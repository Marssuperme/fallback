<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>
<%@ page isELIgnored="false"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
response.addHeader("Cache-Control", "no-cache");
response.addHeader("Expires", "Thu, 01 Jan 1970 00:00:01 GMT");
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="expires" CONTENT="Wed, 26 Feb 1997 08:21:57 GMT"> 

<title>addAndEdit.jsp</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/JS/uploadFile.js?v=${modifyDate}"  ></script>

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
<input type="hidden" id="bbstate" name="bbstate" value="${ct.bbstate}">
 

<table width="98%" height="5%" border="0" cellspacing="0" cellpadding="0">
	<tr align="center">
		<td width="70%" align="center">
		 	<center class="formTitle">
				${ct.wtxmlx }
			</center>
		</td>
	</tr> 
	 
</table>
<div id="bbnum" style="text-align: center;">
		防伪编号：<input style="background-color: white;border: 0px" value="${ct.bbbh}"" id="bbbh" name="bbbh" readonly="readonly" size="30" >
</div><br>

<DIV class=block id=search style="width: 99%;overflow-x:auto;">

<H3 class=tabs id=searchtabs>
	<A class="tab curtab" id="dbswszltab" href="javascript:setTab('search','dbswszl')">报备事务所资料</A> 
	<A class="tab" id="nrytab" href="javascript:setTab('search','nry')">报备内容一</A>
	<A class="tab" id="nretab" href="javascript:setTab('search','nre')">报备内容二</A>
	<A class="tab" id="nrstab" href="javascript:setTab('search','nrs')">附件</A>
	<div style="margin-left: 70%;margin-top: 1%">
		<span>
			   <input type="button"	name="bcb" id="bcb" value="审核通过" icon="icon-apply" onclick="pass('${ct.guid}');"> 
			   <input type="button"	name="bcb" id="bcb" value="审核不通过" icon="icon-delete-row" onclick="nopass('${ct.guid}');"> 
			   <input id="fh" type="button" name="next" value="返  回" icon="icon-back" class="flyBT" onclick="goback();">
		</span>
	</div>
</H3>


<div class="tabcontent" id="dbswszl" style="text-align: center;"> 

<table style="WIDTH: 100%; border: 0px;" class="data_tb" align="center">
 	<!-- 
	<tr>
		<td class="data_tb_alignright" style="text-align: left;"
			width="100%" colspan="4" height="18"><input type="checkbox" id="sws" name="sws" value="是否外地事务所">是否外地事务所</td>
	</tr>
	 -->
	
	 
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">事务所名称</td>
		<td class="data_tb_content" colspan="3" width="80%" height="18"><input
			name="companyName" type="text" id="companyName" size="85"
			value="${clt.companyName }" class="required"></td>
		 
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
		<td class="data_tb_content" colspan="3" width="30%" height="18"><input
			name="ssaddress" readonly="readonly" type="text" id="ssaddress" size="85"
			value="${clt.area}"></td>
	</tr>
	 
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">联系人<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" height="18" colspan="3"> 
			<input maxlength="100" name="linkman" type="text" id="linkman"  size="96" value = "${clt.person }" >
		</td>
	</tr>
	
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">联系电话<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" height="18" colspan="3"> 
			<input maxlength="100" name="linkphone" type="text" id="linkphone"  size="96" value = "${clt.phone }" >
		</td>
	</tr>
	
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">传&nbsp;&nbsp;&nbsp;&nbsp;真<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" width="30%" height="18"><input
			name="faxes" type="text" id="faxes" size="25"
			value="${clt.faxes }"></td>
		<td class="data_tb_alignright" height="18">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;编<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" height="18">
			<input name="post" type="text" id="post"  size="30"  value = "${clt.post }" class="required zipcode">
		</td>
	</tr>
	
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">地&nbsp;&nbsp;&nbsp;&nbsp;址<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" height="18" colspan="3">
			<input name="address" type="text" id="address"  size="85"  value = "${clt.address }">
		</td>
	</tr>
	
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">E-Mial<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" width="30%" height="18"><input
			name="email" type="text" id="email" size="25"
			value="${clt.email }" class="required email"></td>
		<td class="data_tb_alignright" height="18">网&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址&nbsp;</td>
		<td class="data_tb_content" height="18">
			<input name="url" type="text" id="url"  size="30"  value = "${clt.url }" class="required url">
		</td>
	</tr>
</table>
</div>


<div class="tabcontent" id="nry"
	style="text-align: center; display: none;"> 
	
