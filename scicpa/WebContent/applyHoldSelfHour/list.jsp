<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %> 
<%@ include file="/Sys_INCLUDE/include.jsp" %>

<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<%@ taglib prefix="mt"   uri="http://www.matech.cn/tag" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="/Web/JS/jquery.tree.js" type="text/javascript" ></script>
<link rel="stylesheet" href="/Web/CSS/jquery.tree.css"/>

<style type="text/css">
	
	body {
		padding-left: 10px ;
		padding-right: 10px ;
		font-size: 12px ;
	}

	.formTitle {
	color: #4A74BC;
	font-weight: bold;
	font-size: 14px;
	text-align:center;
	width:100%;
	margin-top: 10px;
	}
	
	.tree {
		border: #c3daf9 1px solid;
		background:#fffcec;
		width: 20%; 
		height:600px;
		overflow:auto;
		float: left;
	} 
	
	.treeTitle {
		background:#e6f4d0 ;
		width:100%;
		height : 27px ;
		border:1px solid #e6f4d0;
		line-height: 27px ;
		color: #125908 ;
		font-size: 14px; 
		font-weight: bold;
		padding-left: 5px;
	}
	
	.gridFrame {
		width: 100%; 
		height:500px;
		border: #c3daf9 1px solid;
		float: left;
		margin-left: 5px ;
		padding: 5px ;
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

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>自办培训班学时申报</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css"/>
</head>
<body>

<div id="divBlock" style="position:absolute;width:100%;height:100%; z-index:0; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;"></div>

<form action="" method="post" name="myform" id="myform"> 
		
	<div style="width:100%;">
	 	 
	    <div class="gridFrame">
			    <div class="tools" >
			    	&nbsp;<input icon="icon-search" type="button" onclick="f_search()" value="搜索"> 
			    	&nbsp;<input icon="icon-excel" type="button" onclick="f_down();" value="自办培训班学时模板下载"> 
			    	&nbsp;<input icon="icon-save" type="button" onclick="f_import();" value="导入自办培训班学时">			    	  
			    	&nbsp;<input icon="icon-add" type="button" onclick="f_upload();" value="自办培训班学时附件上传">			    	 
			    	&nbsp;<input icon="icon-add" type="button" onclick="f_delete();" value="删除">
			    </div>
		 	
	     <div id="search" style="position:absolute;width:45%;height:15%; z-index:0;left:expression((document.body.clientWidth-400)/2);top:expression(this.offsetParent.scrollTop + 70); border:1px solid #6595d6; padding:1px; background:#ffffff; display: none;">
		    <br>
		   <fieldset  style="border: 1px solid lightblue;width:100%;height: 70%;margin-left: 2px;" id="fieldset">
				<legend>
					搜索条件
				</legend>
				<table style="width: 90%">
		    		<tr>
		    			<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;培训班名称：&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input id="trainingName" name="trainingName" onfocus="onPopDivClick(this);"  style="width: 60%"
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												norestorehint=true
												autoid=46
												refer="${userSession.userMap.loginid}"
												hideresult=true > 
		    			</td>
		    		</tr>
		    		<tr>
		    			<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;学&nbsp;&nbsp;时&nbsp;形&nbsp;式：&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input id="hourType" name="hourType" style="width: 60%">
		    			</td>
		    		</tr>
		    	</table>
		    	<br>
	    		<table width="90%" style="margin-left: 15%;">
					<tr>
						<td>
							<input icon='icon-success' type='button' onclick="f_sure();" value='确定'>
					    	&nbsp;&nbsp;&nbsp;&nbsp; 
					    	<input icon='icon-retry' type='button' onclick="f_clear();" value='清空'>
					    	&nbsp;&nbsp;&nbsp;&nbsp; 
					    	<input icon='icon-delete' type='button' onclick="f_quxiao();" value='取消'>
					    </td>
					</tr>
		    	</table>
	    	</fieldset>
	    </div>
	    
		    <div style="width:100%;overflow:auto;height:98%;"> 
		    	<mt:DataGridPrintByBean name="ApplyHoldSelfHourList"/>
		    </div>
		</div>
		
	</div>
	<input type="hidden" id="classId" name="classId" value="${classId }"/>
</form>

</body>

<script type="text/javascript" defer="defer">
// 发起申请
function f_add(){
	document.myform.action = "${pageContext.request.contextPath}/common/applyHoldSelfHour.do?method=go";
	document.myform.submit();
}

// 修改 
function f_update(){
	var chooseValue = document.getElementById('chooseValue_ApplyHoldSelfHourList').value ;
	
	if(chooseValue==null || chooseValue==""){
		alert("请选择要修改的记录!");
	}else{
		var oBao = new ActiveXObject("Microsoft.XMLHTTP");
		var url="${pageContext.request.contextPath}/common/applyHoldSelfHour.do?method=viewState&type=company&id="+chooseValue;
		oBao.open("POST",url,false);    // 注意第三个参数  为true 时要加多下面三句话  false 就不用
		oBao.send();

    	var resText = oBao.responseText;  
		if(resText=="N"){
			alert("已审核状态了，不能再修改!");
			return false;
		}else{
			document.myform.action = "${pageContext.request.contextPath}/common/applyHoldSelfHour.do?method=go&type=micfo&id="+chooseValue;
			document.myform.submit();
		}
	}	
}

// 删除 
function f_delete(){
	var chooseValue = document.getElementById('chooseValue_ApplyHoldSelfHourList').value ;
	
	if(chooseValue==null || chooseValue==""){
		alert("请选择要删除的记录!");
	}else{
		if(confirm("您确定要删除吗？")){
			var oBao = new ActiveXObject("Microsoft.XMLHTTP");
			var url="${pageContext.request.contextPath}/common/applyHoldSelfHour.do?method=viewState&type=company&id="+chooseValue;
			oBao.open("POST",url,false);   
			oBao.send();
	
	    	var resText = oBao.responseText;  
			if(resText=="N"){
				alert("已审核状态了，不能再删除!");
				return false;
			}else{
				document.myform.action = "${pageContext.request.contextPath}/common/applyHoldSelfHour.do?method=deleteApplyTrainHourTable&id="+chooseValue;
				document.myform.submit();
			}
		}
	}
}

function grid_dblclick(trObj) {
	var id = trObj.id;
	document.myform.action = "${pageContext.request.contextPath}/common/applyHoldSelfHour.do?method=view&id="+id;
	document.myform.submit();
}

// 查看 
function goView(id){
	document.myform.action = "${pageContext.request.contextPath}/common/applyHoldSelfHour.do?method=view&id="+id;
	document.myform.submit();
}

// 审核
function f_verify(){
	var chooseValue = document.getElementById('chooseValue_ApplyHoldSelfHourList').value ;
	
	if(chooseValue==null || chooseValue==""){
		alert("请选择要审核的记录!");
	}else{
		var oBao = new ActiveXObject("Microsoft.XMLHTTP");
		var url="${pageContext.request.contextPath}/common/applyHoldSelfHour.do?method=viewState&type=proince&id="+chooseValue;
		oBao.open("POST",url,false);    // 注意第三个参数  为true 时要加多下面三句话  false 就不用
		oBao.send();

    	var resText = oBao.responseText;  
		if(resText=="N"){
			alert("省注协已审核，事务所不能再审核!");
			return false;
		}else{
			document.myform.action = "${pageContext.request.contextPath}/common/applyHoldSelfHour.do?method=go&id="+chooseValue;
			document.myform.submit();
		}
	}
}



// 清空
function f_clear(){
	document.getElementById("trainingName").value = "";
	document.getElementById("hourType").value = "";
	f_quxiao();
	goSearch("ApplyHoldSelfHourList");
}

// 搜索 
function f_search(){
	document.getElementById("search").style.display = "";
	document.getElementById("divBlock").style.display = "";
}

// 取消
function f_quxiao(){
	document.getElementById("search").style.display = "none";
	document.getElementById("divBlock").style.display = "none";
}

// 确定 
function f_sure(){
	f_quxiao();
	goSearch("ApplyHoldSelfHourList");
}


// 下载
function f_down(){
	window.location = "${pageContext.request.contextPath}/common/attachFile/XS_ApplyHoldSelfHour/TrainingLearnTimeModel.zip";
}

// 导入
function f_import(){
	document.myform.action = "${pageContext.request.contextPath}/common/applyHoldSelfHour.do?method=goImport";
	document.myform.submit();
}

// 自办培训班学时附件上传
function f_upload(){
	document.myform.action = "${pageContext.request.contextPath}/common/applyHoldSelfHour.do?method=uploadList";
	document.myform.submit();
}

</script>

</html>