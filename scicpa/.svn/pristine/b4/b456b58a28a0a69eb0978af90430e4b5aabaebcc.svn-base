package cn.org.gdicpa.web.service.posts;

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

public class PostsService {

	private Connection conn = null;
	
	public PostsService(Connection conn) {
		this.conn = conn;
	}
	
	/**
	 * 保存招聘信息
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
				if(!"topicid".equals(RSMD.getColumnName(i).toLowerCase())){	//自动编号
					sql1 += ","+RSMD.getColumnName(i).toLowerCase()+" ";
	 				sql2 += ",? ";
				}
			}
			
			sql = "insert into  " + tabname + " (" + sql1.substring(1) + ") values (" + sql2.substring(1) + ") ";
			ps = conn.prepareStatement(sql);
			int ii = 1;
			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
				if(!"topicid".equals(RSMD.getColumnName(i).toLowerCase())){	//自动编号
					ps.setString(ii, (String)parameters.get(RSMD.getColumnName(i).toLowerCase()));
					ii++ ;
				}
			}
			
			int flag = ps.executeUpdate();
			if(flag > 0){
				return "";
			}else{
				return "招聘信息信息发布失败！";
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
	 * 得到主题表的内容
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
			
			sql = "select *,b.loginname,b.ctypetabname from " + tabname + " a, k_user b where topicid = ? and a.loginid = b.loginid";
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
	 * 得到贴子的内容
	 * @param tabname
	 * @param topicid
	 * @return
	 * @throws Exception
	 */
	public ArrayList getPosts(String tabname,String topicid) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			
//			Map map = new HashMap();
			ArrayList list = new ArrayList();
//			list.remove(list.size());
			
			sql = "select *,b.loginname,b.ctypetabname from " + tabname + " a, k_user b where topicid = ? and a.loginid = b.loginid order by posttime";
			ps = conn.prepareStatement(sql);
			ps.setString(1, topicid);
			rs = ps.executeQuery();
			
			ResultSetMetaData RSMD = rs.getMetaData();
			int ii = 0;
			while(rs.next()){
				Map mapTemp = new HashMap();
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					if("attachment".equals(RSMD.getColumnName(i).toLowerCase())){
						mapTemp.put(RSMD.getColumnName(i).toLowerCase() , rs.getBinaryStream("attachment"));
					}else{
						mapTemp.put(RSMD.getColumnName(i).toLowerCase() , rs.getString(RSMD.getColumnName(i)));
					}
				}
				
//				map.put("posts" + ii, mapTemp);
				list.add(mapTemp);
				ii++;
			}
