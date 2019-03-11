package cn.org.gdicpa.web.service.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.member.model.MemberTable;

public class MemberService {
	private Connection conn = null;
	public MemberService(Connection conn) {
		this.conn = conn;
	}
	public void save(MemberTable mt) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			String sql ="insert into K_Member (id,partyname,officecode,nation,borndate,ismembercadre," +
			"post,iscicpa,sex,education,rank,mobile,lastby,lastmodify) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			int i = 1;
			pstmt.setString(i++, mt.getId());
			pstmt.setString(i++, mt.getMemberName());
			pstmt.setString(i++, mt.getOfficeCode());
			pstmt.setString(i++, mt.getNation());
			pstmt.setString(i++, mt.getBorndate());
			pstmt.setString(i++, mt.getIsMemberCadre());
			pstmt.setString(i++, mt.getPost());
			pstmt.setString(i++, mt.getIsCicpa());
			pstmt.setString(i++, mt.getSex());
			pstmt.setString(i++, mt.getEducation());
			pstmt.setString(i++, mt.getRank());
			pstmt.setString(i++, mt.getMobile());
			pstmt.setString(i++, mt.getLastby());
			pstmt.setString(i++, mt.getLastmodify());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally{
			DbUtil.close(pstmt);
		}
	}
	public Map get(String sql,String id) {
		Map<String,String> map = new HashMap<String,String>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				map.put("memberid", StringUtil.showNull(rs.getString("id")));
				map.put("membername", StringUtil.showNull(rs.getString("partyname")));
				map.put("officecode", StringUtil.showNull(rs.getString("officecode")));
				map.put("loginname", StringUtil.showNull(rs.getString("officename")));
				map.put("mobile", StringUtil.showNull(rs.getString("mobile")));
				map.put("sex", StringUtil.showNull(rs.getString("sex")));
				map.put("borndate", StringUtil.showNull(rs.getString("borndate")));
				map.put("rank", StringUtil.showNull(rs.getString("rank")));
				map.put("nation", StringUtil.showNull(rs.getString("nation")));
				map.put("education", StringUtil.showNull(rs.getString("education")));
				map.put("iscicpa", StringUtil.showNull(rs.getString("iscicpa")));
				map.put("ismembercadre", StringUtil.showNull(rs.getString("ismembercadre")));
				map.put("memberpost", StringUtil.showNull(rs.getString("post")));
			}
			System.out.println("---------------------------->\n"+map);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
		}
		return map;
	}
	public void update(MemberTable mt) {
		String sql = "update K_Member set partyname=?,officecode=?,nation=?,borndate=?,ismembercadre=?," +
				"post=?,iscicpa=?,sex=?,education=?,rank=?,mobile=?,lastby=?,lastmodify=? where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			int i = 1;
			pstmt.setString(i++, mt.getMemberName());
			pstmt.setString(i++, mt.getOfficeCode());
			pstmt.setString(i++, mt.getNation());
			pstmt.setString(i++, mt.getBorndate());
			pstmt.setString(i++, mt.getIsMemberCadre());
			pstmt.setString(i++, mt.getPost());
			pstmt.setString(i++, mt.getIsCicpa());
			pstmt.setString(i++, mt.getSex());
			pstmt.setString(i++, mt.getEducation());
			pstmt.setString(i++, mt.getRank());
			pstmt.setString(i++, mt.getMobile());
			pstmt.setString(i++, mt.getLastby());
			pstmt.setString(i++, mt.getLastmodify());
			pstmt.setString(i++, mt.getId());
			pstmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			DbUtil.close(pstmt);
		}
	}
	public void deleteMemberTableById(String id) {
		String sql = "delete from K_Member where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			sql = "delete from K_MemberPost where pid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			DbUtil.close(pstmt);
		}
	}
}
