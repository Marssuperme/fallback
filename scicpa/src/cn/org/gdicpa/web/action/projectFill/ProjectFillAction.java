package cn.org.gdicpa.web.action.projectFill;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.listener.UserSession;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.projectFill.ProjectFillService;
import cn.org.gdicpa.web.service.projectFill.model.ProjectFill;

public class ProjectFillAction extends MultiActionController{
	private static final String LIST = "/projectFill/list.jsp";
	private static final String ADDANDEDIT = "/projectFill/addAndEdit.jsp";
	
	
	/**
	 * list
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		ModelAndView model = new ModelAndView(LIST);
		
		String sql = " select * from  k_projectFill where 1=1 ${companyName} ${projectName} ${fillUserName} ${fillTime} "; 
		
		DataGridProperty pp = new DataGridProperty() {
			public void onSearch(HttpSession session,HttpServletRequest request,
					HttpServletResponse response) throws Exception {
				String companyName = getRequestValue("companyName") ;
				String projectName = getRequestValue("projectName") ;
				String fillUserName = getRequestValue("fillUserName") ;
				String fillTime1 = getRequestValue("fillTime1") ;
				String fillTime2 = getRequestValue("fillTime2") ;
				String fillTime = "" ;
				if(companyName == null || "".equals(companyName)) {
					companyName = "" ;
				}else {
					companyName = " and ( companyName = '"+companyName+"' or companyId = '"+companyName+"' )" ;
				}
				
				if(projectName == null || "".equals(projectName)) {
					projectName = "" ;
				}else {
					projectName = " and projectName like '%"+projectName+"%'";
				}
				
				if(fillUserName == null || "".equals(fillUserName)) {
					fillUserName = "" ;
				}else {
					fillUserName = " and (fillUserName='"+fillUserName+"' or fillUserId='"+fillUserName+"')";
				}
				
				
				if(fillTime1!=null && !"".equals(fillTime1) && fillTime2!=null && !"".equals(fillTime2)){
					fillTime = "  and ( fillTime between '"+fillTime1+"' and '"+fillTime2+" 24:00:00' ) ";
				}else{
					if(fillTime1!=null && !"".equals(fillTime1)){
						fillTime = "  and substring(fillTime,1,10) = '"+fillTime1+"'";
					}
					if(fillTime2!=null && !"".equals(fillTime2)){
						fillTime = "  and substring(fillTime,1,10) = '"+fillTime2+"'";
					}
				}
				
				this.setOrAddRequestValue("companyName", companyName);
				this.setOrAddRequestValue("projectName", projectName);
				this.setOrAddRequestValue("fillUserName", fillUserName);
				this.setOrAddRequestValue("fillTime", fillTime);
			}
		};
			

		pp.addInputValue("fillTime1");
		pp.addInputValue("fillTime2");
		
		pp.addSqlWhere("companyName","${companyName}") ;
		pp.addSqlWhere("projectName","${projectName}") ;
		pp.addSqlWhere("fillUserName","${fillUserName}") ;
		pp.addSqlWhere("fillTime","${fillTime}") ;
		
		pp.setInputType("radio");
		
		pp.setTableID("projectFillList");
		pp.setWhichFieldIsValue(1);
		
		pp.addColumn("被检查事务所", "companyName","showCenter");
		pp.addColumn("项目名称", "projectName","showCenter");
		pp.addColumn("填报人", "fillUserName","showCenter");
		pp.addColumn("填报时间", "fillTime","showCenter");
		
		pp.setTitle("项目填报信息");
		pp.setPageSize_CH("10");
		
		pp.setSQL(sql);
		pp.setOrderBy_CH("fillTime");
		pp.setDirection("desc");
		request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
			
		return model;
	}
	
	/**
	 * 跳转
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView go(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView model = new ModelAndView(ADDANDEDIT);
		String opt = request.getParameter("opt");
		String id = request.getParameter("id");
		String source = request.getParameter("source");
		Connection conn = null;
		try{
			// 修改
			if("update".equalsIgnoreCase(opt)){
				conn = new DBConnect().getConnect();
				ProjectFillService pfs = new ProjectFillService(conn);
				Map map = pfs.getSupervisionSub(id);
				model.addObject("map", map);
			}else{
				ProjectFill pf = new ProjectFill();
				Map map = new HashMap();
				map.put("filltime", new ASFuntion().getCurrentDate());
				model.addObject("map", map);
			}
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			DbUtil.close(conn);
		}
		model.addObject("opt", opt);
		model.addObject("source", source);
		return model;
	}
	
	
	/**
	 * 跳转
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView go_bak(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView model = new ModelAndView(ADDANDEDIT);
		String opt = request.getParameter("opt");
		String id = request.getParameter("id");
		String source = request.getParameter("source");
		Connection conn = null;
		try{
			// 修改
			if("update".equalsIgnoreCase(opt)){
				conn = new DBConnect().getConnect();
				ProjectFillService pfs = new ProjectFillService(conn);
				ProjectFill pf = pfs.getProjectFillById(id);
				model.addObject("pf", pf);
			}else{
				ProjectFill pf = new ProjectFill();
				pf.setFillTime(new ASFuntion().getCurrentDate());
				model.addObject("pf", pf);
			}
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			DbUtil.close(conn);
		}
		model.addObject("opt", opt);
		model.addObject("source", source);
		return model;
	}
	

	/**
	 * 保存
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response) {
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginUser = request.getParameter("loginid");
		if(userSession!=null){
			Map map = userSession.getUserMap();
			loginUser = (String)map.get("loginid");
		}
		ASFuntion af = new ASFuntion();
		String opt = request.getParameter("opt");
		String id = request.getParameter("id");
		String source = request.getParameter("source");
		String mainId = (String)request.getSession().getAttribute("testnoticeid");
		String projectId = "";
		String projectName = request.getParameter("projectName");
		String companyId = "";
		String qmzs1 = "";
		String qmzs2 = "";
		String qmzs3 = "";
		String qmzs4 = "";
		String qmzs5 = "";
		String qmzs6 = "";
		String fillBy = loginUser;
		String fillTime = af.getDateAndTime1();
		
		String companyName = request.getParameter("companyName");
		String bgwh = request.getParameter("bgwh");
		
		/*
		id,MainID,ProjectID,loginid,lstUserID,lstUserName,ProjectName,
		QMZS1,QMZS2,QMZS3,QMZS4,QMZS5,QMZS6,InitFlag,TimeFlag,FillBy,FillTime
		 */
		Connection conn = null;
		try{
			conn = new DBConnect().getConnect();
			
			DbUtil db = new DbUtil(conn);
			companyId = db.queryForString(" select loginid from k_user where loginname = ? ",new Object[]{companyName});
			
			ProjectFillService pfs = new ProjectFillService(conn);
			
			if(bgwh==null || "".equals(bgwh)){
				projectId = request.getParameter("projectId"); 
				Map map = pfs.getContentInfo2(projectId);
				qmzs1 = (String)map.get("qmzs1");
				qmzs2 = (String)map.get("qmzs2");
				qmzs3 = (String)map.get("qmzs3");
				qmzs4 = (String)map.get("qmzs4");
				qmzs5 = (String)map.get("qmzs5");
				qmzs6 = (String)map.get("qmzs6");
			}else{
				Map map = pfs.getContentInfo(companyId, bgwh);
				projectId = (String)map.get("guid");
				qmzs1 = (String)map.get("qmzs1");
				qmzs2 = (String)map.get("qmzs2");
				qmzs3 = (String)map.get("qmzs3");
				qmzs4 = (String)map.get("qmzs4");
				qmzs5 = (String)map.get("qmzs5");
				qmzs6 = (String)map.get("qmzs6");
			}
			
			Map map_save = new HashMap();
			
			// 修改
			if("update".equalsIgnoreCase(opt)){
				map_save.put("id", id);
				map_save.put("mainid", mainId);
				map_save.put("projectid", projectId);
				map_save.put("loginid", companyId);
				map_save.put("projectname", projectName);
				
				map_save.put("qmzs1",qmzs1);
				map_save.put("qmzs2",qmzs2);
				map_save.put("qmzs3",qmzs3);
				map_save.put("qmzs4",qmzs4);
				map_save.put("qmzs5",qmzs5);
				
				map_save.put("qmzs6",qmzs6);
				map_save.put("fillby",fillBy);
				map_save.put("filltime",fillTime);
				
				pfs.updateProjectFill2(map_save);
				
			}else{
				map_save.put("id", UUID.randomUUID().toString());
				map_save.put("mainid", mainId);
				map_save.put("projectid", projectId);
				map_save.put("loginid", companyId);
				map_save.put("projectname", projectName);
				
				map_save.put("qmzs1",qmzs1);
				map_save.put("qmzs2",qmzs2);
				map_save.put("qmzs3",qmzs3);
				map_save.put("qmzs4",qmzs4);
				map_save.put("qmzs5",qmzs5);
				
				map_save.put("qmzs6",qmzs6);
				map_save.put("fillby",fillBy);
				map_save.put("filltime",fillTime);
				
				pfs.addProjectFill2(map_save);
			}
			// 监管作业链接过来的
			if("xmtb".equalsIgnoreCase(source)){
				response.sendRedirect(request.getContextPath()+"/common/supervision.do?method=goSupervision&type=xmtb");
			}else{
				response.sendRedirect(request.getContextPath()+"/common/supervision.do?method=goSupervision");
			}
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	

	/**
	 * 保存
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView save_bak(HttpServletRequest request,HttpServletResponse response) {
		String opt = request.getParameter("opt");
		String id = request.getParameter("id");
		String source = request.getParameter("source");
		String companyName = request.getParameter("companyName");
		String projectName = request.getParameter("projectName");
		String fillUserName = request.getParameter("fillUserName");
		String fillTime = request.getParameter("fillTime");
		
		ProjectFill pf = new ProjectFill();
		pf.setCompanyName(companyName);
		pf.setProjectName(projectName);
		pf.setFillUserName(fillUserName);
		pf.setFillTime(fillTime);
		Connection conn = null;
		try{
			conn = new DBConnect().getConnect();
			String companyId = new DbUtil(conn).queryForString(" select loginid from k_user where loginname = ? ",new Object[]{companyName});
			String fillUserId = new DbUtil(conn).queryForString(" select loginid from k_user where loginname = ? ",new Object[]{fillUserName});
			
			pf.setCompanyId(companyId);
			pf.setFillUserId(fillUserId);
			
			ProjectFillService pfs = new ProjectFillService(conn);
			
			// 修改
			if("update".equalsIgnoreCase(opt)){
				pf.setId(id);
				pfs.updateProjectFill(pf);
				
			}else{
				pf.setId(UUID.randomUUID().toString());
				pfs.addProjectFill(pf);
			}
			// 监管作业链接过来的
			if("xmtb".equalsIgnoreCase(source)){
				response.sendRedirect(request.getContextPath()+"/common/supervision.do?method=goSupervision&type=xmtb");
			}else{
				response.sendRedirect(request.getContextPath()+"/common/supervision.do?method=goSupervision");
			}
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	
	
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView delete(HttpServletRequest request,HttpServletResponse response) {
		String id = request.getParameter("id");
		Connection conn = null;
		try{
			conn = new DBConnect().getConnect();
			ProjectFillService pfs = new ProjectFillService(conn);
			pfs.delete2(id);
			response.sendRedirect(request.getContextPath()+"/common/supervision.do?method=goSupervision&type=xmtb");
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView delete_Bak(HttpServletRequest request,HttpServletResponse response) {
		String id = request.getParameter("id");
		Connection conn = null;
		try{
			conn = new DBConnect().getConnect();
			ProjectFillService pfs = new ProjectFillService(conn);
			pfs.deleteProjectFillById(id);
			response.sendRedirect(request.getContextPath()+"/common/supervision.do?method=goSupervision&type=xmtb");
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
	
	/**
	 * 同一个项目不能报两次
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ModelAndView check1(HttpServletRequest request,HttpServletResponse response) throws IOException{
		ASFuntion af = new ASFuntion();
		String companyName = af.showNull(request.getParameter("companyName"));
		String bgwh = af.showNull(request.getParameter("bgwh"));
		Connection conn = null;
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			String companyId = new DbUtil(conn).queryForString(" select loginid from k_user where loginname = ? ",new Object[]{companyName});
			ProjectFillService ps = new ProjectFillService(conn);
			Map map = ps.getContentInfo(companyId, bgwh);
			String projectId = (String)map.get("guid");
			String rs = af.showNull(new DbUtil(conn).queryForString(" select projectId from k_SuperviseSub where loginid=? and projectId=? ",new Object[]{companyId,projectId}));
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			if(!"".equals(rs)){
				out.print("Y");
			}else{
				out.print("N");
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
	 * 同一个项目不能报两次
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ModelAndView check2(HttpServletRequest request,HttpServletResponse response) throws IOException{
		ASFuntion af = new ASFuntion();
		String id = af.showNull(request.getParameter("id"));
		String companyName = af.showNull(request.getParameter("companyName"));
		String bgwh = af.showNull(request.getParameter("bgwh"));
		Connection conn = null;
		PrintWriter out = null ;
		try {
			conn = new DBConnect().getConnect();
			String companyId = new DbUtil(conn).queryForString(" select loginid from k_user where loginname = ? ",new Object[]{companyName});
			ProjectFillService ps = new ProjectFillService(conn);
			Map map = ps.getContentInfo(companyId, bgwh);
			String projectId = (String)map.get("guid");
			String rs = af.showNull(new DbUtil(conn).queryForString(" select projectId from k_SuperviseSub where loginid=? and projectId=? and id <> ? ",new Object[]{companyId,projectId,id}));
			response.setContentType("text/html;charset=UTF-8") ;
			out = response.getWriter() ;
			if(!"".equals(rs)){
				out.print("Y");
			}else{
				out.print("N");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.close();
			DbUtil.close(conn);
		}
		return null;
	}
	
	
}
