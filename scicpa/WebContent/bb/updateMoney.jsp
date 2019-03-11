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
<input type="hidden" id="bbstate" name="bbstate" value="${ct.bbstate}">
<input type="hidden" id="bcbBtn" name="bcbBtn" value="保存" >
<input type="hidden" id="isPass" name="isPass" value="Y" >
<input type="hidden" id="attachfileId" name="attachfileId" value="${ct.attachfileId}">
<input type="hidden" id="ysywfedUpdateTime" name="ysywfedUpdateTime" value="${ct.ysywfedUpdateTime}">
<input type="hidden" id="kjskdfphd2UpdateTime" name="kjskdfphd2UpdateTime" value="${ct.kjskdfphd2UpdateTime}">
<input type="hidden" id="syskhlx" name="syskhlx" value="${ct.syskhlx}">
<input type="hidden" id="isoverflow" name="isoverflow" value="${ct.isoverflow}">

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
			<center>
				<!-- 
				<font color="#FF0000">该报备时间已超过一个月,只能修改已收业务费用、收费日期、开具收款发票号、收费说明!</font>
				 -->
				<font color="#FF0000">该报备时间已超过一个月,只能修改收费日期、收费说明、开具收款发票号码!</font>
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
	<div id="fsave" style="margin-left: 78%;margin-top: 1%">
			   <input type="button"
				name="bcb" id="bcb" value="保  存"
				onclick="return updateMoney();"> 
				<input id="fh" type="button" name="next"
				value="返  回" icon="icon-back" class="flyBT" onclick="goback();">
	</div>
</H3>


<div class="tabcontent" id="dbswszl" style="text-align: center;display: none"> 

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
			<input maxlength="100" name="linkman" class="required" type="text" id="linkman" style="width: 25%" value = "${clt.person}" >
		</td>
	</tr>
	
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">联系电话<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" height="18" colspan="3"> 
			<input maxlength="100" name="linkphone" class="required" type="text" id="linkphone" style="width: 25%"  value = "${clt.phone }" >
		</td>
	</tr>
	
	
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">传&nbsp;&nbsp;&nbsp;&nbsp;真<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input maxlength="50" name="faxes" myClass="phone" class="required" type="text" id="faxes" style="width: 68%" value="${clt.faxes }" >
		</td>
		<td class="data_tb_alignright" height="18">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;编<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" height="18"> 
			<input maxlength="50" name="post" myClass="number" class="required" type="text" id="post" style="width: 83%" value = "${clt.post }" >
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
			<input maxlength="50" name="url" type="text" id="url" style="width: 83%"  value = "${clt.url }" >
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
    <td width="30%" height="23" class="data_tb_content"><input maxlength="300" title="委托单位名称" id="wtdwmc" value="${ct.wtdwmc }" style="width: 85%" size="23" class="required"></td>
    <td width="20%" height="23" class="data_tb_alignright">被审(验)单位名称<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23" class="data_tb_content"><input maxlength="300" title="被审验单位名称" id="bsdwmc" value="${ct.bsdwmc }" style="width: 85%" size="24" class="required"></td>
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
						hideresult=true title="客户出资类型" id="khczlx" value="${ct.khczlx }" name="khczlx" size="20" class="required"></td>
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
    	<input maxlength="20" id="bsdwzczb" value="${ct.bsdwzczb }" style="width: 75%" name="bsdwzczb" class="required number" onkeyup="f_moneys(this);" >万元&nbsp;&nbsp;&nbsp;&nbsp; <br />
    	 <input maxlength="20" id="zczbbz" value="${ct.zczbbz }" style="width: 75%"" name="zczbbz" class="required" onfocus="onPopDivClick(this);"
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
    <td width="80%" colspan="3" height="23" class="data_tb_content"><input maxlength="300" id="zcdz" value="${ct.zcdz }" name="zcdz" style="width: 95%" ></td>
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
	<td width="30%" height="23" class="data_tb_content">${ct.sfdbxm}</td>
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
		<input maxlength="50" id="qmzs3" name="qmzs3" value="${ct.qmzs3 }"  onfocus="onPopDivClick(this);"
			 			onchange="isQmzs(this,'3');"
    					noinput=true
    					autoWidth=190
						autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						refer="${userSession.userMap.officecode }"
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
		<input maxlength="50" id="qmzs4" name="qmzs4" value="${ct.qmzs4 }"  onfocus="onPopDivClick(this);"
			 			onchange="isQmzs(this,'4');"
    					noinput=true
    					autoWidth=190
						autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						refer="${userSession.userMap.officecode }"
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
			 			onchange="isQmzs(this,'5');"
    					noinput=true
    					autoWidth=190
						autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						refer="${userSession.userMap.officecode }"
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
		<input maxlength="50" id="qmzs6" name="qmzs6" value="${ct.qmzs6}"  onfocus="onPopDivClick(this);"
			 			onchange="isQmzs(this,'6');"
    					noinput=true
    					autoWidth=190
						autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						refer="${userSession.userMap.officecode }"
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
    <td width="80%" height="16" colspan="3" class="data_tb_content"><textarea id="leaveword" name="leaveword" style="width: 95%;height: 40">${ct.leaveword }</textarea></td>
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
    <td class="data_tb_content" width="30%"><input maxlength="20"  title="只能输入数字" id="ysywf" value="${ct.ysywf }" style="width: 60%" name="ysywf" class="required number" onkeyup="f_moneys(this);" >元(人民币)</td>
    <td class="data_tb_alignright" width="20%" height="16">收费日期</td>
    <td width="30%" height="16" class="data_tb_content"><input maxlength="20" id="sfrq" value="${ct.sfrq}" name="sfrq" style="width: 70%" showcalendar="true" onkeypress="return false;" onpaste="return false;"></td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%" >已收业务费</td>
    <td width="30%" class="data_tb_content"><input maxlength="20" id="ysywfed" value="${ct.ysywfed }" style="width: 60%" name="ysywfed" class="number" onkeyup="f_moneys(this);" >元(人民币)</td>
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
    	<input maxlength="50" id="kjskdfphd" value="${ct.kjskdfphd }" name="kjskdfphd" size="45" class="required">&nbsp;&nbsp;&nbsp;&nbsp;
    	<input maxlength="50" id="kjskdfphd2" value="${ct.kjskdfphd2 }" name="kjskdfphd2" size="45" >
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

