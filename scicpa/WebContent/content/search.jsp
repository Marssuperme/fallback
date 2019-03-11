<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>

<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>录入防伪编号</title>
<style>
	.left{
		text-align: left;
		border: 0px,0px,0px,0px;
	}
	.right{
		text-align: right;
		border: 0px,0px,0px,0px;
	}
	a:HOVER {
		text-decoration: underline;
	}
</style>
 
</head>
<body>
<div id="divBlock" style="position:absolute;width:100%;height:100%; z-index:0; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;"></div>
<form action="" method="post" name="myform" id="myform"> 
	<input type="hidden" id="bh" name="bh" value="${ct.bbbh}">
	<input type="hidden" id="guid" name="guid" value="${ct.guid}">
	<input type="hidden" id="bbstate" name="bbstate" value="${ct.bbstate}">
	<input type="hidden" id="p" name="p" value="${search }">
	<input type="hidden" id="ip" name="ip" value="${pageContext.request.remoteAddr }"  >
	<input type="hidden" id="time" name="time" value="${time}"  >
	<input type="hidden" id="time2" name="time2" value=""  >
	<input type="hidden" id="count" name="count" value="${count}"  >
	
	<input type="hidden" id="yzje_db" name="yzje_db" value="${map_field.yzje}" >
	<input type="hidden" id="zcze_db" name="zcze_db" value="${map_field.zcze}" >
	<input type="hidden" id="xssr_db" name="xssr_db" value="${map_field.xssr}" >
	<input type="hidden" id="xssr_db" name="zxsjje_db" value="${map_field.zxsjje}" >
	<input type="hidden" id="yysr_db" name="yysr_db" value="${map_field.yysr}" >
	<input type="hidden" id="zczb_db" name="zczb_db" value="${ct.bsdwzczb}" >
	
	<div id="ywszd" style="position:absolute;width:500px;height:100px; z-index:0;left:expression((document.body.clientWidth-530)/2);top:expression(this.offsetParent.scrollTop + 100); border:1px solid #6595d6; padding:1px; background:#ffffff; display: none;">
	    <br><br>
	    <table>
	    	<tr>
	    		<td width="35%" align="right"><font style="font-size: 15;margin-left: 5%" color="red">业务所在地：</font></td>  
	    		<td width="30%"><input id="ywarea" name="ywarea" title="业务所在地" onfocus="onPopDivClick(this);" 
   					autoWidth=190
   					autoHeight=180
					onkeydown="onKeyDownEvent();"
					onkeyup="onKeyUpEvent();"
					onclick="onPopDivClick(this);"
					autoid=40 >
				</td>
				<td align="center" width="35%"><input type="button" icon="icon-query" value="确  定" onclick="f_sure()"></td>
			</tr>
		</table>
    </div>
	 		<center>
	 			<div id="num">
		 			<table style="margin-top: 30px;">
		 				<tr>
		 					<td>
						    	<font style="font-size: 15" color="red">防伪编号：</font>  
						    	<input id="bbhm" name="bbhm" value="${ct.bbbh }" title="防伪编号" size="30">&nbsp;&nbsp;
						    </td>
						   
						    <td>
						    	<input type="button" icon="icon-query" value="查  询" onclick="f_search()">&nbsp;&nbsp;
						    	<!-- 
						    		<span style="display: none;" id="dis0" ><input type="button" icon="icon-print" value="打  印" onclick="print()"></span>
						    	 -->
						    	<input type="button" icon="icon-delete" value="关  闭" onclick="window.close();">
						    </td>
				    	</tr>
					 </table>  	
			    </div>
		
			    <div id="dis1" style="margin-top: 20px;display: none;">
					<table id="table0" cellSpacing="0" cellPadding="5" width="100%" border="1px">
						<tr>
							<td colspan="2" align="center" style="background-color: #e8f7fc ! important">
								&nbsp;&nbsp;&nbsp;
								<font style="font-size: 20; ">
									四川省注册会计师协会报告防伪报备查询系统
								</font>
							</td>
						</tr>
						<tr>
							<td class="right" width="50%" >被审（验）单位名称：</td>
							<td class="left" width="50%" >${ct.bsdwmc}</td>
						</tr>
						<tr>
							<td class="right" >委托项目：</td>
							<td class="left">${ct.wtxmlx}</td>
						</tr>
						<tr>
							<td class="right" >防伪号码：</td>
							<td class="left">${ct.bbbh}</td>
						</tr>
						<tr>
							<td class="right" >报告文号：</td>
							<td class="left">${ct.bgwh}</td>
						</tr>
						<tr>
							<td class="right" >报告日期：</td>
							<td class="left">${ct.bgrq}</td>
						</tr>
						<tr>
							<td class="right" >
								事务所名称：
							</td>
							<td class="left">
								<a href="###" onclick= "window.open('${pageContext.request.contextPath}/common/content.do?method=goCompanyInfo&baobei=baobei&name=k_company&id=${ct.bbperson }')">${clt.companyName}</a>&nbsp;&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
						<!-- 
						<tr>
							<td class="right" >
								等级评价：
							</td>
							<td class="left">
								${ranking}
							</td>
						</tr>
						 -->
						<c:if test="${ct.qmzs1!='' && ct.qmzs1!=null}">
						<tr>
							<c:if test="${officeType=='事务所' }">
								<td class="right" >签名注师一</td>
								<td class="left">
									<a href="###" onclick="window.open('${pageContext.request.contextPath}/common/content.do?method=micfoBaoBei&baobei=baobei&id=${ct.cpa1 }&name=k_micfo')">${ct.qmzs1}</a>&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</c:if>
							<c:if test="${officeType=='评估所' }">
								<td class="right" >签名评估师一</td>
								<td class="left">
									<a href="###" onclick="window.open('${pageContext.request.contextPath}/common/content.do?method=micfoBaoBei&baobei=baobei&id=${ct.cpa1 }&name=k_assesser')">${ct.qmzs1}</a>&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</c:if>
						</tr>
						 </c:if>
						 <c:if test="${ct.qmzs2!='' && ct.qmzs2!=null}">
						<tr>
							<c:if test="${officeType=='事务所' }">
								<td class="right" >签名注师二</td>
								<td class="left">
									<a href="###" onclick="window.open('${pageContext.request.contextPath}/common/content.do?method=micfoBaoBei&baobei=baobei&id=${ct.cpa2 }&name=k_micfo')">${ct.qmzs2}</a>&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</c:if>
							<c:if test="${officeType=='评估所' }">
								<td class="right" >签名评估师二</td>
								<td class="left">
									<a href="###" onclick="window.open('${pageContext.request.contextPath}/common/content.do?method=micfoBaoBei&baobei=baobei&id=${ct.cpa2 }&name=k_assesser')">${ct.qmzs2}</a>&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</c:if>
						</tr>
						</c:if>
						<c:if test="${ct.qmzs3!='' && ct.qmzs3!=null}">
						<tr>
							<c:if test="${officeType=='事务所' }">
								<td class="right" >签名注师三</td>
								<td class="left">
									<a href="###" onclick="window.open('${pageContext.request.contextPath}/common/content.do?method=micfoBaoBei&baobei=baobei&id=${ct.cpa3 }&name=k_micfo')">${ct.qmzs3}</a>&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</c:if>
							<c:if test="${officeType=='评估所' }">
								<td class="right" >签名评估师三</td>
								<td class="left">
									<a href="###" onclick="window.open('${pageContext.request.contextPath}/common/content.do?method=micfoBaoBei&baobei=baobei&id=${ct.cpa3 }&name=k_assesser')">${ct.qmzs3}</a>&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</c:if>
						</tr>
						 </c:if>
						 <c:if test="${ct.qmzs4!='' && ct.qmzs4!=null}">
						<tr>
							<c:if test="${officeType=='事务所' }">
								<td class="right" >签名注师四</td>
								<td class="left">
									<a href="###" onclick="window.open('${pageContext.request.contextPath}/common/content.do?method=micfoBaoBei&baobei=baobei&id=${ct.cpa4 }&name=k_micfo')">${ct.qmzs4}</a>&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</c:if>
							<c:if test="${officeType=='评估所' }">
								<td class="right" >签名评估师四</td>
								<td class="left">
									<a href="###" onclick="window.open('${pageContext.request.contextPath}/common/content.do?method=micfoBaoBei&baobei=baobei&id=${ct.cpa4 }&name=k_assesser')">${ct.qmzs4}</a>&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</c:if>
						</tr>
						</c:if>
						<c:if test="${ct.qmzs5!='' && ct.qmzs5!=null}">
						<tr>
							<c:if test="${officeType=='事务所' }">
								<td class="right" >签名注师五</td>
								<td class="left">
									<a href="###" onclick="window.open('${pageContext.request.contextPath}/common/content.do?method=micfoBaoBei&baobei=baobei&id=${ct.cpa5 }&name=k_micfo')">${ct.qmzs5}</a>&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</c:if>
							<c:if test="${officeType=='评估所' }">
								<td class="right" >签名评估师五</td>
								<td class="left">
									<a href="###" onclick="window.open('${pageContext.request.contextPath}/common/content.do?method=micfoBaoBei&baobei=baobei&id=${ct.cpa5 }&name=k_assesser')">${ct.qmzs5}</a>&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</c:if>
						</tr>
						 </c:if>
						 <c:if test="${ct.qmzs6!='' && ct.qmzs6!=null}">
						<tr>
							<c:if test="${officeType=='事务所' }">
								<td class="right" >签名注师六</td>
								<td class="left">
									<a href="###" onclick="window.open('${pageContext.request.contextPath}/common/content.do?method=micfoBaoBei&baobei=baobei&id=${ct.cpa6 }&name=k_micfo')">${ct.qmzs6}</a>&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</c:if>
							<c:if test="${officeType=='评估所' }">
								<td class="right" >签名评估师六</td>
								<td class="left">
									<a href="###" onclick="window.open('${pageContext.request.contextPath}/common/content.do?method=micfoBaoBei&baobei=baobei&id=${ct.cpa6 }&name=k_assesser')">${ct.qmzs6}</a>&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</c:if>
						</tr>
						</c:if>
						<tr>
							<td class="right" >报备状态：</td>
							<td class="left">${ct.bbstate}</td>
						</tr>
					</table>
				</div>
				<br />
				<div id="dis2" style="text-align: center;display: none;">
					<pre>   四川省注册会计师协会  版权所有  
          广州铭太信息科技有限公司 承建        
