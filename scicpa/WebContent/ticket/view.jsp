<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<HTML>
<HEAD>
<TITLE></TITLE>
<META http-equiv=Content-type content="text/html; charset=gb2312">
<STYLE type=text/css></STYLE>

<%@ include file="/Sys_INCLUDE/include.jsp" %>

<LINK href="${pageContext.request.contextPath}/CSS/voteresult_1.css" type=text/css rel=stylesheet>

<SCRIPT src="${pageContext.request.contextPath}/JS/FusionCharts.js" type=text/javascript charset="gbk"></SCRIPT>

<SCRIPT src="${pageContext.request.contextPath}/JS/fun.js" type=text/javascript charset="gbk"></SCRIPT>


</HEAD>
<BODY><A id=top name=top></A>
	
	
<!-- 整个调查的统计图表 begin -->
<DIV class="box-area box-area2" id=from_global_host style="DISPLAY: none"></DIV>
	 
	 
<!-- 整个调查的统计图表 end --><!-- 表格 begin -->
<DIV id=S_Cont_10>
	
<DIV class=vote style="border: 1px;">



<DIV class=vote-result>
<OL class=olist>
  <li>&nbsp;&nbsp;&nbsp;&nbsp;<H4>问题：${tt.tctitle }</H4></li>
  <li>${tt.tccontent }
  <li>&nbsp;&nbsp;&nbsp;&nbsp;<H4>投票结果 </H4></li>
  <LI class=t-header>
  <DIV class="d d-index">序号123111111111</DIV>
  <DIV class="d d-item thv">选项 </DIV>
  <DIV class="d d-prc thv">比例 </DIV>
  <DIV class="d d-num thv">票数</DIV> 
  </LI>
  
  <c:if test="${tpList.tcchooseone != ''}">
  <LI class=item>
  <DIV class="d d-tit"><SPAN class=num>1</SPAN> <SPAN 
  class=gd style="text-align: center;">${tt.tcchooseone } </SPAN></DIV>
  <DIV class="d d-prc">
  <DIV class=bar>
  <DIV class=precent style="WIDTH: 0%" precent="${tct.percente1}%">
  	<IMG height=13 alt=""   src="${pageContext.request.contextPath}/images/vote_cl_v2.png" width=149> 
  </DIV></DIV><SPAN class=precent-num>${tct.percente1}%</SPAN> </DIV>
  <DIV class="d d-num">${tct.tcchooseonecount } </DIV> <!-- 统计图表 begin -->
  <LI class=item-area id=from_69816_host 
  style="DISPLAY: none"><!-- 统计图表 end --></LI>
  </c:if>
  
  <c:if test="${tpList.tcchoosetwo != ''}">
  <LI class=item>
  <DIV class="d d-tit"><SPAN class=num>2</SPAN> <SPAN 
  class=gd style="text-align: center;">${tt.tcchoosetwo } </SPAN></DIV>
  <DIV class="d d-prc">
  <DIV class=bar>
  <DIV class=precent style="WIDTH: 0%" precent="${tct.percente2}%"><IMG height=13 alt="" 
  src="${pageContext.request.contextPath}/images/vote_cl_v2.png" width=149> 
  </DIV></DIV><SPAN class=precent-num>${tct.percente2}%</SPAN> </DIV>
  <DIV class="d d-num">${tct.tcchoosetwocount } </DIV> <!-- 统计图表 begin -->
  <LI class=item-area id=from_69815_host 
  style="DISPLAY: none"><!-- 统计图表 end --></LI>
  </c:if>
  
  <c:if test="${tpList.tcchoosethree != ''}">
  <LI class=item>
  <DIV class="d d-tit"><SPAN class=num>3</SPAN> <SPAN 
  class=gd style="text-align: center;">${tt.tcchoosethree } </SPAN></DIV>
  <DIV class="d d-prc">
  <DIV class=bar>
  <DIV class=precent style="WIDTH: 0%" precent="${tct.percente3}%"><IMG height=13 alt="" 
  src="${pageContext.request.contextPath}/images/vote_cl_v2.png" width=149> 
  </DIV></DIV><SPAN class=precent-num>${tct.percente3}%</SPAN> </DIV>
  <DIV class="d d-num">${tct.tcchoosethreecount } </DIV> <!-- 统计图表 begin -->
  <LI class=item-area id=from_69815_host 
  style="DISPLAY: none"><!-- 统计图表 end --></LI>
  </c:if>
  
  <c:if test="${tpList.tcchoosefour != ''}">
  <LI class="item last">
  <DIV class="d d-tit"><SPAN class=num>4</SPAN> 
  <SPAN class=gd style="text-align: center;">
	${tt.tcchoosefour } 
</SPAN></DIV>
  <DIV class="d d-prc">
  <DIV class=bar>
  <DIV class=precent style="WIDTH: 0%" precent="${tct.percente4}%"><IMG height=13 alt="" 
  src="${pageContext.request.contextPath}/images/vote_cl_v2.png" width=149> 
  </DIV></DIV><SPAN class=precent-num>${tct.percente4}%</SPAN> </DIV>
  <DIV class="d d-num">${tct.tcchoosefourcount }</DIV> <!-- 统计图表 begin --></LI>
  </c:if>
  
  <LI class=item-area id=from_69817_host 
  style="DISPLAY: none"><!-- 统计图表 end --></LI></OL></DIV></DIV></DIV><br> 
  <!-- 表格 end --><!-- data end begin --><!-- data end begin -->
  <center><input icon="icon-back" type="button" name="next" value="返  回"  onclick="goBack();" ></center>
  </BODY>
  <script>
	  function goBack(){
		  var p = "${p}";
		  if(p=="list"){
	  		  window.location="${pageContext.request.contextPath}/common/ticket.do?method=getMoreTicket";
		  }else{
			  window.history.back();
		  }
	  }
  </script>
  </HTML>

