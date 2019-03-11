package cn.org.gdicpa.web.service.bbqsshb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.bbqsshb.model.QsshbTable;

public class QsshbService {
	private Connection conn;
	public QsshbService(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 根据编号得到对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public QsshbTable getQsshbTable(String guid) throws Exception{
		DbUtil.checkConn(conn);
		QsshbTable qt = new QsshbTable();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select guid,qslx,qsjsy,zcze,xssr, qssd,ylssde,ylsde,bgyjlx,notblyjly, bjyjly,cyry,sjns,yysr,zxsjje, "
				+ " sftzje,zczetzh,xssrtzh from bb_qsshb where guid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, guid);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				qt.setGuid(rs.getString(i++));
				qt.setQslx(rs.getString(i++));
				qt.setQsjsy(rs.getString(i++));
				qt.setZcze(rs.getString(i++));
				qt.setXssr(rs.getString(i++));
				
				qt.setQssd(rs.getString(i++));
				qt.setYlssde(rs.getString(i++));
				qt.setYlsde(rs.getString(i++));
				qt.setBgyjlx(rs.getString(i++));
				qt.setNotblyjly(rs.getString(i++));
				
				qt.setBjyjly(rs.getString(i++));
				qt.setCyry(rs.getString(i++));
				qt.setSjns(rs.getString(i++));
				qt.setYysr(rs.getString(i++));
				qt.setZxsjje(rs.getString(i++));
				
				qt.setSftzje(rs.getString(i++));
				qt.setZczetzh(rs.getString(i++));
				qt.setXssrtzh(rs.getString(i++));
				
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
	public boolean addQsshbTable(QsshbTable qt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into bb_qsshb (guid,qslx,qsjsy,zcze,xssr, qssd,ylssde,ylsde,bgyjlx,notblyjly, " 
				+ " bjyjly,cyry,sjns,yysr,zxsjje, sftzje,zczetzh,xssrtzh ) "
				+ " values(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, qt.getGuid());
			ps.setString(i++, qt.getQslx());
			ps.setString(i++, qt.getQsjsy());
			ps.setString(i++, qt.getZcze());
			ps.setString(i++, qt.getXssr());
			
			ps.setString(i++, qt.getQssd());
			ps.setString(i++, qt.getYlssde());
			ps.setString(i++, qt.getYlsde());
			ps.setString(i++, qt.getBgyjlx());
			ps.setString(i++, qt.getNotblyjly());
			
			ps.setString(i++, qt.getBjyjly());
			ps.setString(i++, qt.getCyry());
			ps.setString(i++, qt.getSjns());
			ps.setString(i++, qt.getYysr());
			ps.setString(i++, qt.getZxsjje());
			
			ps.setString(i++, qt.getSftzje());
			ps.setString(i++, qt.getZczetzh());
			ps.setString(i++, qt.getXssrtzh());
			
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
	public boolean updateQsshbTable(QsshbTable qt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update bb_qsshb set qslx=?,qsjsy=?,zcze=?,xssr=?,qssd=?, ylssde=?,ylsde=?,bgyjlx=?,notblyjly=?,bjyjly=?, " 
				+ " cyry=?,sjns=?,yysr=?,zxsjje=?,sftzje=?, zczetzh=?,xssrtzh=? "
				+ " where guid=? ";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, qt.getQslx());
			ps.setString(i++, qt.getQsjsy());
			ps.setString(i++, qt.getZcze());
			ps.setString(i++, qt.getXssr());
			ps.setString(i++, qt.getQssd());
			
			ps.setString(i++, qt.getYlssde());
			ps.setString(i++, qt.getYlsde());
			ps.setString(i++, qt.getBgyjlx());
			ps.setString(i++, qt.getNotblyjly());
			ps.setString(i++, qt.getBjyjly());
			
			ps.setString(i++, qt.getCyry());
			ps.setString(i++, qt.getSjns());
			ps.setString(i++, qt.getYysr());
			ps.setString(i++, qt.getZxsjje());
			ps.setString(i++, qt.getSftzje());
			
			ps.setString(i++, qt.getZczetzh());
			ps.setString(i++, qt.getXssrtzh());
			
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
	public boolean deleteQsshbTable(String GUID) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from bb_qsshb where guid = ?" ;
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
