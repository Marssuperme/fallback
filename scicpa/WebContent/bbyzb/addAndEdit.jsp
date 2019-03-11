<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>
<%@ page isELIgnored="false"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>addAndEdit.jsp</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/main.css" />
	
<style>
.formTitle {
	color: #4A74BC;
	font-weight: bold;
	font-size: 14px;
	text-align: center;
	width: 100%;
	margin-top: 10px;
}

.mustSpan {
	color: #FF6600;
	font-family: "宋体";
	font: normal;
	font-size: 9pt;
	padding: 0px;
	margin: 0px;
}

.data_tb TD {
	BORDER-RIGHT: #b0c6d8 1px solid; BORDER-TOP: #b0c6d8 1px solid; PADDING-LEFT: 2px; BORDER-LEFT: #b0c6d8 1px solid; WORD-BREAK: break-all; BORDER-BOTTOM: #b0c6d8 1px solid; WORD-WRAP: break-word 
}

H3.tabs {
	PADDING-LEFT: 0px ! important;
	HEIGHT: 26px;
	BACKGROUND-COLOR: #e8f7fc ! important
}

.tab {
	BORDER-RIGHT: #c1d8e0 1px solid;
	PADDING-RIGHT: 10px;
	PADDING-LEFT: 10px;
	FONT-WEIGHT: normal;
	FLOAT: left;
	PADDING-BOTTOM: 0px;
	CURSOR: pointer;
	PADDING-TOP: 0px
}

.curtab {
	FONT-WEIGHT: bold;
	BACKGROUND: #fff;
	BORDER-RIGHT-COLOR: #b2c9d3;
}

.block {
	BORDER-RIGHT: #b2c9d3 1px solid;
	BORDER-TOP: #b2c9d3 1px solid;
	BACKGROUND: #fff;
	MARGIN: 0px 0px 6px;
	BORDER-LEFT: #b2c9d3 1px solid;
	BORDER-BOTTOM: #b2c9d3 1px solid
}

.block H3 {
	PADDING-LEFT: 0.5em;
	FONT-SIZE: 1em;
	BACKGROUND: url(../images/dotline_h.gif) repeat-x 50% bottom;
	MARGIN: 1px 0px 0px;
	COLOR: #5086a5;
	LINE-HEIGHT: 26px
}

.block H3 A {
	COLOR: #5086a5
}

.before {
	border: 0px;
	background-color: white;
}

.after {
	border: 1px solid;
}

label { width: 10em; float: left; }
label.error { float: none; color: red; padding-left: .5em; vertical-align: top; }

</style>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/index.css" />	
</head>
<body>

<form name="thisForm" method="post" action="" id="thisForm">

<input type="hidden" id="ctguid" name="ctguid" value="${ct.guid}">
<input type="hidden" id="cltguid" name="cltguid" value="${clt.guid}">
<input type="hidden" id="yzbguid" name="yzbguid" value="${yt.guid}">
<input type="hidden" id="typeid" name="typeid" value="${typeid}">
 

<table width="98%" height="5%" border="0" cellspacing="0" cellpadding="0">
	<tr align="center">
		<td width="70%" align="center">
		 	<center class="formTitle">
				验&nbsp;&nbsp;资&nbsp;&nbsp;信&nbsp;&nbsp;息
			</center>
		</td>
	</tr> 
	 
</table>
<div id="bbnum" style="text-align: center;">
		报备编号：<input style="background-color: white;border: 0px" value="${ct.bbbh}"" id="bbbh" name="bbbh" readonly="readonly">
</div><br>

<DIV class=block id=search style="width: 99%">

<H3 class=tabs id=searchtabs>
	<A class="tab curtab" id="dbswszltab" href="javascript:setTab('search','dbswszl')">报备事务所资料</A> 
	<A class="tab" id="nrytab" href="javascript:setTab('search','nry')">报备内容一</A>
	<A class="tab" id="nretab" href="javascript:setTab('search','nre')">报备内容二</A>
	<div id="fsave" style="margin-left: 78%;margin-top: 1%">
			   <input type="button"
				name="bcb" id="bcb" value="保  存"
				onclick="return saveCompanyJudge();"> 
				<input id="fh" type="button" name="next"
				value="返  回" icon="icon-back" class="flyBT" onclick="goback();">
	</div>
