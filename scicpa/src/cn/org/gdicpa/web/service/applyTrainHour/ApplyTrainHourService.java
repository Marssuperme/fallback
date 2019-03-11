package cn.org.gdicpa.web.service.applyTrainHour;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.applyTrainHour.model.ApplyTrainHourTable;


/**
 * 学时申报
 * @author Administrator
 *
 */
public class ApplyTrainHourService {
	private Connection conn;
	public ApplyTrainHourService(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 根据编号得到对象
	 * @param guid
	 * @return
	 * @throws Exception 
	 */
	public ApplyTrainHourTable getApplyTrainHourTableByGUID(String guid) throws Exception{
		DbUtil.checkConn(conn);
		ApplyTrainHourTable at = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		try {
			sql = " select id,loginid,loginName,applyHours,educationType,educationNote, " 
				+ " applyDate,companyOpinion,societyOpinion,attachmentid,companyChecked,provinceChecked "
				+ " from XS_ApplyTrainHour where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, guid);
			rs = ps.executeQuery();
			if(rs.next()){
				at = new ApplyTrainHourTable();
				int i = 1;
				at.setId(rs.getString(i++));
				at.setLoginid(rs.getString(i++));
				at.setLoginName(rs.getString(i++));
				at.setApplyHours(rs.getString(i++));
				at.setEducationType(rs.getString(i++));
				at.setEducationNote(rs.getString(i++));
				at.setApplyDate(rs.getString(i++));
				at.setCompanyOpinion(rs.getString(i++));
				at.setSocietyOpinion(rs.getString(i++));
				at.setAttachmentid(rs.getString(i++));
				at.setCompanyChecked(rs.getString(i++));
				at.setProvinceChecked(rs.getString(i++));
			}
			return at;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return at;
	}
	
	
	/**
	 * 根据LoginId得到对象
	 * @param guid
	 * @return
	 * @throws Exception 
	 */
	public ApplyTrainHourTable getApplyTrainHourTableByLoiginId(String loginid) throws Exception{
		DbUtil.checkConn(conn);
		ApplyTrainHourTable at = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		try {
			sql = " select id,loginid,loginName,applyHours,educationType,educationNote, " 
				+ " applyDate,companyOpinion,societyOpinion,attachmentid,companyChecked,provinceChecked "
				+ " from XS_ApplyTrainHour where loginid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginid);
			rs = ps.executeQuery();
			if(rs.next()){
				at = new ApplyTrainHourTable();
				int i = 1;
				at.setId(rs.getString(i++));
				at.setLoginid(rs.getString(i++));
				at.setLoginName(rs.getString(i++));
				at.setApplyHours(rs.getString(i++));
				at.setEducationType(rs.getString(i++));
				at.setEducationNote(rs.getString(i++));
				at.setApplyDate(rs.getString(i++));
				at.setCompanyOpinion(rs.getString(i++));
				at.setSocietyOpinion(rs.getString(i++));
				at.setAttachmentid(rs.getString(i++));
				at.setCompanyChecked(rs.getString(i++));
				at.setProvinceChecked(rs.getString(i++));
			}
			return at;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return at;
	}
	
	
	/**
	 * 添加 对象
	 * @param at
	 * @return
	 * @throws Exception 
	 */
	public boolean addApplyTrainHourTable(ApplyTrainHourTable at) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = null;
		try {
			sql = " insert into XS_ApplyTrainHour ( "
				+ " id,loginid,loginName,applyHours,educationType,educationNote, "
				+ " applyDate,companyOpinion,societyOpinion,attachmentid,companyChecked,provinceChecked,ctype) " 
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, at.getId());
			ps.setString(i++, at.getLoginid());
			ps.setString(i++, at.getLoginName());
			ps.setString(i++, at.getApplyHours());
			ps.setString(i++, at.getEducationType());
			ps.setString(i++, at.getEducationNote());
			
			ps.setString(i++, at.getApplyDate());
			ps.setString(i++, at.getCompanyOpinion());
			ps.setString(i++, at.getSocietyOpinion());
			ps.setString(i++, at.getAttachmentid());
			ps.setString(i++, at.getCompanyChecked());
			ps.setString(i++, at.getProvinceChecked());
			ps.setString(i++, at.getCtype());
			
			ps.execute();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
		return false;
	}
	
	
	/**
	 * 个人 修改  学时对象
	 * @param at
	 * @return
	 * @throws Exception
	 */
	public boolean updateApplyTrainHourTable(ApplyTrainHourTable at) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update XS_ApplyTrainHour set "
				+ " loginid=?,loginName=?,applyHours=?,educationType=?,educationNote=?,applyDate=?,attachmentid=?"
				+ " where id = ?";
			
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, at.getLoginid());
			ps.setString(i++, at.getLoginName());
			ps.setString(i++, at.getApplyHours());
			ps.setString(i++, at.getEducationType());
			ps.setString(i++, at.getEducationNote());
			ps.setString(i++, at.getApplyDate());
			
			ps.setString(i++, at.getAttachmentid());
			ps.setString(i++, at.getId());
			
			ps.execute();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
		return false;
	}
	
	/**
	 * 团体 修改 学时  对象 [ 审核 ]
	 * @param at
	 * @return
	 * @throws Exception
	 */
	public boolean updateApplyTrainHourTable1(ApplyTrainHourTable at) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update XS_ApplyTrainHour set "
				+ " companyOpinion=?,companyChecked=? where id = ?";
			
			ps = conn.prepareStatement(sql);
			int i = 1;
			
			ps.setString(i++, at.getCompanyOpinion());
			ps.setString(i++, at.getCompanyChecked());
			ps.setString(i++, at.getId());
			
			ps.execute();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
		return false;
	}
	
	
	
	/**
	 * 修改 学时  对象
	 * @param at
	 * @return
	 * @throws Exception
	 */
	public boolean updateApplyTrainHourTable2(ApplyTrainHourTable at) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update XS_ApplyTrainHour set "
				+ " loginid=?,loginName=?,applyHours=?,educationType=?,educationNote=?,applyDate=?,"
				+ " companyOpinion=?,societyOpinion=?,attachmentid=?,companyChecked=?,provinceChecked=?"
				+ " where id = ?";
			
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, at.getLoginid());
			ps.setString(i++, at.getLoginName());
			ps.setString(i++, at.getApplyHours());
			ps.setString(i++, at.getEducationType());
			ps.setString(i++, at.getEducationNote());
			ps.setString(i++, at.getApplyDate());
			
			ps.setString(i++, at.getCompanyOpinion());
			ps.setString(i++, at.getSocietyOpinion());
			ps.setString(i++, at.getAttachmentid());
			ps.setString(i++, at.getCompanyChecked());
			ps.setString(i++, at.getProvinceChecked());
			ps.setString(i++, at.getId());
			
			ps.execute();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
		return false;
	}
	
	
	/**
	 * 删除对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean deleteById(String id) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = null;
		try {
			sql = "delete from XS_ApplyTrainHour where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
		return false;
	}
	
	/**
	 * 得到 事务所下面的人
	 * @param loginid
	 * @return
	 */
	public String getLoginidByLoginid(String loginid){
		String sql = "";
		String loginids = "";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			sql = "select loginid from k_micfo where officecode = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginid);
			rs = ps.executeQuery();
			while(rs.next()){
				loginids = loginids + rs.getString(1) + ",";
			}
			if(loginids == null || "".equals(loginids)){
				loginids = "('')";
			}else{
				loginids = "("+loginids.substring(0, loginids.length()-1)+")";
			}
			return loginids;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
			DbUtil.close(rs);
		}
		return loginids;
	} 
 
}
