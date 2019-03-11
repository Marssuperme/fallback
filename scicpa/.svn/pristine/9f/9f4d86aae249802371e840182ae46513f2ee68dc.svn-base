package cn.org.gdicpa.web.service.conferenceRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.conferenceRecord.model.ConferenceRecordTable;
import cn.org.gdicpa.web.service.officeRecord.model.OfficeRecordTable;

public class ConferenceRecordService {
	private Connection conn = null;
	public ConferenceRecordService(Connection conn){
		this.conn = conn;
	}
	
	
	/**
	 * 根据编号得到对象的方法
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ConferenceRecordTable getConferenceRecordTableById(String id) throws Exception{
		ConferenceRecordTable crt = new ConferenceRecordTable();
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select id,loginid,outTime,beforeName,beforeType,"  
				+ " inTime,nowName,nowType,reason,register,registDate from k_conferenceRecord where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				crt.setId((rs.getString(i++)));
				crt.setLoginid(rs.getString(i++));
				crt.setOutTime(rs.getString(i++));
				crt.setBeforeName(rs.getString(i++));
				crt.setBeforeType(rs.getString(i++));
				crt.setInTime(rs.getString(i++));
				crt.setNowName(rs.getString(i++));
				crt.setNowType(rs.getString(i++));
				crt.setReason(rs.getString(i++));
				crt.setRegister(rs.getString(i++));
				crt.setRegistDate(rs.getString(i++));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return crt;
	}
	
	/**
	 * 增加
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	public boolean addConferenceRecordTable(ConferenceRecordTable crt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = "insert into k_conferenceRecord (id,loginid,outTime,beforeName,beforeType,"
				+ "inTime,nowName,nowType,reason,register,registDate)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, UUID.randomUUID().toString());
			ps.setString(i++, crt.getLoginid());
			ps.setString(i++, crt.getOutTime());
			ps.setString(i++, crt.getBeforeName());
			ps.setString(i++, crt.getBeforeType());
			ps.setString(i++, crt.getInTime());
			ps.setString(i++, crt.getNowName());
			ps.setString(i++, crt.getNowType());
			ps.setString(i++, crt.getReason());
			ps.setString(i++, crt.getRegister());
			ps.setString(i++, crt.getRegistDate());
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
	public boolean updateConferenceRecordTable(ConferenceRecordTable crt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update k_conferenceRecord set outTime=?,beforeName=?,beforeType=?,inTime=?,nowName=?,"
				+ " nowType=?,reason=?,register=?,registDate=? where id = ?" ;
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, crt.getOutTime());
			ps.setString(i++, crt.getBeforeName());
			ps.setString(i++, crt.getBeforeType());
			ps.setString(i++, crt.getInTime());
			ps.setString(i++, crt.getNowName());
			ps.setString(i++, crt.getNowType());
			ps.setString(i++, crt.getReason());
			ps.setString(i++, crt.getRegister());
			ps.setString(i++, crt.getRegistDate());
			ps.setString(i++, crt.getId());
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
	public boolean deleteConferenceRecordTable(String id) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from k_conferenceRecord where id = ?" ;
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
