<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>投稿</title>
<style type="text/css">
.gridFrame {
	width: 100%; 
	height:55%;
	border: #c3daf9 1px solid;
	float: left;
	margin-left: 5px ;
	padding: 5px ;
}
</style>
</head>
<body>
<form name="myform" id="myform" action="" method="post" > 
<input type="hidden" id="p" name="p">
<input type="hidden" id="id" name="id">
<div class="gridFrame">	
  <div class="tools">
	 &nbsp;<input icon="icon-add" type="button" onClick="f_contributors();" value="投稿">
	 &nbsp;<input icon="icon-edit" type="button" onClick="f_update();" value="修改">
	 &nbsp;<input icon="icon-delete" type="button" onClick="f_delete();" value="删除">
 </div> 
 <div style="width:100%;overflow:auto;height:600px;"> 
    <mt:DataGridPrintByBean name="paper"/>
</div>
</div>
</form>
</body>
<script type="text/javascript">
// 投稿
	function f_contributors(){
		document.getElementById("p").value = "add";
		document.getElementById("myform").action = "${pageContext.request.contextPath}/common/paper.do?method=addPaperAndEdit";
		document.getElementById("myform").submit();
	}
	// 修改 
	function f_update(){
		var chooseValue = document.getElementById("chooseValue_paper").value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要修改的记录!");
		}else{
			//这个ID也是ParticularAction类addParticularAndEdit（）方法的
			document.getElementById("id").value = chooseValue;
			
			//后台有框架控制它会自动去找它
			document.getElementById("p").value = "update";
			document.getElementById("myform").action = "${pageContext.request.contextPath}/common/paper.do?method=addPaperAndEdit";
			document.getElementById("myform").submit();
		}
	}
	
	// 删除
	function f_delete(){
		var chooseValue = document.getElementById("chooseValue_paper").value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要删除的记录!");
		}else{
			if(confirm("确定要删除吗？")){
				document.getElementById("id").value = chooseValue;
				document.getElementById("myform").action = "${pageContext.request.contextPath}/common/paper.do?method=deletePaperNo";
				document.getElementById("myform").submit();
			}
		}
	}
	// 查看
	function goView(id){
		//后台有框架控制它会自动去找它
		document.getElementById("p").value="search";
		document.getElementById("id").value = id;
		document.getElementById("myform").action = "${pageContext.request.contextPath}/common/paper.do?method=addPaperAndEdit";
		document.getElementById("myform").submit();
	}
</script>
</html>