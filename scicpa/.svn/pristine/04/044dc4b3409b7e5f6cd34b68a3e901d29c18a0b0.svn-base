<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<input type="hidden" id="jtguid" name="jtguid" value="${jt.guid}">
<input type="hidden" id="bguid" name="bguid" value="${jt.guid}">
<input type="hidden" id="addJsp" name="addJsp" value="${pageContext.request.contextPath}/common/bb.do?method=addJrblpgTable">
<input type="hidden" id="updateJsp" name="updateJsp" value="${pageContext.request.contextPath}/common/bb.do?method=updateJrblpgTableById">
 
<table border="1" cellpadding="0" cellspacing="0" style="padding-left: 2px;" width="100%">
  <tr>
    <td class="data_tb_alignright" style="text-align: left;" width="597" colspan="4" height="16">业务基本信息</td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">业务类型<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23"><input maxlength="50" onfocus="onPopDivClick(this);"
				    	noinput=true	
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=55
						autoWidth="190"
						refer="金融不良资产评估业务类型"
						hideresult=true title="业务类型" id="ywlx" value="${jt.ywlx}" name="ywlx" size="20" class="required"></td>
    <td width="20%" height="23" class="data_tb_alignright">报告形式<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23"><input maxlength="50" onfocus="onPopDivClick(this);"
    					autoWidth=180
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=55
						autoWidth="190"
						refer="报告形式"
						hideresult=true id="bglx" value="${jt.bglx}" name="bglx" size="20" class="required"></td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">汇总户数</td>
    <td width="30%" height="23"><input  id="hzzs" value="${jt.hzzs}" name="hzzs" size="20" onkeyup="f_money(this)" ></td>
    <td width="20%" height="23" class="data_tb_alignright">债权金额</td>
    <td width="30%" height="23"><input id="zqje" value="${jt.zqje}" name="zqje" size="20" onkeyup="f_money(this)" >万元</td>
  </tr>
  <tr>
	<td align="left" colspan="4">
		<fieldset style="border: 1px solid lightblue;width:100%;border-collapse:collapse;">
			<legend>
				评估价值
			</legend>
				<table width="100%" border="1" align="left" cellpadding="0" cellspacing="0" style="border:1px solid lightblue;border-collapse:collapse;">
					<tr>
						<td class="data_tb_alignright" align="left" >实物类资产</td>
						<td  align="left">
							<input maxlength="20" class="data_tb_content" name="swlzc" type="text" id="swlzc" size="15" value="${jt.swlzc}" onkeyup="f_money(this)" onpropertychange="f_sethj()">万元
						</td>
						<td class="data_tb_alignright" align="left" >股权类资产</td>
						<td  align="left">
							<input maxlength="20" class="data_tb_content" name="gqlzc" type="text" id="gqlzc" size="15" value="${jt.gqlzc}" onkeyup="f_money(this)" onpropertychange="f_sethj()">万元
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" align="left" >其它资产</td>
						<td  align="left">
							<input maxlength="20" class="data_tb_content" name="qtzc" type="text" id="qtzc" size="15" value="${jt.qtzc}" onkeyup="f_money(this)" onpropertychange="f_sethj()">万元
						</td>
						<td class="data_tb_alignright" align="left" >债权类资产</td>
						<td  align="left">
							<input maxlength="20" class="data_tb_content" name="zqlzc" type="text" id="zqlzc" size="15" value="${jt.zqlzc}" onkeyup="f_money(this)" onpropertychange="f_sethj()">万元
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" align="left" >合计</td>
						<td  align="left" colspan="3">
							<input maxlength="20" class="data_tb_content" name="hj" type="text" id="hj" size="15" value="${jt.hj}" readonly="readonly" >万元
						</td>
					</tr>
				</table>
		</fieldset>
	   </td>
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

// 计算合计
function f_sethj(){
	var swlzc = document.getElementById("swlzc").value;//实物类资产
	var gqlzc = document.getElementById("gqlzc").value;//股权类资产
	var qtzc = document.getElementById("qtzc").value;//其它资产
	var zqlzc = document.getElementById("zqlzc").value;//债权类资产
	
	// 合计
	document.getElementById("hj").value = swlzc*1 + gqlzc*1 + qtzc*1 + zqlzc*1;
	
}

//计算收费标准
function getChargeStandard(){
	var type = "评估计件";
	var hj = document.getElementById("hj").value*1;
	if(hj==0){
		setTab('search','nre');
		document.getElementById("hj").select();
		alert("评估价值的合计必须大于0!");
		return "N";
	}
	var zcze = hj;
	var url="${pageContext.request.contextPath}/common/content.do?method=getChargeStandard";
	var request = "&type="+type+"&zcze="+zcze+"&kind=2&year=0&hour=0";
	var resText = ajaxLoadPageSynch(url,request);
	return resText;
}
</script>