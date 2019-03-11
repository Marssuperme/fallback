<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>座位号信息</title>
<style>
.gridFrame {
	width: 100%; 
	height:55%;
	border: #c3daf9 1px solid;
	float: left;
	margin-left: 5px ;
	padding: 5px ;
}
</style>
</head>
<body>
<div id="divBlock" style="position:absolute;width:100%;height:100%; z-index:0; padding:10px; background:#ffffff;filter:alpha(opacity=50); text-align:center; display:none;"></div>
<form name="myform" id="myform" action="" method="post" > 
<input type="hidden" id="p" name="p">
<input type="hidden" id="id" name="id">
  <div class="gridFrame">	 
     	<div class="tools">
		    	&nbsp;<input icon="icon-query" type="button" onclick="f_search();" value="查询">
	    </div>
	    
		<div id="search" style="position:absolute;width:60%;height:15%; z-index:0;left:expression((document.body.clientWidth-400)/2);top:expression(this.offsetParent.scrollTop + 70); border:1px solid #6595d6; padding:1px; background:#ffffff; display: none;">
		    <br>
		    <fieldset  style="border: 1px solid lightblue;width:95%;height: 70%;margin-left: 2px;" id="fieldset">
				<legend>
					搜索条件
				</legend>
				<table align="center" style="margin-left: 30px;">
		    		<tr>
		    			<td style="text-align: right;">培训班：</td>
		    			<td width="280px;">
		    				<!--  
		    				<input id="trainingname" name="trainingname" onfocus="onPopDivClick(this);"
		    				        size="35"
				   					autoWidth=200
									autoHeight=260
									onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);"
									autoid=61>
							-->		
							<div style="margin-top: -12px;">
								 <select id="s_trainingname" name="s_trainingname" style="position:absolute;width:260px;height:15px;clip:rect(0 260 110 130);" onchange='document.all.trainingname.value=this.options[this.selectedIndex].value;'>
								 	<option value="">=====清空=====</option> 
								 	<c:forEach var="trainName" items="${trainNameList}">
								 		<option value="${trainName}">${trainName}</option>   
								 	</c:forEach>
								 </select>
								 <input id="trainingname" name="trainingname" type="text" style="position:absolute;width:242px;height:21px;">
							 </div>  
							 
		    			</td>
		    		</tr>
		    		<tr>
		    			<td style="text-align: right;">座位号：</td>
		    			<td width="280px;">
		    				<input id="seatno" name="seatno" style="width: 242px">
		    			</td>
		    		</tr>
		    		<tr>
		    			<td style="text-align: right;">CPA证号 \ 姓名：</td>
		    			<td width="280px;">
		    				<input id="cpa" name="cpa" style="width: 242px">
		    			</td>
		    		</tr>
		    	</table>
		    	<br>
	    		<table width="90%" style="margin-left: 30%;">
					<tr>
						<td>
							<input id="pass" icon="icon-success" type="button" onclick="f_sure()" value="确定">
					    	&nbsp;&nbsp;&nbsp;&nbsp; 
					    	<input id="pass" icon="icon-retry" type="button" onclick="f_clear()" value="清空">
					    	&nbsp;&nbsp;&nbsp;&nbsp; 
					    	<input id="pass" icon="icon-delete" type="button" onclick="f_quxiao();" value="取消">
					    </td>
					</tr>
		    	</table>
	    	</fieldset>
	    </div>
	    
	   <div style="width:100%;overflow:auto;height:600px;"> 
	   		<mt:DataGridPrintByBean name="seatNoList"/>
	   </div>
 </div>
 </form>
</body>
<script type="text/javascript">
	
	//加载培训班
	function f_loadTrainingName(){
		var ctypeTabName = "${ctypeTabName}";
		var url="${pageContext.request.contextPath}/common/training.do?method=getTrainingName";
		var request = "&ctypeTabName="+ctypeTabName;
		var resText = ajaxLoadPageSynch(url,request);
		var obj_array = eval('('+resText+')');
		var training_array = obj_array;
        var objSelect = document.getElementById("s_trainingname"); 
        for(var i=0;i<training_array.length;i++){
	        // 取得字段值 
	        var strName = training_array[i]; 
	        var strValue = training_array[i]; 
	        // 建立Option对象 
	        var objOption = new Option(strName,strValue); 
            objSelect.add(objOption,i);
	    }
	}
	
	// 搜索 
	function f_search(){
		document.getElementById("search").style.display = "";
		document.getElementById("divBlock").style.display = "";
	}
	
	// 取消
	function f_quxiao(){
		document.getElementById("search").style.display = "none";
		document.getElementById("divBlock").style.display = "none";
	}
	
	// 清空
	function f_clear(){
		document.getElementById("cpa").value = "";
		document.getElementById("trainingname").value = "";
		document.getElementById("seatno").value = "";
		f_quxiao();
		goSearch("seatNoList");
	}
	
	// 确定 
	function f_sure(){
		f_quxiao();
		goSearch("seatNoList");
	}
	
	
	// 加载培训班
	// f_loadTrainingName();

</script>
</html>
