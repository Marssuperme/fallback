<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线课程列表</title>

</head>
<body style="height:100%;" >
	<div style="height:100%;">
   		<mt:DataGridPrintByBean name="courseList"/>
	</div>	
</body>

<script type="text/javascript"> 
  	
        function goView(id) {
        	if(id == "") {
        		return;
        	}
        	window.open("${pageContext.request.contextPath}/micfo/course.do?method=view&id="+id);
        }
        
         function goAdd() {
        	window.location = "${pageContext.request.contextPath}/common/template.do?method=addView";
        }
        
        function goExam(courseId) {
        	var url = "${pageContext.request.contextPath}/common/exam.do?method=isExistPaper&courseId="+courseId ;
        	$.post(url,null,function (responseText){
        		if(responseText == "jy"){
        			alert("该试卷已禁用!不能考试");
        			return ;
        		}
        		if(responseText == "noPaper") {
        			alert("该课程的考试信息尚未存在！不能开始考试");
        			return ;
        		}else if(responseText == "finish") {
        			alert("您已经参加过本课程考试了，不能重复考试");
        			return ;
        		}else {
        			window.open("${pageContext.request.contextPath}/common/exam.do?method=list&courseId="+courseId);
        		}
        	}) 
        }
   </script>
</html>
