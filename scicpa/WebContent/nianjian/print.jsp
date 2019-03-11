<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>非执业入会</title>
<style>
	.left{
		width: 30%;
		text-align: left;	
	}
	.right{
		width: 15%;
		text-align: right;
	}
	.right1{
		width: 25%;
		text-align: right;
	}
	.alongHR{
		font-size: 15;
	}
	
	#color{
		background-color: white;
	}
	
	#table{
		width:100%;
		border-collapse:collapse;
	}
	 
	#table td{ 
		border:solid 1px; 
		height:22px; 
	} 
	.input{
		width: 75%;  
	} 
	.color{
		background-color: white;
	}

</style>

<style media=print>
	*{font-size: 12.0pt}
	body {font-size:12.0pt;}
	#separated{border-top:1px solid #000;font-weight:bold;text-align:center;margin-top:5px;position: relative;width:100%}
	
	  .Noprint{DISPLAY:none;}   
	  .PageNext{PAGE-BREAK-AFTER:always}   
</style>
</head>
<body>

	<form id="myForm" name="myForm" method="post" >
	<input type="button" id=print name=print value="打 印" icon='icon-print' onclick="window.print();" >&nbsp;&nbsp;&nbsp;
	<input type="hidden" id="id" name="id" value="${ct.id }">
		<br><br>
				<table align="center" id="table" cellpadding="4px;">
					<tr>
						<td colspan="6" class="color">
							<span style="margin-left: 35%"><font style="font-size: 20">非执业会员年检表</font></span>
						</td>
					</tr>
					<tr>
						<td id="color" width="15%" align="right" ><font style="font-size: 14">姓名：</font></td>
						<td width="20%"> ${userMap.loginname} </td>
						<td id="color" width="15%" align="right"><font style="font-size: 14">性别：</font></td>
						<td width="15%"> ${userMap.sex} </td>
						<td id="color" width="15%" align="right"><font style="font-size: 14">证件类型：</font></td>
						<td width="20%"> 身份证 </td>
					</tr>
					<tr>
						<td id="color" align="right"><font style="font-size: 14">曾用名：</font></td>
						<td > ${userMap.loginnameex} </td>
						<td id="color" align="right"><font style="font-size: 14">曾用身份证号码：</font></td>
						<td > ${userMap.idnumberex} </td>
						<td id="color" align="right"><font style="font-size: 14">身份证件号：</font></td>
						<td > ${userMap.idnumber} </td>
					</tr>
					
					<tr>
						<td id="color" align="right"><font style="font-size: 14">资格取得方式：</font></td>
						<td > ${userMap.getmode}  </td>
						<td id="color" align="right"><font style="font-size: 14" >全科合格证号：</font></td>
						<td > ${userMap.certificate} </td>
						<td id="color" align="right"><font style="font-size: 14">出生日期：</font></td>
						<td > ${userMap.borndate} </td>
					</tr>
					
					<tr>
						<td id="color" align="right"><font style="font-size: 14">户口所在地：</font></td>
						<td > ${userMap.accountin} </td>
						<td id="color" align="right"><font style="font-size: 14">民族：</font></td>
						<td > ${userMap.nation} </td>
						<td id="color" align="right"><font style="font-size: 14">政治面貌：</font></td>
						<td > ${userMap.politics} </td>
					</tr>
					<tr>
						<td id="color" align="right"><font style="font-size: 14">联系电话、手机：</font></td>
						<td > ${userMap.phone} 、${userMap.mobile} </td>
						<td width="20%" align="right"><font style="font-size: 14">电子邮件：</font></td>
						<td > ${userMap.email} </td>
						<td id="color" align="right"><font style="font-size: 14">单位性质：</font></td>
						<td > ${userMap.ownership}  </td>
					</tr>
					
					<tr>
						<td id="color" align="right"><font style="font-size: 14">工作单位：</font></td>
						<td colspan="3"> ${userMap.workunits}</td>
						<td id="color" align="right"><font style="font-size: 14">是否离退休：</font></td>
						<td > ${userMap.retirees}  </td>
					</tr>
					
					<tr>
						<td id="color" align="right"><font style="font-size: 14">通讯地址：</font></td>
						<td colspan="3"> ${userMap.address} </td>
						<td id="color" align="right"><font style="font-size: 14">邮政编码：</font></td>
						<td > ${userMap.postcode} </td>
					</tr>
					
					
					<tr>
						<td id="color" align="right"><font style="font-size: 14">毕业院校：</font></td>
						<td colspan="3"> ${userMap.educational} </td>
						<td id="color" align="right"><font style="font-size: 14">专业：</font></td>
						<td > ${userMap.specialty} </td>
					</tr>
					<tr>
						<td id="color" align="right"><font style="font-size: 14">学历：</font></td>
						<td > ${userMap.diploma}  </td>
						<td id="color" align="right"><font style="font-size: 14">学位：</font></td>
						<td > ${userMap.degree}  </td>
						<td id="color" align="right"><font style="font-size: 14">外语程度：</font></td>
						<td > ${userMap.languagelevel} </td>
					</tr>
					<tr>
						<td id="color" align="right"><font style="font-size: 14">专业技术职称：</font></td>
						<td > ${userMap.rank} </td>
						<td id="color" align="right"><font style="font-size: 14">职称等级：</font></td>
						<td > ${userMap.professional}  </td>
						<td id="color" align="right"><font style="font-size: 14">所在地区：</font></td>
						<td >${userMap.area}</td>
					</tr>
					<tr>
						<td id="color" align="right"><font style="font-size: 14">具有完全民事行为能力：</font></td>
						<td > ${isMap.msnl}  </td>
						<td id="color" align="right"><font style="font-size: 14">有无受过何种刑事处罚：</font></td>
						<td > ${isMap.xscf}  </td>
						<td id="color" align="right"><font style="font-size: 14">有无受过何种行业处罚：</font></td>
						<td > ${isMap.hycf} </td>
					</tr>
					<tr>
						<td id="color" align="right"><font style="font-size: 14">后续教育学时：</font></td>
						<td > ${isMap.schooldate}  </td>
						<td id="color" align="right"><font style="font-size: 14">是否缴纳会费：</font></td>
						<td > ${isMap.dues}  </td>
						<td id="color" align="right"><font style="font-size: 14">是否参加年检：</font></td>
						<td > ${isMap.yearcheck} </td>
					</tr>
					<tr>     
						<td colspan="6">
							<div style="margin-top: 1%;margin-bottom: 1%">
								<span style="margin-left: 10%;"><font style="font-size: 14">省注册会计师协会意见：</font></span>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<span style="margin-left: 10%;"><font style="font-size: 14">会员签名：</font></span>
									
								
								<br><br>
								<span style="margin-left: 15%"><font style="font-size: 14">签名：</font></span>
								<span style="margin-left: 10%"><font style="font-size: 14">盖章：</font></span> 				        
								<span style="margin-left: 15%"><font style="font-size: 14">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日</font></span>
							</div>
						</td>
					</tr>   
				</table>
				<font style="font-size: 10">该表由非执业会员填写，打印后交市注协初审。</font>
	</form>
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
</html>