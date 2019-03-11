<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="cn.org.gdicpa.web.pub.util.ASFuntion"%>
<html>
<head>
<%
response.addHeader("Cache-Control", "no-cache");
response.addHeader("Expires", "Thu, 01 Jan 1970 00:00:01 GMT");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	BORDER-RIGHT: #b0c6d8 1px solid; 
	BORDER-TOP: #b0c6d8 1px solid; 
	PADDING-LEFT: 2px; 
	BORDER-LEFT: #b0c6d8 1px solid; 
	WORD-BREAK: break-all; 
	BORDER-BOTTOM: #b0c6d8 1px solid; 
	WORD-WRAP: break-word;
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

.borderColor {
	border: 1px solid red;
}

</style>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/index.css" />	
</head>
<body>
<form name="thisForm" method="post" action="" id="thisForm">

<input type="hidden" id="ctguid" name="ctguid" value="${ct.guid}">
<input type="hidden" id="cltguid" name="cltguid" value="${clt.guid}">
<input type="hidden" id="typeid" name="typeid" value="${typeid}">
<input type="hidden" id="loginid" name="loginid" value="${userSession.userMap.loginid}">
<input type="hidden" id="tempORFinish" name="tempORFinish" >
<input type="hidden" id="bbstate" name="bbstate" value="${ct.bbstate }" >
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

<div id="divBlock" style="height:30px;text-align:center;line-height:30px;position:absolute;width:100%;height:100%; top:expression(this.offsetParent.scrollTop); z-index:1; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;">
	<table border="0" cellpadding="0" cellspacing="0" width="100%" height="100%">
		<tr><td height="20%">&nbsp;</td><td align="center"><img id="divImg" style="width:30px;height:30px;text-align:center;vertical-align:middle;" src="${pageContext.request.contextPath}/images/loading.gif"/>&nbsp;&nbsp;请等待...</td><td>&nbsp;</td></tr>
		<tr><td></td><td>&nbsp;</td><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
	</table>
</div>

<div id="sjbgndDiv" style="position: absolute; width: 500; height: 150; z-index: 3; left: expression(( document.body.clientWidth-600)/2); top: expression(this.offsetParent.scrollTop + 130); border: 1px solid #6595d6; padding: 0px; background: #ffffff; text-align: center; display: none;">
	<div style="line-height:30px;color:white;text-align:left;font-size:15px;padding-left:10px;background: url('${pageContext.request.contextPath}/icons/pic3.png');height:30px;width:100%">
		设置报表年度
	</div>
	<br>
	<table width="450" class="data_tb" align="center">
		<tr>
			<td class="data_tb_alignright" width="25%">报表年度：</td>
			<td class="data_tb_content">
				<input maxlength="4" onfocus="onPopDivClick(this);" style="text-align: right;"
    					autoWidth=120
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						autoid=54 
						refer="年份" 
						noinput=true 
						class="data_tb_content" 
						hideresult=true size="5" id="nf" name="nf" onchange="setBgnd(this);checkNfAndYf();">年
						
    			&nbsp;从<input maxlength="4" onfocus="onPopDivClick(this);" style="text-align: right;"
    				    autoWidth=100
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						autoid=54 
						refer="月份" 
						noinput=true 
						class="data_tb_content" 
						hideresult=true size="3" id="cyf" name="cyf" onchange="setBgnd(this);checkNfAndYf();">
						
    			月&nbsp;到<input maxlength="4" onfocus="onPopDivClick(this);" style="text-align: right;"
    					autoWidth=100
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						autoid=54 
						refer="年份" 
						noinput=true 
						class="data_tb_content" 
						hideresult=true size="5" id="dnf" name="dnf" onchange="setBgnd(this);checkNfAndYf();">
						
    			年<input maxlength="4" onfocus="onPopDivClick(this);" style="text-align: right;"
    					autoWidth=100
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						autoid=54 
						refer="月份" 
						noinput=true 
						class="data_tb_content" 
						hideresult=true size="3" id="dyf" name="dyf" onchange="setBgnd(this);checkNfAndYf();">月
			</td>
		</tr>
	</table>
	<ul style="list-style: none;">
		<li><input type="button" value="确  定" onclick="f_sure()" />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input icon="icon-delete"
			type="button" value="取  消" onclick="f_cancle()" /></li>
	</ul>

</div>

<div id="divBlock2" style="position:absolute;width:100%;height:100%; top:expression(this.offsetParent.scrollTop); z-index:1; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;">
</div>

<table width="98%" height="5%" border="0" cellspacing="0" cellpadding="0">
	<tr align="center">
		<td width="70%" align="center">
		 	<center class="formTitle">
				${ct.wtxmlx }
			</center>
		</td>
	</tr> 
	 
</table>

<c:if test="${ct.bbbh != null}">
<div id="bbnum" style="text-align: center;">
		防伪编号：<input style="background-color: white;border: 0px" value="${ct.bbbh}" id="bbbh" name="bbbh" readonly="readonly" size="30" >
		<br/>
		<span style="color='red'">报备状态:${Bbstate }</span>
</div>
</c:if>	
<br>	
<DIV class=block id=search style="width: 99%;overflow-x:auto;">

