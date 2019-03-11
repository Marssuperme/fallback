package cn.org.gdicpa.web.action.personInfoChange;

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
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.personInfoChange.PersonInfoChangeService;
import cn.org.gdicpa.web.service.personInfoChange.model.PersonInfoChangeTable;

public class PersonInfoChangeAction extends MultiActionController{
	private static final String LIST = "/personInfoChange/list.jsp";
	private static final String ADDANDEDIT = "/personInfoChange/addAndEdit.jsp";
	private static final String VIEW = "/personInfoChange/view.jsp";
	
	
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  >>>>>>>>>>>>      index(HttpServletRequest request,HttpServletResponse response) ...............");
		ModelAndView model = new ModelAndView(LIST);
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = (String)userSession.getUserMap().get("loginid");
		try {
			String sql = "select * from k_personInfoChange where loginid = '"+loginid+"'  ${changeTime} ${changeField} ";
			
			DataGridProperty pp = new DataGridProperty() {
				public void onSearch(HttpSession session,HttpServletRequest request,
						HttpServletResponse response) throws Exception {
					String changeTime1 = getRequestValue("changeTime1") ;
					String changeTime2 = getRequestValue("changeTime2") ;
					String changeField = getRequestValue("changeField") ;
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
			
			pp.setTitle("个人信息变动经历");
			
			pp.addInputValue("changeTime1");
			pp.addInputValue("changeTime2");
			
			pp.addSqlWhere("changeTime","${changeTime}") ;
			pp.addSqlWhere("changeField","${changeField}") ;
			pp.setTableID("personInfoChange");

			//pp.setInputType("radio");
			//pp.setWhichFieldIsValue(1);
			
			//pp.setPrintColumnWidth("20,20,20");
			
//			pp.addColumn("变动人", "person");
			pp.addColumn("变动时间", "changeTime");
			
			
			pp.addColumn("变动内容", "changeField");
			pp.addColumn("原来值", "beforeValue");
			pp.addColumn("现在值", "nowValue");
			pp.addColumn("变动结果", "changeReason");
			pp.addColumn("操作人", "person");
			
//			pp.addColumn("审批人", "approvePerson");
//			pp.addColumn("审批时间", "approveTime");
//			pp.addColumn("备注", "remark");
		
			pp.setSQL(sql);
			pp.setPageSize_CH("10");
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
	public ModelAndView addPersonInfoChangeTable(HttpServletRequest request,HttpServletResponse response,PersonInfoChangeTable pict) throws IOException{
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = (String)userSession.getUserMap().get("loginid");
		String ctypetabname = (String)userSession.getUserMap().get("ctypetabname");
		System.out.println(this.getClass()+" ...>>>>>>>>> addPersonInfoChangeTableTableById()   loginid = "+loginid);
		pict.setLoginid(loginid);
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			PersonInfoChangeService pics = new PersonInfoChangeService(conn);
			pict.setTableName(ctypetabname);
			pics.addPersonInfoChangeTable(pict);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		response.sendRedirect("personInfoChange.do");
		return null;
	}
	
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 */
	public ModelAndView updatePersonInfoChangeTableById(HttpServletRequest request,HttpServletResponse response,PersonInfoChangeTable pict){
		Connection conn = null;
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String ctypetabname = (String)userSession.getUserMap().get("ctypetabname");
		try {
			conn = new DBConnect().getConnect();
			PersonInfoChangeService pics = new PersonInfoChangeService(conn);
			pict.setTableName(ctypetabname);
			pics.updatePersonInfoChangeTable(pict);
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
	public ModelAndView deletePersonInfoChangeTable(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  >>>>>>>>>  deletePersonInfoChangeTable()...");
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			PersonInfoChangeService pics = new PersonInfoChangeService(conn);
			String id = request.getParameter("id");
			pics.deletePersonInfoChangeTable(id);
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
		PersonInfoChangeTable pict = null;
		try {
			conn = new DBConnect().getConnect();
			PersonInfoChangeService pics = new PersonInfoChangeService(conn);
			if(param.equals("update")){
				String id = request.getParameter("id");
				pict = pics.getPersonInfoChangeTableById(id);
				model.addObject("pict", pict);
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
		System.out.println(this.getClass()+  ">>>>>>>>>>>  addAndEdit() ......");
		ModelAndView model = new ModelAndView(VIEW);
		Connection conn = null; 
		String id = request.getParameter("id");
		PersonInfoChangeTable pict = null;
		try {
			conn = new DBConnect().getConnect();
			PersonInfoChangeService pics = new PersonInfoChangeService(conn);
			pict = pics.getPersonInfoChangeTableById(id);
			model.addObject("pict", pict);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return model;
	}
}
