package cn.org.gdicpa.web.service.applyTrainHourElse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;

import cn.org.gdicpa.web.service.applyTrainHourElse.model.ApplyTrainHourElse;


/**
 * 其他学时申报  Service
 * @author YDZ
 *  
 */
public class ApplyTrainHourElseService {
	
	private Connection connection = null;
	private PreparedStatement ps = null;
		public ApplyTrainHourElseService(Connection connection){
			this.connection = connection;
		}
		
		/**
		 * 新增
		 * @param ApplyTrainHourElse
		 * @return
		 * @throws MatechException
		 */
		public int addApplyTrain(ApplyTrainHourElse aHourElse) throws Exception  {
			DbUtil.checkConn(connection);
		
			int row = 0;
			
			try {
				int n = 1;
				String sql = "insert into XS_ApplyTrainHour "
						   + "(id,loginid,loginName,applyHours,educationType,educationNote,"
						   + "applyDate,companyOpinion,societyOpinion,attachmentid,companyChecked,"
						   + "provinceChecked,Ctype"
						   + ")"
						   + " values(?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
				ps = connection.prepareStatement(sql);
				
				ps.setString(n++, aHourElse.getId());  
				ps.setString(n++, aHourElse.getLoginid()); 
				ps.setString(n++, aHourElse.getLoginName()); 
				ps.setString(n++, aHourElse.getApplyHours()); 
				
				ps.setString(n++, aHourElse.getEducationType()); 				
				ps.setString(n++, aHourElse.getEducationNote()); 
				ps.setString(n++, aHourElse.getApplyDate()); 
				ps.setString(n++, aHourElse.getCompanyOpinion()); 
				
				ps.setString(n++, aHourElse.getSocietyOpinion()); 				
				ps.setString(n++, aHourElse.getAttachmentid()); 
				ps.setString(n++, aHourElse.getCompanyChecked()); 
				ps.setString(n++, aHourElse.getProvinceChecked()); 
				ps.setString(n++, aHourElse.getCtype()); 
				
			 

				row = ps.executeUpdate(); 
			} catch (Exception e) {
				row = 0;
				e.printStackTrace();
			} finally {
				DbUtil.close(ps);
			}
			return row;

		}
		
		
		/**
		 * 修改
		 * @param ApplyTrainHourElse
		 * @return
		 * @throws MatechException
		 */
		public void updateCnteExpElse(ApplyTrainHourElse aHourElse) throws Exception  {
			DbUtil.checkConn(connection);
		
			try {
			int n = 1;
			String sql = "update XS_ApplyTrainHour " +
					     "set loginid=?,loginName=?,applyHours=?,educationType=?," +
					     "educationNote=?,applyDate=?,companyOpinion=?,societyOpinion=?," +
					     "attachmentid=?,companyChecked=?,provinceChecked=? where id=?";
				ps = connection.prepareStatement(sql);
				
				ps.setString(n++, aHourElse.getLoginid());  
				ps.setString(n++, aHourElse.getLoginName()); 
				ps.setString(n++, aHourElse.getApplyHours());				
				ps.setString(n++, aHourElse.getEducationType()); 
				
				ps.setString(n++, aHourElse.getEducationNote()); 
				ps.setString(n++, aHourElse.getApplyDate()); 
				ps.setString(n++, aHourElse.getCompanyOpinion()); 
				ps.setString(n++, aHourElse.getSocietyOpinion());
				
				ps.setString(n++, aHourElse.getAttachmentid());
				ps.setString(n++, aHourElse.getCompanyChecked()); 
				ps.setString(n++, aHourElse.getProvinceChecked()); 
				ps.setString(n++, aHourElse.getId()); 
				 			 
				ps.executeUpdate(); 
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DbUtil.close(ps);
			}

		}
		
		
	    /**
		 * 根据ID删除一条记录
		 * @param id
		 * @return
		 */
		public int deleteApplyElse(String id) {
			int result = 0;
			try {
				String sql = "delete from XS_ApplyTrainHour where id=?";
				ps = connection.prepareStatement(sql);
				ps.setString(1, id);
				result = ps.executeUpdate();  
			 
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DbUtil.close(ps);
			}
			return result;

		}

