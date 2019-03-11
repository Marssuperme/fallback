<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<input type="hidden" id="sjguid" name="sjguid" value="${st.guid}">
<input type="hidden" id="bguid" name="bguid" value="${st.guid}">
<input type="hidden" id="addJsp" name="addJsp"
	value="${pageContext.request.contextPath}/common/bb.do?method=addSjTable">
<input type="hidden" id="updateJsp" name="updateJsp"
	value="${pageContext.request.contextPath}/common/bb.do?method=updateSjTableById">

<table border="0" class="data_tb" cellpadding="0" cellspacing="0" style="padding-left: 2px;" width="100%">
	<tr>
		<td class="data_tb_alignright" style="text-align: left" colspan="4"
			height="16"><span> 审计信息&nbsp;&nbsp;<font color="red">(资产总额、营业收入、专项审计金额之和要大于0，其中没有金额可以填写0。)</font>
		</span></td>
	</tr>
	<tr>
		<td width="20%" height="23" class="data_tb_alignright">审计类型<font
			color="#FF0000">&nbsp;[*]</font>
		</td>
		<td width="30%" height="23" class="data_tb_content">
			<input maxlength="50" onfocus="onPopDivClick(this);" 
				onkeydown="onKeyDownEvent();"
				onkeyup="onKeyUpEvent();" 
				onclick="onPopDivClick(this);"
				norestorehint=true 
				autoid=16 
				noinput=true 
				hideresult=true
				onchange="isQtzxsj();sjlxChange();checkBbIsExist();" 
				title="审计类型" id="sjlx" value="${st.sjlx}" name="sjlx" size="20"	class="required">
		</td>
		<td width="20%" height="23" class="data_tb_alignright">专项审计名称</td>
		<td width="30%" height="23" class="data_tb_content"><input maxlength="100" id="zxsjmc"
			value="${st.zxsjmc}" name="zxsjmc" size="25">专项审计</td>
	</tr>
	<tr>
		<td width="20%" height="23" class="data_tb_alignright">新业务拓展</td>
		<td height="23" class="data_tb_content"><input maxlength="200" onfocus="onPopDivClick(this);" 
			autoWidth=350 
			autoHeight=180
			onkeydown="onKeyDownEvent();" 
			onkeyup="onKeyUpEvent();"
			onclick="onPopDivClick(this);" 
			norestorehint=true 
			autoid=72
			noinput=true
			refer="${userSession.userMap.officecode }"
			hideresult=true id="xywtz" value="${st.xywtz }" name="xywtz" size="20">
		</td>
		<td width="20%" height="23" class="data_tb_alignright">项目鉴证金额</td>
		<td height="23" class="data_tb_content"><input maxlength="100" size="25" type="text" id="xmjzje" name="xmjzje" value="${st.xmjzje }" onkeyup="f_money(this);">万元</td>
	</tr>
	<tr>
		<td width="20%" height="23" class="data_tb_alignright">报告用途</td>
		<td width="30%" height="23" class="data_tb_content"><input id="bgyt" value="${st.bgyt}"
			name="bgyt" size="20">
		</td>
		<td width="20%" height="23" class="data_tb_alignright">报表年度</td>
		<td width="30%" height="23" class="data_tb_content">
			<input maxlength="50" onfocus="onPopDivClick(this);" 
				onkeydown="onKeyDownEvent();"
				onkeyup="onKeyUpEvent();getProjectName();" 
				onclick="onPopDivClick(this);"
				norestorehint=true 
				autoid=73 
				noinput=false 
				hideresult=true
				onchange="getProjectName();checkBbIsExist();" 
				title="报表年度" id="bgnd" value="${ct.bgnd}" name="bgnd" size="25"	class="data_tb_content">
				<a id="setBgndImg" href="javascript:;" style="display:none;"><img alt="点击选择报表区间" onclick="editBgnd();" src="${pageContext.request.contextPath}/icons/clock.png" style="border:0px !important;position: relative;top:3px;"></a>
			<br>
		<font color="red">(会显示在报备封面上)</font>
		</td>
	</tr>
	<tr>
		<td width="20%" height="23" class="data_tb_alignright">合并户数</td>
		<td width="30%" height="23" class="data_tb_content"><input maxlength="50" id="hbhs"
			value="${st.hbhs}" name="hbhs" size="20" class="number"
			onkeyup="f_money(this);">
		</td>
		<td width="20%" height="23" class="data_tb_alignright">控股上市公司数</td>
		<td width="30%" height="23" class="data_tb_content"><input maxlength="50" id="kgssgss"
			value="${st.kgssgss }" size="25" name="kgssgss" class="number"
			onkeyup="f_money(this);"></td>
	</tr>
	<tr>
		<td width="20%" height="23" class="data_tb_alignright">股票代码</td>
		<td width="30%" height="23" class="data_tb_content"><input maxlength="50" id="gpdm"
			value="${st.gpdm }" name="gpdm" size="20">
		</td>
		<td width="20%" height="23" class="data_tb_alignright">是否连续审计</td>
		<td width="30%" height="23" class="data_tb_content"><input maxlength="10"
			onfocus="onPopDivClick(this);" noinput=true autoWidth=180
			autoHeight=180 onkeydown="onKeyDownEvent();"
			onkeyup="onKeyUpEvent();" onclick="onPopDivClick(this);"
			norestorehint=true autoid=20 hideresult=true id="sflxsj"
			value="${st.sflxsj }" size="25" name="sflxsj"></td>
	</tr>
	<tr>
		<td width="20%" height="23" class="data_tb_alignright">前任会计师事务所名称</td>
		<td width="30%" height="23" class="data_tb_content"><input maxlength="100"
			id="qykjsswsmc" value="${st.qykjsswsmc }" name="qykjsswsmc" size="20">
		</td>
		<td width="20%" height="23" class="data_tb_alignright">审计报告意见类型<font color="#FF0000">&nbsp;[*]</font>
		</td>
		<td width="30%" height="23" class="data_tb_content"><input maxlength="50"
			onfocus="onPopDivClick(this);" autoWidth=180 autoHeight=180
			onkeydown="onKeyDownEvent();" onkeyup="onKeyUpEvent();"
			onclick="onPopDivClick(this);" norestorehint=true autoid=7
			noinput=true hideresult=true id="sjbgyjlx" value="${st.sjbgyjlx }"
			title="审计报告意见类型" size="25" name="sjbgyjlx" class="required"
			refer=0>
		</td>
	</tr>
	<tr>
		<td width="20%" height="23" class="data_tb_alignright">利润总额</td>
		<td width="30%" height="23" class="data_tb_content"><input maxlength="20" id="lrze"
			value="${st.lrze }" name="lrze" size="20" class="number"
			onkeyup="f_money(this);">万元</td>
		<td width="20%" height="23" class="data_tb_alignright">应纳税所得额</td>
		<td width="30%" height="23" class="data_tb_content"><input maxlength="20" id="ylsde"
			value="${st.ylsde }" size="25" name="ylsde" class="number"
			onkeyup="f_money(this);">万元</td>
	</tr>
	<tr>
		<td width="20%" height="23" class="data_tb_alignright">净利润</td>
		<td width="30%" height="23" class="data_tb_content"><input maxlength="20" id="jlr"
			value="${st.jlr }" name="jlr" size="20" class="number"
			onkeyup="f_money(this);">万元</td>
		<td width="20%" height="23" class="data_tb_alignright">应纳所得税额</td>
		<td width="30%" height="23" class="data_tb_content"><input maxlength="20" id="ylsdse"
			value="${st.ylsdse }" name="ylsdse" size="25" class="number"
			onkeyup="f_money(this);">万元</td>
	</tr>

	<tr>
		<td width="20%" height="23" class="data_tb_alignright">项目组人数</td>
		<td width="30%" height="23" class="data_tb_content"><input maxlength="50" id="xmzrs"
			value="${st.xmzrs }" name="xmzrs" size="20" class="number"
			onkeyup="f_money(this);">人</td>
		<td width="20%" height="23" class="data_tb_alignright">外勤工作天数</td>
		<td width="30%" height="23" class="data_tb_content"><input maxlength="50" id="wqgzts"
			value="${st.wqgzts }" name="wqgzts" size="25" class="number"
			onkeyup="f_money(this);">天</td>
	</tr>

	<tr>
		<td width="20%" height="23" class="data_tb_alignright">审计年数<font
			color="#FF0000">&nbsp;[*]</font>
		</td>
		<td width="20%" height="23" class="data_tb_content"><input maxlength="20" id="sjns"
			value="${st.sjns }" name="sjns" size="20" class="required"
			onfocus="onPopDivClick(this);" onkeydown="onKeyDownEvent();"
			onkeyup="onKeyUpEvent();" onclick="onPopDivClick(this);"
			noinput="true" autoWidth="130" refer="sjns_sj"
			onpropertychange="f_getYearInfo(this)" autoid=55></td>
		<td width="20%" height="23" class="data_tb_alignright">负债总额</td>
		<td width="30%" height="23" class="data_tb_content"><input maxlength="20" id="fzze"
			value="${st.fzze }" name="fzze" size="25" class="number"
			onkeyup="f_money(this);">万元</td>
	</tr>

	<tr>
		<td width="20%" height="23" class="data_tb_alignright">是否需要调整<font
			color="#FF0000">&nbsp;[*]</font>
		</td>
		<td height="23" class="data_tb_content"><input maxlength="200"
			onfocus="onPopDivClick(this);" autoWidth=140 autoHeight=180
			onkeydown="onKeyDownEvent();" onkeyup="onKeyUpEvent();"
			onclick="onPopDivClick(this);" norestorehint=true autoid=20
			noinput=true hideresult=true id="sftzje" value="${st.sftzje}"
			name="sftzje" size="20" class="required"
			onchange="f_display_tzh_money()"> <font color="red">(如果涉及调整数，请在报备完成前填列)</font>

		</td>
		<td width="20%" height="23" class="data_tb_alignright">所有者权益</td>
		<td width="30%" height="23" class="data_tb_content"><input maxlength="20" id="syzqy"
			value="${st.syzqy}" name="syzqy" size="25" class="number"
			onkeyup="f_money(this);">万元</td>
	</tr>	
	<tr>
		<td class="data_tb_alignright" width="20%" height="16">保留意见内容</td>
		<td width="80%" height="16" class="data_tb_content" colspan="3"><textarea
				style="width: 90%; height: 50px;" id="blyjlx" name="blyjlx">${st.blyjlx }</textarea>
		</td>
	</tr>

	<tr>
		<td class="data_tb_alignright" width="20%" height="16">无保留意见强调事项</td>
		<td width="80%" height="16" class="data_tb_content" colspan="3"><textarea
				style="width: 90%; height: 50px;" id="notblyjlx" name="notblyjlx">${st.notblyjlx }</textarea>
		</td>
	</tr>
	<tr>
		<td colspan="4">
			<table class="data_tb" width="100%" id="t_table">
				<tbody id="tb_title" style="display: none">
					<tr>
						<td width="12%"></td>
						<td width="17%">资产总额<br>
						<font color="red">(保留小数点后四位以上，不作四舍五入)</font>
						</td>
						<td style="display: none">销售收入<br>
						<font color="red">(保留小数点后四位以上，不作四舍五入)</font>
						</td>
						<td width="17%">营业收入<br>
						<font color="red">(保留小数点后四位以上，不作四舍五入)</font>
						</td>
						<td width="17%">专项审计金额</td>
						<td width="20%">从业人员<br>
						<font color="red">(被审验单位期末员工数)</font>
						</td>
					</tr>
				</tbody>

				<tbody id="tb_one" style="display: none">
					<tr>
						<td><input type="text" id="years1" name="years" value="第一年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze1" name="zcze"
							value="${mapTotalMoney.oneYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr1"
							name="xssr" value="${mapTotalMoney.oneYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr1" name="yysr"
							value="${mapTotalMoney.oneYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje1" name="zxsjje"
							value="${mapTotalMoney.oneYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry1" name="cyry"
							value="${mapTotalMoney.oneYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>

				<tbody id="tb_two" style="display: none">
					<tr>
						<td><input type="text" id="years2" name="years" value="第二年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze2" name="zcze"
							value="${mapTotalMoney.twoYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr2"
							name="xssr" value="${mapTotalMoney.twoYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr2" name="yysr"
							value="${mapTotalMoney.twoYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje2" name="zxsjje"
							value="${mapTotalMoney.twoYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry2" name="cyry"
							value="${mapTotalMoney.twoYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>

				<tbody id="tb_three" style="display: none">
					<tr>
						<td><input type="text" id="years3" name="years" value="第三年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze3" name="zcze"
							value="${mapTotalMoney.threeYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr3"
							name="xssr" value="${mapTotalMoney.threeYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr3" name="yysr"
							value="${mapTotalMoney.threeYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje3" name="zxsjje"
							value="${mapTotalMoney.threeYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry3" name="cyry"
							value="${mapTotalMoney.threeYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>
				<tbody id="tb_four" style="display: none">
					<tr>
						<td><input type="text" id="years4" name="years" value="第四年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze4" name="zcze"
							value="${mapTotalMoney.fourYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr4"
							name="xssr" value="${mapTotalMoney.fourYear.xssr}"
							onkeyup="f_moneys(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr4" name="yysr"
							value="${mapTotalMoney.fourYear.yysr}"
							onkeyup="f_moneys(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje4" name="zxsjje"
							value="${mapTotalMoney.fourYear.zxsjje}"
							onkeyup="f_moneys(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry4" name="cyry"
							value="${mapTotalMoney.fourYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>
				<tbody id="tb_five" style="display: none">
					<tr>
						<td><input type="text" id="years5" name="years" value="第五年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze5" name="zcze"
							value="${mapTotalMoney.fiveYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr5"
							name="xssr" value="${mapTotalMoney.fiveYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr5" name="yysr"
							value="${mapTotalMoney.fiveYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje5" name="zxsjje"
							value="${mapTotalMoney.fiveYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry5" name="cyry"
							value="${mapTotalMoney.fiveYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>
				<tbody id="tb_six" style="display: none">
					<tr>
						<td><input type="text" id="years6" name="years" value="第六年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze6" name="zcze"
							value="${mapTotalMoney.sixYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr6"
							name="xssr" value="${mapTotalMoney.sixYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr6" name="yysr"
							value="${mapTotalMoney.sixYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje6" name="zxsjje"
							value="${mapTotalMoney.sixYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry6" name="cyry"
							value="${mapTotalMoney.sixYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>
				<tbody id="tb_seven" style="display: none">
					<tr>
						<td><input type="text" id="years7" name="years" value="第七年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze7" name="zcze"
							value="${mapTotalMoney.sevenYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr7"
							name="xssr" value="${mapTotalMoney.sevenYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr7" name="yysr"
							value="${mapTotalMoney.sevenYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje7" name="zxsjje"
							value="${mapTotalMoney.sevenYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry7" name="cyry"
							value="${mapTotalMoney.sevenYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>
				<tbody id="tb_eight" style="display: none">
					<tr>
						<td><input type="text" id="years8" name="years" value="第八年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze8" name="zcze"
							value="${mapTotalMoney.eightYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr8"
							name="xssr" value="${mapTotalMoney.eightYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr8" name="yysr"
							value="${mapTotalMoney.eightYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje8" name="zxsjje"
							value="${mapTotalMoney.eightYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry8" name="cyry"
							value="${mapTotalMoney.eightYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>
				<tbody id="tb_nine" style="display: none">
					<tr>
						<td><input type="text" id="years9" name="years" value="第九年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze9" name="zcze"
							value="${mapTotalMoney.nineYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr9"
							name="xssr" value="${mapTotalMoney.nineYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr9" name="yysr"
							value="${mapTotalMoney.nineYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje9" name="zxsjje"
							value="${mapTotalMoney.nineYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry9" name="cyry"
							value="${mapTotalMoney.nineYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>
				<tbody id="tb_ten" style="display: none">
					<tr>
						<td><input type="text" id="years10" name="years" value="第十年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze10" name="zcze"
							value="${mapTotalMoney.tenYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr10"
							name="xssr" value="${mapTotalMoney.tenYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr10" name="yysr"
							value="${mapTotalMoney.tenYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje10" name="zxsjje"
							value="${mapTotalMoney.tenYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry10" name="cyry"
							value="${mapTotalMoney.tenYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>
				<tbody id="tb_eleven" style="display: none">
					<tr>
						<td><input type="text" id="years11" name="years" value="第十一年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze11" name="zcze"
							value="${mapTotalMoney.elevenYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr11"
							name="xssr" value="${mapTotalMoney.elevenYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr11" name="yysr"
							value="${mapTotalMoney.elevenYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje11" name="zxsjje"
							value="${mapTotalMoney.elevenYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
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
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr12"
							name="xssr" value="${mapTotalMoney.twelveYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr12" name="yysr"
							value="${mapTotalMoney.twelveYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje12" name="zxsjje"
							value="${mapTotalMoney.twelveYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
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
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr13"
							name="xssr" value="${mapTotalMoney.thirteenYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr13" name="yysr"
							value="${mapTotalMoney.thirteenYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje13" name="zxsjje"
							value="${mapTotalMoney.thirteenYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
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
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr14"
							name="xssr" value="${mapTotalMoney.fourteenYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr14" name="yysr"
							value="${mapTotalMoney.fourteenYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje14" name="zxsjje"
							value="${mapTotalMoney.fourteenYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
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
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr15"
							name="xssr" value="${mapTotalMoney.fifteenYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr15" name="yysr"
							value="${mapTotalMoney.fifteenYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje15" name="zxsjje"
							value="${mapTotalMoney.fifteenYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry15" name="cyry"
							value="${mapTotalMoney.fifteenYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>
				<tbody id="tb_sixteen" style="display: none">
					<tr>
						<td><input type="text" id="years16" name="years" value="第十六年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze16" name="zcze"
							value="${mapTotalMoney.sixteenYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr16"
							name="xssr" value="${mapTotalMoney.sixteenYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr16" name="yysr"
							value="${mapTotalMoney.sixteenYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje16" name="zxsjje"
							value="${mapTotalMoney.sixteenYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry16" name="cyry"
							value="${mapTotalMoney.sixteenYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>
				<tbody id="tb_seventeen" style="display: none">
					<tr>
						<td><input type="text" id="years17" name="years" value="第十七年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze17" name="zcze"
							value="${mapTotalMoney.seventeenYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr17"
							name="xssr" value="${mapTotalMoney.seventeenYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr17" name="yysr"
							value="${mapTotalMoney.seventeenYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje17" name="zxsjje"
							value="${mapTotalMoney.seventeenYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry17" name="cyry"
							value="${mapTotalMoney.seventeenYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>
				<tbody id="tb_eightteen" style="display: none">
					<tr>
						<td><input type="text" id="years18" name="years" value="第十八年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze18" name="zcze"
							value="${mapTotalMoney.eightteenYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr18"
							name="xssr" value="${mapTotalMoney.eightteenYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr18" name="yysr"
							value="${mapTotalMoney.eightteenYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje18" name="zxsjje"
							value="${mapTotalMoney.eightteenYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry18" name="cyry"
							value="${mapTotalMoney.eightteenYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>
				<tbody id="tb_nineteen" style="display: none">
					<tr>
						<td><input type="text" id="years19" name="years" value="第十九年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze19" name="zcze"
							value="${mapTotalMoney.nineteenYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr19"
							name="xssr" value="${mapTotalMoney.nineteenYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr19" name="yysr"
							value="${mapTotalMoney.nineteenYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje19" name="zxsjje"
							value="${mapTotalMoney.nineteenYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry19" name="cyry"
							value="${mapTotalMoney.nineteenYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>
				<tbody id="tb_twenty" style="display: none">
					<tr>
						<td><input type="text" id="years20" name="years" value="第二十年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze20" name="zcze"
							value="${mapTotalMoney.twentyYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr20"
							name="xssr" value="${mapTotalMoney.twentyYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr20" name="yysr"
							value="${mapTotalMoney.twentyYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje20" name="zxsjje"
							value="${mapTotalMoney.twentyYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry20" name="cyry"
							value="${mapTotalMoney.twentyYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>
				<tbody id="tb_twentyone" style="display: none">
					<tr>
						<td><input type="text" id="years21" name="years" value="第二十一年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze21" name="zcze"
							value="${mapTotalMoney.twentyoneYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr21"
							name="xssr" value="${mapTotalMoney.twentyoneYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr21" name="yysr"
							value="${mapTotalMoney.twentyoneYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje21" name="zxsjje"
							value="${mapTotalMoney.twentyoneYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry21" name="cyry"
							value="${mapTotalMoney.twentyoneYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>
				<tbody id="tb_twentytwo" style="display: none">
					<tr>
						<td><input type="text" id="years22" name="years" value="第二十二年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze22" name="zcze"
							value="${mapTotalMoney.twentytwoYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr22"
							name="xssr" value="${mapTotalMoney.twentytwoYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr22" name="yysr"
							value="${mapTotalMoney.twentytwoYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje22" name="zxsjje"
							value="${mapTotalMoney.twentytwoYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry22" name="cyry"
							value="${mapTotalMoney.twentytwoYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>
				<tbody id="tb_twentythree" style="display: none">
					<tr>
						<td><input type="text" id="years23" name="years" value="第二十三年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze23" name="zcze"
							value="${mapTotalMoney.twentythreeYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr23"
							name="xssr" value="${mapTotalMoney.twentythreeYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr23" name="yysr"
							value="${mapTotalMoney.twentythreeYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje23" name="zxsjje"
							value="${mapTotalMoney.twentythreeYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry23" name="cyry"
							value="${mapTotalMoney.twentythreeYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>
				<tbody id="tb_twentyfour" style="display: none">
					<tr>
						<td><input type="text" id="years24" name="years" value="第二十四年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze24" name="zcze"
							value="${mapTotalMoney.twentyfourYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr24"
							name="xssr" value="${mapTotalMoney.twentyfourYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr24" name="yysr"
							value="${mapTotalMoney.twentyfourYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje24" name="zxsjje"
							value="${mapTotalMoney.twentyfourYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry24" name="cyry"
							value="${mapTotalMoney.twentyfourYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>
				<tbody id="tb_twentyfive" style="display: none">
					<tr>
						<td><input type="text" id="years25" name="years" value="第二十五年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze25" name="zcze"
							value="${mapTotalMoney.twentyfiveYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr25"
							name="xssr" value="${mapTotalMoney.twentyfiveYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr25" name="yysr"
							value="${mapTotalMoney.twentyfiveYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje25" name="zxsjje"
							value="${mapTotalMoney.sixteenYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry25" name="cyry"
							value="${mapTotalMoney.twentyfiveYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>
				<tbody id="tb_twentysix" style="display: none">
					<tr>
						<td><input type="text" id="years26" name="years" value="第二十六年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze26" name="zcze"
							value="${mapTotalMoney.twentysixYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr26"
							name="xssr" value="${mapTotalMoney.twentysixYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr26" name="yysr"
							value="${mapTotalMoney.twentysixYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje26" name="zxsjje"
							value="${mapTotalMoney.twentysixYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry26" name="cyry"
							value="${mapTotalMoney.twentysixYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>
				<tbody id="tb_twentyseven" style="display: none">
					<tr>
						<td><input type="text" id="years27" name="years" value="第二十七年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze27" name="zcze"
							value="${mapTotalMoney.twentysevenYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr27"
							name="xssr" value="${mapTotalMoney.twentysevenYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr27" name="yysr"
							value="${mapTotalMoney.twentysevenYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje27" name="zxsjje"
							value="${mapTotalMoney.twentysevenYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry27" name="cyry"
							value="${mapTotalMoney.twentysevenYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>
				<tbody id="tb_twentyeight" style="display: none">
					<tr>
						<td><input type="text" id="years28" name="years" value="第二十八年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze28" name="zcze"
							value="${mapTotalMoney.twentyeightYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr28"
							name="xssr" value="${mapTotalMoney.twentyeightYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr28" name="yysr"
							value="${mapTotalMoney.twentyeightYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje28" name="zxsjje"
							value="${mapTotalMoney.twentyeightYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry28" name="cyry"
							value="${mapTotalMoney.twentyeightYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>
				<tbody id="tb_twentynine" style="display: none">
					<tr>
						<td><input type="text" id="years29" name="years" value="第二十九年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze29" name="zcze"
							value="${mapTotalMoney.twentynineYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr29"
							name="xssr" value="${mapTotalMoney.twentynineYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr29" name="yysr"
							value="${mapTotalMoney.twentynineYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje29" name="zxsjje"
							value="${mapTotalMoney.twentynineYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry29" name="cyry"
							value="${mapTotalMoney.twentynineYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>
				<tbody id="tb_thirty" style="display: none">
					<tr>
						<td><input type="text" id="years30" name="years" value="第三十年"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zcze30" name="zcze"
							value="${mapTotalMoney.thirtyYear.zcze}"
							onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssr30"
							name="xssr" value="${mapTotalMoney.thirtyYear.xssr}"
							onkeyup="f_money(this);f_countXssr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="yysr30" name="yysr"
							value="${mapTotalMoney.thirtyYear.yysr}"
							onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="zxsjje30" name="zxsjje"
							value="${mapTotalMoney.thirtyYear.zxsjje}"
							onkeyup="f_money(this);f_countZxsjje();" size=13
							style="text-align: right;">万元</td>
						<td><input type="text" id="cyry30" name="cyry"
							value="${mapTotalMoney.thirtyYear.cyry}"
							onkeyup="f_number(this);f_countCyry();" size=5
							style="text-align: right;">人</td>
					</tr>
				</tbody>
				
				
				<tbody id="tb_tzh_money">
					<tr>
						<td><input type="text" id="lastyears" name="lastyears"
							value="最后一年调整后金额" size="22"
							style="text-align: center; border: 0px; font-size: 10;"
							readonly="readonly"></td>
						<td><input type="text" id="zczetzh" name="zczetzh"
							value="${st.zczetzh}" onkeyup="f_money(this);f_countZcze();" size=13
							style="text-align: right;">万元</td>
						<td style="display: none"><input type="text" id="xssrtzh"
							name="xssrtzh" value="${st.xssrtzh}" onkeyup="f_money(this);"
							size=13 style="text-align: right;">万元</td>
						<td><input type="text" id="yysrtzh" name="yysrtzh"
							value="${st.yysrtzh}" onkeyup="f_money(this);f_countYysr();" size=13
							style="text-align: right;">万元</td>
						<td><span style="display: none"><input type="text"
								id="zxsjjetzh" name="zxsjjetzh" value="${st.zxsjjetzh}"
								onkeyup="f_money(this);" size=13 style="text-align: right;">万元</span>
						</td>
						<td><span style="display: none"><input type="text"
								id="cyrytzh" name="cyrytzh" value="" readonly="readonly" size=5
								style="text-align: right;">人</span>
						</td>
					</tr>
				</tbody>

				<tbody id="tb_total" style="display: none">
					<tr>
						<td><input type="text" id="total" name="total" value="合计"
							size="10" style="text-align: center; border: 0px;"
							readonly="readonly"></td>
						<td><input type="text" id="zczetotal" name="zczetotal"
							value="" size=13 style="text-align: right; border: 0px;"
							readonly="readonly">万元</td>
						<td style="display: none"><input type="text" id="xssrtotal"
							name="xssrtotal" value="" size=13
							style="text-align: right; border: 0px;" readonly="readonly">万元</td>
						<td><input type="text" id="yysrtotal" name="yysrtotal"
							value="" size=13 style="text-align: right; border: 0px;"
							readonly="readonly">万元</td>
						<td><input type="text" id="zxsjjetotal" name="zxsjjetotal"
							value="" size=13 style="text-align: right; border: 0px;"
							readonly="readonly">万元</td>
						<td><input type="text" id="cyrytotal" name="cyrytotal"
							value="" size=5 style="text-align: right; border: 0px;"
							readonly="readonly">人</td>
					</tr>
				</tbody>
			</table></td>
	</tr>
	<tbody id="tb_tzh_money2" >
		<tr>
			<td class="data_tb_alignright" style="text-align: left" colspan="5"
				height="16"><span> 审计调整事项 </span></td>
		</tr>
		<tr>
			<td width="20%" height="23" class="data_tb_alignright">资产调增<font	color="#FF0000">&nbsp;[*]</font></td>
			<td width="30%" height="23" class="data_tb_content"><input maxlength="20" id="zctz" value="${st.zctz }" name="zctz" size="20" onkeyup="f_money(this);" class="">万元</td>
			<td width="20%" height="23" class="data_tb_alignright">资产调减<font	color="#FF0000">&nbsp;[*]</font></td>
			<td width="30%" height="23" class="data_tb_content"><input maxlength="20" id="zctj" value="${st.zctj }" name="zctj" size="20" onkeyup="f_money(this);" class="">万元</td>
		</tr>
		<tr>
			<td width="20%" height="23" class="data_tb_alignright">利润调增<font	color="#FF0000">&nbsp;[*]</font></td>
			<td width="30%" height="23" class="data_tb_content"><input maxlength="20" id="lrtz" value="${st.lrtz }" name="lrtz" size="20" onkeyup="f_money(this);" class="">万元</td>
			<td width="20%" height="23" class="data_tb_alignright">利润调减<font	color="#FF0000">&nbsp;[*]</font>		</td>
			<td width="30%" height="23" class="data_tb_content"><input maxlength="20" id="lrtj" value="${st.lrtj }" name="lrtj" size="20" onkeyup="f_money(this);" class="">万元</td>
		</tr>
		<tr>
			<td width="20%" height="23" class="data_tb_alignright">税收调增<font	color="#FF0000">&nbsp;[*]</font></td>
			<td width="30%" height="23" class="data_tb_content"><input maxlength="20" id="sstz" value="${st.sstz }" name="sstz" size="20" onkeyup="f_money(this);" class="">万元</td>
			<td width="20%" height="23" class="data_tb_alignright">税收调减<font	color="#FF0000">&nbsp;[*]</font></td>
			<td width="30%" height="23" class="data_tb_content"><input maxlength="20" id="sstj" value="${st.sstj }" name="sstj" size="20" onkeyup="f_money(this);" class="">万元</td>
		</tr>
		<tr>
			<td width="20%" height="23" class="data_tb_alignright">防止国有资产流失金额<font	color="#FF0000">&nbsp;[*]</font></td>
			<td width="30%" height="23" colspan="3" class="data_tb_content"><input maxlength="20" id="fzgyzclsje" value="${st.fzgyzclsje }" name="fzgyzclsje" size="20" onkeyup="f_money(this);" class="">万元</td>
		</tr>
	</tbody>
