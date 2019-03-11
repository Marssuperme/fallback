<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %> 
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>党内奖惩</title> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/main.css"/>
<style>
.formTitle {
	color: #4A74BC;
	font-weight: bold;
	font-size: 14px;
	text-align:center;
	width:100%;
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
	PADDING-LEFT: 0px! important; HEIGHT: 26px; BACKGROUND-COLOR: #e8f7fc! important
	}
	.tab {
		BORDER-RIGHT: #c1d8e0 1px solid; PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FONT-WEIGHT: normal; FLOAT: left; PADDING-BOTTOM: 0px; CURSOR: pointer; PADDING-TOP: 0px
	}
	.curtab {
		FONT-WEIGHT: bold; BACKGROUND: #fff; BORDER-RIGHT-COLOR: #b2c9d3
	}
	.block {
	BORDER-RIGHT: #b2c9d3 1px solid; BORDER-TOP: #b2c9d3 1px solid; BACKGROUND: #fff; MARGIN: 0px 0px 6px; BORDER-LEFT: #b2c9d3 1px solid; BORDER-BOTTOM: #b2c9d3 1px solid
	}
	.block H3 {
		PADDING-LEFT: 0.5em; FONT-SIZE: 1em; BACKGROUND: url(../images/dotline_h.gif) repeat-x 50% bottom; MARGIN: 1px 0px 0px; COLOR: #5086a5; LINE-HEIGHT: 26px
	}
	.block H3 A {
		COLOR: #5086a5
	}
	
	.before{
		border: 0px;
	}
	.after{
		border: 1px solid;
	}
</style> 
</head>
<body>

<form name="thisForm" method="post" action="" id="thisForm" >
	<center class="formTitle" > 
	党&nbsp;&nbsp;内&nbsp;&nbsp;奖&nbsp;&nbsp;惩<br/><br/> 
	</center>

<DIV class=block id=search style="height: 100%;">

<div class=tabcontent id="dgxx" style="text-align:center;">

<table style="PADDING-LEFT: 5px; PADDING-RIGHT: 5px;" border="0" cellSpacing="0" cellPadding="0" width="60%" align="center" height="100%">
  <tbody>
    <tr>
      <td vAlign="top"><br>
        <table style="WIDTH: 100%" class="data_tb" align="center">
          <tbody>
            <tr>
              <td class="data_tb_alignright"  width="20%">年度</td>
              <td class="data_tb_content" colspan="3"><input value="${edit.syear }" name="syear" maxlength="50" type="text"  id="syear"  size="30" class='required'></td>
            </tr>
            <tr>
              <td class="data_tb_alignright" >类型</td>
              <td class="data_tb_content"  colspan="3">
              	<select id="stype" name="stype" style="width: 185px" onChange="get(this);" >
              	<option value="奖励" <c:if test="${edit.stype=='奖励' }">selected</c:if> >奖励</option>
              	<option value="惩罚" <c:if test="${edit.stype=='惩罚' }">selected</c:if> >惩罚</option>
              	</select>
              </td>
            </tr>  
            <tr>
              <td class="data_tb_alignright" >级别</td>
              <td id="commendtypeTD" class="data_tb_content" width="30%" colspan="3">
              	
              </td>
            </tr>  
            <tr>
              <td class="data_tb_alignright">名称</td>
              <td class="data_tb_content" colspan="3"><input class="required" value="${edit.commendname }" name="commendname" maxlength="50" type="text"  id="commendname"  size="30" ></td>
            </tr>
            <tr>
              <td class="data_tb_alignright">批准机构名称</td>
              <td class="data_tb_content" colspan="3"><input class="required" value="${edit.approvaldepart }" name="approvaldepart" maxlength="50" type="text"  id="approvaldepart"  size="30" ></td>
            </tr>
            <tr> 
              <td class="data_tb_alignright">批准时间</td>
              <td class="data_tb_content" colspan="3"><input showcalendar="true" value="${edit.approvaltime }" name="approvaltime" maxlength="50" type="text"  id="approvaltime"  size="30" ></td>
            </tr>
             <tr>
              <td class="data_tb_alignright"> 审核人</td>
              <td class="data_tb_content" colspan="3"><input value="${edit.auditor }" name="auditor" maxlength="50" type="text"  id="auditor"  size="30" class='required' ></td>
            </tr>
          </tbody>
        </table>
      </td>
    </tr>
  </tbody>
</table>
<br>

