package cn.org.gdicpa.web.action.planManage;

import java.io.IOException;
import java.sql.Connection;
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
import cn.org.gdicpa.web.service.planManage.PlanManageService;
import cn.org.gdicpa.web.service.planManage.model.PlanManage;

public class PlanManageAction extends MultiActionController{
	private static final String LIST = "/planManage/list.jsp";
	private static final String ADDANDEDIT = "/planManage/addAndEdit.jsp";
	
	 
	/**
	 * list
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		ModelAndView model = new ModelAndView(LIST);
		
		String sql = " select c.loginname as companyname,ss.projectName,s.beginDate,u.loginid as username  " 
				   + " from k_supprogress s " 
				   + " left join k_company c on s.companyid=c.loginid " 
				   + " left join k_SuperviseSub ss on s.ProjectID=ss.ProjectID " 
				   + " left join k_user u on s.userId = u.loginid  " 
				   + " where 1=1 ${beginDate} "; 
		
		DataGridProperty pp = new DataGridProperty() {
			public void onSearch(HttpSession session,HttpServletRequest request,
					HttpServletResponse response) throws Exception {
//				String companyName = getRequestValue("companyName") ;
//				String projectName = getRequestValue("projectName") ;
//				String fillUserName = getRequestValue("fillUserName") ;
				String beginDate1 = getRequestValue("beginDate1") ;
				String beginDate2 = getRequestValue("beginDate2") ;
				String beginDate = "" ;
				
//				if(companyName == null || "".equals(companyName)) {
//					companyName = "" ;
//				}else {
//					companyName = " and ( companyName = '"+companyName+"' or companyId = '"+companyName+"' )" ;
//				}
//				
//				if(projectName == null || "".equals(projectName)) {
//					projectName = "" ;
//				}else {
//					projectName = " and projectName like '%"+projectName+"%'";
//				}
//				
//				if(fillUserName == null || "".equals(fillUserName)) {
//					fillUserName = "" ;
//				}else {
//					fillUserName = " and (fillUserName='"+fillUserName+"' or fillUserId='"+fillUserName+"')";
//				}
				
				if(beginDate1!=null && !"".equals(beginDate1) && beginDate2!=null && !"".equals(beginDate2)){
					beginDate = "  and ( beginDate between '"+beginDate1+"' and '"+beginDate2+" 24:00:00' ) ";
				}else{
					if(beginDate1!=null && !"".equals(beginDate1)){
						beginDate = "  and substring(beginDate,1,10) = '"+beginDate1+"'";
					}
					if(beginDate2!=null && !"".equals(beginDate2)){
						beginDate = "  and substring(beginDate,1,10) = '"+beginDate2+"'";
					}
				}
				
				
//				this.setOrAddRequestValue("companyName", companyName);
//				this.setOrAddRequestValue("projectName", projectName);
//				this.setOrAddRequestValue("fillUserName", fillUserName);
				this.setOrAddRequestValue("beginDate", beginDate);
			}
		};
			

		pp.addInputValue("beginDate1");
		pp.addInputValue("beginDate2");
		
//		pp.addSqlWhere("companyName","${companyName}") ;
//		pp.addSqlWhere("projectName","${projectName}") ;
//		pp.addSqlWhere("fillUserName","${fillUserName}") ;
		pp.addSqlWhere("beginDate","${beginDate}") ;
		
		pp.setInputType("radio");
		
		pp.setTableID("planManageList");
		pp.setWhichFieldIsValue(1);
		
		pp.addColumn("被检查事务所", "companyName","showCenter");
		pp.addColumn("项目名称", "projectName","showCenter");
		pp.addColumn("填报人", "username","showCenter");
		pp.addColumn("进场日期", "beginDate","showCenter");
		
		pp.setTitle("进度管理信息");
		pp.setPageSize_CH("10");
		
		pp.setSQL(sql);
		pp.setOrderBy_CH("beginDate");
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
				PlanManageService pms = new PlanManageService(conn);
				PlanManage pm = pms.getPlanManageById(id);
				model.addObject("pm", pm);
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
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response,PlanManage pm) {
		String opt = request.getParameter("opt");
		String source = request.getParameter("source");
		
		Connection conn = null;
		try{
			conn = new DBConnect().getConnect();
			
			PlanManageService pms = new PlanManageService(conn);
			
			// 修改
			if("update".equalsIgnoreCase(opt)){
				pms.updatePlanManage(pm);
				
			}else{
				pm.setId(UUID.randomUUID().toString());
				pms.addPlanManage(pm);
			}
			
			// 监管作业链接过来的
			if("jdgl".equalsIgnoreCase(source)){
				response.sendRedirect(request.getContextPath()+"/common/supervision.do?method=goSupervision&type=zxtb");
			}else{
				response.sendRedirect(request.getContextPath()+"/common/supervision.do?method=goSupervision&type=jdgl");
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
			PlanManageService pms = new PlanManageService(conn);
			pms.deletePlanManageById(id);
			response.sendRedirect(request.getContextPath()+"/common/supervision.do?method=goSupervision&type=jdgl");
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			DbUtil.close(conn);
		}
		return null;
	}
	
}
