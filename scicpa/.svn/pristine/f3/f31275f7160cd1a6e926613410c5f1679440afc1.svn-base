<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看法律法规</title>

<style type="text/css">

	body {
		margin: 0px ;
		padding: 0px ;
	}
	
	/*
	.tools {
		width:100% ;
		height:27px ;
		padding-top: 5px;
		
		text-align: right; 		
	    position:fixed;
	    _position:absolute;  
	    left:0px;
	    top: 0 px ;
	    background-color: #fff;
	} 
	*/
	

	
	.content {
		width:100% ;
		/*padding-bottom:150px;*/  
		padding-bottom:0px;		 /*我改的*/
		/*padding-top: 30px;*/
		padding-top: opx;		/*我改的*/
		padding-left:20px;
		padding-right:30px;
	}
	
	.foot_bar{
	  position:fixed;
	  bottom:0;
	  left:0;
	  color:#fff;
	  border:1.5px solid #eff7e2;
	  font-weight:bold;
	  width:100%;
	  z-index:100;
	  height:150px;
	  line-height:58px;
	  display:block;
	  text-indent:16px;
	  _position:absolute; /* for IE6 */
	  _top: expression(documentElement.scrollTop + documentElement.clientHeight-this.offsetHeight); /* for IE6 */
	  overflow:visible;
	  _width:100%;
	  background-color: #fff;
	}
	
	.hd{
	  width: 100%;
	  background-color: #e6f4d0;
	  height: 24px;
	  line-height:25px;
	  color: #0066cc;
	  font-size: 14px ;
	}
	
	ul {
		color:#030303;
		text-align: top;
		line-height:20px;
	}
	
	li a{
		color:#030303;
		font-size:12px;
		text-decoration:none;
	}
	li a:hover {
		color:#0066cc ;
	}
	
	
	#askQuestion 
	{
		position: absolute;
		left:250px;
		top:80px;
		width:700px;
		height:350px;
		background-color:#f0f5FF;
		border: 1px solid #000;
		z-index: 50;
	}
	#askQuestion_handle 
	{
		background-color:#5588bb;
		padding:2px;
		text-align:center;
		font-weight:bold;
		color: #FFFFFF;
		vertical-align:middle;
	}
	#askQuestion_content 
	{
		padding:5px;
	}
	#close
	{
		float:right;
		text-decoration:none;
		color:#FFFFFF;
	}





	


	/*	
	p { 
		text-indent: 2em;
	}
	p:first-child {
		font-weight: bold;
		//border: solid 1px red;
		text-align: center;
	}
	*/	
	
	<!--
	table {
		margin:0 auto;
	}
	-->

	.dan {
		background: #dfe6ee;
	}
	
.t {
	border: lightgray; 
	border-style: solid; 
	border-width: 1px;
} 	


	
</style>

</head>
<body> 


















<table width=768>
<tr><td align=right>


<div class="tools">
	
	
	
		&nbsp;<input icon='icon-config' id="notPass" onclick="update();" type='button' value='我要纠错'>
		&nbsp;<input icon='icon-question' onclick="goAdd();" type='button' value='我要提问'>
	
	&nbsp;<input icon='icon-back' onclick="window.history.back();" type='button' value='返回'>
	&nbsp;<input icon='icon-cancel' onclick="window.close();" type='button' value='关闭'>
</div>

</td></tr>
</table>




<!-- 
<div class="content">
	<table border=0 cellspacing=0 width=100% cellpadding=3 align=center bordercolor=#ffffff>
		<tr><Td align=center style="font-size:14px"><b><font color=maroon>关于印发《会计师事务所财务管理暂行办法》的通知</font></b></td></tr>
		<tr><Td align=center style="font-size:14px"><font color=#614E4E></font></td></tr>
		<tr>
			<td align=center style="font-size:14px">
					
			<font color=#614E4E>颁布日期：2010-06-13</font><font color=#614E4E>　颁布单位：财政部</font></td>
		</tr>
		<tr><Td height=5></td></tr>
	</table>
	<div class="faguicon">




