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

<title>报备封面</title>

<style media=print>
	*{font-size: 12.0pt}
	body {font-size:12.0pt;}
	#separated{border-top:1px solid #000;font-weight:bold;text-align:center;margin-top:5px;position: relative;width:100%}
	
	  .Noprint{DISPLAY:none;}   
	  .PageNext{PAGE-BREAK-AFTER:always}   
	   
</style>

</head>
<body oncontextmenu="return false" onmousemove="event.returnValue=false;">
<br />
	<input type="button" id=print name=print value="打 印" icon='icon-print' onclick="window.print();" >&nbsp;&nbsp;&nbsp;
 
<table align="center" style="margin-top:20px;" width="100%" border="0">
	<tr align="right"><td>
		<table align="center" cellpadding="0" cellspacing="0"  width="100%" border="0">
			<!-- 
			<tr>
				<td align="right" nowrap="nowrap" width="38%">防伪条形码：</td>
				<td>
					<c:choose>
						<c:when test="${print.bbstate=='报备完成'}">
							<img src="${pageContext.request.contextPath}/barcode?msg=${print.bbbh}&type=code39" height="50" width="250"></img>
						</c:when>
						<c:otherwise>
							报备完成后显示
						</c:otherwise>
					</c:choose>
				 </td>
			</tr>
			 -->
			<tr>
				<td align="right" nowrap="nowrap" width="35%">
					<c:choose>
							<c:when test="${print.bbstate=='报备完成' || print.bbstate=='初次报备'}">
								<strong>
									防伪编号：
								</strong>
							</c:when>
							<c:otherwise>
								防伪编号：
							</c:otherwise>
						</c:choose>
				</td>
				<td width="100">
						<c:choose>
							<c:when test="${print.bbstate=='报备完成' || print.bbstate=='初次报备'}">
								<strong style="font-size:20px;">
									${print.bbbh}
								</strong>
							</c:when>
							<c:otherwise>
								报备完成后显示
							</c:otherwise>
						</c:choose>
				</td>
				 <td rowspan="10" width="45%" style="vertical-align: top;">
					<c:choose>
						<c:when test="${print.bbstate=='报备完成' || print.bbstate=='初次报备'}">
							<img src="${pageContext.request.contextPath}/common/content.do?method=getQrcode&v=<%=System.currentTimeMillis() %>" height="150" width="150"/>
							<br>
							<span style="margin-left:40px;">防伪二维码</span>
						</c:when>
						<c:otherwise>
							防伪二维码：报备完成后显示
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap">报告文号：</td>
				<td>${print.bgwh}</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap">委托单位：</td>
				<td>${print.wtdwmc}</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap">被审单位名称：</td>
				<td>${print.bsdwmc}</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap">营业执照号码：</td>
				<td>${print.yyzzhm}</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap" width="20%">
						事务所名称：
				</td>
				<td>${print.companyName}</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap">报告日期：</td>
				<td>${print.bgrq}</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap">报备时间：</td>
				<td>${print.bbtime}</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap">被审单位所在地：</td>
				<td>${print.ywarea}</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap">
					签名注册会计师：
				</td>
				<td>${print.qmzs1}&nbsp; 
					<c:if test="${isInspection1=='' || isInspection1 == null}">
						<!-- （${inspectionYear}年未年检） -->
					</c:if>  
					<!-- 
					<c:if test="${phone1!='' && phone1 != null}">
						（电话：${phone1}）
					</c:if>
					 -->
				</td>
			</tr>
			<tr>
				<td align="right">&nbsp;</td>
				<td>${print.qmzs2}&nbsp;   
					<c:if test="${isInspection2=='' || isInspection2 == null}">
							<!-- （${inspectionYear}年未年检）-->
					</c:if>
					<!-- 
					<c:if test="${phone2!='' && phone2 != null}">
							（电话：${phone2}）
					</c:if>
					 -->
				</td>
			</tr>
			<c:if test="${print.qmzs3!='' && print.qmzs3!=null }">
			<tr>
				<td align="right">&nbsp;</td>
				<td>${print.qmzs3}&nbsp;
					<c:if test="${isInspection3=='' || isInspection3 == null}">
							<!-- （${inspectionYear}年未年检）-->
					</c:if>
					<!-- 
					<c:if test="${phone3!='' && phone3 != null}">
						（电话：${phone3}）
					</c:if>
					 -->   
				</td>
			</tr>
			</c:if>
			<c:if test="${print.qmzs4!='' && print.qmzs4!=null }">
			<tr>
				<td align="right">&nbsp;</td>
				<td>${print.qmzs4}&nbsp;  
					<c:if test="${isInspection4=='' || isInspection4 == null}">
							<!-- （${inspectionYear}年未年检）-->
					</c:if>
					<!-- 
					<c:if test="${phone4!='' && phone4!=null}">
						（电话：${phone4}）
					</c:if>
					 -->
				</td>
			</tr>
			</c:if>
			<c:if test="${print.qmzs5!='' && print.qmzs5!=null }">
			<tr>
				<td align="right">&nbsp;</td>
				<td>${print.qmzs5}&nbsp; 
					<c:if test="${isInspection5=='' || isInspection5 == null}">
							<!-- （${inspectionYear}年未年检）-->
					</c:if>
					<!-- 
					<c:if test="${phone5!='' && phone5!=null}">
						（电话：${phone5}）
					</c:if>
					 -->
				</td>
			</tr>
			</c:if>
			<c:if test="${print.qmzs6!='' && print.qmzs6!=null }">
			<tr>
				<td align="right">&nbsp;</td>
				<td>${print.qmzs6}&nbsp; 
					<c:if test="${isInspection6=='' || isInspection6 == null}">
							<!-- （${inspectionYear}年未年检）-->
					</c:if> 
					<!-- 
					<c:if test="${phone6!='' && phone6!=null}">
						（电话：${phone6}）
					</c:if>
					 -->
				</td>
			</tr>
			</c:if>
			<c:if test="${print.qmzs3=='' || print.qmzs3==null }"><tr><td>&nbsp;</td></tr></c:if>
			<c:if test="${print.qmzs4=='' || print.qmzs4==null }"><tr><td>&nbsp;</td></tr></c:if>
			<c:if test="${print.qmzs5=='' || print.qmzs5==null }"><tr><td>&nbsp;</td></tr></c:if>
			<c:if test="${print.qmzs6=='' || print.qmzs6==null }"><tr><td>&nbsp;</td></tr></c:if>
		</table>
	</td> 
	</tr>
	<tr>
		<td>
			<div id="separated1" style="height: 25px;"></div>
		</td>
	</tr>
	<tr align="center">
		<td id="contents">
			<br>
			<div style="font-weight: bold;margin-top:10px;font-size:25px;text-align: center;">
				${print.bsdwmc} 
			</div><br>
			<div style="font-weight: bold;font-size:25px;text-align: center;"> 
				<c:if test="${typename=='报备其他'}">
				 			${print.bgnd}${qt.bustype}报告 
				</c:if>
				<c:if test="${typename=='审计'}">
					<c:choose>
						<c:when test="${sj.sjlx=='其他专项审计' || sj.sjlx=='经济责任审计' || sj.sjlx=='改制审计' || sj.sjlx=='财务收支审计业务' || sj.sjlx=='涉及经济案件审计' || sj.sjlx=='基本建设工程决算审核' || sj.sjlx=='其他专项审计'}">
					 			<c:choose>
									<c:when test="${!empty sj.zxsjmc || sj.zxsjmc!=''}">
							 			${print.bgnd}${sj.zxsjmc}专项审计报告 
						 			</c:when>
						 			<c:otherwise>
						 				${print.bgnd}${sj.sjlx}报告 
						 			</c:otherwise>
						 		</c:choose>
						</c:when>
						<c:otherwise>		
					 			${print.bgnd}${sj.sjlx}报告 
					 	</c:otherwise>
					</c:choose>
				</c:if>
				<c:if test="${typename!='报备其他' && typename!='审计'}">
				 			${print.bgnd}${typename}报告 
				</c:if> 
			</div>
			<br>
 		</td>
 	</tr> 
 	<tr>
		<td>
			<div id="separated2" style="height: 25px;"></div>
		</td>
	</tr>
 	<tr align="center"><td>
	 	<table align="left" cellpadding="0" cellspacing="0" width="100%" border="0">
			<tr>
				<td align="right" nowrap="nowrap" width="35%">
						事务所名称：
				</td>
				<td>${print.companyName}</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap" >
						事务所电话：
				</td>
				<td>${print.phone}</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap" >传&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;真：</td>
				<td>${print.faxes}</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap" >通&nbsp;讯&nbsp;&nbsp;地&nbsp;址：</td>
				<td>${print.address}</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap" >电&nbsp;子&nbsp;&nbsp;邮&nbsp;件：</td>
				<td>${print.email}</td>
			</tr>
			<tr>
				<td align="right" nowrap="nowrap" >
						事务所网址：
				</td>
				<td>${print.url}</td>
			</tr>
		</table>
	</td></tr>
	<tr>
		<td>
			<div id="separated" style="margin-bottom:0px;"></div>
		</td>
	</tr>
	
	<tr align="center">
		<td>
			<table align="center" cellpadding="0" cellspacing="0" width="30%" border="0" >
				<tr>
					<td align="left" nowrap="nowrap" >
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						业务报告使用防伪编号仅证明该业务报告是由经依法批准设立的会计师事<br>
						务所出具，报告的法律责任主体是签字注册会计师及其所在事务所。如业务报<br>
						告缺乏防伪封面或者防伪封面提供的信息无法正常查询，请报告使用人谨慎使<br>
						用。					
					</td>
				</tr>
				<tr>
					<td align="left" nowrap="nowrap">
						<br>
						四川省注册会计师协会
					</td>
				</tr>
				<tr>
					<td align="left" nowrap="nowrap">
						防伪查询电话：028-85316767、028-85317676
					</td>
				</tr>
				<tr>
					<td align="left" nowrap="nowrap">
						防伪查询网址：http://www.scicpa.org.cn
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
	<div style="height: 50px;">
	
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
<noscript> <iframe   src=*.html> </iframe> </noscript>

</html>