<table cellSpacing="0" cellPadding="5" class="data_tb" width="100%" >
  <tr>
    <td class="data_tb_alignright" style="text-align: left;" colspan="4" height="16">客户信息</td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">委托单位名称<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23" class="data_tb_content"><input title="委托单位名称" id="wtdwmc" value="${ct.wtdwmc }" name="wtdwmc" size="23" class="required"></td>
    <td width="20%" height="23" class="data_tb_alignright">被审(验)单位名称<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23" class="data_tb_content"><input title="被审验单位名称" id="bsdwmc" value="${ct.bsdwmc }" name="bsdwmc" size="24" class="required"></td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">被审(验)单位出资类型<font color="#FF0000">&nbsp;[*]</font></td>
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
    <td width="20%" height="46" class="data_tb_alignright">被审(验)单位经济性质<font color="#FF0000">&nbsp;[*]</font></td>
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
    	<input maxlength="20" id="bsdwzczb" value="${ct.bsdwzczb }" size="10" name="bsdwzczb" class="required number">万元&nbsp;&nbsp;&nbsp;&nbsp; <br />
    	<input maxlength="20" id="zczbbz" value="${ct.zczbbz }" size="5" name="zczbbz" onfocus="onPopDivClick(this);"
        				autoWidth="130"
        				autoHeight="180"
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						autoid=5
						norestorehint=true
						hideresult=true >币种
    </td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">被审(验)单位行业类型<font color="#FF0000" class="required">&nbsp;[*]</font></td>
    <td width="30%" height="23" class="data_tb_content"><input onfocus="onPopDivClick(this);"
    					noinput=true
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=55
						refer="dic_kmhylx"
						hideresult=true title="客户行业类型" id="kmhylx" value='${ct.kmhylx }' name="kmhylx" size="20" class="required"></td>
    <td width="20%" height="23" class="data_tb_alignright">是否上市企业<font color="#FF0000" class="required">&nbsp;[*]</font></td>
    <td width="30%" height="23" class="data_tb_content">
		<input onfocus="onPopDivClick(this);"
    					noinput=true
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
    <td class="data_tb_alignright" width="20%">项目客户类型<font color="#FF0000" class="required">&nbsp;[*]</font></td>
    <td class="data_tb_content" width="30%">
    	<input maxlength="50" id="xmkhlx" value="${ct.xmkhlx }" name="xmkhlx" onfocus="onPopDivClick(this);"
    					autoWidth=190
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						autoid=55 refer="projectCustomerTypes" style="width: 85%" class="required">
	</td>
  </tr>
  
 <tr>
    <td width="20%" height="23" class="data_tb_alignright">联系人电话</td>
    <td width="30%" height="23" class="data_tb_content"><input maxlength="50" id="lxrdh" value="${ct.lxrdh }" name="lxrdh" size="20" class="phone"></td>
 	<td width="20%" height="23" class="data_tb_alignright">联系人姓名</td>
    <td width="30%" height="23" class="data_tb_content"><input id="lxrxm" value="${ct.lxrxm }" name="lxrxm" size="20"></td>
  </tr>
  <tr>
    <td class="data_tb_alignright" style="text-align: left;" colspan="4" height="16">业务信息</td>
  </tr>
  <tr>
    <td width="20%" height="10" class="data_tb_alignright">是否打包项目<font color="#FF0000">&nbsp;[*]</font></td>
	<td width="30%" height="23" class="data_tb_content">
		${ct.sfdbxm}
	</td>
    <td width="20%" class="data_tb_alignright" id="dbxm1" <c:if test="${ct.sfdbxm=='是' }">style='display:;'</c:if><c:if test="${ct.sfdbxm!='是' }">style='display:none;'</c:if> >打包项目名称<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" class="data_tb_content" id="dbxm2"  <c:if test="${ct.sfdbxm=='是' }">style='display:;'</c:if><c:if test="${ct.sfdbxm!='是' }">style='display:none;'</c:if> ><input type="text" maxlength="250" title="打包项目名称" id="dbxmmc" value="${ct.dbxmmc }" style="width: 85%" name="dbxmmc"></td>
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
    <td class="data_tb_content" width="30%"><input id="fcbgfs" value="${ct.fcbgfs }" size="20" name="fcbgfs" class="digits"></td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%">
    	<c:choose>
    		<c:when test="${typeid=='dxzhpg001' || typeid=='jrblpg001' || typeid=='qtzcpg001' || typeid=='qyjzpg001' }">
    			签名评估师一
    		</c:when>
    		<c:otherwise>
    			签名注师一
    		</c:otherwise>
    	</c:choose>
		<font color="#FF0000">&nbsp;[*]</font>
	</td>
    <td class="data_tb_content" width="30%">
		<input id="qmzs1" value="${ct.qmzs1 }" size="20" name="qmzs1">
	</td>
    <td class="data_tb_alignright" width="20%">
    	<c:choose>
    		<c:when test="${typeid=='dxzhpg001' || typeid=='jrblpg001' || typeid=='qtzcpg001' || typeid=='qyjzpg001' }">
    			签名评估师二
    		</c:when>
    		<c:otherwise>
    			签名注师二
    		</c:otherwise>
		</c:choose>
		<font color="#FF0000">&nbsp;[*]</font>
	</td>
    <td class="data_tb_content" width="30%">
		<input id="qmzs2" value="${ct.qmzs2 }" size="20" name="qmzs2">
	</td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%">
		<c:choose>
    		<c:when test="${typeid=='dxzhpg001' || typeid=='jrblpg001' || typeid=='qtzcpg001' || typeid=='qyjzpg001' }">
    			签名评估师三
    		</c:when>
    		<c:otherwise>
    			签名注师三
    		</c:otherwise>
    	</c:choose>
	</td>
    <td class="data_tb_content" width="30%">
		<input id="qmzs3" value="${ct.qmzs3 }" size="20" name="qmzs3">
	</td>
    <td class="data_tb_alignright" width="20%">
    	<c:choose>
    		<c:when test="${typeid=='dxzhpg001' || typeid=='jrblpg001' || typeid=='qtzcpg001' || typeid=='qyjzpg001' }">
    			签名评估师四
    		</c:when>
    		<c:otherwise>
    			签名注师四
    		</c:otherwise>
    	</c:choose>
	</td>
    <td class="data_tb_content" width="30%">
		<input id="qmzs4" value="${ct.qmzs4 }" size="20" name="qmzs4">
	</td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%">
		<c:choose>
    		<c:when test="${typeid=='dxzhpg001' || typeid=='jrblpg001' || typeid=='qtzcpg001' || typeid=='qyjzpg001' }">
    			签名评估师五
    		</c:when>
    		<c:otherwise>
    			签名注师五
    		</c:otherwise>
    	</c:choose>
	</td>
    <td class="data_tb_content" width="30%">
		<input id="qmzs5" value="${ct.qmzs5 }" size="20" name="qmzs5">
	</td>
    <td class="data_tb_alignright" width="20%">
    	<c:choose>
    		<c:when test="${typeid=='dxzhpg001' || typeid=='jrblpg001' || typeid=='qtzcpg001' || typeid=='qyjzpg001' }">
    			签名评估师六
    		</c:when>
    		<c:otherwise>
    			签名注师六
    		</c:otherwise>
    	</c:choose>
	</td>
    <td class="data_tb_content" width="30%">
		<input id="qmzs6" value="${ct.qmzs6}" size="20" name="qmzs6">
	</td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%">
    	其他参与注师
	</td>
    <td class="data_tb_content" width="30%">
		<input maxlength="50" id="qmzs7" name="qtcyzs" value="${ct.qtcyzs }"  
						onfocus="onPopDivClick(this);"
						onchange="isQmzs(this,'7');"
    					noinput=true
    					autoWidth=250
						autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						hideresult=true 
						style="width: 85%"
						refer="${userSession.userMap.officecode }" 
				    	autoid="50" 
				    	title="其他参与注师"
				    	multiselect=true
						>
	</td>
	<td class="data_tb_alignright" width="20%">发出报告份数</td>
    <td class="data_tb_content" width="30%"><input maxlength="50" id="fcbgfs" value="${ct.fcbgfs }" style="width: 85%" name="fcbgfs" class="number" onkeyup="f_moneys(this);" ></td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%">助理人员&nbsp;</td>
    <td class="data_tb_content" width="30%"><input maxlength="50" style="height: 0px;" id="zlry" value="${ct.zlry }" name="zlry" size="20"></td>
    <td class="data_tb_alignright" width="20%">被审(验)单位注册地址<font color="#FF0000" class="required">&nbsp;[*]</font></td>
    <td class="data_tb_content" width="30%"><input maxlength="50" onfocus="onPopDivClick(this);" title="业务所在地"
    					class="required"
    					noinput=true
    					autoWidth=190
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=10
						onchange="isOnly();"
						hideresult=true id="ywarea" value="${ct.ywarea}" size="20" name="ywarea"></td>
  </tr>
  
  <tr>
    <td class="data_tb_alignright" width="20%">报告日期<font color="#FF0000">&nbsp;[*]</font></td>
    <td class="data_tb_content" width="30%">
    	<input maxlength="50" id="bgrq" value="${ct.bgrq }" style="width: 70%" name="bgrq" showcalendar="true" class="required" onkeypress="return false;" onpaste="return false;" >
    </td>
    
   	<td class="data_tb_alignright" width="20%">报告年度</td>
    <td class="data_tb_content" width="30%">
    	<input id="baogaoniandu" value="${ct.baogaoniandu }" style="width: 85%;" name="baogaoniandu" title="报告年度" readonly="readonly">
	</td>
  </tr>
  
  <tr>
    <td class="data_tb_alignright" width="20%" height="16">
    	<c:choose>
    		<c:when test="${typeid=='dxzhpg001' || typeid=='jrblpg001' || typeid=='qtzcpg001' || typeid=='qyjzpg001' }">
    			留给后任评估师的话
    		</c:when>
    		<c:otherwise>
    			留给后任注册会计师的话
    		</c:otherwise>
    	</c:choose>
	</td>
    <td width="80%" height="16" colspan="3" class="data_tb_content"><textarea id="leaveword" name="leaveword" style="width: 85%;height: 90%">${ct.leaveword }</textarea></td>
  </tr>
  <tr>
    <td class="data_tb_alignright" style="text-align: left;" height="16" colspan="4">收费信息</td>
  </tr>
  <tr >
    <td class="data_tb_alignright" width="20%">计费方式<font color="#FF0000">&nbsp;[*]</font></td>
    <td class="data_tb_content" colspan="3">
    	<input maxlength="50" onfocus="onPopDivClick(this);"
    					noinput=true 
    					autoWidth=190
    					autoHeight=150
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true 
						autoid=55
						refer="sfstandard"
						onchange="f_setSfbzAlready(this)"
						hideresult=true title="计费方式" id="sfbz" name="sfbz" value="${ct.sfbz }" style="width:22%" class="required">
    </td>
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
    <td class="data_tb_alignright" width="20%" height="16">收费依据</td>
    <td width="30%" height="16" class="data_tb_content"><input onfocus="onPopDivClick(this);"
    					noinput=true
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=20
						hideresult=true title="收费依据" id="sfyj" value="${ct.sfyj }" name="sfyj" size="20" ></td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%" height="16">开具收款发票号码</td>
    <td width="30%" height="16" class="data_tb_content" colspan="3">
    	<input maxlength="50" id="kjskdfphd" value="${ct.kjskdfphd }" name="kjskdfphd" size="45">&nbsp;&nbsp;&nbsp;&nbsp;
    	<input maxlength="50" id="kjskdfphd2" value="${ct.kjskdfphd2 }" name="kjskdfphd2" size="45" ><br>
    </td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%" height="16">收费说明</td>
    <td width="80%" height="16" class="data_tb_content" colspan="3">
    	<textarea id="sfsm" name="sfsm" size="20" style="width: 85%;">${ct.sfsm }</textarea>
    </td>
  </tr>
  
   <tbody id="jssfTbody" style="display: none" >
   	 <tr>	
   	 	<td colspan="4" >
	    	<table class="data_tb" width="100%">
			  <tr>
			  	<td width="25%">职位</td>
			    <td width="5%">人数</td>
			  	<td width="5%">总工时</td>
			    <td width="30%">总金额</td>
			  	<td width="35%">备注</td>
			  </tr>
			  <c:if test="${userSession.userMap.officetype=='事务所'}">
			  <tr>
			  	<td ><input type="text" id="duty1" name="duty" value="初级助理" size=5 readonly="readonly" style="border: 0px;width: 90%;text-align: center;"></td>
			    <td ><input type="text" id="countPeople1" name="countPeople" value="${mapTotal.primaryAssistant.countPeople}" onkeyup="f_number(this);f_countPeopleTotal();" size=5></td>
			  	<td ><input type="text" id="countHour1" name="countHour" value="${mapTotal.primaryAssistant.countHour }" onkeyup="f_moneys(this);f_countHourTotal();" size=5>小时</td>
			    <td ><input type="text" id="countMoney1" name="countMoney" value="${mapTotal.primaryAssistant.countMoney }" onkeyup="f_moneys(this);f_countMoneyTotal();" size=12 style="text-align: right;">元(人民币)</td>
			  	<td ><textarea id="property1" name="property" style="width: 95%">${mapTotal.primaryAssistant.propertys }</textarea></td>
			  </tr>
			  <tr>
			  	<td ><input type="text" id="duty2" name="duty" value="助理" size=5 readonly="readonly" style="border: 0px;width: 90%;text-align: center;"></td>
			    <td ><input type="text" id="countPeople2" name="countPeople" value="${mapTotal.assistant.countPeople }" onkeyup="f_number(this);f_countPeopleTotal();" size=5></td>
			  	<td ><input type="text" id="countHour2" name="countHour" value="${mapTotal.assistant.countHour }" onkeyup="f_moneys(this);f_countHourTotal();" size=5>小时</td>
			    <td ><input type="text" id="countMoney2" name="countMoney" value="${mapTotal.assistant.countMoney }" onkeyup="f_moneys(this);f_countMoneyTotal();" size=12 style="text-align: right;">元(人民币)</td>
			  	<td ><textarea id="property2" name="property" style="width: 95%">${mapTotal.assistant.propertys }</textarea></td>
			  </tr>
			  <tr>
			  	<td ><input type="text" id="duty3" name="duty" value="注册会计师" size=5 readonly="readonly" style="border: 0px;width: 90%;text-align: center;"></td>
			    <td ><input type="text" id="countPeople3" name="countPeople" value="${mapTotal.cpa.countPeople }" onkeyup="f_number(this);f_countPeopleTotal();" size=5></td>
			  	<td ><input type="text" id="countHour3" name="countHour" value="${mapTotal.cpa.countHour }" onkeyup="f_moneys(this);f_countHourTotal();" size=5>小时</td>
			    <td ><input type="text" id="countMoney3" name="countMoney" value="${mapTotal.cpa.countMoney }" onkeyup="f_moneys(this);f_countMoneyTotal();" size=12 style="text-align: right;">元(人民币)</td>
			  	<td ><textarea id="property3" name="property" style="width: 95%">${mapTotal.cpa.propertys }</textarea></td>
			  </tr>
			  <tr>
			  	<td ><input type="text" id="duty4" name="duty" value="项目经理" size=5 readonly="readonly" style="border: 0px;width: 90%;text-align: center;"></td>
			    <td ><input type="text" id="countPeople4" name="countPeople" value="${mapTotal.projecter.countPeople }" onkeyup="f_number(this);f_countPeopleTotal();" size=5></td>
			  	<td ><input type="text" id="countHour4" name="countHour" value="${mapTotal.projecter.countHour }" onkeyup="f_moneys(this);f_countHourTotal();" size=5>小时</td>
			    <td ><input type="text" id="countMoney4" name="countMoney" value="${mapTotal.projecter.countMoney }" onkeyup="f_moneys(this);f_countMoneyTotal();" size=12 style="text-align: right;">元(人民币)</td>
			  	<td ><textarea id="property4" name="property" style="width: 95%">${mapTotal.projecter.propertys }</textarea></td>
			  </tr>
			  <tr>
			  	<td ><input type="text" id="duty5" name="duty" value="部门经理" size=5 readonly="readonly" style="border: 0px;width: 90%;text-align: center;"></td>
			    <td ><input type="text" id="countPeople5" name="countPeople" value="${mapTotal.department.countPeople }" onkeyup="f_number(this);f_countPeopleTotal();" size=5></td>
			  	<td ><input type="text" id="countHour5" name="countHour" value="${mapTotal.department.countHour }" onkeyup="f_moneys(this);f_countHourTotal();" size=5>小时</td>
			    <td ><input type="text" id="countMoney5" name="countMoney" value="${mapTotal.department.countMoney }" onkeyup="f_moneys(this);f_countMoneyTotal();" size=12 style="text-align: right;">元(人民币)</td>
			  	<td ><textarea id="property5" name="property" style="width: 95%">${mapTotal.department.propertys }</textarea></td>
			  </tr>
			  <tr>
			  	<td ><input type="text" id="duty6" name="duty" value="主任会计师" size=5 readonly="readonly" style="border: 0px;width: 90%;text-align: center;"></td>
			    <td ><input type="text" id="countPeople6" name="countPeople" value="${mapTotal.chairman.countPeople }" onkeyup="f_number(this);f_countPeopleTotal();" size=5></td>
			  	<td ><input type="text" id="countHour6" name="countHour" value="${mapTotal.chairman.countHour }" onkeyup="f_moneys(this);f_countHourTotal();" size=5>小时</td>
			    <td ><input type="text" id="countMoney6" name="countMoney" value="${mapTotal.chairman.countMoney }" onkeyup="f_moneys(this);f_countMoneyTotal();" size=12 style="text-align: right;">元(人民币)</td>
			  	<td ><textarea id="property6" name="property" style="width: 95%">${mapTotal.chairman.propertys }</textarea></td>
			  </tr>
			  </c:if>
			  
			  <c:if test="${userSession.userMap.officetype=='评估所'}">
			   <tr>
			  	<td ><input type="text" id="duty1" name="duty" value="评估所法人代表、首席评估师" size=5 readonly="readonly" style="border: 0px;width: 90%;text-align: center;"></td>
			    <td ><input type="text" id="countPeople1" name="countPeople" value="${mapTotal.duty1.countPeople }" onkeyup="f_number(this);f_countPeopleTotal();" size=5></td>
			  	<td ><input type="text" id="countHour1" name="countHour" value="${mapTotal.duty1.countHour }" onkeyup="f_moneys(this);f_countHourTotal();" size=5>小时</td>
			    <td ><input type="text" id="countMoney1" name="countMoney" value="${mapTotal.duty1.countMoney }" onkeyup="f_moneys(this);f_countMoneyTotal();" size=12 style="text-align: right;">元(人民币)</td>
			  	<td ><textarea id="property1" name="property" style="width: 95%">${mapTotal.duty1.propertys }</textarea></td>
			  </tr>
			  <tr>
			  	<td ><input type="text" id="duty2" name="duty" value="评估所合伙人、部门经理" size=5 readonly="readonly" style="border: 0px;width: 90%;text-align: center;"></td>
			    <td ><input type="text" id="countPeople2" name="countPeople" value="${mapTotal.duty2.countPeople }" onkeyup="f_number(this);f_countPeopleTotal();" size=5></td>
			  	<td ><input type="text" id="countHour2" name="countHour" value="${mapTotal.duty2.countHour }" onkeyup="f_moneys(this);f_countHourTotal();" size=5>小时</td>
			    <td ><input type="text" id="countMoney2" name="countMoney" value="${mapTotal.duty2.countMoney }" onkeyup="f_moneys(this);f_countMoneyTotal();" size=12 style="text-align: right;">元(人民币)</td>
			  	<td ><textarea id="property2" name="property" style="width: 95%">${mapTotal.duty2.propertys }</textarea></td>
			  </tr>
			  <tr>
			  	<td ><input type="text" id="duty3" name="duty" value="注册评估师" size=5 readonly="readonly" style="border: 0px;width: 90%;text-align: center;"></td>
			    <td ><input type="text" id="countPeople3" name="countPeople" value="${mapTotal.duty3.countPeople }" onkeyup="f_number(this);f_countPeopleTotal();" size=5></td>
			  	<td ><input type="text" id="countHour3" name="countHour" value="${mapTotal.duty3.countHour }" onkeyup="f_moneys(this);f_countHourTotal();" size=5>小时</td>
			    <td ><input type="text" id="countMoney3" name="countMoney" value="${mapTotal.duty3.countMoney }" onkeyup="f_moneys(this);f_countMoneyTotal();" size=12 style="text-align: right;">元(人民币)</td>
			  	<td ><textarea id="property3" name="property" style="width: 95%">${mapTotal.duty3.propertys }</textarea></td>
			  </tr>
			  <tr>
			  	<td ><input type="text" id="duty4" name="duty" value="助理评估人员" size=5 readonly="readonly" style="border: 0px;width: 90%;text-align: center;"></td>
			    <td ><input type="text" id="countPeople4" name="countPeople" value="${mapTotal.duty4.countPeople }" onkeyup="f_number(this);f_countPeopleTotal();" size=5></td>
			  	<td ><input type="text" id="countHour4" name="countHour" value="${mapTotal.duty4.countHour }" onkeyup="f_moneys(this);f_countHourTotal();" size=5>小时</td>
			    <td ><input type="text" id="countMoney4" name="countMoney" value="${mapTotal.duty4.countMoney }" onkeyup="f_moneys(this);f_countMoneyTotal();" size=12 style="text-align: right;">元(人民币)</td>
			  	<td ><textarea id="property4" name="property" style="width: 95%">${mapTotal.duty4.propertys }</textarea></td>
			  </tr>
			  </c:if>
			  <tr>
			  	<td >合计</td>
			    <td ><input type="text" id="countPeopleTotal" name="countPeopleTotal" readonly="readonly" style="border: 0px;text-align: center;"></td>
			  	<td ><input type="text" id="countHourTotal" name="countHourTotal" readonly="readonly" style="border: 0px;text-align: center;"></td>
			    <td ><input type="text" id="countMoneyTotal" name="countMoneyTotal" readonly="readonly" style="border: 0px;text-align: center;"></td>
			  	<td ></td>
			  </tr>
		 </table>
		</td>
   </tr>
   </tbody>
  
   <tbody id="tjshqkTbody" style="display: none">
  	  <tr>
	  	<td class="data_tb_alignright" width="20%" height="16">需要提交审核情况</td>
	    <td width="80%" height="16" colspan="3" class="data_tb_content">
	    	<input type="checkbox" id="isauditPropery" name="isauditPropery" <c:if test="${at.isauditPropery=='是' }">checked="checked"</c:if> value="${at.isauditPropery}"  onclick="return false;" >
	    </td>
	  </tr>
  </tbody>
  
  <tbody id="qksmTbody" style="display: none">
	  <tr>
	  	<td class="data_tb_alignright" width="20%" height="16">情况说明<font color="#FF0000">&nbsp;[*]</font></td>
	    <td width="80%" height="16" colspan="3" class="data_tb_content">
	    	<textarea id="standard" name="standard" style="width: 95%;height: 45;">${at.standard}</textarea>
	    </td>
	  </tr>
	  <tr>
		  	<td class="data_tb_alignright" width="20%" height="16">审核情况</td>
		    <td width="80%" height="16" colspan="3" class="data_tb_content">
		    	<input id="jj_auditPropery" name="jj_auditPropery" readonly="readonly" value="${at.auditPropery }">
		    </td>
  	  </tr>
  	  <tr>
	  	<td class="data_tb_alignright" width="20%" height="16">市注协复核意见</td>
	    <td width="80%" height="16" colspan="3" class="data_tb_content">
	    	<textarea id="jj_cityAdvice" name="jj_cityAdvice" style="width: 95%;height: 45;" readonly="readonly" >${at.cityAdvice }</textarea>
	    </td>
	  </tr>
	  <tr>
	  	<td class="data_tb_alignright" width="20%" height="16">省注协复核意见</td>
	    <td width="80%" height="16" colspan="3" class="data_tb_content">
	    	<textarea id="jj_checkAdvice" name="jj_checkAdvice" style="width: 95%;height: 45;" readonly="readonly" >${at.checkAdvice }</textarea>
	    </td>
	  </tr>
   </tbody>
  
  
