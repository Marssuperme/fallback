function initHtmlbox(id,width,height) {
		var oWidth = width || "100%" ;
		var oHidth = height || "100%" ;
		
		if(!document.getElementById(id)) {
			alert("element:"+id+ " not found!");
			return ;
		}
	
		$("#"+id).css("height",oHidth).css("width",oWidth).htmlbox({
	    	toolbars:[
			    [
				// Cut, Copy, Paste
				"separator","cut","copy","paste",
				// Bold, Italic, Underline, Strikethrough, Sup, Sub
				"separator","bold","italic","underline","strike","sup","sub",
				// Left, Right, Center, Justify
				"separator","justify","left","center","right",
				// Ordered List, Unordered List, Indent, Outdent
				"separator","ol","ul","indent","outdent",
				// Hyperlink, Remove Hyperlink, Image
				"separator","link","unlink","image"
				],
				[// Show code
		
		        // Formats, Font size, Font family, Font color, Font, Background
		        "separator","formats","fontsize","fontfamily",
				"separator","fontcolor","highlight"
				]
		],
		skin:"blue",
		idir:CONTEXT_PATH+"/images/htmlbox/"
	});
	
}


function myWindowOpen(url, target, param) {

	var targetTemp = "_blank";
	var paramTemp = "channelmode=1, resizable=yes,toolbar=no,menubar=no,titlebar=no,scrollbars=yes";

	if (target != "") {
		targetTemp = target;
	}

	if (param != "") {
		paramTemp = param;
	}
	window.open(url, targetTemp, paramTemp);
}

function reinitIframe(id){
	var iframe = document.getElementById(id);
	try{
		var bHeight = iframe.contentWindow.document.body.scrollHeight;
		if(bHeight<700){
			bHeight = 700;
		}
		iframe.height =  bHeight;
	}catch (ex){}
}

//-----------------------------------
// 把表单内的input拼成url字符串返回
//-----------------------------------
function formToRequestString(form_obj) {
	var query_string='';
	var and='';
	//alert(form_obj.length);
	for (i=0;i<form_obj.length ;i++ ) {
		e=form_obj[i];
		if ((e.tagName=='INPUT' || e.tagName=='SELECT' || e.tagName=='TEXTAREA') && e.name!='') {
			if (e.type=='select-one') {
				element_value=e.options[e.selectedIndex].value;
			} else if (e.type=='checkbox' || e.type=='radio') {
				if (e.checked==false) {
					//break;
					continue;
				}
				element_value=e.value;
			} else {
				element_value=e.value;
			}
			query_string+=and+e.name+'='+element_value.replace(/\&/g,"%26");
			and="&"
		}

	}
	return query_string;
}

//异步
function ajaxLoadPage(url,request,container) {
	var loading_msg='正在加载数据,请稍候...';
	var loader;

	try {
		loader = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
		try {
			loader = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (e2) {
			loader = false;
		}
	}

	loader.open("POST",url,true);
	loader.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	loader.onreadystatechange = function(){
		if (loader.readyState==1) {
			container.innerHTML=loading_msg;
			try {
				showWaiting("100%","100%");
			} catch(e) {

			}
		}

		if (loader.readyState==4) {
			container.innerHTML=loader.responseText;

			try {
				stopWaiting();
			} catch(e) {

			}
		}
	}

	loader.send(request);
}

//同步
function ajaxLoadPageSynch(url,request) {

	var loader;

	try {
		loader = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
		try {
			loader = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (e2) {
			loader = false;
		}
	}

	loader.open("POST",url,false);
	loader.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	loader.send(request);

	return unescape(loader.responseText);
}
