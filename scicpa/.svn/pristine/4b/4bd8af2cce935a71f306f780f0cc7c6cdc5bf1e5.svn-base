package cn.org.gdicpa.web.service.seat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.seat.model.SeatTable;

public class SeatService {

	private Connection conn = null ;
		
	public SeatService(Connection conn){
		this.conn = conn;
	}
		
		
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public SeatTable getSeatTable(String id) {
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		SeatTable st = new SeatTable();
		try {
			String sql = " select id,cpano,cpaName,trainingClass,trainingStartDate, " 
					   + " trainingEndDate,meetingRoom,seatno,orderno,rows, "
					   + " columns,propertys "
					   + " from m_seat where id=? order by orderno ";
			ps = conn.prepareStatement(sql) ;
			ps.setString(1, id) ;
			rs = ps.executeQuery() ;
			if(rs.next()) {
				st.setId(rs.getString("id"));
				st.setCpano(rs.getString("cpano"));
				st.setCpaName(rs.getString("cpaName"));
				st.setTrainingClass(rs.getString("trainingClass"));
				st.setTrainingStartDate(rs.getString("trainingStartDate"));
				
				st.setTrainingEndDate(rs.getString("trainingEndDate"));
				st.setMeetingRoom(rs.getString("meetingRoom"));
				st.setSeatno(rs.getString("seatno"));
				st.setOrderno(rs.getString("orderno"));
				st.setRows(rs.getString("rows"));
				
				st.setColumns(rs.getString("columns"));
				st.setPropertys(rs.getString("propertys"));
			}
			return st ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
		return st;
	}
	
	/**
	 * 根据seatno查询
	 * @param seatno
	 * @return
	 */
	public List getSeatTableBySeatno(String seatno) {
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		List list = new ArrayList();
		try {
			String sql = " select id,cpano,cpaName,trainingClass,trainingStartDate, " 
					   + " trainingEndDate,meetingRoom,seatno,orderno,rows, "
					   + " columns,propertys "
					   + " from m_seat where seatno=? order by orderno ";
			ps = conn.prepareStatement(sql) ;
			ps.setString(1, seatno) ;
			rs = ps.executeQuery() ;
			while(rs.next()) {
				
				SeatTable st = new SeatTable();
				
				st.setId(rs.getString("id"));
				st.setCpano(rs.getString("cpano"));
				st.setCpaName(rs.getString("cpaName"));
				st.setTrainingClass(rs.getString("trainingClass"));
				st.setTrainingStartDate(rs.getString("trainingStartDate"));
				
				st.setTrainingEndDate(rs.getString("trainingEndDate"));
				st.setMeetingRoom(rs.getString("meetingRoom"));
				st.setSeatno(rs.getString("seatno"));
				st.setOrderno(rs.getString("orderno"));
				st.setRows(rs.getString("rows"));
				
				st.setColumns(rs.getString("columns"));
				st.setPropertys(rs.getString("propertys"));
				
				list.add(st);
			}
			return list ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
		return list;
	}
	
	
	/**
	 * 根据培训班名称查询
	 * @param trainingClass
	 * @return
	 */
	public List getSeatTableByTraining(String trainingClass) {
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		List<SeatTable> list = new ArrayList<SeatTable>();
		try {
			String sql = " select id,cpano,cpaName,trainingClass,trainingStartDate, " 
					   + " trainingEndDate,meetingRoom,seatno,orderno,rows, "
					   + " columns,propertys "
					   + " from m_seat where trainingClass=? order by orderno ";
			ps = conn.prepareStatement(sql) ;
			ps.setString(1, trainingClass) ;
			rs = ps.executeQuery() ;
			while(rs.next()) {
				
				SeatTable st = new SeatTable();
				
				st.setId(rs.getString("id"));
				st.setCpano(rs.getString("cpano"));
				st.setCpaName(rs.getString("cpaName"));
				st.setTrainingClass(rs.getString("trainingClass"));
				st.setTrainingStartDate(rs.getString("trainingStartDate"));
				
				st.setTrainingEndDate(rs.getString("trainingEndDate"));
				st.setMeetingRoom(rs.getString("meetingRoom"));
				st.setSeatno(rs.getString("seatno"));
				st.setOrderno(rs.getString("orderno"));
				st.setRows(rs.getString("rows"));
				
				st.setColumns(rs.getString("columns"));
				st.setPropertys(rs.getString("propertys"));
				
				list.add(st);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
		return list;
	}
	
	/**
	 * 根据cpa查询
	 * @param trainingClass
	 * @return
	 */
	public List getSeatTableByCpa(String cpa) {
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		List list = new ArrayList();
		try {
			String sql = " select id,cpano,cpaName,trainingClass,trainingStartDate, " 
					   + " trainingEndDate,meetingRoom,seatno,orderno,rows, "
					   + " columns,propertys "
					   + " from m_seat where cpano=? or cpaname=? order by orderno ";
			ps = conn.prepareStatement(sql) ;
			ps.setString(1, cpa) ;
			ps.setString(2, cpa) ;
			rs = ps.executeQuery() ;
			while(rs.next()) {
				
				SeatTable st = new SeatTable();
				
				st.setId(rs.getString("id"));
				st.setCpano(rs.getString("cpano"));
				st.setCpaName(rs.getString("cpaName"));
				st.setTrainingClass(rs.getString("trainingClass"));
				st.setTrainingStartDate(rs.getString("trainingStartDate"));
				
				st.setTrainingEndDate(rs.getString("trainingEndDate"));
				st.setMeetingRoom(rs.getString("meetingRoom"));
				st.setSeatno(rs.getString("seatno"));
				st.setOrderno(rs.getString("orderno"));
				st.setRows(rs.getString("rows"));
				
				st.setColumns(rs.getString("columns"));
				st.setPropertys(rs.getString("propertys"));
				
				list.add(st);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
		return list;
	}
	
	/**
	 * 添加
	 * @param pt
	 */
	public boolean addSeatTable(SeatTable st) {
		boolean bl = true;
		PreparedStatement ps = null ;
		try {
			String sql = " insert into m_seat(id,cpano,cpaName,trainingClass,trainingStartDate," 
					   + " trainingEndDate,meetingRoom,seatno,orderno,rows," 
					   + " columns,propertys) " 
					   + " values(?,?,?,?,?, ?,?,?,?,?, ?,?)";
			int i = 1;
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(i++,st.getId());
			ps.setString(i++,st.getCpano());
			ps.setString(i++,st.getCpaName());
			ps.setString(i++,st.getTrainingClass());
			ps.setString(i++,st.getTrainingStartDate());
			
			ps.setString(i++,st.getTrainingEndDate());
			ps.setString(i++,st.getMeetingRoom());
			ps.setString(i++,st.getSeatno());
			ps.setString(i++,st.getOrderno());
			ps.setString(i++,st.getRows());
			
			ps.setString(i++,st.getColumns());
			ps.setString(i++,st.getPropertys());
			
			ps.execute();
			
		}catch(Exception e) {
			bl = false;
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
		
		return bl;
	}
	
	
	/**
	 * 修改
	 * @param pt
	 */
	public boolean updateSeatTable(SeatTable st) {
		boolean bl = true;
		PreparedStatement ps = null ;
		try {
			String sql = " update m_seat set cpano=?,cpaName=?,trainingClass=?,trainingStartDate=?,trainingEndDate=?," 
					   + " meetingRoom=?,seatno=?,orderno=?,rows=?,columns=? " 
					   + " where id = ? ";
			
			ps = conn.prepareStatement(sql);
			
			int i = 1;
			
			ps.setString(i++,st.getCpano());
			ps.setString(i++,st.getCpaName());
			ps.setString(i++,st.getTrainingClass());
			ps.setString(i++,st.getTrainingStartDate());
			ps.setString(i++,st.getTrainingEndDate());
			
			ps.setString(i++,st.getMeetingRoom());
			ps.setString(i++,st.getSeatno());
			ps.setString(i++,st.getOrderno());
			ps.setString(i++,st.getRows());
			ps.setString(i++,st.getColumns());
			
			ps.setString(i++,st.getId());
			
			ps.execute();
			
		}catch(Exception e) {
			bl = false;
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
		return bl;
	}
	
	/**
	 * 删除
	 * @param id
	 */
	public void delSeatTable(String id) {
		PreparedStatement ps = null ;
		try {
			String sql = " delete from m_seat where id=? ";
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,id) ;
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
	}
	
	/**
	 * 删除
	 * @param trainingClass
	 */
	public void delSeatTableByTrainingClass(String trainingClass) {
		PreparedStatement ps = null ;
		try {
			String sql = " delete from m_seat where trainingClass=? ";
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,trainingClass) ;
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
	}
	
	/**
	 * 删除
	 * @param seatno
	 */
	public void delSeatTableBySeatno(String seatno) {
		PreparedStatement ps = null ;
		try {
			String sql = " delete from m_seat where seatno=? ";
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,seatno) ;
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
	}
	
	/**
	 * 删除
	 * @param cpa
	 */
	public void delSeatTableByCpa(String cpa) {
		PreparedStatement ps = null ;
		try {
			String sql = " delete from m_seat where cpano=? or cpaname=? ";
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,cpa) ;
			ps.setString(2,cpa) ;
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
	}
}