</H3>


<div class=tabcontent id="dbswszl" style="text-align: center;"> 

<table style="WIDTH: 100%; border: 0px;" class="data_tb" align="center">
 	<!-- 
	<tr>
		<td class="data_tb_alignright" style="text-align: left;"
			width="100%" colspan="4" height="18"><input type="checkbox" id="sws" name="sws" value="是否外地事务所">是否外地事务所</td>
	</tr>
	 -->
	
	 
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">事务所名称</td>
		<td class="data_tb_content" colspan="3" width="80%" height="18">${clt.companyName }
			<input name="companyName" type="hidden" id="companyName" size="85" value="${clt.companyName }" readonly="readonly">
		</td>
		 
	</tr>
	 
	 <!-- 
	<tr>
		<td class="data_tb_alignright" width="20%" height="21">事务所语音调查名称&nbsp;</td>
		<td class="data_tb_content" colspan="3" width="30%" height="18"><input
			name="languageSelectName" type="text" id="languageSelectName" size="78"
			value="${clt.languageSelectName }"></td>
	</tr>
	 -->
	 
	  
	<tr>
		<td class="data_tb_alignright" width="20%" height="21">事务所归属地&nbsp;</td>
		<td class="data_tb_content" colspan="3" width="30%" height="18">${userSession.userMap.area}
			<input name="area"   type="hidden" id="area" size="85" value="${userSession.userMap.area}">
		</td>
	</tr>
	 
	
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">联系人<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" width="30%" height="18">
			<input name="person" class="required" type="text" id="person" size="25" value="${clt.person }" >
		</td>
		<td class="data_tb_alignright" height="18">联系电话<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" height="18">
			<input name="phone" myClass="phone" class="required" type="text" id="phone" size="25"  value = "${clt.phone }" >
		</td>
	</tr>
	
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">传&nbsp;&nbsp;&nbsp;&nbsp;真<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" width="30%" height="18">
			<input name="faxes" myClass="phone" class="required" type="text" id="faxes" size="25" value="${clt.faxes }" >
		</td>
		<td class="data_tb_alignright" height="18">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;编<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" height="18">
			<input name="post" myClass="number" class="required" type="text" id="post"  size="25"  value = "${clt.post }" >
		</td>
	</tr>
	
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">地&nbsp;&nbsp;址<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" height="18" colspan="3">
			<input name="address" class="required" type="text" id="address"  size="85"  value = "${clt.address }" >
		</td>
	</tr>
	
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">E-Mial<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" width="30%" height="18">
			<input name="email" class="required" type="text" myClass="email" id="email" size="25" value="${clt.email }" >
		</td>
		<td class="data_tb_alignright" height="18">网&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址&nbsp;</td>
		<td class="data_tb_content" height="18">
			<input name="url" type="text" id="url"  size="25"  value = "${clt.url }" >
		</td>
	</tr>
</table>
</div>


<div class=tabcontent id="nry"
	style="text-align: center; display: none;"> 
	