<H3 class=tabs id=searchtabs>
	<A class="tab curtab" id="dbswszltab" href="javascript:setTab('search','dbswszl')">报备事务所资料</A> 
	<A class="tab" id="nrytab" href="javascript:setTab('search','nry')">报备内容一</A>
	<A class="tab" id="nretab" href="javascript:setTab('search','nre')">报备内容二</A>
	<A class="tab" id="nrstab" href="javascript:setTab('search','nrs')">上传附件</A>
	<div id="fsave" style="text-align:right;margin-right:10px;margin-top: 1%">
		   	<span id="standardPriceButton">			
			  <input type="button" icon="icon-method" name="ysywfBtn" id="ysywfBtn" value="发改委、财政厅收费标准" onclick="f_countYsywf();">
			</span>
			
			<c:if test="${ct.bbstate == '暂存' || ct.bbstate == '' || ct.bbstate == null}">
			   <input type="button" name="zcBtn" id="zcBtn" value="暂  存" onclick="saveTempCompanyJudge();">
			</c:if> 
		   <span id="wcSpan">
			   <input type="button" icon="icon-save" name="wcBtn" id="wcBtn" value="报备完成" onclick="saveCompanyJudgeAddWait();">
		   </span>
		   <span id="sqSpan">
		   	   <input type="button" icon="icon-save" name="sqbtn" id="sqbtn" value="申请审核" onclick="saveApplyAddWait()">
		   </span> 
		   <span id="saveSpan" style="display: none">
		   	   <input type="button" icon="icon-save" name="savebtn" id="savebtn" value="保存" onclick="f_save();">
		   </span> 
		   <input type="button" icon="icon-back" name="fhBtn" id="fhBtn" value="返  回"  class="flyBT" onclick="goback();">
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
		<td class="data_tb_content" colspan="3" width="80%" height="18">${clt.companyName }
			<input name="companyName" type="hidden" id="companyName" style="width: 90%" value="${clt.companyName }" readonly="readonly">
		</td>
		 
	</tr>
	  
	<tr>
		<td class="data_tb_alignright" width="20%" height="21">事务所归属地&nbsp;</td>
		<td class="data_tb_content" colspan="3" width="30%" height="18">${clt.area}
			<input name="area"   type="hidden" id="area" style="width: 90%" value="${clt.area}">
		</td>
	</tr>
	 
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">联系人<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" height="18" colspan="3"> 
			<input maxlength="25" name="linkman" class="required" type="text" id="linkman" style="width: 25%" value = "${clt.person}" >
		</td>
	</tr>
	
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">联系电话<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" height="18" colspan="3"> 
			<input maxlength="100" name="linkphone" class="required" type="text" id="linkphone" style="width: 25%" value = "${clt.phone }" >
		</td>
	</tr>
	
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">传&nbsp;&nbsp;&nbsp;&nbsp;真<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input maxlength="50" name="faxes" myClass="phone" class="required" type="text" id="faxes" style="width: 68%" value="${clt.faxes }" >
		</td>
		<td class="data_tb_alignright" height="18" style="width:20%;">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;编<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" height="18"> 
			<input maxlength="50" name="post" myClass="number" class="required" type="text" id="post" style="width:205px;" value = "${clt.post }">
		</td>
	</tr>
	
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">地&nbsp;&nbsp;&nbsp;&nbsp;址<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" height="18" colspan="3"> 
			<input maxlength="100" name="address" class="required" type="text" id="address" style="width: 92%" value = "${clt.address }" >
		</td>
	</tr>
	
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">E-Mail<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" width="30%" height="18"> 
			<input maxlength="50" name="email" class="required" type="text" myClass="email" id="email" style="width: 68%" value="${clt.email }" >
		</td>
		<td class="data_tb_alignright" height="18" style="width:20%;">网&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址&nbsp;</td>
		<td class="data_tb_content" height="18"> 
			<input maxlength="50" name="url" type="text" id="url" style="width:205px;" value = "${clt.url }" >
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
    <td width="30%" height="23" class="data_tb_content">
    	<input maxlength="300" title="委托单位名称" onfocus="onPopDivClick(this);" 
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						onchange="setInfo();"
						norestorehint=true
						autoid=30
						refer="loginid"
						hideresult=true id="wtdwmc" value="${ct.wtdwmc }" name="wtdwmc" style="width: 85%" class="required" >
    </td>
    <td width="20%" height="23" class="data_tb_alignright">被审(验)单位名称<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="23" class="data_tb_content">
    	<input maxlength="300" title="被审单位名称" onfocus="onPopDivClick(this);" 
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();getProjectName();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=31
						refer="loginid"
						hideresult=true id="bsdwmc" value="${ct.bsdwmc }" name="bsdwmc" style="width: 85%" class="required" onchange="getProjectName();"></td>
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
    <td width="20%" height="46" class="data_tb_alignright">被审（验）单位实收资本<font color="#FF0000" >&nbsp;[*]（保留小数点后四位以上，不作四舍五入）</font></td>
    <td width="30%" height="46" class="data_tb_content"> 
    	<input maxlength="20" id="bsdwzczb" value="${ct.bsdwzczb }" style="width: 75%" name="bsdwzczb" class="required number" onkeyup="f_moneys(this);" onpaste="return false">万元&nbsp;&nbsp;&nbsp;&nbsp; <br />
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
						onchange="checkBbIsExist();" 
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
		<select onchange="sfdb(this);" style="width: 85%;" name="sfdbxm" id="sfdbxm" class="required">
			<option value="否">否</option>
			<option value="是" <c:if test="${ct.sfdbxm=='是' }">selected</c:if>>是</option>
		</select>
	</td>
    <td width="20%" height="10" class="data_tb_alignright">是否招投标<font color="#FF0000">&nbsp;[*]</font></td>
	<td width="30%" height="23" class="data_tb_content">
		<select style="width: 85%;" name="sfztb" id="sfztb" class="required">
			<option value="否">否</option>
			<option value="是" <c:if test="${ct.sfztb=='是' }">selected</c:if>>是</option>
		</select>
	</td>
  </tr>
  <tr>
    <td width="20%" class="data_tb_alignright" id="dbxm1" <c:if test="${ct.sfdbxm=='是' }">style='display:;'</c:if><c:if test="${ct.sfdbxm!='是' }">style='display:none;'</c:if> >打包项目名称<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" class="data_tb_content" id="dbxm2" colspan="3"  <c:if test="${ct.sfdbxm=='是' }">style='display:;'</c:if><c:if test="${ct.sfdbxm!='是' }">style='display:none;'</c:if> ><input type="text" maxlength="50" title="打包项目名称" id="dbxmmc" value="${ct.dbxmmc }" style="width: 95%" name="dbxmmc" ></td>
  </tr>
  <tr>
    <td width="20%" height="10" class="data_tb_alignright">委托项目类型<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="10" class="data_tb_content"><input maxlength="50" title="委托项目类型" id="wtxmlx" readonly="readonly" value="${ct.wtxmlx }" style="width: 85%" name="wtxmlx" class="required"></td>
    <td width="20%" class="data_tb_alignright">业务约定书号码<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" class="data_tb_content"><input maxlength="50" title="业务约定书号码" id="ywyds" value="${ct.ywyds }" style="width: 85%" name="ywyds" class="required"></td>
  </tr>
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">签约日期&nbsp;</td>
    <td width="30%" height="16" class="data_tb_content"><input maxlength="50" id="qyrq" value="${ct.qyrq }" style="width: 70%" name="qyrq" showcalendar="true" onkeypress="return false;" onpaste="return false;"></td>
    <td width="20%" height="16" class="data_tb_alignright">报告文号<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="30%" height="16" class="data_tb_content"><input maxlength="50" title="报告文号" id="bgwh" value="${ct.bgwh }" name="bgwh" style="width: 85%" class="required"></td>
  </tr>
  <tr>
    <td width="20%" height="16" class="data_tb_alignright">项目名称<font color="#FF0000">&nbsp;[*]</font></td>
    <td width="80%" height="16" colspan="3" class="data_tb_content">
    	<input maxlength="300" title="项目名称" id="xmmc" value="${ct.xmmc }" name="xmmc"style="width: 95%" class="required"><br/>
    	<font color="#FF0000">[被审(验)单位名称+报表年度/验资区间+报备类型]</font>
    </td>
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
		    			valuemustexist=true 
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
		    	valuemustexist=true 
				>
	</td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%">
    	签名注师三
	</td>
    <td class="data_tb_content" width="30%">
		<input maxlength="50" id="qmzs3" name="qmzs3" value="${ct.qmzs3 }"  
						onfocus="onPopDivClick(this);"
			 			onchange="isQmzs(this,'3');"
    					autoWidth=190
						autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						hideresult=true 
						style="width: 85%"
						refer="${userSession.userMap.officecode }" 
				    	autoid="50" title="签名注师三" 
				    	valuemustexist=true 
						>
	</td>
    <td class="data_tb_alignright" width="20%">
    	签名注师四
    </td>
    <td class="data_tb_content" width="30%">
		<input maxlength="50" id="qmzs4" name="qmzs4" value="${ct.qmzs4 }"  
						onfocus="onPopDivClick(this);"
			 			onchange="isQmzs(this,'4');"
    					autoWidth=190
						autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						hideresult=true 
						style="width: 85%"
						refer="${userSession.userMap.officecode }"
				    	autoid="50" title="签名注师四" 
				    	valuemustexist=true 
						>
	</td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%">
    	签名注师五
    </td>
    <td class="data_tb_content" width="30%">
		<input maxlength="50" id="qmzs5" name="qmzs5" value="${ct.qmzs5 }"  
						onfocus="onPopDivClick(this);"
			 			onchange="isQmzs(this,'5');"
    					autoWidth=190
						autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						hideresult=true 
						style="width: 85%"
						refer="${userSession.userMap.officecode }"  
				    	autoid="50" title="签名注师五" 
				    	valuemustexist=true 
						>
	</td>
    <td class="data_tb_alignright" width="20%">
    	签名注师六
	</td>
    <td class="data_tb_content" width="30%">
		<input maxlength="50" id="qmzs6" name="qmzs6" value="${ct.qmzs6}"  
						onfocus="onPopDivClick(this);"
			 			onchange="isQmzs(this,'6');"
    					autoWidth=190
						autoHeight=180
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						hideresult=true 
						style="width: 85%"
						refer="${userSession.userMap.officecode }" 
						autoid="50" title="签名注师六" 
						valuemustexist=true 
						>
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
    <td class="data_tb_content" width="30%"><input maxlength="50" style="height: 0px;" id="zlry" value="${ct.zlry }" name="zlry" style="width: 85%"></td>
    <td class="data_tb_alignright" width="20%">被审(验)单位注册地址<font color="#FF0000" class="required">&nbsp;[*]</font></td>
    <td class="data_tb_content" width="30%"><br>
    
     <input  id="ywarea" type="text"  name="ywarea" style="display:none;" value="${ct.ywarea}"/>	
   
						<input type="checkbox" id="other" />外省地区<br/>
    	<input  maxlength="50" onfocus="onPopDivClick(this);" title="业务所在地"
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
						hideresult=true id="ywarea2" value="" style="width: 85%;" name="ywareaywarea">
						
						<span id="otherspan" style="display:none;"><input type="text" name="ywarea3" id="ywareaother" value=""  class="required"/> <font id="ywareaother" color="#FF0000" class="required" >格式：四川省成都市</font><br/></span>
						
						<font color="#FF0000" class="required">[请非本地报备重新选择或填写]</font>
					</td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%">报告日期<font color="#FF0000">&nbsp;[*]</font></td>
    <td class="data_tb_content" width="30%">
    	<input maxlength="50" id="bgrq" value="${ct.bgrq }" style="width: 70%" name="bgrq" showcalendar="true" class="required" onkeypress="return false;" onpaste="return false;" onchange="bgrqChange();">
    </td>
    
   	<td class="data_tb_alignright" width="20%">报告年度</td>
    <td class="data_tb_content" width="30%">
    	<input id="baogaoniandu" value="${ct.baogaoniandu }" style="width: 85%;background-color: #F0F0F0;border: 1px solid grey;" name="baogaoniandu" title="报告年度" readonly="readonly">
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
    <td width="80%" height="16" colspan="3" class="data_tb_content"><textarea id="leaveword" name="leaveword" style="width: 95%;height: 45;">${ct.leaveword }</textarea></td>
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
						autoid=71
						refer="报备收费类型"
						onchange="f_setsfbz(this)"
						hideresult=true title="计费方式" id="sfbz" name="sfbz" value="${ct.sfbz }" style="width:22%" class="required">
    </td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%">业务约定书收费金额<font color="#FF0000">&nbsp;[*]</font></td>
    <td class="data_tb_content" width="30%"><input maxlength="20" id="ysywf" value="${ct.ysywf }" style="width: 60%" name="ysywf" class="required number" onkeyup="f_moneys(this);" onpaste="return false" >元(人民币)</td>
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
						hideresult=true title="收费依据" id="sfyj" value="${ct.sfyj }" name="sfyj" style="width: 85%" >
	</td>
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
   
   <tbody id="tjshqkTbody">
  	  <tr>
	  	<td class="data_tb_alignright" width="20%" height="16"><input id="isaPropery_ipt" name="isaPropery_ipt" value="需要提交审核情况" readonly="readonly" style="border: 0px;background: #e4f4fe;text-align: right;"> </td>
	    <td width="80%" height="16" colspan="3" class="data_tb_content">
	    	<input type="checkbox" id="isauditPropery" name="isauditPropery" <c:if test="${at.isauditPropery=='是' }">checked="checked"</c:if> value="${at.isauditPropery}"  onclick="f_setqksmTbody(this)">
	    </td>
	  </tr>
  </tbody>
  <tbody id="qksmTbody">
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
  	  <!-- 
  	  <tr>
	  	<td class="data_tb_alignright" width="20%" height="16">市注协复核意见</td>
	    <td width="80%" height="16" colspan="3" class="data_tb_content">
	    	<textarea id="jj_cityAdvice" name="jj_cityAdvice" style="width: 95%;height: 45;" readonly="readonly" >${at.cityAdvice }</textarea>
	    </td>
	  </tr>
  	   -->
	  <tr>
	  	<td class="data_tb_alignright" width="20%" height="16">省注协复核意见</td>
	    <td width="80%" height="16" colspan="3" class="data_tb_content">
	    	<textarea id="jj_checkAdvice" name="jj_checkAdvice" style="width: 95%;height: 45;" readonly="readonly" >${at.checkAdvice }</textarea>
	    </td>
	  </tr>
   </tbody>
   
