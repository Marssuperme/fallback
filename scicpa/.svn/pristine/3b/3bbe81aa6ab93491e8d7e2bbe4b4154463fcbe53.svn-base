package cn.org.gdicpa.web.service.approval;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.ASFuntion;

public class  ApprovalService {

	private Connection conn = null;
	private String modules = "";	//模块名称
	private String tablemean = "";	//表意思
	
	ASFuntion CHF=new ASFuntion();
	
	private ArrayList keyList = new ArrayList();//主键List
	private ArrayList appList = new ArrayList();//审批List
	private ArrayList readList = new ArrayList();//只读List
	private ArrayList freeList = new ArrayList();//自由List
	private ArrayList autoList = new ArrayList();//自动List,表示自动更新，不进日志
	
	private ArrayList logList = new ArrayList();//日志List
	
	Map oriMap = new HashMap();	//原来的值
	Map keyMap = new HashMap();	//主键的值
	Map appMap = new HashMap();	//要审批的值
	Map freeMap = new HashMap();//自由的值
	Map autoMap = new HashMap();//自动的值
	
	private String person = ""; //变动人，可以与loginid不一致
	
	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public ApprovalService(Connection conn) {
		this.conn = conn;
	}
	
	//设置List
	public void setMeaning(String table) throws  Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = "select * from s_meaning where tableName = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, table);
			rs = ps.executeQuery();
			
			ResultSetMetaData RSMD = rs.getMetaData();
			while(rs.next()){
				Map map = new HashMap();
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					map.put(RSMD.getColumnName(i).toLowerCase() , rs.getString(RSMD.getColumnName(i)));
				}
				
				modules = rs.getString("ModulesName"); //模块名称
				tablemean = rs.getString("tableMean"); //表意思	
				
