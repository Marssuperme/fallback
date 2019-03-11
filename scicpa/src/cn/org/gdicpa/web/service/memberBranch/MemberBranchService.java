package cn.org.gdicpa.web.service.memberBranch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.memberBranch.model.MemberBranchTable;

public class MemberBranchService {
	private Connection conn = null;
	
	public MemberBranchService() {
	}
	public MemberBranchService(Connection conn) {
		this.conn = conn;
	}
	
	/**
	 * 得到团组织信息
	 */
	public Map getBranch(String officeCode) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Map map = new HashMap();
			String sql = "select a.OfficeCode,a.OfficeName,a.area," +
					"b.id,b.branchname,b.builddate,b.branchtype,b.secretaryname,b.mobile,b.phone,b.iscreate,b.linkman,b.membernum,b.cpanum " +
					"from k_company a left join k_memberBranch b on a.loginid=b.officecode where a.loginid=?";
			ps = conn.prepareStatement(sql);
	        ps.setString(1, officeCode);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = null;
			RSMD = rs.getMetaData();
			if(rs.next()){
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					map.put(RSMD.getColumnLabel(i).toLowerCase() , rs.getObject(RSMD.getColumnLabel(i)));
				}
			}
			
//			String membernum = new DbUtil(conn).queryForString("select count(*) from k_member where officecode=?", new Object[]{officeCode});;
//			
//			String cpanum = new DbUtil(conn).queryForString("select count(*) from k_member where officecode=? and isCicpa='是'", new Object[]{officeCode});;
//			map.put("membernum", membernum);
//			map.put("cpanum", cpanum);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	public void saveOrUpdate(MemberBranchTable memberBranch) throws Exception{
		if(memberBranch.getId()==null || "".equals(memberBranch.getId())){
			// 生成 id 主键
			String guid = UUID.randomUUID().toString();
			String sql = "insert into K_MemberBranch (id,phone,branchtype,officecode,iscreate,linkman,builddate,branchname,secretaryname,mobile,lastby,lastmodify,area,membernum,cpanum,pid,pname) " +
					"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				int i = 1;
				pstmt.setString(i++, guid);
				pstmt.setString(i++, memberBranch.getPhone());
				pstmt.setString(i++, memberBranch.getBranchtype());
				pstmt.setString(i++, memberBranch.getOfficecode());
				pstmt.setString(i++, memberBranch.getIsCreate());
				pstmt.setString(i++, memberBranch.getLinkMan());
				pstmt.setString(i++, memberBranch.getBuilddate());
				pstmt.setString(i++, memberBranch.getBranchname());
				pstmt.setString(i++, memberBranch.getSecretaryName());
				pstmt.setString(i++, memberBranch.getMobile());
				pstmt.setString(i++, memberBranch.getLastby());
				pstmt.setString(i++, memberBranch.getLastmodify());
				pstmt.setString(i++, memberBranch.getArea());
				pstmt.setInt(i++, memberBranch.getMemberNum());
				pstmt.setInt(i++, memberBranch.getCpaNum());
				pstmt.setString(i++, memberBranch.getPid());
				pstmt.setString(i++, memberBranch.getPname());
				int count = pstmt.executeUpdate();
				
				System.out.println("-------------------------------->:"+count);
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			} finally{
				DbUtil.close(pstmt);
			}
		}else{
			String sql = "update K_MemberBranch set phone=?,branchtype=?,officecode=?,iscreate=?,linkman=?," +
					"builddate=?,branchname=?,secretaryname=?,mobile=?,lastby=?,lastmodify=?,area=?,membernum=?,cpanum=?,pid=?,pname=? where id=?";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				int i = 1;
				pstmt.setString(i++, memberBranch.getPhone());
				pstmt.setString(i++, memberBranch.getBranchtype());
				pstmt.setString(i++, memberBranch.getOfficecode());
				pstmt.setString(i++, memberBranch.getIsCreate());
				pstmt.setString(i++, memberBranch.getLinkMan());
				pstmt.setString(i++, memberBranch.getBuilddate());
				pstmt.setString(i++, memberBranch.getBranchname());
				pstmt.setString(i++, memberBranch.getSecretaryName());
				pstmt.setString(i++, memberBranch.getMobile());
				pstmt.setString(i++, memberBranch.getLastby());
				pstmt.setString(i++, memberBranch.getLastmodify());
				pstmt.setString(i++, memberBranch.getArea());
				pstmt.setInt(i++, memberBranch.getMemberNum());
				pstmt.setInt(i++, memberBranch.getCpaNum());
				pstmt.setString(i++, memberBranch.getPid());
				pstmt.setString(i++, memberBranch.getPname());
				
				pstmt.setString(i++, memberBranch.getId());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			} finally{
				DbUtil.close(pstmt);
			}
		}		
	}
	
	public MemberBranchTable getByCofficeCode(String officeCode){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberBranchTable memberBranch = null;
		try {
			String sql = "select ID,BranchName,BranchType,OfficeCode,Area from K_MemberBranch where OfficeCode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, officeCode);
			rs = pstmt.executeQuery();
			while(rs.next()){
				memberBranch = new MemberBranchTable();
				memberBranch.setId(rs.getString("ID"));
				memberBranch.setBranchname(rs.getString("BranchName"));
				memberBranch.setBranchtype(rs.getString("BranchType"));
				memberBranch.setOfficecode(rs.getString("OfficeCode"));
				memberBranch.setArea(rs.getString("Area"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(pstmt);
			DbUtil.close(rs);
		}
		
		return memberBranch;
	}
}
