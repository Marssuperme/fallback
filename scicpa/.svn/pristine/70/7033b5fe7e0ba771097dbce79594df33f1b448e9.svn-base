<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<%@ page isELIgnored="false" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>非执业会员信息</title> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/main.css"/>

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
<body onload="f_init()">
<div id="divBlock" style="position:absolute;width:100%;height:500px; top:expression(this.offsetParent.scrollTop); z-index:1; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;">
</div>
<form name="thisForm" method="post" action="" id="thisForm" >
<input type="hidden" id="state" name="state" value="${state}">   <!-- 用来判断是否是查询时传来的参数 -->
<input type="hidden" id="isyearcheck" name="isyearcheck">  
<input type="hidden" id="iuser" name="iuser" value="${iuser}">  
<input type="hidden" id="iyear" name="iyear" value="${iyear}">  
	<center class="formTitle" > 
		<font style="font-size: 15px;">非&nbsp;&nbsp;执&nbsp;&nbsp;业&nbsp;&nbsp;年&nbsp;&nbsp;检&nbsp;&nbsp;信&nbsp;&nbsp;息</font><br />
	</center>
	<br>
<DIV class=block id=search style="width:100%">

<div id="tzf" style="position:absolute;width:40%;height:40%; z-index:2;left:expression((document.body.clientWidth-750)/2);top:expression(this.offsetParent.scrollTop + 130); border:1px solid #6595d6; padding:1px; background:#ffffff;text-align:center; display: none;">
   <div style="overflow: auto;height: 60%">
	   <table style="width: 100%;">
		   	<tr>
		   		<td style="text-align: center;">未参加原因</td>
		    </tr>
		    <tr>
		   		<td ><textarea id="noyearcheckreason" name="noyearcheckreason" rows="4" style="width: 100%">${noyearcheckreason}</textarea></td>
		    </tr>
	    </table>
   </div>
   <ul style="list-style: none;">
    <li>
    	<input type="button" value="确  定" onclick="f_sure('sure')"/>
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<input icon="icon-delete" type="button" value="取  消" onclick="f_qx()"/>
    </li>
  </ul>
    	
 </div>  

<div class=tabcontent id="cpa" style="text-align: center; width: 100%">
	<div style="background-color: #e8f7fc ! important;width: 100%;">
		<span style="vertical-align: top;">自检年份：<input id="nianfen" name="nianfen" onfocus="onPopDivClick(this);" 
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												autoWidth="160px"
												norestorehint=true
												autoid=56
												maxlength="4"
												hideresult=true >
												</span>
		<input id="see" icon='icon-search' type='button' onclick="f_search();" value='搜索'>
		<c:if test="${iyear==now}">
	   		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="pass" icon='icon-add' type='button' onclick="f_submit();" value='提交'>
	   	</c:if>
    </div>
	<!-- CPA信息 -->
	<div style="overflow: scroll;width: 100%;height:800px;">
		<mt:DataGridPrintByBean name="inspectionno"/>
	</div>
</div>

</DIV>
</form>
	

</body>
</html>
<script type="text/javascript">

// 处理默认值
var tempYear = "${iyear}";
document.getElementById("nianfen").value = tempYear;
 

// 设置值
function f_sure(p){
	if(p=="sure"){
		if(confirm("您确定不参加年检吗?")){
		    document.getElementById("isyearcheck").value = "否";
			document.thisForm.action = "${pageContext.request.contextPath}/common/inspection.do?method=updateYearCheckMicfono&p=n";			
			document.thisForm.submit();
		}
	}else{
	    document.getElementById("isyearcheck").value = "是";
		document.thisForm.action = "${pageContext.request.contextPath}/common/inspection.do?method=updateYearCheckMicfono&p=y";
		document.thisForm.submit();
	}
	
}

 
// 提交 
function f_submit(){
	var ycn = document.getElementById("yearcheckName");		// 复选框  list
	var p = "N";
	if(ycn.checked == true){
		p = "Y";
	} 
	if(p=="N"){
		document.getElementById("divBlock").style.display = "";
		document.getElementById("tzf").style.display = "";
	}

	if(p=="Y"){
		if(confirm("您确定要参加年检吗?")){
			f_sure('submit');	
		}
	}
	
}

// 隐藏显示  提交按钮 
function f_display(){
	var nianfen = document.getElementById("nianfen").value;
	var date = new Date();
	var year = date.getYear();
	if(nianfen==year){
		document.getElementById("pass").style.display = "";
	}else{
		document.getElementById("pass").style.display = "none";
	}
}

// 搜索 
function f_search(){
	document.thisForm.action = "${pageContext.request.contextPath}/common/inspection.do?method=micfono";
	document.thisForm.submit();
}

var date = new Date();
var year = date.getYear();
var iyear = "${iyear}";
if(year!=iyear){
	var ycn = document.getElementById("yearcheckName");		// 复选框  list
	ycn.disabled = "disabled";
}
  
  
// 取消
function f_qx(){
	document.getElementById("divBlock").style.display = "none";
	document.getElementById("tzf").style.display = "none";
}

    
</script>