</table>
<div id="sqDivObj" style="background-color: #e8f7fc;">
	<br>
	<input class="data_tb_alignright" type="button" icon="icon-save" name="sqbtn2" id="sqbtn2" value="申请审核" onclick="saveApplyAddWait();">
</div>
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

<input type="hidden" id="isPropery_temp" name="isauditPropery"  value="${at.isauditPropery}" disabled="disabled">
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

	//加验证
  $(document).ready(function(){
    $("#thisForm").validate();
  });
  
	//加输入限制
  $(document).ready(function(){
    $("input.zipcode").mask("999999");
  }); 
	
	
	// 报告年度
	var baogaoniandu = "${ct.baogaoniandu}";
	if(baogaoniandu==""){
		document.getElementById("baogaoniandu").value = <%=new ASFuntion().getCurrentDate().substring(0,4)%>+"年度";
	}

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

	var typeid = "${typeid}";
	var privince = "${userSession.userMap.sys_province_cicpa}";
	// 这些报备分类不需要进行报备申请
 	if(privince=="四川省注协" && typeid!="qssh001" && typeid!="hbsj001" 
 			&& typeid!="flsj001" && typeid!="sj001" && typeid!="yz001"){
 	    
 	    // 判断是否已经达到报备最大份数，如果达到最大份数就溢出了，必须走申请流程
 	    var rs_sfyc = f_getCPAFYZReportCount("notalert");
 	    // 没有报备溢出，那么这些报备分类不用走申请流程，直接报备完成。
		if(rs_sfyc!="N"){
	 	    // 申请审核按钮
	 		document.getElementById("sqSpan").style.display = "none";
	 		document.getElementById("sqDivObj").style.display = "none";
			// 是否需要提交申请审核
	 		document.getElementById("tjshqkTbody").style.display = "none";
			// 情况说明
	 		document.getElementById("qksmTbody").style.display = "none";
		} 	    
 	    // 物价局收费标准按钮
 	    document.getElementById("standardPriceButton").style.display = "none";
 	}
 	
 	// 只读字段控制
 	function f_readOnlyProperty(array){
		var form_obj = document.all; 
		//form的值
		for (var i=0;i<form_obj.length ;i++ ) {
			e=form_obj[i];
			if (e.tagName=='INPUT' || e.tagName=='TEXTAREA') {
				for(var l=0;l<array.length;l++){
					if(e.id==array[l]){
						if(e.value==""){
							var equalsValue = "N";
							for(var m=0;m<nullValueArray.length;m++){
								if(e.id==nullValueArray[m]){
									equalsValue = "Y";
									break;
								}
							}
							if(equalsValue=="N"){
								e.readOnly = true ;
								e.className = "before";
								if(e.type == 'checkbox'){
									e.disabled = true ;
									if(e.id=="isauditPropery"){
										document.getElementById("isPropery_temp").disabled = false;
									}
								}
							}
						}else{
							e.readOnly = true ;
							e.className = "before";
							if(e.type == 'checkbox'){
								e.disabled = true ;
								if(e.id=="isauditPropery"){
									document.getElementById("isPropery_temp").disabled = false;
								}
							}
						}
					}
				}
			}
		}
 	}
 	
 	// 字段内容为空的时候不锁定，因为更新之前一些报备数据这些字段可能不是必填项导致可能没有填写这些数据。
 	var nullValueArray = ["ywarea","yzhl","yzbz","cyry","sjlx"]; 
 	
 	// 初审通过后的只读字段
 	var cstg_ReadOnlyProertyArray = ["wtdwmc","bsdwmc","ysywf","kmhylx","xmkhlx","sfbz",
	 								"cyry","xssr","yysr","zcze","yzbzje","yzswje",
	 								"yztdsyje","yzqtwszcje","yzqtje","yzhl","yzbz","sjlx",
	 								"isauditPropery","standard","ywarea","zxsjje","sjns",
	 								"duty1","countPeople1","countHour1","countMoney1","property1",
	 								"duty2","countPeople2","countHour2","countMoney2","property2",
	 								"duty3","countPeople3","countHour3","countMoney3","property3",
	 								"duty4","countPeople4","countHour4","countMoney4","property4",
	 								"duty5","countPeople5","countHour5","countMoney5","property5",
	 								"duty6","countPeople6","countHour6","countMoney6","property6",
	 								"zcze1","xssr1","yysr1","zxsjje1","cyry1",
	 								"zcze2","xssr2","yysr2","zxsjje2","cyry2",
	 								"zcze3","xssr3","yysr3","zxsjje3","cyry3",
	 								"zcze4","xssr4","yysr4","zxsjje4","cyry4",
	 								"zcze5","xssr5","yysr5","zxsjje5","cyry5"];
	
	/*
	 申请审核后就只能保存部分字段：可能存在省注协领导正在审批申请审核数据，
	 然后事务所有跑进去修改了一些敏感的信息。倒是省注协看到的数据和事务所修改后的数据不一致。
	 */
 	var bbState = "${ct.bbstate}";
 	if(bbState == "初审通过" || bbState == "申请审核" || bbState == "待审申请审核"){
 		// 只读控制
 		f_readOnlyProperty(cstg_ReadOnlyProertyArray);
	 	// 申请审核按钮
		document.getElementById("sqSpan").style.display = "none";
		document.getElementById("sqDivObj").style.display = "none";
		// 保存按钮
		document.getElementById("saveSpan").style.display = "";
 	}
 	
 	
 	if(bbState == "审核通过"){
	 	// oa 导入进系统的 已签业务的报备数据
	 	var isyqyyw = "${at.isyqyyw}"; 
 		if(isyqyyw=="1"){// oa 导入进系统的 已签业务的报备数据
	 		var shtg_ReadOnlyProertyArray = ["wtdwmc","bsdwmc","ysywf","standard","sfbz","isauditPropery"];   
			// 只读控制
 			f_readOnlyProperty(shtg_ReadOnlyProertyArray);
		}else{
	 		// 只读控制
 			f_readOnlyProperty(cstg_ReadOnlyProertyArray);
		}
		
		 // 申请审核按钮
 		document.getElementById("sqSpan").style.display = "none";
 		document.getElementById("sqDivObj").style.display = "none";
 		// 保存按钮
 		document.getElementById("saveSpan").style.display = "";
 	}
 	
 	if(bbState == "审核未通过"){
 		// 保存按钮
 		document.getElementById("saveSpan").style.display = "";
 	}
 	
	var ctguid = document.getElementById("ctguid").value;
	if(ctguid==null || ctguid==""){	
		// 报告年度 默认当前年
		// var date = new Date();
		//document.getElementById("bgnd").value = date.getYear()+"年度";
		//document.getElementById("bgrq").value = getDate();
		//document.getElementById("qyrq").value = getDate();
		//document.getElementById("sfrq").value = getDate();
		var area = "${userSession.userMap.area}";
		if(area== '广州' || area== '深圳' || area== '东莞'){
			document.getElementById("ywarea").value = "";
		}else{
			document.getElementById("ywarea").value = area;
		}
	}
	
	
	// 收费标准默认设置为 ： 计件收费
	var sfbzObj = document.getElementById("sfbz");
	if(sfbzObj.value==""){
		sfbzObj.value = "计件收费";
	 	// 不可以走申请流程的报备分类的计费方式只能是计件收费。
	 	if(!f_isSqsh()){
	 		sfbzObj.readOnly = true;
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

//遮罩层
var divBlock = document.getElementById("divBlock");
//报备完成时加了等待进度
function saveCompanyJudgeAddWait(){
    //审计类型选择了年报审计和月财务报表审计这两项时, 报表年度设为必填项
    //alert(twoHtml);
    var stwoHtml = "${twoHtml}";
    //alert(stwoHtml);
    if (stwoHtml=="addBbsjb.jsp"){
      var sjlx = document.getElementById("sjlx").value;
    //alert(sjlx);
      var bgnd = document.getElementById("bgnd").value;
      if(sjlx=='年报审计' || sjlx=='月财务报表审计'){
         if (bgnd==''){
           alert("报表年度不能为空！");
           document.getElementById("bgnd").focus();
	       return;
	     }
      }
    }
	
	
	divBlock.style.display = "";	
	setTimeout("if(saveCompanyJudge()==undefined){divBlock.style.display = 'none';}",1000);
}

// 保存//报备完成（2013-04-23）
function saveCompanyJudge(){	
	
	// 判断当前报备数据状态是否与数据库最新状态一致
	if(!f_checkSaveState()){
		alert("注协刚刚已审核过该报备数据状态，请先返回到列表页面后再进行当前操作！");
		return;
	}
	
	//检查是否禁用自动报备，如禁用了要则走“申请审核”流程
	var s = "${ct.bbstate }";
	if((s =='' || s == '暂存') && isAuto()){
		alert("注协已禁用自动报备，请选择申请审核。");
		return;
	}else if(s == '申请审核' && isAuto()){
		alert("注协已禁用自动报备，要审核通过才能报备完成。");
		return;
	}else if(s == '审核未通过' && isAuto()){
		alert("注协已禁用自动报备，要审核通过才能报备完成。");
		return;
	}

	// 如果是其他类型的报备 并且 其它业务类型 字段 包含了 一下字眼 就提示不能进行报备完成
	var typeid = document.getElementById("typeid").value;
	if(typeid=="bbqt001"){
		var bustypeObj = document.getElementById("bustype");
		var bustypeArray = ["审计","验资","清算审计","合并审计","分立审计","清产核资","司法会计鉴定","外汇年检"];
		for(var i=0;i<bustypeArray.length;i++){
			if(bustypeObj.value.indexOf(bustypeArray[i])>-1){
				setTab('search','nre');
				bustypeObj.select();
				alert("请按正确报备类型报备，如有问题请与省注协联系！");
				return;
			}
		} 
	}
	
	//检查当审计类型为年报审计时。假如数据库里有被审计单位名称相同和报表年度相同的，就要弹出提示：‘该份报告已经在别家事务所出具了。’单单提示而已。
	checkBbIsExist();
	
	var bbState = f_getStateByGuid("${ct.guid}");
	var typeid = "${typeid}";
	
	// 初审通过
	if(bbState=="cstg"){
		alert("正在省注协审核中！");
		return;
	}
	
	// 申请不检查：暂存、申请审核、审核通过、审核未通过、审核通过
	if(bbState!="shtg"){
		// 验证报备份数
		if(typeid=="yz001"){
			var rs = f_getCPAYZReportCount("alert");
			if(rs=="N"){
				return;
			}
		}else{
			var rs = f_getCPAFYZReportCount("alert");
			if(rs=="N"){
				return;
			}
		}
	}else{
		// 验证报备份数
		if(typeid=="yz001"){
			f_getCPAYZReportCount("notalert");
		}else{
			f_getCPAFYZReportCount("notalert");
		}
	}
	
	var parentId = "${parentId}";
	if(parentId!="" && parentId!=null){
		document.getElementById("tempORFinish").value="待审报备完成"; 
	}else{
		document.getElementById("tempORFinish").value="报备完成"; 
	}
	 
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
	
	//报告日期不能超过当天日期
	var newDate = "<%=new ASFuntion().getCurrentDate()%>";
	var bgrq = document.getElementById('bgrq').value;
	if(bgrq>newDate){
		alert("报告日期不能超过当天日期！");
		setTab('search','nry') ;
		document.getElementById('bgrq').select();
		return;
	}
	
	var officeType = "${userSession.userMap.officetype}";
	if(officeType=="事务所"){
		var bgnd = document.getElementById("bgnd").value;
		var bgndTitle = "报表年度";
		if(typeid=="yz001"){
			bgndTitle = "验资区间";	
		}
		if(typeid!="yz001" && (bgnd == "" || bgnd == null)){
			if(confirm("当前"+bgndTitle+"为空,如果确定要填写"+bgndTitle+"请点击确定,不填"+bgndTitle+"请点击取消?")){
				setTab('search','nre');
				document.getElementById("bgnd").select();
				return;
			} 
		} 
		//if(!isQmzs()) return false;
		if(!isOnly()) return;
	}
	if(!isBusSum()) return;
	
	var yzbguid = document.getElementById("ctguid").value;
	var addJsp = document.getElementById("addJsp").value;
	var updateJsp = document.getElementById("updateJsp").value;
	var ysywf = document.getElementById("ysywf").value;
	var ysywfed = document.getElementById("ysywfed").value;
	
	// 查看报告文号是否重复
	var loginid = document.getElementById("loginid").value;
	var bgwh = document.getElementById("bgwh").value;
	
	var url = "";
	var request = "";
	if(yzbguid!="" && yzbguid != null){  // 修改 就查看除了本条之外是否有其他的报告文号,本条报备数据的报告文号例外
		url="${pageContext.request.contextPath}/common/content.do?method=seeBgwhUpdate";
		request = "&loginid="+loginid+"&typeid="+typeid+"&bgwh="+bgwh+"&guid="+yzbguid;
	}else{	// 添加操作 只要有报告文号  就提示重复
		url="${pageContext.request.contextPath}/common/content.do?method=seeBgwh";
		request = "&loginid="+loginid+"&typeid="+typeid+"&bgwh="+bgwh;
	}
	var resText = ajaxLoadPageSynch(url,request);

	if(resText!="Y"){
		var res = resText.split(",#$");
		alert("您填写的报告文号"+bgwh+"与报备时间为"+res[1].substring(0,10)+"、防伪编号为"+res[3]+"、项目名称为 '"+res[0]+"' 的报备记录的报告文号重复,请改为其他文号!");
		setTab('search','nry') ;
		document.getElementById("bgwh").select();
		return ;
	} 
	
	// 如果是计时收费 那么 申请审核与报备完成的时候检查 应收业务费与总金额合计是否一致
	if(f_isSqsh()){
		if(!f_jssf_same()){
			return;
		}
	}
		
	var sfbz = document.getElementById("sfbz").value;
	// 检查计时收费信息
	if(sfbz=="计时收费"){
		if(f_isSqsh()){
			if(!f_checkJSSF()){
				return;
			}
		}
	}
	
	//document.getElementById("zdsfbzje").value = document.getElementById("standerPrice").value; 
	document.getElementById("zdsfbzje").value =0;
	
	// 设置 已收业务费和 开具发票号 字段值的 修改时间
	f_setUpdateTime();	
	
	// 判断是否中小微
	var iszxw = f_checkCompanyType();
	if(iszxw=="大型"){
		document.getElementById("iszxw").value = "0";
	}else{
		document.getElementById("iszxw").value = "1";
	}

	//审计类型为：经济责任审计'、'改制审计'、'财务收支审计业务'、'涉及经济案件审计'、'基本建设工程决算审核'、'其他专项审计'的时候,"专项审计名称"必填，会显示在封面。
	if(typeid=='sj001'){
		var sjlx = document.getElementById("sjlx").value;
		var zxsjmc = document.getElementById("zxsjmc").value;
		if((sjlx=='经济责任审计' || sjlx=='改制审计' || sjlx=='财务收支审计业务' || 
				sjlx=='涉及经济案件审计' || sjlx=='基本建设工程决算审核' || sjlx=='其他专项审计') && zxsjmc==''){
			alert("审计类型为【'经济责任审计'、'改制审计'、'财务收支审计业务'、'涉及经济案件审计'、'基本建设工程决算审核'、'其他专项审计'】 时，\"专项审计名称\"必填!");
			document.getElementById("zxsjmc").select();
			return;
		}
		
	}
	
//收费标准(计算的地方)------------------------------------------------------------------------------
	var bbstate = "${ct.bbstate}";
	if(bbstate!="审核通过" && f_isSqsh()){
		if(getChargeStandard()=="N"){
			return;
		}
		var moneys = JSON.parse(getChargeStandard());
		
		document.getElementById("discountBySeven").value = moneys.discount;//已打折
		document.getElementById("zdsfbzje").value = moneys.standardPrice;//未打折
		
		var sfbz_money = moneys.discount;
		
		sfbz_money = sfbz_money*1;
		var ysywf = document.getElementById("ysywf").value*1;
		if(ysywf<sfbz_money){
			var typeid = "${typeid}";
			if(typeid=="yz001"){
				alert("您所填报的业务约定书收费金额"+ysywf+"元，低于发改委、财政厅收费标准"+sfbz_money.toFixed(2)+"元，不能进行报备！如果您确定要以本收费金额进行报备，请到【收费信息】选择【计费方式】，填写提示的信息申请审核，注协【审核通过】后可以点击【修改】进行【报备完成】。");
				return;
			}else{
				alert("你所报备的业务报告收费低于《四川省会计师事务所服务收费管理办法》规定，将被列为重点监管对象，请及时整改。");
			}
		}
	}
	
	// 检查分类报备的调整后金额
	if(typeid=="qchz001" || typeid=="qssh001" || typeid=="sj001" || typeid=="sfkjjd001" || typeid=="flsj001" || typeid=="hbsj001" ){
		var tzh_rs = f_check_tzh_money();
		if(tzh_rs=="notAlert"){
			return;
		}
	}
	
	//是否打包项目
	
	if(isSfdbxm()){
		return;
	}
	
	var ysywfed = document.getElementById("ysywfed").value;
	var kjskdfphd = document.getElementById("kjskdfphd").value;
	//var kjskdfphd2 = document.getElementById("kjskdfphd2").value;
	if(ysywfed*1>0 && kjskdfphd==""){
		alert("请填写开具收款发票号码!");
		document.getElementById("kjskdfphd").select();
		return;
	}
	
	if(yzbguid=="" || yzbguid == null){
		document.thisForm.action=addJsp;
		if (thisForm.fireEvent('onsubmit')){
			if(confirm("点击报备完成后，只有客户信息的被审（验）单位出资类型、币种、被审（验）单位经济性质、被审（验）单位行业类型、是否上市企业、项目客户类型、被审（验）单位注册地址、注册地址、负责人姓名、联系人姓名、联系人电话在一个月内可以修改，还有收费信息的已收业务费、收费日期、开具发票收款号码的第2个框、收费说明可以修改，其他的修改必须向省注协申请，请确认是否报备完成？")){
				// 罩层 
				document.getElementById("divBlock2").style.display = "";
				thisForm.submit();
			}
		}
	}else{
		document.thisForm.action=updateJsp;
		if (thisForm.fireEvent('onsubmit')){
			if(confirm("点击报备完成后，只有客户信息的被审（验）单位出资类型、币种、被审（验）单位经济性质、被审（验）单位行业类型、是否上市企业、项目客户类型、被审（验）单位注册地址、注册地址、负责人姓名、联系人姓名、联系人电话在一个月内可以修改，还有收费信息的已收业务费、收费日期、开具发票收款号码的第2个框、收费说明可以修改，其他的修改必须向省注协申请，请确认是否报备完成？")){
				// 罩层 
				document.getElementById("divBlock2").style.display = "";
				thisForm.submit();
			}
		}
	}
	
}


//检查是否禁用自动报备
function isAuto(){
	var loginid = "${userSession.userMap.loginid}";
	url="${pageContext.request.contextPath}/common/content.do?method=isAuto";
	request = "&loginid="+loginid;
	var resText = ajaxLoadPageSynch(url,request);
	if(resText=='1'){
		return true;
	}
	return false;
}

// 客户行业类型： 如果 加载出来的数据不在新的 下拉选项的话让 用户重新选择 值。
function f_check_kmhylx(){  

	var kmhylxObj = document.getElementById("kmhylx");
	
	var kmhylxValueArray = ["农、林、牧、渔业","工业","建筑业","批发业","零售业",
							"交通运输业","仓储业","邮政业","住宿业","餐饮业",
							"信息传输业","软件和信息技术服务业","房地产开发经营","物业管理","租赁和商业服务业",
							"其他未列明行业"]; 
	var kmhylxSame = "N";							
	for(var n=0;n<kmhylxValueArray.length;n++){
		if(kmhylxObj.value==kmhylxValueArray[n]){
			kmhylxSame = "Y";
			break;
		}
	}
	if(kmhylxSame=="N"){
		kmhylxObj.value="";
		setTab('search','nry');
		kmhylxObj.select();
		return false;
	}else{
		return true;
	}
}

//申请审核时加了等待进度
function saveApplyAddWait(){
	divBlock.style.display = "";
	setTimeout("if(saveApply()==undefined){divBlock.style.display = 'none';}",1000);
}

//申请审核(1491-1817行)
function saveApply(){
	// 判断当前报备数据状态是否与数据库最新状态一致
	if(!f_checkSaveState()){
		alert("注协刚刚已审核过该报备数据状态，请先返回到列表页面后再进行当前操作！");
		return;
	}
	var bbstate = f_getStateByGuid("${ct.guid}");
	// 初审通过或者审核通过
	if(bbstate=="cstg" || bbstate=="shtg"){
		alert("已申请审核！");
		return;
	}
	// 取消  业务信息 里面的必填项
	if(!f_cancelInputRequired()){
		return;
	};
	
	// 客户行业类型： 如果 加载出来的数据不在新的 下拉选项的话让 用户重新选择 值。
	if(!f_check_kmhylx()){
		return;
	}
	var typeid = "${typeid}";
	
	//如是其他专项审计则一定要申请审核
	var isTrue = true;
	if(typeid=="sj001"){
		var sjlx = document.getElementById("sjlx").value;
		if(sjlx=="其他专项审计"){
			isTrue = false;
		}
	}
	// 验证 应收业务费用 和 省物价局规定的收费标准
	if(isTrue && f_isSqsh()){
		if(getChargeStandard()=="N"){
			return;
		}
		var moneys = JSON.parse(getChargeStandard());
		
		document.getElementById("discountBySeven").value = moneys.discount;//已打折
		document.getElementById("zdsfbzje").value = moneys.standardPrice;//未打折
		document.getElementById("standerPrice").value = moneys.standardPrice;//加入bb_apply表未打折
		
		var sfbz_money = moneys.discount;
		
		sfbz_money = sfbz_money*1;
		var ysywf = document.getElementById("ysywf").value*1;
		
		//isAuto()为true时表是被禁用自动报备，即使达标也要申请审核。
		if(ysywf>=sfbz_money && !isAuto()){
			alert("已达到收费标准，请直接报备完成。");
			return;
		}
	}
	
	// 是否溢出
	var rs_sfyc="Y";
	// 验证报备份数：确定该报备数据是否溢出
	if(typeid=="yz001"){
		var rs_sfyc = f_getCPAYZReportCount("notalert");
	}else{
		var rs_sfyc = f_getCPAFYZReportCount("notalert");
	}
	
	// 如果是计时收费 那么 申请审核与报备完成的时候检查 应收业务费与总金额合计是否一致
	if(f_isSqsh()){
		if(!f_jssf_same()){
			return;
		}
	}
	
	var yzbguid = document.getElementById("ctguid").value;
	
	var parentId = "${parentId}";
	if(parentId!="" && parentId!=null){
		document.getElementById("tempORFinish").value="待审申请审核"; 
	}else{
		document.getElementById("tempORFinish").value="申请审核";
	}
	
	var addJsp = document.getElementById("addJsp").value;
	var updateJsp = document.getElementById("updateJsp").value;
	
	// 计费方式
	var sfbz = document.getElementById("sfbz").value;
	if(sfbz==""){
		document.getElementById("sfbz").value = "计件收费";
	}
	
	// 检查计时收费信息
	if(sfbz=="计时收费"){
		if(f_isSqsh()){
			if(!f_checkJSSF()){
				return;
			}
		}
	}
	
	// 需要提交审核情况
	var isauditPropery_temp = document.getElementById("isauditPropery");
	if(!isauditPropery_temp.checked){
		alert("请打勾 '需要提交审核情况' !");
		setTab('search','nry') ;
		document.getElementById("isaPropery_ipt").select();
		return;
	}
	var standard = document.getElementById("standard");
	if(standard.value==""){
		setTab('search','nry') ;
		document.getElementById("standard").focus();
		alert("请填写情况说明!");
		return;
	}
	
	//document.getElementById("zdsfbzje").value = document.getElementById("standerPrice").value;
	 
	// 设置 已收业务费和 开具发票号 字段值的 修改时间
	f_setUpdateTime();
	
	// 判断是否中小微
	var iszxw = f_checkCompanyType();
	if(iszxw=="大型"){
		document.getElementById("iszxw").value = "0";
	}else{
		document.getElementById("iszxw").value = "1";
	}
	
	//是否打包项目
	if(isSfdbxm()){
		return;
	}
	
	/* 现在修改为：出提示“该业务为其他事务所转入业务，不能低于基准价”，不能报备完成，但是可以申请审核
	*/
	// 项目客户类型
	var xmkhlx = document.getElementById("xmkhlx").value;
	if(xmkhlx=="其他事务所转入"){
		if(confirm("您当前业务为其他事务所转入业务，且低于基准价,您确认要进行申请审核吗？")){
			if(yzbguid=="" || yzbguid == null){
				document.thisForm.action=addJsp;
			}else{
				document.thisForm.action=updateJsp;
			}
			// 罩层 
			document.getElementById("divBlock2").style.display = "";
			thisForm.submit();
		}
	}else{
		if(yzbguid=="" || yzbguid == null){
			document.thisForm.action=addJsp;
		}else{
			document.thisForm.action=updateJsp;
		}
		// 罩层 
		document.getElementById("divBlock2").style.display = "";
		thisForm.submit();
	}
}

// 保存
function f_save(){
	// 判断当前报备数据状态是否与数据库最新状态一致
	if(!f_checkSaveState()){
		alert("注协刚刚已审核过该报备数据状态，请先返回到列表页面后再进行当前操作！");
		return;
	}
	
	/*
	// 客户行业类型： 如果 加载出来的数据不在新的 下拉选项的话让 用户重新选择 值。
	if(!f_check_kmhylx()){
		return;
	}
	*/
	
	// 如果是计时收费 那么 申请审核与报备完成的时候检查 应收业务费与总金额合计是否一致
	if(f_isSqsh()){
		if(!f_jssf_same()){
			return;
		}
	}
	
	var yzbguid = document.getElementById("ctguid").value;
	document.getElementById("tempORFinish").value=f_convertState(f_getStateByGuid(yzbguid));
	
	// 计费方式
	var sfbz = document.getElementById("sfbz").value;
	if(sfbz==""){
		document.getElementById("sfbz").value = "计件收费";
	}
	
	// 检查计时收费信息
	if(sfbz=="计时收费"){
		if(f_isSqsh()){
			if(!f_checkJSSF()){
				return;
			}
		}
	}
	
	// 检查上一年是否不存在的老客户
	f_sflkh();
	
	//document.getElementById("zdsfbzje").value = document.getElementById("standerPrice").value;
	 
	// 设置 已收业务费和 开具发票号 字段值的 修改时间
	f_setUpdateTime();
	
	// 验证报备份数：确定该报备数据是否溢出
	if(typeid=="yz001"){
		f_getCPAYZReportCount("notalert");
	}else{
		f_getCPAFYZReportCount("notalert");
	}
	
	//是否打包项目
	if(isSfdbxm()){
		return;
	}
	
	var updateJsp = document.getElementById("updateJsp").value;
	document.thisForm.action=updateJsp;
	// 罩层 
	document.getElementById("divBlock").style.display = "";
	thisForm.submit();
}

// 返回
function goback(){	
	history.back();
	/* var model='${model}';
	var typeid = document.getElementById("typeid").value;
	window.location="${pageContext.request.contextPath}/common/bb.do?method=index&typeid=" + typeid+"&fanhui="+model; */
}

//检查签名注师是否相同
function isQmzs(t,num){
	var qmzs1 = document.getElementById("qmzs1").value;
	var qmzs2 = document.getElementById("qmzs2").value;
	var qmzs3 = document.getElementById("qmzs3").value;
	var qmzs4 = document.getElementById("qmzs4").value;
	var qmzs5 = document.getElementById("qmzs5").value;
	var qmzs6 = document.getElementById("qmzs6").value;
	var qmzs7 = document.getElementById("qmzs7").value;
	var temps = [qmzs1,qmzs2,qmzs3,qmzs4,qmzs5,qmzs6,qmzs7];

	for(var i = 0;i<temps.length;i++){
		if(i==(num-1))continue;//  去掉和自己比较 
		if(t.value==temps[i] || temps[i].indexOf(t.value)>-1){
			alert("签名注师不能相同，请重新输入！");
			t.value="";
			t.select();
			return false;
		}
	}
	
	if(qmzs7!=""){
		var arr = qmzs7.split(",");
		for(var j = 0;j<arr.length;j++){
			for(var i = 0;i<temps.length;i++){
				if(i==6)continue;//  去掉和自己比较 
				if(arr[j]==temps[i]){
					alert("签名注师不能相同，请重新输入！");
					t.value="";
					t.select();
					return false;
				}
			}
		}
	}
	
	return true;
}

//检查唯一性
function isOnly(){
	//业务所在地的控制
	var v=$("#ywarea2").val();	
	$("#ywarea").val(v);
	$("#ywarea2").val($("#ywarea").val());
	$("#ywareaother").val(v);
	
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
			alert("业务约定书收费金额不能小于${clt.area}地区的业务金额：" +busSum + "；请重新输入!!");
			document.getElementById("ysywf").select();
			return false;
		}
	}
	return true;
}



