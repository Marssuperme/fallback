package cn.org.gdicpa.web.service.reportValidate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.reportValidate.model.ReportValidateTable;

public class ReportValidateService {
	private Connection conn = null;
	public ReportValidateService(Connection conn){
		this.conn = conn;
	}
	
	
	/**
	 * 根据编号得到对象的方法
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ReportValidateTable getReportValidateTableById(String id) throws Exception{
		ReportValidateTable rvt = new ReportValidateTable();
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select id,loginid,applicantName,carefulName,customerContributeType,licenceNumber,"
				+ " customerEconomicQuality,carefulRegisteMoney,customerTradeType,chargeName,"
				+ " goEnterprise,contactPerson,registeAddress,phone,giveProjectType,"
				+ " businessAgreeNumber,agreeDate,reportNumber,projectName,signTeacherType,"  
				+ " helpmate,signTeacherOne,signTeacherTwo,registAccountant,signTeacherThree,"
				+ " signTeacherFour,signTeacherFive,signTeacherSix,reportDate,reportYear,"  
				+ " reportCount,shouldMoney,hadMoney,openInvoiceNumber,chargDiscription,payDate,"
				+ " payAccording,enterpriseNote,bussinessType,officeName,registMoneyType,"   
				+ " laterMessage,testResult,applicationTax,acceptTaxOffice,foreignNumber,"
				+ " currency,testCurrency,testType,moneyBreakType,reportAddviseType,consultProject,"
				+ " clearType,auditType,auditReportType,agencyProject,otherProject"
				+ " from k_reportValidate where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			int i = 1;
			if(rs.next()){
				 rvt.setId(rs.getString(i++));
				 rvt.setLoginid(rs.getString(i++));
				 rvt.setApplicantName(rs.getString(i++));
				 rvt.setCarefulName(rs.getString(i++));
				 rvt.setCustomerContributeType(rs.getString(i++));
				 rvt.setLicenceNumber(rs.getString(i++));
				 rvt.setCustomerEconomicQuality(rs.getString(i++));
				 rvt.setCarefulRegisteMoney(rs.getString(i++));
				 rvt.setCustomerTradeType(rs.getString(i++));
				 rvt.setChargeName(rs.getString(i++));
				 rvt.setGoEnterprise(rs.getString(i++));
				 rvt.setContactPerson(rs.getString(i++));
				 rvt.setRegisteAddress(rs.getString(i++));
				 rvt.setPhone(rs.getString(i++));
				 rvt.setGiveProjectType(rs.getString(i++));
				 rvt.setBusinessAgreeNumber(rs.getString(i++));
				 rvt.setAgreeDate(rs.getString(i++));
				 rvt.setReportNumber(rs.getString(i++));
				 rvt.setProjectName(rs.getString(i++));
				 rvt.setSignTeacherType(rs.getString(i++));
				 rvt.setHelpmate(rs.getString(i++));
				 rvt.setSignTeacherOne(rs.getString(i++));
				 rvt.setSignTeacherTwo(rs.getString(i++));
				 rvt.setRegistAccountant(rs.getString(i++));
				 rvt.setSignTeacherThree(rs.getString(i++));
				 rvt.setSignTeacherFour(rs.getString(i++));
				 rvt.setSignTeacherFive(rs.getString(i++));
				 rvt.setSignTeacherSix(rs.getString(i++));
				 rvt.setReportDate(rs.getString(i++));
				 rvt.setReportYear(rs.getString(i++));
				 rvt.setReportCount(rs.getString(i++));
				 rvt.setShouldMoney(rs.getString(i++));
				 rvt.setHadMoney(rs.getString(i++));
				 rvt.setOpenInvoiceNumber(rs.getString(i++));
				 rvt.setChargDiscription(rs.getString(i++));
				 rvt.setPayDate(rs.getString(i++));
				 rvt.setPayAccording(rs.getString(i++));
				 rvt.setEnterpriseNote(rs.getString(i++));
				 rvt.setBussinessType(rs.getString(i++));
				 rvt.setOfficeName(rs.getString(i++));
				 rvt.setRegistMoneyType(rs.getString(i++));
				 rvt.setLaterMessage(rs.getString(i++));
				 rvt.setTestResult(rs.getString(i++));
				 rvt.setApplicationTax(rs.getString(i++));
				 rvt.setAcceptTaxOffice(rs.getString(i++));
				 rvt.setForeignNumber(rs.getString(i++));
				 rvt.setCurrency(rs.getString(i++));
				 rvt.setTestCurrency(rs.getString(i++));
				 rvt.setTestType(rs.getString(i++));
				 rvt.setMoneyBreakType(rs.getString(i++));
				 rvt.setReportAddviseType(rs.getString(i++));
				 rvt.setConsultProject(rs.getString(i++));
				 rvt.setClearType(rs.getString(i++));
				 rvt.setAuditType(rs.getString(i++));
				 rvt.setAuditReportType(rs.getString(i++));
				 rvt.setAgencyProject(rs.getString(i++));
				 rvt.setOtherProject(rs.getString(i++));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return rvt;
	}
	
	/**
	 * 增加
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	public boolean addReportValidateTable(ReportValidateTable rvt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into k_reportValidate("
				+ " id,loginid,applicantName,carefulName,customerContributeType,licenceNumber," 
				+ " customerEconomicQuality,carefulRegisteMoney,customerTradeType,chargeName," 
				+ " goEnterprise,contactPerson,registeAddress,phone,giveProjectType," 
				+ " businessAgreeNumber,agreeDate,reportNumber,projectName,signTeacherType," 
				+ " helpmate,signTeacherOne,signTeacherTwo,registAccountant,signTeacherThree," 
				+ " signTeacherFour,signTeacherFive,signTeacherSix,reportDate,reportYear," 
				+ " reportCount,shouldMoney,hadMoney,openInvoiceNumber,chargDiscription,payDate," 
				+ " payAccording,enterpriseNote,bussinessType,officeName,registMoneyType," 
				+ " laterMessage,testResult,applicationTax,acceptTaxOffice,foreignNumber," 
				+ " currency,testCurrency,testType,moneyBreakType,reportAddviseType,consultProject," 
				+ " clearType,auditType,auditReportType,agencyProject,otherProject)"     
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, UUID.randomUUID().toString());
			ps.setString(i++, rvt.getLoginid());
			ps.setString(i++, rvt.getApplicantName());
			ps.setString(i++, rvt.getCarefulName());
			ps.setString(i++, rvt.getCustomerContributeType());
			ps.setString(i++, rvt.getLicenceNumber());
			ps.setString(i++, rvt.getCustomerEconomicQuality());
			ps.setString(i++, rvt.getCarefulRegisteMoney());
			ps.setString(i++, rvt.getCustomerTradeType());
			ps.setString(i++, rvt.getChargeName());
		    ps.setString(i++, rvt.getGoEnterprise());
			ps.setString(i++, rvt.getContactPerson());
			ps.setString(i++, rvt.getRegisteAddress());
			ps.setString(i++, rvt.getPhone());
			ps.setString(i++, rvt.getGiveProjectType());
			ps.setString(i++, rvt.getBusinessAgreeNumber());
			ps.setString(i++, rvt.getAgreeDate());
			ps.setString(i++, rvt.getReportNumber());
			ps.setString(i++, rvt.getProjectName());
			ps.setString(i++, rvt.getSignTeacherType());
			ps.setString(i++, rvt.getHelpmate());
			ps.setString(i++, rvt.getSignTeacherOne());
			ps.setString(i++, rvt.getSignTeacherTwo());
			ps.setString(i++, rvt.getRegistAccountant());
			ps.setString(i++, rvt.getSignTeacherThree());
			ps.setString(i++, rvt.getSignTeacherFour());
			ps.setString(i++, rvt.getSignTeacherFive());
			ps.setString(i++, rvt.getSignTeacherSix());
			ps.setString(i++, rvt.getReportDate());
			ps.setString(i++, rvt.getReportYear());
			ps.setString(i++, rvt.getReportCount());
			ps.setString(i++, rvt.getShouldMoney());
			ps.setString(i++, rvt.getHadMoney());
			ps.setString(i++, rvt.getOpenInvoiceNumber());
			ps.setString(i++, rvt.getChargDiscription());
			ps.setString(i++, rvt.getPayDate());
			ps.setString(i++, rvt.getPayAccording());
			ps.setString(i++, rvt.getEnterpriseNote());
			ps.setString(i++, rvt.getBussinessType());
			ps.setString(i++, rvt.getOfficeName());
			ps.setString(i++, rvt.getRegistMoneyType());
			ps.setString(i++, rvt.getLaterMessage());
			ps.setString(i++, rvt.getTestResult());
			ps.setString(i++, rvt.getApplicationTax());
			ps.setString(i++, rvt.getAcceptTaxOffice());
			ps.setString(i++, rvt.getForeignNumber());
			ps.setString(i++, rvt.getCurrency());
			ps.setString(i++, rvt.getTestCurrency());
			ps.setString(i++, rvt.getTestType());
			ps.setString(i++, rvt.getMoneyBreakType());
			ps.setString(i++, rvt.getReportAddviseType());
			ps.setString(i++, rvt.getConsultProject());
			ps.setString(i++, rvt.getClearType());
			ps.setString(i++, rvt.getAuditType());
			ps.setString(i++, rvt.getAuditReportType());
			ps.setString(i++, rvt.getAgencyProject());
			ps.setString(i++, rvt.getOtherProject());
			
			ps.execute();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		return false;
	}
	
	
	/**
	 * 修改
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	public boolean updateReportValidateTable(ReportValidateTable rvt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update k_reportValidate set"
				+ " applicantName=?,carefulName=?,customerContributeType=?,licenceNumber=?,"
				+ " customerEconomicQuality=?,carefulRegisteMoney=?,customerTradeType=?,chargeName=?,"
				+ " goEnterprise=?,contactPerson=?,registeAddress=?,phone=?,giveProjectType=?,"
				+ " businessAgreeNumber=?,agreeDate=?,reportNumber=?,projectName=?,signTeacherType=?,"
				+ " helpmate=?,signTeacherOne=?,signTeacherTwo=?,registAccountant=?,signTeacherThree=?,"
				+ " signTeacherFour=?,signTeacherFive=?,signTeacherSix=?,reportDate=?,reportYear=?,"
				+ " reportCount=?,shouldMoney=?,hadMoney=?,openInvoiceNumber=?,chargDiscription=?,payDate=?,"
				+ " payAccording=?,enterpriseNote=?,bussinessType=?,officeName=?,registMoneyType=?,"
				+ " laterMessage=?,testResult=?,applicationTax=?,acceptTaxOffice=?,foreignNumber=?,"
				+ " currency=?,testCurrency=?,testType=?,moneyBreakType=?,reportAddviseType=?,consultProject=?,"
				+ " clearType=?,auditType=?,auditReportType=?,agencyProject=?,otherProject=?"
				+ " where id = ?" ;
			ps = conn.prepareStatement(sql);
			int i = 1;
			
			ps.setString(i++, rvt.getApplicantName());
			ps.setString(i++, rvt.getCarefulName());
			ps.setString(i++, rvt.getCustomerContributeType());
			ps.setString(i++, rvt.getLicenceNumber());
			ps.setString(i++, rvt.getCustomerEconomicQuality());
			ps.setString(i++, rvt.getCarefulRegisteMoney());
			ps.setString(i++, rvt.getCustomerTradeType());
			ps.setString(i++, rvt.getChargeName());
		    ps.setString(i++, rvt.getGoEnterprise());
			ps.setString(i++, rvt.getContactPerson());
			ps.setString(i++, rvt.getRegisteAddress());
			ps.setString(i++, rvt.getPhone());
			ps.setString(i++, rvt.getGiveProjectType());
			ps.setString(i++, rvt.getBusinessAgreeNumber());
			ps.setString(i++, rvt.getAgreeDate());
			ps.setString(i++, rvt.getReportNumber());
			ps.setString(i++, rvt.getProjectName());
			ps.setString(i++, rvt.getSignTeacherType());
			ps.setString(i++, rvt.getHelpmate());
			ps.setString(i++, rvt.getSignTeacherOne());
			ps.setString(i++, rvt.getSignTeacherTwo());
			ps.setString(i++, rvt.getRegistAccountant());
			ps.setString(i++, rvt.getSignTeacherThree());
			ps.setString(i++, rvt.getSignTeacherFour());
			ps.setString(i++, rvt.getSignTeacherFive());
			ps.setString(i++, rvt.getSignTeacherSix());
			ps.setString(i++, rvt.getReportDate());
			ps.setString(i++, rvt.getReportYear());
			ps.setString(i++, rvt.getReportCount());
			ps.setString(i++, rvt.getShouldMoney());
			ps.setString(i++, rvt.getHadMoney());
			ps.setString(i++, rvt.getOpenInvoiceNumber());
			ps.setString(i++, rvt.getChargDiscription());
			ps.setString(i++, rvt.getPayDate());
			ps.setString(i++, rvt.getPayAccording());
			ps.setString(i++, rvt.getEnterpriseNote());
			ps.setString(i++, rvt.getBussinessType());
			ps.setString(i++, rvt.getOfficeName());
			ps.setString(i++, rvt.getRegistMoneyType());
			ps.setString(i++, rvt.getLaterMessage());
			ps.setString(i++, rvt.getTestResult());
			ps.setString(i++, rvt.getApplicationTax());
			ps.setString(i++, rvt.getAcceptTaxOffice());
			ps.setString(i++, rvt.getForeignNumber());
			ps.setString(i++, rvt.getCurrency());
			ps.setString(i++, rvt.getTestCurrency());
			ps.setString(i++, rvt.getTestType());
			ps.setString(i++, rvt.getMoneyBreakType());
			ps.setString(i++, rvt.getReportAddviseType());
			ps.setString(i++, rvt.getConsultProject());
			ps.setString(i++, rvt.getClearType());
			ps.setString(i++, rvt.getAuditType());
			ps.setString(i++, rvt.getAuditReportType());
			ps.setString(i++, rvt.getAgencyProject());
			ps.setString(i++, rvt.getOtherProject());
			ps.setString(i++, rvt.getId());
			
			ps.execute();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
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
	public boolean deleteReportValidateTable(String id) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from k_reportValidate where id = ?" ;
			ps = conn.prepareStatement(sql);
			ps.setString(1,id);
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
