package cn.org.gdicpa.web.service.trainRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.conferenceRecord.model.ConferenceRecordTable;
import cn.org.gdicpa.web.service.trainRecord.model.TrainRecordTable;

public class TrainRecordService {
	private Connection conn = null;
	public TrainRecordService(Connection conn){
		this.conn = conn;
	}
	
	
	/**
	 * 根据编号得到对象的方法
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public TrainRecordTable getTrainRecordTableById(String id) throws Exception{
		TrainRecordTable trt = new TrainRecordTable();
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select id,loginid,startTime,endTime,trainPlace,trainContent,"  
				+ " trainTeacher,remark,classHour,trainWay from k_trainRecord where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				trt.setId((rs.getString(i++)));
				trt.setLoginid(rs.getString(i++));
				trt.setStartTime(rs.getString(i++));
				trt.setEndTime(rs.getString(i++));
				trt.setTrainPlace(rs.getString(i++));
				trt.setTrainContent(rs.getString(i++));
				trt.setTrainTeacher(rs.getString(i++));
				trt.setRemark(rs.getString(i++));
				trt.setClassHour(rs.getString(i++));
				trt.setTrainWay(rs.getString(i++));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return trt;
	}
	
	/**
	 * 增加
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	public boolean addTrainRecordTable(TrainRecordTable trt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = "insert into k_trainRecord (loginid,startTime,endTime,trainPlace,trainContent,"
				+ "trainTeacher,remark,classHour,trainWay) "
				+ "values(?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, trt.getLoginid());
			ps.setString(i++, trt.getStartTime());
			ps.setString(i++, trt.getEndTime());
			ps.setString(i++, trt.getTrainPlace());
			ps.setString(i++, trt.getTrainContent());
			ps.setString(i++, trt.getTrainTeacher());
			ps.setString(i++, trt.getRemark());
			ps.setString(i++, trt.getClassHour());
			ps.setString(i++, trt.getTrainWay());
			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		return false;
	}
	
	
	/**
	 * 修改
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	public boolean updateTrainRecordTable(TrainRecordTable trt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update k_trainRecord set loginid=?,startTime=?,endTime=?,trainPlace=?,trainContent=?,"
				+ " trainTeacher=?,remark=?,classHour=?,trainWay=? where id = ?" ;
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, trt.getLoginid());
			ps.setString(i++, trt.getStartTime());
			ps.setString(i++, trt.getEndTime());
			ps.setString(i++, trt.getTrainPlace());
			ps.setString(i++, trt.getTrainContent());
			ps.setString(i++, trt.getTrainTeacher());
			ps.setString(i++, trt.getRemark());
			ps.setString(i++, trt.getClassHour());
			ps.setString(i++, trt.getTrainWay());
			ps.setString(i++, trt.getId());
			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		return false;
	}
	
	
	/**
	 * 删除
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	public boolean deleteTrainRecordTable(String id) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from k_trainRecord where id = ?" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,id);
			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		return false;
	}
}