//取得当前时间  
function getNowTime(){   
  //取得当前时间   
  var now= new Date();   
  var year=now.getYear();   
  var month=now.getMonth()+1;   
  var day=now.getDate();   
  var hour=now.getHours();   
  var minute=now.getMinutes();   
  var second=now.getSeconds();   
  var nowdate=year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;   
  return nowdate;   
}


// 联动项目名称
function getProjectName(){
	var lx = "${ct.wtxmlx }";
	var bsdwmc = document.getElementById("bsdwmc").value;
	//区分评估所和事务所
	var officeType = "${userSession.userMap.officetype}";
	if(officeType=="事务所"){
		var bgnd = document.getElementById("bgnd").value;
		document.getElementById("xmmc").value = bsdwmc+bgnd+lx+"报告";
	}else{
		document.getElementById("xmmc").value = bsdwmc+lx+"报告";
	}
}


//暂存保存
function saveTempCompanyJudge(){
	var ispObj = document.getElementById("isauditPropery");
	if(ispObj.checked){
		alert("暂存请不要勾选申请审核情况！");
		setTab('search','nry');
		return;
	}
	
	// 判断当前报备数据状态是否与数据库最新状态一致
	if(!f_checkSaveState()){
		alert("注协刚刚已审核过该报备数据状态，请先返回到列表页面后再进行当前操作！");
		return;
	}
	
	// 客户行业类型： 如果 加载出来的数据不在新的 下拉选项的话让 用户重新选择 值。
	if(!f_check_kmhylx()){
		return;
	}
	
	// 查看报告文号是否重复
	var yzbguid = document.getElementById("ctguid").value;
	var loginid = document.getElementById("loginid").value;
	var typeid = document.getElementById("typeid").value;
	var bgwh = document.getElementById("bgwh").value;
	
	var url = "";
	var request = "";
	if(yzbguid!="" && yzbguid != null){  // 修改 就查看除了本条之外是否有其他的报告文号,本条报备数据的报告文号例外
		//url="${pageContext.request.contextPath}/common/content.do?method=seeBgwhUpdate&loginid="+loginid+"&typeid="+typeid+"&bgwh="+bgwh+"&guid="+yzbguid;
		url="${pageContext.request.contextPath}/common/content.do?method=seeBgwhUpdate";
		request = "&loginid="+loginid+"&typeid="+typeid+"&bgwh="+bgwh+"&guid="+yzbguid;
	}else{	// 添加操作 只要有报告文号  就提示重复
		//url="${pageContext.request.contextPath}/common/content.do?method=seeBgwh&loginid="+loginid+"&typeid="+typeid+"&bgwh="+bgwh;
		url="${pageContext.request.contextPath}/common/content.do?method=seeBgwh";
		request = "&loginid="+loginid+"&typeid="+typeid+"&bgwh="+bgwh;
	}
	var resText = ajaxLoadPageSynch(url,request);

	if(resText!="Y"){
		var res = resText.split(",#$");
		alert("您填写的报告文号"+bgwh+"与报备时间为"+res[1].substring(0,10)+"、防伪编号为"+res[3]+"、项目名称为 '"+res[0]+"' 的报备记录的报告文号重复,请改为其他文号!");
		setTab('search','nry');
		document.getElementById("bgwh").select();
		return ;
	} 
	
	document.getElementById("tempORFinish").value="暂存"; 

	// 去必填限制 
	$("input").each(function(index,obj){
		if(obj.className.indexOf("required")>-1){
			obj.className = obj.className.replace("required","");
		}
	});
	
	$("textarea").each(function(index,obj){
		if(obj.className.indexOf("required")>-1){
			obj.className = obj.className.replace("required","");
		}
	});
	
	$.firstUnPassElemnt = null;
	$.hasUnPass = false;
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
	//if(!isQmzs()) return false;
	if(!isOnly()) return;
	if(!isBusSum()) return;
	
	var addJsp = document.getElementById("addJsp").value;
	var updateJsp = document.getElementById("updateJsp").value;
	var ysywf = document.getElementById("ysywf").value;
	var ysywfed = document.getElementById("ysywfed").value;
	
	// 后期调整 ： 去掉 该 限制
	//if(ysywfed*1>ysywf*1){
		//alert("已收业务费用不能大于应收业务费用!");
		//document.getElementById("ysywfed").focus();
		//return;
	//}
	
	
	// 验证报备份数：确定该报备数据是否溢出
	if(typeid=="yz001"){
		f_getCPAYZReportCount("notalert");
	}else{
		f_getCPAFYZReportCount("notalert");
	}	
	
	// 检查上一年是否不存在的老客户
	f_sflkh();
	//document.getElementById("zdsfbzje").value = document.getElementById("standerPrice").value;
	 
	// 设置 已收业务费和 开具发票号 字段值的 修改时间
	f_setUpdateTime();
	
	//是否打包项目
	if(isSfdbxm()){
		return;
	}
	
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
	
}

