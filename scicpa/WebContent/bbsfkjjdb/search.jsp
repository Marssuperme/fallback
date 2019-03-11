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
<input type="hidden" id="stguid" name="stguid" value="${st.guid}">
<input type="hidden" id="typeid" name="typeid" value="${typeid}">
 
<table width="98%" height="5%" border="0" cellspacing="0" cellpadding="0">
	<tr align="center">
		<td width="70%" align="center">
		 	<center class="formTitle">
				司&nbsp;&nbsp;法&nbsp;&nbsp;会&nbsp;&nbsp;计&nbsp;&nbsp;鉴&nbsp;&nbsp;定
			</center>
		</td>
	</tr>
</table>

<div id="bbnum" style="text-align: center;">
		报备编号：<input style="background-color: white;border: 0px" value="${ct.bbbh}"" id="bbbh" name="bbbh" readonly="readonly">
</div><br>

<DIV class=block id=search>

<H3 class=tabs id=searchtabs>
	<A class="tab curtab" id="dbswszltab" href="javascript:setTab('search','dbswszl')">报备事务所资料</A> 
	<A class="tab" id="nrytab" href="javascript:setTab('search','nry')">报备内容一</A>
	<A class="tab" id="nretab" href="javascript:setTab('search','nre')">报备内容二</A>
	<div style="margin-left: 78%;margin-top: 1%"> 
		<span id="fcancle">
			   <input type="button"
					name="bcb" id="bcb" value="作  废"
					onclick="return f_cancel();"> 
		</span>
		<span id="fback">
				<input id="fh" type="button" name="next"
					value="返  回" icon="icon-back" class="flyBT" onclick="goback();">
		</span>
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
			value="${clt.address}"></td>
	</tr>
	 
	
	<tr>
		<td class="data_tb_alignright" width="20%" height="18">联系人&nbsp;</td>
		<td class="data_tb_content" width="30%" height="18"><input
			name="person" type="text" id="person" size="25"
			value="${clt.person }"></td>
		<td class="data_tb_alignright" height="18">联系电话&nbsp;</td>
		<td class="data_tb_content" height="18">
			<input name="phone" type="text" id="phone" class="phone" size="25"  value = "${clt.phone }">
		</td>
	</tr>
	
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">传&nbsp;&nbsp;&nbsp;&nbsp;真&nbsp;</td>
		<td class="data_tb_content" width="30%" height="18"><input
			name="faxes" type="text" id="faxes" size="25"
			value="${clt.faxes }"></td>
		<td class="data_tb_alignright" height="18">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;编&nbsp;</td>
		<td class="data_tb_content" height="18">
			<input name="post" type="text" id="post"  size="25"  value = "${clt.post }" class="required zipcode">
		</td>
	</tr>
	
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">地&nbsp;&nbsp;址&nbsp; 
		<td class="data_tb_content" height="18" colspan="3">
			<input name="address" type="text" id="address"  size="85"  value = "${clt.address }">
		</td>
	</tr>
	
	 <tr>
		<td class="data_tb_alignright" width="20%" height="18">E-Mial&nbsp;</td>
		<td class="data_tb_content" width="30%" height="18"><input
			name="email" type="text" id="email" size="25"
			value="${clt.email }" class="required email"></td>
		<td class="data_tb_alignright" height="18">网&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址&nbsp;</td>
		<td class="data_tb_content" height="18">
			<input name="url" type="text" id="url"  size="25"  value = "${clt.url }" class="required url">
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
    <td class="data_tb_content" width="30%"><input id="fcbgfs" value="${ct.fcbgfs }" size="20" name="fcbgfs" class="digits"></td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%">签名注师一&nbsp;</td>
    <td class="data_tb_content" width="30%">
		<input id="qmzs1" value="${ct.qmzs1 }" size="20" name="qmzs1">
	</td>
    <td class="data_tb_alignright" width="20%">签名注师二&nbsp;</td>
    <td class="data_tb_content" width="30%">
		<input id="qmzs2" value="${ct.qmzs2 }" size="20" name="qmzs2">
	</td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%">签名注师三</td>
    <td class="data_tb_content" width="30%">
		<input id="qmzs3" value="${ct.qmzs3 }" size="20" name="qmzs3">
	</td>
    <td class="data_tb_alignright" width="20%">签名注师四</td>
    <td class="data_tb_content" width="30%">
		<input id="qmzs4" value="${ct.qmzs4 }" size="20" name="qmzs4">
	</td>
  </tr>
  <tr>
    <td class="data_tb_alignright" width="20%">签名注师五&nbsp;</td>
    <td class="data_tb_content" width="30%">
		<input id="qmzs5" value="${ct.qmzs5 }" size="20" name="qmzs5">
	</td>
    <td class="data_tb_alignright" width="20%">签名注师六&nbsp;</td>
    <td class="data_tb_content" width="30%">
		<input id="qmzs6" value="${ct.qmzs6}" size="20" name="qmzs6">
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
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=20
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
	    <td width="123" height="53" class="data_tb_alignright">鉴定结果<font color="#FF0000">&nbsp;[*]</font></td>
	    <td width="577" height="53" colspan="3" align="left" >
	    	<textarea title="鉴定结果" id="jdjg" name="jdjg" style="width: 450px;height: 50px;" class="required">${st.jdjg }</textarea>
	    </td>
	  </tr>
