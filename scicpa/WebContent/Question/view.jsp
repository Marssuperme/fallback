<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<html>
<head>
<title>查看问题</title>
<style>
	body {
		height: 100%;
		font-size: 14px;
	}
	.outContent {
		border: 1px solid #88c369 ;
		width: 70%;
		margin: 20 0px;
	}
	 
	.inContent {
		border: 2px solid #e6f4d0 ;

		margin: 1px;
	}
	
	.outContent2 {
		border: 1px solid #e3d686 ;

		width: 70%;
		margin: 20 0px;
		
	}
	 
	.inContent2 {
		border: 2px solid #f2eab7 ;
	
		margin: 1px;
	}
	
	.title2 {
		padding:5px;
		height: 30px;
		background-color: #f2eab7;
		color: #000000;
		font-size: 14px;
		font-weight: bold;
	}
	
	.title {
		padding:5px;
		height: 30px;
		background-color: #e6f4d0;
		color: #007500;
		font-size: 14px;
		font-weight: bold;
	}
	
	.dash{
		border-top: 1px dashed #d1dfbb;
		height: 1px;
		margin:0 10px;
		
	}
	
	a:visited{
		nothing;
	}
	
	.datetime {
		color: #cccccc;
		font-size: 12px;
	}
	
	* {
		font-size: 14px;
	}
	
	.bottom {
		text-align: right;
		margin:0 10px;
		font-size: 12px;
	}
	
	.bottomUser {
		color: blue;
		font-size: 12px;
	}
	
	.answer {
		background-color: #eeeeee;
	}
	
</style>

</head>
<body>
	首页  >  <a href="${pageContext.request.contextPath}/common/question.do?method=main">问题库</a>
	<div class="outContent">
		<div class="inContent">
			<div class="title">
				<img src="${pageContext.request.contextPath}/icons/question_blue.png" width="16" height="16" />&nbsp;
				${question.state}
			</div>
			<div style="padding:10px;">
			
				<strong>${question.title}</strong>
				<div style="margin:10px;"><img src="${pageContext.request.contextPath}/icons/money.png" width="16" height="16" />&nbsp;悬赏分:&nbsp;${question.rewardMark}</div>
				
				${question.question}
				
				<!-- 问题补充 -->			
				<c:if test="${question.explan != ''}">
				<p>
					<strong>问题补充：</strong><span class="datetime">${question.explanDate}</span>
					<br/>
					${question.explan}
				</p>
				</c:if>
				
				<div class="bottom">提问者：<span class="bottomUser">${question.userName}</span>&nbsp;&nbsp;<span class="datetime">${question.createDate}</span></div>
				
				<span>
					<c:if test="${userSession.userMap.loginid == question.userId && question.state == '未解决'}">
						<input type='button' onclick="goExplan();" value='补充问题'>
						<input type='button' onclick="noAnswer();" value='无满意答案'>
						
						<div id="explanDiv" style="display: none;">
							<form id="explanForm" name="explanForm" method="post">
								<textarea cols="80" rows="10" id="explan" name="explan">${question.explan}</textarea>
								<p>
									<input icon='icon-config' type='button' onclick="saveExplan();" value='确 认'>
									<input icon='icon-config' type='button' onclick="exitExplan();" value='取 消'>
								</p>
							</form>
						</div>
					</c:if>
				</span>
			</div>
		</div>
	</div>
	
	<c:if test="${userSession.userMap.loginid != question.userId && question.state == '未解决' && !isAnswer}">
	<div class="outContent">
		<div class="inContent">
			<div style="padding:10px;">
				<form id="thisForm" name="thisForm" method="post">
					<input type="hidden" id="questionId" name="questionId" value="${question.id}">
					<table>
						<tr>
							<td nowrap="nowrap">我来回答：</td>
							<td><textarea cols="80" rows="10" id="answer" name="answer"></textarea> </td>
						</tr>
						<tr>
							<td>&nbsp; </td>
							<td><input id="pass" icon='icon-config' type='button' onclick="saveAnswer();" value='提 交'></td>
							
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<br/>
	</c:if>
	
	<div class="outContent2" id="bestAnswer">
		<div class="inContent2">
			<div class="title2">
				<img src="${pageContext.request.contextPath}/icons/offset.png" width="16" height="16" />&nbsp;
				最佳答案
			</div>
			<div style="padding:10px;">
				${bestAnswer.answer}
			<div class="bottom">回答者：<span class="bottomUser">${bestAnswer.userName}</span> &nbsp;&nbsp;<span class="datetime">${bestAnswer.date}</span></div>
			</div>
			<div class="dash"></div>
		</div>
	</div>
	
	<div class="outContent" id="otherAnswer">
		<div class="inContent">
			<div class="title">
				<img src="${pageContext.request.contextPath}/icons/collapse-all.gif" width="16" height="16" />&nbsp;
				回答
			</div>
			<c:forEach items="${answers}" var="answer">
			
				<input type="hidden" id="answerUserId_${answer.userId}" name="answerUserId" value="${answer.userId}" />
				<div style="padding:10px;">
					${answer.answer}
				<div class="bottom">回答者：<span class="bottomUser">${answer.userName}</span> &nbsp;&nbsp;<span class="datetime">${answer.date}</span></div>
				</div>
				
				<span style="padding-left: 10px;" >
					<!-- 如果是提问者 -->
					<c:if test="${question.state == '未解决' && userSession.userMap.loginid == question.userId}">
						<input type="button" onclick="answer('${answer.id}');" value="采纳为答案"/>
					</c:if>
					
					<!-- 如果是回答者 -->
					<c:if test="${question.state == '未解决' && userSession.userMap.loginid == answer.userId}">
						<input type="button" onclick="editAnswer();" value="修改答案"/>
						
						<div id="editdiv" style="display: none;">
						<form id="editForm" name="editForm" method="post">
							<input type="hidden" id="updateAnswerId" name="updateAnswerId" value="${answer.id}" />
							<textarea cols="80" rows="10" id="updateAnswer" name="updateAnswer">${answer.answer}</textarea>
							<p>
								<input icon='icon-config' type='button' onclick="updateAnswerSub();" value='确 认'>
								<input icon='icon-config' type='button' onclick="exitEditAnswer();" value='取 消'>
							</p>
						</form>
						</div>
					</c:if>
					
				</span>
				
				<div class="dash"></div>
			
			</c:forEach>
		</div>
	</div>
	
