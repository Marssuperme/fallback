<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>事务所自查管理</title>

</head>
<body >

<form id="myform" name="myform" method="post">
<input type="hidden" id="id" name="id">
<div style="height:expression(document.body.clientHeight-28);width:100%;">
	<mt:DataGridPrintByBean name="managementList" />
</div>
</form>

</body>

</html>