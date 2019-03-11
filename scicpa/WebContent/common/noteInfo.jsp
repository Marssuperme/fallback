<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>

<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
<table width="98%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#6595d6">
<tr height=18>
	<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>短信内容：</strong><font color="#FF0000">&nbsp;[*]</font></td>
 	<td width="80%" valign="bottom" align="left" bgColor="#ffffff" >
		<textarea style="width: 95%;height: 100px;" name="noteContent" id= "noteContent" ></textarea>
	</td>
</tr>

<tr height=18>
	<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>短信通知范围：</strong><font color="#FF0000">&nbsp;[*]</font></td>
 	<td width="80%" valign="bottom" align="left" bgColor="#ffffff" >
		<textarea style="width: 95%;height: 100px;"  name="noteArea" id= "noteArea" ></textarea>
	</td>
</tr>
</table>
<table align="center">
<tr>
	<td bgColor="white"><input type="button" value="发送"></td>
	<td style="width: 40%">&nbsp;</td>
	<td bgColor="white"><input type="button" value="取消"></td>
</tr>
</table>	

</body>
</html>