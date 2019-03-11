<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="STYLESHEET" type="text/css" href="${pageContext.request.contextPath}/CSS/index.css">
<title>用户排名</title>
</head>
<body>


<table class="indexList" style="width: 400px;">
	<tr>
		<th align="left" colspan="3">我的分数</th>
	</tr>
	
	<tr align="center">
		<td>我的资源分</td>
		<td>我的专家分</td>
		<td>我的总分</td>
	</tr>
	
	<tr align="center">
		<td>${grade.resource}</td>
		<td>${grade.expert}</td>
		<td>${grade.expert*100+grade.resource}</td>
	</tr>
</table>

<br/><br/>
<table class="indexList" style="width: 400px;">
	<tr>
		<th align="left" colspan="3">我的排名</th>
	</tr>
	
	<tr align="center">
		<td>资源分排名</td>
		<td>专家分排名</td>
		<td>总分排名</td>
		
	</tr>
	
	<tr align="center">	
		<td>${resource}</td>
		<td>${expert}</td>
		<td>${total}</td>
	</tr>
</table>

<br/><br/>
<table class="indexBox" style="width: 600px;">
	<tr>
		<th align="left" >积分规则</th>
	</tr>
	
	<tr>
		<td style="line-height: 150%;">
			专家分 - 初始值 0<br/>
			资源分 - 初始值 100<br/>
  			总分 - 专家分*100+资源分<br/><br/>
			
			所有问问题，可以悬赏，悬赏耗费资源分（0、5、10、20、50）<br/>
			回答问题有一个结贴操作：选一个最佳答案/没有答案（资源分数不退回）<br/>
			问题状态：等待回答、结贴、有答案<br/><br/>
			
			普通回答：资源分+2<br/>
			最佳回答：专家分2分+悬赏资源分（0、5、10、20、50分）<br/><br/>
			
			

			在模板库点击下载，扣除新增者规定扣除的资源分<br/>
			在模板库规定下载者需扣除分数，新增成功，取得审核通过后，得到下载者被扣取的资源分<br/>
			在案例库、法律法规库新增成功，取得审核通过后：专家分3分<br/>
		</td>
	</tr>
	
	
</table>

</body>
</html>