<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>所属会员信息</title> 
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

.mustSpan {
	color: #FF6600;
	font-family: "宋体";
	font: normal;
	font-size: 9pt;
	padding: 0px;
	margin: 0px;
}
 
 #tb {background-color: #ffffff;text-align: center;border:#d1dfbb 1px solid;border-collapse:collapse;text-align:center;width:90%;margin:20 0px;}
	#tb td{white-space:nowrap;padding: 1px;border-top: #d1dfbb 1px solid;border-left: #d1dfbb 1px solid;height:30px;}
	#tb input{border:0px;border-bottom:1px solid #aaa;width:100%;margin:0 10px; }
 
 
</style>
<style>
	H3.tabs {
	PADDING-LEFT: 0px! important; HEIGHT: 26px; BACKGROUND-COLOR: #e8f7fc! important
	}
	.tab {
		BORDER-RIGHT: #c1d8e0 1px solid; PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FONT-WEIGHT: normal; FLOAT: left; PADDING-BOTTOM: 0px; CURSOR: pointer; PADDING-TOP: 0px
	}
	.curtab {
		FONT-WEIGHT: bold; BACKGROUND: #fff; BORDER-RIGHT-COLOR: #b2c9d3
	}
	.block {
	BORDER-RIGHT: #b2c9d3 1px solid; BORDER-TOP: #b2c9d3 1px solid; BACKGROUND: #fff; MARGIN: 0px 0px 6px; BORDER-LEFT: #b2c9d3 1px solid; BORDER-BOTTOM: #b2c9d3 1px solid
	}
	.block H3 {
		PADDING-LEFT: 0.5em; FONT-SIZE: 1em; BACKGROUND: url(../images/dotline_h.gif) repeat-x 50% bottom; MARGIN: 1px 0px 0px; COLOR: #5086a5; LINE-HEIGHT: 26px
	}
	.block H3 A {
		COLOR: #5086a5
	}
	
	.before{
		border: 0px;
	}
	.after{
		border: 1px solid;
	}
</style> 
</head>
<body onload="f_init()">

<form name="thisForm" method="post" action="" id="thisForm" >
<input type="hidden" id="userid" name="userid" >
<input type="hidden" id="isyearcheck" name="isyearcheck" >
<input type="hidden" id="iyear" name="iyear" >
<input type="hidden" id="noyearcheckreason" name="noyearcheckreason" >
<input type="hidden" id="ID" name="ID" >
	<center class="formTitle" > 
		所&nbsp;&nbsp;&nbsp;属&nbsp;&nbsp;&nbsp;CPA&nbsp;&nbsp;&nbsp;学&nbsp;&nbsp;&nbsp;时&nbsp;&nbsp;&nbsp;信&nbsp;&nbsp;&nbsp;息<br />
	</center>

<DIV class=block id=search style="width:100%">

<H3 class=tabs id=searchtabs>
<!-- <A class="tab curtab" id=dgxxtab href="javascript:setTab('search','dgxx')">单位信息</A> -->
<A class="tab curtab" id=cpatab href="javascript:setTab('search','cpa')">所属CPA学时信息</A> 
<!-- <A class="tab " id=micfonotab href="javascript:setTab('search','micfono')">非执业会员年检</A> -->
</H3>



<div class=tabcontent id="dgxx" style="display: none;text-align:center;width: 100%">

<table style="WIDTH: 100%" class="data_tb" align="center">

    <tr>
      <td class="data_tb_alignright" width="50%" style="text-align: left;" colspan="4"><b>基础资料</b></td>
    </tr>
    <tr>
      <td class="data_tb_alignright" width="20%">事务所名称</td>
      <td class="data_tb_content" width="30%"  height="18" colspan="3">${userMap.loginname }</td>
    </tr>
    <tr>
      <td class="data_tb_alignright" width="20%">事务所代码</td>
      <td class="data_tb_content" width="30%">${userMap.officecode}</td>
      <td class="data_tb_alignright" width="20%">注册资金</td>
      <td class="data_tb_content" width="30%">${userMap.capital}</td>
    </tr>
    <tr>
      <td class="data_tb_alignright">组织形式</td>
      <td class="data_tb_content">${userMap.organization}</td>
      <td class="data_tb_alignright">所在城市</td>
      <td class="data_tb_content">${userMap.address}</td>
    </tr>
    <tr>
      <td class="data_tb_alignright">成立批准时间</td>
      <td class="data_tb_content">${userMap.approval}</td>
      <td class="data_tb_alignright">成立批准文号</td>
      <td class="data_tb_content">${userMap.approvalnumber}</td>
    </tr>
    <tr>
      <td class="data_tb_alignright">税务登记号</td>
      <td class="data_tb_content">${userMap.tax }</td>
      <td class="data_tb_alignright">成立批准机关</td>
      <td class="data_tb_content">${userMap.approvalauthority}</td>
    </tr>
    <tr>
      <td class="data_tb_alignright">工商登记日期</td>
      <td class="data_tb_content">${userMap.businesstime}</td>
      <td class="data_tb_alignright">工商登记号</td>
      <td class="data_tb_content">${userMap.business}</td>
    </tr>
    <tr>
      <td class="data_tb_alignright">法人代表</td>
      <td class="data_tb_content">${userMap.corporate}</td>
      <td class="data_tb_alignright">法人代表手机号</td>
      <td class="data_tb_content">${userMap.corporatephone}</td>
    </tr>
   
