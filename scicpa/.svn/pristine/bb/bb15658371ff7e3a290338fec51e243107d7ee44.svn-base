<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/Sys_INCLUDE/include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>问题库</title>

<script src="${pageContext.request.contextPath}/JS/jquery.tree.js" type="text/javascript" ></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/jquery.tree.css"/>

<style type="text/css">
	
	body { 
		font-size: 12px ;
		padding: 0px;
		margin: 0px;
	}

	.tree {
		border: #eff7e2 1px solid;
		width: 20%; 
		height:100%;
		overflow:auto;
		float: left;
	} 
	
	.treeTitle {
		background:#eff7e2 ;
		width:100%;
		height : 27px ;
		line-height: 27px ;
		color: #506a27 ;
		font-size: 14px; 
		font-family: cursive;
		font-weight: bold;
		padding-left: 5px;
	}
	
	.gridFrame {
		width: 79%; 
		height:100%;
		border: #eff7e2 1px solid;
		float: left;
		margin-left:2px ;
		padding: 2px ;
	}
	
	.tools {
		width:100% ;
		height:27px ;
		float:left;
		padding-left:5px;
		margin-bottom: 5px;
		line-height: 27px;
	} 
</style>

</head>
<body>
	<input type="hidden" value="" id="fullPath" name="fullPath">
	<input type="hidden" value="" id="ctype" name="ctype">
	<input type="hidden" value="${mine}" id="mine" name="mine">
	<div style="margin:0 0 10 100">
		<input type="text" size="100" id="searchQuestion" name="searchQuestion" style="height:30px;">
		<input id="pass" icon='icon-search' type='button' onclick="search();" value='搜索答案'>
		&nbsp;<input id="pass" icon='icon-question' type='button' onclick="goAdd();" value='我要提问'>
	</div>
	<div style="height:100%;width:100%;">
	 	<div class="tree">
	 		<div class="treeTitle">问题库</div>
	        <div id="tree">
	            
	        </div>
	    </div>
	    <div class="gridFrame">
	    
		    <mt:DataGridPrintByBean name="questionList"/>
		</div>
	</div>
  <script type="text/javascript">
  
         $(function() {
             var options = { 
            	url: "${pageContext.request.contextPath}/common/question.do?method=getTree&mine="+$("#mine").val(), 
                theme: "bbit-tree-lines bbit-tree-arrows", //bbit-tree-lines ,bbit-tree-no-lines,bbit-tree-arrows
            	onnodeclick:function(item){
            		$("#fullPath").val(item.fullPath) ;
            		$("#ctype").val(item.value) ;
            		goSearch("questionList");
            	}
            };
           $("#tree").treeview(options);   
        });
         
         function search() {
        	 goSearch("questionList");
         }
        
          
        function view(chooseValue) {
        	if(chooseValue == "") {
        		return  ;
        	}
        	window.location = "${pageContext.request.contextPath}/common/question.do?method=view&id="+chooseValue;
        }
        
        function goAdd() {
        	window.location = "${pageContext.request.contextPath}/common/question.do?method=addView&ctype=other";
        }
    </script>
</body>
</html>