<table cellSpacing="0" cellPadding="5" class="data_tb" width="100%" >
  <tr>
    <td class="data_tb_alignright" style="text-align: left;" colspan="4" height="16">客户信息</td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">委托单位名称<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23" class="data_tb_content"><input title="委托单位名称" id="wtdwmc" value="${ct.wtdwmc }" name="wtdwmc" size="23" class="required"></td>
    <td width="20%" height="23" class="data_tb_alignright">被审验单位名称<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23" class="data_tb_content"><input title="被审验单位名称" id="bsdwmc" value="${ct.bsdwmc }" name="bsdwmc" size="24" class="required"></td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">客户出资类型<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23" class="data_tb_content"><input onfocus="onPopDivClick(this);"
    					noinput=true
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=4
						hideresult=true title="客户出资类型" id="khczlx" value="${ct.khczlx }" name="khczlx" size="20" class="required"></td>
    <td width="20%" height="23" class="data_tb_alignright">营业执照号码或核准通知书号<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23" class="data_tb_content"><input title="营业执照号码或核准通知书号" id="yyzzhm" value="${ct.yyzzhm }" name="yyzzhm" size="20" class="required"></td>
  </tr>
  <tr>
    <td width="20%" height="46" class="data_tb_alignright">客户经济性质<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="46" class="data_tb_content"><input onfocus="onPopDivClick(this);"
    					noinput=true
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=11
						hideresult=true title="客户经济性质" id="khjjxj" value="${ct.khjjxj }" name="khjjxj" size="20" class="required"></td>
    <td width="20%" height="46" class="data_tb_alignright">被审(验)单位注册资本<font color="#FF0000" >&nbsp;[*]</font></td>
    <td width="30%" height="46" class="data_tb_content"> 
    	<input title="被审(验)单位注册资本" id="bsdwzczb" value="${ct.bsdwzczb }" size="20" name="bsdwzczb" class="required number">万元
    </td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">客户行业类型<font color="#FF0000" class="required">&nbsp;[*]</font></td>
    <td width="30%" height="23" class="data_tb_content"><input onfocus="onPopDivClick(this);"
    					noinput=true
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=12
						hideresult=true title="客户行业类型" id="kmhylx" value='${ct.kmhylx }' name="kmhylx" size="20" class="required"></td>
    <td width="20%" height="23" class="data_tb_alignright">是否上市企业<font color="#FF0000" class="required">&nbsp;[*]</font></td>
    <td width="30%" height="23" class="data_tb_content">
		<input onfocus="onPopDivClick(this);"
    					noinput=true
    					autoWidth=190
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=13
						hideresult=true title="是否上市企业" id="sfssqy" value="${ct.sfssqy }" size="20" name="sfssqy" class="required"> 
	</td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">注册地址</td>
    <td width="80%" colspan="3" height="23" class="data_tb_content"><input id="zcdz" value="${ct.zcdz }" name="zcdz" size="85"></td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">负责人姓名</td>
    <td width="30%" height="23" class="data_tb_content"><input id="fzrmc" value="${ct.fzrmc }" name="fzrmc" size="20"></td>
    <td width="20%" height="23" class="data_tb_alignright">联系人姓名</td>
    <td width="30%" height="23" class="data_tb_content"><input id="lxrxm" value="${ct.lxrxm }" name="lxrxm" size="20"></td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">联系人电话</td>
    <td width="80%" colspan="3" height="23" class="data_tb_content"><input id="lxrdh" value="${ct.lxrdh }" name="lxrdh" size="20" class="phone"></td>
  </tr>
  <tr>
    <td class="data_tb_alignright" style="text-align: left;" colspan="4" height="16">业务信息</td>
  </tr>
  <tr>
    <td width="20%" height="10" class="data_tb_alignright">委托项目类型<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="10" class="data_tb_content"><input title="委托项目类型" id="wtxmlx" readonly="readonly" value="${ct.wtxmlx }" size="20" name="wtxmlx" class="required"></td>
    <td class="data_tb_alignright" width="20%" class="data_tb_alignright">业务约定书号码<font color="#FF0000">&nbsp;[*]</font></td>
    <td class="data_tb_content" width="30%" class="data_tb_content"><input title="业务约定书号码" id="ywyds" value="${ct.ywyds }" size="20" name="ywyds" class="required"></td>
  </tr>
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">签约日期&nbsp;</td>
    <td width="30%" height="16" class="data_tb_content"><input id="qyrq" value="${ct.qyrq }" size="20" name="qyrq" showcalendar="true" class="date"></td>
    <td width="20%" height="16" class="data_tb_alignright">报告文号<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="16" class="data_tb_content"><input title="报告文号" id="bgwh" value="${ct.bgwh }" name="bgwh" size="20" class="required"></td>
  </tr>
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">项目名称<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="80%" height="16" colspan="3" class="data_tb_content"><input title="项目名称" id="xmmc" value="${ct.xmmc }" name="xmmc" size="85" class="required"></td>
  </tr>
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">签名执业师类型</td>
    <td width="30%" height="16" class="data_tb_content"><input onfocus="onPopDivClick(this);"
    					noinput=true
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=21
						hideresult=true id="qmzyszl" value="${ct.qmzyszl }" name="qmzyszl" size="20"></td>
    <td class="data_tb_alignright" width="20%">发出报告份数</td>
    <td class="data_tb_content" width="30%"><input id="fcbgfs" value="${ct.fcbgfs }" size="20" name="fcbgfs" class="number"></td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%">签名注师一<font color="#FF0000">&nbsp;[*]</font></td>
    <td class="data_tb_content" width="30%">
		<input title="签名注师一" id="qmzs1" value="${ct.qmzs1 }" onfocus="onPopDivClick(this);"
    					noinput=true
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=50
						refer = "${userSession.userMap.loginid }"
						hideresult=true size="20" name="qmzs1" class="required">
	</td>
    <td class="data_tb_alignright" width="20%">签名注师二<font color="#FF0000">&nbsp;[*]</font></td>
    <td class="data_tb_content" width="30%">
		<input title="签名注师二" id="qmzs2" value="${ct.qmzs2 }" onfocus="onPopDivClick(this);"
    					noinput=true
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=50
						refer = "${userSession.userMap.loginid }"
						hideresult=true size="20" name="qmzs2" class="required">
	</td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%">签名注师三</td>
    <td class="data_tb_content" width="30%">
		<input id="qmzs3" value="${ct.qmzs3 }"  onfocus="onPopDivClick(this);"
    					noinput=true
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=50
						refer = "${userSession.userMap.loginid }"
						hideresult=true size="20" name="qmzs3">
	</td>
    <td class="data_tb_alignright" width="20%">签名注师四</td>
    <td class="data_tb_content" width="30%">
		<input id="qmzs4" value="${ct.qmzs4 }"  onfocus="onPopDivClick(this);"
    					noinput=true
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=50
						refer = "${userSession.userMap.loginid }"
						hideresult=true size="20" name="qmzs4">
	</td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%">签名注师五&nbsp;</td>
    <td class="data_tb_content" width="30%">
		<input id="qmzs5" value="${ct.qmzs5 }"  onfocus="onPopDivClick(this);"
    					noinput=true
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=50
						refer = "${userSession.userMap.loginid }"
						hideresult=true size="20" name="qmzs5">
	</td>
    <td class="data_tb_alignright" width="20%">签名注师六&nbsp;</td>
    <td class="data_tb_content" width="30%">
		<input id="qmzs6" value="${ct.qmzs6}"  onfocus="onPopDivClick(this);"
    					noinput=true
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=50
						refer = "${userSession.userMap.loginid }"
						hideresult=true size="20" name="qmzs6">
	</td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%" height="16">助理人员&nbsp;</td>
    <td width="80%" height="16" colspan="3" class="data_tb_content"><input id="zlry" value="${ct.zlry }" name="zlry" size="85"></td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%">报告日期</td>
    <td class="data_tb_content" width="30%"><input id="bgrq" value="${ct.bgrq }" size="20" name="bgrq" showcalendar="true" class="date"></td>
    <td class="data_tb_alignright" width="20%">报告年度</td>
    <td class="data_tb_content" width="30%"><input onfocus="onPopDivClick(this);"
    					noinput=true
    					autoWidth=190
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=3
						hideresult=true id="bgnd" value="${ct.bgnd }" size="20" name="bgnd"></td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%" height="16">留给后任注册会计师的话&nbsp;</td>
    <td width="80%" height="16" colspan="3" class="data_tb_content"><textarea id="leaveword" name="leaveword" style="width: 85%;height: 90%">${ct.leaveword }</textarea></td>
  </tr>
  <tr>
    <td class="data_tb_alignright" style="text-align: left;" height="16" colspan="4">收费信息</td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%">应收业务费<font color="#FF0000">&nbsp;[*]</font></td>
    <td class="data_tb_content" width="30%"><input title="应收业务费" id="ysywf" value="${ct.ysywf }" size="15" name="ysywf" class="required number">元(人民币)</td>
    <td class="data_tb_alignright" width="20%" height="16">收费日期</td>
    <td width="30%" height="16" class="data_tb_content"><input id="sfrq" value="${ct.sfrq}" name="sfrq" size="20" showcalendar="true" class="date"></td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%" >已收业务费</td>
    <td width="30%" class="data_tb_content"><input id="ysywfed" value="${ct.ysywfed }" size="15" name="ysywfed" class="number">元(人民币)</td>
    <td class="data_tb_alignright" width="20%" height="16">开具收款发票号码</td>
    <td width="30%" height="16" class="data_tb_content"><input id="kjskdfphd" value="${ct.kjskdfphd }" name="kjskdfphd" size="20"></td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%" height="16">收费依据<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="16" class="data_tb_content"><input onfocus="onPopDivClick(this);"
    					noinput=true
    					autoWidth=190
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=15
						hideresult=true title="收费依据" id="sfyj" value="${ct.sfyj }" name="sfyj" size="20" class="required"></td>
    <td class="data_tb_alignright" width="20%" height="16">收费说明</td>
    <td width="30%" height="16" class="data_tb_content"><textarea id="sfsm" name="sfsm" size="20">${ct.sfsm }</textarea></td>
  </tr>
