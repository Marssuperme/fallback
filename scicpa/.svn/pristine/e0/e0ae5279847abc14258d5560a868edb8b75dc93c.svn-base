<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<%@ page isELIgnored="false" %> 
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
<title>培训经历查询</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css"/>

</head>
<body>
 
<form action="" method="post" name="myform" id="myform">

	<center class="formTitle" >
		培&nbsp;&nbsp;训&nbsp;&nbsp;经&nbsp;&nbsp;历&nbsp;&nbsp;信&nbsp;&nbsp;息<br/><br/> 
	</center>
<input type="hidden" value="" id="typeId" name="typeId">
	<div style="width:100%;">
	 	 
	    <div class="gridFrame">
		    <div class="tools">
		    	&nbsp;<input id="pass" icon='icon-query' type='button' onclick="f_view();" value='查看详细'>
		    	&nbsp;<input id="pass" icon='icon-query' type='button' onclick="f_add();" value='增加'>
		    	&nbsp;<input id="pass" icon='icon-query' type='button' onclick="f_update();" value='修改'>
		    	&nbsp;<input id="pass" icon='icon-query' type='button' onclick="f_delete();" value='删除'>
		    	&nbsp;<input id="pass" icon='icon-query' type='button' onclick="f_select();" value='查询'>
		    </div>
		    
		    <div id="search" style="display: none;border:#c3daf9 1px solid; " align="center" >
		    	<table>
		    		<tr>
		    			<td colspan="2">培训开始时间：<input id="startTime" name="startTime" showcalendar="true"></td>
		    		</tr>
		    		<tr>
		    			<td colspan="2">培训结束时间：<input id="endTime" name="endTime" showcalendar="true"></td>
		    		</tr>
		    		<tr>
		    			<td><input type="button" value="搜索" onclick="goSearch('trainRecord')"></td>
		    			<td><input type="button" value="清空" onclick="f_clear()"></td>
		    		</tr>
		    	</table>
		    </div>
		    <br><br>
		    <div style="width:100%;overflow:auto;height:300px;"> 
		    	<mt:DataGridPrintByBean name="trainRecord"/>
		    </div>
		</div>
		
	</div>
</form>
 
</body>

<script type="text/javascript">

	// 查看详细
	function f_view(){
		var chooseValue = document.getElementById('chooseValue_trainRecord').value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要查看的记录");
		}else{
			myform.action = "${pageContext.request.contextPath}/common/trainRecord.do?method=view&id="+chooseValue;
			myform.submit();
		}
	}
	
	// 查看
	function f_select(){
		  if(document.getElementById("search").style.display=="none"){
	            document.getElementById("search").style.display="";
	      }else{
	            document.getElementById("search").style.display="none";
	      } 
	}
	
	// 清空
	function f_clear(){
		document.getElementById("startTime").value = "";
		document.getElementById("endTime").value = "";
		goSearch("trainRecord");
	}
	
	// 增加
	function f_add(){
		myform.action = "${pageContext.request.contextPath}/common/trainRecord.do?method=addAndEdit&param=add";
		myform.submit();
	}
	
	// 修改
	function f_update(){
		var chooseValue = document.getElementById('chooseValue_trainRecord').value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要修改的记录");
		}else{
			myform.action = "${pageContext.request.contextPath}/common/trainRecord.do?method=addAndEdit&param=update&id="+chooseValue;
			myform.submit();
		}
	}
	
	// 删除
	function f_delete(){
		var chooseValue = document.getElementById('chooseValue_trainRecord').value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要删除的记录");
		}else{
			if(confirm("确定要删除吗？")){
				myform.action = "${pageContext.request.contextPath}/common/trainRecord.do?method=deleteTrainRecordTable&param=update&id="+chooseValue;
				myform.submit();
			}
		}
	}
	
	
	 
</script>

</html>