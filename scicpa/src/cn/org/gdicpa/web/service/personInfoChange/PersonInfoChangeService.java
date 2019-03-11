package cn.org.gdicpa.web.service.personInfoChange;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.conferenceRecord.model.ConferenceRecordTable;
import cn.org.gdicpa.web.service.personInfoChange.model.PersonInfoChangeTable;

public class PersonInfoChangeService {
	private Connection conn = null;
	public PersonInfoChangeService(Connection conn){
		this.conn = conn;
	}
	
	
	/**
	 * 根据编号得到对象的方法
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PersonInfoChangeTable getPersonInfoChangeTableById(String id) throws Exception{
		PersonInfoChangeTable pict = new PersonInfoChangeTable();
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select id,tablename,loginid,person,changeTime,changeReason,changeField,beforeValue,nowValue,"
				+ " approvePerson,approveTime,remark from k_personInfoChange where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				pict.setId((rs.getString(i++)));
				pict.setTableName(rs.getString(i++));
				pict.setLoginid(rs.getString(i++));
				pict.setPerson(rs.getString(i++));
				pict.setChangeTime(rs.getString(i++));
				pict.setChangeReason(rs.getString(i++));
				pict.setChangeField(rs.getString(i++));
				pict.setBeforeValue(rs.getString(i++));
				pict.setNowValue(rs.getString(i++));
				pict.setApprovePerson(rs.getString(i++));
				pict.setApproveTime(rs.getString(i++));
				pict.setRemark(rs.getString(i++));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return pict;
	}
	
	/**
	 * 增加
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	public boolean addPersonInfoChangeTable(PersonInfoChangeTable pict) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = "insert into k_personInfoChange (id,tablename,loginid,person,changeTime,changeReason,"
				+ "changeField,beforeValue,nowValue,approvePerson,approveTime,remark) "
				+ "values(?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, UUID.randomUUID().toString());
			ps.setString(i++, pict.getTableName());
			ps.setString(i++, pict.getLoginid());
			ps.setString(i++, pict.getPerson());
			ps.setString(i++, pict.getChangeTime());
			ps.setString(i++, pict.getChangeReason());
			ps.setString(i++, pict.getChangeField());
			ps.setString(i++, pict.getBeforeValue());
			ps.setString(i++, pict.getNowValue());
			ps.setString(i++, pict.getApprovePerson());
			ps.setString(i++, pict.getApproveTime());
			ps.setString(i++, pict.getRemark());
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
	public boolean updatePersonInfoChangeTable(PersonInfoChangeTable pict) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update k_personInfoChange set tablename=?,loginid=?,person=?,changeTime=?,changeReason=?,"
				+ " changeField=?,beforeValue=?,nowValue=?,approvePerson=?,approveTime=?,remark=? where id = ?" ;
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, pict.getTableName());
			ps.setString(i++, pict.getLoginid());
			ps.setString(i++, pict.getPerson());
			ps.setString(i++, pict.getChangeTime());
			ps.setString(i++, pict.getChangeReason());
			ps.setString(i++, pict.getChangeField());
			ps.setString(i++, pict.getBeforeValue());
			ps.setString(i++, pict.getNowValue());
			ps.setString(i++, pict.getApprovePerson());
			ps.setString(i++, pict.getApproveTime());
			ps.setString(i++, pict.getRemark());
			ps.setString(i++, pict.getId());
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
	public boolean deletePersonInfoChangeTable(String id) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from k_personInfoChange where id = ?" ;
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
