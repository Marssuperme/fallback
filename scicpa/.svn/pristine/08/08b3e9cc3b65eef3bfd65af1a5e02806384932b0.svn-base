<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>党群新闻</title>
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
<form name="thisForm" method="post" action="">
<c:if test="${ctypetabname == 'k_company'}">
	<input type="button" icon='icon-edit' value="操作" onclick="goDel();">
</c:if>		
	
	
	<mt:DataGridPrintByBean name="newList"/>
</form>
</body>
</html>
<script>
/*查看*/
function goView(chooseValue){
	//alert(chooseValue);
	window.location="${pageContext.request.contextPath}/common/new.do?method=view&nid="+chooseValue;
}


function goDel(){
	window.location="${pageContext.request.contextPath}/common/new.do?method=indexdel";
}

</script>