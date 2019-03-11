package cn.org.gdicpa.web.service.trainingHoldSelf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.trainingHoldSelf.model.TrainingHoldSelfTable;

/**
 * 自办培训班
 * @author Administrator
 *
 */
public class TrainingHoldSelfService {
	private Connection conn;

	public TrainingHoldSelfService(Connection conn) {
		this.conn = conn;
	}
	
	
	/**
	 * 根据编号得到对象
	 * @param guid
	 * @return
	 * @throws Exception 
	 */
	public TrainingHoldSelfTable getTrainingHoldSelfTableByClassId(String classid) throws Exception{
		DbUtil.checkConn(conn);
		TrainingHoldSelfTable tt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		try {
			sql = " select ClassID,OfficeId,OfficeName,TrainingChargeID,TrainingDate," 
				+ " TrainingDateBeg,TrainingDateEnd,TrainingAddress,TrainingHour,ClassName, "
				+ " TrainingContent,Teachers,TeacherIntroduce,TrainingObject,Annox, "
				+ " Memo,CheckState,attachmentid,nopassReason,trainingSummary "
				+ " from b_TrainingHoldSelf where ClassID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, classid);
			rs = ps.executeQuery();
			if(rs.next()){
				tt = new TrainingHoldSelfTable();
				
				int i = 1;
				
				tt.setClassID(rs.getString(i++));
				tt.setOfficeId(rs.getString(i++));
				tt.setOfficeName(rs.getString(i++));
				tt.setTrainingChargeID(rs.getString(i++));
				tt.setTrainingDate(rs.getString(i++));
				
				tt.setTrainingDateBeg(rs.getString(i++));
				tt.setTrainingDateEnd(rs.getString(i++));
				tt.setTrainingAddress(rs.getString(i++));
				tt.setTrainingHour(rs.getString(i++));
				tt.setClassName(rs.getString(i++));
				
				tt.setTrainingContent(rs.getString(i++));
				tt.setTeachers(rs.getString(i++));
				tt.setTeacherIntroduce(rs.getString(i++));
				tt.setTrainingObject(rs.getString(i++));
				tt.setAnnox(rs.getString(i++));
				
				tt.setMemo(rs.getString(i++));
				tt.setCheckState(rs.getString(i++));
				tt.setAttachmentid(rs.getString(i++));
				tt.setNopassReason(rs.getString(i++));
				tt.setTrainingSummary(rs.getString(i++));
				
			}
			return tt;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return tt;
	}
	
	
	
	/**
	 * 得到 对应 事务所 下的执业会员
	 * @param officecode
	 * @return
	 * @throws Exception 
	 */
	public String getMicfosInCompany(String officecode) throws Exception{
		DbUtil.checkConn(conn);
		String persons = "";
		String sql = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			sql = "select count(*) as persons from k_micfo where officeCode = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, officecode);
			rs = ps.executeQuery();
			if(rs.next()){
				persons = rs.getString(1);
			}
			return persons;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return persons;
		
	}
	
	/**
	 * 修改
	 * @param tt
	 * @return
	 * @throws Exception
	 */
	public void addTrainingHoldSelfTable(TrainingHoldSelfTable tt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			
				
			sql = " insert into b_TrainingHoldSelf  "
				+ " (ClassID,OfficeId,OfficeName,TrainingChargeID,TrainingDate," 
				+ " TrainingDateBeg,TrainingDateEnd,TrainingAddress,TrainingHour,ClassName, "
				+ " TrainingContent,Teachers,TeacherIntroduce,TrainingObject,Annox, "
				+ " Memo,CheckState,attachmentid,nopassReason,trainingSummary) " 
				+ " values(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?)";
			
			ps = conn.prepareStatement(sql);
			int i = 1;
			
			ps.setString(i++, tt.getClassID());
			ps.setString(i++, tt.getOfficeId());
			ps.setString(i++, tt.getOfficeName());
			ps.setString(i++, tt.getTrainingChargeID());
			ps.setString(i++, tt.getTrainingDate());
			
			ps.setString(i++, tt.getTrainingDateBeg());
			ps.setString(i++, tt.getTrainingDateEnd());
			ps.setString(i++, tt.getTrainingAddress());
			ps.setString(i++, tt.getTrainingHour());
			ps.setString(i++, tt.getClassName());
			
			ps.setString(i++, tt.getTrainingContent());
			ps.setString(i++, tt.getTeachers());
			ps.setString(i++, tt.getTeacherIntroduce());
			ps.setString(i++, tt.getTrainingObject());
			ps.setString(i++, tt.getAnnox());
			
			ps.setString(i++, tt.getMemo());
			ps.setString(i++, tt.getCheckState());
			ps.setString(i++, tt.getAttachmentid());
			ps.setString(i++, tt.getNopassReason());
			ps.setString(i++, tt.getTrainingSummary());
			
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
		
	}
	
	
	/**
	 * 修改
	 * @param tt
	 * @return
	 * @throws Exception
	 */
	public void updateTrainingHoldSelfTable(TrainingHoldSelfTable tt) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			
			sql = " update b_TrainingHoldSelf set "
				+ " OfficeId=?,OfficeName=?,TrainingChargeID=?,TrainingDate=?,TrainingDateBeg=?," 
				+ " TrainingDateEnd=?,TrainingAddress=?,TrainingHour=?,ClassName=?,TrainingContent=?, "
				+ " Teachers=?,TeacherIntroduce=?,TrainingObject=?,Annox=?,Memo=?, "
				+ " attachmentid=?,trainingSummary=? "
				+ " where ClassID = ?";
			
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, tt.getOfficeId());
			ps.setString(i++, tt.getOfficeName());
			ps.setString(i++, tt.getTrainingChargeID());
			ps.setString(i++, tt.getTrainingDate());
			ps.setString(i++, tt.getTrainingDateBeg());
			
			ps.setString(i++, tt.getTrainingDateEnd());
			ps.setString(i++, tt.getTrainingAddress());
			ps.setString(i++, tt.getTrainingHour());
			ps.setString(i++, tt.getClassName());
			ps.setString(i++, tt.getTrainingContent());
			
			ps.setString(i++, tt.getTeachers());
			ps.setString(i++, tt.getTeacherIntroduce());
			ps.setString(i++, tt.getTrainingObject());
			ps.setString(i++, tt.getAnnox());
			ps.setString(i++, tt.getMemo());
			
			ps.setString(i++, tt.getAttachmentid());
			ps.setString(i++, tt.getTrainingSummary());
			
			ps.setString(i++, tt.getClassID());
			
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
	}
	
	/**
	 * 删除对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean deleteByClassId(String classid) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = null;
		try {
			sql = " delete from b_TrainingHoldSelf where classid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, classid);
			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
		return false;
	}

}