</table>

</div>


<div class=tabcontent id="nre"
	style="text-align: center; display: none;"> 
	
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="data_tb" align="center">
 	<tr>
		<td class="data_tb_alignright" colspan="6" style="text-align: left;">
		验资币种&nbsp;&nbsp;<input onfocus="onPopDivClick(this);"
    					noinput=true
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=5
						hideresult=true id="yzbz" value="${yt.yzbz }" size="10" name="yzbz">
		</td>
	</tr>

	<tr>
		<td rowspan="7" align="left" colspan="3">
		<fieldset style="border: 1px solid lightblue;width:100%;">
			<legend>
				验资金额
			</legend>
			<table width="100%" align="left" border="1" cellpadding="0" cellspacing="0">
					<tr>
						<td class="data_tb_alignright" align="left" colspan="2">货币</td>
						<td  align="left">
							<input class="data_tb_content number" name="yzbzje" type="text" id="yzbzje" size="15" value="${yt.yzbzje }" onblur="f_yztotal()">万元
						</td>
					</tr>
					
					<tr>
						<td class="data_tb_alignright" align="left" colspan="2">实物</td>
						<td  align="left">
							<input class="data_tb_content number" name="yzswje" type="text" id="yzswje" size="15" value="${yt.yzswje }" onblur="f_yztotal()">万元
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
									<td class="data_tb_alignright" align="left">使用土地权</td>
									<td  align="left">
										<input class="data_tb_content number" name="yztdsyje" type="text" id="yztdsyje" size="15" value="${yt.yztdsyje }" onblur="f_yztotal()">万元
									</td>
								</tr>
								
								<tr>
									<td class="data_tb_alignright" align="left">其他无形资产</td>
									<td  align="left">
										<input class="data_tb_content number" name="yzqtwszcje" type="text" id="yzqtwszcje" size="15" value="${yt.yzqtwszcje }" onblur="f_yztotal()">万元
									</td>
								</tr>
								
								<tr>
									<td class="data_tb_alignright" align="left">无形资产总金额</td>
									<td  align="left">
										<input class="data_tb_content" name="wxzczje" readonly="readonly" type="text" id="wxzczje" size="15" value="${yt.yztdsyje+yt.yzqtwszcje }">万元
									</td>
								</tr>
							</table>
						</fieldset>
						</td>
					</tr>
					
					
					<tr>
						<td class="data_tb_alignright" align="left" colspan="2">其他</td>
						<td  align="left">
							<input class="data_tb_content number" name="yzqtje" type="text" id="yzqtje" size="15" value="${yt.yzqtje }" onblur="f_yztotal()">万元
						</td>
					</tr>
					
					<tr>
						<td class="data_tb_alignright" align="left" colspan="2">验资总金额</td>
						<td  align="left">
							<input class="data_tb_content" name="yzzjes" type="text" readonly="readonly" id="yzzjes" size="15" value="${yt.yzbzje+yt.yzswje+yt.yztdsyje+yt.yzqtwszcje+yt.yzqtje}">万元
						</td>
					</tr>
			</table>
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
								<input class="data_tb_content number" name="bqyzwfczxhje" type="text" id="bqyzwfczxhje" size="15" value="${yt.bqyzwfczxhje }" onblur="f_wfcztotal()">万元
							</td>
						</tr>
						
						<tr>
							<td class="data_tb_alignright" align="left" >实物</td>
							<td  align="left">
								<input class="data_tb_content number" name="bqyzwfczswje" type="text" id="bqyzwfczswje" size="15" value="${yt.bqyzwfczswje }" onblur="f_wfcztotal()">万元
							</td>
						</tr>
						
						<tr>
							<td class="data_tb_alignright" align="left">利润转投资</td>
							<td  align="left">
								<input class="data_tb_content number" name="bqyzwfczlyztzje" type="text" id="bqyzwfczlyztzje" size="15" value="${yt.bqyzwfczlyztzje }" onblur="f_wfcztotal()">万元
							</td>
						</tr>
						
						<tr>
							<td class="data_tb_alignright" align="left">无形资产</td>
							<td  align="left">
								<input class="data_tb_content number" name="bqyzwfczwxzcje" type="text" id="bqyzwfczwxzcje" size="15" value="${yt.bqyzwfczwxzcje }" onblur="f_wfcztotal()">万元 
							</td>
						</tr>
						
						<tr>
							<td class="data_tb_alignright" align="left">其他</td>
							<td  align="left">
								<input class="data_tb_content number" name="bqyzwfczqtje" type="bqyzwfczqtje" id="" size="15" value="${yt.bqyzwfczqtje }" onblur="f_wfcztotal()">万元 
							</td>
						</tr>
						
						<tr>
							<td class="data_tb_alignright" align="left">本期验证外方出资金额出资总金额</td>
							<td  align="left">
								<input class="data_tb_content" name="wfcztotal" readonly="readonly" type="text" id="wfcztotal" size="15" value="${yt.bqyzwfczxhje+yt.bqyzwfczswje+yt.bqyzwfczlyztzje+yt.bqyzwfczwxzcje+yt.bqyzwfczqtje }">万元 
							</td>
						</tr>
				</table>
			</fieldset>
		</td>
	</tr>
	
