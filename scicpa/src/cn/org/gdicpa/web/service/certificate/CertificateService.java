package cn.org.gdicpa.web.service.certificate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.certificate.model.Certificate;
import cn.org.gdicpa.web.service.micfonoJoinParty.model.MicfonoJoinParty;

public class CertificateService {
private Connection conn = null;
	
	public CertificateService(Connection conn) {
		this.conn = conn;
	}
	
	//id;loginName;//姓名idnumber;//身份证号 suear;//年份 account;//会计 audit;//审计 financial;//财务管理
	//economyLow;//经济法 taxLow;//税法 csrm;//公司战略与风险管理 professional;//专业阶段合格证号 general;//全科合格证号
    //integratedTest;//综合测试 state; initFlag; timeFlag;
	
	/**
	 * 得到 非职业会员入会信息
	 */
	public Certificate getCertificateById(String id){
		Certificate cf = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select * from K_Certificate where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			cf = new Certificate();
			if(rs.next()){
				cf.setId(rs.getString("id"));
				cf.setLoginName(rs.getString("loginName"));
				cf.setIdnumber(rs.getString("idnumber"));
				cf.setSuear(rs.getString("suear"));
				cf.setAccount(rs.getString("account"));
				cf.setAudit(rs.getString("audit"));
				cf.setFinancial(rs.getString("financial"));
				cf.setEconomyLow(rs.getString("economyLow"));
				cf.setTaxLow(rs.getString("taxLow"));
				cf.setCsrm(rs.getString("csrm"));
				cf.setProfessional(rs.getString("professional"));
				cf.setGeneral(rs.getString("general"));
				cf.setIntegratedTest(rs.getString("integratedTest"));
				cf.setState(rs.getString("state"));
				cf.setInitFlag(rs.getString("initFlag"));
				cf.setTimeFlag(rs.getString("timeFlag"));
			}
			
		} catch (SQLException e) {
			System.out.println(this.getClass()+"    query    sql  ERROR:"+sql);
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
		return cf;
	}
	
	/**
	 * 得到 非职业会员入会信息
	 */
	public Certificate getCertificateById(String loginName,String IDNumber ){
		Certificate cf = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select * from K_Certificate where loginName = ? and IDNumber";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginName);
			ps.setString(2, IDNumber);
			rs = ps.executeQuery();
			cf = new Certificate();
			if(rs.next()){
				cf.setId(rs.getString("id"));
				cf.setLoginName(rs.getString("loginName"));
				cf.setIdnumber(rs.getString("idnumber"));
				cf.setSuear(rs.getString("suear"));
				cf.setAccount(rs.getString("account"));
				cf.setAudit(rs.getString("audit"));
				cf.setFinancial(rs.getString("financial"));
				cf.setEconomyLow(rs.getString("economyLow"));
				cf.setTaxLow(rs.getString("taxLow"));
				cf.setCsrm(rs.getString("csrm"));
				cf.setProfessional(rs.getString("professional"));
				cf.setGeneral(rs.getString("general"));
				cf.setIntegratedTest(rs.getString("integratedTest"));
				cf.setState(rs.getString("state"));
				cf.setInitFlag(rs.getString("initFlag"));
				cf.setTimeFlag(rs.getString("timeFlag"));
			}
			
		} catch (SQLException e) {
			System.out.println(this.getClass()+"    query    sql  ERROR:"+sql);
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
		return cf;
	}
	
}
