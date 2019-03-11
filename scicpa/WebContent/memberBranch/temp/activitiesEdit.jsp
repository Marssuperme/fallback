<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %> 
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>组织活动</title> 
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
	组&nbsp;&nbsp;织&nbsp;&nbsp;活&nbsp;&nbsp;动<br/><br/> 
	</center>

<DIV class=block id=search style="height: 100%;">

<div class=tabcontent id="dgxx" style="text-align:center;">

<table style="PADDING-LEFT: 5px; PADDING-RIGHT: 5px;" border="0" cellSpacing="0" cellPadding="0" width="90%" align="center" height="100%">
  <tbody>
    <tr>
      <td vAlign="top"><br>
        <table style="WIDTH: 100%" class="data_tb" align="center">
          <tbody>
            <tr>
              <td class="data_tb_alignright" style="width: 40%">年度</td>
              <td class="data_tb_content" colspan="3"><input value="${edit.syear }" name="syear" maxlength="50" type="text"  id="syear"  size="30" class='required' ></td>
            </tr>
            <tr>
              <td class="data_tb_alignright">三会（支部党员大会、支部委员会、党小组会）次数</td>
              <td class="data_tb_content" colspan="3"><input value="${edit.threenum }" name="threenum" maxlength="50" type="text"  id="threenum"  size="30" class='number'></td>
            </tr>
            <tr>
              <td class="data_tb_alignright">组织（民主）生活会次数</td>
              <td class="data_tb_content" colspan="3"><input value="${edit.activitiesnum }" name="activitiesnum" maxlength="50" type="text"  id="activitiesnum"  size="30" class='number' ></td>
            </tr>
            <tr>
              <td class="data_tb_alignright">党课次数</td>
              <td class="data_tb_content" colspan="3"><input value="${edit.classnum }" name="classnum" maxlength="50" type="text"  id="classnum"  size="30" class='number' ></td>
            </tr>
            <tr>
              <td class="data_tb_alignright">开展主题活动情况</td>
              <td class="data_tb_content" colspan="3">
              <textarea style="width: 70%;height: 70px;" id="actcontent" name="actcontent">${edit.actcontent}</textarea>
              </td>
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
   		<input type="button" style="display:none;" icon="icon-save" name="bcb" id="bcb" value="保  存" onclick="return saveCompany();" >
    </td>
    <td width="33%" align="left">
		<input type="button" name="next" value="返  回" icon="icon-back" class="flyBT" onclick="goBack();" >
	</td>
  </tr>
</table>
</div>
</DIV>
<input name="id" type="hidden" id="id"  value="${edit.id }"  >
<input name="pid" type="hidden" id="pid"  value="${edit.pid }"  >
<input name="initflag" type="hidden" id="initflag"  value="${edit.initflag }"  >
<input name="timeflag" type="hidden" id="timeflag"  value="${edit.timeflag }"  >

<input name="tablename" type="hidden" id="tablename"  value="K_PartyActivities"  >
<input name="url" type="hidden" id="url"  value="/common/partyBranch.do?method=activities&id=${edit.pid }"  >

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
