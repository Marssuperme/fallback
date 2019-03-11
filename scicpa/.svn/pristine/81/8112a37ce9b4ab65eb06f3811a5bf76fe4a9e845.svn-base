/*package cn.org.gdicpa.web.service.micfoRegister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.micfoRegister.model.MicfoRegister;

public class CopyOfMicfoRegisterService {

	private Connection conn = null;
	public CopyOfMicfoRegisterService(Connection conn){
		this.conn = conn;
	}
	
	*//**
	 * 根据主键获取对象
	 *//*
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
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
		return mr;
		
	}
	
	
	*//**
	 * 多条件获取对象
	 * @param idCardNum
	 * @param loginname
	 * @return
	 *//*
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
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return mr;
	}
	
	
	*//**
	 * 自定义条件获取对象
	 * @param idCardNum
	 * @param loginname
	 * @return
	 *//*
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
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return mr;
	}
	
	
	*//**
	 * 新增
	 * @param mr
	 *//*
	public void addMicfoRegister(MicfoRegister mr){
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = "INSERT INTO k_micfoRegister(loginid,loginName,Pwd,State,Ctype,CtypetabName,IDnumber," +
					"OfficeCode,OfficeName,CPANO,userPhoto,userPhotoName,Sex,Post,BornDate,Nation,Rank," +
					"Professional,Diploma,Degree,Specialty,LanguageLevel,Educational,EMail,Mobile,Phone," +
					"Address,Postcode,Politics,Application,Approve,CPApermitno,Certificate,General,Retirees," +
					"Intotime,isShareholder,Intobefore,Filestorage,fileType,Source,Lastmodified,Lastpeople," +
					"Association,IsTester,Yearcheck,MgrType,IsAudit,IsUpLoad,Nationality,GetMode,CertificateYear," +
					"Amount,Period,AssessID,AssessNo,AssessName,ShareDate,PauseDate) " +
					"VALUES (?,?,?,?,?,?, ?,?,?,?,?,?, ?,?,?,?,?,?, ?,?,?,?,?,?, ?,?,?,?,?,?, ?,?,?,?,?,?, ?,?,?,?,?,?, ?,?,?,?,?,?, ?,?,?,?,?,?, ?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			int i = 1;
			//"INSERT INTO k_micfoRegister(loginid,loginName,Pwd,State,Ctype,CtypetabName,IDnumber," +
			ps.setString(i++, mr.getLoginid());
			ps.setString(i++, mr.getLoginName());
			ps.setString(i++, mr.getPwd());
			ps.setString(i++, mr.getState());
			ps.setString(i++, mr.getCtype());
			ps.setString(i++, mr.getCtypetabName());
			ps.setString(i++, mr.getIdnumber());
			//"OfficeCode,OfficeName,CPANO,userPhoto,userPhotoName,Sex,Post,BornDate,Nation,Rank," +
			ps.setString(i++, mr.getOfficeCode());			
			ps.setString(i++, mr.getOfficeName());
			ps.setString(i++, mr.getCpaNO());
			ps.setString(i++, mr.getUserPhoto());
			ps.setString(i++, mr.getUserPhotoName());
			ps.setString(i++, mr.getSex());
			ps.setString(i++, mr.getPost());
			ps.setString(i++, mr.getBornDate());
			ps.setString(i++, mr.getNation());
			ps.setString(i++, mr.getRank());
			//"Professional,Diploma,Degree,Specialty,LanguageLevel,Educational,EMail,Mobile,Phone," +
			ps.setString(i++, mr.getProfessional());
			ps.setString(i++, mr.getDiploma());
			ps.setString(i++, mr.getDegree());
			ps.setString(i++, mr.getSpecialty());
			ps.setString(i++, mr.getLanguageLevel());
			ps.setString(i++, mr.getEducational());
			ps.setString(i++, mr.getEmail());
			ps.setString(i++, mr.getMobile());
			ps.setString(i++, mr.getPhone());
			//	"Address,Postcode,Politics,Application,Approve,CPApermitno,Certificate,General,Retirees," +
			ps.setString(i++, mr.getAddress());
			ps.setString(i++, mr.getPost());
			ps.setString(i++, mr.getPolitics());
			ps.setString(i++, mr.getApplication());
			ps.setString(i++, mr.getApprove());
			ps.setString(i++, mr.getCpapermitno());
			ps.setString(i++, mr.getCertificate());
			ps.setString(i++, mr.getGeneral());
			ps.setString(i++, mr.getRetirees());
			//	"Intotime,isShareholder,Intobefore,Filestorage,fileType,Source,Lastmodified,Lastpeople," +
			ps.setString(i++, mr.getIntotime());
			ps.setString(i++, mr.getIsShareholder());
			ps.setString(i++, mr.getIntobefore());
			ps.setString(i++, mr.getFilestorage());
			ps.setString(i++, mr.getFileType());
			ps.setString(i++, mr.getSource());
			ps.setString(i++, mr.getLastmodified());
			ps.setString(i++, mr.getLastpeople());
			//	"Association,IsTester,Yearcheck,MgrType,IsAudit,IsUpLoad,Nationality,GetMode,CertificateYear," +
			ps.setString(i++, mr.getAssociation());
			ps.setString(i++, mr.getIsTester());
			ps.setString(i++, mr.getYearcheck());
			ps.setString(i++, mr.getMgrType());
			ps.setString(i++, mr.getIsAudit());
			ps.setString(i++, mr.getIsUpLoad());
			ps.setString(i++, mr.getNationality());
			ps.setString(i++, mr.getGetMode());
			ps.setString(i++, mr.getCertificateYear());
			//	"Amount,Period,AssessID,AssessNo,AssessName,ShareDate,PauseDate) " +
			ps.setString(i++, mr.getAmount());
			ps.setString(i++, mr.getPeriod());
			ps.setString(i++, mr.getAssessID());
			ps.setString(i++, mr.getAssessNo());
			ps.setString(i++, mr.getAssessName());
			ps.setString(i++, mr.getShareDate());
			ps.setString(i++, mr.getPauseDate());
			
			ps.execute();
			 
		} catch (SQLException e) {
			System.out.println(this.getClass()+"    insert into   sql  ERROR:"+sql);
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
	}
	
	*//**
	 * 修改
	 * @param mr
	 *//*
	public void updateMicfoRegister(MicfoRegister mr){
		PreparedStatement ps = null;
		String sql = "";
		try {
			
			ps.execute();
			 
		} catch (SQLException e) {
			System.out.println(this.getClass()+"    update sql  ERROR:"+sql);
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
	}
	
	*//**
	 * 删除
	 * @param id
	 *//*
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
*/