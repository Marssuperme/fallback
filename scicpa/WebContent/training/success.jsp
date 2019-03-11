<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="STYLESHEET" type="text/css" href="${pageContext.request.contextPath}/CSS/index.css">
<title>报名成功</title>
<style>
td {
	font-size: 12px;
	text-decoration: none;
}

</style>
</head>
<body>
	<table class="indexBox">
		<tr>
			<th align="left" colspan="2">报名结果信息</th>
		</tr>
		
		<tr>
			<td colspan="2">您已经报名成功！生成订单编号为：<font color="red">${orderId }</font></td>
		</tr>
		
		<tr>
			<td colspan="2">
				您需要支付<font color="red">${order.orderAmount}</font>元，您可以选择：
			</td>
		</tr>
		
		<tr>
			<td align="right"></td>
			<td align="left" style="padding-left: 0px;">1、离线支付：请在&nbsp;<font color="red">${map.expenseedate}</font>&nbsp;以前汇款到${map.bank }</td>
		</tr>
		
		<tr>
			<td align="right"></td>
			<td align="left" style="padding-left: 0px;">2、网上支付：<input type="button" class="common" value="在线支付" onclick="pay();" ></td>
		</tr>
		
		<tr>
			<td colspan="2"><font color="red">注意：请确认是否要缴费，已缴费不能退费及取消报名。</font></td>
		</tr>
	</table>
	
	<center>
		<c:choose>
			<c:when test="${userSession.userMap.ctypetabname=='K_Company'}">
				<input type="button" value="返回到培训通知" onclick="back();" >
			</c:when>
			<c:otherwise>
				<input type="button" value="返回到继续教育信息" onclick="back();" >
			</c:otherwise>
		</c:choose>
	</center>
	
	<input type="hidden" id="param" name="param" value="${userSession.userMap.ctypetabname}">
</body>
<script type="text/javascript">
function pay() {
	window.location = "${pageContext.request.contextPath}/common/pay.do?method=payInfo&orderId=${orderId}";
}

function back() {
	var p = document.getElementById("param").value;
	if(p=="K_Company"){
		p = "company";
	}else if(p=="K_Micfo"){
		p = "micfo";
	}else{
		p = "micfono";
	}
	window.location = "${pageContext.request.contextPath}/common/training.do?param="+p;
}

</script>
</html>
