package cn.org.gdicpa.web.service.sfkjjdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.sfkjjdb.model.SfkjjdbTable;

public class SfkjjdbService {
	private Connection conn;
	public SfkjjdbService(Connection conn){
		this.conn = conn;
	}
	
	
	/**
	 * 根据编号得到对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public SfkjjdbTable getSfkjjdbTable(String guid) throws Exception{
		DbUtil.checkConn(conn);
		SfkjjdbTable st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select guid,jdjg,zcze,xssr,cyry, sftzje,zczetzh,xssrtzh "
				+ " from BB_SFKJJDB where guid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, guid);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				st = new SfkjjdbTable();
				st.setGuid(rs.getString(i++));
				st.setJdjg(rs.getString(i++));
				st.setZcze(rs.getString(i++));
				st.setXssr(rs.getString(i++));
				st.setCyry(rs.getString(i++));
				
				st.setSftzje(rs.getString(i++));
				st.setZczetzh(rs.getString(i++));
				st.setXssrtzh(rs.getString(i++));
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
	public boolean addSfkjjdbTable(SfkjjdbTable st) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into BB_SFKJJDB (guid,jdjg,zcze,xssr,cyry, sftzje,zczetzh,xssrtzh)"
				+ " values(?,?,?,?,? ,?,?,?)";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, st.getGuid());
			ps.setString(i++, st.getJdjg());
			ps.setString(i++, st.getZcze());
			ps.setString(i++, st.getXssr());
			ps.setString(i++, st.getCyry());
			
			ps.setString(i++, st.getSftzje());
			ps.setString(i++, st.getZczetzh());
			ps.setString(i++, st.getXssrtzh());
			
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
	 * 添加对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public boolean updateSfkjjdbTable(SfkjjdbTable st) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update BB_SFKJJDB set jdjg=?,zcze=?,xssr=?,cyry=?,sftzje=?," 
				+ " zczetzh=?,xssrtzh=?  " 
				+ " where guid=? ";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, st.getJdjg());
			ps.setString(i++, st.getZcze());
			ps.setString(i++, st.getXssr());
			ps.setString(i++, st.getCyry());
			ps.setString(i++, st.getSftzje());

			ps.setString(i++, st.getZczetzh());
			ps.setString(i++, st.getXssrtzh());
			
			ps.setString(i++, st.getGuid());
			
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
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	public boolean deleteSfkjjdbTable(String GUID) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from BB_SFKJJDB where GUID = ?" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,GUID);
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
