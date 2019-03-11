package cn.org.gdicpa.web.service.micfoApplyTrainHour;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.applyTrainHourElse.ApplyTrainHourElseService;
import cn.org.gdicpa.web.service.micfoApplyTrainHour.model.MicfoApplyTrainHour;

/**
 * 职业会员其他学时申报  Service
 * @author YDZ
 *  
 */
public class MicfoApplyTrainHourService {
private static Log log = LogFactory.getLog(ApplyTrainHourElseService.class);
	
	private Connection connection = null;
	private PreparedStatement ps = null;
		public MicfoApplyTrainHourService(Connection connection){
			this.connection = connection;
		}
		
		/**
		 * 新增
		 * @param MicfoApplyTrainHour
		 * @return
		 * @throws MatechException
		 */
		public int addmTrainHour(MicfoApplyTrainHour mTrainHour) throws Exception  {
			DbUtil.checkConn(connection);
		
			int row = 0;
			
			try {
				int n = 1;
				String sql = "insert into k_micfoApplyTrainHour "
						+ "(id,loginid,loginName,applyHours,educationType,educationNote,"
						 + "applyDate,companyOpinion,societyOpinion,attachmentid,companyChecked,"
						+ "provinceChecked,property1,property2,ctype"
						+ ")"
						+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				ps = connection.prepareStatement(sql);
				
				ps.setString(n++, mTrainHour.getId());  
				ps.setString(n++, mTrainHour.getLoginid()); 
				ps.setString(n++, mTrainHour.getLoginName()); 
				ps.setString(n++, mTrainHour.getApplyHours()); 
				
				ps.setString(n++, mTrainHour.getEducationType()); 				
				ps.setString(n++, mTrainHour.getEducationNote()); 
				ps.setString(n++, mTrainHour.getApplyDate()); 
				ps.setString(n++, mTrainHour.getCompanyOpinion()); 
				
				ps.setString(n++, mTrainHour.getSocietyOpinion()); 				
				ps.setString(n++, mTrainHour.getAttachmentid()); 
				ps.setString(n++, mTrainHour.getCompanyChecked()); 
				ps.setString(n++, mTrainHour.getProvinceChecked());
				
				
				ps.setString(n++, mTrainHour.getProperty1());
				ps.setString(n++, mTrainHour.getProperty2());
				ps.setString(n++, mTrainHour.getCtype());
				
			 

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
		 * @param MicfoApplyTrainHour
		 * @return
		 * @throws MatechException
		 */
		public int updatemTrainHour(MicfoApplyTrainHour mTrainHour) throws Exception  {
			DbUtil.checkConn(connection);
		
			int row = 0;
			
			try {
			int n = 1;
			String sql = "update  k_micfoApplyTrainHour " +
					     "set loginid=?,loginName=?, applyHours=?,educationType=?," +
					     "educationNote=?,applyDate=?,companyOpinion=?,societyOpinion=?," +
					     "attachmentid=?,companyChecked=?,provinceChecked=?,property1=?,property2=? where id=?";
				ps = connection.prepareStatement(sql);
				
				ps.setString(n++, mTrainHour.getLoginid());  
				ps.setString(n++, mTrainHour.getLoginName()); 
				ps.setString(n++, mTrainHour.getApplyHours());				
				ps.setString(n++, mTrainHour.getEducationType()); 
				
				ps.setString(n++, mTrainHour.getEducationNote()); 
				ps.setString(n++, mTrainHour.getApplyDate()); 
				ps.setString(n++, mTrainHour.getCompanyOpinion()); 
				ps.setString(n++, mTrainHour.getSocietyOpinion());
				
				ps.setString(n++, mTrainHour.getAttachmentid());
				ps.setString(n++, mTrainHour.getCompanyChecked()); 
				ps.setString(n++, mTrainHour.getProvinceChecked());
				ps.setString(n++, mTrainHour.getProperty1());
				
				ps.setString(n++, mTrainHour.getProperty2());
				ps.setString(n++, mTrainHour.getId()); 
				 			 
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
		 * 根据ID删除一条记录
		 * @param id
		 * @return
		 */
		public int deletemTrainHourId(String id) {
			int result = 0;
			try {
				String sql = "delete from k_micfoApplyTrainHour where id=?";
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
		 * @throws MicfoApplyTrainHour 
		 */
		public MicfoApplyTrainHour selectmTrainHourId(String id) throws Exception  {
			DbUtil.checkConn(connection);
			PreparedStatement ps = null;
			ResultSet rs = null;
			MicfoApplyTrainHour mTrainHour = new MicfoApplyTrainHour();
			try {
				String sql = " select id,loginid,loginName,applyHours,educationType," +
						     "educationNote,applyDate,companyOpinion,societyOpinion," +
						     "attachmentid,companyChecked,provinceChecked,property1,property2 from k_micfoApplyTrainHour where id='"+id+"'";
				ps = connection.prepareStatement(sql);
				rs = ps.executeQuery();
				System.out.println("sql                 shi   " + sql);
				if (rs.next()) {
					mTrainHour.setId(rs.getString("id"));       
					mTrainHour.setLoginid( rs.getString("loginid")); 
					mTrainHour.setLoginName( rs.getString("loginName"));
					mTrainHour.setApplyHours(  rs.getString("applyHours"));  

					mTrainHour.setEducationType(  rs.getString("educationType"));  
					mTrainHour.setEducationNote(  rs.getString("educationNote")); 
					mTrainHour.setApplyDate(  rs.getString("applyDate"));  
					mTrainHour.setCompanyOpinion(  rs.getString("companyOpinion")); 
					
					mTrainHour.setSocietyOpinion(  rs.getString("societyOpinion"));  
					mTrainHour.setAttachmentid(  rs.getString("attachmentid"));
					mTrainHour.setCompanyChecked(   rs.getString("companyChecked"));
					mTrainHour.setProvinceChecked(  rs.getString("provinceChecked"));
					
					
					mTrainHour.setProperty1( rs.getString("property1"));   //备用1
					mTrainHour.setProperty2( rs.getString("property2"));   //备用2
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DbUtil.close(ps);
			}
			return mTrainHour;

		  }
}
