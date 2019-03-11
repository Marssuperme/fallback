package cn.org.gdicpa.web.action.seat;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.org.gdicpa.web.pub.datagrid.DataGrid;
import cn.org.gdicpa.web.pub.datagrid.DataGridProperty;
import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.seat.SeatService;
import cn.org.gdicpa.web.service.seat.model.SeatTable;

public class SeatAction extends MultiActionController{
	private static final String LIST = "/seat/list.jsp";
	private static final String LISTDETAIL = "/seat/listDetail.jsp";
	private static final String PLAN = "/seat/seatPlan.jsp";
	private static final String ADDANDEDIT = "/seat/addAndEdit.jsp";
	
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(LIST);
		try {
			String sql = " select max(trainingClass) as trainingClass,max(trainingStartDate) as trainingStartDate," 
					   + " max(trainingEndDate) as trainingEndDate,max(meetingRoom) as meetingRoom " 
					   + " from m_seat " 
					   + " where 1=1 ${trainingClass} group by trainingClass ";
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.addSqlWhere("trainingClass"," and trainingClass like '%${trainingClass}%' ") ;
			
			pp.setInputType("radio");
			pp.setWhichFieldIsValue(1);
			
			pp.setTitle("培训班信息");
			
			pp.setTableID("seat");

			pp.addColumn("培训班名称", "trainingClass","showCenter");
			pp.addColumn("培训开始日期", "trainingStartDate","showCenter");
			pp.addColumn("培训室名称", "meetingRoom","showCenter");
			
			pp.setSQL(sql);
			pp.setPageSize_CH("10");
			pp.setOrderBy_CH("trainingClass");
			pp.setDirection("asc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
		return model;
	}
	
	public ModelAndView indexDetail(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(LISTDETAIL);
		try {
			String sql = " select id,cpano,cpaName,trainingClass,trainingStartDate," 
					   + " trainingEndDate,meetingRoom,seatno,orderno,propertys "
					   + " from m_seat " 
					   + " where 1=1 and cpano<>'cpa号' ${cpa} ${trainingClass} ${seatno} ";
			
			DataGridProperty pp = new DataGridProperty();
			
			pp.addSqlWhere("cpa"," and (cpano like '%${cpa}%' or cpaName like '%${cpa}%' ) ") ;
			pp.addSqlWhere("trainingClass"," and trainingClass like '%${trainingClass}%' ") ;
			pp.addSqlWhere("seatno"," and seatno like '%${seatno}%' ") ;
			
			pp.setInputType("radio");
			pp.setWhichFieldIsValue(1);
			
			pp.setTitle("座位号信息");
			
			pp.setTableID("seatDetail");

			pp.addColumn("CPA号", "cpano","showCenter");
			pp.addColumn("姓名", "cpaName","showCenter");
			pp.addColumn("培训班名称", "trainingClass","showCenter");
			pp.addColumn("培训开始日期", "trainingStartDate","showCenter");
			pp.addColumn("座位号", "seatno","showCenter");
			pp.addColumn("培训室名称", "meetingRoom","showCenter");
			
			pp.setSQL(sql);
			pp.setPageSize_CH("10");
			pp.setOrderBy_CH("orderno");
			pp.setDirection("asc");
			request.getSession().setAttribute(DataGrid.sessionPre + pp.getTableID(), pp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
		return model;
	}
	
	
	/**
	 * 编辑/查看
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView addAndEdit(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model = new ModelAndView(ADDANDEDIT);
	
		Connection conn = null; 
		String p = StringUtil.showNull(request.getParameter("p"));
		String trainingClass = StringUtil.showNull(request.getParameter("id"));
		SeatTable st = new SeatTable();
		try {
			if("update".equalsIgnoreCase(p) || "search".equalsIgnoreCase(p)){
				conn = new DBConnect().getConnect();
				SeatService ss = new SeatService(conn);
				List list = ss.getSeatTableByTraining(trainingClass);
				int rows = Integer.parseInt(((SeatTable)list.get(0)).getRows());
				int columns = Integer.parseInt(((SeatTable)list.get(0)).getColumns());
				List listRows = new ArrayList();
				for (int i = 1; i <= rows; i++) {
					List lt = new ArrayList();
					for (int j = (i-1)*columns; j < i*columns; j++) {
						lt.add(list.get(j));
					}
					listRows.add(lt);
				}
				model.addObject("list", list);
				model.addObject("listRows", listRows);
			}else{
				model = new ModelAndView(PLAN);
			}
			model.addObject("st", st);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		return model;
	}
	
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @param pt
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		String rows = request.getParameter("rows");
		String columns = request.getParameter("columns");
		String meetingRoom = request.getParameter("meetingRoom");
		String trainingClass = request.getParameter("trainingClass");
		String trainingStartDate = request.getParameter("trainingStartDate");
		String trainingEndDate = request.getParameter("trainingEndDate");
		
		String[] seatno = request.getParameterValues("seatno");
		String[] cpano = request.getParameterValues("cpano");
		String[] cpaName = request.getParameterValues("cpaName");
		
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			SeatService ss = new SeatService(conn);
			
			// 删除培训班名称的座位
			ss.delSeatTableByTrainingClass(trainingClass);
			
			for(int i=0;i<seatno.length;i++){
				SeatTable st = new SeatTable();
				String id = UUID.randomUUID().toString();
				st.setId(id);
				st.setSeatno(seatno[i]);
				st.setCpano(cpano[i]);
				st.setCpaName(cpaName[i]);
				st.setTrainingClass(trainingClass);
				st.setTrainingStartDate(trainingStartDate);
				st.setTrainingEndDate(trainingEndDate);
				st.setMeetingRoom(meetingRoom);
				st.setOrderno(i+"");
				st.setRows(rows);
				st.setColumns(columns);
				
				// 添加
				ss.addSeatTable(st);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		response.sendRedirect("seat.do?method=index");
		return null;
	}
	
	
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ModelAndView delete(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String trainingClass = request.getParameter("id");
		Connection conn = null;
		try {
			conn = new DBConnect().getConnect();
			SeatService ss = new SeatService(conn);
			// 删除培训班名称的座位
			ss.delSeatTableByTrainingClass(trainingClass);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbUtil.close(conn);
		}
		
		response.sendRedirect("seat.do?method=index");
		return null;
	}
}
