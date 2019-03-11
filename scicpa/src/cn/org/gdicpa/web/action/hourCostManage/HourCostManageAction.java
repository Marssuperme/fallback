package cn.org.gdicpa.web.action.hourCostManage;

import java.io.IOException;
import java.sql.Connection;
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
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.DateUtil;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.hourCostMain.HourCostMainService;
import cn.org.gdicpa.web.service.hourCostMain.model.HourCostMainTable;
import cn.org.gdicpa.web.service.hourCostManage.HourCostManageService;
import cn.org.gdicpa.web.service.hourCostManage.model.CityTransportTable;
import cn.org.gdicpa.web.service.hourCostManage.model.HourCostManageTable;

public class HourCostManageAction extends MultiActionController{
	private static String LIST = "/hourCostManage/list.jsp";
	private static final String ADDANDEDIT = "/hourCostManage/addAndEdit1.jsp";
	private static final String ADDANDEDITS = "/hourCostManage/addAndEdit.jsp";
	
	 
	/**
	 * 默认方法
	 * @param request  
	 * @param response
	 * @return
	 */
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  >>>>>>>>>>>>      index(HttpServletRequest request,HttpServletResponse response) ...............");
		ModelAndView model = new ModelAndView(LIST);
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode"); 
		
		try {
			String sql = " select id,fillMan,checkProject,checkoffice,fillTime,totalDays,totalCheckPay,"  
					   + " totalfoodPay,totalbusinessTrips,totalCountMoney,propertys "
					   + " from k_hourcostmain where fillMan='"+loginname+"' and checkoffice='"+officecode+"' ";
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.setTitle("监管工时费用报备信息");
			 
			pp.setInputType("radio");
			pp.setTableID("hourCostMain");
			pp.setWhichFieldIsValue(1);
			
			pp.addColumn("被检查事务所名称", "checkoffice","showCenter").setTdProperty(" onclick=\"goView('${id}');\" ");

			pp.addColumn("填报人", "fillMan","showCenter");
			pp.addColumn("填报项目", "checkProject","showCenter");
			pp.addColumn("填报日期", "fillTime","showCenter");
			pp.addColumn("检查津贴总额", "totalCheckPay","showCenter");
			pp.addColumn("小计总额", "totalCountMoney","showCenter");
			
			
			
			pp.setSQL(sql);
			pp.setOrderBy_CH("fillTime");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
		return model;
	}
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView addHourCostManageTable(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		Connection conn = null;
		ASFuntion asf = new ASFuntion();
		String nid = asf.showNull((String)request.getSession().getAttribute("testnoticeid"));
		String userid = asf.showNull((String)request.getSession().getAttribute("testnoticeuserid"));
		String source = asf.showNull((String)request.getSession().getAttribute("source"));
		
		String id = request.getParameter("id");
		
		String checkOffice = request.getParameter("checkOffice");
		String checkProject = request.getParameter("checkProject");
		String fillMan = request.getParameter("fillMan");
		String fillTime = request.getParameter("fillTime");
		String totalDays = request.getParameter("totalDays");
		String totalCheckPay = request.getParameter("totalCheckPay");  
		String totalfoodPay = request.getParameter("totalfoodPay");  
		String totalbusinessTrips = request.getParameter("totalbusinessTrips");   
		String totalCountMoney = request.getParameter("totalCountMoney"); 
		
		String[] checkManID = request.getParameterValues("checkManID");
		String[] startTime = request.getParameterValues("startTime");
		String[] endTime = request.getParameterValues("endTime");
		String[] countDays = request.getParameterValues("countDays");
		String[] checkPay = request.getParameterValues("checkPay");
		String[] foodPay = request.getParameterValues("foodPay");
		String[] businessTrips = request.getParameterValues("businessTrips");
		String[] countMoney = request.getParameterValues("countMoney");
		
		
		// 城际交通费用明细
		String[] checkManIDs = request.getParameterValues("checkManIDs");
		String[] sdate = request.getParameterValues("sdate");
		String[] startPlace = request.getParameterValues("startPlace");
		String[] endPlace = request.getParameterValues("endPlace");
		String[] moneys = request.getParameterValues("moneys");
		String[] reason = request.getParameterValues("reason");
		String[] remark = request.getParameterValues("remark");
		
		try {
			conn = new DBConnect().getConnect();
			
		
			
			HourCostManageService hmanage = new HourCostManageService(conn);
			HourCostMainService hmain = new HourCostMainService(conn);
			
			// 主表
			HourCostMainTable hmainTable = new HourCostMainTable();
			if(id==null || "".equals(id)){
				id = UUID.randomUUID().toString();
			}
			hmainTable.setId(id);   
			hmainTable.setFillMan(fillMan);
			hmainTable.setCheckProject(checkProject);
			hmainTable.setCheckoffice(checkOffice);
			hmainTable.setFillTime(fillTime); 
			hmainTable.setTotalDays(totalDays);
			hmainTable.setTotalCheckPay(totalCheckPay);
			hmainTable.setTotalfoodPay(totalfoodPay);
			hmainTable.setTotalbusinessTrips(totalbusinessTrips);
			hmainTable.setTotalCountMoney(totalCountMoney);
			
			// 修改的话 就删除
			if(id!=null && !"".equals(id)){
				hmain.deleteHourCostMainTable(id);
			}
			// 添加
			hmain.addHourCostMainTable(hmainTable);
			
			// 删除 HourCostManageTable
			hmanage.delHourCostManageTable(id);
			
			for(int i=0;i<checkManID.length;i++) {
				HourCostManageTable hmanageTable = new HourCostManageTable();
				hmanageTable.setMid(id);
				hmanageTable.setCheckManID(checkManID[i]);
				hmanageTable.setStartTime(startTime[i]);
				hmanageTable.setEndTime(endTime[i]);
				hmanageTable.setCountDays(countDays[i]);
				hmanageTable.setCheckPay(checkPay[i]);
				hmanageTable.setFoodPay(foodPay[i]);
				hmanageTable.setBusinessTrips(businessTrips[i]);
				hmanageTable.setCountMoney(countMoney[i]);
				hmanageTable.setCheckOffice(checkOffice);
				hmanageTable.setCheckProject(checkProject);
				hmanageTable.setFillMan(fillMan);
				hmanageTable.setFillTime(fillTime);
				
				hmanage.addHourCostManageTable(hmanageTable);
			}
			
			
			// 删除
			hmanage.delCityTransportTable(id);
			
			// 保存城际交通费用明细
			for(int i=0;i<checkManIDs.length;i++) {
				CityTransportTable ctt = new CityTransportTable();
				
				ctt.setPid(id);
				ctt.setLoginName(checkManIDs[i]);
				ctt.setSdate(sdate[i]);
				ctt.setStartPlace(startPlace[i]);
				ctt.setEndPlace(endPlace[i]);
				ctt.setMoneys(moneys[i]);
				ctt.setReason(reason[i]);
				ctt.setRemark(remark[i]);
				
				hmanage.addCityTransportTable(ctt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		// 监管作业链接过来的
		if("jgzy".equalsIgnoreCase(source)){
			response.sendRedirect(request.getContextPath()+"/common/supervision.do?method=goSupervision&type=hfjl");
		}else{
			response.sendRedirect(request.getContextPath()+"/common/supervision.do?method=goSupervision&type=hfjl&id="+nid+"&userid="+userid);
		}
		return null;
	}
	
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView addHourCostManageTable_bak(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		Connection conn = null;
		String mid = request.getParameter("mid");
		ASFuntion asf = new ASFuntion();
		String nid = asf.showNull((String)request.getSession().getAttribute("testnoticeid"));
		String userid = asf.showNull((String)request.getSession().getAttribute("testnoticeuserid"));
		System.out.println(this.getClass()+"     mid = "+mid);
		
		if(mid!=null && !"".equals(mid)){
			try {
				conn = new DBConnect().getConnect();
				HourCostMainService hcms2 = new HourCostMainService(conn);
				hcms2.deleteHourCostMainTable(mid);
				HourCostManageService hcms = new HourCostManageService(conn);
				hcms.delHourCostManageTable(mid);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DbUtil.close(conn);
			}
		}
		
		//保存缴费明细
		String checkOffice = request.getParameter("checkOffice");
		String checkProject = request.getParameter("checkProject");
		String fillMan = request.getParameter("fillMan");
		String fillTime = request.getParameter("fillTime");
		String totalDays = request.getParameter("totalDays");
		String totalCheckPay = request.getParameter("totalCheckPay");  
		String totalfoodPay = request.getParameter("totalfoodPay");  
		String totalbusinessTrips = request.getParameter("totalbusinessTrips");   
		String totalCountMoney = request.getParameter("totalCountMoney"); 
		
		String[] checkManID = request.getParameterValues("checkManID");
		String[] startTime = request.getParameterValues("startTime");
		String[] endTime = request.getParameterValues("endTime");
		String[] countDays = request.getParameterValues("countDays");
		String[] checkPay = request.getParameterValues("checkPay");
		String[] foodPay = request.getParameterValues("foodPay");
		String[] businessTrips = request.getParameterValues("businessTrips");
		String[] countMoney = request.getParameterValues("countMoney");
		
	
		try {
			conn = new DBConnect().getConnect();
			
		
			
			HourCostManageService hcms = new HourCostManageService(conn);
			HourCostMainService hcms2 = new HourCostMainService(conn);
			
			// 主表
			HourCostMainTable hcmt2 = new HourCostMainTable();
			String id = UUID.randomUUID().toString();
			hcmt2.setId(id);   
			hcmt2.setFillMan(fillMan);
			hcmt2.setCheckProject(checkProject);
			hcmt2.setCheckoffice(checkOffice);
			hcmt2.setFillTime(fillTime); 
			hcmt2.setTotalDays(totalDays);
			hcmt2.setTotalCheckPay(totalCheckPay);
			hcmt2.setTotalfoodPay(totalfoodPay);
			hcmt2.setTotalbusinessTrips(totalbusinessTrips);
			hcmt2.setTotalCountMoney(totalCountMoney);
			
			hcms2.addHourCostMainTable(hcmt2);
			
			for(int i=0;i<checkManID.length;i++) {
				HourCostManageTable hcmt = new HourCostManageTable();
				hcmt.setMid(id);
				hcmt.setCheckManID(checkManID[i]);
				hcmt.setStartTime(startTime[i]);
				hcmt.setEndTime(endTime[i]);
				hcmt.setCountDays(countDays[i]);
				hcmt.setCheckPay(checkPay[i]);
				hcmt.setFoodPay(foodPay[i]);
				hcmt.setBusinessTrips(businessTrips[i]);
				hcmt.setCountMoney(countMoney[i]);
				hcmt.setCheckOffice(checkOffice);
				hcmt.setCheckProject(checkProject);
				hcmt.setFillMan(fillMan);
				hcmt.setFillTime(fillTime);
				
				hcms.addHourCostManageTable(hcmt);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		response.sendRedirect(request.getContextPath()+"/common/supervision.do?method=goSupervision&type=hfjl&id="+nid+"&userid="+userid);
		return null;
	}
	
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView updateHourCostManageTable(HttpServletRequest request,HttpServletResponse response,HourCostManageTable hcmt) throws IOException{
		ASFuntion asf = new ASFuntion();
		String nid = asf.showNull((String)request.getSession().getAttribute("testnoticeid"));
		String userid = asf.showNull((String)request.getSession().getAttribute("testnoticeuserid"));
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			HourCostManageService hcms = new HourCostManageService(conn);
			hcms.updateHourCostManageTable(hcmt);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		response.sendRedirect(request.getContextPath()+"/common/supervision.do?method=goSupervision&type=hfjl&id="+nid+"&userid="+userid);
		return null;
	}
	
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView deleteHourCostManageTable(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println(this.getClass()+"  >>>>>>>>>  deleteHourCostManageTable()...");
		ASFuntion asf = new ASFuntion();
		String nid = asf.showNull((String)request.getSession().getAttribute("testnoticeid"));
		String userid = asf.showNull((String)request.getSession().getAttribute("testnoticeuserid"));
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			HourCostManageService hcms = new HourCostManageService(conn);
			HourCostMainService hcms2 = new HourCostMainService(conn);
			String id = request.getParameter("id");
			hcms2.deleteHourCostMainTable(id);
			hcms.delHourCostManageTable(id);
			hcms.delCityTransportTable(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		response.sendRedirect(request.getContextPath()+"/common/supervision.do?method=goSupervision&type=hfjl&id="+nid+"&userid="+userid);
		return null;
	}
	
	/**
	 * 编辑跳转
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 */
	public ModelAndView addAndEdit(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(ADDANDEDIT);
		
		ASFuntion af = new ASFuntion();
		String groupname = af.showNull((String)request.getSession().getAttribute("groupname"));
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = StringUtil.showNull((String)map.get("loginid")); 
		String loginname = StringUtil.showNull((String)map.get("loginname")); 
		String officecode = StringUtil.showNull((String)map.get("officecode"));
		
		Connection conn = null; 
		String param = StringUtil.showNull(request.getParameter("param"));
		String source = StringUtil.showNull(request.getParameter("source"));
		HourCostManageTable hcmt = null;
		try {
			conn = new DBConnect().getConnect();
			HourCostManageService hcms = new HourCostManageService(conn);
			if(param.equals("update")){
				String id = StringUtil.showNull(request.getParameter("id"));
				hcmt = hcms.getHourCostManageTable(id);
				model.addObject("hcmt", hcmt);
			}else if(param.equals("add")){
//				String sql = "select loginname from k_company where officecode = '"+officecode+"'";
//				String officename = new DbUtil(conn).queryForString(sql);
				
				HourCostMainTable hcmt2 = new HourCostMainTable();
				
				hcmt2.setFillMan(loginname);
				hcmt2.setFillTime(af.getCurrentDate());
				
//				model.addObject("officename", officename);
				model.addObject("officename", officecode);
				model.addObject("loginid", loginid);
				model.addObject("loginname", loginname);
				model.addObject("officecode", officecode);
				model.addObject("hcmt2", hcmt2);
			}
			model.addObject("source", source);
			
			//单位设置
			Map mapParam = hcms.getPayParametterTable();
			//广州组
			System.out.println(mapParam.get("checkpay")+"    "+mapParam.get("checkpayex"));
			if(groupname.indexOf("广州")>-1){
				//checkpay,mealmoneypay,transportpay,other,companypay
				model.addObject("checkpay", mapParam.get("checkpay"));
				model.addObject("mealmoneypay", mapParam.get("mealmoneypay"));
				model.addObject("transportpay", mapParam.get("transportpay"));
				model.addObject("other", mapParam.get("other"));
				model.addObject("companypay", mapParam.get("companypay"));
			}else{
				model.addObject("checkpay", mapParam.get("checkpayex"));
				model.addObject("mealmoneypay", mapParam.get("mealmoneypayex"));
				model.addObject("transportpay", mapParam.get("transportpayex"));
				model.addObject("other", mapParam.get("otherex"));
				model.addObject("companypay", mapParam.get("companypayex"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return model;
	}
	
	/**
	 * 得到两个日期之间相差的天数
	 * @param request
	 * @param response
	 * @return
	 */
	public int getCountDays(HttpServletRequest request,HttpServletResponse response){
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		System.out.println(this.getClass()+" startTime="+startTime+" endTime="+endTime);
		return new DateUtil().equalDate(startTime, endTime);
	}
	
	/**
	 * 查看
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView goView(HttpServletRequest request,HttpServletResponse response){

		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		ASFuntion af = new ASFuntion();
		String groupname = af.showNull((String)request.getSession().getAttribute("groupname"));
		String loginid = af.showNull((String)map.get("loginid")); 
		String loginname = af.showNull((String)map.get("loginname")); 
		String officecode = af.showNull((String)map.get("officecode"));
		
		Connection conn = null;
		
		try {
			conn = new DBConnect().getConnect();
			ModelAndView model = new ModelAndView(ADDANDEDIT);
			String mid = request.getParameter("id");
			String opt = request.getParameter("opt");
			String source = request.getParameter("source");
			String valid = "";
			if(!"update".equalsIgnoreCase(opt)){
				valid = "N";
			}
			
			HourCostManageService hcms = new HourCostManageService(conn);
			
			List listc = hcms.getCityTransportTable(mid);
			
			List list = hcms.getManyHourCostManageTable(mid);
			
			HourCostMainService hcms2 = new HourCostMainService(conn);
			HourCostMainTable hcmt2 = hcms2.getHourHourCostMainTable(mid);
			
			model.addObject("listc", listc);
			model.addObject("list", list);
			model.addObject("hcmt2", hcmt2);
			model.addObject("opt", "update");
			
			model.addObject("officename", officecode);
			model.addObject("loginid", loginid);
			model.addObject("loginname", loginname);
			model.addObject("officecode", officecode);
			model.addObject("valid", valid);
			model.addObject("source", source);
			
			//单位设置
			Map mapParam = hcms.getPayParametterTable();
			//广州组
			System.out.println(mapParam.get("checkpay")+"    "+mapParam.get("checkpayex"));
			if(groupname.indexOf("广州")>-1){
				//checkpay,mealmoneypay,transportpay,other,companypay
				model.addObject("checkpay", mapParam.get("checkpay"));
				model.addObject("mealmoneypay", mapParam.get("mealmoneypay"));
				model.addObject("transportpay", mapParam.get("transportpay"));
				model.addObject("other", mapParam.get("other"));
				model.addObject("companypay", mapParam.get("companypay"));
			}else{
				model.addObject("checkpay", mapParam.get("checkpayex"));
				model.addObject("mealmoneypay", mapParam.get("mealmoneypayex"));
				model.addObject("transportpay", mapParam.get("transportpayex"));
				model.addObject("other", mapParam.get("otherex"));
				model.addObject("companypay", mapParam.get("companypayex"));
			}
			
			return model;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView goUpdate(HttpServletRequest request,HttpServletResponse response){
		
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String loginname = (String)map.get("loginname"); 
		String officecode = (String)map.get("officecode");
		
		Connection conn = null;
		
		try {
			conn = new DBConnect().getConnect();
			ModelAndView model = new ModelAndView(ADDANDEDIT);
			String mid = request.getParameter("id");
			
			HourCostManageService hcms = new HourCostManageService(conn);
			
			List listc = hcms.getCityTransportTable(mid);
			
			List list = hcms.getManyHourCostManageTable(mid);
			
			HourCostMainService hcms2 = new HourCostMainService(conn);
			HourCostMainTable hcmt2 = hcms2.getHourHourCostMainTable(mid);
			
			model.addObject("listc", listc);
			model.addObject("list", list);
			model.addObject("hcmt2", hcmt2);
			model.addObject("opt", "update");
			
			model.addObject("officename", officecode);
			model.addObject("loginid", loginid);
			model.addObject("loginname", loginname);
			model.addObject("officecode", officecode);
			
			return model;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
}
