package cn.org.gdicpa.web.service.assesserRegister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.assesserRegister.model.AssesserRegister;

public class AssesserRegisterService {

	private Connection conn = null;
	public AssesserRegisterService(Connection conn){
		this.conn = conn;
	}
	
	
	// id;　loginid;　photo;　officeCode; // 事务所编号  loginName;// --姓名   sex;// --性别  bornDate;// -- 出生日期
	// country;// -- 国籍  nation;// -- 民族  idnumber;// -- 身份证号码  phone;// -- 联系电话  rank;// --专业职称
	// professional;// -- 职称等级  specialty;// --专业  diploma;// -- 学历  retirees;// -- 是否离退休  intobefore;// -- 进事务所前所在单位
	// filestorage;// -- 档案存放单位  intotime;// -- 进事务所时间  auditTime;// -- 从事审计业务时间(月)  iscomanySpecialty;// -- 是否在事务所专职执业
	// seniorityType;// -- 资格取得方式 (考试或者考核或者认定)  certificate;// -- 合格证号或考核（认定）批准文号  timeAndreason;// -- 何时因何原因受到 何种处罚或者处分
	// startTime1;// -- 开始日期1  endTime1;// -- 结束日期1  startTime2;// -- 开始日期2  endTime2;// -- 结束日期2  startTime3;// -- 开始日期3
	// endTime3;// -- 结束日期3  startTime4;// -- 开始日期4  endTime4;// -- 结束日期4  stayCompany1;// -- 所在单位名称1  stayCompany2;// -- 所在单位名称2
	// stayCompany3;// -- 所在单位名称3  stayCompany4;// -- 所在单位名称4  certifier1;// -- 证明人1  certifier2;// -- 证明人2
	// certifier3;// -- 证明人3  certifier4;// -- 证明人4  propertys1;// -- 备用字段1  propertys2;// -- 备用字段2
	
