<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>

<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/JS/uploadFile.js?v=${modifyDate}"  ></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/main.css" />
<style type="text/css">
	
	body {
		padding-left: 10px ;
		padding-right: 10px ;
		font-size: 12px ;
	}
	.left_tb{
	position:relative; 
	text-align:left;
	font-size:15px;
	font-weight:bold;
	}
	.before {
	border: 0px!important;
	background-color: white!important;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body oncontextmenu="return false" onmousemove="event.returnValue=false;">
<br/>
<input readonly="readonly" type="button" id=print name=print value="打 印" icon='icon-print' onclick="window.print();" >&nbsp;&nbsp;&nbsp;
<div id="divBlock" style="position:absolute;width:100%;height:100%; z-index:0; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;"></div>
<form action="" method="post" name="thisform" id="thisform">
<div>
<input readonly="readonly" name="Guid" id="Guid"  value="${map.Guid}" type="hidden">
</div>
<div class="tabcontent" id="dbswszl" style="width:100%; height:100%">
<div style="text-align: center;margin-top: 15px; margin-bottom:15px;"><font style="font-size:20px">会计师事务所社会责任履行情况统计表</font></div>
<table style="WIDTH: 100%; border: 0px;" class="data_tb" >
	<tr>
		<td class="data_tb_alignright" nowrap="nowrap">填报人<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="UserName" id="UserName" value="${map.UserName}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">联系手机<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content"> 
			<input readonly="readonly" maxlength="25" name="MobilePhone" type="text" id="MobilePhone"  value = "${map.MobilePhone}" >
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">事务所名称<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="OfficeName" id="OfficeName" style="width:300px"  value="${map.OfficeName }">
		</td>
	</tr>
    <tr>
    <td class="left_tb" colspan="6">一、总体数据</td>
    </tr>
    <tr>
    <td class="left_tb" colspan="6">1.业务收入(万元)及出具报告(份)</td>
    </tr>
   <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="BGFS" id="BGFS" value="${map.BGFS}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="YWSR" id="YWSR"  value="${map.YWSR}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content"> 
			<input readonly="readonly" name="Memo_YWSR" style="width:100%" type="text" id="Memo_YWSR"  value = "${map.Memo_YWSR}" >
		</td> 
        </tr> 
    <tr>
    <td class="left_tb" colspan="6">2.服务客户(客户数量、审验资金或资产规模)</td>
    </tr>
     <tr>
    <td class="data_tb_alignright" nowrap="nowrap">行政事业单位数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="KHSL_XZ" id="KHSL_XZ"  value="${map.KHSL_XZ}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="SYZJ_XZ" id="SYZJ_XZ"  value="${map.SYZJ_XZ}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content"> 
			<input readonly="readonly" name="Memo_XZ" style="width:100%" type="text" id="Memo_XZ"  value = "${map.Memo_XZ}" >
		</td>
    </tr>
    
     <tr>
    <td class="data_tb_alignright" nowrap="nowrap">国有企业数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="KHSL_GY" id="KHSL_GY"  value="${map.KHSL_GY }">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="SYZJ_GY" id="SYZJ_GY"  value="${map.SYZJ_GY}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content"> 
			<input readonly="readonly" name="Memo_GY" style="width:100%" type="text" id="Memo_GY"  value = "${map.Memo_GY}" >
		</td>
    </tr>
    
     <tr>
    <td class="data_tb_alignright" nowrap="nowrap">民营企业数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="KHSL_MY" id="KHSL_MY"  value="${map.KHSL_MY }">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="SYZJ_MY" id="SYZJ_MY"  value="${map.SYZJ_MY}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content"> 
			<input readonly="readonly" name="Memo_MY" style="width:100%" type="text" id="Memo_MY"  value = "${map.Memo_MY}" >
		</td>
    </tr>
    
     <tr>
    <td class="data_tb_alignright" nowrap="nowrap">社会组织数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="KHSL_SH" id="KHSL_SH"  value="${map.KHSL_SH }">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="SYZJ_SH" id="SYZJ_SH"  value="${map.SYZJ_SH}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content"> 
			<input readonly="readonly" name="Memo_SH" style="width:100%" type="text" id="Memo_SH"  value = "${map.Memo_SH}" >
		</td>
    </tr>
    
     <tr>
    <td class="data_tb_alignright" nowrap="nowrap">其他数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="KHSL_QT" id="KHSL_QT"  value="${map.KHSL_QT }">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="SYZJ_QT" id="SYZJ_QT"  value="${map.SYZJ_QT}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content"> 
			<input readonly="readonly" name="Memo_QT" style="width:100%" type="text" id="Memo_QT"  value = "${map.Memo_QT}" >
		</td>
    </tr>
    
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">小计<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="FWKHXJ" id="FWKHXJ"  value="${map.FWKHXJ}" >
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">小计<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="FWKHJE" id="FWKHJE" value="${map.FWKHJE}" >
		</td>
    </tr>
    
    <tr>
    <td class="left_tb" colspan="6">3.年纳税总额</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">年纳税总额涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="NNSZE" id="NNSZE"  value="${map.NNSZE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_NNSZE" id="Memo_NNSZE" style="width:100%"  type="text" value="${map.Memo_NNSZE}">
		</td>
    </tr>
    
    <tr>
    <td class="left_tb" colspan="6">4.员工情况</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">员工总数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="YGZS" id="YGZS"  value="${map.YGZS}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_YGZS" id="Memo_YGZS" style="width:100%"  type="text" value="${map.Memo_YGZS}">
		</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">新增岗位数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="XZGWSL" id="XZGWSL"  value="${map.XZGWSL}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_XZGW" id="Memo_XZGW" style="width:100%"  type="text" value="${map.Memo_XZGW}">
		</td>
    </tr>
    
     <tr>
    <td class="left_tb" colspan="6">5.注册会计师兼任社会职务情况</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap" colspan="2">兼任政府部门顾问及外聘专家(人次)数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="JRZWSL_ZF" id="JRZWSL_ZF"  value="${map.JRZWSL_ZF}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">具体职务名称<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="2">
			<input readonly="readonly" name="JRZWMC_ZF" id="JRZWMC_ZF"  type="text" value="${map.JRZWMC_ZF}">
		</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap" colspan="2">兼任高校导师、讲师、论文评阅及答辩专家(人次)数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="JRZWSL_GX" id="JRZWSL_GX"  value="${map.JRZWSL_GX}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">具体职务名称<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="2">
			<input readonly="readonly" name="JRZWMC_GX" id="JRZWMC_GX"  type="text" value="${map.JRZWMC_GX}">
		</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap" colspan="2">兼任社会组织职务(人次)数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="JRZWSL_SH" id="JRZWSL_SH"  value="${map.JRZWSL_SH}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">具体职务名称<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="2">
			<input readonly="readonly" name="JRZWMC_SH" id="JRZWMC_SH"  type="text" value="${map.JRZWMC_SH}">
		</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap" colspan="2">兼任各级各类评审专家(人次)数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="JRZWSL_PS" id="JRZWSL_PS"  value="${map.JRZWSL_PS}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">具体职务名称<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="2">
			<input readonly="readonly" name="JRZWMC_PS" id="JRZWMC_PS"  type="text" value="${map.JRZWMC_PS}">
		</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap" colspan="2">兼任其他社会职务(人次)数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="JRZWSL_QT" id="JRZWSL_QT"  value="${map.JRZWSL_QT}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">具体职务名称<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="2">
			<input readonly="readonly" name="JRZWMC_QT" id="JRZWMC_QT"  type="text" value="${map.JRZWMC_QT}">
		</td>
    </tr>
    
    <tr>
    <td class="left_tb" colspan="6">6.政府及社会对事务所和注师的评价和批示(次数)</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="PJPSSL" id="PJPSSL"  value="${map.PJPSSL}">
		</td>
		 <td class="data_tb_alignright" nowrap="nowrap">附件<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
		<div id="attachfileid_pjps" style="border: 1px red solid;"></div> 
	    <input readonly="readonly" name="ATT_PJPS"  id="ATT_PJPS" value="${map.ATT_PJPS}"  type="hidden"/>
		</td>
    </tr>
    <tr>
    		<td class="data_tb_alignright" nowrap="nowrap">具体情况说明<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="5">
			<input readonly="readonly" name="Memo_PJPS" id="Memo_PJPS" style="width:100%" type="text" value="${map.Memo_PJPS}">
		</td>
    </tr>
    
     <tr>
    <td class="left_tb" colspan="6">二、具体数据</td>
    </tr>
     <tr>
    <td class="left_tb" colspan="6">(一)经济方面</td>
    </tr>
    <tr>
     <tr>
    <td class="left_tb" colspan="6">1.参与地方基础设施建设项目情况</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="DFJSSL" id="DFJSSL"  value="${map.DFJSSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="DFJSJE" id="DFJSJE"  value="${map.DFJSJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">具体情况说明<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_DFJS" id="Memo_DFJS" style="width:100%"  type="text" value="${map.Memo_DFJS}">
		</td>
    </tr>
    
    <tr>
    <td class="left_tb" colspan="6">2.服务产业转型升级项目情况</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">企业高新技术认证项目数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="GXXMSL" id="GXXMSL"  value="${map.GXXMSL}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_GXXM" id="Memo_GXXM" style="width:100%"  type="text" value="${map.Memo_GXXM}">
		</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">863、973等科研项目数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="ZDKYSL" id="ZDKYSL"  value="${map.ZDKYSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="ZDKYJE" id="ZDKYJE"  value="${map.ZDKYJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">具体情况说明<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_ZDKY" id="Memo_ZDKY" style="width:100%"  type="text" value="${map.Memo_ZDKY}">
		</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">服务三农建设项目数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="SNJSSL" id="SNJSSL"  value="${map.SNJSSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="SNJSJE" id="SNJSJE"  value="${map.SNJSJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">附件(需提供照片)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
		<div id="attachfiled_snjs" style="border: 1px red solid;"></div> 
	      <input readonly="readonly" name="ATT_SNJS"  id="ATT_SNJS" value="${map.ATT_SNJS}"  type="hidden"/>
		</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">服务淘汰落后产能项目数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="TTXMSL" id="TTXMSL"  value="${map.TTXMSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="TTXMJE" id="TTXMJE"  value="${map.TTXMJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">附件(需提供照片)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<div id="attachfiled_ttxm" style="border: 1px red solid;"></div> 
	      <input readonly="readonly" name="ATT_TTXM"  id="ATT_TTXM" value="${map.ATT_TTXM}"  type="hidden"/>
		</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">产业转型升级等方面数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="CYZXSL" id="CYZXSL"  value="${map.CYZXSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="CYZXJE" id="CYZXJE"  value="${map.CYZXJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">具体情况说明<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_CYZX" id="Memo_CYZX" style="width:100%"  type="text" value="${map.Memo_CYZX}">
		</td>
    </tr>
    
    <tr>
    <td class="left_tb" colspan="6">3.服务资本、金融市场项目情况</td>
    </tr>
    <tr>
    <td class="left_tb" colspan="6">(1)帮助企业成功首发上市融资情况</td>
    </tr>
     <tr>
    <td class="data_tb_alignright" nowrap="nowrap">A股数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="AGSL" id="AGSL"  value="${map.AGSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="AGJE" id="AGJE"  value="${map.AGJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_AG" id="Memo_AG" style="width:100%"  type="text" value="${map.Memo_AG}">
		</td>
    </tr>
     <tr>
    <td class="data_tb_alignright" nowrap="nowrap">H股数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="HGSL" id="HGSL"  value="${map.HGSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="HGJE" id="HGJE"  value="${map.HGJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_HG" id="Memo_HG" style="width:100%"  type="text" value="${map.Memo_HG}">
		</td>
    </tr>
     <tr>
    <td class="data_tb_alignright" nowrap="nowrap">新三板数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="XSBSL" id="XSBSL"  value="${map.XSBSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="XSBJE" id="XSBJE"  value="${map.XSBJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_XSB" id="Memo_XSB" style="width:100%"  type="text" value="${map.Memo_XSB}">
		</td>
    </tr>
     <tr>
    <td class="data_tb_alignright" nowrap="nowrap">四板数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="SBSL" id="SBSL"  value="${map.SBSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="SBJE" id="SBJE"  value="${map.SBJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_SB" id="Memo_SB" style="width:100%"  type="text" value="${map.Memo_SB}">
		</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">小计<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="FWZBXJ" id="FWZBXJ"  value="${map.FWZBXJ}" readonly="readonly">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">小计<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="FWZBJE" id="FWZBJE" value="${map.FWZBJE}" readonly="readonly">
		</td>
    </tr>
    
    <tr>
    <td class="left_tb" colspan="6">(2)服务上市公司再融资、企业发债融资情况</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="SSRZSL" id="SSRZSL"  value="${map.SSRZSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="SSRZJE" id="SSRZJE"  value="${map.SSRZJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_SSRZ" id="Memo_SSRZ" style="width:100%"  type="text" value="${map.Memo_SSRZ}">
		</td>
    </tr>
    
    <tr>
    <td class="left_tb" colspan="6">(3)服务地方金融机构情况</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="DFJRSL" id="DFJRSL"  value="${map.DFJRSL}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_DFJR" id="Memo_DFJR" style="width:100%"  type="text" value="${map.Memo_DFJR}">
		</td>
    </tr> 
    
    <tr>
    <td class="left_tb" colspan="6">(4)服务资本、金融市场其他方面情况</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="FWQTSL" id="FWQTSL"  value="${map.FWQTSL}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="FWQTJE" id="FWQTJE"  value="${map.FWQTJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">具体情况说明<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_FWQT" id="Memo_FWQT" style="width:100%"  type="text" value="${map.Memo_FWQT}">
		</td>
    </tr> 

    <tr>
    <td class="left_tb" colspan="6">4.服务国有、民营企业项目情况</td>
    </tr>
    <tr>
    <td class="left_tb" colspan="6">(1)参与国有企业改制项目</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="GQGZSL" id="GQGZSL"  value="${map.GQGZSL}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="GQGZJE" id="GQGZJE"  value="${map.GQGZJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_GQGZ" id="Memo_GQGZ" style="width:100%"  type="text" value="${map.Memo_GQGZ}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">(2)帮助中小企业获取政府扶持项目</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="zxqfcSL" id="zxqfcSL"  value="${map.zxqfcSL}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="ZXQFCJE" id="ZXQFCJE"  value="${map.ZXQFCJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_ZXQFC" id="Memo_ZXQFC" style="width:100%"  type="text" value="${map.Memo_ZXQFC}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">(3)担任企业财务顾问、独立董事(人次)</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="CWGWSL" id="CWGWSL"  value="${map.CWGWSL}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_CWGW" id="Memo_CWGW" style="width:100%"  type="text" value="${map.Memo_CWGW}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">(4)为企业提供专业咨询(次)</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="ZYZXSL" id="ZYZXSL"  value="${map.ZYZXSL}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_ZYZX" id="Memo_ZYZX" style="width:100%"  type="text" value="${map.Memo_ZYZX}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">(5)为企业提供税收服务项目数</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="SSFWSL" id="SSFWSL"  value="${map.SSFWSL}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_SSFW" id="Memo_SSFW" style="width:100%"  type="text" value="${map.Memo_SSFW}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">(6)为企业节约税款金额</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="JYSKJE" id="JYSKJE"  value="${map.JYSKJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_JYSK" id="Memo_JYSK" style="width:100%"  type="text" value="${map.Memo_JYSK}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">(7)服务企业其他方面情况</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="QTFWSL" id="QTFWSL"  value="${map.QTFWSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="QTFWJE" id="QTFWJE"  value="${map.QTFWJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">具体情况说明<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" >
			<input readonly="readonly" name="Memo_QTFW" id="Memo_QTFW" style="width:100%"  type="text" value="${map.Memo_QTFW}">
		</td>
    </tr> 
    
    <tr>
    <td class="left_tb" colspan="6">5.服务对外经济</td>
    </tr>
    <tr>
    <td class="left_tb" colspan="6">(1)参与企业海外投资项目</td>
    </tr>
     <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="HWTZSL" id="HWTZSL"  value="${map.HWTZSL}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="HWTZJE" id="HWTZJE"  value="${map.HWTZJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_HWTZ" id="Memo_HWTZ" style="width:100%"  type="text" value="${map.Memo_HWTZ}">
		</td>
    </tr> 
    
    <tr>
    <td class="left_tb" colspan="6">(2)服务外资企业在川投资项目</td>
    </tr>
     <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="ZCTZSL" id="ZCTZSL"  value="${map.ZCTZSL}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="ZCTZJE" id="ZCTZJE"  value="${map.ZCTZJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_ZCTZ" id="Memo_ZCTZ" style="width:100%"  type="text" value="${map.Memo_ZCTZ}">
		</td>
    </tr>
     
    <tr>
    <td class="left_tb" colspan="6">(3)服务对外经济其他方面情况</td>
    </tr>
     <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="DWQTSL" id="DWQTSL"  value="${map.DWQTSL}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="DWQTJE" id="DWQTJE"  value="${map.DWQTJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">具体情况说明<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_DWQT" id="Memo_DWQT" style="width:100%"  type="text" value="${map.Memo_DWQT}">
		</td>
    </tr> 
    
    <tr>
    <td class="left_tb" colspan="6">6.培养会计专业人才</td>
    </tr>
    <tr>
    <td class="left_tb" colspan="6">(1)与几所高校建立实习基地</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="SXJDSL" id="SXJDSL"  value="${map.SXJDSL}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_SXJD" id="Memo_SXJD" style="width:100%"  type="text" value="${map.Memo_SXJD}">
		</td>
    </tr> 
    <tr>
    <td class="left_tb" colspan="6">(2)提供实习岗位数量</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="SXGWSL" id="SXGWSL"  value="${map.SXGWSL}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_SXGW" id="Memo_SXGW" style="width:100%"  type="text" value="${map.Memo_SXGW}">
		</td>
    </tr> 
    
    <tr>
    <td class="left_tb" colspan="6">(3)为企业提供财务培训(次)</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="QYPXCS" id="QYPXCS"  value="${map.QYPXCS}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_QYPXCS" id="Memo_QYPXCS" style="width:100%"  type="text" value="${map.Memo_QYPXCS}">
		</td>
    </tr> 
    
    <tr>
    <td class="left_tb" colspan="6">涉及人数(人次)</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="QYPXRS" id="QYPXRS"  value="${map.QYPXRS}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_QYPXRS" id="Memo_QYPXRS" style="width:100%"  type="text" value="${map.Memo_QYPXRS}">
		</td>
    </tr> 
    
    <tr>
    <td class="left_tb" colspan="6">(4)为行政事业单位提供财务培训(次)</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="XZPXCS" id="XZPXCS"  value="${map.XZPXCS}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_XZPXCS" id="Memo_XZPXCS" style="width:100%"  type="text" value="${map.Memo_XZPXCS}">
		</td>
    </tr> 
    <tr>
    <td class="left_tb" colspan="6">涉及人数(人次)</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="XZPXRS" id="XZPXRS"  value="${map.XZPXRS}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_XZPXRS" id="Memo_XZPXRS" style="width:100%"  type="text" value="${map.Memo_XZPXRS}">
		</td>
    </tr> 
    
     <tr>
    <td class="left_tb" colspan="6">(5)提供农村财务培训(次)</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="NCPXCS" id="NCPXCS"  value="${map.NCPXCS}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_NCPXCS" id="Memo_NCPXCS" style="width:100%"  type="text" value="${map.Memo_NCPXCS}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">涉及人数(人次)</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="NCPXRS" id="NCPXRS"  value="${map.NCPXRS}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_NCPXRS" id="Memo_NCPXRS" style="width:100%"  type="text" value="${map.Memo_NCPXRS}">
		</td>
    </tr> 
    
     <tr>
    <td class="left_tb" colspan="6">(6)培养会计专业人才其他方面</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="PYQTCS" id="PYQTCS"  value="${map.PYQTCS}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">具体情况说明<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_PYQT" id="Memo_PYQT" style="width:100%"  type="text" value="${map.Memo_PYQT}">
		</td>
    </tr> 
    
      <tr>
    <td class="left_tb" colspan="6">(二)政府购买服务</td>
    </tr>
      <tr>
    <td class="left_tb" colspan="6">1.参与工商企业信息公示项目情况</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="GSQYSL" id="GSQYSL"  value="${map.GSQYSL}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="GSQYJE" id="GSQYJE"  value="${map.GSQYJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_GSQY" id="Memo_GSQY" style="width:100%"  type="text" value="${map.Memo_GSQY}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">2.参加绩效评价项目情况</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="JXPJSL" id="JXPJSL"  value="${map.JXPJSL}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="JXPJJE" id="JXPJJE"  value="${map.JXPJJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_JXPJ" id="Memo_JXPJ" style="width:100%"  type="text" value="${map.Memo_JXPJ}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">3.为政府提供税收服务项目数</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="TGSSSL" id="TGSSSL"  value="${map.TGSSSL}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_TGSS" id="Memo_TGSS" style="width:100%"  type="text" value="${map.Memo_TGSS}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">为政府核增税款金额</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="HZSKJE" id="HZSKJE"  value="${map.HZSKJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_HZSK" id="Memo_HZSK" style="width:100%"  type="text" value="${map.Memo_HZSK}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">4.参与PPP项目情况</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="PPPSL" id="PPPSL"  value="${map.PPPSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="PPPJE" id="PPPJE"  value="${map.PPPJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_PPP" id="Memo_PPP" style="width:100%"  type="text" value="${map.Memo_PPP}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">5.参与国家审计部门审计事项情况</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="GJSJSL" id="GJSJSL"  value="${map.GJSJSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="GJSJJE" id="GJSJJE"  value="${map.GJSJJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_GJSJ" id="Memo_GJSJ" style="width:100%"  type="text" value="${map.Memo_GJSJ}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">6.参与政府部门公共决策(次)</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="ZFJCSL" id="ZFJCSL"  value="${map.ZFJCSL}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">具体情况说明<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_ZFJC" id="Memo_ZFJC" style="width:100%"  type="text" value="${map.Memo_ZFJC}">
		</td>
    </tr> 
    
     <tr>
    <td class="left_tb" colspan="6">7.参与项目立项论证、验收情况</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="LXLZSL" id="LXLZSL"  value="${map.LXLZSL}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_LXLZ" id="Memo_LXLZ" style="width:100%"  type="text" value="${map.Memo_LXLZ}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">为政府节省投资</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="JSTZJE" id="JSTZJE"  value="${map.JSTZJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_JSTZ" id="Memo_JSTZ" style="width:100%"  type="text" value="${map.Memo_JSTZ}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">8.参与政府开展的检查、审计业务(不含社保、公积金稽核)</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="JCSJSL" id="JCSJSL"  value="${map.JCSJSL}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_JCSJ" id="Memo_JCSJ" style="width:100%"  type="text" value="${map.Memo_JCSJ}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">检查、审计后调增金额</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="DZJE" id="DZJE"  value="${map.DZJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_DZJE" id="Memo_DZJE" style="width:100%"  type="text" value="${map.Memo_DZJE}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">检查、审计后调减金额</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="DJJE" id="DJJE"  value="${map.DJJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_DJJE" id="Memo_DJJE" style="width:100%"  type="text" value="${map.Memo_DJJE}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">9.参与政府购买服务其他方面情况</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="GMQTSL" id="GMQTSL"  value="${map.GMQTSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="GMQTJE" id="GMQTJE"  value="${map.GMQTJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">具体情况说明<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_GMQT" id="Memo_GMQT" style="width:100%"  type="text" value="${map.Memo_GMQT}">
		</td>
    </tr> 
    
     <tr>
    <td class="left_tb" colspan="6">(三)民生方面</td>
    </tr>
     <tr>
    <td class="left_tb" colspan="6">1.服务社会保障</td>
    </tr>
     <tr>
    <td class="left_tb" colspan="6">(1)参与社会保险稽核项目</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="SBJHSL" id="SBJHSL"  value="${map.SBJHSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="SBJHJE" id="SBJHJE"  value="${map.SBJHJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_SBJH" id="Memo_SBJH" style="width:100%"  type="text" value="${map.Memo_SBJH}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">(2)参与住房公积金稽核项目</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="GJJJHSL" id="GJJJHSL"  value="${map.GJJJHSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="GJJJHJE" id="GJJJHJE"  value="${map.GJJJHJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_GJJJH" id="Memo_GJJJH" style="width:100%"  type="text" value="${map.Memo_GJJJH}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">2.服务民生治理</td>
    </tr>
     <tr>
    <td class="left_tb" colspan="6">(1)医疗卫生项目</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="YLWSSL" id="YLWSSL"  value="${map.YLWSSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="YLWSJE" id="YLWSJE"  value="${map.YLWSJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_YLWS" id="Memo_YLWS" style="width:100%"  type="text" value="${map.Memo_YLWS}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">(2)学校教育项目</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="XXJYSL" id="XXJYSL"  value="${map.XXJYSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="XXJYJE" id="XXJYJE"  value="${map.XXJYJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_XXJY" id="Memo_XXJY" style="width:100%"  type="text" value="${map.Memo_XXJY}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">(3)文化设施项目</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="WHSSSL" id="WHSSSL"  value="${map.WHSSSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="WHSSJE" id="WHSSJE"  value="${map.WHSSJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_WHSS" id="Memo_WHSS" style="width:100%"  type="text" value="${map.Memo_WHSS}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">(4)社区治理项目</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="SQZLSL" id="SQZLSL"  value="${map.SQZLSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="SQZLJE" id="SQZLJE"  value="${map.SQZLJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_SQZL" id="Memo_SQZL" style="width:100%"  type="text" value="${map.Memo_SQZL}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">(5)食品安全项目</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="SPAQSL" id="SPAQSL"  value="${map.SPAQSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="SPAQJE" id="SPAQJE"  value="${map.SPAQJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_SPAQ" id="Memo_SPAQ" style="width:100%"  type="text" value="${map.Memo_SPAQ}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">3.服务法治建设</td>
    </tr>
     <tr>
    <td class="left_tb" colspan="6">(1)是否具备司法鉴定资格(是/否)</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">是否具备资格<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="5">
			<input readonly="readonly" name="SFJDZG" id="SFJDZG"  value="${map.SFJDZG}">
		</td>
    </tr> 
     <tr>
    <td class="left_tb" colspan="6">(2)服务司法案件</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="SFAJSL" id="SFAJSL"  value="${map.SFAJSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="SFAJJE" id="SFAJJE"  value="${map.SFAJJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_SFAJ" id="Memo_SFAJ" style="width:100%"  type="text" value="${map.Memo_SFAJ}">
		</td>
    </tr> 
    <tr>
    <td class="left_tb" colspan="6">(3)是否具备破产管理人资格(是/否)</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">是否具备资格<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="5">
			<input readonly="readonly" name="PCGLRZG" id="PCGLRZG"  value="${map.PCGLRZG}">
		</td>
    </tr>
    <tr>
    <td class="left_tb" colspan="6">(4)服务企业破产案件</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="PCAJSL" id="PCAJSL"  value="${map.PCAJSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="PCAJJE" id="PCAJJE"  value="${map.PCAJJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_PCAJ" id="Memo_PCAJ" style="width:100%"  type="text" value="${map.Memo_PCAJ}">
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">4.服务民生其他方面项目情况</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="STQTSL" id="STQTSL"  value="${map.STQTSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="MSQTJE" id="MSQTJE"  value="${map.MSQTJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">具体情况说明<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_MSQT" id="Memo_MSQT" style="width:100%"  type="text" value="${map.Memo_MSQT}">
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">(四)生态方面</td>
    </tr>
    <tr>
    <td class="left_tb" colspan="6">1.服务节能减排项目</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="JNJPSL" id="JNJPSL"  value="${map.JNJPSL}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_JNJP" id="Memo_JNJP" style="width:100%"  type="text" value="${map.Memo_JNJP}">
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">2.参与排污、垃圾处理等项目</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="PWCLSL" id="PWCLSL"  value="${map.PWCLSL}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_PWCL" id="Memo_PWCL" style="width:100%"  type="text" value="${map.Memo_PWCL}">
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">3.本单位参与地方环保活动</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="DFHBSL" id="DFHBSL"  value="${map.DFHBSL}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_DFHB" id="Memo_DFHB" style="width:100%"  type="text" value="${map.Memo_DFHB}">
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">4.服务生态其他方面项目情况</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="STQTSL" id="STQTSL"  value="${map.STQTSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="STQTJE" id="STQTJE"  value="${map.STQTJE}">
		</td>
		<td class="data_tb_alignright" nowrap="nowrap">具体情况说明<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_STQT" id="Memo_STQT" style="width:100%"  type="text" value="${map.Memo_STQT}">
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">(五)诚信建设</td>
    </tr>
    <tr>
    <td class="left_tb" colspan="6">1.是否举办诚信宣誓(是/否)</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">是否举办<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="CXXS" id="CXXS"  value="${map.CXXS}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">附件(需提供照片)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
	<div id="attachfileid_cxxs" style="border: 1px red solid;"></div> 
	<input readonly="readonly" name="Att_CXXS"  id="Att_CXXS" value="${map.Att_CXXS}"   type="hidden"/>
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">2.诚信教育(次)</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="CXJYSL" id="CXJYSL"  value="${map.CXJYSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">附件(需提供照片)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<div id="attachfileid_cxjy" style="border: 1px red solid;"></div> 
	<input readonly="readonly" name="Att_CXJY"  id="Att_CXJY" value="${map.Att_CXJY}"  type="hidden"/>
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">3.诚信建设其他方面情况</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="CXQTSL" id="CXQTSL"  value="${map.CXQTSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="CXQTJE" id="CXQTJE"  value="${map.CXQTJE}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">具体情况说明<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_CXQT" id="Memo_CXQT" style="width:100%"  value="${map.Memo_CXQT}">
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">(六)党建工作</td>
    </tr>
    <tr>
    <td class="left_tb" colspan="2">1.年度集中性教育、主题年教育</td>
    <td class="data_tb_alignright" nowrap="nowrap" colspan="3">附件(需提供照片)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<div id="attachfileid_ztnjy" style="border: 1px red solid;"></div> 
	<input readonly="readonly" name="Att_ZTNJY"  id="Att_ZTNJY" value="${map.Att_ZTNJY}"  type="hidden"/>
		</td>
    </tr>
    <tr>
    <td class="left_tb" colspan="6">2.党团活动(次)</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="DTHDSL" id="DTHDSL"  value="${map.DTHDSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">附件(需提供照片)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
				<div id="attachfileid_dthd" style="border: 1px red solid;"></div> 
	<input readonly="readonly" name="Att_DTHD"  id="Att_DTHD" value="${map.Att_DTHD}"  type="hidden"/>
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">3.各级人大代表(人)</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="RDDBSL" id="RDDBSL"  value="${map.RDDBSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_RDDB" id="Memo_RDDB" style="width:100%"  value="${map.Memo_RDDB}">
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">4.各级政协代表(人)</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="ZXDBSL" id="ZXDBSL"  value="${map.ZXDBSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_ZXDB" id="Memo_ZXDB" style="width:100%"  value="${map.Memo_ZXDB}">
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">5.代表提案(件)</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="DBTASL" id="DBTASL"  value="${map.DBTASL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">上传附件<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<div id="attachfileid_dbta" style="border: 1px red solid;"></div> 
	        <input readonly="readonly" name="Att_DBTA"  id="Att_DBTA" value="${map.Att_DBTA}"  type="hidden"/>
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">(七)社会公益</td>
    </tr>
    <tr>
    <td class="left_tb" colspan="6">1.自然灾害</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="ZRZHSL" id="ZRZHSL"  value="${map.ZRZHSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="ZRZHJE" id="ZRZHJE"  value="${map.ZRZHJE}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">上传附件<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<div id="attachfileid_zrzh" style="border: 1px red solid;"></div> 
	        <input readonly="readonly" name="Att_ZRZH"  id="Att_ZRZH" value="${map.Att_ZRZH}"  type="hidden"/>
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">2.扶弱济贫</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="FRJPSL" id="FRJPSL"  value="${map.FRJPSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="FRJPJE" id="FRJPJE"  value="${map.FRJPJE}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">上传附件<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<div id="attachfileid_frjp" style="border: 1px red solid;"></div> 
	        <input readonly="readonly" name="Att_FRJP"  id="Att_FRJP" value="${map.Att_FRJP}"  type="hidden"/>
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">3.捐资助学</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="JZZXSL" id="JZZXSL"  value="${map.JZZXSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="JZZXJE" id="JZZXJE"  value="${map.JZZXJE}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">上传附件<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<div id="attachfileid_jzzx" style="border: 1px red solid;"></div> 
	        <input readonly="readonly" name="Att_JZZX"  id="Att_JZZX" value="${map.Att_JZZX}"  type="hidden"/>
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">4.志愿服务</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="ZYFWSL" id="ZYFWSL"  value="${map.ZYFWSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="ZYFWJE" id="ZYFWJE"  value="${map.ZYFWJE}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">上传附件<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<div id="attachfileid_zyfw" style="border: 1px red solid;"></div> 
	        <input readonly="readonly" name="Att_ZYFW"  id="Att_ZYFW" value="${map.Att_ZYFW}" type="hidden"/>
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">5.其他</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="GYQTSL" id="GYQTSL"  value="${map.GYQTSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="GYQTJE" id="GYQTJE"  value="${map.GYQTJE}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">上传附件<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
		<div id="attachfileid_gyqt" style="border: 1px red solid;"></div> 
	        <input readonly="readonly" name="Att_GYQT"  id="Att_GYQT" value="${map.Att_GYQT}"  type="hidden"/>
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">(八)内部建设</td>
    </tr>
    <tr>
    <td class="left_tb" colspan="6">1.组织内部培训</td>
    </tr>
    <tr>
    <td class="left_tb" colspan="6">(1)内部培训(次)</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="NBPXSL" id="NBPXSL"  value="${map.NBPXSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">上传附件<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<div id="attachfileid_nbpx" style="border: 1px red solid;"></div> 
	        <input readonly="readonly" name="Att_NBPX"  id="Att_NBPX" value="${map.Att_NBPX}"  type="hidden"/>
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">(2)参加人数(人次)</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="CJRSSL" id="CJRSSL"  value="${map.CJRSSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_CJRS" id="Memo_CJRS" style="width:100%" value="${map.Memo_CJRS}">
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">2.组织工会活动(次)</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="GHHDSL" id="GHHDSL"  value="${map.GHHDSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">上传附件<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<div id="attachfileid_ghhd" style="border: 1px red solid;"></div> 
	        <input readonly="readonly" name="Att_GHHD"  id="Att_GHHD" value="${map.Att_GHHD}" type="hidden"/>
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">3.为员工购买五险一金</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="WXYJJE" id="WXYJJE"  value="${map.WXYJJE}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_WXYJ" id="Memo_WXYJ" style="width:100%" value="${map.Memo_WXYJ}">
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">4.组织帮助家庭困难员工情况(人次、金额)</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="BZYGSL" id="BZYGSL"  value="${map.BZYGSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="BZYGJE" id="BZYGJE"  value="${map.BZYGJE}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">上传附件<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<div id="attachfileid_bzyd" style="border: 1px red solid;"></div> 
	        <input readonly="readonly" name="Att_BZYG"  id="Att_BZYG" value="${map.Att_BZYG}"  type="hidden"/>
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="4">5.构建员工成长通道</td>
    <td class="data_tb_alignright" nowrap="nowrap">上传附件<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
            <div id="attachfileid_cctd" style="border: 1px red solid;"></div> 
	        <input readonly="readonly" name="Att_CCTD"  id="Att_CCTD" value="${map.Att_CCTD}"  type="hidden"/>
		</td>
    </tr>
    <tr>
    <td class="left_tb" colspan="6">6.购买职业责任保险保额或提取风险金</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="ZRBXJE" id="ZRBXJE"  value="${map.ZRBXJE}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">备注<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<input readonly="readonly" name="Memo_ZRBX" id="Memo_ZRBX" style="width:100%" value="${map.Memo_ZRBX}">
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">(九)其他方面</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="QTFMSL" id="QTFMSL"  value="${map.QTFMSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">涉及金额(万元)<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="QTFMJE" id="QTFMJE"  value="${map.QTFMJE}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">具体情况说明<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="Memo_QTFM" id="Memo_QTFM" style="width:100%" value="${map.Memo_QTFM}">
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">三、典型案例报送</td>
    </tr>
    <tr>
    <td class="left_tb" colspan="6">(一)经济方面</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="JJFMSL" id="JJFMSL"  value="${map.JJFMSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">上传附件<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<div id="attachfileid_jjfm" style="border: 1px red solid;"></div> 
	        <input readonly="readonly" name="Att_JJFM"  id="Att_JJFM" value="${map.Att_JJFM}"  type="hidden"/>
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">(二)政府购买服务</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="GMFWSL" id="GMFWSL"  value="${map.GMFWSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">上传附件<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<div id="attachfileid_gmfw" style="border: 1px red solid;"></div> 
	        <input readonly="readonly" name="Att_GMFW"  id="Att_GMFW" value="${map.Att_GMFW}"  type="hidden"/>
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">(三)民生方面</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="MSFMSL" id="MSFMSL"  value="${map.MSFMSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">上传附件<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<div id="attachfileid_msfm" style="border: 1px red solid;"></div> 
	        <input readonly="readonly" name="Att_MSFM"  id="Att_MSFM" value="${map.Att_MSFM}"  type="hidden"/>
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">(四)生态方面</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="STFMSL" id="STFMSL"  value="${map.STFMSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">上传附件<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<div id="attachfileid_stfm" style="border: 1px red solid;"></div> 
	        <input readonly="readonly" name="Att_STFM"  id="Att_STFM" value="${map.Att_STFM}"  type="hidden"/>
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">(五)诚信建设</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="CXJSSL" id="CXJSSL"  value="${map.CXJSSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">上传附件<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<div id="attachfileid_cxjs" style="border: 1px red solid;"></div> 
	        <input readonly="readonly" name="Att_CXJS"  id="Att_CXJS" value="${map.Att_CXJS}"  type="hidden"/>
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">(六)党建工作</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="DJGZSL" id="DJGZSL"  value="${map.DJGZSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">上传附件<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<div id="attachfileid_djgz" style="border: 1px red solid;"></div> 
	        <input readonly="readonly" name="Att_DJGZ"  id="Att_DJGZ" value="${map.Att_DJGZ}"  type="hidden"/>
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">(七)社会公益</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="SHGYSL" id="SHGYSL"  value="${map.SHGYSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">上传附件<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<div id="attachfileid_shgy" style="border: 1px red solid;"></div> 
	        <input readonly="readonly" name="Att_SHGY"  id="Att_SHGY" value="${map.Att_SHGY}"  type="hidden"/>
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">(八)内部建设</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="NBJSSL" id="NBJSSL"  value="${map.NBJSSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">上传附件<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<div id="attachfileid_nbjs" style="border: 1px red solid;"></div> 
	        <input readonly="readonly" name="Att_NBJS"  id="Att_NBJS" value="${map.Att_NBJS}"  type="hidden"/>
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">(九)注师兼任社会职务情况</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="JRZWSL" id="JRZWSL"  value="${map.JRZWSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">上传附件<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<div id="attachfileid_jrzw" style="border: 1px red solid;"></div> 
	        <input readonly="readonly" name="Att_JRZW"  id="Att_JRZW" value="${map.Att_JRZW}"  type="hidden"/>
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">(十)政府及社会对事务所和注师的评价</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="SHPJSL" id="SHPJSL"  value="${map.SHPJSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">上传附件<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<div id="attachfileid_shpj" style="border: 1px red solid;"></div> 
	        <input readonly="readonly" name="Att_SHPJ"  id="Att_SHPJ" value="${map.Att_SHPJ}"  type="hidden"/>
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">(十一)其他方面</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">数量<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content">
			<input readonly="readonly" name="QTALSL" id="QTALSL"  value="${map.QTALSL}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">上传附件<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="3">
			<div id="attachfileid_qtal" style="border: 1px red solid;"></div> 
	        <input readonly="readonly" name="Att_QTAL"  id="Att_QTAL" value="${map.Att_QTAL}"  type="hidden"/>
		</td>
    </tr>  
    <tr>
    <td class="left_tb" colspan="6">四、事务所视频宣传片报送</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">上传附件<font color="#FF0000">&nbsp;[*]</font></td>
		<td class="data_tb_content" colspan="5">
			<div id="attachfileid_xcp" style="border: 1px red solid;"></div> 
	        <input readonly="readonly" name="Att_XCP"  id="Att_XCP" value="${map.Att_XCP}"  type="hidden"/>
		</td>
    </tr>
    <tr>
    <td class="left_tb" colspan="6">五、统一上传附件</td>
    </tr>
    <tr>
    <td class="data_tb_alignright" nowrap="nowrap">上传附件</td>
		<td class="data_tb_content" colspan="5">
			<div id="Attachfile" style="border: 1px red solid;"></div> 
	        <input readonly="readonly" name="Attachfile"  id="Attachfile" value="${map.Attachfile}"  type="hidden"/>
		</td>
    </tr>
</table>
<div style="text-align: center;margin-top: 15px; margin-bottom:15px;"><font style="font-size:20px">会计师事务所典型案例登记表</font></div>
<table style="WIDTH: 100%; border: 0px;" class="data_tb">
  <tr>
    <td class="data_tb_alignright" nowrap="nowrap">案例名称<font color="#FF0000">&nbsp;[*]</font></td>
    <td class="data_tb_content">
			<input readonly="readonly" name="Title" id="Title" style="width:200px"  value="${map.Title}">
		</td>
    <td class="data_tb_alignright" nowrap="nowrap">所属种类<font color="#FF0000">&nbsp;[*]</font></td>
    <td class="data_tb_content">
			<input readonly="readonly" name="Type" id="Type" style="width:200px" value="${map.Type}">
		</td>
  </tr>
  <tr>
    <td class="left_tb" colspan="4">主要内容(600-800字)<font color="#FF0000">&nbsp;[*]</font></td>
  </tr>
  <tr>
  <td class="data_tb_content" colspan="4">
			<textarea readonly="readonly" name="ALContent" id="ALContent" rows="8" cols="148" >${map.ALContent}</textarea>
		</td>
  </tr>
  
</table>
</div>
</form>
</body>
<script type="text/javascript">
//初始化上传控件
var a = new Array("#ATT_PJPS", "#Att_SNJS", "#Att_TTXM","#Att_CXXS","#Att_CXJY","#Att_ZTNJY","#Att_DTHD","#Att_DBTA","#Att_ZRZH","#Att_FRJP","#Att_JZZX","#Att_ZYFW","#Att_GYQT","#Att_NBPX","#Att_GHHD","#Att_BZYG","#Att_CCTD","#Att_JJFM","#Att_GMFW","#Att_MSFM","#Att_STFM","#Att_CXJS","#Att_DJGZ","#Att_SHGY","#Att_NBJS","#Att_JRZW","#Att_SHPJ","#Att_QTAL","#Att_XCP","#Attachfile");
var b = new Array("#attachfileid_pjps", "#attachfiled_snjs", "#attachfiled_ttxm","#attachfileid_cxxs","#attachfileid_cxjy","#attachfileid_ztnjy","#attachfileid_dthd","#attachfileid_dbta","#attachfileid_zrzh","#attachfileid_frjp","#attachfileid_jzzx","#attachfileid_zyfw","#attachfileid_gyqt","#attachfileid_nbpx","#attachfileid_ghhd","#attachfileid_bzyd","#attachfileid_cctd","#attachfileid_jjfm","#attachfileid_gmfw","#attachfileid_msfm","#attachfileid_stfm","#attachfileid_cxjs","#attachfileid_djgz","#attachfileid_shgy","#attachfileid_nbjs","#attachfileid_jrzw","#attachfileid_shpj","#attachfileid_qtal","#attachfileid_xcp","#Attachfile_ty");
var c = new Array('${map.ATT_PJPS}','${map.Att_SNJS}','${map.Att_TTXM}','${map.Att_CXXS}','${map.Att_CXJY}','${map.Att_ZTNJY}','${map.Att_DTHD}','${map.Att_DBTA}','${map.Att_ZRZH}','${map.Att_FRJP}','${map.Att_JZZX}','${map.Att_ZYFW}','${map.Att_GYQT}','${map.Att_NBPX}','${map.Att_GHHD}','${map.Att_BZYG}','${map.Att_CCTD}','${map.Att_JJFM}','${map.Att_GMFW}','${map.Att_MSFM}','${map.Att_STFM}','${map.Att_CXJS}','${map.Att_DJGZ}','${map.Att_SHGY}','${map.Att_NBJS}','${map.Att_JRZW}','${map.Att_SHPJ}','${map.Att_QTAL}','${map.Att_XCP}','${map.Attachfile}');
for(var i = 0;i < a.length; i++) {
	    var fileid=new Date().getTime();
	    $(a[i]).val(fileid);
	    var d=(c[i]=='') ? fileid : c[i];
		$(b[i]).uploadFile({
		 	indexId:d, 
			module:'R_SHZRLXTJB',
			forbitUpload:false,
			forbitDel:false
		});	
	}
$("input").each(function(index,obj){
	obj.readOnly = true ;
	obj.className = "before";
});
$("textarea").each(function(index,obj){
	obj.readOnly = true ;
	obj.className = "before";
});

$("select").each(function(index,obj){
	obj.disabled = true ;
	obj.className = "before";

});
</script>
</html>