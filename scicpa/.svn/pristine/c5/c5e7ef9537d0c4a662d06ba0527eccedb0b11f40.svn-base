<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
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
<input type="hidden" id="typeid" name="typeid" value="${typeid}">
<input type="hidden" id="tempORFinish" name="tempORFinish" value="">
<input type="hidden" id="bbstate" name="bbstate" value="${ct.bbstate }" >
<input type="hidden" id="isUpdateTime" name="isUpdateTime" value="">
<input type="hidden" id="bcbBtn" name="bcbBtn" value="保存" >
<input type="hidden" id="isPass" name="isPass" value="Y" >
<input type="hidden" id="standerPrice" name="standerPrice" value="${at.standerPrice}">
<input type="hidden" id="zdsfbzje" name="zdsfbzje" value="${ct.zdsfbzje}">
<input type="hidden" id="isnexts" name="isnexts" value="${ct.isnexts}">
<input type="hidden" id="sflkh" name="sflkh" value="${ct.sflkh}">
<input type="hidden" id="attachfileId" name="attachfileId" value="${ct.attachfileId}">
<input type="hidden" id="ysywfedUpdateTime" name="ysywfedUpdateTime" value="${ct.ysywfedUpdateTime}">
<input type="hidden" id="kjskdfphd2UpdateTime" name="kjskdfphd2UpdateTime" value="${ct.kjskdfphd2UpdateTime}">
<input type="hidden" id="syskhlx" name="syskhlx" value="${ct.syskhlx}">
<input type="hidden" id="isoverflow" name="isoverflow" value="${ct.isoverflow}">
<input type="hidden" id="autoAudit" name="autoAudit" value="${at.autoAudit}">
<input type="hidden" id="isnext" name="isnext" value="${at.isnext}">
<input type="hidden" id="iszxw" name="iszxw" value="${at.iszxw}">
<input type="hidden" id="standerPrice" name="standerPrice" value="${at.standerPrice}">
<input type="hidden" id="discountBySeven" name="discountBySeven" value="${ct.discountBySeven}">

<input type="hidden" id="cpa1" name="cpa1" value="${ct.cpa1 }"/>
<input type="hidden" id="cpa2" name="cpa2" value="${ct.cpa2 }"/>
<input type="hidden" id="cpa3" name="cpa3" value="${ct.cpa3 }"/>
<input type="hidden" id="cpa4" name="cpa4" value="${ct.cpa4 }"/>
<input type="hidden" id="cpa5" name="cpa5" value="${ct.cpa5 }"/>
<input type="hidden" id="cpa6" name="cpa6" value="${ct.cpa6 }"/>

<div id="divBlock" style="position:absolute;width:100%;height:100%; top:expression(this.offsetParent.scrollTop); z-index:1; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;">
</div>

<table width="98%" height="5%" border="0" cellspacing="0" cellpadding="0">
	<tr align="center">
		<td width="70%" align="center">
		 	<center class="formTitle">
				${ct.wtxmlx }<br>
			</center>
		</td>
	</tr> 
	 
</table>

<c:if test="${ct.bbbh != null}">
<div id="bbnum" style="text-align: center;">
		防伪编号：<input style="background-color: white;border: 0px" value="${ct.bbbh}"" id="bbbh" name="bbbh" readonly="readonly" size="30" >
</div>
</c:if>	
<br>	
<DIV class=block id=search style="width: 99%;overflow-x:auto;">

<H3 class=tabs id=searchtabs>
	<A class="tab" id="dbswszltab" href="javascript:setTab('search','dbswszl')">报备事务所资料</A> 
	<A class="tab curtab" id="nrytab" href="javascript:setTab('search','nry')">报备内容一</A>
	<A class="tab" id="nretab" href="javascript:setTab('search','nre')">报备内容二</A>
	<A class="tab" id="nrstab" href="javascript:setTab('search','nrs')">附件</A>
	<c:choose>
		<c:when test="${ct.bbstate=='审核通过'}">
			<div id="fsave" style="margin-left: 58%;margin-top: 1%">
		</c:when>
		<c:otherwise>
		   <div id="fsave" style="margin-left: 78%;margin-top: 1%">
		</c:otherwise>
	</c:choose>
			<!-- 
			<c:if test="${userSession.userMap.sys_province_cicpa=='广东省注协' && (typeid=='qchz001' || typeid=='qssh001' || typeid=='sj001' || typeid=='whnj001' || typeid=='yz001' || typeid=='sfkjjd001' || typeid=='bbqt001' || typeid=='flsj001' || typeid=='hbsj001')}">
			  <input type="button" icon="icon-method" name="ysywfBtn" id="ysywfBtn" value="发改委、财政厅收费标准" onclick="f_countYsywf();">
			</c:if>
			 -->
			 
			<c:choose>
				<c:when test="${ct.bbstate=='审核通过'}">
				    <input type="button" icon="icon-method" name="ysywfBtn" id="ysywfBtn" value="发改委、财政厅收费标准" onclick="f_countYsywf();">
					<input type="button" icon="icon-save" name="bcb" id="bcb" value="报备完成" onclick="saveCompanyJudge();">
				</c:when>
				<c:otherwise>
				    <input type="button" icon="icon-save" name="bcb" id="bcb" value="保  存" onclick="saveCompanyJudge();">
				</c:otherwise>
			</c:choose>
			<input id="fh" type="button" name="next" value="返  回" icon="icon-back" class="flyBT" onclick="goback();">
	</div>
</H3>


<div class=tabcontent id="dbswszl" style="text-align: center;display: none"> 

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
			<input name="companyName" type="hidden" id="companyName" style="width: 90%" value="${clt.companyName }" readonly="readonly">
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
		<td class="data_tb_content" colspan="3" width="30%" height="18">${clt.area}
			<input name="area"   type="hidden" id="area" style="width: 90%" value="${clt.area}">
		</td>
	</tr>
	 
	
 	<tr>
		<td class="data_tb_alignright" width="20%" height="18">联系人<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" height="18" colspan="3"> 
			<input maxlength="100" name="linkman" class="required" type="text" id="linkman"  style="width: 25%" value = "${ct.linkman}" >
		</td>
	</tr>
	
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">联系电话<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" height="18" colspan="3"> 
			<input maxlength="100" name="linkphone" class="required" type="text" id="linkphone"  style="width: 25%" value = "${ct.linkphone }" >
		</td>
	</tr>
	
	
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">传&nbsp;&nbsp;&nbsp;&nbsp;真<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input maxlength="50" name="faxes" myClass="phone" class="required" type="text" id="faxes" style="width: 68%" value="${clt.faxes }" >
		</td>
		<td class="data_tb_alignright" height="18">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;编<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" height="18"> 
			<input maxlength="50" name="post" myClass="number" class="required" type="text" id="post"  style="width: 83%"  value = "${clt.post }" >
		</td>
	</tr>
	
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">地&nbsp;&nbsp;&nbsp;&nbsp;址<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" height="18" colspan="3"> 
			<input maxlength="100" name="address" class="required" type="text" id="address" style="width: 95%" value = "${clt.address }" >
		</td>
	</tr>
	
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">E-Mial<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input maxlength="50" name="email" class="required" type="text" myClass="email" id="email" style="width: 68%" value="${clt.email }" >
		</td>
		<td class="data_tb_alignright" height="18">网&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址&nbsp;</td>
		<td class="data_tb_content" height="18"> 
			<input maxlength="50" name="url" type="text" id="url" style="width: 83%" value = "${clt.url }" >
		</td>
	</tr>
</table>
</div>


<div class=tabcontent id="nry"
	style="text-align: center;"> 
	
