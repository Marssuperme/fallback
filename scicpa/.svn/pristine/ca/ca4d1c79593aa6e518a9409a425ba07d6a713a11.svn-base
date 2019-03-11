package cn.org.gdicpa.web.action.annualInspection;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.swetake.util.Qrcode;

import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.DateUtil;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.annualInspection.InspectionService;

public class InspectionAction extends MultiActionController {
	
	private static final String LISTMEMBER = "/yearCheckno/listMember.jsp";
	private static final String LISTYEEPAY = "/yearCheckno/listYeepay.jsp";
	private static final String MEMBER = "/yearCheckno/member.jsp";
	private static final String PRINTRESULT = "/yearCheckno/printResult.jsp";
	private static final String LISTYXS = "/yearCheckno/listXS.jsp";
	private static final String QRCODEVIEW = "/yearCheckno/QrcodeView.jsp";

	/**
	 * 会费缴纳列表
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView listYeepay(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView model = new ModelAndView(LISTYEEPAY);
		String sql = null;
		try {
			UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
			if (userSession == null) {
				response.sendRedirect("login.do");
				return null;
			}
			String loginid = (String) userSession.getUserMap().get("loginid");
			String currYear = DateUtil.getDate("yyyy");
			
			model.addObject("currYear", currYear);
			
			DataGridProperty pp = new DataGridProperty();
			
			sql = "select loginid,isyear,p3_amt, case when r1_code='1'  then '是' else '否' end as state from k_yeepay "
					+ " where loginid='" + loginid + "'";

			String property = " align=center  nowrap=\"nowrap\" ";
			
			pp.setTitle("会费缴纳情况");
			pp.setTableID("listMemberno");
			pp.setTableHead("年度,用户ID，缴费金额，是否完成缴费");

			pp.setWhichFieldIsValue(1);
			pp.addColumn("年度", "isyear").setTdProperty(property);
			pp.addColumn("用户ID", "loginid").setTdProperty(property);
			pp.addColumn("缴费金额", "p3_amt").setTdProperty(property);
			pp.addColumn("是否完成缴费", "state").setTdProperty(property);

			pp.setPageAlign("left");
			pp.setPageSize_CH(10);
			pp.setSQL(sql);
			pp.setOrderBy_CH("isyear");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	/**
	 * 年检申请列表
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView listMember(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView model = new ModelAndView(LISTMEMBER);
		String sql = null;
		try {
			UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
			if (userSession == null) {
				response.sendRedirect("login.do");
				return null;
			}
			Map userMap = userSession.getUserMap();
			String loginid = (String) userMap.get("loginid");
			String loginname = (String) userMap.get("loginname");

			DataGridProperty pp = new DataGridProperty();
			
			sql = "select uuid,year,loginid,loginname,state,stateno,workunits,selfidea,auditidea,area,result "
					+ " from k_yckcpano "
					+ " where loginid='" + loginid + "' "
					+ " and loginname='" + loginname + "'";
			
			String property = " align=center onclick=\"goDetail('${uuid}');\"  nowrap=\"nowrap\" ";

			pp.setInputType("radio");
			pp.setTitle("非执业年检汇总");
			pp.setTableID("listMemberno");
			pp.setTableHead("年度,ID,姓名,状态,地区,工作单位,本人意见,省注协意见,年检结论");

			pp.setWhichFieldIsValue(1);
			pp.addColumn("年度", "year").setTdProperty(property);
			pp.addColumn("ID", "loginid").setTdProperty(property);
			pp.addColumn("姓名", "loginname").setTdProperty(property);
			pp.addColumn("状态", "state").setTdProperty(property);
			pp.addColumn("地区", "area").setTdProperty(property);
			pp.addColumn("工作单位", "workunits").setTdProperty(property);
			pp.addColumn("本人意见", "selfidea").setTdProperty(property);
			pp.addColumn("注协意见", "auditidea").setTdProperty(property);
			pp.addColumn("年检结论", "result").setTdProperty(property);

			pp.setPageAlign("left");
			pp.setPageSize_CH(10);
			pp.setSQL(sql);
			pp.setOrderBy_CH("year,uuid");
			pp.setDirection("desc,desc");
			
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			request.getSession().setAttribute("excelSql", sql);
			
			model.addObject("usertype", "uncpa");
			model.addObject("isok", "1");
			model.addObject("add", "add");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return model;
	}

	/**
	 * 个人继续教育学时列表
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView listXS(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView model = new ModelAndView(LISTYXS);
		String sql = null;
		try {
			UserSession userSession = (UserSession) request.getSession()
			.getAttribute("userSession");
			if (userSession == null) {
				response.sendRedirect("login.do");
				return null;
			}
			String loginid = (String) userSession.getUserMap().get("loginid");
			
			DataGridProperty pp = new DataGridProperty();
			sql = "select no,appname,ending,periodresult,kscj,curryear from xs_content where no='"+loginid+"'";
			
			String property = " align=center  nowrap=\"nowrap\" ";
			pp.setTitle("继续教育情况");
			pp.setTableID("listMemberno");
			pp.setTableHead("年度,用户ID,学时数,是否通过,考试成绩");
			
			pp.setWhichFieldIsValue(1);
			pp.addColumn("年度", "curryear").setTdProperty(property);
			pp.addColumn("用户ID", "no").setTdProperty(property);
			pp.addColumn("学时数", "periodresult").setTdProperty(property);
			pp.addColumn("是否通过", "ending").setTdProperty(property);
			pp.addColumn("考试成绩", "kscj").setTdProperty(property);
			
			pp.setPageAlign("left");
			pp.setPageSize_CH(10);
			pp.setSQL(sql);
			pp.setOrderBy_CH("curryear");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return model;
	}
	
	/**
	 * 新增申请年检前检查
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView beforeAddApplyTable(HttpServletRequest request, HttpServletResponse response) {

		Connection conn = null;
		PrintWriter out = null;

		try {
			
			conn = new DBConnect().getConnect();
			response.setContentType("text/html;charset=utf-8");
			out = response.getWriter();
			
			UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
			if (userSession == null) {
				response.sendRedirect("login.do");
				return null;
			}
			
			Map userMap = userSession.getUserMap();
			String loginid = (String) userMap.get("loginid");
			String currYear = DateUtil.getDate("yyyy");

			InspectionService ins = new InspectionService(conn);
			
			// 年检启用年度
			Map<String, String> yckmanageMap = ins.isInspectionYear(currYear);
			
			if (yckmanageMap != null) {
				request.getSession().setAttribute("yck_year", currYear);
			} else {
				out.print("省注协还未开启年检，请联系省注协！");
				return null;
			}
			
			// 年检填报时间
			String fillStr = ins.canFill(yckmanageMap, currYear);
			
			if (fillStr != null && fillStr != "") {
				out.print(fillStr);
				return null;
			}
			
			// 继续教育情况
			String educationPass = ins.isEducationPass(loginid, currYear);
			
			if(!"通过".equals(educationPass)){
				out.print("请先完成"+(Integer.parseInt(currYear) - 1)+"年继续教育");
				return null;
			}
			
			// 本年度年检报告是否存在
			if (ins.isExistYearcheckReport(loginid, currYear)) {
				out.println(currYear + "年的年检报告已经存在!");
				out.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		return null;
	}

	/**
	 * 新增
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView addAndView(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView model = new ModelAndView(MEMBER);
		Connection conn = null;
		String sql = "";
		
		try {
			
			conn = new DBConnect().getConnect();
			InspectionService ins = new InspectionService(conn);
			
			UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
			if (userSession == null) {
				response.sendRedirect("login.do");
				return null;
			}
			
			String loginid = (String) userSession.getUserMap().get("loginid");
			String theyear = (String) request.getSession().getAttribute("yck_year");
			String uuid = (String) request.getParameter("uuid");
			
			String operation = (String) request.getParameter("operation");
			
			if (theyear == null || "".equals(theyear)) {
				theyear = DateUtil.getDate("yyyy");
			}

			Map<String, String> maps = new HashMap<String, String>();
			Map<String, String> map = new HashMap<String, String>();
			
			String editType = "edit";
			
			if ("add".equals(operation)) {
				
				// 惩戒
				/*String year1 = Integer.parseInt(theyear) - 1 + "-06-01";
				String year2 = theyear + "-05-31";
				
				sql = "select m.*, s.punishtype, s.state as punishstate from k_micfono m "
						+ " left join k_suppunish s on s.loginid = m.loginid "
						+ " and " + year1 + " < s.punishdate and " + year2 + " > s.punishdate "
						+ " where m.loginid='" + loginid + "'";*/
				
