package cn.org.gdicpa.web.service.bbkjzsb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.bbkjzsb.model.KjzsbTable;

public class KjzsbService {
	private Connection conn;
	public KjzsbService(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 根据编号得到对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public KjzsbTable getKjzsTable(String guid) throws Exception{
		DbUtil.checkConn(conn);
		KjzsbTable kt = new KjzsbTable();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select guid,zsxm "
				+ " from bb_kjzsb where guid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, guid);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				kt.setGuid(rs.getString(i++));
				kt.setZsxm(rs.getString(i++));
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
	public boolean addKjzsbTable(KjzsbTable kt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into bb_kjzsb (guid,zsxm) "
				+ " values(?,?)";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, kt.getGuid());
			ps.setString(i++, kt.getZsxm());
			
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
	public boolean updateKjzsbTable(KjzsbTable kt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update bb_kjzsb set zsxm=? where guid=? ";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, kt.getZsxm());
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
	public boolean deleteKjzsbTable(String GUID) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from bb_kjzsb where guid = ?" ;
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

