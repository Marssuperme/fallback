<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>检查人员报名审批</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/JS/uploadFile.js?v=${modifyDate}"  ></script>

<style>
td {
	font-size: 12px;
	text-decoration: none;
}
</style>

</head>
<body>


<div id="divBlock_cjr" style="position:absolute;width:100%;height:100%; top:expression(this.offsetParent.scrollTop); z-index:1; padding:10px; background:#EDEDED;filter:alpha(opacity=50); text-align:center; display:none;">
</div>
<form id="thisForm" name="thisForm" method="post" action="" >

<input type="hidden" id="uids" name = "uids" value="${tcname}">
<input type="hidden" id="tname1" name = "tname1" value="">
<input type="hidden" id="noticeId" name = "noticeId" value="${tnt.id }">
<input type="hidden" id="uploadAttachId" name = "uploadAttachId" value="${uploadAttachId}">
<input type="hidden" id="timelimit" name = "timelimit" value="${tnt.timelimit }">
<input type="hidden" id="testerlimit" name = "testerlimit" value="${tnt.testerlimit }">

<input type="hidden" id="post1" name="post1"> 
<input type="hidden" id="mobile1" name="mobile1"> 
<input type="hidden" id="email1" name="email1"> 
<input type="hidden" id="rtx1" name="rtx1">

<!-- 对应通知的已参加人数 -->
<input type="hidden" id="count" name = "count" value="${count}">

<!-- 选中人的编号  -->
<input type="hidden" id="tid2" name = "tid2" value="">

<!-- 选中人的名称  -->
<input type="hidden" id="tname2" name = "tname2" value="">

	<div id="divProduce" style="margin-top:200px;position:absolute;width:800px;height:300px; z-index:2;left:expression((document.body.clientWidth-720)/2);top:expression(this.offsetParent.scrollTop + 80); border:1px solid #6595d6; padding:10px; background:#ffffff;text-align:center; display: none;overflow: auto;">
		<fieldset>
			<legend><font size="2">该所已有的会员</font></legend>
			<div style="height: 200px;overflow: auto">	
				<table id="targetTable" cellSpacing="1" cellPadding="2" width="100%" bgColor="#6595d6" border="0" style="margin-top: 5px; " >
			    <tr >
			      <td width="2px;" align="center" bgColor="#b9c4d5"><input type="checkbox" onclick="checkall(this);"></td>
			      <td align="center" bgColor="#b9c4d5">姓名</td>
			      <td noWrap align="center" bgColor="#b9c4d5">会员类型</td>
			      <td noWrap align="center" bgColor="#b9c4d5">CPA号</td>
			      <td noWrap align="center" bgColor="#b9c4d5">职&nbsp;&nbsp;&nbsp;&nbsp;位</td>
			      <td noWrap align="center" bgColor="#b9c4d5">手机号码</td>
			      <td noWrap align="center" bgColor="#b9c4d5">邮&nbsp;&nbsp;&nbsp;&nbsp;箱</td>
			      <td noWrap align="center" bgColor="#b9c4d5">即时通讯</td>
			    </tr>
			    
				<c:forEach items="${userList}" var="user" >
				
						<tr >
					      <td width="2px;" align="center" bgcolor="#f6f6f6">
					      	<input
					      		<c:if test="${user.astate == '不批准'}">disabled</c:if>
					      		<c:if test="${user.astate == '批准'}"></c:if>
					      		<c:if test="${user.astate == '' || user.astate==null}"></c:if>
					      		<c:if test="${user.id != '' && user.id!=null}">checked</c:if>
					      		name="t_name1" 
					      		type="checkbox" 
					      		value='${user.loginname }' 
					      		loginid = '${user.loginid }' 
					      		ttype='${user.ctype }' 
					      		onclick="f_isPunish('${user.loginname }','${user.cpano }',this)"
					      	>
					      </td>
					      <td align="center" bgcolor="#f6f6f6" ><input type="text" name="loginnames" value="${user.loginname }" style="border:0px;" readonly="readonly"></td>
					      <td noWrap align="center" bgColor="#f6f6f6">${user.ctype }</td>
					      <td noWrap align="center" bgColor="#f6f6f6" ><input type="text" name="cpanos" value="${user.cpano }" style="border:0px;" readonly="readonly"></td>
					      <td noWrap align="center" bgColor="#f6f6f6">
					      		<input id="post" name="post" value="${user.post}" autoWidth="20%"
										onfocus="onPopDivClick(this);" 
										onkeydown="onKeyDownEvent();"
										onkeyup="onKeyUpEvent();"
										onclick="onPopDivClick(this);"
										autoid=33 >
							</td>
					      <td noWrap align="center" bgColor="#f6f6f6"><input id="mobile" name="mobile" value="${user.mobile}"></td>
					      <td noWrap align="center" bgColor="#f6f6f6"><input id="email" name="email" value="${user.email}"></td>
					      <td noWrap align="center" bgColor="#f6f6f6"><input id="rtx" name="rtx" value="${user.rtx}"></td>
					    </tr>
					    
				</c:forEach>
			    
				</table>	
			</div>	
		</fieldset>
		<br>
		 <input type="button" onclick="chooseProDiv();" class="flyBT" value="确定" >
		 <input type="button" onclick="hiddenProDiv();" class="flyBT" value="取消" >
	</div>





