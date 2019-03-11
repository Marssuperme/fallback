<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<style>
	.displays{
		display: none;
	}
</style>
<input type="hidden" id="qsshbguid" name="qsshbguid" value="${qt.guid}">
<input type="hidden" id="bguid" name="bguid" value="${qt.guid}">
<input type="hidden" id="addJsp" name="addJsp" value="${pageContext.request.contextPath}/common/bb.do?method=addQsshbTable">
<input type="hidden" id="updateJsp" name="updateJsp" value="${pageContext.request.contextPath}/common/bb.do?method=updateQsshbTableById">

<table border="1" cellpadding="0" cellspacing="0" style="padding-left: 2px;" width="100%" height="20%">
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">清算类型<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="16"><input maxlength="50" onfocus="onPopDivClick(this);"
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=9
						noinput=true
						autoWidth=190
						hideresult=true id="qslx" value="${qt.qslx}" name="qslx" size="20" class="required" onkeyup="f_money(this);" ></td>
    <td width="20%" height="16" class="data_tb_alignright">清算净损益</td>
    <td width="30%" height="16"><input maxlength="20" id="qsjsy" value="${qt.qsjsy}" name="qsjsy" size="20" class="number" onkeyup="f_money(this);" >万元</td>
  </tr>
  
  <!-- 
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">资产总额<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23"><input maxlength="20" id="zcze" value="${qt.zcze }" name="zcze" size="20" class="required number" onkeyup="f_money(this);" >万元</td>
   	<td width="20%" height="23" class="data_tb_alignright">销售收入<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23"><input maxlength="20" id="xssr" value="${qt.xssr }" name="xssr" size="20" class="required number" onkeyup="f_money(this);" >万元</td>
  </tr>
   -->
   
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">清算所得</td>
    <td width="30%" height="16"><input maxlength="20" id="qssd" value="${qt.qssd}" name="qssd" size="20" class="number" onkeyup="f_money(this);" >万元</td>
    <td width="20%" height="16" class="data_tb_alignright">应纳税所得额</td>
    <td width="30%" height="16"><input maxlength="20" id="ylssde" value="${qt.ylssde}" name="ylssde" size="20" class="number" onkeyup="f_money(this);" >万元</td>
  </tr>
  
   <tr>
    <td width="20%" height="16" class="data_tb_alignright">应纳所得税额</td>
    <td width="30%" height="16"><input maxlength="20" id="ylsde" value="${qt.ylsde}" name="ylsde" size="20" class="number" onkeyup="f_money(this);" >万元</td>
    <td width="20%" height="16" class="data_tb_alignright">报告意见类型<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="16"><input maxlength="200" onfocus="onPopDivClick(this);"
    					autoWidth=180
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=7
						noinput=true
						refer=0
						hideresult=true id="bgyjlx" value="${qt.bgyjlx}" name="bgyjlx" size="20" class="required"></td>
  </tr>
 
  <!-- 
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">从业人员<font color="#FF0000">&nbsp;[*]</font></td>
    <td height="23" colspan="3">
    	<input maxlength="20" id="cyry" value="${qt.cyry }" name="cyry" title="从业人员" size="20" class="required number" onkeyup="f_number(this);f_checkZero(this);" >人
    </td>
  </tr>
   -->
   
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">审计年数<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23" >
    	<input maxlength="20" id="sjns" value="${qt.sjns }" name="sjns" size="20" class="required" 
    			onfocus="onPopDivClick(this);"
				onkeydown="onKeyDownEvent();"
				onkeyup="onKeyUpEvent();"
				onclick="onPopDivClick(this);"
				noinput="true"
				autoWidth="130"
				refer="sjns_sj"
				onpropertychange="f_getYearInfo(this)"
				autoid=55 >
    </td>
    <td width="20%" height="16" class="data_tb_alignright">是否需要调整<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="16"><input maxlength="200" onfocus="onPopDivClick(this);"
    					autoWidth=140
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=20
						refer="是否连续审计"
						noinput=true
						hideresult=true id="sftzje" value="${qt.sftzje}" name="sftzje" size="20" class="required" onchange="f_display_tzh_money()">
						<font color="red">(如果涉及调整数，请在报备完成前填列)</font>
	</td>
  </tr>
  
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">报表年度</td>
    <td height="16" colspan="3">
	    <input maxlength="50" id="bgnd" name="bgnd" value="${ct.bgnd}" size="20" title="报表年度" onkeyup="getProjectName();" onchange="getProjectName();">
	    <font color="red">(会显示在报备封面上)</font>
    </td>
  </tr>
  
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">保留意见内容</td>
    <td width="80%" height="16" colspan="3"><textarea id="bjyjly" style="width: 90%;height: 50px;" name="bjyjly">${qt.bjyjly }</textarea></td>
  </tr>
   
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">无保留意见强调事项</td>
    <td width="80%" height="16" colspan="3"><textarea id="notblyjly" style="width: 90%;height: 50px;" name="notblyjly">${qt.notblyjly }</textarea></td>
  </tr>
  
  <tr>
  	<td colspan="4">
  		<table class="data_tb" width="100%" id="t_table">
  			<tbody id="tb_title" style="display: none">
  			  <tr>
			  	<td width="12%"></td>
			    <td width="17%">资产总额</td>
			  	<td width="17%"  class="displays">销售收入</td>
				<td width="17%">营业收入<br><font color="red">(金额包含销售收入)</font></td>
			  	<td width="17%" class="displays">专项审计金额</td>
			  	<td width="20%">从业人员<br><font color="red">(被审验单位期末员工数)</font></td>
			  </tr>
			 </tbody>
			 <tbody id="tb_one" style="display: none">
			  <tr>
			  	<td><input type="text" id="years1" name="years" value="第一年" size="10" style="text-align: center;border: 0px;" readonly="readonly"> </td>
			  	<td ><input type="text" id="zcze1" name="zcze" value="${mapTotalMoney.oneYear.zcze}" onkeyup="f_money(this);f_countZcze();" size=15 style="text-align: right;">万元</td>
			  	
				<td class="displays"><input type="text" id="xssr1" name="xssr" value="${mapTotalMoney.oneYear.xssr}" onkeyup="f_money(this);f_countXssr();" size=15 style="text-align: right;">万元</td>
			    <td class=""><input type="text" id="yysr1" name="yysr" value="${mapTotalMoney.oneYear.yysr}" onkeyup="f_money(this);f_countYysr();" size=15 style="text-align: right;">万元</td>
			    
				<td class="displays"><input type="text" id="zxsjje1" name="zxsjje" value="${mapTotalMoney.oneYear.zxsjje}" onkeyup="f_money(this);f_countZxsjje();" size=15 style="text-align: right;">万元</td>
			    <td ><input type="text" id="cyry1" name="cyry" value="${mapTotalMoney.oneYear.cyry}" onkeyup="f_number(this);f_countCyry();" size=5 style="text-align: right;">人</td>
			  </tr>
			 </tbody>
			 
			 <tbody id="tb_two" style="display: none">
			  <tr>
			  	<td><input type="text" id="years2" name="years" value="第二年" size="10" style="text-align: center;border: 0px;" readonly="readonly"> </td>
			  	<td ><input type="text" id="zcze2" name="zcze" value="${mapTotalMoney.twoYear.zcze}" onkeyup="f_money(this);f_countZcze();" size=15 style="text-align: right;">万元</td>
			  	<td class="displays">><input type="text" id="xssr2" name="xssr" value="${mapTotalMoney.twoYear.xssr}" onkeyup="f_money(this);f_countXssr();" size=15 style="text-align: right;">万元</td>
			    <td class=""><input type="text" id="yysr2" name="yysr" value="${mapTotalMoney.twoYear.yysr}" onkeyup="f_money(this);f_countYysr();" size=15 style="text-align: right;">万元</td>
			    <td class="displays"><input type="text" id="zxsjje2" name="zxsjje" value="${mapTotalMoney.twoYear.zxsjje}" onkeyup="f_money(this);f_countZxsjje();" size=15 style="text-align: right;">万元</td>
			    <td ><input type="text" id="cyry2" name="cyry" value="${mapTotalMoney.twoYear.cyry}" onkeyup="f_number(this);f_countCyry();" size=5 style="text-align: right;">人</td>
			   </tr>
			  </tbody>
			  
			 <tbody id="tb_three" style="display: none">
			  <tr>
			  	<td><input type="text" id="years3" name="years" value="第三年" size="10" style="text-align: center;border: 0px;" readonly="readonly"> </td>
			   	<td ><input type="text" id="zcze3" name="zcze" value="${mapTotalMoney.threeYear.zcze}" onkeyup="f_money(this);f_countZcze();" size=15 style="text-align: right;">万元</td>
			  	<td class="displays"><input type="text" id="xssr3" name="xssr" value="${mapTotalMoney.threeYear.xssr}" onkeyup="f_money(this);f_countXssr();" size=15 style="text-align: right;">万元</td>
			    <td ><input type="text" id="yysr3" name="yysr" value="${mapTotalMoney.threeYear.yysr}" onkeyup="f_money(this);f_countYysr();" size=15 style="text-align: right;">万元</td>
			    <td class="displays"><input type="text" id="zxsjje3" name="zxsjje" value="${mapTotalMoney.threeYear.zxsjje}" onkeyup="f_money(this);f_countZxsjje();" size=15 style="text-align: right;">万元</td>
			    <td ><input type="text" id="cyry3" name="cyry" value="${mapTotalMoney.threeYear.cyry}" onkeyup="f_number(this);f_countCyry();" size=5 style="text-align: right;">人</td>
			  </tr>
			 </tbody>
			 <tbody id="tb_four" style="display: none">
			  <tr>
			  	<td><input type="text" id="years4" name="years" value="第四年" size="10" style="text-align: center;border: 0px;" readonly="readonly"> </td>
			 	<td ><input type="text" id="zcze4" name="zcze" value="${mapTotalMoney.fourYear.zcze}" onkeyup="f_money(this);f_countZcze();" size=15 style="text-align: right;">万元</td>
			  	<td class="displays"><input type="text" id="xssr4" name="xssr" value="${mapTotalMoney.fourYear.xssr}" onkeyup="f_moneys(this);f_countXssr();" size=15 style="text-align: right;">万元</td>
			    <td class=""><input type="text" id="yysr4" name="yysr" value="${mapTotalMoney.fourYear.yysr}" onkeyup="f_moneys(this);f_countYysr();" size=15 style="text-align: right;">万元</td>
			    <td class="displays"><input type="text" id="zxsjje4" name="zxsjje" value="${mapTotalMoney.fourYear.zxsjje}" onkeyup="f_moneys(this);f_countZxsjje();" size=15 style="text-align: right;">万元</td>
			    <td ><input type="text" id="cyry4" name="cyry" value="${mapTotalMoney.fourYear.cyry}" onkeyup="f_number(this);f_countCyry();" size=5 style="text-align: right;">人</td>
			  </tr>
			  </tbody>
			 <tbody id="tb_five" style="display: none">
			  <tr>
			  	<td><input type="text" id="years5" name="years" value="第五年" size="10" style="text-align: center;border: 0px;" readonly="readonly"> </td>
			 	<td ><input type="text" id="zcze5" name="zcze" value="${mapTotalMoney.fiveYear.zcze}" onkeyup="f_money(this);f_countZcze();" size=15 style="text-align: right;">万元</td>
			  	<td class="displays"><input type="text" id="xssr5" name="xssr" value="${mapTotalMoney.fiveYear.xssr}" onkeyup="f_money(this);f_countXssr();" size=15 style="text-align: right;">万元</td>
			    <td class=""><input type="text" id="yysr5" name="yysr" value="${mapTotalMoney.fiveYear.yysr}" onkeyup="f_money(this);f_countYysr();" size=15 style="text-align: right;">万元</td>
			    <td class="displays"><input type="text" id="zxsjje5" name="zxsjje" value="${mapTotalMoney.fiveYear.zxsjje}" onkeyup="f_money(this);f_countZxsjje();" size=15 style="text-align: right;">万元</td>
			    <td ><input type="text" id="cyry5" name="cyry" value="${mapTotalMoney.fiveYear.cyry}" onkeyup="f_number(this);f_countCyry();" size=5 style="text-align: right;">人</td>
			  </tr>
			 </tbody>
			 <tbody id="tb_six" style="display: none">
			  <tr>
			  	<td><input type="text" id="years6" name="years" value="第六年" size="10" style="text-align: center;border: 0px;" readonly="readonly"> </td>
			 	<td ><input type="text" id="zcze6" name="zcze" value="${mapTotalMoney.sixYear.zcze}" onkeyup="f_money(this);f_countZcze();" size=15 style="text-align: right;">万元</td>
			  	<td class="displays"><input type="text" id="xssr6" name="xssr" value="${mapTotalMoney.sixYear.xssr}" onkeyup="f_money(this);f_countXssr();" size=15 style="text-align: right;">万元</td>
			    <td class=""><input type="text" id="yysr6" name="yysr" value="${mapTotalMoney.sixYear.yysr}" onkeyup="f_money(this);f_countYysr();" size=15 style="text-align: right;">万元</td>
			    <td class="displays"><input type="text" id="zxsjje6" name="zxsjje" value="${mapTotalMoney.sixYear.zxsjje}" onkeyup="f_money(this);f_countZxsjje();" size=15 style="text-align: right;">万元</td>
			    <td ><input type="text" id="cyry6" name="cyry" value="${mapTotalMoney.sixYear.cyry}" onkeyup="f_number(this);f_countCyry();" size=5 style="text-align: right;">人</td>
			  </tr>
			 </tbody>
		 	 <tbody id="tb_seven" style="display: none">
			  <tr>
			  	<td><input type="text" id="years7" name="years" value="第七年" size="10" style="text-align: center;border: 0px;" readonly="readonly"> </td>
			 	<td ><input type="text" id="zcze7" name="zcze" value="${mapTotalMoney.sevenYear.zcze}" onkeyup="f_money(this);f_countZcze();" size=15 style="text-align: right;">万元</td>
			  	<td class="displays"><input type="text" id="xssr7" name="xssr" value="${mapTotalMoney.sevenYear.xssr}" onkeyup="f_money(this);f_countXssr();" size=15 style="text-align: right;">万元</td>
			    <td class=""><input type="text" id="yysr7" name="yysr" value="${mapTotalMoney.sevenYear.yysr}" onkeyup="f_money(this);f_countYysr();" size=15 style="text-align: right;">万元</td>
			    <td class="displays"><input type="text" id="zxsjje7" name="zxsjje" value="${mapTotalMoney.sevenYear.zxsjje}" onkeyup="f_money(this);f_countZxsjje();" size=15 style="text-align: right;">万元</td>
			    <td ><input type="text" id="cyry7" name="cyry" value="${mapTotalMoney.sevenYear.cyry}" onkeyup="f_number(this);f_countCyry();" size=5 style="text-align: right;">人</td>
			  </tr>
			 </tbody>
			 <tbody id="tb_eight" style="display: none">
			  <tr>
			  	<td><input type="text" id="years8" name="years" value="第八年" size="10" style="text-align: center;border: 0px;" readonly="readonly"> </td>
			 	<td ><input type="text" id="zcze8" name="zcze" value="${mapTotalMoney.eightYear.zcze}" onkeyup="f_money(this);f_countZcze();" size=15 style="text-align: right;">万元</td>
			  	<td class="displays"><input type="text" id="xssr8" name="xssr" value="${mapTotalMoney.eightYear.xssr}" onkeyup="f_money(this);f_countXssr();" size=15 style="text-align: right;">万元</td>
			    <td class=""><input type="text" id="yysr8" name="yysr" value="${mapTotalMoney.eightYear.yysr}" onkeyup="f_money(this);f_countYysr();" size=15 style="text-align: right;">万元</td>
			    <td class="displays"><input type="text" id="zxsjje8" name="zxsjje" value="${mapTotalMoney.eightYear.zxsjje}" onkeyup="f_money(this);f_countZxsjje();" size=15 style="text-align: right;">万元</td>
			    <td ><input type="text" id="cyry8" name="cyry" value="${mapTotalMoney.eightYear.cyry}" onkeyup="f_number(this);f_countCyry();" size=5 style="text-align: right;">人</td>
			  </tr>
			 </tbody>
 			 <tbody id="tb_nine" style="display: none">
			  <tr>
			  	<td><input type="text" id="years9" name="years" value="第九年" size="10" style="text-align: center;border: 0px;" readonly="readonly"> </td>
			 	<td ><input type="text" id="zcze9" name="zcze" value="${mapTotalMoney.nineYear.zcze}" onkeyup="f_money(this);f_countZcze();" size=15 style="text-align: right;">万元</td>
			  	<td class="displays"><input type="text" id="xssr9" name="xssr" value="${mapTotalMoney.nineYear.xssr}" onkeyup="f_money(this);f_countXssr();" size=15 style="text-align: right;">万元</td>
			    <td class=""><input type="text" id="yysr9" name="yysr" value="${mapTotalMoney.nineYear.yysr}" onkeyup="f_money(this);f_countYysr();" size=15 style="text-align: right;">万元</td>
			    <td class="displays"><input type="text" id="zxsjje9" name="zxsjje" value="${mapTotalMoney.nineYear.zxsjje}" onkeyup="f_money(this);f_countZxsjje();" size=15 style="text-align: right;">万元</td>
			    <td ><input type="text" id="cyry9" name="cyry" value="${mapTotalMoney.nineYear.cyry}" onkeyup="f_number(this);f_countCyry();" size=5 style="text-align: right;">人</td>
			  </tr>
			 </tbody>
		 	 <tbody id="tb_ten" style="display: none">
			  <tr>
			  	<td><input type="text" id="years10" name="years" value="第十年" size="10" style="text-align: center;border: 0px;" readonly="readonly"> </td>
			 	<td ><input type="text" id="zcze10" name="zcze" value="${mapTotalMoney.tenYear.zcze}" onkeyup="f_money(this);f_countZcze();" size=15 style="text-align: right;">万元</td>
			  	<td class="displays"><input type="text" id="xssr10" name="xssr" value="${mapTotalMoney.tenYear.xssr}" onkeyup="f_money(this);f_countXssr();" size=15 style="text-align: right;">万元</td>
			    <td class=""><input type="text" id="yysr10" name="yysr" value="${mapTotalMoney.tenYear.yysr}" onkeyup="f_money(this);f_countYysr();" size=15 style="text-align: right;">万元</td>
			    <td class="displays"><input type="text" id="zxsjje10" name="zxsjje" value="${mapTotalMoney.tenYear.zxsjje}" onkeyup="f_money(this);f_countZxsjje();" size=15 style="text-align: right;">万元</td>
			    <td ><input type="text" id="cyry10" name="cyry" value="${mapTotalMoney.tenYear.cyry}" onkeyup="f_number(this);f_countCyry();" size=5 style="text-align: right;">人</td>
			  </tr>
			 </tbody>
			 <tbody id="tb_eleven" style="display: none">
				<tr>
					<td><input type="text" id="years11" name="years" value="第十一年"size="10" style="text-align: center; border: 0px;" readonly="readonly"></td>
					<td><input type="text" id="zcze11" name="zcze"	value="${mapTotalMoney.elevenYear.zcze}" onkeyup="f_money(this);f_countZcze();" size=15	style="text-align: right;">万元</td>
					<td class="displays"><input type="text" id="xssr11"
						name="xssr" value="${mapTotalMoney.elevenYear.xssr}"
						onkeyup="f_money(this);f_countXssr();" size=15
						style="text-align: right;">万元</td>
					<td><input type="text" id="yysr11" name="yysr"
						value="${mapTotalMoney.elevenYear.yysr}"
						onkeyup="f_money(this);f_countYysr();" size=15
						style="text-align: right;">万元</td>
					<td class="displays"><input type="text" id="zxsjje11" name="zxsjje"
						value="${mapTotalMoney.elevenYear.zxsjje}"
						onkeyup="f_money(this);f_countZxsjje();" size=15
						style="text-align: right;">万元</td>
					<td><input type="text" id="cyry11" name="cyry"
						value="${mapTotalMoney.elevenYear.cyry}"
						onkeyup="f_number(this);f_countCyry();" size=5
						style="text-align: right;">人</td>
				</tr>
			</tbody>
			<tbody id="tb_twelve" style="display: none">
				<tr>
					<td><input type="text" id="years12" name="years" value="第十二年"
						size="10" style="text-align: center; border: 0px;"
						readonly="readonly"></td>
					<td><input type="text" id="zcze12" name="zcze"
						value="${mapTotalMoney.twelveYear.zcze}"
						onkeyup="f_money(this);f_countZcze();" size=15
						style="text-align: right;">万元</td>
					<td class="displays"><input type="text" id="xssr12"
						name="xssr" value="${mapTotalMoney.twelveYear.xssr}"
						onkeyup="f_money(this);f_countXssr();" size=15
						style="text-align: right;">万元</td>
					<td><input type="text" id="yysr12" name="yysr"
						value="${mapTotalMoney.twelveYear.yysr}"
						onkeyup="f_money(this);f_countYysr();" size=15
						style="text-align: right;">万元</td>
					<td class="displays"><input type="text" id="zxsjje12" name="zxsjje"
						value="${mapTotalMoney.twelveYear.zxsjje}"
						onkeyup="f_money(this);f_countZxsjje();" size=15
						style="text-align: right;">万元</td>
					<td><input type="text" id="cyry12" name="cyry"
						value="${mapTotalMoney.twelveYear.cyry}"
						onkeyup="f_number(this);f_countCyry();" size=5
						style="text-align: right;">人</td>
				</tr>
			</tbody>
			<tbody id="tb_thirteen" style="display: none">
				<tr>
					<td><input type="text" id="years13" name="years" value="第十三年"
						size="10" style="text-align: center; border: 0px;"
						readonly="readonly"></td>
					<td><input type="text" id="zcze13" name="zcze"
						value="${mapTotalMoney.thirteenYear.zcze}"
						onkeyup="f_money(this);f_countZcze();" size=15
						style="text-align: right;">万元</td>
					<td class="displays"><input type="text" id="xssr13"
						name="xssr" value="${mapTotalMoney.thirteenYear.xssr}"
						onkeyup="f_money(this);f_countXssr();" size=15
						style="text-align: right;">万元</td>
					<td><input type="text" id="yysr13" name="yysr"
						value="${mapTotalMoney.thirteenYear.yysr}"
						onkeyup="f_money(this);f_countYysr();" size=15
						style="text-align: right;">万元</td>
					<td class="displays"><input type="text" id="zxsjje13" name="zxsjje"
						value="${mapTotalMoney.thirteenYear.zxsjje}"
						onkeyup="f_money(this);f_countZxsjje();" size=15
						style="text-align: right;">万元</td>
					<td><input type="text" id="cyry13" name="cyry"
						value="${mapTotalMoney.thirteenYear.cyry}"
						onkeyup="f_number(this);f_countCyry();" size=5
						style="text-align: right;">人</td>
				</tr>
			</tbody>
			<tbody id="tb_fourteen" style="display: none">
				<tr>
					<td><input type="text" id="years14" name="years" value="第十四年"
						size="10" style="text-align: center; border: 0px;"
						readonly="readonly"></td>
					<td><input type="text" id="zcze14" name="zcze"
						value="${mapTotalMoney.fourteenYear.zcze}"
						onkeyup="f_money(this);f_countZcze();" size=15
						style="text-align: right;">万元</td>
					<td class="displays"><input type="text" id="xssr14"
						name="xssr" value="${mapTotalMoney.fourteenYear.xssr}"
						onkeyup="f_money(this);f_countXssr();" size=15
						style="text-align: right;">万元</td>
					<td><input type="text" id="yysr14" name="yysr"
						value="${mapTotalMoney.fourteenYear.yysr}"
						onkeyup="f_money(this);f_countYysr();" size=15
						style="text-align: right;">万元</td>
					<td class="displays"><input type="text" id="zxsjje14" name="zxsjje"
						value="${mapTotalMoney.fourteenYear.zxsjje}"
						onkeyup="f_money(this);f_countZxsjje();" size=15
						style="text-align: right;">万元</td>
					<td><input type="text" id="cyry14" name="cyry"
						value="${mapTotalMoney.fourteenYear.cyry}"
						onkeyup="f_number(this);f_countCyry();" size=5
						style="text-align: right;">人</td>
				</tr>
			</tbody>
			<tbody id="tb_fifteen" style="display: none">
				<tr>
					<td><input type="text" id="years15" name="years" value="第十五年"
						size="10" style="text-align: center; border: 0px;"
						readonly="readonly"></td>
					<td><input type="text" id="zcze15" name="zcze"
						value="${mapTotalMoney.fifteenYear.zcze}"
						onkeyup="f_money(this);f_countZcze();" size=15
						style="text-align: right;">万元</td>
					<td class="displays"><input type="text" id="xssr15"
						name="xssr" value="${mapTotalMoney.fifteenYear.xssr}"
						onkeyup="f_money(this);f_countXssr();" size=15
						style="text-align: right;">万元</td>
					<td><input type="text" id="yysr15" name="yysr"
						value="${mapTotalMoney.fifteenYear.yysr}"
						onkeyup="f_money(this);f_countYysr();" size=15
						style="text-align: right;">万元</td>
					<td class="displays"><input type="text" id="zxsjje15" name="zxsjje"
						value="${mapTotalMoney.fifteenYear.zxsjje}"
						onkeyup="f_money(this);f_countZxsjje();" size=15
						style="text-align: right;">万元</td>
					<td><input type="text" id="cyry15" name="cyry"
						value="${mapTotalMoney.fifteenYear.cyry}"
						onkeyup="f_number(this);f_countCyry();" size=5
						style="text-align: right;">人</td>
				</tr>
			</tbody>
			 <tbody id="tb_tzh_money">
			  <tr>
			  	<td><input type="text" id="lastyears" name="lastyears" value="最后一年调整后金额" size="20" style="text-align: center;border: 0px;" readonly="readonly"> </td>
			 	<td ><input type="text" id="zczetzh" name="zczetzh" value="${qt.zczetzh}" onkeyup="f_money(this);" size=15 style="text-align: right;">万元</td>
			  	<td class="displays"><input type="text" id="xssrtzh" name="xssrtzh" value="${qt.xssrtzh}" onkeyup="f_money(this);" size=15 style="text-align: right;">万元</td>
			    <td class=""><input type="text" id="yysrtzh" name="yysrtzh" value="" onkeyup="f_money(this);" size=15 style="text-align: right;">万元</td>
			    <td class="displays"><input type="text" id="zxsjjetzh" name="zxsjjetzh" value="" onkeyup="f_money(this);" size=15 style="text-align: right;">万元</td>
			    <td class="displays"><input type="text" id="cyrytzh" name="cyrytzh" value="" readonly="readonly" size=5 style="text-align: right;">人</td>
			  </tr>
			 </tbody>
			 <tbody id="tb_total" style="display: none">
		   	  <tr>
			  	<td><input type="text" id="total" name="total" value="合计" size="10" style="text-align: center;border: 0px;" readonly="readonly"> </td>
			  	<td ><input type="text" id="zczetotal" name="zczetotal" value="" size=15 style="text-align: right;border: 0px;" readonly="readonly">万元</td>
			  	<td class="displays"><input type="text" id="xssrtotal" name="xssrtotal" value="" size=15 style="text-align: right;border: 0px;" readonly="readonly">万元</td>
			    <td class=""><input type="text" id="yysrtotal" name="yysrtotal" value="" size=15 style="text-align: right;border: 0px;" readonly="readonly">万元</td>
			    <td class="displays"><input type="text" id="zxsjjetotal" name="zxsjjetotal" value="" size=15 style="text-align: right;border: 0px;" readonly="readonly">万元</td>
			    <td ><input type="text" id="cyrytotal" name="cyrytotal" value="" size=5 style="text-align: right;border: 0px;" readonly="readonly">人</td>
			  </tr>
			 </tbody>
		 </table>
  	</td>
 </tr>