<table cellSpacing="0" cellPadding="5" class="data_tb" width="100%" >
  <tr>
    <td class="data_tb_alignright" style="text-align: left;" colspan="4" height="16">客户信息</td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">委托单位名称<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23" class="data_tb_content"><input maxlength="300" title="委托单位名称" id="wtdwmc" value="${ct.wtdwmc }" name="wtdwmc"style="width: 85%" class="required"></td>
    <td width="20%" height="23" class="data_tb_alignright">被审(验)单位名称<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23" class="data_tb_content"><input maxlength="300" title="被审验单位名称" id="bsdwmc" value="${ct.bsdwmc }" name="bsdwmc" style="width: 85%" class="required"></td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">被审(验)单位出资类型<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23" class="data_tb_content"><input maxlength="50" onfocus="onPopDivClick(this);" 
    					noinput=true
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=4
						hideresult=true title="客户出资类型" id="khczlx" value="${ct.khczlx }" name="khczlx" style="width: 85%" class="required"></td>
    <td width="20%" height="23" class="data_tb_alignright">营业执照号码或核准通知书号<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23" class="data_tb_content"><input maxlength="300" title="营业执照号码或核准通知书号" id="yyzzhm" value="${ct.yyzzhm }" name="yyzzhm" style="width: 85%" class="required"></td>
  </tr>
  <tr>
    <td width="20%" height="46" class="data_tb_alignright">被审(验)单位经济性质<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="46" class="data_tb_content"><input maxlength="50" onfocus="onPopDivClick(this);"
    					noinput=true
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=11
						hideresult=true title="客户经济性质" id="khjjxj" value="${ct.khjjxj }" name="khjjxj" style="width: 85%" class="required"></td>
    <td width="20%" height="46" class="data_tb_alignright">被审（验）单位实收资本<font color="#FF0000" >&nbsp;[*]</font></td>
    <td width="30%" height="46" class="data_tb_content"> 
    	<input maxlength="20" id="bsdwzczb" value="${ct.bsdwzczb }" style="width: 75%" name="bsdwzczb" class="required number" onkeyup="f_moneys(this);" onpaste="return false" >万元&nbsp;&nbsp;&nbsp;&nbsp; <br />
    	 <input maxlength="20" id="zczbbz" value="${ct.zczbbz }" style="width: 75%" name="zczbbz" class="required" onfocus="onPopDivClick(this);"
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
    <td width="30%" height="23" class="data_tb_content"><input maxlength="50" onfocus="onPopDivClick(this);"
    					noinput=true
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true 
						autoid=55
						refer="dic_kmhylx"
						hideresult=true title="客户行业类型" id="kmhylx" value='${ct.kmhylx }' name="kmhylx" style="width: 85%" class="required"></td>
    <td width="20%" height="23" class="data_tb_alignright">是否上市企业<font color="#FF0000" class="required">&nbsp;[*]</font></td>
    <td width="30%" height="23" class="data_tb_content">
		<input maxlength="50" onfocus="onPopDivClick(this);"
    					noinput=true
    					autoWidth=190
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);" 
						norestorehint=true
						autoid=13
						hideresult=true title="是否上市企业" id="sfssqy" value="${ct.sfssqy }" style="width: 85%" name="sfssqy" class="required"> 
	</td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">注册地址</td>
    <td width="80%" colspan="3" height="23" class="data_tb_content"><input maxlength="300" id="zcdz" value="${ct.zcdz }" name="zcdz" style="width: 95%"></td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">负责人姓名</td>
    <td width="30%" height="23" class="data_tb_content"><input maxlength="50" id="fzrmc" value="${ct.fzrmc }" name="fzrmc" style="width: 85%"></td>
    <td class="data_tb_alignright" width="20%">项目客户类型<font color="#FF0000" class="required">&nbsp;[*]</font></td>
    <td class="data_tb_content" width="30%">
    	<input maxlength="50" id="xmkhlx" value="${ct.xmkhlx }" name="xmkhlx" onfocus="onPopDivClick(this);"
    					autoWidth=190
    					autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						noinput=true
						autoid=55 refer="projectCustomerTypes" style="width: 85%" class="required">
	</td>
  </tr>
  <tr>
    <td width="20%" height="23" class="data_tb_alignright">联系人电话</td>
    <td width="30%" height="23" class="data_tb_content"><input maxlength="50" id="lxrdh" value="${ct.lxrdh }" name="lxrdh" style="width: 85%" class="phone"></td>
 	<td width="20%" height="23" class="data_tb_alignright">联系人姓名</td>
    <td width="30%" height="23" class="data_tb_content"><input maxlength="50" id="lxrxm" value="${ct.lxrxm }" name="lxrxm" style="width: 85%"></td>
  </tr>
  <tr>
    <td class="data_tb_alignright" style="text-align: left;" colspan="4" height="16">业务信息</td>
  </tr>
  <tr>
    <td width="20%" height="10" class="data_tb_alignright">是否打包项目<font color="#FF0000">&nbsp;[*]</font></td>
	<td width="30%" height="23" class="data_tb_content">
		${ct.sfdbxm}
	</td>
	<td width="20%" height="10" class="data_tb_alignright">是否招投标<font color="#FF0000">&nbsp;[*]</font></td>
	<td width="30%" height="23" class="data_tb_content">${ct.sfztb}</td>
  </tr>
  <tr>
    <td width="20%" class="data_tb_alignright" id="dbxm1" <c:if test="${ct.sfdbxm=='是' }">style='display:;'</c:if><c:if test="${ct.sfdbxm!='是' }">style='display:none;'</c:if> >打包项目名称<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" class="data_tb_content" id="dbxm2" colspan="3" <c:if test="${ct.sfdbxm=='是' }">style='display:;'</c:if><c:if test="${ct.sfdbxm!='是' }">style='display:none;'</c:if> ><input type="text" maxlength="250" title="打包项目名称" id="dbxmmc" value="${ct.dbxmmc }" style="width: 95%" name="dbxmmc"></td>
  </tr>
  <tr>
    <td width="20%" height="10" class="data_tb_alignright">委托项目类型<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="10" class="data_tb_content"><input maxlength="50" title="委托项目类型" id="wtxmlx" readonly="readonly" value="${ct.wtxmlx }" style="width: 85%" name="wtxmlx" class="required"></td>
    <td class="data_tb_alignright" width="20%" class="data_tb_alignright">业务约定书号码<font color="#FF0000">&nbsp;[*]</font></td>
    <td class="data_tb_content" width="30%" class="data_tb_content"><input maxlength="50" title="业务约定书号码" id="ywyds" value="${ct.ywyds }" style="width: 85%" name="ywyds" class="required"></td>
  </tr>
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">签约日期&nbsp;</td>
    <td width="30%" height="16" class="data_tb_content"><input maxlength="50" id="qyrq" value="${ct.qyrq }" style="width: 70%" name="qyrq" ></td>
    <td width="20%" height="16" class="data_tb_alignright">报告文号<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="16" class="data_tb_content"><input maxlength="50" title="报告文号" id="bgwh" value="${ct.bgwh }" name="bgwh" style="width: 85%" class="required"></td>
  </tr>
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">项目名称<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="80%" height="16" colspan="3" class="data_tb_content"><input maxlength="300" title="项目名称" id="xmmc" value="${ct.xmmc }" name="xmmc" style="width: 95%" class="required"></td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%">
    	签名注师一<c:if test="${typeid!='kjdsh001' && typeid!='kjzs001' && typeid!='swdl001' && typeid!='bbqt001'}"><font color="#FF0000">&nbsp;[*]</font></c:if>
    </td>
    <td class="data_tb_content" width="30%">
		<input maxlength="50" id="qmzs1" name="qmzs1" value="${ct.qmzs1 }"
						<c:if test="${typeid!='kjdsh001' && typeid!='kjzs001' && typeid!='swdl001' && typeid!='bbqt001'}">
							class="required"  
						</c:if>
						onfocus="onPopDivClick(this);"
			 			onchange="isQmzs(this,'1');"
    					noinput=true
    					autoWidth=190
						autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						hideresult=true 
						style="width: 85%"
						refer="${userSession.userMap.officecode }" 
		    			autoid="50" title="签名注师一"
				    	>
	</td>
    <td class="data_tb_alignright" width="20%">
    	签名注师二<c:if test="${typeid!='kjdsh001' && typeid!='kjzs001' && typeid!='swdl001' && typeid!='bbqt001'}"><font color="#FF0000">&nbsp;[*]</font></c:if>
	</td>
    <td class="data_tb_content" width="30%">
		<input maxlength="50" id="qmzs2" name="qmzs2" value="${ct.qmzs2 }" 
				<c:if test="${typeid!='kjdsh001' && typeid!='kjzs001' && typeid!='swdl001' && typeid!='bbqt001'}">
					class="required"  
				</c:if>
				onfocus="onPopDivClick(this);"
				onchange="isQmzs(this,'2');"
  					noinput=true
  					autoWidth=190
				autoHeight=180
				onkeydown="onKeyDownEvent();"
				onkeyup="onKeyUpEvent();"
				onclick="onPopDivClick(this);"
				norestorehint=true
				hideresult=true 
				style="width: 85%"
				refer="${userSession.userMap.officecode }"
		    	autoid="50" title="签名注师二"
				>
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
		<input maxlength="50" id="qmzs3" name="qmzs3" value="${ct.qmzs3 }" onfocus="onPopDivClick(this);"
    					noinput=true
    					autoWidth=190
						autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						onchange="isQmzs(this,'3');"
						norestorehint=true
						refer = "${userSession.userMap.officecode }"
						hideresult=true 
						style="width: 85%" 
						<c:choose>
				    		<c:when test="${typeid=='dxzhpg001' || typeid=='jrblpg001' || typeid=='qtzcpg001' || typeid=='qyjzpg001' }">
				    			autoid="60" title="签名评估师三"
				    		</c:when>
				    		<c:otherwise>
				    			autoid="50" title="签名注师三"
				    		</c:otherwise>
				    	</c:choose>  
						>
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
		<input maxlength="50" id="qmzs4" value="${ct.qmzs4 }" name="qmzs4" onfocus="onPopDivClick(this);"
    					noinput=true
    					autoWidth=190
						autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
			 			onchange="isQmzs(this,'4');"
						norestorehint=true
						refer = "${userSession.userMap.officecode }"
						hideresult=true 
						style="width: 85%" 
						<c:choose>
				    		<c:when test="${typeid=='dxzhpg001' || typeid=='jrblpg001' || typeid=='qtzcpg001' || typeid=='qyjzpg001' }">
				    			autoid="60" title="签名评估师四"
				    		</c:when>
				    		<c:otherwise>
				    			autoid="50" title="签名注师四"
				    		</c:otherwise>
				    	</c:choose>   
				    	>
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
		<input maxlength="50" id="qmzs5" name="qmzs5" value="${ct.qmzs5 }"  onfocus="onPopDivClick(this);"
    					noinput=true
    					autoWidth=190
						autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
			 			onchange="isQmzs(this,'5');"
						norestorehint=true
						refer = "${userSession.userMap.officecode }"
						hideresult=true 
						style="width: 85%"
						<c:choose>
				    		<c:when test="${typeid=='dxzhpg001' || typeid=='jrblpg001' || typeid=='qtzcpg001' || typeid=='qyjzpg001' }">
				    			autoid="60" title="签名评估师五"
				    		</c:when>
				    		<c:otherwise>
				    			autoid="50" title="签名注师五"
				    		</c:otherwise>
				    	</c:choose>  
						>
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
		<input maxlength="50" id="qmzs6" name="qmzs6" value="${ct.qmzs6}" onfocus="onPopDivClick(this);"
    					noinput=true
    					autoWidth=190
						autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
			 			onchange="isQmzs(this,'6');"
						norestorehint=true
						refer = "${userSession.userMap.officecode }"
						hideresult=true 
						style="width: 85%" 
						<c:choose>
				    		<c:when test="${typeid=='dxzhpg001' || typeid=='jrblpg001' || typeid=='qtzcpg001' || typeid=='qyjzpg001' }">
				    			autoid="60" title="签名评估师六"
				    		</c:when>
				    		<c:otherwise>
				    			autoid="50" title="签名注师六"
				    		</c:otherwise>
				    	</c:choose>   
						>
	</td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%">
    	其他参与注师
	</td>
    <td class="data_tb_content" width="30%">
		${ct.qtcyzs }
	</td>
	<td class="data_tb_alignright" width="20%">发出报告份数</td>
    <td class="data_tb_content" width="30%"><input maxlength="50" id="fcbgfs" value="${ct.fcbgfs }" style="width: 85%" name="fcbgfs" class="number" onkeyup="f_moneys(this);" ></td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%">助理人员&nbsp;</td>
    <td class="data_tb_content" width="30%"><input maxlength="50" style="height: 0px;" id="zlry" value="${ct.zlry }" name="zlry" style="width: 85%"></td>
    <td class="data_tb_alignright" width="20%">被审(验)单位注册地址<font color="#FF0000" class="required">&nbsp;[*]</font></td>
    <td class="data_tb_content" width="30%"><input maxlength="50" onfocus="onPopDivClick(this);" title="被审(验)单位注册地址"
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
						hideresult=true id="ywarea" value="${ct.ywarea}" style="width: 85%" name="ywarea"></td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%">报告日期<font color="#FF0000">&nbsp;[*]</font></td>
    <td class="data_tb_content" width="30%">
    	<input maxlength="50" id="bgrq" value="${ct.bgrq }" style="width: 70%" name="bgrq" class="required" onkeypress="return false;" onpaste="return false;" >
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
    <td width="80%" height="16" colspan="3" class="data_tb_content"><textarea id="leaveword" name="leaveword" style="width: 95%;height: 90%">${ct.leaveword }</textarea></td>
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
    <td class="data_tb_alignright" width="20%">业务约定书收费金额<font color="#FF0000">&nbsp;[*]</font></td>
    <td class="data_tb_content" width="30%"><input maxlength="20"  title="只能输入数字" id="ysywf" value="${ct.ysywf }" style="width: 60%" name="ysywf" class="required number" onkeyup="f_moneys(this);" onpaste="return false" >元(人民币)</td>
    <td class="data_tb_alignright" width="20%" height="16">收费日期</td>
    <td width="30%" height="16" class="data_tb_content"><input maxlength="20" id="sfrq" value="${ct.sfrq}" name="sfrq" style="width: 70%" showcalendar="true" onkeypress="return false;" onpaste="return false;"></td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%" >已收业务费</td>
    <td width="30%" class="data_tb_content"><input maxlength="20" id="ysywfed" value="${ct.ysywfed }" style="width: 60%" name="ysywfed" class="number" onkeyup="f_moneys(this);" onpaste="return false" >元(人民币)</td>
    <td class="data_tb_alignright" width="20%" height="16">收费依据</td>
    <td width="30%" height="16" class="data_tb_content"><input maxlength="50" onfocus="onPopDivClick(this);"
    					noinput=true 
    					autoWidth=190
    					autoHeight=150
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=15
						hideresult=true title="收费依据" id="sfyj" value="${ct.sfyj }" name="sfyj" style="width: 85%" ></td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%" height="16">开具收款发票号码</td>
    <td width="30%" height="16" class="data_tb_content" colspan="3">
    	<input maxlength="250" id="kjskdfphd" value="${ct.kjskdfphd }" name="kjskdfphd" size="50">
    	<input maxlength="250" id="kjskdfphd2" value="${ct.kjskdfphd2 }" name="kjskdfphd2" size="42" style="margin-left: 55px;"><br>
    	<font color="red">如有多张发票，请将多个发票号填入框中，多个发票号之间可用逗号分割。</font>
    </td>
  </tr>
   
  <tr>
    <td class="data_tb_alignright" width="20%" height="16">收费说明</td>
    <td width="30%" height="16" class="data_tb_content" colspan="3">
    	<textarea id="sfsm" name="sfsm" style="width: 85%;height: 30px;">${ct.sfsm }</textarea>
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
			  <tr>
			  	<td ><input type="text" id="duty1" name="duty" value="助理" size=5 readonly="readonly" style="border: 0px;width: 90%;text-align: center;"></td>
			    <td ><input type="text" id="countPeople1" name="countPeople" value="${mapTotal.assistant.countPeople }" onkeyup="f_number(this);f_countPeopleTotal();" size=5></td>
			  	<td ><input type="text" id="countHour1" name="countHour" value="${mapTotal.assistant.countHour }" onkeyup="f_moneys(this);f_countHourTotal();" size=5>小时</td>
			    <td ><input type="text" id="countMoney1" name="countMoney" value="${mapTotal.assistant.countMoney }" onkeyup="f_moneys(this);f_countMoneyTotal();" size=12 style="text-align: right;">元(人民币)</td>
			  	<td ><textarea id="property2" name="property" style="width: 95%">${mapTotal.assistant.propertys }</textarea></td>
			  </tr>
			  <tr>
			  	<td ><input type="text" id="duty2" name="duty" value="注册会计师" size=5 readonly="readonly" style="border: 0px;width: 90%;text-align: center;"></td>
			    <td ><input type="text" id="countPeople2" name="countPeople" value="${mapTotal.cpa.countPeople }" onkeyup="f_number(this);f_countPeopleTotal();" size=5></td>
			  	<td ><input type="text" id="countHour2" name="countHour" value="${mapTotal.cpa.countHour }" onkeyup="f_moneys(this);f_countHourTotal();" size=5>小时</td>
			    <td ><input type="text" id="countMoney2" name="countMoney" value="${mapTotal.cpa.countMoney }" onkeyup="f_moneys(this);f_countMoneyTotal();" size=12 style="text-align: right;">元(人民币)</td>
			  	<td ><textarea id="property3" name="property" style="width: 95%">${mapTotal.cpa.propertys }</textarea></td>
			  </tr>
			  <tr>
			  	<td ><input type="text" id="duty3" name="duty" value="项目经理" size=5 readonly="readonly" style="border: 0px;width: 90%;text-align: center;"></td>
			    <td ><input type="text" id="countPeople3" name="countPeople" value="${mapTotal.projecter.countPeople }" onkeyup="f_number(this);f_countPeopleTotal();" size=5></td>
			  	<td ><input type="text" id="countHour3" name="countHour" value="${mapTotal.projecter.countHour }" onkeyup="f_moneys(this);f_countHourTotal();" size=5>小时</td>
			    <td ><input type="text" id="countMoney3" name="countMoney" value="${mapTotal.projecter.countMoney }" onkeyup="f_moneys(this);f_countMoneyTotal();" size=12 style="text-align: right;">元(人民币)</td>
			  	<td ><textarea id="property4" name="property" style="width: 95%">${mapTotal.projecter.propertys }</textarea></td>
			  </tr>
			  <tr>
			  	<td ><input type="text" id="duty4" name="duty" value="部门经理" size=5 readonly="readonly" style="border: 0px;width: 90%;text-align: center;"></td>
			    <td ><input type="text" id="countPeople4" name="countPeople" value="${mapTotal.department.countPeople }" onkeyup="f_number(this);f_countPeopleTotal();" size=5></td>
			  	<td ><input type="text" id="countHour4" name="countHour" value="${mapTotal.department.countHour }" onkeyup="f_moneys(this);f_countHourTotal();" size=5>小时</td>
			    <td ><input type="text" id="countMoney4" name="countMoney" value="${mapTotal.department.countMoney }" onkeyup="f_moneys(this);f_countMoneyTotal();" size=12 style="text-align: right;">元(人民币)</td>
			  	<td ><textarea id="property5" name="property" style="width: 95%">${mapTotal.department.propertys }</textarea></td>
			  </tr>
			  <tr>
			  	<td ><input type="text" id="duty5" name="duty" value="主任会计师" size=5 readonly="readonly" style="border: 0px;width: 90%;text-align: center;"></td>
			    <td ><input type="text" id="countPeople5" name="countPeople" value="${mapTotal.chairman.countPeople }" onkeyup="f_number(this);f_countPeopleTotal();" size=5></td>
			  	<td ><input type="text" id="countHour5" name="countHour" value="${mapTotal.chairman.countHour }" onkeyup="f_moneys(this);f_countHourTotal();" size=5>小时</td>
			    <td ><input type="text" id="countMoney5" name="countMoney" value="${mapTotal.chairman.countMoney }" onkeyup="f_moneys(this);f_countMoneyTotal();" size=12 style="text-align: right;">元(人民币)</td>
			  	<td ><textarea id="property6" name="property" style="width: 95%">${mapTotal.chairman.propertys }</textarea></td>
			  </tr>
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

