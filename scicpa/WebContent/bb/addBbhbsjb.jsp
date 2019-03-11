<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<input type="hidden" id="qsshbguid" name="qsshbguid" value="${ht.guid}">
<input type="hidden" id="bguid" name="bguid" value="${ht.guid}">
<input type="hidden" id="addJsp" name="addJsp" value="${pageContext.request.contextPath}/common/bb.do?method=addHbsjbTable">
<input type="hidden" id="updateJsp" name="updateJsp" value="${pageContext.request.contextPath}/common/bb.do?method=updateHbsjbTableById">

<table border="1" cellpadding="0" cellspacing="0" style="padding-left: 2px;" width="100%" height="20%">
  <tr>
    <td width="15%" height="16" class="data_tb_alignright">合并类型<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="35%" height="16"><input maxlength="50" onfocus="onPopDivClick(this);"
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=55
						noinput=true
						refer="sjlx_hblx"
						autoWidth=190
						hideresult=true id="qslx" value="${ht.qslx}" name="qslx" size="20" class="required" onkeyup="f_money(this);" ></td>
    <td width="15%" height="16" class="data_tb_alignright">合并净损益</td>
    <td width="35%" height="16"><input maxlength="20" id="qsjsy" value="${ht.qsjsy}" name="qsjsy" size="20" class="number" onkeyup="f_money(this);" >元</td>
  </tr>
  
  <tr>
    <td width="15%" height="23" class="data_tb_alignright">资产总额<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="35%" height="23"><input maxlength="20" id="zcze" value="${ht.zcze }" name="zcze" size="20" class="required number" onkeyup="f_money(this);" >元
	<font color="red"></font></td>
   	<td width="15%" height="23" class="data_tb_alignright">营业收入<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="35%" height="23"><input maxlength="20" id="xssr" value="${ht.xssr }" name="xssr" size="20" class="required number" onkeyup="f_money(this);" >元
	<font color="red">(包括销售收入)</font></td>
  </tr>
  <tbody id="tb_tzh_money">
	  <tr>
	    <td width="15%" height="23" class="data_tb_alignright">资产总额(调整后)<font color="#FF0000">&nbsp;[*]</font></td>
	    <td width="35%" height="23"><input maxlength="20" id="zczetzh" value="${ht.zczetzh }" name="zczetzh" size="20" class="number" onkeyup="f_money(this);" >元
		<font color="red"></font></td>
	   	<td width="15%" height="23" class="data_tb_alignright">营业收入(调整后)<font color="#FF0000">&nbsp;[*]</font></td>
	    <td width="35%" height="23"><input maxlength="20" id="xssrtzh" value="${ht.xssrtzh }" name="xssrtzh" size="20" class="number" onkeyup="f_money(this);" >元
		<font color="red"></font></td>
	  </tr>
  </tbody>
  <tr>
    <td width="15%" height="16" class="data_tb_alignright">合并所得</td>
    <td width="35%" height="16"><input maxlength="20" id="qssd" value="${ht.qssd}" name="qssd" size="20" class="number" onkeyup="f_money(this);" >元</td>
    <td width="15%" height="16" class="data_tb_alignright">应纳税所得额</td>
    <td width="35%" height="16"><input maxlength="20" id="ylssde" value="${ht.ylssde}" name="ylssde" size="20" class="number" onkeyup="f_money(this);" >元</td>
  </tr>
  
   <tr>
    <td width="15%" height="16" class="data_tb_alignright">应纳所得税额</td>
    <td width="35%" height="16"><input maxlength="20" id="ylsde" value="${ht.ylsde}" name="ylsde" size="20" class="number" onkeyup="f_money(this);" >元</td>
    <td width="15%" height="16" class="data_tb_alignright">报告意见类型<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="35%" height="16"><input maxlength="200" onfocus="onPopDivClick(this);"
    					autoWidth=180
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=7
						refer=0
						noinput=true
						hideresult=true id="bgyjlx" value="${ht.bgyjlx}" name="bgyjlx" size="20" class="required"></td>
  </tr>
 
  <tr>
    <td width="15%" height="16" class="data_tb_alignright">报表年度</td>
    <td width="35%" height="16" >
	    <input maxlength="50" id="bgnd" name="bgnd" value="${ct.bgnd}" size="20" title="报表年度" onkeyup="getProjectName();" onchange="getProjectName();">
	    <font color="red">(会显示在报备封面上)</font>
    </td>
    <td width="15%" height="16" class="data_tb_alignright">是否需要调整<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="35%" height="16"><input maxlength="200" onfocus="onPopDivClick(this);"
    					autoWidth=140
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=55
						refer="是否连续审计"
						noinput=true
						hideresult=true id="sftzje" value="${ht.sftzje}" name="sftzje" size="20" class="required" onchange="f_display_tzh_money()">
						<font color="red">(如有调整请在报备完成前填列)</font>
						
						
						
						
	</td>
  </tr>
  
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">从业人员<font color="#FF0000"></font></td>
    <td height="23" colspan="3">
    	<input type="text" maxlength="20" id="cyry" value="${ht.cyry }" name="cyry" title="从业人员" size="20" class="number" onkeyup="f_number(this);f_checkZero(this);" >人
    	<font color="red">(被审验单位期末员工数)</font>
    </td>
  </tr>
  
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">保留意见内容</td>
    <td width="80%" height="16" colspan="3"><textarea id="bjyjly" style="width: 90%;height: 50px;" name="bjyjly">${ht.bjyjly }</textarea></td>
  </tr>
   
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">无保留意见强调事项</td>
    <td width="80%" height="16" colspan="3"><textarea id="notblyjly" style="width: 90%;height: 50px;" name="notblyjly">${ht.notblyjly }</textarea></td>
  </tr>
