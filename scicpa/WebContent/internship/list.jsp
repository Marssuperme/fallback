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

	
<c:if test="${ctypetabname == 'k_company'}">
	<input type="button" icon='icon-add' value="增加" onclick="goAdd();">
	<input type="button" icon='icon-delete' value="删除" onclick="goDel();">
</c:if>	

<!-- <input type="button" icon='icon-query' value="查看" onclick="goView();"> -->
	
	<mt:DataGridPrintByBean name="topicList"/>
</form>
</body>
</html>
<script>
/*增加*/
function goAdd(){
	window.location="${pageContext.request.contextPath}/common/internship.do?method=add";
}

/*查看*/
function goView(chooseValue){
/*
	var chooseValue = document.getElementById('chooseValue_topicList').value ;
	if(chooseValue == "") {
		alert("请选择你要查看的实习信息!");
		return false ;
	}
*/	
	window.location="${pageContext.request.contextPath}/common/internship.do?method=view&topicid="+chooseValue;
}

/*删除*/
function goDel(){
	window.location="${pageContext.request.contextPath}/common/internship.do?method=indexdel&loginid=${userSession.userMap.loginid}"
}
</script>