</table>

</div>


<div id="divBlock" style="position:absolute;width:100%;height:500px; top:expression(this.offsetParent.scrollTop); z-index:1; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;">
</div>

<div id="query" style="position:absolute;width:100%;height:500px; top:expression(this.offsetParent.scrollTop); z-index:1; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;">
</div>

<div id="tzf" style="position:absolute;width:70%;height:60%; z-index:2;left:expression((document.body.clientWidth-750)/2);top:expression(this.offsetParent.scrollTop + 130); border:1px solid #6595d6; padding:1px; background:#ffffff;text-align:center; display: none;">
   <div style="overflow: auto;height: 70%">
   <table id="tb" >
   	<tr>
   		<td style="text-align: center;">cpa号</td>
   		<td style="text-align: center;">姓名</td>
   		<td style="text-align: center;">未参加原因</td>
    </tr>
    <c:forEach items="${list}" var="list">
	    <tr id="${list.cpaid }">
	    	<td width="20%" style="text-align: center;">${list.cpaid}<input type="hidden" id="${list.cpaid }s2" name="${list.cpaid }s2" value="${list.id }" /></td>
	   		<td width="20%" style="text-align: center;">${list.loginname}<input type="hidden" id="${list.cpaid }s3" name="${list.cpaid }s3" value="${list.iyear }" /></td>
	   		<td width="60%"><textarea id="${list.cpaid }s1" name="${list.cpaid }s1" rows="2" cols="60">${list.noyearcheckreason}</textarea></td>
	    </tr>
    </c:forEach>
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
		<span style="vertical-align: top;">年份：<input id="nianfen" name="nianfen" onfocus="onPopDivClick(this);" 
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
    </div>
	<!-- CPA信息 -->
	<div style="overflow: scroll;width: 100%;height:800px;">
	<mt:DataGridPrintByBean name="inspection"/>
	</div>
</div>

<div class=tabcontent id="micfono" style="text-align: center; display: none;">
<!-- 非执业会员 -->

</div>

<div id="querycontent" style="position:absolute;width:85%;height:20%; z-index:2;left:expression((document.body.clientWidth-850)/2);top:expression(this.offsetParent.scrollTop + 130); border:1px solid #6595d6; padding:1px; background:#ffffff; display: none;">
<br>
<pre>
	※年检规则：
		举例2011年今年年检：

		1.学时通过：
		1)学时通过规则：
		A. 2009年前年学时通过   2009年学时不少于30个学时（包括等于）；
		B. 2010年上年学时通过   2010年学时不少于30个学时；
		C. 2009年和2010年两年学时通过  2009+2010不少于80个学时。

		2)批准时间规则：
		A注师“批准时间”为2009年6月30日之前（包括6月30日）：需要完成A、B、C 3项是否通过的检查；
		B注师“批准时间”为2009年7月1日到2010年6月30日：需要完成B 1项是否通过的检查，A、C 2项无条件通过；
		C注师“批准时间”为2010年7月1日到2010年12月31日：不需要完成任何1项都为学时通过，A、B、C 3项无条件通过；
		D注师“批准时间”为2011年1月1日之后，不显示。        

		2.2011年今年缴纳会费为是，要事务所在会费填报登记了会费，市注协确认了会费，“是否确认缴费”为“已缴费”，才为“是”。

		前2项为通过，自检结果才为通过。<font color="red">自检结果非最终结果，以省注协发文为准。</font>
</pre>
<center><input icon="icon-delete" type="button" value="关  闭" onclick="f_close()"/></center>
<br>
</div>


</DIV>
</form>
	

</body>
</html>
<script type="text/javascript">

// 处理默认值
var tempYear = "${iyear}";
document.getElementById("nianfen").value = tempYear;
 
