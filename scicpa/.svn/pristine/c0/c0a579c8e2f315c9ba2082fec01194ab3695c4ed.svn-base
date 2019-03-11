package cn.org.gdicpa.web.service.bbqyjzpg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.bbqyjzpg.model.QyjzpgTable;

public class QyjzpgService {

	private Connection conn;
	public QyjzpgService(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 根据编号得到对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public QyjzpgTable getBbqyjzpgTable(String guid) throws Exception{
		DbUtil.checkConn(conn);
		QyjzpgTable bt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			
			sql = " select guid,ywlx,pgjzr,jzlx,pgmd, pgdx,pgfw,zypgffxz,cypgffxz,otheruser, "
				+ " othervalue,zmldzc,zmcqzc,zmgdzc,zmzjgc, zmjzw,zmsb,zmwxzc,zmtdsyq,zmqtzc, "
				+ " zmzczj,zmldfz,zmlqfz,zmfzzj,zmjzc, zmgdbfqyjz,pgldzc,pgcqzc,pggdzc,pgzjgc, "
				+ " pgjzw,pgsb,pgwxzc,pgtdsyq,pgqtzc, pgzczj,pgldfz,pglqfz,pgfzzj,pgjzc, pggdbfqyjz " 
				+ " from bb_qyjzpg where guid = ? ";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, guid);
			rs = ps.executeQuery();
			
			int i = 1;
			
			if(rs.next()){
				
				bt = new QyjzpgTable();
				
				bt.setGuid(rs.getString(i++));
				bt.setYwlx(rs.getString(i++));
				bt.setPgjzr(rs.getString(i++));
				bt.setJzlx(rs.getString(i++));
				bt.setPgmd(rs.getString(i++));
				
				bt.setPgdx(rs.getString(i++));
				bt.setPgfw(rs.getString(i++));
				bt.setZypgffxz(rs.getString(i++));
				bt.setCypgffxz(rs.getString(i++));
				bt.setOtheruser(rs.getString(i++));

				
				bt.setOthervalue(rs.getString(i++));
				bt.setZmldzc(rs.getString(i++));
				bt.setZmcqzc(rs.getString(i++));
				bt.setZmgdzc(rs.getString(i++));
				bt.setZmzjgc(rs.getString(i++));
				
				bt.setZmjzw(rs.getString(i++));
				bt.setZmsb(rs.getString(i++));
				bt.setZmwxzc(rs.getString(i++));
				bt.setZmtdsyq(rs.getString(i++));
				bt.setZmqtzc(rs.getString(i++));
				
				bt.setZmzczj(rs.getString(i++));
				bt.setZmldfz(rs.getString(i++));
				bt.setZmlqfz(rs.getString(i++));
				bt.setZmfzzj(rs.getString(i++));
				bt.setZmjzc(rs.getString(i++));
				
				bt.setZmgdbfqyjz(rs.getString(i++));
				bt.setPgldzc(rs.getString(i++));
				bt.setPgcqzc(rs.getString(i++));
				bt.setPggdzc(rs.getString(i++));
				bt.setPgzjgc(rs.getString(i++));
				
				bt.setPgjzw(rs.getString(i++));
				bt.setPgsb(rs.getString(i++));
				bt.setPgwxzc(rs.getString(i++));
				bt.setPgtdsyq(rs.getString(i++));
				bt.setPgqtzc(rs.getString(i++));
				
				bt.setPgzczj(rs.getString(i++));
				bt.setPgldfz(rs.getString(i++));
				bt.setPglqfz(rs.getString(i++));
				bt.setPgfzzj(rs.getString(i++));
				bt.setPgjzc(rs.getString(i++));
				
				bt.setPggdbfqyjz(rs.getString(i++));
				
			}
			return bt;
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
	 * @param bt
	 * @return
	 * @throws Exception
	 */
	public boolean addBbqyjzpgTable(QyjzpgTable bt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into bb_qyjzpg (guid,ywlx,pgjzr,jzlx,pgmd, pgdx,pgfw,zypgffxz,cypgffxz,otheruser, "
				+ " othervalue,zmldzc,zmcqzc,zmgdzc,zmzjgc, zmjzw,zmsb,zmwxzc,zmtdsyq,zmqtzc, "
				+ " zmzczj,zmldfz,zmlqfz,zmfzzj,zmjzc, zmgdbfqyjz,pgldzc,pgcqzc,pggdzc,pgzjgc, "
				+ " pgjzw,pgsb,pgwxzc,pgtdsyq,pgqtzc, pgzczj,pgldfz,pglqfz,pgfzzj,pgjzc, pggdbfqyjz) "
				+ " values(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?)";
			int i = 1;
			ps = conn.prepareStatement(sql);
			
			ps.setString(i++, bt.getGuid());
			ps.setString(i++, bt.getYwlx());
			ps.setString(i++, bt.getPgjzr());
			ps.setString(i++, bt.getJzlx());
			ps.setString(i++, bt.getPgmd());
			
			ps.setString(i++, bt.getPgdx());
			ps.setString(i++, bt.getPgfw());
			ps.setString(i++, bt.getZypgffxz());
			ps.setString(i++, bt.getCypgffxz());
			ps.setString(i++, bt.getOtheruser());
			
			ps.setString(i++, bt.getOthervalue());
			ps.setString(i++, bt.getZmldzc());
			ps.setString(i++, bt.getZmcqzc());
			ps.setString(i++, bt.getZmgdzc());
			ps.setString(i++, bt.getZmzjgc());
			
			ps.setString(i++, bt.getZmjzw());
			ps.setString(i++, bt.getZmsb());
			ps.setString(i++, bt.getZmwxzc());
			ps.setString(i++, bt.getZmtdsyq());
			ps.setString(i++, bt.getZmqtzc());
			
			ps.setString(i++, bt.getZmzczj());
			ps.setString(i++, bt.getZmldfz());
			ps.setString(i++, bt.getZmlqfz());
			ps.setString(i++, bt.getZmfzzj());
			ps.setString(i++, bt.getZmjzc());
			
			ps.setString(i++, bt.getZmgdbfqyjz());
			ps.setString(i++, bt.getPgldzc());
			ps.setString(i++, bt.getPgcqzc());
			ps.setString(i++, bt.getPggdzc());
			ps.setString(i++, bt.getPgzjgc());
			
			ps.setString(i++, bt.getPgjzw());
			ps.setString(i++, bt.getPgsb());
			ps.setString(i++, bt.getPgwxzc());
			ps.setString(i++, bt.getPgtdsyq());
			ps.setString(i++, bt.getPgqtzc());
			
			ps.setString(i++, bt.getPgzczj());
			ps.setString(i++, bt.getPgldfz());
			ps.setString(i++, bt.getPglqfz());
			ps.setString(i++, bt.getPgfzzj());
			ps.setString(i++, bt.getPgjzc());
			
			ps.setString(i++, bt.getPggdbfqyjz());
			
			
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
	 * @param bt
	 * @return
	 * @throws Exception
	 */
	public boolean updateBbqyjzpgTable(QyjzpgTable bt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update bb_qyjzpg set ywlx=?,pgjzr=?,jzlx=?,pgmd=?,pgdx=?, pgfw=?,zypgffxz=?,cypgffxz=?,otheruser=?,othervalue=?, "
				+ " zmldzc=?,zmcqzc=?,zmgdzc=?,zmzjgc=?,zmjzw=?, zmsb=?,zmwxzc=?,zmtdsyq=?,zmqtzc=?,zmzczj=?, "
				+ " zmldfz=?,zmlqfz=?,zmfzzj=?,zmjzc=?,zmgdbfqyjz=?, pgldzc=?,pgcqzc=?,pggdzc=?,pgzjgc=?,pgjzw=?, "
				+ " pgsb=?,pgwxzc=?,pgtdsyq=?,pgqtzc=?,pgzczj=?, pgldfz=?,pglqfz=?,pgfzzj=?,pgjzc=?,pggdbfqyjz=? "
				+ " where guid=? ";
			
			int i = 1;
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(i++, bt.getYwlx());
			ps.setString(i++, bt.getPgjzr());
			ps.setString(i++, bt.getJzlx());
			ps.setString(i++, bt.getPgmd());
			ps.setString(i++, bt.getPgdx());
			
			ps.setString(i++, bt.getPgfw());
			ps.setString(i++, bt.getZypgffxz());
			ps.setString(i++, bt.getCypgffxz());
			ps.setString(i++, bt.getOtheruser());
			ps.setString(i++, bt.getOthervalue());
			
			ps.setString(i++, bt.getZmldzc());
			ps.setString(i++, bt.getZmcqzc());
			ps.setString(i++, bt.getZmgdzc());
			ps.setString(i++, bt.getZmzjgc());
			ps.setString(i++, bt.getZmjzw());
			
			ps.setString(i++, bt.getZmsb());
			ps.setString(i++, bt.getZmwxzc());
			ps.setString(i++, bt.getZmtdsyq());
			ps.setString(i++, bt.getZmqtzc());
			ps.setString(i++, bt.getZmzczj());
			
			ps.setString(i++, bt.getZmldfz());
			ps.setString(i++, bt.getZmlqfz());
			ps.setString(i++, bt.getZmfzzj());
			ps.setString(i++, bt.getZmjzc());
			ps.setString(i++, bt.getZmgdbfqyjz());
			
			ps.setString(i++, bt.getPgldzc());
			ps.setString(i++, bt.getPgcqzc());
			ps.setString(i++, bt.getPggdzc());
			ps.setString(i++, bt.getPgzjgc());
			ps.setString(i++, bt.getPgjzw());
			
			ps.setString(i++, bt.getPgsb());
			ps.setString(i++, bt.getPgwxzc());
			ps.setString(i++, bt.getPgtdsyq());
			ps.setString(i++, bt.getPgqtzc());
			ps.setString(i++, bt.getPgzczj());
			
			ps.setString(i++, bt.getPgldfz());
			ps.setString(i++, bt.getPglqfz());
			ps.setString(i++, bt.getPgfzzj());
			ps.setString(i++, bt.getPgjzc());
			ps.setString(i++, bt.getPggdbfqyjz());
			
			
			ps.setString(i++, bt.getGuid());
			
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
	 * @param GUID
	 * @return
	 * @throws Exception
	 */
	public boolean deleteBbqyjzpgTable(String GUID) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from bb_qyjzpg where guid = ?" ;
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