// 根据委托单位名称 下拉 客户信息 
function setInfo(){
	var name = document.getElementById("wtdwmc").value;
	var url="${pageContext.request.contextPath}/common/content.do?method=getInfoByWtdwmc";
	var request = "&wtdwmc="+name;
	var resText = ajaxLoadPageSynch(url,request);
	
	var obj = eval('('+resText+')'); 
	
	//被审(验)单位名称
	/*不用自动填充
	var bsdwmc = document.getElementById("bsdwmc");
	if(bsdwmc.value==""){
		bsdwmc.value=obj[0].bsdwmc;
	}
	*/
	
	//客户出资类型
	var khczlx = document.getElementById("khczlx");
	if(khczlx.value==""){
		khczlx.value=obj[0].khczlx;
	}
	//营业执照号码或核准通知书号
	var yyzzhm = document.getElementById("yyzzhm");
	if(yyzzhm.value==""){
		yyzzhm.value=obj[0].yyzzhm;
	}
	//客户经济性质
	var khjjxj = document.getElementById("khjjxj");
	if(khjjxj.value==""){
		khjjxj.value=obj[0].khjjxj;
	}
	
	//被审(验)单位注册资本/开办资金
	var bsdwzczb = document.getElementById("bsdwzczb");
	if(bsdwzczb.value==""){
		bsdwzczb.value=obj[0].bsdwzczb;
	}
	
	//币种
	var zczbbz = document.getElementById("zczbbz");
	if(zczbbz.value==""){
		zczbbz.value=obj[0].zczbbz;
	}
	
	//客户行业类型
	var kmhylx = document.getElementById("kmhylx");
	if(kmhylx.value==""){
		kmhylx.value=obj[0].kmhylx;
	}
	
	//是否上市企业
	var sfssqy = document.getElementById("sfssqy");
	if(sfssqy.value==""){
		sfssqy.value=obj[0].sfssqy;
	}
	
	//注册地址
	var zcdz = document.getElementById("zcdz");
	if(zcdz.value==""){
		zcdz.value=obj[0].zcdz;
	}
	
	//负责人姓名
	var fzrmc = document.getElementById("fzrmc");
	if(fzrmc.value=""){
		fzrmc.value=obj[0].fzrmc;
	}
	
	//项目客户类型
	var xmkhlx = document.getElementById("xmkhlx");
	if(xmkhlx.value==""){
		xmkhlx.value=obj[0].xmkhlx;
	}
	
	//联系人姓名
	var lxrxm = document.getElementById("lxrxm");
	if(lxrxm.value==""){
		lxrxm.value=obj[0].lxrxm;
	}
	
	//联系人电话
	var lxrdh = document.getElementById("lxrdh");
	if(lxrdh.value==""){
		lxrdh.value=obj[0].lxrdh;
	}

	// 生成项目名称 
	var xmmc = document.getElementById("xmmc");
	if(xmmc.value==""){
		getProjectName();
	}
	
}