//显示
function setTab(area,id) {
	var tabArea=document.getElementById(area);
	var contents=tabArea.childNodes;
	for(i=0; i<contents.length; i++) {
		if(contents[i].className=='tabcontent'){contents[i].style.display='none';}
	}
	document.getElementById(id).style.display='';
	var tabs=document.getElementById(area+'tabs').getElementsByTagName('a');
	
	for(i=0; i<tabs.length; i++) { 
		tabs[i].className='tab'; 
	}
	document.getElementById(id+'tab').className='tab curtab';
	document.getElementById(id+'tab').blur();
	
}


// 设置值
function f_sure(p){
	document.getElementById("noyearcheckreason").value = "";
	document.getElementById("ID").value = "";
	var userid = document.getElementById("userid").value;			// 用户编号
	var iyear = document.getElementById("iyear").value;			// 用户编号
	var isyearcheck = document.getElementById("isyearcheck").value;			// 是否选中 
	var noyearcheckreason = document.getElementById("noyearcheckreason").value;			// 原因 
	var ID = document.getElementById("ID").value;			// ID 
	var ycn = document.getElementsByName("yearcheckName");		// 复选框  list
	for(var i = 0;i<ycn.length;i++){
		if(ycn[i].checked){
			isyearcheck = isyearcheck + ",是";
		}else{
			if(document.getElementById(ycn[i].value+"s1").value=="" 
				|| document.getElementById(ycn[i].value+"s1").value == null
				|| document.getElementById(ycn[i].value+"s1").value.length<1
				){
					alert("请填写为参加年检原因!");
					document.getElementById(ycn[i].value+"s1").select();
					return;
			}
			isyearcheck = isyearcheck + ",否";
			noyearcheckreason = noyearcheckreason + "," +document.getElementById(ycn[i].value+"s1").value;
			ID = ID + "," + document.getElementById(ycn[i].value+"s2").value;
		}
		iyear = iyear + "," + document.getElementById(ycn[i].value+"s3").value;
		userid = userid + "," + ycn[i].value;
	}

	document.getElementById("userid").value = userid.substring(1,userid.length);
	document.getElementById("isyearcheck").value = isyearcheck.substring(1,isyearcheck.length);
	document.getElementById("iyear").value = iyear.substring(1,iyear.length);
	document.getElementById("noyearcheckreason").value = noyearcheckreason.substring(1,noyearcheckreason.length);
	document.getElementById("ID").value = ID.substring(1,ID.length);
	var state=document.getElementById("state").value;
	if(p=="sure"){
		if(confirm("您确定以上注师不参加年检吗?")){
			document.thisForm.action = "${pageContext.request.contextPath}/common/inspection.do?method=updateYearCheck&state='"+state+"'";			
			document.thisForm.submit();
		}
	}else{
		document.thisForm.action = "${pageContext.request.contextPath}/common/inspection.do?method=updateYearCheck";
		document.thisForm.submit();
	}
	
}


// 全选反选 
function f_check(p){
	var ycn = document.getElementsByName("yearcheckName");		// 复选框  list
	for(var i = 0;i<ycn.length;i++){
		ycn[i].checked = p.checked;
	}
}

 
// 提交 
function f_submit(){
	var ycn = document.getElementsByName("yearcheckName");		// 复选框  list
	var p = "Y";
	for(var i = 0;i<ycn.length;i++){
		if(ycn[i].checked == true){
			document.getElementById(ycn[i].value).style.display="none";
		}else{
			document.getElementById(ycn[i].value).style.display="";
			p = "N";
		}
	}
	
	if(p=="N"){
		document.getElementById("divBlock").style.display="";
		document.getElementById("tzf").style.display = "";
	}

	if(p=="Y"){
		if(confirm("您确定所有注师都参加年检吗?")){
			f_sure('submit');
		}
	}
	
}

//取消
function f_qx(){	
	 document.getElementById("divBlock").style.display="none";
	 document.getElementById("tzf").style.display = "none";
	  
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
	document.thisForm.action = "${pageContext.request.contextPath}/common/inspection.do?method=company1";
	document.thisForm.submit();
}

var date = new Date();
var year = date.getYear();
var iyear = "${iyear}";
if(year!=iyear){
	var ycn = document.getElementsByName("yearcheckName");		// 复选框  list
	for(var i = 0;i<ycn.length;i++){
		ycn[i].disabled = "disabled";
	}
}
  

// 查看年检规则 
function f_query(){
	document.getElementById("query").style.display = "";
	document.getElementById("querycontent").style.display = "";
}

// 关闭
function f_close(){
	document.getElementById("query").style.display = "none";
	document.getElementById("querycontent").style.display = "none";
}


    
</script>
