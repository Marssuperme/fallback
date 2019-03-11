<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告通知</title>
<style>
td {
	font-size: 12px;
	text-decoration: none;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/uploadFile.js?v=${modifyDate}"  ></script>
</head>
<body>
<form name="thisForm" method="post" action="">
<table width="100%" height="121" border="0" cellpadding="0" cellspacing="1" bgcolor="#6595d6">
 
<tr>
	<td align="center" valign="top" bordercolor="#CCCCCC" bgcolor="#FFFFFF" style="padding-top: 20px">
      
	<h4>${noticeMap.caption }</h4>

	<table width="98%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#6595d6">
	<tbody id="SWlist">
	
	<!-- 
	<tr height=18>
	  	<td width="98" height="20" align="center" bgColor="#EEEEEE"><strong>文号</strong></td>
	  	<td width="845" align="left" bgColor="#ffffff" >${noticeMap.reference }</td>
	</tr>
	 -->
	 
	<tr height=18>
	  	<td height="20" align="right" bgColor="#EEEEEE" width="15%"><strong>发文机构</strong></td>
	  	<td align="left" bgColor="#ffffff" width="85%">${noticeMap.agencyname }</td>
	</tr>
	<tr height=18>
	  	<td height="20" align="right" bgColor="#EEEEEE"><strong>发文日期</strong></td>
	  	<td align="left" bgColor="#ffffff" >${noticeMap.ntime }</td>
	</tr>
	<tr height=18>
	  	<td height="22" align="right" bgColor="#EEEEEE"><strong>文件正文</strong></td>
	  	<td align="left" bgColor="#ffffff" >${noticeMap.body }</td>
	</tr>
	<tr>
		<td height="22" align="right" bgColor="#EEEEEE"><strong>附 件</strong></td>
	 	<td align="left" bgColor="#FFFFFF"><div id = "${noticeMap.attachmentid }"></div></td>
	</tr>
	<tbody>
	</table>
	<br>
	<br>
	<table width="90%" align="center">
	<tr>
		<td width="" align="center">
			<input icon="icon-back" type="button" name="next" value="返  回"  onclick="f_goBack();" >
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

try{
	$('#${noticeMap.attachmentid }').uploadFile({
		indexId: '${noticeMap.attachmentid }',
		module:'${noticeMap.table }',
		forbitUpload:true,
		forbitDel:true
	});
}catch(e){}	 
 
var p = "${p}"; 
function f_goBack(){
	if(p=="main"){ 
		window.location = "${pageContext.request.contextPath}/company/company.do?method=goAddFrame&param=mainFrame";
	}else if(p=="micfomain"){
		window.location = "${pageContext.request.contextPath}/micfo/micfo.do?method=goAddFrame&param=mainFrame";
	}else if(p=="micfonomain"){
		window.location = "${pageContext.request.contextPath}/micfono/micfono.do?method=goAddFrame&param=mainFrame";
	}else{
		window.history.back();
	}
}

</script>