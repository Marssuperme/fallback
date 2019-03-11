<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>监管工时费用报备管理</title>

 <style>
	.tb {background-color: #ffffff;text-align: center;border:#d1dfbb 1px solid;border-collapse:collapse;width:90%;margin:20 0px;}
	.tb td{white-space:nowrap;padding: 1px;border-top: #d1dfbb 1px solid;border-left: #d1dfbb 1px solid;height:30px;}
	.tb input{border:0px;border-bottom:1px solid #aaa;}
	#desc {height : 27px ;line-height: 27px ;color: #125908 ;font-size: 14px;font-weight: bold;padding-left: 5px;}
	.titleTd{background-color: #eff7e2;font-size: 13px;font-family:"宋体";}
	.otherinput{border:0px;border-bottom:1px solid #aaa;margin-right: 100px;}
	a:visited{color:blue} 
	.error{color: red;}
</style>

</head>

<body style="height:100%;">
	<form id="thisForm" name="thisForm" method="post">
	<input name="id" type="hidden" id="id"  value="${hcmt2.id}"  > 
	<input name="source" type="hidden" id="source"  value="${source}"  >
	<input name="testnoticeid" type="hidden" id="testnoticeid"  value="${testnoticeid}"  >
	<input name="groupname" type="hidden" id="groupname"  value="${groupname}"  >
		<div id="desc">请录入监管工时费用信息：</div> 
		<div style="height:1px;border-top:1px solid #aabbcc;width: 100%;"></div>
		<table align="center" cellpadding="5"> 
			<tr>
				<td align="right">填报人：</td>
	    		<td><input type="text" id="fillMan" name="fillMan" class="required" readonly="readonly" value="${hcmt2.fillMan}" style="border:0px;border-bottom:1px solid #aaa;" >
	    		</td>
	    		<td colspan="2"></td>
	    		<td>填报日期：</td>
				<td><input type="text"  id="fillTime" name="fillTime" class="required" value="${hcmt2.fillTime}" style="border:0px;border-bottom:1px solid #aaa;" readonly="readonly">
				</td>
	    	</tr>
			<tr style="display: none">
				<td>被检查事务所名称：</td>
				<td><input type="text" id="checkOffice" name="checkOffice" title="请被检查事务所名称"
			 		class="required" size="30" value="${officename}" style="border:0px;border-bottom:1px solid #aaa;" refer="testnoticeid" onfocus="onPopDivClick(this);"
					onkeydown="onKeyDownEvent();"
					onkeyup="onKeyUpEvent();"
					onclick="onPopDivClick(this);"
					norestorehint=true
					valuemustexist="true"
					autoid=25  class="required">
			 	</td>
			 	<td colspan="2"></td>
				<td>填报项目：</td>
				<td><input type="text"  id="checkProject" name="checkProject" class="required" value="${checkProject}" style="border:0px;border-bottom:1px solid #aaa;" title="请输入填报项目">
				</td>
			</tr>
		</table>
		<div style="overflow:scroll;width: 99%;height: 200px;">
		<table class="tb" id="tb" cellpadding="5" cellspacing="0" width="100%" style="margin-left: 10px;">
			<tr>
				<td colspan="9" class="titleTd">监管工时费用信息&nbsp;&nbsp;&nbsp;&nbsp;<a href="###" onclick="addLine();">【点击追加信息】</a></td>
			</tr>
			<tr>
				<td class="titleTd" width="120px">检查组人员</td>
				<td class="titleTd" width="170px">起始日期</td>
				<td class="titleTd" width="170px">结束日期</td>
				<td class="titleTd" width="40px">天数</td>
				<td class="titleTd" width="140px">检查津贴(<span id="checkpay_span"></span>人/天)</td>
				<td class="titleTd" width="80px">早、午餐补贴(<span id="mealmoneypay_span"></span>人/天)</td>
				<td class="titleTd" width="100px">城际交通费</td>
				<td class="titleTd" width="40px">小计</td>
				<td class="titleTd" width="80px">&nbsp;&nbsp;&nbsp;操&nbsp;作&nbsp;&nbsp;&nbsp;</td>
			</tr>
			<c:choose>
				<c:when test="${opt=='update'}">
					<c:forEach items="${list}" var="listm" >
						<tr>
							<td width="120px" nowrap="nowrap"><input type="text" id="checkManID" name="checkManID" value="${listm.checkManID}" class="required"
								onchange="f_distinctManID(this)"; 
								onfocus="onPopDivClick(this);"
			   					noinput=true
			   					autoWidth=190
								autoHeight=180
								onkeydown="onKeyDownEvent();"
								onkeyup="onKeyUpEvent();"
								onclick="onPopDivClick(this);"
								norestorehint=true
								autoid=67
								refer="testnoticeid"
								refer1="groupname"
								hideresult=true style="width: 85%"></td>
							<td width="170px" nowrap="nowrap"><input type="text" id="startTime" name="startTime" value="${listm.startTime}" onpropertychange="f_days(this);" showcalendar="true" ></td>
							<td width="170px" nowrap="nowrap"><input type="text" id="endTime" name="endTime" value="${listm.endTime}" onpropertychange="f_daye(this);" showcalendar="true" ></td>
							<td width="40px"><input type="text" id="countDays" name="countDays" readonly="readonly" value="${listm.countDays}"></td>
							<td width="130px"><input type="text" id="checkPay" name="checkPay" style="text-align: right" readonly="readonly" value="${listm.checkPay}"></td>
							<td width="60px"><input type="text" id="foodPay" name="foodPay" style="text-align: right" value="${listm.foodPay}" readonly="readonly" onpropertychange="f_countMoney(this)" onkeyup="f_onkeyup(this)" onblur="f_blur(this)" title="请输入有效的金额"></td>
							<td width="100px"><input type="text" id="businessTrips" style="text-align: right" name="businessTrips" value="${listm.businessTrips}" readonly="readonly" onpropertychange="f_countMoney(this)" onkeyup="f_onkeyup(this)" onblur="f_blur(this)" title="请输入有效的金额"></td>
							<td width="40px"><input type="text" id="countMoney" name="countMoney" style="text-align: right" readonly="readonly" value="${listm.countMoney}"></td>
							<td width="80px">
								<a href="###" onclick="removeLine(this);">【删除】</a>
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td width="120px" nowrap="nowrap"><input type="text" id="checkManID" name="checkManID" value="${checkManID}" class="required"
							onchange="f_distinctManID(this)"; 
							onfocus="onPopDivClick(this);"
		   					noinput=true
		   					autoWidth=190
							autoHeight=180
							onkeydown="onKeyDownEvent();"
							onkeyup="onKeyUpEvent();"
							onclick="onPopDivClick(this);"
							norestorehint=true
							autoid=67
							refer="testnoticeid"
							refer1="groupname"
							hideresult=true style="width: 85%"></td>
						<td width="170px" nowrap="nowrap"><input type="text" id="startTime" name="startTime" value="${startTime}" onpropertychange="f_days(this);" showcalendar="true" ></td>
						<td width="170px" nowrap="nowrap"><input type="text" id="endTime" name="endTime" value="${endTime}" onpropertychange="f_daye(this);" showcalendar="true" ></td>
						<td width="40px"><input type="text" id="countDays" name="countDays" readonly="readonly" value="0" ></td>
						<td width="130px"><input type="text" id="checkPay" name="checkPay" style="text-align: right" readonly="readonly" value="0.00"></td>
						<td width="60px"><input type="text" id="foodPay" name="foodPay" style="text-align: right" value="0.00" readonly="readonly" onpropertychange="f_countMoney(this)" onkeyup="f_onkeyup(this)" onblur="f_blur(this)" title="请输入有效的金额"></td>
						<td width="100px"><input type="text" id="businessTrips" style="text-align: right" name="businessTrips" value="0.00" readonly="readonly" onpropertychange="f_countMoney(this)" onkeyup="f_onkeyup(this)" onblur="f_blur(this)" title="请输入有效的金额"></td>
						<td width="40px"><input type="text" id="countMoney" name="countMoney" style="text-align: right" readonly="readonly" value="0.00"></td>
						<td width="80px">
							<a href="###" onclick="removeLine(this);">【删除】</a>
						</td>
					</tr>
				</c:otherwise>
			</c:choose>
		 </table> 
		 <table class="tb" cellspacing="0" width="100%" style="margin-left: 10px;margin-top: -15px;">
			<tr>
				<td width="460px" nowrap="nowrap" class="titleTd" colspan="3">合&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计</td>
				<td width="40px"><input type="text" readonly="readonly" id="totalDays" name="totalDays" value="${hcmt2.totalDays }"></td>
				<td width="130px"><input style="text-align: right" type="text" readonly="readonly" id="totalCheckPay" name="totalCheckPay" value="${hcmt2.totalCheckPay }"></td>
				<td width="60px"><input style="text-align: right" type="text" readonly="readonly" id="totalfoodPay" name="totalfoodPay" value="${hcmt2.totalfoodPay }"></td>
				<td width="100px"><input style="text-align: right" type="text" readonly="readonly" id="totalbusinessTrips" name="totalbusinessTrips" value="${hcmt2.totalbusinessTrips }"></td>
				<td width="40px"><input style="text-align: right" type="text" id="totalCountMoney" name="totalCountMoney" readonly="readonly" value="${hcmt2.totalCountMoney }"></td>
				<td width="80px"><span style="width: 75px;"></span></td>
			</tr>
			
		</table> 
		</div><br>
		
		<div style="overflow:scroll;width: 99%;height: 200px;">
		<table class="tb" id="tb2" cellpadding="5" cellspacing="0" width="100%" style="margin-left: 10px;">
			<tr>
				<td colspan="9" class="titleTd">城际交通费详细信息&nbsp;&nbsp;&nbsp;&nbsp;<a href="###" onclick="addLine2();">【点击追加信息】</a></td>
			</tr>
			<tr>
				<td class="titleTd" width="120px" align="center">检查组人员</td>
				<td class="titleTd" width="170px">日期</td>
				<td class="titleTd" width="140px">起点</td>
				<td class="titleTd" width="140px">终点</td>
				<td class="titleTd" width="100px">金额</td>
				<td class="titleTd" width="140px">事由</td>
				<td class="titleTd" width="140px">备注</td>
				<td class="titleTd" width="80px">&nbsp;&nbsp;&nbsp;操&nbsp;作&nbsp;&nbsp;&nbsp;</td>
			</tr>
			<c:choose>
				<c:when test="${opt=='update'}">
					<c:forEach items="${listc}" var="listc">
						<tr>
							<td width="120px" nowrap="nowrap"><input type="text" id="checkManIDs" name="checkManIDs" value="${listc.loginName}" class="required" 
								onchange="f_checkMan(this)"
								onfocus="onPopDivClick(this);"
			   					noinput=true
			   					autoWidth=190
								autoHeight=180
								onkeydown="onKeyDownEvent();"
								onkeyup="onKeyUpEvent();"
								onclick="onPopDivClick(this);"
								norestorehint=true
								autoid=67
								refer="testnoticeid"
								refer1="groupname"
								hideresult=true style="width: 85%"></td>
							<td width="170px"><input type="text" id="sdate" name="sdate" showcalendar="true" value="${listc.sdate}"></td>
							<td width="170px" nowrap="nowrap"><input type="text" id="startPlace" name="startPlace" value="${listc.startPlace}" ></td>
							<td width="170px" nowrap="nowrap"><input type="text" id="endPlace" name="endPlace" value="${listc.endPlace}" ></td>
							<td width="40px"><input type="text" id="moneys" name="moneys" style="text-align: right;" value="${listc.moneys}" onkeydown="f_forbidNull(this)" onkeyup="f_onkeyup(this);f_calcBusinessTrips(this)" onblur="f_blur(this)" title="请输入有效的金额"></td>
							<td width="130px"><input type="text" id="reason" name="reason" value="${listc.reason}"></td>
							<td width="100px"><input type="text" id="remark" name="remark" value="${listc.remark}"></td>
							<td width="80px">
								<a href="###" onclick="removeLine(this);">【删除】</a>
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td width="120px" nowrap="nowrap"><input type="text" id="checkManIDs" name="checkManIDs" value="${checkManID}" class="required" 
							onchange="f_checkMan(this)"
							onfocus="onPopDivClick(this);"
		   					noinput=true
		   					autoWidth=190
							autoHeight=180
							onkeydown="onKeyDownEvent();"
							onkeyup="onKeyUpEvent();"
							onclick="onPopDivClick(this);"
							norestorehint=true
							autoid=67
							refer="testnoticeid"
							refer1="groupname"
							hideresult=true style="width: 85%"></td>
						<td width="170px"><input type="text" id="sdate" name="sdate" showcalendar="true" ></td>
						<td width="170px" nowrap="nowrap"><input type="text" id="startPlace" name="startPlace" value="${startPlace}" ></td>
						<td width="170px" nowrap="nowrap"><input type="text" id="endPlace" name="endPlace" value="${startPlace}" ></td>
						<td width="40px"><input type="text" id="moneys" name="moneys" style="text-align: right;" value="0.00" onkeydown="f_forbidNull(this)" onkeyup="f_onkeyup(this);f_calcBusinessTrips(this)" onblur="f_blur(this)" title="请输入有效的金额"></td>
						<td width="130px"><input type="text" id="reason" name="reason" ></td>
						<td width="100px"><input type="text" id="remark" name="remark" ></td>
						<td width="80px">
							<a href="###" onclick="removeLine(this);">【删除】</a>
						</td>
					</tr>
				</c:otherwise>
			</c:choose>
		 </table> 
		</div>
		
		<br>
		<center>
			<span id="saveSpan">
				<c:choose>
					<c:when test="${userSession.userMap.ctype=='团体会员' }">
						<input type="submit" icon='icon-save' name="next" value="保存"  onclick="return f_save();" >&nbsp;&nbsp;
					</c:when>
					<c:otherwise>
						<c:if test="${checkPost=='组长'}">
							<input type="submit" icon='icon-save' name="next" value="保存"  onclick="return f_save();" >&nbsp;&nbsp;
						</c:if>
					</c:otherwise>
				</c:choose>
			</span>
			<input type="button" icon='icon-back' name="next" value="返回"  onclick="f_back();" >
		</center>
	<input type="hidden" id="tab1_linenum" name="tab1_linenum" value="0">
	</form>
</body>

<script type="text/javascript"> 

var checkpay_money = "${checkpay}";
var mealmoneypay_money = "${mealmoneypay}";
var transportpay_money = "${transportpay}";
var other_money = "${other}";
var companypay_money = "${companypay}";

document.getElementById("checkpay_span").innerHTML = checkpay_money;
document.getElementById("mealmoneypay_span").innerHTML = mealmoneypay_money;


	//加验证
	$(document).ready(function(){
	    $("#thisForm").validate();
	});

	$(function (){$("#thisForm").validate({
		errorClass: "error",
		errorElement: "div"
	});})
	
	
	// 如果过期了那么只能查看不能修改
	var valid = "${valid}";
	if(valid=="N"){
		f_view();
	}
	function f_view(){
		var form_obj = document.all; 
		//form的值
		for (i=0;i<form_obj.length ;i++ ) {
			e=form_obj[i];
			if (e.tagName=='INPUT' || e.tagName=='TEXTAREA') {
				e.readOnly = true ;
				e.className = "before";
				if(e.type == 'checkbox'){
					e.disabled = true ;
				}
			}
			if(e.tagName=='SELECT'){
				e.disabled= true;
				e.className = "before";
			}
			//alert(e.tagName);
			if(e.tagName == 'A'){
				e.style.display = "none";
			}
			if(e.tagName == "IMG"){
				e.style.display = "none";
			}
			
		}
			
		document.getElementById("saveSpan").style.display = "none";
	}
	
	function getTime(){
		var now = new Date();
		var fullyear = now.getFullYear();
		var month = now.getMonth()*1+1;
		if(month<10){
			month="0"+month;
		}
		var date = now.getDate();
		if(date<10){
			date = "0"+date;
		}
		var nowtime = fullyear+"-"+month+"-"+date;
		return nowtime;
	}			
		
	
	// 添加行
	function addLine(){
	  var tab1_linenum = document.getElementById("tab1_linenum");
	  $('#tb').append("<tr><td class='serial'><input type='text' id='checkManID"+tab1_linenum.value+"' name='checkManID' class='required' noinput='true' onchange='f_distinctManID(this)'; "
   						+"onfocus='onPopDivClick(this);' autoWidth='190' autoHeight='180' onkeydown='onKeyDownEvent();' onkeyup='onKeyUpEvent();' onclick='onPopDivClick(this);' "
						+"norestorehint='true' autoid='67' refer='testnoticeid' refer1='groupname' hideresult='true' style='width: 85%'></td>"
	  					+"<td><input type='text' name='startTime' class='required' onpropertychange='f_days(this);' showcalendar='true' ></td>"
	  					+"<td><input type='text' name='endTime' onpropertychange='f_daye(this);' class='required' showcalendar='true' ></td>"
	  					+"<td><input type='text' readonly='readonly' name='countDays' value='0' ></td>"
	  					+"<td><input type='text' name='checkPay' style='text-align: right' readonly='readonly' value='0.00'></td>"
	  					+"<td><input type='text' name='foodPay' style='text-align: right' value='0.00' readonly='readonly' onpropertychange='f_countMoney(this)' onblur='f_blur(this)' onkeyup='f_onkeyup(this)'></td>"
	  					+"<td><input type='text' name='businessTrips' style='text-align: right' value='0.00' readonly='readonly' onpropertychange='f_countMoney(this)' onblur='f_blur(this)' onkeyup='f_onkeyup(this)' ></td>"
	  					+"<td><input type='text' name='countMoney' style='text-align: right' readonly='readonly' value='0.00'>"
	  					+"<td><a href='###' onclick='removeLine(this);'>【删除】</td></tr>");
	  					
	  tab1_linenum.value = tab1_linenum + 1 ;
	  
	  doLoadCalendar(); // 加载日期控件 
	}
	
	// 添加行
	function addLine2(){
	  $('#tb2').append("<tr><td class='serial'><input type='text' name='checkManIDs' class='required' onchange='f_checkMan(this)' onfocus='onPopDivClick(this);'noinput=true"
   						+"autoWidth='190' autoHeight='180' onkeydown='onKeyDownEvent();' onkeyup='onKeyUpEvent();' onclick='onPopDivClick(this);'"
						+"norestorehint='true' autoid='67' refer='testnoticeid' refer1='groupname' hideresult='true' style='width: 85%'></td>"
	  					+"<td><input type='text' name='sdate' class='required' showcalendar='true' ></td>"
	  					+"<td><input type='text' name='startPlace' ></td>"
	  					+"<td><input type='text' name='endPlace' ></td>"
	  					+"<td><input type='text' name='moneys' style='text-align: right' value='0.00' onpropertychange='f_forbidNull(this)' onkeyup='f_onkeyup(this);f_calcBusinessTrips(this)' onblur='f_blur(this)' title='请输入有效的金额' ></td>"
	  					+"<td><input type='text' name='reason' ></td>"
	  					+"<td><input type='text' name='remark'>"
	  					+"<td><a href='###' onclick='removeLine(this);'>【删除】</td></tr>");

	  doLoadCalendar(); // 加载日期控件 
	}
	
	
	// 删除行
	function removeLine(obj){
	  var $delLine = $(obj).parent("td").parent("tr") ; 
	  $delLine.remove();
	  var cpacount = parseInt($("#cpaCount").val())-1;
	  $("#cpaCount").val(cpacount) ;
	  f_jisuan();
   }
   
 
   
   // 计算天数
   function f_days(t){
   		//alert(t.parentNode.parentNode.cells[1].childNodes[0].value);
   		//str.replace(/\-/g,"!")则可以替换掉全部匹配的字符（g为全局标志）。 
   		
   		//var e = /^[1-9]{4}-[0-9]{2}-[0-9]{2}$/;
   	    //var e2 = /^[1-9]{4}[\/]{1}[0-9]{2}[\/]{1}[0-9]{2}$/;
   		//var e2 = /[1-9][/d]{3,3}[/\][/d]{2,2}[/\][/d]{2,2}[/s][/d]{2,2}/;
   		
   		var e = /^\d{4}(\-|\/|\.)\d{1,2}\1\d{1,2}$/;
   		
   		
		var startTime = t.parentNode.parentNode.cells[1].childNodes[0].value;
		var endTime = t.parentNode.parentNode.cells[2].childNodes[0].value;
		  
		 
		if(!e.exec(startTime)){
			// alert("日期格式为(年-月-日或年/月/日)");
			t.parentNode.parentNode.cells[1].childNodes[0].value = getTime();
			t.parentNode.parentNode.cells[3].childNodes[0].value = 0;
			t.parentNode.parentNode.cells[4].childNodes[0].value = "0.00";
			f_countMoney(t); // 计算小计
			//f_jisuan();
			return;
		}
				

		if(f_testMonthDay(t)){
			startTime = startTime.replace(/\-/g,"/");
			endTime = endTime.replace(/\-/g,"/");
			var startDate = new Date(Date.parse(startTime)).getTime();
			var endDate = new Date(Date.parse(endTime)).getTime();
			var result = (endDate-startDate)/(1000*60*60*24);
	
	   		if(startTime == "" || endTime == ""){
	   			t.parentNode.parentNode.cells[3].childNodes[0].value = 0;
	   			t.parentNode.parentNode.cells[4].childNodes[0].value = "0.00";
	   			t.parentNode.parentNode.cells[5].childNodes[0].value = "0.00";
	   			f_countMoney(t);   // 计算小计
	   		}else{
	   			if(result<0){
	   				alert("结束日期应大于起始日期");
	   				t.parentNode.parentNode.cells[3].childNodes[0].value = 0;
	   				t.parentNode.parentNode.cells[4].childNodes[0].value = "0.00";
	   				t.parentNode.parentNode.cells[5].childNodes[0].value = "0.00";
	   				return;
	   			}else{
	   				t.parentNode.parentNode.cells[3].childNodes[0].value = result;
	   				t.parentNode.parentNode.cells[4].childNodes[0].value = (parseFloat(result*checkpay_money)).toFixed(2);
	   				t.parentNode.parentNode.cells[5].childNodes[0].value = (parseFloat(result*mealmoneypay_money)).toFixed(2);
	   			}
				f_countMoney(t); // 计算小计
	   		}
	   		
	   		// 计算总金额
	   		// f_jisuan();
		}else{
			t.parentNode.parentNode.cells[1].childNodes[0].value = "";
			t.parentNode.parentNode.cells[3].childNodes[0].value = 0;
			t.parentNode.parentNode.cells[4].childNodes[0].value = "0.00";
			t.parentNode.parentNode.cells[4].childNodes[5].value = "0.00";
			f_countMoney(t); // 计算小计
			// f_jisuan();
		}
   		
   }
   
    // 计算天数
   function f_daye(t){
   		//alert(t.parentNode.parentNode.cells[1].childNodes[0].value);
   		//str.replace(/\-/g,"!")则可以替换掉全部匹配的字符（g为全局标志）。 
   		
   		//var e = /^[1-9]{4}-[0-9]{2}-[0-9]{2}$/;
   	    //var e2 = /^[1-9]{4}[\/]{1}[0-9]{2}[\/]{1}[0-9]{2}$/;
   		//var e2 = /[1-9][/d]{3,3}[/\][/d]{2,2}[/\][/d]{2,2}[/s][/d]{2,2}/;
   		
   		var e = /^\d{4}(\-|\/|\.)\d{1,2}\1\d{1,2}$/;
   		
   		
		var startTime = t.parentNode.parentNode.cells[1].childNodes[0].value;
		var endTime = t.parentNode.parentNode.cells[2].childNodes[0].value;
		  
	 
		if(!e.exec(endTime)){
			//alert("日期格式为(年-月-日或年/月/日)");
			t.parentNode.parentNode.cells[2].childNodes[0].value = getTime();
			t.parentNode.parentNode.cells[3].childNodes[0].value = 0;
			t.parentNode.parentNode.cells[4].childNodes[0].value = "0.00";
			t.parentNode.parentNode.cells[5].childNodes[0].value = "0.00";
			f_jisuan();
			return;
		}
		

		if(f_testMonthDay(t)){
			startTime = startTime.replace(/\-/g,"/");
			endTime = endTime.replace(/\-/g,"/");
			var startDate = new Date(Date.parse(startTime)).getTime();
			var endDate = new Date(Date.parse(endTime)).getTime();
			var result = (endDate-startDate)/(1000*60*60*24);
	
	   		if(startTime == "" || endTime == ""){
	   			t.parentNode.parentNode.cells[3].childNodes[0].value = 0;
	   			t.parentNode.parentNode.cells[4].childNodes[0].value = "0.00";
	   			t.parentNode.parentNode.cells[5].childNodes[0].value = "0.00";
	   			f_countMoney(t);   // 计算小计
	   		}else{
	   			if(result<0){
	   				alert("结束日期应大于起始日期");
	   				t.parentNode.parentNode.cells[3].childNodes[0].value = 0;
	   				t.parentNode.parentNode.cells[4].childNodes[0].value = "0.00";
	   				t.parentNode.parentNode.cells[5].childNodes[0].value = "0.00";
	   			}else{
	   				t.parentNode.parentNode.cells[3].childNodes[0].value = result;
   					t.parentNode.parentNode.cells[4].childNodes[0].value = (parseFloat(result*checkpay_money)).toFixed(2);
	   				t.parentNode.parentNode.cells[5].childNodes[0].value = (parseFloat(result*mealmoneypay_money)).toFixed(2);
	   			}
				f_countMoney(t); // 计算小计
	   		}
	   		
	   		// 计算总金额
	   		// f_jisuan();
		}else{
			t.parentNode.parentNode.cells[2].childNodes[0].value = "";
			t.parentNode.parentNode.cells[3].childNodes[0].value = 0;
			t.parentNode.parentNode.cells[4].childNodes[0].value = "0.00";
			t.parentNode.parentNode.cells[5].childNodes[0].value = "0.00";
			f_jisuan();
		}
   		
   }
   
   
   // 计算总计
   function f_jisuan(){
   		var tb = document.getElementById("tb");
   		var sumdays = 0;
   		var sumcheckpay = 0;
   		var sumfoodpay = 0;
   		var sumbusinesstrip = 0;
   		var sumcoundmoney = 0;
   		for(var i = 2;i<tb.rows.length;i++){
   			sumdays = sumdays + tb.rows[i].cells[3].childNodes[0].value*1;
   			sumcheckpay = sumcheckpay + tb.rows[i].cells[4].childNodes[0].value*1;
   			sumfoodpay = sumfoodpay + tb.rows[i].cells[5].childNodes[0].value*1;
   			sumbusinesstrip = sumbusinesstrip + tb.rows[i].cells[6].childNodes[0].value*1;
   			sumcoundmoney = sumcoundmoney + tb.rows[i].cells[7].childNodes[0].value*1;
	   		//alert(tb.rows.length+ "       "+sumdays+"     "+sumcheckpay+"  "+sumfoodpay+"      "+sumbusinesstrip+"     "+sumcoundmoney);
   		}	
   		
		document.getElementById("totalDays").value = sumdays;
		document.getElementById("totalcheckPay").value = (parseFloat(sumcheckpay)).toFixed(2);
		document.getElementById("totalfoodPay").value = (parseFloat(sumfoodpay)).toFixed(2);
		document.getElementById("totalbusinessTrips").value = (parseFloat(sumbusinesstrip)).toFixed(2);
		document.getElementById("totalcountMoney").value = (parseFloat(sumcoundmoney)).toFixed(2);
		
   }
   
   
   
   // 只能输入数字       并计算小计
	function f_onkeyup(t){
		if(!isNaN(t.value)){
			var value = t.value.replace(/[^\d\.\\-]/g,'');
			//t.value = (parseFloat(value)).toFixed(2);
		}else{
			t.value="";
		}
	}

   // 转成 两位 小数 
	function f_blur(t){
		t.value = (parseFloat(t.value*1)).toFixed(2);
	}
   
   // 计算小计
   function f_countMoney(t){
   		var checkPay = t.parentNode.parentNode.cells[4].childNodes[0].value;
   		var foodPay = t.parentNode.parentNode.cells[5].childNodes[0].value;
   		var businessTrips = t.parentNode.parentNode.cells[6].childNodes[0].value;
   		var total = checkPay*1 + foodPay*1 + businessTrips*1;
   		t.parentNode.parentNode.cells[7].childNodes[0].value = (parseFloat(total)).toFixed(2);
   		f_jisuan(); 	   // 计算总金额
   }
   
   
   // 保存
   function f_save(){ 
		thisForm.action = "${pageContext.request.contextPath}/common/hourCostManage.do?method=addHourCostManageTable";
		thisForm.submit();
	}
   
   
   // 求和
   function getSum(){
	 var groupCost =  $("#groupCost").val() ;
	 var memberCost =  $("#memberCost").val() ;
	 
	 if(groupCost == "") {
	 	groupCost = "0";
	 }
	 if(memberCost == "") {
	 	memberCost = "0";
	 }
	 $("#total").val(parseInt(groupCost)+parseInt(memberCost));
   }

   // 验证 月和对应的天数 
   function f_testMonthDay(t){
 	  var str = t.value;
 	  if(str.indexOf("/") != -1){
 		  date = str.split("/");
 	  }else{
 		  date = str.split("-");
 	  }
 		  
 	  var year = date[0]*1;
 	  var month = date[1]*1;
       var day = date[2]*1;
       // 判断月份
       if(month > 12 || month < 1){
 			alert("月份不合法!");
 			t.value = "";
 			return false;
       }

       var temp = "";
       // 判断天数 
       if(day>31){
 			alert("天数不合法！");
 			t.value = "";
 			return false;
       }else{
    	   		if(0==year%4&&((year%100!=0)||(year%400==0))) {  // 闰年 
 				if(month==2){
 					if(day>29){
 						alert("该月的天数不能大于29");
 						t.value = "";
 						return false;
 					}
 				}
            }else{
 	       	   if(month==2){
 						if(day>28){
 							alert("该月的天数不能大于28");
 							t.value = "";
 							return false;
 						}
 					}
 	        }
    	  		if(month==4 || month==6 || month==9 || month==11){
 				if(day>30){
 					alert("该月的天数不能大于30");
 					t.value = "";
 					return false;
 				}
 			}
        }

       return true;
 	}
 	
 	// 检查城际交通费的检查人员
 	function f_checkMan(t){
 		var tb = document.getElementById("tb");
 		var j = "0";
   		for(var i = 2;i<tb.rows.length;i++){
   			if(tb.rows[i].cells[0].childNodes[0].value==t.value){
   				j = i;
   			}
   		}
   		if(t.value!=""){
	   		if(j=="0"){
	   			alert("请选择在监管工时费用信息表中的检查组人员1！");
	   			t.value = "";
	   			t.focus();
	   			return;
	   		}	
   		}
 	}
 	
 	// 检查 检查组人员 
 	function f_forbidNull(t){
 		var checkManIDs = t.parentNode.parentNode.cells[0].childNodes[0].value;
 		if(checkManIDs=="" || checkManIDs==null){
 			alert("请录入检查组人员！");
 			t.parentNode.parentNode.cells[0].childNodes[0].focus();
 			return;
 		}
 	}
 	
 	// 监管工时费用信息表中的检查组人员 不能重复
 	function f_distinctManID(t){
 		var tb = document.getElementById("tb");
   		for(var i = 2;i<tb.rows.length;i++){
   			// 避免与自己比较
   			if(tb.rows[i].cells[0].childNodes[0].id!=t.id){
	   			if(tb.rows[i].cells[0].childNodes[0].value==t.value){
	   				alert("请不要录入相同的检查组人员！");
	   				t.value = "";
	   				return;
	   			}
	   		}
   		}
 	}
 	
 	// 计算城际交通费
 	function f_calcBusinessTrips(t){
		var tb = document.getElementById("tb");
		var tb2 = document.getElementById("tb2");
		
		var checkManIDs = t.parentNode.parentNode.cells[0].childNodes[0].value;
		
		var t_money = "0";
		for(var i = 2;i<tb2.rows.length;i++){
			if(tb2.rows[i].cells[0].childNodes[0].value==checkManIDs){
				t_money = t_money*1 + tb2.rows[i].cells[4].childNodes[0].value*1;
			} 
   		}
   		
   		for(var i = 2;i<tb.rows.length;i++){
   			if(tb.rows[i].cells[0].childNodes[0].value==checkManIDs){
   				tb.rows[i].cells[6].childNodes[0].value = t_money; 
   				f_countMoney(tb.rows[i].cells[0].childNodes[0]);  
   			}
   		}
 	}
 	
 	
	function f_back(){
		var source = "${source}";
		// 监管作业链接过来的
		if(source=="hfjl"){
			window.location = "${pageContext.request.contextPath}/common/supervision.do?method=goSupervision&type=hfjl";
		}else{
			window.history.back();
		}
	}
</script>
</html>