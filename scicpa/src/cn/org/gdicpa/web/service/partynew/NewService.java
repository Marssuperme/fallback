package cn.org.gdicpa.web.service.partynew;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import cn.org.gdicpa.web.pub.autocode.DELUnid;
import cn.org.gdicpa.web.pub.db.DbUtil;

public class NewService {

	private Connection conn = null;
	
	public NewService(Connection conn) {
		this.conn = conn;
	}
	
	//删除
	public String del(String tabname,String id) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			String result = "";
			sql = "select * from " + tabname + " where id in ('"+id+"') and isnull(status,0) = 1 ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				result += "此新闻["+rs.getString("caption")+"]已审核，不能删除；\\n";
			}
			
			sql = "delete from " + tabname + " where id in ('"+id+"') and isnull(status,0) = 0 ";
			ps = conn.prepareStatement(sql);
			ps.execute();
			
			return result;
		} catch (Exception e) {
			System.out.println("saveInfo ERROR :" +sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	//保存
	public String saveInfo(String tabname,Map parameters) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			String id = (String)parameters.get("id");
			if(id != null && !"".equals(id) && !"null".equals(id)){
				del( tabname, id);
			}
			
			sql = "select top 1 * from " + tabname + " ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();
			sql = "";
			String sql1 = "", sql2 = "";
			
			if("b_new".equalsIgnoreCase(tabname)){
				parameters.put("id", DELUnid.getCharUnid());
			}
			
			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
				if("b_new".equalsIgnoreCase(tabname)){
					sql1 += ","+RSMD.getColumnName(i).toLowerCase()+" ";
					sql2 += ",? ";
				}else{
					if(!"id".equals(RSMD.getColumnName(i).toLowerCase())){	//自动编号
						sql1 += ","+RSMD.getColumnName(i).toLowerCase()+" ";
						sql2 += ",? ";
					}
				}
			}
			
			sql = "insert into  " + tabname + " (" + sql1.substring(1) + ") values (" + sql2.substring(1) + ") ";
			
			ps = conn.prepareStatement(sql);
			int ii = 1;
			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
				if("b_new".equalsIgnoreCase(tabname)){
					ps.setString(ii, (String)parameters.get(RSMD.getColumnName(i).toLowerCase()));
					ii++ ;
				}else{
					if(!"id".equals(RSMD.getColumnName(i).toLowerCase())){	//自动编号
						ps.setString(ii, (String)parameters.get(RSMD.getColumnName(i).toLowerCase()));
						ii++ ;
					}
				}
			}
			
			int flag = ps.executeUpdate();
			if(flag > 0){
				return "";
			}else{
				return "党建新闻信息发布失败！";
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
	
	public Map get(String table,String nid) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			Map map = new HashMap();
			
			sql = "select * from " + table + "  where id = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, nid);
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
	
	
	public Map get(String table,String nid,String reader)throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			Map map = new HashMap();
			sql = " select d.*,c.name as agencyname from " + table + " as d left join k_customer as c" 
			+ " on d.customerid  = c.id where d.id = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, nid);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();
			String attachmentid = "";	// 正文附件编号
			if(rs.next()){
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					if(RSMD.getColumnName(i).toLowerCase().equalsIgnoreCase("attachmentid")){
						attachmentid = rs.getString(RSMD.getColumnName(i));
					}
					if(RSMD.getColumnName(i).toLowerCase().equalsIgnoreCase("body")){
						if(rs.getString(RSMD.getColumnName(i))!=null && !"".equals(rs.getString(RSMD.getColumnName(i)))){
							if(rs.getString(RSMD.getColumnName(i)).indexOf("\n")>-1){
								String[] acontents = rs.getString(RSMD.getColumnName(i)).split("\n");
								String temp = "";
								for (int j = 0; j < acontents.length; j++) {
									temp=temp+acontents[j]+"<br>";
								}
								map.put(RSMD.getColumnName(i).toLowerCase() , temp);
								continue;
							}
						}
					}
					map.put(RSMD.getColumnName(i).toLowerCase() , rs.getString(RSMD.getColumnName(i)));
				}
			}
			DbUtil.close(rs);
			DbUtil.close(ps);
			
			
			// 得到 正文 对应的附件
			sql = " select indexid from k_attachfile Where indextable = '"+table+"' and initflag = '0' and property = '"+attachmentid+"'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				map.put("attachmentids", rs.getString(1));
			}
			
			DbUtil.close(rs);
			DbUtil.close(ps);
			 
			
			sql = "select * from b_reader where nid = ? and reader = ? and source = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, nid);
			ps.setString(2, reader);
			ps.setString(3, table);
			rs = ps.executeQuery();
			RSMD = rs.getMetaData();
			if(rs.next()){
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					if(!"id".equals(RSMD.getColumnName(i).toLowerCase())){
						map.put(RSMD.getColumnName(i).toLowerCase() , rs.getString(RSMD.getColumnName(i)));
					}
				}
			}
			
			return map;
		} catch (Exception e) {
			System.out.println("saveInfo ERROR :" +sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
}
