<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>培训信息</title>
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
<form id="thisForm" name="thisForm" method="post" action="">
	
	<mt:DataGridPrintByBean name="trainingList"/>
	
	
	<input type="hidden" id="ctypetabname" name="ctypetabname" value="${ctypetabname}">
	<input type="hidden" id="loginid" name="loginid" value="${loginid}">
	<input type="hidden" id="loginname" name="loginname" value="${loginname}">
	<input type="hidden" id="source" name="source" value="${source}">
	<input type="hidden" id="trainingid_temp" name="trainingid_temp" >
</form>


</body>
</html>
<script>
/*查看*/
function goView(chooseValue){
	document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/training.do?method=view&nid="+chooseValue; 
	document.getElementById("thisForm").submit();
}

var AuditReport =  new ActiveXObject("AuditReportPoject.AuditReport");
var oframe=document.getElementById('oframe');
AuditReport.pDSOFramer=oframe;

// 广东省注协自助会员机控件打开
function goExcute(chooseValue){
	document.getElementById("divBlock").style.display = "block";
	
	//会员机反应慢
	if(document.getElementById("divBlock").style.display=="block"){
		if(confirm("确定开启该培训班吗？")){
			f_start();
			
			var opttype = "${opttype}";
			if(opttype=="kq_cx_szx" || opttype=="kq_cx_zx"){
				AuditReport.execute("C:/openEXE/Terminal.exe "+chooseValue+" TrianingQry");
			}else{
				AuditReport.execute("C:/openEXE/Terminal.exe "+chooseValue+" AutoWork");
			}
			
			document.getElementById("trainingid_temp").value = chooseValue;
			
			// 检查是否需要退出
			f_checkExit();
		}else{
			document.getElementById("divBlock").style.display = "none";
		}
	}
}

function f_display(){
	document.getElementById("divBlock").style.display = "none";
}
function f_start(){
	var id=window.setTimeout("f_display()",15000);
}
 
var timeId = "";

//会员机：如果OA考勤完退出后 网页自动退出 
function f_selfExit(){
	var trainingid = document.getElementById("trainingid_temp").value;
	var url="${pageContext.request.contextPath}/common/training.do?method=checkExit";
	var request = "&trainingid="+trainingid;
	var resText = ajaxLoadPageSynch(url,request);
	if(resText=="exit"){
	 	if(timeId!=""){
	 		window.clearInterval(timeId); //清楚定时器
	 	}
	 	/*
		var url = "${pageContext.request.contextPath}/common/member/entry.jsp";
	 	window.location = url;
	 	*/
	 	
	 	url="${pageContext.request.contextPath}/common/training.do?method=exit_hyj";
		var request = "";
		ajaxLoadPageSynch(url,request);
	};
	
} 

function f_checkExit(){
	timeId=window.setInterval("f_selfExit()",3000);
}

</script>