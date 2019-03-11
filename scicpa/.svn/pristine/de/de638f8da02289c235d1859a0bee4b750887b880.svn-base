<%@page import="org.drools.lang.dsl.DSLMapParser.mapping_file_return"%>
<%@page import="org.apache.commons.dbutils.DbUtils"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="cn.org.gdicpa.web.pub.db.DBConnect"%>
<%@page import="cn.org.gdicpa.web.pub.db.DbUtil"%>
<%@page import="java.util.UUID"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="cn.org.gdicpa.web.pub.listener.UserSession"%>
<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@ page import="cn.org.gdicpa.web.service.yeepay.*" import="java.util.Map, java.util.HashMap"%>

<%!String formatString(String text) { return text == null ? "" : text.trim();}%>
<%
	Connection conn = null;
	PreparedStatement pstm = null;
	try {
		conn = new DBConnect().getConnect();
		DbUtil db = new DbUtil(conn);
		request.setCharacterEncoding("GBK");
		UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		if (userSession == null) {
			response.sendRedirect("login.do");
		}
		Map userMap = userSession.getUserMap();
		
		String area = "SC";		// 四川,对应配置文件的值
		
		String nowYear 	 = new SimpleDateFormat("yyyy").format(new Date());
		String loginid 	 = userMap.get("loginid").toString();
		String loginname = userMap.get("loginname").toString();
		
		String sqlID = "select idnumber,area from k_micfono where loginid='" + loginid + "'";
		Map uMap = db.getMap(sqlID);
		String idnumber = uMap.get("idnumber").toString();
		
		Long time = System.currentTimeMillis();
		String beforStr = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		beforStr = beforStr + (int) (Math.random() * 10);//时间加随机数，避免同一秒产生同订单号
		
		String p1_MerId 		= Configuration.getInstance().getValue("p1_MerId_" + area); //商户编号
		String p0_Cmd 			= Configuration.getInstance().getValue("p0_Cmd"); //业务类型  固定值Buy
		String p2_Order			= beforStr + "YCK" + nowYear + area;//商户订单号   beforStr + 'YCK'+ 年份+地区缩写
		String p3_Amt 			= Configuration.getInstance().getValue("p3_Amt"); //支付金额
		String p4_Cur 			= Configuration.getInstance().getValue("p4_Cur"); //交易币种 固定值CNY
		String p5_Pid 			= Configuration.getInstance().getValue("p5_Pid"); //商品名称
		String p6_Pcat 			= Configuration.getInstance().getValue("p6_Pcat"); //商品种类
		String p7_Pdesc 		= Configuration.getInstance().getValue("p7_Pdesc");//商品描述
		String p8_Url 			= Configuration.getInstance().getValue("p8_Url"); //回调地址
		String p9_SAF 			= Configuration.getInstance().getValue("p9_SAF"); //送货地址 
		String pa_MP 			= Configuration.getInstance().getValue("pa_MP"); //商户扩展信息
		String pd_FrpId 		= Configuration.getInstance().getValue("pd_FrpId"); //支付通道编码
		String pm_Period 		= Configuration.getInstance().getValue("pm_Period");//订单有效期
		String pn_Unit 		   	= Configuration.getInstance().getValue("pn_Unit"); //订单有效期单位
		String pr_NeedResponse 	= Configuration.getInstance().getValue("pr_NeedResponse"); //应答机制 固定值1
		
		System.out.println("求求别乱码好吗  " + p5_Pid);
		//插入数据库中，纪录订单号

		String sql = "select uuid as  count  from k_yeepay where loginid='" + loginid + "' and isyear='" + nowYear + "'";
		String uuid = db.queryForString(sql);

		if (uuid == null || "".equals(uuid)) {
			sql = "insert into k_yeepay (uuid,loginid,isyear,p3_amt,r1_code,p1_merid,p2_order,loginname,area,idnumber) values(?,?,?,?,?,?,?,?,?,?)";
			uuid = UUID.randomUUID().toString();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, uuid);
			pstm.setString(2, loginid);
			pstm.setString(3, nowYear);
			pstm.setString(4, "0");
			pstm.setString(5, "0");
			pstm.setString(6, p1_MerId);
			pstm.setString(7, p2_Order);
			pstm.setString(8, loginname);
			pstm.setString(9, uMap.get("area").toString());
			pstm.setString(10, idnumber);
			pstm.execute();
		} else {
			sql = "update k_yeepay set p2_order=? where uuid=? ";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, p2_Order);
			pstm.setString(2, uuid);
			pstm.execute();
		}
		//将扩展信息pa_MP设置成k_yeepay 中的uuid。
		pa_MP = uuid;

		Map<String, String> params = new HashMap<String, String>();
		params.put("p0_Cmd", p0_Cmd);
		params.put("p2_Order", p2_Order);
		params.put("p3_Amt", p3_Amt);
		params.put("p4_Cur", p4_Cur);
		params.put("p5_Pid", p5_Pid);
		params.put("p6_Pcat", p6_Pcat);
		params.put("p7_Pdesc", p7_Pdesc);
		params.put("p8_Url", p8_Url);
		params.put("p9_SAF", p9_SAF);
		params.put("pa_MP", pa_MP);
		params.put("pd_FrpId", pd_FrpId);
		params.put("pm_Period", pm_Period);
		params.put("pn_Unit", pn_Unit);
		params.put("pr_NeedResponse", pr_NeedResponse);

		out.println("params : " + params);

		String payURL = new YeepayService(area).getPayURL(params);

		if ("".equals(payURL)) {
			out.println("生成链接失败！");
		} else {
			response.sendRedirect(payURL);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		DbUtil.close(pstm);
		DbUtil.close(conn);
	}
%>
