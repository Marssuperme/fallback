<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<%@ page isELIgnored="false" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>checkGroupResult    addAndEdit</title>


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

#tb {background-color: #ffffff;text-align: center;border:#d1dfbb 1px solid;border-collapse:collapse;width:90%;margin:20 0px;}
#tb td{white-space:nowrap;padding: 1px;border-top: #d1dfbb 1px solid;border-left: #d1dfbb 1px solid;height:30px;}
#tb input{border:0px;border-bottom:1px solid #aaa;width:100%;margin:0 10px; }


</style>
</head>
<body>

<form name="thisForm" method="post" action="" id="thisForm" >
	<center class="formTitle" >
	事&nbsp;务&nbsp;所&nbsp;执&nbsp;业&nbsp;质&nbsp;量&nbsp;结&nbsp;果&nbsp;评&nbsp;价&nbsp;信&nbsp;息<br/><br/> 
	</center>

		<input name="checkid" type="hidden" id="checkid" value="${cgrt.checkid}">
		<input name="checkoffice" type="hidden" id="checkoffice" value="${cgrt.checkoffice}">
		
			<table align="center" id="tab" width="100%" border="1" cellpadding="1" cellspacing="0" > 
				<tr>
					<td align="right" width="20%">被检查事务所</td>
					<td width="40%"><input name="checkofficeid" type="text" id="checkofficeid" value="${cgrt.checkofficeid}" size="30" 
						onfocus="onPopDivClick(this);"
						noinput=true
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=24
						class="required"></td>
				
					<td align="right" width="15%">检查年度</td>
					<td width="25%"><input onfocus="onPopDivClick(this);"
						autoWidth=190
    					noinput=true
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=3
						hideresult=true name="years" type="text" id="years" value="${cgrt.years}" class="required" size="30"></td>
				</tr>
				
					
				<tr>
					<td align="right" width="20%">评价</td>
					<td width="40%"><input onfocus="onPopDivClick(this);"
						autoWidth=190
    					noinput=true
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=22
						hideresult=true name="evaluation" type="text" id="evaluation" value="${cgrt.evaluation}" class="required" size="30" ></td>
			 
					<td align="right" width="15%">审核意见</td>
					<td width="25%"><input onfocus="onPopDivClick(this);"
						autoWidth=190
    					noinput=true
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=23
						hideresult=true name="result" type="text" id="result" value="${cgrt.result}" class="required" size="30" ></td>
				</tr>
			
				 
				<tr>
					<td align="right" width="20%">奖励内容</td>
					<td colspan="3"><textarea cols="120%" rows="5%" name="prize" id="prize">${cgrt.prize}</textarea></td>
				</tr>
				
				<tr>
					<td align="right" width="20%">惩戒内容</td>
					<td colspan="3"><textarea cols="120%" rows="5%" name="punish" id="punish">${cgrt.punish}</textarea></td>
				</tr>
				
			</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="22" colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td width="10%">&nbsp;</td>
    <td width="45%" align="right">
    	<input type="submit" name="next" value="保 存" class="flyBT" onclick="return f_save();" >&nbsp;&nbsp;&nbsp;
    	<input type="button" name="next" value="返 回" class="flyBT" onclick="history.back();" >
    </td>
    <td width="45%" ></td>
  </tr>
</table>


</form>
 
</body>

<script type="text/javascript">

	//加验证
	$(document).ready(function(){
	    $("#thisForm").validate();
	});

	
	// 保存
	function f_save(){
		var id = document.getElementById("checkid").value; 
		var checkoffice = "";
		if(document.getElementById("advice-checkofficeid")) {
			checkoffice = document.getElementById("advice-checkofficeid").innerHTML;
		}
		document.getElementById("checkoffice").value = checkoffice; 
		if(id==null || id==""){
			thisForm.action = "${pageContext.request.contextPath}/common/checkGroupResult.do?method=addCheckGroupResultTable";
			//thisForm.submit();
		}else{
			thisForm.action = "${pageContext.request.contextPath}/common/checkGroupResult.do?method=updateCheckGroupResultTable";
			//thisForm.submit();
		}
	}
</script>
</html>