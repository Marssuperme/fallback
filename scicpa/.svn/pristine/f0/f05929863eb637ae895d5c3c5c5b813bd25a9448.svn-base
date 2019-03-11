<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>座位号信息</title>
<style>
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
<div id="divBlock" style="position:absolute;width:100%;height:100%; z-index:0; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;"></div>
<form name="myform" id="myform" action="" method="post" > 
<input type="hidden" id="p" name="p">
<input type="hidden" id="id" name="id">

  <div class="gridFrame">	 
     	<div class="tools">
		    	&nbsp;<input icon="icon-add" type="button" onclick="f_add();" value="增加">
		    	&nbsp;<input icon="icon-edit" type="button" onclick="f_update();" value="修改">
		    	&nbsp;<input icon="icon-delete" type="button" onclick="f_delete();" value="删除">
		    	&nbsp;<input icon="icon-query" type="button" onclick="f_search();" value="查询">
	    </div>
	    
		<div id="search" style="position:absolute;width:40%;height:15%; z-index:0;left:expression((document.body.clientWidth-400)/2);top:expression(this.offsetParent.scrollTop + 70); border:1px solid #6595d6; padding:1px; background:#ffffff; display: none;">
		    <br>
		    <fieldset  style="border: 1px solid lightblue;width:95%;height: 70%;margin-left: 2px;" id="fieldset">
				<legend>
					搜索条件
				</legend>
				<table align="center">
		    		<tr>
		    			<td style="text-align: right;">培训班：</td>
		    			<td >
		    				<input id="trainingClass" name="trainingClass" >
		    			</td>
		    		</tr>
		    	</table>
		    	<br>
	    		<table width="90%" style="margin-left: 15%;">
					<tr>
						<td>
							<input id="pass" icon="icon-success" type="button" onclick="f_sure()" value="确定">
					    	&nbsp;&nbsp;&nbsp;&nbsp; 
					    	<input id="pass" icon="icon-retry" type="button" onclick="f_clear()" value="清空">
					    	&nbsp;&nbsp;&nbsp;&nbsp; 
					    	<input id="pass" icon="icon-delete" type="button" onclick="f_quxiao();" value="取消">
					    </td>
					</tr>
		    	</table>
	    	</fieldset>
	    </div>
	    
	   <div style="width:100%;overflow:auto;height:600px;"> 
	   		<mt:DataGridPrintByBean name="seat"/>
	   </div>
 </div>
 </form>
</body>
<script type="text/javascript">
	
	// 添加
	function f_add(){
		document.getElementById("p").value = "add";
		document.getElementById("myform").action = "${pageContext.request.contextPath}/common/seat.do?method=addAndEdit";
		document.getElementById("myform").submit();
	}
	
	// 修改
	function f_update(){
		var chooseValue = document.getElementById("chooseValue_seat").value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要修改的记录!");
		}else{
			document.getElementById("id").value = chooseValue;
			document.getElementById("p").value = "update";
			document.getElementById("myform").action = "${pageContext.request.contextPath}/common/seat.do?method=addAndEdit";
			document.getElementById("myform").submit();
		}
	}
	
	// 查看
	function goView(id){
		document.getElementById("p").value="search";
		document.getElementById("id").value = id;
		document.getElementById("myform").action = "${pageContext.request.contextPath}/common/seat.do?method=addAndEdit";
		document.getElementById("myform").submit();
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
	
	// 清空
	function f_clear(){
		document.getElementById("trainingClass").value = "";
		f_quxiao();
		goSearch("seat");
	}
	
	// 确定 
	function f_sure(){
		f_quxiao();
		goSearch("seat");
	}
	
	
	// 删除
	function f_delete(){
		var chooseValue = document.getElementById("chooseValue_seat").value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要删除的记录!");
		}else{
			if(confirm("请确定要删除吗？")){
				document.getElementById("id").value = chooseValue;
				document.getElementById("myform").action = "${pageContext.request.contextPath}/common/seat.do?method=delete";
				document.getElementById("myform").submit();
			}
		}
	}

</script>
</html>
