<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>法律法规全文搜索</title>

</head>

<body onload="isChecked()">

<form name="thisForm" method="post" action="${pageContext.request.contextPath}/common/policy.do?method=search" onsubmit="return search();">
<input type="hidden" name="typeId" value="${typeId }">
<br>
<table width="97%" border="0" cellpadding="0" cellspacing="0">
	<tr height="20"> 
		<td style="width: 20%" align="right"><font style="font-weight: bold">法律法规搜索条件：</font></td>
		<td style="width: 30%" align="left"> 
			<input style="border:1px solid #6595d6;width: 95%" name="searchArea" id="searchArea" type="text" maxlength="50" value="${searhArea}" />
		</td>
		<td style="width: 10%" align="left"> 
			<input name="searchB" type="button" icon="icon-config" id="searchB" onclick="search();" value="确  定" />
		</td>
		<td style="width: 40%" align="left" id="Policy_title" valign="top" >包括：&nbsp;&nbsp; 
			<input name="title" id="title" type="checkbox" value="checkbox" style="border:none"/><label for="title">标题</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
			<span style="display:none;">
				<input type="checkbox" name="content" id="content"  style="border:none"	value="checkbox" /> <label for="content">内容</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<input type="checkbox"  style="border:none"	name="wordNum" id="wordNum" value="checkbox" /> 文号&nbsp;&nbsp;
				<input  style="border:none"	type="checkbox" name="sendDepartment" id="sendDepartment" value="checkbox" /><label for="sendDepartment">发文机关</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</span>
			<input type="hidden" name="page" id="page" value="${page}">
		</td>
	</tr>
</table>
<br/>  
<div style="height:expression(document.body.clientHeight-80);overflow:auto;">

<c:if test="${totalCount >0}">
	<table width="97%" style="border-collapse:collapse;align:center">
		<tr bgColor="#F0F7F9" height="24px">
			<td align="center"> 约有${totalCount}项符合 <font color="red">${searhArea}</font> 的查询结果，以下是第${from} 到 ${to} 项</td>
		</tr>
	</table>
	<br/>
	<table>
		<tr>
			<td>
				${resultHTML}
			</td>
		</tr>
	</table>
	<br/>
	${pageInfo}
</c:if>

<c:if test="${totalCount ==0}">
	<table width="97%" style="border-top:1px solid #6595d6;border-collapse:collapse;align:center">
		<tr bgColor="#F0F7F9" height="24px">
			<td align="center">搜索不到任何记录，请更改搜索条件重试！</td>
		</tr>
	</table>
	<br/>
</c:if>
</div>
<input type="hidden" name="srAbout" value="" /></form>
</body>

<script>
if ("${srAbout}".indexOf("title") >= 0) {
	thisForm.title.checked = true
}
if ("${srAbout}".indexOf("content") >= 0) {
	thisForm.content.checked = true
}
if ("${srAbout}".indexOf("wordNum") >= 0) {
	thisForm.wordNum.checked = true
}
if ("${srAbout}".indexOf("sendDepartment") >= 0) {
	thisForm.sendDepartment.checked = true
}
function search()
{
	if(thisForm.searchArea.value=='')
	{
		return false;
	}
	var srAbout = "";
	if(thisForm.title.checked == true)
	{
		srAbout = srAbout + "title,";
	}
	if(thisForm.content.checked == true)
	{
		srAbout = srAbout + "content,";
	}
	if(thisForm.wordNum.checked == true)
	{
		srAbout = srAbout + "wordNum,";
	}
	if(thisForm.sendDepartment.checked == true)
	{
		srAbout = srAbout + "sendDepartment,";
	}
	
	if(srAbout.length<6)
	{
		alert("请至少选择一个条件！");
		return false;
	}
	thisForm.srAbout.value = srAbout;
	thisForm.submit();
	
}

function isChecked(){
    if(document.getElementById("title").checked!=true&&document.getElementById("content").checked!=true&&document.getElementById("wordNum").checked!=true&&document.getElementById("sendDepartment").checked!=true){
       setChecked();
    } 	
}

function setChecked(){
	document.getElementById("title").checked=true;
	//document.getElementById("content").checked=true;
}

function goTo(page) {
	document.getElementById("page").value = page;
	if(thisForm.searchArea.value=='')
	{
		return false;
	}
	var srAbout = "";
	if(thisForm.title.checked == true)
	{
		srAbout = srAbout + "title,";
	}
	if(thisForm.content.checked == true)
	{
		srAbout = srAbout + "content,";
	}
	if(thisForm.wordNum.checked == true)
	{
		srAbout = srAbout + "wordNum,";
	}
	if(thisForm.sendDepartment.checked == true)
	{
		srAbout = srAbout + "sendDepartment,";
	}
	
	if(srAbout.length<6)
	{
		alert("请至少选择一个条件！");
		return false;
	}
	thisForm.srAbout.value = srAbout;
	document.thisForm.submit();
}
</script>
</html>
