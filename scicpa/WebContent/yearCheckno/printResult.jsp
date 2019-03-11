<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>

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
	
	<title>年检打印</title>
	
	<style media=print>
		* {
			font-size: 14pt
		}
		
		#separated {
			border-top: 1px solid #000;
			font-weight: bold;
			text-align: center;
			margin-top: 5px;
			position: relative;
			width: 100%
		}
		
		.Noprint {
			DISPLAY: none;
		}
		
		.PageNext {
			PAGE-BREAK-AFTER: always
		}
		
		td {
			font-size: 16pt;
		}
		
		tr td {
			font-size: 16pt;
		}
		
		.hhhh {
			font-size: 16pt;
		}
	</style>

	<script type="text/javascript">
		if("${status}" == "0"){
			alert('年检通过才可以打印年检结果 !');
			window.close();
		}
	</script>

</head>
<body >
	<div>
		<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" id=print name=print value="打 印" icon='icon-print' onclick="window.print();" />
 		<div style="padding-top: 50px;text-align:center">
 			<font style="font-size: 16px;font-weight: bolder;">请沿虚线剪下，贴在证书“年度检验登记”处</font>
 			<br/>
 			<br/>
 			<br/>
 			<table bordercolor="black" cellpadding="0px;" cellspacing="1px;" align="center" style="border: 1px dashed;padding-left:7px;padding-bottom:3px;">
 				<tr>
 					<td style="">
 						<img src="${pageContext.request.contextPath}/common/annualInspection.do?method=getQrcode&id=${map.uuid }&v=<%=System.currentTimeMillis() %>" />
 					</td>
 				</tr>
 				<tr>
 					<td style='text-align: center;'><span style='font-size:12px;'>${userSession.userMap.loginname }(${userSession.userMap.loginid })</span></td>
 				</tr>
 				<tr>
 					<td style='text-align: center;'><span style='font-size:12px;'>您已通过${map.year }年年检</span></td>
 				</tr>
 				<tr>
 					<td style='text-align: center;'><span style='font-size:12px;;'>四川省注册会计师协会</span></td>
 				</tr>
 			</table>
			<br/>
			<br/>
			<font style="color:red;font-size: 28px; text-align:center">请扫描二维码进行验证</font>
		</div>
	</div>
</body>

<script type="text/javascript">
	var HKEY_Root,HKEY_Path,HKEY_Key;    
	HKEY_Root="HKEY_CURRENT_USER";    
	HKEY_Path="\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";   
	
	//设置网页打印的页眉页脚和页边距   
	function PageSetup_Null()    
	{    
		 try    
		 {    
			  var Wsh=new ActiveXObject("WScript.Shell");    
			  HKEY_Key="header";    
			//设置页眉（为空）   
			  Wsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"");    
			  HKEY_Key="footer";    
			//设置页脚（为空）   
			  Wsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"");   
		}catch(e){
			//alert(111);
		 }    
	}       

	window.onbeforeprint = function (){
		//PageSetup_Null();
		document.getElementById("print").style.display = "none" ;
	}
	
	window.onafterprint = function (){
		document.getElementById("print").style.display = "" ;
	}


	  
     // 打印设置  
     function doPrintSet(){   
         document.all.WebBrowser.ExecWB(8,1);
     }   


</script>
<noscript> <iframe   src=*.html> </iframe> </noscript>
<script type="text/javascript">
	$("table tr td").css("font-size", "14pt");
	$(".xx").css("font-size", "11pt");
</script>
</html>