<p><div class="promulgatepopulation">各省、自治区、直辖市财政厅（局），深圳市财政委员会：</div><p class="doc-A">为了贯彻落实《国务院办公厅转发财政部关于加快发展我国注册会计师行业若干意见的通知》（国办发〔2009〕56号），促进会计师事务所加强财务管理，优化会计师事务所内部治理，根据《中华人民共和国会计法》、《中华人民共和国注册会计师法》，我部制定了《会计师事务所财务管理暂行办法》，现予印发，自2011年1月1日起施行。</p><p class="doc-A">财务管理尤其是总分所之间财务管理的实质统一，是会计师事务所规范程度和管理水平的重要标志。各省级财政部门要结合宣传贯彻《会计师事务所分所管理暂行办法》（财会〔2010〕2号），将会计师事务所实施财务管理情况作为履行行政管理职能的重要内容，在会计师事务所日常管理和年度报备时予以重点关注。财政部将会同部分地区财政部门择机组织专项检查评估，采取切实有效措施，督促、指导我国会计师事务所全面提升财务管理水平。</p><p class="promulgatesignatory">财政部</p><p class="promulgatedate">二○一○年六月十三日</p>
<p><p class="doc-A"><a name="No8_F1"></a>附：</p><p class="attachtitle"><a name="No9"></a>会计师事务所财务管理暂行办法</p><p><a name="No10_T1"></a><span class="sect2Title">第一条</span><a name="No11_T1K1"></a><span class="title">为了加强会计师事务所财务管理，优化会计师事务所内部治理，根据《中华人民共和国会计法》、《中华人民共和国注册会计师法》、《国务院办公厅转发财政部关于加快发展我国注册会计师行业若干意见的通知》（国办发〔2009〕56号）等，制定本暂行办法。</span></p><p><a name="No12_T2"></a><span class="sect2Title">第二条</span><a name="No13_T2K1"></a><span class="title">会计师事务所应当根据《中华人民共和国会计法》等国家有关法规制度和本暂行办法，结合合伙人协议、事务所章程等，建立内部财务管理体制和各项财务管理制度。</span></p><p><a name="No14_T3"></a><span class="sect2Title">第三条</span><a name="No15_T3K1"></a><span class="title">鼓励会计师事务所执行《企业内部控制基本规范》、《企业内部控制应用指引》和《企业内部控制评价指引》，进一步强化会计师事务所财务内部控制。</span></p><p><a name="No16_T4"></a><span class="sect2Title">第四条</span><a name="No17_T4K1"></a><span class="title">会计师事务所应当对全所范围内的会计核算、资金使用、业务收支和收益分配等进行统一管理，进一步加强对分所财务的集中控制，切实做到一体化管理，避免会计师事务所内部财务管理各自为政。</span></p><p><a name="No18_T5"></a><span class="sect2Title">第五条</span><a name="No19_T5K1"></a><span class="title">会计师事务所应当结合经营特点和管理要求，优化业务流程，加大信息技术应用推广力度，进一步整合财务和业务信息管理系统，不断提高财务管理效能。</span></p><p><a name="No20_T6"></a><span class="sect2Title">第六条</span><a name="No21_T6K1"></a><span class="title">会计师事务所应当按照统一的财务管理体制和财务会计法规制度，设立独立的财会部门或在相关部门内指定专职财会人员，明确相关部门和人员的职责权限。</span></p><p><a name="No22_T7"></a><span class="sect2Title">第七条</span><a name="No23_T7K1"></a><span class="title">会计师事务所任用会计人员应当实行回避制度。</span></p><p class="title"><a name="No24_T7K2"></a>大中型会计师事务所的合伙人（股东）的直系亲属不得担任本会计师事务所的会计机构负责人、会计主管人员。</p><p><a name="No25_T8"></a><span class="sect2Title">第八条</span><a name="No26_T8K1"></a><span class="title">大中型会计师事务所应当建立健全财务预算管理制度，对会计师事务所业务收支等实施预算管理。</span></p><p class="title"><a name="No27_T8K2"></a>鼓励小型会计师事务所建立财务预算管理制度。</p><p><a name="No28_T9"></a><span class="sect2Title">第九条</span><a name="No29_T9K1"></a><span class="title">会计师事务所应当加强对应收账款的管理，完善财务部门和业务部门的沟通和协作机制，保证应收账款真实、完整。</span></p><p><a name="No30_T10"></a><span class="sect2Title">第十条</span><a name="No31_T10K1"></a><span class="title">会计师事务所应当建立严格的资金支付授权审批制度，明确支出款项的用途、金额、限额、支付方式等内容，保证资金支出的合法、安全。</span></p><p class="title"><a name="No32_T10K2"></a>会计师事务所拓展和承接业务，不得向委托人或相关方面提供回扣或其他形式的商业贿赂。</p><p><a name="No33_T11"></a><span class="sect2Title">第十一条</span><a name="No34_T11K1"></a><span class="title">会计师事务所及其注册会计师购买有价证券应当符合相关法律法规和独立性要求。</span></p><p class="title"><a name="No35_T11K2"></a>会计师事务所不得为其他企业、单位或个人提供担保。</p><p><a name="No36_T12"></a><span class="sect2Title">第十二条</span><a name="No37_T12K1"></a><span class="title">会计师事务所应当建立健全财产物资采购、使用、保管、处置等各环节的管理制度，定期清查和盘点，对发生的财产损失要及时查明原因、作出处理。</span></p><p><a name="No38_T13"></a><span class="sect2Title">第十三条</span><a name="No39_T13K1"></a><span class="title">会计师事务所应当加强负债管理，保证适当的流动性，对发生的各种借款和应付应交款项，应当按合同约定方式和期限及时归还或支付。</span></p><p class="title"><a name="No40_T13K2"></a>会计师事务所分所不得同其他企业或单位发生除正常业务活动外的债权债务关系。</p><p><a name="No41_T14"></a><span class="sect2Title">第十四条</span><a name="No42_T14K1"></a><span class="title">会计师事务所应当按照业务类型对取得的收入进行明细核算，同时按照资金用途对支出的费用进行明细核算。</span></p><p><a name="No43_T15"></a><span class="sect2Title">第十五条</span><a name="No44_T15K1"></a><span class="title">会计师事务所应当建立有效的工时管理系统和成本控制系统，在保证执业质量的前提下，不断强化成本预算约束，实现成本的全员管理和全过程控制。</span></p><p class="title"><a name="No45_T15K2"></a>大中型会计师事务所应当以具体承做的业务项目为基础，对主营业务收入和直接成本费用进行核算。鼓励小型会计师事务所以具体承做的业务项目为基础，对主营业务收入和直接成本费用进行核算。</p><p><a name="No46_T16"></a><span class="sect2Title">第十六条</span><a name="No47_T16K1"></a><span class="title">会计师事务所应当结合人员定级定岗制度制定工资薪酬政策和制度。工资薪酬政策和制度应当统一，同时统筹考虑分所所在地的地区差异。</span></p><p><a name="No48_T17"></a><span class="sect2Title">第十七条</span><a name="No49_T17K1"></a><span class="title">会计师事务所应当统一购买职业保险，或按规定计提职业风险基金。</span></p><p><a name="No50_T18"></a><span class="sect2Title">第十八条</span><a name="No51_T18K1"></a><span class="title">会计师事务所应当为党组织的活动提供必要经费。</span></p><p><a name="No52_T19"></a><span class="sect2Title">第十九条</span><a name="No53_T19K1"></a><span class="title">会计师事务所应当加大教育培训投入，强化经费保障，提高从业人员职业道德水平和专业胜任能力。</span></p><p><a name="No54_T20"></a><span class="sect2Title">第二十条</span><a name="No55_T20K1"></a><span class="title">会计师事务所应当制定科学的业绩考核和收益分配制度，业绩考核和收益分配制度应当经合伙人会议（股东大会）审议批准，并在全所范围内执行。会计师事务所应当定期对业绩考核和分配制度进行评估，根据市场环境变化和自身发展需要不断修订完善。</span></p><p><a name="No56_T21"></a><span class="sect2Title">第二十一条</span><a name="No57_T21K1"></a><span class="title">会计师事务所制定业绩考核和收益分配制度，应当充分体现会计师事务所“人合”的特性，在优先考虑事务所持续发展的基础上，根据职级、能力和贡献等因素确定业绩考核标准和收益分配方案。</span></p><p><a name="No58_T22"></a><span class="sect2Title">第二十二条</span><a name="No59_T22K1"></a><span class="title">会计师事务所应当于每年年度终了编制年度财务报告，并向全体合伙人（股东）报告。</span></p><p class="title"><a name="No60_T22K2"></a>除国家统一的会计准则制度规定外，会计师事务所编制的年度财务报告还应当包括业务收入明细表（见附表1）和支出明细表（见附表2）。</p><p><a name="No61_T23"></a><span class="sect2Title">第二十三条</span><a name="No62_T23K1"></a><span class="title">会计师事务所应当于每年3月31日前，通过中国注册会计师行业管理信息系统财务报表子系统，向中国注册会计师协会、省级注册会计师协会上报经其他会计师事务所审计的上年度财务报告（包括本办法第二十二条中的业务收入明细表和支出明细表，下同）。省级注册会计师协会应将确认、汇总后的，与系统汇总数据一致的全省会计师事务所财务报告报送中国注册会计师协会。</span></p><p class="title"><a name="No63_T23K2"></a>会计师事务所经其他会计师事务所审计的上年度财务报告应当同时报送省级财政部门；其中，大中型会计师事务所经其他会计师事务所审计的财务报告还应当同时报送财政部。</p><p><a name="No64_T24"></a><span class="sect2Title">第二十四条</span><a name="No65_T24K1"></a><span class="title">会计师事务所应当按照财政部、国家档案局《会计档案管理办法》（财会字〔98〕第32号）的规定建立会计档案管理制度，明确会计档案的立卷、归档、保管、查阅和销毁等管理制度，保证会计档案的妥善保管和有序存放。</span></p><p class="title"><a name="No66_T24K2"></a>会计师事务所分所撤销后，其会计档案应由会计师事务所统一保管。</p><p><a name="No67_T25"></a><span class="sect2Title">第二十五条</span><a name="No68_T25K1"></a><span class="title">会计师事务所应当健全内部财务监督制度。</span></p><p class="title"><a name="No69_T25K2"></a>会计师事务所可以通过设立监事会、财务监督委员会、内部审计机构等方式，按照国家相关法规制度的要求、合伙人协议或事务所章程等履行内部财务监督职责。</p><p><a name="No70_T26"></a><span class="sect2Title">第二十六条</span><a name="No71_T26K1"></a><span class="title">本暂行办法自2011年1月1日起施行。</span></p><p class="doc-A"><a name="No72"></a>附件下载：</p><p class="doc-A"><a name="No73"></a>附表1 业务收入明细表.doc<br/>附表2 支出明细表.doc</p>