				sql = "select m.* from k_micfono m where m.loginid = '" + loginid + "'";
				
				map = ins.getMap(sql);
				maps.putAll(map);
				map.clear();
				
				// 缴费信息
				int paidFee = ins.isPaidFee(loginid, theyear);
				
				if (paidFee > 0) {
					maps.put("payfee", "已缴纳");
				}else{
					maps.put("payfee", "未缴纳");
				}
				
				// 继续教育信息
				map = ins.getXSContent(loginid, theyear);
				
				maps.put("educate", map.get("ending"));
				maps.put("sxcontent", map.get("periodresult"));
				map.clear();
				
				maps.put("year", theyear);
				
			} else if ("view".equals(operation)) {
				
				sql = "select y.* from K_YCKCPANO y where y.uuid = '" + uuid + "'";
				map = ins.getMap(sql);
				maps.putAll(map);
				
				// 退回则可更改
				String stateno = map.get("stateno").toString();
				
				editType = "9".equals(stateno) ? "edit" : "noedit";
			}
			
			System.out.println(sql);
			
			model.addObject("edit", editType);
			model.addObject("usertype", "uncpa");
			model.addObject("member", maps);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		return model;
	}

	/**
	 * 删除申请
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) {
		
		Connection conn = null;
		PrintWriter out = null;
		String sql = null;
		
		try {
			response.setContentType("text/html;charset=utf-8");
			out = response.getWriter();
			
			conn = new DBConnect().getConnect();
			DbUtil db = new DbUtil(conn);
			
			String type = request.getParameter("type");
			String uuid = request.getParameter("uuid");
			String tablename = "k_" + type;
			
			UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
			Map map = userSession.getUserMap();
			String loginid = (String) map.get("loginid");
			String ctype = (String) map.get("ctype");
			
			boolean flag = true;
			
			sql = "select stateno, fillformperson from " + tablename + " where uuid='" + uuid + "'";
			
			Map<String, String> yckMap = db.getMap(sql);
			
			if ("非执业会员".equals(ctype) || "执业会员".equals(ctype)) {
				if (!"0".equals(yckMap.get("stateno"))) {
					flag = false;
					out.print("该记录已经提交，不能删除！");
				} else if (!loginid.equals(yckMap.get("fillformperson"))) {
					flag = false;
					out.print("该记录不是本人提交的，没有权限删除！");
				}
			}
			
			if (flag) {
				
				sql = "delete " + tablename + " where uuid='" + uuid + "'";
				if (db.executeUpdate(sql) > 0){
					out.print("1");
				}else{
					out.print("0");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		return null;
	}

	/**
	 * 提交审核
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView saveApplyTable(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int res = 0;

		PrintWriter out = null;
		try {

			response.setContentType("text/html;charset=utf-8");
			out = response.getWriter();
			conn = new DBConnect().getConnect();
			conn.setAutoCommit(false);
			
			UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
			if (userSession == null) {
				response.sendRedirect("login.do");
				return null;
			}

			String uuid = (String) request.getParameter("uuid");
			
			Map<String, String> emMap = new HashMap<String, String>();
			Enumeration<?> enum1 = request.getParameterNames();
			while (enum1.hasMoreElements()) {
				String paramName = (String) enum1.nextElement();
				String paramValue = request.getParameter(paramName);
				emMap.put(paramName, paramValue);
			}
			
			if (uuid == "") {
				uuid = UUID.randomUUID().toString();
			}
			
			String audtireason = "";
			String payfee = emMap.get("payfee").toString();
			if("未缴纳".equals(payfee)){
				audtireason = "未缴纳会费";
			}
			emMap.put("audtireason", audtireason);
			emMap.put("uuid", uuid);
			emMap.put("step_current", "1");
			emMap.put("state", "待审批");
			emMap.put("stateno", "1");
			emMap.put("type", "审核");
			emMap.put("filltime", DateUtil.getDate("yyyy-MM-dd HH:mm:ss"));
			
			InspectionService ins = new InspectionService(conn);
			
			// 1.主表
			res = ins.saveInfo("uuid", emMap);

			if (res > 0) {
				
				// 2.流程表
				boolean stepFlag = ins.saveToStep(uuid);
				if(!stepFlag){
					conn.rollback();
					out.println("<script>alert('操作失败!');</script>");
				}
				
				// 3.反补会基本信息
				boolean micfonoFlag = ins.updatemicfono(emMap);
				if(!micfonoFlag){
					conn.rollback();
					out.println("<script>alert('操作失败!');</script>");
				}
				
				conn.commit();
				response.sendRedirect("annualInspection.do?method=listMember");
			} else {
				conn.rollback();
				out.println("<script>alert('操作失败!');</script>");
			}
			
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			DbUtil.close(ps);
			DbUtil.close(rs);
			DbUtil.close(conn);
		}
		return null;
	}

	/**
	 * 打印年检结果
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView printResult(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView(PRINTRESULT);
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			response.setContentType("text/html;charset=utf-8");
			
			String uuid = request.getParameter("uuid");
			String sql = "select uuid,loginid,loginname,result,year from k_yckcpano where uuid= '" + uuid + "'";
			Map map = new DbUtil(conn).getMap(sql);
			
			System.out.println("年检结果===》" + map.get("result"));
			if (map.get("result") != null && map.get("result").equals("通过")) {
				request.getSession().setAttribute("status", "1");
				model.addObject("map", map);
			} else {
				request.getSession().setAttribute("status", "0");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		return model;
	}
	 
	/**
	 * 检查是否在缴费的时间段
	 * @param request
	 * @param response
	 * @return
	 */
	public void checkIsPayDate(HttpServletRequest request, HttpServletResponse response) {
		
		Connection conn = null;
		PrintWriter out = null;
		
		String type = StringUtil.showNull(request.getParameter("ccc")); // 缴费判断
		
		try {
			conn = new DBConnect().getConnect();
			response.setCharacterEncoding("utf-8");
			out = response.getWriter();
			
			UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
			if (userSession == null) {
				response.sendRedirect("login.do");
			}
			String loginid = (String)userSession.getUserMap().get("loginid");
			String applyYear = StringUtil.showNull(request.getParameter("year"));
			
			DbUtil db = new DbUtil(conn);
			InspectionService ins = new InspectionService(conn);
			
			String nowDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			
			// 1.是否在缴费时间内
			String sql = "select year from k_YEARCHECKMANAGENO where yeepaystartdate <= ? and yeepayenddate >= ?";
			String year = db.queryForString(sql, new Object[]{nowDate, nowDate});
			
			String msg = "timeOut";
			
			if (year != "null" || year != null) {
				
				if(type != ""){
					
					// 2.是否完成上一年继续教育 
					String ending = ins.isEducationPass(loginid, applyYear);
					
					if(!"通过".equals(ending)){
						out.print("unFinished");
						return;
					}
					
					// 3.本年度是否已缴纳
					int count = ins.isPaidFee(loginid, applyYear);
					
					msg = count < 1 ? "unPay" : "paid";
				}
			}
			out.print(msg);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
	}

	/**
	 * 检查是否已经缴费成功
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public void checkIsPaid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection conn = null;
		PrintWriter out = null;
		
		try {
			conn = new DBConnect().getConnect();
			response.setCharacterEncoding("utf-8");
			out = response.getWriter();
			
			UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
			if (userSession == null) {
				response.sendRedirect("login.do");
			}
			String loginid = (String) userSession.getUserMap().get("loginid");
			String year  = StringUtil.showNull(request.getParameter("year"));
			
			int count = new InspectionService(conn).isPaidFee(loginid, year);
			
			if (count < 1) {
				out.print("N");
			} else {
				out.print("Y");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
	}

	/**
	 * 生成 年检结果二维码
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView getQrcode(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		OutputStream out = null;
		try {
			out = response.getOutputStream();

			StringBuffer buf = new StringBuffer();
			String id = request.getParameter("id");
			
			//生成返回二维码内容的链接
			buf.append(request.getRequestURL()).append("?method=executeQrcode&guid=").append(id);
			
			String content = buf.toString();
			Qrcode handler = new Qrcode();
			handler.setQrcodeErrorCorrect('M');
			handler.setQrcodeEncodeMode('B');
			handler.setQrcodeVersion(13);

			System.out.println(content);
			byte[] contentBytes = content.getBytes("GB2312");

			BufferedImage bufImg = new BufferedImage(150, 150, BufferedImage.TYPE_INT_RGB);
			Graphics2D gs = bufImg.createGraphics();

			gs.setBackground(Color.WHITE);
			gs.clearRect(0, 0, 150, 150);

			// 设定图像颜色：BLACK
			gs.setColor(Color.BLACK);

			// 设置偏移量 不设置肯能导致解析出错
			int pixoff = 2;
			// 输出内容：二维码
			if (contentBytes.length > 0 && contentBytes.length < 335) {
				boolean[][] codeOut = handler.calQrcode(contentBytes);
				for (int i = 0; i < codeOut.length; i++) {
					for (int j = 0; j < codeOut.length; j++) {
						if (codeOut[j][i]) {
							gs.fillRect(j * 2 + pixoff, i * 2 + pixoff, 2, 2);
						}
					}
				}
			} else {
				System.err.println("QRCode content bytes length = " + contentBytes.length + " not in [ 0,334 ]. ");
			}
			// 生成二维码QRCode图片
			ImageIO.write(bufImg, "jpg", out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {out.close();} catch (IOException e) {}
		}
		return null;
	}

	/**
	 * 扫描二维码
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView executeQrcode(HttpServletRequest request,HttpServletResponse response){
		
		ModelAndView model = new ModelAndView(QRCODEVIEW);
		Connection conn = null;
		try {
		
			conn = new DBConnect().getConnect();
			
			String uuid = request.getParameter("guid");

			String sql = "select y.* from K_YCKCPANO y where y.uuid = '" + uuid + "' ";
			
			Map maps = new DbUtil(conn).getMap(sql);
			
			model.addObject("member", maps);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		return model;
	}
	
	/**
	 * 学时是否足够
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView checkBeforApply(HttpServletRequest request, HttpServletResponse response) {
		
		Connection conn = null;
		PrintWriter out = null;
		try {
			conn = new DBConnect().getConnect();
			response.setCharacterEncoding("utf-8");
			out = response.getWriter();
			
			UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
			if (userSession == null) {
				response.sendRedirect("login.do");
				return null;
			}
			Map userMap = userSession.getUserMap();
			String loginid   = (String) userMap.get("loginid");
			String currYear  = request.getParameter("year");
			
			InspectionService ins = new InspectionService(conn);
			
			// 年检启用年度
			Map<String, String> yckmanageMap = ins.isInspectionYear(currYear);
			
			if (yckmanageMap == null) {
				out.print("省注协还未开启年检，请联系省注协！");
				return null;
			}
			
			// 年检填报时间
			String fillStr = ins.canFill(yckmanageMap, currYear);
			
			if (fillStr != null && fillStr != "") {
				out.print(fillStr);
				return null;
			}
			
			// 继续教育情况
			String educationPass = ins.isEducationPass(loginid, currYear);
			
			if(!"通过".equals(educationPass)){
				out.print("请先完成"+(Integer.parseInt(currYear) - 1)+"年继续教育");
				return null;
			}
			
			// 本年度年检报告是否存在
			if (ins.isExistYearcheckReport(loginid, currYear)) {
				out.println(currYear + "年的年检报告已经存在!");
				return null;
			}
			out.print("Y");
		} catch (Exception e) {
			out.print("系统错误");
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
			out.close();
		}

		return null;
	}
	
}
