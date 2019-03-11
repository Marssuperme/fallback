package cn.org.gdicpa.web.service.bbhbsjb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.bbhbsjb.model.HbsjbTable;

public class HbsjbService {
	private Connection conn;
	public HbsjbService(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 根据编号得到对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public HbsjbTable getHbsjbTable(String guid) throws Exception{
		DbUtil.checkConn(conn);
		HbsjbTable ht = new HbsjbTable();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select guid,qslx,qsjsy,zcze,xssr, qssd,ylssde,ylsde,bgyjlx,notblyjly, bjyjly,cyry,sftzje,zczetzh,xssrtzh "
				+ " from bb_hbsjb where guid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, guid);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				ht.setGuid(rs.getString(i++));
				ht.setQslx(rs.getString(i++));
				ht.setQsjsy(rs.getString(i++));
				ht.setZcze(rs.getString(i++));
				ht.setXssr(rs.getString(i++));
				
				ht.setQssd(rs.getString(i++));
				ht.setYlssde(rs.getString(i++));
				ht.setYlsde(rs.getString(i++));
				ht.setBgyjlx(rs.getString(i++));
				ht.setNotblyjly(rs.getString(i++));
				
				ht.setBjyjly(rs.getString(i++));
				ht.setCyry(rs.getString(i++));
				ht.setSftzje(rs.getString(i++));
				ht.setZczetzh(rs.getString(i++));
				ht.setXssrtzh(rs.getString(i++));
			}
			return ht;
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
	public void addHbsjbTable(HbsjbTable ht) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into bb_hbsjb (guid,qslx,qsjsy,zcze,xssr, qssd,ylssde,ylsde,bgyjlx,notblyjly, bjyjly,cyry,sftzje,zczetzh,xssrtzh) "
				+ " values(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?)";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, ht.getGuid());
			ps.setString(i++, ht.getQslx());
			ps.setString(i++, ht.getQsjsy());
			ps.setString(i++, ht.getZcze());
			ps.setString(i++, ht.getXssr());
			
			ps.setString(i++, ht.getQssd());
			ps.setString(i++, ht.getYlssde());
			ps.setString(i++, ht.getYlsde());
			ps.setString(i++, ht.getBgyjlx());
			ps.setString(i++, ht.getNotblyjly());
			
			ps.setString(i++, ht.getBjyjly());
			ps.setString(i++, ht.getCyry());
			ps.setString(i++, ht.getSftzje());
			ps.setString(i++, ht.getZczetzh());
			ps.setString(i++, ht.getXssrtzh());
			
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
		
	}
	
	/**
	 * 修改对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public void updateHbsjbTable(HbsjbTable ht) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update bb_hbsjb set qslx=?,qsjsy=?,zcze=?,xssr=?,qssd=?, " 
				+ " ylssde=?,ylsde=?,bgyjlx=?,notblyjly=?,bjyjly=?, "
				+ " cyry=?,sftzje=?,zczetzh=?,xssrtzh=? "
				+ " where guid=? ";
			
			int i = 1;
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(i++, ht.getQslx());
			ps.setString(i++, ht.getQsjsy());
			ps.setString(i++, ht.getZcze());
			ps.setString(i++, ht.getXssr());
			ps.setString(i++, ht.getQssd());
			
			ps.setString(i++, ht.getYlssde());
			ps.setString(i++, ht.getYlsde());
			ps.setString(i++, ht.getBgyjlx());
			ps.setString(i++, ht.getNotblyjly());
			ps.setString(i++, ht.getBjyjly());
			
			ps.setString(i++, ht.getCyry());
			ps.setString(i++, ht.getSftzje());
			ps.setString(i++, ht.getZczetzh());
			ps.setString(i++, ht.getXssrtzh());
			
			ps.setString(i++, ht.getGuid());
			
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
		
	}
	
	/**
	 * 删除
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	public void deleteHbsjbTable(String GUID) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from bb_hbsjb where guid = ?" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,GUID);
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		
	}
}
