package cn.org.gdicpa.web.service.inspection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.StringUtil;

public class InspectionService {
	
	private Connection conn = null;
	
	public InspectionService(Connection conn) {
		this.conn = conn;
	}
	
	//保存 到 临时表
	public void saveTemp(Map map) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			String iuser = (String)map.get("iuser");
			String iyear = (String)map.get("iyear");
			
			sql = "select * from t_inspectiontemp where iuser=? and iyear=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, iuser);
			ps.setString(2, iyear);
			rs = ps.executeQuery();
			if(rs.next()){ 
				return;
			}
			
			sql = " INSERT INTO t_inspectiontemp ("  
				+ "	id,officecode,iuser,idate,iyear,cpaid, "  
				+ "	schoolbdate,schooledate,school,school1,school2,"  
				+ "	verification,dues,result,approve,yearcheck,noyearcheckreason)"  
				+ " VALUES (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?,?,? )";
			int ii = 1;
			ps = conn.prepareStatement(sql);
			ps.setString(ii++, (String)map.get("id"));
			ps.setString(ii++, (String)map.get("officecode"));
			ps.setString(ii++, (String)map.get("iuser"));
			ps.setString(ii++, (String)map.get("idate"));
			ps.setString(ii++, (String)map.get("iyear"));
			ps.setString(ii++, (String)map.get("cpaid"));
			
			ps.setString(ii++, (String)map.get("schoolbdate"));
			ps.setString(ii++, (String)map.get("schooledate"));
			ps.setString(ii++, (String)map.get("school"));
			ps.setString(ii++, (String)map.get("school1"));
			ps.setString(ii++, (String)map.get("school2"));
			
