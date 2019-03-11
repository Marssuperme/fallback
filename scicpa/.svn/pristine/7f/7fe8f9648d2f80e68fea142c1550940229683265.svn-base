package cn.org.gdicpa.web.action.applyHoldSelfHour;

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
import cn.org.gdicpa.web.service.applyHoldSelfHour.ApplyHoldSelfHourService;
import cn.org.gdicpa.web.service.applyHoldSelfHour.model.ApplyHoldSelfHourTable;
import cn.org.gdicpa.web.service.lineup.LineupService;
import cn.org.gdicpa.web.service.lineup.model.LineupTable;

public class ApplyHoldSelfHourAction extends MultiActionController{
	private static final String LIST = "/applyHoldSelfHour/list.jsp";
	private static final String VIEW = "/applyHoldSelfHour/view.jsp";
	private static final String ADDANDEDIT = "/applyHoldSelfHour/addAndEdit.jsp";
	private static final String traingingSchoolTime = "/applyHoldSelfHour/traingingSchoolTime.jsp";
	private static final String fileList = "/applyHoldSelfHour/fileList.jsp";
	private static final String fileAdd = "/applyHoldSelfHour/fileAdd.jsp";
	private static final String fileView = "/applyHoldSelfHour/fileView.jsp";
	
	
	/**
	 * 跳转
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView go(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = null;
		String id = StringUtil.showNull(request.getParameter("id"));
		Connection conn = null;
		try {
			model = new ModelAndView(ADDANDEDIT);
			
			if(id != null && !id.equals("")){
				conn = new DBConnect().getConnect();
				ApplyHoldSelfHourService as = new ApplyHoldSelfHourService(conn);
				ApplyHoldSelfHourTable at = as.getApplyHoldSelfHourById(id);
				model.addObject("at",at);
			}else{
				model.addObject("attachmentid",DELUnid.getNumUnid());
				model.addObject("hourAttachmentid",DELUnid.getNumUnid()+"1");
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
		
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion af = new ASFuntion();
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid"); 
		String ctypetabname = (String)map.get("ctypetabname"); 
		String classId = af.showNull(request.getParameter("classId")); 
		
		ModelAndView model = new ModelAndView(LIST);
		String sql = "";
		try {
			sql = " select id,companyid,classid,trainingTime,hourAttachmentid,attachmentid,"
				+ " provinceChecked,micfoNum,micfoName,hourType,trainingName,"
				+ " examResult,attendance,isover,reportNumber,reason,post,"
				+ " hourResult,years,trainingTimeBeg,trainingTimeEnd  " 
				+ " from XS_ApplyHoldSelfHour where companyid = '"+loginid+"' and classId = '"+classId+"' ${trainingName} ${hourType} ";
			
			
			System.out.println("sql : ==> "+sql);
			DataGridProperty pp = new DataGridProperty() {
				public void onSearch(HttpSession session,HttpServletRequest request,
						HttpServletResponse response) throws Exception {
					String trainingName = getRequestValue("trainingName") ;
					String hourType = getRequestValue("hourType") ;
					if(trainingName == null || "".equals(trainingName)) {
						trainingName = "" ;
					}else {
						trainingName = " and trainingName like '%"+trainingName+"%'" ;
					}
					
					if(hourType == null || "".equals(hourType)) {
						hourType = "" ;
					}else {
						hourType = " and hourType like '%"+hourType+"%'";
					}
					this.setOrAddRequestValue("trainingName", trainingName);
					this.setOrAddRequestValue("hourType", hourType);
				}
			};
			
			pp.setInputType("radio");
			pp.setWhichFieldIsValue(1);
			
			pp.setTableID("ApplyHoldSelfHourList");
			
			pp.addSqlWhere("trainingName","${trainingName}") ;
			pp.addSqlWhere("hourType","${hourType}") ;
			
			pp.addColumn("培训班名称", "trainingName","showCenter");
			pp.addColumn("注师名称", "micfoName","showCenter");
			pp.addColumn("学时形式", "hourType","showCenter");
			pp.addColumn("考试考核结果", "examResult","showCenter");
			pp.addColumn("学时结果", "hourResult","showCenter");
			
			pp.setPageSize_CH("10");
			pp.setTitle("自办培训班学时上报");
			pp.setSQL(sql);
			pp.setOrderBy_CH("trainingName");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
		model.addObject("classId", classId);
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
	public ModelAndView addApplyHoldSelfHourTable(HttpServletRequest request,HttpServletResponse response,ApplyHoldSelfHourTable ah) throws IOException{
		Connection conn = null;
		ASFuntion af = new ASFuntion();
		String classId = "";
		try {
			UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
			Map map = userSession.getUserMap();
			String loginid = af.showNull((String)map.get("loginid")); 
			String loginName = af.showNull((String)map.get("loginname"));
			classId = af.showNull(request.getParameter("classId"));
			
			conn = new DBConnect().getConnect();
			ApplyHoldSelfHourService as= new ApplyHoldSelfHourService(conn);
			
			ah.setId(UUID.randomUUID().toString());
			ah.setTrainingTime(new ASFuntion().getCurrentDate());
			ah.setCompanyId(loginid);
			ah.setProvinceChecked("否");
		    as.addApplyHoldSelfHourTable(ah);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		response.sendRedirect(request.getContextPath()+"/common/applyHoldSelfHour.do?method=index&classId="+classId);
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
	public ModelAndView updateApplyHoldSelfHourTable(HttpServletRequest request,HttpServletResponse response,ApplyHoldSelfHourTable ah) throws IOException{
		Connection conn = null;  
		ASFuntion af = new ASFuntion();
		String classId = af.showNull(request.getParameter("classId"));
		
		String id = request.getParameter("id");
		try {
			conn = new DBConnect().getConnect();
			ApplyHoldSelfHourService as= new ApplyHoldSelfHourService(conn);
			ah.setId(id);
			ah.setClassID(classId);
			as.updateApplyHoldSelfHourTable(ah);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		response.sendRedirect(request.getContextPath()+"/common/applyHoldSelfHour.do?method=index&classId="+classId);
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
		ASFuntion af = new ASFuntion();
		String classId = af.showNull(request.getParameter("classId"));
		String id = af.showNull(request.getParameter("id"));
		try {
			conn = new DBConnect().getConnect();
			ApplyHoldSelfHourService as= new ApplyHoldSelfHourService(conn);
			as.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		response.sendRedirect(request.getContextPath()+"/common/applyHoldSelfHour.do?method=index&classId="+classId);
		return null;
	}
	
	
	
	 
	/**
	 * 得到事务所审核状态
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView viewState(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Connection conn = null;
		ASFuntion af = new ASFuntion();
		String id = af.showNull(request.getParameter("id"));
		PrintWriter out = null ;
		String state = "";
		String sql = "";
		try {
			conn = new DBConnect().getConnect();
			sql = "select provinceChecked from XS_ApplyHoldSelfHour where id = ?";
			state = new DbUtil(conn).queryForString(sql,new String[]{id});
			
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			if(af.showNull(state).equals("是")){
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
		String id = request.getParameter("id");
		Connection conn = null;
		try {
			model = new ModelAndView(VIEW);
			conn = new DBConnect().getConnect();
			ApplyHoldSelfHourService as = new ApplyHoldSelfHourService(conn);
			ApplyHoldSelfHourTable at = as.getApplyHoldSelfHourById(id);
			model.addObject("ah",at);
			
			model.addObject("ctypetabname", ctypetabname.toLowerCase());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return model;
	}
	
	/**
	 * 去 导入学时
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView goImport(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(traingingSchoolTime);
		ASFuntion af = new ASFuntion();
		String p = af.showNull(request.getParameter("p"));
		String classId = af.showNull(request.getParameter("classId"));
		model.addObject("p", p);
		model.addObject("classId", classId);
		return model;
	}
	
	/**
	 * 自办培训班学时附件
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView uploadList(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(fileList);
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");
		String trainingName = (String)map.get("trainingName");
		try {
			String sql = " select id,lineuptime,lineupname,memo,c.loginname from s_lineup l left join k_company c on l.lineupPerson = c.loginid "
					   + " where lineupperson = '"+loginid+"' ${trainingName}";
		
			DataGridProperty pp = new DataGridProperty();
           
			pp.addSqlWhere("trainingName", "  and l.memo='${trainingName}'");	
			
			pp.setInputType("radio");
			pp.setTableID("lineup");
			pp.setWhichFieldIsValue(1);
			
			pp.addColumn("培训班名称", "memo","showCenter").setTdProperty(" onclick=\"goView('${id}');\" ");
			pp.addColumn("附件名称", "lineupname","showCenter");
			pp.addColumn("上传人", "loginname","showCenter");
			pp.addColumn("上传时间", "lineuptime","showCenter");
			
			pp.setSQL(sql);
			pp.setOrderBy_CH("lineuptime");
			pp.setDirection("desc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			
		}
		
		return model;
		
	}
	
	
	/**
	 * 跳转
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView addAndView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView model = null;
		ASFuntion af = new ASFuntion();
		String p = af.showNull(request.getParameter("p"));
		String classId = af.showNull(request.getParameter("classId"));
		if(p.equalsIgnoreCase("add")){
			model = new ModelAndView(fileAdd);
			model.addObject("attachment", DELUnid.getNumUnid());    //产生一个唯一编号         JS 上传的时候要用到这个编号
		}else if(p.equalsIgnoreCase("view")){
			model = new ModelAndView(fileView);
			String id = request.getParameter("id");
			Connection conn = new DBConnect().getConnect();
			LineupService ls = new LineupService(conn);
			LineupTable lte = ls.getLineupTable(id);
			model.addObject("lte", lte);
		}
		model.addObject("classId", classId);
		return model;
	}
	
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView(fileList);
		ASFuntion asf = new ASFuntion();
		String attachment = asf.showNull(request.getParameter("attachment"));
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = asf.showNull((String)map.get("loginid"));
		String time = asf.getDateAndTime();
		String trainingName = request.getParameter("trainingName");
		
		
		//  得到文件名称
		String strSql = " select filename from k_attachfile where indexid = '"+attachment+"' and indexTable = 's_lineup'";
		try {
			conn = new DBConnect().getConnect();
			String lineupname = new DbUtil(conn).queryForString(strSql);   // 得到文件名称
			strSql = " select classid from b_TrainingHoldSelf where officeid= '"+loginid+"' and classname = '"+trainingName+"'";
			String trainingId = new DbUtil(conn).queryForString(strSql);   // 附件编号
			LineupService ls = new LineupService(conn);
			LineupTable lt = new LineupTable();
			lt.setLineupname(lineupname);
			lt.setLineupperson(loginid);
			lt.setLineuptime(time);
			lt.setAttachment(attachment);
			lt.setMemo(trainingName);
			lt.setNoticeid(trainingId);
			ls.addLineupTable(lt);	// 添加对应信息到表中
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		
		return model;
	}
	
	
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView(fileList);
		String id = request.getParameter("id");
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			LineupService ls = new LineupService(conn);
			ls.deleteLineupTable(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		
		return model;
	}
	

	/**
	 * 得到状态
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getState(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8") ;
		String id = request.getParameter("id");
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		Map map = userSession.getUserMap();
		String loginid = (String)map.get("loginid");
		String trainingName = "";
		PrintWriter out = null;
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			out = response.getWriter();
			String sql = " select memo from s_lineup where id = '"+id+"'";
			trainingName = new DbUtil(conn).queryForString(sql);
			
			sql = " select count(*) from XS_ApplyHoldSelfHour " 
					   + " where companyid = '"+loginid+"' and trainingname = '"+trainingName+"' and provincechecked<>'是' ";

			String result = new DbUtil(conn).queryForString(sql);
			out.print(result);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn);
		}
		
		return null;
	}
}