<table width="100%" height="121" border="0" cellpadding="0" cellspacing="1" bgcolor="#6595d6">
<tr>
	<td align="center" valign="top" bordercolor="#CCCCCC" bgcolor="#FFFFFF">
      <br>
	<h4>${tnt.title }</h4>


	<table width="98%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#6595d6">
	<tr height=18>
	  	<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>标题</strong></td>
	  	<td width="80%" align="left" bgColor="#ffffff" >${tnt.title }</td>
	</tr>
	<tr height=18>
	  	<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>通知正文</strong></td>
	  	<td width="80%" align="left" bgColor="#ffffff" >${tnt.acontent }</td>
	</tr>
	<tr height=18>
	  	<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>发起机构</strong></td>
	  	<td width="80%" align="left" bgColor="#ffffff" >${tnt.customerID }</td>
	</tr>
	<tr height=18>
	  	<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>发起时间</strong></td>
	  	<td width="80%" align="left" bgColor="#ffffff" >${tnt.atime }</td>
	</tr>
	<tr height=18>
	  	<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>检查年份</strong></td>
	  	<td width="80%" align="left" bgColor="#ffffff" >${tnt.testyear }</td>
	</tr>
	<tr height=18>
	  	<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>检查报名人数上限</strong></td>
	  	<td width="80%" align="left" bgColor="#ffffff" >${tnt.testerlimit }</td>
	</tr>
	<tr height=18>
	  	<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>报名截止日期</strong></td>
	  	<td width="80%" align="left" bgColor="#ffffff" >${tnt.timelimit }</td>
	</tr>
	<tr height=18>
	  	<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>下载附件</strong></td>
	  	<td width="80%" align="left" bgColor="#ffffff" ><div id="file"></div></td>
	</tr>
	 
	 