维护电话：020-38378976</pre>
				</div>
			 <c:if test="${search!='noInfo' && search!='repeat' && search!='notValidState' }">
				 <c:if test="${ct.typeid=='ccsssqkcjj001' || ct.typeid=='swdl001' || ct.typeid=='kjdsh001' || ct.typeid=='kjzs001' || ct.typeid=='sdshsqj001' || ct.typeid=='qtssjj001' || ct.typeid=='zcpg001' || ct.typeid=='bbqt001' }">
					<table id="valid_tab" style="width: 380px;">
		 				<tr>
		 					<td align="center" width="50%"><font color="red">注册资本/开办资金</font></td>
		 				</tr>
		 				<tr>
						    <td align="center">
						    	<input id="zczb" name="zczb" value="" style="height: 0px;" onkeyup="f_moneys(this);" onpaste="return false">&nbsp;&nbsp;元
						    </td>
						</tr>
						<tr>
							<td align="center">
						    	<input type="button" icon="icon-edit" value="验  证" onclick="f_checkMoney('zczb') ">
						    </td>
				    	</tr>
					 </table>
				</c:if>
		 	
			 	<c:if test="${ct.typeid=='yz001'}">
					<table id="valid_tab" style="width: 380px;">
		 				<tr>
		 					<td align="center" width="50%"><font color="red">验资金额</font></td>
		 					<td align="center" width="50%"><font color="red">注册资本/开办资金</font></td>
		 				</tr>
		 				<tr>
						    <td align="center">
						    	<input id="yzje" name="yzje" value="" style="height: 0px;" onkeyup="f_moneys(this);" onpaste="return false">&nbsp;&nbsp;元
						    </td>
						    <td align="center">
						    	<input id="zczb" name="zczb" value="" style="height: 0px;" onkeyup="f_moneys(this);" onpaste="return false">&nbsp;&nbsp;元
						    </td>
						</tr>
						<tr>
						    <td align="center">
						    	<input type="button" icon="icon-edit" value="验  证" onclick="f_checkMoney('yzje') ">
						    </td>
						    <td align="center">
						    	<input type="button" icon="icon-edit" value="验  证" onclick="f_checkMoney('zczb') ">
						    </td>
				    	</tr>
					 </table>
				</c:if>
				<c:if test="${ct.typeid=='sj001'}">
					 <table id="valid_tab" style="width: 60%;">
		 				<tr>
		 					<td align="center" width="25%"><font color="red">资产总额</font></td>
		 					<td align="center" width="25%"><font color="red">营业收入</font></td>
		 					<td align="center" width="25%"><font color="red">专项审计金额</font></td>
		 					<td align="center" width="25%"><font color="red">注册资本/开办资金</font></td>
		 				</tr>
		 				<tr>
						    <td align="center">
						    	<input id="zcze" name="zcze" value="" style="height: 0px;" onkeyup="f_moneys(this);" onpaste="return false">&nbsp;&nbsp;元
						    </td>
					    	<td align="center">
						    	<input id="yysr" name="yysr" value="" style="height: 0px;" onkeyup="f_moneys(this);" onpaste="return false">&nbsp;&nbsp;元
					    	</td>
						    <td align="center">
						    	<input id="zxsjje" name="zxsjje" value="" style="height: 0px;" onkeyup="f_moneys(this);" onpaste="return false">&nbsp;&nbsp;元
					    	</td>
					    	<td align="center">
						    	<input id="zczb" name="zczb" value="" style="height: 0px;" onkeyup="f_moneys(this);" onpaste="return false">&nbsp;&nbsp;元
						    </td>
						</tr>
						<tr>
						    <td align="center">
						    	<input type="button" icon="icon-edit" value="验  证" onclick="f_checkMoney('zcze') ">
						    </td>
						    <td align="center">
						    	<input type="button" icon="icon-edit" value="验  证" onclick="f_checkMoney('yysr') ">
						    </td>
						    <td align="center">
						    	<input type="button" icon="icon-edit" value="验  证" onclick="f_checkMoney('zxsjje') ">
						    </td>
						    <td align="center">
						    	<input type="button" icon="icon-edit" value="验  证" onclick="f_checkMoney('zczb') ">
						    </td>
				    	</tr>
					 </table>
				</c:if>
				<c:if test="${ct.typeid=='whnj001'}">
					 <table id="valid_tab" style="width: 60%;">
		 				<tr>
		 					<td align="center" width="25%"><font color="red">资产总额</font></td>
		 					<td align="center" width="25%"><font color="red">注册资本/开办资金</font></td>
		 				</tr>
		 				<tr>
						    <td align="center">
						    	<input id="zcze" name="zcze" value="" style="height: 0px;" onkeyup="f_moneys(this);" onpaste="return false">&nbsp;&nbsp;元
						    </td>
					    	<td align="center">
						    	<input id="zczb" name="zczb" value="" style="height: 0px;" onkeyup="f_moneys(this);" onpaste="return false">&nbsp;&nbsp;元
						    </td>
						</tr>
						<tr>
						    <td align="center">
						    	<input type="button" icon="icon-edit" value="验  证" onclick="f_checkMoney('zcze') ">
						    </td>
						    <td align="center">
						    	<input type="button" icon="icon-edit" value="验  证" onclick="f_checkMoney('zczb') ">
						    </td>
				    	</tr>
					 </table>
				</c:if>
				<c:if test="${ct.typeid=='qssh001'}">
					 <table id="valid_tab" style="width: 60%;">
		 				<tr>
		 					<td align="center" width="25%"><font color="red">资产总额</font></td>
		 					<td align="center" width="25%"><font color="red">营业收入</font></td>
		 					<td align="center" width="25%"><font color="red">注册资本/开办资金</font></td>
		 				</tr>
		 				<tr>
						    <td align="center">
						    	<input id="zcze" name="zcze" value="" style="height: 0px;" onkeyup="f_moneys(this);" onpaste="return false">&nbsp;&nbsp;元
						    </td>
						    <td align="center">
						    	<input id="yysr" name="yysr" value="" style="height: 0px;" onkeyup="f_moneys(this);" onpaste="return false">&nbsp;&nbsp;元
					    	</td>
					    	<td align="center">
						    	<input id="zczb" name="zczb" value="" style="height: 0px;" onkeyup="f_moneys(this);" onpaste="return false">&nbsp;&nbsp;元
						    </td>
						</tr>
						<tr>
						    <td align="center">
						    	<input type="button" icon="icon-edit" value="验  证" onclick="f_checkMoney('zcze') ">
						    </td>
						    <td align="center">
						    	<input type="button" icon="icon-edit" value="验  证" onclick="f_checkMoney('yysr') ">
						    </td>
						    <td align="center">
						    	<input type="button" icon="icon-edit" value="验  证" onclick="f_checkMoney('zczb') ">
						    </td>
				    	</tr>
					 </table>
				</c:if>
				<c:if test="${ct.typeid=='flsj001' || ct.typeid=='hbsj001' || ct.typeid=='qchz001' || ct.typeid=='sfkjjd001' }">
					 <table id="valid_tab" style="width: 60%;">
		 				<tr>
		 					<td align="center" width="25%"><font color="red">资产总额</font></td>
		 					<td align="center" width="25%"><font color="red">营业收入</font></td>
		 					<td align="center" width="25%"><font color="red">注册资本/开办资金</font></td>
		 				</tr>
		 				<tr>
						    <td align="center">
						    	<input id="zcze" name="zcze" value="" style="height: 0px;" onkeyup="f_moneys(this);" onpaste="return false">&nbsp;&nbsp;元
						    </td>
						    <td align="center">
						    	<input id="xssr" name="xssr" value="" style="height: 0px;" onkeyup="f_moneys(this);" onpaste="return false">&nbsp;&nbsp;元
					    	</td>
					    	<td align="center">
						    	<input id="zczb" name="zczb" value="" style="height: 0px;" onkeyup="f_moneys(this);" onpaste="return false">&nbsp;&nbsp;元
						    </td>
						</tr>
						<tr>
						    <td align="center">
						    	<input type="button" icon="icon-edit" value="验  证" onclick="f_checkMoney('zcze') ">
						    </td>
						    <td align="center">
						    	<input type="button" icon="icon-edit" value="验  证" onclick="f_checkMoney('xssr') ">
						    </td>
						    <td align="center">
						    	<input type="button" icon="icon-edit" value="验  证" onclick="f_checkMoney('zczb') ">
						    </td>
				    	</tr>
					 </table>
				</c:if>
			 </c:if>
    </center>
    <center>			
    	<div style="margin-top: 20px"><font color="red" style="font-size: 15">注意：如果审计年数为多年，只提供验证最近一年数据。
		</font></div>
    </center>
    	
