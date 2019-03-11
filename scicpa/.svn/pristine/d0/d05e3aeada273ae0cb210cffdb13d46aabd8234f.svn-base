<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
<%@ include file="/Sys_INCLUDE/include.jsp" %>

<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<%@ taglib prefix="mt"   uri="http://www.matech.cn/tag" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="/Web/JS/jquery.tree.js" type="text/javascript" ></script>
<link rel="stylesheet" href="/Web/CSS/jquery.tree.css"/>

<style type="text/css">
	
	body {
		padding-left: 10px ;
		padding-right: 10px ;
		font-size: 12px ;
	}

	.formTitle {
	color: #4A74BC;
	font-weight: bold;
	font-size: 14px;
	text-align:center;
	width:100%;
	margin-top: 10px;
	}
	
	.tree {
		border: #c3daf9 1px solid;
		background:#fffcec;
		width: 20%; 
		height:600px;
		overflow:auto;
		float: left;
	} 
	
	.treeTitle {
		background:#e6f4d0 ;
		width:100%;
		height : 27px ;
		border:1px solid #e6f4d0;
		line-height: 27px ;
		color: #125908 ;
		font-size: 14px; 
		font-weight: bold;
		padding-left: 5px;
	}
	
	.gridFrame {
		width: 100%; 
		height:100%;
		border: #c3daf9 1px solid;
		float: left;
		margin-left: 5px ;
		padding: 5px ;
	}
	
	.tools {
		width:100% ;
		height:27px ;
		float:left;
		background-image: url("/Web/images/toolBarBg.gif");
		padding-top: 3px;
		padding-left:5px;
		margin-bottom: 5px;
	} 
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报备list</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css"/>
</head>
<body>
<div id="divBlock" style="position:absolute;width:100%;height:100%; z-index:0; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;"></div>
<form action="" method="post" name="myform" id="myform"> 
<input type="hidden" value="${typeid }" id="typeid" name="typeid">
<input type="hidden" value="${title }" id="title" name="title">
<input type="hidden" id="qmzscpa" name="qmzscpa" value="mh">
<input type="hidden" id="loginid" name="loginid" value="${userSession.userMap.loginid}">
	<div style="width:100%;">
	 	 
	    <div class="gridFrame">
		    <div class="tools" >
		    	<c:if test="${model=='tongji' }">
		    	&nbsp;<input icon="icon-back" type="button" onclick="back_list();" value="返回">
		    	</c:if>
		    	
		    	&nbsp;<input icon="icon-add" type="button" onclick="f_add();" value="增加">
		    	&nbsp;<input icon="icon-edit" type="button" onclick="f_update();" value="修改">
		    	&nbsp;<input icon="icon-delete" type="button" onclick="f_delete();" value="删除">
		    	<!-- 
		    	&nbsp;<input icon="icon-delete-row" type="button" onclick="f_cancle();" value="作废">
		    	 -->
		    	&nbsp;<input icon="icon-print" type="button" onclick="print();" value="封面打印">
		    	&nbsp;<input icon="icon-search" type="button" onclick="f_search();" value="搜索">
		    	&nbsp;<input icon="icon-excel" type="button" onclick="f_expExcel();" value="导出Excel">
		    	&nbsp;<input icon="icon-excel" type="button" onclick="f_inExcel();" value="导入Excel">
		    	&nbsp;<input icon="icon-method" type="button" onclick="f_downLoad();" value="批量报备模板下载">
		    	&nbsp;<input icon="icon-method" type="button" onclick="f_downLoadTable();" value="下载申请修改和作废表格">
		        <span style="border:0px solid red;width:500px;height:25px;"><font color="red" style="margin-bottom: 25px;">请用IE9及以下版本的浏览器登录【导出Excel】，并且不使用迅雷，请直接下载</font></span>
		       
		    </div>
			<div id="search" style="position:absolute;width:575px;height:400px; z-index:0;left:expression((document.body.clientWidth-575)/2);top:expression(this.offsetParent.scrollTop + 70); border:1px solid #6595d6; padding:1px; background:#ffffff; display: none;">
			    <br>
			    <fieldset  style="border: 1px solid lightblue;width:85%;height: 80%;margin-left: 2px;" id="fieldset">
					<legend>
						搜索条件
					</legend>
					<table width="90%" style="margin-left: 15px;">
						<tr align="left">
							<td>防&nbsp;&nbsp;&nbsp;&nbsp;伪&nbsp;&nbsp;&nbsp;编&nbsp;&nbsp;&nbsp;号：<input id="bbbh" name="bbbh" ></td>
							<td>项&nbsp;&nbsp;&nbsp;目&nbsp;&nbsp;&nbsp;&nbsp;名&nbsp;&nbsp;&nbsp;称：<input id="xmmc" name="xmmc" style="height: 0px;"></td>
						</tr>
						<tr align="left">
							<td>委&nbsp;&nbsp;&nbsp;&nbsp;托&nbsp;&nbsp;&nbsp;单&nbsp;&nbsp;&nbsp;位：<input id="wtdw" name="wtdw"  style="height: 0px;" onfocus="onPopDivClick(this);" 
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												norestorehint=true
												autoid=30
												
												refer="loginid"
												hideresult=true >
							</td>
							<td>被审&nbsp;( 验)&nbsp;单位：<input id="bsydw" name="bsydw"  style="height: 0px;" onfocus="onPopDivClick(this);" 
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												norestorehint=true
												autoid=31
												
												refer="loginid"
												hideresult=true >
							</td>
						</tr>	
						
						<tr align="left">
							<td>客户出资&nbsp;类&nbsp;型：<input id="khczlx" name="khczlx"  style="height: 0px;" onfocus="onPopDivClick(this);" 
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												norestorehint=true
												noinput=true
												autoid=4
												hideresult=true></td>
							<td>客户&nbsp;经济&nbsp;性质：<input id="khjjxz" name="khjjxz" style="height: 0px;" onfocus="onPopDivClick(this);"
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												norestorehint=true
												autoid=11
												noinput=true
												hideresult=true></td>
						</tr>
						
						<tr align="left">
							<td>客户行业&nbsp;类&nbsp;型：<input id="khhylx" name="khhylx"  style="height: 0px;" onfocus="onPopDivClick(this);"
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												norestorehint=true
												autoid=55
												noinput=true
												refer="dic_kmhylx"
												hideresult=true></td>
							<td>是否&nbsp;上市&nbsp;企业：<input id="sfssqy" name="sfssqy" onfocus="onPopDivClick(this);"
						    					autoWidth=190
						    					autoHeight=180
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												norestorehint=true
												autoid=13
												noinput=true
												hideresult=true></td>
						</tr>
						
						<tr align="left">
							<c:if test="${typeid=='yz001'}">
								<td>验&nbsp;&nbsp;&nbsp;&nbsp;资&nbsp;&nbsp;&nbsp;期&nbsp;&nbsp;&nbsp;间：<input id="bgnd" name="bgnd" ></td>
							</c:if>
							<c:if test="${typeid!='yz001'}">
								<td>报&nbsp;&nbsp;&nbsp;&nbsp;表&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;度：<input id="bgnd" name="bgnd" ></td>
							</c:if>
							<td>
								<c:choose>
									<c:when test="${typeid=='yz001' || typeid=='sj001' || typeid=='sdshsqj001' || typeid=='ccsssqkcjj001' || typeid=='qssh001' || typeid=='qtssjj001'}">
										报告&nbsp;意见&nbsp;类型：<input id="bgyjlx" name="bgyjlx" onfocus="onPopDivClick(this);"
									    					autoWidth=180
									    					autoHeight=180
															onkeydown="onKeyDownEvent();"
															onkeyup="onKeyUpEvent();"
															onclick="onPopDivClick(this);"
															norestorehint=true
															noinput=true
															autoid=7
															hideresult=true style="height: 0px;">
									</c:when>
									<c:otherwise>
										报告&nbsp;意见&nbsp;类型：<input id="bgyjlx" name="bgyjlx" style="background-color: #F0F0F0;border: 1px solid #d0d0d0" disabled="disabled">
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						
						<tr align="left">
							<td>报&nbsp;&nbsp;&nbsp;&nbsp;告&nbsp;&nbsp;&nbsp;文&nbsp;&nbsp;&nbsp;号：<input id="bgwh" name="bgwh" ></td>
							<td>业务&nbsp;约定书&nbsp;号：<input id="ywyds" name="ywyds" style="height: 0px;"></td>
						</tr>
						
						<tr align="left">
							<td>报&nbsp;&nbsp;&nbsp;备&nbsp;&nbsp;&nbsp;&nbsp;状&nbsp;&nbsp;&nbsp;态：<input id="bbstate" name="bbstate" autoWidth=190
			    					autoHeight=180
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=55
									noinput=true
									refer="bbzt" >
							</td>
							<td>业&nbsp;&nbsp;务&nbsp;&nbsp;所&nbsp;在&nbsp;地：<input id="ywarea" name="ywarea" autoWidth=190
			    					autoHeight=180
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									
									autoid=10 >
							</td>
						</tr>
						
						<tr align="left">
							<td><input type="radio" id="mh" name="mh" value="mh" checked="checked" onclick="f_display(this)">
								&nbsp;签名注师模糊查询&nbsp;&nbsp;
								<input type="radio" id="dw" name="mh" value="dw" onclick="f_display(this)">&nbsp;签名注师定位查询
							</td>
							<td><font color="#FF0000">&nbsp;( 支持手动录入&nbsp;cpa&nbsp;编号进行查询 )</font></td>
						</tr>
						
						<tr align="left" id="sigle">
							<td>
								签&nbsp;名&nbsp;注&nbsp;师/&nbsp;cpa：<input maxlength="50" title="签名注师" size="20" name="qmzs" id="qmzs" onfocus="onPopDivClick(this);"
			    					autoWidth=190
									autoHeight=180
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									norestorehint=true
									autoid=50
									refer = "${userSession.userMap.officecode }"
									hideresult=true >
							</td>
							<td></td>
						</tr>
						
						<tr align="left" id="double1" style="display: none">
							<td>
								签名注师1/cpa1：<input maxlength="50" title="签名注师1" size="20" name="qmzs1" id="qmzs1" onfocus="onPopDivClick(this);"
			    					autoWidth=190
									autoHeight=180
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									norestorehint=true
									autoid=50
									refer = "${userSession.userMap.officecode }"
									hideresult=true >
							</td>
							<td>
								签名注师2/cpa2：<input maxlength="50" title="签名注师2" size="20" name="qmzs2" id="qmzs2" onfocus="onPopDivClick(this);"
			    					autoWidth=190
									autoHeight=180
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									norestorehint=true
									autoid=50
									refer = "${userSession.userMap.officecode }"
									hideresult=true >
							</td>
						</tr>
						
						<tr align="left" id="double2" style="display: none">
							<td>
								签名注师3/cpa3：<input maxlength="50" title="签名注师3" size="20" name="qmzs3" id="qmzs3" onfocus="onPopDivClick(this);"
			    					autoWidth=190
									autoHeight=180
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									norestorehint=true
									autoid=50
									refer = "${userSession.userMap.officecode }"
									hideresult=true >
							</td>
							<td>
								签名注师4/cpa4：<input maxlength="50" title="签名注师4" size="20" name="qmzs4" id="qmzs4" onfocus="onPopDivClick(this);"
			    					autoWidth=190
									autoHeight=180
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									norestorehint=true
									autoid=50
									refer = "${userSession.userMap.officecode }"
									hideresult=true >
							</td>
						</tr>
						
						<tr align="left" id="double3" style="display: none">
							<td>
								签名注师5/cpa5：<input maxlength="50" title="签名注师5" size="20" name="qmzs5" id="qmzs5" onfocus="onPopDivClick(this);"
			    					autoWidth=190
									autoHeight=180
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									norestorehint=true
									autoid=50
									refer = "${userSession.userMap.officecode }"
									hideresult=true >
							</td>
							<td>
								签名注师6/cpa6：<input maxlength="50" title="签名注师6" size="20" name="qmzs6" id="qmzs6" onfocus="onPopDivClick(this);"
			    					autoWidth=190
									autoHeight=180
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									norestorehint=true
									autoid=50
									refer = "${userSession.userMap.officecode }"
									hideresult=true >
							</td>
						</tr>
						
						<tr align="left">
							<td>应&nbsp;&nbsp;收&nbsp;&nbsp;&nbsp;业&nbsp;务&nbsp;费：<input id="ysywf0" name="ysywf1" onkeyup="isDigit(this)"></td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input id="ysywf" name="ysywf2" onkeyup="isDigit(this)">
							</td>
						</tr>
						
						<tr align="left">
							<td>已&nbsp;&nbsp;收&nbsp;&nbsp;&nbsp;业&nbsp;务&nbsp;费：<input id="ysywfed0" name="ysywfed1" onkeyup="isDigit(this)"></td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input id="ysywfed" name="ysywfed2" onkeyup="isDigit(this)">
							</td>
						</tr>
						
						<tr align="left">
							<td>报&nbsp;&nbsp;&nbsp;&nbsp;备&nbsp;&nbsp;&nbsp;&nbsp;时&nbsp;&nbsp;&nbsp;间：<input id="bbtime0" name="bbtime1" showcalendar="true" class="time"></td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input id="bbtime" name="bbtime2" showcalendar="true" class="time">
							</td>
						</tr>
						
						<tr align="left">
							<td>报&nbsp;&nbsp;&nbsp;&nbsp;告&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;&nbsp;期：<input id="bgrq0" name="bgrq1" showcalendar="true" class="time"></td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input id="bgrq" name="bgrq2" showcalendar="true" class="time">
							</td>
						</tr>
						
					</table>
					<br>
					<table width="90%" style="margin-left: 25%;">
						<tr>
							<td>
								<input icon="icon-success" type="button" onclick="f_sure();" value="确定">
						    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input icon="icon-retry" type="button" onclick="f_clear();" value="清空">
						    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	<input icon="icon-delete" type="button" onclick="f_quxiao();" value="取消">
						    </td>
						</tr>
			    	</table>
				</fieldset>
			</div>
			
		    <br> 
		    <div style="width:100%;overflow:scroll;height:100%px;"> 
		    	<mt:DataGridPrintByBean name="${typeid}"/>
		    	<br> 
		    </div>
		</div>
		
	</div>
