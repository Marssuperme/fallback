<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<input type="hidden" id="qtguid" name="qtguid" value="${qt.guid}">
<input type="hidden" id="bguid" name="bguid" value="${qt.guid}">
<input type="hidden" id="addJsp" name="addJsp" value="${pageContext.request.contextPath}/common/bb.do?method=addQtzcpgTable">
<input type="hidden" id="updateJsp" name="updateJsp" value="${pageContext.request.contextPath}/common/bb.do?method=updateQtzcpgTableById">
 
<table border="1" cellpadding="0" cellspacing="0" style="padding-left: 2px;" width="100%">
  <tr>
    <td class="data_tb_alignright" style="text-align: left;" width="597" colspan="4" height="16">业务基本信息</td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">业务类型<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23"><input maxlength="50" onfocus="onPopDivClick(this);"
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=55
						autoWidth="190"
						refer="其他资产评估业务类型"
						hideresult=true title="业务类型" id="ywlx" value="${qt.ywlx}" name="ywlx" size="20" class="required"></td>
    <td width="20%" height="23" class="data_tb_alignright">评估目的<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23"><input maxlength="50" onfocus="onPopDivClick(this);"
    					autoWidth=180
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=55
						autoWidth="190"
						refer="其他资产评估目的"
						hideresult=true id="pgmd" value="${qt.pgmd}" name="pgmd" size="20" class="required"></td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">评估对象<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23"><input maxlength="50" onfocus="onPopDivClick(this);"
    					noinput="true"
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=55
						autoWidth="190"
						refer="其他资产评估对象"
						hideresult=true title="业务类型" id="pgdx" value="${qt.pgdx}" name="pgdx" size="20" class="required"></td>
    <td width="20%" height="23" class="data_tb_alignright">主要评估方法<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23"><input maxlength="50" onfocus="onPopDivClick(this);"
    					noinput="true"
    					autoWidth=180
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=55
						autoWidth="190"
						refer="其他资产主要评估方法"
						hideresult=true id="zypgffxz" value="${qt.zypgffxz}" name="zypgffxz" size="20" class="required"></td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">账面原值</td>
    <td width="30%" height="23"><input  id="zmyz" value="${qt.zmyz}" name="zmyz" size="20" onkeyup="f_money(this)" >万元</td>
    <td width="20%" height="23" class="data_tb_alignright">评估价值</td>
    <td width="30%" height="23"><input id="pgjz" value="${qt.pgjz}" name="pgjz" size="20" onkeyup="f_money(this)" >万元</td>
  </tr>
  	
</table>

<script>

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

//计算收费标准
function getChargeStandard(){
	var type = "评估计件";
	var zmyz = document.getElementById("zmyz").value*1;
	var pgjz = document.getElementById("pgjz").value*1;
	if((zmyz+pgjz)==0){
		setTab('search','nre');
		document.getElementById("zmyz").select();
		alert("帐面资产总计与评估资产总计之和必须大于0!");
		return "N";
	}
	var zcze = zmyz !=0 ? zmyz : pgjz;
	var url="${pageContext.request.contextPath}/common/content.do?method=getChargeStandard";
	var request = "&type="+type+"&zcze="+zcze+"&kind=2&year=0&hour=0";
	var resText = ajaxLoadPageSynch(url,request);
	return resText;
}
</script>