package cn.org.gdicpa.web.service.bbzcpgb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.bbzcpgb.model.ZcpgbTable;

public class ZcpgbService {
	private Connection conn;
	public ZcpgbService(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 根据编号得到对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public ZcpgbTable getZcpgbTable(String guid) throws Exception{
		DbUtil.checkConn(conn);
		ZcpgbTable zt = new ZcpgbTable();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select guid,pgmd,pgdx,pglx,pgff,pgjzr,zcze,fzze,jzze,sjdwmc "
				+ " from bb_zcpgb where guid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, guid);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				zt.setGuid(rs.getString(i++));
				zt.setPgmd(rs.getString(i++));
				zt.setPgdx(rs.getString(i++));
				zt.setPglx(rs.getString(i++));
				zt.setPgff(rs.getString(i++));
				zt.setPgjzr(rs.getString(i++));
				zt.setZcze(rs.getString(i++));
				zt.setFzze(rs.getString(i++));
				zt.setJzze(rs.getString(i++));
				zt.setSjdwmc(rs.getString(i++));
			}
			return zt;
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
	public boolean addZcpgbTable(ZcpgbTable zt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into bb_zcpgb (guid,pgmd,pgdx,pglx,pgff,pgjzr,zcze,fzze,jzze,sjdwmc) "
				+ " values(?,?,?,?,?,?,?,?,?,?)";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, zt.getGuid());
			ps.setString(i++, zt.getPgmd());
			ps.setString(i++, zt.getPgdx());
			ps.setString(i++, zt.getPglx());
			ps.setString(i++, zt.getPgff());
			ps.setString(i++, zt.getPgjzr());
			ps.setString(i++, zt.getZcze());
			ps.setString(i++, zt.getFzze());
			ps.setString(i++, zt.getJzze());
			ps.setString(i++, zt.getSjdwmc());
			
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
	public boolean updateZcpgbTable(ZcpgbTable zt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update bb_zcpgb set pgmd=?,pgdx=?,pglx=?,pgff=?,pgjzr=?,zcze=?,fzze=?,jzze=?,sjdwmc=? where guid=? ";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, zt.getPgmd());
			ps.setString(i++, zt.getPgdx());
			ps.setString(i++, zt.getPglx());
			ps.setString(i++, zt.getPgff());
			ps.setString(i++, zt.getPgjzr());
			ps.setString(i++, zt.getZcze());
			ps.setString(i++, zt.getFzze());
			ps.setString(i++, zt.getJzze());
			ps.setString(i++, zt.getSjdwmc());
			ps.setString(i++, zt.getGuid());
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
	public boolean deleteZcpgbTable(String GUID) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from bb_zcpgb where guid = ?" ;
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
