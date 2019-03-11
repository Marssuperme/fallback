<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>缴费列表</title>
</head>
<body>

<div style="padding: 5px;line-height: 150%;font-size: 14px;color: #133db6;">

<mt:DataGridPrintByBean name="orderList"/>

<br/>
<mt:DataGridPrintByBean name="orderList2"/>

</body>

<script type="text/javascript">
function pay(orderId) {
	window.location = "${pageContext.request.contextPath}/common/pay.do?method=payInfo&orderId=" + orderId;
}
</script>
</html>