	/**
	 * 根据主键获取对象
	 */
	public AssesserRegister getAssesserRegisterById(String id){
		AssesserRegister ar = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " select * from k_AssesserRegister where id = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			ar = new AssesserRegister();
			if(rs.next()){
				ar.setId(rs.getString("id"));
				ar.setLoginid(rs.getString("loginid"));
				ar.setPhoto(rs.getString("photo"));
				ar.setOfficeCode(rs.getString("officeCode"));
				ar.setLoginName(rs.getString("loginName"));
				ar.setSex(rs.getString("sex"));
				ar.setBornDate(rs.getString("bornDate"));
				ar.setCountry(rs.getString("country"));
				ar.setNation(rs.getString("nation"));
				
				ar.setIdnumber(rs.getString("idnumber"));
				ar.setPhone(rs.getString("phone"));
				ar.setRank(rs.getString("rank"));
				
				ar.setProfessional(rs.getString("professional"));
				ar.setSpecialty(rs.getString("specialty"));
				ar.setDiploma(rs.getString("diploma"));
				ar.setRetirees(rs.getString("retirees"));
				ar.setIntobefore(rs.getString("intobefore"));
				ar.setFilestorage(rs.getString("filestorage"));
				
				ar.setIntotime(rs.getString("intotime"));
				ar.setAuditTime(rs.getString("auditTime"));
				ar.setIscomanySpecialty(rs.getString("isComanySpecialty"));
				ar.setSeniorityType(rs.getString("seniorityType"));
				ar.setCertificate(rs.getString("certificate"));
				ar.setTimeAndreason(rs.getString("timeAndreason"));
				ar.setStartTime1(rs.getString("startTime1"));
				ar.setEndTime1(rs.getString("endTime1"));
				ar.setStartTime2(rs.getString("startTime2"));
				ar.setEndTime2(rs.getString("endTime2"));
				ar.setStartTime3(rs.getString("startTime3"));
				ar.setEndTime3(rs.getString("endTime3"));
				ar.setStartTime4(rs.getString("startTime4"));
				ar.setEndTime4(rs.getString("endTime4"));
				ar.setStayCompany1(rs.getString("stayCompany1"));
				ar.setStayCompany2(rs.getString("stayCompany2"));
				ar.setStayCompany3(rs.getString("stayCompany3"));
				ar.setStayCompany4(rs.getString("stayCompany4"));
				
				ar.setCertifier1(rs.getString("certifier1"));
				ar.setCertifier2(rs.getString("certifier2"));
				ar.setCertifier3(rs.getString("certifier3"));
				ar.setCertifier4(rs.getString("certifier4"));
				
				ar.setPropertys1(rs.getString("propertys1"));
				ar.setPropertys2(rs.getString("propertys2"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
		return ar;
		
	}
	
	
	/**
	 * 多条件获取对象
	 * @param idCardNum
	 * @param loginname
	 * @return
	 */
	public AssesserRegister getAssesserRegisterByMore(String idCardNum,String loginname){
		AssesserRegister ar = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " select * from k_AssesserRegister where loginname=? and idnumber = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginname);
			ps.setString(2, idCardNum);
			rs = ps.executeQuery();
			ar = new AssesserRegister();
			if(rs.next()){
				ar.setId(rs.getString("id"));
				ar.setLoginid(rs.getString("loginid"));
				ar.setPhoto(rs.getString("photo"));
				ar.setOfficeCode(rs.getString("officeCode"));
				ar.setLoginName(rs.getString("loginName"));
				ar.setSex(rs.getString("sex"));
				ar.setBornDate(rs.getString("bornDate"));
				ar.setCountry(rs.getString("country"));
				ar.setNation(rs.getString("nation"));
				
				ar.setIdnumber(rs.getString("idnumber"));
				ar.setPhone(rs.getString("phone"));
				ar.setRank(rs.getString("rank"));
				
				ar.setProfessional(rs.getString("professional"));
				ar.setSpecialty(rs.getString("specialty"));
				ar.setDiploma(rs.getString("diploma"));
				ar.setRetirees(rs.getString("retirees"));
				ar.setIntobefore(rs.getString("intobefore"));
				ar.setFilestorage(rs.getString("filestorage"));
				
				ar.setIntotime(rs.getString("intotime"));
				ar.setAuditTime(rs.getString("auditTime"));
				ar.setIscomanySpecialty(rs.getString("isComanySpecialty"));
				ar.setSeniorityType(rs.getString("seniorityType"));
				ar.setCertificate(rs.getString("certificate"));
				ar.setTimeAndreason(rs.getString("timeAndreason"));
				ar.setStartTime1(rs.getString("startTime1"));
				ar.setEndTime1(rs.getString("endTime1"));
				ar.setStartTime2(rs.getString("startTime2"));
				ar.setEndTime2(rs.getString("endTime2"));
				ar.setStartTime3(rs.getString("startTime3"));
				ar.setEndTime3(rs.getString("endTime3"));
				ar.setStartTime4(rs.getString("startTime4"));
				ar.setEndTime4(rs.getString("endTime4"));
				ar.setStayCompany1(rs.getString("stayCompany1"));
				ar.setStayCompany2(rs.getString("stayCompany2"));
				ar.setStayCompany3(rs.getString("stayCompany3"));
				ar.setStayCompany4(rs.getString("stayCompany4"));
				
				ar.setCertifier1(rs.getString("certifier1"));
				ar.setCertifier2(rs.getString("certifier2"));
				ar.setCertifier3(rs.getString("certifier3"));
				ar.setCertifier4(rs.getString("certifier4"));
				
				ar.setPropertys1(rs.getString("propertys1"));
				ar.setPropertys2(rs.getString("propertys2"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return ar;
	}
	
	
	/**
	 * 自定义条件获取对象
	 * @param idCardNum
	 * @param loginname
	 * @return
	 */
	public AssesserRegister getAssesserRegisterDefineField(String field,String fieldValue){
		AssesserRegister ar = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " select * from k_AssesserRegister where "+field+" = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, fieldValue);
			rs = ps.executeQuery();
			ar = new AssesserRegister();
			if(rs.next()){
				ar.setId(rs.getString("id"));
				ar.setLoginid(rs.getString("loginid"));
				ar.setPhoto(rs.getString("photo"));
				ar.setOfficeCode(rs.getString("officeCode"));
				ar.setLoginName(rs.getString("loginName"));
				ar.setSex(rs.getString("sex"));
				ar.setBornDate(rs.getString("bornDate"));
				ar.setCountry(rs.getString("country"));
				ar.setNation(rs.getString("nation"));
				
				ar.setIdnumber(rs.getString("idnumber"));
				ar.setPhone(rs.getString("phone"));
				ar.setRank(rs.getString("rank"));
				
				ar.setProfessional(rs.getString("professional"));
				ar.setSpecialty(rs.getString("specialty"));
				ar.setDiploma(rs.getString("diploma"));
				ar.setRetirees(rs.getString("retirees"));
				ar.setIntobefore(rs.getString("intobefore"));
				ar.setFilestorage(rs.getString("filestorage"));
				
				ar.setIntotime(rs.getString("intotime"));
				ar.setAuditTime(rs.getString("auditTime"));
				ar.setIscomanySpecialty(rs.getString("isComanySpecialty"));
				ar.setSeniorityType(rs.getString("seniorityType"));
				ar.setCertificate(rs.getString("certificate"));
				ar.setTimeAndreason(rs.getString("timeAndreason"));
				ar.setStartTime1(rs.getString("startTime1"));
				ar.setEndTime1(rs.getString("endTime1"));
				ar.setStartTime2(rs.getString("startTime2"));
				ar.setEndTime2(rs.getString("endTime2"));
				ar.setStartTime3(rs.getString("startTime3"));
				ar.setEndTime3(rs.getString("endTime3"));
				ar.setStartTime4(rs.getString("startTime4"));
				ar.setEndTime4(rs.getString("endTime4"));
				ar.setStayCompany1(rs.getString("stayCompany1"));
				ar.setStayCompany2(rs.getString("stayCompany2"));
				ar.setStayCompany3(rs.getString("stayCompany3"));
				ar.setStayCompany4(rs.getString("stayCompany4"));
				
				ar.setCertifier1(rs.getString("certifier1"));
				ar.setCertifier2(rs.getString("certifier2"));
				ar.setCertifier3(rs.getString("certifier3"));
				ar.setCertifier4(rs.getString("certifier4"));
				
				ar.setPropertys1(rs.getString("propertys1"));
				ar.setPropertys2(rs.getString("propertys2"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return ar;
	}
	
	
	/**
	 * 新增
	 * @param ar
	 */
	public void addAssesserRegister(AssesserRegister ar){
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into k_AssesserRegister (id,loginid,photo,officeCode,loginName,sex,bornDate,country,nation,idnumber,phone,rank,"
			    + " professional,specialty,diploma,retirees,intobefore,filestorage,"
			    + " intotime,auditTime,isComanySpecialty,seniorityType,certificate,timeAndreason,"
			    + " startTime1,endTime1,startTime2,endTime2,startTime3,endTime3,startTime4,endTime4,stayCompany1,stayCompany2,"
			    + " stayCompany3,stayCompany4,certifier1,certifier2,certifier3,certifier4,propertys1,propertys2)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?, ?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, ar.getId());
			ps.setString(i++, ar.getLoginid());
			ps.setString(i++, ar.getPhoto());
			ps.setString(i++, ar.getOfficeCode());
			ps.setString(i++, ar.getLoginName());
			ps.setString(i++, ar.getSex());
			ps.setString(i++, ar.getBornDate());
			ps.setString(i++, ar.getCountry());
			ps.setString(i++, ar.getNation());
			ps.setString(i++, ar.getIdnumber());
			ps.setString(i++, ar.getPhone());
			ps.setString(i++, ar.getRank());
			
			ps.setString(i++, ar.getProfessional());
			ps.setString(i++, ar.getSpecialty());
			ps.setString(i++, ar.getDiploma());
			ps.setString(i++, ar.getRetirees());
			ps.setString(i++, ar.getIntobefore());
			ps.setString(i++, ar.getFilestorage());

			ps.setString(i++, ar.getIntotime());
			ps.setString(i++, ar.getAuditTime());
			ps.setString(i++, ar.getIscomanySpecialty());
			ps.setString(i++, ar.getSeniorityType());
			ps.setString(i++, ar.getCertificate());
			ps.setString(i++, ar.getTimeAndreason());

			ps.setString(i++, ar.getStartTime1());
			ps.setString(i++, ar.getEndTime1());
			ps.setString(i++, ar.getStartTime2());
			ps.setString(i++, ar.getEndTime2());
			ps.setString(i++, ar.getStartTime3());
			ps.setString(i++, ar.getEndTime3());
			ps.setString(i++, ar.getStartTime4());
			ps.setString(i++, ar.getEndTime4()); 
			ps.setString(i++, ar.getStayCompany1());
			ps.setString(i++, ar.getStayCompany2());
			
			ps.setString(i++, ar.getStayCompany3());
		    ps.setString(i++, ar.getStayCompany4());
			ps.setString(i++, ar.getCertifier1());
			ps.setString(i++, ar.getCertifier2());
			ps.setString(i++, ar.getCertifier3());
			ps.setString(i++, ar.getCertifier4());
			ps.setString(i++, ar.getPropertys1());
			ps.setString(i++, ar.getPropertys2());
			
			ps.execute();
			 
		} catch (SQLException e) {
			System.out.println(this.getClass()+"    insert into   sql  ERROR:"+sql);
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
	}
	
	/**
	 * 修改
	 * @param ar
	 */
	public void updateAssesserRegister(AssesserRegister ar){
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update k_AssesserRegister set photo=?,loginName=?,sex=?,bornDate=?,country=?,nation=?,idnumber=?,phone=?,rank=?,"
			    + " professional=?,specialty=?,diploma=?,retirees=?,intobefore=?,filestorage=?,"
			    + " intotime=?,auditTime=?,isComanySpecialty=?,seniorityType=?,certificate=?,timeAndreason=?,"
			    + " startTime1=?,endTime1=?,startTime2=?,endTime2=?,startTime3=?,endTime3=?,startTime4=?,endTime4=?,stayCompany1=?,stayCompany2=?,"
			    + " stayCompany3=?,stayCompany4=?,certifier1=?,certifier2=?,certifier3=?,certifier4=?,propertys1=?,propertys2=? "
				+ " where id = ?";
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, ar.getPhoto());
			ps.setString(i++, ar.getLoginName());
			ps.setString(i++, ar.getSex());
			ps.setString(i++, ar.getBornDate());
			ps.setString(i++, ar.getCountry());
			ps.setString(i++, ar.getNation());
			ps.setString(i++, ar.getIdnumber());
			ps.setString(i++, ar.getPhone());
			ps.setString(i++, ar.getRank());
			
			ps.setString(i++, ar.getProfessional());
			ps.setString(i++, ar.getSpecialty());
			ps.setString(i++, ar.getDiploma());
			ps.setString(i++, ar.getRetirees());
			ps.setString(i++, ar.getIntobefore());
			ps.setString(i++, ar.getFilestorage());

			ps.setString(i++, ar.getIntotime());
			ps.setString(i++, ar.getAuditTime());
			ps.setString(i++, ar.getIscomanySpecialty());
			ps.setString(i++, ar.getSeniorityType());
			ps.setString(i++, ar.getCertificate());
			ps.setString(i++, ar.getTimeAndreason());

			ps.setString(i++, ar.getStartTime1());
			ps.setString(i++, ar.getEndTime1());
			ps.setString(i++, ar.getStartTime2());
			ps.setString(i++, ar.getEndTime2());
			ps.setString(i++, ar.getStartTime3());
			ps.setString(i++, ar.getEndTime3());
			ps.setString(i++, ar.getStartTime4());
			ps.setString(i++, ar.getEndTime4()); 
			ps.setString(i++, ar.getStayCompany1());
			ps.setString(i++, ar.getStayCompany2());

			ps.setString(i++, ar.getStayCompany3());
		    ps.setString(i++, ar.getStayCompany4());
			ps.setString(i++, ar.getCertifier1());
			ps.setString(i++, ar.getCertifier2());
			ps.setString(i++, ar.getCertifier3());
			ps.setString(i++, ar.getCertifier4());
			ps.setString(i++, ar.getPropertys1());
			ps.setString(i++, ar.getPropertys2());
			
			ps.setString(i++, ar.getId());
			
			ps.execute();
			 
		} catch (SQLException e) {
			System.out.println(this.getClass()+"    update sql  ERROR:"+sql);
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
	}
	
	/**
	 * 删除
	 * @param id
	 */
	public void deleteAssesserRegister(String id){
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from k_AssesserRegister where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
	}
	
}
