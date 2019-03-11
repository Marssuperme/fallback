package cn.org.gdicpa.web.service.micfonoJoinParty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.micfonoJoinParty.model.MicfonoJoinParty;

public class MicfonoJoinPartyService {
	private Connection conn = null;
	
	public MicfonoJoinPartyService(Connection conn) {
		this.conn = conn;
	}

	// id; loginid; loginName;// --姓名  sex;// --性别 photo;// --照片  credentials;// -- 证件类型  credentialsNum;// --证件号  oldName;// --曾用名
	// oldCredenttialsNum;// --曾用身份证号码  seniorityType;// --资格取得方式  certificate2;// -- 全科合格证号  bornDate;// -- 出生日期
	// area;// -- 所在地区  nation;// -- 民族  politics;// --政治面貌  phone;// -- 联系电话  mobile;// -- 手机  email;// -- 电子邮件
	// ownership;// -- 单位性质  workunits ;// -- 工作单位  istired;// -- 是否离退休  address;// -- 通信地址  postcode;// -- 邮政编码
	// bornAddress;// -- 户口所在地  passYear;// -- 全科合格年份  educational;// -- 毕业院校  specialty;// --专业
	// diploma ;// -- 学历  degree;// -- 学位  languagelevel ;// -- 外语程度  rank ;// --专业职称  professional ;// -- 职称等级
	// initFlag;  timeFlag;
	
	/**
	 * 得到 非职业会员入会信息
	 */
	public MicfonoJoinParty getMicfonoJoinPartyById(String id){
		MicfonoJoinParty mjp = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select * from k_MicfonoJoinParty where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			mjp = new MicfonoJoinParty();
			if(rs.next()){
				mjp.setId(rs.getString("id"));
				mjp.setLoginid(rs.getString("loginid"));
				mjp.setLoginName(rs.getString("loginName"));
				mjp.setSex(rs.getString("sex"));
				mjp.setPhone(rs.getString("phone"));
				mjp.setCredentials(rs.getString("credentials"));
				mjp.setCredentialsNum(rs.getString("credentialsNum"));
				mjp.setOldName(rs.getString("oldName"));
				mjp.setOldCredenttialsNum(rs.getString("oldCredenttialsNum"));
				mjp.setSeniorityType(rs.getString("seniorityType"));
				mjp.setCertificate2(rs.getString("certificate2"));
				mjp.setBornDate(rs.getString("bornDate"));
				mjp.setArea(rs.getString("area"));
				mjp.setNation(rs.getString("nation"));
				mjp.setPolitics(rs.getString("politics"));
				mjp.setPhone(rs.getString("phone"));
				mjp.setMobile(rs.getString("mobile"));
				mjp.setEmail(rs.getString("email"));
				
				mjp.setOwnership(rs.getString("ownership"));
				mjp.setWorkunits(rs.getString("workunits"));
				mjp.setIstired(rs.getString("istired"));
				mjp.setAddress(rs.getString("address"));
				mjp.setPostcode(rs.getString("postcode"));
				mjp.setBornAddress(rs.getString("bornAddress"));
				mjp.setPassYear(rs.getString("passYear"));
				mjp.setEducational(rs.getString("educational"));
				mjp.setSpecialty(rs.getString("specialty"));
				mjp.setDiploma(rs.getString("diploma"));
				mjp.setDegree(rs.getString("degree"));
				mjp.setLanguagelevel(rs.getString("languagelevel"));
				mjp.setRank(rs.getString("rank"));
				mjp.setProfessional(rs.getString("professional"));
				mjp.setInitFlag(rs.getString("initFlag"));
				mjp.setTimeFlag(rs.getString("timeFlag"));
				
			}
			
		} catch (SQLException e) {
			System.out.println(this.getClass()+"    query    sql  ERROR:"+sql);
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
		return mjp;
	}
	
