<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="jxl.*"%>
<%@page import="jxl.Cell"%>
<%@page import="jxl.Workbook"%>
<%@page import="jxl.Sheet"%>
<%@page import="java.io.File"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cn.org.gdicpa.web.pub.db.DBConnect"%>
<%@page import="cn.org.gdicpa.web.pub.db.DbUtil"%>
<%@page import="cn.org.gdicpa.web.pub.fileupload.MyFileUpload"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="cn.org.gdicpa.web.pub.listener.UserSession"%>
<%@page import="cn.org.gdicpa.web.service.bbCommon.BbService"%>
<%@page import="java.util.UUID"%>
<%@page import="cn.org.gdicpa.web.pub.autocode.DELAutocode"%>
<%@page import="cn.org.gdicpa.web.pub.util.ASFuntion"%>
<%@page import="cn.org.gdicpa.web.service.content.ContentService"%>
<%@page import="cn.org.gdicpa.web.pub.util.MD5"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ImportBBData.jsp</title>
<style>
a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
<%
//读取 excel 数据 保存到数据库
Connection conn = null;
PreparedStatement ps = null;
Statement stmt = null;
ResultSet rs = null;
Map<String,String> map = new HashMap<String,String>();
try {
	conn = new DBConnect().getConnect();
	stmt = conn.createStatement();
	rs = stmt.executeQuery("SELECT loginid,IDnumber FROM dbo.K_Micfo");
	
	while(rs.next()){
		String s = rs.getString("IDnumber");
		s = MD5.getMD5String(s.substring(s.length()-7));
		System.out.println(s);
		map.put(rs.getString("loginid"),s);
	}
}catch(Exception e){
	
}



%>

	 
</body>

</html>