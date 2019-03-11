<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %> 
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>党组织信息</title> 
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
	计&nbsp;&nbsp;划&nbsp;&nbsp;发&nbsp;&nbsp;展&nbsp;&nbsp;党&nbsp;&nbsp;员<br/><br/> 
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
              <td class="data_tb_alignright">年度</td>
              <td class="data_tb_content" colspan="3"><input value="${edit.syear }" class='required' name="syear" maxlength="50" type="text"  id="syear"  size="30" ></td>
            </tr>
            <tr>
              <td class="data_tb_alignright">发展新党员人数</td>
              <td class="data_tb_content" colspan="3"><input value="${edit.newnum }" class='required number' name="newnum" maxlength="50" type="text"  id="newnum"  size="30" ></td>
            </tr>
            <tr>
              <td class="data_tb_alignright">申请入党人数</td>
              <td class="data_tb_content" colspan="3"><input value="${edit.applynum }" class='required number' name="applynum" maxlength="50" type="text"  id="applynum"  size="30" ></td>
            </tr>
            <tr>
              <td class="data_tb_alignright">确定培养对象(入党积极分子)人数</td>
              <td class="data_tb_content" colspan="3"><input value="${edit.grownum }" class='required number' name="grownum" maxlength="50" type="text"  id="grownum"  size="30" ></td>
            </tr>
            <tr>
              <td class="data_tb_alignright">审核人</td>
              <td class="data_tb_content" colspan="3"><input value="${edit.auditor }" class='required' name="auditor" maxlength="50" type="text"  id="auditor"  size="30" ></td>
            </tr>
          </tbody>
        </table>
      </td>
    </tr>
  </tbody>
</table>
<br>

<table height="5%" border="0" cellspacing="0" cellpadding="0"   >
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
<input name="initflag" type="hidden" id="initflag"  value="${edit.initflag }"  >
<input name="timeflag" type="hidden" id="timeflag"  value="${edit.timeflag }"  >

<input name="tablename" type="hidden" id="tablename"  value="K_PartyExpansion"  >
<input name="url" type="hidden" id="url"  value="/common/partyBranch.do?method=expansion&id=${edit.pid }"  >

</form>

<iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>
</body>
</html>
<script type="text/javascript">
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

</script>
