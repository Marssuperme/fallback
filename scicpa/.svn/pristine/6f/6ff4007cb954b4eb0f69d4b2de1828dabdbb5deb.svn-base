package cn.org.gdicpa.web.action.officeRecord;

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
import cn.org.gdicpa.web.service.officeRecord.OfficeRecordService;
import cn.org.gdicpa.web.service.officeRecord.model.OfficeRecordTable;

public class OfficeRecordAction extends MultiActionController{
	private static final String LIST = "/officeRecord/list.jsp";
	private static final String ADDANDEDIT = "/officeRecord/addAndEdit.jsp";
	private static final String VIEW = "/officeRecord/view.jsp";
	
	
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  >>>>>>>>>>>>      index(HttpServletRequest request,HttpServletResponse response) ...............");
		ModelAndView model = new ModelAndView(LIST);
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = (String)userSession.getUserMap().get("loginid");
		try {
			String sql = " select id,substring(outTime,1,10) as outTime,nowName,inTime,beforeName " 
					   + " from k_officeRecord where 1=1 and loginid = '"+loginid+"'  ${outTime} ";
			
			DataGridProperty pp = new DataGridProperty() {
				public void onSearch(HttpSession session,HttpServletRequest request,
						HttpServletResponse response) throws Exception {
					String outTime1 = getRequestValue("outTime1") ;
					String outTime2 = getRequestValue("outTime2") ;
					String outTime = "";
					
					if(outTime1!=null && !"".equals(outTime1) && outTime2!=null && !"".equals(outTime2)){
						outTime = "  and ( outTime between '"+outTime1+"' and '"+outTime2+" 24:00:00' ) ";
					}else{
						if(outTime1!=null && !"".equals(outTime1)){
							outTime = "  and substring(outTime,1,10) = '"+outTime1+"'";
						}
						if(outTime2!=null && !"".equals(outTime2)){
							outTime = "  and substring(outTime,1,10) = '"+outTime2+"'";
						}
					}
					this.setOrAddRequestValue("outTime", outTime);
				}
			};
			
			pp.setTitle("转所经历信息");
			
			pp.addInputValue("outTime1");
			pp.addInputValue("outTime2");
			
			pp.addSqlWhere("outTime","${outTime}") ;
			pp.setTableID("officeRecord");

			pp.addColumn("转所时间", "outTime","showCenter");
			pp.addColumn("转入所", "nowName","showCenter");
			pp.addColumn("转入时间", "inTime","showCenter");
			pp.addColumn("转出所", "beforeName","showCenter");
			pp.addColumn("转出时间", "outTime","showCenter");
		
			pp.setSQL(sql);
			pp.setColumnWidth("120,110,80,110,80");
			pp.setPageSize_CH("10");
			pp.setOrderBy_CH("id");
			pp.setDirection("asc");
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
	public ModelAndView addOfficeRecordTable(HttpServletRequest request,HttpServletResponse response,OfficeRecordTable ort) throws IOException{
		ModelAndView model = new ModelAndView();
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = (String)userSession.getUserMap().get("loginid");
		System.out.println(this.getClass()+" ...。。。。。。>>>>>>>>> addOfficeRecordTableById()   loginid = "+loginid);
		ort.setLoginid(loginid);
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			OfficeRecordService ors = new OfficeRecordService(conn);
			ors.addOfficeRecordTable(ort);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		response.sendRedirect("officeRecord.do");
		return null;
	}
	
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 */
	public ModelAndView updateOfficeRecordTableById(HttpServletRequest request,HttpServletResponse response,OfficeRecordTable ort){
		ModelAndView model = new ModelAndView();
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			OfficeRecordService ors = new OfficeRecordService(conn);
			ors.updateOfficeRecordTable(ort);
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
	public ModelAndView deleteOfficeRecordTable(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  >>>>>>>>>  deleteOfficeRecordTable()...");
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			OfficeRecordService ors = new OfficeRecordService(conn);
			String id = request.getParameter("id");
			ors.deleteOfficeRecordTable(id);
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
		OfficeRecordTable officeRecordTable = null;
		try {
			conn = new DBConnect().getConnect();
			OfficeRecordService ors = new OfficeRecordService(conn);
			if(param.equals("update")){
				String id = request.getParameter("id");
				officeRecordTable = ors.getOfficeRecordTableById(id);
				model.addObject("officeRecordTable", officeRecordTable);
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
		Connection conn = null; 
		String id = request.getParameter("id");
		OfficeRecordTable officeRecordTable = null;
		try {
			conn = new DBConnect().getConnect();
			OfficeRecordService ors = new OfficeRecordService(conn);
			officeRecordTable = ors.getOfficeRecordTableById(id);
			model.addObject("officeRecordTable", officeRecordTable);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return model;
	}
	
}
