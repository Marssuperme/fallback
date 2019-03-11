package cn.org.gdicpa.web.service.partyNo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.partyNo.model.PartyNoTable;

public class PartyNoService {
private Connection conn = null ;
	
	public PartyNoService(Connection conn){
		this.conn = conn;
	}
	
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public PartyNoTable getPartyNo(String id) {
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		PartyNoTable pt = new PartyNoTable();
		try {
			String sql = " select id,customerName,officeCode,area,loginName, "
					   + " sex,bornDate,iscpa,diploma,politics, "
					   + " relation,rank,rankNum,department,departRank, "
					   + " phone,mobile,joinParty,partyRank,remark,nation "
					   + " from k_partyno where id=? ";
			ps = conn.prepareStatement(sql) ;
			ps.setString(1, id) ;
			rs = ps.executeQuery() ;
			if(rs.next()) {
				
				pt.setId(rs.getString("id"));
				pt.setCustomerName(rs.getString("customerName"));
				pt.setOfficeCode(rs.getString("officeCode"));
				pt.setArea(rs.getString("area")) ;
				pt.setLoginName(rs.getString("loginName"));
				
				pt.setSex(rs.getString("sex"));
				pt.setBornDate(rs.getString("bornDate"));
				pt.setIscpa(rs.getString("iscpa"));
				pt.setDiploma(rs.getString("diploma"));
				pt.setPolitics(rs.getString("politics"));
				
				pt.setRelation(rs.getString("relation"));
				pt.setRank(rs.getString("rank"));
				pt.setRankNum(rs.getString("rankNum"));
				pt.setDepartment(rs.getString("department"));
				pt.setDepartRank(rs.getString("departRank"));
				
				pt.setPhone(rs.getString("phone"));
				pt.setMobile(rs.getString("mobile"));
				pt.setJoinParty(rs.getString("joinParty"));
				pt.setPartyRank(rs.getString("partyRank"));
				pt.setRemark(rs.getString("remark"));
				pt.setNation(rs.getString("nation"));
				
			}
			System.out.println(pt.getNation()+"-----------------");
			return pt ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
		return pt;
	}
	
	/**
	 * 添加
	 * @param pt
	 */
	public boolean addPartyNo(PartyNoTable pt) {
		boolean bl = true;
		PreparedStatement ps = null ;
		try {
			String sql = " insert into k_partyno(id,customerName,officeCode,area,loginName, "
					   + " sex,bornDate,iscpa,diploma,politics, "
					   + " relation,rank,rankNum,department,departRank, "
					   + " phone,mobile,joinParty,partyRank,remark,nation) " 
					   + " values(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?,?)";
			int i = 1;
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(i++,pt.getId());
			ps.setString(i++,pt.getCustomerName());
			ps.setString(i++,pt.getOfficeCode());
			ps.setString(i++,pt.getArea());
			ps.setString(i++,pt.getLoginName());
			
			ps.setString(i++,pt.getSex());
			ps.setString(i++,pt.getBornDate());
			ps.setString(i++,pt.getIscpa());
			ps.setString(i++,pt.getDiploma());
			ps.setString(i++,pt.getPolitics());
			
			ps.setString(i++,pt.getRelation());
			ps.setString(i++,pt.getRank());
			ps.setString(i++,pt.getRankNum());
			ps.setString(i++,pt.getDepartment());
			ps.setString(i++,pt.getDepartRank());
			
			ps.setString(i++,pt.getPhone());
			ps.setString(i++,pt.getMobile());
			ps.setString(i++,pt.getJoinParty());
			ps.setString(i++,pt.getPartyRank());
			ps.setString(i++,pt.getRemark());
			ps.setString(i++, pt.getNation());
			
			ps.execute();
			
		}catch(Exception e) {
			bl = false;
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
		
		return bl;
	}
	
	
	/**
	 * 修改
	 * @param pt
	 */
	public boolean updatePartyNo(PartyNoTable pt) {
		boolean bl = true;
		PreparedStatement ps = null ;
		try {
			String sql = " update k_partyno set customerName=?,officeCode=?,area=?,loginName=?,sex=?, "
					   + " bornDate=?,iscpa=?,diploma=?,politics=?,relation=?, "
					   + " rank=?,rankNum=?,department=?,departRank=?,phone=?, "
					   + " mobile=?,joinParty=?,partyRank=?,remark=?,nation=? " 
					   + " where id = ? ";
			
			ps = conn.prepareStatement(sql);
			
			int i = 1;
			
			ps.setString(i++,pt.getCustomerName());
			ps.setString(i++,pt.getOfficeCode());
			ps.setString(i++,pt.getArea());
			ps.setString(i++,pt.getLoginName());
			ps.setString(i++,pt.getSex());
			
			ps.setString(i++,pt.getBornDate());
			ps.setString(i++,pt.getIscpa());
			ps.setString(i++,pt.getDiploma());
			ps.setString(i++,pt.getPolitics());
			ps.setString(i++,pt.getRelation());
			
			ps.setString(i++,pt.getRank());
			ps.setString(i++,pt.getRankNum());
			ps.setString(i++,pt.getDepartment());
			ps.setString(i++,pt.getDepartRank());
			ps.setString(i++,pt.getPhone());
			
			ps.setString(i++,pt.getMobile());
			ps.setString(i++,pt.getJoinParty());
			ps.setString(i++,pt.getPartyRank());
			ps.setString(i++,pt.getRemark());
			ps.setString(i++,pt.getNation());
			
			ps.setString(i++,pt.getId());
			
			ps.execute();
			
		}catch(Exception e) {
			bl = false;
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
		return bl;
	}
	
	/**
	 * 删除
	 * @param id
	 */
	public void delPartyNo(String id) {
		PreparedStatement ps = null ;
		try {
			String sql = " delete from k_partyno where id=? ";
			ps = conn.prepareStatement(sql) ;
			ps.setString(1,id) ;
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(ps) ;
		}
	}
	
}
