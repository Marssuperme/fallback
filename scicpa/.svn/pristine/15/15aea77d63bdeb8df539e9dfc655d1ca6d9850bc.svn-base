package cn.org.gdicpa.web.service.bbqchzb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.bbqchzb.model.QchzbTable;

public class QchzbService {
	private Connection conn;
	public QchzbService(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 根据编号得到对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public QchzbTable getQchzbTable(String guid) throws Exception{
		DbUtil.checkConn(conn);
		QchzbTable qt = new QchzbTable();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select guid,zcze,fzze,jzze,cyry, xssr,sftzje,zczetzh,xssrtzh,jzrq "
				+ " from bb_qchzb where guid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, guid);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				qt.setGuid(rs.getString(i++));
				qt.setZcze(rs.getString(i++));
				qt.setFzze(rs.getString(i++));
				qt.setJzze(rs.getString(i++)); 
				qt.setCyry(rs.getString(i++)); 
				
				qt.setXssr(rs.getString(i++));
				qt.setSftzje(rs.getString(i++));
				qt.setZczetzh(rs.getString(i++));
				qt.setXssrtzh(rs.getString(i++));
				qt.setJzrq(rs.getString(i++));
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
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public boolean addQchzbTable(QchzbTable qt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into bb_qchzb (guid,zcze,fzze,jzze,cyry, xssr,sftzje,zczetzh,xssrtzh,jzrq ) "
				+ " values(?,?,?,?,?, ?,?,?,?,?)";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, qt.getGuid());
			ps.setString(i++, qt.getZcze());
			ps.setString(i++, qt.getFzze());
			ps.setString(i++, qt.getJzze()); 
			ps.setString(i++, qt.getCyry()); 
			
			ps.setString(i++, qt.getXssr()); 
			ps.setString(i++, qt.getSftzje());
			ps.setString(i++, qt.getZczetzh());
			ps.setString(i++, qt.getXssrtzh());
			ps.setString(i++, qt.getJzrq());
			
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
	public boolean updateQchzbTable(QchzbTable qt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update bb_qchzb set zcze=?,fzze=?,jzze=?,cyry=?,xssr=?, sftzje=?,zczetzh=?,xssrtzh=?,jzrq=? " 
				+ " where guid=? ";
			int i = 1;
			ps = conn.prepareStatement(sql);
			
			ps.setString(i++, qt.getZcze());
			ps.setString(i++, qt.getFzze());
			ps.setString(i++, qt.getJzze()); 
			ps.setString(i++, qt.getCyry());
			ps.setString(i++, qt.getXssr());
			
			ps.setString(i++, qt.getSftzje());
			ps.setString(i++, qt.getZczetzh());
			ps.setString(i++, qt.getXssrtzh());
			ps.setString(i++, qt.getJzrq());
			
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
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	public boolean deleteQchzbTable(String GUID) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from bb_qchzb where guid = ?" ;
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
