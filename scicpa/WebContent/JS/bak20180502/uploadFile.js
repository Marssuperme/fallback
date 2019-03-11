/**
 * @category   javascript
 * @package    jquery
 * @author     Bill
 * @copyright  Copyright (c) 2006-2008 Matech. (http://www.matech.cn)
 * @version    1.0
 * @requires jQuery Library >= 1.4.1 (may work with older versions)
 * 
 *  * Usage:
 *    e.g. <code>$('#test').uploadFile(options)</code>
 *    	  options 参数定义如下:
 *        module: 附件所属模块名称（如对应人员模块 User）.
 *        indexId:对应模块明细的主键（如人员A的ID为12，人员B的ID为19）.
 *        ExtentName：允许上传附件的扩展名（default：gif,jpg,jpeg,bmp,png,rar,doc,xls,zip,docx,xlsx,ppt,pdf,txt）.
 *        forbitUpload:是否显示继续上传附件按钮.
 *        forbitDel:是否允许删除附件.
 */ 
(function ($){
	
	function getFileNameByPath(path) {
		if(path.indexOf("\\") > -1) { 
			return path.substring(path.lastIndexOf("\\")+1);
		}else {
			return path ;
		} 
	}
	
	function getFileExtentName(fileName) {
		if(fileName.indexOf(".") > -1) { 
			return fileName.substr(fileName.lastIndexOf(".")+1);
		}else {
			return fileName ;
		}
	}
	
	function showBlockDiv() {
		var blockDiv = document.getElementById("divBlock");

		if (blockDiv) {
			blockDiv.style.display = "";
		} else {
			var div = document.createElement("div");
			document.body.appendChild(div);
			div.id = "divBlock";
			div.style.cssText = "position:absolute;width:100%;height:100%; top:0px; left:0px; z-index:1; padding:0px; margin:0px; background:#000000;filter:alpha(opacity=30); text-align:center;";
			
		}
	}
	
	function hideBlockDiv() {
		var blockDiv = document.getElementById("divBlock");
		if (blockDiv) {
			try {
				blockDiv.style.display = "none";
				document.body.removeChild(blockDiv);
			}catch(e){}
		}
	}
	
	// 隐藏进度条DIV
	function hideProBarDiv() {
		var progressBar = document.getElementById("progressBar");
		if (progressBar) {
			try {
				progressBar.style.display = "none";
				document.body.removeChild(progressBar);
			}catch(e){}
		}
	}
		
	
	function initListener() {
		
		var progressStatusText = document.getElementById("progressBar");
		var divBlock = document.getElementById("divBlock");
		if(divBlock){
			divBlock.style.display = "" ;
		}
		progressStatusText.style.left = window.document.body.clientWidth /2 -150;
        progressStatusText.style.top = window.document.body.clientHeight /2 -150;
		progressStatusText.style.visibility = "visible";
		
		startUpload() ;
	}  
		
	// 进度条
	function startUpload(){   
	    timer = window.setTimeout(startListener,700);   
	    return true;   
	}
	
	var timer;   
	function startListener(){
	    var xmlhttp;   
	    try{   
	        xmlhttp = new ActiveXObject('Msxm12.XMLHTTP');   
	    }catch(e){   
	        try{   
	            xmlhttp = new ActiveXObject('Microsoft.XMLHTTP');   
	        }catch(e){   
	            try{   
	                xmlhttp = new XMLHttpRequest();   
	            }catch(e){}   
	        }   
	    }
	     
	    var progressStatusText = document.getElementById("progressBar");   
	   	xmlhttp.open("post",CONTEXT_PATH+"/common/uploadProcess.do?method=fileUploadProcess&beanName=datauploadBean",true);     
     	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");   
     	xmlhttp.onreadystatechange = function(){   
	        if(xmlhttp.readyState == 4){   
	            if(xmlhttp.status == 200){
		            progressStatusText.innerHTML = ""; 
		            progressStatusText.style.visibility = "visible";
		            progressStatusText.style.left = window.document.body.clientWidth /2 -150;
		            progressStatusText.style.top = window.document.body.clientHeight /2 -150;  
		            progressStatusText.innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;"+xmlhttp.responseText;   
		            var temp = xmlhttp.responseText.indexOf("上传成功");
		            if ( temp > 0 ){   
		            	hideBlockDiv();
		            	hideProBarDiv();
		           		window.clearTimeout(timer);   
		            }else{   
		            	timer = window.setTimeout(startListener,300);   
		            }   
	            }   
	        }   
	    }   
	    xmlhttp.send(null);   
	}  
	
	$.downloadFile = function(obj,downloadCallback) {
		var fileTempName = obj.fileTempName ;
		var indexTable = obj.indexTable ;
		var indexId = obj.indexId ;
		
		$("#downloadForm").attr("action",CONTEXT_PATH+"/common/uploadProcess.do?method=download" +
								"&fileTempName="+fileTempName+"&indexTable="+indexTable+"&indexId="+indexId) ;
		if(downloadCallback){
			var res = downloadCallback();
			if(res){
				$("#downloadForm").submit();
			}
		}else {
			$("#downloadForm").submit();
		}
		
	}
	
	$.deleteFile = function(obj) {
		var $obj = $(obj);
		var fileTempName = $obj.prev().attr("fileTempName") ;
		var indexTable = $obj.prev().attr("indexTable") ;
		var indexId = $obj.prev().attr("indexId") ; 
		
		var url = CONTEXT_PATH+"/common/uploadProcess.do?method=deteleFile&fileTempName="+fileTempName+"&indexTable="+indexTable+"&indexId="+indexId+"&random="+Math.random();
		$.post(url,null,function(data){
			if(data == "suc") {
				alert("文件删除成功!") ;
			}else if(data == "fail"){
				alert("文件删除失败!") ;
			}else {
				alert("您要删除的文件不存在,请联管理员!");
			}
			//移除页面的内容
			$obj.parent().remove();
		});
	}
	
	$.updateAttr = function (fileTempName,mark,module,indexId) {
		$("#downA"+module+indexId+mark).attr("fileTempName",fileTempName);
	}
	
	$.fn.uploadFile = function (options) {
	
		hideProBarDiv();
		
		var defaults = {
			ExtentName : "gif,jpg,JPG,jpeg,bmp,png,rar,doc,xls,zip,docx,xlsx,ppt,pdf,txt",
			forbitDel:false,
			forbitUpload:false
		}
		var options = $.extend(defaults,options);
		
		if(options.indexId == null || options.indexId =="") {
			alert("上传控件初始化错误，缺少indexId参数！");
			return ;
		}
		
		if(options.module == null || options.module =="") {
			alert("上传控件初始化错误，缺少module参数！");
			return ;
		}
		var $this = $(this) ;
		
		var $upload = $("<a href=\"#\">上传附件</a>");
		
		//从后台中取出相关附件
		var j = 0 ;
		$.getJSON(CONTEXT_PATH+"/common/uploadProcess.do?method=getFiles&indexTable="+options.module+"&indexId="+options.indexId+"&random="+Math.random(),function(data){
				
			  $.each(data, function(i,item){
			  		var fileHtml = "<div style=\"text-align:left;line-height:30\"><img src=\""+CONTEXT_PATH+"/icons/attach.png\">" 
			  					+"<a id=\"downA"+options.module+options.indexId+i+"\" name=\"down"+options.module+"\" fileTempName=\""+item.fileTempName+"\" indexTable=\""+options.module+"\"  indexId=\""+options.indexId+"\"" 
			  					+ "href=\"###\" title=\"点击下载文件\">"+item.fileName + "</a>" ;
			  		
			  		if(!options.forbitDel) {
			  			fileHtml += "<img onclick=\"$.deleteFile(this);\" title=\"点击删除文件\" src=\""+CONTEXT_PATH+"/images/del.gif\" style=\"cursor:hand;\"/>" ;
			  		}
						fileHtml +=	"</div>" ;
					$this.append($(fileHtml));
					$("#downA"+options.module+options.indexId+i).click(function(){
			  			$.downloadFile(this,options.onDownload);
			  		})
					j = i ;
			  });
		});
		
		//$(document.body).append($(pbarDiv));
		
		var $fileUploadDiv = $("<div class=\"file_upload\"><div class=\"file_upload_title\">文件上传</div></div>") ;
		$(document.body).append($fileUploadDiv);
		var $form = $("<form method=\"post\" encType=\"multipart/form-data\" style=\"margin:0px;padding:0px;\"></form>"); 
		var $file = $("<input type=\"file\" name=\"file\" style=\"width:100%;margin-bottom:10px;\">");
		var $uploadBtn = $("<input type=\"button\" id=\"upload_Btn\" class=\"common\" value=\"上传\" >");
		var $cancleBtn = $("<input type=\"button\" class=\"common\" value=\"取消\">");
		$fileUploadDiv.append($form);
		$form.append($file);
	
		
		var $mark = $("<input type=\"hidden\" value=\"\" id=\"mark\" name=\"mark\">");
		var $indexTable =$("<input type=\"hidden\" value=\""+options.module+"\" id=\"indexTable\" name=\"indexTable\">")
		var $indexId =$("<input type=\"hidden\" value=\""+options.indexId+"\" id=\"indexId\" name=\"indexId\">")
		var $mainId =$("<input type=\"hidden\" value=\""+options.mainId+"\" id=\"mainId\" name=\"mainId\">")
		$form.append($mark); //页面文件的索引
		$form.append($indexTable);
		$form.append($indexId);
		$form.append($mainId);
		$form.append($uploadBtn);
		$form.append($cancleBtn);
		$form.attr("action",CONTEXT_PATH+"/common/uploadProcess.do?method=attachFileUpload&beanName=datauploadBean");
		$form.attr("target","attachHidden_frame") ;
		$form.attr("encoding","multipart/form-data") ;
		$cancleBtn.click(function(){
			$fileUploadDiv.css("display","none");
			hideBlockDiv();
		}) ;
		$uploadBtn.click(function(){
			j++ ;
			$mark.val(j);
			if($file.val() == "") {
				alert("请选择要上传的文件！");
				return ;
			}
			var fileName = getFileNameByPath($file.val()) ;
			var fileExtentName = getFileExtentName(fileName);
			var allowExtentName = options.ExtentName ;
			if(allowExtentName.indexOf(fileExtentName) == -1) {
	 			alert("不允许上传扩展名为"+fileExtentName+"的文件");
	  			return ;
 			}
 			
 			//  进度条
 			initListener();
 			
 			$form.submit();
 			
			var fileHtml = "<div style=\"text-align:left;line-height:30\"><img src=\""+CONTEXT_PATH+"/icons/attach.png\">" 
						 +"<a id=\"downA"+options.module+options.indexId+j+"\" name=\"down"+options.module+"\" indexTable=\""+options.module+"\"  indexId=\""+options.indexId+"\" href=\"###\" title=\"点击下载文件\">"+fileName
						 + "</a>" ;
			if(!options.forbitDel) {
				fileHtml += "<img onclick=\"$.deleteFile(this);\" title=\"点击删除文件\" src=\""+CONTEXT_PATH+"/images/del.gif\" style=\"cursor:hand;\"/>";
			}
			fileHtml +="</div>";
			$this.append($(fileHtml));
			$("#downA"+options.module+options.indexId+j).click(function(){
	  			$.downloadFile(this,options.onDownload);
	  		})
	  		document.getElementById("progressBar").style.display = "";
			$fileUploadDiv.css("display","none");
			//hideBlockDiv();
			
		}) ;
		$upload.click(function(){
			$fileUploadDiv.css("display","block");
			showBlockDiv();
		}) ;
		if(!options.forbitUpload) {
			$this.append($upload);
			var pbarDiv = "<div id=\"progressBar\" class=\"coolDiv\" style=\"display:none;\" oncontextmenu=\"return false;\">"
						+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;正在上传...0% <div class=\"prog-border\"><div class=\"prog-bar\" style=\"width: 0%;\"></div></div>&nbsp;&nbsp;&nbsp;"
			 			+ "</div>";
			$this.append($(pbarDiv));
		}
		
		$this.append($("<iframe name=\"attachHidden_frame\" id=\"attachHidden_frame\" style=\"display:none\"></iframe>"));
		$(document.body).append($("<form name=\"downloadForm\" id=\"downloadForm\" method=\"post\" target=\"attachHidden_frame\"></form>"));
	};
})(jQuery) ;