</table>

</div>


<div class=tabcontent id="nre"	style="text-align: center; display: none;"> 
	<jsp:include page="${twoHtml}" flush="true"></jsp:include>
</div>

<div class="tabcontent" id="nrs" style="text-align: center; display: none;"> 
	<table style="width: 100%;height: 50px;border: 0px;" class="data_tb" align="center">
		<tr>
			<td height="22" width="30%" align="center" ><strong>上传附件</strong></td>
			<td align="left" bgColor="#FFFFFF"><div id="bb_attachfileId"></div></td>
		</tr>
	</table>
</div>

</DIV>  

<div id="divBlock" style="position:absolute;width:100%;height:100%; top:expression(this.offsetParent.scrollTop); z-index:1; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;">
</div>
<div id="tzf" style="position:absolute;width:80%;height:20%; z-index:2;left:expression((document.body.clientWidth-550)/2);top:expression(this.offsetParent.scrollTop + 130); border:1px solid #6595d6; padding:10px; background:#ffffff;text-align:center; display: none;">
   
   <table width="90%">
   	<tr>
   		<td>
   	 		    作&nbsp;&nbsp;废&nbsp;&nbsp;原&nbsp;&nbsp;因<font color="red">[*]</font>：
    	<textarea title="作废原因" class="data_tb_content required" id="bbreason" name="bbreason" style="width: 80%;height: 100px;vertical-align: middle;">${ct.bbreason}</textarea>
    	</td>
    </tr>
    <tr>
    	<td>
    		收回报告份数：
    		<input type="text" id="reportCount" name="reportCount" class="data_tb_content" value="${ct.reportCount}" />
    	</td>
    </tr>
    </table>
   <ul style="list-style: none;">
    <li>
    	<input type="button" value="确  定" onclick="f_sure()"/>
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<input icon="icon-delete" type="button" value="取  消" onclick="f_qx()"/>
    </li>
  </ul>
    	
 </div>
 
