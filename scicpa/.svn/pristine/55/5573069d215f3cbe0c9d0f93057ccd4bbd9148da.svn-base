<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<input type="hidden" id="yzbguid" name="yzbguid" value="${yt.guid}">
<input type="hidden" id="bguid" name="bguid" value="${yt.guid}">
<input type="hidden" id="addJsp" name="addJsp" value="${pageContext.request.contextPath}/common/bb.do?method=addYzbTable">
<input type="hidden" id="updateJsp" name="updateJsp" value="${pageContext.request.contextPath}/common/bb.do?method=updateYzbTableById">

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="data_tb" align="center">
 	<tr>
		<td class="data_tb_alignright" colspan="6" style="text-align: left;">
		验资币种<font color="#FF0000">&nbsp;[*]</font><input maxlength="50" onfocus="onPopDivClick(this);"
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						onchange="changeBZ(this);"
						norestorehint=true
						autoid=5
						autoWidth="190"
						hideresult=true id="yzbz" name="yzbz" value="${yt.yzbz }" size="10" class="required" >
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		汇率<font color="#FF0000">&nbsp;[*]</font>
		<input maxlength="50" id="yzhl" name="yzhl" value="${yt.yzhl}" size="10" class="required" onkeyup="f_money(this);f_money2(this);f_hl();" onblur="f_money3(this);">&nbsp;
		<font color="red">(请自行填写注资当天汇率)</font>
		</td>
	</tr>

	<tr>
		<td rowspan="7" align="left" colspan="3">
		<fieldset style="border: 1px solid lightblue;width:100%;">
			<legend>
				本次验资金额
			</legend>
			<!-- <font color="red" >(必须填写货币或实物或使用土地权或其他无形资产或其他的其中一个,金额保留小数点后四位以上，不作四舍五入)</font> -->
			<table width="100%" align="left" border="1" cellpadding="0" cellspacing="0">
					<tr>
						<td class="data_tb_alignright" align="left" colspan="2">货币</td>
						<td  align="left">
							<input maxlength="20" class="data_tb_content number" name="yzbzje" type="text" id="yzbzje" size="15" value="${yt.yzbzje }" onkeyup="f_money(this);f_yztotal()" >万元
						</td>
					</tr>
					
					<tr>
						<td class="data_tb_alignright" align="left" colspan="2">实物</td>
						<td  align="left">
							<input maxlength="20" class="data_tb_content number" name="yzswje" type="text" id="yzswje" size="15" value="${yt.yzswje }" onkeyup="f_money(this);f_yztotal()">万元
						</td>
					</tr>
					
					<tr>
						<td colspan="3" class="data_tb_alignright" align="left">
						<fieldset style="border: 1px solid lightblue">
							<legend>
								无形资产金额
							</legend>
							<table align="left" width="100%">
								<tr>
									<td class="data_tb_alignright" align="left">土地使用权</td>
									<td  align="left">
										<input maxlength="20" class="data_tb_content number" name="yztdsyje" type="text" id="yztdsyje" size="15" value="${yt.yztdsyje }" onkeyup="f_money(this);f_yztotal()">万元
									</td>
								</tr>
								
								<tr>
									<td class="data_tb_alignright" align="left">其他无形资产</td>
									<td  align="left">
										<input maxlength="20" class="data_tb_content number" name="yzqtwszcje" type="text" id="yzqtwszcje" size="15" value="${yt.yzqtwszcje }" onkeyup="f_money(this);f_yztotal()">万元
									</td>
								</tr>
								
								<tr>
									<td class="data_tb_alignright" align="left">无形资产总金额</td>
									<td  align="left">
										<input maxlength="20" class="data_tb_content" name="wxzczje" readonly="readonly" type="text" id="wxzczje" size="15" value="${yt.yztdsyje+yt.yzqtwszcje }">万元
									</td>
								</tr>
							</table>
						</fieldset>
						</td>
					</tr>
					
					
					<tr>
						<td class="data_tb_alignright" align="left" colspan="2">其他</td>
						<td  align="left">
							<input maxlength="20" class="data_tb_content number" name="yzqtje" type="text" id="yzqtje" size="15" value="${yt.yzqtje }" onkeyup="f_money(this);f_yztotal()">万元
						</td>
					</tr>
					
					<tr>
						<td class="data_tb_alignright" align="left" colspan="2">验资总金额</td>
						<td  align="left">
							<input maxlength="20" class="data_tb_content" name="yzzjes" type="text" readonly="readonly" id="yzzjes" size="15" value="${yt.yzbzje+yt.yzswje+yt.yztdsyje+yt.yzqtwszcje+yt.yzqtje}">万元
						</td>
					</tr>
					<tr id="yzzje_RMB" style="display:none;">
						<td class="data_tb_alignright" align="left" colspan="2"><font color="#FF0000">验资总金额(人民币)</font></td>
						<td  align="left">
							<input maxlength="20" class="data_tb_content" name="yzzjermb" type="text" readonly="readonly" id="yzzjermb" size="15" value="">万元
						</td>	
					</tr>
			</table>
			<script type="text/javascript">
				var yzbz = document.getElementById("yzbz").value;
				if(yzbz!="" && yzbz!="人民币"){
					document.getElementById("yzzje_RMB").style.display="";
				}
				
				var total = "${yt.yzbzje+yt.yzswje+yt.yztdsyje+yt.yzqtwszcje+yt.yzqtje}";
				var hl = "${yt.yzhl}";
				hl = hl=="" ? 1 : hl*1;
				document.getElementById("yzzjermb").value=(total*hl).toFixed(4);
			</script>
		</fieldset>
		</td>
		
		
		<td rowspan="7" align="left" colspan="3">
			<fieldset style="border: 1px solid lightblue;width:100%;height: 100%">
				<legend>
					其中：本期验证外方出资金额
				</legend>
				<table width="100%" align="left" cellpadding="0" cellspacing="0" height="220">
						<tr>
							<td class="data_tb_alignright" align="left" >现汇</td>
							<td  align="left" >
								<input maxlength="20" class="data_tb_content number" name="bqyzwfczxhje" type="text" id="bqyzwfczxhje" size="12" value="${yt.bqyzwfczxhje }" onkeyup="f_money(this);f_wfcztotal()">万元
							</td>
						</tr>
						
						<tr>
							<td class="data_tb_alignright" align="left" >实物</td>
							<td  align="left">
								<input maxlength="20" class="data_tb_content number" name="bqyzwfczswje" type="text" id="bqyzwfczswje" size="12" value="${yt.bqyzwfczswje }" onkeyup="f_money(this);f_wfcztotal()">万元
							</td>
						</tr>
						
						<tr>
							<td class="data_tb_alignright" align="left">利润转投资</td>
							<td  align="left">
								<input maxlength="20" class="data_tb_content number" name="bqyzwfczlyztzje" type="text" id="bqyzwfczlyztzje" size="12" value="${yt.bqyzwfczlyztzje }" onkeyup="f_money(this);f_wfcztotal()">万元
							</td>
						</tr>
						
						<tr>
							<td class="data_tb_alignright" align="left">无形资产</td>
							<td  align="left">
								<input maxlength="20" class="data_tb_content number" name="bqyzwfczwxzcje" type="text" id="bqyzwfczwxzcje" size="12" value="${yt.bqyzwfczwxzcje }" onkeyup="f_money(this);f_wfcztotal()">万元 
							</td>
						</tr>
						
						<tr>
							<td class="data_tb_alignright" align="left">其他</td>
							<td  align="left">
								<input maxlength="20" class="data_tb_content number" name="bqyzwfczqtje" type="bqyzwfczqtje" id="" size="12" value="${yt.bqyzwfczqtje }" onkeyup="f_money(this);f_wfcztotal()">万元 
							</td>
						</tr>
						
						<tr>
							<td class="data_tb_alignright" align="left">本期验证外方出资金额出资总金额</td>
							<td  align="left">
								<input maxlength="20" class="data_tb_content" name="wfcztotal" readonly="readonly" type="text" id="wfcztotal" size="12" value="${yt.bqyzwfczxhje+yt.bqyzwfczswje+yt.bqyzwfczlyztzje+yt.bqyzwfczwxzcje+yt.bqyzwfczqtje }">万元 
							</td>
						</tr>
				</table>
			</fieldset>
		</td>
	</tr>
	
