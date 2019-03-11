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
<title>监管工时费用报备管理 List</title> 

</head>
<body>

<form action="" method="post" name="myform" id="myform"> 
		
	    <div class="gridFrame">
		    <div class="tools" >
		    	&nbsp;<input id="pass" icon='icon-add' type='button' onclick="f_add();" value='增加'>
		    	&nbsp;<input id="pass" icon='icon-edit' type='button' onclick="f_update();" value='修改'>
		    	&nbsp;<input id="pass" icon='icon-delete' type='button' onclick="f_delete();" value='删除'> 
		    </div>
		    
		    
		 
		    <br><br>
		    <div style="width:100%;overflow:auto;height:300px;"> 
		    	<mt:DataGridPrintByBean name="hourCostMain"/>
		    </div>
		</div>
		
</form>

</body>



<script>
	 
	
	// 添加
	function f_add(){
		document.myform.action = "${pageContext.request.contextPath}/common/hourCostManage.do?method=addAndEdit&param=add";
		document.myform.submit();
	}
	
	// 修改
	function f_update(){
		var chooseValue = document.getElementById('chooseValue_hourCostMain').value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要修改的记录");
		}else{
			document.myform.action = "${pageContext.request.contextPath}/common/hourCostManage.do?method=goView&id="+chooseValue;
			document.myform.submit();
		}
	}
	
	// 删除
	function f_delete(){
		var chooseValue = document.getElementById('chooseValue_hourCostMain').value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要删除的记录");
		}else{
			if(confirm("确定要删除吗？")){
				myform.action = "${pageContext.request.contextPath}/common/hourCostManage.do?method=deleteHourCostManageTable&id="+chooseValue;
				myform.submit();
			}
		}
	}
	
	
	// 查看
	function goView(id){
		document.myform.action = "${pageContext.request.contextPath}/common/hourCostManage.do?method=goView&id="+id;
		document.myform.submit();
	}
	
 
	
	 
	 
</script>

</html>