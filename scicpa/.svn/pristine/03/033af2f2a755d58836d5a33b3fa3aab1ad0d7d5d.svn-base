<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<input type="hidden" id="whnjguid" name="whnjguid" value="${wt.guid}">
<input type="hidden" id="bguid" name="bguid" value="${wt.guid}">
<input type="hidden" id="addJsp" name="addJsp" value="${pageContext.request.contextPath}/common/bb.do?method=addWhnjTable">
<input type="hidden" id="updateJsp" name="updateJsp" value="${pageContext.request.contextPath}/common/bb.do?method=updateWhnjTableById">

<table border="1" cellpadding="0" style="padding-left: 2px" cellspacing="0" width="100%" height="20%">
  <tr>
    <td class="data_tb_alignright" style="text-align: left;" width="597" colspan="4" height="16">外汇年检信息</td>
  </tr>
  <tr>
    <td width="15%" height="16" class="data_tb_alignright">外汇登记证号<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="35%" height="16"><input maxlength="50" title="外汇登记证号" id="whdjzh" value="${wt.whdjzh}" name="whdjzh" size="20" class="required"></td>
    <td width="15%" height="16" class="data_tb_alignright">币种<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="35%" height="16"><input maxlength="50" onfocus="onPopDivClick(this);"
    					autoWidth=170
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=5
						hideresult=true id="bz" title="币种" value="${wt.bz}" name="bz" size="15" class="required"></td>
  </tr>
  <tr>
    <td width="15%" height="16" class="data_tb_alignright">外汇收入总计</td>
    <td width="35%" height="16"><input maxlength="20" id="whsrzj" value="${wt.whsrzj}" name="whsrzj" size="20" class="number" onkeyup="f_money(this);" >万元</td>
    <td width="15%" height="16" class="data_tb_alignright">处汇支出总计</td>
    <td width="35%" height="16"><input maxlength="20" id="whzczj" value="${wt.whzczj}" name="whzczj" size="15" class="number" onkeyup="f_money(this);" >万元</td>
  </tr>
  <tr>
    <td width="15%" height="16" class="data_tb_alignright">经常项目差额</td>
    <td width="35%" height="16"><input maxlength="20" id="jcxmce" value="${wt.jcxmce}" name="jcxmce" size="20" class="number" onkeyup="f_money(this);" >万元</td>
    <td width="15%" height="16" class="data_tb_alignright">其它资产</td>
    <td width="35%" height="16"> 
    	<input maxlength="20" id="qtzc" value="${wt.qtzc }" size="15" name="qtzc" class="number" onkeyup="f_money(this);" >万元
    </td>
  </tr>
  <tr>
    <td width="15%" height="16" class="data_tb_alignright">外汇货币资金</td>
    <td width="35%" height="16"><input maxlength="20" id="whhbjj" value="${wt.whhbjj }" name="whhbjj" size="20" class="number" onkeyup="f_money(this);" >万元</td>
    <td width="15%" height="16" class="data_tb_alignright">资产合计<br><font color="red">(保留小数点后四位以上，不作四舍五入)</font></td>
    <td width="35%" height="16">
		<input maxlength="20" id="jchj" value="${wt.jchj }" size="15" name="jchj" class="number" onkeyup="f_money(this);" >万元
	</td>
  </tr>
  <tr>
    <td width="15%" height="16" class="data_tb_alignright">实收境外资本</td>
    <td width="35%" height="16"><input maxlength="20" id="ssjwjb" value="${wt.ssjwjb }" name="ssjwjb" size="20" class="number" onkeyup="f_money(this);" >万元</td>
    <td width="15%" height="16" class="data_tb_alignright">实收境内外汇资本</td>
    <td width="35%" height="16">
		<input maxlength="20" id="ssjlwhjb" value="${wt.ssjlwhjb }" size="15" name="ssjlwhjb" class="number" onkeyup="f_money(this);" > 万元
	</td>
  </tr>
  <tr>
    <td width="15%" height="16" class="data_tb_alignright">境外借款</td>
    <td width="35%" height="16"><input maxlength="20" id="jwjk" value="${wt.jwjk }" name="jwjk" size="20" class="number">万元</td>
    <td width="15%" height="16" class="data_tb_alignright">项目组人数</td>
    <td width="35%" height="16"><input maxlength="10" id="xmzrs" value="${wt.xmzrs }" name="xmzrs" size="15" class="number"></td>
  </tr>
  <tr>
    <td width="15%" height="16" class="data_tb_alignright">外勤工作天数</td>
    <td width="35%" height="16"><input maxlength="10" id="wqgzts" value="${wt.wqgzts }" name="wqgzts" size="20" class="number"></td>
    <td width="15%" height="16" class="data_tb_alignright">报表年度</td>
    <td width="35%" height="16" >
	    <input maxlength="50" id="bgnd" name="bgnd" value="${ct.bgnd}" size="20" title="报表年度" onkeyup="getProjectName();" onchange="getProjectName();">
	    <font color="red">(会显示在报备封面上)</font>
    </td>
  </tr>
</table>

<script type="text/javascript">

// 默认为否
var sftzje = "${wt.sftzje}";
if(sftzje == ""){
	document.getElementById("sftzje").value = "否";
	document.getElementById("tb_tzh_money").style.display = "none";
}else{
	f_display_tzh_money();
}

// 验证应收业务费金额
function f_checkMoney(isCount,wjjsfbz){
	// 广州、珠海、佛山、东莞、中山、江门、深圳
	var area = "${userSession.userMap.area}";
	var ywarea = document.getElementById("ywarea").value;
	
	// 物价局收费标准：直接提示标准价
	if(wjjsfbz=="wjjsfbz"){
		return "物价局收费标准价为：1000 元!";
	}else{
		var ysywf = document.getElementById("ysywf").value;
		if(ysywf==""){
			if(isCount!="Y"){
				var bbState = "${ct.bbstate}";
				if(bbState!="审核通过" && wjjsfbz!="wjjsfbz"){
					setTab('search','nry');
					alert("应收业务费不能小于1000元！");
					document.getElementById("ysywf").focus();
				}
			}
			return "应收业务费不能小于1000元。";
		}else{ 
			// 数据库 7 折价
			document.getElementById("discountBySeven").value = 1000;
			// 标准金额
			document.getElementById("standerPrice").value = 1000;
			
			if(ysywf*1<1000){
				if(isCount!="Y"){
					var bbState = "${ct.bbstate}";
					if(bbState!="审核通过" && wjjsfbz!="wjjsfbz"){
						setTab('search','nry');
						alert("应收业务费不能小于1000元！如果您确定要以本收费金额进行报备，请到【应收业务费】勾选【需提交审核情况】并填写【情况说明】，注协审核通过后继续进行报备。");
						document.getElementById("ysywf").select();
					}
				}
				return "应收业务费不能小于1000元。";
			}
			return "ok";
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
		var zczetzh = document.getElementById("zczetzh").value*1;
		if(zczetzh<=0){
			setTab('search','nre');
			document.getElementById("zczetzh").select();
			alert("调整后资产总额必须大于0！");
			return "notAlert";
		}
	}
	return "OK";
}

</script>
	