</form>


<form action="" method="post" name="myform1" id="myform1"> 
	<input type="hidden" value="${typeid }" id="typeid" name="typeid">
	<input type="hidden" value="${title }" id="title" name="title">
	<input type="hidden" id="qmzscpa" name="qmzscpa" value="mh">
	<input type="hidden" id="loginid" name="loginid" value="${userSession.userMap.loginid}">
</form>

<form action="${pageContext.request.contextPath}/common/common.do?method=expExcel" method="post" name="exform1" id="exform1">
	<input type="hidden" id="expTableID_${typeid}" name="expTableID" value="" />
	<input type="hidden" id="expSql_${typeid}" name="expSql" value="" />
	<input type="hidden" id="expDisplayColName_${typeid}" name="expDisplayColName" value="" />
	<input type="hidden" id="expColName_${typeid}" name="expColName" value="" />
	<input type="hidden" id="fileName_${typeid}" name="fileName" value="" />
</form>

</body>

<script>

	// 只是添加完成之后提示。注意传过来的参数变量名
	var guid="${bbnum}";
	if(guid!="" && guid!=null){
		var state = f_getStateByGuid(guid);
		if(state=="wanch" || state=="ccbb"){
			if(confirm("报备成功，是否立刻打印封面？"))
			{
				var typeid="${typeid}";
				window.open("${pageContext.request.contextPath}/common/bb.do?method=print&guid="+guid+"&typeid="+typeid);
			}
		}
		if(state=="sqsh"){
			//alert("已申请审核，请等待注协审核（电话：020-83063583、83063578，传真：020-83053575）。")
			alert("已经提交注协。");
		}
	}	



	
	// 查看是否审核
	function isReviewed(){
		var chooseValue = document.getElementById("chooseValue_${typeid}").value ;
		var oBao = new ActiveXObject("Microsoft.XMLHTTP");
		var url="${pageContext.request.contextPath}/common/content.do?method=viewIsReviewed&ctguid="+chooseValue;
		oBao.open("POST",url,false);    
		oBao.send();

    	var resText = oBao.responseText;  
		if(resText=="true"){
			return "Y";
		}else{
			return "N";
		}
	}


	// 根据 guid 查看报备状态
	function f_getStateByGuid(guid){
		var chooseValue = guid;
		var oBao = new ActiveXObject("Microsoft.XMLHTTP");
		var url="${pageContext.request.contextPath}/common/content.do?method=getStateByGuid&ctguid="+chooseValue;
		oBao.open("POST",url,false);     
		oBao.send();

    	var resText = oBao.responseText;  
		return resText; 
	}

	// 更加报备编号查看报备状态
	
	function f_getStateByBbbh(bbnum){
		var chooseValue = bbnum ;
		var oBao = new ActiveXObject("Microsoft.XMLHTTP");
		var url="${pageContext.request.contextPath}/common/content.do?method=getStateByBbbh&bbbh="+chooseValue;
		oBao.open("POST",url,false);     
		oBao.send();

    	var resText = oBao.responseText;
		return resText; 
	}
	
	 
	// 添加
	function f_add(){
		var typeid = "${typeid}";
		
		var loginid = document.getElementById("loginid").value;
		var chooseValue = loginid ;
		var oBao = new ActiveXObject("Microsoft.XMLHTTP");
		var url="${pageContext.request.contextPath}/common/content.do?method=getCompanyCanReport&loginid="+chooseValue;
		oBao.open("POST",url,false);     
		oBao.send();

    	var resText = oBao.responseText;
		
		if(resText=="Y"){
			document.myform1.action = "${pageContext.request.contextPath}/common/bb.do?method=addAndEdit&param=add";
			document.myform1.submit();
		}else{
			alert("贵所报备功能已被暂停，请与省注协联系。联系电话：028-85316767");
			return;
		} 
	}

	// 修改
	function f_update(){
		
		var model='${model}';
		var chooseValue = document.getElementById("chooseValue_${typeid}").value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要修改的记录!");
		}else{
			// 检查选中记录否改所前旧记录，如旧的不能修改20130313修改
			var oBaos = new ActiveXObject("Microsoft.XMLHTTP");
			var url="${pageContext.request.contextPath}/common/bb.do?method=checkIsOldRecord&GUID="+chooseValue+"&model="+model;
			oBaos.open("POST",url,false);     
			oBaos.send();	
	    	var resText = oBaos.responseText; 
			if(resText=="NO"){
				alert("该记录为改制前的数据，不能修改或删除！");
				return;
			}else if(resText!="OK"){
				alert("操作超时，请重新登录！");
				return;
			}			
			
	    	var resText = f_getStateByGuid(chooseValue);  
			if(resText=="zuofei"){
				alert("已作废状态了，不能再修改!");
				return false;
			}else if(resText=="zancun" || resText=="sqsh" || resText=="shwtg"){
				document.myform1.action = "${pageContext.request.contextPath}/common/bb.do?method=addAndEdit&GUID="+chooseValue+"&param=update";
				document.myform1.submit();
			}else{
				// 报备 一个月后只能 修改  已收业务费
				var oBaos = new ActiveXObject("Microsoft.XMLHTTP");
				var url="${pageContext.request.contextPath}/common/content.do?method=getDays&ctguid="+chooseValue;
				oBaos.open("POST",url,false);     
				oBaos.send();
		
		    	var resText = oBaos.responseText;  
				if(resText=="yes"){
					document.myform1.action = "${pageContext.request.contextPath}/common/bb.do?method=addAndEdit&GUID="+chooseValue+"&param=update";
					document.myform1.submit();
				}else{
					// 只能修改 已收业务费用 
					document.myform1.action = "${pageContext.request.contextPath}/common/bb.do?method=addAndEdit&GUID="+chooseValue+"&param=update&updatemoney=updatemoney";
					document.myform1.submit();
				}
			}
		}
	}
	
	// 删除
	function f_delete(){
		var chooseValue = document.getElementById("chooseValue_${typeid}").value ;
		var p = f_getStateByGuid(chooseValue);
		if(p!="zancun" && p!="sqsh" && p!="cstg" && p!="shtg" && p!="shwtg" ){
			alert("该报备处于非【暂存状态、申请审核、初审通过、审核通过、审核未通过】状态，不能删除！");
			return false;
		}else{
			if(chooseValue==null || chooseValue==""){
				alert("请选择要删除的记录!");
			}else{
				
				// 检查选中记录否改所前旧记录，如旧的不能修改20130313修改
				var oBaos = new ActiveXObject("Microsoft.XMLHTTP");
				var url="${pageContext.request.contextPath}/common/bb.do?method=checkIsOldRecord&GUID="+chooseValue;
				oBaos.open("POST",url,false);     
				oBaos.send();	
		    	var resText = oBaos.responseText; 
		    	if(resText=="NO"){
					alert("该记录为改制前的数据，不能修改或删除！");
					return;
				}else if(resText!="OK"){
					alert("操作超时，请重新登录！");
					return;
				}			
				
				if(confirm("确定要删除吗？")){
					myform1.action = "${pageContext.request.contextPath}/common/bb.do?method=delete&GUID="+chooseValue;
					myform1.submit();
				}
			}
		}
	}
	
	//原点击查看功能增加为修改功能2013-04-12
	
	function lookForUpdate(guid,companyguid){
		
		var chooseValue = guid ;
		
			// 检查选中记录否改所前旧记录，如旧的不能修改20130313修改
			var oBaos = new ActiveXObject("Microsoft.XMLHTTP");
			var url="${pageContext.request.contextPath}/common/bb.do?method=checkIsOldRecord&GUID="+chooseValue;
			oBaos.open("POST",url,false);     
			oBaos.send();	
	    	var resText = oBaos.responseText; 
			if(resText=="NO"){
				alert("该记录为改制前的数据，不能修改或删除！");
				return;
			}else if(resText!="OK"){
				alert("操作超时，请重新登录！");
				return;
			}			
			
	    	var resText = f_getStateByGuid(chooseValue);  
			if(resText=="zuofei"){
				alert("已作废状态了，不能再修改!");
				return false;
			}else if(resText=="zancun" || resText=="sqsh" || resText=="shwtg"){
				document.myform1.action = "${pageContext.request.contextPath}/common/bb.do?method=addAndEdit&GUID="+chooseValue+"&param=update";
				document.myform1.submit();
			}else{
				// 报备 一个月后只能 修改  已收业务费
				var oBaos = new ActiveXObject("Microsoft.XMLHTTP");
				var url="${pageContext.request.contextPath}/common/content.do?method=getDays&ctguid="+chooseValue;
				oBaos.open("POST",url,false);     
				oBaos.send();
		
		    	var resText = oBaos.responseText;  
				if(resText=="yes"){
					document.myform1.action = "${pageContext.request.contextPath}/common/bb.do?method=addAndEdit&GUID="+chooseValue+"&param=update";
					document.myform1.submit();
					//window.location="${pageContext.request.contextPath}/common/bb.do?method=addAndEdit&GUID="+chooseValue+"&param=update";
				}else{
					// 只能修改 已收业务费用 
					document.myform1.action = "${pageContext.request.contextPath}/common/bb.do?method=addAndEdit&GUID="+chooseValue+"&param=update&updatemoney=updatemoney";
					document.myform1.submit();
				}
			}
		
		
		
	}
	
	
	// 查看
	function f_viewTD(guid,companyguid){
		lookForUpdate(guid,companyguid);
		
		//document.myform1.action = "${pageContext.request.contextPath}/common/bb.do?method=addAndEdit&GUID="+guid+"&param=search&p=ck";
		//document.myform1.submit(); 
	}
	
	// 作废
	function f_cancle(){
		var chooseValue = document.getElementById("chooseValue_${typeid}").value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择要作废的记录!");
		}else{
	    	var resText = f_getStateByGuid(chooseValue);  
			if(resText=="zuofei"){
				alert("已作废状态了!");
				return false;
			}else if(resText=="zancun" || resText=="sqsh" || resText=="cstg" || resText=="shtg" || resText=="shwtg"){
				alert("请删除记录，不要作废记录!");
				return false;
			}else{
				// 超过一个月不能作废 
				var oBaos = new ActiveXObject("Microsoft.XMLHTTP");
				var url="${pageContext.request.contextPath}/common/content.do?method=getDays&ctguid="+chooseValue;
				oBaos.open("POST",url,false);    
				oBaos.send();
		
		    	var resText2 = oBaos.responseText;  
				if(resText2=="cannot"){
					alert("报备超过一个月，不能自行作废；请联系注协代为作废!");
					return false;
				}else{
					document.myform1.action = "${pageContext.request.contextPath}/common/bb.do?method=addAndEdit&GUID="+chooseValue+"&param=search&p=zf";
					document.myform1.submit();
				}
			}
		}
	}
	
	function print(){
		var chooseValue = document.getElementById("chooseValue_${typeid}").value ;
		var typeid = "${typeid}";
		if(chooseValue==null || chooseValue==""){
			alert("请选择要打印的记录!");
		}else{
	    	var resText = f_getStateByGuid(chooseValue);
			if(resText=="zuofei"){
				alert("已作废状态了，不能再打印!");
				return false;
			}else{
				window.open("${pageContext.request.contextPath}/common/bb.do?method=print&guid="+chooseValue+"&typeid="+typeid);
			}
		}
	}



	// 搜索 
	function f_search(){
		document.getElementById("search").style.display = "";
		document.getElementById("divBlock").style.display = "";
	}

	// 取消  清空
	function f_clear(){
		// 防伪编号
		document.getElementById("bbbh").value = "";
		// 项目名称
		document.getElementById("xmmc").value = "";
		// 委托单位
		document.getElementById("wtdw").value = "";
		// 被审( 验)单位
		document.getElementById("bsydw").value = "";
		// 客户出资类型
		document.getElementById("khczlx").value = "";
		// 客户经济性质
		document.getElementById("khjjxz").value = "";
		// 客户行业类型
		document.getElementById("khhylx").value = "";
		// 是否上市企业
		document.getElementById("sfssqy").value = "";
		// 报告年度
		document.getElementById("bgnd").value = "";
		// 报告意见类型
		document.getElementById("bgyjlx").value = "";
		// 报告文号
		document.getElementById("bgwh").value = "";
		// 业务约定书号
		document.getElementById("ywyds").value = "";
		// 业务所在地
		document.getElementById("ywarea").value = "";
		// 签名注师
		document.getElementById("qmzs").value = "";
		// 应收业务费
		document.getElementById("ysywf0").value = "";
		document.getElementById("ysywf").value = "";
		// 收业务费
		document.getElementById("ysywfed0").value = "";
		document.getElementById("ysywfed").value = "";
		// 报备时间
		document.getElementById("bbtime0").value = "";
		document.getElementById("bbtime").value = "";
		// 报告日期
		document.getElementById("bgrq0").value = "";
		document.getElementById("bgrq").value = "";
		document.getElementById("myform1").action = "${pageContext.request.contextPath}/common/bb.do?method=index"; 
		document.getElementById("myform1").submit();
	}
	
	// 取消
	function f_quxiao(){
		document.getElementById("search").style.display = "none";
		document.getElementById("divBlock").style.display = "none";
	}
	
	
	// 确定 
	function f_sure(){
		//document.getElementById("myform1").action = "${pageContext.request.contextPath}/common/bb.do?method=index"; 
		//document.getElementById("myform1").submit();
		var j=0;
		$("#search input[type='text']").each(function(){ 
    		if(!Testing($(this).val())){
    			j=1;
    			return false;
    		}
    		
  		});
		if(j==1){
			return false;
		}

		var t = "${pageContext.request.contextPath}/common/bb.do?method=index&bbbh="+document.getElementById("bbbh").value
		+"&typeid="+document.getElementById("typeid").value
		+"&xmmc="+document.getElementById("xmmc").value
		+"&wtdw="+document.getElementById("wtdw").value
		+"&bsydw="+document.getElementById("bsydw").value
		+"&khczlx="+document.getElementById("khczlx").value
		+"&khjjxz="+document.getElementById("khjjxz").value
		+"&khhylx="+document.getElementById("khhylx").value
		+"&sfssqy="+document.getElementById("sfssqy").value
		+"&bgnd="+document.getElementById("bgnd").value
		+"&bgyjlx="+document.getElementById("bgyjlx").value
		+"&bgwh="+document.getElementById("bgwh").value
		+"&ywyds="+document.getElementById("ywyds").value
		+"&ywarea="+document.getElementById("ywarea").value
		+"&bbstate="+document.getElementById("bbstate").value
		+"&qmzscpa="+document.getElementById("qmzscpa").value
		+"&qmzs="+document.getElementById("qmzs").value
		+"&qmzs1="+document.getElementById("qmzs1").value
		+"&qmzs2="+document.getElementById("qmzs2").value
		+"&qmzs3="+document.getElementById("qmzs3").value
		+"&qmzs4="+document.getElementById("qmzs4").value
		+"&qmzs5="+document.getElementById("qmzs5").value
		+"&qmzs6="+document.getElementById("qmzs6").value
		+"&ysywf1="+document.getElementById("ysywf0").value
		+"&ysywf2="+document.getElementById("ysywf").value
		+"&ysywfed1="+document.getElementById("ysywfed0").value
		+"&ysywfed2="+document.getElementById("ysywfed").value
		+"&bbtime1="+document.getElementById("bbtime0").value
		+"&bbtime2="+document.getElementById("bbtime").value
		+"&bgrq1="+document.getElementById("bgrq0").value
		+"&bgrq2="+document.getElementById("bgrq").value;
		window.location=t;
	}


	// 还原状态
	function f_reset(){
		var chooseValue = document.getElementById("chooseValue_${typeid}").value ;
		var loginid = document.getElementById("loginid").value ;
		if(chooseValue==null || chooseValue==""){
			alert("请选择对象!");
		}else{
	   		var typeid="${typeid}";
	   		
			// 2011-01-01 后的报备数据才能还原
			var oBaos = new ActiveXObject("Microsoft.XMLHTTP");
			var url="${pageContext.request.contextPath}/common/bb.do?method=seebbTime&GUID="+chooseValue;
			oBaos.open("POST",url,false);   
			oBaos.send();
			
			var resText2 = oBaos.responseText;  
			if(resText2 == "Y"){
				document.myform1.action = "${pageContext.request.contextPath}/common/bb.do?method=reset&GUID="+chooseValue+"&typeid="+typeid+"&loginid="+loginid;
				document.myform1.submit();
			}else{
				alert("2011-01-01之前的报备数据不允许还原!");
			}
		}
	}
	
	// 验证金额
	function isDigit(s){ 
		 var patrn=/^-?\d+\.{0,}\d{0,}$/; 
		 var v = s.value;
		 if (!patrn.exec(v)) {
			  alert("请输入合法金额!");
			  s.value = "";			  
		 } 
	}


	// 签名注师查询
	function f_display(t){
		if(t.id == "mh"){
			// 保存是模糊还是定位查询
			document.getElementById("qmzscpa").value = "mh";
			// 清空
			document.getElementById("qmzs1").value = "";
			document.getElementById("qmzs2").value = "";
			document.getElementById("qmzs3").value = "";
			document.getElementById("qmzs4").value = "";
			document.getElementById("qmzs5").value = "";
			document.getElementById("qmzs6").value = "";
			
			document.getElementById("sigle").style.display = "";
			document.getElementById("double1").style.display = "none";
			document.getElementById("double2").style.display = "none";
			document.getElementById("double3").style.display = "none";
		}else{
			// 保存是模糊还是定位查询
			document.getElementById("qmzscpa").value = "dw";
			// 清空
			document.getElementById("qmzs").value = "";
			
			document.getElementById("sigle").style.display = "none";
			document.getElementById("double1").style.display = "";
			document.getElementById("double2").style.display = "";
			document.getElementById("double3").style.display = "";
		}
	}
	
	// 导出
	function f_expExcel(){
		var typeid = document.getElementById("typeid").value;
		var title = document.getElementById("title").value;
		//expExcel(typeid,title);
		document.getElementById("expTableID_" + typeid).value = document.getElementById("dgExpTableID_" + typeid).value;
		//document.getElementById("expSql_" + typeid).value = '"'+document.getElementById("dgExpSql_" + typeid).value+'"';
		document.getElementById("expDisplayColName_" + typeid).value = document.getElementById("dgExpDisplayColName_" + typeid).value;
		document.getElementById("expColName_" + typeid).value = document.getElementById("dgExpColName_" + typeid).value;
		document.getElementById("fileName_" + typeid).value = title;
		document.getElementById("exform1").submit();
	}
	
	// 导入报备数据
	function f_inExcel(){
		window.open("${pageContext.request.contextPath}/common/importBBData.jsp?v=<%=System.currentTimeMillis()%>");
	}
	
	// 离线报备模板下载
	function f_downLoad(){
		var officeType = "${userSession.userMap.officetype}";
		if(officeType!="评估所"){
			window.location = "${pageContext.request.contextPath}/common/attachFile/bb/model.zip";
		}else{
			window.location = "${pageContext.request.contextPath}/common/attachFile/bb/model2.zip";
		}
	}
	
	// 下载申请修改和作废表格
	function f_downLoadTable(){
		window.location = "${pageContext.request.contextPath}/common/attachFile/bb/bbDataInfo.zip";
	}
	
	
	
</script>
<script type="text/javascript">
	function back_list(){
		window.location = "${pageContext.request.contextPath}/common/content/listcontent.jsp";
		
	}

	$(function(){
 		$(".time").keyup(function(){
 			$(this).val("");
 		});
 	});
</script>


</html>