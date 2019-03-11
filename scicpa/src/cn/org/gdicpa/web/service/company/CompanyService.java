package cn.org.gdicpa.web.service.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.company.model.CompanyTable;

public class CompanyService {
	private Connection conn;
	public CompanyService(Connection conn){
		this.conn = conn;
	}
	
	
	/**
	 * 根据编号得到实体对象的方法
	 * @param loginid
	 * @return
	 * @throws Exception
	 */
	public CompanyTable getCompanyTableById(String loginid) throws Exception{
		DbUtil.checkConn(conn);
		CompanyTable companytable = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try{
			String sql = " select loginid,loginName,pwd,state,ctype,ctypetabName,"
					   + " officeCode,officeName,organization,email,postcode,address,phone,"
					   + " postalcode,approvalNumber,approval,approvalAuthority,tax,"
					   + " business,businessTime,capital,corporate,corporatePhone,remark,"
					   + " scale,employees,lastmodified,lastpeople,cpa,other,area,linkman,oldLoginId from K_Company"
					   + " where loginid = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginid);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				companytable = new CompanyTable();
				companytable.setLoginid(rs.getString(i++));
				companytable.setLoginName(rs.getString(i++));
				companytable.setPwd(rs.getString(i++));
				companytable.setState(rs.getString(i++));
				companytable.setCtype(rs.getString(i++));
				companytable.setCtypetabName(rs.getString(i++));
				companytable.setOfficeCode(rs.getString(i++));
				companytable.setOfficeName(rs.getString(i++));
				companytable.setOrganization(rs.getString(i++));
				companytable.setEmail(rs.getString(i++));
				companytable.setPostcode(rs.getString(i++));
				companytable.setAddress(rs.getString(i++));
				companytable.setPhone(rs.getString(i++));
				companytable.setPostalcode(rs.getString(i++));
				companytable.setApprovalNumber(rs.getString(i++));
				companytable.setApproval(rs.getString(i++));
				companytable.setApprovalAuthority(rs.getString(i++));
				companytable.setTax(rs.getString(i++));
				companytable.setBusiness(rs.getString(i++));
				companytable.setBusinessTime(rs.getString(i++));
				companytable.setCapital(rs.getString(i++));
				companytable.setCorporate(rs.getString(i++));
				companytable.setCorporatePhone(rs.getString(i++));
				companytable.setRemark(rs.getString(i++));
				companytable.setScale(rs.getString(i++));
				companytable.setEmployees(rs.getString(i++));
				companytable.setLastmodified(rs.getString(i++));
				companytable.setLastpeople(rs.getString(i++));
				companytable.setCpa(rs.getString(i++));
				companytable.setOther(rs.getString(i++));
				companytable.setArea(rs.getString(i++));
				companytable.setLinkman(rs.getString(i++));
				companytable.setOldLoginId(rs.getString(i++));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return companytable;
	}
	
	
	/**
	 * 根据编号修改的方法
	 * @param companytable
	 * @return
	 * @throws Exception
	 */
	public boolean updateCompanyTableById(CompanyTable companytable) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		try{
			String sql = " update K_Company set loginName=?,pwd=?,state=?,ctype=?,ctypetabName=?,"
					   + " officeCode=?,officeName=?,organization=?,email=?,postcode=?,address=?,phone=?,"
					   + " postalcode=?,approvalNumber=?,approval=?,approvalAuthority=?,tax=?,"
					   + " business=?,businessTime=?,capital=?,corporate=?,corporatePhone=?,remark=?,"
					   + " scale=?,employees=?,lastmodified=?,lastpeople=?,cpa=?,other=?,oldLoginId=? "
					   + " where loginid = ? ";
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, companytable.getLoginName());
			ps.setString(i++, companytable.getPwd());
			ps.setString(i++, companytable.getState());
			ps.setString(i++, companytable.getCtype());
			ps.setString(i++, companytable.getCtypetabName());
			ps.setString(i++, companytable.getOfficeCode());
			ps.setString(i++, companytable.getOfficeName());
			ps.setString(i++, companytable.getOrganization());
			ps.setString(i++, companytable.getEmail());
			ps.setString(i++, companytable.getPostcode());
			ps.setString(i++, companytable.getAddress());
			ps.setString(i++, companytable.getPhone());
			ps.setString(i++, companytable.getPostalcode());
			ps.setString(i++, companytable.getApprovalNumber());
			ps.setString(i++, companytable.getApproval());
			ps.setString(i++, companytable.getApprovalAuthority());
			ps.setString(i++, companytable.getTax());
			ps.setString(i++, companytable.getBusiness());
			ps.setString(i++, companytable.getBusinessTime());
			ps.setString(i++, companytable.getCapital());
			ps.setString(i++, companytable.getCorporate());
			ps.setString(i++, companytable.getCorporatePhone());
			ps.setString(i++, companytable.getRemark());
			ps.setString(i++, companytable.getScale());
			ps.setString(i++, companytable.getEmployees());
			ps.setString(i++, companytable.getLastmodified());
			ps.setString(i++, companytable.getLastpeople());
			ps.setString(i++, companytable.getCpa());
			ps.setString(i++, companytable.getOther());
			ps.setString(i++, companytable.getOldLoginId());//增加旧ID
			ps.setString(i++, companytable.getLoginid());
			
			ps.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		return false;
	}
}
