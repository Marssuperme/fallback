<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学时信息</title>
<style>
.formTitle {
	color: #4A74BC;
	font-weight: bold;
	font-size: 14px;
	text-align:center;
	width:100%;
	margin-top: 10px;
}
body {
		padding-left: 10px ;
		padding-right: 10px ;
		font-size: 12px ;
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
</head>
<body>
<div id="divBlock" style="position:absolute;width:100%;height:100%; z-index:0; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;"></div>
<form id="thisForm" name="thisForm" method="post" action="">
<div style="width:100%;">
	    <div class="gridFrame">
	 		<div class="tools" >
	    	&nbsp;<input id="pass" icon='icon-search' type='button' onclick="f_search();" value='搜索'>
		    </div>
			    
			<div id="search" style="position:absolute;width:50%;height:170px; z-index:0;left:expression((document.body.clientWidth-575)/2);top:expression(this.offsetParent.scrollTop + 70); border:1px solid #6595d6; padding:1px; background:#ffffff; display: none;">
			    <br>
			    <fieldset  style="border: 1px solid lightblue;width:97%;height: 60%;margin-left: 2px;" id="fieldset">
					<legend>
						搜索条件
					</legend>
					<table style="margin-left: 1px;width: 80%" align="center">
						<tr >
							<td style="text-align: right;width: 18%">培训班：</td>
		    				<td style="width: 82%">
		    					<c:choose>
		    						<c:when test="${source=='hyj'}">
		    								<div style="margin-top: -12px;">
												 <select id="s_trainingname" name="s_trainingname" style="position:absolute;width:230px;height:15px;clip:rect(0 260 110 130);" onchange='document.all.trainingname.value=this.options[this.selectedIndex].value;'>
												 	<option value="">=====清空=====</option> 
												 	<c:forEach var="trainName" items="${trainNameList}">
												 		<option value="${trainName}">${trainName}</option>   
												 	</c:forEach>
												 </select>
												 <input id="trainingname" name="trainingname" type="text" style="position:absolute;width:212px;height:21px;">
											 </div>  
		    						</c:when>
		    						<c:otherwise>
										<input id="trainingname" name="trainingname" style="height: 0px;" 
													onfocus="onPopDivClick(this);"
						    				        size="35"
								   					autoWidth=200
													autoHeight=260
													onkeydown="onKeyDownEvent();"
													onkeyup="onKeyUpEvent();"
													onclick="onPopDivClick(this);"
													autoid=61  >
		    						</c:otherwise>
		    					</c:choose>
							</td>
						</tr>
						<tr>
							<td style="text-align: right;">学&nbsp;&nbsp;&nbsp;&nbsp;员：</td>
							<td >
								<input id="loginname" name="loginname" size="35" style="height: 0px;">
							</td>
						</tr>
						<tr >
							<td style="text-align: right;">CPA号：</td>
							<td >
								<input id="cpano" name="cpano" size="35" style="height: 0px;">
							</td>
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
			<mt:DataGridPrintByBean name="receiptList"/>
		</div>
		</div>
	</div>
</form>
</body>
</html>
<script>


	// 搜索 
	function f_search(){
		document.getElementById("search").style.display = "";
		document.getElementById("divBlock").style.display = "";
	}

	// 取消  清空
	function f_clear(){
		// 学员
		document.getElementById("loginname").value = "";
		// cpa号
		document.getElementById("cpano").value = "";
		// 培训班
		document.getElementById("trainingname").value = "";
		
		var source = "${source}";
		var loginId = "${loginId}";
		// 省注协会员机链接
		if(source=="hyj"){
			document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/certificateReceipt.do?method=receiptListFromHYJ&loginId="+loginId; 
		}else{
			document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/certificateReceipt.do?method=receiptList"; 
		} 
		document.getElementById("thisForm").submit();
	}
	
	// 取消
	function f_quxiao(){
		document.getElementById("search").style.display = "none";
		document.getElementById("divBlock").style.display = "none";
	}
	
	
	// 确定 
	function f_sure(){
		var source = "${source}";
		var loginId = "${loginId}";
		// 省注协会员机链接
		if(source=="hyj"){
			document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/certificateReceipt.do?method=receiptListFromHYJ&loginId="+loginId;
		}else{
			document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/certificateReceipt.do?method=receiptList"; 
		} 
		document.getElementById("thisForm").submit();
	}
	
		
	// 打印
	function printReceipt(id,loginid){
		
		window.showModalDialog("${pageContext.request.contextPath}/common/certificateReceipt.do?method=printReceipt&id="+id+"&micfoLoginid="+loginid,'','dialogWidth=900px;dialogHeight=1000px;');
		
		// window.open("${pageContext.request.contextPath}/common/certificateReceipt.do?method=printReceipt&id="+id+"&micfoLoginid="+loginid);
		
	}
</script>