</form>
 
</body>

<script>

	// 附件
	$('#bb_attachfileId').uploadFile({
		indexId: '${ct.attachfileId}',
		module:'bb_content1',
		forbitUpload:true,
		forbitDel:true
	});

	// 只读效果 
	$("input").each(function(index,obj){
		if(obj.id!="reportCount"){
			obj.readOnly = true ;
			obj.className = "before";
		}
	});
	
	$("textarea").each(function(index,obj){
		if(obj.id=="bbreason"){
			return;
		}
		obj.readOnly = true ;
		obj.className = "before";
	}); 
		
	// 判断是否查看
	if("${p}"=="ck"){
		document.getElementById("fcancle").style.display = "none";
		document.getElementById("tzf").style.display = "none";
	}
 
 
 // 加载总金额
	var bbbh = "${ct.bbbh}"
	if(bbbh!=""){
		f_countPeopleTotal();
		f_countHourTotal();
		f_countMoneyTotal();
	}
	
	// 计费方式
	var sfbzObj = document.getElementById("sfbz");
	if(sfbzObj.value!=""){
		f_setsfbz(sfbzObj);
		var isauditProperyObj = document.getElementById("isauditPropery");
		f_setqksmTbody(isauditProperyObj);
	}
	


// 计费方式
function f_setsfbz(t){
	if(!t){
		t = document.getElementById("sfbz");
	}
	var typeid = document.getElementById("typeid").value;
	if(typeid=="qchz001" || typeid=="qssh001" || typeid=="sj001" || typeid=="whnj001" || typeid=="yz001" || typeid=="sfkjjd001" || typeid=="flsj001" || typeid=="hbsj001"){
		if(t.value == "计时收费"){
			document.getElementById("jssfTbody").style.display = "";
		}else if(t.value == "计件收费"){
			document.getElementById("jssfTbody").style.display = "none";
		}else{
			document.getElementById("jssfTbody").style.display = "none";
		}
		
		var bbtime = "${ct.bbtime}";
		if(bbtime!=""){
			if(document.getElementById("isauditPropery").checked){
				document.getElementById("tjshqkTbody").style.display = "";
				document.getElementById("qksmTbody").style.display = "";
			}else{
				document.getElementById("tjshqkTbody").style.display = "none";
				document.getElementById("qksmTbody").style.display = "none";
			}
		}else{
			document.getElementById("standard").value = "";
			document.getElementById("isauditPropery").checked = false;
			document.getElementById("tjshqkTbody").style.display = "none";
			document.getElementById("qksmTbody").style.display = "none";
		}
	}
} 
	
	
// 情况说明设置
function f_setqksmTbody(t){
	if(t.checked){
		document.getElementById("qksmTbody").style.display = "";
	}else{
		document.getElementById("qksmTbody").style.display = "none";
	}
}