</table>


<script type="text/javascript">

var sjns = "${qt.sjns}";
if(sjns==""){
	document.getElementById("sjns").value = "一年";
}

// 是否调整金额：默认为否
var sftzje = "${qt.sftzje}";
if(sftzje == ""){
	document.getElementById("sftzje").value = "否";
	document.getElementById("tb_tzh_money").style.display = "none";
}else{
	f_display_tzh_money();
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
		
		// 调整后销售收入
		var xssrtzh = document.getElementById("xssrtzh").value;
		if(xssrtzh==""){
			setTab('search','nre');
			document.getElementById("xssrtzh").select();
			alert("调整后销售收入不能为空！");
			return "notAlert";
		}
		xssrtzh = xssrtzh*1;
		
		
		if((zczetzh*1+xssrtzh*1)<=0){
			setTab('search','nre');
			document.getElementById("zczetzh").select();
			alert("调整后资产总额、调整后销售收入之和必须大于0！");
			return "notAlert";
		}
	}
	return "OK";
}


// 初始化0
function f_initZero(arrayObj){
	if(arrayObj){
		for(var i=0;i<arrayObj.length;i++){
			var obj = document.getElementById(arrayObj[i]); 
			if(obj){
				if(obj.value==""){
					obj.value = 0;
				}
			}
		}
	}
}


