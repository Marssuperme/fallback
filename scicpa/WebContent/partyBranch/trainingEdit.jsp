<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %> 
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>党内培训</title> 
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
	党&nbsp;&nbsp;内&nbsp;&nbsp;培&nbsp;&nbsp;训<br/><br/> 
	</center>

<DIV class=block id=search style="height: 100%;">

<div class=tabcontent id="dgxx" style="text-align:center;">

<table style="PADDING-LEFT: 5px; PADDING-RIGHT: 5px;" border="0" cellSpacing="0" cellPadding="0" width="50%" align="center" height="100%">
  <tbody>
    <tr>
      <td vAlign="top"><br>
        <table style="WIDTH: 100%" class="data_tb" align="center">
          <tbody>
            <tr>
              <td class="data_tb_alignright" style="width: 40%">培训班名称<font color="#FF0000">&nbsp;[*]</font></td>
              <td class="data_tb_content" colspan="3"><input class="required" value="${edit.trainname }" name="trainname" maxlength="50" type="text"  id="trainname"  size="30" ></td>
            </tr>
            <tr>
              <td class="data_tb_alignright" width="20%">开始时间</td>
              <td class="data_tb_content" colspan="3"><input showcalendar="true" value="${edit.begindate }" name="begindate" maxlength="50" type="text"  id="begindate"  size="30" ></td>
            </tr>  
            <tr>
              <td class="data_tb_alignright" width="20%">截止时间</td>
              <td class="data_tb_content" colspan="3"><input showcalendar="true" value="${edit.enddate }" name="enddate" maxlength="50" type="text"  id="enddate"  size="30" ></td>
            </tr>  
            <tr>
              <td class="data_tb_alignright">培训单位</td>
              <td class="data_tb_content" colspan="3"><input value="${edit.department }" name="department" maxlength="50" type="text"  id="department"  size="30" ></td>
            </tr>
            <tr>
              <td class="data_tb_alignright">培训学时数</td>
              <td class="data_tb_content" colspan="3"><input value="${edit.traintime }" name="traintime" maxlength="50" type="text"  id="traintime"  size="30" ></td>
            </tr>
            <tr>
              <td class="data_tb_alignright"> 审核人</td>
              <td class="data_tb_content" colspan="3"><input value="${edit.auditor }" name="auditor" maxlength="50" type="text"  id="auditor"  size="30" class='required' ></td>
            </tr>
            <tr>
              <td class="data_tb_alignright">完成情况</td>
              <td class="data_tb_content" colspan="3">
              	<select id="trainresult" name="trainresult" style="width: 185px" onChange="get(this);" >
              	<option value="毕业" <c:if test="${edit.trainresult=='毕业' }">selected</c:if> >毕业</option>
              	<option value="结业" <c:if test="${edit.trainresult=='结业' }">selected</c:if> >结业</option>
              	<option value="肄业" <c:if test="${edit.trainresult=='肄业' }">selected</c:if> >肄业</option>
              	<option value="在训" <c:if test="${edit.trainresult=='在训' }">selected</c:if> >在训</option>
              	<option value="未完成" <c:if test="${edit.trainresult=='未完成' }">selected</c:if> >未完成</option>
              	</select>
              </td>
            </tr>
          </tbody>
        </table>
      </td>
    </tr>
  </tbody>
</table>
<br>

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
<input name="partyid" type="hidden" id="partyid"  value="${edit.partyid }"  >
<input name="traincnt" type="hidden" id="traincnt"  value="${edit.traincnt }"  >
<input name="initflag" type="hidden" id="initflag"  value="${edit.initflag }"  >
<input name="timeflag" type="hidden" id="timeflag"  value="${edit.timeflag }"  >

<input name="tablename" type="hidden" id="tablename"  value="K_PartyTraining"  >
<input name="url" type="hidden" id="url"  value="/common/partyBranch.do?method=training&id=${edit.partyid }"  >

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