<div class="tabcontent" id="nre" style="text-align: center; display: none;"> 
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
	


	var updatemoney="${updatemoney}";
	if(updatemoney=="updatemoney"){
		$("input").each(function(index,obj){
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
		
			if(obj.id == "ysywfed" && "${ct.bbstate}"=="报备完成"){
				// 报备完成：已收业务费 和 发票号码第二个框 的值不为空的情况下 的 2 个星期后不能修改 
				if("${ct.ysywfed}"!="" && "${ct.ysywfed}"!=0 && DateDiff(nowTime,ysywfedUpdateTime)>14 ){
					obj.readOnly = true ;
					obj.className = "before";
				}
			}else if(obj.id=="kjskdfphd2" && "${ct.bbstate}"=="报备完成"){
				// 报备完成：已收业务费 和 发票号码第二个框 的值不为空的情况下 的 2 个星期后不能修改 
				/* if("${ct.kjskdfphd2}"!="" && "${ct.kjskdfphd2}"!=0 && DateDiff(nowTime,kjskdfphd2UpdateTime)>14 ){
					obj.readOnly = true ;
					obj.className = "before";
				} */
			}else if(obj.id == 'sfrq' || obj.id=="file" || obj.id=="upload_Btn" || obj.id=="upload_Cle"){
				//obj.readOnly = false ;
				//obj.className = "";
			}else{
				obj.readOnly = true ;
				obj.className = "before";
			}
		});
		
		$("textarea").each(function(index,obj){
			if(obj.id != 'sfsm' && obj.id !='changeReason'){
				obj.readOnly = true ;
				obj.className = "before";
			}
		});
		setTab('search','nry') ;
		document.getElementById("ysywfed").focus();
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
	var totalTemp = "0";
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
	if(!isOnly()) return ;
	if(!isBusSum()) return ;
	
	var yzbguid = document.getElementById("ctguid").value;
	var addJsp = document.getElementById("addJsp").value;
	var updateJsp = document.getElementById("updateJsp").value;


	var isPass = document.getElementById("isPass").value;
	// 比较是否有改动过信息,如果改动了必须填写原因
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
	// 收费说明
	var beforesfsm = "${ct.sfsm}";
	var nowsfsm = document.getElementById("sfsm").value;
	if(beforesfsm!=nowsfsm){
		isPass = "N";
	}
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
	
	var isPass = document.getElementById("isPass").value;
	// 比较是否有改动过信息,如果改动了必须填写原因
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
	
	// 设置 已收业务费和 开具发票号 字段值的 修改时间
	f_setUpdateTime();
	
	if(isPass=="Y"){
		// 后期调整 ： 去掉 该 限制
		//if(ysywfed*1<=ysywf*1){
			if (thisForm.fireEvent('onsubmit')){
				document.thisForm.action="${pageContext.request.contextPath}/common/bb.do?method=updateMoney";
				thisForm.submit();
			}
		//}else{
			//alert("已收业务费用不能大于应收业务费用!");
			//document.getElementById("ysywfed").focus();
		//}
	}else{
		document.getElementById("reasonDiv").style.display = "";;
		document.getElementById("reasonDivBig").style.display = "";
		document.getElementById("changeReason").focus();
	}
}



// 确定
function f_sure(){
	var ysywf = document.getElementById("ysywf").value;
	var ysywfed = document.getElementById("ysywfed").value;
	
	var changeReason = document.getElementById("changeReason").value;
	
	if(changeReason=="" || changeReason==null){
		alert("请填写修改原因!");
		document.getElementById("changeReason").focus();
		return;
	}else{
		// 后期调整 ： 去掉 该 限制
		//if(ysywfed*1<=ysywf*1){
			if (thisForm.fireEvent('onsubmit')){
				document.thisForm.action="${pageContext.request.contextPath}/common/bb.do?method=updateMoney";
				thisForm.submit();
			}
		//}else{
			//alert("已收业务费用不能大于应收业务费用!");
			//document.getElementById("ysywfed").focus();
		//}
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
	
// 解决两个小数相加出现多位小数位的问题4
function f_addNum(num1,num2){
	var sq1,sq2,m;
	try{sq1=num1.toString().split(".")[1].length;} catch(e){sq1=0;}
	try{sq2=num2.toString().split(".")[1].length;} catch(e){sq2=0;}
	
	m=Math.pow(10,Math.max(sq1,sq2));
	return ( num1 * m + num2 * m ) / m;
}
	
</script>

</html>