<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %> 
<%@ include file="/Sys_INCLUDE/include.jsp" %>

<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<%@ taglib prefix="mt"   uri="http://www.matech.cn/tag" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<script src="/Web/JS/jquery.tree.js" type="text/javascript" ></script>
<link rel="stylesheet" href="/Web/CSS/jquery.tree.css"/>

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
		height:741px;
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
<title>转所申请流程列表</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css"/>
</head>
<body>
<div id="divBlock" style="position:absolute;width:100%;height:100%; z-index:0; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;"></div>
<form action="" method="post" name="myform" id="myform"> 
	<div style="width:100%;">
	    <div class="gridFrame">
		    <div class="tools" >
		    	&nbsp;<input icon="icon-add" type="button" onclick="f_add();" value="增加">
		    	&nbsp;<input icon="icon-edit" type="button" onclick="f_update();" value="修改">
		    </div>
		    <br> 
		    <div style="width:100%;overflow:auto;height:90%x;"> 
		    	<mt:DataGridPrintByBean name="micfo"/>
		    </div>
		</div>
		
	</div>
</form>

</body>

<script>
	// 添加
	function f_add(){
		
	}

	// 修改
	function f_update(){
		
		var chooseValue = document.getElementById("chooseValue_${typeid}").value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要修改的记录!");
		}else{
			// 检查选中记录否改所前旧记录，如旧的不能修改20130313修改
			var oBaos = new ActiveXObject("Microsoft.XMLHTTP");
			var url="${pageContext.request.contextPath}/common/bb.do?method=checkIsOldRecord&GUID="+chooseValue;
			oBaos.open("POST",url,false);     
			oBaos.send();	
	    	var resText = oBaos.responseText; 
			if(resText=="NO"){
				alert("该记录为改制前的数据，不能修改或删除！");
				return;
			}else if(resText!="OK"){
				alert("操作超时，请重新登录！");
				return;
			}			
			
	    	var resText = f_getStateByGuid(chooseValue);  
			if(resText=="zuofei"){
				alert("已作废状态了，不能再修改!");
				return false;
			}else if(resText=="zancun" || resText=="sqsh" || resText=="shwtg"){
				document.myform.action = "${pageContext.request.contextPath}/common/bb.do?method=addAndEdit&GUID="+chooseValue+"&param=update";
				document.myform.submit();
			}else{
				// 报备 一个月后只能 修改  已收业务费
				var oBaos = new ActiveXObject("Microsoft.XMLHTTP");
				var url="${pageContext.request.contextPath}/common/content.do?method=getDays&ctguid="+chooseValue;
				oBaos.open("POST",url,false);     
				oBaos.send();
		
		    	var resText = oBaos.responseText;  
				if(resText=="yes"){
					document.myform.action = "${pageContext.request.contextPath}/common/bb.do?method=addAndEdit&GUID="+chooseValue+"&param=update";
					document.myform.submit();
				}else{
					// 只能修改 已收业务费用 
					document.myform.action = "${pageContext.request.contextPath}/common/bb.do?method=addAndEdit&GUID="+chooseValue+"&param=update&updatemoney=updatemoney";
					document.myform.submit();
				}
			}
		}
	}
</script>

</html>