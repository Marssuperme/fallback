<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<%@ taglib prefix="mt"   uri="http://www.matech.cn/tag" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="/Web/JS/jquery.tree.js" type="text/javascript" ></script>
<link rel="stylesheet" href="/Web/CSS/jquery.tree.css"/>

<style type="text/css">

	body {
		padding-left: 10px ;
		padding-right: 5px ;
		font-size: 12px ;
	}

	.formTitle {
		color: #4A74BC;
		font-weight: bold;
		font-size: 14px;
		text-align:center;
		width:100%;
		margin-top: 10px;
	}
	
	.tree {
		border: #c3daf9 1px solid;
		background:#fffcec;
		width: 20%; 
		height:600px;
		overflow:auto;
		float: left;
	} 
	
	.treeTitle {
		background:#e6f4d0 ;
		width:100%;
		height : 27px ;
		border:1px solid #e6f4d0;
		line-height: 27px ;
		color: #125908 ;
		font-size: 14px; 
		font-weight: bold;
		padding-left: 5px;
	}
	
	.gridFrame {
		width: 100%; 
		height:100%;
		border: #c3daf9 1px solid;
		float: left;
		margin-left: 5px ;
		padding: 5px ;
	}
	
	.tools {
		display:none;
		width:100% ;
		height:27px ;
		float:left;
		background-image: url("/Web/images/toolBarBg.gif");
		padding-top: 3px;
		padding-left:5px;
		margin-bottom: 5px;
	} 
</style>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>报告签证经历查询</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css"/>

</head>
<body>
 
<div id="divBlock" style="position:absolute;width:100%;height:100%; z-index:0; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;"></div>
<form name="myform" id="myform" action="" method="post" > 
		
<input type="hidden" value="" id="typeId" name="typeId">
	   <div class="gridFrame" >	 
	    <div style="margin-bottom: 0.5%">
	    	&nbsp;<input id="pass" icon='icon-search' type='button' onclick="f_search();" value='搜索'>
	    </div>
	    
		<div id="search" style="position:absolute;width:50%;height:15%; z-index:0;left:expression((document.body.clientWidth-400)/2);top:expression(this.offsetParent.scrollTop + 70); border:1px solid #6595d6; padding:1px; background:#ffffff; display: none;">
		    <br>
		    <fieldset  style="border: 1px solid lightblue;width:95%;height: 70%;margin-left: 2px;" id="fieldset">
				<legend>
					搜索条件
				</legend>
				<table width="100%" style="margin-left: 15px;">
		    		<tr>
		    			<td colspan="2">业务类型：<input id="ywlx" name="ywlx" style="width: 70%" 
								onkeydown="onKeyDownEvent();"
								onkeyup="onKeyUpEvent();"
								onclick="onPopDivClick(this);"
								norestorehint=true
								autoid=32
								refer=0
								hideresult=true>
		    			</td>
		    		</tr>
		    		<tr>
		    			<td colspan="2">报告文号：<input id="bgwh" name="bgwh" style="width: 70%"></td>
		    		</tr>
	    		</table>
	    		<br>
	    		<table width="90%" style="margin-left: 15%;">
					<tr>
						<td>
							<input id="pass" icon='icon-success' type='button' onclick="f_sure();" value='确定'>
					    	&nbsp;&nbsp;&nbsp;&nbsp; 
					    	<input id="pass" icon='icon-retry' type='button' onclick="f_clear();" value='清空'>
					    	&nbsp;&nbsp;&nbsp;&nbsp; 
					    	<input id="pass" icon='icon-delete' type='button' onclick="f_quxiao();" value='取消'>
					    </td>
					</tr>
		    	</table>
	    	</fieldset>
	    </div>
	  <div style="width:100%;height: 100%;overflow: scroll;"> 
	    	<mt:DataGridPrintByBean name="reportValidate"/>
    </div>
   </div>
</form>
 

</body>

<script type="text/javascript">
	
	// 查看详细
	function f_viewTD(no,type){
		
		var mydo="";
		if (type=="yz001"){
			//验资
			mydo="bbyzb.do";
		}else if (type=="sj001"){
			//审计
			mydo="bbsjb.do";
		}else if (type=="whnj001"){
			//外汇年检
			mydo="bbwhnj.do";
		}else if (type=="sdshsqj001"){
			//所得税
			mydo="bbsdshsqjb.do";
		}else if (type=="ccsssqkcjj001"){
			//财产报损
			mydo="bbccsssqkcjjb.do";
		}else if (type=="qssh001"){
			//清算审计
			mydo="bbqsshb.do";
		}else if (type=="qtssjj001"){
			//其他涉税鉴证
			mydo="bbqtssjjb.do";
		}else if (type=="swdl001"){
			//税务代理
			mydo="bbswdlb.do";
		}else if (type=="zcpg001"){
			//资产评估
			mydo="bbzcpgb.do";
		}else if (type=="qchz001"){
			//清产核资
			mydo="bbqchzb.do";
		}else if (type=="sfkjjd001"){
			//司法鉴定
			mydo="sfkjjdb.do";
		}else if (type=="kjdsh001"){
			//电算化
			mydo="bbkjdshb.do";
		}else if (type=="kjzs001"){
			//会计咨询
			mydo="bbkjzsb.do";
		}else if (type=="bbqt001"){
			//其他
			mydo="bbbbqtb.do";
		}
		
		mydo = "bb.do"; 
		myform.action = "${pageContext.request.contextPath}/common/"+mydo+"?method=addAndEdit&GUID="+no+"&param=update&view=ture&p=ck&typeid="+type;
		//alert(myform.action);
		//myform.target="blank";
		myform.submit();
	}
	
	// 清空
	function f_clear(){
		document.getElementById("ywlx").value = "";
		document.getElementById("bgwh").value = "";
		f_quxiao();
		goSearch("reportValidate");
	}
	
	// 搜索 
	function f_search(){
		document.getElementById("search").style.display = "";
		document.getElementById("divBlock").style.display = "";
	}
	
	// 取消
	function f_quxiao(){
		document.getElementById("search").style.display = "none";
		document.getElementById("divBlock").style.display = "none";
	}
	
	// 确定 
	function f_sure(){
		var j=0;
		$("#search input[type='text']").each(function(){ 
			if(!Testing($(this).val())){
				j=1;
				return false;
			}
			
			});
		if(j==1){
			return false;
		};
		f_quxiao();
		goSearch("reportValidate");
	}
	
	
	
</script>

</html>