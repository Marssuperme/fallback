<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %> 
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>评估师注册信息</title>
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
		    	&nbsp;<input icon='icon-query' type='button' onclick="f_add();" value='增加'>
		    	&nbsp;<input icon='icon-query' type='button' onclick="f_update();" value='修改'>
		    	&nbsp;<input icon='icon-query' type='button' onclick="f_delete();" value='删除'>
		    	&nbsp;<input icon='icon-query' type='button' onclick="f_search();" value='查询'>
		    	&nbsp;<input icon="icon-print" type="button" onclick="f_print()" value="打  印" > 
	    </div>
	    
		<div id="search" style="position:absolute;width:30%;height:15%; z-index:0;left:expression((document.body.clientWidth-400)/2);top:expression(this.offsetParent.scrollTop + 70); border:1px solid #6595d6; padding:1px; background:#ffffff; display: none;">
		    <br>
		    <fieldset  style="border: 1px solid lightblue;width:95%;height: 70%;margin-left: 2px;" id="fieldset">
				<legend>
					搜索条件
				</legend>
				<table>
		    		<tr>
		    			<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;评估师名称：&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input id="loginName" name="loginName" >
		    			</td>
		    		</tr>
		    		<tr>
		    			<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;身份证号：&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input id="idnumber" name="idnumber" >
		    			</td>
		    		</tr>
		    		<tr>
		    			<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;批准文号：&nbsp;&nbsp;&nbsp;&nbsp;
		    				<input id="certificate" name="certificate" >
		    			</td>
		    		</tr>
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
	    
	    <div id="regist" style="position:absolute;width:30%;height:15%; z-index:0;left:expression((document.body.clientWidth-400)/2);top:expression(this.offsetParent.scrollTop + 70); border:1px solid #6595d6; padding:1px; background:#ffffff; display: none;">
	    	 <br>
		    <fieldset  style="border: 1px solid lightblue;width:95%;height: 70%;margin-left: 2px;" id="fieldset">
				<legend>
					评估师师注册
				</legend>
		    	<table>
			    		<tr>
			    			<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：&nbsp;&nbsp;&nbsp;&nbsp;
			    				<input id="name" name="name" >
			    			</td>
			    		</tr>
			    		<tr>
			    			<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;身份证号：&nbsp;&nbsp;&nbsp;&nbsp;
			    				<input id="idCardNum" name="idCardNum" style="height: 0px;">
			    			</td>
			    		</tr>
		    	</table>
		    	<br>
	    		<table width="90%" style="margin-left: 15%;">
					<tr>
						<td>
							<input id="pass" icon='icon-success' type='button' onclick="f_regist();" value='确定'>
					    	&nbsp;&nbsp;&nbsp;&nbsp; 
					    	<input id="pass" icon='icon-delete' type='button' onclick="f_cancle();" value='取消'>
					    </td>
					</tr>
		    	</table>
			  </fieldset>
	    </div>
	   <div style="width:100%;overflow:auto;height:400px;"> 
	   		<mt:DataGridPrintByBean name="assesserRegister"/>
	   </div>
 </div>
 </form>
</body>
<script type="text/javascript">
	// 添加
	function f_add(){
		document.getElementById("regist").style.display = "";
		document.getElementById("divBlock").style.display = "";
	}
	
	// 修改
	function f_update(){
		var chooseValue = document.getElementById('chooseValue_assesserRegister').value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要修改的记录!");
		}else{
			document.getElementById("id").value = chooseValue;
			document.getElementById("p").value = "update";
			document.getElementById("myform").action = "${pageContext.request.contextPath}/common/assesserRegister.do?method=go";
			document.getElementById("myform").submit();
		}
	}
	
	// 删除
	function f_delete(){
		var chooseValue = document.getElementById('chooseValue_assesserRegister').value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要删除的记录!");
		}else{
			if(confirm("确定要删除吗？")){
				document.getElementById("id").value = chooseValue;
				document.getElementById("myform").action = "${pageContext.request.contextPath}/common/assesserRegister.do?method=delAssesserRegister";
				document.getElementById("myform").submit();
			}
		}
	}
	
	// 查看
	function goView(id){
		document.getElementById("p").value="search";
		document.getElementById("id").value = id;
		document.getElementById("myform").action = "${pageContext.request.contextPath}/common/assesserRegister.do?method=go";
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
		document.getElementById("loginName").value = "";
		document.getElementById("idnumber").value = "";
		document.getElementById("certificate").value = "";
		f_quxiao();
		goSearch("assesserRegister");
	}
	
	// 确定 
	function f_sure(){
		f_quxiao();
		goSearch("assesserRegister");
	}
	
	// 打印
	function f_print(){
		var chooseValue = document.getElementById('chooseValue_assesserRegister').value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要打印的记录!");
		}else{
			window.open("${pageContext.request.contextPath}/common/assesserRegister.do?method=goPrint&id="+chooseValue);
		}
	}
	
	// 注册
	function f_regist(){
		var name = document.getElementById("name").value;
		var idCardNum = document.getElementById("idCardNum").value;
		if(name=="" || name==null){
			alert("请填写姓名!");
			return;
		}
		if(idCardNum=="" || idCardNum==null){
			alert("请填写身份证号!");
			return;
		}
		document.getElementById("myForm").action = "${pageContext.request.contextPath}/common/assesserRegister.do?method=goRegist";
		document.getElementById("myForm").submit();
	}

	// 取消
	function f_cancle(){
		document.getElementById("regist").style.display = "none";
		document.getElementById("divBlock").style.display = "none";
	}	
</script>
</html>
