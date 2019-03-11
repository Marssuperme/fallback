<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<input type="hidden" id="dtguid" name="dtguid" value="${dt.guid}">
<input type="hidden" id="bguid" name="bguid" value="${dt.guid}">
<input type="hidden" id="addJsp" name="addJsp" value="${pageContext.request.contextPath}/common/bb.do?method=addDxzhpgTable">
<input type="hidden" id="updateJsp" name="updateJsp" value="${pageContext.request.contextPath}/common/bb.do?method=updateDxzhpgTableById">
 
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
						refer="单项资产业务类型"
						hideresult=true title="业务类型" id="ywlx" value="${dt.ywlx}" name="ywlx" size="20" class="required"></td>
    <td width="20%" height="23" class="data_tb_alignright">评估基准日<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23"><input maxlength="50" id="pgjzr" value="${dt.pgjzr}" name="pgjzr" size="20" showcalendar="true" class="required"></td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">价值类型<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23"><input onfocus="onPopDivClick(this);"
    					noinput=true
    					autoWidth=180
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=55
						autoWidth="190"
						refer="单项资产价值类型"
						hideresult=true id="jzlx" value="${dt.jzlx}" name="jzlx" size="20" class="required"></td>
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
						refer="单项资产评估目的"
						hideresult=true id="pgmd" value="${dt.pgmd}" name="pgmd" size="20" class="required"></td>
  </tr>
  <tr>
    <td width="20%" height="46" class="data_tb_alignright">评估对象<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="46"><input maxlength="50" onfocus="onPopDivClick(this);"
    					noinput=true
    					autoWidth=180
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=55
						autoWidth="190"
						refer="单项资产评估对象"
						hideresult=true id="pgdx" value="${dt.pgdx}" name="pgdx" size="20" class="required"></td>
    <td width="20%" height="46" class="data_tb_alignright">评估范围<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="46"> 
    	<input maxlength="50" onfocus="onPopDivClick(this);"
    					noinput=true
    					autoWidth=180
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=55
						autoWidth="190"
						refer="单项资产评估范围"
						hideresult=true id="pgfw" value="${dt.pgfw }" size="20" name="pgfw" class="required">
    </td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">主要评估方法<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23"><input maxlength="50" onfocus="onPopDivClick(this);"
    					noinput=true
    					autoWidth=180
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=55
						autoWidth="190"
						refer="单项资产主要评估方法"
						hideresult=true id="zypgffxz" value="${dt.zypgffxz }" name="zypgffxz" size="20" class="required"></td>
    <td width="20%" height="23" class="data_tb_alignright">次要评估方法</td>
    <td width="30%" height="23">
		<input maxlength="10" onfocus="onPopDivClick(this);"
    					noinput=true
    					autoWidth=180
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=55
						autoWidth="190"
						refer="单项资产次要评估方法"
						hideresult=true id="cypgffxz" value="${dt.cypgffxz }" size="20" name="cypgffxz"> 
	</td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">委托方以外的其它评估报告使用者</td>
    <td width="30%" height="23"><input maxlength="100" onfocus="onPopDivClick(this);"
    					noinput=true
    					autoWidth=180
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=55
						autoWidth="190"
						refer="单项资产委托方以外的其它评估报告使用者"
						hideresult=true id="otheruser" value="${dt.otheruser }" name="otheruser" size="20"></td>
    <td width="20%" height="23" class="data_tb_alignright">市场价值以外的具体价值类型</td>
    <td width="30%" height="23">
		<input id="othervalue" value="${dt.othervalue}" size="20" name="othervalue" > 
	</td>
  </tr>
  
  <tr>
		<td align="left" colspan="2">
		<fieldset style="border: 1px solid lightblue;width:100%;">
			<legend>
				账面价值
			</legend>
			<table width="100%" align="left" border="1" cellpadding="0" cellspacing="0">
					<tr>
						<td class="data_tb_alignright" align="left" >流动资产</td>
						<td  align="left">
							<input maxlength="20" class="data_tb_content number" name="zmldzc" type="text" id="zmldzc" size="15" value="${dt.zmldzc }" onkeyup="f_money(this)" onpropertychange="f_setzmzczj()">万元
						</td>
					</tr>
					
					<tr>
						<td class="data_tb_alignright" align="left" >长期投资</td>
						<td  align="left">
							<input maxlength="20" class="data_tb_content number" name="zmcqzc" type="text" id="zmcqzc" size="15" value="${dt.zmcqzc }" onkeyup="f_money(this)" onpropertychange="f_setzmzczj()">万元
						</td>
					</tr>
					
					<tr>
						<td class="data_tb_alignright" align="left" colspan="2">
						<fieldset style="border: 1px solid white;border-top: 1px solid lightblue;border-collapse:collapse;">
							<legend>
								固定资产
							</legend>
							<table width="100%" align="left" border="1" cellpadding="0" cellspacing="0" style="border:1px solid lightblue;border-collapse:collapse;">
								<tr>
									<td class="data_tb_alignright" align="left">在建工程</td>
									<td  align="left">
										<input maxlength="20" class="data_tb_content number" name="zmzjgc" type="text" id="zmzjgc" size="15" value="${dt.zmzjgc }" onkeyup="f_money(this)" onpropertychange="f_setzmgdzc()">万元
									</td>
								</tr>
								<tr>
									<td class="data_tb_alignright" align="left">建筑物</td>
									<td  align="left">
										<input maxlength="20" class="data_tb_content number" name="zmjzw" type="text" id="zmjzw" size="15" value="${dt.zmjzw }" onkeyup="f_money(this)" onpropertychange="f_setzmgdzc()">万元
									</td>
								</tr>
								<tr>
									<td class="data_tb_alignright" align="left">设备</td>
									<td  align="left">
										<input maxlength="20" class="data_tb_content" name="zmsb" type="text" id="zmsb" size="15" value="${dt.zmsb}" onkeyup="f_money(this)" onpropertychange="f_setzmgdzc()">万元
									</td>
								</tr>
								<tr>
									<td class="data_tb_alignright" align="left">固定资产</td>
									<td  align="left">
										<input maxlength="20" class="data_tb_content" name="zmgdzc" type="text" id="zmgdzc" size="15" value="${dt.zmgdzc}" readonly="readonly">万元
									</td>
								</tr>
							</table>
						</fieldset>
						</td>
					</tr>
					
					
					<tr>
						<td class="data_tb_alignright" align="left" colspan="2">
							<fieldset style="border: 1px solid white;border-top: 1px solid lightblue;border-collapse:collapse;">
								<legend>
									无形资产
								</legend>
								<table width="100%" align="left" border="1" cellpadding="0" cellspacing="0" style="border:1px solid lightblue;border-collapse:collapse;">
								<tr>
									<td class="data_tb_alignright" align="left">土地使用权</td>
									<td  align="left">
										<input maxlength="20" class="data_tb_content number" name="zmtdsyq" type="text" id="zmtdsyq" size="15" value="${dt.zmtdsyq }" onkeyup="f_money(this)" >万元
									</td>
								</tr>
								<tr>
									<td class="data_tb_alignright" align="left">无形资产</td>
									<td  align="left">
										<input maxlength="20" class="data_tb_content" name="zmwxzc" type="text" id="zmwxzc" size="15" value="${dt.zmwxzc}" onkeyup="f_money(this)" onpropertychange="f_setzmzczj()">万元
									</td>
								</tr>
							</table>
							</fieldset>
						</td>
					</tr>
					
					<tr>
						<td class="data_tb_alignright" align="left" >其它资产</td>
						<td  align="left">
							<input maxlength="20" class="data_tb_content" name="zmqtzc" type="text" id="zmqtzc" size="15" value="${dt.zmqtzc}" onkeyup="f_money(this)" onpropertychange="f_setzmzczj()">万元
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" align="left" >资产总计</td>
						<td  align="left">
							<input maxlength="20" class="data_tb_content" name="zmzczj" type="text" readonly="readonly" id="zmzczj" size="15" value="${dt.zmzczj}">万元
						</td>
					</tr>
			</table>
		</fieldset>
		</td>
		
		
		<td align="left" colspan="2">
			<fieldset style="border: 1px solid lightblue;width:100%;height: 100%">
				<legend>
					评估价值
				</legend>
				<table width="100%" align="left" border="1" cellpadding="0" cellspacing="0">
					<tr>
						<td class="data_tb_alignright" align="left" >流动资产</td>
						<td  align="left">
							<input maxlength="20" class="data_tb_content number" name="pgldzc" type="text" id="pgldzc" size="15" value="${dt.pgldzc }" onkeyup="f_money(this)" onpropertychange="f_setpgzczj()">万元
						</td>
					</tr>
					
					<tr>
						<td class="data_tb_alignright" align="left" >长期投资</td>
						<td  align="left">
							<input maxlength="20" class="data_tb_content number" name="pgcqzc" type="text" id="pgcqzc" size="15" value="${dt.pgcqzc }" onkeyup="f_money(this)" onpropertychange="f_setpgzczj()">万元
						</td>
					</tr>
					
					<tr>
						<td class="data_tb_alignright" align="left" colspan="2">
						<fieldset style="border: 1px solid white;border-top: 1px solid lightblue;border-collapse:collapse;">
							<legend>
								固定资产
							</legend>
							<table width="100%" align="left" border="1" cellpadding="0" cellspacing="0" style="border:1px solid lightblue;border-collapse:collapse;">
								<tr>
									<td class="data_tb_alignright" align="left">在建工程</td>
									<td  align="left">
										<input maxlength="20" class="data_tb_content number" name="pgzjgc" type="text" id="pgzjgc" size="15" value="${dt.pgzjgc }" onkeyup="f_money(this)" onpropertychange="f_setpggdzc()">万元
									</td>
								</tr>
								<tr>
									<td class="data_tb_alignright" align="left">建筑物</td>
									<td  align="left">
										<input maxlength="20" class="data_tb_content number" name="pgjzw" type="text" id="pgjzw" size="15" value="${dt.pgjzw }" onkeyup="f_money(this)" onpropertychange="f_setpggdzc()">万元
									</td>
								</tr>
								<tr>
									<td class="data_tb_alignright" align="left">设备</td>
									<td  align="left">
										<input maxlength="20" class="data_tb_content" name="pgsb" type="text" id="pgsb" size="15" value="${dt.pgsb}" onkeyup="f_money(this)" onpropertychange="f_setpggdzc()">万元
									</td>
								</tr>
								<tr>
									<td class="data_tb_alignright" align="left">固定资产</td>
									<td  align="left">
										<input maxlength="20" class="data_tb_content" name="pggdzc" type="text" id="pggdzc" size="15" value="${dt.pggdzc}" readonly="readonly">万元
									</td>
								</tr>
							</table>
						</fieldset>
						</td>
					</tr>
					
					
					<tr>
						<td class="data_tb_alignright" align="left" colspan="2">
							<fieldset style="border: 1px solid white;border-top: 1px solid lightblue;border-collapse:collapse;">
								<legend>
									无形资产
								</legend>
								<table width="100%" align="left" border="1" cellpadding="0" cellspacing="0" style="border:1px solid lightblue;border-collapse:collapse;">
								<tr>
									<td class="data_tb_alignright" align="left">土地使用权</td>
									<td  align="left">
										<input maxlength="20" class="data_tb_content number" name="pgtdsyq" type="text" id="pgtdsyq" size="15" value="${dt.pgtdsyq }" onkeyup="f_money(this)" >万元
									</td>
								</tr>
								<tr>
									<td class="data_tb_alignright" align="left">无形资产</td>
									<td  align="left">
										<input maxlength="20" class="data_tb_content" name="pgwxzc" type="text" id="pgwxzc" size="15" value="${dt.pgwxzc}" onkeyup="f_money(this)" onpropertychange="f_setpgzczj()">万元
									</td>
								</tr>
							</table>
							</fieldset>
						</td>
					</tr>
					
					<tr>
						<td class="data_tb_alignright" align="left" >其它资产</td>
						<td  align="left">
							<input maxlength="20" class="data_tb_content" name="pgqtzc" type="text" id="pgqtzc" size="15" value="${dt.pgqtzc}" onkeyup="f_money(this)" onpropertychange="f_setpgzczj()">万元
						</td>
					</tr>
					<tr>
						<td class="data_tb_alignright" align="left" >资产总计</td>
						<td  align="left">
							<input maxlength="20" class="data_tb_content" name="pgzczj" type="text" readonly="readonly" id="pgzczj" size="15" value="${dt.pgzczj}">万元
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