</table>

<script type="text/javascript">
var $sjlx = $("#sjlx").val();
/* 
if($sjlx=="年报审计"){
	$("#bgnd").attr("noinput","true");
} */
//审计类型 为年报审计时
function sjlxChange(){
	var $sjlx = $("#sjlx").val();
	$("#bgnd").attr("readOnly",false);
	$("#setBgndImg").css("display","none");
	/* if($sjlx=="年报审计"){
		$("#bgnd").val(new Date().getYear()+"年度");
		$("#bgnd").attr("noinput","true");
	}else  */
	if($sjlx=="月财务报表审计"){
		$("#bgnd").val("");
		//$("#bgnd").attr("readOnly",true);
		$("#setBgndImg").css("display","");
	}else{
		$("#bgnd").val("");
		$("#bgnd").attr("noinput","false");
	}
	
}

if($sjlx=="月财务报表审计"){
	//$("#bgnd").attr("readOnly",true);
	$("#setBgndImg").css("display","");
}

var sjns = "${st.sjns}";
if(sjns==""){
	document.getElementById("sjns").value = "一年";
}

var years_array = ["years1","years2","years3","years4","years5","years6","years7","years8","years9","years10",
	"years11","years12","years13","years14","years15","years16","years17","years18","years19","years20",
	"years21","years22","years23","years24","years25","years26","years27","years28","years29","years30"];
	
