package cn.org.gdicpa.web.service.bbflsjb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.bbflsjb.model.FlsjbTable;

public class FlsjbService {
	private Connection conn;
	public FlsjbService(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 根据编号得到对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public FlsjbTable getFlsjbTable(String guid) throws Exception{
		DbUtil.checkConn(conn);
		FlsjbTable ft = new FlsjbTable();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select guid,qslx,qsjsy,zcze,xssr, qssd,ylssde,ylsde,bgyjlx,notblyjly, bjyjly,cyry,sftzje,zczetzh,xssrtzh "
				+ " from bb_flsjb where guid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, guid);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				ft.setGuid(rs.getString(i++));
				ft.setQslx(rs.getString(i++));
				ft.setQsjsy(rs.getString(i++));
				ft.setZcze(rs.getString(i++));
				ft.setXssr(rs.getString(i++));
				
				ft.setQssd(rs.getString(i++));
				ft.setYlssde(rs.getString(i++));
				ft.setYlsde(rs.getString(i++));
				ft.setBgyjlx(rs.getString(i++));
				ft.setNotblyjly(rs.getString(i++));
				
				ft.setBjyjly(rs.getString(i++));
				ft.setCyry(rs.getString(i++));
				ft.setSftzje(rs.getString(i++));
				ft.setZczetzh(rs.getString(i++));
				ft.setXssrtzh(rs.getString(i++));
			}
			return ft;
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
	public void addFlsjbTable(FlsjbTable ft) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into bb_flsjb (guid,qslx,qsjsy,zcze,xssr, qssd,ylssde,ylsde,bgyjlx,notblyjly, bjyjly,cyry,sftzje,zczetzh,xssrtzh) "
				+ " values(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?)";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, ft.getGuid());
			ps.setString(i++, ft.getQslx());
			ps.setString(i++, ft.getQsjsy());
			ps.setString(i++, ft.getZcze());
			ps.setString(i++, ft.getXssr());
			
			ps.setString(i++, ft.getQssd());
			ps.setString(i++, ft.getYlssde());
			ps.setString(i++, ft.getYlsde());
			ps.setString(i++, ft.getBgyjlx());
			ps.setString(i++, ft.getNotblyjly());
			
			ps.setString(i++, ft.getBjyjly());
			ps.setString(i++, ft.getCyry());
			ps.setString(i++, ft.getSftzje());
			ps.setString(i++, ft.getZczetzh());
			ps.setString(i++, ft.getXssrtzh());
			
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
	public void updateFlsjbTable(FlsjbTable ft) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update bb_flsjb set qslx=?,qsjsy=?,zcze=?,xssr=?,qssd=?, " 
				+ " ylssde=?,ylsde=?,bgyjlx=?,notblyjly=?,bjyjly=?, " 
				+ " cyry=?,sftzje=?,zczetzh=?,xssrtzh=? "
				+ " where guid=? ";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, ft.getQslx());
			ps.setString(i++, ft.getQsjsy());
			ps.setString(i++, ft.getZcze());
			ps.setString(i++, ft.getXssr());
			ps.setString(i++, ft.getQssd());
			
			ps.setString(i++, ft.getYlssde());
			ps.setString(i++, ft.getYlsde());
			ps.setString(i++, ft.getBgyjlx());
			ps.setString(i++, ft.getNotblyjly());
			ps.setString(i++, ft.getBjyjly());
			
			ps.setString(i++, ft.getCyry());
			ps.setString(i++, ft.getSftzje());
			ps.setString(i++, ft.getZczetzh());
			ps.setString(i++, ft.getXssrtzh());
			
			ps.setString(i++, ft.getGuid());
			
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
	public void deleteFlsjbTable(String GUID) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from bb_flsjb where guid = ?" ;
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
