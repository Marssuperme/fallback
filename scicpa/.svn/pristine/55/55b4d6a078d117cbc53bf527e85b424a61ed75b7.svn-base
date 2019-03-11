package cn.org.gdicpa.web.action.costpay;

import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
import cn.org.gdicpa.web.service.costpay.CostPayService;
import cn.org.gdicpa.web.service.costpay.model.Pay;
import cn.org.gdicpa.web.service.costpay.model.PayDetail;
import cn.org.gdicpa.web.service.user.UserService;

public class CostPayAction extends MultiActionController {
	private final static String LIST_VIEW = "/costpay/list.jsp";
	private final static String ADD_VIEW = "/costpay/add.jsp";
	private final static String VIEW_VIEW = "/costpay/view.jsp";
	
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession") ;
		String loginid = StringUtil.showNull((String)userSession.getUserMap().get("loginid"));
		ModelAndView modelAndView = new ModelAndView(LIST_VIEW) ;
		try { 
			conn = new DBConnect().getConnect();
			String sql = " select UUID,iuser,idate,iyear,departname,totalIncome,groupCost,memberCost,cpaCount,total,"  
					   + " case when property = '已缴费' then '已缴费'  else '未缴费' end as property  " 
					   + " from k_costpay where departname = (select loginname from k_company where loginid = '"+loginid+"')" ;
			
			DataGridProperty pp = new DataGridProperty();
			pp.setTableID("costPayList");
			pp.setWhichFieldIsValue(1); 
			pp.addColumn("事务所名称", "departname","showCenter").setTdProperty(" onclick=\"goView('${UUID}');\" ");
			pp.addColumn("会费年度", "iyear","showCenter").setTdProperty(" onclick=\"goView('${UUID}');\"");
			pp.addColumn("总收入", "totalIncome","showMoney");
			pp.addColumn("应缴团体会费", "groupCost","showMoney");  
			pp.addColumn("CPA人数", "cpaCount","showCenter");
			pp.addColumn("应缴个人会费", "memberCost","showMoney");
			pp.addColumn("是否确认缴费", "property","showCenter");
			pp.addColumn("总计", "total","showMoney");
			pp.addColumn("操作", "property","showCenter","cn.org.gdicpa.web.action.costpay.CostPayFieldProcess","");
//						.setColContent("<a href='###' onclick=\"goUpdate('${UUID}','${property}');\">修改</a>" 
//						+"&nbsp;&nbsp;&nbsp;<a  href='###' onclick=\"goDel('${UUID}','${property}');\">删除</a>");
			
			//pp.setColumnWidth("30%,20%,10%,10%");
			pp.setSQL(sql);
			pp.setOrderBy_CH("iyear");
			pp.setDirection("desc");
			pp.setTitle("会费缴纳登记表") ;
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn) ;
		}
		return modelAndView;
	}
	
	
	public ModelAndView goAdd(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		List payDetailList = null ;
		ModelAndView modelAndView = null;
		try { 
			conn = new DBConnect().getConnect();
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession") ;
			String loginid = StringUtil.showNull((String)userSession.getUserMap().get("loginid"));
			String UUID = StringUtil.showNull(request.getParameter("UUID"));
			String iyear = new SimpleDateFormat("yyyy").format(new Date());
			CostPayService cps = new CostPayService(conn);
			
			UserService us = new UserService(conn) ;
			Map map = us.getUser("k_company", loginid) ;
			String officeCode = (String)map.get("officecode");
			String departname = (String)map.get("loginname");
			String p = StringUtil.showNull(request.getParameter("p"));
			
			if("view".equals(p)){
				modelAndView = new ModelAndView(VIEW_VIEW) ;
			}else{
				modelAndView = new ModelAndView(ADD_VIEW) ;
			}
			
			if("".equals(UUID)) {
				//新增
				payDetailList = cps.getUserBydepartCode(officeCode) ;
				modelAndView.addObject("iyear",iyear) ;
				modelAndView.addObject("departname", departname) ;
			}else {
				Pay pay = cps.getPay(UUID) ;
				payDetailList = cps.getPayDetailByUid(UUID) ;
				modelAndView.addObject("pay",pay) ;
				modelAndView.addObject("iyear",pay.getIyear()) ;
				modelAndView.addObject("departname", pay.getDepartname()) ;
			}
			 
			
			modelAndView.addObject("officeCode", officeCode) ;
			modelAndView.addObject("payDetailList", payDetailList) ;
			modelAndView.addObject("cpaCount", payDetailList.size()) ;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn) ;
		}
		return modelAndView;
	}
	
	public ModelAndView isCostPayExist(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		try { 
			conn = new DBConnect().getConnect();
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			String iyear = StringUtil.showNull(request.getParameter("iyear")) ;
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession") ;
			String loginid = StringUtil.showNull((String)userSession.getUserMap().get("loginid"));
			
			UserService us = new UserService(conn) ;
			Map map = us.getUser("k_company", loginid) ;
			String officeName = (String)map.get("loginname");
			
			CostPayService cps = new CostPayService(conn);
			String property = cps.isPayExist(iyear, officeName) ;
			out.write(property) ;
			out.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn) ;
		}
		return null;
	}
	
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		try { 
			conn = new DBConnect().getConnect();
			CostPayService cps = new CostPayService(conn);
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession") ;
			
			//保存缴费记录
			String departname = StringUtil.showNull(request.getParameter("departname")) ;
			String totalIncome = StringUtil.showNull(request.getParameter("totalIncome")) ;
			if("".equals(totalIncome) || null == totalIncome){
				totalIncome = "0";
			}
			String groupCost = StringUtil.showNull(request.getParameter("groupCost")) ;
			String memberCost = StringUtil.showNull(request.getParameter("memberCost")) ;
			String cpaCount = StringUtil.showNull(request.getParameter("cpaCount"));
			String total = StringUtil.showNull(request.getParameter("total")) ;
			String pmemo = StringUtil.showNull(request.getParameter("pmemo"));
			String iyear = StringUtil.showNull(request.getParameter("iyear"));
			
			String payUUID = StringUtil.showNull(request.getParameter("UUID"));
			if(!"".equals(payUUID)) {
				cps.delPay(payUUID);
				cps.delPayDetail(payUUID);
			}
			
			//先删除原来缴费记录
			cps.delPayDetail(iyear, departname);    // 先删除 详细表
			cps.delPay(iyear, departname);        // 再删除主表 
			
			Pay pay = new Pay() ;
			String UUIDStr = UUID.randomUUID().toString();
			pay.setUUID(UUIDStr);
			pay.setDepartname(departname);
			pay.setTotalIncome(totalIncome);
			pay.setGroupCost(groupCost) ;
			pay.setMemberCost(memberCost) ;
			pay.setCpaCount(cpaCount) ;
			pay.setTotal(total);
			pay.setMemo(pmemo) ;
			pay.setIdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			pay.setIuser((String)userSession.getUserMap().get("loginid")) ;
			pay.setIyear(iyear);
			pay.setProperty("未缴费") ;
			cps.addPay(pay);
			//保存缴费明细
			String[] cpaId = request.getParameterValues("cpaId");
			String[] userName = request.getParameterValues("userName");
			String[] sex = request.getParameterValues("sex");
			String[] dutylevel = request.getParameterValues("dutylevel");
			String[] memo = request.getParameterValues("memo");
			
			for(int i=0;i<cpaId.length;i++) {
				PayDetail pd = new PayDetail();
				pd.setCpaid(cpaId[i]);
				pd.setUID(UUIDStr);
				pd.setUsername(userName[i]);
				pd.setSex(sex[i]);
				pd.setDutylevel(dutylevel[i]);
				pd.setMemo(memo[i]);
				cps.addPayDetail(pd) ;
			}
			response.sendRedirect(request.getContextPath()+"/company/costpay.do") ;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn) ;
		}
		return null;
	}
	
	public ModelAndView del(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		Connection conn = null; 
		try { 
			conn = new DBConnect().getConnect();
			CostPayService cps = new CostPayService(conn);
			
			String UUID = StringUtil.showNull(request.getParameter("UUID"));
			
			//先删除原来缴费记录
			cps.delPay(UUID);
			cps.delPayDetail(UUID);
			
			response.sendRedirect(request.getContextPath()+"/company/costpay.do") ;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conn) ;
		}
		return null;
	}

}
