<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>

<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>

<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公文收文</title>
<style>
.formTitle {
	color: #4A74BC;
	font-weight: bold;
	font-size: 14px;
	text-align:center;
	width:100%;
	margin-top: 10px;
}

</style>
</head>
<body>
<div id="divBlock" style="position:absolute;width:100%;height:100%; z-index:0; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;"></div>
<form name="myform" method="post" action="">

	<div style="width:100%;">
	 	 
	    <div>
		    <div style="margin-bottom: 0.5%">
		    	&nbsp;<input id="pass" icon='icon-search' type='button' onclick="f_search();" value='搜索'>
		    </div>
		    
			<div id="search" style="position:absolute;width:40%;height:50%; z-index:0;left:expression((document.body.clientWidth-575)/2);top:expression(this.offsetParent.scrollTop + 70); border:1px solid #6595d6; padding:1px; background:#ffffff; display: none;">
			    <br>
			    <fieldset  style="border: 1px solid lightblue;width:86%;height: 95%;margin-left: 2px;" id="fieldset">
					<legend>
						搜索条件
					</legend>
					<table width="100%" style="margin-left: 15px;">
						<tr >
							<td align="right">标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题：</td>
							<td align="left"><input id="caption" name="caption" style="width: 260;height: 0px;"></td>
						</tr>
						<!--<tr >
							<td align="right">文&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</tr>
							<td align="left;"><input id="reference" name="reference" style="width: 260"></td>
							-->
						<tr >
							<td align="right">发文时间：</td>
							<td align="left">
								<input id="ntime1" name="ntime1"  style="width: 85px;" showcalendar="true">至
								<input id="ntime2" name="ntime2"  style="width: 85px;" showcalendar="true">
							</td>
						</tr>
						<tr >
							<td align="right">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：</td>
							<td align="left"><input id="isview" name="isview"  style="width: 260px;" >
							</td>
						</tr>	
						 
				</table>
			<br>
			<table width="90%" style="margin-left: 25%;">
				<tr>
					<td>
						<input id="pass" icon='icon-success' type='button' onclick="f_sure();" value='确定'>
				    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    	<input id="pass" icon='icon-retry' type='button' onclick="f_clear();" value='清空'>
				    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    	<input id="pass" icon='icon-delete' type='button' onclick="f_quxiao();" value='取消'>
				    </td>
				</tr>
	    	</table>
		</fieldset>
	</div>
    <div style="width:100%;height:100%;"> 
    	<mt:DataGridPrintByBean name="documentList"/>
    </div>
</div>
</div>
</form>

</body>
</html>
<script>
	/*查看*/
	function goView(chooseValue){
		window.location="${pageContext.request.contextPath}/common/new.do?method=document&nid="+chooseValue;
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
	
	
	// 确定 
	function f_sure(){
		document.getElementById("myform").action = "${pageContext.request.contextPath}/common/new.do?method=dlist"; 
		document.getElementById("myform").submit();
	}
	
	
	// 取消  清空
	function f_clear(){
		// 标题
		document.getElementById("caption").value = "";
		// 文号
		document.getElementById("reference").value = "";
		// 发文时间
		document.getElementById("ntime1").value = "";
		document.getElementById("ntime2").value = "";
		// 状态
		document.getElementById("isview").value = "";
		
		document.getElementById("myform").action = "${pageContext.request.contextPath}/common/new.do?method=dlist"; 
		document.getElementById("myform").submit();
	}
	
	
</script>