</table>

<table width="100%" cellpadding="0" cellspacing="0" class="data_tb" align="center">
 	<tr>
	    <td class="data_tb_alignright" colspan="2">验资种类</td>
	    <td align="left">
			<input onfocus="onPopDivClick(this);"
    					noinput=true
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=6
						hideresult=true id="yzzl" value="${yt.yzzl }" size="15" name="yzzl">
		</td>
	    <td class="data_tb_alignright" colspan="2">验资截止日</td>
	    <td align="left"><input id="yzjzr" class="data_tb_content date"  value="${yt.yzjzr}" name="yzjzr" size="15" showcalendar="true"></td>
	    <td class="data_tb_alignright" colspan="2">股东1</td>
	    <td align="left"><input id="gd1" class="data_tb_content"  value="${yt.gd1}" name="gd1" size="15"></td>
    </tr>
    <tr>
	    <td class="data_tb_alignright" colspan="2">增资</td>
	    <td align="left">
			<input id="zj" class="data_tb_content number" value="${yt.zj}" name="zj" size="15">万元
		</td>
	    <td class="data_tb_alignright" colspan="2">股东2</td>
	    <td align="left"><input id="gd2" class="data_tb_content" value="${yt.gd2}" name="gd2" size="15"></td>
	    <td class="data_tb_alignright" colspan="2">股东3</td>
	    <td align="left"><input id="gd3" class="data_tb_content" value="${yt.gd3}" name="gd3" size="15"></td>
    </tr>
    <tr>
	    <td class="data_tb_alignright" colspan="2">股份转让</td>
	    <td align="left">
			<input id="gfzy" class="data_tb_content number" value="${yt.gfzy}" name="gfzy" size="15">万元
		</td>
	    <td class="data_tb_alignright" colspan="2">股东4</td>
	    <td align="left"><input id="gd4" class="data_tb_content" value="${yt.gd4}" name="gd4" size="15"></td>
	    <td class="data_tb_alignright" colspan="2">其他股东</td>
	    <td align="left"><input id="qtgd" class="data_tb_content" value="${yt.qtgd}" name="qtgd" size="15"></td>
    </tr>
    
   
    <tr> 
	    <td class="data_tb_alignright" colspan="2">减资</td>
	    <td align="left">
	    	<input class="data_tb_content number" id="jz" value="${yt.jz}" name="jz" size="15">万元
	    </td>
    </tr>
