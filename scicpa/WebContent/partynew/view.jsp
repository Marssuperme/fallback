<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>党群新闻</title>
<style>
td {
	font-size: 12px;
	text-decoration: none;
}
</style>
</head>
<body>
<form name="thisForm" method="post" action="">
<table width="100%" height="121" border="0" cellpadding="0" cellspacing="1" bgcolor="#6595d6">
<tr>
	<td align="center" valign="top" bordercolor="#CCCCCC" bgcolor="#FFFFFF">
      
	<h4>${newMap.caption }</h4>

	<table width="98%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#6595d6">
	<tbody id="SWlist">
	<tr height=18>
	  	<td width="98" height="20" align="center" bgColor="#EEEEEE"><strong>发布机构</strong></td>
	  	<td align="left" bgColor="#ffffff" >${newMap.agency }</td>
	</tr>
	<tr height=18>
	  	<td height="20" align="center" bgColor="#EEEEEE"><strong>发布时间</strong></td>
	  	<td align="left" bgColor="#ffffff" >${newMap.ntime }</td>
	</tr>
	<tr height=18>
	  	<td height="22" align="center" bgColor="#EEEEEE"><strong>新闻内容</strong></td>
	  	<td align="left" bgColor="#ffffff" >${newMap.body }</td>
	</tr>
	<tbody>
	</table>
	<br>
	<br>
	<table width="90%" align="center">
	<tr>
		<td width="" align="center">
			<input icon="icon-back" type="button" name="next" value="返  回"  onclick="window.history.back();" >
		</td>
	</tr>
	</table>

	</td>
</tr>
</table>
</form>
</body>
</html>
<script type="text/javascript">

</script>