var zcze_array = ["zcze1","zcze2","zcze3","zcze4","zcze5","zcze6","zcze7","zcze8","zcze9","zcze10",
	"zcze11","zcze12","zcze13","zcze14","zcze15","zcze16","zcze17","zcze18","zcze19","zcze20",
	"zcze21","zcze22","zcze23","zcze24","zcze25","zcze26","zcze27","zcze28","zcze29","zcze30"];
	
var xssr_array = ["xssr1","xssr2","xssr3","xssr4","xssr5","xssr6","xssr7","xssr8","xssr9","xssr10",
	"xssr11","xssr12","xssr13","xssr14","xssr15","xssr16","xssr17","xssr18","xssr19","xssr20",
	"xssr21","xssr22","xssr23","xssr24","xssr25","xssr26","xssr27","xssr28","xssr29","xssr30"];
	
var yysr_array = ["yysr1","yysr2","yysr3","yysr4","yysr5","yysr6","yysr7","yysr8","yysr9","yysr10",
	"yysr11","yysr12","yysr13","yysr14","yysr15","yysr16","yysr17","yysr18","yysr19","yysr20",
	"yysr21","yysr22","yysr23","yysr24","yysr25","yysr26","yysr27","yysr28","yysr29","yysr30"];
	
var zxsjje_array = ["zxsjje1","zxsjje2","zxsjje3","zxsjje4","zxsjje5","zxsjje6","zxsjje7","zxsjje8","zxsjje9","zxsjje10",
	"zxsjje11","zxsjje12","zxsjje13","zxsjje14","zxsjje15","zxsjje16","zxsjje17","zxsjje18","zxsjje19","zxsjje20",
	"zxsjje21","zxsjje22","zxsjje23","zxsjje24","zxsjje25","zxsjje26","zxsjje27","zxsjje28","zxsjje29","zxsjje30"];
	
