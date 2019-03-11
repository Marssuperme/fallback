<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>奖惩信息</title>

<style type="text/css">
	
	body {
		padding-left: 10px ;
		padding-right: 10px ;
		font-size: 12px ;
	}
	
	.gridFrame {
		width: 100%; 
		height:500px;
		border: #c3daf9 1px solid;
		float: left;
		margin-left: 2px ;
		padding: 5px ;
	}
	
</style>

</head>
<body>

<form action="" method="post" name="myform" id="myform"> 
    <div class="gridFrame" >
	    <div style="width:100%;overflow:auto;height:85%;"> 
	    	<mt:DataGridPrintByBean name="punishList"/>
	    </div>
	</div>
</form>

</body>
</html>