<p></div>
 -->






<div>

	<table border=0 cellspacing=0 width=768 cellpadding=3 align=center class=t>
		<tr class=dan>
			<td colspan=2><table align=left><tr><td width=75 valign=top>【法规标题】</td><td><b><font color=maroon>关于印发《会计师事务所财务管理暂行办法》的通知</font></b></td></tr></table></td>
		</tr>
		<tr>
			<td width=50%>【发布日期】2010-06-13&nbsp;</td><td width=50%><table align=left><tr><td width=75 valign=top align=left>【发文机关】</td><td>财政部&nbsp;</td></tr></table></td>
		</tr>	
		<tr class=dan>
			<td>【文号】财会[2010]14号&nbsp;</td><td>【行业分类】&nbsp;</td>
		</tr>	
		<tr>
			<td>【效力状态】<font color="red">现行有效</font>&nbsp;</td><td>【效力级别】 &nbsp;</td>
		</tr>	
		<tr class=dan>
			<td>【主题分类】财务管理&nbsp;</td><td>【地域分类】全国&nbsp;</td>
		</tr>	
	
		
		<tr>
			<td colspan=2 bgcolor=#e37c37></td>
		</tr>

		<tr>
			<td colspan=2><font color=red>【全文】</font></td>
		</tr>
	
		<tr>
			<td colspan=2><div class="faguicon">




