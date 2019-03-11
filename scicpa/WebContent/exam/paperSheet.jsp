<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线考试</title>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<style>

	body {
		margin: 0px ;
		padding: 0px ;
	}
	
	.tools {
		width:100% ;
		height:40px ;
		background-color:#d5c59f;
		padding-top: 5px;
		padding-left:10px;
	    position:fixed;
	    _position:absolute;
	    left:0px;
	    top: 0 px ;
	    line-height: 40px;
	} 
	
	.content {
		width:100% ;
		padding-top: 50px;
		padding-left:20px;
		padding-right:30px;
	}
	.questionDiv {
		margin-left: 10px;
		margin-top: 20px;
	}

	
</style>

</head>
<body>

<div class="tools">
	<span id="time" style="width:100px;margin-right:50px;">距离考试结束还有：</span>
	<span  style="width:100px;">
		<input icon="icon-apply" type="button" id="submitpaper" value="已完成，交卷" onclick="submitPaper();"/> &nbsp;&nbsp;
		<input icon="icon-cancel" type="button" value="关闭" onclick="window.close();"/>&nbsp;&nbsp;
	</span>
	<span  style="width:100px;font-size:15px;font-weight: bold;margin-left:50px;">
		${paper.title}  
	</span>
</div>

<div class="content">
	<form name="thisForm" method="post" action="" id="thisForm">
			<input type="hidden" value="${examId}" id="examId" name="examId"/>
			<input type="hidden" value="${courseId}" id="courseId" name="courseId"/>
				<c:if test="${fn:length(singleList)>0}">
					<p>一、单选题</p>
					<c:forEach items="${singleList}" var="single">
						<div class="questionDiv">
							${single.sequence}、${single.question}<br/>
							<span>${single.options}</span>
						</div>
					</c:forEach>
				</c:if>
				
				<c:if test="${fn:length(multiList)>0}">
				<br/><br/><br/>
					<p>二、多选题</p>
					<c:forEach items="${multiList}" var="multil">
						<div class="questionDiv">
							${multil.sequence}、${multil.question}<br/>
							<span>${multil.options}</span>
						</div>
					</c:forEach>
				</c:if>
				
				
				<c:if test="${fn:length(multiList)>0}">
				<br/><br/><br/>
					<p>三、判断题</p>
					<c:forEach items="${judgeList}" var="judge">
						<div class="questionDiv">
							${judge.sequence}、${judge.question}<br/>
							<span>
								<c:if test="${judge.userAnswer == '对'}">
									<input type="radio" value="对" name="${judge.id}" checked="checked"/> 对 &nbsp;&nbsp;
									<input type="radio" value="错" name="${judge.id}"/> 错
								</c:if>
								
								<c:if test="${judge.userAnswer == '错'}">
									<input type="radio" value="对" name="${judge.id}" /> 对 &nbsp;&nbsp;
									<input type="radio" value="错" name="${judge.id}" checked="checked"/> 错
								</c:if>
								
								<c:if test="${judge.userAnswer == ''}">
									<input type="radio" value="对" name="${judge.id}"/> 对 &nbsp;&nbsp;
									<input type="radio" value="错" name="${judge.id}"/> 错
								</c:if>
							</span>
						</div>
					</c:forEach>
				</c:if>
				
				<c:if test="${fn:length(fillList)>0}">
				<br/><br/><br/>
					<p>四、填空题</p>
					<c:forEach items="${fillList}" var="fill">
						<div class="questionDiv">
							${fill.sequence}、${fill.question}<br/>
							<span>
								<input type="text" id="${fill.id}" value="${fill.userAnswer}"/>
							</span>
						</div>
					</c:forEach>
				</c:if>
				
				
				<c:if test="${fn:length(qaList)>0}">
				<br/><br/><br/>
					<p>五、问答题</p>
					<c:forEach items="${qaList}" var="qa">
						<div class="questionDiv">
							${qa.sequence}、${qa.question}<br/>
							<span>
								<textarea rows="15" cols="100" name="${qa.id}" id="${qa.id}">${qa.userAnswer}</textarea>
							</span>
						</div>
					</c:forEach>
				</c:if>
			</form>
</div>


<script language="javascript">
	var maxtime = parseInt("${paper.totaltime}")*60; //一个小时，按秒计算，自己调整!   
	function CountDown(){   
		 if(maxtime>=0){   
			 minutes = Math.floor(maxtime/60);   
			 seconds = Math.floor(maxtime%60);   
			 msg = "距离考试结束还有:"+minutes+"分"+seconds+"秒";   
			 document.all["time"].innerHTML=msg;   
			 if(maxtime == 5*60) alert('注意，考试还剩5分钟!');   
			 	--maxtime;   
		 }   
		 else{   
			 clearInterval(timer);   
			 alert("时间到，考试结束!");   
		 }   
	}
	var btnSubmit ;
	$(function (){
		
		if("${view}" == "view") {
			$("#submitpaper").css("display","none");
			$("#time").html("");
		}else {
			var maxtime = parseInt("${paper.totaltime}")*60 ;
			var min = parseInt(maxtime/60)  ;
			var second = maxtime/60 ;
			//初始化考试时间
			msg = "距离考试结束还有:"+min+"分0秒";   
			$("#time").html(msg);
			timer = setInterval("CountDown()",1000); 
			
			window.onbeforeunload = function (){
				if(!btnSubmit){
					return "您正在进行考试中，关闭页面系统将视同您放弃本次考试，您是否确定关闭？";
				}
			}
		}
	})   
	
	function submitPaper() {
		btnSubmit = true ;
		document.thisForm.action = "${pageContext.request.contextPath}/common/exam.do?method=add&view=view" ;
		document.thisForm.submit(); 
	}
	
</script>

</body>
</html>
 