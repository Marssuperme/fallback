package cn.org.gdicpa.web.service.log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.log.model.LogTable;

public class LogService {
private Connection conn = null;
	
	public LogService(Connection conn) {
		this.conn = conn;
	}
	
	/**
	 * 记录用户登录日志
	 * @param lt
	 * @return
	 */
	public boolean saveLogInfo(LogTable lt){
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into l_log (userId,userName,ip,loginDate,loginTime,operation,memo,ctype,initflag)"
				+ " values(?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, lt.getUserId());
			ps.setString(i++, lt.getUserName());
			ps.setString(i++, lt.getIp());
			ps.setString(i++, lt.getLoginDate());
			ps.setString(i++, lt.getLoginTime());
			ps.setString(i++, lt.getOperation());
			ps.setString(i++, lt.getMemo());
			ps.setString(i++, lt.getCtype());
			ps.setString(i++, lt.getInitFlag());

			ps.execute();
			return true;
		} catch (SQLException e) {
			System.out.println(this.getClass()+" insert  ERRO :"+sql);
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		return false;
	}
}