<p><div class="promulgatepopulation">各省、自治区、直辖市财政厅（局），深圳市财政委员会：</div><p class="doc-A">为了贯彻落实《国务院办公厅转发财政部关于加快发展我国注册会计师行业若干意见的通知》（国办发〔2009〕56号），促进会计师事务所加强财务管理，优化会计师事务所内部治理，根据《中华人民共和国会计法》、《中华人民共和国注册会计师法》，我部制定了《会计师事务所财务管理暂行办法》，现予印发，自2011年1月1日起施行。</p><p class="doc-A">财务管理尤其是总分所之间财务管理的实质统一，是会计师事务所规范程度和管理水平的重要标志。各省级财政部门要结合宣传贯彻《会计师事务所分所管理暂行办法》（财会〔2010〕2号），将会计师事务所实施财务管理情况作为履行行政管理职能的重要内容，在会计师事务所日常管理和年度报备时予以重点关注。财政部将会同部分地区财政部门择机组织专项检查评估，采取切实有效措施，督促、指导我国会计师事务所全面提升财务管理水平。</p><p class="promulgatesignatory">财政部</p><p class="promulgatedate">二○一○年六月十三日</p>
<p><p class="doc-A"><a name="No8_F1"></a>附：</p><p class="attachtitle"><a name="No9"></a>会计师事务所财务管理暂行办法</p><p><a name="No10_T1"></a><span class="sect2Title">第一条</span><a name="No11_T1K1"></a><span class="title">为了加强会计师事务所财务管理，优化会计师事务所内部治理，根据《中华人民共和国会计法》、《中华人民共和国注册会计师法》、《国务院办公厅转发财政部关于加快发展我国注册会计师行业若干意见的通知》（国办发〔2009〕56号）等，制定本暂行办法。</span></p><p><a name="No12_T2"></a><span class="sect2Title">第二条</span><a name="No13_T2K1"></a><span class="title">会计师事务所应当根据《中华人民共和国会计法》等国家有关法规制度和本暂行办法，结合合伙人协议、事务所章程等，建立内部财务管理体制和各项财务管理制度。</span></p><p><a name="No14_T3"></a><span class="sect2Title">第三条</span><a name="No15_T3K1"></a><span class="title">鼓励会计师事务所执行《企业内部控制基本规范》、《企业内部控制应用指引》和《企业内部控制评价指引》，进一步强化会计师事务所财务内部控制。</span></p><p><a name="No16_T4"></a><span class="sect2Title">第四条</span><a name="No17_T4K1"></a><span class="title">会计师事务所应当对全所范围内的会计核算、资金使用、业务收支和收益分配等进行统一管理，进一步加强对分所财务的集中控制，切实做到一体化管理，避免会计师事务所内部财务管理各自为政。</span></p><p><a name="No18_T5"></a><span class="sect2Title">第五条</span><a name="No19_T5K1"></a><span class="title">会计师事务所应当结合经营特点和管理要求，优化业务流程，加大信息技术应用推广力度，进一步整合财务和业务信息管理系统，不断提高财务管理效能。</span></p><p><a name="No20_T6"></a><span class="sect2Title">第六条</span><a name="No21_T6K1"></a><span class="title">会计师事务所应当按照统一的财务管理体制和财务会计法规制度，设立独立的财会部门或在相关部门内指定专职财会人员，明确相关部门和人员的职责权限。</span></p><p><a name="No22_T7"></a><span class="sect2Title">第七条</span><a name="No23_T7K1"></a><span class="title">会计师事务所任用会计人员应当实行回避制度。</span></p><p class="title"><a name="No24_T7K2"></a>大中型会计师事务所的合伙人（股东）的直系亲属不得担任本会计师事务所的会计机构负责人、会计主管人员。</p><p><a name="No25_T8"></a><span class="sect2Title">第八条</span><a name="No26_T8K1"></a><span class="title">大中型会计师事务所应当建立健全财务预算管理制度，对会计师事务所业务收支等实施预算管理。</span></p><p class="title"><a name="No27_T8K2"></a>鼓励小型会计师事务所建立财务预算管理制度。</p><p><a name="No28_T9"></a><span class="sect2Title">第九条</span><a name="No29_T9K1"></a><span class="title">会计师事务所应当加强对应收账款的管理，完善财务部门和业务部门的沟通和协作机制，保证应收账款真实、完整。</span></p><p><a name="No30_T10"></a><span class="sect2Title">第十条</span><a name="No31_T10K1"></a><span class="title">会计师事务所应当建立严格的资金支付授权审批制度，明确支出款项的用途、金额、限额、支付方式等内容，保证资金支出的合法、安全。</span></p><p class="title"><a name="No32_T10K2"></a>会计师事务所拓展和承接业务，不得向委托人或相关方面提供回扣或其他形式的商业贿赂。</p><p><a name="No33_T11"></a><span class="sect2Title">第十一条</span><a name="No34_T11K1"></a><span class="title">会计师事务所及其注册会计师购买有价证券应当符合相关法律法规和独立性要求。</span></p><p class="title"><a name="No35_T11K2"></a>会计师事务所不得为其他企业、单位或个人提供担保。</p><p><a name="No36_T12"></a><span class="sect2Title">第十二条</span><a name="No37_T12K1"></a><span class="title">会计师事务所应当建立健全财产物资采购、使用、保管、处置等各环节的管理制度，定期清查和盘点，对发生的财产损失要及时查明原因、作出处理。</span></p><p><a name="No38_T13"></a><span class="sect2Title">第十三条</span><a name="No39_T13K1"></a><span class="title">会计师事务所应当加强负债管理，保证适当的流动性，对发生的各种借款和应付应交款项，应当按合同约定方式和期限及时归还或支付。</span></p><p class="title"><a name="No40_T13K2"></a>会计师事务所分所不得同其他企业或单位发生除正常业务活动外的债权债务关系。</p><p><a name="No41_T14"></a><span class="sect2Title">第十四条</span><a name="No42_T14K1"></a><span class="title">会计师事务所应当按照业务类型对取得的收入进行明细核算，同时按照资金用途对支出的费用进行明细核算。</span></p><p><a name="No43_T15"></a><span class="sect2Title">第十五条</span><a name="No44_T15K1"></a><span class="title">会计师事务所应当建立有效的工时管理系统和成本控制系统，在保证执业质量的前提下，不断强化成本预算约束，实现成本的全员管理和全过程控制。</span></p><p class="title"><a name="No45_T15K2"></a>大中型会计师事务所应当以具体承做的业务项目为基础，对主营业务收入和直接成本费用进行核算。鼓励小型会计师事务所以具体承做的业务项目为基础，对主营业务收入和直接成本费用进行核算。</p><p><a name="No46_T16"></a><span class="sect2Title">第十六条</span><a name="No47_T16K1"></a><span class="title">会计师事务所应当结合人员定级定岗制度制定工资薪酬政策和制度。工资薪酬政策和制度应当统一，同时统筹考虑分所所在地的地区差异。</span></p><p><a name="No48_T17"></a><span class="sect2Title">第十七条</span><a name="No49_T17K1"></a><span class="title">会计师事务所应当统一购买职业保险，或按规定计提职业风险基金。</span></p><p><a name="No50_T18"></a><span class="sect2Title">第十八条</span><a name="No51_T18K1"></a><span class="title">会计师事务所应当为党组织的活动提供必要经费。</span></p><p><a name="No52_T19"></a><span class="sect2Title">第十九条</span><a name="No53_T19K1"></a><span class="title">会计师事务所应当加大教育培训投入，强化经费保障，提高从业人员职业道德水平和专业胜任能力。</span></p><p><a name="No54_T20"></a><span class="sect2Title">第二十条</span><a name="No55_T20K1"></a><span class="title">会计师事务所应当制定科学的业绩考核和收益分配制度，业绩考核和收益分配制度应当经合伙人会议（股东大会）审议批准，并在全所范围内执行。会计师事务所应当定期对业绩考核和分配制度进行评估，根据市场环境变化和自身发展需要不断修订完善。</span></p><p><a name="No56_T21"></a><span class="sect2Title">第二十一条</span><a name="No57_T21K1"></a><span class="title">会计师事务所制定业绩考核和收益分配制度，应当充分体现会计师事务所“人合”的特性，在优先考虑事务所持续发展的基础上，根据职级、能力和贡献等因素确定业绩考核标准和收益分配方案。</span></p><p><a name="No58_T22"></a><span class="sect2Title">第二十二条</span><a name="No59_T22K1"></a><span class="title">会计师事务所应当于每年年度终了编制年度财务报告，并向全体合伙人（股东）报告。</span></p><p class="title"><a name="No60_T22K2"></a>除国家统一的会计准则制度规定外，会计师事务所编制的年度财务报告还应当包括业务收入明细表（见附表1）和支出明细表（见附表2）。</p><p><a name="No61_T23"></a><span class="sect2Title">第二十三条</span><a name="No62_T23K1"></a><span class="title">会计师事务所应当于每年3月31日前，通过中国注册会计师行业管理信息系统财务报表子系统，向中国注册会计师协会、省级注册会计师协会上报经其他会计师事务所审计的上年度财务报告（包括本办法第二十二条中的业务收入明细表和支出明细表，下同）。省级注册会计师协会应将确认、汇总后的，与系统汇总数据一致的全省会计师事务所财务报告报送中国注册会计师协会。</span></p><p class="title"><a name="No63_T23K2"></a>会计师事务所经其他会计师事务所审计的上年度财务报告应当同时报送省级财政部门；其中，大中型会计师事务所经其他会计师事务所审计的财务报告还应当同时报送财政部。</p><p><a name="No64_T24"></a><span class="sect2Title">第二十四条</span><a name="No65_T24K1"></a><span class="title">会计师事务所应当按照财政部、国家档案局《会计档案管理办法》（财会字〔98〕第32号）的规定建立会计档案管理制度，明确会计档案的立卷、归档、保管、查阅和销毁等管理制度，保证会计档案的妥善保管和有序存放。</span></p><p class="title"><a name="No66_T24K2"></a>会计师事务所分所撤销后，其会计档案应由会计师事务所统一保管。</p><p><a name="No67_T25"></a><span class="sect2Title">第二十五条</span><a name="No68_T25K1"></a><span class="title">会计师事务所应当健全内部财务监督制度。</span></p><p class="title"><a name="No69_T25K2"></a>会计师事务所可以通过设立监事会、财务监督委员会、内部审计机构等方式，按照国家相关法规制度的要求、合伙人协议或事务所章程等履行内部财务监督职责。</p><p><a name="No70_T26"></a><span class="sect2Title">第二十六条</span><a name="No71_T26K1"></a><span class="title">本暂行办法自2011年1月1日起施行。</span></p><p class="doc-A"><a name="No72"></a>附件下载：</p><p class="doc-A"><a name="No73"></a>附表1 业务收入明细表.doc<br/>附表2 支出明细表.doc</p>

