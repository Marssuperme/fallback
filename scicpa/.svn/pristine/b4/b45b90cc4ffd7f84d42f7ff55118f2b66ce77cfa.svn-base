package cn.org.gdicpa.web.service.micfoRegister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.micfoRegister.model.MicfoRegister;

public class MicfoRegisterService {

	private Connection conn = null;
	public MicfoRegisterService(Connection conn){
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
	public MicfoRegister getMicfoRegisterById(String id){
		MicfoRegister mr = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " select * from k_micfoRegister where id = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			mr = new MicfoRegister();
			if(rs.next()){
				mr.setId(rs.getString("id"));
				mr.setLoginid(rs.getString("loginid"));
				mr.setPhoto(rs.getString("photo"));
				mr.setOfficeCode(rs.getString("officeCode"));
				mr.setLoginName(rs.getString("loginName"));
				mr.setSex(rs.getString("sex"));
				mr.setBornDate(rs.getString("bornDate"));
				mr.setCountry(rs.getString("country"));
				mr.setNation(rs.getString("nation"));
				
				mr.setIdnumber(rs.getString("idnumber"));
				mr.setPhone(rs.getString("phone"));
				mr.setRank(rs.getString("rank"));
				
				mr.setProfessional(rs.getString("professional"));
				mr.setSpecialty(rs.getString("specialty"));
				mr.setDiploma(rs.getString("diploma"));
				mr.setRetirees(rs.getString("retirees"));
				mr.setIntobefore(rs.getString("intobefore"));
				mr.setFilestorage(rs.getString("filestorage"));
				
				mr.setIntotime(rs.getString("intotime"));
				mr.setAuditTime(rs.getString("auditTime"));
				mr.setIscomanySpecialty(rs.getString("isComanySpecialty"));
				mr.setSeniorityType(rs.getString("seniorityType"));
				mr.setCertificate(rs.getString("certificate"));
				mr.setTimeAndreason(rs.getString("timeAndreason"));
				mr.setStartTime1(rs.getString("startTime1"));
				mr.setEndTime1(rs.getString("endTime1"));
				mr.setStartTime2(rs.getString("startTime2"));
				mr.setEndTime2(rs.getString("endTime2"));
				mr.setStartTime3(rs.getString("startTime3"));
				mr.setEndTime3(rs.getString("endTime3"));
				mr.setStartTime4(rs.getString("startTime4"));
				mr.setEndTime4(rs.getString("endTime4"));
				mr.setStayCompany1(rs.getString("stayCompany1"));
				mr.setStayCompany2(rs.getString("stayCompany2"));
				mr.setStayCompany3(rs.getString("stayCompany3"));
				mr.setStayCompany4(rs.getString("stayCompany4"));
				
				mr.setCertifier1(rs.getString("certifier1"));
				mr.setCertifier2(rs.getString("certifier2"));
				mr.setCertifier3(rs.getString("certifier3"));
				mr.setCertifier4(rs.getString("certifier4"));
				
				mr.setPropertys1(rs.getString("propertys1"));
				mr.setPropertys2(rs.getString("propertys2"));
				mr.setCPApermitno(rs.getString("CPApermitno"));
				mr.setApprove(rs.getString("approve"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
		return mr;
		
	}
	
	
	/**
	 * 多条件获取对象
	 * @param idCardNum
	 * @param loginname
	 * @return
	 */
	public MicfoRegister getMicfoRegisterByMore(String idCardNum,String loginname){
		MicfoRegister mr = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " select * from  k_micfoRegister  where loginname=? and idnumber = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginname);
			ps.setString(2, idCardNum);
			rs = ps.executeQuery();
			mr = new MicfoRegister();
			if(rs.next()){
				mr.setId(rs.getString("id"));
				mr.setLoginid(rs.getString("loginid"));
				mr.setPhoto(rs.getString("photo"));
				mr.setOfficeCode(rs.getString("officeCode"));
				mr.setLoginName(rs.getString("loginName"));
				mr.setSex(rs.getString("sex"));
				mr.setBornDate(rs.getString("bornDate"));
				mr.setCountry(rs.getString("country"));
				mr.setNation(rs.getString("nation"));
				
				mr.setIdnumber(rs.getString("idnumber"));
				mr.setPhone(rs.getString("phone"));
				mr.setRank(rs.getString("rank"));
				
				mr.setProfessional(rs.getString("professional"));
				mr.setSpecialty(rs.getString("specialty"));
				mr.setDiploma(rs.getString("diploma"));
				mr.setRetirees(rs.getString("retirees"));
				mr.setIntobefore(rs.getString("intobefore"));
				mr.setFilestorage(rs.getString("filestorage"));
				
				mr.setIntotime(rs.getString("intotime"));
				mr.setAuditTime(rs.getString("auditTime"));
				mr.setIscomanySpecialty(rs.getString("isComanySpecialty"));
				mr.setSeniorityType(rs.getString("seniorityType"));
				mr.setCertificate(rs.getString("certificate"));
				mr.setTimeAndreason(rs.getString("timeAndreason"));
				mr.setStartTime1(rs.getString("startTime1"));
				mr.setEndTime1(rs.getString("endTime1"));
				mr.setStartTime2(rs.getString("startTime2"));
				mr.setEndTime2(rs.getString("endTime2"));
				mr.setStartTime3(rs.getString("startTime3"));
				mr.setEndTime3(rs.getString("endTime3"));
				mr.setStartTime4(rs.getString("startTime4"));
				mr.setEndTime4(rs.getString("endTime4"));
				mr.setStayCompany1(rs.getString("stayCompany1"));
				mr.setStayCompany2(rs.getString("stayCompany2"));
				mr.setStayCompany3(rs.getString("stayCompany3"));
				mr.setStayCompany4(rs.getString("stayCompany4"));
				
				mr.setCertifier1(rs.getString("certifier1"));
				mr.setCertifier2(rs.getString("certifier2"));
				mr.setCertifier3(rs.getString("certifier3"));
				mr.setCertifier4(rs.getString("certifier4"));
				
				mr.setPropertys1(rs.getString("propertys1"));
				mr.setPropertys2(rs.getString("propertys2"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return mr;
	}
	
	
	/**
	 * 自定义条件获取对象
	 * @param idCardNum
	 * @param loginname
	 * @return
	 */
	public MicfoRegister getMicfoRegisterDefineField(String field,String fieldValue){
		MicfoRegister mr = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " select * from  k_micfoRegister  where "+field+" = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, fieldValue);
			rs = ps.executeQuery();
			mr = new MicfoRegister();
			if(rs.next()){
				mr.setId(rs.getString("id"));
				mr.setLoginid(rs.getString("loginid"));
				mr.setPhoto(rs.getString("photo"));
				mr.setOfficeCode(rs.getString("officeCode"));
				mr.setLoginName(rs.getString("loginName"));
				mr.setSex(rs.getString("sex"));
				mr.setBornDate(rs.getString("bornDate"));
				mr.setCountry(rs.getString("country"));
				mr.setNation(rs.getString("nation"));
				
				mr.setIdnumber(rs.getString("idnumber"));
				mr.setPhone(rs.getString("phone"));
				mr.setRank(rs.getString("rank"));
				
				mr.setProfessional(rs.getString("professional"));
				mr.setSpecialty(rs.getString("specialty"));
				mr.setDiploma(rs.getString("diploma"));
				mr.setRetirees(rs.getString("retirees"));
				mr.setIntobefore(rs.getString("intobefore"));
				mr.setFilestorage(rs.getString("filestorage"));
				
				mr.setIntotime(rs.getString("intotime"));
				mr.setAuditTime(rs.getString("auditTime"));
				mr.setIscomanySpecialty(rs.getString("isComanySpecialty"));
				mr.setSeniorityType(rs.getString("seniorityType"));
				mr.setCertificate(rs.getString("certificate"));
				mr.setTimeAndreason(rs.getString("timeAndreason"));
				mr.setStartTime1(rs.getString("startTime1"));
				mr.setEndTime1(rs.getString("endTime1"));
				mr.setStartTime2(rs.getString("startTime2"));
				mr.setEndTime2(rs.getString("endTime2"));
				mr.setStartTime3(rs.getString("startTime3"));
				mr.setEndTime3(rs.getString("endTime3"));
				mr.setStartTime4(rs.getString("startTime4"));
				mr.setEndTime4(rs.getString("endTime4"));
				mr.setStayCompany1(rs.getString("stayCompany1"));
				mr.setStayCompany2(rs.getString("stayCompany2"));
				mr.setStayCompany3(rs.getString("stayCompany3"));
				mr.setStayCompany4(rs.getString("stayCompany4"));
				
				mr.setCertifier1(rs.getString("certifier1"));
				mr.setCertifier2(rs.getString("certifier2"));
				mr.setCertifier3(rs.getString("certifier3"));
				mr.setCertifier4(rs.getString("certifier4"));
				
				mr.setPropertys1(rs.getString("propertys1"));
				mr.setPropertys2(rs.getString("propertys2"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return mr;
	}
	
	
	/**
	 * 新增
	 * @param mr
	 */
	public void addMicfoRegister(MicfoRegister mr){
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " insert into k_micfoRegister (id,loginid,photo,officeCode,loginName,sex,bornDate,country,nation,idnumber,phone,rank,"
			    + " professional,specialty,diploma,retirees,intobefore,filestorage,"
			    + " intotime,auditTime,isComanySpecialty,seniorityType,certificate,timeAndreason,"
			    + " startTime1,endTime1,startTime2,endTime2,startTime3,endTime3,startTime4,endTime4,stayCompany1,stayCompany2,"
			    + " stayCompany3,stayCompany4,certifier1,certifier2,certifier3,certifier4,propertys1,propertys2,CPApermitno,approve)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?, ?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, mr.getId());
			ps.setString(i++, mr.getLoginid());
			ps.setString(i++, mr.getPhoto());
			ps.setString(i++, mr.getOfficeCode());
			ps.setString(i++, mr.getLoginName());
			ps.setString(i++, mr.getSex());
			ps.setString(i++, mr.getBornDate());
			ps.setString(i++, mr.getCountry());
			ps.setString(i++, mr.getNation());
			ps.setString(i++, mr.getIdnumber());
			ps.setString(i++, mr.getPhone());
			ps.setString(i++, mr.getRank());
			
			ps.setString(i++, mr.getProfessional());
			ps.setString(i++, mr.getSpecialty());
			ps.setString(i++, mr.getDiploma());
			ps.setString(i++, mr.getRetirees());
			ps.setString(i++, mr.getIntobefore());
			ps.setString(i++, mr.getFilestorage());

			ps.setString(i++, mr.getIntotime());
			ps.setString(i++, mr.getAuditTime());
			ps.setString(i++, mr.getIscomanySpecialty());
			ps.setString(i++, mr.getSeniorityType());
			ps.setString(i++, mr.getCertificate());
			ps.setString(i++, mr.getTimeAndreason());

			ps.setString(i++, mr.getStartTime1());
			ps.setString(i++, mr.getEndTime1());
			ps.setString(i++, mr.getStartTime2());
			ps.setString(i++, mr.getEndTime2());
			ps.setString(i++, mr.getStartTime3());
			ps.setString(i++, mr.getEndTime3());
			ps.setString(i++, mr.getStartTime4());
			ps.setString(i++, mr.getEndTime4()); 
			ps.setString(i++, mr.getStayCompany1());
			ps.setString(i++, mr.getStayCompany2());
			
			ps.setString(i++, mr.getStayCompany3());
		    ps.setString(i++, mr.getStayCompany4());
			ps.setString(i++, mr.getCertifier1());
			ps.setString(i++, mr.getCertifier2());
			ps.setString(i++, mr.getCertifier3());
			ps.setString(i++, mr.getCertifier4());
			ps.setString(i++, mr.getPropertys1());
			ps.setString(i++, mr.getPropertys2());
			ps.setString(i++, mr.getCPApermitno());
			ps.setString(i++, mr.getApprove());
			
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
	 * @param mr
	 */
	public void updateMicfoRegister(MicfoRegister mr){
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update k_micfoRegister set loginid=?,photo=?,loginName=?,sex=?,bornDate=?,country=?,nation=?,idnumber=?,phone=?,rank=?,"
			    + " professional=?,specialty=?,diploma=?,retirees=?,intobefore=?,filestorage=?,"
			    + " intotime=?,auditTime=?,isComanySpecialty=?,seniorityType=?,certificate=?,timeAndreason=?,"
			    + " startTime1=?,endTime1=?,startTime2=?,endTime2=?,startTime3=?,endTime3=?,startTime4=?,endTime4=?,stayCompany1=?,stayCompany2=?,"
			    + " stayCompany3=?,stayCompany4=?,certifier1=?,certifier2=?,certifier3=?,certifier4=?,propertys1=?,propertys2=?,CPApermitno=?,approve=? "
				+ " where id = ?";
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, mr.getLoginid());
			ps.setString(i++, mr.getPhoto());
			ps.setString(i++, mr.getLoginName());
			ps.setString(i++, mr.getSex());
			ps.setString(i++, mr.getBornDate());
			ps.setString(i++, mr.getCountry());
			ps.setString(i++, mr.getNation());
			ps.setString(i++, mr.getIdnumber());
			ps.setString(i++, mr.getPhone());
			ps.setString(i++, mr.getRank());
			
			ps.setString(i++, mr.getProfessional());
			ps.setString(i++, mr.getSpecialty());
			ps.setString(i++, mr.getDiploma());
			ps.setString(i++, mr.getRetirees());
			ps.setString(i++, mr.getIntobefore());
			ps.setString(i++, mr.getFilestorage());

			ps.setString(i++, mr.getIntotime());
			ps.setString(i++, mr.getAuditTime());
			ps.setString(i++, mr.getIscomanySpecialty());
			ps.setString(i++, mr.getSeniorityType());
			ps.setString(i++, mr.getCertificate());
			ps.setString(i++, mr.getTimeAndreason());

			ps.setString(i++, mr.getStartTime1());
			ps.setString(i++, mr.getEndTime1());
			ps.setString(i++, mr.getStartTime2());
			ps.setString(i++, mr.getEndTime2());
			ps.setString(i++, mr.getStartTime3());
			ps.setString(i++, mr.getEndTime3());
			ps.setString(i++, mr.getStartTime4());
			ps.setString(i++, mr.getEndTime4()); 
			ps.setString(i++, mr.getStayCompany1());
			ps.setString(i++, mr.getStayCompany2());

			ps.setString(i++, mr.getStayCompany3());
		    ps.setString(i++, mr.getStayCompany4());
			ps.setString(i++, mr.getCertifier1());
			ps.setString(i++, mr.getCertifier2());
			ps.setString(i++, mr.getCertifier3());
			ps.setString(i++, mr.getCertifier4());
			ps.setString(i++, mr.getPropertys1());
			ps.setString(i++, mr.getPropertys2());
			ps.setString(i++, mr.getCPApermitno());
			ps.setString(i++, mr.getApprove());
			
			ps.setString(i++, mr.getId());
			
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
	public void deleteMicfoRegister(String id){
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " delete from k_micfoRegister where id = ?";
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
