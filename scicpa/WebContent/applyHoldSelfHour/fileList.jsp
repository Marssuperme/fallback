<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>自办培训班学时附件</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/JS/uploadFile.js?v=${modifyDate}"  ></script>

<link rel="stylesheet"	href="${pageContext.request.contextPath}/CSS/main.css" />
<link rel="stylesheet"  href="${pageContext.request.contextPath}/CSS/index.css" />
	
<style>
.formTitle {
	color: #4A74BC;
	font-weight: bold;
	font-size: 16px; 
	text-align: center;
	width: 100%;
	margin-top: 10px;
}

</style>
 

</head>



<body>
 <div id="divBlock" style="position:absolute;width:100%;height:100%; z-index:0; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;"></div>
<form name="thisForm" method="post" action="" id="thisForm">
    <div id="search" style="position:absolute;width:35%;height:7%; z-index:0;left:expression((document.body.clientWidth-400)/2);top:expression(this.offsetParent.scrollTop + 70); border:1px solid #6595d6; padding:1px; background:#ffffff; display: none;">
    <br>
    <fieldset  style="border: 1px solid lightblue;width:95%;height: 95%;margin-left: 2px;" id="fieldset">
		<legend>
			搜索条件
		</legend>
		<table width="100%" border="0" align="center" cellpadding="2" cellspacing="1">
			<tr>
				<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;自办培训班名称：&nbsp;&nbsp;&nbsp;&nbsp; 
					<input id="trainingName" name="trainingName" onfocus="onPopDivClick(this);"  style="width: 40%"
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												norestorehint=true
												autoid=46
												refer="${userSession.userMap.loginid}"
												hideresult=true > 
				</td>
			</tr>
		</table>
    	<br>
   		<table width="90%" style="margin-left: 15%;">
			<tr>
				<td>
					<input id="pass" icon='icon-success' type='button' onclick="f_sure();" value='确定'>
			    	&nbsp;&nbsp;&nbsp;&nbsp; 
			    	<input id="pass" icon='icon-retry' type='button' onclick="f_clear();" value='清空'>
			    	&nbsp;&nbsp;&nbsp;&nbsp; 
			    	<input id="pass" icon='icon-delete' type='button' onclick="f_quxiao();" value='取消'>
			    </td>
			</tr>
    	</table>
   	</fieldset>
   </div>

<center class="formTitle">
自&nbsp;&nbsp;&nbsp;办&nbsp;&nbsp;&nbsp;培&nbsp;&nbsp;&nbsp;训&nbsp;&nbsp;&nbsp;班&nbsp;&nbsp;&nbsp;学&nbsp;&nbsp;&nbsp;时&nbsp;&nbsp;&nbsp;附&nbsp;&nbsp;&nbsp;件
<br><br>
</center>

<DIV style="width: 99%">
<div style="text-align: center;">
	
	<div class="tools" style="background-color: #e8f7fc ! important;padding-top:5px; height:10%;margin-bottom: -1px;">
	    <input id="pass" icon='icon-search' type='button' onclick="f_search();" value='搜索'>
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="pass" icon='icon-add' type='button' onclick="f_add();" value='增加'>
	   	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="pass" icon='icon-delete' type='button' onclick="f_delete();" value='删除'>
	   	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="pass" icon='icon-back' type='button' onclick="f_back();" value='返回'>
    </div>
	<mt:DataGridPrintByBean name="lineup"/>
</div>	
</DIV>


</form>


</body>
</html>
<script type="text/javascript">


//添加
function f_add(){
	document.thisForm.action = "${pageContext.request.contextPath}/common/applyHoldSelfHour.do?method=addAndView&p=add";
	document.thisForm.submit();
}

// 查看
function goView(id){
	document.thisForm.action = "${pageContext.request.contextPath}/common/applyHoldSelfHour.do?method=addAndView&p=view&id="+id;
	document.thisForm.submit();
}



// 删除
function f_delete(){
	var chooseValue = document.getElementById('chooseValue_lineup').value ;
	if(chooseValue==null || chooseValue==""){
		alert("请选择要删除的记录!");
	}else{
		var query_String = "&id=" + chooseValue;
		var url = "${pageContext.request.contextPath}/common/applyHoldSelfHour.do?method=getState";
		var result = ajaxLoadPageSynch(url,query_String);
		if(result != "0" ){
			if(confirm("确定要删除吗？")){
				thisForm.action = "${pageContext.request.contextPath}/common/applyHoldSelfHour.do?method=delete&id="+chooseValue;
				thisForm.submit();
			}
		}else{
			alert("该自办培训班学时已审核通过,不能删除！");
		}
	}
}


// 搜索
function f_search(){
	document.getElementById("search").style.display = "";
	document.getElementById("divBlock").style.display = "";
}


// 清空
function f_clear(){
	document.getElementById("trainingName").value = "";
	f_quxiao();
	goSearch("lineup");
}
 	
// 取消
function f_quxiao(){
	document.getElementById("search").style.display = "none";
	document.getElementById("divBlock").style.display = "none";
}

// 确定 
function f_sure(){
	f_quxiao();
	goSearch("lineup");
}

// 返回 
function f_back(){ 
	document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/applyHoldSelfHour.do?method=index";
	document.getElementById("thisForm").submit();
}



</script>