<p></div></td>
		</tr>
		
		
		
			<tr>
				<td colspan=2 bgcolor=#e37c37></td>
			</tr>
			<tr>
				<td colspan=2><font color=red>【附件】</font></td>
			</tr>
			
				<tr class=dan>
					<td colspan=2><a href="/gdicpa/Download_FileDOWNLOAD_FILE/GWY/600-9/001E3741A2CC0DB37A2102.DOC" target="_balnk">业务收入明细表.doc</a><br></td>
				</tr>	
			
				<tr class=dan>
					<td colspan=2><a href="/gdicpa/Download_FileDOWNLOAD_FILE/GWY/600-9/001E3741A2CC0DB37A2102.DOC" target="_balnk">支出明细表.doc</a><br></td>
				</tr>	
			
		
		
	</table><br><br>















	
	
</div>

<!-- 
<div class="foot_bar" id="foot">
	<div class="hd">
		<img src="/gdicpa/icons/question_blue.png"/>  &nbsp;相关问题
		<span style="float: right"><a href="#" style="text-decoration:none;">更多</a></span>
	</div>
	<div style="height:76;overflow: auto;">
		<ul>
			
			
		</ul>
	</div> 
</div>


<div id="askQuestion" style="display:none">
	<form action="" id="thisForm" name="thisForm" method="post"> 
		<table>
			<tr>
				<td>标题:</td>
				<td><input type="text" size="80" id="title" name="title"></td>
			</tr>
			<tr>
				<td>内容:</td>
				<td><textarea cols="62" rows="15" id="content" name="content"></textarea></td>
			</tr>
		</table>
		<input type="hidden" value="10000073926" id="policyId" name="policyId">
 	</form>
 	
 	<iframe src="" id="go"  name="go" style="display: none"></iframe>
 	
