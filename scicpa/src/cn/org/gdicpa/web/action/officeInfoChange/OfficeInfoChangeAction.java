package cn.org.gdicpa.web.action.officeInfoChange;

import java.io.IOException;
import java.sql.Connection;

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
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.officeInfoChange.OfficeInfoChangeService;
import cn.org.gdicpa.web.service.officeInfoChange.model.OfficeInfoChangeTable;

public class OfficeInfoChangeAction extends MultiActionController{
	private static final String LIST = "/officeInfoChange/list.jsp";
	private static final String ADDANDEDIT = "/officeInfoChange/addAndEdit.jsp";
	private static final String VIEW = "/officeInfoChange/view.jsp";
	
	

	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  >>>>>>>>>>>>      index(HttpServletRequest request,HttpServletResponse response) ...............");
		ModelAndView model = new ModelAndView(LIST);
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		ASFuntion CHF = new ASFuntion();
		try {
			String loginid = CHF.showNull(request.getParameter("id")); 
			if("".equals(loginid))loginid = (String)userSession.getUserMap().get("loginid");
			
			String tablename = CHF.showNull(request.getParameter("tablename")); 
			String sql1 = "";
			if(!"".equals(tablename)) sql1 = " and tablename = '"+tablename+"' ";
			String sql = "select * from k_personInfoChange where loginid = '"+loginid+"' "+sql1+" ${changeTime} ${changeField} ";
			
			DataGridProperty pp = new DataGridProperty() {
				public void onSearch(HttpSession session,HttpServletRequest request,
						HttpServletResponse response) throws Exception {
					String changeTime1 = getRequestValue("changeTime1") ;
					String changeTime2 = getRequestValue("changeTime2") ;
					String changeField = getRequestValue("changeField") ;
					System.out.println("changeTime1="+changeTime1+"      changeTime2="+changeTime2);
					String changeTime = "";

					if(changeTime1!=null && !"".equals(changeTime1) && changeTime2!=null && !"".equals(changeTime2)){
						changeTime = "  and ( changeTime between '"+changeTime1+"' and '"+changeTime2+" 24:00:00' ) ";
					}else{
						if(changeTime1!=null && !"".equals(changeTime1)){
							changeTime = "  and substring(changeTime,1,10) = '"+changeTime1+"'";
						}
						if(changeTime2!=null && !"".equals(changeTime2)){
							changeTime = "  and substring(changeTime,1,10) = '"+changeTime2+"'";
						}
					}
					
					if(changeField == null || "".equals(changeField)) {
						changeField = "" ;
					}else {
						changeField = " and changeField like '%"+changeField+"%'";
					}
					this.setOrAddRequestValue("changeTime", changeTime);
					this.setOrAddRequestValue("changeField", changeField);
				}
			};
			
			pp.setTitle("信息变动经历");
			
			
			pp.addInputValue("changeTime1");
			pp.addInputValue("changeTime2");
			pp.addSqlWhere("changeTime","${changeTime}") ;
			pp.addSqlWhere("changeField","${changeField}") ;
			pp.setTableID("officeInfoChange");

			//修改人、修改时间、更新状态、更改内容、更改前、更改后
			pp.addColumn("修改人", "person");
			pp.addColumn("修改时间", "changeTime");
			pp.addColumn("更新状态", "changeReason");
			pp.addColumn("更改内容", "changeField");
			pp.addColumn("更改前", "beforeValue");
			pp.addColumn("更改后", "nowValue");
			
			
		
			pp.setPageSize_CH("10");
			pp.setSQL(sql);
			pp.setColumnWidth("120,130,80,140,140,50");
			pp.setOrderBy_CH("changeTime");
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
	public ModelAndView addOfficeInfoChangeTable(HttpServletRequest request,HttpServletResponse response,OfficeInfoChangeTable oict) throws IOException{
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = (String)userSession.getUserMap().get("loginid");
		System.out.println(this.getClass()+" ...>>>>>>>>> addOfficeInfoChangeTableById()   loginid = "+loginid);
		oict.setLoginid(loginid);
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			OfficeInfoChangeService oics = new OfficeInfoChangeService(conn);
			oics.addOfficeInfoChangeTable(oict);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		response.sendRedirect("officeInfoChange.do");
		return null;
	}
	
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 */
	public ModelAndView updateOfficeInfoChangeTableById(HttpServletRequest request,HttpServletResponse response,OfficeInfoChangeTable oict){
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			OfficeInfoChangeService oics = new OfficeInfoChangeService(conn);
			oics.updateOfficeInfoChangeTable(oict);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return this.index(request, response);
	}
	
	
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView deleteOfficeInfoChangeTable(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  >>>>>>>>>  deleteOfficeInfoChangeTable()...");
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			OfficeInfoChangeService oics = new OfficeInfoChangeService(conn);
			String id = request.getParameter("id");
			oics.deleteOfficeInfoChangeTable(id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		return this.index(request, response);
	}
	
	
	
	/**
	 * 编辑跳转
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 */
	public ModelAndView addAndEdit(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+  ">>>>>>>>>>>  addAndEdit() ......");
		ModelAndView model = new ModelAndView(ADDANDEDIT);
		Connection conn = null; 
		String param = StringUtil.showNull(request.getParameter("param"));
		OfficeInfoChangeTable oict = null;
		try {
			conn = new DBConnect().getConnect();
			OfficeInfoChangeService oics = new OfficeInfoChangeService(conn);
			if(param.equals("update")){
				String id = request.getParameter("id");
				oict = oics.getOfficeInfoChangeTableById(id);
				model.addObject("oict", oict);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return model;
	}
	
	
	
	/**
	 * 查看详细
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 */
	public ModelAndView view(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+  ">>>>>>>>>>>  view() ......");
		ModelAndView model = new ModelAndView(VIEW);
		String id = request.getParameter("id");
		Connection conn = null; 
		OfficeInfoChangeTable oict = null;
		try {
			conn = new DBConnect().getConnect();
			OfficeInfoChangeService oics = new OfficeInfoChangeService(conn);
			oict = oics.getOfficeInfoChangeTableById(id);
			model.addObject("oict", oict);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return model;
	}
}
