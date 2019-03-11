package cn.org.gdicpa.web.service.supTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;

import cn.org.gdicpa.web.pub.db.DbUtil;

public class SupTaskService {
	private Connection conn = null;
	public SupTaskService(Connection conn){
		this.conn = conn;
	}
	
	/**
	 * 得到在线填报对象
	 * @param id
	 * @return
	 */
	public Map getSupTask(String id,String loginid){
		PreparedStatement ps = null;
		ResultSet rs = null;
		String t_attachment="";  // k_task 任务表的 的 attachment 值
		String sql = "";
		try {
			Map map = new HashMap();
			
			sql = " select s.id,s.title as stitle,t.title as ttitle,s.taskMan,s.PublishType,s.enddate,s.createDate,s.department," 
				+ " s.CustomerName,s.attachment,s.taskcnt,u.loginname " 
				+ " from K_SupTask as s " 
				+ " left join k_user as u on s.createby=u.loginid " 
				+"  left join k_testernotice as t on s.NotcieID = t.id where s.id = ? ";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();
			if(rs.next()){ 
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					map.put(RSMD.getColumnName(i).toLowerCase() , rs.getString(RSMD.getColumnName(i)));
					if(RSMD.getColumnName(i).equalsIgnoreCase("taskcnt")){
						System.out.println(rs.getString("taskcnt")+"    "+rs.getString(RSMD.getColumnName(i)));
					}
					if(RSMD.getColumnName(i).toLowerCase().equalsIgnoreCase("attachment")){
						t_attachment = rs.getString(RSMD.getColumnName(i));
					}
				}
			}
			
			sql = "select * from k_reply where tid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
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
	public void reply(String tid,String replytime,String attachment,String contents) throws Exception{
		DbUtil.checkConn(conn);
		PreparedStatement ps = null;
		String sql = "";
		try {
			System.out.println(this.getClass()+"       tid="+tid+"  replytime="+replytime+"   attachment="+attachment+" contents="+contents);
			sql = " update k_reply set replytime=?,attachment=?,contents=? where tid=? " ;
			
			ps = conn.prepareStatement(sql);
			int i = 1;
			ps.setString(i++, replytime);
			ps.setString(i++, attachment);
			ps.setString(i++, contents);
			ps.setString(i++, tid);
			
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DbUtil.close(ps);
		}
	}
	
}
