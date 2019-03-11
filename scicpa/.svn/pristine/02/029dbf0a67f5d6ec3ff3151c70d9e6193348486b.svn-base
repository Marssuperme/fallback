package cn.org.gdicpa.web.service.candidates;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.candidates.model.Candidates;

public class CandidateService {
private Connection conn = null;
	
	public CandidateService(Connection conn) {
		this.conn = conn;
	}

	//  id;	applyNumber; //报名序号 netNumber;//网报序号  loginID; loginName;//姓名 idnumber;//身份证号
	//   ticketNumber;//准考证号  roomNo;//考场号  seatNo;//座位号  email;//电子邮箱  phone;//电话号码  mobile;//手机号码
	//   address;//通讯地址 post;//邮政编码 idtype;//证件类型 sex;//性别 nation;//民族 political;//政治面貌 dducation;//学历
	//   title;//职称 specialty;//专业大类 specialty2;//专业 professional;//职业 area;//地区
	//    syear;//考试年份 cpa;//CPA号   initFlag; timeFlag;
	
	/**
	 * 得到 考生信息
	 */
	public Candidates getCandidatesById(String id){
		Candidates cd = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select * from k_Candidates where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			cd = new Candidates();
			if(rs.next()){
				cd.setId(rs.getString("id"));
				cd.setApplyNumber(rs.getString("applyNumber"));
				cd.setNetNumber(rs.getString("netNumber"));
				cd.setLoginID(rs.getString("loginID"));
				cd.setLoginName(rs.getString("loginName"));
				cd.setIdnumber(rs.getString("idnumber"));
				cd.setTicketNumber(rs.getString("ticketNumber"));
				cd.setRoomNo(rs.getString("roomNo"));
				cd.setSeatNo(rs.getString("seatNo"));
				cd.setEmail(rs.getString("email"));
				cd.setPhone(rs.getString("phone"));
				cd.setMobile(rs.getString("mobile"));
				
				cd.setAddress(rs.getString("address"));
				cd.setPost(rs.getString("post"));
				cd.setIdtype(rs.getString("idtype"));
				cd.setSex(rs.getString("sex"));
				cd.setNation(rs.getString("nation"));
				cd.setPolitical(rs.getString("political"));
				cd.setEducation(rs.getString("education"));
				
				cd.setTitle(rs.getString("title"));
				cd.setSpecialty(rs.getString("specialty"));
				cd.setSpecialty2(rs.getString("specialty2"));
				cd.setProfessional(rs.getString("professional"));
				cd.setArea(rs.getString("area"));
				cd.setSyear(rs.getString("syear"));
				cd.setCpa(rs.getString("cpa"));
				cd.setInitFlag(rs.getString("initFlag"));
				cd.setTimeFlag(rs.getString("timeFlag"));
				
			}
			
		} catch (SQLException e) {
			System.out.println(this.getClass()+"    query    sql  ERROR:"+sql);
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
		return cd;
	}
	
	/**
	 * 得到 考生信息
	 */
	public Candidates getCandidatesByMore(String name,String idCardNum){
		Candidates cd = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select * from k_Candidates where loginname = ? and idnumber = ? order by syear desc";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, idCardNum);
			rs = ps.executeQuery();
			cd = new Candidates();
			if(rs.next()){
				cd.setId(rs.getString("id"));
				cd.setApplyNumber(rs.getString("applyNumber"));
				cd.setNetNumber(rs.getString("netNumber"));
				cd.setLoginID(rs.getString("loginID"));
				cd.setLoginName(rs.getString("loginName"));
				cd.setIdnumber(rs.getString("idnumber"));
				cd.setTicketNumber(rs.getString("ticketNumber"));
				cd.setRoomNo(rs.getString("roomNo"));
				cd.setSeatNo(rs.getString("seatNo"));
				cd.setEmail(rs.getString("email"));
				cd.setPhone(rs.getString("phone"));
				cd.setMobile(rs.getString("mobile"));
				
				cd.setAddress(rs.getString("address"));
				cd.setPost(rs.getString("post"));
				cd.setIdtype(rs.getString("idtype"));
				cd.setSex(rs.getString("sex"));
				cd.setNation(rs.getString("nation"));
				cd.setPolitical(rs.getString("political"));
				cd.setEducation(rs.getString("education"));
				
				cd.setTitle(rs.getString("title"));
				cd.setSpecialty(rs.getString("specialty"));
				cd.setSpecialty2(rs.getString("specialty2"));
				cd.setProfessional(rs.getString("professional"));
				cd.setArea(rs.getString("area"));
				cd.setSyear(rs.getString("syear"));
				cd.setCpa(rs.getString("cpa"));
				cd.setInitFlag(rs.getString("initFlag"));
				cd.setTimeFlag(rs.getString("timeFlag"));
			}
			
		} catch (SQLException e) {
			System.out.println(this.getClass()+"    query    sql  ERROR:"+sql);
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
		return cd;
	}
	
}
