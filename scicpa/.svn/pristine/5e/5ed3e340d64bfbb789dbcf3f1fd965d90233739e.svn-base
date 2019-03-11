package cn.org.gdicpa.web.service.user;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.MD5;
import cn.org.gdicpa.web.service.approval.ApprovalService;

public class UserService {
	
	private Connection conn = null;
	
	public UserService(Connection conn) {
		this.conn = conn;
	}
	
	/**
     * 登录
     * @param user
     * @param pass
     * @return
     * @throws Exception
     */
    public Map getUserLogin(String loginId,String userType,String dog) throws Exception {
    	PreparedStatement ps = null;
        ResultSet rs = null;
    	String sql = "";
    	try {
    		Map map = new HashMap();
			if("1".equals(userType)){
				sql = " select * from k_user where (ctypetabname = 'k_company' or ctypetabname = 'k_assess' ) and loginId=?  ";
			}else{
				sql = " select * from k_user where ctypetabname <> 'k_company' and (loginId=? or assessId=?)  ";
			}
			
			if("0".equals(dog)){   // 特殊  事务所用户在界面选择了 个人用户登陆方式 也登陆进去
				sql = " select * from k_user where loginId=?  ";
			}
			
			ps = conn.prepareStatement(sql);
            ps.setString(1, loginId);
            if(!"1".equals(userType) && !"0".equals(dog)){
            	ps.setString(2, loginId);
            }
    		rs = ps.executeQuery();
    		ResultSetMetaData RSMD = rs.getMetaData();	
    		if(rs.next()){
    			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
    				map.put(RSMD.getColumnName(i).toLowerCase() , rs.getString(RSMD.getColumnName(i)));
				}
    		}
    		DbUtil.close(rs);
			DbUtil.close(ps);
			
//			System.out.println(map);
			
			//取得会员类型的判断
			String tableName=(String)map.get("ctypetabname");
			
			if ("k_micfo".equals(tableName.toLowerCase())){
				//如果是执业会员，就在环境变量里面追加cpano
				sql = "select * from K_Micfo where loginId=? ";
				ps = conn.prepareStatement(sql);
	            ps.setString(1, loginId);
	            rs = ps.executeQuery();
	            if (rs.next()){
	            	map.put("cpano",rs.getString("cpano"));
	            }
	            DbUtil.close(rs);
				DbUtil.close(ps);
			}
			
			if ("k_company".equals(tableName.toLowerCase()) || "k_assess".equals(tableName.toLowerCase()) ){
				//如果是团体会员，就在环境变量里面追加 address  所属地 和 事务所类型 OfficeType (评估所还是事务所)
				sql = "select * from k_company where loginId=? ";
				ps = conn.prepareStatement(sql);
	            ps.setString(1, loginId);
	            rs = ps.executeQuery();
	            if (rs.next()){
	            	map.put("address",rs.getString("address"));
	            	map.put("area",rs.getString("area"));
	            	map.put("officetype",rs.getString("OfficeType"));
	            }
	            
	            // 把 bb_content1 的字段 信息 存到 环境变量里面，兼容不同注协 使用的 报备字段
	            sql = " select tableName,fieldName,fieldMean from s_meaning where tableName = 'bb_content1' ";
	            ps = conn.prepareStatement(sql);
	            rs = ps.executeQuery();
	            while(rs.next()){
            		map.put(rs.getString("tableName").toLowerCase()+"_"+rs.getString("fieldName").toLowerCase(),rs.getString("fieldMean"));
	            }
	            
	            DbUtil.close(rs);
				DbUtil.close(ps);
			}
			
			sql = " select svalue from s_config where sname='系统省注协' ";
			
			
			ps = conn.prepareStatement(sql);
    		rs = ps.executeQuery();
    		if(rs.next()){
				map.put("sys_province_cicpa" , rs.getString("svalue"));
    		}
    		
    		System.out.println("sys_province_cicpa="+map.get("sys_province_cicpa"));
    		
    		DbUtil.close(rs);
			DbUtil.close(ps);
			
//			String tableName = (String)map.get("ctypetabname");
//			K_CICPA			-- 省注协用户、各地市注协对口业务部门用户：
//			K_Company		-- 团体会员表【公司会员表】:
//			K_Micfo			-- 执业会员表：
//			K_MicfoNo		-- 非执业会员：
//			K_Director		-- 理事和专业委员会成员：
//			K_Government	-- 政府查询用户：
//			sql = "select * from " + tableName + " where loginId=? ";
//			ps = conn.prepareStatement(sql);
//            ps.setString(1, loginId);
//            rs = ps.executeQuery();
//    		RSMD = rs.getMetaData();	
//    		if(rs.next()){
//    			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
//    				if("userphoto".equals(RSMD.getColumnName(i).toLowerCase())){
//    					map.put(RSMD.getColumnName(i).toLowerCase() , rs.getBinaryStream("userPhoto"));
//    				}else{
//    					map.put(RSMD.getColumnName(i).toLowerCase() , rs.getObject(RSMD.getColumnName(i)));
//    				}
//				}
//    		}
//    		DbUtil.close(rs);
//			DbUtil.close(ps); 
			
//			IC卡号 
//			sql = "select * from k_Card where loginid = ? ";
//			ps = conn.prepareStatement(sql);
//            ps.setString(1, loginId);
//            rs = ps.executeQuery();
//            if(rs.next()){
//            	map.put("cardid" , rs.getString("cardid"));
//            }
			
			return map;
		} catch (Exception e) {
			System.out.println("登录出错SQL："+sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
    	
    }
    
	
	/**
	 * 得到用户信息
	 * @param tabName
	 * @param loginid
	 * @return
	 * @throws Exception
	 */
	public Map getUser(String tabName,String loginid) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			Map map = new HashMap();
			
			sql = "select * from " + tabName + " where loginId=? ";
			ps = conn.prepareStatement(sql);
	        ps.setString(1, loginid);
	        rs = ps.executeQuery();
	        ResultSetMetaData RSMD = rs.getMetaData();	
			if(rs.next()){
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					//if("userphoto".equals(RSMD.getColumnName(i).toLowerCase())){
						//map.put(RSMD.getColumnName(i).toLowerCase() , rs.getBinaryStream("userPhoto"));
					//}else{
						map.put(RSMD.getColumnName(i).toLowerCase() , rs.getObject(RSMD.getColumnName(i)));
					//}
				}
			}
			DbUtil.close(rs);
			DbUtil.close(ps);
			
//			IC卡号 
			sql = "select * from k_Card where loginid = ? ";
			ps = conn.prepareStatement(sql);
	        ps.setString(1, loginid);
	        rs = ps.executeQuery();
	        if(rs.next()){
	        	map.put("cardid" , rs.getString("cardid"));
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
	 *	修改密码 
	 */
	public String updatePwd(String tabName,String loginid,String pwd_new,String pwd_old) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			System.out.println( tabName+"|"+loginid+"|"+pwd_new+"|"+pwd_old+"|"+MD5.getMD5String(pwd_old));
			sql = "select * from " + tabName + " where loginid = ? and pwd = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginid);
			ps.setString(2, MD5.getMD5String(pwd_old));
			rs = ps.executeQuery();
			if(rs.next()){
				System.out.println(this.getClass()+"     "+rs.getString(2));
				sql = "update " + tabName + " set pwd = ? where loginid = ? ";
				ps = conn.prepareStatement(sql);
				ps.setString(1, MD5.getMD5String(pwd_new));
				ps.setString(2, loginid);
				ps.execute();
				return "修改密码成功！";
			}else{
				System.out.println(this.getClass()+" ss33333333333333333333333333");
				return "原密码不正确，修改密码失败！";
			}
			
			
		} catch (Exception e) {
			System.out.println("updatePwd ERROR :" +sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	/**
	 * 保存修改
	 * @throws Exception
	 */
	public String saveInfo(Map userMap) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			String table = (String)userMap.get("ctypetabname");
			String loginid = (String)userMap.get("loginid");
			ApprovalService ss = new ApprovalService(conn);
			ss.save(table, loginid, userMap);
			return ""; 
			
//			String tabName = (String)userMap.get("ctypetabname");
//			sql = "select top 1 * from " + tabName + " ";
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			ResultSetMetaData RSMD = rs.getMetaData();
//			sql = "";
//			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
//				if(!"loginid".equals(RSMD.getColumnName(i).toLowerCase()) 
//					&& !"pwd".equals(RSMD.getColumnName(i).toLowerCase())
//					&& !"userphoto".equals(RSMD.getColumnName(i).toLowerCase())
//					&& !"userphotoname".equals(RSMD.getColumnName(i).toLowerCase())
//					
//					){
//					sql += ","+RSMD.getColumnName(i).toLowerCase()+" = ? ";
//				}
//			}
//			
//			sql = "update " + tabName + " set " + sql.substring(1) + " where loginid = ? ";
//			ps = conn.prepareStatement(sql);
//			int ii = 1;
//			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
//				if(!"loginid".equals(RSMD.getColumnName(i).toLowerCase()) 
//					&& !"pwd".equals(RSMD.getColumnName(i).toLowerCase())
//					&& !"userphoto".equals(RSMD.getColumnName(i).toLowerCase())
//					&& !"userphotoname".equals(RSMD.getColumnName(i).toLowerCase())
//					){
//					String string = (String)userMap.get(RSMD.getColumnName(i).toLowerCase());
//					ps.setString(ii, (string == null) ? "" : string );
//					ii++;
//				}
//			}
//			ps.setString(ii , (String)userMap.get("loginid"));
//			
//			int flag = ps.executeUpdate();
//			if(flag > 0){
//				return "";
//			}else{
//				return "修改个人信息失败！";
//			}
			
		} catch (Exception e) {
			System.out.println(this.getClass()+"  >>>   saveInfo ERROR : "+ sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	/**
	 * 保存上传图片
	 */
	public String savePhoto(String tabname,String loginid,String uploadtemppath,Map parameters) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = " update " + tabname + " set userPhotoname = ? where loginid = ? ";
			// 针对执业会员 oa  里面 需要检查 是否上传 照片了
			if("k_micfo".equalsIgnoreCase(tabname)){
				sql = " update " + tabname + " set userPhotoname = ?,isupload='1' where loginid = ? ";
			}
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginid);
			ps.setString(2, loginid);
			int flag = ps.executeUpdate();
			if(flag > 0){
				return "上传图片成功！";
			}else{
				return "上传图片失败！";
			}
			
		} catch (Exception e) {
			System.out.println("savePhoto ERROR : "+ sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
	}
	
	public String getPhoto(String tabname,String loginid,String fileTempName) throws Exception {
		try {
			String newPath =  this.getClass().getResource("/").getPath();
			newPath = newPath + "../../photo/";
			return getPhoto( tabname, loginid, newPath, fileTempName);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		} finally {
		}
		
	}
	
	/**
	 * 读取图片
	 */
	public String getPhoto(String tabname,String loginid,String newPath,String fileTempName) throws Exception {
		System.out.println(this.getClass()+"   tabName="+tabname);
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {

			String userPhotoName = "";
			sql = "select * from " + tabname + " where loginid = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginid);
			rs = ps.executeQuery();
			if(rs.next()){
				userPhotoName = rs.getString("userPhotoName"); 
			}
			 
			if(userPhotoName!=null && !"".equals(userPhotoName)){
				return "/common/attachFile/"+tabname+"/" + loginid;
			}else{
				if(tabname.equalsIgnoreCase("k_company")){
					return "/images/comp.png";
				}else{
					return "/images/administrator.png";
				}
			}
			
		} catch (Exception e) {
			System.out.println("getPhoto ERROR : "+ sql);
			e.printStackTrace();
			if(tabname.equalsIgnoreCase("k_company")){
				return "/images/comp.png";
			}else{
				return "/images/administrator.png";
			}
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	/**
	 * 删除图片
	 * @param tabname
	 * @param loginid
	 * @param path
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public String delPhoto(String tabname,String loginid,String path,String fileName) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			String delfile = path + fileName;
			System.out.println(delfile);
			File file  = new File(delfile);
			if(file.exists()) {
				file.delete() ;
			}
			
			sql = "update " + tabname + " set userPhoto = null, userPhotoName = '' where loginid = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginid);
			ps.execute();
			
			return "";
		} catch (Exception e) {
			System.out.println("delPhoto ERROR : "+ sql);
			e.printStackTrace();
			return "删除个人图片失败！";
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	/**
	 * 判断登录名是否可用,1 为可用,0 为不可用
	 * @param loginid
	 * @return 
	 * @throws Exception
	 */
	public String isLogin(String loginid) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			String string = "1";
			sql = "select * from k_user where loginid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginid);
			rs = ps.executeQuery();
			if(rs.next()){
				string = "0";
			}
			return string;
		} catch (Exception e) {
			System.out.println("isLogin ERROR : "+ sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	/**
	 * 注册用户
	 * @param tabname	新增记录的表名
	 * @param tempname	记录表对应的字段
	 * @param map
	 * @throws Exception
	 */
	public String insert(String tabname,String tempname,Map map) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = "select top 1 * from " + tempname + " ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();
			String sql1 = "", sql2 = "";
			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
				sql1 += ","+RSMD.getColumnName(i).toLowerCase()+" ";
 				sql2 += ",? ";
			}
			sql = "insert into  " + tabname + " (" + sql1.substring(1) + ") values (" + sql2.substring(1) + ") ";
			ps = conn.prepareStatement(sql);
			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
				if("pwd".equals(RSMD.getColumnName(i).toLowerCase())){
					ps.setString(i, MD5.getMD5String((String)map.get(RSMD.getColumnName(i).toLowerCase())));
				}else{
					ps.setString(i, (String)map.get(RSMD.getColumnName(i).toLowerCase()));
				}
			}

			int flag = ps.executeUpdate();
			if(flag > 0){
				return "";
			}else{
				return "新增注册信息失败！";
			}
		} catch (Exception e) {
			System.out.println("insert ERROR : "+ sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
}
