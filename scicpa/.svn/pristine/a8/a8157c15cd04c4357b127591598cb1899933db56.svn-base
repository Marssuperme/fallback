<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<%@ taglib prefix="mt"   uri="http://www.matech.cn/tag" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>党内奖惩</title>



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
		    	&nbsp;<input id="pass" icon='icon-add' type='button' onclick="f_add();" value='新增'>
		    	&nbsp;<input id="pass" icon='icon-edit' type='button' onclick="f_update();" value='修改'>
		    	&nbsp;<input id="pass" icon='icon-delete' type='button' onclick="f_del();" value='删除'>
		    </div>
		    
		     
		    <br><br>
		    <div style="width:100%;overflow:auto;height:85%;"> 
		    	<mt:DataGridPrintByBean name="partyCommend"/>
		    </div>
		</div>
<input name="tablename" type="hidden" id="tablename"  value="K_PartyCommend"  >
<input name="url" type="hidden" id="url"  value="/common/partyBranch.do?method=commend"  >
		
</form>
 


</body>

<script type="text/javascript">
	// 修改
	function f_update(){
		var chooseValue = document.getElementById('chooseValue_partyCommend').value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要修改的记录!");
		}else{
			document.getElementById("myform").action = "${pageContext.request.contextPath}/common/partyBranch.do?method=edit&param=update&id="+chooseValue;
			document.getElementById("myform").submit();
		}
	}
	//新增
	function f_add(){
		document.getElementById("myform").action = "${pageContext.request.contextPath}/common/partyBranch.do?method=edit&param=add&pid=${pid}";
		document.getElementById("myform").submit();
	}
	//删除
	function f_del(){
		var chooseValue = document.getElementById('chooseValue_partyCommend').value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要修改的记录!");
		}else{
			var str = "您的操作可能会造成数据丢失，您确定要删除该记录吗？";
	  		if(confirm(str,"提示")){
				document.getElementById("myform").action = "${pageContext.request.contextPath}/common/partyBranch.do?method=edit&param=del&pid=${pid}&id="+chooseValue;
				document.getElementById("myform").submit();
			}
		}
	}
</script>
</html>