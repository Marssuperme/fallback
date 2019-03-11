package cn.org.gdicpa.web.action.trainRecord;

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
import cn.org.gdicpa.web.service.trainRecord.TrainRecordService;
import cn.org.gdicpa.web.service.trainRecord.model.TrainRecordTable;

public class TrainRecordAction extends MultiActionController{
	private static final String LIST = "/trainRecord/list.jsp";
	private static final String ADDANDEDIT = "/trainRecord/addAndEdit.jsp";
	private static final String VIEW = "/trainRecord/view.jsp";
	
	
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  >>>>>>>>>>>>      index(HttpServletRequest request,HttpServletResponse response) ...............");
		ModelAndView model = new ModelAndView(LIST);
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = (String)userSession.getUserMap().get("loginid");
		try {
			String sql = "select * from k_trainRecord where 1=1 and loginid = '"+loginid+"'  ${startTime} ${endTime}";
			
			DataGridProperty pp = new DataGridProperty() {
				public void onSearch(HttpSession session,HttpServletRequest request,
						HttpServletResponse response) throws Exception {
					String startTime = getRequestValue("startTime") ;
					String endTime = getRequestValue("endTime") ;
					if(startTime == null || "".equals(startTime)) {
						startTime = "" ;
					}else {
						startTime = " and startTime= '"+startTime+"'";
					}
					if(endTime == null || "".equals(endTime)) {
						endTime = "" ;
					}else {
						endTime = " and endTime= '"+endTime+"'";
					}
					this.setOrAddRequestValue("startTime", startTime);
					this.setOrAddRequestValue("endTime", endTime);
				}
			};
			pp.addSqlWhere("startTime","${startTime}") ;
			pp.addSqlWhere("endTime","${endTime}") ;
			pp.setInputType("radio");
			pp.setTableID("trainRecord");
			pp.setWhichFieldIsValue(1);
			//pp.setPrintColumnWidth("20,20,20");
			
			pp.addColumn("培训师", "trainTeacher");
			pp.addColumn("开始培训时间", "startTime");
			pp.addColumn("结束时间", "endTime");
			
			pp.addColumn("培训地点", "trainPlace");
			pp.addColumn("培训内容", "trainContent");
			pp.addColumn("学时", "classHour");
			
			pp.addColumn("培训方式", "trainWay");
			pp.addColumn("备注", "remark");
		
			pp.setSQL(sql);
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
	public ModelAndView addTrainRecordTable(HttpServletRequest request,HttpServletResponse response,TrainRecordTable trt) throws IOException{
		UserSession userSession = (UserSession)request.getSession().getAttribute("userSession");
		String loginid = (String)userSession.getUserMap().get("loginid");
		System.out.println(this.getClass()+" ...>>>>>>>>> addTrainRecordTableById()   loginid = "+loginid);
		trt.setLoginid(loginid);
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			TrainRecordService crs = new TrainRecordService(conn);
			crs.addTrainRecordTable(trt);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		response.sendRedirect("trainRecord.do");
		return null;
	}
	
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param ort
	 * @return
	 */
	public ModelAndView updateTrainRecordTableById(HttpServletRequest request,HttpServletResponse response,TrainRecordTable trt){
		Connection conn = null; 
		try {
			conn = new DBConnect().getConnect();
			TrainRecordService trs = new TrainRecordService(conn);
			trs.updateTrainRecordTable(trt);
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
	public ModelAndView deleteTrainRecordTable(HttpServletRequest request,HttpServletResponse response){
		System.out.println(this.getClass()+"  >>>>>>>>>  deleteTrainRecordTable()...");
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			TrainRecordService trs = new TrainRecordService(conn);
			String id = request.getParameter("id");
			trs.deleteTrainRecordTable(id);
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
		TrainRecordTable trt = null;
		try {
			conn = new DBConnect().getConnect();
			TrainRecordService trs = new TrainRecordService(conn);
			if(param.equals("update")){
				String id = request.getParameter("id");
				trt = trs.getTrainRecordTableById(id);
				model.addObject("trt", trt);
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
		TrainRecordTable trt = null;
		try {
			conn = new DBConnect().getConnect();
			TrainRecordService trs = new TrainRecordService(conn);
			trt = trs.getTrainRecordTableById(id);
			model.addObject("trt", trt);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		return model;
	}
}
