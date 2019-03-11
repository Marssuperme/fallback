package cn.org.gdicpa.web.service.party;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.party.model.PartyTable;

/**
 * 党员
 * @author yuanbo
 *
 */
public class PartyService {
	private Connection conn = null;
	
	public PartyService(Connection conn) {
		this.conn = conn;
	}
	
	// ID,PartyName,Sex,Post,Department,IDnumber,General,PartyState,JoinDate,RelationParty,BornDate,Marital,
	// Rank,RelationDepart,EMail,Mobile,Phone,Address,Fax,PartyType,LastBy,LastModify,State,CType,DNPXXX,DYJZXX
	
	/**
	 * 得到 党员对象
	 */
	public PartyTable getPartyTableById(String id){
		PartyTable pt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select * from k_party where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			pt = new PartyTable();
			if(rs.next()){
				pt.setId(rs.getString("id"));
				pt.setPartyname(rs.getString("partyname"));
				pt.setSex(rs.getString("sex"));
				pt.setPost(rs.getString("post"));
				pt.setDepartment(rs.getString("department"));
				pt.setIdnumber(rs.getString("idnumber"));
				pt.setGeneral(rs.getString("general"));
				pt.setPartystate(rs.getString("partystate"));
				pt.setJoindate(rs.getString("joindate"));
				pt.setRelationparty(rs.getString("relationparty"));
				
				pt.setBorndate(rs.getString("borndate"));
				pt.setMarital(rs.getString("marital"));
				pt.setRank(rs.getString("rank"));
				pt.setRelationdepart(rs.getString("relationdepart"));
				pt.setEmail(rs.getString("email"));
				pt.setMobile(rs.getString("mobile"));
				pt.setPhone(rs.getString("phone"));
				pt.setAddress(rs.getString("address"));
				pt.setFax(rs.getString("fax"));
				pt.setPartytype(rs.getString("partytype"));
				pt.setLastby(rs.getString("lastby"));
				pt.setLastmodify(rs.getString("lastmodify"));
				
				pt.setState(rs.getString("state"));
				pt.setCtype(rs.getString("ctype"));
				pt.setDnpxxx(rs.getString("dnpxxx"));
				pt.setDyjzxx(rs.getString("dyjzxx"));
				pt.setIsCpa(rs.getString("iscpa"));
			}
			
		} catch (SQLException e) {
			System.out.println(this.getClass()+"    query    sql  ERROR:"+sql);
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
		return pt;
	}
	

	/**
	 * 添加
	 * @param pt
	 */
	public void addParty(PartyTable pt){
		PreparedStatement ps = null;
		String sql = "";
		
		try {
			sql = " insert into k_party (ID,PartyName,Sex,Post,Department,IDnumber,General,PartyState,JoinDate,RelationParty,"
				+ " BornDate,Marital,Rank,RelationDepart,EMail,Mobile,Phone,Address,Fax,PartyType,"
				+ " LastBy,LastModify,State,CType,DNPXXX,DYJZXX,iscpa) "
				+ " values(?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, pt.getId());
			ps.setString(i++, pt.getPartyname());
			ps.setString(i++, pt.getSex());
			ps.setString(i++, pt.getPost());
			ps.setString(i++, pt.getDepartment());
			ps.setString(i++, pt.getIdnumber());
			ps.setString(i++, pt.getGeneral());
			ps.setString(i++, pt.getPartystate());
			
			ps.setString(i++, pt.getJoindate());
			ps.setString(i++, pt.getRelationparty());
			ps.setString(i++, pt.getBorndate());
			ps.setString(i++, pt.getMarital());
			ps.setString(i++, pt.getRank());
			ps.setString(i++, pt.getRelationdepart());
			ps.setString(i++, pt.getEmail());
			ps.setString(i++, pt.getMobile());
			ps.setString(i++, pt.getPhone());
			
			ps.setString(i++, pt.getAddress());
			ps.setString(i++, pt.getFax());
			ps.setString(i++, pt.getPartytype());
			ps.setString(i++, pt.getLastby());
			ps.setString(i++, pt.getLastmodify());
			ps.setString(i++, pt.getState());
			ps.setString(i++, pt.getCtype());
			ps.setString(i++, pt.getDnpxxx());
			ps.setString(i++, pt.getDyjzxx());
			ps.setString(i++, pt.getIsCpa());
			
			ps.execute();
			
		} catch (SQLException e) {
			System.out.println("  SQLException   ERROR:"+e.getMessage());
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
	}
	
	
	/**
	 * 修改
	 * @param pt
	 */
	public void updatePartyById(PartyTable pt){
		PreparedStatement ps = null;
		String sql = "";
		
		try {
			sql = " update k_party set PartyName=?,Sex=?,Post=?,Department=?,IDnumber=?,General=?,PartyState=?,"
				+ " JoinDate=?,RelationParty=?,BornDate=?,Marital=?,Rank=?,RelationDepart=?,EMail=?,Mobile=?,Phone=?,"
				+ " Address=?,Fax=?,PartyType=?,LastBy=?,LastModify=?,State=?,CType=?,DNPXXX=?,DYJZXX=?,iscpa=? " 
				+ " where ID=?";
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, pt.getPartyname());
			ps.setString(i++, pt.getSex());
			ps.setString(i++, pt.getPost());
			ps.setString(i++, pt.getDepartment());
			ps.setString(i++, pt.getIdnumber());
			ps.setString(i++, pt.getGeneral());
			ps.setString(i++, pt.getPartystate());
			
			ps.setString(i++, pt.getJoindate());
			ps.setString(i++, pt.getRelationparty());
			ps.setString(i++, pt.getBorndate());
			ps.setString(i++, pt.getMarital());
			ps.setString(i++, pt.getRank());
			ps.setString(i++, pt.getRelationdepart());
			ps.setString(i++, pt.getEmail());
			ps.setString(i++, pt.getMobile());
			ps.setString(i++, pt.getPhone());
			
			ps.setString(i++, pt.getAddress());
			ps.setString(i++, pt.getFax());
			ps.setString(i++, pt.getPartytype());
			ps.setString(i++, pt.getLastby());
			ps.setString(i++, pt.getLastmodify());
			ps.setString(i++, pt.getState());
			ps.setString(i++, pt.getCtype());
			ps.setString(i++, pt.getDnpxxx());
			ps.setString(i++, pt.getDyjzxx());
			ps.setString(i++, pt.getIsCpa());
			
			ps.setString(i++, pt.getId());
			
			ps.execute();
			
		} catch (SQLException e) {
			System.out.println("  SQLException   ERROR:"+e.getMessage());
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
	}
	
	/**
	 * 删除
	 * @param id
	 */
	public void deletePartyTableById(String id){
		PreparedStatement ps = null;
		String sql = "";
		
		try {
			sql = "delete from k_party where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("  SQLException   ERROR:"+e.getMessage());
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
	}
	
	
	public Map get(String sql) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;		
		try {
			Map map = null;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();	
			if(rs.next()){
				map = new HashMap();
				
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					map.put(RSMD.getColumnLabel(i).toLowerCase() , rs.getObject(RSMD.getColumnLabel(i)));
				}
			}
			
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
	}
	
}
