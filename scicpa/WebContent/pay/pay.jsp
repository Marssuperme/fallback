<%@page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<html>
<head>
<script>
	var CONTEXT_PATH = "${pageContext.request.contextPath}" ;
</script>

<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link rel="STYLESHEET" type="text/css" href="${pageContext.request.contextPath}/CSS/index.css">
<link rel="STYLESHEET" type="text/css" href="${pageContext.request.contextPath}/CSS/button.css">
<link rel="STYLESHEET" type="text/css" href="${pageContext.request.contextPath}/CSS/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/jquery.js"  ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/button.js"></script>
<link rel="STYLESHEET" type="text/css" href="${pageContext.request.contextPath}/pay/pay.css"> 

<title>选择付款方式</title>
</head>

<body style="padding: 0px;margin: 0px;">
<div id="divBlock" style="position:absolute;width:100%;height:100%; top:expression(this.offsetParent.scrollTop)-300; z-index:1; padding:10px; background:#CCCCCC;filter:alpha(opacity=50); text-align:center; display:none;">
	</div>
	<div id="divInfo" style="position:absolute;width:400px;height:250px; z-index:2;left:expression((document.body.clientWidth-400)/2);top:expression((document.body.clientHeight-300)/2 - 300); border:1px solid #6595d6; padding:10px; background:#ffffff;text-align:center; display: none;">
		<BR/><BR/>
		<input type='button' class="flyBT" value='支付完成,返回支付管理' onclick="check();"><BR/><BR/>
		<input type="button" class="flyBT" value="支付失败，重新支付" onclick="hiddenDiv();">
	</div>
<ul class="payStep">
	<li class="complete">1.选择支付方式</li>
	<li class="curr">2.在线支付</li>
	<li>3.完成</li>
</ul>

<br/><br/>
<table align="center" class="indexBox" style="width: 100%" border="0" cellspacing="0">
	<tr>
		<th align="left" colspan="2">支付信息：</th>
	</tr>
		
	<tr>
		<td>
			您本次需要支付共 <font color="red">${p3_Amt}</font> 元,您选择的是通过 <font color="red">易宝支付</font> 进行付款。
		</td>
	</tr>
</table>

<center>
	<form name="yeepay" action="${nodeAuthorizationURL}" method="POST" target="_blank">
		<input type='hidden' name="p0_Cmd"   value="${p0_Cmd}">
		<input type='hidden' name="p1_MerId" value="${p1_MerId}">
		<input type='hidden' name="p2_Order" value="${p2_Order}">
		<input type='hidden' name="p3_Amt"   value="${p3_Amt}">
		<input type='hidden' name="p4_Cur"   value="${p4_Cur}">
		<input type='hidden' name="p5_Pid"   value="${p5_Pid}">
		<input type='hidden' name="p6_Pcat"  value="${p6_Pcat}">
		<input type='hidden' name="p7_Pdesc" value="${p7_Pdesc}">
		<input type='hidden' name="p8_Url"   value="${p8_Url}">
		<input type='hidden' name="p9_SAF"   value="${p9_SAF}">
		<input type='hidden' name="pa_MP"    value="${pa_MP}">
		<input type='hidden' name="pd_FrpId" value="${pd_FrpId}">
		<input type="hidden" name="pr_NeedResponse"  value="${pr_NeedResponse}">
		<input type='hidden' name="hmac"     value="${hmac}">
		
		<input type="submit" value="确  定" onclick="showDiv();" />
		<input type="button" value="返回修改支付方式" onclick="history.back();"/>
					
	</form>
</center>
</body>
<script type="text/javascript">
function check() {
	window.location = "${pageContext.request.contextPath}/common/pay.do?method=orderList"
}

function showDiv() {
	var divObj = document.getElementById("divInfo");
	var blockObj =  document.getElementById("divBlock");

	divObj.style.display = "";
	blockObj.style.display = "";

}

function  hiddenDiv() {
	var divObj = document.getElementById("divInfo");
	var blockObj =  document.getElementById("divBlock");
	divObj.style.display = "none";
	blockObj.style.display = "none";
}
</script>

</html>