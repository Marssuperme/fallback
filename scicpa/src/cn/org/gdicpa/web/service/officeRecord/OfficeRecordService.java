package cn.org.gdicpa.web.service.officeRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.officeRecord.model.OfficeRecordTable;

public class OfficeRecordService {
	private Connection conn = null;
	public OfficeRecordService(Connection conn){
		this.conn = conn;
	}
	
	
	/**
	 * 根据编号得到对象的方法
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public OfficeRecordTable getOfficeRecordTableById(String id) throws Exception{
		OfficeRecordTable ort = new OfficeRecordTable();
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select id,loginid,outTime,beforeName,beforeChair,"  
				+ " inTime,nowName,nowChair,reason,register,registDate from k_officeRecord where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				ort.setId((rs.getString(i++)));
				ort.setLoginid(rs.getString(i++));
				ort.setOutTime(rs.getString(i++));
				ort.setBeforeName(rs.getString(i++));
				ort.setBeforeChair(rs.getString(i++));
				ort.setInTime(rs.getString(i++));
				ort.setNowName(rs.getString(i++));
				ort.setNowChair(rs.getString(i++));
				ort.setReason(rs.getString(i++));
				ort.setRegister(rs.getString(i++));
				ort.setRegistDate(rs.getString(i++));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return ort;
	}
	
	/**
	 * 增加
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	public boolean addOfficeRecordTable(OfficeRecordTable ort) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into k_officeRecord(id,loginid,outTime,beforeName,beforeChair,inTime,nowName,"
				+ " nowChair,reason,register,registDate)" 
				+ " values(?,?,?,?,?,?,?,?,?,?,?);";
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, UUID.randomUUID().toString());
			ps.setString(i++, ort.getLoginid());
			ps.setString(i++, ort.getOutTime());
			ps.setString(i++, ort.getBeforeName());
			ps.setString(i++, ort.getBeforeChair());
			ps.setString(i++, ort.getInTime());
			ps.setString(i++, ort.getNowName());
			ps.setString(i++, ort.getNowChair());
			ps.setString(i++, ort.getReason());
			ps.setString(i++, ort.getRegister());
			ps.setString(i++, ort.getRegistDate());
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
	public boolean updateOfficeRecordTable(OfficeRecordTable ort) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update k_officeRecord set outTime=?,beforeName=?,beforeChair=?,inTime=?,nowName=?,"
				+ " nowChair=?,reason=?,register=?,registDate=? where id = ?" ;
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, ort.getOutTime());
			ps.setString(i++, ort.getBeforeName());
			ps.setString(i++, ort.getBeforeChair());
			ps.setString(i++, ort.getInTime());
			ps.setString(i++, ort.getNowName());
			ps.setString(i++, ort.getNowChair());
			ps.setString(i++, ort.getReason());
			ps.setString(i++, ort.getRegister());
			ps.setString(i++, ort.getRegistDate());
			ps.setString(i++, ort.getId());
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
	public boolean deleteOfficeRecordTable(String id) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from k_officeRecord where id = ?" ;
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
