<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>培训信息</title>
<link rel="stylesheet"	href="${pageContext.request.contextPath}/CSS/main.css" />
<style>
.formTitle {
	color: #4A74BC;
	font-weight: bold;
	font-size: 14px; 
	text-align: center;
	width: 100%;
	margin-top: 10px;
}

.mustSpan {
	color: #FF6600;
	font-family: "宋体";
	font: normal;
	font-size: 9pt;
	padding: 0px;
	margin: 0px;
}
</style>
<style>
H3.tabs {
	PADDING-LEFT: 0px ! important;
	HEIGHT: 26px;
	BACKGROUND-COLOR: #e8f7fc ! important
}

.tab {
	BORDER-RIGHT: #c1d8e0 1px solid;
	PADDING-RIGHT: 10px;
	PADDING-LEFT: 10px;
	FONT-WEIGHT: normal;
	FLOAT: left;
	PADDING-BOTTOM: 0px;
	CURSOR: pointer;
	PADDING-TOP: 0px
}

.curtab {
	FONT-WEIGHT: bold;
	BACKGROUND: #fff;
	BORDER-RIGHT-COLOR: #b2c9d3
}

.block {
	BORDER-RIGHT: #b2c9d3 1px solid;
	BORDER-TOP: #b2c9d3 1px solid;
	BACKGROUND: #fff;
	MARGIN: 0px 0px 6px;
	BORDER-LEFT: #b2c9d3 1px solid;
	BORDER-BOTTOM: #b2c9d3 1px solid
}

.block H3 {
	PADDING-LEFT: 0.5em;
	FONT-SIZE: 1em;
	BACKGROUND: url(../images/dotline_h.gif) repeat-x 50% bottom;
	MARGIN: 1px 0px 0px;
	COLOR: #5086a5;
	LINE-HEIGHT: 26px
}

.block H3 A {
	COLOR: #5086a5
}

.before {
	border: 0px;
	background-color: white;
}

.after {
	border: 1px solid;
}
</style>
</head>
<body>
<form name="thisForm" method="post" action="">


<DIV class=block id=search>
<!-- 
<c:if test="${tableName=='K_Company' }">
<H3 class=tabs id=searchtabs>
<c:if test="${t=='px' }">
<A class="tab" id=jzzctab href="javascript:setTab('search','jzzc')">培训班报名</A>
</c:if>
<c:if test="${t=='jc' }">
<A class="tab" id=hfjltab href="javascript:setTab('search','hfjl')">检查组人员通知报名</A>
</c:if>
</H3>
</c:if>
 -->
<c:choose>
	<c:when test="${tableName=='K_Company' }">
		<c:if test="${t=='px' }">
			<div class=tabcontent id="jzzc" style="text-align: center;">
				<!-- 培训班报名 -->
				<mt:DataGridPrintByBean name="tList"/>
			</div>	
		</c:if>
		<c:if test="${t=='jc' }">
			<div class=tabcontent id="hfjl" style="text-align: center;">
				<!-- 检查组人员通知报名 -->
				<mt:DataGridPrintByBean name="testerNoticeBM"/>
			</div>	
		</c:if>
	</c:when>
	<c:otherwise>
		<div class=tabcontent id="jzzc" style="text-align: center;">
			<!-- 培训班报名 -->
			<mt:DataGridPrintByBean name="tList"/>
		</div>	
	</c:otherwise>
</c:choose>

</DIV>

<div id="reasonDivBig" style="position:absolute;width:100%;height:100%; top:expression(this.offsetParent.scrollTop); z-index:1; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;">
</div>
<div id="reasonDiv" style="position:absolute;width:60%;height:10%; z-index:2;left:expression((document.body.clientWidth-600)/2);top:expression(this.offsetParent.scrollTop + 70); border:1px solid #6595d6; padding:10px; background:#ffffff;text-align:center; display: none;">
   
   <table width="90%">
   	<tr>
   		<td>
	   	 	不参加原因：<font color="red">[*]</font>
	    	<textarea title="不参加原因" class="data_tb_content" id="notJoinReason" name="notJoinReason" style="width: 80%;height: 100px;vertical-align: middle;"></textarea>
    	</td>
    </tr>
    </table>
   <ul style="list-style: none;">
    <li>
    	<input type="button" value="确  定" onclick="f_sure()"/>
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<input icon="icon-delete" type="button" value="取  消" onclick="f_cancle()"/>
    </li>
  </ul>
    	
 </div>
