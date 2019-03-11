<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<input type="hidden" id="bbqtbguid" name="bbqtbguid" value="${bt.guid}">
<input type="hidden" id="bguid" name="bguid" value="${bt.guid}">
<input type="hidden" id="addJsp" name="addJsp" value="${pageContext.request.contextPath}/common/bb.do?method=addBbqtbTable">
<input type="hidden" id="updateJsp" name="updateJsp" value="${pageContext.request.contextPath}/common/bb.do?method=updateBbqtbTableById">

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="data_tb" align="center">
	  <tr>
	    <td width="20%" height="16" class="data_tb_alignright">报表年度</td>
	    <td height="16" align="left" colspan="3">
		    <input maxlength="50" id="bgnd" name="bgnd" value="${ct.bgnd}" size="40" title="报表年度" onkeyup="getProjectName();" onchange="getProjectName();">
		    <font color="red">(会显示在报备封面上)</font>
	    </td>
	  </tr>
	  
 	  <tr>
 	   <td width="20%" height="23" class="data_tb_alignright">其它业务类型<font color="#FF0000">&nbsp;[*]</font></td>
	    <td width="80%" height="23" colspan="3" align="left" >
	    	<input maxlength="100" id="bustype" name="bustype" value="${bt.bustype  }" class="required" style="width: 90%" >
	    </td>
	  </tr>  
	  
	  <tr id="trObjMoney" style="display:none">
	    <td width="20%" class="data_tb_alignright">资产总额<font color="#FF0000">&nbsp;[*]</font></td>
	    <td width="30%" style="text-align: left;"><input maxlength="20" id="zcze" name="zcze" value="${bt.zcze }" size="20" class="required number" onkeyup="f_money(this);f_setMoney(this)" readonly="readonly">元</td>
	   	<td width="20%" class="data_tb_alignright">销售收入<font color="#FF0000">&nbsp;[*]</font></td>
	    <td width="30%" style="text-align: left;"><input maxlength="20" id="xssr" name="xssr" value="${bt.xssr }" size="20" class="required number" onkeyup="f_money(this);f_setMoney(this)" readonly="readonly">元</td>
	  </tr>
	  
	  <tr>
	    <td width="20%" height="53" class="data_tb_alignright">其它承办的项目<font color="#FF0000">&nbsp;[*]</font></td>
	    <td width="80%" height="53" colspan="3" align="left" >
	    	<textarea title="其它承办的项目" id="qtcbdxm" name="qtcbdxm" style="width: 90%;height: 50px;" class="required">${bt.qtcbdxm }</textarea>
	    </td>
	  </tr>
</table>


<script type="text/javascript">

var zcze = document.getElementById("zcze");
var xssr = document.getElementById("xssr");
if(zcze.value == ""){
	zcze.value = "0";
}
if(xssr.value == ""){
	xssr.value = "0";
}

f_display();

function f_display(){
	var bustype = document.getElementById("bustype");
	if(bustype.value=="经济责任审计"){
		document.getElementById("trObjMoney").style.display = "";
	}else{
		document.getElementById("trObjMoney").style.display = "none";
	}
	
}

// 如果金额为空设置为 0
function f_setMoney(t){
	if(t.value==""){
		t.value = "0";
	}
}

// 验证金额
function f_money(t){
	t.value = t.value.replace(/[^\d\.\\-]/g,'');
	
	if(t.value.substring(0,1)=="."){
		t.value = t.value.substring(1,t.value.length);
	}
	
	// 不能有两个小数点
	if(t.value.replace(".","").indexOf(".") > -1){
		var temp = t.value.replace(".","");
		var tempIndex = temp.indexOf(".")+1;
		t.value = t.value.substring(0,tempIndex)+""+t.value.substring(tempIndex+1,t.value.length);
	}   
	
	if(t.value*1<0){
		t.style.color = "red";
	}else{
		t.style.color = "black";
	}
} 

</script>

