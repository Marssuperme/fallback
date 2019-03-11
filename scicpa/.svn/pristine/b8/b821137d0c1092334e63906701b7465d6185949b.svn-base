package cn.org.gdicpa.web.service.training.bak;

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
import cn.org.gdicpa.web.service.pay.Order;
import cn.org.gdicpa.web.service.pay.OrderService;

public class TrainingService {
	
	private Connection conn = null;
	
	public TrainingService(Connection conn) {
		this.conn = conn;
	}
	  
	/**
	 * 得到对象
	 * @param table
	 * @param nid
	 * @param loginid
	 * @return
	 * @throws Exception
	 */
	public Map get(String table,String nid,String loginid,String ctypetabname)throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			Map map = new HashMap();
			ASFuntion CHF=new ASFuntion();
			
			sql = "select * from " + table + " where id = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, nid);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();
			if(rs.next()){
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					map.put(RSMD.getColumnName(i).toLowerCase() , rs.getString(RSMD.getColumnName(i)));
				}
			}
			DbUtil.close(rs);
			DbUtil.close(ps);
			
			sql = "select trainingID,count(trainingID) as tcount from b_enroll where trainingID = ? and source = ? group by trainingID ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, nid);
			ps.setString(2, table);
			rs = ps.executeQuery();
			if(rs.next()){
				map.put("tcount" , rs.getString("tcount"));
			}else{
				map.put("tcount" , "0");
			}
			DbUtil.close(rs);
			DbUtil.close(ps);
			
			sql = "select a.*,b.orderState from b_enroll a left join k_order b on a.orderid = b.orderid where a.trainingID = ? and a.source = ? and a.tid = ?  ";
			if("k_company".equalsIgnoreCase(ctypetabname)){
				sql = "select a.*,b.orderState from b_enroll a left join k_order b on a.orderid = b.orderid where a.trainingID = ? and a.source = ? and  a.loginid = ?  ";
			}
			ps = conn.prepareStatement(sql);
			ps.setString(1, nid);
			ps.setString(2, table);
			ps.setString(3, loginid);
			rs = ps.executeQuery();
			RSMD = rs.getMetaData();
			String orderState = "1";
			while(rs.next()){
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					if(!"id".equalsIgnoreCase(RSMD.getColumnName(i).toLowerCase())){
						if(!"tid".equalsIgnoreCase(RSMD.getColumnName(i).toLowerCase())
							&&	!"tname".equalsIgnoreCase(RSMD.getColumnName(i).toLowerCase())
						){
							map.put(RSMD.getColumnName(i).toLowerCase() , rs.getString(RSMD.getColumnName(i)));
						}else{
							String string1 = CHF.showNull((String)map.get(RSMD.getColumnName(i).toLowerCase()));
							String string = ("".equals(string1) ? "" : (string1 + ",")) + rs.getString(RSMD.getColumnName(i));
							map.put(RSMD.getColumnName(i).toLowerCase() , string);
						}
					}else{
						map.put("eid" , rs.getString("id"));
					}
					// 团体报名 中 只要有一个人没有交费 就不显示 已缴费
					if(!"orderState".equalsIgnoreCase(RSMD.getColumnName(i).toLowerCase())){
						if("0".equals(rs.getString("orderstate")) || "".equals(rs.getString("orderstate")) || null == rs.getString("orderstate")){
							orderState = "0";
						}
					}
				}
			}
			if("k_company".equalsIgnoreCase(ctypetabname)){	
				map.put("orderstate", orderState);
			}
			System.out.println("map=|"+map+"     /n  sql="+sql);
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
	
	//保存
	public String save(String table,Map parameters) throws Exception{
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
//		PreparedStatement ps2 = null;
		ResultSet rs = null;
		String sql = "";
		try {
			
			String lessonname = (String)parameters.get("lessonname");
			String trainingname = (String)parameters.get("trainingname");
			String expense = (String)parameters.get("expense");
			String orderId = (String)parameters.get("orderid");
			String loginid = (String)parameters.get("loginid");
			String loginuser = (String)parameters.get("loginuser");
			String ctypetabname = (String)parameters.get("ctypetabname");
			double expense1 = 0.00; 
			
			String tnames = (String)parameters.get("tname");
			String tid = (String)parameters.get("tid");
			// 事务所用户报名 是 手动添加的 非职业会员
			String companyToMicfoNo = (String)parameters.get("companyToMicfoNo");
			
			//  处理是否住宿和中转  如果是团体会员才进行下面操作
			String[] syzss = {};
			String[] syzzs = {};
			String[] syzzs2 = {};
			String[] phones = {};
			// 所属级别
			String leval = (String)parameters.get("leval2");
			
			String[] companyToMicfoNos = companyToMicfoNo.split(",");
			String[] levals = leval.split(",");
			String [] ts = tnames.split(",");
			// 系统注师的 loginid
			String loginid22 = (String)parameters.get("loginid22");           
			// 如果用户的 电话号码和 职务 为空就写回 联动到 用户信息那边
			String [] loginid22s = {};
			if(loginid22!=null && !"".equals(loginid22)){
				loginid22s = loginid22.split(",");
			}
			// System.out.println("".split(","));
			// System.out.println("".split(",").length);        结果 为 1  奇怪
			
			String phone = (String)parameters.get("phones"); //  记录电话号码
			if(phone!=null && !"".equals(phone)){
				phones = phone.split(",");
			}
			for(int j=0;j<loginid22s.length;j++){
				// 找出对应的用户类型
				sql = "select ctypetabname from k_user where loginid = '"+loginid22s[j]+"'";
				String tabname = new DbUtil(conn).queryForString(sql);
				if(!"".equals(tabname) && null != tabname){
					// 找出报名参加人的电话
					sql = "select mobile from "+tabname+" where loginid = '"+loginid22s[j]+"'";
					String mobile = new DbUtil(conn).queryForString(sql);
					// 写回 联动到 用户信息那边
					if(mobile==null || "".equals(mobile)){
						sql = "update "+tabname+" set mobile = '"+phones[j]+"' where loginid = '"+loginid22s[j]+"'";
						new DbUtil(conn).executeUpdate(sql);
					}
					// 找出报名参加人的职务
					sql = "select post from "+tabname+" where loginid = '"+loginid22s[j]+"'";
					String post = new DbUtil(conn).queryForString(sql);
					// 写回 联动到 用户信息那边
					if(post==null || "".equals(post)){
						sql = "update "+tabname+" set post = '"+levals[j]+"' where loginid = '"+loginid22s[j]+"'";
						new DbUtil(conn).executeUpdate(sql);
					}
					System.out.println("tabname="+tabname+"    loginid22s[j]="+loginid22s[j]+"      mobile="+mobile+"   post="+post);
				}
			}
			
			
//			if(tid == null || "".equals(tid)){//表示是团体用户
			if("k_company".equalsIgnoreCase(ctypetabname)){//表示是团体用户
				String syzs = (String)parameters.get("syzs");  //手动是否住宿 
				String syzz = (String)parameters.get("syzz"); //手动是否中转   为空就不处理  
				
				String syzz2 = (String)parameters.get("syzz2"); //手动是否中转   为空就不处理  
				
				if(syzs!=null && !"".equals(syzs)){
					syzss = syzs.split(",");
				}
				if(syzz!=null && !"".equals(syzz)){
					 syzzs = syzz.split(",");
				}
				if(syzz2!=null && !"".equals(syzz2)){
					 syzzs2 = syzz2.split(",");
				}
				
			}
 
			sql = "insert into  b_enroll " +
					"(id,trainingID,source,loginid,edate,tid,tname,memo,orderId,lessonid,isdormitory,istransit,phone,usertype,leval,enrolltype,seatno,istransit1) " +
					"values (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?) ";
			ps = conn.prepareStatement(sql);
			
//			sql = " insert into XS_Content(PSB_Guid,PSB_MC,APPID,APPNAME) " 
//				+ " values(?,?,?,?)";
//			ps2 = conn.prepareStatement(sql);
//			ps2.setString(1, (String)parameters.get("trainingid"));
//			ps2.setString(2, (String)parameters.get("lessonid"));
			
			
			ps.setString(2, (String)parameters.get("trainingid"));
			ps.setString(3, table);
			// 如果是执业会员  loginid 就是对应的 事务所编号
			if("k_micfo".equalsIgnoreCase(ctypetabname)){
				sql = "select officecode from k_micfo where loginid = '"+loginuser+"'";
				String officecode = new DbUtil(conn).queryForString(sql);
				ps.setString(4, officecode);
			}else{	// 否则 就是 当前登录用户的 loginid
				ps.setString(4, loginid);
			}
			
			ps.setString(5, (String)parameters.get("edate"));
			
			ps.setString(8, (String)parameters.get("memo"));
			ps.setString(9, orderId);
			ps.setString(10, (String)parameters.get("lessonid"));

//TODO----------------------------------------------------------------------------			
			// 设置所在培训班里面的座位号
			String seatMaxNoSql = " select isnull(max(seatno),0) as seatno from b_enroll where trainingid = ? ";
			int seatMaxNo = new DbUtil(conn).queryForInt(seatMaxNoSql,new Object[]{parameters.get("trainingid")}) + 1;
			
//TODO----------------------------------------------------------------------------			
			for (int i = 0; i < ts.length; i++) {
				if("k_company".equalsIgnoreCase(ctypetabname)){//表示是团体用户
					if(ts[i] == null || "".equals(ts[i].trim())) continue;
					
					//1、判断是否已有，有就不增加
					sql = "select * from b_enroll where trainingID = ? and source = ? and loginid = ? and tname = ? ";
					ps1 = conn.prepareStatement(sql);
					ps1.setString(1, (String)parameters.get("trainingid"));
					ps1.setString(2, table);
					ps1.setString(3, loginid);
					ps1.setString(4, ts[i]);
					rs = ps1.executeQuery();
					if(rs.next()){
						continue;
					}
					DbUtil.close(rs);
					DbUtil.close(ps1);
					
					// loginid22 系统用户
					if(i+1<=loginid22s.length){
						ps.setString(6, loginid22s[i]);
					}else{
						String micfonoid = new DbUtil(conn).queryForString("select top 1 loginid from k_user where loginname = ?", new Object[]{ts[i]});
						if(null == micfonoid || "".equals(micfonoid)){
							micfonoid = "sd001";
						}
						ps.setString(6, micfonoid);	// 手动录入的 报名人员
					}
					
					// 这样子 有问题  如果一个事务所有两个同名的注师 就可能会有问题
					
					// 当 OA 没有设置 每人每次培训费用的时候
					if("".equals(expense) || expense == null){
						expense = "0.00";
					}
					expense1 += Double.parseDouble(expense); 
					ps.setString(11, syzss[i]);
					ps.setString(12, syzzs[i]);
					ps.setString(13, phones[i]);

					
				}else{
					// 当 OA 没有设置 每人每次培训费用的时候                加多       执业会员设置每次培训费用
					if("".equals(expense) || expense == null){
						expense = "0.00";
					}
					expense1 += Double.parseDouble(expense); 
					
//					ps2.setString(3, (String)parameters.get("tid"));
					ps.setString(6, loginuser);	
					ps.setString(11, (String)parameters.get("isdormitory"));	
					ps.setString(12, (String)parameters.get("istransit"));	
					ps.setString(13, (String)parameters.get("phone"));
					
				}
				ps.setString(1, UUID.randomUUID().toString());
				ps.setString(7, ts[i]);
//				ps2.setString(4, ts[i]);
				System.out.println("ctypetabname="+ctypetabname);
				if("k_company".equalsIgnoreCase(ctypetabname)){
					boolean bl = false;
					for(int j=0;j<companyToMicfoNos.length;j++){
						if(ts[i].equals(companyToMicfoNos[j])){		// 一定是手动添加的非执业会员
							bl = true;
							break;
						} 
					}
					System.out.println("bl="+bl);
					if(bl){
						ps.setString(14, "companyToMicfoNo");
					}else{
						ps.setString(14, "companyToMicfo");
					}
					ps.setString(15, levals[i]);
				}else{
					ps.setString(14, "micfo");
					ps.setString(15, (String)parameters.get("leval"));
					
				}
				if("k_company".equalsIgnoreCase((String)parameters.get("ctypetabname"))){
					ps.setString(16,"团体代报名");
				}else{
					ps.setString(16,"个人已报名");
				}
				
				ps.setInt(17, seatMaxNo++);
				
				ps.setString(18, syzzs2[i]);
				
//				ps2.addBatch();
				ps.addBatch();
			}
//			ps2.executeBatch();
			ps.executeBatch();
			
			
			//增加订单
			OrderService orderService = new OrderService(conn);
			Order order = new Order();
			order.setOrderAmount(expense1);
			order.setOrderContent(trainingname + "-报名费");
			order.setOrderId(orderId);
			order.setUserId(loginid);
			orderService.save(order);
			
			return "";
			
		} catch (Exception e) {
			System.out.println("saveInfo ERROR :" +sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
			DbUtil.close(ps1);
		}
	}
	
	//删除报名
	public String del(String loginid,String trainingid,String table) throws Exception{
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		String sql = "";
		try {
			int ii = 1;
			sql = "delete from b_enroll where id = ? ";
			ps1 = conn.prepareStatement(sql);
			// 该培训班、该事务所、培训班表名(b_training) 、未交费的 报名 orderState = 0     
			sql = "select a.* from b_enroll a inner join k_order b on a.orderid = b.orderid and orderState = 0 where loginid = ? and trainingid = ? and source = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(ii++, loginid);
			ps.setString(ii++, trainingid);
			ps.setString(ii++, table);
			rs = ps.executeQuery();
			while(rs.next()){
				ps1.setString(1, rs.getString("id"));
				ps1.addBatch();
				//return "用户已缴费，不能改变！";
			}
			ps1.executeBatch();
			
			return "";
		} catch (Exception e) {
			System.out.println("saveInfo ERROR :" +sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(ps);
		}
	}
	
	//expense 缴费
	public void expense(String eid,String loginid,String memo )throws Exception{
		PreparedStatement ps = null;
		String sql = "";
		try {
			sql = "update b_enroll  set isexpense = 1 ,memo = ? " +
			"	where trainingid = ? " +
			"	and ( loginid = ? or tid = ? ) " ;
			ps = conn.prepareStatement(sql);
			int ii = 1;
			ps.setString(ii++, memo);
			ps.setString(ii++, eid);
			ps.setString(ii++, loginid);
			ps.setString(ii++, loginid);
			ps.execute();
			
		} catch (Exception e) {
			System.out.println(" ERROR :" +sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(ps);
		}
	}
	
	//删除报名
	public String del(String eid,String loginid,String ctypetabname,String p)throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		boolean flag  = false;
		String tname = "";
		String enrollId = "";
		String[] enrollIds = {};
		try {
			OrderService orderService = new OrderService(conn);
			
			if("k_company".equalsIgnoreCase(ctypetabname)){
				sql = " select a.* ,b.orderState from b_enroll a left join k_order b on a.orderid = b.orderid  where trainingID = ? and loginid = ?  ";
			}else{
				sql = " select a.* ,b.orderState from b_enroll a left join k_order b on a.orderid = b.orderid  where trainingID = ? and tid = ?  ";
			}
			ps = conn.prepareStatement(sql);
			int ii = 1;
			ps.setString(ii++, eid);
			ps.setString(ii++, loginid);
			rs = ps.executeQuery();
			while(rs.next()){
				String orderState = rs.getString("orderState");
				String orderid = rs.getString("orderid");
				if("1".equals(orderState)){
					flag = true;
					tname = tname + rs.getString("tname")+",";
					continue;
				}
				enrollId = enrollId+rs.getString("id")+",";
				orderService.remove(orderid);	//删除订单
			}
			
			enrollId = enrollId.substring(0, enrollId.length()-1);
			sql = "delete from b_enroll where id = ? ";
			if(enrollId.indexOf(",")>-1){
				enrollIds = enrollId.split(",");
				for (int i = 0; i < enrollIds.length; i++) {
					ps = conn.prepareStatement(sql);
					ps.setString(1, enrollIds[i]);
					ps.execute();
				}
			}else{
				ps = conn.prepareStatement(sql);
				ps.setString(1, enrollId);
				ps.execute();
			}
			
			if(flag){
				return "参与人"+tname.substring(0, tname.length()-1)+"已经缴费，不能取消,其他参与人已取消报名成功！";
			}else{
				return "取消报名成功！";
			}
		} catch (Exception e) {
			System.out.println(" ERROR :" +sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
	}
	
	//得到人数和合计
	public Map get(String sql) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Map map = new HashMap();
			
			sql = "select count(*) as countall,sum(convert(decimal(18,2), expense)) as expenseall from ( " +
				sql + 
				") a";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				map.put("countall", rs.getString("countall"));
				map.put("expenseall", rs.getString("expenseall"));
			}else{
				map.put("countall", "0");
				map.put("expenseall", "0.00");
			}
			
			return map;
		} catch (Exception e) {
			System.out.println(" ERROR :" +sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}

	public List getList(String sql) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			List list = new ArrayList();
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();
			while(rs.next()){
				Map map = new HashMap();
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					map.put(RSMD.getColumnName(i).toLowerCase() , rs.getString(RSMD.getColumnName(i)));
				}
				list.add(map);
			}
			
			return list;
		} catch (Exception e) {
			System.out.println(" ERROR :" +sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	public String isLesson(String lessonid,String loginid)throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			ASFuntion CHF=new ASFuntion();
			String result = "",ispass = "";
			int opt = 0;
			/**
			 * 1、您已经参加本次培训课程第一次培训，无需再报。
			 * 2、您已经参加本次培训课程第一次培训报名，但没有参加培训；按照相关规定，您还要重新参加培训，并补缴二次报名费用。
			 */
			sql = "select a.lessonid,a.lessonname,b.* " +
			 "	from b_training a,dbo.b_enroll b " +
			 "	where 1=1 " +
			 "	and a.lessonid = ? " +
			 "	and (b.loginid = ? or b.tid = ?) " +
			 "	and a.id = b.trainingid ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, lessonid);
			ps.setString(2, loginid);
			ps.setString(3, loginid);
			rs = ps.executeQuery();
			while(rs.next()){
				opt++;
				ispass = CHF.showNull(rs.getString("ispass")); 
				if("1".equals(ispass)){
					break;
				}
			}
			DbUtil.close(rs);
			DbUtil.close(ps);
			
			if("1".equals(ispass)){
//				result = "您已经通过本次培训课程的培训，无需再报。";
				result = "1";
			}else if(opt != 0 && ("".equals(ispass) || "0".equals(ispass))){
//				result = "您已经参加本次培训课程的报名，但没有通过本次培训；\\n按照相关规定，您还要重新参加培训，并补缴二次报名费用。";
				result = "2";
			}
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	/**
	 * 得到培训对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Map getIsTransit(String id) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from b_training where id = ?";
		Map map = new HashMap();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();
			if(rs.next()){
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					System.out.println(RSMD.getColumnName(i).toLowerCase() +"="+rs.getString(RSMD.getColumnName(i)));
					map.put(RSMD.getColumnName(i).toLowerCase() , rs.getString(RSMD.getColumnName(i)));
				}
			}
			
			return map;
		} catch (Exception e) {
			System.out.println(" ERROR :" +sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	/**
	 * 获取注师 用户信息 和 注师培训报名信息 ： 电话和职称 特殊处理 
	 * @param sql
	 * @param loginid
	 * @return
	 * @throws Exception
	 */
	public List getLists(String sql,String loginid) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			List list = new ArrayList();
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData RSMD = rs.getMetaData();
			while(rs.next()){
				Map map = new HashMap();
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					if("phone".equals(RSMD.getColumnName(i).toLowerCase()) && (rs.getString("phone")==null || "".equals(rs.getString("phone")))){
						// 该事务所下的该注师只要在任何培训班报过名  填写过 电话号码 就取最后一次报名的 填写的电话号码,并且不是本培训班的(如果该执业会员已参加该培训班，就显示对应填写的电话号码和职称)，
						String phone = new DbUtil(conn).queryForString("select top 1 phone from b_enroll where loginid = ? and tid = ? order by edate desc", new Object[]{loginid,rs.getString("loginid")});
						System.out.println(this.getClass()+"      phone="+phone+"     loginid="+loginid+"     tid="+rs.getString("loginid"));
						if(!"".equals(phone) && phone!= null ){
							map.put(RSMD.getColumnName(i).toLowerCase() , phone);
						}else{
							map.put(RSMD.getColumnName(i).toLowerCase() , rs.getString("mobile"));
						}
					}else if("leval".equals(RSMD.getColumnName(i).toLowerCase()) && (rs.getString("leval")==null || "".equals(rs.getString("leval")))){
						// 该事务所下的该注师只要在任何培训班报过名  填写过 职称  就取最后一次报名的 填写的职称 
						String leval = new DbUtil(conn).queryForString("select top 1 leval from b_enroll where loginid = ? and tid = ? order by edate desc", new Object[]{loginid,rs.getString("loginid")});
						System.out.println(this.getClass()+"      leval="+leval+"     loginid="+loginid+"     tid="+rs.getString("loginid"));
						if(!"".equals(leval) && leval!= null ){
							map.put(RSMD.getColumnName(i).toLowerCase() , leval);
						}else{
							map.put(RSMD.getColumnName(i).toLowerCase() , rs.getString("post"));
						}
					}else{
						map.put(RSMD.getColumnName(i).toLowerCase() , rs.getString(RSMD.getColumnName(i)));
					}
				}
				list.add(map);
			}
			
			return list;
		} catch (Exception e) {
			System.out.println(" ERROR :" +sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	
	//个人报名
	public synchronized String savePerson(String table,Map parameters) throws Exception{
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		String sql = "";
		try{
			
//			"(id,trainingID,source,loginid,edate,tid,tname,memo,orderId,lessonid,isdormitory,istransit,phone,usertype,leval,enrolltype) "  
			
			String id = UUID.randomUUID().toString();
			String trainingId = (String)parameters.get("trainingid");
			String source = "b_training";
			String loginid = (String)parameters.get("officecode");
			String edate = (String)parameters.get("edate");
			String tid = (String)parameters.get("loginuser");
			String tname = (String)parameters.get("loginname");
			String memo = (String)parameters.get("memo");
			String orderid = (String)parameters.get("orderid");
			String lessonid = (String)parameters.get("lessonid");
			
			// 是否住宿
			String isdormitory = (String)parameters.get("isdormitory");
			// 是否中转
			String istransit = (String)parameters.get("istransit");
			// 联系电话
			String phone = (String)parameters.get("phone");
			// 报名类型
			String usertype = (String)parameters.get("usertype");
			// 级别
			String leval = (String)parameters.get("leval");
			// 报名中文名称的类型
			String enrolltype = (String)parameters.get("enrolltype");
			// 
			String ctypetabname = (String)parameters.get("ctypetabname");
			
			
			String trainingname = (String)parameters.get("trainingname");
			String expense = (String)parameters.get("expense");
			double expense1 = 0.00; 
			
			// 如果用户的 电话号码和 职务 为空就写回 联动到 用户信息那边
			// 找出对应的用户类型
			if(!"".equals(ctypetabname) && null != ctypetabname){
				// 找出报名参加人的电话
				sql = "select mobile from "+ctypetabname+" where loginid = '"+tid+"'";
				String mobile = new DbUtil(conn).queryForString(sql);
				// 写回 联动到 用户信息那边
				if(mobile==null || "".equals(mobile)){
					sql = "update "+ctypetabname+" set mobile = '"+phone+"' where loginid = '"+tid+"'";
					new DbUtil(conn).executeUpdate(sql);
				}
				// 找出报名参加人的职务
				sql = "select post from "+ctypetabname+" where loginid = '"+tid+"'";
				String post = new DbUtil(conn).queryForString(sql);
				// 写回 联动到 用户信息那边
				if(post==null || "".equals(post)){
					sql = "update "+ctypetabname+" set post = '"+leval+"' where loginid = '"+tid+"'";
					new DbUtil(conn).executeUpdate(sql);
				}
			}
			
			
			sql = "insert into  b_enroll " +
					"(id,trainingID,source,loginid,edate,tid,tname,memo,orderId,lessonid,isdormitory,istransit,phone,usertype,leval,enrolltype,seatno) " +
					"values (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?) ";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setString(2, trainingId);
			ps.setString(3, table);
			
			// 如果是执业会员  loginid 就是对应的 事务所编号
			if("k_micfo".equalsIgnoreCase(ctypetabname)){
				ps.setString(4, loginid);
				ps.setString(14, "micfo");
				ps.setString(16, "个人已报名");
			}else{	// 否则 就是 当前登录用户的 loginid
				ps.setString(4, tid);
				ps.setString(14, "micfono");
				ps.setString(16, "非执业个人已报名");
			}
			
			ps.setString(5, edate);
			ps.setString(6, tid);
			ps.setString(7, tname);
			ps.setString(8, memo);
			
			ps.setString(9, orderid);
			ps.setString(10, lessonid);
			ps.setString(11, isdormitory);
			ps.setString(12, istransit);
			ps.setString(13, phone);
			
			ps.setString(15, leval);
			
			if(expense!=null && !"".equals(expense)){
				expense1 = Double.parseDouble(expense); 
			}

			// 设置所在培训班里面的座位号
			String seatMaxNoSql = " select isnull(max(seatno),0) as seatno from b_enroll where trainingid = ? ";
			int seatMaxNo = new DbUtil(conn).queryForInt(seatMaxNoSql,new Object[]{trainingId}) + 1;
			ps.setInt(17, seatMaxNo);
			ps.executeUpdate();
			
			//增加订单
			OrderService orderService = new OrderService(conn);
			Order order = new Order();
			order.setOrderAmount(expense1);
			order.setOrderContent(trainingname + "-报名费");
			order.setOrderId(orderid);
			order.setUserId(loginid);
			orderService.save(order);
			
			return "";
			
		} catch (Exception e) {
			System.out.println("saveInfo ERROR :" +sql);
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
			DbUtil.close(ps1);
		}
	}
}
