package cn.org.gdicpa.web.service.bbccsssqkcjjb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.bbccsssqkcjjb.model.CcsssqkcjjbTable;

public class CcsssqkcjjbService {
	private Connection conn;
	public CcsssqkcjjbService(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 根据编号得到对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public CcsssqkcjjbTable getCcsssqkcjjbTable(String guid) throws Exception{
		DbUtil.checkConn(conn);
		CcsssqkcjjbTable ct = new CcsssqkcjjbTable();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select guid,ccsslb,khsbssje,jzssje,bgyjlx,notblyjly,blyjly "
				+ " from bb_ccsssqkcjjb where guid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, guid);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				ct.setGuid(rs.getString(i++));
				ct.setCcsslb(rs.getString(i++));
				ct.setKhsbssje(rs.getString(i++));
				ct.setJzssje(rs.getString(i++));
				ct.setBgyjlx(rs.getString(i++));
				ct.setNotblyjly(rs.getString(i++));
				ct.setBlyjly(rs.getString(i++));
			}
			return ct;
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
	public boolean addCcsssqkcjjbTable(CcsssqkcjjbTable ct) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into bb_ccsssqkcjjb (guid,ccsslb,khsbssje,jzssje,bgyjlx,notblyjly,blyjly) "
				+ " values(?,?,?,?,?,?,?)";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, ct.getGuid());
			ps.setString(i++, ct.getCcsslb());
			ps.setString(i++, ct.getKhsbssje());
			ps.setString(i++, ct.getJzssje());
			ps.setString(i++, ct.getBgyjlx());
			ps.setString(i++, ct.getNotblyjly());
			ps.setString(i++, ct.getBlyjly());
			
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
	public boolean updateCcsssqkcjjbTable(CcsssqkcjjbTable ct) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update bb_ccsssqkcjjb set ccsslb=?,khsbssje=?,jzssje=?,bgyjlx=?,notblyjly=?," 
				+ " blyjly=? where guid=? ";
			int i = 1;
			ps = conn.prepareStatement(sql);
			
			ps.setString(i++, ct.getCcsslb());
			ps.setString(i++, ct.getKhsbssje());
			ps.setString(i++, ct.getJzssje());
			ps.setString(i++, ct.getBgyjlx());
			ps.setString(i++, ct.getNotblyjly());
			ps.setString(i++, ct.getBlyjly());
			ps.setString(i++, ct.getGuid());
			
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
	public boolean deleteCcsssqkcjjbTable(String GUID) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from bb_ccsssqkcjjb where guid = ?" ;
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
