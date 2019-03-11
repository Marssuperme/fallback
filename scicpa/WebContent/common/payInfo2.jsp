<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="STYLESHEET" type="text/css" href="${pageContext.request.contextPath}/CSS/index.css">
<link rel="STYLESHEET" type="text/css" href="${pageContext.request.contextPath}/pay/pay.css">
<title>选择付款方式</title>
</head>
<body style="padding: 0px;margin: 0px;">

<table align="center" class="indexList" style="width: 100%" border="0" cellspacing="0">
	<tr>
		<td>
			<font style="font-size: 20px;">暂不支持网上支付！ </font>
		</td>
	</tr>
</table>

<!-- 暂时隐藏，不用网上支付功能 -->
<div style="display: none">
<ul class="payStep">
	<li class="curr">1.选择付款方式</li>
	<li>2.在线支付</li>
	<li class="last">3.完成</li>
</ul>

<br/><br/>
<form name="thisForm" id="thisForm" action="${pageContext.request.contextPath}/common/pay.do?method=pay" method="post">
	<input type="hidden" name="order" value="${pay.order}">
	<input type="hidden" name="amount" value="${pay.amount}">
	<input type="hidden" name="productName" value="${pay.productName}">
	<input type="hidden" name="productType" value="${pay.productType}">
	<input type="hidden" name="productDesc" value="${pay.productDesc}">
	<input type="hidden" name="productReMark" value="${pay.productReMark}">

<table align="center" class="indexList" style="width: 100%" border="0" cellspacing="0">
	<tr>
		<th align="left" colspan="2">订单信息：</th>
	</tr>
	
	<tr>
		<td align="right" width="100">订单号：</td>
		<td>&nbsp;${pay.order }</td>
	</tr>
	
	<tr>
		<td align="right" width="100">订单日期：</td>
		<td>&nbsp;${order.orderDate }</td>
	</tr>
	
	<tr>
		<td align="right">支付金额：</td>
		<td>&nbsp;${pay.amount }</td>
	</tr>
	
	<tr>
		<td align="right">订单内容：</td>
		<td>&nbsp;${pay.productName }</td>
	</tr>
	<!-- 
	<tr>
		<td align="right">商品类型：</td>
		<td>&nbsp;${pay.productType }</td>
	</tr>
	
	<tr>
		<td align="right">商品描述：</td>
		<td>&nbsp;${pay.productDesc }</td>
	</tr>
	
	<tr>
		<td align="right">商品备注：</td>
		<td>&nbsp;${pay.productReMark }</td>
	</tr>
	 -->
</table>

<table align="center" class="indexBox" style="width: 100%;">
	<tr>
		<th align="left" >选择付款方式：</th>
	</tr>
	
	<tr>
		<td>
			<input type="radio" checked="checked" value="" name="frpId">
			<img alt="易宝支付" src="${pageContext.request.contextPath}/pay/yeepay.jpg"  />	
		</td>
	</tr>
</table>
<br/><br/>
<center>
	<input type="button" value="确 定" onclick="check();">&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="返 回" onclick="history.back();">
</center>


</div>

</body>

<script type="text/javascript">
function check() {
	document.thisForm.submit(); 
}
</script>
</html>