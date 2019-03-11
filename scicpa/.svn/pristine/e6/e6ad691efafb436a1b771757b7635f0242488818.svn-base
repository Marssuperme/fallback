<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
<%@ include file="/Sys_INCLUDE/include.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="divBlock" style="position:absolute;width:100%;height:100%; top:expression(this.offsetParent.scrollTop); z-index:1; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;cursor: wait;">
	</div>
<div id="loading"
	style="position: absolute; width: 300px; height: 70px; z-index: 10; left: expression(( document.body.clientWidth-300)/ 2 ); top: 200px; border: 1px solid #6595d6; padding: 4px; background: #ffffff; text-align: center; display:none;cursor: wait;">
	<div style=" border: 1px solid #6595d6; padding: 10px;  ">
	<table>
	<tr>
		<td  >
	<img alt="" src="/jsicpa/images/loading.gif">
		</td>
		<td >
		正在提交报名中，请稍候...
		</td>
	</tr>
	</table>
	</div>
</div>	 
<br/>
<br/>
<br/>
<br/>
<br/>
<form name="thisForm" method="post" action="" id="thisForm" > 
<table class="" cellspacing="0" border="0" style="width: 60%;" align="center"  >
	
	${netschools }
	
</table> 	
</form>

<form action="" method="post" id="netForm" name="netForm" target="_blank">
<input type="hidden" id="name" name="name" value=""><br>
<input type="hidden" id="certno" name="certno" value=""><br>
<input type="hidden" id="sign" name="sign" value=""><br>
<input type="hidden" id="signtime" name="signtime" value=""><br>
</form>
</body>

<script type="text/javascript">
var url="";
function apply(sid){
	if(confirm("参加该网校报名就不能继续参加其他网校报名，确定报名？")){ 
		$("#divBlock").css("display","inline"); 
		$("#loading").css("display","inline"); 
		var t=Math.random(); 
		$.ajax({
			url:"training.do?method=netSchoolCheck&ccc="+t,
			async:true,
			type: "post", 
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			data:{"sid":sid}, 
			success:function(data){
				var info=eval("("+data+")");
				$("#divBlock").hide();  
				$("#loading").hide();
				
				alert(info.msg);
					
				if(info.state=="succeed"){
					document.execCommand('Refresh') ;
					return golearn(sid);
				}
			}
		});
		
	}
	
}


//进入学习
function golearn(sid){	
	var url="${pageContext.request.contextPath}/common/training.do?method=netSchLearn";
	var request = "&sid="+sid;
	var resText = ajaxLoadPageSynch(url,request);
	var map = JSON.parse(resText);
	document.netForm.action = map.url;
	$("#name").val(map.name);
	$("#certno").val(map.certno);
	$("#sign").val(map.sign);
	$("#signtime").val(map.signtime);	
	document.netForm.submit();
	
//	window.open("${pageContext.request.contextPath}/common/training.do?method=netSchLearn&sid="+sid+"&v="+new Date().getTime());
}

function netSchInfo(sid){
	url="${pageContext.request.contextPath}/common/training.do?method=netSchInfo&sid="+sid;
	window.showModalDialog(url,window,'dialogWidth=1100px;dialogHeight=700px;'); 
	//window.open("${pageContext.request.contextPath}/common/training.do?method=netSchInfo&id="+id);
	
}
function repairXS(year,sid){
	if(confirm("参加该网校报名/(学时补充)就不能继续参加其他网校报名/(学时补充)，确定报名？")){ 
		$("#divBlock").css("display","inline"); 
		$("#loading").css("display","inline"); 
		var t=Math.random(); 
		$.ajax({
			url:"training.do?method=netSchoolRepareCheck&ccc="+t,
			async:true,
			type: "post", 
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			data:{"sid":sid,"year":year}, 
			success:function(data){
				var info=eval("("+data+")");
				$("#divBlock").hide();  
				$("#loading").hide();
				if(info.state=="go"){
					//alert("直接进入补充学时");
					return golearn(sid); 
				}else{
					alert(info.msg);
					if(info.state=="succeed"){
						 document.execCommand('Refresh') ;
						return golearn(sid); 
					}
				}
			}
		});
		
	}
}
</script>
</html>