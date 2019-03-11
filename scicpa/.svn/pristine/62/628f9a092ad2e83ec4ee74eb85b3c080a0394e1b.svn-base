package cn.org.gdicpa.web.service.bbwhnjb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.bbwhnjb.model.WhnjTable;

public class WhnjService {
	private Connection conn;
	public WhnjService(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 根据编号得到对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public WhnjTable getWhnjTable(String guid) throws Exception{
		DbUtil.checkConn(conn);
		WhnjTable wt = new WhnjTable();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select guid,whdjzh,bz,whsrzj,whzczj, " 
				+ " jcxmce,qtzc,whhbjj,jchj,ssjwjb,"
				+ " ssjlwhjb,jwjk,xmzrs,wqgzts,sftzje, "
				+ " zczetzh,wfcze,whcdwfgl,wfdlcsye,whzhye "
				+ " from BB_WHNJB where guid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, guid);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				wt.setGuid(rs.getString(i++));
				wt.setWhdjzh(rs.getString(i++));
				wt.setBz(rs.getString(i++));
				wt.setWhsrzj(rs.getString(i++));
				wt.setWhzczj(rs.getString(i++));
				
				wt.setJcxmce(rs.getString(i++));
				wt.setQtzc(rs.getString(i++));
				wt.setWhhbjj(rs.getString(i++));
				wt.setJchj(rs.getString(i++));
				wt.setSsjwjb(rs.getString(i++));
				
				wt.setSsjlwhjb(rs.getString(i++));
				wt.setJwjk(rs.getString(i++));
				wt.setXmzrs(rs.getString(i++));
				wt.setWqgzts(rs.getString(i++));
				wt.setSftzje(rs.getString(i++));
				
				wt.setZczetzh(rs.getString(i++));
				
				//新增加wfcze,whcdwfgl,wfdlcsye,whzhye
				wt.setWfcze(rs.getString(i++));
				wt.setWhcdwfgl(rs.getString(i++));
				wt.setWfdlcsye(rs.getString(i++));
				wt.setWhzhye(rs.getString(i++));
			}
			return wt;
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
	public boolean addWhnjTable(WhnjTable wt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into BB_WHNJB (guid,whdjzh,bz,whsrzj,whzczj,"
				+ " jcxmce,qtzc,whhbjj,jchj,ssjwjb, "
				+ " ssjlwhjb,jwjk,xmzrs,wqgzts,sftzje, "
				+ " zczetzh,wfcze,whcdwfgl,wfdlcsye,whzhye) "
				+ " values(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?)";
			int i = 1;
			ps = conn.prepareStatement(sql);
			
			ps.setString(i++, wt.getGuid());
			ps.setString(i++, wt.getWhdjzh());
			ps.setString(i++, wt.getBz());
			ps.setString(i++, wt.getWhsrzj());
			ps.setString(i++, wt.getWhzczj());
			
			ps.setString(i++, wt.getJcxmce());
			ps.setString(i++, wt.getQtzc());
			ps.setString(i++, wt.getWhhbjj());
			ps.setString(i++, wt.getJchj());
			ps.setString(i++, wt.getSsjwjb());
			
			ps.setString(i++, wt.getSsjlwhjb());
			ps.setString(i++, wt.getJwjk());
			ps.setString(i++, wt.getXmzrs());
			ps.setString(i++, wt.getWqgzts());
			ps.setString(i++, wt.getSftzje());
			
			ps.setString(i++, wt.getZczetzh());
			
			//新增加wfcze,whcdwfgl,wfdlcsye,whzhye
			ps.setString(i++, wt.getWfcze());
			ps.setString(i++, wt.getWhcdwfgl());
			ps.setString(i++, wt.getWfdlcsye());
			ps.setString(i++, wt.getWhzhye());
			
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
	public boolean updateWhnjTable(WhnjTable wt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update BB_WHNJB set whdjzh=?,bz=?,whsrzj=?,whzczj=?,jcxmce=?,"
				+ " qtzc=?,whhbjj=?,jchj=?,ssjwjb=?,ssjlwhjb=?, "
				+ " jwjk=?,xmzrs=?,wqgzts=?,sftzje=?,zczetzh=?,wfcze=?,whcdwfgl=?,wfdlcsye=?,whzhye=? " 
				+ " where guid=? ";
			
			int i = 1;
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(i++, wt.getWhdjzh());
			ps.setString(i++, wt.getBz());
			ps.setString(i++, wt.getWhsrzj());
			ps.setString(i++, wt.getWhzczj());
			ps.setString(i++, wt.getJcxmce());
			
			ps.setString(i++, wt.getQtzc());
			ps.setString(i++, wt.getWhhbjj());
			ps.setString(i++, wt.getJchj());
			ps.setString(i++, wt.getSsjwjb());
			ps.setString(i++, wt.getSsjlwhjb());
			
			ps.setString(i++, wt.getJwjk());
			ps.setString(i++, wt.getXmzrs());
			ps.setString(i++, wt.getWqgzts());
			ps.setString(i++, wt.getSftzje());
			ps.setString(i++, wt.getZczetzh());
			
			//新增加wfcze,whcdwfgl,wfdlcsye,whzhye
			ps.setString(i++, wt.getWfcze());
			ps.setString(i++, wt.getWhcdwfgl());
			ps.setString(i++, wt.getWfdlcsye());
			ps.setString(i++, wt.getWhzhye());
			
			ps.setString(i++, wt.getGuid()); 
			
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
	public boolean deleteWhnjTable(String GUID) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from BB_WHNJB where guid = ?" ;
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
