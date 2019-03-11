<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>缴费统计</title>
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
	
	<mt:DataGridPrintByBean name="expense"/>
	<hr>
	
	<input type="hidden" id="expenseall" name="expenseall" value = "${allMap.expenseall }">
	<table width="100%" border="0" >
	<tr>
		<td  align="right" width="90%" style="font-size: 20px;font-weight: bold">人数：</td>
		<td  align="right" style="font-size: 20px;font-weight: bold;color: blue;">${allMap.countall }</td>
	</tr>
	<tr>
		<td  align="right" style="font-size: 20px;font-weight: bold">合计：</td>
		<td  align="right" style="font-size: 20px;font-weight: bold;color: blue;" >${allMap.expall }</td>
	</tr>
	<tr>
		<td width="" align="right" colspan="2">
			<input icon="icon-save" type="button" name="next" value="缴费"  onclick="save();" >
			<input icon="icon-back" type="button" name="next" value="返回"  onclick="go();" >
		</td>
	</tr>
	</table>
	
	<input type="hidden" name="order" value="${allMap.nid}">
	<input type="hidden" name="amount" value="${allMap.expenseall}">
	<input type="hidden" name="productName" value="培训费">
	<input type="hidden" name="productType" value="培训费">
	<input type="hidden" name="productDesc" value="培训费">
	<input type="hidden" name="productReMark" value="${userSession.userMap.loginid}">
	
</form>
</body>
</html>
<script>
function save(nid){
	document.thisForm.action = "${pageContext.request.contextPath}/common/pay.do?method=payInfo";
	document.thisForm.submit();
}

function go(){
	window.location="${pageContext.request.contextPath}/common/training.do?method=list";

}
</script>