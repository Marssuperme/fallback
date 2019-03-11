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
<title>自办培训班资格申请</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css"/>
</head>
<body>

<div id="divBlock" style="position:absolute;width:100%;height:100%; z-index:0; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;"></div>

<form action="" method="post" name="myform" id="myform"> 
		
	<div style="width:100%;">
	 	 
	    <div class="gridFrame">
		    <div class="tools" >
		    	<c:choose>
		    		<c:when test="${act=='apply'}">
				    	&nbsp;<input id="pass" icon='icon-add' type='button' onclick="f_add();" value='发起申请'>
				    	&nbsp;<input id="pass" icon='icon-edit' type='button' onclick="f_update();" value='修改'>
				    	&nbsp;<input id="pass" icon='icon-delete' type='button' onclick="f_delete();" value='删除'> 
		    		</c:when>
		    		<c:otherwise>
				    	&nbsp;<input id="pass" icon='icon-edit' type='button' onclick="f_update();" value='修改'>
				    	&nbsp;<input id="pass" icon='icon-delete' type='button' onclick="f_delete();" value='删除'> 
				    	&nbsp;<input id="pass" icon='icon-example' type='button' onclick="f_viewTrainHour();" value='学时维护'> 
		    		</c:otherwise>
		    	</c:choose>
		    	&nbsp;<input id="pass" icon='icon-search' type='button' onclick="f_search();" value='搜索'> 
		    </div>
		 	
			<br>
			 <div id="search" style="position:absolute;width:40%;height:15%; z-index:0;left:expression((document.body.clientWidth-400)/2);top:expression(this.offsetParent.scrollTop + 70); border:1px solid #6595d6; padding:1px; background:#ffffff; display: none;">
		    <br>
		   <fieldset  style="border: 1px solid lightblue;width:100%;height: 70%;margin-left: 2px;" id="fieldset">
				<legend>
					搜索条件
				</legend>
				<table>
		    		<tr>
		    			<td colspan="2">&nbsp;&nbsp;培&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;训&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;班：&nbsp;&nbsp;<input id="className" name="className"></td>
		    		</tr>
		    		<tr>
		    			<td colspan="2">&nbsp;&nbsp;培训开始日期：&nbsp;&nbsp;<input id="trainingDateBeg1" name="trainingDateBeg1" showcalendar="true"></td>
		    		</tr>
		    		<tr>
		    			<td colspan="1" style="width: 24%">&nbsp;&nbsp;&nbsp;</td>
		    			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;至<input id="trainingDateBeg2" name="trainingDateBeg2" showcalendar="true"></td>
		    		</tr>
		    		<tr>
		    			<td colspan="2">&nbsp;&nbsp;培训结束日期：&nbsp;&nbsp;<input id="trainingDateEnd1" name="trainingDateEnd1" showcalendar="true"></td>
		    		</tr>
		    		<tr>
		    			<td colspan="1" style="width: 24%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		    			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;至<input id="trainingDateEnd2" name="trainingDateEnd2" showcalendar="true"></td>
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
		    <div style="width:100%;overflow:auto;height:300px;"> 
		    	<mt:DataGridPrintByBean name="trainingHoldSelf"/>
		    </div>
		</div>
		
	</div>

<input type="hidden" id="act" name="act" value="${act }">
	
</form>

</body>

<script type="text/javascript" defer="defer">

// 发起申请
function f_add(){
	document.myform.action = "${pageContext.request.contextPath}/common/trainingHoldSelf.do?method=go";
	document.myform.submit();
}

// 修改 
function f_update(){
	var chooseValue = document.getElementById('chooseValue_trainingHoldSelf').value ;
	if(chooseValue==null || chooseValue==""){
		alert("请选择要修改的记录!");
	}else{
		var oBao = new ActiveXObject("Microsoft.XMLHTTP");
		var url="${pageContext.request.contextPath}/common/trainingHoldSelf.do?method=viewState&id="+chooseValue;
		oBao.open("POST",url,false);    
		oBao.send();

    	var resText = oBao.responseText;  

		if(resText=="N"){
			alert("已审核状态了，不能再修改!");
			return false;
		}else{
			document.myform.action = "${pageContext.request.contextPath}/common/trainingHoldSelf.do?method=go&id="+chooseValue;
			document.myform.submit();
		}
	}
	
}

// 删除 
function f_delete(){
	var chooseValue = document.getElementById('chooseValue_trainingHoldSelf').value ;
	
	if(chooseValue==null || chooseValue==""){
		alert("请选择要删除的记录!");
	}else{
		if(confirm("您确定要删除吗？")){
			var oBao = new ActiveXObject("Microsoft.XMLHTTP");
			var url="${pageContext.request.contextPath}/common/trainingHoldSelf.do?method=viewState&id="+chooseValue;
			oBao.open("POST",url,false);   
			oBao.send();
	
	    	var resText = oBao.responseText;  

			if(resText=="N"){
				alert("已审核状态了，不能再删除!");
				return false;
			}else{
				document.myform.action = "${pageContext.request.contextPath}/common/trainingHoldSelf.do?method=deleteTrainingHoldSelfTable&id="+chooseValue;
				document.myform.submit();
			}
		}
	}
}

function grid_dblclick(trObj) {
	var id = trObj.id;
	document.myform.action = "${pageContext.request.contextPath}/common/trainingHoldSelf.do?method=view&id="+id;
	document.myform.submit();
}

// 查看 
function goView(id){
	document.myform.action = "${pageContext.request.contextPath}/common/trainingHoldSelf.do?method=view&id="+id;
	document.myform.submit();
}

// 审核
function f_verify(){
	var chooseValue = document.getElementById('chooseValue_trainingHoldSelf').value ;
	
	if(chooseValue==null || chooseValue==""){
		alert("请选择要审核的记录!");
	}else{
		var oBao = new ActiveXObject("Microsoft.XMLHTTP");
		var url="${pageContext.request.contextPath}/common/trainingHoldSelf.do?method=viewState&id="+chooseValue;
		oBao.open("POST",url,false);    
		oBao.send();

    	var resText = oBao.responseText;  
		if(resText=="N"){
			alert("省注协已审核，事务所不能再审核!");
			return false;
		}else{
			document.myform.action = "${pageContext.request.contextPath}/common/trainingHoldSelf.do?method=go&id="+chooseValue;
			document.myform.submit();
		}
	}
}


		// 清空
	function f_clear(){
		document.getElementById("className").value = "";
		document.getElementById("trainingDateBeg1").value = "";
		document.getElementById("trainingDateBeg2").value = "";
		document.getElementById("trainingDateEnd1").value = "";
		document.getElementById("trainingDateEnd2").value = "";
		f_quxiao();
		goSearch("trainingHoldSelf");
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
		goSearch("trainingHoldSelf");
	}
	
	// 学时维护
	function f_viewTrainHour(){
		var chooseValue = document.getElementById('chooseValue_trainingHoldSelf').value ;
		
		if(chooseValue==null || chooseValue==""){
			alert("请选择培训班!");
		}else{
			document.myform.action = "${pageContext.request.contextPath}/common/applyHoldSelfHour.do?method=index&classId="+chooseValue;
			document.myform.submit();
		}
	}

</script>

</html>