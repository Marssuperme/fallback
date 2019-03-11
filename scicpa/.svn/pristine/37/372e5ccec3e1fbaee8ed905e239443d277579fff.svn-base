package cn.org.gdicpa.web.service.bbqtssjjb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.bbqtssjjb.model.QtssjjbTable;

public class QtssjjbService {
	private Connection conn;
	public QtssjjbService(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 根据编号得到对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public QtssjjbTable getQtssjjTable(String guid) throws Exception{
		DbUtil.checkConn(conn);
		QtssjjbTable qt = new QtssjjbTable();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select guid,srze,xssr,xscb,qjfy,lrze,lstzqsde,lstzzje,lstzjse,ylssde,sysl,sjylssd,"
				+ " yyjsdse,bqybsdlse,slsjg,gsswdjh,dsswdjh,slswjgmc,bgyjlx,notblyjly,blyjly"
				+ " from bb_qtssjjb where guid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, guid);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				qt.setGuid(rs.getString(i++));
				qt.setSrze(rs.getString(i++));
				qt.setXssr(rs.getString(i++));
				qt.setXscb(rs.getString(i++));
				qt.setQjfy(rs.getString(i++));
				qt.setLrze(rs.getString(i++));
				qt.setLstzqsde(rs.getString(i++));
				
				qt.setLstzzje(rs.getString(i++));
				qt.setLstzjse(rs.getString(i++));
				qt.setYlssde(rs.getString(i++));
				qt.setSysl(rs.getString(i++));
				qt.setSjylssd(rs.getString(i++));
				
				qt.setYyjsdse(rs.getString(i++));
				qt.setBqybsdlse(rs.getString(i++));
				qt.setSlsjg(rs.getString(i++));
				qt.setGsswdjh(rs.getString(i++));
				qt.setDsswdjh(rs.getString(i++));
				qt.setSlswjgmc(rs.getString(i++));
				qt.setBgyjlx(rs.getString(i++));
				qt.setNotblyjly(rs.getString(i++));
				qt.setBlyjly(rs.getString(i++));
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
	public boolean addQtssjjTable(QtssjjbTable qt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into bb_qtssjjb (guid,srze,xssr,xscb,qjfy,lrze,lstzqsde,lstzzje,lstzjse,ylssde," 
				+ " sysl,sjylssd,yyjsdse,bqybsdlse,slsjg,gsswdjh,dsswdjh,slswjgmc,bgyjlx,notblyjly,blyjly) "
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, qt.getGuid());
			ps.setString(i++, qt.getSrze());
			ps.setString(i++, qt.getXssr());
			ps.setString(i++, qt.getXscb());
			ps.setString(i++, qt.getQjfy());
			ps.setString(i++, qt.getLrze());
			ps.setString(i++, qt.getLstzqsde());
			
			ps.setString(i++, qt.getLstzzje());
			ps.setString(i++, qt.getLstzjse());
			ps.setString(i++, qt.getYlssde());
			 
			ps.setString(i++, qt.getSysl());
			ps.setString(i++, qt.getSjylssd());
			ps.setString(i++, qt.getYyjsdse());
			ps.setString(i++, qt.getBqybsdlse());
			ps.setString(i++, qt.getSlsjg());
			ps.setString(i++, qt.getGsswdjh());
			ps.setString(i++, qt.getDsswdjh());
			ps.setString(i++, qt.getSlswjgmc());
			ps.setString(i++, qt.getBgyjlx());
			ps.setString(i++, qt.getNotblyjly());
			ps.setString(i++, qt.getBlyjly());
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
	public boolean updateQtssjjTable(QtssjjbTable qt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update bb_qtssjjb set srze=?,xssr=?,xscb=?,qjfy=?,lrze=?,lstzqsde=?,lstzzje=?,"  
				+ " lstzjse=?,ylssde=?,sysl=?,sjylssd=?,yyjsdse=?,bqybsdlse=?,slsjg=?,gsswdjh=?," 
				+ " dsswdjh=?,slswjgmc=?,bgyjlx=?,notblyjly=?,blyjly=? where guid=? ";
			int i = 1;
			ps = conn.prepareStatement(sql);
			
			ps.setString(i++, qt.getSrze());
			ps.setString(i++, qt.getXssr());
			ps.setString(i++, qt.getXscb());
			ps.setString(i++, qt.getQjfy());
			ps.setString(i++, qt.getLrze());
			ps.setString(i++, qt.getLstzqsde());
			ps.setString(i++, qt.getLstzzje());
			
			ps.setString(i++, qt.getLstzjse());
			ps.setString(i++, qt.getYlssde());
			ps.setString(i++, qt.getSysl());
			ps.setString(i++, qt.getSjylssd());
			ps.setString(i++, qt.getYyjsdse());
			ps.setString(i++, qt.getBqybsdlse());
			ps.setString(i++, qt.getSlsjg());
			ps.setString(i++, qt.getGsswdjh());
		 
			ps.setString(i++, qt.getDsswdjh());
			ps.setString(i++, qt.getSlswjgmc());
			ps.setString(i++, qt.getBgyjlx());
			ps.setString(i++, qt.getNotblyjly());
			ps.setString(i++, qt.getBlyjly());
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
	public boolean deleteQtssjjTable(String GUID) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from bb_qtssjjb where guid = ?" ;
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
