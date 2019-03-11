package cn.org.gdicpa.web.service.scoreItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.org.gdicpa.web.pub.db.DbUtil;

 
public class ScoreItemService {
	private Connection conn = null;

	public ScoreItemService(Connection conn) {
		this.conn = conn;
	}

	
	
	/** Map
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public Map getMapInfoBySql(String sql) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map map = new HashMap();
		 
		try {
			ps = conn.prepareStatement(sql);
	        rs = ps.executeQuery();
	        ResultSetMetaData RSMD = rs.getMetaData();
	        
			if(rs.next()){
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					System.out.println(rs.getObject(RSMD.getColumnName(i)).toString());
					map.put(RSMD.getColumnName(i).toLowerCase() , rs.getObject(RSMD.getColumnName(i)).toString().replaceAll("\n", "<br/>"));
				}
			}
			
	        return map;
	        
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
	}
	
	
	/** String
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public String getStringInfoBySql(String sql,String split) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String value = "";
		try {
			Map map = new HashMap();
			ps = conn.prepareStatement(sql);
	        rs = ps.executeQuery();
	        ResultSetMetaData RSMD = rs.getMetaData();	
			while(rs.next()){
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					value += rs.getObject(RSMD.getColumnName(i))+split;
				}
			}
	        return value;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
	}
	
	
	public List getListBySql(String sql) {

		PreparedStatement ps = null ;
		ResultSet rs = null ;
		List list = new ArrayList();
		try {
			ps = conn.prepareStatement(sql) ;
			rs = ps.executeQuery() ;
			ResultSetMetaData RSMD = rs.getMetaData();
			while(rs.next()){
				Map map = new HashMap();
				for (int i = 1; i<=RSMD.getColumnCount(); i++) {
					map.put(RSMD.getColumnName(i).toLowerCase(),rs.getString(RSMD.getColumnName(i).toLowerCase()));
				}
				list.add(map);
			}
			return list ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally{
			DbUtil.close(rs) ;
			DbUtil.close(ps) ;
			
		}
		return null ;
	}
}