<div id="option1" style="display: none;">
<option type="奖励" value="国家级" <c:if test="${edit.commendtype=='国家级' }">selected</c:if> >国家级</option>
<option type="奖励" value="省（直辖市）级" <c:if test="${edit.commendtype=='省（直辖市）级' }">selected</c:if> >省（直辖市）级</option>
<option type="奖励" value="部委级" <c:if test="${edit.commendtype=='部委级' }">selected</c:if> >部委级</option>
<option type="奖励" value="地、厅、司、局（区）级" <c:if test="${edit.commendtype=='地、厅、司、局（区）级' }">selected</c:if> >地、厅、司、局（区）级</option>
<option type="奖励" value="县、处级" <c:if test="${edit.commendtype=='县、处级' }">selected</c:if> >县、处级</option>
<option type="奖励" value="中注协党委" <c:if test="${edit.commendtype=='中注协党委' }">selected</c:if> >中注协党委</option>
<option type="奖励" value="省级注协党委" <c:if test="${edit.commendtype=='省级注协党委' }">selected</c:if> >省级注协党委</option>
<option type="奖励" value="地市级注协党委" <c:if test="${edit.commendtype=='地市级注协党委' }">selected</c:if> >地市级注协党委</option>
<option type="奖励" value="企事业单位荣誉称号" <c:if test="${edit.commendtype=='企事业单位荣誉称号' }">selected</c:if> >企事业单位荣誉称号</option>
<option type="奖励" value="国外授予荣誉称号" <c:if test="${edit.commendtype=='国外授予荣誉称号' }">selected</c:if> >国外授予荣誉称号</option>
</div>


<div id="option2" style="display: none;">
<option type="惩罚" value="警告" <c:if test="${edit.commendtype=='警告' }">selected</c:if> >警告</option>
<option type="惩罚" value="严重警告" <c:if test="${edit.commendtype=='严重警告' }">selected</c:if> >严重警告</option>
<option type="惩罚" value="撤消党内职务" <c:if test="${edit.commendtype=='撤消党内职务' }">selected</c:if> >撤消党内职务</option>
<option type="惩罚" value="留党察看" <c:if test="${edit.commendtype=='留党察看' }">selected</c:if> >留党察看</option>
<option type="惩罚" value="开除党籍" <c:if test="${edit.commendtype=='开除党籍' }">selected</c:if> >开除党籍</option>
</div>

<table height="5%" border="0" cellspacing="0" cellpadding="0"     >
  <tr align="center">
    <td width="33%" align="left">
   		<input type="button" style="display:none;" icon="icon-save" name="bcb" id="bcb" value="保  存" onClick="return saveCompany();" >
    </td>
    <td width="33%" align="left">
		<input type="button" name="next" value="返  回" icon="icon-back" class="flyBT" onClick="goBack();" >
	</td>
  </tr>
</table>
</div>
</DIV>
<input name="id" type="hidden" id="id"  value="${edit.id }"  >
<input name="pid" type="hidden" id="pid"  value="${edit.pid }"  >
<input name="ctype" type="hidden" id="ctype"  value="${edit.ctype }"  >
<input name="initflag" type="hidden" id="initflag"  value="${edit.initflag }"  >
<input name="timeflag" type="hidden" id="timeflag"  value="${edit.timeflag }"  >

<input name="tablename" type="hidden" id="tablename"  value="K_PartyCommend"  >
<input name="url" type="hidden" id="url"  value="/common/partyBranch.do?method=commend&id=${edit.pid }"  >

</form>

<iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>
</body>
</html>
<script type="text/javascript">
	//加验证
  $(document).ready(function(){
    $("#thisForm").validate();
  });
  
//保存
function saveCompany(){ 
	
	document.thisForm.action = "${pageContext.request.contextPath}/common/partyBranch.do?method=saveTable";
	document.thisForm.target = "";
	
	$("input").each(function(index,obj){
		if (obj.myClass){
			obj.className = obj.myClass; 
		}
	});
	
	if(document.thisForm.fireEvent('onsubmit')){
		document.thisForm.submit();
		return true;
	}else{
		return false;
	}
	
}


// 返回到主页 
function goBack(){
	window.history.back();
}

get(document.getElementById("stype"));
function get(obj){

	var selectInnerHTML = "<select id='commendtype' name='commendtype' style='width: 185px' >";
				
	var commendtypeTD = document.getElementById("commendtypeTD");
	var option1 = document.getElementById("option1");
	var option2 = document.getElementById("option2");
	
	if(obj.value == "奖励") {
		selectInnerHTML += option1.innerHTML;
	} else {
		selectInnerHTML += option2.innerHTML;
	}
	
	selectInnerHTML += "</select>";
	
	commendtypeTD.innerHTML = selectInnerHTML;
	
}
</script>
