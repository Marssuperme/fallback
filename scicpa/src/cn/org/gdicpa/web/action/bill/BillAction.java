package cn.org.gdicpa.web.action.bill;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.bill.model.ApplyBill;

public class BillAction extends MultiActionController {
	
	private static final String LIST = "/bill/listBill.jsp";
	private static final String BILL = "/bill/bill.jsp";

	/**
	 * 发票列表
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView listBill(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView model = new ModelAndView(LIST);
		Connection conn = null;
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String) map.get("loginid");
		try {
			conn = new DBConnect().getConnect();
			String sql = "select guid,year,title,money,applyDate,receiver,mobile,postcode,auditdate,address, "
				+ " case when state='0' then '暂存' when state='1' then '会员已提交' when state='2' then '注协已受理' else '发票已寄出' end as state "
				+ " from k_applybill a where loginid='" + loginid + "' ";
			DataGridProperty pp = new DataGridProperty();
			pp.setTitle("会费发票申请信息");
			pp.setInputType("radio");
			pp.setTableID("applyBill");
			pp.setWhichFieldIsValue(1);
			
			String property = " align=center onclick=\"goDetail('${guid}');\"  nowrap=\"nowrap\"";
			pp.addColumn("年度", "year").setTdProperty(property);
			pp.addColumn("发票抬头", "title").setTdProperty(property);
			pp.addColumn("发票金额", "money").setTdProperty(property);
			pp.addColumn("申请日期", "applyDate").setTdProperty(property);
			pp.addColumn("收件人", "receiver").setTdProperty(property);
			pp.addColumn("手机号码", "mobile").setTdProperty(property);
			pp.addColumn("邮政编码", "postcode").setTdProperty(property);
			pp.addColumn("状态", "state").setTdProperty(property);
			pp.addColumn("审核时间", "auditdate").setTdProperty(property);
			pp.addColumn("收件人地址", "address").setTdProperty(property);

			pp.setSQL(sql);
			pp.setOrderBy_CH("year");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}

		return model;
	}

	/**
	 * 新增、查看
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView addAndView(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView model = new ModelAndView(BILL);

		String operation = StringUtil.showNull(request.getParameter("operation"));
		String guid = StringUtil.showNull(request.getParameter("guid"));

		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String) map.get("loginid");
		String loginname = (String) map.get("loginname");
		
		Connection conn = null;
		String type = "";
		try {
			conn = new DBConnect().getConnect();
			ApplyBill apply = new ApplyBill();
			DbUtil db = new DbUtil(conn);
			
			String sql = null;
			
			if ("add".equals(operation)) {
				
				sql = "select workunits,mobile,address,area,postcode from k_micfono where loginid = ?";
				Map mInfo = db.getOneObject2Map(sql, new Object[] { loginid });
				apply.setGuid(UUID.randomUUID().toString());
				apply.setYear(new SimpleDateFormat("yyyy").format(new Date()));
				apply.setWorkUnit((String) mInfo.get("workunits"));
				apply.setMobile((String) mInfo.get("mobile"));
				apply.setAddress((String) mInfo.get("address"));
				apply.setPostcode((String) mInfo.get("postcode"));
				apply.setLoginId(loginid);
				apply.setLoginName(loginname);
				apply.setReceiver(loginname);
				apply.setArea((String) mInfo.get("area"));
				apply.setState("0");
				type = "add";
				
			} else if ("update".equals(operation)) {
				
				sql = "select * from k_applybill where guid = ?";
				apply = (ApplyBill) db.getOneObject2Bean(sql, new ApplyBill().getClass(), new Object[] { guid });
				type = "update";
				
			} else {
				
				sql = "select * from k_applybill where guid = ?";
				apply = (ApplyBill) db.getOneObject2Bean(sql, new ApplyBill().getClass(), new Object[] { guid });
				type = "view";
			}
			model.addObject("type", type);
			model.addObject("usertype", "k_micfono");
			model.addObject("apply", apply);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		return model;
	}

	/**
	 * 暂存/提交审核
	 * @param request
	 * @param response
	 * @param apply
	 */
	public void saveInfo(HttpServletRequest request, HttpServletResponse response, ApplyBill apply) {

		Connection conn = null;
		PrintWriter out = null;
		try {
			conn = new DBConnect().getConnect();
			out = response.getWriter();
			
			DbUtil db = new DbUtil(conn);
			
			String guid = apply.getGuid();
			String state = "";
			
			if(guid != ""){
				
				state = db.queryForString("select state from k_applybill where guid=?", new Object[]{guid});
				
			}else{
				
				apply.setGuid(UUID.randomUUID().toString());
			}
			
			apply.setApplyDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			
			// 清空退回申请的审核信息
			apply.setAuditId("");
			apply.setAuditIdea("");	
			apply.setAuditRemark("");
			apply.setAuditDate("");
			
			if ("0".equals(state) || "9".equals(state)) { 	
				
				db.update("k_applybill", "guid", apply);
				
			} else {	// 新增
				
				db.add("k_applybill", null, apply);
			}
			
			out.write("<script>window.parent.saveResult('1');</script>");
		} catch (Exception e) {
			out.write("<script>window.parent.saveResult('0');</script>");
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
	}

	/**
	 * 判断是否已经申请 提交审核
	 * @param request
	 * @param response
	 */
	public void beforeAddApplyTable(HttpServletRequest request, HttpServletResponse response) {

		String loginid = StringUtil.showNull(request.getParameter("loginid"));
		String year = StringUtil.showNull(request.getParameter("year"));
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			String sql = "select count(guid) from k_applybill where state>0  and  loginid=? and year=? ";
			int rs = new DbUtil(conn).queryForInt(sql, new Object[]{loginid, year});
			response.getWriter().print(rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
	}

	/**
	 * 是否可以申请发票
	 * @param request
	 * @param response
	 */
	public void checkIfCanApply(HttpServletRequest request, HttpServletResponse response) {
		
		Connection conn = null;
		PrintWriter out = null;
		try {
			conn = new DBConnect().getConnect();
			DbUtil db = new DbUtil(conn);
			response.setCharacterEncoding("utf-8");
			out = response.getWriter();
			
			UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
			if (userSession == null) {
				response.sendRedirect("login.do");
			}
			
			String sql = "select year from k_YEARCHECKMANAGENO "
					+ " where substring(convert(varchar,getdate(), 120), 1, 10) >= billstartdate "
					+ " and   substring(convert(varchar,getdate(), 120), 1, 10) <= billenddate   ";
			
			String year = db.queryForString(sql);

			String msg = "";
			
			if(year != null){
				
				year = new SimpleDateFormat("yyyy").format(new Date());
				
				String loginid = (String) userSession.getUserMap().get("loginid");
				
				Object[] objs = {loginid, year};
					
				sql = "select 1 from k_yeepay where r1_code = 1 and loginid = ? and isyear = ?  ";
					
				String rs = db.queryForString(sql, objs);
				
				if(rs != null){
					
					sql = "select 1 from k_applybill where loginid = ? and year = ? ";
					
					Map<String, Object> result = db.getOneObject2Map(sql, objs);
					
					msg = result == null ? "Ok" : "Exists";		// Ok - 可以申请, Exists - 记录已存在
					
				}else{
					msg = "UnPay";		// 未缴费
				}
					
			}else{
				msg = "TimeOut";		// 不在发票申请时间
			}
			out.print(msg);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
			out.close();
		}
	}
	
	/**
	 * 是否可以修改、删除申请
	 * @param request
	 * @param response
	 */
	public void checkIfCanEdit(HttpServletRequest request, HttpServletResponse response) {
		
		Connection conn = null;
		PrintWriter out = null;
		try {
			conn = new DBConnect().getConnect();
			DbUtil db = new DbUtil(conn);
			response.setCharacterEncoding("utf-8");
			out = response.getWriter();
			
			UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
			if (userSession == null) {
				response.sendRedirect("login.do");
			}
			
			String sql = "select year from k_YEARCHECKMANAGENO "
					+ " where substring(convert(varchar,getdate(), 120), 1, 10) >= billstartdate "
					+ " and   substring(convert(varchar,getdate(), 120), 1, 10) <= billenddate   ";
			
			String year = db.queryForString(sql);
			
			String msg = "";
			
			if(year != null){
				
				year = new SimpleDateFormat("yyyy").format(new Date());
				
				String loginid = (String) userSession.getUserMap().get("loginid");
				
				sql = "select state from k_applybill where loginid = ? and year = ? ";
				
				String state = db.queryForString(sql, new Object[]{loginid, year});
				
				msg = Integer.parseInt(state) > 0 ? "No" : "Yes";
				
				if("9".equals(state)){
					msg = "Yes";
				}
				
			}else{
				msg = "TimeOut";		// 不在发票操作时间
			}
			out.print(msg);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
			out.close();
		}
	}

	/**
	 * 删除
	 * @param request
	 * @param response
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		
		Connection conn = null;
		PrintWriter out = null;
		PreparedStatement ps = null;
		int i = 0;
		try {
			conn = new DBConnect().getConnect();
			response.setCharacterEncoding("utf-8");
			UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
			if (userSession == null) {
				response.sendRedirect("login.do");
			}
			String guid = request.getParameter("guid");
			String sql = "delete k_applybill where guid='" + guid + "'";
			ps = conn.prepareStatement(sql);
			i = ps.executeUpdate();
			out = response.getWriter();
			out.print(i);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
	}
}
