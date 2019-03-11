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

<title>打印结业证书</title>
<style type="text/css">
u{
	font-size:30px;
	font-family: 仿宋;
	line-height:85px;"
}
</style>
</head>
<body oncontextmenu="return false">
<br />
<input type="button" id=print name=print value="打 印" icon='icon-print' onclick="window.print();" >&nbsp;&nbsp;&nbsp;

<form name="thisForm" method="post" action="">
	<div style="text-align: center;border: 12px solid black;margin-left: 15px;margin-right: 15px;">
		<table cellpadding="10" cellspacing="10" style="width: 90%;word-break:break-all">
			<tr align="center">
				<td colspan="2"> 
					<font style="font-size: 80px;font-family: 隶书;">
						结业证书<br>
					</font>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					 <font style="font-size:30px;font-family: 仿宋;line-height:85px;">
					 &nbsp;&nbsp;&nbsp;&nbsp;<u>黄海清</u>学员(证书编号：<u>442009C272</u>)于<u>2012</u>年参加了由<u>广东省注
                                                 册会计师协会</u>委托上海国家会计学院组织的<u>2012年非执业会员培训</u>，共计<u>25</u>学时，课时修满合格，特此证明。
					</font>
				</td>
			</tr>
			
			<tr height="100%">
				<td>
					<div style="margin-left: 0px;background-image: url('${pageContext.request.contextPath}/images/certificate.gif');background-repeat:no-repeat;background-position:center;text-align:center;height:171px;padding-top:30px;">
						<font style="font-size: 22px;font-family: 仿宋;font-weight: bolder;">主管单位：广东省注册会计师协会</font><br/>
						<font style="font-size: 14px;font-family: 仿宋;font-weight: bolder;"><br><br>
							
						</font><br/>
						<font style="font-size: 17px;font-family: 仿宋;font-weight: bolder;">2013年xx月xx日</font>
					</div>
				</td>
				<td>
					<div style="margin-left: 0px;background-image: url('');background-repeat:no-repeat;background-position:center;text-align:center;height:171px;padding-top:30px;">
						<font style="font-size: 22px;font-family: 仿宋;font-weight: bolder;">培训单位：上海国家会计学院</font><br/>
						<font style="font-size: 14px;font-family: 仿宋;font-weight: bolder;"><br><br>
							
						</font><br/>
						<font style="font-size: 17px;font-family: 仿宋;font-weight: bolder;">2013年xx月xx日</font>
					</div>
				</td>
			</tr>
		</table>
	</div>
 
</form>
</body>
</html>
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
		}    
	}       

	window.onbeforeprint = function (){
		//PageSetup_Null();
		document.getElementById("print").style.display = "none" ;
	}
	
	window.onafterprint = function (){
		document.getElementById("print").style.display = "" ;
	}


//加入页面保护   禁止复制(copy),禁用鼠标右键!
    function rf()
    {return false; }
    document.oncontextmenu = rf
    function keydown()
    {if(event.ctrlKey ==true || event.keyCode ==93 || event.shiftKey ==true){return false;} }
    document.onkeydown =keydown
    function drag()
    {return false;}
    document.ondragstart=drag
    function stopmouse(e) {
    if (navigator.appName == 'Netscape' && (e.which == 3 || e.which == 2))
    return false;
    else if
    (navigator.appName == 'Microsoft Internet Explorer' && (event.button == 2 || event.button == 3)) {
    return false;
    }
    return true;
    }
    document.onmousedown=stopmouse;
    if (document.layers)
    window.captureEvents(Event.MOUSEDOWN);
    window.onmousedown=stopmouse;


</script>