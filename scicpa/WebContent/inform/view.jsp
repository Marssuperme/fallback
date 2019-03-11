<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>实名举报</title>
<style>
.formTitle {
	color: #4A74BC;
	font-weight: bold;
	font-size: 14px;
	text-align:center;
	width:100%;
	margin-top: 10px;
}


	body {
		margin: 0px ;
		padding: 0px ;
		font-size:12px;
		overflow: auto;
		padding: 0 100;
	}
	
	.tools {
		width:100%;
		height:27px ;
		background-image: url("${pageContext.request.contextPath}/images/toolBarBg.gif");
		padding-top: 5px;
		padding-left:10px; 
	} 
	
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css?v=${modifyDate}"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/uploadFile.js?v=${modifyDate}"  ></script>
</head>
<body>
<form name="thisForm" id="thisForm" method="post" enctype="multipart/form-data" >

	<center class="formTitle" >
	实&nbsp;&nbsp;名&nbsp;&nbsp;举&nbsp;&nbsp;报<br/><br/> 
	</center>
	<hr>
	提示： 您的举报内容已经提交至服务器，我们将尽快查实处理。 
	<br>
	
	<input name="iuser" type="hidden" id="iuser"  value="${userSession.userMap.loginid }"  >
	<input name="idate" type="hidden" id="idate"  value="${dateandtime }"  >
	
		<table width="98%" border="0" align="" cellpadding="2" cellspacing="1"  bgcolor="#6595d6" > 
		<tr>
			<td align="right" width="15%" bgColor="#EEEEEE"><font color="#0000FF"><strong>举报人</strong></font></td>
			<td bgColor="#EEEEEE" >
			${topicMap.loginname }
			</td>
		</tr>
		<tr>
			<td align="right" width="15%" bgColor="#EEEEEE"><font color="#0000FF"><strong>举报时间</strong></font></td>
			<td bgColor="#EEEEEE" >
			${topicMap.idate }
			</td>
		</tr>
		<tr>
			<td align="right" width="15%" bgColor="#EEEEEE"><font color="#0000FF"><strong>IP</strong></font></td>
			<td bgColor="#EEEEEE" >
			${topicMap.ip }
			</td>
		</tr>
		
		<tr>
			<td align="right" width="15%" bgColor="#EEEEEE"><font color="#0000FF"><strong>标题</strong></font></td>
			<td bgColor="#EEEEEE" >
			${topicMap.caption }
			</td>
		</tr>
		
		<tr>
			<td align="right" valign="top" width="15%" height="450" bgColor="#EEEEEE" ><font color="#0000FF"><strong>举报事项</strong></font></td>
			<td bgColor="#ffffff" >${topicMap.body }</td>
		</tr>
		</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="22" colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td width="37%" align="right">
    </td>
    <td width="8%">&nbsp;</td>
	<td width="55%">
    	<input type="button" icon='icon-back' value="返 回" onclick="go()">
    </td>
  </tr>
</table>

</form>
</body>
</html>
<script type="text/javascript">
	
/*返回*/
function go(){
	var table = "${userSession.userMap.ctypetabname}";
	table = table.toLowerCase().substring(2);
	// 返回到首页 
	var url = "${pageContext.request.contextPath}/"+table+"/"+table+".do?method=goAddFrame&param=mainFrame";
	window.location = url;
}
</script>

