<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>注师注册信息</title>
<style>
	.left{
		width: 30%;
		text-align: left;	
	}
	.color{
		background-color: white;
	}
	.right1{
		width: 25%;
		text-align: right;
		background-color: #e4f4fe;
	}
	.alongHR{
		font-size: 15;
	}
	
	#table{
		width:80%;
		border-collapse:collapse;
	}
	 
	#table td{ 
		border:solid 1px; 
		height:22px; 
	} 
	.input{
		width: 75%;  
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
	<input type="hidden" id="id" name="id" value="${mr.id }">
	<input type="hidden" id="p" name="p" value="${p}">
		<br> <br>
			<table align="center" id="table" cellpadding="3px;" style="width: 90%">
			<tr>
				<td colspan="9" >
				<center> <font style="font-size: 20">&nbsp;执&nbsp;业&nbsp;会&nbsp;员&nbsp;注&nbsp;册&nbsp;信&nbsp;息&nbsp;</font></center>
				</td>
			</tr>
			<tr>
				<td colspan="2" width="20%" align="right" ><font style="font-size: 14">姓名：</font></td>
				<td width="10%"> ${mr.loginName} </td>
				<td class="color" width="10%" align="right"><font style="font-size: 14">性别：</font></td>
				<td width="10%"> ${mr.sex} </td>
				<td class="color" width="15%" align="right"><font style="font-size: 14">出生日期：</font></td>
				<td width="10%"> ${mr.bornDate} </td>
				<td rowspan="4" colspan="2">
					<center>
						<img id="bill" height="120" width="100" src="${pageContext.request.contextPath}/common/attachFile/K_MicfoRegister/${mr.photo}"><br>
					</center>
				</td>
			</tr>
				
			<tr>
				<td align="right" colspan="2"><font style="font-size: 14">国籍：</font></td>
				<td colspan="3"> ${mr.country} </td>
				<td align="right"><font style="font-size: 14">民族：</font></td>
				<td colspan="1"> ${mr.nation}  </td>
			</tr>
			
			<tr>
				<td align="right" colspan="2"><font style="font-size: 14">身份证号：</font></td>
				<td colspan="3"> ${mr.idnumber}  </td>
				<td align="right"><font style="font-size: 14">联系电话：</font></td>
				<td colspan="1"> ${mr.phone} </td>
			</tr>
			
			<tr>
				<td align="right" colspan="2"><font style="font-size: 14">专业职称：</font></td>
				<td colspan="3"> ${mr.rank} </td>
				<td align="right"><font style="font-size: 14">职称等级：</font></td>
				<td colspan="1"> ${mr.professional} </td>
			</tr>
			
			
			<tr>
				<td align="right" colspan="2"><font style="font-size: 14">学历：</font></td>
				<td colspan="1"> ${mr.diploma} </td>
				<td align="right"><font style="font-size: 14">专业：</font></td>
				<td colspan="1"> ${mr.specialty}</td>
				<td align="right" width="15%"><font style="font-size: 14">是否离退休：</font></td>
				<td colspan="1" width="15%"> ${mr.retirees} </td>
				<td colspan="2"> </td>
			</tr>
			
			<tr>
				<td align="right" colspan="2"><font style="font-size: 14">进事务所前所在单位：</font></td>
				<td colspan="7"> ${mr.intobefore} </td>
			</tr>
			
			
			<tr>
				<td align="right" colspan="2"><font style="font-size: 14">档案存放单位：</font></td>
				<td colspan="3"> ${mr.filestorage} </td>
				<td align="right" colspan="2"><font style="font-size: 14">进事务所时间：</font></td>
				<td colspan="2"> ${mr.intotime} </td>
			</tr>
			
			<tr>
				<td align="right" colspan="2"><font style="font-size: 14">从事审计业务时间(月)：</font></td>
				<td colspan="3"> ${mr.auditTime} </td>
				<td align="right" colspan="2"><font style="font-size: 14">否在事务所专职执业：</font></td>
				<td colspan="3"> ${mr.iscomanySpecialty} </td>
			</tr>
			<tr>
				<td align="right" colspan="2"><font style="font-size: 14">资格取得方式：</font></td>
				<td colspan="3"> ${mr.seniorityType} </td>
				<td align="right" colspan="2"><font style="font-size: 14">合格证号或考核（认定）批准文号：</font></td>
				<td colspan="2"> ${mr.certificate} </td>
			</tr>
			
			
			<tr>
				<td rowspan="5" colspan="2" align="right"><font style="font-size: 14">本人从事审计业务工作简历：</font></td>
				<td colspan="3" align="center">起止年月</td>
				<td colspan="2" align="center">所在单位名称</td>
				<td colspan="2" align="center">证明人</td>
			</tr>
			<tr>
				<td colspan="3" align="center"> ${mr.startTime1}<c:if test="${mr.startTime1!='' && mr.startTime1!=null && mr.endTime1!='' && mr.endTime1!=null}"> &nbsp;至&nbsp; </c:if>${mr.endTime1} </td>
				<td colspan="2" align="center"> ${mr.stayCompany1} </td>
				<td colspan="2" align="center"> ${mr.certifier1} </td>
			</tr>
			<tr>
				<td colspan="3" align="center"> ${mr.startTime2}<c:if test="${mr.startTime2!='' && mr.startTime2!=null && mr.endTime2!='' && mr.endTime2!=null}"> &nbsp;至&nbsp; </c:if>${mr.endTime2} </td>
				<td colspan="2" align="center"> ${mr.stayCompany2} </td>
				<td colspan="2" align="center"> ${mr.certifier2} </td>
			</tr>
			<tr>
				<td colspan="3" align="center"> ${mr.startTime3}<c:if test="${mr.startTime3!='' && mr.startTime3!=null && mr.endTime3!='' && mr.endTime3!=null}"> &nbsp;至&nbsp; </c:if>${mr.endTime3} </td>
				<td colspan="2" align="center"> ${mr.stayCompany3} </td>
				<td colspan="2" align="center"> ${mr.certifier3}</td>
			</tr>
			<tr>
				<td colspan="3" align="center"> ${mr.startTime4}<c:if test="${mr.startTime4!='' && mr.startTime4!=null && mr.endTime4!='' && mr.endTime4!=null}"> &nbsp;至&nbsp; </c:if>${mr.endTime4} </td>
				<td colspan="2" align="center"> ${mr.stayCompany4} </td>
				<td colspan="2" align="center"> ${mr.certifier4} </td>
			</tr>
			<tr>
				<td colspan="2" align="right"><font style="font-size: 14">何时因何原因受到何种处罚或者处分：</font></td>
				<td colspan="7"> ${mr.timeAndreason}  </td>
			</tr>
			<tr>
				<td colspan="5">
					<span style="margin-left: 5%">本人对以上所填写内容的真实性负责。</span> <br><br>
					<span style="margin-left: 15%">注册申请人签字：</span> <br><br>
					<br>
					<span style="margin-left: 30%">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日</span>
				</td>
				<td colspan="4">
					<span style="margin-left: 5%">所在会计师事务所意见： </span><br><br>
					<span style="margin-left: 5%">主任会计师签字：</span><br><br>
					<span style="margin-left: 5%">会计师事务所盖章： </span><br>
					<span style="margin-left: 30%">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日</span> 
				</td>
			</tr>
			<tr>
				<td colspan="9" align="center">注册申请人从事审计业务二年以上证明表</td>
			</tr>
			
			<tr>
				<td align="right">证明人基本情况：</td>
				<td colspan="4">
					<span>姓名：</span><br><br>
					<span>注册会计师证书编号：</span><br><br>	
					<span>所在的会计师事务所名称</span>	<br><br>
				</td>
				<td colspan="4">
					<span>姓名：</span><br><br>
					<span>注册会计师证书编号：</span><br><br>
					<span>所在的会计师事务所名称</span>	<br><br>
				</td>
			</tr>
			<tr>
				<td align="right">证明人签字：</td>
				<td colspan="4">
					<span>该申请人从事审计业务：</span><br><br>
					<span>时间自&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月　&nbsp;&nbsp;&nbsp;&nbsp;至  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月</span><br><br>	
					<span>我自愿为上述事项证明，并承担相应责任。</span>	<br><br>
					<span>签字：</span>	<br><br>
					<span>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日</span>
				</td>
				<td colspan="4">
					<span>该申请人从事审计业务：</span><br><br>
					<span>时间自&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月　&nbsp;&nbsp;&nbsp;&nbsp;至  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月</span><br><br>	
					<span>我自愿为上述事项证明，并承担相应责任。</span>	<br><br>
					<span>签字：</span>	<br><br>
					<span>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日</span>
				</td>
			</tr>
			<tr>
				<td colspan="9">申请人姓名：</td>
			</tr>
			<tr>
				<td colspan="9">申请人所在会计师事务所(盖章)：</td> 
			</tr>
		</table>
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