</div>	

 -->



<script language="javascript">
	
	$(function (){
		if("" != "" && "" != "null") {
			$("#foot").css("display","none");
		}
	}) ;

	//flag 1代表通过，0代表不通过
	function goAudit(flag) {
		 var result = $.ajax({
		  	url: "/gdicpa/common/policy.do?method=audit",
		  	data: "id=&state="+flag+"&random="+Math.random(),
		  	async: false
		 }).responseText;
	   alert(result);
	  $("#pass").btn().disable();
	  $("#notPass").btn().disable();
	}
	   
	function update() {
      	window.location = "/gdicpa/common/policy.do?method=update&id=10000073926" ;
    } 
    
    //显示浮动窗口的方法    
	function showWin() {
	   $.weeboxs.open('#askQuestion',{width:600,height:300,title: '请输入您的问题',okBtnName:'提交',onok:function(){saveQuestion()}});
	}  
	
	
	function saveQuestion() {
	   document.thisForm.action = "/gdicpa/common/policy.do?method=saveQuestion" ;
	   document.thisForm.submit();
	}
	
	function goAdd() {
       	window.open("/gdicpa/common/question.do?method=addView&ctype=policy&typeId=10000073926");
    }
	
	
	function f_download(attachmentId){
		document.getElementById("go").src = "/gdicpa/common/policy.do?method=downPolicy&attachmentId="+attachmentId;
	}
	
</script>



</body>
</html>
 