</table>
<br><br>
	<font color="#FF0000">[&nbsp;修改或添加参加人，请点击下框。&nbsp;]</font>
	<c:choose>
		<c:when test="${tnt.timelimit < today}">
			<c:if test="${tcname != '' && tcname != null }">
				<table width="98%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#6595d6">
					<tr height=18>
						<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>参加人</strong></td>
					  	<td width="80%" valign="bottom" align="left" bgColor="#ffffff" >
			  				<textarea rows="5" cols="100" name="userId" id= "userId" disabled="disabled">${tcname}</textarea>
			  			</td>
					</tr>
					<tr height=18>
						<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>上传附件</strong></td>
					  	<td width="80%" align="left" bgColor="#ffffff" ><div id="upload_file"></div></td>
					</tr>
				</table>	
				<br>
		   </c:if>
			<table width="90%" align="center">
				<tr height=18>
				  	<td width="20%" height="20" align="center" ><font color="red">注意：报名截止日期已过</font></td>
				</tr>	
				<tr>
					<td width="" align="center">
						<input icon="icon-back" type="button" name="next" value="返  回"  onclick="window.history.back();" >
					</td>
				</tr>
			</table>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${count*1>=tnt.testerlimit*1}">
					<c:if test="${tcname != '' && tcname != null }">
						<table width="98%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#6595d6">
							<tr height=18>
								<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>参加人</strong></td>
							  	<td width="80%" valign="bottom" align="left" bgColor="#ffffff" >
					  				<textarea rows="5" cols="100" name="userId" id= "userId" onclick="f_updateBM();">${tcname}</textarea>
					  			</td>
							</tr>
							<tr height=18>
								<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>上传附件</strong></td>
							  	<td width="80%" align="left" bgColor="#ffffff" ><div id="upload_file"></div></td>
							</tr>
						</table>	
				   </c:if>
				
					<table width="90%" align="center">
						<tr height=18>
						  	<td width="20%" height="20" align="center" ><font color="red">注意：报名人数已满</font></td>
						</tr>		
						<tr>
							<td width="" align="center">
								<c:if test="${tcname != '' && tcname != null }">
									<!-- 
									<input icon="icon-update" type="button" name="next" value="修改报名"  onclick="f_updateBM();" >
									 -->
									<input icon="icon-cancel" type="button" name="next" value="取消报名"  onclick="f_cancelBM();" > 
								</c:if>
								<input icon="icon-back" type="button" name="next" value="返  回"  onclick="window.history.back();" >
							</td>
						</tr>
					</table>	
				</c:when>
				
				<c:otherwise>
					<table width="98%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#6595d6">
						<tr height=18>
							<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>参加人</strong></td>
						  	<td width="80%" valign="bottom" align="left" bgColor="#ffffff" >
						  		
						  		<c:choose>
						  			<c:when test="${tct.astate=='不批准'}">
						  				<textarea rows="5" cols="100" name="userId" id= "userId" disabled="disabled" >${tcname}</textarea>
						  			</c:when>
						  			<c:otherwise>
						  				<c:choose>
						  					<c:when test="${tcname != '' && tcname != null }">
						  						<textarea rows="5" cols="100" name="userId" id= "userId" onfocus="f_updateBM();">${tcname}</textarea>
						  					</c:when>
						  					<c:otherwise>
						  						<textarea rows="5" cols="100" name="userId" id= "userId"  onfocus="f_updateBM();">${tcname}</textarea>
					  						</c:otherwise>
						  				</c:choose>
						  			</c:otherwise>
						  		</c:choose>
						  	</td>
						</tr>
						<tr height=18>
							<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>上传附件</strong></td>
						  	<td width="80%" align="left" bgColor="#ffffff" ><div id="upload_file"></div></td>
						</tr>
					</table>	
					<br>
					<table width="90%" align="center">
						<tr>
							<td width="" align="center" >
								<input icon="icon-save" type="button" name="next" value="提交报名" onclick="saveProcedure();">
								<c:if test="${tct.astate!='不批准'}">
									<c:choose>
										<c:when test="${tcname != '' && tcname != null }">
											<!-- 
											<input icon="icon-update" type="button" name="next" value="修改报名"  onclick="f_updateBM();" >
											 -->
											<input icon="icon-cancel" type="button" name="next" value="取消报名"  onclick="f_cancelBM();" >
					  					</c:when>
					  					<c:otherwise>
											<!-- 
											<input icon="icon-save" type="button" name="next" value="报  名"  onclick="f_updateBM();" >
											 -->
				  						</c:otherwise>
				  					</c:choose>
								</c:if>
								<input icon="icon-back" type="button" name="next" value="返  回"  onclick="f_back();" >
							</td>
						</tr>
					</table>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
		
	 </c:choose>
</body>