<div class=tabcontent id="nre" style="text-align: center; display: none;"> 
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


<div id="reasonDivBig" style="position:absolute;width:100%;height:100%; top:expression(this.offsetParent.scrollTop); z-index:1; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;">
</div>
<div id="reasonDiv" style="position:absolute;width:80%;height:10%; z-index:2;left:expression((document.body.clientWidth-600)/2);top:expression(this.offsetParent.scrollTop + 130); border:1px solid #6595d6; padding:10px; background:#ffffff;text-align:center; display: none;">
   
   <table width="90%">
   	<tr>
   		<td>
	   	 	修&nbsp;&nbsp;改&nbsp;&nbsp;原&nbsp;&nbsp;因：<font color="red">[*]</font>
	    	<textarea title="修改原因" class="data_tb_content" id="changeReason" name="changeReason" style="width: 80%;height: 100px;vertical-align: middle;"></textarea>
    	</td>
    </tr>
    </table>
   <ul style="list-style: none;">
    <li>
    	<input type="button" value="确  定" onclick="f_sure()"/>
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<input icon="icon-delete" type="button" value="取  消" onclick="f_cancle()"/>
    </li>
  </ul>
    	
 </div>

</form>
 
</body>

<script>
	
	//附件上传处理
	var _forbitUpload = false;
	var _forbitDel = false;
	var _bbstate = "${ct.bbstate}";
	//if(_bbstate=="初审通过" || _bbstate=="审核通过" || _bbstate=="报备完成" || _bbstate=="作废"){
	if( _bbstate=="报备完成" ){
		//_forbitUpload = true;
		_forbitDel = true;
	}

	// 附件
	$('#bb_attachfileId').uploadFile({
		indexId: '${ct.attachfileId}',
		module:'bb_content1',
		forbitUpload:_forbitUpload,
		forbitDel:_forbitDel
	});

