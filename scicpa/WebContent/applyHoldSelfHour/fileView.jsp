<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ include file="/Sys_INCLUDE/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/JS/uploadFile.js?v=${modifyDate}"  ></script>

</head>
<body>
<table width="98%" border="0" align="center" cellpadding="5" cellspacing="1" bgcolor="#6595d6">
	<tbody >
	
	<tr height=18 >
	  	<td height="20" align="center" bgColor="#EEEEEE" style="width: 30%"><strong>培训班名称</strong></td>
	  	<td align="left" bgColor="#ffffff" >${lte.memo}</td>
	</tr>
	
	<tr height=18>
	  	<td height="20" align="center" bgColor="#EEEEEE"><strong>附件名称</strong></td>
	  	<td align="left" bgColor="#ffffff" >${lte.lineupname }</td>
	</tr>
	
	<tr height=18>
	  	<td height="20" align="center" bgColor="#EEEEEE"><strong>上传时间</strong></td>
	  	<td align="left" bgColor="#ffffff" >${lte.lineuptime}</td>
	</tr>
	 
	<tr>
		<td height="22" align="center" bgColor="#EEEEEE"><strong>附件下载</strong></td>
		<td align="left" bgColor="#FFFFFF"><div id = "file"></div></td>
	</tr>
 	 
	</tbody>
	</table>
	<table width="30%" align="center">
	<tr> 
		<td>
			<input icon="icon-back" type="button" name="next" value="返    回"  onclick="window.history.back();" >
		</td>
	</tr>
	</table>
	
</body>

<script type="text/javascript">

// 附件
$('#file').uploadFile({
	indexId: '${lte.attachment}',
	module: 's_lineup',
	forbitUpload:true,
	forbitDel:true
}); 
	
</script>

</html>