</table>

<table width="100%" cellpadding="0" cellspacing="0" class="data_tb" align="center">
 	<tr>
	    <td class="data_tb_alignright" colspan="2">验资种类<font color="#FF0000">&nbsp;[*]</font></td>
	    <td align="left">
			<input maxlength="50" onfocus="onPopDivClick(this);"
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=6
						autoWidth="190"
						noinput=true
						hideresult=true id="yzzl" value="${yt.yzzl }" size="12" name="yzzl" class="required">
		</td>
	    <td class="data_tb_alignright" colspan="2">验资截止日<font color="#FF0000">&nbsp;[*]</font></td>
	    <td align="left"><input maxlength="50" id="yzjzr" class="required"  value="${yt.yzjzr}" name="yzjzr" size="8" showcalendar="true"></td>
	    <td class="data_tb_alignright" colspan="2">股东1</td>
	    <td align="left"><input maxlength="50" id="gd1" class="data_tb_content"  value="${yt.gd1}" name="gd1" size="12"></td>
    </tr>
    <tr>
	    <td class="data_tb_alignright" colspan="2">增资</td>
	    <td align="left">
			<input maxlength="20" id="zj" class="data_tb_content number" value="${yt.zj}" name="zj" size="12" onkeyup="f_money(this);" >万元
		</td>
	    <td class="data_tb_alignright" colspan="2">股东2</td>
	    <td align="left"><input maxlength="50" id="gd2" class="data_tb_content" value="${yt.gd2}" name="gd2" size="12"></td>
	    <td class="data_tb_alignright" colspan="2">股东3</td>
	    <td align="left"><input maxlength="50" id="gd3" class="data_tb_content" value="${yt.gd3}" name="gd3" size="12"></td>
    </tr>
    <tr>
	    <td class="data_tb_alignright" colspan="2">股份转让</td>
	    <td align="left">
			<input maxlength="20" id="gfzy" class="data_tb_content number" value="${yt.gfzy}" name="gfzy" size="12" onkeyup="f_money(this);" >万元
		</td>
	    <td class="data_tb_alignright" colspan="2">股东4</td>
	    <td align="left"><input maxlength="50" id="gd4" class="data_tb_content" value="${yt.gd4}" name="gd4" size="12"></td>
	    <td class="data_tb_alignright" colspan="2">其他股东</td>
	    <td align="left"><input maxlength="50" id="qtgd" class="data_tb_content" value="${yt.qtgd}" name="qtgd" size="12"></td>
    </tr>
    
   
    <tr> 
	    <td class="data_tb_alignright" colspan="2">减资</td>
	    <td align="left">
	    	<input maxlength="20" class="data_tb_content number" id="jz" value="${yt.jz}" name="jz" size="12" onkeyup="f_money(this);" >万元
	    </td>
	    <td class="data_tb_alignright" ><!--验资期间--></td>
	    <td align="left" colspan="5">
	    	<input type="hidden" maxlength="50" id="bgnd" name="bgnd" value="${ct.bgnd}" size="12" title="验资区间" onkeyup="getProjectName();" onchange="getProjectName();">
			<!--<font color="red">(会显示在报备封面上)</font>-->
	    </td>
    </tr>
    
    <%-- <tr> 
	    <td class="data_tb_alignright" colspan="2">报告意见类型</td>
	    <td align="left" colspan="7">
	    	<input maxlength="100" onfocus="onPopDivClick(this);"
    					autoWidth=300
    					autoHeight=280
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=7
						noinput=true
						hideresult=true id="sjbgyjlx" value="${yt.sjbgyjlx} " title="审计报告意见类型" style="width: 95%" name="sjbgyjlx" > 
		</td>
    </tr>
    
     <tr> 
	    <td class="data_tb_alignright" colspan="2">保留意见内容</td>
	    <td align="left" colspan="7">
	    	<textarea style="width: 95%;height: 50px;"  id="blyjlx" name="blyjlx" >${yt.blyjlx}</textarea>
	    </td>
    </tr>
    <tr> 
	    <td class="data_tb_alignright" colspan="2">无保留意见强调事项</td>
	    <td align="left" colspan="7">
	    	<textarea style="width: 95%;height: 50px;" id="notblyjlx" name="notblyjlx" >${yt.notblyjlx}</textarea>
	    </td>
    </tr> --%>
    
    
