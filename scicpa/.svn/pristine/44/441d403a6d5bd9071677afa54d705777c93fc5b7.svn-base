package cn.org.gdicpa.web.service.testerComposition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.testerComposition.model.TesterCompositionTable;

public class TesterCompositionService {
	private Connection conn = null;
	public TesterCompositionService(Connection conn) {
		this.conn = conn;
	}
	
	/**
	 * 保存
	 * @return
	 * @throws Exception 
	 */
	public boolean addTesterCompositionTable(TesterCompositionTable tct) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into k_TesterComposition (id,noticeId,CPANo,tcname,companyId," 
				+ " userId,applytime,astate,post,mobile," 
				+ " email,rtx,uploadAttachId,isJoin,notJoinReason) "
				+ " values(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?)";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, UUID.randomUUID().toString());
			ps.setString(i++, tct.getNoticeId());
			ps.setString(i++, tct.getCPANo());
			ps.setString(i++, tct.getTcname());

			ps.setString(i++, tct.getCompanyId());
			ps.setString(i++, tct.getUserId());
			ps.setString(i++, tct.getApplytime());
			ps.setString(i++, tct.getAstate()); 
			ps.setString(i++, tct.getPost()); 
			ps.setString(i++, tct.getMobile()); 
			ps.setString(i++, tct.getEmail()); 
			ps.setString(i++, tct.getRtx()); 
			ps.setString(i++, tct.getUploadAttachId()); 
			ps.setString(i++, tct.getIsJoin()); 
			ps.setString(i++, tct.getNotJoinReason()); 
			
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
	 * 修改
	 * @return
	 * @throws Exception 
	 */
	public boolean updateTesterCompositionTable(TesterCompositionTable tct) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update k_TesterComposition set tcname=?,applytime=? where id=? ";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, tct.getTcname());

			ps.setString(i++, tct.getApplytime());
			ps.setString(i++, tct.getId()); 
			
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
	 * 删除
	 * @return
	 * @throws Exception 
	 */
	public boolean deleteTesterCompositionTable(String noticeid,String loginid) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from  k_TesterComposition where noticeid=? and companyId=? ";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, noticeid);
			ps.setString(i++, loginid); 
			
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
	 * 是否可以报名
	 * 
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public TesterCompositionTable search(String noticeID,String loginid) throws Exception {
		DbUtil.checkConn(conn);
		TesterCompositionTable tct = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		String astate="";
		try {
			sql = " select id,noticeId,cpano,tcname,companyid," 
				+ " userid,applytime,astate,uploadAttachId,isJoin," 
				+ " notJoinReason " 
				+ " from k_TesterComposition where noticeId = ? and companyId=?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, noticeID);
			ps.setString(2, loginid);
			rs = ps.executeQuery(); 
			int i = 1;
			if (rs.next()) {
				tct = new TesterCompositionTable();
				tct.setId(rs.getString(i++));
				tct.setNoticeId(rs.getString(i++));
				tct.setCPANo(rs.getString(i++));
				tct.setTcname(rs.getString(i++));
				tct.setCompanyId(rs.getString(i++));
				tct.setUserId(rs.getString(i++));
				tct.setApplytime(rs.getString(i++));
				tct.setAstate(rs.getString(i++));
				tct.setUploadAttachId(rs.getString(i++));
				tct.setIsJoin(rs.getString(i++));
				tct.setNotJoinReason(rs.getString(i++));
			}
			System.out.println(this.getClass()+"     noticeID="+noticeID+"     userId="+loginid+"   astate="+astate);
			return tct;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return null;
	}
	
	/**
	 * 得到CPANO
	 * @param loginid
	 * @return
	 * @throws Exception 
	 */
	public String getCPANO(String loginid) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		String cpano="";
		try {
			sql = " select cpano from k_micfo where loginid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginid);
			rs = ps.executeQuery(); 
			if (rs.next()) {
				cpano=rs.getString(1);
			}
			return cpano;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return "";
	}
	
	/**
	 * 得到officeName
	 * @param loginid
	 * @return
	 * @throws Exception 
	 */
	public String getOfficeName(String loginid) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		String officeName="";
		try {
			sql = " select officeName from k_company where loginid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginid);
			rs = ps.executeQuery(); 
			if (rs.next()) {
				officeName=rs.getString(1);
			}
			return officeName;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return "";
	}
	
	
	/**
	 * 是否可以报名
	 * 
	 * @param guid
	 * @return
	 * @throws Exception 
	 * @throws Exception
	 */
	public List<TesterCompositionTable> getList(String noticeID,String userId) throws Exception {
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<TesterCompositionTable> list = new ArrayList<TesterCompositionTable>();
		String sql = "";
		try {
			sql = " select id,noticeId,cpano,tcname,companyid," 
				+ " userid,applytime,astate,uploadAttachId,isJoin," 
				+ " notJoinReason from k_TesterComposition where noticeId = ? and userId=?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, noticeID);
			ps.setString(2, userId);
			rs = ps.executeQuery(); 
			while (rs.next()) {
				int i = 1;
				TesterCompositionTable tct = new TesterCompositionTable();
				tct.setId(rs.getString(i++));
				tct.setNoticeId(rs.getString(i++));
				tct.setCPANo(rs.getString(i++));
				tct.setTcname(rs.getString(i++));
				tct.setCompanyId(rs.getString(i++));
				tct.setUserId(rs.getString(i++));
				tct.setApplytime(rs.getString(i++));
				tct.setAstate(rs.getString(i++));
				tct.setUploadAttachId(rs.getString(i++));
				tct.setIsJoin(rs.getString(i++));
				tct.setNotJoinReason(rs.getString(i++));
				
				list.add(tct);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return list;
	}
	
	/**
	 * 对应事务所下面的通知参与人
	 * 
	 * @param guid
	 * @return
	 * @throws Exception 
	 * @throws Exception
	 */
	public List<TesterCompositionTable> getTcnameList(String noticeID,String loginid) throws Exception {
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<TesterCompositionTable> list = new ArrayList<TesterCompositionTable>();
		String sql = "";
		String astate="";
		try {
			sql = " select id,noticeId,cpano,tcname,companyid," 
				+ " userid,applytime,astate,uploadAttachId,isJoin," 
				+ " notJoinReason from k_TesterComposition where noticeId = ? and companyId = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, noticeID);
			ps.setString(2, loginid);
			rs = ps.executeQuery(); 
			while (rs.next()) {
				int i = 1;
				TesterCompositionTable tct = new TesterCompositionTable();
				tct.setId(rs.getString(i++));
				tct.setNoticeId(rs.getString(i++));
				tct.setCPANo(rs.getString(i++));
				tct.setTcname(rs.getString(i++));
				tct.setCompanyId(rs.getString(i++));
				tct.setUserId(rs.getString(i++));
				tct.setApplytime(rs.getString(i++));
				tct.setAstate(rs.getString(i++));
				tct.setUploadAttachId(rs.getString(i++));
				tct.setIsJoin(rs.getString(i++));
				tct.setNotJoinReason(rs.getString(i++));
				
				list.add(tct);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return list;
	}
	
	/**
	 * 得到 检查组人员通知的 已参加人数
	 * @param noticeid
	 * @return
	 * @throws Exception
	 */
	public String getCountByNoticeid(String noticeid) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		String count = "";
		try {
			sql = "select count(*) from k_TesterComposition where noticeId = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, noticeid);
			rs = ps.executeQuery();
			if(rs.next()){
				count = rs.getString(1);
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally{
			DbUtil.close(ps);
			DbUtil.close(rs);
		}
		return count;
	}
}
