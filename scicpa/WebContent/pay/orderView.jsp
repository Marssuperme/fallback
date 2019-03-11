<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="STYLESHEET" type="text/css" href="${pageContext.request.contextPath}/CSS/index.css">
<title>支付信息</title>
</head>

<body>

<table align="center" class="indexList" style="width: 80%" border="0" cellspacing="0">
	<tr>
		<th align="left" colspan="2">订单信息：</th>
	</tr>
	
	<tr>
		<td align="right" width="100">订单号：</td>
		<td>&nbsp;${order.orderId }</td>
	</tr>
	
	<tr>
		<td align="right" width="100">订单日期：</td>
		<td>&nbsp;${order.orderDate }</td>
	</tr>
	
	<tr>
		<td align="right" width="100">订单内容：</td>
		<td>&nbsp;${order.orderContent }</td>
	</tr>
	
	<tr>
		<td align="right" width="100">订单金额：</td>
		<td>&nbsp;${order.orderAmount }</td>
	</tr>
</table>
	
<form name="thisForm" action="${pageContext.request.contextPath}/common/pay.do?method=payInfo" method="post">
	<input type="hidden" name="order" value="${order.orderId }">
	<input type="hidden" name="amount" value="${order.orderAmount }">
	<input type="hidden" name="productName" value="${order.orderContent }">
	<input type="hidden" name="productType" value=""><br/>
	<input type="hidden" name="productDesc" value="">
	<input type="hidden" name="productReMark" value="">
</form>

<br/><br/>
<center>
	<input type="button" value="下一步" onclick="check();">&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="返回" onclick="history.back();">
</center>

</body>
<script type="text/javascript">
function check() {
	document.thisForm.submit(); 
}
</script>
</html>