</table>
<script>

// 汇率 默认是 1
var yzhl = "${yt.yzhl}";
if(yzhl==""){
	document.getElementById("yzhl").value = "1";
}
   
// 求验资总金额
function f_yztotal(){
	// 货币 yzbzje    实物 yzswje 使用土地权 yztdsyje  其他无形资产 yzqtwszcje  
	// 无形资产总金额 wxzczje    其他  yzqtje   验资总金额 yzzjes
	var hbs = document.getElementById("yzbzje").value;
	var sws = document.getElementById("yzswje").value;
	var sytdqs = document.getElementById("yztdsyje").value;
	var qtwxzcs = document.getElementById("yzqtwszcje").value;
	var qts = document.getElementById("yzqtje").value;
	var total1 = sytdqs*1+qtwxzcs*1;
	f_setMoney(total1,"wxzczje");
	var total2 = hbs*1+sws*1+sytdqs*1+qtwxzcs*1+qts*1;
	f_setMoney(total2,"yzzjes");
	
	var yzhl = document.getElementById("yzhl").value;
	var total3 = (total2*yzhl).toFixed(4);
	f_setMoney(total3,"yzzjermb");
}

// 设置金额
function f_setMoney(money,objId){
	if(!isNaN(money) && document.getElementById(objId)){
		document.getElementById(objId).value=money;
		if(money<0){
			document.getElementById(objId).style.color = "red";
		}else{
			document.getElementById(objId).style.color = "black";
		}
	}
}

