<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %> 
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%
response.addHeader("Cache-Control", "no-cache");
response.addHeader("Expires", "Thu, 01 Jan 1970 00:00:01 GMT");
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="expires" CONTENT="Wed, 26 Feb 1997 08:21:57 GMT"> 


<title>问卷调查</title>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<style>

	body {
		margin: 0px ;
		padding: 0px ;
	}
	
	.content {
		width:100% ;
		padding-top: 50px;
		padding-left:20px;
		padding-right:30px;
	}
	.questionDiv {
		font-size: 15px;
		margin-left: 10px;
		margin-top: 20px;
	}
	
	
</style>

</head>
<body>

<div >
		<div style="width: 100%;background-color:#d5c59f;text-align: center;" id="butDiv">
			<c:if test="${opt!='see'}">
				<input type="button" icon="icon-save" id="submitpaper" value="提交" onclick="submitPaper();" />  
				<c:if test="${loginid==null || loginid==''}">
					&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="cancle" value="关闭" onclick="window.close();" />
				</c:if> 
			</c:if>
				&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" icon="icon-print" id="print" value="打印" onclick="window.print();" />  
		</div>
	<br><br>
	<span  style="width:90%;margin-left:50px;">
		<center><span style="font-size:25px;">${map.surname}</span></center>
		<br><br><br>  
			<span style="font-size:15px;">${map.remark}</span>
	</span>
</div>

<form id="thisForm" name="thisForm" method="post" action="" >
	<div class="content" >
		<c:forEach items="${typeList}" var="tList">
			<center><span style="font-size: 15px;">${tList.typename}</span></center><br><br>
				<c:if test="${fn:length(titleOptionsList)>0}">
					<c:forEach items="${titleOptionsList}" var="toList">
						<c:if test="${tList.typename == toList.typename}">
							<div class="questionDiv">
								<!-- <input type="hidden" id="${tleList.siid}" name="siid" value="${tleList.siid}"> -->
								${toList.sequence}、${toList.question}<br>
								<span style="font-size: 15px;">
									<c:forEach items="${toList.optiosList}" var="optList">
										${optList}
									</c:forEach>
								</span>
							</div>
							<br><br>
						</c:if>
					</c:forEach>
				</c:if>
		</c:forEach>
		<input type="hidden" id="surveyid" name="surveyid" value="${k_survey_id }">
		<input type="hidden" id="loginid" name="loginid" value="${loginid}">
		<input type="hidden" id="loginname" name="loginname" value="${loginname}">
		<input type="hidden" id="tempSeq" name="tempSeq" >
	</div>

</form>

</body>
</html>

<script language="javascript">

	var btnSubmit ;
	$(function (){
		if("${view}" == "view") {
			$("#submitpaper").css("display","none");
			$("#time").html("");
		}else {
			window.onbeforeunload = function (){
				if(!btnSubmit){
					return "您是否确定关闭？";
				}
			}
		}
	})   
	
	
	var HKEY_Root,HKEY_Path,HKEY_Key;    
	HKEY_Root="HKEY_CURRENT_USER";    
	HKEY_Path="\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";   
	
	//设置网页打印的页眉页脚和页边距   
	function PageSetup_Null()    
	{    
		 try    
		 {    
			  var Wsh=new ActiveXObject("WScript.Shell");    
			  HKEY_Key="header";    
			//设置页眉（为空）   
			  Wsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"");    
			  HKEY_Key="footer";    
			//设置页脚（为空）   
			  Wsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"");   
		}catch(e){
			//alert(111);
		 }    
	}       

	window.onbeforeprint = function (){
		PageSetup_Null();
		if(document.getElementById("butDiv")){
			document.getElementById("butDiv").style.display = "none" ;
		}
	}
	
	window.onafterprint = function (){
		if(document.getElementById("butDiv")){
			document.getElementById("butDiv").style.display = "" ;
		}
	}
	
	
	function submitPaper() {
		var loginid = document.getElementById("loginid").value;
		btnSubmit = true;
		if(loginid==null || loginid==""){
			document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/surveyItem.do?method=saveSurveyItemAnswer" ;
		}else{
			document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/surveyItem.do?method=saveSurveyItemAnswers" ;
		}
		document.getElementById("thisForm").submit(); 
	}
	
	function f_setValue(t){
		document.getElementById(t.forValue).value = t.anotherValue +"$##$"+document.getElementById(t.id).value;
	}
	
	
	// 解除 readonly
	function disReadonly(id){
		var obj = document.getElementById(id);
		if(obj.type=="radio"){
			var objs = document.getElementsByName(obj.name);
			var textObj = document.getElementsByName(obj.name+obj.value.substring(obj.value.indexOf("_**_")));

			if(textObj.length>0){
				if(("id_"+id)==textObj[0].id){
					textObj[0].readOnly=false;
					document.getElementById("tempSeq").value = obj.value.substring(obj.value.indexOf("_**_")+4); 
				}else{
					textObj[0].value="";
					textObj[0].readOnly=true;
				}
			}else{
				var tempSeq = document.getElementById("tempSeq").value;
				if(document.getElementById(obj.name+"_**_"+tempSeq)){
					document.getElementById(obj.name+"_**_"+tempSeq).value="";
					document.getElementById(obj.name+"_**_"+tempSeq).readOnly=true;
				}else{
					// 初始化 的时候   没有  tempSeq ；所以 让 tempSeq = 1 到 20 ，单选题 的选项超过 20 个 后就不支持了 得 改到 该题目的选项的 个数才行。
					for(var i=0;i<20;i++){
						if(document.getElementById(obj.name+"_**_"+i)){
							document.getElementById(obj.name+"_**_"+i).value="";
							document.getElementById(obj.name+"_**_"+i).readOnly=true;
						}
					}
				}
			}
		}else{
			if(obj.checked){
				document.getElementById("id_"+id).readOnly=false;
			}else{
				document.getElementById("id_"+id).value="";
				document.getElementById("id_"+id).readOnly=true;
			}
		}
	}
	
	// 提示
	function prompt(id){
		var obj = document.getElementById("id_"+id);
		if(obj.readOnly){
			alert("请选中相应选项!");
		}
	}
	
</script>