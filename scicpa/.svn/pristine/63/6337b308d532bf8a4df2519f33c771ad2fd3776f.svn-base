package cn.org.gdicpa.web.service.bbjrzcpg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.bbjrzcpg.model.JrzcpgTable;

public class JrzcpgService {
	
	private Connection conn;
	public JrzcpgService(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 根据编号得到对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public JrzcpgTable getJrzcpgTable(String guid) throws Exception{
		DbUtil.checkConn(conn);
		JrzcpgTable jt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			
			
			
			sql = " select guid,ywlx,bglx,hzzs,zqje, swlzc,gqlzc,qtzc,zqlzc,hj " 
				+ " from bb_jrzcpg where guid = ? ";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, guid);
			rs = ps.executeQuery();
			
			int i = 1;
			
			if(rs.next()){
				
				jt = new JrzcpgTable();
				
				jt.setGuid(rs.getString(i++));
				jt.setYwlx(rs.getString(i++));
				jt.setBglx(rs.getString(i++));
				jt.setHzzs(rs.getString(i++));
				jt.setZqje(rs.getString(i++));
				
				jt.setSwlzc(rs.getString(i++));
				jt.setGqlzc(rs.getString(i++));
				jt.setQtzc(rs.getString(i++));
				jt.setZqlzc(rs.getString(i++));
				jt.setHj(rs.getString(i++));
				
			}
			return jt;
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
	public boolean addJrzcpgTable(JrzcpgTable jt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into bb_jrzcpg (guid,ywlx,bglx,hzzs,zqje, swlzc,gqlzc,qtzc,zqlzc,hj) "
				+ " values(?,?,?,?,?, ?,?,?,?,?)";
			int i = 1;
			ps = conn.prepareStatement(sql);
			
			ps.setString(i++, jt.getGuid());
			ps.setString(i++, jt.getYwlx());
			ps.setString(i++, jt.getBglx());
			ps.setString(i++, jt.getHzzs());
			ps.setString(i++, jt.getZqje());
			
			ps.setString(i++, jt.getSwlzc());
			ps.setString(i++, jt.getGqlzc());
			ps.setString(i++, jt.getQtzc());
			ps.setString(i++, jt.getZqlzc());
			ps.setString(i++, jt.getHj());

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
	public boolean updateJrzcpgTable(JrzcpgTable jt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update bb_jrzcpg set ywlx=?,bglx=?,hzzs=?,zqje=?,swlzc=?, gqlzc=?,qtzc=?,zqlzc=?,hj=? "
				+ " where guid=? ";
			
			int i = 1;
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(i++, jt.getYwlx());
			ps.setString(i++, jt.getBglx());
			ps.setString(i++, jt.getHzzs());
			ps.setString(i++, jt.getZqje());
			ps.setString(i++, jt.getSwlzc());
			
			ps.setString(i++, jt.getGqlzc());
			ps.setString(i++, jt.getQtzc());
			ps.setString(i++, jt.getZqlzc());
			ps.setString(i++, jt.getHj());
			
			ps.setString(i++, jt.getGuid());
			
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
	public boolean deleteJrzcpgTable(String GUID) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from bb_jrzcpg where guid = ?" ;
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
