<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>seatPlan.jsp</title>


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/main.css" />
	
<style>
.formTitle {
	color: #4A74BC;
	font-weight: bold;
	font-size: 14px;
	text-align: center;
	width: 100%;
	margin-top: 10px;
}

a:visited {text-decoration: none;}

.mustSpan {
	color: #FF6600;
	font-family: "宋体";
	font: normal;
	font-size: 9pt;
	padding: 0px;
	margin: 0px;
}

.data_tb TD {
	BORDER-RIGHT: #b0c6d8 1px solid; BORDER-TOP: #b0c6d8 1px solid; PADDING-LEFT: 2px; BORDER-LEFT: #b0c6d8 1px solid; WORD-BREAK: break-all; BORDER-BOTTOM: #b0c6d8 1px solid; WORD-WRAP: break-word 
}

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
	BORDER-RIGHT-COLOR: #b2c9d3;
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
.dispaly {
	display: none;
}

label { width: 10em; float: left; }
label.error { float: none; color: red; padding-left: .5em; vertical-align: top; }

.TB{border-collapse:collapse;border:none;width: 100%}
.TD{border:1px solid #b0c6d8;}

</style>

</head>
<body>
<%
	// 初始化信息
	String cpano_info = "cpa号";
	String cpaName_info = "姓名";
%>

<form name="myform" id="myform" action="" method="post" > 
	
<table style="width: 95%; border: 0px;margin-top: 20px;" class="data_tb" align="center">
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">教室名称：<font color="#FF0000">[*]</font></td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input id="meetingRoom" name="meetingRoom" class="required">
		</td>
		<td class="data_tb_alignright" width="20%" height="18">培训班名称：<font color="#FF0000">[*]</font></td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input id="trainingClass" name="trainingClass" class="required">
		</td>
	</tr>
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">培训开始日期：<font color="#FF0000">[*]</font></td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input id="trainingStartDate" name="trainingStartDate" showcalendar="true" class="required" >
		</td>
		<td class="data_tb_alignright" width="20%" height="18">培训结束日期：<font color="#FF0000">[*]</font></td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input id="trainingEndDate" name="trainingEndDate" showcalendar="true" class="required" >
		</td>
	</tr>
	
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">座位行数：<font color="#FF0000">[*]</font></td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input id="rows" name="rows" onkeyup="f_number(this)" onpaste="return false" class="required">
		</td>
		<td class="data_tb_alignright" width="20%" height="18">座位列数：<font color="#FF0000">[*]</font></td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input id="columns" name="columns" onkeyup="f_number(this)" onpaste="return false" class="required">
		</td>
	</tr>
</table>

<table style="width: 95%; border: 0px;margin-top: 20px;display: none" class="data_tb" align="center" id="seatTable">
	<tr>
		<td class="data_tb_content" colspan="4"> 
			<div id="seatPlan_div" style="text-align: center;width: 760px;height: 195px;overflow: auto;">
			
			</div>
		</td>
	</tr>
</table>

<div style="margin-top: 20px;text-align: center;">
<input type="button" id="createTable" name="createTable" value="createTable" onclick="createTable()">&nbsp;&nbsp;&nbsp;
<input type="button" icon="icon-save" id="save" name="save" value="保存" onclick="f_save()">&nbsp;&nbsp;&nbsp;
<input type="button" icon="icon-back" id="save" name="save" value="返回" onclick="f_back()">
</div>
<br>
</form>

</body>

<script type="text/javascript">

//加验证
$(document).ready(function(){
   $("#myform").validate();
});


var cpano_info = "<%=cpano_info%>";
var cpaName_info = "<%=cpaName_info%>";

//初始化提示信息
function f_init_focucmsg(){
	$(document).ready(function(){
		$("input[focucmsg]").each(function(){
			$(this).val($(this).attr("focucmsg"));
			$(this).val($(this).attr("focucmsg")).css("color","#979393");
			$(this).focus(function(){
				if($(this).val()== $(this).attr("focucmsg")){
					$(this).val('');
					$(this).val('').css("color","#6b6969");
				}
			});
			$(this).blur(function(){
				if(!$(this).val()){
					$(this).val($(this).attr("focucmsg"));
					$(this).val($(this).attr("focucmsg")).css("color","#979393");
				}
			});
		});
	});
}

// 验证数字
function f_number(t){
	t.value = t.value.replace(/[^\d]/g,'');
	if(t.value*1<0){
		t.style.color = "red";
	}else{
		t.style.color = "black";
	}
} 

// 去空格
function f_clearNull(id){
	var id_value = document.getElementById(id).value;
	var id_value_array = id_value.split(" ");
	var tempValue = "";
	// 去空格
	for(var i=0;i<id_value_array.length;i++){
		tempValue = tempValue + id_value_array[i]; 
		tempValue = tempValue.replace(" ",""); 
	}
	id_value = tempValue;
	return id_value; 
}

// 创建表格
function createTable() {
	if(f_checkRowColumns()){
		var data = new Array();
	    var rows = document.getElementById("rows").value;
	    var columns = document.getElementById("columns").value;
	    data.push('<table border=0 id=\'table1\' class=\'TB\'><tbody>');
	    var i_temp = 0;
		for (var i = 1; i <= rows; i++) {
	       	data.push('<tr>');
	       	for (var j = 1; j <= columns; j++) {
	       		data.push('<td class=\'TD\'><input id=\'seatno'+i_temp+'\' name=\'seatno\' value=' + i + '-' + j + ' style=\'text-align:center;border:0px;width:100%;\'><br><input id=\'cpano'+i_temp+'\' name=\'cpano\' focucmsg='+cpano_info+' style=\'width:100%;height: 0px;\' onkeyup=\'f_changeStyle(this)\' ><br><input id=\'cpaName'+i_temp+'\' name=\'cpaName\' focucmsg='+cpaName_info+' style=\'width:100%;\' onkeyup=\'f_changeStyle(this)\' style=\'margin-top:1px;\' ></td>');
	       		i_temp = i_temp + 1;
	       	}
	       	data.push('</tr>');
		}
		data.push('</tbody><table>');
	      
		document.getElementById('seatPlan_div').innerHTML = data.join('');
		
		f_init_focucmsg();
		
		document.getElementById("seatTable").style.display = "";
	}
 } 
	
	
// 检查值	
function f_changeStyle(t){
	if(t.value==cpano_info || t.value==cpaName_info){
		t.style.color = "#979393";
	}else{
		t.style.color = "black";
	}
}

// 检查数组元素重复
function f_checkRepeat(ary,exceptValue){
	var s = ary.join(",")+",";
	for(var i=0;i<ary.length;i++){ 
		if(s.replace(ary[i]+",","").indexOf(ary[i]+",")>-1 && exceptValue!=ary[i] ){
			alert(ary[i]+"重复!");
			return false; 
		} 
	}
	return true;
} 

// 变色
function f_changeColor(ary,id,color,exceptValue){
	var s = ary.join(",")+","; 
	for(var i=0;i<ary.length;i++){ 
		if(s.replace(ary[i]+",","").indexOf(ary[i]+",")>-1 && exceptValue!=ary[i]){
			document.getElementById(id+i).style.color = color;
		} 
	}
}

// 对象数组转值数组
function f_changeValueArray(arrayObj){
	var value_array = [];
	for(var i=0;i<arrayObj.length;i++){
		value_array.push(arrayObj[i].value);
	}
	return　value_array;
}

// 保存
function f_save(){
	
	if(f_checkNull() && f_checkRowColumns()){
		var isOk = true;
		var cpano_Obj_Array = document.getElementsByName("cpano");
		var cpano_Value_Array = f_changeValueArray(cpano_Obj_Array);
		// 检查 cpano 是否重复
		if(!f_checkRepeat(cpano_Value_Array,cpano_info)){
			isOk = false;
			f_changeColor(cpano_Value_Array,"cpano","red",cpano_info);
		}
		if(isOk){
			document.getElementById("myform").action = "${pageContext.request.contextPath}/common/seat.do?method=save";
			document.getElementById("myform").submit();
		}
	}
}

function f_checkRowColumns(){
	var rows = f_clearNull("rows");
	if(rows=="" || rows.length<1){
		alert("请填写行数！");
		document.getElementById("rows").select();
		return false;
	}
	var columns = f_clearNull("columns");
	if(columns=="" || columns.length<1){
		alert("请填写列数！");
		document.getElementById("columns").select();
		return false;
	}
	
	var rows_value = document.getElementById("rows").value*1;
	if(rows_value<1){
		alert("行数必须大于0！");
		document.getElementById("rows").select();
		return false;
	}
	
	var columns_value = document.getElementById("columns").value*1;
	if(columns_value<1){
		alert("列数必须大于0！");
		document.getElementById("columns").select();
		return false;
	}
	return true;
}

function f_checkNull(){
	var meetingRoom = f_clearNull("meetingRoom");
	if(meetingRoom=="" || meetingRoom.length<1){
		alert("请填写教室名称！");
		document.getElementById("meetingRoom").select();
		return false;
	}
	var trainingClass = f_clearNull("trainingClass");
	if(trainingClass=="" || trainingClass.length<1){
		alert("请填写培训班名称！");
		document.getElementById("trainingClass").select();
		return false;
	}
	var trainingStartDate = f_clearNull("trainingStartDate");
	if(trainingStartDate=="" || trainingStartDate.length<1){
		alert("请填写培训开始日期！");
		document.getElementById("trainingStartDate").select();
		return false;
	}
	var trainingEndDate = f_clearNull("trainingEndDate");
	if(trainingEndDate=="" || trainingEndDate.length<1){
		alert("请填写培训结束日期！");
		document.getElementById("trainingEndDate").select();
		return false;
	}
	
	var seatPlan_div_value = document.getElementById("seatPlan_div").innerHTML;
	if(seatPlan_div_value=="" || seatPlan_div_value.length<1){
		alert("请创建座位！");
		return false;
	}
	return true;
}

// 返回
function f_back(){
	document.getElementById("myform").action = "${pageContext.request.contextPath}/common/seat.do?method=index";
	document.getElementById("myform").submit();
}

</script>

</html>