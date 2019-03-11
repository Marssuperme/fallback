package cn.org.gdicpa.web.service.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.MD5;

public class LoginService {

	private Connection conn = null;

	public LoginService(Connection conn) {
		this.conn = conn;
	}

	/**
	 * 是否可以登录
	 * @param user
	 * @param pass
	 * @return
	 * @throws Exception
	 */
	public String isLogin(String user, String pass,String userType) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			String result = "";
			if("1".equals(userType)){
				//事务所用户
				sql = " select * from k_user where (ctypetabname = 'k_company' or ctypetabname = 'k_assess') and loginId=?  ";
				
			}else{
				sql = " select * from k_user where ctypetabname <> 'k_company' and (loginId=? or assessId=?)  ";
			}
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			if(!"1".equals(userType)){
            	ps.setString(2, user);
            }
			rs = ps.executeQuery();

			if (rs.next()) {
				String pwd = rs.getString("pwd");
				String State = rs.getString("State");

				if (pwd.toLowerCase().equals(MD5.getMD5String(pass.trim()).toLowerCase())) {
					if ("0".equals(State)) {
						result = "0";
					} else {
						result = "用户存在禁用状态，没法登录！";
					}
				} else {
					result = "密码不正确，没法登录！";
				}
			} else {
				sql = " select * from k_user where ctypetabname <> 'k_company' and (loginId=? or assessId=?)  ";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, user);
	            ps.setString(2, user);
				rs = ps.executeQuery();
				
				if (rs.next()) {
					result = "N";
				}else{
					result = "登录名不存在，没法登录！";
				}
				
				
			}

			if ("0".equals(result)) {
				//有卡时检查卡号

			}

			return result;
		} catch (Exception e) {
			System.out.println("登录查询SQL：" + sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
}
