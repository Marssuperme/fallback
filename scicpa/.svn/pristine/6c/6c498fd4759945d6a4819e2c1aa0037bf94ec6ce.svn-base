package cn.org.gdicpa.web.service.director;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.director.model.DirectorTable;

public class DirectorService {
	private Connection conn;
	public DirectorService(Connection conn){
		this.conn = conn;
	}
	
	
	/**
	 * 根据编号得到实体对象的方法
	 * @param loginid
	 * @return
	 * @throws Exception
	 */
	public DirectorTable getDirectorTableById(String loginid) throws Exception{
		DbUtil.checkConn(conn);
		DirectorTable directortable = null;
		ResultSet rs = null;
		PreparedStatement ps =null;
		try {
			String sql = " select loginid,loginName,pwd,state,ctype,ctypetabName,email,mobile,phone,workunits"
					   + " from K_Director where loginid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginid);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				directortable = new DirectorTable();
				directortable.setLoginid(rs.getString(i++));
				directortable.setLoginName(rs.getString(i++));
				directortable.setPwd(rs.getString(i++));
				directortable.setState(rs.getString(i++));
				directortable.setCtype(rs.getString(i++));
				directortable.setCtypetabName(rs.getString(i++));
				directortable.setEmail(rs.getString(i++));
				directortable.setMobile(rs.getString(i++));
				directortable.setPhone(rs.getString(i++));
				directortable.setWorkunits(rs.getString(i++));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
		return directortable;
	}
	
	
	/**
	 * 根据编号修改对实体对象的方法
	 * @param directortable
	 * @return
	 * @throws Exception
	 */
	public boolean updateDirectorTableById(DirectorTable directortable) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		try {
			String sql = " update K_Director set loginName=?,state=?,ctype=?,ctypetabName=?,"
					   + " email=?,mobile=?,phone=?,workunits=?"
				   	   + " where loginid = ?";
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, directortable.getLoginName());
			//ps.setString(i++, directortable.getPwd());
			ps.setString(i++, directortable.getState());
			ps.setString(i++, directortable.getCtype());
			ps.setString(i++, directortable.getCtypetabName());
			ps.setString(i++, directortable.getEmail());
			ps.setString(i++, directortable.getMobile());
			ps.setString(i++, directortable.getPhone());
			ps.setString(i++, directortable.getWorkunits());
			ps.setString(i++, directortable.getLoginid());
			
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
