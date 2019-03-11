<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>打开网络文件</title>
</head>
<body style=" padding: 0px; margin: 0px;">

<%
String attachmentId = request.getParameter("attachmentId"); 
String folderId = request.getParameter("folderId"); 
%>
<!-- 
<input type="button"  onclick="openfile('/gdicpa/common/Audit_KJ/1你好.doc','1你好.doc')" value="用屈文浩控件打开" />
 -->
 <span id="print_span">
<input type="button"  onclick="print()" value="打印" />
</span>
&nbsp;&nbsp;
<input type="button"  onclick="myclose()" value="关闭" />

<!-- 
  -->
<input type="button"  onclick="myexecute('E:/Downloads/openEXE/Terminal.exe {068F501A-E732-4E38-88E6-F0209D7D0519} AutoWork')" value="执行命令" />
 
<!-- 
<object classid="clsid:C20572B8-6104-45B8-A3EE-303B42C26ABF" id="oframe" width="98%" height="980px" >
	<param name="BorderStyle" value="1">
	<param name="SideBarVisible" value="0">
	<param name="Titlebar" value="0">
	<param name="Menubar" value="1">
</object>
 -->
 
<script language="javascript" >

<!--var AuditReport =  new ActiveXObject("AuditReportPoject.AuditReport");-->
var oframe=document.getElementById('oframe');

// AuditReport.pDSOFramer=oframe;

//---------------
//获取主机地址
//---------------
function getlocationhost(){
	return "http:\/\/"+window.location.host;
}

function print(){
	AuditReport.funPrint();
}


function openfile(url,filename){
	
	AuditReport.pFileName = filename;
    AuditReport.pOpenUrl = getlocationhost()+url;
	AuditReport.funOpenUrlFile(2);
}


function myclose(){
	AuditReport.funCloseFile();
	window.close();
}

function myexecute(strCmd){
	AuditReport.execute(strCmd);
}


function f_printFile(){
	var attachmentId = "<%=attachmentId%>";
	var attachmentIds = ["micfoNo_glff","micfoNo_djb","zckjs_sqzczl","zckjs_zssqb","zckjs_zsgrjlb",
						"zckjs_plzsb","fzyhy_djb","fzyhy_zhsqb","kjsws_bgsxb","kjsws_fsbgsxb",
						"blcs_sjywzmzl", "ksglzn_jkrygzgz","ksglzn_ksglgzzn","ksglzn_kwgzgz","ksglzn_wgxwclgz",
						"ksglzn_ykrykcsz","ksglzn_ksggfa","ksglzn_tyksbf","ksglzn_kswgxwclbf","pxglzn_fzyjxjy",
						"pxglzn_gdskjsjxjy","pxglzn_zgkjsjxjy"];
	var attachmentNames = ["广东省注册会计师协会非执业会员管理办法.doc","非执业会员登记表.xls","注册会计师申请注册材料.doc","注册会计师转所申请表.doc","注册会计师转所个人简历表.doc",
							"注册会计师批量转所表.doc","中国注册会计师协会非执业会员登记表.xls","中国注册会计师协会非执业会员转会申请表.xls","会计师事务所变更事项情况表.doc","会计师事务所分所变更事项情况表.doc",
							"办理从事审计业务证明资料.doc","监考人员工作规则.doc","考试管理工作指南.doc","考务工作规则.doc","违规行为处理规程.doc",
							"应考人员考场守则.doc","注册会计师考试改革方案.doc","注册会计师全国统一考试办法.doc","注册会计师全国统一考试违规行为处理办法.doc","非执业会员继续教育暂行办法.doc",
							"广东省注册会计师继续教育管理制度.doc","中国注册会计师继续教育制度.doc"];
	var filename = "";										
	for (var i = 0; i < attachmentNames.length; i++) {
		if(attachmentIds[i]==attachmentId){
			filename = attachmentNames[i];
			break;
		}
	}	
	
	// 办事指南不用打印按钮
	if(attachmentId.indexOf("zn")>-1){
		document.getElementById("print_span").style.display = "none";
	}
	
	var folderId = "<%=folderId%>";
	var folderIds = ["bgdy","ksglzn","pxglzn"];
	var folderNames = ["表格打印","考试管理指南","培训管理指南"];
									
	var folder = "";		
	for (var i = 0; i < folderIds.length; i++) {
		if(folderIds[i]==folderId){
			folder = folderNames[i];
			break;
		}
	}	
	if(filename!=""){
		openfile("/gdicpa/common/member/attachFiles/"+folder+"/"+filename,filename);
	}else{
		alert("找不到文件！");
	}
}

// 打印
f_printFile();

</script>
</body>
</html>