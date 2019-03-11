<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>监管工时费用报备管理</title>

 <style>
 	.before{
		border: 0px;
		background-color: #FFFFFF !important;
	}
	
	#tb {background-color: #ffffff;text-align: center;border:#d1dfbb 1px solid;border-collapse:collapse;width:90%;margin:20 0px;}
	#tb td{white-space:nowrap;padding: 1px;border-top: #d1dfbb 1px solid;border-left: #d1dfbb 1px solid;height:30px;}
	#tb input{border:0px;border-bottom:1px solid #aaa;}
	#tb2 {background-color: #ffffff;text-align: center;border:#d1dfbb 1px solid;border-collapse:collapse;width:90%;margin:20 0px;}
	#tb2 td{white-space:nowrap;padding: 1px;border-top: #d1dfbb 1px solid;border-left: #d1dfbb 1px solid;height:30px;}
	#tb2 input{border:0px;border-bottom:1px solid #aaa;}
	#desc {height : 27px ;line-height: 27px ;color: #125908 ;font-size: 14px;font-weight: bold;padding-left: 5px;}
	.titleTd{background-color: #eff7e2;font-size: 13px;font-family:"宋体";}
	.otherinput{border:0px;border-bottom:1px solid #aaa;margin-right: 100px;}
	a:visited{color:blue} 
	.error{color: red;}
</style>

</head>

<body style="height:100%;">
	<form id="thisForm" name="thisForm" method="post">
	<input name="testnoticeid" type="hidden" id="testnoticeid"  value="${testnoticeid}"  >
		<input type="hidden" id="mid" name="mid" value="${hcmt2.id}">
		<div id="desc">请录入监管工时费用信息：</div>
		<div style="height:1px;border-top:1px solid #aabbcc;width: 100%;"></div>
		<div style="overflow:scroll;width: 99%">
			<table align="center">
				<tr>
					<td align="right">填报人：</td>
		    		<td><input type="text" id="fillMan" name="fillMan" class="required" value="${hcmt2.fillMan}" style="border:0px;border-bottom:1px solid #aaa;" title="请输入填报人">
		    		</td>
		    		<td>填报项目：</td>
					<td><input type="text"  id="checkProject" name="checkProject" class="required" value="${hcmt2.checkProject}" style="border:0px;border-bottom:1px solid #aaa;" title="请输入填报项目">
					</td>
		    	</tr>
				<tr>
					<td>被检查事务所名称：</td>
					<td><input type="text" id="checkOffice" name="checkOffice" title="请被检查事务所名称"
				 		class="required" size="30" value="${hcmt2.checkoffice}" style="border:0px;border-bottom:1px solid #aaa;" refer="testnoticeid" onfocus="onPopDivClick(this);"
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						valuemustexist="true"
						autoid=25  class="required">
				 	</td>
					<td>填报日期：</td>
					<td><input type="text"  id="fillTime" name="fillTime" class="required" value="${hcmt2.fillTime}" style="border:0px;border-bottom:1px solid #aaa;" title="请输入填报日期" showcalendar="true" class="date">
					</td>
				</tr>
			</table>
		
		<table id="tb" cellpadding="5" cellspacing="0" width="100%" style="margin-left: 10px;">
			<tr>
				<td colspan="9" class="titleTd">监管工时费用信息&nbsp;&nbsp;&nbsp;&nbsp;<a href="###" onclick="addLine();">【点击追加信息】</a></td>
			</tr>
			<tr>
				<td class="titleTd" width="120px">检查组人员</td>
				<td class="titleTd" width="170px">起始日期</td>
				<td class="titleTd" width="170px">结束日期</td>
				<td class="titleTd" width="40px">天数</td>
				<td class="titleTd" width="130px">检查津贴(200人/天)</td>
				<td class="titleTd" width="60px">食宿费</td>
				<td class="titleTd" width="100px">差旅交通费</td>
				<td class="titleTd" width="40px">小计</td>
				<td class="titleTd" width="80px">&nbsp;&nbsp;&nbsp;操&nbsp;作&nbsp;&nbsp;&nbsp;</td>
			</tr>
			<c:forEach var="l" items="${list}">
				<tr>
					<td width="120px" nowrap="nowrap"><input type="text" id="checkManID" name="checkManID" value="${l.checkManID}" class="required"></td>
					<td width="170px"><input type="text" id="startTime" name="startTime" value="${l.startTime}" onpropertychange="f_days(this);" showcalendar="true"></td>
					<td width="170px"><input type="text" id="endTime" name="endTime" value="${l.endTime}" onpropertychange="f_daye(this);" showcalendar="true"></td>
					<td width="40px"><input type="text" id="countDays" name="countDays" readonly="readonly" value="${l.countDays}" ></td>
					<td width="130px"><input type="text" id="checkPay" name="checkPay" style="text-align: right" readonly="readonly" value="${l.checkPay}"></td>
					<td width="60px"><input type="text" id="foodPay" name="foodPay" style="text-align: right" value="${l.foodPay}" onpropertychange="f_countMoney(this)" onkeyup="f_onkeyup(this)" onblur="f_blur(this)" title="请输入有效的金额"></td>
					<td width="100px"><input type="text" id="businessTrips" style="text-align: right" name="businessTrips" value="${l.businessTrips}" onpropertychange="f_countMoney(this)" onkeyup="f_onkeyup(this)" onblur="f_blur(this)"  title="请输入有效的金额"></td>
					<td width="40px"><input type="text" id="countMoney" name="countMoney" style="text-align: right" readonly="readonly" value="${l.countMoney}"></td>
					<td width="80px">
						<a href="###" onclick="removeLine(this);">【删除】</a>
					</td>
				</tr>
			</c:forEach>
			 
		 </table> 
		 <table id="tb2" cellspacing="0" width="100%" style="margin-left: 10px;margin-top: -15px;">
			<tr>
				<td <c:if test="${valid=='N' }">width="395px" </c:if><c:if test="${valid!='N' }">width="460px" </c:if> nowrap="nowrap" class="titleTd" colspan="3">合&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计</td>
				<td width="40px"><input type="text" readonly="readonly" id="totalDays" name="totalDays" value="${hcmt2.totalDays }"></td>
				<td width="130px"><input style="text-align: right" type="text" readonly="readonly" id="totalCheckPay" name="totalCheckPay" value="${hcmt2.totalCheckPay }"></td>
				<td width="60px"><input style="text-align: right" type="text" readonly="readonly" id="totalfoodPay" name="totalfoodPay" value="${hcmt2.totalfoodPay }"></td>
				<td width="100px"><input style="text-align: right" type="text" readonly="readonly" id="totalbusinessTrips" name="totalbusinessTrips" value="${hcmt2.totalbusinessTrips }"></td>
				<td width="40px"><input style="text-align: right" type="text" id="totalCountMoney" name="totalCountMoney" readonly="readonly" value="${hcmt2.totalCountMoney }"></td>
				<td width="80px"></td>
			</tr>
			
		</table> 
		</div><br>
		<center>
			<span id="saveSpan">
				<input type="submit" icon='icon-save' id="saveBtn" name="next" value="保存"  onclick="return f_save();" >&nbsp;&nbsp;
			</span>
			<input type="button" icon='icon-back' id="backBtn" name="next" value="返回"  onclick="window.history.back();" >
		</center>
	</form>
</body>

<script type="text/javascript"> 

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



	//加验证
	$(document).ready(function(){
	    $("#thisForm").validate();
	});
 
	$(function (){$("#thisForm").validate({
		errorClass: "error",
		errorElement: "div"
	});})
	
	
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
	document.getElementById("fillTime").value = nowtime;

	
	// 添加行
	function addLine(){
	  $('#tb').append("<tr><td class='serial'><input type='text' name='checkManID' id='checkManID' class='required'></td>"
	  					+"<td><input type='text' name='startTime' id='startTime' class='required' onpropertychange='f_days(this);' showcalendar='true' ></td>"
	  					+"<td><input type='text' name='endTime' id='endTime' onpropertychange='f_daye(this);' showcalendar='true' ></td>"
	  					+"<td><input type='text' readonly='readonly' name='countDays' id='countDays' value='0' ></td>"
	  					+"<td><input type='text' name='checkPay' id='checkPay' style='text-align: right' readonly='readonly' value='0.00'></td>"
	  					+"<td><input type='text' name='foodPay' id='foodPay' style='text-align: right' value='0.00' onpropertychange='f_countMoney(this)' onblur='f_blur(this)' onkeyup='f_onkeyup(this)'></td>"
	  					+"<td><input type='text' name='businessTrips' id='businessTrips' style='text-align: right' value='0.00' onpropertychange='f_countMoney(this)' onblur='f_blur(this)' onkeyup='f_onkeyup(this)' ></td>"
	  					+"<td><input type='text' name='countMoney' id='countMoney' style='text-align: right' readonly='readonly' value='0.00'>"
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
   		var e = /^\d{4}(\-|\/|\.)\d{1,2}\1\d{1,2}$/;
   		
		var startTime = t.parentNode.parentNode.cells[1].childNodes[0].value;
		var endTime = t.parentNode.parentNode.cells[2].childNodes[0].value;
		  
		 
		if(!e.exec(startTime)){
			// alert("日期格式为(年-月-日或年/月/日)");
			t.parentNode.parentNode.cells[1].childNodes[0].value = nowtime;
			t.parentNode.parentNode.cells[3].childNodes[0].value = 0;
			t.parentNode.parentNode.cells[4].childNodes[0].value = "0.00";
			f_countMoney(t); // 计算小计
			f_jisuan();
			return;
		}
				

		// 验证月份 和 天数 
		if(f_testMonthDay(t)){ 
			startTime = startTime.replace(/\-/g,"/");
			endTime = endTime.replace(/\-/g,"/");
			var startDate = new Date(Date.parse(startTime)).getTime();
			var endDate = new Date(Date.parse(endTime)).getTime();
			var result = (endDate-startDate)/(1000*60*60*24);
	
			
					
	   		if(startTime == "" || endTime == ""){
	   			t.parentNode.parentNode.cells[3].childNodes[0].value = 0;
	   			t.parentNode.parentNode.cells[4].childNodes[0].value = "0.00";
	   			f_countMoney(t);   // 计算小计
	   		}else{
	   			if(result<0){
	   				alert("结束日期应大于起始日期");
	   				t.value = "";
	   				t.parentNode.parentNode.cells[3].childNodes[0].value = 0;
	   				t.parentNode.parentNode.cells[4].childNodes[0].value = "0.00";
	   			}else{
	   				t.parentNode.parentNode.cells[3].childNodes[0].value = result;
	   				t.parentNode.parentNode.cells[4].childNodes[0].value = (parseFloat(result*200)).toFixed(2);
	   			}
	   		}
	   		// 计算小计
			f_countMoney(t); 
	   		// 计算总金额
	   		f_jisuan();
		}else{
			t.value = "";
			t.parentNode.parentNode.cells[3].childNodes[0].value = 0;
			t.parentNode.parentNode.cells[4].childNodes[0].value = "0.00";
			f_countMoney(t); // 计算小计
			f_jisuan();
		}
   		
   }
   
    // 计算天数
   function f_daye(t){
   		var e = /^\d{4}(\-|\/|\.)\d{1,2}\1\d{1,2}$/;
   		
		var startTime = t.parentNode.parentNode.cells[1].childNodes[0].value;
		var endTime = t.parentNode.parentNode.cells[2].childNodes[0].value;
		  
	 
		if(!e.exec(endTime)){
			// alert("日期格式为(年-月-日或年/月/日)");
			t.parentNode.parentNode.cells[2].childNodes[0].value = nowtime;
			t.parentNode.parentNode.cells[3].childNodes[0].value = 0;
			t.parentNode.parentNode.cells[4].childNodes[0].value = "0.00";
			f_countMoney(t); // 计算小计
			f_jisuan();
			return;
		}
				

		// 验证月份 和 天数 
		if(f_testMonthDay(t)){ 
			startTime = startTime.replace(/\-/g,"/");
			endTime = endTime.replace(/\-/g,"/");
			var startDate = new Date(Date.parse(startTime)).getTime();
			var endDate = new Date(Date.parse(endTime)).getTime();
			var result = (endDate-startDate)/(1000*60*60*24);
	
				
	   		if(startTime == "" || endTime == ""){
	   			t.parentNode.parentNode.cells[3].childNodes[0].value = 0;
	   			t.parentNode.parentNode.cells[4].childNodes[0].value = "0.00";
	   			f_countMoney(t);   // 计算小计
	   		}else{
	   	   		
	   			if(result<0){
	   				alert("结束日期应大于起始日期");
	   				t.value = "";
	   				t.parentNode.parentNode.cells[3].childNodes[0].value = 0;
	   				t.parentNode.parentNode.cells[4].childNodes[0].value = "0.00";
	   			}else{
	   				t.parentNode.parentNode.cells[3].childNodes[0].value = result;
	   				t.parentNode.parentNode.cells[4].childNodes[0].value = (parseFloat(result*200)).toFixed(2);
	   			}
	   		}
	   		// 计算小计
			f_countMoney(t); 
	   		// 计算总金额
	   		f_jisuan();
		}else{
			t.parentNode.parentNode.cells[2].childNodes[0].value = "";
			t.parentNode.parentNode.cells[3].childNodes[0].value = 0;
			t.parentNode.parentNode.cells[4].childNodes[0].value = "0.00";
			f_countMoney(t); // 计算小计
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
			// t.value = (parseFloat(value)).toFixed(2);
		}else{
			t.value="";
		}
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
		//thisForm.submit();
	}


	// 转成 两位 小数 
	function f_blur(t){
		t.value = (parseFloat(t.value*1)).toFixed(2);
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
</script>
</html>