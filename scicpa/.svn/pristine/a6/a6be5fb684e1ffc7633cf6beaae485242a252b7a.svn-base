package cn.org.gdicpa.web.service.applyHoldSelfHour;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import cn.org.gdicpa.web.pub.db.DBConnect;
import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.applyHoldSelfHour.model.ApplyHoldSelfHourTable;

public class ApplyHoldSelfHourService {
	
	private Connection conn;
	public ApplyHoldSelfHourService(Connection conn){
		this.conn = conn;
	}
	
	
	/**
	 * 根据编号得到对象
	 * @param guid
	 * @return
	 * @throws Exception 
	 */
	public ApplyHoldSelfHourTable getApplyHoldSelfHourById(String id) throws Exception{
		DbUtil.checkConn(conn);
		ApplyHoldSelfHourTable ah = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		try {
			sql = " select id,classId,trainingTime,companyId,hourAttachmentid,attachmentid,provinceChecked " 
				+ " from XS_ApplyHoldSelfHour where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				ah = new ApplyHoldSelfHourTable();
				int i = 1;
				ah.setId(rs.getString(i++));
				ah.setClassID(rs.getString(i++));
				ah.setTrainingTime(rs.getString(i++));
				ah.setCompanyId(rs.getString(i++));
				ah.setHourAttachmentid(rs.getString(i++));
				ah.setAttachmentid(rs.getString(i++));
				ah.setProvinceChecked(rs.getString(i++));
			}
			return ah;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return ah;
	}
	
	
	/**
	 * 根据companyId得到对象
	 * @param guid
	 * @return
	 * @throws Exception 
	 */
	public ApplyHoldSelfHourTable getApplyHoldSelfHourTableByCompanyId(String companyId) throws Exception{
		DbUtil.checkConn(conn);
		ApplyHoldSelfHourTable ah = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		try {
			sql = " select id,classId,trainingTime,companyId,hourAttachmentid,attachmentid,provinceChecked " 
				+ " from XS_ApplyHoldSelfHour where companyId = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, companyId);
			rs = ps.executeQuery();
			if(rs.next()){
				ah = new ApplyHoldSelfHourTable();
				int i = 1;
				ah.setId(rs.getString(i++));
				ah.setClassID(rs.getString(i++));
				ah.setTrainingTime(rs.getString(i++));
				ah.setCompanyId(rs.getString(i++));
				ah.setHourAttachmentid(rs.getString(i++));
				ah.setAttachmentid(rs.getString(i++));
				ah.setProvinceChecked(rs.getString(i++));
			}
			return ah;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return ah;
	}
	
	
	/**
	 * 添加 对象
	 * @param at
	 * @return
	 * @throws Exception 
	 */
	public boolean addApplyHoldSelfHourTable(ApplyHoldSelfHourTable ah) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = null;
		try {
			sql = " insert into XS_ApplyHoldSelfHour(id,classId,trainingTime,companyId,hourAttachmentid,attachmentid,provinceChecked )"
				+ " values(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, ah.getId());
			ps.setString(i++, ah.getClassID());
			ps.setString(i++, ah.getTrainingTime());
			ps.setString(i++, ah.getCompanyId());
			ps.setString(i++, ah.getHourAttachmentid());
			ps.setString(i++, ah.getAttachmentid());
			
			ps.setString(i++, ah.getProvinceChecked());
			
			ps.execute();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
		return false;
	}
	
	
	/**
	 *   修改 对象
	 * @param at
	 * @return
	 * @throws Exception
	 */
	public boolean updateApplyHoldSelfHourTable(ApplyHoldSelfHourTable ah) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = " update XS_ApplyHoldSelfHour set classId=?,trainingTime=?,companyId=?,"
				+ " hourAttachmentid=?,attachmentid=?,provinceChecked=? )"
				+ " where id = ?";
			
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, ah.getClassID());
			ps.setString(i++, ah.getTrainingTime());
			ps.setString(i++, ah.getCompanyId());
			ps.setString(i++, ah.getHourAttachmentid());
			ps.setString(i++, ah.getAttachmentid());
			
			ps.setString(i++, ah.getProvinceChecked());
			ps.setString(i++, ah.getId());
			ps.execute();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
		return false;
	}
	
	 
	
	 
	
	/**
	 * 删除对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean deleteById(String id) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = null;
		try {
			sql = "delete from XS_ApplyHoldSelfHour where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
		return false;
	}
	
	
	/**
	 * jdom  读取 xml    
	 * @param typeId
	 * @throws Exception
	 */
	public Map getSqlByXml(String classPath,String fileName) throws Exception {
		System.out.println(this.getClass()+"      classPath11111="+classPath);
		// 这句话 服务器上面出现乱码
		classPath = DBConnect.class.getClassLoader().getResource(".").getPath();
		System.out.println(this.getClass()+"      classPath=222"+classPath);
		classPath = this.getClass().getResource("/").getPath();
		System.out.println(this.getClass()+"      classPath=333333"+fileName);
		
		Map map = new HashMap();
		
		SAXBuilder sb = new SAXBuilder();
		Document doc = sb.build(new FileInputStream(classPath + fileName));
		Element root = doc.getRootElement();
		
		StringBuffer sql = new StringBuffer();
		
		
		Element mainElement = root.getChild("mainTable");
		// 表名
		String tableName = mainElement.getAttribute("tableName").getValue();
		map.put("tableName", tableName);
		
		// 列名
		String column = mainElement.getChild("column").getValue();
		map.put("column", column);
		
		// 列名值   文号
		String columnValue = mainElement.getChild("columnValue").getValue();
		map.put("columnValue", columnValue);
		
		// 中文列名
		String columnName = mainElement.getChild("columnName").getValue();
		map.put("columnName", columnName);
		
		// 起始位置
		String columnStartIndex = mainElement.getChild("columnStartIndex").getValue();
		map.put("columnStartIndex", columnStartIndex);
		
		// 结束位置
		String columnEndIndex = mainElement.getChild("columnEndIndex").getValue();
		map.put("columnEndIndex", columnEndIndex);
		
		return map;
	}
	 
}
