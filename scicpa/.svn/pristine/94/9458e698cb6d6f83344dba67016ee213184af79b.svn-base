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
		height:100%;
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
<title>验资list</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css"/>
</head>
<body>
<div id="divBlock" style="position:absolute;width:100%;height:100%; z-index:0; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;"></div>
<form action="" method="post" name="myform" id="myform"> 
<input type="hidden" value="${typeid }" id="typeid" name="typeid">
<input type="hidden" value="${title }" id="title" name="title">
<input type="hidden" id="qmzscpa" name="qmzscpa" value="mh">
<input type="hidden" id="loginid" name="loginid" value="${userSession.userMap.loginid}">

	<div style="width:100%;">
	 	 
	    <div class="gridFrame">
		    <div class="tools" >
		    	&nbsp;<input id="pass" icon='icon-search' type='button' onclick="f_search();" value='搜索'>
		    </div>
		    
			<div id="search" style="position:absolute;width:575px;height:200px; z-index:0;left:expression((document.body.clientWidth-575)/2);top:expression(this.offsetParent.scrollTop + 70); border:1px solid #6595d6; padding:1px; background:#ffffff; display: none;">
			    <br>
			    <fieldset  style="border: 1px solid lightblue;width:97%;height: 80%;margin-left: 2px;" id="fieldset">
					<legend>
						搜索条件
					</legend>
					<table width="98%" style="margin-left: 10px;">
						<tr align="left">
							<td width="50%">防&nbsp;&nbsp;伪&nbsp;&nbsp;编&nbsp;&nbsp;号：<input id="bbbh" name="bbbh" ></td>
							<td width="50%">报&nbsp;&nbsp;备&nbsp;&nbsp;类&nbsp;&nbsp;型：<input id="bbType" name="bbType" style="height: 0px;"></td>
						</tr>
						<tr align="left">
							<td>变&nbsp;&nbsp;更&nbsp;&nbsp;时&nbsp;&nbsp;间：<input id="changeTime1" name="changeTime1"  style="height: 0px;" showcalendar="true" >
							</td>
							<td><span style="width: 25%;text-align: center;">至</span>：<input id="changeTime2" name="changeTime2"  style="height: 0px;" showcalendar="true" >
							</td>
						</tr>	
						
						<tr align="left">
							<td>变&nbsp;&nbsp;更&nbsp;&nbsp;字&nbsp;&nbsp;段：<input id="changeField" name="changeField"  style="height: 0px;" ></td>
						</tr>
					</table>
					<br>
					<table width="90%" style="margin-left: 15%;">
						<tr>
							<td>
								<input id="pass" icon='icon-success' type='button' onclick="f_sure();" value='确定'>
						    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input id="pass" icon='icon-retry' type='button' onclick="f_clear();" value='清空'>
						    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input id="pass" icon='icon-delete' type='button' onclick="f_quxiao();" value='取消'>
						    </td>
						</tr>
			    	</table>
				</fieldset>
			</div>
			
		    <br> 
		    <div style="width:100%;overflow:scroll;height:100%px;"> 
		    	<mt:DataGridPrintByBean name="bbHistoryList"/>
		    	<br> 
		    </div>
		</div>
		
	</div>
</form>

</body>

<script>

	// 搜索 
	function f_search(){
		document.getElementById("search").style.display = "";
		document.getElementById("divBlock").style.display = "";
	}

	// 取消  清空
	function f_clear(){
		// 防伪编号
		document.getElementById("bbbh").value = "";
		// 报备类型
		document.getElementById("bbType").value = "";
		// 变更时间
		document.getElementById("changeTime1").value = "";
		document.getElementById("changeTime2").value = "";
		// 变更字段
		document.getElementById("changeField").value = "";
		
		document.getElementById("myform").action = "${pageContext.request.contextPath}/common/bb.do?method=bbHistoryList"; 
		document.getElementById("myform").submit();
	}
	
	// 取消
	function f_quxiao(){
		document.getElementById("search").style.display = "none";
		document.getElementById("divBlock").style.display = "none";
	}
	
	
	// 确定 
	function f_sure(){
		//document.getElementById("myform").action = "${pageContext.request.contextPath}/common/bb.do?method=bbHistoryList"; 
		//document.getElementById("myform").submit();
		var j=0;
		$("#search input[type='text']").each(function(){ 
    		if(!Testing($(this).val())){
    			j=1;
    			return false;
    		}
    		
  		});
		if(j==1){
			return false;
		};
		var url = "${pageContext.request.contextPath}/common/bb.do?method=bbHistoryList";
		url = url+"&typeid=" + document.getElementById("typeid").value +
			"&title=" + document.getElementById("title").value +
			"&qmzscpa=" + document.getElementById("qmzscpa").value +
			"&loginid=" + document.getElementById("loginid").value +		
			"&bbbh=" + document.getElementById("bbbh").value +
			"&bbType=" + document.getElementById("bbType").value +
			"&changeTime1=" + document.getElementById("changeTime1").value +
			"&changeTime2=" + document.getElementById("changeTime2").value +
			"&changeField=" + document.getElementById("changeField").value;
		window.location=url;
	}

	
</script>

</html>