// 账面价值--固定资产
function f_setzmgdzc(){
	var zmzjgc = document.getElementById("zmzjgc").value;//在建工程
	var zmjzw = document.getElementById("zmjzw").value;//建筑物
	var zmsb = document.getElementById("zmsb").value;//设备
	document.getElementById("zmgdzc").value = zmzjgc*1 + zmjzw*1 + zmsb*1;
	 
	// 账面价值--资产总计
	f_setzmzczj();
}


// 账面价值--资产总计
function f_setzmzczj(){
	var zmldzc = document.getElementById("zmldzc").value;//流动资产
	var zmcqzc = document.getElementById("zmcqzc").value;//长期投资
	var zmgdzc = document.getElementById("zmgdzc").value;//固定资产
	var zmwxzc = document.getElementById("zmwxzc").value;//无形资产
	var zmqtzc = document.getElementById("zmqtzc").value;//其它资产
	
	document.getElementById("zmzczj").value = zmldzc*1 + zmcqzc*1 + zmgdzc*1 + zmwxzc*1 + zmqtzc*1 ;//资产总计
}


// 评估价值--固定资产
function f_setpggdzc(){
	var pgzjgc = document.getElementById("pgzjgc").value;//在建工程
	var pgjzw = document.getElementById("pgjzw").value;//建筑物
	var pgsb = document.getElementById("pgsb").value;//设备
	document.getElementById("pggdzc").value = pgzjgc*1 + pgjzw*1 + pgsb*1;
	 
	// 评估价值--资产总计
	f_setpgzczj();
}

