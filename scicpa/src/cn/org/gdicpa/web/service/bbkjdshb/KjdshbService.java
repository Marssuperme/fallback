package cn.org.gdicpa.web.service.bbkjdshb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.bbkjdshb.model.KjdshbTable;

public class KjdshbService {
	private Connection conn;
	public KjdshbService(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 根据编号得到对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public KjdshbTable getKjdshbTable(String guid) throws Exception{
		DbUtil.checkConn(conn);
		KjdshbTable kt = new KjdshbTable();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select guid,pjjs "
				+ " from bb_kjdshb where guid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, guid);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				kt.setGuid(rs.getString(i++));
				kt.setPjjs(rs.getString(i++));
			}
			return kt;
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
	public boolean addKjdshbTable(KjdshbTable kt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into bb_kjdshb (guid,pjjs) "
				+ " values(?,?)";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, kt.getGuid());
			ps.setString(i++, kt.getPjjs());
			
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
	public boolean updateKjdshbTable(KjdshbTable kt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update bb_kjdshb set pjjs=? where guid=? ";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, kt.getPjjs());
			ps.setString(i++, kt.getGuid());
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
	public boolean deleteKjdshTable(String GUID) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from bb_kjdshb where guid = ?" ;
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