// 验证金额
function isDigit(s){ 
	 var patrn=/^-?\d+\.{0,}\d{0,}$/; 
	 var v = s.value;
	 if (!patrn.exec(v)) {
		  alert("请输入合法金额!");
		  document.getElementById("bsdwzczb").select();  
	 } 
}


// 禁用 退格健
document.onkeydown = function(){ 
  var objtBack = document.activeElement;
  if(objtBack.id=="bgrq" || objtBack.id=="qyrq" || objtBack.id=="sfrq" || objtBack.id=="jzrq"){
	  if (event.keyCode==8){
	   event.returnValue=false; 
	  }
  }
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

// 验证数字
function f_number(t){
	t.value = t.value.replace(/[^\d]/g,'');
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
	f_checkSaveState();
	
	if(ysywf!=""){
		if(getChargeStandard()=="N"){
			return;
		}
		var moneys = JSON.parse(getChargeStandard());
		
		document.getElementById("discountBySeven").value = moneys.discount;//已打折
		document.getElementById("zdsfbzje").value = moneys.standardPrice;//未打折
		
		var sfbz = moneys.discount;//最低价
		var jzj = moneys.standardPrice;//未打折//基准 价
		
		alert('发改委、财政厅收费的基准价为：'+(jzj*1).toFixed(2)+'元，最低价为：'+(sfbz*1).toFixed(2)+'元。');
	}else{
		alert("请先填写业务约定书收费金额！");
		setTab('search','nry'); 
		document.getElementById("ysywf").select();
	}
}

// 计费方式
var sfbzObj = document.getElementById("sfbz");
if(sfbzObj.value!=""){
	f_setsfbz(sfbzObj);
}
// 加载：需要提交审核情况
var isauditProperyObj = document.getElementById("isauditPropery");

f_setqksmTbody(isauditProperyObj);


// 计费方式
function f_setsfbz(t){
	if(!t){
		t = document.getElementById("sfbz");
	}
	var typeid = document.getElementById("typeid").value;
	if(f_isSqsh()){
		if(t.value == "计时收费"){
			document.getElementById("jssfTbody").style.display = "";
		}else if(t.value == "计件收费"){
			document.getElementById("jssfTbody").style.display = "none";
		}else{
			document.getElementById("jssfTbody").style.display = "none";
		}
		
		var bbtime = "${ct.bbtime}";
		if(bbtime==""){
			document.getElementById("standard").value = "";
			document.getElementById("isauditPropery").checked = false;
		}
	}
} 


// 情况说明设置
function f_setqksmTbody(t){
	if(t.checked){
		t.value="是";
	}else{
		t.value="否";
	}
	
	if(t.checked || t.value=="是"){
		document.getElementById("qksmTbody").style.display = "";
	}else{
		document.getElementById("qksmTbody").style.display = "none";
	}
}

// 计算总人数
function f_countPeopleTotal(){
	var countPeoples = document.getElementsByName("countPeople");
	var totalTemp = 0;
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
	var totalTemp = 0;
	for(var i=0;i<countHours.length;i++ ){
		if(countHours[i].value!=""){
			totalTemp = f_addNum(totalTemp*1,countHours[i].value*1);
		}
	}
	totalTemp = totalTemp.toFixed(2);
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
	totalTemp = totalTemp.toFixed(2);
	document.getElementById("countMoneyTotal").value = totalTemp;
	if(totalTemp*1<0){
		document.getElementById("countMoneyTotal").style.color = "red";
	}else{
		document.getElementById("countMoneyTotal").style.color = "black";
	}
}

// 加载总金额
var bbbh = "${ct.bbbh}"
if(bbbh!=""){
	f_countPeopleTotal();
	f_countHourTotal();
	f_countMoneyTotal();
}

// 空转零
function nullToZero(value){
	if(value=="" || value=="null" || value==null){
		return 0;
	}
	return value;
}


// 计算 该注师 参加的报备份数
function f_getCPAReportCount(){
	var typeid = "${typeid}";
	if(typeid == "yz001"){
		f_getCPAYZReportCount();
	}else{
		f_getCPAFYZReportCount();
	}
	

}

// 计算 该注师 参加的验资报备份数
function f_getCPAYZReportCount(p){
	var officeCode = "${userSession.userMap.loginid}";
	url="${pageContext.request.contextPath}/common/content.do?method=getCPAYZReportCount";
	request = "&officeCode="+officeCode;
	var resText = ajaxLoadPageSynch(url,request);
	if(resText == "N"){
		if(p=="alert"){
			//alert("贵所报备的报告数量异常，请与注协联系（020-83063583、83063578）！");
			alert("贵所今年验资报备的报告数量已达到当年最高报备份数，不能直接报备完成，要继续报备请申请审核！");
		}
		document.getElementById("isoverflow").value="溢出";
		return "N";
	}
	document.getElementById("isoverflow").value="非溢出";
	return "Y";
}

// 计算 该注师 参加的非验资报备份数
function f_getCPAFYZReportCount(p){
	var officeCode = "${userSession.userMap.loginid}";
	var url="${pageContext.request.contextPath}/common/content.do?method=getCPAFYZReportCount";
	var request = "&officeCode="+officeCode;
	var resText = ajaxLoadPageSynch(url,request);
	if(resText == "N"){
		if(p=="alert"){
			// alert("贵所报备的报告数量异常，请与注协联系（020-83063583、83063578）！");
			alert("贵所今年非验资报备的报告数量已达到当年最高报备份数，不能直接报备完成，要继续报备请申请审核！");
		}
		document.getElementById("isoverflow").value="溢出";
		return "N";
	}
	document.getElementById("isoverflow").value="非溢出";
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
	//广州、东莞、珠海、佛山、江门、中山
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
			alert("业务约定书收费金额必须与计时总金额合计一致！");
			setTab('search','nry') ;
			document.getElementById("ysywf").select();
			return false;
		}
	}
	return true;
}


	
/* 
 点击“申请审核”时只检查：
（1）客户信息中的必填项
（2）应收业务费
（3）销售收入、总资产/验资总金额
*/

