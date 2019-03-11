package cn.org.gdicpa.web.service.annualInspection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import cn.org.gdicpa.web.pub.db.DbUtil;
import cn.org.gdicpa.web.pub.util.ASFuntion;
import cn.org.gdicpa.web.pub.util.DateUtil;
import cn.org.gdicpa.web.pub.util.StringUtil;
import cn.org.gdicpa.web.service.annualInspection.model.MicfoNoYck;

public class InspectionService {
	
	private Connection conn;

	public InspectionService(Connection conn) {
		this.conn = conn;
	}

	/**
	 * 区别于DbUtil的getMap方法，map的key存放英文小写
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> getMap(String sql){
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	try {
    		ASFuntion CHF = new ASFuntion();
    		Map<String, String> map = null;
    		ps = conn.prepareStatement(sql);
    		rs = ps.executeQuery();
    		ResultSetMetaData RSMD = rs.getMetaData();
    		if (rs.next()) {
    			map = new HashMap<String, String>();
    			for (int i = 1; i <= RSMD.getColumnCount(); i++) {
    				map.put(RSMD.getColumnLabel(i).toLowerCase(), CHF.showNull(rs.getObject(RSMD.getColumnLabel(i)) + ""));
    			}
    		}
    		return map;
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		DbUtil.close(rs);
    		DbUtil.close(ps);
    	}
		return null;
    }
	
	/**
	 * 年检启用年度范围内条件
	 * @param year
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> isInspectionYear(String year) {
		
		Map<String ,String> result = null;
		try {
			String sql = "select * from k_yearcheckmanageno where year <= '"+year+"' and year2 >= '"+year+"'";
			result = new DbUtil(conn).getMap(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 是否通过继续教育
	 * @param loginid
	 * @param year
	 * @return
	 * @throws Exception
	 */
	public String isEducationPass(String loginid, String year) {
		
		String ending = "";
		try{
			String sql = "select ending from xs_content where no = ? and curryear = ? ";
			ending = new DbUtil(conn).queryForString(sql, new Object[]{loginid, Integer.parseInt(year) - 1});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ending;
	}
	
	/**
	 * 是否已缴费
	 * @param loginid
	 * @param year
	 * @return
	 * @throws Exception
	 */
	public int isPaidFee(String loginid, String year) {
		
		int count = 0;
		try{
			String sql = "select count(1) as count from k_yeepay where r1_Code = '1' and loginid = ? and p3_Amt = '100.0' and isyear = ? ";
			count = new DbUtil(conn).queryForInt(sql, new Object[]{loginid, Integer.parseInt(year)});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 获取上一年学时、继续教育情况
	 * @param loginid
	 * @param year
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> getXSContent(String loginid, String year) {
		
		Map<String, String> map = new HashMap<String, String>();
		try {
			
			 int lastYear = Integer.parseInt(year) - 1;
			 String sql = "select ending, isnull(periodresult, '0') as periodresult "
					 + " from xs_content where curryear = '" + lastYear + "' and appid = '" + loginid + "'";
		
			 map = this.getMap(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 当年的年检报告是否已存在
	 * @param loginid
	 * @param theyear
	 * @return
	 */
	public boolean isExistYearcheckReport(String loginid, String theyear) {
		
		boolean flag = false;
		String sql = "select count(1) from k_yckcpano where loginid=? and year=?";
		try {
			int count = new DbUtil(conn).queryForInt(sql, new Object[]{loginid, theyear});
			flag = count > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 保存信息
	 * @param field
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int saveInfo(String field, Map map) {

		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ASFuntion CHF = new ASFuntion();
			String sql = "", sql1 = "", sql2 = "";
			
			// 检查记录是否存在，不存在则插入，存在则修改

			sql = "select  1 from K_YCKCPANO where " + field + "='" + CHF.showNull((String) map.get(field)) + "'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (!rs.next()) {
				// 插入
				sql = "select * from K_YCKCPANO where 1=2 ";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				ResultSetMetaData RSMD = rs.getMetaData();
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					sql1 += "," + RSMD.getColumnLabel(i).toLowerCase() + "";
					sql2 += ",?";
				}

				sql = "insert into K_YCKCPANO (" + sql1.substring(1) + ") values (" + sql2.substring(1) + ") ";
				ps = conn.prepareStatement(sql);
				int ii = 1;
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					String string = (String) map.get(RSMD.getColumnLabel(i).toLowerCase());
					ps.setString(ii, (string == null) ? "" : string);
					ii++;
				}

			} else {
				// 修改
				sql = "select * from K_YCKCPANO where 1=2 ";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				ResultSetMetaData RSMD = rs.getMetaData();
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					if (!CHF.showNull(field).toLowerCase().equals(RSMD.getColumnLabel(i).toLowerCase())) {
						sql1 += "," + RSMD.getColumnLabel(i).toLowerCase() + " = ? ";
					}
				}
				sql = "update K_YCKCPANO set " + sql1.substring(1) + " where " + field + " = ? ";
				ps = conn.prepareStatement(sql);
				int ii = 1;
				for (int i = 1; i <= RSMD.getColumnCount(); i++) {
					if (!CHF.showNull(field).toLowerCase().equals(RSMD.getColumnLabel(i).toLowerCase())) {
						String string = (String) map.get(RSMD.getColumnLabel(i).toLowerCase());
						ps.setString(ii, (string == null) ? "" : string);
						ii++;
					}
				}
				ps.setString(ii, (String) map.get(CHF.showNull(field).toLowerCase()));
			}
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(ps);
		}
		return result;
	}
	
	/**
	 * 保存信息
	 * @param bean
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public int saveInfo(MicfoNoYck bean, String type) {

		String sql = null;
		Object[] objs = null;
		int result = 0;
		try{
		
			if("insert".equalsIgnoreCase(type)){	// 新增
				
				sql = "insert into K_YCKCPANO(uuid,loginname,loginid,sex,idnumber,approvalnumber,certificate,getmode,"
					+ "area,approval,certificdate,retirees,loginnameex,oldcrsa,borndate,nation,politics,postcode,"
					+ "address,phone,email,professional,diploma,degree,specialty,educational,languagelevel,accountin,"
					+ "workunits,ownership,mobile,association,payfee,educate,sxcontent,stateno,state,result,auditidea,"
					+ "auditreason,audittime,auditperson,filltime,year,auditreasonzx,selfidea,type,step_current) "
					+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
					+ " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
				objs = new Object[]{bean.getUuid(), bean.getLoginname(), bean.getLoginid(), bean.getSex(), bean.getIdnumber(), 
						bean.getApprovalnumber(), bean.getCertificate(), bean.getGetmode(), bean.getArea(), bean.getApproval(),
						bean.getCertificdate(), bean.getRetirees(), bean.getLoginnameex(), bean.getOldcrsa(), bean.getBorndate(),
						bean.getNation(), bean.getPolitics(), bean.getPostcode(), bean.getAddress(), bean.getPhone(), bean.getEmail(), bean.getProfessional(),
						bean.getDiploma(), bean.getDegree(), bean.getSpecialty(), bean.getEducational(), bean.getLanguagelevel(), 
						bean.getAccountin(), bean.getWorkunits(), bean.getOwnership(), bean.getMobile(), bean.getAssociation(), 
						bean.getPayfee(), bean.getEducate(), bean.getSxcontent(), bean.getStateno(), bean.getState(), bean.getResult(), 
						bean.getAuditidea(), bean.getAuditreason(), bean.getAudittime(), bean.getAuditperson(), bean.getFilltime(), 
						bean.getYear(), bean.getAuditreasonzx(), bean.getSelfidea(), bean.getType(), bean.getStep_current()};
			
			}else{	// 更新
				
				
			}
			result  = new DbUtil(conn).update(sql, objs);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 流程表
	 * @param yckId
	 * @return
	 */
	public boolean saveToStep(String yckId){
		
		boolean flag = false;
		
		try {
			DbUtil db = new DbUtil(conn);
			
			String sql = "select re_user, step from k_review where 1=1 ";
			List<Map<String, Object>> listMap = db.getAllObject2ListMap(sql, null);
			
			StringBuffer sb = new StringBuffer("insert into K_YCKCPANO_step(step_id, yck_uuid, re_user, step, state)");
			sb.append(" values");
			
			for(int i = 0; i < listMap.size(); i ++){
				
				String uuid = UUID.randomUUID().toString();
				String user = listMap.get(i).get("re_user").toString();
				String step = listMap.get(i).get("step").toString();
				
				sb.append("(");
				sb.append("'").append(uuid).append("',");
				sb.append("'").append(yckId).append("',");
				sb.append("'").append(user).append("',");
				sb.append("'").append(step).append("',");
				sb.append("'0'");
				sb.append("),");
				
			}
			
			sql = sb.toString();
			sql = sql.substring(0, sql.length() - 1);
			
			int count = db.update(sql, null);
			
			flag = count > 0 ? true : false;
			
			System.out.println("插入流程表sql---" + sql);
			System.out.println("流程表操作结果---" + flag);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * 是否可填写年检申请
	 * @param yckmanageMap
	 * @param nowYear
	 * @return
	 */
	public String canFill(Map<String, String> yckmanageMap, String nowYear) {

		String str = "";
		String year1 = yckmanageMap.get("year");
		String year2 = yckmanageMap.get("year2");
		
		String startDate = yckmanageMap.get("startdate");
		String endDate   = yckmanageMap.get("enddate");
		String nowDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		int isok = new DateUtil().equalDateIn(startDate, nowDate, endDate);
		
		if (isok == 0) {
			str = "现在不是年检填报时间！ " + year1 + "至" + year2 + " 年检填报时间从" + startDate + "至" + endDate;
		} else if (isok == 2) {
			str = year1 + "至" + year2 + "年检填报已结束，结束时间是" + endDate;
		}
		return str;
	}

	/**
	 * 更新非执业会员信息
	 * @param map
	 * @return
	 * @throws Exception 
	 */
	public boolean updatemicfono(Map map) {
		
		boolean flag = false;
		try {
			
			String area 			= (String) map.get("area");				// 所在地区
			String retirees 		= (String) map.get("retirees");			// 离退休标志
			String loginnameex 		= (String) map.get("loginnameex");		// 曾用名
			String nation 			= (String) map.get("nation");			// 民族
			String politics			= (String) map.get("politics");			// 政治面貌、
			String postcode 		= (String) map.get("postcode");			// 邮编、
			String address 			= (String) map.get("address");			// 通讯地址、
			String phone 			= (String) map.get("phone");			// 联系电话
			String email 			= (String) map.get("email");			// Email
			String professional		= (String) map.get("professional");		// 职称等级
			String diploma 			= (String) map.get("diploma");			// 学历
			String degree 			= (String) map.get("degree");			// 学位
			String specialty 		= (String) map.get("specialty");		// 专业
			String educational		= (String) map.get("educational");		// 毕业院校
			String languagelevel 	= (String) map.get("languagelevel");	// 外语程度
			String accountin 		= (String) map.get("accountin");		// 户口所在地、
			String workunits 		= (String) map.get("workunits");		// 工作单位
			String ownership 		= (String) map.get("ownership");		// 单位性质
			String mobile 			= (String) map.get("mobile");			// 手机
			String loginid 			= (String) map.get("loginid");
			
			String sql = "update k_micfono set area = ?, retirees = ?, loginnameex = ?, nation = ?, politics = ?, postcode = ?, "
					+ "address = ?, phone = ?, email = ?, professional = ?, diploma = ?, degree = ?, specialty = ?, educational = ?, "
					+ "languagelevel = ?, accountin = ?, workunits = ?, ownership = ?, mobile = ? where loginid = ?";
			
			Object[] objs = new Object[]{area, retirees, loginnameex, nation, politics, postcode, 
					address, phone, email, professional, diploma, degree, specialty, educational, 
					languagelevel, accountin, workunits, ownership, mobile, loginid};
			
			int count = new DbUtil(conn).update(sql, objs);
			
			flag = count > 0 ? true : false;
			
			System.out.println("更新非执业会员sql---" + sql);
			System.out.println("更新非执业会员结果---" + flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 缴费后自动通过年检：<br>
	 * 	1.本年度未申请年检<br>
	 * 	2.上一年继续教育通过<br>
	 * 	3.完成缴费<br>
	 * @param loginid
	 * @param year
	 * @return
	 */
	public boolean autoPass(String loginid, String year) {
		
		boolean flag = false;
		try {
			
			System.out.println("缴费完成后自动通过年检");
			
			String sql = "select loginid, loginname, sex, idnumber, approvalnumber, certificate, getmode, area, approval, "
					+ " issuance as certificdate, retirees, loginnameex, borndate, nation, politics, postcode, address, "
					+ " phone, email, professional, diploma, degree, specialty, educational, languagelevel, accountin, "
					+ " workunits, ownership, mobile, association "
					+ " from k_micfono "
					+ " where loginid = ? ";
			
			MicfoNoYck bean = (MicfoNoYck) new DbUtil(conn).getOneObject2Bean(sql, MicfoNoYck.class, new Object[]{loginid});
			
			// 上一年继续教育情况
			Map<String, String> map = this.getXSContent(loginid, year);
			String periodresult = StringUtil.showNull(map.get("periodresult").toString());
			String ending 		= StringUtil.showNull(map.get("ending").toString());
			
			if("".equals(periodresult) || Integer.parseInt(periodresult) < 24 || 
					"".equals(ending) || "不通过".equals(ending)){
				
				System.out.println((Integer.parseInt(year) - 1) + "年度继续教育未通过");
				return flag;
			}
			
			bean.setPayfee("已缴纳");
			bean.setEducate("通过");
			bean.setSxcontent(map.get("periodresult"));
			bean.setStateno("11");
			bean.setState("已审批");
			bean.setResult("通过");
			bean.setAuditidea("通过");
			bean.setAuditreason("通过");
			bean.setAudittime(DateUtil.getDate("yyyy-MM-dd HH:mm:ss"));
			bean.setFilltime(DateUtil.getDate("yyyy-MM-dd HH:mm:ss"));
			bean.setYear(year);
			bean.setAuditreasonzx("通过");
			bean.setSelfidea("申请通过");
			bean.setType("自动");
			bean.setAuditideadate(DateUtil.getDate("yyyy-MM-dd"));
			bean.setStep_current("11");
			bean.setUuid(UUID.randomUUID().toString());
			int count = this.saveInfo(bean, "insert");
			
			if(count > 0){
				System.out.println("缴费完成后自动通过年检-----成功");
				flag = true;
			}else{
				System.out.println("缴费完成后自动通过年检-----失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
}
