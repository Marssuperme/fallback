package cn.org.gdicpa.web.service.Paper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.Paper.model.PaperTable;
import cn.org.gdicpa.web.service.attachFileUploadService.model.AttachFile;

/**
 * 投稿数据类
 * @author kq
 *
 */
public class PaperService {
	private Connection con = null ;
	public PaperService(Connection con){
		this.con = con;
	}
	
	
	/**
	 * 保存投稿
	 * @param paper
	 * @return
	 */
	public int addPaper(PaperTable paper){
		int result = 0;
		PreparedStatement ps = null;
		try {
			String sql = " insert into b_Paper(ID,OfficeCode,OfficeName,AttachID,Remark, " 
					   + " IsUse,UseRemark,InitFlag,TimeFlag,sDate,title,workUnit)" 
					   + " values(?,?,?,?,?, ?,?,?,?,?, ?,?)";
			int i =1;
			
			ps = con.prepareStatement(sql);
			
			ps.setString(i++, paper.getId());
			ps.setString(i++, paper.getOfficeCode());
			ps.setString(i++, paper.getOfficeName());
			ps.setString(i++, paper.getAttachID());
			ps.setString(i++, paper.getRemark());
			
			ps.setString(i++, paper.getIsUse());
			ps.setString(i++, paper.getUseRemark());
			ps.setString(i++, paper.getInitFlag());
			ps.setString(i++, paper.getTimeFlag());
			ps.setString(i++, paper.getSDate());
			
			ps.setString(i++, paper.getTitle());
			ps.setString(i++, paper.getWorkUnit());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		return result;
	}
	
	
	/**
	 * 更新投稿信息
	 * @param pr
	 * @return
	 */
	public int updatePaperNo(PaperTable paper){
		int result = 0;
		PreparedStatement ps = null;
		try {
			String sql = " update b_Paper set OfficeCode=?,OfficeName=?,AttachID=?,Remark=?,IsUse=?,UseRemark=?," 
					   + " sDate=?,title=?,workUnit=? " 
					   + " where id = ? ";
			
			ps = con.prepareStatement(sql);
			
			int i = 1;
			
			ps.setString(i++, paper.getOfficeCode());
			ps.setString(i++, paper.getOfficeName());
			ps.setString(i++, paper.getAttachID());
			ps.setString(i++, paper.getRemark());
			ps.setString(i++, paper.getIsUse());
			ps.setString(i++, paper.getUseRemark());
			
			
			ps.setString(i++, paper.getSDate());
			ps.setString(i++, paper.getTitle());
			ps.setString(i++, paper.getWorkUnit());
			
			ps.setString(i++, paper.getId());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		return result;
	}
	
	
	/**
	 * 删除投稿信息
	 * @param sid
	 * @return
	 */
	public int deletePaperNo(String id){
		int result = 0;
		PreparedStatement ps = null;
		try {
			String sql ="delete from b_Paper where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(ps);
		}
		return result;
	}
	
	
	/**
	 * 查询单投稿信息
	 * @param pid
	 * @return
	 */
	public PaperTable getPaperTable(String id){
		PaperTable paper = new PaperTable();
		AttachFile attachFile = new AttachFile() ;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			String sql ="select p.*,a.indexTable,a.indexid,a.filename,a.fileTempName,a.autoid " 
						+ " from b_Paper p,k_attachfile a " 
						+ " where id= ? and p.AttachID=a.indexid";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				paper.setId(id);
				paper.setOfficeCode(rs.getString("officeCode"));
				paper.setOfficeName(rs.getString("officeName"));
				paper.setAttachID(rs.getString("attachID"));
				paper.setRemark(rs.getString("remark"));
				
				paper.setIsUse(rs.getString("isUse"));
				paper.setUseRemark(rs.getString("useRemark"));
				paper.setInitFlag(rs.getString("initFlag"));
				paper.setTimeFlag(rs.getString("timeFlag"));
				paper.setSDate(rs.getString("sDate"));
				
				paper.setTitle(rs.getString("title"));
				paper.setWorkUnit(rs.getString("workUnit"));
				
				attachFile.setIndexTable(rs.getString("indexTable"));
				attachFile.setIndexId(rs.getString("indexid"));
				attachFile.setFileName(rs.getString("filename"));
				attachFile.setFileTempName(rs.getString("fileTempName"));
				
				paper.setAttachFile(attachFile);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return paper;
		
	}
	
}
