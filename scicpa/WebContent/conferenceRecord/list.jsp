<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
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
		height:500px;
		border: #c3daf9 1px solid;
		float: left;
		margin-left: 5px ;
		padding: 5px ;
	}
	
	.tools {
		display: none;
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
<title>转会经历查询</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css"/>

</head>
<body>
  <div id="divBlock" style="position:absolute;width:100%;height:100%; z-index:0; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;"></div>
<form action="" method="post" name="myform" id="myform"></form>
<input type="hidden" value="" id="typeId" name="typeId">
	 	 
    <div class="gridFrame" style="height: 80%;">
     	<div style="margin-bottom: 0.5%">
	    	&nbsp;<input id="pass" icon='icon-search' type='button' onclick="f_search();" value='搜索'>
	    </div>	
	    <div class="tools">
	    	&nbsp;<input id="pass" icon='icon-query' type='button' onclick="f_view();" value='查看详细'>
	    	&nbsp;<input id="pass" icon='icon-query' type='button' onclick="f_add();" value='增加'>
	    	&nbsp;<input id="pass" icon='icon-query' type='button' onclick="f_update();" value='修改'>
	    	&nbsp;<input id="pass" icon='icon-query' type='button' onclick="f_delete();" value='删除'>
	    	&nbsp;<input id="pass" icon='icon-query' type='button' onclick="f_select();" value='查询'>
	    </div>
	    
	    <div id="search" style="position:absolute;width:50%;height:15%; z-index:0;left:expression((document.body.clientWidth-400)/2);top:expression(this.offsetParent.scrollTop + 70); border:1px solid #6595d6; padding:1px; background:#ffffff; display: none;">
			    <br>
			    <fieldset  style="border: 1px solid lightblue;width:95%;height: 70%;margin-left: 2px;" id="fieldset">
					<legend>
						搜索条件
					</legend>
					<table>
			    		<tr>
			    			<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;转会时间：&nbsp;&nbsp;&nbsp;&nbsp;<input id="outTime1" name="outTime1" showcalendar="true"></td>
			    		</tr>
			    		<tr>
			    			<td colspan="1" style="width: 24%">&nbsp;</td>
			    			<td>&nbsp;&nbsp;&nbsp;至<input id="outTim2" name="outTime2" showcalendar="true"></td>
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
	    <div style="width:100%;overflow:auto;height:85%;"> 
	    	<mt:DataGridPrintByBean name="conferenceRecord"/>
	    </div>
	</div>
</body>

<script type="text/javascript">
	// 查看详细
	function f_view(){
		var chooseValue = document.getElementById('chooseValue_conferenceRecord').value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要查看的记录");
		}else{
			myform.action = "${pageContext.request.contextPath}/common/conferenceRecord.do?method=view&id="+chooseValue;
			myform.submit();
		}
	}

	// 查看
	function f_select(){
		  if(document.getElementById("search").style.display=="none"){
	            document.getElementById("search").style.display="";
	      }else{
	            document.getElementById("search").style.display="none";
	      } 
	}
	
	// 清空
	function f_clear(){
		document.getElementById("outTime").value = "";
		document.getElementById("inTime").value = "";
		goSearch("conferenceRecord");
	}
	
	// 增加
	function f_add(){
		myform.action = "${pageContext.request.contextPath}/common/conferenceRecord.do?method=addAndEdit&param=add";
		myform.submit();
	}
	
	// 修改
	function f_update(){
		var chooseValue = document.getElementById('chooseValue_conferenceRecord').value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要修改的记录");
		}else{
			myform.action = "${pageContext.request.contextPath}/common/conferenceRecord.do?method=addAndEdit&param=update&id="+chooseValue;
			myform.submit();
		}
	}
	
	// 删除
	function f_delete(){
		var chooseValue = document.getElementById('chooseValue_conferenceRecord').value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要删除的记录");
		}else{
			if(confirm("确定要删除吗？")){
				myform.action = "${pageContext.request.contextPath}/common/conferenceRecord.do?method=deleteConferenceRecordTable&id="+chooseValue;
				myform.submit();
			}
		}
	}
	
	 
	 // 搜索 
	function f_search(){
		document.getElementById("search").style.display = "";
		document.getElementById("divBlock").style.display = "";
	}
	
	// 清空
	function f_clear(){
		document.getElementById("outTime1").value = "";
		document.getElementById("outTime2").value = "";
		f_quxiao();
		goSearch("conferenceRecord");
	}
	 	
	// 取消
	function f_quxiao(){
		document.getElementById("search").style.display = "none";
		document.getElementById("divBlock").style.display = "none";
	}
	
	// 确定 
	function f_sure(){
		f_quxiao();
		goSearch("conferenceRecord");
	}
	
	 
</script>

</html>