//			map.put("postCount", ii);
			list.add(ii);
			
			return list;
		} catch (Exception e) {
			System.out.println("getPosts ERROR :" +sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	/**
	 * 生成附件
	 * @param tabname
	 * @param topicid
	 * @param postid
	 * @param newPath
	 * @param fileTempName
	 * @throws Exception
	 */
	public String getFile(String tabname,String topicid,String postid,String newPath,String fileTempName) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {

			InputStream input = null;
			String attachmentName = "",filename = "";
			sql = "select * from " + tabname + " where topicid = ? ";
			if(!"".equals(postid)){
				sql += " and postid = ? ";
			}
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, topicid);
			if(!"".equals(postid)){
				ps.setString(2, postid);
			}
			rs = ps.executeQuery();
			if(rs.next()){
				attachmentName = rs.getString("attachmentName");
				filename = rs.getString("filename"); 
				input = rs.getBinaryStream("attachment"); 
			}
			
			fileTempName = fileTempName + filename.substring(filename.lastIndexOf("."));//加上文件类型
			
			String newfile1 = newPath + attachmentName;
			String newfile2 = newPath + fileTempName;
			System.out.println(newfile2);
			//删除旧图片
			if(!"".equals(attachmentName)){
				File file1 = new File(newfile1);
				if(file1.exists()) {
					file1.delete() ;
				}
			}
			
			File file2  = new File(newfile2);
			if(file2.exists()) {
				file2.delete() ;
			}
			
			FileOutputStream output = new FileOutputStream(newfile2);
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = input.read(b)) != -1) {
				output.write(b, 0, len);
			}
			output.flush();
			output.close();
			input.close();
			
			
			
			sql = "update " + tabname + " set attachmentName = ? where topicid = ? ";
			if(!"".equals(postid)){
				sql += " and postid = ? ";
			}
			ps = conn.prepareStatement(sql);
			ps.setString(1, fileTempName);
			ps.setString(2, topicid);
			if(!"".equals(postid)){
				ps.setString(3, postid);
			}
			ps.execute();
			
			return fileTempName;
		} catch (Exception e) {
			System.out.println("getPhoto ERROR : "+ sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	/**
	 * 保存帖子内容
	 * @param tabname
	 * @param userMap
	 * @param parameters
	 * @return
	 * @throws Exception
	 */
	public String savePost(String tabname,Map parameters) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			String tempdir = (String)parameters.get("tempdir");//文件临时路径
			String filename = (String)parameters.get("filename");//附件名
			String trace = tempdir + filename;
			
			sql = "select top 1 * from " + tabname + " ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();
			sql = "";
			String sql1 = "", sql2 = "";
			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
				if(!"postid".equals(RSMD.getColumnName(i).toLowerCase())){	//自动编号
					sql1 += ","+RSMD.getColumnName(i).toLowerCase()+" ";
	 				sql2 += ",? ";
				}
			}
			
			sql = "insert into  " + tabname + " (" + sql1.substring(1) + ") values (" + sql2.substring(1) + ") ";
			ps = conn.prepareStatement(sql);
			int ii = 1;
			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
				if(!"postid".equals(RSMD.getColumnName(i).toLowerCase())){	//自动编号
					ps.setString(ii, (String)parameters.get(RSMD.getColumnName(i).toLowerCase()));
					ii++ ;
				}
			}
			
			int flag = ps.executeUpdate();
			if(flag > 0){
				return "";
			}else{
				return "回复信息发布失败！";
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
	 * 保存主题表的【最后发表人、最后发表日期、回复次数】
	 * @param loginid
	 * @param time
	 * @throws Exception
	 */
	public void updateChild(String topicid,String loginid,String time) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = "update b_topic set lastpost = ? ,lastposttime = ? ,child = child+1 where topicid = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginid);
			ps.setString(2, time);
			ps.setString(3, topicid);
			ps.execute();
			
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
	 * 修改查看次数
	 * @param topicid
	 * @throws Exception
	 */
	public void updateHits(String topicid) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = "update b_topic set hits = hits+1 where topicid = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, topicid);
			ps.execute();
			
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
	 * 修改贴子得分
	 * @param postid
	 * @param topicid
	 * @param scoring
	 * @throws Exception
	 */
	public String updateScoring(String postid,String topicid,String scoring) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " select case when fraction >= scoring then 1 else 0 end as opt " +
			"	from b_topic a,(" +
			"		select topicID,sum(scoring)+? as scoring " +
			"		from b_post where topicID=? group by topicID " +
			"	) b " +
			"	where a.topicID=? and a.topicID = b.topicID ";
			ps = conn.prepareStatement(sql);
			ps.setString(1,scoring);
			ps.setString(2,topicid);
			ps.setString(3,topicid);
			rs = ps.executeQuery();
			if(rs.next()){
				int opt = rs.getInt("opt");
				if(opt == 0 ){
					return "贴子评分总值大于问题分数，此次评分失败！";
				}
			}
			DbUtil.close(rs);
			DbUtil.close(ps);
			
			sql = "update b_post set scoring = ? where postid = ? and topicID = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1,scoring);
			ps.setString(2,postid);
			ps.setString(3,topicid);
			ps.execute();
			return "";
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
	 * 删除主题和贴子
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
			 * 删除贴子表的附件
			 */
			sql = "select * from b_post where topicID in ("+chooseValue+") ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String attachmentid = rs.getString("attachmentid");
				afile.delModuleFile("b_post",attachmentid);
			}
			DbUtil.close(rs);
			DbUtil.close(ps);
			
			/**
			 * 删除主题表的附件
			 */
			sql = "select * from b_topic where topicID in ("+chooseValue+") ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String attachmentid = rs.getString("attachmentid");
				afile.delModuleFile("b_topic",attachmentid);
			}
			DbUtil.close(rs);
			DbUtil.close(ps);
			
			sql = "delete from b_post where topicID in ("+chooseValue+") ";
			ps = conn.prepareStatement(sql);
			ps.execute();
			DbUtil.close(ps);
			
			sql = "delete from b_topic where topicID in ("+chooseValue+") ";
			ps = conn.prepareStatement(sql);
			ps.execute();
			
		} catch (Exception e) {
			System.out.println("delete ERROR :" +sql);
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
}