var cyry_array = ["cyry1","cyry2","cyry3","cyry4","cyry5","cyry6","cyry7","cyry8","cyry9","cyry10",
	"cyry11","cyry12","cyry13","cyry14","cyry15","cyry16","cyry17","cyry18","cyry19","cyry20",
	"cyry21","cyry22","cyry23","cyry24","cyry25","cyry26","cyry27","cyry28","cyry29","cyry30"];

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

// 初始化 0 的金额
var sj_money_arrays = ["zcze1","zcze2","zcze3","zcze4","zcze5","zcze6","zcze7","zcze8","zcze9","zcze10",
	"zcze11","zcze12","zcze13","zcze14","zcze15","zcze16","zcze17","zcze18","zcze19","zcze20",
	"zcze21","zcze22","zcze23","zcze24","zcze25","zcze26","zcze27","zcze28","zcze29","zcze30",
	"xssr1","xssr2","xssr3","xssr4","xssr5","xssr6","xssr7","xssr8","xssr9","xssr10",
	"xssr11","xssr12","xssr13","xssr14","xssr15","xssr16","xssr17","xssr18","xssr19","xssr20",
	"xssr21","xssr22","xssr23","xssr24","xssr25","xssr26","xssr27","xssr28","xssr29","xssr30",
	"yysr1","yysr2","yysr3","yysr4","yysr5","yysr6","yysr7","yysr8","yysr9","yysr10",
	"yysr11","yysr12","yysr13","yysr14","yysr15","yysr16","yysr17","yysr18","yysr19","yysr20",
	"yysr21","yysr22","yysr23","yysr24","yysr25","yysr26","yysr27","yysr28","yysr29","yysr30",
	"zxsjje1","zxsjje2","zxsjje3","zxsjje4","zxsjje5","zxsjje6","zxsjje7","zxsjje8","zxsjje9",
	"zxsjje11","zxsjje12","zxsjje13","zxsjje14","zxsjje15","zxsjje16","zxsjje17","zxsjje18","zxsjje19","zxsjje20",
	"zxsjje21","zxsjje22","zxsjje23","zxsjje24","zxsjje25","zxsjje26","zxsjje27","zxsjje28","zxsjje29","zxsjje30",
	"cyry1","cyry2","cyry3","cyry4","cyry5","cyry6","cyry7","cyry8","cyry9","cyry10",
	"cyry11","cyry12","cyry13","cyry14","cyry15","cyry16","cyry17","cyry18","cyry19","cyry20",
	"cyry21","cyry22","cyry23","cyry24","cyry25","cyry26","cyry27","cyry28","cyry29","cyry30"];
					   
