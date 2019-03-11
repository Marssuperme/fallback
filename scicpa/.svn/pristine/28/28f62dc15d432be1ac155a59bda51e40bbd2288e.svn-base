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
<title>填报年检表</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css"/>
</head>
<body>
 
<div id="divBlock" style="position:absolute;width:100%;height:100%; z-index:0; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;"></div>

<form action="" method="post" name="myform" id="myform"> 
		<input type="hidden" id="id" name="id">
	<div style="width:100%;">
	 	 
	    <div class="gridFrame">
			    <div class="tools" >
			    	&nbsp;<input id="pass" icon='icon-add' type='button' onclick="f_add();" value='填报'>
			    	
			    	
			    </div>
		    <br>
		    <div id="search" style="position:absolute;width:25%;height:15%; z-index:0;left:expression((document.body.clientWidth-400)/2);top:expression(this.offsetParent.scrollTop + 70); border:1px solid #6595d6; padding:1px; background:#ffffff; display: none;">
		    <br>
		   <fieldset  style="border: 1px solid lightblue;width:100%;height: 70%;margin-left: 2px;" id="fieldset">
				<legend>
					搜索条件
				</legend>
				<table>
		    		<tr>
		    			<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;申报者：&nbsp;&nbsp;&nbsp;&nbsp;<input id="loginName" name="loginName"></td>
		    		</tr>
		    		<!--
		    		<tr>
		    			<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;会员卡号&nbsp;&nbsp;&nbsp;<input id="applyHours" name="applyHours"></td>
		    		</tr>
		    		  
		    		<tr>
		    			<td >&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;&nbsp;&nbsp;期：&nbsp;&nbsp;<input id="startDate" name="startDate" showcalendar="true"></td>
		    		</tr>
		    		<tr>
		    			<td colspan="1" style="width: 12%">&nbsp;</td>
		    			<td>至<input id="endDate" name="endDate" showcalendar="true"></td>
		    		</tr>
		    		-->
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
		    	<mt:DataGridPrintByBean name="FconExemList"/>		  
		</div>
		
	</div>
</form>

</body>

<script type="text/javascript" defer="defer">
	var date = new Date();
	year = date.getYear();
	// 发起申请
	function f_add(){
		window.location="${pageContext.request.contextPath}/common/nianjian.do?method=addGo&year="+year;
	}

	// 清空
	function f_clear(){
		document.getElementById("loginName").value = "";

		f_quxiao();
		goSearch("FconExemList");
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
		goSearch("FconExemList");
	}
	
	
	// 查看
	function goView(id){
	 	document.getElementById("id").value = id;
		document.myform.action = "${pageContext.request.contextPath}/common/ContentExemptionNot.do?method=view";
		document.myform.submit();
	}

	
	// 打印
	function f_print(){
		document.myform.action = "${pageContext.request.contextPath}/common/nianjian.do?method=goPrint&year="+year;
		document.myform.submit();
	}
	
	
</script>

</html>