<input type="hidden" id="c_id" name="c_id">
</form>
</body>
</html>
<script>
/*查看*/
function goView(chooseValue){
	window.location="${pageContext.request.contextPath}/common/training.do?method=view&nid="+chooseValue;
}

function save(eid,isexp,opt){
	//if(opt == 1){
		//alert("该参与人属于【团体报名】，只能通过团体代缴！");
		//return ;
	//}
	
	if(isexp == 1){
		alert("该参与人已经缴费，不用再缴费！");
		return ;
	}
	
//	alert(eid);
//	return ;
	
	var url="${pageContext.request.contextPath}/common/pay.do?method=payInfo&orderId="+eid+"&random="+Math.random() ;

	document.thisForm.action = url;
	document.thisForm.target = "";
	document.thisForm.submit();
}

function del(eid,isexp,opt){
	if(confirm("您确定要取消吗？")){
		//if(opt == 1){
			//alert("该参与人属于【团体报名】，只能通过团体来取消报名！");
			//return ;
		//}
		
		if(isexp == 1){
			alert("该参与人已经缴费，不能取消！");
			return ;
		}
		
		var oBao = new ActiveXObject("Microsoft.XMLHTTP");
		var url="${pageContext.request.contextPath}/common/training.do?method=del&nid="+eid+"&random="+Math.random() ;
		oBao.open("POST",url,false);
		oBao.send();
	
		resText = oBao.responseText ;
		
		alert(resText);
		
		goSearch('tList');	
	}
}

 

//显示
function setTab(area,id) {
	var tabArea=document.getElementById(area);
	var contents=tabArea.childNodes;
	for(i=0; i<contents.length; i++) {
		if(contents[i].className=='tabcontent'){contents[i].style.display='none';}
	}
	document.getElementById(id).style.display='';
	var tabs=document.getElementById(area+'tabs').getElementsByTagName('a');
	
	for(i=0; i<tabs.length; i++) { 
		tabs[i].className='tab'; 
	}
	document.getElementById(id+'tab').className='tab curtab';
	document.getElementById(id+'tab').blur();
	
}

// 参加
function f_join(isJoin,id,notJoinReason){
	if("YES"==isJoin){
		if(confirm("您确认执行参加操作吗？")){
			var url="${pageContext.request.contextPath}/common/training.do?method=isJoin";
			var request = "&id="+id+"&isJoin=YES"; 
			var resText = ajaxLoadPageSynch(url,request);
			if("Y"==resText){
				alert("参加报名操作成功！");
			}else{
				alert("参加报名操作失败。请联系管理员！");
			}
			document.thisForm.action = "${pageContext.request.contextPath}/common/training.do?method=list&t=jc&random="+Math.random();
			document.thisForm.submit();
		}
	}else{
		document.getElementById("notJoinReason").value = notJoinReason;
		document.getElementById("c_id").value = id;
		document.getElementById("reasonDiv").style.display = "";
		document.getElementById("reasonDivBig").style.display = "";
	}
}


// 确定
function f_sure(){
	var notJoinReason = document.getElementById("notJoinReason").value.replace(" ","");
	if(notJoinReason=="" || notJoinReason==null){
		alert("请填写原因!");
		document.getElementById("notJoinReason").focus();
	}else{
		if(confirm("确定执行不参加操作吗？")){
			var id = document.getElementById("c_id").value;
			var url="${pageContext.request.contextPath}/common/training.do?method=isJoin";
			var request = "&id="+id+"&isJoin=NO&notJoinReason="+notJoinReason; 
			var resText = ajaxLoadPageSynch(url,request);
			if("Y"==resText){
				alert("不参加报名操作成功！");
			}else{
				alert("不参加报名操作失败。请联系管理员！");
			}
			document.thisForm.action = "${pageContext.request.contextPath}/common/training.do?method=list&t=jc&random="+Math.random();
			document.thisForm.submit();
		}
	}
}



// 取消
function f_cancle(){
	document.getElementById("reasonDiv").style.display = "none";
	document.getElementById("reasonDivBig").style.display = "none";
}

</script>