// 计算两个日期的间隔天数
 function  DateDiff(sDate1,  sDate2){    
 	//sDate1和sDate2是2002-12-18格式  
     var  aDate,  oDate1,  oDate2,  iDays  
     aDate  =  sDate1.split("-")  
     oDate1  =  new  Date(aDate[1]  +  '-'  +  aDate[2]  +  '-'  +  aDate[0])    //转换为12-18-2002格式  
     aDate  =  sDate2.split("-")  
     oDate2  =  new  Date(aDate[1]  +  '-'  +  aDate[2]  +  '-'  +  aDate[0])  
     iDays  =  parseInt(Math.abs(oDate1  -  oDate2)  /  1000  /  60  /  60  /24)    //把相差的毫秒数转换为天数  
     return  iDays  
} 
	
	

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
	}else{
	
		var nowTime = getDate().substring(0,10);
		
		var ysywfedUpdateTime = "${ct.ysywfedUpdateTime}";
		if(ysywfedUpdateTime=="" || ysywfedUpdateTime==null || ysywfedUpdateTime=="null"){
			ysywfedUpdateTime = "${ct.bbtime}";
		}
		ysywfedUpdateTime = ysywfedUpdateTime.substring(0,10);
		
		var kjskdfphd2UpdateTime = "${ct.kjskdfphd2UpdateTime}";
		if(kjskdfphd2UpdateTime=="" || kjskdfphd2UpdateTime==null || kjskdfphd2UpdateTime=="null"){
			kjskdfphd2UpdateTime = "${ct.bbtime}";
		}
		kjskdfphd2UpdateTime = kjskdfphd2UpdateTime.substring(0,10);
		
		$("input").each(function(index,obj){
			if(obj.id == "ysywfed" && "${ct.bbstate}"=="报备完成"){
				//  报备完成后不能修改报备时间
				document.getElementById("isUpdateTime").value = "N";
				
				// 报备完成：已收业务费 和 发票号码第二个框 的值不为空的情况下 的 2 个星期后不能修改 
				if("${ct.ysywfed}"!="" && "${ct.ysywfed}"!=0 && DateDiff(nowTime,ysywfedUpdateTime)>14 ){
					obj.readOnly = true ;
					obj.className = "before";
				}
			}else if(obj.id=="kjskdfphd2" && "${ct.bbstate}"=="报备完成"){
				//  报备完成后不能修改报备时间
				document.getElementById("isUpdateTime").value = "N"; 
				
				// 报备完成：已收业务费 和 发票号码第二个框 的值不为空的情况下 的 2 个星期后不能修改 
				/* if("${ct.kjskdfphd2}"!="" && "${ct.kjskdfphd2}"!=0 && DateDiff(nowTime,kjskdfphd2UpdateTime)>14 ){
					obj.readOnly = true ;
					obj.className = "before";
				} */
			}else if(obj.id=="zcdz" || obj.id=="fzrmc" || obj.id=="lxrxm" || obj.id=="lxrdh" || obj.id=="sfrq" 
					|| obj.id=="khczlx" || obj.id=="khjjxj" || obj.id=="zczbbz" || obj.id=="kmhylx" 
					|| obj.id=="sfssqy" || obj.id=="ywarea" || obj.id=="xmkhlx" || obj.id=="file" || obj.id=="upload_Btn" || obj.id=="upload_Cle" ){
				//  报备完成后不能修改报备时间
				document.getElementById("isUpdateTime").value = "N"; 
			}else{
				obj.readOnly = true ;
				obj.className = "before";
			}
		});
		
		
		$("textarea").each(function(index,obj){
			if(obj.id == 'sfsm' || obj.id=='changeReason'){
				obj.readOnly = "" ;
				obj.className = "";
			}else{
				obj.readOnly = true ;
				obj.className = "before";
			}
		});
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
	}
	var isauditProperyObj = document.getElementById("isauditPropery");
	f_setqksmTbody(isauditProperyObj);
	

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
	if(t.checked || t.value=="是"){
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
			totalTemp = f_addNum(totalTemp*1,countHours[i].value*1);
		}
	}
	document.getElementById("countHourTotal").value = totalTemp;
}

