package cn.org.gdicpa.web.action.conferenceRecord;

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
import cn.org.gdicpa.web.service.conferenceRecord.ConferenceRecordService;
import cn.org.gdicpa.web.service.conferenceRecord.model.ConferenceRecordTable;

public class ConferenceRecordAction extends MultiActionController{
	private static final String LIST = "/conferenceRecord/list.jsp";
	private static final String ADDANDEDIT = "/conferenceRecord/addAndEdit.jsp";
	private static final String VIEW = "/conferenceRecord/view.jsp";
	
	
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  >>>>>>>>>>>>      index(HttpServletRequest request,HttpServletResponse response) ...............");
		ModelAndView model = new ModelAndView(LIST);
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = (String)userSession.getUserMap().get("loginid");
		try {
			String sql = "select * from k_conferenceRecord where loginid = '"+loginid+"'  ${outTime} ";
			
			DataGridProperty pp = new DataGridProperty() {
				public void onSearch(HttpSession session,HttpServletRequest request,
						HttpServletResponse response) throws Exception {
					String outTime1 = getRequestValue("outTime1") ;
					String outTime2 = getRequestValue("outTime2") ;
					String outTime = "" ;
					
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
			
			pp.setTitle("转会经历信息");
			
			pp.addInputValue("outTime1");
			pp.addInputValue("outTime2");
			
			pp.addSqlWhere("outTime","${outTime}") ;
			pp.setTableID("conferenceRecord");

			pp.addInputValue("inTime");
			
			pp.addColumn("转会时间", "outTime");
			pp.addColumn("离会时间", "outTime");
			pp.addColumn("之前会名称", "beforeName");
			
			pp.addColumn("进会时间", "inTime");
			pp.addColumn("现在会名称", "nowName");
			
		
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
	public ModelAndView addConferenceRecordTable(HttpServletRequest request,HttpServletResponse response,ConferenceRecordTable crt) throws IOException{
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = (String)userSession.getUserMap().get("loginid");
		System.out.println(this.getClass()+" ...>>>>>>>>> addConferenceRecordTableById()   loginid = "+loginid);
		crt.setLoginid(loginid);
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			ConferenceRecordService crs = new ConferenceRecordService(conn);
			crs.addConferenceRecordTable(crt);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		response.sendRedirect("conferenceRecord.do");
		return null;
	}
	
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 */
	public ModelAndView updateConferenceRecordTableById(HttpServletRequest request,HttpServletResponse response,ConferenceRecordTable crt){
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			ConferenceRecordService crs = new ConferenceRecordService(conn);
			System.out.println(this.getClass()+"   >>>>>>  crt.updateConferenceRecordTableById"+crt.getBeforeType()+"    "+crt.getNowType());
			crs.updateConferenceRecordTable(crt);
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
	public ModelAndView deleteConferenceRecordTable(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  >>>>>>>>>  deleteConferenceRecordTable()...");
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			ConferenceRecordService crs = new ConferenceRecordService(conn);
			String id = request.getParameter("id");
			crs.deleteConferenceRecordTable(id);
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
		ConferenceRecordTable crt = null;
		try {
			conn = new DBConnect().getConnect();
			ConferenceRecordService ors = new ConferenceRecordService(conn);
			if(param.equals("update")){
				String id = request.getParameter("id");
				crt = ors.getConferenceRecordTableById(id);
				model.addObject("crt", crt);
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
		ConferenceRecordTable crt = null;
		try {
			conn = new DBConnect().getConnect();
			ConferenceRecordService ors = new ConferenceRecordService(conn);
			crt = ors.getConferenceRecordTableById(id);
			model.addObject("crt", crt);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return model;
	}
			
	
	
}