</form>
</body>

<script>
	//报备日期
	var bbDate = "${ct.bgrq}";//朱汉强添加于20130118
	
	var guid = document.getElementById("guid").value;
	var p = document.getElementById("p").value;
	document.getElementById("ywarea").value = "";
	
	var bbstate = document.getElementById("bbstate").value;
	
	// 没有报备信息
	if(p=="noInfo"){
		alert("无相关信息!");
	}
	
	// 只录入了报备编号，但是记录重复
	if(p=="repeat"){
		alert("请填写业务所在地!");
		document.getElementById("ywszd").style.display = "";
		document.getElementById("divBlock").style.display = "";
	}
	
	// 报备信息状态 为非报备完成或者作废的其他状态	
	if(p=="notValidState"){
		alert("无相关信息!");
	}
	
	// 正常报备信息
	if(p=="ok"){
		document.getElementById("ywszd").style.display = "none";
		document.getElementById("divBlock").style.display = "none";
		document.getElementById("dis1").style.display="";
		document.getElementById("dis2").style.display="";
	}
	
	// 防伪编号重复
	if(p=="repeatOk"){
		document.getElementById("ywszd").style.display = "none";
		document.getElementById("divBlock").style.display = "none";
		document.getElementById("dis1").style.display="";
		document.getElementById("dis2").style.display="";
	}
	
	
	
	function f_search(){
		var bbhm = document.getElementById("bbhm").value;
		if(bbhm=="" || bbhm==null){
			alert("请输入防伪号码！");
			return;
		}else{
			var oBao = new ActiveXObject("Microsoft.XMLHTTP");
			var url="${pageContext.request.contextPath}/common/content.do?method=getTimes";
			oBao.open("POST",url,false);     
			oBao.send();
			var resText = oBao.responseText;  
			if(resText*1<60000*1){
				alert("互联网报备查询请等待一分钟后再进行！");
			}else{
				document.myform.action="${pageContext.request.contextPath}/common/content.do?method=search";
				document.myform.submit();
			}
		}
	}
	
	function f_sure(){
		var bbhm = document.getElementById("bbhm").value;
		if(bbhm=="" || bbhm==null){
			alert("请输入防伪号码！");
			return;
		}else{
			document.myform.action="${pageContext.request.contextPath}/common/content.do?method=search";
			document.myform.submit();
		}
	}


	function print(){
		var guid = document.getElementById('guid').value ;
		if(guid==null || guid == ""){
			alert("无报备信息,打印无效！");
		}else{
			window.open("${pageContext.request.contextPath}/common/bb.do?method=print&guid="+guid);
		}
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
	
	// 检查金额
	function f_checkMoney(id){
	
		// 用户录入的金额
		var userMoney = document.getElementById(id).value;
		// 数据库金额
		var dbMoney = document.getElementById(id+"_db").value;
		
		if(userMoney == ""){
			document.getElementById(id).select();
			alert("请录入金额！");
			return;
		}
		
		dbMoney = Math.floor((dbMoney*10000).toFixed(5));//
		userMoney = Math.floor(userMoney);//
		
		//userMoney = getMoneyOfWan(userMoney);
		//dbMoney = getMoneyOfWan(dbMoney);
		
		if(userMoney == dbMoney){
			alert("验证相符！");
		}else{
			alert("验证不相符！");
			document.getElementById(id).select();
		}
	}
	
	
	// 得到金额的万位以上， 没有就返回 0
	function getMoneyOfWan(money){
		//money = money/10000;
		money = Math.floor(money);
		return money;
	}

	//如果报备内容为“作废”时，报务查询内容显红色
	var bbstate = "${ct.bbstate}";
	var table = document.getElementById("table0");
	var trs = table.getElementsByTagName("tr");
	if(bbstate=="作废"){
		for(i=0;i<trs.length;i++){
			trs[i].style.color="red";
		}
	}
</script>
</html>