// 计算总人数
function f_countPeopleTotal(){
	var countPeoples = document.getElementsByName("countPeople");
	var totalTemp = "0";
	for(var i=0;i<countPeoples.length;i++ ){
		if(countPeoples[i].value!=""){
			totalTemp = totalTemp*1 + countPeoples[i].value*1;
		}
	}
	document.getElementById("countPeopleTotal").value = totalTemp;
}


// 计算总工时
function f_countHourTotal(){
	var countHours = document.getElementsByName("countHour");
	var totalTemp = "0";
	for(var i=0;i<countHours.length;i++ ){
		if(countHours[i].value!=""){
			totalTemp = totalTemp*1 + countHours[i].value*1;
		}
	}
	document.getElementById("countHourTotal").value = totalTemp;
}

// 计算总金额
function f_countMoneyTotal(){
	var countMoneys = document.getElementsByName("countMoney");
	var totalTemp = "0";
	for(var i=0;i<countMoneys.length;i++ ){
		if(countMoneys[i].value!=""){
			totalTemp = totalTemp*1 + countMoneys[i].value*1;
		}
	}
	document.getElementById("countMoneyTotal").value = totalTemp;
	if(totalTemp*1<0){
		document.getElementById("countMoneyTotal").style.color = "red";
	}else{
		document.getElementById("countMoneyTotal").style.color = "black";
	}
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

// 作废
function f_cancel(){
	document.getElementById("divBlock").style.display="";
 	document.getElementById("tzf").style.display = "";
 	//document.getElementById("bbreason").value="";
}

// 返回
function goback(){	
	window.location="${pageContext.request.contextPath}/common/bb.do?method=goFsList";
}

// 取消
function f_qx(){	
	 document.getElementById("divBlock").style.display="none";
	 document.getElementById("tzf").style.display = "none";
	 document.getElementById("bbreason").value="";
}

// 确定
function f_sure(){
	var reportCount = document.getElementById("reportCount").value;
	var ctguid = document.getElementById("ctguid").value;
	var bbreason = document.getElementById("bbreason").value;
	var typeid = document.getElementById("typeid").value;
	var bbstate = document.getElementById("bbstate").value;
	if(bbreason=="" || bbreason==null){
		alert("作废原因不能为空!");
	}else{
		if(confirm("您确定要作废吗?")){
			var url="${pageContext.request.contextPath}/common/content.do?method=invalid";
			request = "&ctguid="+ctguid+"&bbreason="+bbreason+"&reportCount="+reportCount+"&typeid="+typeid+"&bbstate="+bbstate;
			var resText = ajaxLoadPageSynch(url,request);
			if(resText=="cannot"){
				alert("报备时间超过一个月，不能进行作废了 !"); 
			}else{
				if(resText=="true"){
					alert("作废成功 !");
					window.location="${pageContext.request.contextPath}/common/bb.do?method=index&typeid="+typeid;
				}else{
					alert("作废失败 !");
					window.location="${pageContext.request.contextPath}/common/bb.do?method=index&typeid="+typeid;
				}
			}
			
		}
		 document.getElementById("divBlock").style.display="none";
		 document.getElementById("tzf").style.display = "none";
		 document.getElementById("bbreason").value="";
	}
}



// 解决两个小数相加出现多位小数位的问题3
function f_addNum(num1,num2){
	var sq1,sq2,m;
	try{sq1=num1.toString().split(".")[1].length;} catch(e){sq1=0;}
	try{sq2=num2.toString().split(".")[1].length;} catch(e){sq2=0;}
	
	m=Math.pow(10,Math.max(sq1,sq2));
	return ( num1 * m + num2 * m ) / m;
}

//审核通过
function pass(guid){
	if(confirm("是否审核通过？")){
		window.location = "${pageContext.request.contextPath}/common/bb.do?method=passOrNopass&p=pass&guid="+guid;
	}
}
//审核不通过
function nopass(guid){
	if(confirm("是否审核不通过？")){
		window.location = "${pageContext.request.contextPath}/common/bb.do?method=passOrNopass&p=nopass&guid="+guid;
	}
}
</script>

</html>