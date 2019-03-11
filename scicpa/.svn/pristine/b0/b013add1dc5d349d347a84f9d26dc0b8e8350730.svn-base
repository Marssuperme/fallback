<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<%@ taglib prefix="mt"   uri="http://www.matech.cn/tag" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>党组织列表信息</title>



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
	
	.tools {
		width:100% ;
		height:27px ;
		float:left;
		background-image: url("/Web/images/toolBarBg.gif");
		padding-top: 3px;
		padding-left:5px;
		margin-bottom: 2px;
	} 
</style>

</head>
<body>


<form action="" method="post" name="myform" id="myform"> 
	 	 
	    <div class="gridFrame" >
		    <div class="tools">
		    	&nbsp;<input id="pass" icon='icon-edit' type='button' onclick="f_update();" value='修改'>
		    	&nbsp;<input id="pass" icon='icon-delete' type='button' onclick="f_delete();" value='删除'>
		    </div>
		    
		     
		    <br><br>
		    <div style="width:100%;overflow:auto;height:85%;"> 
		    	<mt:DataGridPrintByBean name="party"/>
		    </div>
		</div>
		
</form>
 


</body>

<script type="text/javascript">

	// 查看详细
	function f_view(id){
		document.getElementById("myform").action = "${pageContext.request.contextPath}/common/party.do?method=addAndEdit&param=view&id="+id;
		document.getElementById("myform").submit();
	}

	// 修改
	function f_update(){
		var chooseValue = document.getElementById('chooseValue_party').value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要修改的记录!");
		}else{
			document.getElementById("myform").action = "${pageContext.request.contextPath}/common/party.do?method=addAndEdit&param=update&id="+chooseValue;
			document.getElementById("myform").submit();
		}
	}
	
	// 删除
	function f_delete(){
		var chooseValue = document.getElementById('chooseValue_party').value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要删除的记录!");
		}else{
			document.getElementById("myform").action = "${pageContext.request.contextPath}/common/party.do?method=delete&id="+chooseValue;
			document.getElementById("myform").submit();
		}
	}
	
</script>
</html>