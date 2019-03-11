<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>seatPlan.jsp</title>

<style >
	.TB{border-collapse:collapse;border:none;}
	.TD{border:1px solid #b0c6d8;}
</style>

</head>
<body>
	座位行数：<input id="rows" name="rows" onkeyup="f_number(this)" onpaste="return false" ><br><br>
	座位列数：<input id="columns" name="columns" onkeyup="f_number(this)" onpaste="return false" ><br><br>
	<input type="button" id="createTable" name="createTable" value="createTable" onclick="createTable()"><br><br>
	<div id="seatPlan_div">
	
	</div>
	<br><br>
</body>

<script type="text/javascript">

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
	var rows = f_clearNull("rows");
	if(rows=="" || rows.length<1){
		alert("请填写行数！");
		document.getElementById("rows").select();
		return;
	}
	var columns = f_clearNull("columns");
	if(columns=="" || columns.length<1){
		alert("请填写列数！");
		document.getElementById("columns").select();
		return;
	}
	
	var data = new Array();
    
    data.push('<table border=0 id=\'table1\' class=\'TB\'><tbody>');
	for (var i = 1; i <= rows; i++) {
       	data.push('<tr>');
       	for (var j = 1; j <= columns; j++) {
       		data.push('<td class=\'TD\'><input id=\'xuhao'+i+'\' name=\'xuhao\' value=' + i + '-' + j + ' size=5 style=\'text-align:right;border:0px;\'><br><input id=\'loginname'+i+'\' name=\'loginname\' focucmsg=\'姓名\' size=10 onkeyup=\'f_changeStyle(this)\' ><br><input id=\'cpano'+i+'\' name=\'cpano\' focucmsg=\'cpa号\' size=10 onkeyup=\'f_changeStyle(this)\' style=\'margin-top:2px;\' ></td>');
       	}
       	data.push('</tr>');
	}
	data.push('</tbody><table>');
      
	document.getElementById('seatPlan_div').innerHTML = data.join('');
	
	f_init_focucmsg();
 } 
	
	
// 检查值	
function f_changeStyle(t){
	t.style.color = "black";
}

</script>

</html>