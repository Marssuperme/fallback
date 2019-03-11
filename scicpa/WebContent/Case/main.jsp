<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="mt"   uri="http://www.matech.cn/tag" %>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>案例库查询</title>
<script src="${pageContext.request.contextPath}/JS/jquery.tree.js" type="text/javascript" ></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/jquery.tree.css"/>

<style type="text/css">
	
	body {padding:0px;margin:0px ;font-size: 12px ;}

	.tree {border: #eff7e2 1px solid;width: 20%;height:100%;overflow:auto;float: left;} 
	
	.treeTitle {
		background:#eff7e2 ;
		width:100%;
		height : 27px ;
		line-height: 27px ;
		color: #125908 ;
		font-size: 14px; 
		font-weight: bold;
		padding-left: 5px;
	}
	
	.gridFrame {
		width: 79%; 
		height:100%;
		border: #eff7e2 1px solid;
		float: left;
		margin-left: 5px ;
		padding: 5px ;
	}
	
	.tools {
		width:100% ;
		height:27px ;
		float:left;
		padding-top: 3px;
		padding-left:5px;
		margin-bottom: 5px;
	} 
</style>

</head>
<body>
	<input type="hidden" value="" id="fullPath" name="fullPath">
	<div style="height:100%;width:100%;">
	 	<div class="tree">
	 		<div class="treeTitle">案例库分类浏览查询</div>
	        <div id="tree">
	            
	        </div>
	    </div>
	    <div class="gridFrame">
		    <div class="tools">
		    	&nbsp;<input id="pass" icon='icon-add' type='button' onclick="goAdd();" value='我要新增案例'>
		    	<c:if test="${isCicpa ==true}">
		    	&nbsp;<input id="pass" icon='icon-config' type='button' onclick="audit();" value='审核案例'>
		    	</c:if>
		    </div>
		    	<mt:DataGridPrintByBean name="caseList"/>
		</div>
	</div>
  <script type="text/javascript">
  		var typeId = "" ;
         $(function() {
             var options = { 
            	url: "${pageContext.request.contextPath}/common/case.do?method=getTree", 
                theme: "bbit-tree-lines bbit-tree-arrows", //bbit-tree-lines ,bbit-tree-no-lines,bbit-tree-arrows
            	onnodeclick:function(item){
            	
            		typeId = item.id ;
            		$("#fullPath").val(item.fullPath) ;
            		goSearch("caseList");
            	}
            };
           $("#tree").treeview(options);   
        });
        
        
        function view(chooseValue,typeid) {
        	if(chooseValue == "") {
        		return ;
        	}
        	window.open("${pageContext.request.contextPath}/common/case.do?method=view&id="+chooseValue+"&typeid="+typeid);
        }
        
        function audit() {
        	window.open("${pageContext.request.contextPath}/common/case.do?method=auditList");
        }
        
        function goAdd() {
        	if(typeId == "") {
        		alert("请在左边选择对应分类下新增案例！");
        		return;
        	}
        	window.location = "${pageContext.request.contextPath}/common/case.do?method=addView&typeId="+typeId ;
        }
    </script>
</body>
</html>