var init_money_arrays = ["zcze1","zcze2","zcze3","zcze4","zcze5","zcze6","zcze7","zcze8","zcze9","zcze10","zcze11","zcze12","zcze13","zcze14","zcze15",
					   		"xssr1","xssr2","xssr3","xssr4","xssr5","xssr6","xssr7","xssr8","xssr9","xssr10","xssr11","xssr12","xssr13","xssr14","xssr15",
					   		"cyry1","cyry2","cyry3","cyry4","cyry5","cyry6","cyry7","cyry8","cyry9","cyry10","cyry11","cyry12","cyry13","cyry14","cyry15"];

var qssj_en_money_arrays = ["zcze1","zcze2","zcze3","zcze4","zcze5","zcze6","zcze7","zcze8","zcze9","zcze10","zcze11","zcze12","zcze13","zcze14","zcze15",
					   		"xssr1","xssr2","xssr3","xssr4","xssr5","xssr6","xssr7","xssr8","xssr9","xssr10","xssr11","xssr12","xssr13","xssr14","xssr15"];
						   
var qssj_ch_money_arrays = ["第1年资产总额","第2年资产总额","第3年资产总额","第4年资产总额","第5年资产总额",
							"第6年资产总额","第7年资产总额","第8年资产总额","第9年资产总额","第10年资产总额",
							"第11年资产总额","第12年资产总额","第13年资产总额","第14年资产总额","第15年资产总额",
					   	  	"第1年销售收入","第2年销售收入","第3年销售收入","第4年销售收入","第5年销售收入",
					   	  	"第6年销售收入","第7年销售收入","第8年销售收入","第9年销售收入","第10年销售收入",
					   	    "第11年销售收入","第12年销售收入","第13年销售收入","第14年销售收入","第15年销售收入"];
					   	  					   	  	
					   
