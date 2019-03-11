<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%> 
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
<input type="hidden" id="loginid" name="loginid" value="${userSession.userMap.loginid}">

<input type="hidden" value="${typeid }" id="typeid" name="typeid">

	<div style="width:100%;">
	 	 
	    <div class="gridFrame">
		    <div class="tools" >
		    	&nbsp;<input id="pass" icon='icon-print' type='button' onclick="print();" value='打印'>
		    	&nbsp;<input id="pass" icon='icon-search' type='button' onclick="f_search();" value='搜索'>
		    </div>
		 
		    <br> 
		    <div id="search" style="display: none;" align="center">
			    <fieldset  style="border: 1px solid lightblue;width:80%;height: 20%;" id="fieldset">
					<legend>
						搜索条件
					</legend>
					<table>
						<tr align="right">
							<td>报&nbsp;&nbsp;&nbsp;备&nbsp;&nbsp;&nbsp;时&nbsp;&nbsp;间：<input id="bbtime" name="bbtime1" showcalendar="true"></td>
							<td>至   <input id="bbtime" name="bbtime2" showcalendar="true"></td>
						</tr>
						<tr align="left">
							<td>委托项目类型：<input id="wtxmlx" name="wtxmlx" style="height: 0px;" onfocus="onPopDivClick(this);" 
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												norestorehint=true
												autoid=32
												hideresult=true ></td>
							<td>委托单位：<input id="wtdw" name="wtdw" onfocus="onPopDivClick(this);" 
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												norestorehint=true
												autoid=30
												refer="loginid"
												hideresult=true ></td>
						</tr>
					</table>
					<input id="pass" icon='icon-success' type='button' onclick="f_sure();" value='确定'>
			    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    	<input id="pass" icon='icon-retry' type='button' onclick="f_cancle();" value='清空'>
				</fieldset>
			</div>
			<br>
		    <div style="width:100%;overflow:auto;height:580px;"> 
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
			var resText = f_getStateByGuid(chooseValue);
			if(resText=="zuofei"){
				alert("已作废状态了，不能再打印!");
				return false;
			}else if(resText=="zancun"){
				alert("暂存状态，不能打印，请报备完成，才能打印封面!");
				return false;
			}else{
				window.open("${pageContext.request.contextPath}/common/bb.do?method=print&guid="+chooseValue);
			}
		}
	}

	// 根据 guid 查看报备状态
	function f_getStateByGuid(guid){
		var chooseValue = guid;
		var oBao = new ActiveXObject("Microsoft.XMLHTTP");
		var url="${pageContext.request.contextPath}/common/content.do?method=getStateByGuid&ctguid="+chooseValue;
		oBao.open("POST",url,false);    // 注意第三个参数  为true 时要加多下面三句话  false 就不用
		oBao.send();

    	var resText = oBao.responseText;  
		return resText; 
	}


	// 搜索 
	function f_search(){
		if(document.getElementById("search").style.display=="none"){
			document.getElementById("search").style.display = "";
		}else{
			document.getElementById("search").style.display = "none";
		}
		go_Search("reportPrintList");
	}

	// 取消 
	function f_cancle(){
		document.getElementById("wtxmlx").value = "";
		document.getElementById("wtdw").value = "";
		document.getElementById("bbtime1").value = "";
		document.getElementById("bbtime2").value = "";
		document.getElementById("myform").action = "${pageContext.request.contextPath}/common/bb.do?method=printList"; 
		document.getElementById("myform").submit();
	}
	// 确定 
	function f_sure(){
		document.getElementById("myform").action = "${pageContext.request.contextPath}/common/bb.do?method=printList"; 
		document.getElementById("myform").submit();
	}

</script>

</html>