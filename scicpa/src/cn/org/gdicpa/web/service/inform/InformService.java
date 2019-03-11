package cn.org.gdicpa.web.service.inform;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.MD5;
import cn.org.gdicpa.web.service.attachFileUploadService.AttachFileUploadService;

public class InformService {

	private Connection conn = null;
	
	public InformService(Connection conn) {
		this.conn = conn;
	}
	
	/**
	 * 保存举报信息
	 */
	public String saveInfo(String tabname,Map parameters) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			
			sql = "select top 1 * from " + tabname + " ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();
			sql = "";
			String sql1 = "", sql2 = "";
			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
				//if(!"id".equals(RSMD.getColumnName(i).toLowerCase())){	//自动编号
					sql1 += ","+RSMD.getColumnName(i).toLowerCase()+" ";
	 				sql2 += ",? ";
				//}
			}
			
			sql = "insert into  " + tabname + " (" + sql1.substring(1) + ") values (" + sql2.substring(1) + ") ";
			ps = conn.prepareStatement(sql);
			int ii = 1;
			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
				//if(!"id".equals(RSMD.getColumnName(i).toLowerCase())){	//自动编号
					ps.setString(ii, (String)parameters.get(RSMD.getColumnName(i).toLowerCase()));
					ii++ ;
				//}
			}
			
			int flag = ps.executeUpdate();
			if(flag > 0){
				return "";
			}else{
				return "检举信息保存失败！";
			}
			
		} catch (Exception e) {
			System.out.println("saveInfo ERROR :" +sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	
	/**
	 * 得到检举的内容
	 * @param tabname
	 * @param topicid
	 * @return
	 * @throws Exception
	 */
	public Map getTopic(String tabname,String topicid) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			Map map = new HashMap();
			
			sql = "select *,b.loginname,b.ctypetabname from b_inform a, k_user b where id = ? and a.iuser = b.loginid";
			ps = conn.prepareStatement(sql);
			ps.setString(1, topicid);
			rs = ps.executeQuery();
			
			ResultSetMetaData RSMD = rs.getMetaData();
			if(rs.next()){
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					map.put(RSMD.getColumnName(i).toLowerCase() , rs.getString(RSMD.getColumnName(i)));
				}
			}
			
			return map;
		} catch (Exception e) {
			System.out.println("getTopic ERROR :" +sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
	}
	
	
	/**
	 * 删除检举
	 * @param chooseValue
	 * @throws Exception
	 */
	public void delete(String chooseValue ) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			AttachFileUploadService afile = new AttachFileUploadService(conn);
			
			/**
			 * 删除主题表的附件
			 */
			
			sql = "delete from b_inform where id in ("+chooseValue+") ";
			ps = conn.prepareStatement(sql);
			ps.execute();
			DbUtil.close(ps);
			
		} catch (Exception e) {
			System.out.println("delete ERROR :" +sql);
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
}