				if("1".equals(map.get("primarykey"))){	//主键
					keyList.add(map);
				}else if("1".equals(map.get("approval"))){	//要审批
					appList.add(map);
				}else if("1".equals(map.get("autocomplete"))){	//自动的
					autoList.add(map); 
				}else if("1".equals(map.get("readonly"))){	//只读的
					readList.add(map); 
				}else{	//自由
					freeList.add(map);	
				}
				
			}
			
		} catch (Exception e) {
			System.out.println("SysService 出错的SQL2：" + sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	//通过审批的保存 
	public void save(String table,String loginid,Map map) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			
			setMeaning( table);
			if(keyList == null || keyList.size() == 0){
				throw new Exception("含义表没有此表，请先设定含义表！");
			}
			
			/**
			 * 得到主键
			 */
			String key = "";
			for(int i = 0;i < keyList.size(); i++){
				Map temp = (Map)keyList.get(i);
				key += " and " + (String)temp.get("fieldname") + " = ? ";
			}
			
			/**
			 * 得到只读
			 */
			String read = "";	//`id``####``####``####`
			for(int i = 0;i < readList.size(); i++){
				Map temp = (Map)readList.get(i);
				read += "`" + ((String)temp.get("fieldname")).toLowerCase() + "`";
			}
			
			/**
			 * 求原来的值
			 */
			sql = "select * from " + table + " where 1=1 " + key;
			ps = conn.prepareStatement(sql);
			for(int i = 0;i < keyList.size(); i++){
				Map temp = (Map)keyList.get(i);
				ps.setString(i+1, (String)map.get(((String)temp.get("fieldname")).toLowerCase()));
			}
			rs = ps.executeQuery();
			
			ResultSetMetaData RSMD = rs.getMetaData();
			if(rs.next()){
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					//原来的值只求出(非只读的)
					if(read.indexOf("`" + RSMD.getColumnName(i).toLowerCase() + "`") == -1){
						oriMap.put(RSMD.getColumnName(i).toLowerCase() , rs.getString(RSMD.getColumnName(i)));	
					}
				}
			}
			DbUtil.close(rs);
			DbUtil.close(ps);
			
			/**
			 * 求出主键的值
			 */
			for(int i = 0;i < keyList.size(); i++){
				Map temp = (Map)keyList.get(i);
				String fieldname = ((String)temp.get("fieldname")).toLowerCase();
				keyMap.put(fieldname, map.get(fieldname));
			}
			
			/**
			 * 求出自动的值
			 */
			for(int i = 0;i < autoList.size(); i++){
				Map temp = (Map)autoList.get(i);
				String fieldname = ((String)temp.get("fieldname")).toLowerCase();
				autoMap.put(fieldname, map.get(fieldname));
			}
			
			/**
			 * 求出要审批的值
			 */
			for(int i = 0;i < appList.size(); i++){
				Map temp = (Map)appList.get(i);
				String fieldname = ((String)temp.get("fieldname")).toLowerCase();
				String ori = CHF.showNull((String)oriMap.get(fieldname));	//原来的
				String app = CHF.showNull((String)map.get(fieldname));	//现在的
				if(!ori.equals(app)){
					appMap.put(fieldname, app);	
				}
			}
			
			/**
			 * 求出自由的值
			 */
			for(int i = 0;i < freeList.size(); i++){
				Map temp = (Map)freeList.get(i);
				String fieldname = ((String)temp.get("fieldname")).toLowerCase();
				String ori = CHF.showNull((String)oriMap.get(fieldname));	//原来的
				String free = CHF.showNull((String)map.get(fieldname));	//现在的
				if(!ori.equals(free)){
					freeMap.put(fieldname, free);	
				}
			}
			
			setApproval( table, loginid);//审批
			saveAuto( table, loginid);//自动
			saveFree( table, loginid);//自由
//			log( loginid);//日志
			
		} catch (Exception e) {
			System.out.println("SysService 出错的SQL1：" + sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	//保存要审批的值
	public void setApproval(String table,String loginid) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			if(appMap == null || appMap.size() == 0){
				return ;	//没有要审批的值
			}

			String changetime = CHF.getDateAndTime();
			
			Map infoMap = new HashMap(); //用于插入k_personInfoChange表的
			infoMap.put("tablename", table);	//表名
			infoMap.put("loginid", loginid);	//变动loginid
			infoMap.put("person", person);	//变动人
			infoMap.put("changetime", changetime);	//变动时间
			
			sql = "INSERT INTO s_approval" +
			"(the,thetime,operatingTable,primarykey,keyValue, operatingField,originally,Nowvalue,infoID) " +
			"values (?,?,?,?,?, ?,?,?,?) ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginid);
			ps.setString(2, changetime);
			ps.setString(3, table);
			
			/**
			 * 主键
			 */
			String pkey = "",pvalue = "";
			Set coll = keyMap.keySet();
			for (Iterator iter = coll.iterator(); iter.hasNext(); ) {
				String key = (String) iter.next();
				String value = (String) keyMap.get(key);
				
				pkey += "," + key;
				pvalue += "," + value;
			}
			ps.setString(4, "".equals(pkey) ? "" : pkey.substring(1));
			ps.setString(5, "".equals(pvalue) ? "" : pvalue.substring(1));
			
			/**
			 * 审批的值
			 */
			coll = appMap.keySet();
			for (Iterator iter = coll.iterator(); iter.hasNext(); ) {
				String key = (String) iter.next();
				String value = (String) appMap.get(key);
				ps.setString(6, key);
				ps.setString(7, (String)oriMap.get(key));	//原来的值
				ps.setString(8, value);	//现在的值
				
				/**
				 * k_personInfoChange 修改Map
				 */
				String keymean = "";
				for(int i = 0;i < appList.size(); i++){
					Map temp = (Map)appList.get(i);
					String fieldname = ((String)temp.get("fieldname")).toLowerCase();
					String fieldmean = ((String)temp.get("fieldmean")).toLowerCase();
					if(key.equals(fieldname)){
						keymean = fieldmean;
						break;
					}
				}
				infoMap.put("changereason", "要审批后才能生效");	//变动结果
				infoMap.put("changefield", keymean);	//变动字段
				infoMap.put("beforevalue", (String)oriMap.get(key));	//原来值
				infoMap.put("nowvalue", value);	//变动后值
				String infoID = log(infoMap);
				
				ps.setString(9, infoID);	//现在的值
				ps.addBatch();
//				/**
//				 * 生成日志:
//				 * 修改【###】字段，原来的值是【###】，要修改为【####】，此修改需要审批后才能生效；
//				 */
//				for(int i = 0;i < appList.size(); i++){
//					Map temp = (Map)appList.get(i);
//					String fieldname = ((String)temp.get("fieldname")).toLowerCase();
//					String fieldmean = ((String)temp.get("fieldmean")).toLowerCase();
//					if(key.equals(fieldname)){
//						String log = "修改【"+fieldmean+"】字段，原来的值是【"+(String)oriMap.get(key)+"】，要修改为【"+value+"】，此修改需要审批后才能生效；";
//						logList.add(log);
//						break;
//					}
//				}

			}
			ps.executeBatch();

			
		} catch (Exception e) {
			System.out.println("SysService 出错的SQL3：" + sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	//保存自由的值
	public void saveFree(String table,String loginid) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			if(freeMap == null || freeMap.size() == 0){
				return ;	//没有自由的值
			}
			
			String changetime = CHF.getDateAndTime();
			
			Map infoMap = new HashMap(); //用于插入k_personInfoChange表的
			infoMap.put("tablename", table);	//表名
			infoMap.put("loginid", loginid);	//变动loginid
			infoMap.put("person", person);	//变动人
			infoMap.put("changetime", changetime);	//变动时间
			
			/**
			 * 要修改的字段
			 */
			String field = "",pkey = "";
			Set coll = freeMap.keySet();
			for (Iterator iter = coll.iterator(); iter.hasNext(); ) {
				String key = (String) iter.next();
				String value = (String) freeMap.get(key);
				if(key.equalsIgnoreCase("state")){			// 暂时没有禁用用户状态
					value="0";
				}
				field += "," + key + " = ? ";
				
				/**
				 * k_personInfoChange 修改Map
				 */
				String keymean = "";
				for(int i = 0;i < freeList.size(); i++){
					Map temp = (Map)freeList.get(i);
					String fieldname = ((String)temp.get("fieldname")).toLowerCase();
					String fieldmean = ((String)temp.get("fieldmean")).toLowerCase();
					if(key.equals(fieldname)){
						keymean = fieldmean;
						break;
					}
				}
				infoMap.put("changereason", "修改成功");	//变动结果
				infoMap.put("changefield", keymean);	//变动字段
				infoMap.put("beforevalue", (String)oriMap.get(key));	//原来值
				infoMap.put("nowvalue", value);	//变动后值
				log(infoMap);
				
//				/**
//				 * 生成日志:
//				 * 修改【###】字段，原来的值是【###】，要修改为【####】，此修改成功；
//				 */
//				for(int i = 0;i < freeList.size(); i++){
//					Map temp = (Map)freeList.get(i);
//					String fieldname = ((String)temp.get("fieldname")).toLowerCase();
//					String fieldmean = ((String)temp.get("fieldmean")).toLowerCase();
//					if(key.equals(fieldname)){
//						String log = "修改【"+fieldmean+"】字段，原来的值是【"+(String)oriMap.get(key)+"】，要修改为【"+value+"】，此修改成功；";
//						logList.add(log);
//						break;
//					}
//				}
				
			}
			field = field.substring(1);
			
			/**
			 * 主键
			 */
			coll = keyMap.keySet();
			for (Iterator iter = coll.iterator(); iter.hasNext(); ) {
				String key = (String) iter.next();
				String value = (String) keyMap.get(key);
				if(key.equalsIgnoreCase("state")){     		// 暂时没有禁用用户状态
					value="0";
				}
				pkey += " and " + key + " = ? ";
			}
			
			/**
			 * SQL
			 */
			int ii = 1;
			sql = "update " + table + " set " + field + " where 1=1 " + pkey; 
			ps = conn.prepareStatement(sql);
			
			coll = freeMap.keySet();
			for (Iterator iter = coll.iterator(); iter.hasNext(); ) {
				String key = (String) iter.next();
				String value = (String) freeMap.get(key);
				
				if(key.equalsIgnoreCase("state")){    		// 暂时没有禁用用户状态
					value="0";
				}
				
				ps.setString(ii++, value);
			}
			coll = keyMap.keySet();
			for (Iterator iter = coll.iterator(); iter.hasNext(); ) {
				String key = (String) iter.next();
				String value = (String) keyMap.get(key);
				
				if(key.equalsIgnoreCase("state")){   	 	// 暂时没有禁用用户状态
					value="0";
				}
				
				
				ps.setString(ii++, value);
			}
			ps.execute();
			
		} catch (Exception e) {
			System.out.println("SysService 出错的SQL4：" + sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	//保存自动的值
	public void saveAuto(String table,String loginid) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			if(autoMap == null || autoMap.size() == 0){
				return ;	//没有自由的值
			}
			
			/**
			 * 要修改的字段
			 */
			String field = "",pkey = "";
			Set coll = autoMap.keySet();
			for (Iterator iter = coll.iterator(); iter.hasNext(); ) {
				String key = (String) iter.next();
				String value = (String) autoMap.get(key);

				field += "," + key + " = ? ";
				
			}
			field = field.substring(1);
			
			/**
			 * 主键
			 */
			coll = keyMap.keySet();
			for (Iterator iter = coll.iterator(); iter.hasNext(); ) {
				String key = (String) iter.next();
				String value = (String) keyMap.get(key);
				pkey += " and " + key + " = ? ";
			}
			
			/**
			 * SQL
			 */
			int ii = 1;
			sql = "update " + table + " set " + field + " where 1=1 " + pkey; 
			ps = conn.prepareStatement(sql);
			
			coll = autoMap.keySet();
			for (Iterator iter = coll.iterator(); iter.hasNext(); ) {
				String key = (String) iter.next();
				String value = (String) autoMap.get(key);
				if(key.equalsIgnoreCase("state")){   	 	// 暂时没有禁用用户状态
					value="0";
				}
				ps.setString(ii++, value);
			}
			coll = keyMap.keySet();
			for (Iterator iter = coll.iterator(); iter.hasNext(); ) {
				String key = (String) iter.next();
				String value = (String) keyMap.get(key);
				if(key.equalsIgnoreCase("state")){   	 	// 暂时没有禁用用户状态
					value="0";
				}
				ps.setString(ii++, value);
			}
			ps.execute();
			
		} catch (Exception e) {
			System.out.println("SysService 出错的SQL41：" + sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	//保存日志
	public void log(String loginid) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			sql = "INSERT INTO t_log(the,thetime,ModulesName,logContent) values (?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginid);
			ps.setString(2, CHF.getDateAndTime());
			ps.setString(3, modules);
			String log = "表：" + tablemean ;
			for(int i = 0;i < logList.size(); i++){
				log += "<br>" + logList.get(i);
			}
			ps.setString(4, log);
			ps.execute();
			
		} catch (Exception e) {
			System.out.println("SysService 出错的SQL5：" + sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	//插入k_personInfoChange【人员变动表】
	public String log(Map map) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			String tabname = "k_personInfoChange";
			sql = "select * from "+tabname+" where 1=2 " ; 
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();
			String sql1 = "", sql2 = "";
			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
				//if(!"id".equals(RSMD.getColumnName(i).toLowerCase())){
					String string =(String)map.get(RSMD.getColumnName(i).toLowerCase()) ;
					if(string == null && !"id".equals(RSMD.getColumnName(i))) {
						continue;
					}
					sql1 += ","+RSMD.getColumnName(i).toLowerCase()+" ";
	 				sql2 += ",? ";
				//}
			}
			
			sql = "insert into  " + tabname + " (" + sql1.substring(1) + ") values (" + sql2.substring(1) + ") ";
			ps = conn.prepareStatement(sql);
			int ii = 1;
			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
				
					String value = "";
					
					if(!"id".equals(RSMD.getColumnName(i).toLowerCase())){
						value = (String)map.get(RSMD.getColumnName(i).toLowerCase()) ;
					} else {
						value = UUID.randomUUID().toString();
					}
					if(value == null) {
						continue;
					}
					
					ps.setString(ii++, value);
				
			}
			ps.execute();
			DbUtil.close(rs);
			DbUtil.close(ps);
			
// 		    无条件 取消 update  person 的操作,生成记录的时候 person是怎样就怎样
//			if("".equals(person)){
//				/**
//				 * 修改[变动人]
//				 */
//				sql = "update a  set a.person = b.loginname from k_personInfoChange a,k_user b where a.loginid = b.loginid";
//				ps = conn.prepareStatement(sql);
//				ps.execute();
//				DbUtil.close(ps);
//			}
			
			String info = "";
			sql = "select top 1 * from " + tabname + " where 1=1 order by id desc ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				info = rs.getString("id");
			}
			
			return info;
		} catch (Exception e) {
			System.out.println("SysService 出错的SQL6：" + sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	//通过审批，修改表，增加日志
	public void saveApproval(String id,String loginid) throws Exception{
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		String sql = "";
		try {
			
			/**
			 * 修改通过审批的表的内容
			 */
			sql = "select * from s_approval where id in (" + id + ") ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
//			ResultSetMetaData RSMD = rs.getMetaData();
			while(rs.next()){
				String operatingTable = rs.getString("operatingTable");// 操作表		
				String operatingField = rs.getString("operatingField");// 操作字段名	
				String Nowvalue	= rs.getString("Nowvalue");// 现在的值	
				String primarykey = rs.getString("primarykey");// 要操作表主键(多主键时，以","分隔)	
				String keyValue	= rs.getString("keyValue");// 主键的值(多主键时，以","分隔)	
				
				String [] pkey = primarykey.split(",");
				String [] kvalue = keyValue.split(",");
				
				sql = "update " + operatingTable + " set " + operatingField + " = ? where 1=1 ";
				for(int i = 0 ;i<pkey.length; i++){
					if(pkey[i] == null || "".equals(pkey[i])) continue;
					sql += " and " + pkey[i] + " = ? ";
				}
				int ii = 1;
				ps1 = conn.prepareStatement(sql);
				ps1.setString(ii++, Nowvalue);
				for(int i = 0 ;i<kvalue.length; i++){
					if(kvalue[i] == null || "".equals(kvalue[i])) continue;
					ps1.setString(ii++,kvalue[i]);
				}
				ps1.execute();
				DbUtil.close(ps1);
			}
			DbUtil.close(rs);
			DbUtil.close(ps);

			/**
			 * 修改审批表
			 */
			String changetime = CHF.getDateAndTime();
			sql = "update s_approval set ShenPiRen = ?,approvalTime = ?,ShenPiResult = ? where id in ("+id+") ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginid);	//审批人	
			ps.setString(2, changetime);	//审批时间	
			ps.setString(3, "审批通过，修改成功");	//审批结果
			ps.execute();
			DbUtil.close(ps);
			
			updateInfo( id);//修改 k_personInfoChange 的审批
			
		} catch (Exception e) {
			System.out.println("SysService 出错的SQL7：" + sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	//审批不通过，修改审批表和变动日志
	public void delApproval(String id,String loginid) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			
			/**
			 * 修改审批表
			 */
			String changetime = CHF.getDateAndTime();
			sql = "update s_approval set ShenPiRen = ?,approvalTime = ?,ShenPiResult = ? where id in ("+id+") ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginid);	//审批人	
			ps.setString(2, changetime);	//审批时间	
			ps.setString(3, "审批不通过，不能修改");	//审批结果
			ps.execute();
			DbUtil.close(ps);
			
			updateInfo( id);//修改 k_personInfoChange 的审批
			
		} catch (Exception e) {
			System.out.println("SysService 出错的SQL7：" + sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	//修改 k_personInfoChange 的审批
	public void updateInfo(String id) throws Exception{
		PreparedStatement ps = null;
		String sql = "";
		try {
			/**
			 * 修改 k_personInfoChange 的记录
			 */
			sql = "update b set " +
			"	b.approveLoginid = a.ShenPiRen," +
			"	b.approveTime = a.approvalTime," +
			"	b.changeReason = a.ShenPiResult " +
			"	from s_approval a,k_personInfoChange b " +
			"	where a.infoid = b.id " +
			"	and a.id in ("+id+")";
			ps = conn.prepareStatement(sql);
			ps.execute();
			DbUtil.close(ps);
			
			sql = "update a  set a.approvePerson = b.loginname from k_personInfoChange a,k_user b where a.approveLoginid = b.loginid";
			ps = conn.prepareStatement(sql);
			ps.execute();
			
		} catch (Exception e) {
			System.out.println("SysService 出错的SQL7：" + sql);
			e.printStackTrace();
		} finally {
			DbUtil.close(ps);
		}
	}
}
