package cn.org.gdicpa.web.service.bbqtzcpg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.bbqtzcpg.model.QtzcpgTable;

public class QtzcpgService {

	private Connection conn;
	public QtzcpgService(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 根据编号得到对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public QtzcpgTable getQtzcpgTable(String guid) throws Exception{
		DbUtil.checkConn(conn);
		QtzcpgTable qt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select guid,pgmd,ywlx,pgdx,zypgffxz,zmyz,pgjz " 
				+ " from bb_qtzcpg where guid = ? ";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, guid);
			rs = ps.executeQuery();
			
			int i = 1;
			
			if(rs.next()){
				
				qt = new QtzcpgTable();
				
				qt.setGuid(rs.getString(i++));
				qt.setPgmd(rs.getString(i++));
				qt.setYwlx(rs.getString(i++));
				qt.setPgdx(rs.getString(i++));
				qt.setZypgffxz(rs.getString(i++));
				
				qt.setZmyz(rs.getString(i++));
				qt.setPgjz(rs.getString(i++));
				
			}
			return qt;
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
	 * @param bt
	 * @return
	 * @throws Exception
	 */
	public boolean addQtzcpgTable(QtzcpgTable qt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into bb_qtzcpg (guid,pgmd,ywlx,pgdx,zypgffxz, zmyz,pgjz) "
				+ " values(?,?,?,?,?, ?,?)";
			int i = 1;
			ps = conn.prepareStatement(sql);
			
			ps.setString(i++, qt.getGuid());
			ps.setString(i++, qt.getPgmd());
			ps.setString(i++, qt.getYwlx());
			ps.setString(i++, qt.getPgdx());
			ps.setString(i++, qt.getZypgffxz());
			
			ps.setString(i++, qt.getZmyz());
			ps.setString(i++, qt.getPgjz());

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
	 * @param bt
	 * @return
	 * @throws Exception
	 */
	public boolean updateQtzcpgTable(QtzcpgTable qt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update bb_qtzcpg set pgmd=?,ywlx=?,pgdx=?,zypgffxz=?,zmyz=?, pgjz=? "
				+ " where guid=? ";
			
			int i = 1;
			
			ps = conn.prepareStatement(sql);
			
			
			ps.setString(i++, qt.getPgmd());
			ps.setString(i++, qt.getYwlx());
			ps.setString(i++, qt.getPgdx());
			ps.setString(i++, qt.getZypgffxz());
			ps.setString(i++, qt.getZmyz());
			
			ps.setString(i++, qt.getPgjz());
			
			ps.setString(i++, qt.getGuid());

			
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
	 * @param GUID
	 * @return
	 * @throws Exception
	 */
	public boolean deleteQtzcpgTable(String GUID) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from bb_qtzcpg where guid = ?" ;
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
