<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>监管作业</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/JS/uploadFile.js?v=${modifyDate}"  ></script>

<link rel="stylesheet"	href="${pageContext.request.contextPath}/CSS/main.css" />
<style>
.formTitle {
	color: #4A74BC;
	font-weight: bold;
	font-size: 14px; 
	text-align: center;
	width: 100%;
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

.tools {
		width:100% ;
		height:27px ;
		float:left;
		background-image: url("/Web/images/toolBarBg.gif");
		padding-top: 3px;
		padding-left:5px;
		margin-bottom: 5px;
} 
	
	
</style>
<style>
H3.tabs {
	PADDING-LEFT: 0px ! important;
	HEIGHT: 26px;
	BACKGROUND-COLOR: #e8f7fc ! important
}

.tab {
	BORDER-RIGHT: #c1d8e0 1px solid;
	PADDING-RIGHT: 10px;
	PADDING-LEFT: 10px;
	FONT-WEIGHT: normal;
	FLOAT: left;
	PADDING-BOTTOM: 0px;
	CURSOR: pointer;
	PADDING-TOP: 0px
}

.curtab {
	FONT-WEIGHT: bold;
	BACKGROUND: #fff;
	BORDER-RIGHT-COLOR: #b2c9d3
}

.block {
	BORDER-RIGHT: #b2c9d3 1px solid;
	BORDER-TOP: #b2c9d3 1px solid;
	BACKGROUND: #fff;
	MARGIN: 0px 0px 6px;
	BORDER-LEFT: #b2c9d3 1px solid;
	BORDER-BOTTOM: #b2c9d3 1px solid
}

.block H3 {
	PADDING-LEFT: 0.5em;
	FONT-SIZE: 1em;
	BACKGROUND: url(../images/dotline_h.gif) repeat-x 50% bottom;
	MARGIN: 1px 0px 0px;
	COLOR: #5086a5;
	LINE-HEIGHT: 26px
}

.block H3 A {
	COLOR: #5086a5
}

.before {
	border: 0px;
	background-color: white;
}

.after {
	border: 1px solid;
}
</style>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/index.css" />
</head>
<body>

<iframe src="" id="go"  name="go" style="display: none">
</iframe>
<form id="thisForm" name="thisForm" method="post" action="" >
<center class="formTitle">
&nbsp;&nbsp;监&nbsp;&nbsp;管&nbsp;&nbsp;作&nbsp;&nbsp;业&nbsp;&nbsp;信&nbsp;&nbsp;息<a href="###" style="margin-left: 100px" onclick="goBack();">[返  回]</a> ${info }<br />
<br />
</center>

<DIV class=block id=search style="width: 99%">

<H3 class=tabs id=searchtabs>
<A class="tab curtab" id=dgxxtab href="javascript:setTab('search','dgxx')">检查通知</A> 
<A class="tab" id=sjdwtab href="javascript:setTab('search','sjdw')">检查组成员</A>
<A class="tab" id=zlxztab href="javascript:setTab('search','zlxz')" >资料下载</A>
<A class="tab" id=zxtbtab href="javascript:setTab('search','zxtb')">在线填报</A>
<A class="tab" id=jdgltab href="javascript:setTab('search','jdgl')" >进度管理</A>
<A class="tab" id=xmtbtab href="javascript:setTab('search','xmtb')">项目填报</A>
<A class="tab" id=jzzctab href="javascript:setTab('search','jzzc')">问题汇报</A>
<A class="tab" id=jgdgsbtab href="javascript:setTab('search','jgdgsb')">意见书上报</A>
<A class="tab" id=hfjltab href="javascript:setTab('search','hfjl')">费用填报</A>
<A class="tab" id=zgbgtab href="javascript:setTab('search','zgbg')" style="display: none">整改报告上传</A>
</H3>
 
<!-- 基础信息 -->
<div class=tabcontent id="dgxx" style="text-align: center;">

<table style="WIDTH: 100%" class="data_tb" align="center">
	<tbody>
		<tr> 
			<td class="data_tb_alignright" style="text-align: left;" colspan="4" height="18">
				<b>&nbsp;&nbsp;&nbsp;&nbsp;检&nbsp;查&nbsp;通&nbsp;知</b>
			</td>
		</tr>
		<tr>
			<td class="data_tb_alignright" width="20%" height="18">标题</td>
			<td class="data_tb_content" height="18" colspan="3">${tnt.title }</td>
		</tr>
		<tr>
			<td class="data_tb_alignright" width="20%" height="18">通知正文</td>
			<td class="data_tb_content" width="30%"  height="18" colspan="3">${tnt.acontent }</td>
		</tr>
		<tr>
			<td class="data_tb_alignright"  width="20%" height="18">发起机构</td>
			<td class="data_tb_content"  width="30%" height="18">${tnt.customerID }</td>
			<td class="data_tb_alignright" height="18">发起时间</td>
			<td class="data_tb_content" height="18">${tnt.atime}</td>
		</tr>
		
	 	<!-- 
		<tr>
			<td class="data_tb_alignright" height="18">事务所全称</td>
			<td class="data_tb_content" height="18" colspan="3">${userMap.officename }</td>
		</tr>
		 -->
		 
		<tr>
			<td class="data_tb_alignright" height="18">检查年份</td>
			<td class="data_tb_content" height="18">${tnt.testyear }</td>
			<td class="data_tb_alignright" height="18">检查报名人数上限</td>
			<td class="data_tb_content" height="18">${tnt.testerlimit }</td>
		</tr>
		<tr>
			<td class="data_tb_alignright" height="18">报名截止日期</td>
			<td class="data_tb_content" height="18" colspan="3">${tnt.timelimit }</td>
			 
		</tr>
		 
	</tbody>
</table>
</div>


<!-- 检查组成员 -->
<div class=tabcontent id="sjdw" style="text-align: center; display: none;">
	<mt:DataGridPrintByBean name="checkGroupPersonInfo"/>
</div>	

<!-- 资料下载 -->
<div class=tabcontent id="zlxz" style="text-align: center; display: none;">
	<div class="tools" style="display: none;background-color: #e8f7fc ! important;padding-top:20px; height:60px;margin-bottom: -1px">
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="pass" icon='icon-edit' type='button' onclick="f_downReport()" value='下载事务所自查报告'>
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="pass" icon='icon-add' type='button' onclick="f_downProject()" value='下载事务所项目清单'> 
    </div>
	<mt:DataGridPrintByBean name="zlxzList"/>
</div>	

<!-- 在线填报 -->
<div class=tabcontent id="zxtb" style="text-align: center; display: none;">
	<mt:DataGridPrintByBean name="supTaskList"/>
</div>	

<!-- 进度管理 -->
<div class=tabcontent id="jdgl" style="text-align: center; display: none;">
		<c:if test="${valid=='Y'}">
			<c:if test="${checkPost=='组长'}">
				<div class="tools" style="background-color: #e8f7fc ! important;padding-top:20px; height:60px;margin-bottom: -1px">
			    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="pass" icon='icon-add' type='button' onclick="f_addPlanManage()" value='增加'> 
			    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="pass" icon='icon-edit' type='button' onclick="f_updatePlanManage()" value='修改'>
			    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="pass" icon='icon-delete' type='button' onclick="f_deletePlanManage()" value='删除'>
			    </div>
	    	</c:if>
    	</c:if>
	<mt:DataGridPrintByBean name="jdglList"/>
</div>	

<!-- 项目填报 -->
<div class=tabcontent id="xmtb" style="text-align: center; display: none;">
	<c:if test="${valid=='Y'}">
		<c:if test="${checkPost=='组长'}">
			<div class="tools" style="background-color: #e8f7fc ! important;padding-top:20px; height:60px;margin-bottom: -1px">
		    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="pass" icon='icon-add' type='button' onclick="f_addProjectFill()" value='增加'> 
		    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="pass" icon='icon-edit' type='button' onclick="f_updateProjectFill()" value='修改'>
		    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="pass" icon='icon-delete' type='button' onclick="f_deleteProjectFill()" value='删除'>
		    </div>
    	</c:if>
   	</c:if>
	<mt:DataGridPrintByBean name="projectFillList"/>
</div>	

<!-- 问题汇报 -->
<div class=tabcontent id="jzzc" style="text-align: center; display: none;">
   	<c:if test="${valid=='Y'}">
   		<c:if test="${checkPost=='组长'}">
			<div class="tools" style="background-color: #e8f7fc ! important;padding-top:20px; height:60px;margin-bottom: -1px;">
   				<input id="pass" icon="icon-add" type="button" onclick="f_add();" value="增加">
		    </div>
	   	</c:if>
	</c:if>
   	<!-- 
   		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="pass" icon="icon-query" type="button" onclick="f_view();" value="查看">
   	 --> 
	<mt:DataGridPrintByBean name="supervision"/>
</div>	

<!-- 底稿上报 -->
<div class=tabcontent id="jgdgsb" style="text-align: center; display: none;">
   	<!-- &nbsp;<input id="pass" icon='icon-query' type='button' onclick="f_view2();" value='查看'>  -->
   	<c:if test="${valid=='Y'}">
   		<c:if test="${checkPost=='组长'}">
			<div class="tools" style="background-color: #e8f7fc ! important;padding-top:20px; height:60px;margin-bottom: -1px;">
			    <input id="pass" icon='icon-add' type='button' onclick="f_addlineup();" value='增加'>
			   	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			   	<input id="pass" icon='icon-delete' type='button' onclick="f_deletelineup();" value='删除'>
		    </div>
		 </c:if>
   	</c:if>
	<mt:DataGridPrintByBean name="lineup"/>
</div>		

<!-- 监管费用 -->
<div class=tabcontent id="hfjl" style="text-align: center; display: none;">
   	<c:if test="${valid=='Y'}">
   		<c:if test="${checkPost=='组长'}">
		    <div class="tools" style="background-color: #e8f7fc ! important;padding-top:20px; height:60px;margin-bottom: -1px">
		    	&nbsp;<input id="pass" icon='icon-add' type='button' onclick="f_add1();" value='增加'>
		    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="pass" icon='icon-edit' type='button' onclick="f_update();" value='修改'>
		    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="pass" icon='icon-delete' type='button' onclick="f_delete();" value='删除'>
		    </div>
	    </c:if>
   	</c:if> 
	<mt:DataGridPrintByBean name="hourCostMain"/>
</div>


</DIV>

<input type="hidden" id="companyName" name="companyName" >
<input type="hidden" id="valid" name="valid" value="${valid}" >
</form>


</body>
</html>
<script type="text/javascript">

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
var typeId = "${type}";
if(typeId!=""){
	setTab("search",typeId);
}

//添加
function f_add(){
	document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/supervision.do?method=go&source=jzzc&p=add";
	document.getElementById("thisForm").submit();
}

// 查看
function f_view(id){
	document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/supervision.do?method=viewSupervisionTable&source=jzzc&id="+id;
	document.getElementById("thisForm").submit();
}

//查看  监管工时费用
function goView(id){
	document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/hourCostManage.do?method=goView&source=hfjl&id="+id;
	document.getElementById("thisForm").submit();
}


// 添加
function f_add1(){
	document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/hourCostManage.do?method=addAndEdit&source=hfjl&param=add";
	document.getElementById("thisForm").submit();
}

// 修改
function f_update(){
	var chooseValue = document.getElementById('chooseValue_hourCostMain').value ;
	if(chooseValue==null || chooseValue==""){
		alert("请选择要修改的记录");
	}else{
		document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/hourCostManage.do?method=goView&opt=update&source=hfjl&id="+chooseValue;
		document.getElementById("thisForm").submit();
	}
}

// 删除
function f_delete(){
	var chooseValue = document.getElementById('chooseValue_hourCostMain').value ;
	if(chooseValue==null || chooseValue==""){
		alert("请选择要删除的记录");
	}else{
		if(confirm("确定要删除吗？")){
			document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/hourCostManage.do?method=deleteHourCostManageTable&id="+chooseValue;
			document.getElementById("thisForm").submit();
		}
	}
}


// 底稿  添加 
function f_addlineup(){
	document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/lineup.do?method=repeat&source=jgdgsb&p=add";
	document.getElementById("thisForm").submit();
}

// 删除 
function f_deletelineup(){
	var chooseValue = document.getElementById('chooseValue_lineup').value ;
	if(chooseValue==null || chooseValue==""){
		alert("请选择要删除的记录");
	}else{
		if(confirm("确定要删除吗？")){
			document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/lineup.do?method=delete&id="+chooseValue;
			document.getElementById("thisForm").submit();
		}
	} 
}

// 查看
function f_view2(){
	var chooseValue = document.getElementById('chooseValue_lineup').value ;
	if(chooseValue==null || chooseValue==""){
		alert("请选择要删除的记录");
	}else{
		document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/lineup.do?method=repeat&source=jgdgsb&p=view&id="+chooseValue;
		document.getElementById("thisForm").submit();
	}
}

// 查看 
function goViewLineup(id){
	document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/lineup.do?method=repeat&p=view&id="+id;
	document.getElementById("thisForm").submit();
}


// 返回
function goBack(){
	document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/supervision.do?method=testerNoticeList";
	document.getElementById("thisForm").submit();
}


// 下载事务所自查报告
function f_downReport(){
	alert("不存在自查报告，无法下载!");
}

// 下载事务所项目清单
function f_downProject(){
	alert("不存在项目清单，无法下载!");
}


// 下载自查报告
function downReport(testyear,companyid,companyname,state){
	var checkPost = "${checkPost}";
	if(checkPost=="组长"){
		if(state!="已下发"){
			alert("该检查方案的自查报告还未下发，无法下载！");
		}else{
			document.getElementById("companyName").value = companyname;
			document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/supervision.do?method=downReport&companyid="+companyid+"&testyear="+testyear;
			document.getElementById("thisForm").submit();
		}
	}else{
		alert("只能组长下载，要下载请联系组长！");
	}
}

// 导出项目清单
/*
function downProject(testyear,companyid,loginname,state){



	var checkPost = "${checkPost}";
	if(checkPost=="组长"){
		if(state!="已下发"){
			alert("该检查方案的项目清单还未下发，无法下载！");
		}else{
			document.getElementById("go").src = "${pageContext.request.contextPath}/common/supervision.do?method=expExcel&testyear="+testyear+"&companyid="+companyid+"&loginname="+loginname;
		}
	}else{
		alert("只能组长下载，要下载请联系组长！");
	}
}*/

// 导出项目清单
function downProject(companyid,loginname,state){

	var startime = "${startime}";
	var endtime = "${endtime}";
	alert(startime + "<--->" + endtime);


	var checkPost = "${checkPost}";
	if(checkPost=="组长"){
		if(state!="已下发"){
			alert("该检查方案的项目清单还未下发，无法下载！");
		}else{
			document.getElementById("go").src = "${pageContext.request.contextPath}/common/supervision.do?method=expExcel&startime="+startime+"&endtime="+endtime+"&companyid="+companyid+"&loginname="+loginname;
		}
	}else{
		alert("只能组长下载，要下载请联系组长！");
	}
}


//====== 在线填报 ========//
// 查看
function goViewSupTask(chooseValue){
	window.location="${pageContext.request.contextPath}/common/supTask.do?method=viewSupTask&source=zxtb&id="+chooseValue;
}


//====== 进度管理 ========//
// 添加
function f_addPlanManage(){
	document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/planManage.do?method=go&source=jdgl&opt=add";
	document.getElementById("thisForm").submit();
} 

// 修改
function f_updatePlanManage(){
	var chooseValue = document.getElementById('chooseValue_jdglList').value ;
	
	if(chooseValue==null || chooseValue==""){
		alert("请选择要修改的记录!");
	}else{
		document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/planManage.do?method=go&source=jdgl&opt=update&id="+chooseValue;
		document.getElementById("thisForm").submit();
	}
	
}
// 删除
function f_deletePlanManage(){
	var chooseValue = document.getElementById('chooseValue_jdglList').value ;
	
	if(chooseValue==null || chooseValue==""){
		alert("请选择要删除的记录!");
	}else{
		if(confirm("您确定要删除吗？")){
			document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/planManage.do?method=delete&id="+chooseValue;
			document.getElementById("thisForm").submit();
		}
	}
}
   



//====== 项目填报 ========//
// 添加
function f_addProjectFill(){
	document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/projectFill.do?method=go&source=xmtb&opt=add";
	document.getElementById("thisForm").submit();
} 

// 修改
function f_updateProjectFill(){
	var chooseValue = document.getElementById('chooseValue_projectFillList').value ;
	
	if(chooseValue==null || chooseValue==""){
		alert("请选择要修改的记录!");
	}else{
		document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/projectFill.do?method=go&source=xmtb&opt=update&id="+chooseValue;
		document.getElementById("thisForm").submit();
	}
	
}
// 删除
function f_deleteProjectFill(){
	var chooseValue = document.getElementById('chooseValue_projectFillList').value ;
	
	if(chooseValue==null || chooseValue==""){
		alert("请选择要删除的记录!");
	}else{
		if(confirm("您确定要删除吗？")){
			document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/projectFill.do?method=delete&id="+chooseValue;
			document.getElementById("thisForm").submit();
		}
	}
}
   
   

</script>
