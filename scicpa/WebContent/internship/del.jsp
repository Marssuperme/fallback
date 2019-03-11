<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>实习信息</title>
<style>
.formTitle {
	color: #4A74BC;
	font-weight: bold;
	font-size: 14px;
	text-align:center;
	width:100%;
	margin-top: 10px;
}

</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css"/>
</head>
<body>
<form name="thisForm" method="post" action="">

	
	<input type="button" icon='icon-delete' value="删除" onclick="goDel();">
	
	<input type="button" icon='icon-back' value="返回" onclick="go()">
	
	<mt:DataGridPrintByBean name="delList"/>
</form>
</body>
</html>
<script>

/*返回*/
function go(){
	window.location="${pageContext.request.contextPath}/common/internship.do";
}

/*删除*/
function goDel(){
	var chooseValue = document.getElementById("chooseValue_delList").value;
	
	if(chooseValue =="") {
		alert("请选择要删除的菜单项！");
	}else {
		if(confirm("您的操作可能会造成数据丢失，您确定要删除该记录吗？","提示")){
			document.thisForm.action = "${pageContext.request.contextPath}/common/internship.do?method=del&loginid=${userSession.userMap.loginid}&chooseValue="+chooseValue;
			document.thisForm.submit();
		}
	}
}
</script>

