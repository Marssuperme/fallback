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
<title>所得税汇算清缴</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css"/>
</head>
<body>


<form action="" method="post" name="myform" id="myform"> 
		
<input type="hidden" value="${typeid }" id="typeid" name="typeid">

	<div style="width:100%;">
	 	 
	    <div class="gridFrame">
		    <div class="tools" >
		    	&nbsp;<input id="pass" icon='icon-add' type='button' onclick="f_add();" value='增加'>
		    	&nbsp;<input id="pass" icon='icon-edit' type='button' onclick="f_update();" value='修改'>
		    	&nbsp;<input id="pass" icon='icon-delete' type='button' onclick="f_delete();" value='删除'>
		        &nbsp;<input id="pass" icon='icon-delete-row' type='button' onclick="f_cancle();" value='作废'>
		    	&nbsp;<input id="pass" icon='icon-print' type='button' onclick="print();" value='封面打印'>
		    </div>
		    
		 
		    <br><br>
		    <div style="width:100%;overflow:auto;height:300px;"> 
		    	<mt:DataGridPrintByBean name="bbsdshsqj"/>
		    </div>
		</div>
		
	</div>
</form>


</body>

<script>

	// 只是添加完成之后提示。注意传过来的参数变量名
	var bbnum="${bbnum}";
	if(bbnum!="" && bbnum!=null){
		if(confirm("报备成功，是否立刻打印封面？"))
		{
			window.open("${pageContext.request.contextPath}/common/bbbbqtb.do?method=print&guid="+bbnum);
		}
	}	
	
	
	// 查看是否审核
	function isReviewed(){
		var chooseValue = document.getElementById('chooseValue_bbsdshsqj').value ;
		var oBao = new ActiveXObject("Microsoft.XMLHTTP");
		var url="${pageContext.request.contextPath}/common/content.do?method=viewIsReviewed&ctguid="+chooseValue;
		oBao.open("POST",url,false);    // 注意第三个参数  为true 时要加多下面三句话  false 就不用
		oBao.send();

    	var resText = oBao.responseText;  
		if(resText=="true"){
			return "Y";
		}else{
			return "N";
		}
	}
	
	// 添加
	function f_add(){
		document.myform.action = "${pageContext.request.contextPath}/common/bbsdshsqjb.do?method=addAndEdit&param=add";
		document.myform.submit();
	}
	
	// 修改
	function f_update(){
		var chooseValue = document.getElementById('chooseValue_bbsdshsqj').value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要修改的记录");
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
						alert("已作废状态了，不能再修改!");
						return false;
					}else{
						var p = isReviewed();
						if(p=="Y"){
							alert("已审核状态，不能再修改!");
							return false;
						}else{
							document.myform.action = "${pageContext.request.contextPath}/common/bbsdshsqjb.do?method=addAndEdit&GUID="+chooseValue+"&param=update";
							document.myform.submit();
						}
					}
				 }
			   }
			}
		}
	}
	
	// 删除
	function f_delete(){
		var chooseValue = document.getElementById('chooseValue_bbsdshsqj').value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要删除的记录");
		}else{
			if(confirm("确定要删除吗？")){
				var p = isReviewed();
				if(p=="Y"){
					alert("已审核状态，不能再删除!");
					return false;
				}else{
					myform.action = "${pageContext.request.contextPath}/common/bbsdshsqjb.do?method=deleteSdshsqjTable&GUID="+chooseValue;
					myform.submit();
				}
			}
		}
	}
	
	// 查看
	function f_viewTD(guid,companyguid){
		document.myform.action = "${pageContext.request.contextPath}/common/bbsdshsqjb.do?method=addAndEdit&GUID="+guid+"&param=search&p=ck";
		document.myform.submit();
	}
	
	// 打印
	function print(){
		var chooseValue = document.getElementById('chooseValue_bbsdshsqj').value ;
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
	
	
	// 作废
	function f_cancle(){
		var chooseValue = document.getElementById('chooseValue_bbsdshsqj').value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要作废的记录");
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
						alert("已作废状态了!");
						return false;
					}else{
						var p = isReviewed();
						if(p=="Y"){
							alert("已审核状态，不能再作废!");
							return false;
						}else{
							document.myform.action = "${pageContext.request.contextPath}/common/bbsdshsqjb.do?method=addAndEdit&GUID="+chooseValue+"&param=search&p=zf";
							document.myform.submit();
						}
					}
				 }
			   }
			}
		}
	}
	
</script>

</html>