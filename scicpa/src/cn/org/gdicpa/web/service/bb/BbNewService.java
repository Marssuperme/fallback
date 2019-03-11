package cn.org.gdicpa.web.service.bb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.service.bbqtzcpg.model.QtzcpgTable;

public class BbNewService {
	
	
	private Connection conn;
	public BbNewService(Connection conn){
		this.conn = conn;
	}
	
	public Map<?,?> getMap(String sql) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;		
		try {
			ASFuntion CHF = new ASFuntion();
			Map map = null;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();	
			if(rs.next()){
				map = new HashMap();
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					map.put(RSMD.getColumnLabel(i).toLowerCase() ,CHF.showNull(rs.getObject(RSMD.getColumnLabel(i))+"") );
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
	
	
	/**
	 * 插入数据
	 * @param table 表名
	 * @param fields 所以的字段名 以逗号分隔
	 * @param fields 所以的字段名 以逗号分隔
	 * @param map 提交上来的数据Map类型
	 * @return
	 * @throws Exception
	 */
	public int insertInfo(String table,String fields,Map<?,?> map) throws Exception{
		int result=0;
		PreparedStatement ps = null;
		try {
			String sql = "",sql2 = "?";
		
			String[] fieldsArray=fields.split(",");
			for (int i = 1; i < fieldsArray.length; i++) {
					sql2 += ",?";
			}
			sql = "insert into "+table+" ("+fields+") values ("+sql2.substring(1)+") ";
			ps = conn.prepareStatement(sql);
			int ii = 1;
			for (int i = 0; i < fieldsArray.length; i++) {
					String string = (String)map.get(fieldsArray[i]);
					ps.setString(ii, (string == null) ? "" : string );
					ii++;
			}
				
			
			result=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
		
	}
	
	public int insertInfo(String table,Map<?,?> map) throws Exception{
		int result=0;
		PreparedStatement ps = null;
		ResultSet rs = null;	
		try {
			String sql = "",sql1 = "",sql2 = "";
		
			sql = "select * from "+table+" where 1=2 " ;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();
			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					sql1 += ","+RSMD.getColumnLabel(i).toLowerCase()+"";
					sql2 += ",?";
			}
			
			sql = "insert into "+table+" ("+sql1.substring(1)+") values ("+sql2.substring(1)+") ";
			ps = conn.prepareStatement(sql);
			int ii = 1;
			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					String string = (String)map.get(RSMD.getColumnLabel(i).toLowerCase());
					ps.setString(ii, (string == null) ? "" : string );
					ii++;
			}
			result=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
		
	}
	
	public int updateInfo(String table,String fields,String field,Map<?,?> map) throws Exception{
		int result=0;
		PreparedStatement ps = null;
		try {
			String[] fieldsArray=fields.split(",");
			int fal=fieldsArray.length;
			
			String sql = "";
			String sql2 = fieldsArray[0]+"=?";
			for (int i = 1; i < fal; i++) {
					sql2 +=","+ fieldsArray[i]+"=?";
			}
			sql = "update  "+table+"  set  "+sql2+" where "+field+"=?";
			ps = conn.prepareStatement(sql);
			int ii = 1;
			
			for (int i = 0; i < fal; i++) {
					String string = (String)map.get(fieldsArray[i]);
					ps.setString(ii, (string == null) ? "" : string );
					ii++;
			}
			ps.setString(ii, (String)map.get(field) );	
			
			result=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
		
	}
	
	public int updateInfo(String table,String field,Map<?,?> map) throws Exception{
		int result=0;
		PreparedStatement ps = null;
		String sql="";
		String sql1="";
		String sql2="";
		ResultSet rs = null;	
		try {
			//修改
			ASFuntion CHF = new ASFuntion();
			sql = "select * from "+table+" where 1=2 " ;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();
			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
				if(!CHF.showNull(field).toLowerCase().equals(RSMD.getColumnLabel(i).toLowerCase()) 
					){
					sql1 += ","+RSMD.getColumnLabel(i).toLowerCase()+" = ? ";
				}
			}
			
			sql = "update "+table+" set " + sql1.substring(1) + " where "+field+" = ? ";
			ps = conn.prepareStatement(sql);
			int ii = 1;
			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
				if(!CHF.showNull(field).toLowerCase().equals(RSMD.getColumnLabel(i).toLowerCase()) 
				){
					String string = (String)map.get(RSMD.getColumnLabel(i).toLowerCase());
					ps.setString(ii, (string == null) ? "" : string );
					ii++;
				}
			}
			ps.setString(ii, (String)map.get(CHF.showNull(field).toLowerCase()));
			result=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
		
	}
		
	public int saveInfo(String table,String field,Map<?,?> map) throws Exception{
		
		int result=0;
		PreparedStatement ps = null;
		ResultSet rs = null;	
		try {
			ASFuntion CHF = new ASFuntion();
			String sql = "",sql1 = "",sql2 = "";
			//检查记录是否存在，不存在则插入，存在则修改
			
			sql="select  1 from "+table+" where uuid='"+CHF.showNull((String)map.get(field))+"'" ;
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(!rs.next()){
				//插入
				sql = "select * from "+table+" where 1=2 " ;
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				ResultSetMetaData RSMD = rs.getMetaData();
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
						sql1 += ","+RSMD.getColumnLabel(i).toLowerCase()+"";
						sql2 += ",?";
				}
				
				sql = "insert into "+table+" ("+sql1.substring(1)+") values ("+sql2.substring(1)+") ";
				ps = conn.prepareStatement(sql);
				int ii = 1;
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
						String string = (String)map.get(RSMD.getColumnLabel(i).toLowerCase());
						ps.setString(ii, (string == null) ? "" : string );
						ii++;
				}
				
			}else{
				//修改
				sql = "select * from "+table+" where 1=2 " ;
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				ResultSetMetaData RSMD = rs.getMetaData();
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					if(!CHF.showNull(field).toLowerCase().equals(RSMD.getColumnLabel(i).toLowerCase()) 
						){
						sql1 += ","+RSMD.getColumnLabel(i).toLowerCase()+" = ? ";
					}
				}
				
				sql = "update "+table+" set " + sql1.substring(1) + " where "+field+" = ? ";
				ps = conn.prepareStatement(sql);
				int ii = 1;
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					if(!CHF.showNull(field).toLowerCase().equals(RSMD.getColumnLabel(i).toLowerCase()) 
					){
						String string = (String)map.get(RSMD.getColumnLabel(i).toLowerCase());
						ps.setString(ii, (string == null) ? "" : string );
						ii++;
					}
				}
				ps.setString(ii, (String)map.get(CHF.showNull(field).toLowerCase()));
			}
			result=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
		
	}
	
	
	public int saveAppli(String table,String field,Map map) throws Exception{
		
		int result=0;
		PreparedStatement ps = null;
		ResultSet rs = null;	
		try {
			ASFuntion CHF = new ASFuntion();
			String sql = "",sql1 = "",sql2 = "";
			//检查记录是否存在，不存在则插入，存在则修改
			if("R_SHZRLXTJB".equals(table)) {
				sql="select  1 from "+table+" where guid='"+CHF.showNull((String)map.get("Guid"))+"'" ;
			}else{
				sql="select  1 from "+table+" where zbid='"+CHF.showNull((String)map.get("ZBID"))+"'" ;
			}
			
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(!rs.next()){
				//插入
				sql = "select * from "+table+" where 1=2 " ;
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				ResultSetMetaData RSMD = rs.getMetaData();
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
						sql1 += ","+RSMD.getColumnLabel(i)+"";
						sql2 += ",?";
				}
				
				sql = "insert into "+table+" ("+sql1.substring(1)+") values ("+sql2.substring(1)+") ";
				ps = conn.prepareStatement(sql);
				int ii = 1;
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
						String string = (String)map.get(RSMD.getColumnLabel(i));
						ps.setString(ii, (string == null) ? "" : string );
						ii++;
				}
				
			}else{
				//修改
				sql = "select * from "+table+" where 1=2 " ;
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				ResultSetMetaData RSMD = rs.getMetaData();
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					if(!CHF.showNull(field).equals(RSMD.getColumnLabel(i)) 
						){
						sql1 += ","+RSMD.getColumnLabel(i)+" = ? ";
					}
				}
				
				sql = "update "+table+" set " + sql1.substring(1) + " where "+field+" = ? ";
				ps = conn.prepareStatement(sql);
				int ii = 1;
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					if(!CHF.showNull(field).equals(RSMD.getColumnLabel(i)) 
					){
						String string = (String)map.get(RSMD.getColumnLabel(i));
						ps.setString(ii, (string == null) ? "" : string );
						ii++;
					}
				}
				ps.setString(ii, (String)map.get(CHF.showNull(field)));
			}
			result=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
		
	}
	/**
	 * 验资注师/评估师 是否可以报备
	 * @param no (cpano/assessid)
	 * @param officecode
	 * @param officetype
	 * @return
	 */
  public String[] isApply(String no,String officecode,String officetype){
	    String[] num = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			
			sql = " select isapply,isremark  from k_micfo " 
				+ " where cpano = ? and officecode = ? ";
			
			// 评估所
			if("评估所".equalsIgnoreCase(officetype)){
				sql = " select isapply,isremark from k_assesser  "
					+ " where assessid = ? and officecode = ? ";
			}
			
			ps = conn.prepareStatement(sql);
			ps.setString(1,no);
			ps.setString(2, officecode);
			rs = ps.executeQuery();
			if(rs.next()){
				String[] arr=new String[2];
				arr[0]= rs.getString("isapply"); arr[1]=rs.getString("isremark");
				num=arr;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return num;
  }
  /**
	 * 验资事务所是否可以报备
	 * @param no (cpano/assessid)
	 * @param officecode
	 * @param officetype
	 * @return
	 */
public String canreport(String officecode){
	    String canreport = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			
			sql = " select canreport  from k_company where loginid = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, officecode);
			rs = ps.executeQuery();
			if(rs.next()){
				canreport = rs.getString("canreport");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return canreport;
}
}
