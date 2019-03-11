<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>报备打印</title>
<style>
	*{font-size: 12.0pt}
	body {font-size:12.0pt;}
	#separated{border-top:1px solid #000;font-weight:bold;text-align:center;margin-top:5px;position: relative;width:100%}
	
	@media print
	 {   
	  .Noprint{DISPLAY:none;}   
	  .PageNext{PAGE-BREAK-AFTER:always}   
	 } 
</style>

</head>
<body>
<input type="button" id=print name=print value="打 印" onclick="window.print();" >
<table align="center" style="margin-top:60px;">
	<tr><td>
		<table align="center" cellpadding="0" cellspacing="10">
			<tr>
				<td align="right" nowrap="nowrap">防伪条形码：</td>
				<td><img src="${pageContext.request.contextPath}/barcode?msg=${print.bbbh}&type=code39" height="50" width="250"></img> </td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap">报备 号码：</td>
				<td>${print.bbbh}</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap">报告 文号：</td>
				<td>${print.bgwh}</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap">委托 单位：</td>
				<td>${print.wtdwmc}</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap">事务所名称：</td>
				<td>${print.companyName}</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap">报告 日期：</td>
				<td>${print.bgrq}</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap">报备 时间：</td>
				<td>${print.bbtime}</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap">签名注册会计师：</td>
				<td>${print.cpa1}</td>
			</tr>
			<tr>
				<td align="right">&nbsp;</td>
				<td>${print.cpa2}</td>
			</tr>
			<tr>
				<td align="right">&nbsp;</td>
				<td>${print.cpa3}</td>
			</tr>
			<tr>
				<td align="right">&nbsp;</td>
				<td>${print.cpa4}</td>
			</tr>
			<tr>
				<td align="right">&nbsp;</td>
				<td>${print.cpa5}</td>
			</tr>
			<tr>
				<td align="right">&nbsp;</td>
				<td>${print.cpa6}</td>
			</tr>
		</table>
	</td>
	</tr>
	<tr><td>
		<div style="font-weight: bold;text-align: center;margin-top:10px;font-size:30px;">${print.wtdwmc}</div>
 		<div style="font-weight: bold;text-align: center;margin:50 0 100 0px;height:40px;font-size:30px;">${print.bgnd}审计报告</div>
 	</td></tr>
 	<tr style="height:100px;"><td></td></tr>
 	<tr><td>
	 	<table align="left" cellpadding="0" cellspacing="10" width="100%">
			<tr>
				<td align="right" nowrap="nowrap" width="20%">事务所名称：</td>
				<td>${print.companyName}</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap" width="20%">事务所电话：</td>
				<td>${print.phone}</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap" width="20%">传   真：</td>
				<td>${print.faxes}</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap" width="20%">通迅 地址：</td>
				<td>${print.address}</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap" width="20%">电子 邮件：</td>
				<td>${print.email}</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap" width="20%">事务所网址：</td>
				<td>${print.url}</td>
			</tr>
		</table>
	</td></tr>
	<tr><td>
		<div id="separated" style="margin-bottom:0px;"></div>
	</td></tr>
	
	<tr><td>
		<table align="left" cellpadding="0" cellspacing="10" width="100%" >
			<tr>
				<td align="left" nowrap="nowrap" style="font-size:12px;">
					如对上述报务资料，有疑问的。请与广东注册会计师协会联系。
				</td>
			</tr>
			<tr>
				<td align="left" nowrap="nowrap" style="font-size:12px;">
					防伪查询电话号码：  020-38922363、38922373
				</td>
			</tr>
			<tr>
				<td align="left" nowrap="nowrap" style="font-size:12px;">
					防伪  查询  网址： http://www.gdicpa.org.cn
				</td>
			</tr>
		</table>
	</td></tr>
	</table>
	
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

</script>

</html>