			ps.setString(ii++, (String)map.get("verification"));
			ps.setString(ii++, (String)map.get("dues"));
			ps.setString(ii++, (String)map.get("result"));
			ps.setString(ii++, (String)map.get("approve"));
			ps.setString(ii++, (String)map.get("yearcheck"));
			ps.setString(ii++, (String)map.get("noyearcheckreason"));
			
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(ps);
		}
	}
	
	
	//保存 到 表 t_inspection
	public void save(Map map) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		String iuser = (String)map.get("iuser"); 
		String iyear = (String)map.get("iyear"); 
		String id = (String)map.get("id");
		String p = "";
		try {
			sql = "select * from t_inspection where iuser=? and iyear=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, iuser);
			ps.setString(2, iyear);
			rs = ps.executeQuery();
			if(rs.next()){ 
				sql = " update t_inspection set officecode=?,iuser=?,idate=?,iyear=?,cpaid=?, "
					+ " schoolbdate=?,schooledate=?,school=?,school1=?,school2=?,"
					+ " verification=?,dues=?,result=?,approve=?,schoolodate=?,school0=? where iuser=? and iyear=? ";
				p = "update";
			}else{
				sql = " INSERT INTO t_inspection ("  
					+ "	id,officecode,iuser,idate,iyear,cpaid, "  
					+ "	schoolbdate,schooledate,school,school1,school2,"  
					+ "	verification,dues,result,approve,yearcheck,noyearcheckreason,schoolodate,school0)"  
					+ " VALUES (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?,?,?,?,? )";
				p = "add";
			}
			
			int ii = 1;
			ps = conn.prepareStatement(sql);
			if("add".equals(p)){
				if(id==null || "".equals(id)){
					id = UUID.randomUUID()+"";
				}
				ps.setString(ii++, id);
			}
			ps.setString(ii++, (String)map.get("officecode"));
			ps.setString(ii++, (String)map.get("iuser"));
			ps.setString(ii++, (String)map.get("idate"));
			ps.setString(ii++, (String)map.get("iyear"));
			ps.setString(ii++, (String)map.get("cpaid"));
			
			ps.setString(ii++, (String)map.get("schoolbdate"));
			ps.setString(ii++, (String)map.get("schooledate"));
			ps.setString(ii++, (String)map.get("school"));
			ps.setString(ii++, (String)map.get("school1"));
			ps.setString(ii++, (String)map.get("school2"));
			
			ps.setString(ii++, (String)map.get("verification"));
			ps.setString(ii++, (String)map.get("dues"));
			ps.setString(ii++, (String)map.get("result"));
			ps.setString(ii++, (String)map.get("approve"));
			
			if("add".equals(p)){
				ps.setString(ii++, (String)map.get("yearcheck"));
				ps.setString(ii++, (String)map.get("noyearcheckreason"));
			}
			
			ps.setString(ii++, (String)map.get("schoolodate"));
			ps.setString(ii++, (String)map.get("school0"));
			
			if("update".equals(p)){
				ps.setString(ii++, (String)map.get("cpaid"));
				ps.setString(ii++, (String)map.get("iyear"));
			}
			
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	public void del(String iuser,String iyear) throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			
			sql = "delete from t_inspectiontemp where iuser = ? and iyear = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, iuser);
			ps.setString(2, iyear);
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	public String get(String sql) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String result = "0";
		try {
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				result = rs.getString(1); 
			}
			
		} catch (Exception e) {
			System.out.println(" ERROR :" +sql);
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return result;
	}
	
	/**
	 * 
	 * @param sql	
	 * @param approve 批文时间
	 * @param iyear	年度
	 * @param PR	三年前的学时总数
	 * @param map
	 * @throws Exception
	 */
	public void get(String sql,String approve,String iyear,String PR,Map map) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			/*
				批文时间：2010-6-30，	年：2010年，学时：10，结果：前年学时数：0，上年学时数：0，两年学时数：0	
				批文年:2010 ,iyear 2009 小于 通过
	
				批文时间：2010-6-30，	年：2011年，学时：20，结果：前年学时数：0，上年学时数：10，两年学时数：10
				批文年:2010 ,iyear 2010 , 相同 7-1之前 上年学时数>=30  通过
	
				批文时间：2010-6-30，	年：2012年，学时：30，结果：前年学时数：10，上年学时数：20，两年学时数：30	
				批文年:2010 ,iyear 2011,差1年    大于 7-1之前 前年学时数>=30 && 上年学时数 >=30 && 两年学时数>=80  通过
	
				批文时间：2010-6-30，	年：2013年，学时：40，结果：前年学时数：20，上年学时数：30，两年学时数：50	
				批文年:2010 ,iyear 2012,差2年以上   大于 7-1之前 前年学时数>=30 && 上年学时数 >=30 && 两年学时数>=80 通过
	
				====================
					
				批文时间：2010-7-1，	年：2010年，学时：10，结果：前年学时数：0，上年学时数：0，两年学时数：0	
				批文年:2010 ,iyear 2009 小于 通过
	
				批文时间：2010-7-1，	年：2011年，学时：20，结果：前年学时数：0，上年学时数：10，两年学时数：10
				批文年:2010 ,iyear 2010 , 相同 7-1之后  通过
	
				批文时间：2010-7-1，	年：2012年，学时：30，结果：前年学时数：10，上年学时数：20，两年学时数：30
				批文年:2010 ,iyear 2011,差1年    大于 7-1之后 上年学时数 >=30 && 两年学时数>=80 通过
	
				批文时间：2010-7-1，	年：2013年，学时：40，结果：前年学时数：20，上年学时数：30，两年学时数：50
				批文年:2010 ,iyear 2012,差2年    大于 7-1之后 前年学时数>=30 && 上年学时数 >=30 && 两年学时数>=80 通过
				
				批文时间：2010-7-1，	年：2014年，学时：50，结果：前年学时数：30，上年学时数：40，两年学时数：70
				
			 */
			
			
			/**
			 * 年检的规矩是：举例2011年今年年检
				1.学时通过
				
				A   2009年前年学时通过   2009年学时不少于30个学时（等于可以）
				B   2010年上年学时通过   2010年学时不少于30个学时
				C   2009年和2010年两年学时通过  2009+2010不少于80个学时
				
				注师“批准时间”为2009年6月30日之前（包括6月30日）  需要完成A、B、C 3项是否通过的检查
				注师“批准时间”为2009年7月1日到2010年6月30日  需要完成B 1项是否通过的检查，A、C 2项无条件通过
				注师“批准时间”为2010年7月1日到2010年12月31日 不需要完成任何1项都为学时通过  A、B、C项无条件通过
				
				注师“批准时间”为2011年1月1日之后，不需要参加年检，不用显示记录    
			 */

			
			double PR0 = 0.00 ,PR1 = 0.00,PR2 = 0.00; //PR0 前年   PR1 上年，PR2 二年
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if("".equals(approve) || approve == null){
				approve = new ASFuntion().getCurrentDate();
			}
			Date adate = sdf.parse(approve);	//批文时间 2010-6-30
			Date bdate1 = sdf.parse(approve.substring(0,4) + "-07-01");
			
			map.put("approve", approve);	
			
			int ad = Integer.parseInt(approve.substring(0,4)); //批准年
			int iy = Integer.parseInt(iyear); //上年
			
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String CurrYear = rs.getString("CurrYear");
				double PeriodResult = rs.getDouble("PeriodResult");
				
				if(iyear.equals(CurrYear)){ //上年
					PR1 += PeriodResult;
				}else{ //前年
					PR0 += PeriodResult;
				}
				PR2 += PeriodResult; //二年
				
			}
			System.out.println(PR1+"|"+PR2);
			
			map.put("schoolodate", String.valueOf(PR0));//前年
			map.put("schoolbdate", String.valueOf(PR1));	//上年
			map.put("schooledate", String.valueOf(PR2));	//二年
			
			String school = "0",school0 = "不通过",school1 = "不通过",school2 = "不通过";
			switch (ad - iy) {
			case -1:
				school0 = "通过";
				school1 = "通过";
				school2 = "通过";
				break;
			case 0:
				if(adate.before(bdate1)){ // 之前
					school0 = "通过"; 
					if(PR1>=30){
						school1 = "通过";
					}
					if(PR1>=30){
						school2 = "通过";
					}
				}else{ 		// 之后
					school0 = "通过";
					school1 = "通过";
					school2 = "通过";
				}
				break;
			case 1:
				if(adate.before(bdate1)){ // 之前
					if(PR0>=30){
						school0 = "通过";
					}
					if(PR1>=30){
						school1 = "通过";
					}
					if(PR0>=30 && PR1>=30 && PR2>=80){
						school2 = "通过";
					}
				}else{ 		// 之后
					school0 = "通过";
					if(PR1>=30){
						school1 = "通过";
					}
					if(PR1>=30 && PR2>=80){
						school2 = "通过";
					}
				}
				break;
			default:
				 if(PR0>=30){
					school0 = "通过";
				 }
				 if(PR1>=30){
					school1 = "通过";
				 }
				 if(PR0>=30 && PR1>=30 && PR2>=80){
					school2 = "通过";
				}
					
				break;
			}
		
			
			map.put("school", school);//  暂无用
			map.put("school1", school1);
			map.put("school2", school2);
			map.put("school0", school0);
		} catch (Exception e) {
			System.out.println(" ERROR :" +sql);
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	public void saveMicfo(String officecode,String idate,String iyear) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			
			Map map = new HashMap();
			map.put("officecode", officecode); //事务所代码
			map.put("idate", idate); 	//自检日期
			map.put("iyear", iyear); 	//自检年份
			
			int iyear1 = Integer.parseInt(iyear) - 1; //上年年份
			
			sql = "select * from K_Micfo where officecode = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, officecode);
			
			rs = ps.executeQuery();
			while(rs.next()){
				String loginid = rs.getString("loginid");
				String cpaid = rs.getString("cpano");
				String approve = rs.getString("approve");
				
				map.put("iuser", loginid); 	//自检人
				map.put("cpaid", cpaid); 	//CPA号	
				map.put("yearcheck", "是"); 	//是否参与年检         默认 为  是
				
				//学时数
				String sql1 = "select sum(PeriodResult) " +
				"	from XS_Content where appid = '"+loginid+"' " +
				"	and curryear='"+(Integer.parseInt(iyear) - 2)+"' ";
				String PR = get(sql1); //三年前的学时总数
				if(PR == null || "".equals(PR)){
					PR = "0";
				}
				
//				sql = "select a.*,b.trainingname,b.lessonid,b.lessonname,b.term " +
//				"	from XS_Content a,b_training b  " +
//				"	where 1=1 " +
//				"	and a.appid = '"+loginid+"' " +
//				"	and a.curryear <= '"+iyear1+"' " +
//				"	and a.curryear >= '"+(iyear1 - 1)+"' " +
//				"	and a.psb_guid = b.id ";
				
				sql = "select * from XS_Content a " +
				"	where 1=1 " +
				"	and a.appid = '"+loginid+"' " +
				"	and a.curryear <= '"+iyear1+"' " +
				"	and a.curryear >= '"+(iyear1 - 1)+"' " ;
				 
				
				// 计算 年检总数   和   是否 通过
				get(sql, approve, String.valueOf(iyear1), PR, map);
				
				
				//鉴证数  是上一年的 参加的报备数目
				sql = " select * from BB_View where 1=1 "  
					+ "	and substring(bbtime,1,4) = '"+(Integer.parseInt(iyear)-1)+"'"  
					+ "	and (" 
					+ "	CPA1 = '"+cpaid+"' "  
					+ "	or CPA2 = '"+cpaid+"' "  
					+ "	or CPA3 = '"+cpaid+"' "  
					+ "	or CPA4 = '"+cpaid+"' "  
					+ "	or CPA5 = '"+cpaid+"' "  
					+ "	or CPA6 = '"+cpaid+"' "  
					+ "	)" ;
				sql = "select count(*) from ("+sql+") a ";
				String verification = get(sql);
				map.put("verification", verification); 	//鉴证数
				
				//缴纳会费	是/否
				sql = "select b.*,a.idate,a.iyear " +
				"	from k_costpay a ,k_costpay_detail b " +
				"	where 1=1" +
				"	and a.iyear = '"+iyear+"'" +
				"	and b.cpaid = '"+cpaid+"' " +
				"   and a.property = '已缴费' " +
				"	and a.uuid =b.uid  " ;
				sql = "select count(*) from ("+sql+") a ";
				String dues = get(sql);
				if("0".equals(dues)){
					dues = "否";
				}else{
					dues = "是";
				}
				map.put("dues", dues); 	//缴纳会费	是/否	
				
				//自检结果
				String result = "";
				if("2011".equals(iyear)){//2011年检特别情况：鉴证数为0，可以通过
					if(!"否".equals(dues) && "通过".equals(map.get("school2"))){
						result = "通过";
					}else{
						result = "不通过";
					}
				}else{
					if(!"0".equals(verification) && !"否".equals(dues) && "通过".equals(map.get("school2"))){
						result = "通过";
					}else{
						result = "不通过";
					}
				}
				map.put("result", result); 	//自检结果
				
				String noyearcheckreason = "";
				map.put("noyearcheckreason", noyearcheckreason); 	// 未参加年检的原因
				
				map.put("id", UUID.randomUUID().toString()); 	// 主键
				
				// 保存到 临时表  t_inspectiontemp
				// saveTemp(map);
				
				// 保存到 表  t_inspection
				save(map);
				
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

	
	
	/**
	 * 修改是否参加年检
	 * @return
	 */
	public boolean updateYearCheck(String loginid,String isyearcheck,String iyear){
		PreparedStatement ps = null;
		String sql = "";
		try {
			
			if("是".equals(isyearcheck)){
				sql = "update t_inspection set yearcheck = ?,noyearcheckreason='' where iuser = ?  and iyear = ?";
			}else{
				sql = "update t_inspection set yearcheck = ? where iuser = ?  and iyear = ?";
			}
			ps = conn.prepareStatement(sql);
			ps.setString(1, isyearcheck);
			ps.setString(2, loginid);
			ps.setString(3, iyear);
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(ps);
		}
		return false;
	}
	
	
	/**
	 * 得到 list 信息
	 * @return
	 */
	public List getInfo(String officecode,String iyear){
		PreparedStatement ps = null;
		ResultSet rs = null;

		List list = null;
		Map map = null;
		
		String sql = "";
		try {
			sql = "select a.*,b.loginname from t_inspection a,k_user b  " +
			"	where 1=1 " +
			"	and a.officecode = '"+officecode+"' " +
			"	and a.iyear = '"+iyear+"' " +
			"	and a.iuser = b.loginid " ;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			list = new ArrayList();
			
			while(rs.next()){
				//CPA号，姓名，自检年份，学时数，鉴证数，会费缴纳，通过情况
				map = new HashMap();
				map.put("cpaid", rs.getString("cpaid"));
				map.put("loginname",rs.getString("loginname"));
				map.put("approve", rs.getString("approve"));
				map.put("iyear",rs.getString("iyear"));
				map.put("yearcheck", rs.getString("YearCheck"));
				map.put("schoolbdate",rs.getString("schoolbdate"));
				map.put("school1", rs.getString("school1"));
				map.put("schooledate",rs.getString("schooledate"));
				map.put("school2", rs.getString("school2"));
				map.put("verification",rs.getString("verification"));
				map.put("dues", rs.getString("dues"));
				map.put("result",rs.getString("result"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return list;
	}
	
	
	
	/**
	 * 得到任职资格检查  list 对象
	 * @return
	 */
	public List getInspectionList(String sql){
		PreparedStatement ps = null;
		ResultSet rs = null;

		List list = null;
		Map map = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			list = new ArrayList();
			
			while(rs.next()){
				//CPA号，姓名，自检年份，学时数，鉴证数，会费缴纳，通过情况
				map = new HashMap();
				map.put("id",rs.getString("id"));
				map.put("cpaid", rs.getString("cpaid"));
				map.put("loginname",rs.getString("loginname"));
				map.put("iyear",rs.getString("iyear"));
				map.put("yearcheck", rs.getString("yearcheck"));
				map.put("noyearcheckreason",rs.getString("noyearcheckreason"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return list;
	}
	
	
	/**
	 * 修改是否参加年检
	 * @return
	 */
	public boolean updateNoYearCheckReason(String id,String noyearcheckreason){
		PreparedStatement ps = null;
		String sql = "";
		try {
			
			sql = "update t_inspection set noyearcheckreason = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, noyearcheckreason);
			ps.setString(2, id);
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			System.out.println("执行 update   sql 出错："+e.getMessage());
			e.printStackTrace();
		} finally {
			DbUtil.close(ps);
		}
		return false;
	}
	
	
	/**
	 * 非执业年检
	 * @param iuser
	 * @param iyear
	 * @return
	 */
	public Map getInspectionNo(String iuser,String iyear){
		Map map = new HashMap();
		String sql = " select * from t_InspectionNo where iuser = ? and iyear = ? ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, iuser);
			ps.setString(2, iyear);
			rs = ps.executeQuery();
			if(rs.next()){
				map.put("id",rs.getString("id"));
				map.put("iuser", rs.getString("iuser"));
				map.put("idate", rs.getString("idate"));
				map.put("iyear", rs.getString("iyear"));
				map.put("crsa", rs.getString("crsa"));
				
				map.put("approval",rs.getString("approval"));
				map.put("yearcheck", rs.getString("yearcheck"));
				map.put("yearcheckresult", rs.getString("yearcheckresult"));
				map.put("memo", rs.getString("memo"));
				map.put("result", rs.getString("result"));
				
				map.put("nocheckreason",rs.getString("nocheckreason"));
				map.put("schooldate", rs.getString("schooldate"));
				map.put("schooldate2", rs.getString("schooldate2"));
				map.put("school2", rs.getString("school2"));
				map.put("schooldate3", rs.getString("schooldate3"));
				
				map.put("dues", rs.getString("dues"));
				map.put("initflag", rs.getString("initflag"));
				map.put("timeflag", rs.getString("timeflag"));
				
				map.put("msnl", rs.getString("msnl"));
				map.put("xscf", rs.getString("xscf"));
				map.put("hycf", rs.getString("hycf"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		
		return map;
	}
	
	
	/**
	 * 保存非执业年检学时信息
	 */
	public void saveInspectionNo(Map map){

//		ID varchar(64) not null,   iuser varchar(20),
//		idate varchar(20),  iyear varchar(10),  crsa varchar(20),  Approval varchar(20),   YearCheck varchar(10), --是否参加年检
//		YearCheckResult varchar(10),--年检结果   Memo varchar(100), --未通过原因   Result varchar(10), --自检结果
//		noCheckReason varchar(255), --未参加原因  schooldate varchar(10), --上年学时数   schooldate2 varchar(10), --上年投入式学时
//		school2 varchar(10), --上年投入式学时通过  schooldate3 varchar(10), --上年产出式学时  dues varchar(10), --缴纳会费
		
//		会员证号	姓名	年检结果	是否参加年检	资格批准时间	年份	自检结果	
//							是，否							
//		未参加原因	上年学时数	上年投入式学时	上年投入式学时通过	上年产出式学时		缴纳会员
//								>或=24为通过									是，否

		// YearCheckResult varchar(10),--年检结果   这个 的 结果的 算法
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String loginid = map.get("loginid").toString();
		String loginName = map.get("loginname").toString(); 
		String iyear = map.get("iyear").toString();
		try {
			ASFuntion CHF=new ASFuntion();
			String idate = CHF.getDateAndTime();
			map.put("id", UUID.randomUUID().toString());
			map.put("iuser", loginid);
			map.put("idate", idate);
			map.put("yearcheck", "是");
			
			if(!"".equals(iyear) && null != iyear){
				iyear = idate.substring(0, 4);
			}
			map.put("crsa", loginid);
			
			String sql = " select * from XS_Content c "
					   + " left join k_micfono m on c.appid = m.loginid "
					   + " and c.appname = m.loginname "
					   + " where appid = ? and appname = ? and curryear = ? and contenttype='非执业会员' ";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, loginid);
			ps.setString(2, loginName);
			ps.setString(3, iyear);
			rs = ps.executeQuery();
			String approval = "";
			if(rs.next()){
				approval = rs.getString("approval");
			}
			if(approval == null || "".equals(approval)){
				approval = idate;
			}
			
			map.put("approval", approval);
			
			double schooldate = 0.0;
			double schooldate2 = 0.0;
			double schooldate3 = 0.0;
			
			sql = " select PeriodResult from XS_Content  " +
				"	where 1=1 " +
				"	and appid = '"+loginid+"' " +
				"	and curryear = '"+(Integer.parseInt(iyear)-1)+"' and xs_guid = '投入式学时' ";
			
			
			String schooldate22 = new DbUtil(conn).queryForString(sql);	// 上年投入式学时
			if(schooldate22!=null && !"".equals(schooldate22)){
				schooldate2 = Double.parseDouble(schooldate22);
			}
			map.put("schooldate2", schooldate2+"");
			
			String school2 = schooldate2>=24?"通过":"不通过";
			
			map.put("school2", school2);

			sql = " select PeriodResult from XS_Content  " +
				"	where 1=1 " +
				"	and appid = '"+loginid+"' " +
				"	and curryear = '"+(Integer.parseInt(iyear)-1)+"' and xs_guid = '产出式学时' ";
			
			String schooldate33 = new DbUtil(conn).queryForString(sql);	// 上年产出式学时
			if(schooldate33!=null && !"".equals(schooldate33)){
				schooldate3 = Double.parseDouble(schooldate33);
			}
			map.put("schooldate3", schooldate3+"");

			schooldate = schooldate2+schooldate3;
			map.put("schooldate",schooldate+"");
			
			String dues = "否";
			String duesResult = new DbUtil(conn).queryForString(" select uuid from k_menbercostpay where loginid = '"+loginid+"' and iyear = '"+iyear+"' ");
			if(duesResult!=null && "".equals(duesResult)){
				dues = "是";
			}
			map.put("dues", dues);
			
			String result = "不通过";
			if("通过".equals(school2) && "是".equals(dues)){
				result = "通过";
			}
			map.put("result", result);
			
			saveToInspectionno(map);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	
	

	//保存 到 表 t_inspectionno
	public void saveToInspectionno(Map map) throws Exception{
//		ID varchar(64) not null,   iuser varchar(20),
//		idate varchar(20),  iyear varchar(10),  crsa varchar(20),  Approval varchar(20),   YearCheck varchar(10), --是否参加年检
//		YearCheckResult varchar(10),--年检结果   Memo varchar(100), --未通过原因   Result varchar(10), --自检结果
//		noCheckReason varchar(255), --未参加原因  schooldate varchar(10), --上年学时数   schooldate2 varchar(10), --上年投入式学时
//		school2 varchar(10), --上年投入式学时通过  schooldate3 varchar(10), --上年产出式学时  dues varchar(10), --缴纳会费
		
//		会员证号	姓名	年检结果	是否参加年检	资格批准时间	年份	自检结果	
//							是，否							
//		未参加原因	上年学时数	上年投入式学时	上年投入式学时通过	上年产出式学时		缴纳会员
//								>或=24为通过									是，否
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		String iuser = (String)map.get("iuser"); 
		String iyear = (String)map.get("iyear"); 
		String id = (String)map.get("id");
		String flag = (String)map.get("flag");//flag=all是即为通过“填报年检表”提交的数据 
		String p = "";
		try {
			sql = "select * from t_inspectionno where iuser=? and iyear=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, iuser);
			ps.setString(2, iyear);
			rs = ps.executeQuery();
			if(rs.next()){ 
				sql = " update t_inspectionno set iuser=?,idate=?,iyear=?,crsa=?,approval=?,schooldate=?,schooldate2=?,school2=?,schooldate3=?, "
					+ " YearCheckResult=?,Result=?,dues=? where iuser=? and iyear=? ";
				if("all".equals(flag)){
					sql = " update t_inspectionno set iuser=?,idate=?,iyear=?,crsa=?,approval=?,schooldate=?,schooldate2=?,school2=?,schooldate3=?, "
						+ " YearCheckResult=?,Result=?,dues=?,msnl=?,xscf=?,hycf=? where iuser=? and iyear=? ";
				}
				
				p = "update";
			}else{
				sql = " INSERT INTO t_inspectionno ("  
					+ "	id,iuser,idate,iyear,crsa,approval,schooldate,schooldate2,school2,schooldate3,YearCheck,nocheckreason, "  
					+ "	YearCheckResult,result,dues)"  
					+ " VALUES (?,?,?,?,?,?,?,?, ?,?,?,?,?,?, ?)";
				
				if("all".equals(flag)){
					sql = " INSERT INTO t_inspectionno ("  
						+ "	id,iuser,idate,iyear,crsa,approval,schooldate,schooldate2,school2,schooldate3,YearCheck,nocheckreason, "  
						+ "	YearCheckResult,result,dues,msnl,xscf,hycf)"  
						+ " VALUES (?,?,?,?,?,?,?,?, ?,?,?,?,?,?, ?,?,?,?)";
				}
				
				p = "add";
			}
			
			int ii = 1;
			ps = conn.prepareStatement(sql);
			if("add".equals(p)){
				ps.setString(ii++, id);
			}
			ps.setString(ii++, (String)map.get("iuser"));
			ps.setString(ii++, (String)map.get("idate"));
			ps.setString(ii++, (String)map.get("iyear"));
			ps.setString(ii++, (String)map.get("crsa"));
			ps.setString(ii++, (String)map.get("approval"));
			
			ps.setString(ii++, (String)map.get("schooldate"));
			ps.setString(ii++, (String)map.get("schooldate2"));
			ps.setString(ii++, (String)map.get("school2"));
			ps.setString(ii++, (String)map.get("schooldate3"));
			
			if("add".equals(p)){
				ps.setString(ii++, (String)map.get("yearcheck"));
				ps.setString(ii++, (String)map.get("noyearcheckreason"));
			}
			
			ps.setString(ii++, (String)map.get("yearcheckresult"));
			ps.setString(ii++, (String)map.get("result"));
			ps.setString(ii++, (String)map.get("dues"));
			
			if("add".equals(p) && "all".equals(flag)){
				ps.setString(ii++, (String)map.get("msnl"));
				ps.setString(ii++, (String)map.get("xscf"));
				ps.setString(ii++, (String)map.get("hycf"));
			}
			
			if("update".equals(p)){
				if("all".equals(flag)){
					ps.setString(ii++, (String)map.get("msnl"));
					ps.setString(ii++, (String)map.get("xscf"));
					ps.setString(ii++, (String)map.get("hycf"));
				}
				ps.setString(ii++, (String)map.get("iuser"));
				ps.setString(ii++, (String)map.get("iyear"));
			}
			
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
	}
	

	/**
	 * 修改是否参加年检
	 * @return
	 */
	public boolean updateYearCheckMicfono(String loginid,String isyearcheck,String iyear,String nocheckreason){
		PreparedStatement ps = null;
		String sql = "";
		try {
			
			sql = "update t_inspectionno set yearcheck = ?,nocheckreason=? where iuser = ?  and iyear = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, isyearcheck);
			if("否".equals(isyearcheck)){
				ps.setString(2, nocheckreason);
			}else{
				ps.setString(2, "");
			}
			ps.setString(3, loginid);
			ps.setString(4, iyear);
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(ps);
		}
		return false;
	}
	
	
	
	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date bdate = sdf.parse("2010-01-01");
		Date edate = sdf.parse("2010-07-01");
		
		Date adate = sdf.parse("2010-07-01");	//批文时间 2010-6-31
		
			// iyear-01-01 =< approve < iyear-07-01 
			//a.after(b) 表示a是b之后
			//a.before(b) 表示a是b之前
			if(adate.before(edate)){
				System.out.println("adate1:"+adate);
			}else{
				System.out.println("adate2:"+adate);
			}
	}		
}
