var sqlWhereVariables_dicList = new Array();
var DATAGRID_CHANGE_PATH = CONTEXT_PATH + "/common/common.do?method=datagrid";
var DATAGRID_EXPEXCEL_PATH = CONTEXT_PATH + "/common/common.do?method=expExcel";

function setChooseValue_CH(dgName,chooseValue){
   var i = 0;
   var str = "";
   var oChooses = document.getElementsByName("choose_" + dgName);
   var j = oChooses.length;
   for(i = 0; i < j; i++){
      if(oChooses[i].checked == true){
         str = str + oChooses[i].value + ',';
      }
	}
	str = str.substring(0,(str.length - 1));
	document.getElementById("chooseValue_" + dgName).value = str;
}
function changeGrid_CH(dgName,tp,vl) {
	var oBao = new ActiveXObject("Microsoft.XMLHTTP"); 
	oBao.open("POST",DATAGRID_CHANGE_PATH + "&csn=" + dgName + "&random=" + Math.random(),false); 
	oBao.setRequestHeader("Content-type","application/x-www-form-urlencoded"); 
	oBao.send("tp=" + tp + "&vl=" + vl + "&xml="+encodeURIComponent(document.getElementById("page_xml_" + dgName).value)); 
	var oResponseText = unescape(oBao.responseText); 
	document.getElementById(dgName + '_td').innerHTML=oResponseText; 
} 
function changeGrid_CH_1(dgName,tp,vl) {
	var oBao = new ActiveXObject("Microsoft.XMLHTTP"); 
	oBao.open("POST",DATAGRID_CHANGE_PATH + "&csn="+dgName+ "&forcetofirstpage=1&random=" + Math.random(),false); 
	oBao.setRequestHeader("Content-type","application/x-www-form-urlencoded"); 
	oBao.send("tp=" + tp + "&vl=" + vl + "&xml=" + encodeURIComponent(document.getElementById("page_xml_" + dgName).value)); 
	var oResponseText = unescape(oBao.responseText); 
	document.getElementById(dgName + '_td').innerHTML = oResponseText
}
function goSearch(dgName) {
  var sv = '';
  var sqlWhereVariables = eval("sqlWhereVariables_" + dgName);
  	for(var i=0;i<sqlWhereVariables.length;i++){
   		var oTT=document.getElementById(sqlWhereVariables[i]);
  		if(!oTT) {
  			continue;
  		}
   		sv = sv + "<" + sqlWhereVariables[i] + ">" + oTT.value + "</"+sqlWhereVariables[i]+">";
	}
	changeGrid_CH_1(dgName, 'sqlWhereVariable_CH', sv);
}
function goClean_CH(dgName){
	var sv='';
	var sqlWhereVariables = eval("sqlWhereVariables_" + dgName);
	for(var i = 0; i < sqlWhereVariables.length; i++){
		var oTT=document.getElementById(sqlWhereVariables[i]);
		if(!oTT) {
			continue;
		}
  	
  		oTT.value = "";
		sv = sv + "<" + sqlWhereVariables[i] + ">" + "</" + sqlWhereVariables[i] + ">";
	}
  
   	changeGrid_CH(dgName, 'sqlWhereVariable_CH', sv);
}
function goRefresh_CH(dgName){
   	changeGrid_CH(dgName, 'refresh_CH', '');
}
function onKeyDownPage(){
   switch (event.keyCode) {
   case 13: break; 
   case 8: 
   case 9: 
   case 35: 
   case 36: 
   case 37: 
   case 39: 
   case 46: return true;
   }
   if (!(event.keyCode >= 48 && event.keyCode <= 57 ) &&!(event.keyCode >= 96 && event.keyCode <= 105 )){
      event.returnValue = false;
      return false;
   }else{
      event.returnValue = true;
   }
}

function getRecords(dgName,tp,vl){
	if(event.keyCode==13){
   		var temp=/^[0-9]*[1-9][0-9]*$/;
		if(!temp.test(vl)) {
			alert('输入错误,请输入大于0小于等于500的整数!!');
			return false; 
		}
		if(vl*1 > 500) { 
		 	alert('输入错误,请输入大于0小于等于500的整数!!'); 
			return false; 
		} 
   		changeGrid_CH(dgName,tp,vl);
		return true;
	}else{
		return false;
	}
}

function selectAll_CH(dgName, oCbx){
	var cbxValue = oCbx.checked;         
	var table = document.getElementById(dgName);
	var oInput = table.document.getElementsByName("choose_" + dgName);
	for(var i = 0; i < oInput.length; i++){
		oInput[i].checked = cbxValue;  
	}
	setChooseValue_CH(dgName);
}
function orderby_CH(dgName, orderField){
	if(event.ctrlKey){
		changeGrid_CH(dgName, 'orderByAdd_CH', orderField) 
	} else {    
		changeGrid_CH(dgName, 'orderBy_CH', orderField) 
	}
}
function addOrderby_CH(dgName, orderField, direction_CH){
	if(direction_CH == "ASC"){
		changeGrid_CH(dgName, 'orderByAdd_CH_ASC', orderField) 
	} else {
		changeGrid_CH(dgName, 'orderByAdd_CH_DESC', orderField) 
	}
}
function nothing() {
}
function setScrollTop(){
	document.getElementsByTagName("body")[0].scrollTop =9999; 
}

function dgTdMouseOut(tdObj) {
	with(tdObj.style) {
		textDecoration = "none";
		cursor = "none";
	}
}

function dgTdMouseOver(tdObj) {
	with(tdObj.style) {
		textDecoration = "underline";
		cursor = "hand";
	}
}

function expExcel(tableId, fileName) {
	var expForm = document.getElementById("expForm_" + tableId);
	
	if(!expForm) {
		//var formStr = "<form id='expForm_'" + tableId + " name='expForm_" + tableId + "'>";
		var formStr = "";
		formStr += "<input type=\"hidden\" id=\"expTableID_" + tableId + "\" name=\"expTableID\" value=\"\" />";
		formStr += "<input type=\"hidden\" id=\"expSql_" + tableId + "\" name=\"expSql\" value=\"\" />";
		formStr += "<input type=\"hidden\" id=\"expDisplayColName_" + tableId + "\" name=\"expDisplayColName\" value=\"\" />";
		formStr += "<input type=\"hidden\" id=\"expColName_" + tableId + "\" name=\"expColName\" value=\"\" />";
		formStr += "<input type=\"hidden\" id=\"fileName_" + tableId + "\" name=\"fileName\" value=\"\" />";
		
		var expForm = document.createElement('form');
		expForm.id = "expForm_" + tableId;
		expForm.name = "expForm_" + tableId;
		expForm.method = "post";
		expForm.action = DATAGRID_EXPEXCEL_PATH;
   		expForm.innerHTML = formStr;
   		document.body.appendChild(expForm);
	}
	
	document.getElementById("expTableID_" + tableId).value = document.getElementById("dgExpTableID_" + tableId).value;
	document.getElementById("expSql_" + tableId).value = document.getElementById("dgExpSql_" + tableId).value;
	document.getElementById("expDisplayColName_" + tableId).value = document.getElementById("dgExpDisplayColName_" + tableId).value;
	document.getElementById("expColName_" + tableId).value = document.getElementById("dgExpColName_" + tableId).value;
	document.getElementById("fileName_" + tableId).value = fileName;

	expForm.submit();
}