// 求外方出资总金额
function f_wfcztotal(){
	// 现汇 bqyzwfczxhje   实物 bqyzwfczswje   利润转投资 bqyzwfczlyztzje   无形资产 bqyzwfczwxzcje
	// 其他 bqyzwfczqtje   本期验证外方出资金额出资总金额  wfcztotal
	var xhs = document.getElementById("bqyzwfczxhje").value;
	var shs = document.getElementById("bqyzwfczswje").value;
	var lrs = document.getElementById("bqyzwfczlyztzje").value;
	var zcs = document.getElementById("bqyzwfczwxzcje").value;
	var qts = document.getElementById("bqyzwfczqtje").value;
	var total = xhs*1+shs*1+lrs*1+zcs*1+qts*1;
	if(!isNaN(total)){
		document.getElementById("wfcztotal").value=total;
		if(total<0){
			document.getElementById("wfcztotal").style.color = "red";
		}else{
			document.getElementById("wfcztotal").style.color = "black";
		}
	}
	
}

// 验证应收业务费金额
function f_checkMoney(isCount,wjjsfbz){
	
	// 验证总金额
	var yzzjes = document.getElementById("yzzjes").value;
	yzzjes = yzzjes==""?0:yzzjes*1;
	
	if(yzhl.indexOf("%")>-1){
		yzhl = yzhl.replace("%","");
	}
	
	// 金额
	var ysywfCount = yzzjes*yzhl;
	
	if(yzzjes<=0){
		var bbState = "${ct.bbstate}";
		if(bbState!="审核通过"){
			setTab('search','nre');
			alert("验资总金额必须大于 0 ！");
			document.getElementById("yzzjes").select();
			return "notAlert";
		}else{

			if(wjjsfbz=="wjjsfbz"){
				var moneyArray = f_checkMoneyStandard_YZ(ysywfCount,"yz001",wjjsfbz);
				var standerMoney = moneyArray[1]*1;
				return "发改委、财政厅收费标准价为："+standerMoney.toFixed(2)+" 元!";
			}
		}
	}else{
		return f_countMoney(isCount,wjjsfbz);
	}
}

