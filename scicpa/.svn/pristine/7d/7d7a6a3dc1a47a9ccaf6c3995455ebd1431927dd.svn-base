package cn.org.gdicpa.web.service.bbdxzhpgb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.bbdxzhpgb.model.DxzhpgbTable;

public class DxzhpgbService {

	private Connection conn;
	public DxzhpgbService(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 根据编号得到对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public DxzhpgbTable getBbdxzhpgbTable(String guid) throws Exception{
		DbUtil.checkConn(conn);
		DxzhpgbTable bt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			
			sql = " select guid,ywlx,pgjzr,jzlx,pgmd, pgdx,pgfw,zypgffxz,cypgffxz,otheruser, "
				+ " othervalue,zmldzc,zmcqzc,zmgdzc,zmzjgc, zmjzw,zmsb,zmwxzc,zmtdsyq,zmqtzc, "
				+ " zmzczj,pgldzc,pgcqzc,pggdzc,pgzjgc, pgjzw,pgsb,pgwxzc,pgtdsyq,pgqtzc, "
				+ " pgzczj from bb_dxzhpg where guid = ? ";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, guid);
			rs = ps.executeQuery();
			
			int i = 1;
			
			if(rs.next()){
				bt = new DxzhpgbTable();
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
	public boolean addBbDxzhpgbTable(DxzhpgbTable bt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into bb_dxzhpg (guid,ywlx,pgjzr,jzlx,pgmd, pgdx,pgfw,zypgffxz,cypgffxz,otheruser, "
				+ " othervalue,zmldzc,zmcqzc,zmgdzc,zmzjgc, zmjzw,zmsb,zmwxzc,zmtdsyq,zmqtzc, "
				+ " zmzczj,pgldzc,pgcqzc,pggdzc,pgzjgc, pgjzw,pgsb,pgwxzc,pgtdsyq,pgqtzc, "
				+ " pgzczj) "
				+ " values(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?)";
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
	public boolean updateBbDxzhpgTable(DxzhpgbTable bt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update bb_dxzhpg set ywlx=?,pgjzr=?,jzlx=?,pgmd=?,pgdx=?," 
				+ " pgfw=?,zypgffxz=?,cypgffxz=?,otheruser=?,othervalue=?, "
				+ " zmldzc=?,zmcqzc=?,zmgdzc=?,zmzjgc=?,zmjzw=?," 
				+ " zmsb=?,zmwxzc=?,zmtdsyq=?,zmqtzc=?,zmzczj=?, "
				+ " pgldzc=?,pgcqzc=?,pggdzc=?,pgzjgc=?,pgjzw=?," 
				+ " pgsb=?,pgwxzc=?,pgtdsyq=?,pgqtzc=?,pgzczj=? "
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
	public boolean deleteBbDxzhpgTable(String GUID) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from bb_dxzhpg where guid = ?" ;
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