function f_cancelInputRequired(){
	
	$.firstUnPassElemnt = null;
	$.hasUnPass = false;
	
	var form_obj = document.all; 
	//form的值
	var flag2 = true;
	for (i=0;i<form_obj.length ;i++ ) {
		var obj=form_obj[i];
		if ((obj.tagName=="INPUT" && obj.type=="text") || obj.tagName=="TEXTAREA") {
			
			if(obj.id=="wtdwmc" || obj.id=="bsdwmc" || obj.id=="khczlx" || obj.id=="yyzzhm" || obj.id=="bsdwzczb" || obj.id=="khjjxj"
			    || obj.id=="zczbbz" || obj.id=="kmhylx" || obj.id=="sfssqy" || obj.id=="xmkhlx" || obj.id=="ysywf" || obj.id=="sjlx"
			    || obj.id=="ywarea2" || obj.id=="yzhl" || obj.id=="yzbz" || obj.id=="ywareaother"){
				if(!$("#"+obj.id).valid()){
					if(document.getElementById(obj.id)){
						document.getElementById(obj.id).select();
					}
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
					//return false;
					flag2 = false;
				};
			}
		}
	}
	return flag2;
}

// 计时收费规则
function f_checkJSSF(){
	var countPeopleObj = document.getElementsByName("countPeople");
	var countHourObj = document.getElementsByName("countHour");
	var countMoneyObj = document.getElementsByName("countMoney");
	
	var isOK = "N";
	for(var i=0;i<countPeopleObj.length;i++){
		if(countPeopleObj[i].value=="" && countHourObj[i].value=="" && countMoneyObj[i].value==""){
			isOK = "Y";
		}else if(countPeopleObj[i].value!="" && countHourObj[i].value!="" && countMoneyObj[i].value!=""){
			isOK = "Y";
		}else{
			isOK = "N";
			if(countPeopleObj[i].value==""){
				setTab('search','nry') ;
				countPeopleObj[i].focus();
				alert("人数不能为空！");
				return false;
			}
			if(countHourObj[i].value==""){
				setTab('search','nry') ;
				countHourObj[i].focus();
				alert("总工时不能为空！");
				return false;				
			}
			if(countMoneyObj[i].value==""){
				setTab('search','nry') ;
				countMoneyObj[i].focus();
				alert("总金额不能为空！");
				return false;				
			}
		}
	}
	if(isOK=="Y"){
		return true;
	}else{
		return false;
	}
}  