var fzxsj_en_money_arrays = ["zcze1","zcze2","zcze3","zcze4","zcze5","zcze6","zcze7","zcze8","zcze9","zcze10",
	"zcze11","zcze12","zcze13","zcze14","zcze15","zcze16","zcze17","zcze18","zcze19","zcze20",
	"zcze21","zcze22","zcze23","zcze24","zcze25","zcze26","zcze27","zcze28","zcze29","zcze30",
	"xssr1","xssr2","xssr3","xssr4","xssr5","xssr6","xssr7","xssr8","xssr9","xssr10",
	"xssr11","xssr12","xssr13","xssr14","xssr15","xssr16","xssr17","xssr18","xssr19","xssr20",
	"xssr21","xssr22","xssr23","xssr24","xssr25","xssr26","xssr27","xssr28","xssr29","xssr30",
	"yysr1","yysr2","yysr3","yysr4","yysr5","yysr6","yysr7","yysr8","yysr9","yysr10",
	"yysr11","yysr12","yysr13","yysr14","yysr15","yysr16","yysr17","yysr18","yysr19","yysr20",
	"yysr21","yysr22","yysr23","yysr24","yysr25","yysr26","yysr27","yysr28","yysr29","yysr30"];
						   
var fzxsj_ch_money_arrays = ["第1年资产总额","第2年资产总额","第3年资产总额","第4年资产总额","第5年资产总额","第6年资产总额","第7年资产总额","第8年资产总额","第9年资产总额","第10年资产总额",
	"第11年资产总额","第12年资产总额","第13年资产总额","第14年资产总额","第15年资产总额","第16年资产总额","第17年资产总额","第18年资产总额","第19年资产总额","第20年资产总额",
	"第21年资产总额","第22年资产总额","第23年资产总额","第24年资产总额","第25年资产总额","第26年资产总额","第27年资产总额","第28年资产总额","第29年资产总额","第30年资产总额",
	"第1年销售收入","第2年销售收入","第3年销售收入","第4年销售收入","第5年销售收入","第6年销售收入","第7年销售收入","第8年销售收入","第9年销售收入","第10年销售收入",
	"第11年销售收入","第12年销售收入","第13年销售收入","第14年销售收入","第15年销售收入","第16年销售收入","第17年销售收入","第18年销售收入","第19年销售收入","第20年销售收入",
	"第21年销售收入","第22年销售收入","第23年销售收入","第24年销售收入","第25年销售收入","第26年销售收入","第27年销售收入","第28年销售收入","第29年销售收入","第30年销售收入",
	"第1年营业收入","第2年营业收入","第3年营业收入","第4年营业收入","第5年营业收入","第6年营业收入","第7年营业收入","第8年营业收入","第9年营业收入","第10年营业收入",
	"第11年营业收入","第12年营业收入","第13年营业收入","第14年营业收入","第15年营业收入","第16年营业收入","第17年营业收入","第18年营业收入","第19年营业收入","第20年营业收入",
	"第21年营业收入","第22年营业收入","第23年营业收入","第24年营业收入","第25年营业收入","第26年营业收入","第27年营业收入","第28年营业收入","第29年营业收入","第30年营业收入",];
					   
// 初始化0					   
// f_initZero(sj_money_arrays);

// 是否调整金额：默认为否
var sftzje = "${st.sftzje}";
if(sftzje == ""){
	document.getElementById("sftzje").value = "否";
	document.getElementById("tb_tzh_money").style.display = "none";
	document.getElementById("tb_tzh_money2").style.display = "none";
}else{
	f_display_tzh_money();
}

// 调整后金额
function f_display_tzh_money(){
	var sftzje = document.getElementById("sftzje").value;
	
	//zctz,zctj,lrtz,lrtj,sstz,sstj,fzgyzclsje
	var arr = ["zctz","zctj","lrtz","lrtj","sstz","sstj","fzgyzclsje"];
	for(i=0;i<arr.length;i++){
		if(sftzje=="是"){
			document.getElementById(arr[i]).className="required";//obj.className = "required";
		}else{
			document.getElementById(arr[i]).className="";
			document.getElementById(arr[i]).value="";
		}
	}
	
	if(sftzje=="是"){
		document.getElementById("tb_tzh_money").style.display = "";
		document.getElementById("tb_tzh_money2").style.display = "";
	}else{
		document.getElementById("tb_tzh_money").style.display = "none";
		document.getElementById("tb_tzh_money2").style.display = "none";
	}
}

// 检查调整后金额之和大于零
function f_check_tzh_money(){
	var sftzje = document.getElementById("sftzje").value;
	if(sftzje=="是"){
		var sjlx = document.getElementById("sjlx").value;
		/*if(sjlx=="专项审计"){
			// 专项审计金额调整后
			var zxsjjetzh = document.getElementById("zxsjjetzh").value*1;
			if(zxsjjetzh<=0){
				setTab('search','nre');
				document.getElementById("zxsjjetzh").select();
				alert("专项审计报备类型的调整后专项审计金额必须大于0！");
				return "notAlert";
			}
		}else*/ if(sjlx=="经济责任审计"){
			// 资产总金额调整后
			var zczetzh = document.getElementById("zczetzh").value;
			if(zczetzh==""){
				setTab('search','nre');
				document.getElementById("zczetzh").select();
				alert("经济责任审计报备类型的调整后资产总额不能为空！");
				return "notAlert";
			}
			zczetzh = zczetzh*1;
			
			// 销售收入调整后
			var xssrtzh = document.getElementById("xssrtzh").value;
			if(xssrtzh==""){
				setTab('search','nre');
				document.getElementById("xssrtzh").select();
				alert("经济责任审计报备类型的调整后销售收入不能为空！");
				return "notAlert";
			}
			xssrtzh = xssrtzh*1;
			
			if((zczetzh*1+xssrtzh*1)<=0){
				setTab('search','nre');
				document.getElementById("zczetzh").select();
				alert("经济责任审计报备类型的调整后资产总额、调整后销售收入之和必须大于0！");
				return "notAlert";
			}
		}else{
			// 资产总金额调整后
			var zczetzh = document.getElementById("zczetzh").value;
			if(zczetzh==""){
				setTab('search','nre');
				document.getElementById("zczetzh").select();
				alert(sjlx+"报备类型的调整后资产总额不能为空！");
				return "notAlert";
			}
			zczetzh = zczetzh*1;
			
			// 销售收入调整后
			
			/*
			var xssrtzh = document.getElementById("xssrtzh").value;
			
			if(xssrtzh==""){
				setTab('search','nre');
				document.getElementById("xssrtzh").select();
				alert(sjlx+"报备类型的调整后销售收入不能为空！");
				return "notAlert";
			}
			
			xssrtzh = xssrtzh*1;
			*/
			
			// 营业收入调整后
			var yysrtzh = document.getElementById("yysrtzh").value;
			if(yysrtzh==""){
				setTab('search','nre');
				document.getElementById("yysrtzh").select();
				alert(sjlx+"报备类型的调整后营业收入不能为空！");
				return "notAlert";
			}
			yysrtzh = yysrtzh*1;
			
			//if((zczetzh*1+xssrtzh*1+yysrtzh*1)<=0){
			if((zczetzh*1+yysrtzh*1)<=0){
				setTab('search','nre');
				document.getElementById("zczetzh").select();
				alert(sjlx+"报备类型的调整后资产总额、调整后营业收入之和必须大于0！");
				return "notAlert";
			}
		}
		
	}
	return "OK";
}

