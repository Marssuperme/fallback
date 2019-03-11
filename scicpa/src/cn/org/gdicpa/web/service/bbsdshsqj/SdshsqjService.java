package cn.org.gdicpa.web.service.bbsdshsqj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.bbsdshsqj.model.SdshsqjTable;

public class SdshsqjService {
	private Connection conn;
	public SdshsqjService(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 根据编号得到对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public SdshsqjTable getSdshsqjTable(String guid) throws Exception{
		DbUtil.checkConn(conn);
		SdshsqjTable st = new SdshsqjTable();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select guid,srze,xssr,xscb,qjfy,lrze,lstzqsde,"
				+ " lstzzje,lstzjse,ylssde,sysl,sjylssd,yjlssde,bqybsde,"
				+ " slswjg,gsswdjh,dsswdjh,sjswjgmc,bgyjlx,notblyj,blyj"
				+ " from BB_SDSHSQJB where guid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, guid);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				st.setGuid(rs.getString(i++));
				st.setSrze(rs.getString(i++));
				st.setXssr(rs.getString(i++));
				st.setXscb(rs.getString(i++));
				st.setQjfy(rs.getString(i++));
				st.setLrze(rs.getString(i++));
				st.setLstzqsde(rs.getString(i++));
				st.setLstzzje(rs.getString(i++));
				st.setLstzjse(rs.getString(i++));
				st.setYlssde(rs.getString(i++));
				st.setSysl(rs.getString(i++));
				st.setSjylssd(rs.getString(i++));
				st.setYjlssde(rs.getString(i++));
				st.setBqybsde(rs.getString(i++));
				st.setSlswjg(rs.getString(i++));
				st.setGsswdjh(rs.getString(i++));
				st.setDsswdjh(rs.getString(i++));
				st.setSjswjgmc(rs.getString(i++));
				st.setBgyjlx(rs.getString(i++));
				st.setNotblyj(rs.getString(i++));
				st.setBlyj(rs.getString(i++));
			}
			return st;
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
	public boolean addSdshsqjTable(SdshsqjTable st) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into BB_SDSHSQJB (guid,srze,xssr,xscb,qjfy,lrze,lstzqsde,"
				+ " lstzzje,lstzjse,ylssde,sysl,sjylssd,yjlssde,bqybsde,"
				+ " slswjg,gsswdjh,dsswdjh,sjswjgmc,bgyjlx,notblyj,blyj) "
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, st.getGuid());
			ps.setString(i++, st.getSrze());
			ps.setString(i++, st.getXssr());
			ps.setString(i++, st.getXscb());
			ps.setString(i++, st.getQjfy());
			ps.setString(i++, st.getLrze());
			ps.setString(i++, st.getLstzqsde());
			
			ps.setString(i++, st.getLstzzje());
			ps.setString(i++, st.getLstzjse());
			ps.setString(i++, st.getYlssde());
			ps.setString(i++, st.getSysl());
			ps.setString(i++, st.getSjylssd());
			ps.setString(i++, st.getYjlssde());
			ps.setString(i++, st.getBqybsde());
			
			ps.setString(i++, st.getSlswjg());
			ps.setString(i++, st.getGsswdjh());
			ps.setString(i++, st.getDsswdjh());
			ps.setString(i++, st.getSjswjgmc());
			ps.setString(i++, st.getBgyjlx());
			ps.setString(i++, st.getNotblyj());
			ps.setString(i++, st.getBlyj());
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
	public boolean updateSdshsqjTable(SdshsqjTable st) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try { 
			sql = " update BB_SDSHSQJB set srze=?,xssr=?,xscb=?,qjfy=?,lrze=?,lstzqsde=?,"
				+ " lstzzje=?,lstzjse=?,ylssde=?,sysl=?,sjylssd=?,yjlssde=?,bqybsde=?,"
				+ " slswjg=?,gsswdjh=?,dsswdjh=?,sjswjgmc=?,bgyjlx=?,notblyj=?,blyj=? where guid=? ";
			int i = 1;
			ps = conn.prepareStatement(sql);
			
			ps.setString(i++, st.getSrze());
			ps.setString(i++, st.getXssr());
			ps.setString(i++, st.getXscb());
			ps.setString(i++, st.getQjfy());
			ps.setString(i++, st.getLrze());
			ps.setString(i++, st.getLstzqsde());
			
			ps.setString(i++, st.getLstzzje());
			ps.setString(i++, st.getLstzjse());
			ps.setString(i++, st.getYlssde());
			ps.setString(i++, st.getSysl());
			ps.setString(i++, st.getSjylssd());
			ps.setString(i++, st.getYjlssde());
			ps.setString(i++, st.getBqybsde());
			
			ps.setString(i++, st.getSlswjg());
			ps.setString(i++, st.getGsswdjh());
			ps.setString(i++, st.getDsswdjh());
			ps.setString(i++, st.getSjswjgmc());
			ps.setString(i++, st.getBgyjlx());
			ps.setString(i++, st.getNotblyj());
			ps.setString(i++, st.getBlyj());
			ps.setString(i++, st.getGuid());
			
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
	public boolean deleteSdshsqjTable(String GUID) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from BB_SDSHSQJB where guid = ?" ;
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