<script type="text/javascript">

		var num = "${tnt.attachment}";
		//附件
		if(num!=null && num!=""){
			$('#file').uploadFile({
				indexId: '${tnt.attachment}',
				module:'k_TesterNotice',
				forbitUpload:true,
				forbitDel:true
			})
		}; 


		var timelt = "${tnt.timelimit}";
		var tod =  "${today}";
		var cnt = "${count}";
		var ttlit = "${tnt.testerlimit}";
		var fbu = false;
		var fbd = false;
		if(timelt<tod || ttlit*1<cnt*1){
			fbu = true;
			fbd = true;
		}
		
		$('#upload_file').uploadFile({
			indexId: '${uploadAttachId}',
			module:'k_TesterComposition',
			forbitUpload:fbu,
			forbitDel:fbd
		})

		// 判断是否可以报名
		function f_save(){	
			//var userId = document.getElementById("userId").value;
			var userId = document.getElementById("userId").innerHTML;
			if(userId == ""){
				alert("请勾选参与人！");
				setName();
				return ;
			}
		
			var now = new Date();
			var fullyear = now.getFullYear();
			var month = now.getMonth()*1+1;
			if(month<10){
				month="0"+month;
			}
			var date = now.getDate();
			if(date<10){
				date="0"+date;
			}
			var nowtime = fullyear+"-"+month+"-"+date;
			var timelimit = document.getElementById("timelimit").value;
			if(nowtime>timelimit){
				alert("报名截止日期已过,不能报名了");
				return;
			}else{
				// 限制人数
				var testerlimit = document.getElementById("testerlimit").value;
				// 对应 检查组人员通知 报名人数
				var count = document.getElementById("count").value;
				
				var tname = document.getElementById("userId").value;
				var tnames = tname.split(',').length;  // 参加人数 
				var valid = testerlimit*1-count*1;    // 剩余 报名数
				if(tnames*1>testerlimit*1){
					alert("您当前的加入的报名人数："+tnames+",不能高于该通知的上线人数："+testerlimit);
					return;
				}else{
					if(tnames*1>valid*1){
						alert("您当前的加入的报名人数："+tnames+",不能高于该通知的剩余报名人数："+valid);
						return;
					}else{
						thisForm.action = "${pageContext.request.contextPath}/common/testerComposition.do?method=addTesterCompositionTable";
						thisForm.submit();
					}
				}
			}
		}
		
		
		function setName(){ 
			var divObj = document.getElementById("divProduce");
			var blockObj =  document.getElementById("divBlock_cjr");
			divObj.style.display = "";
			blockObj.style.display = "";
			divObj.focus();
			divObj.select();
		}
		
		
		// 全选和反选
		function checkall(oCbx){
			var cbxValue = oCbx.checked; 
			var oInput = document.getElementsByName("t_name1");
			var loginnames = document.getElementsByName("loginnames");
			var cpanos = document.getElementsByName("cpanos");
			for(var i = 0; i < oInput.length; i++){
				
				var rs = f_isPunish(loginnames[i].value,cpanos[i].value,oInput[i]);
				if(rs){
					if(!oInput[i].disabled){
						oInput[i].checked = cbxValue;  
					}
				}
				
			}
		}
	 
		
		function checkone(){
		   var p = "Y";
		   var i = 0;
		   var str = "";
		   // 编号
		   var oChooses = document.getElementsByName("t_name1");
		   var post = document.getElementsByName("post");
		   var strPost = "";
		   var mobile = document.getElementsByName("mobile");
		   var strMobile = "";
		   var email = document.getElementsByName("email");
		   var strEmail = "";
		   var rtx = document.getElementsByName("rtx");
		   var strRtx = "";
		   var j = oChooses.length;
		   for(i = 0; i < j; i++){
		      if(oChooses[i].checked == true ){
		         str = str + oChooses[i].value + ",";
		         if(post[i].value==""){
		         	alert("职位不能为空!");
		         	post[i].focus();
		         	p="N";
		         	break;
		         }else{
		         	strPost = strPost + post[i].value + ",";
		         }
		         
		         if(mobile[i].value=="" || mobile[i].value==null){
			        alert("手机不能为空!");
		         	mobile[i].focus();
		         	p="N";
		         	break;
		         }else{
			         strMobile = strMobile + mobile[i].value + ",";
		         }
		         
		         if(mobile[i].value.length!=11){
			        alert("手机号码长度必须11位!");
		         	mobile[i].focus();
		         	p="N";
		         	break;
		         }else{
			         strMobile = strMobile + mobile[i].value + ",";
		         }
		         
		         if(email[i].value=="" || email[i].value==null){
		         	alert("邮箱不能为空!");
		         	email[i].focus();
		         	p="N";
		         	strEmail = strEmail + "无,";
		         	break;
		         }else{
	             	strEmail = strEmail + email[i].value + ",";
	             }
	             
	             // 即时通讯可以为空  并且 为空的时候  用无 代替，以便后台 数组好做替换处理
	             if(rtx[i].value=="" || rtx[i].value==null){
	             	strRtx = strRtx + "无,";
	             }else{
	             	strRtx = strRtx + rtx[i].value + ",";
	             }
		      }
			}
			
			if(p=="Y"){
				str = str.substring(0,(str.length - 1));
				strPost = strPost.substring(0,(strPost.length - 1));
				strMobile = strMobile.substring(0,(strMobile.length - 1));
				strEmail = strEmail.substring(0,(strEmail.length - 1));
				strRtx = strRtx.substring(0,(strRtx.length - 1));
				document.getElementById("tname1").value = str;
				document.getElementById("post1").value = strPost;
				document.getElementById("mobile1").value = strMobile;
				document.getElementById("email1").value = strEmail;
				document.getElementById("rtx1").value = strRtx;
				return true;
			}else{
				return false;
			}
		} 
		
		function chooseProDiv() {
			//检查必填内容
			if(!checkone()){
				return;
			}
			
			var checkCPA = "";
			var inputObject = document.getElementsByName("t_name1");
			for (var i=0; i<inputObject.length; i++){
				var obj = inputObject[i];
				if ("checkbox" == obj.type && obj.checked){
					checkCPA += (obj.value+",");
				}
			}
			checkCPA = checkCPA.substring(0,checkCPA.lastIndexOf(","));
			var text = document.getElementById("userId");
			text.innerHTML = checkCPA;
			
			divObj = document.getElementById("divProduce");
			blockObj =  document.getElementById("divBlock_cjr");
			divObj.style.display = "none";
			blockObj.style.display = "none";
		}
		
		function hiddenProDiv() {
			divObj = document.getElementById("divProduce");
			blockObj =  document.getElementById("divBlock_cjr");
			divObj.style.display = "none";
			blockObj.style.display = "none";
		}

		// 检查是不是上传了附件		
		function f_check(){
			var indexId = "${uploadAttachId}";
			var module = "k_TesterComposition";
			var url="${pageContext.request.contextPath}/common/testerComposition.do?method=checkFile";
			var request = "&indexId="+indexId+"&module="+module; 
			var resText = ajaxLoadPageSynch(url,request);
			return resText; 
		}
		
		function saveProcedure(){
			var rs = f_check();
			if(rs=="N"){
				if(confirm("您确定不上传附件吗？不上传请点击确定，否则点击取消！")){
					// 先清空参加人,只保存复选框中的 人 
					var userId = document.getElementById("userId");
					userId.value = document.getElementById("tname1").value;
					// 去掉前后 , 号
					if(userId.value.substring(0,1)==","){
						userId.value= userId.value.substring(1,userId.value.length);
					}
					if(userId.value.substring(userId.value.length-1,userId.value.length)==","){
						userId.value= userId.value.substring(0,userId.value.length-1);
					}

					getUserId();  //  得到对应选中人员的 编号
					
					f_save();
					
				}else{
					var divObj = document.getElementById("divProduce");
					var blockObj =  document.getElementById("divBlock_cjr");
					divObj.style.display = "none";
					blockObj.style.display = "none";
				}
			}else{
				// 先清空参加人,只保存复选框中的 人 
				if(checkone()){
					var userId = document.getElementById("userId");
					userId.value = document.getElementById("tname1").value;
					// 去掉前后 , 号
					if(userId.value.substring(0,1)==","){
						userId.value= userId.value.substring(1,userId.value.length);
					}
					if(userId.value.substring(userId.value.length-1,userId.value.length)==","){
						userId.value= userId.value.substring(0,userId.value.length-1);
					}
					getUserId();  //  得到对应选中人员的 编号
					
					f_save();
				}
			}
			
		}
		
		// 控制新添加的人和原来textarea中的值
		function f_calc(){
			var tname1 = document.getElementById("tname1").value;
			var userId = document.getElementById("uids").value;     // 始终保持最开始的那个值   进行比较
			var tnames = tname1.split(",");
			var userIds = userId.split(",");
			var h = 0;
			var temp = "";
			for(var i=0;i<tnames.length;i++){
				h = 0;
				for(var j=0;j<userIds.length;j++){
					if(tnames[i]==userIds[j]){      // 原来的textarea中已经有选中的人了   去掉重复
						h = 1;	
					}
				}
				if(h==0){							// 原来的textarea中没有选中的人了
					temp = temp+tnames[i]+",";
				}
			}
			return temp;
		}
		
		
		
		// 获取参加人编号和名称
		function getUserId(){
			var uid = document.getElementsByName("t_name1");
			var tempId = "";
			var tempName = "";
			for(var i=0;i<uid.length;i++){
				if(uid[i].checked){
					tempId = tempId + uid[i].loginid+",";
					tempName = tempName + uid[i].value+",";
				}
			}
			document.getElementById("tid2").value=tempId;
			document.getElementById("tname2").value=tempName;
		}
		 
		// 查看已报名人数 
		function viewCount(){
			var noticeId = document.getElementById("noticeId").value;
			var testerlimit = document.getElementById("testerlimit").value;
			var oBao = new ActiveXObject("Microsoft.XMLHTTP");
			var url="${pageContext.request.contextPath}/common/training.do?method=viewCount&noticeId="+noticeId;
			oBao.open("POST",url,false);     
			oBao.send();
			var resText = oBao.responseText;    // 已报名人数 
			if(resText*1>=testerlimit*1){
				alert("报名人数已满!");
				return false;
			}else{
				var tname = document.getElementById("userId").value;
				var tnames = tname.split(',');
				
				var valid = testerlimit*1-resText*1;    // 剩余 报名数
				if(tnames.length>valid){
					if(resText==0){
						alert("报名人数不能高于限定人数!");
					}else{
						alert("已报名"+resText*1+"个人,只能报"+valid+"个人了!");
					}
					return false;
				}else{
					return true;
				}
			}
		}

		// 取消报名
		function f_cancle(){
			if(confirm("确定取消报名吗?")){
				var noticeId = document.getElementById("noticeId").value;
				var oBao = new ActiveXObject("Microsoft.XMLHTTP");
				var url="${pageContext.request.contextPath}/common/testerComposition.do?method=delete&noticeId="+noticeId;
				oBao.open("POST",url,false);     
				oBao.send();
				var resText = oBao.responseText;    // 已报名人数 

				if(resText>0){
					alert("取消报名成功！");
				}else{
					alert("取消报名失败！");
				}
				window.location.reload();
			}
		}		
		
		// 检查人员通知	5年里受惩戒的注师不能报名
		function f_isPunish(loginname,cpano,t){
			var query_String = "&cpano=" + cpano;
			var url = "${pageContext.request.contextPath}/common/testerNotice.do?method=isPunish";
			var result = ajaxLoadPageSynch(url,query_String);
			if(result != "Y" ){
				alert("注师"+loginname+"5年内受到惩戒，不能报名!");
				t.checked = false;
				return false;
			}
			return true;
		}
		
		
		// 修改报名
		function f_updateBM(){
			var rs = f_checkBM();
			if(rs=="N"){
				alert("省注协已批准,不能再修改报名,如果需要修改报名请联系省注协！");
			}else{
				setName();
			}
		}
		
		// 取消报名
		function f_cancelBM(){
			var rs = f_checkBM();
			if(rs=="N"){
				alert("省注协已批准,不能再取消报名,如果需要取消报名请联系省注协！");
			}else{
				f_cancle()
			}
		}
		
		// 检查报名
		function f_checkBM(){
			var tntId = "${tnt.id}";
			var query_String = "&id=" + tntId;
			var url = "${pageContext.request.contextPath}/common/testerNotice.do?method=checkState";
			var result = ajaxLoadPageSynch(url,query_String);
			return result;
		}
		
		//返回
		function f_back(){
			document.location="${pageContext.request.contextPath}/common/document.do?method=companyTesterNoticeList";
		}
		
</script>
</html>