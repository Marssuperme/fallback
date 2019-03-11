<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<%@ include file="/Sys_INCLUDE/calendar_include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>业务分析统计</title>

<style>
.gridFrame {
		width: 100%; 
		height:500px;
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
</head>
<body>
<form action="" method="post" name="myform" id="myform"> 
		
	<div style="width:98%;">
	 	 
	    <div class="gridFrame">
		    <div id="search" class="tools">
		   
					 	
				 			&nbsp;&nbsp;&nbsp;&nbsp;<input id="pass" icon='icon-query' type='button' onclick="f_search();" value='查询'>
				 			&nbsp;&nbsp;&nbsp;&nbsp;<input id="pass" icon='icon-retry' type='button' onclick="f_clear();" value='清空'>
			
		    	<table border="0" align="left">
		    		<tr >
		    			
						<td style="width:150px;">
				    		<font size="20" >委托项目类型：</font> &nbsp;
				    		</td>
				    		
				    		<td style="width:300px;">
				    		<input id="wtxmlx" name="wtxmlx" 
				    			noinput=true
								onkeydown="onKeyDownEvent();"
								onkeyup="onKeyUpEvent();"
								onclick="onPopDivClick(this);"
								norestorehint=true
								autoid=32
								refer='<c:if test="${userSession.userMap.officetype=='事务所' }">0</c:if><c:if test="${userSession.userMap.officetype=='评估所' }">1</c:if>'
								hideresult=true>
						</td>
						
						
						
						<td style="width:150px;">
				    		<!-- <font size="20" >报备年度：</font> &nbsp; -->
				    	</td >
				    	<td style="width:300px;"><%-- <input id="bgnd" name="bgnd" value="${bgnd }"					
								onkeydown="onKeyDownEvent();"
								onkeyup="onKeyUpEvent();"
								onclick="onPopDivClick(this);"
								norestorehint=true
								autoid=3
								hideresult=true> --%>
						</td> 
						
					 </tr>
					 
					 
					 
					 <tr>
		    			<td>
				    		<font size="20" >委托单位：</font> &nbsp;
				    		</td>
				    		<td><input id="wtdw" name="wtdw"  style="height: 0px;" onfocus="onPopDivClick(this);" 
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												norestorehint=true
												autoid=30
												refer="${loginid}"
												hideresult=true >
						</td> 
						<td>
				    		&nbsp;&nbsp;&nbsp;&nbsp;<font size="20" >被审（验）单位：</font> &nbsp;</td>
				    		<td>
				    		<input id="bsydw" name="bsydw"  style="height: 0px;" onfocus="onPopDivClick(this);" 
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												norestorehint=true
												autoid=31
												refer="${loginid}"
												hideresult=true >
						</td>
						
					 </tr>
					 
					 
					 
					 <tr>
		    			<td>
				    		<font size="20" >客户出资类型：</font> &nbsp;</td>
				    		<td>
				    		<input id="khczlx" name="khczlx"  style="height: 0px;" onfocus="onPopDivClick(this);" 
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												norestorehint=true
												noinput=true
												autoid=4
												hideresult=true>
						</td> 
						<td>
				    		&nbsp;&nbsp;&nbsp;&nbsp;<font size="20" >客户经济性质：</font> &nbsp;</td>
				    		<td>
				    		<input id="khjjxz" name="khjjxz" style="height: 0px;" onfocus="onPopDivClick(this);"
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												norestorehint=true
												noinput=true
												autoid=11
												hideresult=true>
						</td>
						
					 </tr>
					 
					 
					 
					 <tr>
		    			<td>
				    		<font size="20" >客户行业类型：</font> &nbsp;</td>
				    		<td>
				    		<input id="khhylx" name="khhylx"  style="height: 0px;" onfocus="onPopDivClick(this);"
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												norestorehint=true
												autoid=55
												noinput=true
												refer="dic_kmhylx"
												hideresult=true>
						</td> 
						<td>
				    		&nbsp;&nbsp;&nbsp;&nbsp;<font size="20" >是否上市企业：</font> &nbsp;</td>
				    		<td>
				    		<input id="sfssqy" name="sfssqy" onfocus="onPopDivClick(this);"
						    					autoWidth=190
						    					autoHeight=180
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												norestorehint=true
												autoid=13
												noinput=true
												hideresult=true>
						</td>
						
					 </tr>
					 
					 <tr>
		    			<td>
				    		<font size="20" >报告&nbsp;意见&nbsp;类型：</font> &nbsp;</td>
				    		<td>
				    		<input id="bgyjlx" name="bgyjlx" onfocus="onPopDivClick(this);"
									    					autoWidth=180
									    					autoHeight=180
															onkeydown="onKeyDownEvent();"
															onkeyup="onKeyUpEvent();"
															onclick="onPopDivClick(this);"
															norestorehint=true
															autoid=7
															noinput=true
															hideresult=true style="height: 0px;">
						</td> 
						<td>
				    		&nbsp;&nbsp;&nbsp;&nbsp;<font size="20" >报&nbsp;&nbsp;&nbsp;备&nbsp;&nbsp;&nbsp;&nbsp;状&nbsp;&nbsp;&nbsp;态：</font> &nbsp;</td>
				    	<td>
				    		<input id="bbstate" name="bbstate" autoWidth=190
			    					autoHeight=180
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=55
									noinput=true
									refer="bbzt" >
						</td>
						
					 </tr>
					 
					 
					 
					 <tr>
		    			<td>
				    		<font size="20" >业&nbsp;&nbsp;务&nbsp;&nbsp;所&nbsp;在&nbsp;地：</font> &nbsp;
				    	</td>
				    	<td>
				    		<input id="ywarea" name="ywarea" autoWidth=190
			    					autoHeight=180
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=10 >
						</td> 
						<td>
				    		<!-- &nbsp;&nbsp;&nbsp;&nbsp;<font size="20" >是否上市企业：</font> &nbsp;
				    		 -->
				    	</td>	 
				    	<td>
				    		<!-- <input id="sfssqy" name="sfssqy" onfocus="onPopDivClick(this);"
						    					autoWidth=190
						    					autoHeight=180
												onkeydown="onKeyDownEvent();"
												onkeyup="onKeyUpEvent();"
												onclick="onPopDivClick(this);"
												norestorehint=true
												autoid=13
												hideresult=true> -->
						</td>
						
					 </tr>
					 
					 
					 <tr>
					 	<c:if test="${userSession.userMap.officetype=='事务所' }">
						 	<td>
						 		<input type="radio" id="mh" name="mhdw" value="mh" checked="checked" onclick="chose_type(this);">
									&nbsp;签名注师模糊查询&nbsp;&nbsp;
							</td>
							<td>	
								<input type="radio" id="dw" name="mhdw" value="dw" onclick="chose_type(this);">&nbsp;签名注师定位查询
						 	</td>
						</c:if>
						<c:if test="${userSession.userMap.officetype=='评估所' }">
							<td>
						 		<input type="radio" id="mh" name="mhdw" value="mh" checked="checked" onclick="chose_type(this);">
									&nbsp;签名评估师模糊查询&nbsp;&nbsp;
							</td>
							<td>	
								<input type="radio" id="dw" name="mhdw" value="dw" onclick="chose_type(this);">&nbsp;签名评估师定位查询
						 	</td>
						</c:if>
					 	
					 	<td>
					 		 
					 	</td>
					 	<td>
					 	 
					 	</td>
					 
					 </tr>
					 
					 <tr class="mh">
					 	<td>
					 		<c:if test="${userSession.userMap.officetype=='事务所' }">
					 			签&nbsp;名&nbsp;注&nbsp;师/&nbsp;cpa：
					 		</c:if>
					 		<c:if test="${userSession.userMap.officetype=='评估所' }">
					 			签&nbsp;名&nbsp;评&nbsp;估&nbsp;师：
					 		</c:if>
					 	</td>
					 	<td>
					 		<input maxlength="50" title="" size="20" name="qmzs" id="qmzs" onfocus="onPopDivClick(this);"
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
					 	
					 	</td>
					 	
					 	<td>
					 	
					 	</td>
					 
					 
					 </tr>
					 
					 <tr align="left" id="double1" style="display:none " class="dw">
							<td>
								<c:if test="${userSession.userMap.officetype=='事务所' }">
									签名注师1/cpa1：
								</c:if>
								<c:if test="${userSession.userMap.officetype=='评估所' }">
									签名评估师1：
								</c:if>
							</td>
							<td>
								<input class="dw" maxlength="50" title="" size="20" name="qmzs1" id="qmzs1" onfocus="onPopDivClick(this);"
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
								<c:if test="${userSession.userMap.officetype=='事务所' }">
									签名注师2/cpa2：
								</c:if>
								<c:if test="${userSession.userMap.officetype=='评估所' }">
									签名评估师2：
								</c:if>
							</td>
							<td><input class="dw" maxlength="50" title="签名注师2" size="20" name="qmzs2" id="qmzs2" onfocus="onPopDivClick(this);"
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
						
						<tr align="left" id="double2" style="display: none" class="dw">
							<td>
								<c:if test="${userSession.userMap.officetype=='事务所' }">
									签名注师3/cpa3：
								</c:if>
								<c:if test="${userSession.userMap.officetype=='评估所' }">
									签名评估师3：
								</c:if>
							</td>
							<td>
								<input class="dw" maxlength="50" title="签名注师3" size="20" name="qmzs3" id="qmzs3" onfocus="onPopDivClick(this);"
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
								<c:if test="${userSession.userMap.officetype=='事务所' }">
									签名注师4/cpa4：
								</c:if>
								<c:if test="${userSession.userMap.officetype=='评估所' }">
									签名评估师4：
								</c:if>
							</td>
							<td>
								<input class="dw" maxlength="50" title="签名注师4" size="20" name="qmzs4" id="qmzs4" onfocus="onPopDivClick(this);"
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
						
						<tr align="left" id="double3" style="display:none " class="dw">
							<td>
								<c:if test="${userSession.userMap.officetype=='事务所' }">
									签名注师5/cpa5：
								</c:if>
								<c:if test="${userSession.userMap.officetype=='评估所' }">
									签名评估师5：
								</c:if>
							</td>
							<td>
							<input class="dw" maxlength="50" title="签名注师5" size="20" name="qmzs5" id="qmzs5" onfocus="onPopDivClick(this);"
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
								<c:if test="${userSession.userMap.officetype=='事务所' }">
									签名注师6/cpa6：
								</c:if>
								<c:if test="${userSession.userMap.officetype=='评估所' }">
									签名评估师6：
								</c:if>
							</td>
							<td>
								<input class="dw" maxlength="50" title="签名注师6" size="20" name="qmzs6" id="qmzs6" onfocus="onPopDivClick(this);"
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
					 
					 <tr>
					 	<td>业务约定书收费金额：</td>
						<td>
							<input id="ysywf1" name="ysywf1" onkeyup="isDigit(this)" style="width:80px;" class="qian">
							至
							<input id="ysywf2" name="ysywf2" onkeyup="isDigit(this)" style="width:80px;" class="qian">
							万元<font color="#FF0000">（*只能填写数字）</font>
						</td>
						
						<td>&nbsp;&nbsp;&nbsp;&nbsp;已收业务费：</td>
						<td>
							<input id="ysywf11" name="ysywf2" onkeyup="isDigit(this)" style="width:80px;" class="qian">
							至
							<input id="ysywf12" name="ysywf2" onkeyup="isDigit(this)" style="width:80px;" class="qian">
							万元<font color="#FF0000">（*只能填写数字）</font>
						</td>
					 
					 </tr>	
					 
					 <tr align="left">
							<td>报备时间：</td>
							<td>
								<input id="bbtime1" name="bbtime1" showcalendar="true" style="width:95px;" class="time">
							 &nbsp;至 
								<input id="bbtime2" name="bbtime2" showcalendar="true" style="width:95px;" class="time">
								<br/>
								<font color="#FF0000">只支持选择</font>
								
							</td>
							
							
							<td>&nbsp;&nbsp;&nbsp;&nbsp;报告日期：</td>
							<td>
								<input id="bgtime1" name="bbtime" showcalendar="true" style="width:95px;" class="time">
							 &nbsp;至 
								<input id="bgtime2" name="bbtime2" showcalendar="true" style="width:95px;" class="time">
								<br/>
								<font color="#FF0000">只支持选择</font>
							</td>
						</tr>	
					 	
					 	
					  
				</table>
					
		    </div>
		    
		    <br><br>
		    
		    
		    <div style="width:100%;overflow:auto;height:1000px;" id="content"> 
		    	<%-- <mt:DataGridPrintByBean name="content"/> --%>
		    	<iframe src="${pageContext.request.contextPath}/common/content/listcontent.jsp"
					width="100%" height="100%" id="contentFrame" name="contentFrame" frameborder="0" scrolling="yes" >
				</iframe>
		    	
		    </div>
		</div>
		
	</div>
</form>
</body>


<script type="text/javascript">

var view;
	function f_search(){
		
		/* document.getElementById("myform").action = "${pageContext.request.contextPath}/common/content.do?method=index&p=ywfxtj"; 
		document.getElementById("myform").submit(); */
		var j=0;

		$("#search input[type='text']").each(function(){ 
    		if(!Testing($(this).val())){
    			j=1;
    			return false;
    		}
    		
  		});
		if(j==1){
			return false;
		};
		
		
		var t=Math.random();
		
		var bgnd=$("#bgnd").val();
		var wtxmlx=$("#wtxmlx").val();
		
		var wtdw=$("#wtdw").val();
		var bsydw=$("#bsydw").val();
		
		var khczlx=$("#khczlx").val();
		var khjjxz=$("#khjjxz").val();
		
		var khhylx=$("#khhylx").val();
		var sfssqy=$("#sfssqy").val();
		
		var bgyjlx=$("#bgyjlx").val();
		var bbstate=$("#bbstate").val();
		
		var ywarea=$("#ywarea").val();
		
		
		
		var qmzs=$("#qmzs").val();
		
		var qmzs1=$("#qmzs1").val();
		var qmzs2=$("#qmzs2").val();
		var qmzs3=$("#qmzs3").val();
		
		var qmzs4=$("#qmzs4").val();
		var qmzs5=$("#qmzs5").val();
		var qmzs6=$("#qmzs6").val();
		
		var ysywf1=$("#ysywf1").val();
		var ysywf2=$("#ysywf2").val();
		
		var ysywf11=$("#ysywf11").val();
		var ysywf12=$("#ysywf12").val();
		
		var bbtime1=$("#bbtime1").val();
		var bbtime2=$("#bbtime2").val();
		
		
		var bgtime1=$("#bgtime1").val();
		var bgtime2=$("#bgtime2").val();
		
		//alert(view);
		$.ajax({
			url:"content.do?method=index&p=ywfxtj&t="+t,
			async:false,
			type: "post",
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			data:{"bgnd":bgnd,"wtxmlx":wtxmlx,
				"wtdw":wtdw,"bsydw":bsydw,
				"khczlx":khczlx,"khjjxz":khjjxz,
				"khhylx":khhylx,"sfssqy":sfssqy,
				"bgyjlx":bgyjlx,"bbstate":bbstate,
				"ywarea":ywarea,"qmzscpa":view,
				"qmzs":qmzs,
				"qmzs1":qmzs1,"qmzs2":qmzs2,
				"qmzs3":qmzs3,"qmzs4":qmzs4,
				"qmzs5":qmzs5,"qmzs6":qmzs6,
				"ysywf1":ysywf1,"ysywf2":ysywf2,
				"ysywf11":ysywf11,"ysywf12":ysywf12,
				"bbtime1":bbtime1,"bbtime2":bbtime2,
				"bgtime1":bgtime1,"bgtime2":bgtime2},
			success:function(data){
				document.getElementById("contentFrame").src="${pageContext.request.contextPath}/common/content/listcontent.jsp";
				
			}
		});
	}

 	function go_this(id){ 
 		window.location="${pageContext.request.contextPath}/common/bb.do?method=index&typeid="+id;
 	}
 	function chose_type(obj){
 		var id=obj.id;
 		view=id;
 		if("dw"==id){
 			$(".mh").css("display","none");
 			$("#qmzs").val("");
 			$(".dw").css("display","block");
 		}
 		if("mh"==id){
 			$(".dw").css("display","none");
 			$(".dw").val("");
 			$(".mh").css("display","block");
 		}
 	}
 	
 	function f_clear(){
 			
 			$("input[type=text]").each(function(){
 				
 				$(this).val("");
 			});
 	}
 	
 	$(function(){
 		$(".time").keyup(function(){
 			$(this).val("");
 		});
 	});
 	
 	$(function(){
 		$(".qian").keyup(function(){
 			var v=$(this).val();
 			var t=/^\d*$/;
 			var t2=/^\d*\.\d{0,}$/;
 			if(t.test(v)||t2.test(v)){
 				
 			}else{
 				$(this).val("");
 				
 			}
 		});
 	});
</script>
</html>