</body>
	<script type="text/javascript">
		$(function () {
			$("#myAnswer").css("display","none") ;
			if("${fn:length(answers)}" == 0){
				$("#otherAnswer").css("display","none") ;
				$("#myAnswer").css("display","") ;
			}
			
			if("${bestAnswer}" == "null" || "${bestAnswer}" == "") {
				$("#bestAnswer").css("display","none") ;
			}
		})	;
		
		function showMyAswer() {
			$("#myAnswer").css("display","") ;
		}
		
		function saveAnswer() {
			if($.trim($("#answer").val()) == "") {
				alert("您回答的内容不能为空！");
				return ;
			}
			document.thisForm.action = "${pageContext.request.contextPath}/common/question.do?method=addAnswer" ;
			document.thisForm.submit();
		}
		
		function answer(id) {
			window.location = "${pageContext.request.contextPath}/common/question.do?method=bestAnswer&questionId=${question.id}&answerId=" + id;
		}
		
		function noAnswer() {
			window.location = "${pageContext.request.contextPath}/common/question.do?method=noAnswer&questionId=${question.id}";
		}
		
		function updateAnswerSub() {
			if($.trim($("#updateAnswer").val()) == "") {
				alert("您回答的内容不能为空！");
				return ;
			}
			document.editForm.action = "${pageContext.request.contextPath}/common/question.do?method=updateAnswer" ;
			document.editForm.submit();
		}
		
		function editAnswer() {
			document.getElementById("editdiv").style.display = "";
		}
		
		function exitEditAnswer() {
			document.getElementById("editdiv").style.display = "none";
		}
		
		function goExplan() {
			document.getElementById("explanDiv").style.display = "";
		}
		
		function exitExplan() {
			document.getElementById("explanDiv").style.display = "none";
		}
		
		function saveExplan() {
			if($.trim($("#explan").val()) == "") {
				alert("补充问题的内容不能为空！");
				return ;
			}
			document.explanForm.action = "${pageContext.request.contextPath}/common/question.do?method=saveExplan&questionId=${question.id}" ;
			document.explanForm.submit();
		}
		
	</script>
</html>
 