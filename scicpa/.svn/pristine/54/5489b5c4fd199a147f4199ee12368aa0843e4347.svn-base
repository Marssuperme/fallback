package cn.org.gdicpa.web.service.contentExemptionNot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.service.contentExemption.ContentExemptionService;
import cn.org.gdicpa.web.service.contentExemption.model.ContentExemption;
import cn.org.gdicpa.web.service.contentExemptionNot.model.ContentExemptionNot;
/**
 * 非职业豁免学时申报  Service
 * @author YDZ
 *  
 */
public class ContentExemptionNotService {
	
	private static Log log = LogFactory.getLog(ContentExemptionNotService.class);
		
	private Connection connection = null;
	private PreparedStatement ps = null;
		public ContentExemptionNotService(Connection connection){
			this.connection = connection;
		}
		
		
		/**
		 * 新增
		 * @param ContentExemption
		 * @return
		 * @throws MatechException
		 */
		public int addFcnteExption(ContentExemptionNot contentExemptionNot) throws Exception  {
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
				
				ps.setString(n++, contentExemptionNot.getId());  
				ps.setString(n++, contentExemptionNot.getLoginId()); 
				ps.setString(n++, contentExemptionNot.getLoginName()); 
				ps.setString(n++, contentExemptionNot.getSex()); 
				
				ps.setString(n++, contentExemptionNot.getsDate()); 
				ps.setString(n++, contentExemptionNot.getsYear()); 
				ps.setString(n++, contentExemptionNot.getEContent()); 
				ps.setString(n++, contentExemptionNot.getEHelp()); 
				
				ps.setString(n++, contentExemptionNot.getStatus()); 
				ps.setString(n++, contentExemptionNot.getsType()); 
				ps.setString(n++, contentExemptionNot.getInitFlag()); 
				ps.setString(n++, contentExemptionNot.getImeFlag()); 
			 

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
		 * @param contentExemptionNot
		 * @return
		 * @throws MatechException
		 */
		public int updateFcnteExption(ContentExemptionNot contentExemptionNot) throws Exception  {
			DbUtil.checkConn(connection);
		
			int row = 0;
			
			try {
				int n = 1;
				String sql = "update  XS_ContentExemption set sex=?,sDate=?,sYear=?,EContent=?,EHelp=? where ID =?";
				ps = connection.prepareStatement(sql);
				
				ps.setString(n++, contentExemptionNot.getSex());  
				ps.setString(n++, contentExemptionNot.getsDate()); 
				ps.setString(n++, contentExemptionNot.getsYear());
				
				ps.setString(n++, contentExemptionNot.getEContent()); 			
				ps.setString(n++, contentExemptionNot.getEHelp()); 
				ps.setString(n++, contentExemptionNot.getId()); 
				 			 
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
		public int deleteFcotetNot(String id) {
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
		public ContentExemptionNot selectCteNotId(String id) throws Exception  {
			DbUtil.checkConn(connection);
			PreparedStatement ps = null;
			ResultSet rs = null;
			ContentExemptionNot contentExemptionNot = new ContentExemptionNot();
			try {
				String sql = " select ID,LoginId,LoginName,sex,sDate,sYear,EContent,"+
	                         " EHelp,Status,sType,InitFlag,imeFlag from XS_ContentExemption  where ID='"+id+"'";
				ps = connection.prepareStatement(sql);
				rs = ps.executeQuery();
				System.out.println("sql                 shi   " + sql);
				if (rs.next()) {
					contentExemptionNot.setId(rs.getString("ID"));       
					contentExemptionNot.setLoginId( rs.getString("loginId")); 
					contentExemptionNot.setLoginName( rs.getString("loginName"));
					contentExemptionNot.setSex( rs.getString("sex"));  

					contentExemptionNot.setsDate( rs.getString("sDate"));  
					contentExemptionNot.setsYear( rs.getString("sYear")); 
					contentExemptionNot.setEContent( rs.getString("eContent"));  
					contentExemptionNot.setEHelp( rs.getString("eHelp")); 
					
					contentExemptionNot.setStatus( rs.getString("status"));  
					contentExemptionNot.setsType( rs.getString("sType"));
					contentExemptionNot.setImeFlag(  rs.getString("imeFlag"));
					contentExemptionNot.setInitFlag(  rs.getString("initFlag"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DbUtil.close(ps);
			}
			return contentExemptionNot;

		}
}
