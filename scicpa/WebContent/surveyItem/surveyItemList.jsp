<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>问卷信息</title>
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
</head>
<body>
<form id="thisForm" name="thisForm" method="post" action="">

	<mt:DataGridPrintByBean name="surveyItemList"/>
</form>
</body>
</html>
<script>
// 问卷调查
function joinSurveyItem(id){
	window.open("${pageContext.request.contextPath}/common/surveyItem.do?method=goSurveyItemDetail&id="+id);
	
}
</script>