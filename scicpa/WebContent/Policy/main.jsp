<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="mt"   uri="http://www.matech.cn/tag" %>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>法律法规查询</title>
<script src="${pageContext.request.contextPath}/JS/jquery.tree.js" type="text/javascript" ></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/jquery.tree.css"/>

<style type="text/css">
	body {
		margin:0px;
		padding:0px;
		width:100%;
		font-size: 12px ;
	}

	.tree {
		border: #eff7e2 1px solid;
		width: 20%; 
		height:100%;
		overflow:auto;
		float: left;
	} 
	
	.treeTitle {
		background:#e6f4d0 ;
		width:100%;
		height : 27px ;
		border:1px solid #eff7e2;
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
		padding-left:5px;
		margin-bottom: 5px;
	} 
</style>

</head>
<body>
	<input type="hidden" value="" id="fullPath" name="fullPath">
	<div style="height:100%;width:100%;">
	 	<div class="tree">
	 		<div class="treeTitle">法律法规分类浏览查询</div>
	        <div id="tree">
	            
	        </div>
	    </div>
	    <div class="gridFrame">
		    <div class="tools">
		    	&nbsp;<input id="pass" icon='icon-add' type='button' onclick="goAdd();" value='我要新增法律法规'>
		    	&nbsp;<input id="pass" icon='icon-search' type='button' onclick="search();" value='全文检索'>
		    	<c:if test="${isCicpa ==true}">
		    		&nbsp;<input id="pass" icon='icon-config' type='button' onclick="audit();" value='审核法律法规'>
		    		&nbsp;<input id="pass" icon='icon-search' type='button' onclick="createHtml();" value='重新生成所有静态文件'>
		    	</c:if>
		    	
		    </div>
		    	<mt:DataGridPrintByBean name="policyList"/>
		</div>
	</div>
  <script type="text/javascript">
  		var typeId1 = "1369" ;
  		var typeId = "" ;
         $(function() {
             var options = { 
            	url: "${pageContext.request.contextPath}/common/policy.do?method=getTree", 
                theme: "bbit-tree-lines bbit-tree-arrows", //bbit-tree-lines ,bbit-tree-no-lines,bbit-tree-arrows
            	onnodeclick:function(item){
            		typeId = item.id ;
            		$("#fullPath").val(item.fullPath) ;
            		goSearch("policyList");
            	}
            };
           $("#tree").treeview(options);   
        });
        function view(chooseValue) {
        	//return;
        	if(chooseValue == "") {
        		return ;
        	}
        	//window.open("${pageContext.request.contextPath}/common/policyHtml/"+chooseValue+".html");
        	window.open("${pageContext.request.contextPath}/common/policy.do?method=view&id="+chooseValue+"&typeId="+typeId1);
        	//window.location="${pageContext.request.contextPath}/common/policy.do?method=view&id="+chooseValue;
        }
         function audit() {
        	window.open("${pageContext.request.contextPath}/common/policy.do?method=auditList");
        }
        
         function search() {
        	window.open("${pageContext.request.contextPath}/common/policy.do?method=searchView&typeId="+typeId1);
        }
        
        function createHtml() {
        	window.location = "${pageContext.request.contextPath}/common/policy.do?method=createHtml" ;
        }
        
        function goAdd() {
        	if(typeId == "") {
        		alert("请在左边选择对应分类下新增法律法规！");
        		return;
        	}
        	window.location = "${pageContext.request.contextPath}/common/policy.do?method=addView&typeId="+typeId ;
        }
        function goSearch(dgName) {
       	  var sv = '';
       	  var sqlWhereVariables = eval("sqlWhereVariables_" + dgName);
       	  	for(var i=0;i<sqlWhereVariables.length;i++){
       	   		var oTT=document.getElementById(sqlWhereVariables[i]);
       	   		typeId1 = oTT.value;//获取分类ID
       	  		if(!oTT) {
       	  			continue;
       	  		}
       	   		sv = sv + "<" + sqlWhereVariables[i] + ">" + oTT.value + "</"+sqlWhereVariables[i]+">";
       		}
       		changeGrid_CH_1(dgName, 'sqlWhereVariable_CH', sv);
       	}
    </script>
</body>
</html>