// 计算业务业务费标准
function f_countMoney(isCount,wjjsfbz){
	
	// 验证总金额
	var yzzjes = document.getElementById("yzzjes").value;
	yzzjes = yzzjes==""?0:yzzjes*1;
	
	// 货币 
	var yzbzje = document.getElementById("yzbzje").value;
	yzbzje = yzbzje==""?0:yzbzje*1;
	
	// 实物 
	var yzswje = document.getElementById("yzswje").value;
	yzswje = yzswje==""?0:yzswje*1;
	
	// 无形资产总金额
	var wxzczje = document.getElementById("wxzczje").value;
	wxzczje = wxzczje==""?0:wxzczje*1;
	
	// 其他 
	var yzqtje = document.getElementById("yzqtje").value;
	yzqtje = yzqtje==""?0:yzqtje*1;
	
	// 汇率
	var yzhl = document.getElementById("yzhl").value;
	if(yzhl.indexOf("%")>-1){
		yzhl = yzhl.replace("%","");
	}
	yzhl = yzhl==""?1:yzhl*1;
	
	// 金额
	var ysywfCount = yzzjes*yzhl;
	
	var typeId = "yz001";
	// 非纯货币：验资总金额>币种
	if(yzzjes>yzbzje){
		typeId = "yz002";
	}
	
	// 广州、珠海、佛山、东莞、中山、江门、深圳
	var area = "${userSession.userMap.area}";
	var ywarea = document.getElementById("ywarea").value;
	
	// 物价局收费标准：直接提示标准价
	if(wjjsfbz=="wjjsfbz"){
		var moneyArray = f_checkMoneyStandard_YZ(ysywfCount,typeId,wjjsfbz);
		var standerMoney = moneyArray[1]*1;
		return "发改委、财政厅收费标准价为："+standerMoney.toFixed(2)+" 元!";
	}else{
		return f_returnInfo(ysywfCount,typeId,isCount);
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

//验证汇率要大于0
function f_money2(t){
	var v = t.value;
	//不能输入"-"负数
	if(v.indexOf("-")>-1){
		t.value=t.value.replace("-","");
	}
}

//验证汇率要大于0
function f_money3(t){
	//汇率值	
	var hl = t.value;
	if(hl*1<=0){
		t.value="";
		t.select();
		alert("验资汇率要大于0!");
		return;
	}
}

function changeBZ(o){
	var v = o.value;
	if(v=="人民币"){
		document.getElementById("yzzje_RMB").style.display="none";
	}else{
		document.getElementById("yzzje_RMB").style.display="";
	}
}

function f_hl(){
	f_yztotal();
}

//计算收费标准
function getChargeStandard(){
	var yzbz = document.getElementById("yzbz").value;
	if(yzbz == ""){
		setTab('search','nre');
		document.getElementById("yzbz").select();
		return "N";
	}
	//var type = document.getElementById("yzzl").value;
	var type = "验资";
	if(type == ""){
		setTab('search','nre');
		document.getElementById("yzzl").select();
		return "N";
	}
	
	var yzzjes = document.getElementById("yzzjes").value*1;
	if(yzzjes==0){
		setTab('search','nre');
		document.getElementById("yzzjes").select();
		alert("验资总金额必须大于0!");
		return "N";
	}
	if(yzzjes>99999999){
		setTab('search','nre');
		document.getElementById("yzzjes").select();
		alert("验资总金额的单位为万元,金额不能大于99999999万!");
		return "N";
	}
	var yzhl = document.getElementById("yzhl").value*1;//汇率
	var zcze = yzzjes * yzhl ;
	var url="${pageContext.request.contextPath}/common/content.do?method=getChargeStandard";
	var request = "&type="+type+"&zcze="+zcze+"&kind=1&year=0&hour=0";
	var resText = ajaxLoadPageSynch(url,request);
	return resText;
}
</script>
