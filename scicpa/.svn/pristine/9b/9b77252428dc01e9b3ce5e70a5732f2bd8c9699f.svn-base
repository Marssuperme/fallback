package cn.org.gdicpa.web.service.education;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.education.model.EducationLogTable;

public class EducationLogService {
	public void save(EducationLogTable log){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new DBConnect().getConnect();
			String sql = "insert into EDUCATION_LOG (ID,OPERATION,IP,TIME,STATUS,CALSSNAME,INFO,LOGINID,LOGINNAME) " +
					"values (newid(),?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			int i = 1;
//			pstmt.setString(i++, log.getId());
			pstmt.setString(i++, log.getOperation());
			pstmt.setString(i++, log.getIp());
			pstmt.setString(i++, log.getTime());
			pstmt.setString(i++, log.getStatus());
			pstmt.setString(i++, log.getClassName());
			pstmt.setString(i++, log.getInfo());
			pstmt.setString(i++, log.getLoginID());
			pstmt.setString(i++, log.getLoginName());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
	}
}