</table>


<script type="text/javascript">

// 默认为否
var sftzje = "${ht.sftzje}";
if(sftzje == ""){
	document.getElementById("sftzje").value = "否";
	document.getElementById("tb_tzh_money").style.display = "none";
}else{
	f_display_tzh_money();
}

// 验证应收业务费金额
function f_checkMoney(isCount,wjjsfbz){
	// isyqyyw=1 已签约业务：从OA 导入进来的 报备数据，直接是审核通过状态了。
	var isyqyyw = "${at.isyqyyw}";
	
	// 资产总金额
	var zcze = document.getElementById("zcze").value;
	if(zcze==""){
		setTab('search','nre');
		document.getElementById("zcze").select();
		alert("资产总额不能为空！");
		return "notAlert";
	}
	zcze = zcze*1;
	
	// 营业收入
	var xssr = document.getElementById("xssr").value;
	if(xssr==""){
		setTab('search','nre');
		document.getElementById("xssr").select();
		alert("营业收入不能为空！");
		return "notAlert";
	}
	xssr = xssr*1;
	
	if((xssr*1+zcze*1)<=0){
		var bbState = "${ct.bbstate}";
		if(bbState!="审核通过" || isyqyyw=="1"){
			setTab('search','nre');
			document.getElementById("zcze").select();
			alert("资产总额、营业收入之和必须大于0！");
			return "notAlert";
		}else{
			if(wjjsfbz=="wjjsfbz"){
				var moneyArray = f_checkMoneyStandard(0,"hbsj001");
				var standerMoney = moneyArray[1]*1;
				return "发改委、财政厅收费标准价为："+standerMoney.toFixed(2)+" 元!";
			}
		}
	}else{
		var ysywfCountTemp = zcze<xssr?xssr:zcze;
		// 转元
		ysywfCountTemp = ysywfCountTemp/10000;
		
		// 广州、珠海、佛山、东莞、中山、江门、深圳
		var area = "${userSession.userMap.area}";
		var ywarea = document.getElementById("ywarea").value;
		
		// 物价局收费标准：直接提示标准价
		if(wjjsfbz=="wjjsfbz"){
			var moneyArray = f_checkMoneyStandard(ysywfCountTemp,"hbsj001");
			var standerMoney = moneyArray[1]*1;
			return "发改委、财政厅收费标准价为："+standerMoney.toFixed(2)+" 元!";
		}else{
			return f_returnInfo(ysywfCountTemp,"hbsj001",isCount);
		}
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

// 检查是否小于0
function f_checkZero(t){
	if(t.value<=0){
		t.value="";
	}
}

// 调整后金额
function f_display_tzh_money(){
	var sftzje = document.getElementById("sftzje").value;
	if(sftzje=="是"){
		document.getElementById("tb_tzh_money").style.display = "";
	}else{
		document.getElementById("tb_tzh_money").style.display = "none";
	}
}


// 检查调整后金额之和大于零
function f_check_tzh_money(){
	var sftzje = document.getElementById("sftzje").value;
	if(sftzje=="是"){
		// 调整后资产总金额
		var zczetzh = document.getElementById("zczetzh").value;
		if(zczetzh==""){
			setTab('search','nre');
			document.getElementById("zczetzh").select();
			alert("调整后资产总额不能为空！");
			return "notAlert";
		}
		zczetzh = zczetzh*1;
		
		// 调整后营业收入
		var xssrtzh = document.getElementById("xssrtzh").value;
		if(xssrtzh==""){
			setTab('search','nre');
			document.getElementById("xssrtzh").select();
			alert("调整后营业收入不能为空！");
			return "notAlert";
		}
		xssrtzh = xssrtzh*1;
		
		
		if((zczetzh*1+xssrtzh*1)<=0){
			setTab('search','nre');
			document.getElementById("zczetzh").select();
			alert("调整后资产总额、调整后营业收入之和必须大于0！");
			return "notAlert";
		}
	}
	return "OK";
}

//计算收费标准
function getChargeStandard(){
	var type = "合并审计";
	var zcze = document.getElementById("zcze").value;
	var yysr = document.getElementById("xssr").value;
	if((zcze+yysr)==0){
		setTab('search','nre');
		document.getElementById("zcze").select();
		alert("资产总额与营业收入之和必须大于0!");
		return "N";
	}else if(zcze==""){
		setTab('search','nre');
		document.getElementById("zcze").select();
		alert("资产总额不能为空!");
		return "N";
	}else if(yysr==""){
		setTab('search','nre');
		document.getElementById("xssr").select();
		alert("营业收入不能为空!");
		return "N";
	}
	
	var zcze = zcze*1>yysr*1 ? zcze : yysr;
	var url="${pageContext.request.contextPath}/common/content.do?method=getChargeStandard";
	var request = "&type="+type+"&zcze="+zcze+"&kind=1&year=0&hour=0";
	var resText = ajaxLoadPageSynch(url,request);
	return resText;
}
</script>


