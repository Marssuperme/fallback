package cn.org.gdicpa.web.service.lineup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.lineup.model.LineupTable;

public class LineupService {
	private Connection conn;
	public LineupService(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 根据编号得到对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public LineupTable getLineupTable(String id) throws Exception{
		DbUtil.checkConn(conn);
		LineupTable lt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select id,lineupname,lineupperson,lineuptime,attachment,memo,noticeid from s_lineup where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				lt = new LineupTable();
				lt.setId(rs.getString(i++));
				lt.setLineupname(rs.getString(i++));
				lt.setLineupperson(rs.getString(i++));
				lt.setLineuptime(rs.getString(i++));
				lt.setAttachment(rs.getString(i++));
				lt.setMemo(rs.getString(i++));
				lt.setNoticeid(rs.getString(i++));
			}
			return lt;
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
	public boolean addLineupTable(LineupTable lt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into s_lineup (id,lineupname,lineupperson,lineuptime,attachment,memo,noticeid) "
				+ " values(?,?,?,?,?,?,?)";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, UUID.randomUUID().toString());
			ps.setString(i++, lt.getLineupname());
			ps.setString(i++, lt.getLineupperson());
			ps.setString(i++, lt.getLineuptime());
			ps.setString(i++, lt.getAttachment());
			ps.setString(i++, lt.getMemo());
			ps.setString(i++, lt.getNoticeid());
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
	public boolean deleteLineupTable(String id) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from s_lineup where id = ?" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,id);
			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
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
	public boolean deleteLineupAttachfile(String id) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from k_attachfile where indexId = ?" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,id);
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