</table>

</div>
</DIV>  

<div id="divBlock" style="position:absolute;width:100%;height:100%; top:expression(this.offsetParent.scrollTop); z-index:1; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;">
</div>
<div id="tzf" style="position:absolute;width:80%;height:20%; z-index:2;left:expression((document.body.clientWidth-550)/2);top:expression(this.offsetParent.scrollTop + 130); border:1px solid #6595d6; padding:10px; background:#ffffff;text-align:center; display: none;">
   
   <ul style="list-style: none">
   	 <li>
   	 		    作&nbsp;&nbsp;废&nbsp;&nbsp;原&nbsp;&nbsp;因<font color="red">[*]</font>
   	 </li>
   	 <li>
    	<textarea title="作废原因" class="data_tb_content required" id="bbreason" name="bbreason" style="width: 80%;height: 100px;"> 
    	</textarea>
    </li>
    <li></li>
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
 // 只读效果 
	$("input").each(function(index,obj){
		obj.readOnly = true ;
		obj.className = "before";
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
 	document.getElementById("bbreason").value="";
}

// 返回
function goback(){	
	document.thisForm.action="${pageContext.request.contextPath}/common/sfkjjdb.do?method=index&typeid=sfkjjd001";
	thisForm.submit();
}



// 取消
function f_qx(){	
	 document.getElementById("divBlock").style.display="none";
	 document.getElementById("tzf").style.display = "none";
	 document.getElementById("bbreason").value="";
}


// 确定
function f_sure(){
	var ctguid = document.getElementById("ctguid").value;
	var bbreason = document.getElementById("bbreason").value;
	if(bbreason=="" || bbreason==null){
		alert("作废原因不能为空!");
	}else{
		if(confirm("您确定要作废吗?")){
			var oBao = new ActiveXObject("Microsoft.XMLHTTP");
			var url="${pageContext.request.contextPath}/common/content.do?method=invalid&ctguid="+ctguid+"&bbreason="+bbreason;
			oBao.open("POST",url,false);
			oBao.send();
			
			var resText = oBao.responseText;  
			if(resText=="cannot"){
				alert("报备时间超过一个月，不能进行作废了 !");
			}else{
				if(resText=="true"){
					alert("作废成功 !");
					document.thisForm.action="${pageContext.request.contextPath}/common/sfkjjdb.do?method=index&typeid=sfkjjd001";
					thisForm.submit();
				}else{
					alert("作废失败 !");
					document.thisForm.action="${pageContext.request.contextPath}/common/sfkjjdb.do?method=index&typeid=sfkjjd001";
					thisForm.submit();
				}
			}
			
		}
		 document.getElementById("divBlock").style.display="none";
		 document.getElementById("tzf").style.display = "none";
		 document.getElementById("bbreason").value="";
	}
}

</script>

</html>