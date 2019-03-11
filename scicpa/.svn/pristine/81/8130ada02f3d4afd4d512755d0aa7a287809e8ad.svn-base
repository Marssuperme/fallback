<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>

<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网上投稿</title>
<style>
.formTitle {
	color: #4A74BC;
	font-weight: bold;
	font-size: 14px;
	text-align: center;
	width: 100%;
	margin-top: 10px;
}

body {
	margin: 0px;
	padding: 0px;
	font-size: 12px;
	overflow: auto;
	padding: 0 100;
}

.tools {
	width: 100%;
	height: 27px;
	background-image:
		url("${pageContext.request.contextPath}/images/toolBarBg.gif");
	padding-top: 5px;
	padding-left: 10px;
}
</style>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/index.css?v=${modifyDate}" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/JS/uploadFile.js?v=${modifyDate}"></script>
</head>
<body>
<form name="thisForm" id="thisForm" method="post"
	enctype="multipart/form-data">

<center class="formTitle">
网&nbsp;&nbsp;上&nbsp;&nbsp;投&nbsp;&nbsp;稿<br />
<br />
</center>
<hr>

<br>

<input name="iuser" type="hidden" id="iuser" value=" "> <input
	name="idate" type="hidden" id="idate" value=" "> <input
	name="ip" type="hidden" id="ip" value=" "> <input
	name="result" type="hidden" id="result" value="未处理">

<table width="98%" border="0" align="" cellpadding="2" cellspacing="1"
	bgcolor="#6595d6">
	<tr>
		<td align="right" width="15%" bgColor="#EEEEEE"><font
			color="#0000FF"><strong>稿件标题</strong></font></td>
		<td bgColor="#EEEEEE"><input name="caption" type="text"
			id="caption" style="height: 20px; width: 500px" value=""></td>
	</tr>
	<tr>
		<td align="right" width="15%" bgColor="#EEEEEE"><font
			color="#0000FF"><strong>稿件性质</strong></font></td>
		<td bgColor="#EEEEEE"><input name="author" type="text"
			id="author" style="height: 20px; width: 200px" value=""
			onfocus="onPopDivClick(this);" onkeydown="onKeyDownEvent();"
			onkeyup="onKeyUpEvent();" onclick="onPopDivClick(this);" autoid=34
			class="required"></td>
	</tr>
	<tr>
		<td align="right" width="15%" bgColor="#EEEEEE"><font
			color="#0000FF"><strong>作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者</strong></font></td>
		<td bgColor="#EEEEEE"><input name="author" type="text"
			id="author" style="height: 20px; width: 200px" value=""
			class="required"></td>
	</tr>
	<tr>
		<td align="right" valign="top" width="15%" height="450"
			bgColor="#EEEEEE"><font color="#0000FF"><strong>稿件详细内容</strong></font></td>
		<td bgColor="#ffffff"><textarea id='body' name="body"></textarea></td>
	</tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="22" colspan="3">&nbsp;</td>
	</tr>
	<tr>
		<td width="37%" align="right"><input type="button"
			icon='icon-save' name="next" value="保 存" onclick="">
		</td>
		<td width="8%">&nbsp;</td>
		<td width="55%"><input type="button" icon='icon-back' value="返 回"
			onclick="go()"></td>
	</tr>
</table>

</form>
</body>
</html>
<script type="text/javascript">
 
	initHtmlbox("body","100%","100%");
 

	/*返回*/
	function go(){
		window.history.back();
	}
</script>