// 评估价值--资产总计
function f_setpgzczj(){
	var pgldzc = document.getElementById("pgldzc").value;//流动资产
	var pgcqzc = document.getElementById("pgcqzc").value;//长期投资
	var pggdzc = document.getElementById("pggdzc").value;//固定资产
	var pgwxzc = document.getElementById("pgwxzc").value;//无形资产
	var pgqtzc = document.getElementById("pgqtzc").value;//其它资产
	
	document.getElementById("pgzczj").value = pgldzc*1 + pgcqzc*1 + pggdzc*1 + pgwxzc*1 + pgqtzc*1 ;//资产总计
}

//计算收费标准
function getChargeStandard(){
	var type = "评估计件";
	var zmzczj = document.getElementById("zmzczj").value*1;
	var pgzczj = document.getElementById("pgzczj").value*1;
	if((zmzczj+pgzczj)==0){
		setTab('search','nre');
		document.getElementById("zmzczj").select();
		alert("帐面资产总计与评估资产总计之和必须大于0!");
		return "N";
	}
	var zcze = zmzczj!=0 ? zmzczj : pgzczj;
	var url="${pageContext.request.contextPath}/common/content.do?method=getChargeStandard";
	var request = "&type="+type+"&zcze="+zcze+"&kind=2&year=0&hour=0";
	var resText = ajaxLoadPageSynch(url,request);
	return resText;
}

</script>