		/**
		 * 点击修改按钮跳到修改页面 根据id查询一条记录
		 * 
		 * @param response
		 * @return
		 * @throws QcontentExemption 
		 */
		public ApplyTrainHourElse getAplyTrHTaElseByLoginid(String loginid) throws Exception  {
			DbUtil.checkConn(connection);
			PreparedStatement ps = null;
			ResultSet rs = null;
			ApplyTrainHourElse aHourElse = new ApplyTrainHourElse();
			try {
				String 	sql = " select id,loginid,loginName,applyHours,educationType,educationNote,Ctype, " 
					+ " applyDate,companyOpinion,societyOpinion,attachmentid,companyChecked,provinceChecked "
					+ " from XS_ApplyTrainHour where loginid='"+loginid+"'";
				ps = connection.prepareStatement(sql);
				rs = ps.executeQuery();
				if (rs.next()) {
					aHourElse.setId(rs.getString("id"));       
					aHourElse.setLoginid(rs.getString("loginid")); 
					aHourElse.setLoginName(rs.getString("loginName"));
					aHourElse.setApplyHours(rs.getString("applyHours"));  

					aHourElse.setEducationType(rs.getString("educationType"));  
					aHourElse.setEducationNote(rs.getString("educationNote")); 
					aHourElse.setApplyDate(rs.getString("applyDate"));  
					aHourElse.setCompanyOpinion(rs.getString("companyOpinion")); 
					
					aHourElse.setSocietyOpinion(rs.getString("societyOpinion"));  
					aHourElse.setAttachmentid(rs.getString("attachmentid"));
					aHourElse.setCompanyChecked(rs.getString("companyChecked"));
					aHourElse.setProvinceChecked(rs.getString("provinceChecked"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DbUtil.close(ps);
			}
			return aHourElse;

		  }
		
		/**
		 * 根据编号得到对象
		 * @param guid
		 * @return
		 * @throws Exception 
		 */
		public ApplyTrainHourElse getAplyTrHTaElseById(String id) throws Exception{
			DbUtil.checkConn(connection);
			ApplyTrainHourElse aHourElse = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = null;
			try {
				sql = " select id,loginid,loginName,applyHours,educationType,educationNote,Ctype, " 
					+ " applyDate,companyOpinion,societyOpinion,attachmentid,companyChecked,provinceChecked "
					+ " from XS_ApplyTrainHour where id = ?";
				ps = connection.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				if(rs.next()){
					aHourElse = new ApplyTrainHourElse();
					int i = 1;
					aHourElse.setId(rs.getString("id"));
					aHourElse.setLoginid(rs.getString("loginid"));
					aHourElse.setLoginName(rs.getString("loginName"));
					aHourElse.setApplyHours(rs.getString("applyHours"));
					aHourElse.setEducationType(rs.getString("educationType"));
					aHourElse.setEducationNote(rs.getString("educationNote"));
					aHourElse.setCtype(rs.getString("Ctype"));
					aHourElse.setApplyDate(rs.getString("applyDate"));
					aHourElse.setCompanyOpinion(rs.getString("companyOpinion"));
					aHourElse.setSocietyOpinion(rs.getString("societyOpinion"));
					aHourElse.setAttachmentid(rs.getString("attachmentid"));
					aHourElse.setCompanyChecked(rs.getString("companyChecked"));
					aHourElse.setProvinceChecked(rs.getString("provinceChecked"));
					aHourElse.setCtype(rs.getString(i++));
				}
				return aHourElse;
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				DbUtil.close(rs);
				DbUtil.close(ps);
			}
			return aHourElse;
		}
}
