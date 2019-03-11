<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="mt"   uri="http://www.matech.cn/tag" %>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@include file="/Sys_INCLUDE/calendar_include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增问题</title>

<style>
#desc {
		height : 27px ;
		line-height: 27px ;
		color: #125908 ;
		font-size: 14px; 
		font-weight: bold;
		padding-left: 5px;
	}
	
#main{
	padding-left:30px; 
	padding-right:50px; 
	width: 80%;
}

#main table{
	width: 100%;
	
}
</style>
</head>
<body>
	<form name="thisForm" id="thisForm" method="post">
	<div id="desc">请输入您要提问的问题：</div>
	<div style="height:1px;border-top:1px solid #aabbcc;width: 100%;"></div>
	<div id="main">
		<table cellpadding="0" cellspacing="5" border="0" align="left">
			<tr>
				<td align="right">标题：</td>
				<td><input type="text" name="title" id="title" size="100"></td>
			</tr>
			
			<tr>
				<td align="right">分类：</td>
				<td>
					<input type="text" name="ctype_CH" id="ctype_CH" size="100"  
							onfocus="onPopDivClick(this);" 
							onkeydown="onKeyDownEvent();"
							onkeyup="onKeyUpEvent();"
							onclick="onPopDivClick(this);"
							onchange="f_setType(this);"
							norestorehint="true"
							noinput="true"
							autoid="69" >
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<img src="${pageContext.request.contextPath}/icons/money.png" width="16" height="16">
					悬赏分：</td>
				<td>
					<select name="rewardMark" id="rewardMark">
						<option value="0">0</option>
						<option value="5">5</option>
					</select>
					
					提问需要扣除您相应资源分，您现有拥有资源分：<input type="text" id="resource" name="resource" value="${grade.resource}" style="border: 0;" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap">问题内容：</td>
				<td align="left" height="500"><textarea id='question' name="question"></textarea></td>
			</tr>
			
		</table>
	</div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td height="22" colspan="3">&nbsp;</td>
	  </tr>
	  <tr>
	    <td width="37%" align="right">
	      <input type="button" icon='icon-save' name="next" value="提交"  onclick="goSave();" >
	    </td>
	    <td width="2%">&nbsp;</td>
	    <td width="55%">
	    	<input type="button" icon='icon-back' value="返 回" onclick="window.history.back();">
	    </td>
	  </tr>
	</table>
	
	<input type="hidden" id="ctype" name="ctype" value="${ctype}">
	
	<input type="hidden" id="typeId" name="typeId" value="${typeId}">
	<form>
  <script type="text/javascript">
  
  		document.getElementById("title").focus();
        
        initHtmlbox("question","100%","100%");
        
        // 加载问题类型
        var url = "";
		var request = "";
		url="${pageContext.request.contextPath}/common/question.do?method=getQuestionType";
		request = "&ctype=CH";
		var resText_CH = ajaxLoadPageSynch(url,request);
		
		var obj_array_CH_temp = eval('('+resText_CH+')');
		var obj_array_CH = [];
		for(var i=0;i<obj_array_CH_temp.length;i++){
			obj_array_CH.push(obj_array_CH_temp[i].ctype);
		}
			
		url="${pageContext.request.contextPath}/common/question.do?method=getQuestionType";
		request = "&ctype=EN";
		var resText_EN = ajaxLoadPageSynch(url,request);
		
		var obj_array_EN_temp = eval('('+resText_EN+')');
		var obj_array_EN = [];
        for(var i=0;i<obj_array_EN_temp.length;i++){
			obj_array_EN.push(obj_array_EN_temp[i].ctype);
		}
		
        // 设置类型
        function f_setType(t){
        	var ctype_CH = obj_array_CH;
        	var ctype_EN = obj_array_EN;
        	// 缺省为其他
        	document.getElementById("ctype").value = "other";
        	
        	for(var i=0;i<ctype_CH.length;i++){
        		if(t.value == ctype_CH[i]){
        			document.getElementById("ctype").value = ctype_EN[i];
        			break;
        		}
        	}
        }
        
        
		function goSave() {
			var resource = document.getElementById("resource").value * 1;
			var rewardMark = document.getElementById("rewardMark").value * 1;
			var title = document.getElementById("title");
			var ctype_CH = document.getElementById("ctype_CH");
			var question = document.getElementById("question");
			
			if(title.value == "") {
				alert("标题不能为空!");
				title.focus();
				return;
			}
			
			if(ctype_CH.value == "") {
				alert("分类不能为空!");
				ctype_CH.focus();
				return;
			}
			
			if(question.value == "") {
				alert("问题内容不能为空!");
				question.focus();
				return;
			}
			
			if(rewardMark > 0 && rewardMark > resource) {
				alert("对不起，您的资源分不足。请减少悬赏!");
				return;
			}
			
			document.thisForm.action = "${pageContext.request.contextPath}/common/question.do?method=save" ;
			document.thisForm.submit();
		}
    </script>
</body>
</html>
