<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>执业会员信息</title>
<link rel="stylesheet"	href="${pageContext.request.contextPath}/CSS/main.css" />
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
</style>
<style>
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
	BORDER-RIGHT-COLOR: #b2c9d3
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
</style>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/index.css" />
</head>
<body>


<form name="thisForm" method="post" action="" id="thisForm">
<center class="formTitle">
自&nbsp;&nbsp;我&nbsp;&nbsp;任&nbsp;&nbsp;职&nbsp;&nbsp;资&nbsp;&nbsp;格&nbsp;&nbsp;预&nbsp;&nbsp;查<br />
<br />
</center>
<table style="WIDTH: 100%"  border="0" >
	<tr>
		<td  width="60px" height="18" align="right"><b>自检年份</b></td>
		<td  width=""  height="18" ><hr style="border: 2px dotted #000000;"></td>
		<td  width="60px"  height="18">${tmap.iyear }年</td>
	</tr>
	<tr>
		<td  width="60px" height="18" align="right"><b>学时检查</b></td>
		<td  width=""  height="18" ><hr style="border: 2px dotted #000000;"></td>
		<td  width="60px"  height="18"><c:if test="${tmap.school==0}">不通过</c:if><c:if test="${tmap.school!=0}">通过</c:if></td>
	</tr>
	<tr>
		<td  width="60px" height="18" align="right"><b>鉴证检查</b></td>
		<td  width=""  height="18" ><hr style="border: 2px dotted #000000;"></td>
		<td  width="60px"  height="18"><c:if test="${tmap.verification==0}">不通过</c:if><c:if test="${tmap.verification!=0}">通过</c:if></td>
	</tr>
	<tr>
		<td  width="60px" height="18" align="right"><b>会费缴纳</b></td>
		<td  width=""  height="18" ><hr style="border: 2px dotted #000000;"></td>
		<td  width="60px"  height="18"><c:if test="${tmap.dues=='否'}">不通过</c:if><c:if test="${tmap.dues!='否'}">通过</c:if></td>
	</tr>	
	<tr>
		<td  width="60px" height="18" align="right"><b>预查结果</b></td>
		<td  width=""  height="18" ><hr style="border: 2px dotted #000000;"></td>
		<td  width="60px"  height="18" ><b>${tmap.result }</b></td>
	</tr>			
</table>


<DIV class=block id=search>

<H3 class=tabs id=searchtabs>
<A class="tab curtab" id=dgxxtab href="javascript:setTab('search','dgxx')">用户信息</A> 
<A class="tab" id=sjdwtab href="javascript:setTab('search','sjdw')">学时检查</A>
<A class="tab" id=jzzctab href="javascript:setTab('search','jzzc')">鉴证检查</A>
<A class="tab" id=hfjltab href="javascript:setTab('search','hfjl')">会费缴纳</A>
</H3>

<div class=tabcontent id="dgxx" style="text-align: center;">

