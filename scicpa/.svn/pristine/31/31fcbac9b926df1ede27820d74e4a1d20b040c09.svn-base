package cn.org.gdicpa.web.service.companyList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.companyList.model.CompanyListTable;

public class CompanyListService {
	private Connection conn;
	public CompanyListService(Connection conn){
		this.conn = conn;
	}
	
	
	/**
	 * 根据编号得到对象的方法
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	public CompanyListTable getCompanyListTable(String guid) throws Exception{
		DbUtil.checkConn(conn);
		CompanyListTable clt = new CompanyListTable();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select guid,loginid,companyName,languageSelectName,person,phone,faxes,post,address,email,url,area"
				+ " from BB_companyList where guid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, guid);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				clt.setGuid(rs.getString(i++));
				clt.setLoginid(rs.getString(i++));
				clt.setCompanyName(rs.getString(i++));
				clt.setLanguageSelectName(rs.getString(i++));
				clt.setPerson(rs.getString(i++));
				clt.setPhone(rs.getString(i++));
				clt.setFaxes(rs.getString(i++));
				clt.setPost(rs.getString(i++));
				clt.setAddress(rs.getString(i++));
				clt.setEmail(rs.getString(i++));
				clt.setUrl(rs.getString(i++));
				clt.setArea(rs.getString(i++));
			}
			return clt;
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
	public boolean addCompanyListTable(CompanyListTable clt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into BB_companyList (guid,loginid,companyName,languageSelectName,person,phone,faxes,post,address,email,url,area)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?)";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, clt.getGuid());
			ps.setString(i++, clt.getLoginid());
			ps.setString(i++, clt.getCompanyName());
			ps.setString(i++, clt.getLanguageSelectName());
			ps.setString(i++, clt.getPerson());
			ps.setString(i++, clt.getPhone());
			ps.setString(i++, clt.getFaxes());
			ps.setString(i++, clt.getPost());
			ps.setString(i++, clt.getAddress());
			ps.setString(i++, clt.getEmail());
			ps.setString(i++, clt.getUrl());
			ps.setString(i++, clt.getArea());
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
	public boolean updateCompanyListTable(CompanyListTable clt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update BB_companyList set companyName=?,languageSelectName=?,person=?,phone=?,faxes=?," 
				+ " post=?,address=?,email=?,url=?,area=? where guid=? ";
			int i = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(i++, clt.getCompanyName());
			ps.setString(i++, clt.getLanguageSelectName());
			ps.setString(i++, clt.getPerson());
			ps.setString(i++, clt.getPhone());
			ps.setString(i++, clt.getFaxes());
			ps.setString(i++, clt.getPost());
			ps.setString(i++, clt.getAddress());
			ps.setString(i++, clt.getEmail());
			ps.setString(i++, clt.getUrl());
			ps.setString(i++, clt.getArea());
			ps.setString(i++, clt.getGuid());
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
	public boolean deleteCompanyListTable(String GUID) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = "select count(*) from BB_CONTENT1 where companyguid  = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1,GUID);
			rs = ps.executeQuery();
			if(rs.next()){
				int count = rs.getInt(1);
				if(count > 1) return true; //有多条报备时，不删除BB_companyList
			}
			DbUtil.close(rs);
			DbUtil.close(ps);
			
			sql = " delete from BB_companyList where GUID = ?" ;
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