// 计算总金额
function f_countMoneyTotal(){
	var countMoneys = document.getElementsByName("countMoney");
	var totalTemp = 0;
	for(var i=0;i<countMoneys.length;i++ ){
		if(countMoneys[i].value!=""){
			totalTemp = f_addNum(totalTemp*1,countMoneys[i].value*1);
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

// 保存
function saveCompanyJudge(){
	// 判断当前报备数据状态是否与数据库最新状态一致
	if(!f_checkSaveState()){
		alert("注协刚刚已审核过该报备数据状态，请先返回到列表页面后再进行当前操作！");
		return;
	}
	
	// 报备业务所在地如果包含广州、东莞就提示说不能报备完成
	var ywareaObj = document.getElementById("ywarea");
	if(ywareaObj.value.indexOf("广州")>-1 || ywareaObj.value.indexOf("东莞")>-1){
		setTab('search','nry');
		ywareaObj.select();
		alert("请到该业务所在地的的所属市注协报备系统报备！");
		return;
	}

	// 如果是其他类型的报备 并且 其它业务类型 字段 包含了 一下字眼 就提示不能进行报备完成
	var typeid = document.getElementById("typeid").value;
	if(typeid=="bbqt001"){
		var bustypeObj = document.getElementById("bustype");
		var bustypeArray = ["审计","验资","清算审计","合并审计","分立审计","清产核资","司法会计鉴定"];
		for(var i=0;i<bustypeArray.length;i++){
			if(bustypeObj.value.indexOf(bustypeArray[i])>-1){
				setTab('search','nre');
				bustypeObj.select();
				alert("请按正确报备类型报备，如有问题请与省注协联系！");
				return;
			}
		} 
	}
	
	// 如果是计时收费 那么 申请审核与报备完成的时候检查 应收业务费与总金额合计是否一致
	if(!f_jssf_same()){
		return;
	}
	
	/* 报备完成了可以进行保存报备数据，不用进行限数额控制
	// 验证报备份数
	var typeid = "${typeid}";
	if(typeid=="yz001"){
		var rs = f_getCPAYZReportCount();
		if(rs=="N"){
			return;
		}
	}else{
		var rs = f_getCPAFYZReportCount();
		if(rs=="N"){
			return;
		}
	}
	*/

	$.firstUnPassElemnt = null;
	$.hasUnPass = false;
	if(!$("#thisForm").valid()){
		if($.firstUnPassElemnt) {
			var parentObj = $.firstUnPassElemnt.parentElement;
			while(parentObj != null && parentObj.tagName != "DIV") {
				parentObj = parentObj.parentElement ;
			}
			if(parentObj.id == "dbswszl") {
				setTab('search','dbswszl') ;
			}else if(parentObj.id == "nry") {
				setTab('search','nry') ;
			}else if(parentObj.id == "nre") {
				setTab('search','nre') ;
			}
		}
		return;
	};
	
	//if(!isQmzs()) return false;
	if(!isOnly()) return;
	if(!isBusSum()) return;
	
	var typeid = document.getElementById("typeid").value;
	
	/*  
	报备完成之后 不让修改 应收业务费用
	// 验证 应收业务费用 和 省物价局规定的收费标准
	var sys_province_cicpa = "${userSession.userMap.sys_province_cicpa}";
	if(sys_province_cicpa=="广东省注协"){
		if(typeid=="qchz001" || typeid=="qssh001" || typeid=="sj001" || typeid=="whnj001" || typeid=="yz001" || typeid=="sfkjjd001" || typeid=="bbqt001" || typeid=="flsj001" || typeid=="hbsj001" ){
			if(f_checkMoney("N")!="ok") return;
		}
	}
	*/
	
	var yzbguid = document.getElementById("ctguid").value;
	var addJsp = document.getElementById("addJsp").value;
	var updateJsp = document.getElementById("updateJsp").value;

	var isPass = document.getElementById("isPass").value;
	
	// 比较是否有改动过信息,如果改动了必须填写原因	
	//khczlx   
	// 被审（验）单位出资类型
	var beforekhczlx = "${ct.khczlx}";
	var nowkhczlx = document.getElementById("khczlx").value;
	if(beforekhczlx!=nowkhczlx){
		isPass = "N";
	}
	//khjjxj 被审（验）单位经济性质
	var beforekhjjxj = "${ct.khjjxj}";
	var nowkhjjxj = document.getElementById("khjjxj").value;
	if(beforekhjjxj!=nowkhjjxj){
		isPass = "N";
	}
	//zczbbz 币种
	var beforezczbbz = "${ct.zczbbz}";
	var nowzczbbz = document.getElementById("zczbbz").value;
	if(beforezczbbz!=nowzczbbz){
		isPass = "N";
	}
	//kmhylx 被审（验）单位行业类型
	var beforekmhylx = "${ct.kmhylx}";
	var nowkmhylx = document.getElementById("kmhylx").value;
	if(beforekmhylx!=nowkmhylx){
		isPass = "N";
	}
	//sfssqy 是否上市企业
	var beforesfssqy = "${ct.sfssqy}";
	var nowsfssqy = document.getElementById("sfssqy").value;
	if(beforesfssqy!=nowsfssqy){
		isPass = "N";
	}
	//ywarea 被审（验）单位注册地址
	var beforeywarea = "${ct.ywarea}";
	var nowywarea = document.getElementById("ywarea").value;
	if(beforeywarea!=nowywarea){
		isPass = "N";
	}
	//xmkhlx 项目客户类型
	var beforexmkhlx = "${ct.xmkhlx}";
	var nowxmkhlx = document.getElementById("xmkhlx").value;
	if(beforexmkhlx!=nowxmkhlx){
		isPass = "N";
	}
	// 注册地址
	var beforezcdz = "${ct.zcdz}";
	var nowzcdz = document.getElementById("zcdz").value;
	if(beforezcdz!=nowzcdz){
		isPass = "N";
	}
	// 负责人姓名
	var beforefzrmc = "${ct.fzrmc}";
	var nowfzrmc = document.getElementById("fzrmc").value;
	if(beforefzrmc!=nowfzrmc){
		isPass = "N";
	}
	// 联系人姓名
	var beforelxrxm = "${ct.lxrxm}";
	var nowlxrxm = document.getElementById("lxrxm").value;
	if(beforelxrxm!=nowlxrxm){
		isPass = "N";
	}
	// 联系人电话
	var beforelxrdh = "${ct.lxrdh}";
	var nowlxrdh = document.getElementById("lxrdh").value;
	if(beforelxrdh!=nowlxrdh){
		isPass = "N";
	}
	// 应收业务费
	var beforeysywf = "${ct.ysywf}";
	var nowysywf = document.getElementById("ysywf").value;
	if(beforeysywf!=nowysywf){
		isPass = "N";
	}
	
	// 应收业务费
	var beforeywarea = "${ct.ywarea}";
	var nowywarea = document.getElementById("ywarea").value;
	if(beforeywarea!=nowywarea){
		isPass = "N";
	}
	
	// 收费日期
	var beforesfrq = "${ct.sfrq}";
	var nowsfrq = document.getElementById("sfrq").value;
	if(beforesfrq!=nowsfrq){
		isPass = "N";
	}
	// 已收业务费
	var beforeysywfed = "${ct.ysywfed}";
	var nowysywfed = document.getElementById("ysywfed").value;
	if(beforeysywfed!=nowysywfed){
		isPass = "N";
	}
	// 开具收款发票号码
	var beforekjskdfphd = "${ct.kjskdfphd}";
	var nowkjskdfphd = document.getElementById("kjskdfphd").value;
	if(beforekjskdfphd!=nowkjskdfphd){
		isPass = "N";
	}
	
	// 开具收款发票号码2
	var beforekjskdfphd2 = "${ct.kjskdfphd2}";
	var nowkjskdfphd2 = document.getElementById("kjskdfphd2").value;
	if(beforekjskdfphd2!=nowkjskdfphd2){
		isPass = "N";
	}
	
	// 收费说明
	var beforesfsm = "${ct.sfsm}";
	var nowsfsm = document.getElementById("sfsm").value;
	if(beforesfsm!=nowsfsm){
		isPass = "N";
	}
	
	// 检查上一年是否不存在的老客户
	f_sflkh();
	//document.getElementById("zdsfbzje").value = document.getElementById("standerPrice").value; 
	
	// 设置 已收业务费和 开具发票号 字段值的 修改时间
	f_setUpdateTime();
	
	if(isPass=="Y"){
		if(yzbguid=="" || yzbguid == null){
			document.thisForm.action=addJsp;
			if (thisForm.fireEvent('onsubmit')){
				// 罩层 
				document.getElementById("divBlock").style.display = "";
				thisForm.submit();
			}
		}else{ 
			document.thisForm.action=updateJsp;
			document.getElementById("tempORFinish").value="报备完成";
			if (thisForm.fireEvent('onsubmit')){
				// 罩层 
				document.getElementById("divBlock").style.display = "";
				thisForm.submit();
			}
		}
	}else{
		document.getElementById("reasonDiv").style.display = "";;
		document.getElementById("reasonDivBig").style.display = "";
		document.getElementById("changeReason").focus();
	}
}

// 返回
function goback(){	
	var typeid = document.getElementById("typeid").value;
	window.location="${pageContext.request.contextPath}/common/bb.do?method=index&typeid=" + typeid;
}

//检查签名注师是否相同
function isQmzs(t,num){
	var qmzs1 = document.getElementById("qmzs1").value;
	var qmzs2 = document.getElementById("qmzs2").value;
	var qmzs3 = document.getElementById("qmzs3").value;
	var qmzs4 = document.getElementById("qmzs4").value;
	var qmzs5 = document.getElementById("qmzs5").value;
	var qmzs6 = document.getElementById("qmzs6").value;
	var temps = [qmzs1,qmzs2,qmzs3,qmzs4,qmzs5,qmzs6];

	for(var i = 0;i<temps.length;i++){
		if(i==(num-1))continue;
		if(t.value==temps[i]){
			alert("签名注师不能相同，请重新输入！");
			t.value="";
			t.select();
			return false;
		}
	}
	return true;
}

//检查唯一性
function isOnly(){
	var only = "${isOnly}";
	var bbbh = "${ct.bbbh}";
	if(only == "1" && bbbh == ""){
		//alert(only + "|" + bbbh);		
		//要检查唯一性
		var typeid = document.getElementById("typeid").value;
		var wtdwmc = document.getElementById("wtdwmc").value;
		var bgnd = document.getElementById("bgnd").value; 
		var url = "${pageContext.request.contextPath}/common/bb.do?method=isOnly&typeid="+typeid+"&bgnd="+bgnd+"&wtdwmc="+wtdwmc;
		var oBao = new ActiveXObject("Microsoft.XMLHTTP");
		oBao.open("POST",url,false);
		oBao.send();
		
		var resText = oBao.responseText;
		//alert(resText.indexOf("false")>-1);
		if(resText.indexOf("false")>-1){
			alert("委托单位名称【"+wtdwmc+"】在"+document.getElementById("bgnd").value+"年度已经作过报备，不能重新报备；\n请重新输入项目年度");
			document.getElementById("bgnd").select();
			return false;
		}
	}
	return true;
}

//检查最少业务金额
function isBusSum(){
	var busSum= "${busSum }";
	
	var ysywf = document.getElementById("ysywf").value;
	
	if(busSum != ""){
		if(busSum > ysywf) {
			alert("业务约定书收费金额不能小于${clt.area}地区的业务金额：" +busSum + "；请重新输入!");
			document.getElementById("ysywf").select();
			return false;
		}
	}
	return true;
}

function updateMoney(){
	var ysywf = document.getElementById("ysywf").value;
	var ysywfed = document.getElementById("ysywfed").value;
	
	// 后期调整 ： 去掉 该 限制
	// if(ysywfed*1<=ysywf*1){
		if (thisForm.fireEvent('onsubmit')){
			document.thisForm.action="${pageContext.request.contextPath}/common/bb.do?method=updateMoney";
			thisForm.submit();
		}
	//}else{
		//alert("已收业务费用不能大于应收业务费用!");
		//document.getElementById("ysywfed").focus();
	//}
}

// 确定
function f_sure(){
	var yzbguid = document.getElementById("ctguid").value;
	var addJsp = document.getElementById("addJsp").value;
	var updateJsp = document.getElementById("updateJsp").value;
	
	var changeReason = document.getElementById("changeReason").value;
	
	if(changeReason=="" || changeReason==null){
		alert("请填写修改原因!");
		document.getElementById("changeReason").focus();
		return;
	}else{
		
		// 检查上一年是否不存在的老客户
		f_sflkh();
		//document.getElementById("zdsfbzje").value = document.getElementById("standerPrice").value; 
		
		if(yzbguid=="" || yzbguid == null){
			document.thisForm.action=addJsp;
			if (thisForm.fireEvent('onsubmit')){
				// 罩层 
				document.getElementById("divBlock").style.display = "";
				thisForm.submit();
			}
		}else{
			document.thisForm.action=updateJsp;
			document.getElementById("tempORFinish").value="报备完成";
			if (thisForm.fireEvent('onsubmit')){
				// 罩层 
				document.getElementById("divBlock").style.display = "";
				thisForm.submit();
			}
		}
	}
}

// 取消
function f_cancle(){
	document.getElementById("reasonDiv").style.display = "none";;
	document.getElementById("reasonDivBig").style.display = "none";
}


// 验证金额
function f_moneys(t){
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


// 计算应收业务费用
function f_countYsywf(){
	var typeid = document.getElementById("typeid").value;
	var ysywf = document.getElementById("ysywf").value;
	if(ysywf!=""){
		var rs = f_checkMoney("Y","wjjsfbz");
		if(rs=="ok"){
			alert("业务约定书收费金额达到发改委、财政厅收费标准。");
		}else{
			if(rs!="notAlert"){
				alert(rs);
			}
		};
	}else{
		alert("请先填写业务约定书收费金额！");
		setTab('search','nry'); 
		document.getElementById("ysywf").select();
	}
}

// 计算 该注师 参加的验资报备份数
function f_getCPAYZReportCount(){
	var officeCode = "${userSession.userMap.loginid}";
	url="${pageContext.request.contextPath}/common/content.do?method=getCPAYZReportCount";
	request = "&officeCode="+officeCode;
	var resText = ajaxLoadPageSynch(url,request);
	if(resText == "N"){
		//alert("贵所报备的报告数量异常，请与注协联系（020-83063583、83063578）！");
		alert("贵所今年验资报备的报告数量已达到当年最高报备份数，不能直接报备完成，要继续报备请申请审核！");
		return "N";
	}
	return "Y";
}

// 计算 该注师 参加的非验资报备份数
function f_getCPAFYZReportCount(){
	var officeCode = "${userSession.userMap.loginid}";
	url="${pageContext.request.contextPath}/common/content.do?method=getCPAFYZReportCount";
	request = "&officeCode="+officeCode;
	var resText = ajaxLoadPageSynch(url,request);
	if(resText == "N"){
		//alert("贵所报备的报告数量异常，请与注协联系（020-83063583、83063578）！");
		alert("贵所今年非验资报备的报告数量已达到当年最高报备份数，不能直接报备完成，要继续报备请申请审核！");
		return "N";
	}
	return "Y";
}


// 检查上一年是否不存在的老客户
function f_sflkh(){
	
	// 项目客户类型
	var xmkhlx = document.getElementById("xmkhlx").value;
	// 被审验单位名称
	var bsdwmc = document.getElementById("bsdwmc").value;
	// 报备类型
	var typeid = document.getElementById("typeid").value;
	
	if(xmkhlx=="老客户" && bsdwmc!=""){
		var url="${pageContext.request.contextPath}/common/content.do?method=sflkh";
		var request = "&bsdwmc="+bsdwmc+"&typeId="+typeid;
		var resText = ajaxLoadPageSynch(url,request);
		if(resText == "Y"){
			document.getElementById("sflkh").value = "是";
		}else{
			document.getElementById("sflkh").value = "否";
		}
	}else{
		document.getElementById("sflkh").value = "";
	}
	
}

// 根据事务所所在地或者业务所在地判断该事务所是否属于珠三角
function f_sfzsj(area,ywarea){
	if(area=="广州" || area=="珠海" || area=="佛山" || area=="东莞" || area=="中山" || area=="江门" || area=="深圳" 
		|| ywarea.indexOf("广州")>-1 || ywarea.indexOf("珠海")>-1 || ywarea.indexOf("佛山")>-1 || ywarea.indexOf("东莞")>-1 || ywarea.indexOf("中山")>-1 || ywarea.indexOf("江门")>-1 || ywarea.indexOf("深圳")>-1 ){
		
		return true;
		
	}else{
	
		return false;
	}
}


// 获取当前时间
function getDate(){
  var d,s,t;
  d=new Date();
  s=d.getFullYear().toString(10)+"-";
  t=d.getMonth()+1;
  s+=(t>9?"":"0")+t+"-";
  t=d.getDate();
  s+=(t>9?"":"0")+t+" ";
  t=d.getHours();
  s+=(t>9?"":"0")+t+":";
  t=d.getMinutes();
  s+=(t>9?"":"0")+t+":";
  t=d.getSeconds();
  s+=(t>9?"":"0")+t;
  
  return s;
}

// 设置 已收业务费和 开具发票号 字段值的 修改时间
function  f_setUpdateTime(){
	// 已收业务费 -----  修改时间
	var ysywfnow = document.getElementById("ysywfed").value;
	var ysywfbefore = "${ct.ysywfed}";
	if(ysywfnow!=ysywfbefore){
		document.getElementById("ysywfedUpdateTime").value = getDate();
	}
	 
	// 开具收款发票号2  -----  修改时间
	var kjskdfphd2now = document.getElementById("kjskdfphd2").value;
	var kjskdfphd2before = "${ct.kjskdfphd2}";
	if(kjskdfphd2now!=kjskdfphd2before){
		document.getElementById("kjskdfphd2UpdateTime").value = getDate();
	}
}

// 如果是计时收费 那么 申请审核与报备完成的时候检查 应收业务费与总金额合计是否一致
function f_jssf_same(){
	var sfbz = document.getElementById("sfbz").value;
	if(sfbz=="计时收费"){
		// 应收业务费 必须与 总金额一致
		var ysywf = document.getElementById("ysywf").value*1;
		var countMoneyTotal = document.getElementById("countMoneyTotal").value*1;
		if(ysywf != countMoneyTotal){
			alert("业务约定书收费金额必须与总金额合计一致！");
			setTab('search','nry') ;
			document.getElementById("ysywf").select();
			return false;
		}
	}
	return true;
}



// ============= 收费标准计算  =============== //

/*  验资 的 费率和速算增加数

	金额区间							费率			速算增加数
	50万以下(X<=50万)					0			0.12
	50-100万(50<X<=100万)			0.0015		0.045
	100-500万(100<X<=500万)			0.0004		0.155
	500-1000万(500<X<=1000万)		0.0003		0.205
	1000-5000万(1000<X<=5000万)		0.0002		0.305
	5000万-1亿(5000<X<=1亿)			0.00015		0.555
	1-5亿(1亿<X<=5亿)					0.0001		1.055
	5-10亿(5亿<X<=10亿)				0		    6.055
	10亿以上(X>10亿)					0		    6.055
	
*/

// 根据金额得到：费率[验资]
function f_getRateByYzMoney(money){
	if(money==""){
		money = 0;
	}else{
		money = money*1;
	}
	
	if(money<=50){
		return "0";
	}else if(50<money && money<=100){
		return "0.0015";
	}else if(100<money && money<=500){
		return "0.0004";
	}else if(500<money && money<=1000){
		return "0.0003";
	}else if(1000<money && money<=5000){
		return "0.0002";
	}else if(5000<money && money<=10000){
		return "0.00015";
	}else if(10000<money && money<=50000){
		return "0.0001";
	}else if(50000<money && money<=100000){
		return "0";
	}else{
		return "0";
	}
	
}


// 根据金额得到：速算增加数[验资]
function f_getIncreaseByYzMoney(money){
	if(money==""){
		money = 0;
	}else{
		money = money*1;
	}
	
	if(money<=50){
		return "0.12";
	}else if(50<money && money<=100){
		return "0.045";
	}else if(100<money && money<=500){
		return "0.155";
	}else if(500<money && money<=1000){
		return "0.205";
	}else if(1000<money && money<=5000){
		return "0.305";
	}else if(5000<money && money<=10000){
		return "0.555";
	}else if(10000<money && money<=50000){
		return "1.055";
	}else if(50000<money && money<=100000){
		return "6.055";
	}else{
		return "6.055";
	}
}


/*  非验资 的 费率和速算增加数

	金额									费率			速算增加数
	50万以下(X<=50万)						0			0.2
	50-100万(50<X<=100万)				0.002		0.1
	100-500万(100<X<=500万)				0.0009		0.21
	500-1000万(500<X<=1000万)			0.0007		0.31
	1000-5000万(1000<X<=5000万)			0.0005		0.51
	5000万-1亿(5000<X<=1亿)				0.0003		1.51
	1-5亿(1亿<X<=5亿)						0.00015		3.01
	5-10亿(5亿<X<=10亿)					0		    10.51
	10亿以上(X>10亿)						0		    10.51
	
*/

// 根据金额得到：费率[非验资]
function f_getRateByFYzMoney(money){
	if(money==""){
		money = 0;
	}else{
		money = money*1;
	}
	
	if(money<=50){
		return "0";
	}else if(50<money && money<=100){
		return "0.002";
	}else if(100<money && money<=500){
		return "0.0009";
	}else if(500<money && money<=1000){
		return "0.0007";
	}else if(1000<money && money<=5000){
		return "0.0005";
	}else if(5000<money && money<=10000){
		return "0.0003";
	}else if(10000<money && money<=50000){
		return "0.00015";
	}else if(50000<money && money<=100000){
		return "0";
	}else{
		return "0";
	}
	
}


// 根据金额得到：速算增加数[非验资]
function f_getIncreaseByFYzMoney(money){
	if(money==""){
		money = 0;
	}else{
		money = money*1;
	}
	
	if(money<=50){
		return "0.2";
	}else if(50<money && money<=100){
		return "0.1";
	}else if(100<money && money<=500){
		return "0.21";
	}else if(500<money && money<=1000){
		return "0.31";
	}else if(1000<money && money<=5000){
		return "0.51";
	}else if(5000<money && money<=10000){
		return "1.51";
	}else if(10000<money && money<=50000){
		return "3.01";
	}else if(50000<money && money<=100000){
		return "10.51";
	}else{
		return "10.51";
	}
}


/*  审计非盈利 的 费率和速算增加数

	金额									费率			速算增加数(珠三角)		速算增加数(非珠三角)		
	0-1亿(0<X<=1亿)						0.9			0					0				
	1-5亿(1亿<X<=5亿)						0.8			3460				3157
	5亿(5以上)							0.7		    11120				10514
	
*/

// 根据金额得到：费率[审计非盈利  珠三角与非珠三角一样]
function f_getRateByFylMoney(money){
	if(money==""){
		money = 0;
	}else{
		money = money*1;
	}
	
	if(money<=10000){
		return "0.9";
	}else if(10000<money && money<=50000){
		return "0.8";
	}else{
		return "0.7";
	}
	
}


// 根据金额得到：速算增加数[审计非盈利  珠三角 ]
function f_getIncreaseByZFYlMoney(money){
	if(money==""){
		money = 0;
	}else{
		money = money*1;
	}
	
	if(money<=10000){
		return "0";
	}else if(10000<money && money<=50000){
		return "3460";
	}else{
		return "11120";
	}
}

// 根据金额得到：速算增加数[审计非盈利  非珠三角 ]
function f_getIncreaseByFZFYlMoney(money){
	if(money==""){
		money = 0;
	}else{
		money = money*1;
	}
	
	if(money<=10000){
		return "0";
	}else if(10000<money && money<=50000){
		return "3157";
	}else{
		return "10514";
	}
}


//1000万的标准价
function f_getMoney(typeId,money){
	// 标准价
	var stardardMoney = 0;
	
	if(typeId=="yz001" || typeId=="yz002"){
		stardardMoney = (money*f_getRateByYzMoney(money)*1 + f_getIncreaseByYzMoney(money)*1)*10000;
	}else{
		stardardMoney = (money*f_getRateByFYzMoney(money)*1 + f_getIncreaseByFYzMoney(money)*1)*10000;
	}
	
	return stardardMoney;
}

//检查收费标准:money是万元作单位进来的,typeId报备分类 Id. 返回 7 折价 和 1000万的标准价
function f_checkMoneyStandard(money,typeId){
	// 标准价
	var stardardMoney = f_getMoney(typeId,money);
	// 标准价的7折价
	var stardardMoneyOfServen = stardardMoney * 0.7;
	// 1000万的标准价
	var oneThStardardMoney = f_getMoney(typeId,1000);
	
	/*
	// 取用户金额的标准价和1000万的标准价之间小的那个值
	var tempMoney =  stardardMoney>oneThStardardMoney?oneThStardardMoney:stardardMoney;
	
	// 1000万以上的7折价
	var moreOneThStardardMoney = 0.7*stardardMoney + 0.3*tempMoney;
	*/
	
	var moreOneThStardardMoney = "";
	if(money<=1000){
	  	moreOneThStardardMoney = stardardMoney;
	}else{
		moreOneThStardardMoney = oneThStardardMoney + 0.7 * (stardardMoney - oneThStardardMoney);
	  
		//moreOneThStardardMoney = 0.7*stardardMoney + 0.3*oneThStardardMoney;  
	}
	
	if(typeId=="whnj001"){
		stardardMoneyOfServen = 1000;
		moreOneThStardardMoney = 1000;
	}else if(typeId=="hbsj001" || typeId=="flsj001" || typeId=="qssh001" || typeId=="sfkjjd001" || typeId=="sj003" || typeId=="bbqt001" || typeId=="yz002" ){// 审计下的经济责任审计 ： 用 sj003表示
		stardardMoneyOfServen = stardardMoneyOfServen*1.2;
		moreOneThStardardMoney = moreOneThStardardMoney*1.2;
	}else if(typeId=="qchz001"){
		stardardMoneyOfServen = stardardMoneyOfServen*2;
		moreOneThStardardMoney = moreOneThStardardMoney*2;
	}else if(typeId=="sj002"){// 审计下的非盈利 ： 用 sj002表示
		// 7 折价
		stardardMoneyOfServen = stardardMoneyOfServen*f_getRateByFylMoney(money)*1 + f_getIncreaseByFZFYlMoney(money)*1;
		// 1000万以上 7 折价
		moreOneThStardardMoney = moreOneThStardardMoney*f_getRateByFylMoney(money)*1 + f_getIncreaseByZFYlMoney(money)*1;
	}
	
	var moneyArray = [f_fourDownFiveStay(stardardMoneyOfServen),f_fourDownFiveStay(moreOneThStardardMoney)];
	return moneyArray;
}

// 四舍五保留：十位大于等于 5 保持不变，小于5就舍去十位以后的所有位。
function f_fourDownFiveStay(money){
	var moleMoney = money % 100;
	if(moleMoney < 50){
		money = (money/100).toFixed(0)*100;
	} 
	return money.toFixed(2);
}


//设置标准金额
function f_setStanderPrice(ysywfCountTemp,typeId){
	var moneyArray = f_checkMoneyStandard(ysywfCountTemp,typeId);
	var stardardMoneyOfServen = moneyArray[0]*1;
	var moreOneThStardardMoney = moneyArray[1]*1;
	
	var ysywfCount = 0;
	
	// 广州、珠海、佛山、东莞、中山、江门、深圳
	var area = "${userSession.userMap.area}";
	var ywarea = document.getElementById("ywarea").value;
	// 属于珠三角地区
	if(f_sfzsj(area,ywarea)){
		
		ysywfCount = moreOneThStardardMoney;
		
		if(typeId=="sj001"){
			stardardMoneyOfServen = stardardMoneyOfServen>2000?stardardMoneyOfServen:2000;
		}else if(typeId=="sj002"){
			stardardMoneyOfServen = stardardMoneyOfServen>1800?stardardMoneyOfServen:1800;
		}else if(typeId=="sj003" || typeId=="flsj001" ||typeId=="hbsj001" ||typeId=="qssh001" ||typeId=="sfkjjd001"){
			stardardMoneyOfServen = stardardMoneyOfServen>2400?stardardMoneyOfServen:2400;
		}else if(typeId=="whnj001"){
			stardardMoneyOfServen = stardardMoneyOfServen>1000?stardardMoneyOfServen:1000;
		}else if(typeId=="qchz001"){
			stardardMoneyOfServen = stardardMoneyOfServen>4000?stardardMoneyOfServen:4000;
		}
	}else{
		ysywfCount = stardardMoneyOfServen;
	}
	
	ysywfCount = ysywfCount*1;
	
	// 数据库 7 折价
	document.getElementById("discountBySeven").value = stardardMoneyOfServen;
		 
	// 标准金额
	document.getElementById("standerPrice").value = ysywfCount;
}

// 验证并返回信息
function f_returnInfo(ysywfCountTemp,typeId,isCount,typeName){
	// 应收业务费
	var ysywf = document.getElementById("ysywf").value;
	ysywf = ysywf==""?0:ysywf*1;
	
	// 审计 和 清算审计另外在自己的jsp里面设置标准价：他们需要用多年的标准价的加总和进行计算
	if(typeName!="审计" && typeName!="清算审计"){
		// 设置标准金额
		f_setStanderPrice(ysywfCountTemp,typeId);
	}

	// 标准金额	
	var ysywfCount = document.getElementById("standerPrice").value;
	ysywfCount = ysywfCount==""?0:ysywfCount*1;
	
	if(ysywf.toFixed(2)*1<ysywfCount.toFixed(2)*1){
		setTab('search','nry');
		if(isCount!="Y"){
			alert("您所填报的业务约定书收费金额"+ysywf+"元，低于发改委、财政厅收费标准"+ysywfCount.toFixed(2)+"元，不能进行报备！如果您确定要以本收费金额进行报备，请到【收费信息】选择【计费方式】，填写提示的信息申请审核，注协审核通过后继续进行报备。");
		}
		document.getElementById("ysywf").select();
		return "您所填报的业务约定书收费金额"+ysywf+"元，低于发改委、财政厅收费标准"+ysywfCount.toFixed(2)+"元。";
	}
	
	return "ok";
	
}
	
// ============= 收费标准计算  =============== //

/*
	
	行业名称				指标名称			计量单位			大型
	农、林、牧、渔业		营业收入(Y)		万元				Y>=20000
	工业 				从业人员(X)		人				X>=1000
						营业收入(Y)		万元				Y>=40000
	建筑业				营业收入(Y)		万元				Y>=80000
						资产总额(Z)		万元				Z>=80000
	批发业				从业人员(X)		人				X>=200
						营业收入(Y)		万元				Y>=40000
	零售业				从业人员(X)		人				X>=300
						营业收入(Y)		万元				Y>=20000
	交通运输业 			从业人员(X)		人				X>=1000
						营业收入(Y)		万元				Y>=30000
	仓储业				从业人员(X)		人				X>=200
						营业收入(Y)		万元				Y>=30000
	邮政业				从业人员(X)		人				X>=1000
						营业收入(Y)		万元				Y>=30000
	住宿业				从业人员(X)		人				X>=300
						营业收入(Y)		万元				Y>=10000
	餐饮业				从业人员(X)		人				X>=300
						营业收入(Y)		万元				Y>=10000
	信息传输业 			从业人员(X)		人				X>=2000
						营业收入(Y)		万元				Y>=100000
	软件和信息技术服务业	从业人员(X)		人				X>=300
						营业收入(Y)		万元				Y>=10000
	房地产开发经营			营业收入(Y)		万元				Y>=200000
						资产总额(Z)		万元				Z>=10000
	物业管理				从业人员(X)		人				X>=1000
						营业收入(Y)		万元				Y>=5000
	租赁和商务服务业		从业人员(X)		人				X>=300
						资产总额(Z)		万元				Z>=120000
	其他未列明行业 		从业人员(X)		人				X>=300

*/

// 判断企业类型：大型、中小微型企业
function f_checkCompanyType(){
	// 客户行业类型
	var kmhylx = document.getElementById("kmhylx").value;
	
	// 客户行业类型数组
	var kmhylxArray = ["农、林、牧、渔业","工业","建筑业","批发业","零售业",
					   "交通运输业","仓储业","邮政业","住宿业","餐饮业",
					   "信息传输业","软件和信息技术服务业","房地产开发经营","物业管理","租赁和商务服务业",
					   "其他未列明行业"];
					   
	// 判断指标中文名称数组
	var standardCHArray = ["营业收入+销售收入","从业人员#@#营业收入+销售收入","营业收入+销售收入#@#资产总额","从业人员#@#营业收入+销售收入","从业人员#@#营业收入+销售收入",
						   "从业人员#@#营业收入+销售收入","从业人员#@#营业收入+销售收入","从业人员#@#营业收入+销售收入","从业人员#@#营业收入+销售收入","从业人员#@#营业收入+销售收入",
						   "从业人员#@#营业收入+销售收入","从业人员#@#营业收入+销售收入","营业收入+销售收入#@#资产总额","从业人员#@#营业收入+销售收入","从业人员#@#资产总额",
						   "从业人员"];
	// 判断指标英文名称数组					   
	var standardENArray = ["yysr+xssr","cyry#@#yysr+xssr","yysr+xssr#@#zcze","cyry#@#yysr+xssr","cyry#@#yysr+xssr",
						   "cyry#@#yysr+xssr","cyry#@#yysr+xssr","cyry#@#yysr+xssr","cyry#@#yysr+xssr","cyry#@#yysr+xssr",
						   "cyry#@#yysr+xssr","cyry#@#yysr+xssr","yysr+xssr#@#zcze","cyry#@#yysr+xssr","cyry#@#zcze",
						   "cyry"];
						   
	// 金额和从业人数数组 要跟 判断指标名称数组顺序对应
	var moneyAndCountArray = ["20000","1000#@#40000","80000#@#80000","200#@#40000","300#@#20000",
							  "1000#@#30000","200#@#30000","1000#@#30000","300#@#10000","300#@#10000",
							  "2000#@#100000","300#@#10000","200000#@#10000","1000#@#5000","300#@#120000",
					   	 	  "300"];
	
	
	if(kmhylx!=""){
	 	for(var i=0;i<kmhylxArray.length;i++){
		 	if(kmhylx==kmhylxArray[i]){
		 		// 金额 or 从业人数
		 		var moneyOrCount = "0";
		 		
		 		// 判断指标名称组合
		 		var standardEN = standardENArray[i];
		 		
		 		// 判断金额和从业人数组合
		 		var moneyAndCount = moneyAndCountArray[i];
		 		
		 		// 判断指标名称分组
		 		var standardENArr = standardEN.split("#@#");
		 		
		 		// 判断金额和从业人数分组
		 		var moneyAndCountArr = moneyAndCount.split("#@#");
		 		
	 			var isBig = "Y";
	 			for(var m=0;m<standardENArr.length;m++){
 					// 清零
 					moneyOrCount = "0";
 					// 子数组对象
	 				var standardENArrSon = standardENArr[m].split("+");
 					// 临时对象
					var tempObj = "";
	 				for(var n=0;n<standardENArrSon.length;n++){
	 					var typeid = "${typeid}";
	 					// 审计和清算审计 是多年审计，去最后一年 的数据作为 中小微的 判断依据
	 					if(typeid=="sj001" || typeid=="qssh001"){
	 						// 算出当前审计年数
	 						var year = f_calcYear();
	 						tempObj = document.getElementById(standardENArrSon[n]+year);
		 					// 有些报备分类不存在某元素
		 					if(tempObj){
		 						moneyOrCount = moneyOrCount*1 + tempObj.value*1; 
		 					}
	 					}else{
		 					tempObj = document.getElementById(standardENArrSon[n]);
		 					// 有些报备分类不存在某元素
		 					if(tempObj){
		 						moneyOrCount = moneyOrCount*1 + tempObj.value*1; 
		 					}
	 					}
	 				}
	 				
	 				// 只要有一个条件不满足就是中小微类型
	 				if(moneyOrCount<moneyAndCountArr[m]){
	 					isBig = "N";
	 					break;
	 				}
		 		}
	 			if(isBig=="Y"){
 					return "大型"
 				}else{
 					return "中小微"
 				}
		 	}
		 }
		return "中小微";
	}else{
		return "中小微";
	}
}


// 是否接下家： 同一种报备类型、同一家被审验单位、不同事务所、不同注师 
function f_checkTookHome(){
	var typeid = document.getElementById("typeid").value;
	var bsdwmc = document.getElementById("bsdwmc").value;
	bsdwmc = bsdwmc.replace(/ /g,"");
	var loginid = document.getElementById("loginid").value;
	var qmzs1 = document.getElementById("qmzs1").value;
	var qmzs2 = document.getElementById("qmzs2").value;
	var url="${pageContext.request.contextPath}/common/content.do?method=checkTookHome";
	var request = "&typeid="+typeid+"&bsdwmc="+bsdwmc+"&loginid="+loginid+"&qmzs1="+qmzs1+"&qmzs2="+qmzs2;
	var resText = ajaxLoadPageSynch(url,request);
	return resText; 
}

// 检查当前的报备状态是否与数据库中的最新报备状态一致
function f_checkSaveState(){
	var beforeState = "${ct.bbstate}";
	beforeState = convertState(beforeState);
	var guid = "${ct.guid}";
	if(guid!=""){
		// 得到最新状态
		var nowState = f_getStateByGuid(guid);
		if(beforeState!=nowState){
			return false;
		}else{
			return true;
		}
	}else{
		return true;
	}
}

// 根据 guid 查看报备状态
function f_getStateByGuid(guid){
	var url="${pageContext.request.contextPath}/common/content.do?method=getStateByGuid";
	var request = "&ctguid="+guid;
	var resText = ajaxLoadPageSynch(url,request);
	return resText; 
}

// 状态转换
function convertState(state){
	var chState = ["暂存","申请审核","初审通过","审核未通过","审核通过","报备完成"];
	var enState = ["zancun","sqsh","cstg","shwtg","shtg","wanch"];
	for(var i=0;i<chState.length;i++){
		if(state==chState[i]){
			return enState[i];
		}
		if(state==enState[i]){
			return chState[i]; 
		}
	}
	return "无"+state
}

// 解决两个小数相加出现多位小数位的问题2
function f_addNum(num1,num2){
	var sq1,sq2,m;
	try{sq1=num1.toString().split(".")[1].length;} catch(e){sq1=0;}
	try{sq2=num2.toString().split(".")[1].length;} catch(e){sq2=0;}
	
	m=Math.pow(10,Math.max(sq1,sq2));
	return ( num1 * m + num2 * m ) / m;
}

</script>

</html>