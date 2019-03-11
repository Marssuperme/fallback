package cn.org.gdicpa.web.service.officeInfoChange;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.officeInfoChange.model.OfficeInfoChangeTable;

public class OfficeInfoChangeService {
	private Connection conn = null;
	public OfficeInfoChangeService(Connection conn){
		this.conn = conn;
	}
	
	
	/**
	 * 根据编号得到对象的方法
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public OfficeInfoChangeTable getOfficeInfoChangeTableById(String id) throws Exception{
		OfficeInfoChangeTable oict = new OfficeInfoChangeTable();
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select id,loginid,officeName,changeTime,changeReason,changeField,beforeValue,nowValue,"
				+ " approvePerson,approveTime,remark from k_officeInfoChange where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				oict.setId((rs.getString(i++)));
				oict.setLoginid(rs.getString(i++));
				oict.setOfficeName(rs.getString(i++));
				oict.setChangeTime(rs.getString(i++));
				oict.setChangeReason(rs.getString(i++));
				oict.setChangeField(rs.getString(i++));
				oict.setBeforeValue(rs.getString(i++));
				oict.setNowValue(rs.getString(i++));
				oict.setApprovePerson(rs.getString(i++));
				oict.setApproveTime(rs.getString(i++));
				oict.setRemark(rs.getString(i++));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return oict;
	}
	
	/**
	 * 增加
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	public boolean addOfficeInfoChangeTable(OfficeInfoChangeTable oict) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = "insert into k_officeInfoChange (loginid,officeName,changeTime,changeReason,"
				+ "changeField,beforeValue,nowValue,approvePerson,approveTime,remark) "
				+ "values(?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, oict.getLoginid());
			ps.setString(i++, oict.getOfficeName());
			ps.setString(i++, oict.getChangeTime());
			ps.setString(i++, oict.getChangeReason());
			ps.setString(i++, oict.getChangeField());
			ps.setString(i++, oict.getBeforeValue());
			ps.setString(i++, oict.getNowValue());
			ps.setString(i++, oict.getApprovePerson());
			ps.setString(i++, oict.getApproveTime());
			ps.setString(i++, oict.getRemark());
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
	public boolean updateOfficeInfoChangeTable(OfficeInfoChangeTable oict) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update k_officeInfoChange set officeName=?,changeTime=?,changeReason=?,"
				+ " changeField=?,beforeValue=?,nowValue=?,approvePerson=?,approveTime=?,remark=? where id = ?" ;
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, oict.getOfficeName());
			ps.setString(i++, oict.getChangeTime());
			ps.setString(i++, oict.getChangeReason());
			ps.setString(i++, oict.getChangeField());
			ps.setString(i++, oict.getBeforeValue());
			ps.setString(i++, oict.getNowValue());
			ps.setString(i++, oict.getApprovePerson());
			ps.setString(i++, oict.getApproveTime());
			ps.setString(i++, oict.getRemark());
			ps.setString(i++, oict.getId());
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
	public boolean deleteOfficeInfoChangeTable(String id) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from k_officeInfoChange where id = ?" ;
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
