<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<%@ taglib prefix="mt"   uri="http://www.matech.cn/tag" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>监管问题</title>


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

<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css"/>

</head>
<body>


<form action="" method="post" name="myform" id="myform"> 
		
<input type="hidden" value="${typeid }" id="typeid" name="typeid">
 
	    <div class="gridFrame">
		    <div class="tools" >
		    	&nbsp;<input id="pass" icon='icon-add' type='button' onclick="f_add();" value='增加'>
		    	&nbsp;<input id="pass" icon='icon-query' type='button' onclick="f_view();" value='查看'> 
		    </div>
		    
		    
		 
		    <br><br>
		    <div style="width:100%;height: 90%;overflow:auto;"> 
		    	<mt:DataGridPrintByBean name="supervision"/>
		    </div>
		</div>
		
</form>

</body>
<script type="text/javascript">
	// 添加
	function f_add(){
		document.myform.action = "${pageContext.request.contextPath}/common/supervision.do?method=go&p=add";
		document.myform.submit();
	}
	
	// 查看
	function f_view(){
		var chooseValue = document.getElementById('chooseValue_supervision').value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要查看的记录");
		}else{
			document.myform.action = "${pageContext.request.contextPath}/common/supervision.do?method=viewSupervisionTable&id="+chooseValue;
			document.myform.submit();
		}
	}
</script>

</html>