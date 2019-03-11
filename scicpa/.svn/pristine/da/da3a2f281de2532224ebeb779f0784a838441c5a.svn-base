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


<title>评分项目调查</title>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<style>
.tab{
border-collapse:collapse;border:none;text-align: center;
}
.tab td{border:solid black 1px;padding: 15px;font-size: 15px;}

.input{
border: 0px ;width: 60%;text-align: right;
}

.display{
	display: none; 
}
</style>

</head>
<body>
${sessionScope.userSession.userMap}
<form id="thisForm" name="thisForm" method="post" action="" >
	<div style="width: 100%;background-color:#d5c59f;text-align: center;" id="butDiv">
		<div style="margin-top: 5px;margin-bottom: 5px;">
			<c:if test="${opt!='see'}">
				<input type="button" icon="icon-save" id="submitpaper" value="提交" onclick="submitPaper();" />  
				<c:if test="${userType=='office'}">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="cancle" value="关闭" onclick="window.close();" />
				</c:if> 
			</c:if>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" icon="icon-print" id="print" value="打印" onclick="window.print();" />  
		</div>
	</div>
	<br><br>
	
	<center><span style="font-size:25px;">${surname}</span></center>
		
	<br>
	<table class="tab" align="center" width="1100px;">
		<tr>
			<td width="10%">考核内容</td>
			<td width="50%">分解指标</td>
			<td width="10%">标准分</td>
			<td width="10%">市注协<br>党组织<br>自评</td>
			<td width="10%">省注协<br>党组织<br>评分</td>		
		</tr>
		<c:forEach items="${allList}" var="aList">
			<c:forEach items="${typeList}" var="tList" >
				<c:if test="${aList.typedetail==tList.typedetail}">
					<tr>
						<c:if test="${aList.typesequence=='1'}">
							<td rowspan="${tList.counts }" >
								<span style="writing-mode:tb-rl;height: 120px;font-size: 15px;">${aList.typename }</span><br>${tList.scoretotal }&nbsp;&nbsp;分
							</td>
						</c:if>
						<td style="text-align: left">${aList.sequence }.&nbsp;&nbsp;${aList.question }</td>
						<td><input id="${aList.id}_score" name="${aList.id}_score" value="${aList.score }" size="1" style="border: 0px;text-align: center;" readonly="readonly">分</td>
						<c:if test="${sessionScope.userSession.userMap.ctypetabname=='K_Company'}">
						<td>
							<c:choose>
								<c:when test="${userType=='office'}">
									<input id="${aList.id}" name="${aList.id}" value="${aList.score1 }" size="3" style="text-align: center;height: 0px;border: 0px;border-bottom: 1px solid black; " onkeyup="f_moneys(this);" onpaste="return false">&nbsp;&nbsp;分
								</c:when>
								<c:otherwise>
									<input id="${aList.id}_score1" name="${aList.id}_score1" value="${aList.score1 }" size="3" style="text-align: center;border: 0px; " readonly="readonly" onpaste="return false">&nbsp;&nbsp;分
								</c:otherwise>
							</c:choose>
						</td>
						</c:if>
						<td>
							<c:choose>
								<c:when test="${userType=='city'}">
									<input id="${aList.id}" name="${aList.id}" value="${aList.score2 }" size="3" style="text-align: center;height: 0px;border: 0px;border-bottom: 1px solid black; " onkeyup="f_moneys(this);" onpaste="return false">&nbsp;&nbsp;分
								</c:when>
								<c:otherwise>
									<input id="${aList.id}_score2" name="${aList.id}_score2" value="${aList.score2 }" size="3" style="text-align: center;border: 0px; " readonly="readonly" onpaste="return false">&nbsp;&nbsp;分
								</c:otherwise>
							</c:choose>
						</td>
						
						<c:if test="${sessionScope.userSession.userMap.ctypetabname!='K_Company'}">
						<td>
							<c:choose>
								<c:when test="${userType=='province'}">
									<input id="${aList.id}" name="${aList.id}" value="${aList.score3 }" size="3" style="text-align: center;height: 0px;border: 0px;border-bottom: 1px solid black; " onkeyup="f_moneys(this);" onpaste="return false">&nbsp;&nbsp;分
								</c:when>
								<c:otherwise>
									<input id="${aList.id}_score3" name="${aList.id}_score3" value="${aList.score3 }" size="3" style="text-align: center;border: 0px; " readonly="readonly" onpaste="return false">&nbsp;&nbsp;分
								</c:otherwise>
							</c:choose>
						</td>
						</c:if>
					</tr>
				</c:if>
			</c:forEach>
		</c:forEach>
	</table>
	<br>
	<div style="text-align: left;margin-left: 100px;font-size: 14px;line-height:30px;">
		${remark }
	</div>
	<input type="hidden" id="surveyid" name="surveyid" value="${k_survey_id }">
	<input type="hidden" id="userType" name="userType" value="${userType}">
	<input type="hidden" id="loginid" name="loginid" value="${loginid}">
	<input type="hidden" id="loginname" name="loginname" value="${userSession.userMap.loginname}">
	
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
	
	
	// 提交
	function submitPaper() {
		
		// 检查用户填的分数
		if(!f_checkScore()){
			return;
		};
		
		var loginid = document.getElementById("loginid").value;
		btnSubmit = true;
		document.getElementById("thisForm").action = "${pageContext.request.contextPath}/common/scoreItem.do?method=saveScoreItemAnswer" ;
		document.getElementById("thisForm").submit(); 
	}
	
	
	// 检查数字
	function f_moneys(t){
		t.value = t.value.replace(/[^\d\.\\-]/g,'');
		if(t.value*1<0){
			t.style.color = "red";
		}else{
			t.style.color = "black";
		}
	} 
	
	// 检查分数
	function f_checkScore(){
		var form_obj = document.all; 
		//form的值
		for (i=0;i<form_obj.length ;i++ ) {
			var obj=form_obj[i];
			if (obj.tagName=="INPUT" && obj.type=="text") {
				// 用户录入的分数
				if(obj.id.indexOf("score")<0 && obj.id!="surveyid" && obj.id!="loginid" && obj.id!="loginname"){
					var user_value = obj.value;
					if(user_value==""){
						alert("请填写分数！");
						obj.select();
						return false;
					}else if(isNaN(user_value)){
						alert("请填写合法的分数！");
						obj.select();
						return false;
					}else{
						// 标准分数
						var standard_value = document.getElementById(obj.id+"_score").value; 
						if(user_value*1>standard_value*1){
							alert("分数不能大于规定的标准分数！");
							obj.select();
							return false;	
						}
					}
				}
			}
		}
		// 所有需要检查的文本框都通过检查了
		return true;
	}
	
	
	
</script>