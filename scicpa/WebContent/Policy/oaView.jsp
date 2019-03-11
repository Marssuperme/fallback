<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看法律法规</title>
<script language="javascript" src="${pageContext.request.contextPath}/JS/weebox.js"></script> 
<link rel="STYLESHEET" type="text/css" href="${pageContext.request.contextPath}/CSS/weebox.css">
<style>

	body {
		margin: 10px ;
		padding: 0px ;
	}
	
	
	.content {
		width:100% ;
		height:100%;
		padding-bottom:150px;
		padding-top: 30px;
		padding-left:20px;
		padding-right:30px;
	}
	
	

	
</style>

</head>
<body>

<div class="content">
	<table border=0 cellspacing=0 width=100% cellpadding=3 align=center bordercolor=#ffffff>
		<tr><Td align=center style="font-size:14px"><b><font color=maroon>${policy.title}</font></b></td></tr>
		<tr><Td align=center style="font-size:14px"><font color=#614E4E>${policy.wordNum}</font></td></tr>
		<tr>
			<td align=center style="font-size:14px">
					
			<font color=#614E4E>颁布日期：${policy.sendDate}</font><font color=#614E4E>　颁布单位：${policy.sendDepartment}</font></td>
		</tr>
		<tr><Td height=5></td></tr>
	</table>
	${content}
</div>


</body>
</html>
 