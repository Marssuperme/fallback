package cn.org.gdicpa.web.service.supervision;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import cn.org.gdicpa.web.pub.db.DbUtil; 
import cn.org.gdicpa.web.service.supervision.model.SupervisionTable;

public class SupervisionService {
private Connection conn = null;
	
	public SupervisionService(Connection conn) {
		this.conn = conn;
	}
	
	/**
	 * 根据编号得到对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public SupervisionTable getSupervisionTable(String id) throws Exception{
		DbUtil.checkConn(conn);
		SupervisionTable st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select id,project,caption,body,companyname,IP," 
				+ " iuser,idate,auser,adate,status,result,projectId"
				+ " from supervision where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				st = new SupervisionTable();
				st.setId(rs.getString(i++));
				st.setProject(rs.getString(i++));
				st.setCaption(rs.getString(i++));
				st.setBody(rs.getString(i++));
				st.setCompanyname(rs.getString(i++));
				st.setIp(rs.getString(i++));
				st.setIuser(rs.getString(i++));
				st.setIdate(rs.getString(i++));
				st.setAuser(rs.getString(i++));
				st.setAdate(rs.getString(i++));
				st.setStatus(rs.getString(i++));
				st.setResult(rs.getString(i++));
				st.setProjectId(rs.getString(i++));
			}
			return st;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return null;
	}
	
	/**
	 * 添加对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public boolean addSupervisionTable(SupervisionTable st) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into supervision (id,project,caption,body,companyname,IP,iuser,idate,"
				+ " auser,adate,status,result,projectId) "
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, UUID.randomUUID().toString());
			ps.setString(i++, st.getProject());
			ps.setString(i++, st.getCaption());
			ps.setString(i++, st.getBody());

			ps.setString(i++, st.getCompanyname());
			ps.setString(i++, st.getIp());
			ps.setString(i++, st.getIuser());

			ps.setString(i++, st.getIdate());
			ps.setString(i++, st.getAuser());
			ps.setString(i++, st.getAdate());

			ps.setString(i++, st.getStatus());
			ps.setString(i++, st.getResult());
			ps.setString(i++, st.getProjectId());
			
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
	 * 修改对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public boolean updateSupervisionStuatus(String id) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update supervision set status = '办结' where id=? ";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, id);
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
	 * 得到状态
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public String viewStuatus(String id) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String status = "";
		String sql = "";
		try {
			sql = " select status from  supervision where id=? ";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, id);
			rs = ps.executeQuery();
			if(rs.next()){
				status = rs.getString(1);
			}
			return status;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
		return "";
	}
	

	/**
	 * 名称
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public String getNameById(String id) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String name = "";
		String sql = "";
		try {
			sql = " select loginname from k_user where loginid=? ";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, id);
			rs = ps.executeQuery();
			if(rs.next()){
				name = rs.getString(1);
			}
			return name;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
		return "";
	}
	
	
	/**
	 * 得到 被检查事务所下面的自查报告
	 * @param year
	 * @param companyId
	 * @return
	 * @throws Exception
	 */
	 public List getFiles(String year,String companyId,String testerNoticeId) throws Exception {
	    	PreparedStatement ps = null;
	        ResultSet rs = null;
	        List list = new ArrayList();
	    	String sql = "";
	    	Map map = null; 
	    	try {
	    		// "&fileTempName="+fileTempName+"&indexTable="+indexTable+"&indexId="+indexId;
				sql = "	Select fileTempName,indexTable,indexId,filename From k_SuperviseMain k"
					+ " left join k_reply r on k.TaskID = r.tid "
					+ " left join k_attachfile a on r.attachment = a.indexid "
					+ " where a.indexTable = 'k_reply' and"
					+ " r.replyer = ?  and TesterNoticeID= ? ";	

				
				ps = conn.prepareStatement(sql);
	            ps.setString(1, companyId);
	            ps.setString(2, testerNoticeId);
	    		rs = ps.executeQuery();
	    		ResultSetMetaData RSMD = rs.getMetaData();	
	    		while(rs.next()){
	    			map = new HashMap();
	    			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
	    				map.put(RSMD.getColumnName(i).toLowerCase() , rs.getString(RSMD.getColumnName(i)));
					}
	    			list.add(map);
	    		}
			} catch (Exception e) {
				System.out.println("登录出错SQL："+sql);
				e.printStackTrace();
				throw e;
			} finally {
				DbUtil.close(rs);
				DbUtil.close(ps);
			}
			return list;
	 }

	 /**
	  * 检查组下面的所有的人
	  * @param noticeId
	  * @param groupname
	  * @return
	  * @throws Exception
	  */
	 public List getCheckMan(String testerNoticeId,String groupname) throws Exception {
	    	PreparedStatement ps = null;
	        ResultSet rs = null;
	        List list = new ArrayList();
	    	String sql = "";
	    	Map map = null; 
	    	try {
				sql = "	select m.loginid,m.loginname from k_SuperviseUser s "
					+ " inner join k_micfo m on s.cpano = m.cpano  " 
					+ " where s.noticeid = ? and s.groupname = ? ";	
				
				ps = conn.prepareStatement(sql);
	            ps.setString(1, testerNoticeId);
	            ps.setString(2, groupname);
	    		rs = ps.executeQuery();
	    		while(rs.next()){
	    			map = new HashMap();
    				map.put("loginid", rs.getString("loginid"));
    				map.put("loginname", rs.getString("loginname"));
    				
	    			list.add(map);
	    		}
			} catch (Exception e) {
				System.out.println("出错SQL："+sql);
				e.printStackTrace();
				throw e;
			} finally {
				DbUtil.close(rs);
				DbUtil.close(ps);
			}
			return list;
	 }

	 
}
