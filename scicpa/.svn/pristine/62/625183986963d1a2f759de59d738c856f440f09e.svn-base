<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="STYLESHEET" type="text/css" href="${pageContext.request.contextPath}/CSS/index.css">
<link rel="STYLESHEET" type="text/css" href="${pageContext.request.contextPath}/pay/pay.css">
<title>支付成功</title>
</head>
<body style="padding: 0px;margin: 0px;">
<ul class="payStep">
	<li class="complete">1.选择付款方式</li>
	<li class="complete">2.在线支付</li>
	<li class="curr last">3.完成</li>
</ul>

<br/><br/>

<table align="center" class="indexBox" style="width: 100%" border="0" cellspacing="0">
	<tr>
		<th align="left" colspan="2">支付结果</th>
	</tr>
	
	<tr>
		<td align="right">交易结果：</td>
		<td align="left">&nbsp;${result }</td>
	</tr>
	
	<tr>
		<td align="right" >订单号：</td>
		<td align="left">&nbsp;${orderId }</td>
	</tr>
	
	<tr>
		<td align="right">支付金额：</td>
		<td align="left">&nbsp;${amount }</td>
	</tr>
	
	<tr>
		<td align="right">易宝支付交易流水号：</td>
		<td align="left">&nbsp;${serialNumber }</td>
	</tr>
	
</table>

<br/><br/>
<center>
	<input type="button" value="关闭窗口" onclick="window.close();">
</center>

</body>
</html>