<%@ page language="java" import="cn.org.gdicpa.web.service.education.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>  
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="cn.org.gdicpa.web.pub.fileupload.MyFileUpload"%>
<%@page import="cn.org.gdicpa.web.service.dataupload.DisposeTableService"%>
<%@page import="cn.org.gdicpa.web.service.dataupload.UploadDataService"%>
<%@page import="cn.org.gdicpa.web.pub.db.DBConnect"%>
<%@page import="cn.org.gdicpa.web.pub.util.FileUtil"%>
<%@page import="cn.org.gdicpa.web.pub.db.DbUtil"%>
<%@page import="cn.org.gdicpa.web.pub.autocode.DELUnid"%>
<%@page import="cn.org.gdicpa.web.pub.listener.UserSession"%>
<%@page import="cn.org.gdicpa.web.pub.net.Web"%>
<%@page import="cn.org.gdicpa.web.pub.util.ASFuntion"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>广东省注册会计师协会继续教育网络培训平台会员信息导出程序</title>
</head>
<body>
	 <%
	 	
	 	String sql = "SELECT Name FROM MTOA_GDICPA..SysObjects Where XType='U' and name like 'tt_BB_%137%' ORDER BY Name";
	 	Connection conn = new DBConnect().getConnect();
	 	
	 	Statement st = conn.createStatement();
	 	ResultSet rs = st.executeQuery(sql);
	 	List<String> list = new ArrayList<String>();
	 	while(rs.next()){
	 		list.add(rs.getString("name"));
	 	}
	 
	 	for(String str : list){
		 	st.addBatch("drop table "+str);
	 	}
	 	st.executeBatch();
	 	
	  %>

<form name="thisForm" id="thisForm" action="" method="post">
<table style="width:650px;" cellpadding="0" cellspacing="0">
<tr>
	<td>请选择日期：</td>
	<td><input maxlength="50" id="date" value="" style="width: 350px;" name="date" showcalendar="true" class="required" onkeypress="return false;" onpaste="return false;" ></td>
</tr>
<tr>
	<td align="center" colspan="2"><br>
		<input type="button" onclick="f_export();" value="  导出会员信息  ">
		<input type="button" onclick="f_inport();" value="  导入培训信息  ">
  </td>
</tr>
</table>
</form>
<span>${msg }</span>
<span style="color:red;">${err_msg }</span>
<script type="text/javascript">
	function f_export(){
		if($("#date").val()==""){
			alert("请选择日期！");
			return;
		}
		thisForm.action="${pageContext.request.contextPath}/common/inAndExpTool.do?method=export";
		thisForm.submit();
	}
	function f_inport(){
		if($("#date").val()==""){
			alert("请选择日期！");
			return;
		}
		thisForm.action="${pageContext.request.contextPath}/common/inAndExpTool.do?method=inport";
		thisForm.submit();
	}
</script>
</body>
</html>