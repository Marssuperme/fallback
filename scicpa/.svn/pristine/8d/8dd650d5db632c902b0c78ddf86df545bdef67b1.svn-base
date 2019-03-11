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
<table width="90%" height="30%" border="0" cellpadding="0" align="center" cellspacing="1" bgcolor="#6595d6">
<tr>
	<td align="center" valign="top" bordercolor="#CCCCCC" bgcolor="#FFFFFF"> 
		<div style="margin-top: 10px;margin-bottom: 10px;text-align: center;"><font style="font-size: 16px;">监  管  底  稿  信  息</font></div> 
			<table width="98%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#6595d6">
				<tr height=18>
				  	<td height="20" width="30%" align="right" bgColor="#EEEEEE"><strong>底稿名称：</strong></td>
				  	<td align="left" bgColor="#ffffff" >${lte.lineupname }</td>
				</tr> 
				
				<tr height=18>
				  	<td height="20" align="right" bgColor="#EEEEEE"><strong>上传时间：</strong></td>
				  	<td align="left" bgColor="#ffffff" >${lte.lineuptime}</td>
				</tr>
				 
				<tr>
					<td height="22" align="right" bgColor="#EEEEEE"><strong>底稿下载：</strong></td>
					<td align="left" bgColor="#FFFFFF"><div id = "file"></div></td>
				</tr>
			</table>
			<table width="30%" align="center" style="margin-top: 10px;">
				<tr> 
					<td>
						<input icon="icon-back" type="button" name="next" value="返    回"  onclick="f_back();" >
					</td>
				</tr>
			</table>
	</td>
</tr>
</table>
	
	
</body>

<script type="text/javascript">

// 监管底稿上报
// 附件
$('#file').uploadFile({
	indexId: '${lte.attachment}',
	module: 's_lineup',
	forbitUpload:true,
	forbitDel:true
}); 
	

function f_back(){
	var source = "${source}";
	// 监管作业链接过来的
	if(source=="jgdgsb"){
		window.location = "${pageContext.request.contextPath}/common/supervision.do?method=goSupervision&type=jgdgsb";
	}else{
		window.history.back();
	}
}

</script>

</html>