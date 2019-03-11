<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<%@ taglib prefix="mt"   uri="http://www.matech.cn/tag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

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
<title>报备其他</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css"/>
</head>
<body>


<form action="" method="post" name="myform" id="myform"> 
		
<input type="hidden" value="${typeid }" id="typeid" name="typeid">

	<div style="width:100%;">
	 	 
	    <div class="gridFrame">
		    <div class="tools" >
		    	&nbsp;<input id="pass" icon='icon-print' type='button' onclick="print();" value='打印'>
		    </div>
		    
		 
		    <br><br>
		    <div style="width:100%;overflow:auto;height:300px;"> 
		    	<mt:DataGridPrintByBean name="reportPrintList"/>
		    </div>
		</div>
		
	</div>
</form>

</body>



<script>
	
	function print(){
		var chooseValue = document.getElementById('chooseValue_reportPrintList').value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要打印的记录");
		}else{
			var oBao = new ActiveXObject("Microsoft.XMLHTTP");
			var url="${pageContext.request.contextPath}/common/content.do?method=viewState&ctguid="+chooseValue;
			oBao.open("POST",url,true);    // 注意第三个参数  为true 时要加多下面三句话  false 就不用
			oBao.send();
	
			oBao.onreadystatechange = function()
			{
			   if(oBao.readyState == 4)
			   {
				    if(oBao.status == 200)
				    { 
				    	var resText = oBao.responseText;  
						if(resText=="true"){
							alert("已作废状态了，不能再打印!");
							return false;
						}else{
							window.open("${pageContext.request.contextPath}/common/bbbbqtb.do?method=print&guid="+chooseValue);
						}
					}
			   }
		   }
		}
	}

</script>

</html>