// 计算年数
function f_calcYear(){
	var yeasArray = ["一年","二年","三年","四年","五年","六年","七年","八年","九年","十年","十一年","十二年","十三年","十四年","十五年",
		"十六年","十七年","十八年","十九年","二十年","二十一年","二十二年","二十三年","二十四年","二十五年","二十六年","二十七年","二十八年","二十九年","三十年"];
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

// 验证应收业务费金额
function f_checkMoney(isCount,wjjsfbz){
	// 审计类型
	var sjlxValue = document.getElementById("sjlx").value;
	if(sjlxValue==""){
		setTab('search','nre');
		document.getElementById("sjlx").select();
		return "notAlert";
	}
	
	// isyqyyw=1 已签约业务：从OA 导入进来的 报备数据，直接是审核通过状态了。
	var isyqyyw = "${at.isyqyyw}";
	
	// 计算年 
	var years = f_calcYear();
	
	// 数据库 7 折价
	var discountBySeven = 0;
	
	// 标准金额
	var standerPrice = 0;
	
	if(sjlxValue=="专项审计"){
		for(var i=1;i<=years;i++){
			var everyYearMoney = f_judgeOneMoney_year(i);
			if(everyYearMoney<=0){
				var bbState = "${ct.bbstate}";
				if(bbState!="审核通过" || isyqyyw=="1"){
					setTab('search','nre');
					document.getElementById("zxsjje"+i).select();
					alert("第"+i+"年专项审计类型分类下专项审计金额必须大于0！");
					return "notAlert";
				}
			} 
		}		
		
		// 广州、珠海、佛山、东莞、中山、江门、深圳
		var area = "${userSession.userMap.area}";
		var ywarea = document.getElementById("ywarea").value;
		
		// 物价局收费标准：直接提示标准价
		if(wjjsfbz=="wjjsfbz"){
			var standerMoney = 0;
			//  先循环 设置好 标准金额 和 7折金额
			for(var i=1;i<=years;i++){
				var ysywfCountTemp = f_judgeOneMoney_year(i);
				var moneyArray = f_checkMoneyStandard(ysywfCountTemp,"sj003");
				standerMoney = standerMoney*1 + moneyArray[1]*1;
			}
			return "发改委、财政厅收费标准价为："+standerMoney.toFixed(2)+" 元!";
		}else{
		
			if((bbState!="审核通过" && wjjsfbz!="wjjsfbz") || isyqyyw=="1"){
				var cyry = f_get_cyry_lastYear();
				/*
				if(cyry*1<=0){
					setTab('search','nre');
					document.getElementById("cyry"+years).select();
					alert("第"+years+"年从业人员必须大于0！");
					return "notAlert";
				}
				*/
			}
			
							
			//  先循环 设置好 标准金额 和 7折金额
			for(var i=1;i<=years;i++){
				var ysywfCountTemp = f_judgeOneMoney_year(i);
				
				// 设置多年中的每一年的 7 折价和标准价
				// f_setStanderPrice(ysywfCountTemp,"sj001");
				
				// 改成：专项审计的计算公式与经济责任审计计算公式一样
				f_setStanderPrice(ysywfCountTemp,"sj003");
				
				discountBySeven = discountBySeven*1 + document.getElementById("discountBySeven").value*1;
				standerPrice = standerPrice*1 + document.getElementById("standerPrice").value*1;
			}
			
			document.getElementById("discountBySeven").value = discountBySeven;
			document.getElementById("standerPrice").value = standerPrice;
			
			/* 
			 *审计 和 清算审计另外在自己的jsp里面设置标准价：他们需要用多年的标准价的加总和进行计算。
			 *f_returnInfo方法中直接document获取设置好的标准价,f_returnInfo方法的第一个参数不会被使用，第二个参数也不会被使用
			 */
			return f_returnInfo(0,"sj001",isCount,"审计");
		}
	//}else if(sjlxValue=="年报审计"){//年报审计		
		
	}else{
		for(var i=1;i<=years;i++){
			var everyYearMoney = 0;
			/*
			if(sjlxValue=="经济责任审计"){
				everyYearMoney = f_get_zcze_xssr_total(i);
			}else{
				everyYearMoney = f_get_zcze_xssr_yysr_total(i);
			}*/
			everyYearMoney = f_get_zcze_xssr_yysr_total(i);
			
			if((everyYearMoney)<=0){
				if(bbState!="审核通过" || isyqyyw=="1"){
					setTab('search','nre');
					document.getElementById("zcze"+i).select();
					
					if(sjlxValue=="经济责任审计"){
						//alert("第"+i+"年资产总额、销售收入加总和必须大于0！");
						alert("第"+i+"年资产总额、营业收入加总和必须大于0！");
					}else{
						//alert("第"+i+"年资产总额、销售收入、营业收入加总和必须大于0！");
						alert("第"+i+"年资产总额、营业收入加总和必须大于0！");
					}
					
					return "notAlert";
				}
			}
		}
		
		// 金额不能为空
		if(!f_checkNull()){
			return "notAlert";
		}
		
		// 广州、珠海、佛山、东莞、中山、江门、深圳
		var area = "${userSession.userMap.area}";
		var ywarea = document.getElementById("ywarea").value;
		
		// 物价局收费标准：直接提示标准价
		if(wjjsfbz=="wjjsfbz"){
			//var zsjMoney = 0;
			//var fzsjMoney = 0;
			var  money = 0;
			var moneyArray = [0,0];
			//  先循环 计算 标准金额 
			for(var i=1;i<=years;i++){
				/*
				if(sjlxValue=="经济责任审计"){
					ysywfCountTemp = f_get_zcze_xssr_year(i);
				}else{
					ysywfCountTemp = f_get_zcze_xssr_yysr_year(i);
				}*/
				ysywfCountTemp = f_get_zcze_xssr_yysr_year(i);				
				
				// 设置多年中的每一年的 7 折价和标准价
				if(sjlxValue=="其他非盈利组织审计" || sjlxValue=="学校审计" || sjlxValue=="医院审计"){
					moneyArray = f_checkMoneyStandard(ysywfCountTemp,"sj002");
				}else if(sjlxValue=="经济责任审计"){
					moneyArray = f_checkMoneyStandard(ysywfCountTemp,"sj003");
				}else{
					moneyArray = f_checkMoneyStandard(ysywfCountTemp,"sj001");
				}
				//zsjMoney = zsjMoney*1 + moneyArray[1]*1;
				//fzsjMoney = fzsjMoney*1 + moneyArray[0]*1;
				money = money*1 + moneyArray[1]*1;				
			}
			//if(f_sfzsj(area,ywarea)){
				//return "物价局收费标准价为："+zsjMoney.toFixed(2)+" 元!";
			//}else{
				//return "物价局收费标准价为："+fzsjMoney.toFixed(2)+" 元!";
			//}
			
			return "发改委、财政厅收费标准价为："+money.toFixed(2)+" 元!";
		}else{
			
			if((bbState!="审核通过" && wjjsfbz!="wjjsfbz") || isyqyyw=="1"){
				var cyry = f_get_cyry_lastYear();
				/*
				if(cyry*1<=0){
					setTab('search','nre');
					document.getElementById("cyry"+years).select();
					alert("第"+years+"年从业人员必须大于0！");
					return "notAlert";
				}
				*/
			}			
			
			//  先循环 设置好 标准金额 和 7折金额
			var ysywfCountTemp = "0";
			for(var i=1;i<=years;i++){
				/*
				if(sjlxValue=="经济责任审计"){
					ysywfCountTemp = f_get_zcze_xssr_year(i);
				}else{
					ysywfCountTemp = f_get_zcze_xssr_yysr_year(i);
				}
				*/
				ysywfCountTemp = f_get_zcze_xssr_yysr_year(i);
				
				// 设置多年中的每一年的 7 折价和标准价
				if(sjlxValue=="其他非盈利组织审计" || sjlxValue=="学校审计" || sjlxValue=="医院审计"){
					f_setStanderPrice(ysywfCountTemp,"sj002");
				}else if(sjlxValue=="经济责任审计"){
					f_setStanderPrice(ysywfCountTemp,"sj003");
				}else{
					f_setStanderPrice(ysywfCountTemp,"sj001");
				}
				discountBySeven = discountBySeven*1 + document.getElementById("discountBySeven").value*1;
				standerPrice = standerPrice*1 + document.getElementById("standerPrice").value*1;
			}
			document.getElementById("discountBySeven").value = discountBySeven;
			document.getElementById("standerPrice").value = standerPrice;
						
			/* 
			 *审计 和 清算审计另外在自己的jsp里面设置标准价：他们需要用多年的标准价的加总和进行计算。
			 *f_returnInfo方法中直接document获取设置好的标准价,f_returnInfo方法的第一个参数不会被使用，第二个参数也不会被使用
			 */
			return f_returnInfo(0,"sj001",isCount,"审计");
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

// 验证数字
function f_number(t){
	t.value = t.value.replace(/[^\d]/g,'');
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
		var year_array = ["一年","二年","三年","四年","五年","六年","七年","八年","九年","十年","十一年","十二年","十三年","十四年","十五年",
			"十六年","十七年","十八年","十九年","二十年","二十一年","二十二年","二十三年","二十四年","二十五年","二十六年","二十七年","二十八年","二十九年","三十年"];
		
		var tb_array = ["tb_one","tb_two","tb_three","tb_four","tb_five","tb_six","tb_seven","tb_eight","tb_nine",
			"tb_ten","tb_eleven","tb_twelve","tb_thirteen","tb_fourteen","tb_fifteen","tb_sixteen","tb_seventeen","tb_eightteen","tb_nineteen","tb_twenty",
			"tb_twentyone","tb_twentytwo","tb_twentythree","tb_twentyfour","tb_twentyfive","tb_twentysix","tb_twentyseven","tb_twentyeight","tb_twentynine","tb_thirty"];
		
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

// 资产总额合计
function f_countZcze(){
	if(zcze_array){
		var zczetotal = 0;
		var yearlen = f_calcYear();
		for(var i=0;i<zcze_array.length;i++){
			if(document.getElementById(zcze_array[i])){
				var las = i*1+1;
				if(las==yearlen && document.getElementById("sftzje").value == "是"){		//如果是调整后金额，则替换最后一年金额
					zczetotal = f_addNum(zczetotal*1,document.getElementById("zczetzh").value*1);
				}else{
					zczetotal = f_addNum(zczetotal*1,document.getElementById(zcze_array[i]).value*1);
				}
			}
		}
		var lengths = f_getPointLength(zczetotal);
		zczetotal = zczetotal.toFixed(lengths);
		document.getElementById("zczetotal").value = zczetotal;
	}
};

// 销售收入合计
function f_countXssr(){
	if(xssr_array){
		var xssrtotal = 0;
		for(var i=0;i<xssr_array.length;i++){
			if(document.getElementById(xssr_array[i])){
				xssrtotal = f_addNum(xssrtotal*1,document.getElementById(xssr_array[i]).value*1);
			}
		}
		var lengths = f_getPointLength(xssrtotal);
		xssrtotal = xssrtotal.toFixed(lengths);
		document.getElementById("xssrtotal").value = xssrtotal;
	}
};

// 营业收入合计
function f_countYysr(){
	if(yysr_array){
		var yysrtotal = 0;
		var yearlen = f_calcYear();
		for(var i=0;i<yysr_array.length;i++){
			if(document.getElementById(yysr_array[i])){
				var las = i*1+1;
				if(las==yearlen && document.getElementById("sftzje").value == "是"){		//如果是调整后金额，则替换最后一年金额
					yysrtotal = f_addNum(yysrtotal*1,document.getElementById("yysrtzh").value*1);
				}else{
					yysrtotal = f_addNum(yysrtotal*1,document.getElementById(yysr_array[i]).value*1);
				}
			}
		}
		var lengths = f_getPointLength(yysrtotal);
		yysrtotal = yysrtotal.toFixed(lengths);
		document.getElementById("yysrtotal").value = yysrtotal;
	}
};

// 专项审计合计
function f_countZxsjje(){
	if(zxsjje_array){
		var zxsjjetotal = 0;
		for(var i=0;i<zxsjje_array.length;i++){
			if(document.getElementById(zxsjje_array[i])){
				zxsjjetotal = f_addNum(zxsjjetotal*1,document.getElementById(zxsjje_array[i]).value*1);
			}
		}
		var lengths = f_getPointLength(zxsjjetotal);
		zxsjjetotal = zxsjjetotal.toFixed(lengths);
		document.getElementById("zxsjjetotal").value = zxsjjetotal;
	}
};

// 从业人员合计
function f_countCyry(){
	if(cyry_array){
		var cyrytotal = 0;
		for(var i=0;i<cyry_array.length;i++){
			if(document.getElementById(cyry_array[i])){
				cyrytotal = cyrytotal*1 + document.getElementById(cyry_array[i]).value*1;
			}
		}
		document.getElementById("cyrytotal").value = cyrytotal;
	}
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


// 销售收入、营业收入、资产总额之和必须大于0
function f_judgeThreeMoney(){
	var xssrMoney = 0;
	var yysrMoney = 0;
	var zczeMoney = 0;
	for(var i=0;i<zcze_array.length;i++){
		if(document.getElementById(zcze_array[i])){
			xssrMoney = xssrMoney*1 + document.getElementById(xssr_array[i]).value*1;
			yysrMoney = yysrMoney*1 + document.getElementById(yysr_array[i]).value*1;
			zczeMoney = zczeMoney*1 + document.getElementById(zcze_array[i]).value*1;
		}
	}
	var totalMoney = xssrMoney*1 + yysrMoney*1 + zczeMoney*1;
	return totalMoney;
}


// 专项审计类型分类下专项审计金额必须大于0
function f_judgeOneMoney(){
	var zxsjjeMoney = f_getMoneyFromArray(zxsjje_array);
	return zxsjjeMoney;
}


// 专项审计类型分类下专项审计金额必须大于0 :根据年	
function f_judgeOneMoney_year(year){
	var zxsjje_array_temp = [zxsjje_array[year-1]];
	var zxsjjeMoney = f_getMoneyFromArray(zxsjje_array_temp);
	return zxsjjeMoney*1;
}


// 资产总额与销售收入中取其大者			
function f_get_zcze_xssr(){
	var zczeMoney = f_getMoneyFromArray(zcze_array);
	
	var xssrMoney = f_getMoneyFromArray(xssr_array);
	
	return zczeMoney<xssrMoney?xssrMoney:zczeMoney;
}		

// 资产总额与销售收入中取其大者	：根据年		 
function f_get_zcze_xssr_year(year){
	var zcze_array_temp = [zcze_array[year-1]];
	var zczeMoney = f_getMoneyFromArray(zcze_array_temp);
	
	var xssr_array_temp = [xssr_array[year-1]];
	var xssrMoney = f_getMoneyFromArray(xssr_array_temp);
	
	return zczeMoney<xssrMoney?xssrMoney:zczeMoney;
}		


// 资产总额与(销售收入+营业收入)中取其大者			
function f_get_zcze_xssr_yysr(){
	var zczeMoney = f_getMoneyFromArray(zcze_array);
	
	var xssrMoney = f_getMoneyFromArray(xssr_array);
	
	var yysrMoney = f_getMoneyFromArray(yysr_array);
	
	return (xssrMoney*1+yysrMoney*1)<zczeMoney*1?zczeMoney:(xssrMoney*1+yysrMoney*1);	
}


// 资产总额与(销售收入+营业收入)中取其大者 ：根据年		
function f_get_zcze_xssr_yysr_year(year){
	var zcze_array_temp = [zcze_array[year-1]];
	var zczeMoney = f_getMoneyFromArray(zcze_array_temp);
	
	var xssr_array_temp = [xssr_array[year-1]];
	var xssrMoney = f_getMoneyFromArray(xssr_array_temp);
	
	var yysr_array_temp = [yysr_array[year-1]];
	var yysrMoney = f_getMoneyFromArray(yysr_array_temp);
	
	return (xssrMoney*1+yysrMoney*1)<zczeMoney*1?zczeMoney:(xssrMoney*1+yysrMoney*1);	
}


// 资产总额与(销售收入+营业收入)中取其总和 ：根据年		
function f_get_zcze_xssr_yysr_total(year){
	var zcze_array_temp = [zcze_array[year-1]];
	var zczeMoney = f_getMoneyFromArray(zcze_array_temp);
	
	var xssr_array_temp = [xssr_array[year-1]];
	var xssrMoney = f_getMoneyFromArray(xssr_array_temp);
	
	var yysr_array_temp = [yysr_array[year-1]];
	var yysrMoney = f_getMoneyFromArray(yysr_array_temp);
	
	return zczeMoney*1 + xssrMoney*1 + yysrMoney*1;	
}


// 资产总额与销售收入中取其总和 ：根据年		
function f_get_zcze_xssr_total(year){
	var zcze_array_temp = [zcze_array[year-1]];
	var zczeMoney = f_getMoneyFromArray(zcze_array_temp);
	
	var xssr_array_temp = [xssr_array[year-1]];
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

// 从数组对象中计算总金额
function f_getMoneyFromArray(array){
	var money = 0;
	if(array){
		for(var i=0;i<array.length;i++){
			if(document.getElementById(array[i])){
				money = f_addNum(money*1,document.getElementById(array[i]).value*1);
			}
		}
	}
	return money;
}

// 检查不能为空
function f_checkNull(){
	// 审计类型
	var sjlxValue = document.getElementById("sjlx").value;
	// 计算年 
	var years = f_calcYear();
	for(var i=1;i<=years;i++){
		var zczeRS = f_checkSingleNull(i,"zcze","资产总额");
		if(zczeRS){
			//var xssrRS = f_checkSingleNull(i,"xssr","销售收入");
			var xssrRS = f_checkSingleNull(i,"yysr","营业收入");
			if(xssrRS){
				if(sjlxValue!="经济责任审计" && sjlxValue!="专项审计"){
					var yysrRS = f_checkSingleNull(i,"yysr","营业收入");
					if(!yysrRS){
						return false;
					}
				}
			}else{
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

document.getElementById('zcze2').readonly="";

function isQtzxsj(){
	var sjlx = document.getElementById("sjlx").value;
	if(sjlx=="其他专项审计"){
		alert("注意：\"合并、分立、清算审计请直接在上级菜单报备。\"");		
	}
		
	if(sjlx=="年报审计" || sjlx=="一季度报表审计" || sjlx=="半年度报表审计" || sjlx=="前三个季度报表审计" || sjlx=="财务报表审阅" || sjlx=="月财务报表审计" || sjlx=="合并报表审计"){
		document.getElementById("sjbgyjlx").value="";
		document.getElementById("sjbgyjlx").refer='0';
	}else{
		document.getElementById("sjbgyjlx").value="不适用";
		document.getElementById("sjbgyjlx").refer='1';
	}
}

if($sjlx!="年报审计" && $sjlx!="一季度报表审计" && $sjlx!="半年度报表审计" && $sjlx!="前三个季度报表审计" && $sjlx!="财务报表审阅" && $sjlx!="月财务报表审计" && $sjlx!="合并报表审计"){
	document.getElementById("sjbgyjlx").refer='1';
}

//计算收费标准
function getChargeStandard(){
	var type = document.getElementById("sjlx").value;
	
	if(type == ""){
		setTab('search','nre');
		document.getElementById("sjlx").select();
		return "N";
	}
	
	if(type=="合并报表审计")
		type='年报审计';
	
	/*
	if(type == "其他专项审计"){
		alert("审计类型为\"其他专项审计\",不能直接报备完成，请申请审核！");
		return "N";
	} */
	
	var zczetotal = document.getElementById("zczetotal").value*1;
	var yysrtotal = document.getElementById("yysrtotal").value*1;
	var zxsjjetotal = document.getElementById("zxsjjetotal").value*1;
	var zcze1 = document.getElementById("zcze1").value;
	var yysr1 = document.getElementById("yysr1").value;
	var zxsjje1 = document.getElementById("zxsjje1").value;
	
	if(!f_checkNull()){
		return "N";
	}
	
	if(type!="其他专项审计"){
		if((zczetotal+yysrtotal+zxsjjetotal)==0){
			setTab('search','nre');
			document.getElementById("zcze1").select();
			alert("第一年的资产总额、营业收入、专项审计金额之和必须大于0!");
			return "N";
		}
	}
	
	/*
	else if(zcze1==""){
		setTab('search','nre');
		document.getElementById("zcze1").select();
		alert("第一年的资产总额不能为空!");
		return "N";
	}else if(yysr1==""){
		setTab('search','nre');
		document.getElementById("yysr1").select();
		alert("第一年的营业收入不能为空!");
		return "N";
	}*/
	
	var zcze = 0;
	if(zxsjjetotal>0){
		zcze = zxsjjetotal;
	}else{
		zcze = zczetotal>yysrtotal ? zczetotal : yysrtotal;
	}
	var year = f_calcYear();
	var url="${pageContext.request.contextPath}/common/content.do?method=getChargeStandard";
	var request = "&type="+type+"&zcze="+zcze+"&kind=1&year="+year+"&hour=0";
	var resText = ajaxLoadPageSynch(url,request);
	return resText;
}

//如果是月财务报表则要执行该方法选择报表区间
function editBgnd(){
	document.getElementById("sjbgndDiv").style.display = "";
	document.getElementById("divBlock2").style.display = "";
}
//
function f_sure(){
	var nf = $("#nf").val();
	var cyf = $("#cyf").val();
	var dnf = $("#dnf").val();
	var dyf = $("#dyf").val();
	
	if(nf==""){
		alert("从年度不能为空！");
		$("#nf").select();
		return;
	}else if(cyf==""){
		alert("从月份不能为空！");
		$("#cyf").select();
		return;
	}else if(dnf==""){
		alert("到年度不能为空！");
		$("#dnf").select();
		return;
	}else if(dyf==""){
		alert("到月份不能为空！");
		$("#dyf").select();
		return;
	}
	
	$("#bgnd").val(nf+"年"+cyf+"月到"+dnf+"年"+dyf+"月");
	document.getElementById("sjbgndDiv").style.display = "none";
	document.getElementById("divBlock2").style.display = "none";
}

//
function f_cancle(){
	document.getElementById("sjbgndDiv").style.display = "none";
	document.getElementById("divBlock2").style.display = "none";
}

//备用，之前用来拼接区间使用的
function setBgnd(t){
	
}

//检查年份月份（从的年份要小于等于到的年份,年份相等时到的月份要大于等于从的月份）
function checkNfAndYf(){
	//"nf","cyf","dnf","dyf"
	if($("#dnf").val()!="" && $("#nf").val()>$("#dnf").val()){
		alert("请检查年份，后者不能小于前者！");
		$("#dnf").val("");
		$("#dnf").select();
	}else if($("#dyf").val()!="" && $("#nf").val()==$("#dnf").val() && $("#cyf").val()*1>$("#dyf").val()*1){
		
		alert("请检查月份，年份相同时后者月份不能小于前者月份！");
		$("#dyf").val("");
		$("#dyf").select();
	}
	
	if($("#nf").val()==$("#dnf").val()){
		if($("#cyf").val()=='1' && $("#dyf").val()=='3'){
			alert("该区间应该选择审计类型为【一季度报表审计】");
			$("#dyf").val("");
			$("#dyf").select();
		}else if($("#cyf").val()=='1' && $("#dyf").val()=='6'){
			alert("该区间应该选择审计类型为【半年度报表审计】");
			$("#dyf").val("");
			$("#dyf").select();
		}else if($("#cyf").val()=='7' && $("#dyf").val()=='12'){
			alert("该区间应该选择审计类型为【半年度报表审计】");
			$("#dyf").val("");
			$("#dyf").select();
		}else if($("#cyf").val()=='1' && $("#dyf").val()=='9'){
			alert("该区间应该选择审计类型为【前三个季度报表审计】");
			$("#dyf").val("");
			$("#dyf").select();
		}else if($("#cyf").val()=='1' && $("#dyf").val()=='12'){
			alert("该区间应该选择审计类型为【年报审计】");
			$("#dyf").val("");
			$("#dyf").select();
		}
	}
}
</script>