</table>

</div>
</DIV>  
</form>
 
</body>

<script>
 
   // 隐藏报备编号
   if("${yt.guid}"=="" || "${yt.guid}"==null){
   		document.getElementById("bbnum").style.display = "none";
   }

	//加验证
  $(document).ready(function(){
    $("#thisForm").validate();
  });
  
	//加输入限制
  $(document).ready(function(){
    $("input.zipcode").mask("999999");
  }); 
	

	var view="${view}";
	if (view){
		$("input").each(function(index,obj){
			obj.readOnly = true ;
			obj.className = "before";
		});
		
		$("textarea").each(function(index,obj){
			obj.readOnly = true ;
			obj.className = "before";
		});
		document.getElementById("fsave").style.display = "none";
		document.getElementById("bbnum").style.display = "none";
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
	document.getElementById("wxzczje").value=sytdqs*1+qtwxzcs*1;
	document.getElementById("yzzjes").value=hbs*1+sws*1+sytdqs*1+qtwxzcs*1+qts*1;
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
	document.getElementById("wfcztotal").value=xhs*1+shs*1+lrs*1+zcs*1+qts*1;
	
}

	//显示
function setTab(area,id) {
	var tabArea=document.getElementById(area);
	var contents=tabArea.childNodes;
	for(i=0; i<contents.length; i++) {
		if(contents[i].className=='tabcontent'){contents[i].style.display='none';}
	}
	document.getElementById(id).style.display='';
	var tabs=document.getElementById(area+'tabs').getElementsByTagName('a');
	
	for(i=0; i<tabs.length; i++) { 
		tabs[i].className='tab'; 
	}
	document.getElementById(id+'tab').className='tab curtab';
	document.getElementById(id+'tab').blur();
	
}

// 保存
function saveCompanyJudge(){
	var yzbguid = document.getElementById("yzbguid").value;
	if(yzbguid=="" || yzbguid == null){
		document.thisForm.action="${pageContext.request.contextPath}/common/bbyzb.do?method=addYzbTable";
		if (thisForm.fireEvent('onsubmit')){
			thisForm.submit();
		}
	}else{
		document.thisForm.action="${pageContext.request.contextPath}/common/bbyzb.do?method=updateYzbTableById";
		if (thisForm.fireEvent('onsubmit')){
			thisForm.submit();
		}
	}
}

// 返回
function goback(){	
	document.thisForm.action="${pageContext.request.contextPath}/common/bbyzb.do?method=index&typeid=yz001";
	thisForm.submit();
}
</script>

</html>