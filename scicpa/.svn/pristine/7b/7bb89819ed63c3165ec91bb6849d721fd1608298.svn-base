package cn.org.gdicpa.web.service.government;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.government.model.GovernmentTable;

public class GovernmentService {
	private Connection conn;

	public GovernmentService(Connection conn) {
		this.conn = conn;
	}

	/**
	 * 根据编号得到实体对象的方法
	 * 
	 * @param loginid
	 * @return
	 * @throws Exception
	 */
	public GovernmentTable getGovernmentTableById(String loginid)
			throws Exception {
		DbUtil.checkConn(conn);
		GovernmentTable governmentTable = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			String sql = " select loginid,loginName,Pwd,State,Ctype,CtypetabName,Phone,Workunits "
					   + " from k_government where loginid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginid);
			int i = 1;
			rs = ps.executeQuery();
			if (rs.next()) {
				governmentTable = new GovernmentTable();
				governmentTable.setLoginid(rs.getString(i++));
				governmentTable.setLoginName(rs.getString(i++));
				governmentTable.setPwd(rs.getString(i++));
				governmentTable.setState(rs.getString(i++));
				governmentTable.setCtype(rs.getString(i++));
				governmentTable.setCtypetabName(rs.getString(i++));
				governmentTable.setPhone(rs.getString(i++));
				governmentTable.setWorkunits(rs.getString(i++));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return governmentTable;
	}

	/**
	 * 根据编号修改实体对象的方法
	 * 
	 * @param governmentTable
	 * @return
	 * @throws Exception
	 */
	public boolean updateGovernmentTableById(GovernmentTable governmentTable)
			throws Exception {
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		try {
			String sql = " update k_government set loginName=?,Pwd=?,State=?,Ctype=?,"
					   + " CtypetabName=?,Phone=?,Workunits=? "
					   + " where loginid = ?";
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, governmentTable.getLoginName());
			ps.setString(i++, governmentTable.getPwd());
			ps.setString(i++, governmentTable.getState());
			ps.setString(i++, governmentTable.getCtype());
			ps.setString(i++, governmentTable.getCtypetabName());
			ps.setString(i++, governmentTable.getPhone());
			ps.setString(i++, governmentTable.getWorkunits());
			ps.setString(i++, governmentTable.getLoginid());

			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(ps);
		}
		return false;
	}

}
