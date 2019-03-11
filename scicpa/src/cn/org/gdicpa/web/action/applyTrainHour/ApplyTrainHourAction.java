package cn.org.gdicpa.web.action.applyTrainHour;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


import cn.org.gdicpa.web.pub.autocode.DELUnid;
import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.applyTrainHour.ApplyTrainHourService;
import cn.org.gdicpa.web.service.applyTrainHour.model.ApplyTrainHourTable;

public class ApplyTrainHourAction extends MultiActionController{
	private static final String LIST = "/applyTrainHour/list.jsp";
	private static final String VIEW = "/applyTrainHour/view.jsp";
	private static final String ADDANDEDIT = "/applyTrainHour/addAndEdit.jsp";
	private static final String ADDANDEDIT1 = "/applyTrainHour/addAndEdit1.jsp";
	
	
	/**
	 * 跳转
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView go(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String ctypetabname = StringUtil.showNull((String)map.get("ctypetabname")); 
		String id = StringUtil.showNull(request.getParameter("id"));
		Connection conn = null;
		try {
			if(ctypetabname.equalsIgnoreCase("k_company")){
				model = new ModelAndView(ADDANDEDIT1);
			}else{
				model = new ModelAndView(ADDANDEDIT);
			}
			
			if(id != null && !id.equals("")){
				conn = new DBConnect().getConnect();
				ApplyTrainHourService as = new ApplyTrainHourService(conn);
				ApplyTrainHourTable at = as.getApplyTrainHourTableByGUID(id);
				model.addObject("at",at);
			}else{
				model.addObject("attachmentid",DELUnid.getNumUnid());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return model;
	}
	
	
	/**
	 * 默认方法
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"     index........");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String ctypetabname = (String)map.get("ctypetabname"); 
		String ctype = (String)map.get("ctype"); 
		
		ModelAndView model = new ModelAndView(LIST);
		Connection conn = null;
		String sql = ""; 
		try {
			conn = new DBConnect().getConnect();
			if(ctypetabname.equalsIgnoreCase("k_company")){
				sql = " select id,a.loginid,a.loginName,applyHours,educationType,educationNote, "
					+ " applyDate,companyOpinion,societyOpinion,attachmentid,companyChecked,provinceChecked "
					+ " from XS_ApplyTrainHour a "   
					+ " inner join k_micfo m "
					+ " on a.loginid = m.loginid "
					+ " where m.officecode = '"+loginid+"' ${loginName} ${applyHours} ${applyDate} ";
			}else if(ctypetabname.equalsIgnoreCase("k_micfo")){
				sql = " select id,loginid,loginName,applyHours,educationType,educationNote, " 
					+ " applyDate,companyOpinion,societyOpinion,attachmentid,companyChecked,provinceChecked "
					+ " from XS_ApplyTrainHour a where loginid = '"+loginid+"' and isnull(ctype,'')<>'非执业会员' ${loginName} ${applyHours} ${applyDate} ";
			}else{
				sql = " select id,loginid,loginName,applyHours,educationType,educationNote, " 
					+ " applyDate,companyOpinion,societyOpinion,attachmentid,companyChecked,provinceChecked "
					+ " from XS_ApplyTrainHour a where loginid = '"+loginid+"' and ctype='"+ctype+"' ${loginName} ${applyHours} ${applyDate} ";
			}
			
			DataGridProperty pp = new DataGridProperty() {
				public void onSearch(HttpSession session,HttpServletRequest request,
						HttpServletResponse response) throws Exception {
					String loginName = getRequestValue("loginName") ;
					String applyHours = getRequestValue("applyHours") ;
					String applyDate1 = getRequestValue("applyDate1") ;
					String applyDate2 = getRequestValue("applyDate2") ;
					String applyDate = "" ;
					if(loginName == null || "".equals(loginName)) {
						loginName = "" ;
					}else {
						loginName = " and a.loginName like '%"+loginName+"%'" ;
					}
					
					if(applyHours == null || "".equals(applyHours)) {
						applyHours = "" ;
					}else {
						applyHours = " and applyHours= '"+applyHours+"'";
					}
					
					if(applyDate1!=null && !"".equals(applyDate1) && applyDate2!=null && !"".equals(applyDate2)){
						applyDate = "  and ( applyDate between '"+applyDate1+"' and '"+applyDate2+" 24:00:00' ) ";
					}else{
						if(applyDate1!=null && !"".equals(applyDate1)){
							applyDate = "  and substring(applyDate,1,10) = '"+applyDate1+"'";
						}
						if(applyDate2!=null && !"".equals(applyDate2)){
							applyDate = "  and substring(applyDate,1,10) = '"+applyDate2+"'";
						}
					}
					
					this.setOrAddRequestValue("loginName", loginName);
					this.setOrAddRequestValue("applyHours", applyHours);
					this.setOrAddRequestValue("applyDate", applyDate);
				}
			};
			

			pp.addInputValue("applyDate1");
			pp.addInputValue("applyDate2");
			
			pp.addSqlWhere("loginName","${loginName}") ;
			pp.addSqlWhere("applyHours","${applyHours}") ;
			pp.addSqlWhere("applyDate","${applyDate}") ;
			
			pp.setInputType("radio");
			
			pp.setTableID("applyTrainHourList");
			pp.setWhichFieldIsValue(1);
			
			pp.addColumn("申报者", "loginName","showCenter").setTdProperty(" onclick=\"goView('${id}');\" ");
			pp.addColumn("申请学时数", "applyHours","showCenter");
			pp.addColumn("参加继续教育的形式", "educationType","showCenter");
		
			pp.addColumn("申请日期", "applyDate","showCenter");
			pp.addColumn("事务所审核状态", "companyChecked","showCenter");
			pp.addColumn("省注协审核状态", "provinceChecked","showCenter");
			
			pp.setTitle("其他学时申报");
			pp.setPageSize_CH("10");
			
			pp.setSQL(sql);
			pp.setOrderBy_CH("applyDate");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		model.addObject("ctypetabname", ctypetabname.toLowerCase());
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
	public ModelAndView addApplyTrainHourTable(HttpServletRequest request,HttpServletResponse response,ApplyTrainHourTable at) throws IOException{
		Connection conn = null;  
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Map map = userSession.getUserMap();
			String loginid = (String)map.get("loginid"); 
			String loginName = (String)map.get("loginname");
			String ctype = (String)map.get("ctype");
			
			conn = new DBConnect().getConnect();
			ApplyTrainHourService as= new ApplyTrainHourService(conn);
			
			at.setId(UUID.randomUUID().toString());
			at.setApplyDate(new ASFuntion().getCurrentDate());
			at.setLoginid(loginid);
			at.setLoginName(loginName);
			at.setCompanyChecked("等待审核");
			at.setProvinceChecked("等待审核");
			at.setCtype(ctype);
		    as.addApplyTrainHourTable(at);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		response.sendRedirect(request.getContextPath()+"/common/addApplyTrainHour.do?method=index");
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
	public ModelAndView updateApplyTrainHourTable(HttpServletRequest request,HttpServletResponse response,ApplyTrainHourTable at) throws IOException{
		Connection conn = null;  
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String ctypetabname = (String)map.get("ctypetabname"); 
		
		String id = request.getParameter("id");
		try {
			conn = new DBConnect().getConnect();
			ApplyTrainHourService as= new ApplyTrainHourService(conn);
			at.setId(id);
			if(ctypetabname.equalsIgnoreCase("k_company")){
				as.updateApplyTrainHourTable1(at);
			}else{
				at.setApplyDate(new ASFuntion().getCurrentDate());
				as.updateApplyTrainHourTable(at);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		response.sendRedirect(request.getContextPath()+"/common/addApplyTrainHour.do?method=index");
		return null;
	}
	
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView deleteApplyTrainHourTable(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;  
		String id = request.getParameter("id");
		try {
			conn = new DBConnect().getConnect();
			ApplyTrainHourService as= new ApplyTrainHourService(conn);
			as.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		response.sendRedirect(request.getContextPath()+"/common/addApplyTrainHour.do?method=index");
		return null;
	}
	
	
	
	 
	/**
	 * 得到审核状态
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView viewState(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;
		String id = request.getParameter("id");
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
		 	ApplyTrainHourTable at = new ApplyTrainHourService(conn).getApplyTrainHourTableByGUID(id);
		 	response.setContentType("text/html;charset=UTF-8") ;
		 	out = response.getWriter() ;
		 	
		 	if("通过".equals(at.getCompanyChecked()) || "通过".equals(at.getProvinceChecked())){
		 		out.print("N");
		 	}else{
		 		out.print("Y");
		 	}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.close();
			DbUtil.close(conn);
		}
		return null;
	}
	
	/**
	 * 查看 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView view(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String ctypetabname = (String)map.get("ctypetabname"); 
		System.out.println(this.getClass()+"       ctypetabname="+ctypetabname);
		String id = request.getParameter("id");
		Connection conn = null;
		try {
			model = new ModelAndView(VIEW);
			conn = new DBConnect().getConnect();
			ApplyTrainHourService as = new ApplyTrainHourService(conn);
			ApplyTrainHourTable at = as.getApplyTrainHourTableByGUID(id);
			model.addObject("at",at);
			
			model.addObject("ctypetabname", ctypetabname.toLowerCase());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return model;
	}
	
	
}