	/**
	 * 得到 非职业会员入会信息
	 */
	public MicfonoJoinParty getMicfonoJoinPartyByMore(String name,String idCardNum,String syear){
		MicfonoJoinParty mjp = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select * from k_MicfonoJoinParty where loginname = ? and (credentialsNum = ? or oldCredenttialsNum = ? ) and passYear = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, idCardNum);
			ps.setString(3, idCardNum);
			ps.setString(4, syear);
			rs = ps.executeQuery();
			mjp = new MicfonoJoinParty();
			if(rs.next()){
				mjp.setId(rs.getString("id"));
				mjp.setLoginid(rs.getString("loginid"));
				mjp.setLoginName(rs.getString("loginName"));
				mjp.setSex(rs.getString("sex"));
				mjp.setPhone(rs.getString("phone"));
				mjp.setCredentials(rs.getString("credentials"));
				mjp.setCredentialsNum(rs.getString("credentialsNum"));
				mjp.setOldName(rs.getString("oldName"));
				mjp.setOldCredenttialsNum(rs.getString("oldCredenttialsNum"));
				mjp.setSeniorityType(rs.getString("seniorityType"));
				mjp.setCertificate2(rs.getString("certificate2"));
				mjp.setBornDate(rs.getString("bornDate"));
				mjp.setArea(rs.getString("area"));
				mjp.setNation(rs.getString("nation"));
				mjp.setPolitics(rs.getString("politics"));
				mjp.setPhone(rs.getString("phone"));
				mjp.setMobile(rs.getString("mobile"));
				mjp.setEmail(rs.getString("email"));
				
				mjp.setOwnership(rs.getString("ownership"));
				mjp.setWorkunits(rs.getString("workunits"));
				mjp.setIstired(rs.getString("istired"));
				mjp.setAddress(rs.getString("address"));
				mjp.setPostcode(rs.getString("postcode"));
				mjp.setBornAddress(rs.getString("bornAddress"));
				mjp.setPassYear(rs.getString("passYear"));
				mjp.setEducational(rs.getString("educational"));
				mjp.setSpecialty(rs.getString("specialty"));
				mjp.setDiploma(rs.getString("diploma"));
				mjp.setDegree(rs.getString("degree"));
				mjp.setLanguagelevel(rs.getString("languagelevel"));
				mjp.setRank(rs.getString("rank"));
				mjp.setProfessional(rs.getString("professional"));
				mjp.setInitFlag(rs.getString("initFlag"));
				mjp.setTimeFlag(rs.getString("timeFlag"));
			}
		} catch (SQLException e) {
			System.out.println(this.getClass()+"    query    sql  ERROR:"+sql);
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
		return mjp;
	}
	
	
	/**
	 * 新增
	 */
	public boolean addMicfonoJoinParty(MicfonoJoinParty mjp){
		PreparedStatement ps = null;
		String sql = "";
		boolean bl = true;
		try {
			// id; loginid; loginName;// --姓名  sex;// --性别 photo;// --照片  credentials;// -- 证件类型  credentialsNum;// --证件号  oldName;// --曾用名
			// oldCredenttialsNum;// --曾用身份证号码  seniorityType;// --资格取得方式  certificate2;// -- 全科合格证号  bornDate;// -- 出生日期
			// area;// -- 所在地区  nation;// -- 民族  politics;// --政治面貌  phone;// -- 联系电话  mobile;// -- 手机  email;// -- 电子邮件
			// ownership;// -- 单位性质  workunits ;// -- 工作单位  istired;// -- 是否离退休  address;// -- 通信地址  postcode;// -- 邮政编码
			// bornAddress;// -- 户口所在地  passYear;// -- 全科合格年份  educational;// -- 毕业院校  specialty;// --专业
			// diploma ;// -- 学历  degree;// -- 学位  languagelevel ;// -- 外语程度  rank ;// --专业职称  professional ;// -- 职称等级
			// initFlag;  timeFlag;
			sql = " insert into k_MicfonoJoinParty (id,loginid,loginName,sex,photo,credentials,credentialsNum,"
				+ " oldName,oldCredenttialsNum,seniorityType,certificate2,bornDate,area,nation,politics,phone,mobile,email,"
				+ " ownership,workunits,isTired,address,postcode,bornAddress,passYear,educational,specialty,diploma,degree,"
				+ " languagelevel,rank,professional,initFlag,timeFlag, state,createDate)"
				+ " values(?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?, ?,?)";
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, mjp.getId());
			ps.setString(i++, mjp.getLoginid());
			ps.setString(i++, mjp.getLoginName());
			ps.setString(i++, mjp.getSex());
			ps.setString(i++, mjp.getPhoto());
			ps.setString(i++, mjp.getCredentials());
			ps.setString(i++, mjp.getCredentialsNum());
			
			ps.setString(i++, mjp.getOldName());
			ps.setString(i++, mjp.getOldCredenttialsNum());
			ps.setString(i++, mjp.getSeniorityType());
			ps.setString(i++, mjp.getCertificate2());
			ps.setString(i++, mjp.getBornDate());
			ps.setString(i++, mjp.getArea());
			ps.setString(i++, mjp.getNation());
			ps.setString(i++, mjp.getPolitics());
			ps.setString(i++, mjp.getPhone());
			ps.setString(i++, mjp.getMobile());
			ps.setString(i++, mjp.getEmail());

			ps.setString(i++, mjp.getOwnership());
			ps.setString(i++, mjp.getWorkunits());
			ps.setString(i++, mjp.getIstired());
			ps.setString(i++, mjp.getAddress());
			ps.setString(i++, mjp.getPostcode());
			ps.setString(i++, mjp.getBornAddress());
			ps.setString(i++, mjp.getPassYear());
			ps.setString(i++, mjp.getEducational());
			ps.setString(i++, mjp.getSpecialty());
			ps.setString(i++, mjp.getDiploma());
			ps.setString(i++, mjp.getDegree());

			ps.setString(i++, mjp.getLanguagelevel());
			ps.setString(i++, mjp.getRank());
			ps.setString(i++, mjp.getProfessional());
			ps.setString(i++, mjp.getInitFlag());
			ps.setString(i++, mjp.getTimeFlag());
			
			ps.setString(i++, mjp.getState());
			ps.setString(i++, mjp.getCreateDate());
			
			ps.execute();
			 
		} catch (SQLException e) {
			bl = false;
			System.out.println(this.getClass()+"    insert into   sql  ERROR:"+sql);
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		return bl;
		
	}
	
	
	/**
	 * 修改
	 */
	public boolean updateMicfonoJoinPartyById(MicfonoJoinParty mjp){
		PreparedStatement ps = null;
		String sql = "";
		boolean bl = true;
		try {
			// id; loginid; loginName;// --姓名  sex;// --性别 photo;// --照片  credentials;// -- 证件类型  credentialsNum;// --证件号  oldName;// --曾用名
			// oldCredenttialsNum;// --曾用身份证号码  seniorityType;// --资格取得方式  certificate2;// -- 全科合格证号  bornDate;// -- 出生日期
			// area;// -- 所在地区  nation;// -- 民族  politics;// --政治面貌  phone;// -- 联系电话  mobile;// -- 手机  email;// -- 电子邮件
			// ownership;// -- 单位性质  workunits ;// -- 工作单位  istired;// -- 是否离退休  address;// -- 通信地址  postcode;// -- 邮政编码
			// bornAddress;// -- 户口所在地  passYear;// -- 全科合格年份  educational;// -- 毕业院校  specialty;// --专业
			// diploma ;// -- 学历  degree;// -- 学位  languagelevel ;// -- 外语程度  rank ;// --专业职称  professional ;// -- 职称等级
			// initFlag;  timeFlag;
			
			sql = " update k_MicfonoJoinParty set loginName=?,sex=?,photo=?,credentials=?,credentialsNum=?,"
				+ " oldName=?,oldCredenttialsNum=?,seniorityType=?,certificate2=?,bornDate=?,area=?,nation=?,politics=?,phone=?," 
				+ " mobile=?,email=?,ownership=?,workunits=?,isTired=?,address=?,postcode=?,bornAddress=?,passYear=?,educational=?," 
			    + " specialty=?,diploma=?,degree=?,languagelevel=?,rank=?,professional=?,initFlag=?,timeFlag=? where id=? ";
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, mjp.getLoginName());
			ps.setString(i++, mjp.getSex());
			ps.setString(i++, mjp.getPhoto());
			ps.setString(i++, mjp.getCredentials());
			ps.setString(i++, mjp.getCredentialsNum());
			
			ps.setString(i++, mjp.getOldName());
			ps.setString(i++, mjp.getOldCredenttialsNum());
			ps.setString(i++, mjp.getSeniorityType());
			ps.setString(i++, mjp.getCertificate2());
			ps.setString(i++, mjp.getBornDate());
			ps.setString(i++, mjp.getArea());
			ps.setString(i++, mjp.getNation());
			ps.setString(i++, mjp.getPolitics());
			ps.setString(i++, mjp.getPhone());
			
			ps.setString(i++, mjp.getMobile());
			ps.setString(i++, mjp.getEmail());			
			ps.setString(i++, mjp.getOwnership());
			ps.setString(i++, mjp.getWorkunits());
			ps.setString(i++, mjp.getIstired());
			ps.setString(i++, mjp.getAddress());
			ps.setString(i++, mjp.getPostcode());
			ps.setString(i++, mjp.getBornAddress());
			ps.setString(i++, mjp.getPassYear());
			ps.setString(i++, mjp.getEducational());
			
			ps.setString(i++, mjp.getSpecialty());
			ps.setString(i++, mjp.getDiploma());
			ps.setString(i++, mjp.getDegree());
			ps.setString(i++, mjp.getLanguagelevel());
			ps.setString(i++, mjp.getRank());
			ps.setString(i++, mjp.getProfessional());
			ps.setString(i++, mjp.getInitFlag());
			ps.setString(i++, mjp.getTimeFlag());
			ps.setString(i++, mjp.getId());
			 
			ps.execute();
			
		} catch (SQLException e) {
			bl = false;
			System.out.println(this.getClass()+"    update into   sql  ERROR:"+sql);
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		return bl;
	}
	
	
}
