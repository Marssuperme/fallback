<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>test</title>
</head>

<body>

<form action="${pageContext.request.contextPath}/common/pay.do?method=payInfo" method="post">
	订单号：<input type="text" name="order" value="1000022123"><br/>
	支付金额：<input type="text" name="amount" value="220.00"><br/>
	商品名：<input type="text" name="productName" value="XX费用"><br/>
	商品类型：<input type="text" name="productType" value="考试"><br/>
	商品描述：<input type="text" name="productDesc" value="2010年CPA考试"><br/>
	商品备注：<input type="text" name="productReMark" value="没有备注信息"><br/>

	<input type="submit" >
</form>

</body>

</html>