// 根据 guid 查看报备状态
function f_getStateByGuid(guid){
	var url="${pageContext.request.contextPath}/common/content.do?method=getStateByGuid";
	var request = "&ctguid="+guid;
	var resText = ajaxLoadPageSynch(url,request);
	return resText; 
}


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
		 		var moneyOrCount = 0;
		 		
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
 					moneyOrCount = 0;
 					// 子数组对象
	 				var standardENArrSon = standardENArr[m].split("+");
 					// 临时对象
					var tempObj = "";
	 				for(var n=0;n<standardENArrSon.length;n++){
	 					var typeid = "${typeid}";
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

// 如果审计或者清算审计 最后一年的数据不能为空
function f_checkSjLastYearMoney(){
	var sjns = document.getElementById("sjns").value;
	var year = f_calcYear();
	
	var zczeMoney = 0;
	if(document.getElementById("zcze"+year)){
		zczeMoney = document.getElementById("zcze"+year).value*1;
	}
	
	var xssrMoney = 0;
	if(document.getElementById("xssr"+year)){
		xssrMoney = document.getElementById("xssr"+year).value*1;
	}
	
	var yysrMoney = 0;
	if(document.getElementById("yysr"+year)){
		yysrMoney = document.getElementById("yysr"+year).value*1;
	}
	
	var zxsjjeMoney = 0;
	if(document.getElementById("zxsjje"+year)){
		zxsjjeMoney = document.getElementById("zxsjje"+year).value*1;
	}
	
	var cyryCount = 0;
	if(document.getElementById("cyry"+year)){
		cyryCount = document.getElementById("cyry"+year).value*1;
	}
	
	var typeId = "${typeid}";
	if(typeId=="sj001"){
		var sjlx = document.getElementById("sjlx").value;
		if(sjlx==""){
			document.getElementById("sjlx").value = "专项审计";
		}
		if(sjlx=="专项审计"){
			if(zxsjjeMoney*1<=0){
				setTab('search','nre');
				document.getElementById("zxsjje"+year).select();	
				alert("第"+sjns+"的专项审计金额必须大于0！");
				return false;
			}
		}else{
			if(zczeMoney*1+xssrMoney*1+yysrMoney*1<=0){
				setTab('search','nre');
				document.getElementById("zcze"+year).select();	
				alert("第"+sjns+"的资产总额、售收入、营业收入加总和必须大于0！");
				return false;
			}
		}
			if(cyryCount<=0){
				setTab('search','nre');
				document.getElementById("cyry"+year).select();	
				alert("第"+sjns+"的从业人员必须大于0！");
				return false;
			}
	}else if(typeId=="qssh001"){
		if(zczeMoney*1+xssrMoney*1<=0){
			setTab('search','nre');
			document.getElementById("zcze"+year).select();	
			alert("第"+sjns+"的资产总额、销售收入加总和必须大于0！");
			return false;
		}
		if(cyryCount<=0){
			setTab('search','nre');
			document.getElementById("cyry"+year).select();	
			alert("第"+sjns+"的从业人员必须大于0！");
			return false;
		}
	}
	return true;
	
}

// 检查当前的报备状态是否与数据库中的最新报备状态一致
function f_checkSaveState(){
	var beforeState = "${ct.bbstate}";
	beforeState = f_convertState(beforeState);
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

// 状态转换
function f_convertState(state){
	var chState = ["暂停","暂存","申请审核","初审通过","审核未通过","审核通过","报备完成","待审申请审核","待审报备完成"];
	var enState = ["zanting","zancun","sqsh","cstg","shwtg","shtg","wanch","dssqsh","dsbbwc"];
	for(var i=0;i<chState.length;i++){
		if(state==chState[i]){
			return enState[i];
		}
		if(state==enState[i]){
			return chState[i]; 
		}
	}
	return "无"+state;
}


/*
报备选审计，审计类型选年报审计，被审验单位一样，同一年的报备时间，事务所不一样时，
申请审核或报备完成时不给通过，提示“该企业本年度已出具年度审计报告。”
*/
function f_checkNbsjReport(){
	var bsdwmcObj = document.getElementById("bsdwmc");
	var rs = "N";
	if(bsdwmcObj){
		var bsdwmcValue = bsdwmcObj.value;
		bsdwmcValue = bsdwmcValue.replace(/ /g,"");
		var url="${pageContext.request.contextPath}/common/content.do?method=checkNbsjReport";
		var request = "&bsdwmcValue="+bsdwmcValue;
		rs = ajaxLoadPageSynch(url,request);
	}
	if(rs=="N"){
		return true;
	}else{
		return false;
	}
	
}

// 解决两个小数相加出现多位小数位的问题
function f_addNum(num1,num2){
	var sq1,sq2,m;
	try{sq1=num1.toString().split(".")[1].length;} catch(e){sq1=0;}
	try{sq2=num2.toString().split(".")[1].length;} catch(e){sq2=0;}
	
	m=Math.pow(10,Math.max(sq1,sq2));
	return ( num1 * m + num2 * m ) / m;
}

// 判断是否进行申请审核/或报备完成
function f_isSqsh(){
	var typeid = "${typeid}";
	//验资、审计、清算审计、分立审计、合并审计
	if(typeid=="yz001" || typeid=="sj001" || typeid=="qssh001" || 
			typeid=="flsj001" || typeid=="hbsj001"){
		return true;
	}else{
		return false;
	}
}

// 检查客户类型
function f_checkKhlx(){
	var v = getLkhYwf();
	
	//是否老客户
	var arr = v.split("|");
	if(arr[0]=="YES"){
		return true;
	}else if(arr[0]=="NO"){
		return false;
	}else{
		return;
	}
}
</script>
<script>
	$(function(){
		$("#other").click(function(){
			var state=$(this).attr('checked');
			if(state){
				
				$("#otherspan").css("display","block");
				$("#ywarea2").css("display","none");
				var v=$("#ywareaother").val();
				$("#ywarea").val(v);
				
			}else{
				$("#ywarea2").css("display","block");
				$("#otherspan").css("display","none");
				var v=$("#ywarea2").val();
				$("#ywarea").val(v);
			}
			
		});
	});
	
	$(function(){
		$("#ywareaother").keyup(function(){
			var v=$(this).val();
			$("#ywarea").val(v);
			$("#ywarea2").val($("#ywarea").val());
			
		});
	});
	
	var areaArr = ['乐山','自贡','成都','宜宾','巴中','泸州','凉山','资阳','绵阳','德阳','广安','内江','甘孜','广元','达州','南充','雅安','眉山','遂宁','阿坝','攀枝花'];
	$(function(){			
		var v=$("#ywarea").val();
		var flag = true;
		
		for(i=0;i<areaArr.length;i++){
			if(v==areaArr[i]){
				flag = false;
			}
		}
		if(flag){
			$("#other").attr("checked","checked");
			$("#otherspan").css("display","block");
			$("#ywarea2").css("display","none");
		}else{
			$("#ywarea2").css("display","block");
			$("#otherspan").css("display","none");
		}
		$("#ywarea2").val(v);
		$("#ywareaother").val(v);		
	});
	
	//报备内容不允许输入空格
	$(function(){
		
		$("input[type=text]").keyup(function(){
			var ev = getEvent();
			if(ev.keyCode==32){
				var v=$(this).val();
				var v2=v.replace(/[ ]/g,"");
				$(this).val(v2);
			}
		});
	});
	//兼容事件，获取widow event
 	function getEvent() {
 	    if (document.all) {
 	        return window.event; //for ie
 	    }
 	    func = getEvent.caller;
 	    while (func != null) {
 	        var arg0 = func.arguments[0];
 	        if (arg0) {
 	            if ((arg0.constructor == Event || arg0.constructor == MouseEvent) || (typeof (arg0) == "object" && arg0.preventDefault && arg0.stopPropagation)) {
 	                return arg0;
 	            }
 	        }
 	        func = func.caller;
 	    }
 	    return null;
 	}
	//禁止开具收款发票号码不能输入中文1
	$(function(){
		$("#kjskdfphd").keyup(function(){
			var v=$("#kjskdfphd").val();
			var v2=v.replace(/[\u4E00-\u9FA5]/g,"");
			$("#kjskdfphd").val(v2);
		});
		$("#kjskdfphd2").keyup(function(){
			var v=$("#kjskdfphd2").val();
			var v2=v.replace(/[\u4E00-\u9FA5]/g,"");
			$("#kjskdfphd2").val(v2);
		});
	});
	
	//是否打包项目
	function sfdb(obj){
		var o = obj.value;
		if(o=="是"){
			document.getElementById("dbxm1").style.display = "";
			document.getElementById("dbxm2").style.display = "";
		}else if(o=="否"){
			document.getElementById("dbxmmc").value="";
			document.getElementById("dbxm1").style.display = "none";
			document.getElementById("dbxm2").style.display = "none";
		}
	}
	
	//检查是否打包，项目名称必填
	function isSfdbxm(){
		var sfdbxm = document.getElementById("sfdbxm").value;
		var dbxmmc = document.getElementById("dbxmmc").value;
		if(sfdbxm=='是' && dbxmmc==''){
			alert("请填写打包项目名称！");
			setTab('search','nry') ;
			document.getElementById("dbxmmc").select();
			return true;
		}
		return false;
	}
	
	//检查当审计类型为年报审计时。假如数据库里有被审计单位名称相同和报表年度相同的，就要弹出提示：‘该份报告已经在别家事务所出具了。’单单提示而已。
	function checkBbIsExist(){
		var typeid = "${typeid}";
		if(typeid=='sj001'){
			var $sjlx = $("#sjlx").val();
			var $bsdwmc = $("#bsdwmc").val();
			var $bgnd = $("#bgnd").val();
			if($sjlx=="年报审计" && $bsdwmc!="" && $bgnd!=""){
				url="${pageContext.request.contextPath}/common/content.do?method=checkBbIsExist";
				request = "&sjlx="+$sjlx+"&bsdwmc="+$bsdwmc+"&bgnd="+$bgnd;
				var resText = ajaxLoadPageSynch(url,request);
				if(resText=='1'){
					alert("该份报告已经在别家事务所出具了。");
				}
			}
		}
	}
</script>
</html>