package cn.org.gdicpa.web.service.contentExemption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.org.gdicpa.web.service.contentExemption.model.ContentExemption;
import cn.org.gdicpa.web.pub.db.DbUtil;

/**
 * 豁免学时申报  Service
 * @author YDZ
 *  
 */
public class ContentExemptionService {
  
	
private static Log log = LogFactory.getLog(ContentExemptionService.class);
	
private Connection connection = null;
private PreparedStatement ps = null;
	public ContentExemptionService(Connection connection){
		this.connection = connection;
	}
	
	
	/**
	 * 新增
	 * @param ContentExemption
	 * @return
	 * @throws MatechException
	 */
	public int addCnteExption(ContentExemption contentExemption) throws Exception  {
		DbUtil.checkConn(connection);
	
		int row = 0;
		
		try {
			int n = 1;
			String sql = "insert into XS_ContentExemption "
					+ "(ID,LoginId,LoginName,sex,sDate,"
					+ "sYear,EContent,EHelp,Status,sType,InitFlag,imeFlag"
					+ ")"
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(sql);
			
			ps.setString(n++, contentExemption.getId());  
			ps.setString(n++, contentExemption.getLoginId()); 
			ps.setString(n++, contentExemption.getLoginName()); 
			ps.setString(n++, contentExemption.getSex()); 
			
			ps.setString(n++, contentExemption.getsDate()); 
			ps.setString(n++, contentExemption.getsYear()); 
			ps.setString(n++, contentExemption.getEContent()); 
			ps.setString(n++, contentExemption.getEHelp()); 
			
			ps.setString(n++, contentExemption.getStatus()); 
			ps.setString(n++, contentExemption.getsType()); 
			ps.setString(n++, contentExemption.getInitFlag()); 
			ps.setString(n++, contentExemption.getImeFlag()); 
		 

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
	 * @param ContentExemption
	 * @return
	 * @throws MatechException
	 */
	public int updateCnteExption(ContentExemption contentExemption) throws Exception  {
		DbUtil.checkConn(connection);
	
		int row = 0;
		
		try {
			int n = 1;
			String sql = "update  XS_ContentExemption set sex=?,sDate=?,sYear=?,EContent=?,EHelp=? where ID =?";
			ps = connection.prepareStatement(sql);
			
			ps.setString(n++, contentExemption.getSex());  
			ps.setString(n++, contentExemption.getsDate()); 
			ps.setString(n++, contentExemption.getsYear());
			
			ps.setString(n++, contentExemption.getEContent()); 			
			ps.setString(n++, contentExemption.getEHelp()); 
			ps.setString(n++, contentExemption.getId()); 
			 
		 
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
	public int deleteCotetExtion(String id) {
		int result = 0;
		try {
			String sql = "delete from XS_ContentExemption where ID=?";
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
	 * @param gmanagement
	 * @return
	 * @throws Exception 
	 */
	public ContentExemption selectCteExtionId(String id) throws Exception  {
		DbUtil.checkConn(connection);
		PreparedStatement ps = null;
		ResultSet rs = null;
		ContentExemption contentExemption = new ContentExemption();
		try {
			String sql = " select ID,LoginId,LoginName,sex,sDate,sYear,EContent,"+
                         " EHelp,Status,sType,InitFlag,imeFlag from XS_ContentExemption  where ID='"+id+"'";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("sql                 shi   " + sql);
			if (rs.next()) {
				contentExemption.setId(rs.getString("ID"));       
				contentExemption.setLoginId( rs.getString("loginId")); 
				contentExemption.setLoginName( rs.getString("loginName"));
				contentExemption.setSex( rs.getString("sex"));  

				contentExemption.setsDate( rs.getString("sDate"));  
				contentExemption.setsYear( rs.getString("sYear")); 
				contentExemption.setEContent( rs.getString("eContent"));  
				contentExemption.setEHelp( rs.getString("eHelp")); 
				
				contentExemption.setStatus( rs.getString("status"));  
				contentExemption.setsType( rs.getString("sType"));
				contentExemption.setImeFlag(  rs.getString("imeFlag"));
				contentExemption.setInitFlag(  rs.getString("initFlag"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(ps);
		}
		return contentExemption;

	}
}
