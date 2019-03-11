package cn.org.gdicpa.web.service.testerNotice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.testerNotice.model.TesterNoticeTable;

public class TesterNoticeService {
	private Connection conn = null;

	public TesterNoticeService(Connection conn) {
		this.conn = conn;
	}

	/**
	 * 根据编号得到对象的方法
	 * 
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public TesterNoticeTable getTesterNoticeTable(String id) throws Exception {
		DbUtil.checkConn(conn);
		TesterNoticeTable tnt = new TesterNoticeTable();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select id,testyear,customerName,userId,atime,title,acontent,testerlimit,"
					+ " timelimit,attachment from k_TesterNotice where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			int i = 1;
			if (rs.next()) {
				tnt.setId(rs.getString(i++));
				tnt.setTestyear(rs.getString(i++));
				tnt.setCustomerID(rs.getString(i++));
				tnt.setUserId(rs.getString(i++));
				tnt.setAtime(rs.getString(i++));
				tnt.setTitle(rs.getString(i++));
				tnt.setAcontent(rs.getString(i++));
				tnt.setTesterlimit(rs.getString(i++));
				tnt.setTimelimit(rs.getString(i++));
				tnt.setAttachment(rs.getString(i++));
			}
			return tnt;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return null;
	}

	public List getList(String sql) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			List list = new ArrayList();

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();
			while (rs.next()) {
				Map map = new HashMap();
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					map.put(RSMD.getColumnName(i).toLowerCase(), rs
							.getString(RSMD.getColumnName(i)));
				}
				list.add(map);
			}

			return list;
		} catch (Exception e) {
			System.out.println(" ERROR :" + sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}

	//  检查人员通知
	public ArrayList get()throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			ArrayList list = new ArrayList();

			sql = " select top 3 id,title,customerName,"
				+ " timelimit from k_TesterNotice where status='1' order by atime desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();
			while (rs.next()) {
				Map map = new HashMap();
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					map.put(RSMD.getColumnName(i).toLowerCase(), rs.getString(RSMD.getColumnName(i)));
				}
				list.add(map);
			}
			return list;
		} catch (Exception e) {
			System.out.println("ERROR :" + sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	
	//  得到对应的名称
	public String getLoginName(String loginid)throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String loginName="";
		String sql = "";
		try {

			sql = "select loginname from k_user where loginid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginid);
			rs = ps.executeQuery();
			if(rs.next()) {
				loginName = rs.getString(1);
			}
			return loginName;
		} catch (Exception e) {
			System.out.println("ERROR :" + sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
}
