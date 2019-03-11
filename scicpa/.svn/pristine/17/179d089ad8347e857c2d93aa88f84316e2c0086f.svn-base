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
<form action="" method="post" id="thisForm" name="thisForm">
	<input type="hidden" id="attachment" name="attachment" value="${attachment }">
	<input type="hidden" id="source" name="source" value="${source}">
		<br><br>
		<table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#6595d6">
			<tr>
				<td height="22" width="30%" align="center" bgColor="#EEEEEE"><strong>底稿上报</strong></td>
				<td align="center" width="70%" bgColor="#FFFFFF"><a id="file"></a></td>
			</tr>
		</table>
		<br>
		<table width="100%">
			<tr align="center">
				<td colspan="2">
					<input icon="icon-save" type="button" name="next" value="保   存"  onclick="f_save();" >
					<input icon="icon-back" type="button" name="next" value="返    回"  onclick="f_back();" >
				</td>
			</tr>
		</table>
</form>
</body>
<script type="text/javascript">


// 监管底稿上报
// 附件
$('#file').uploadFile({
	indexId: '${attachment}',
	module: 's_lineup',
	forbitUpload:false,
	forbitDel:true
}); 

// 保存
function f_save(){
	thisForm.action = "${pageContext.request.contextPath}/common/lineup.do?method=add";
	thisForm.submit();
}
	
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