// 初始化0					   
// f_initZero(init_money_arrays);
					   
					   

// 计算年数
function f_calcYear(){
	var yeasArray = ["一年","二年","三年","四年","五年","六年","七年","八年","九年","十年","十一年","十二年","十三年","十四年","十五年"];
	var sjns = document.getElementById("sjns").value;
	var index = 0;
	for(var i=0;i<yeasArray.length;i++){
		if(sjns == yeasArray[i]){
			index = i+1;
			break;
		}
	}
	return index;
}



// 检查不能为空
function f_checkNull(){
	// 计算年 
	var years = f_calcYear();
	for(var i=1;i<=years;i++){
		var zczeRS = f_checkSingleNull(i,"zcze","资产总额");
		if(zczeRS){
			//var xssrRS = f_checkSingleNull(i,"xssr","销售收入");
			var xssrRS = f_checkSingleNull(i,"yysr","营业收入");
			if(!xssrRS){
				return false;
			}
		}else{
			return false;
		}
	}
	return true;
}

function f_checkSingleNull(year,engName,chName){
	var obj = document.getElementById(engName+year); 
	if(obj){
		if(obj.value==""){
			setTab('search','nre');
			alert("第"+year+"年的"+chName+"不能为空！");
			obj.select();
			return false;
		}
	}
	return true;
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



var years_array = ["years1","years2","years3","years4","years5","years6","years7","years8","years9","years10","years11","years12","years13","years14","years15"];
var zcze_array = ["zcze1","zcze2","zcze3","zcze4","zcze5","zcze6","zcze7","zcze8","zcze9","zcze10","zcze11","zcze12","zcze13","zcze14","zcze15"];
var xssr_array = ["xssr1","xssr2","xssr3","xssr4","xssr5","xssr6","xssr7","xssr8","xssr9","xssr10","xssr11","xssr12","xssr13","xssr14","xssr15"];
var yysr_array = ["yysr1","yysr2","yysr3","yysr4","yysr5","yysr6","yysr7","yysr8","yysr9","yysr10","yysr11","yysr12","yysr13","yysr14","yysr15"];
var zxsjje_array = ["zxsjje1","zxsjje2","zxsjje3","zxsjje4","zxsjje5","zxsjje6","zxsjje7","zxsjje8","zxsjje9","zxsjje10","zxsjje11","zxsjje12","zxsjje13","zxsjje14","zxsjje15"];
var cyry_array = ["cyry1","cyry2","cyry3","cyry4","cyry5","cyry6","cyry7","cyry8","cyry9","cyry10","cyry11","cyry12","cyry13","cyry14","cyry15"];

// 屏蔽
function f_doDisable(index){
	if(years_array){
		for(var i=index+1;i<years_array.length;i++){
			document.getElementById(years_array[i]).disabled = true;
			document.getElementById(zcze_array[i]).disabled = true;
			document.getElementById(zcze_array[i]).value = "";
			document.getElementById(xssr_array[i]).disabled = true;
			document.getElementById(xssr_array[i]).value = "";
			document.getElementById(yysr_array[i]).disabled = true;
			document.getElementById(yysr_array[i]).value = "";
			document.getElementById(zxsjje_array[i]).disabled = true;
			document.getElementById(zxsjje_array[i]).value = "";
			document.getElementById(cyry_array[i]).disabled = true;
			document.getElementById(cyry_array[i]).value = "";
		}
	}
}

// 不屏蔽
function f_donotDisable(index){
	if(years_array){
		for(var i=0;i<=index;i++){
			document.getElementById(years_array[i]).disabled = false;
			document.getElementById(zcze_array[i]).disabled = false;
			document.getElementById(xssr_array[i]).disabled = false;
			document.getElementById(yysr_array[i]).disabled = false;
			document.getElementById(zxsjje_array[i]).disabled = false;
			document.getElementById(cyry_array[i]).disabled = false;
		}
	}
}


// 联动
function f_getYearInfo(t){
	if(t.value!=""){
		var year_array = ["一年","二年","三年","四年","五年","六年","七年","八年","九年","十年","十一年","十二年","十三年","十四年","十五年"];
		var tb_array = ["tb_one","tb_two","tb_three","tb_four","tb_five","tb_six","tb_seven","tb_eight","tb_nine","tb_ten","tb_eleven","tb_twelve","tb_thirteen","tb_fourteen","tb_fifteen"];
		var yearIndex = 0;
		for(var i=0;i<year_array.length;i++){
			if(t.value==year_array[i]){
				yearIndex = i; 
				break;
			}
		}
		// 显示
		for(var m=0;m<=yearIndex;m++){
			document.getElementById(tb_array[m]).style.display = "";
		}
	
		// 隐藏
		for(var n=yearIndex+1;n<tb_array.length;n++){
			document.getElementById(tb_array[n]).style.display = "none";
		}
		
		document.getElementById("tb_title").style.display = "";
		document.getElementById("t_table").style.display = "";
		document.getElementById("tb_total").style.display = "";
		
		// 屏蔽
		f_doDisable(yearIndex);
		
		// 不屏蔽
		f_donotDisable(yearIndex);
	}else{
		document.getElementById("t_table").style.display = "none";
		// 屏蔽
		f_doDisable(-1);
	}
	f_calc_total();
}


// 资产总额合计
function f_countZcze(){
	if(zcze_array){
		var zczetotal = 0;
		for(var i=0;i<zcze_array.length;i++){
			if(document.getElementById(zcze_array[i])){
				zczetotal = f_addNum(zczetotal*1,document.getElementById(zcze_array[i]).value*1);
			}
		}
		var lengths = f_getPointLength(zczetotal);
		zczetotal = zczetotal.toFixed(lengths);
		document.getElementById("zczetotal").value = zczetotal;
	}
};


// 小数点后面的数位
function f_getPointLength(money){
	var lengths = 0;
	var moneyString = money+"";
	if(moneyString.indexOf(".")>-1){
		var pointValue = moneyString.substring(moneyString.indexOf(".")+1,moneyString.length);
		lengths = pointValue.length;
	}
	lengths = lengths>7?7:lengths;
	return lengths
}

// 销售收入合计
function f_countXssr(){
	document.getElementById("xssrtotal").value = f_getMoneyFromArray(xssr_array);
};

// 营业收入合计
function f_countYysr(){
	document.getElementById("yysrtotal").value = f_getMoneyFromArray(yysr_array);
};

// 专项审计合计
function f_countZxsjje(){
	document.getElementById("zxsjjetotal").value = f_getMoneyFromArray(zxsjje_array);
};

// 从业人员合计
function f_countCyry(){
	document.getElementById("cyrytotal").value = f_getMoneyFromArray(cyry_array);
};

// 计算合计
function f_calc_total(){
	// 资产总额合计
	f_countZcze();
	// 销售收入合计
	f_countXssr();
	// 营业收入合计
	f_countYysr();
	// 专项审计合计
	f_countZxsjje();
	// 从业人员合计
	f_countCyry();
}



// 资产总额与销售收入中取其大者	：根据年		 
function f_get_zcze_xssr_year(year){
	var zcze_array_temp = [zcze_array[year-1]];
	var zczeMoney = f_getMoneyFromArray(zcze_array_temp);
	
	var xssr_array_temp = [xssr_array[year-1]] 
	var xssrMoney = f_getMoneyFromArray(xssr_array_temp);
	
	return zczeMoney<xssrMoney?xssrMoney:zczeMoney;
}		


function f_get_zcze_yysr_year(year){
	var zcze_array_temp = [zcze_array[year-1]];
	var zczeMoney = f_getMoneyFromArray(zcze_array_temp);
	
	var yysr_array_temp = [yysr_array[year-1]] 
	var yysrMoney = f_getMoneyFromArray(yysr_array_temp);
	
	return zczeMoney<yysrMoney?yysrMoney:zczeMoney;
}	



// 资产总额与(销售收入+营业收入)中取其大者			
function f_get_zcze_xssr_yysr(){
	var zczeMoney = f_getMoneyFromArray(zcze_array);
	
	var xssrMoney = f_getMoneyFromArray(xssr_array);
	
	var yysrMoney = f_getMoneyFromArray(yysr_array);
	
	return (xssrMoney*1+yysrMoney*1)<zczeMoney*1?zczeMoney:(xssrMoney*1+yysrMoney*1);	
}



// 资产总额与(销售收入+营业收入)中取其总和 ：根据年		
function f_get_zcze_xssr_yysr_total(year){
	var zcze_array_temp = [zcze_array[year-1]] ;
	var zczeMoney = f_getMoneyFromArray(zcze_array_temp);
	
	var xssr_array_temp = [xssr_array[year-1]] 
	var xssrMoney = f_getMoneyFromArray(xssr_array_temp);
	
	var yysr_array_temp = [yysr_array[year-1]] 
	var yysrMoney = f_getMoneyFromArray(yysr_array_temp);
	
	return zczeMoney*1 + xssrMoney*1 + yysrMoney*1;	
}

// 资产总额与销售收入大于0：根据年		
function f_get_zcze_xssr_total(year){
	var zcze_array_temp = [zcze_array[year-1]] ;
	var zczeMoney = f_getMoneyFromArray(zcze_array_temp);
	
	var xssr_array_temp = [xssr_array[year-1]] 
	var xssrMoney = f_getMoneyFromArray(xssr_array_temp);
	
	return zczeMoney*1 + xssrMoney*1;	
}

// 得到最后一年从业人员		
function f_get_cyry_lastYear(){
	var year = f_calcYear();
	var cyry = 0;
	var cyryObj = document.getElementById("cyry"+year);
	if(cyryObj){
		cyry = cyryObj.value*1; 
	}
	return cyry;	
}

// 从数组对象中计算总和
function f_getMoneyFromArray(array){
	var money = 0;
	if(array){
		for(var i=0;i<array.length;i++){
			if(document.getElementById(array[i])){
				money = f_addNum(money*1,document.getElementById(array[i]).value*1);
			}
		}
		var lengths = f_getPointLength(money);
		money = money.toFixed(lengths);
	}
	return money;
}

//计算收费标准
function getChargeStandard(){
	var type = "清算审计";
	var zczetotal = document.getElementById("zczetotal").value*1;
	var yysrtotal = document.getElementById("yysrtotal").value*1;
	var zcze1 = document.getElementById("zcze1").value;
	var yysr1 = document.getElementById("yysr1").value;
	
	if(!f_checkNull()){
		return "N";
	}
	
	if((zczetotal+yysrtotal)==0){
		setTab('search','nre');
		document.getElementById("zcze1").select();
		alert("第一年的资产总额与营业收入之和必须大于0!");
		return "N";
	}else if(zcze1==""){
		setTab('search','nre');
		document.getElementById("zcze1").select();
		alert("第一年的资产总额不能为空!");
		return "N";
	}else if(yysr1==""){
		setTab('search','nre');
		document.getElementById("yysr1").select();
		alert("第一年的营业收入不能为空!");
		return "N";
	}
	
	var zcze = zczetotal>yysrtotal ? zczetotal : yysrtotal;
	var year = f_calcYear();
	var url="${pageContext.request.contextPath}/common/content.do?method=getChargeStandard";
	var request = "&type="+type+"&zcze="+zcze+"&kind=1&year="+year+"&hour=0";
	var resText = ajaxLoadPageSynch(url,request);
	return resText;
}
</script>