<table style="WIDTH: 100%" class="data_tb" align="center">
	<tbody>
		<tr>
			<td class="data_tb_alignright" style="text-align: left;" colspan="4" height="18"><b>个人信息</b>
			</td>
		</tr>
		<tr>
			<td class="data_tb_alignright" width="20%" height="18">姓名</td>
			<td class="data_tb_content" height="18" colspan="3">${userMap.loginname }</td>
		</tr>
		<tr>
			<td class="data_tb_alignright" width="20%" height="18">性别</td>
			<td class="data_tb_content" width="30%"  height="18">${userMap.sex }</td>
			<td class="data_tb_alignright"  width="20%" height="18">民族</td>
			<td class="data_tb_content"  width="30%" height="18">${userMap.nation }</td>
		</tr>
		<tr>
			<td class="data_tb_alignright" height="18">出生日期</td>
			<td class="data_tb_content" height="18">${userMap.borndate }</td>
			<td class="data_tb_alignright" height="18">身份证号码</td>
			<td class="data_tb_content" height="18">${userMap.idnumber }</td>
		</tr>
		
		
		<tr>
			<td class="data_tb_alignright" style="text-align: left;"
				height="18" colspan="4"><b>执业信息</b></td>
		</tr>
		<tr>
			<td class="data_tb_alignright" height="18">事务所全称</td>
			<td class="data_tb_content" height="18" colspan="3">${userMap.officename }</td>
		</tr>
		<tr>
			<td class="data_tb_alignright" height="18">事务所代码</td>
			<td class="data_tb_content" height="18">${userMap.officecode }</td>
			<td class="data_tb_alignright" height="18">职务</td>
			<td class="data_tb_content" height="18">${userMap.post }</td>
		</tr>
		<tr>
			<td class="data_tb_alignright" height="18">进 所 时 间</td>
			<td class="data_tb_content" height="18">${userMap.intotime }</td>
			<td class="data_tb_alignright" height="18">是否股东或合伙人</td>
			<td class="data_tb_content" height="18">${userMap.isshareholder}</td>
		</tr>
		<tr>
			<td class="data_tb_alignright" height="18">进所前所在单位</td>
			<td class="data_tb_content" height="18">${userMap.intobefore }</td>
			<td class="data_tb_alignright" height="18">离退休标志</td>
			<td class="data_tb_content" height="18">${userMap.retirees }</td>
		</tr>
		<tr>
			<td class="data_tb_alignright" style="text-align: left;" height="18" colspan="4"><b>资格取得信息</b></td>
		</tr>
		<tr>
			<td class="data_tb_alignright" height="18">CPA证号</td>
			<td class="data_tb_content" height="18">${userMap.cpano }</td>
			<td class="data_tb_alignright" height="18">注师批准文号</td>
			<td class="data_tb_content" height="18">${userMap.cpapermitno }</td>
		</tr>
		<tr>
			<td class="data_tb_alignright" height="18">职称等级</td>
			<td class="data_tb_content" height="18">${userMap.professional }</td>
			<td class="data_tb_alignright" height="18">专业职称</td>
			<td class="data_tb_content" height="18">${userMap.rank }</td>
		</tr>
		<tr>
			<td class="data_tb_alignright" height="18">申请时间</td>
			<td class="data_tb_content" height="18">${userMap.application }</td>
			<td class="data_tb_alignright" height="18">批准时间</td>
			<td class="data_tb_content" height="18">${userMap.approve }</td>
		</tr>
		<tr>
			<td class="data_tb_alignright" height="18">全科合格证书</td>
			<td class="data_tb_content" height="18">${userMap.certificate }</td>
			<td class="data_tb_alignright" height="18">考核批准文号</td>
			<td class="data_tb_content" height="18">${userMap.general }</td>
		</tr>
		<tr>
			<td class="data_tb_alignright" height="18">档案存放单位</td>
			<td class="data_tb_content" height="18">${userMap.filestorage }</td>
			<td class="data_tb_alignright" height="18">档案存放单位类型</td>
			<td class="data_tb_content" height="18">${userMap.filetype }</td>
		</tr>
	</tbody>
</table>
</div>


<div class=tabcontent id="sjdw" style="text-align: center; display: none;">
<!-- 学时检查 -->
<mt:DataGridPrintByBean name="xs_content"/>

	<table width="100%" border="0" >
	<tr>
		<td  align="right" width="85%" style="font-size: 20px;font-weight: bold">本年学时数：</td>
		<td  align="right" width="5%" style="font-size: 20px;font-weight: bold;color: blue;">${tmap.schoolbdate}</td>
		<td  align="right" width="10%" style="font-size: 20px;font-weight: bold;color: blue;">${tmap.school1}</td>
	</tr>
	<tr>
		<td  align="right" style="font-size: 20px;font-weight: bold">二年学时数：</td>
		<td  align="right" style="font-size: 20px;font-weight: bold;color: blue;" >${tmap.schooledate}</td>
		<td  align="right" style="font-size: 20px;font-weight: bold;color: blue;">${tmap.school2}</td>
	</tr>	
	</table>
</div>	

<div class=tabcontent id="jzzc" style="text-align: center; display: none;">
<!-- 鉴证检查 -->
<mt:DataGridPrintByBean name="verification"/>
</div>	

<div class=tabcontent id="hfjl" style="text-align: center; display: none;">
<!-- 会费缴纳 -->
<mt:DataGridPrintByBean name="costpaydetail"/>
</div>	

</DIV>


</form>


</body>
</html>
<script type="text/javascript">
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

</script>
