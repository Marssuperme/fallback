package cn.org.gdicpa.web.service.task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import cn.org.gdicpa.web.pub.db.DbUtil;

public class TaskService {
	private Connection conn = null;
	public TaskService(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 得到在线填报对象
	 * @param id
	 * @return
	 */
	public Map getTask(String id,String loginid){
		PreparedStatement ps = null;
		ResultSet rs = null;
		String t_attachment="";  // k_task 任务表的 的 attachment 值
		String sql = "";
		try {
			Map map = new HashMap();
			
			sql = "select t.*,u.loginname from k_task as t left join k_user as u on t.publisher=u.loginid where t.id = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();
			if(rs.next()){
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					map.put(RSMD.getColumnName(i).toLowerCase() , rs.getString(RSMD.getColumnName(i)));
					if(RSMD.getColumnName(i).toLowerCase().equalsIgnoreCase("attachment")){
						t_attachment = rs.getString(RSMD.getColumnName(i));
					}
					// 处理 Delphi 里面的换行
//					if(RSMD.getColumnName(i).equalsIgnoreCase("describe")){
//						if(rs.getString(RSMD.getColumnName(i))!=null && !"".equals(rs.getString(RSMD.getColumnName(i)))){
//							if(rs.getString(RSMD.getColumnName(i)).indexOf("\n")>-1){	
//								String[] describes = rs.getString(RSMD.getColumnName(i)).split("\n");
//								String temp = "";
//								for (int j = 0; j < describes.length; j++) {
//									temp = temp + describes[j]+"<br>";
//								}
//								map.put("describe", temp);
//							}
//						}
//					}
				}
			}
			
			
			// 找 k_attachfile 附件表是不是已经有对应的附件了
			if(t_attachment==null || "".equals(t_attachment)){
				map.put("indexId","");
			}else{
				sql = "select * from k_attachfile where indexId = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, t_attachment);
				rs = ps.executeQuery();
				if(rs.next()){
					map.put("indexId", rs.getString("indexId"));
				}
			}
			
			sql = "select * from k_reply where replyer = ? and tid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginid);
			ps.setString(2, id);
			rs = ps.executeQuery();
			if(rs.next()){
				map.put("replyId" , rs.getString("id"));
				map.put("tid" , rs.getString("tid"));
				map.put("replyer" , rs.getString("replyer"));
				map.put("replytime" , rs.getString("replytime"));
				map.put("replyerattachment" , rs.getString("attachment"));
				map.put("contents" , rs.getString("contents"));
				map.put("stext" , rs.getString("stext"));
			}
			
			return map;
		}catch(Exception e){
			System.out.println("saveInfo ERROR :" +sql);
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return null;
	}
	

	/**
	 * 回复
	 * @param tid
	 * @param replyer
	 * @param replytime
	 * @param attachment
	 * @param contents
	 * @throws Exception 
	 */
	public void reply(String id,String replytime,String attachment,String contents) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			System.out.println(this.getClass()+"       id="+id+"  replytime="+replytime+"   attachment="+attachment+" contents="+contents);
			sql = " update k_reply set replytime=?,attachment=?,contents=? where id=? " ;
			
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, replytime);
			ps.setString(i++, attachment);
			ps.setString(i++, contents);
			ps.setString(i++, id);
			
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
	}
	
	/**
	 * 回复
	 * @param tid
	 * @param replyer
	 * @param replytime
	 * @param attachment
	 * @param contents
	 * @throws Exception 
	 */
	public void replyBak(String tid,String replyer,String replytime,String attachment,String contents) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = "delete from k_reply where tid = ? and replyer = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, tid);
			ps.setString(2, replyer);
			ps.execute();
			
			sql = " insert into k_reply(id,tid,replyer,replytime,attachment,contents)" 
				+ " values (?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, UUID.randomUUID().toString());
			ps.setString(i++, tid);
			ps.setString(i++, replyer);
			ps.setString(i++, replytime);
			ps.setString(i++, attachment);
			ps.setString(i++, contents);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
	}
	
}
