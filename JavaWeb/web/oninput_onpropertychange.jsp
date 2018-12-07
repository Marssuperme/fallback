<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body >

	<div align="center">
	
		<strong>监听事件：	HTML5 --> oninput(), 	IE9以下  -->  onpropertychange()</strong>
		
		<br><br><br>
	
		a:	<input type="text" id="aa" oninput="change()" onpropertychange="change()"/>
		
		<br><br><br>
		
		b:	<input type="text" id="bb" oninput="change()" onpropertychange="change()"/>
		
		<br><br><br>
		
		a + b = <span id="cc"></span>
	
	</div>
	
	<script type="text/javascript">
	
		function change(){
			
			var aa = document.getElementById('aa').value;
			
			var bb = document.getElementById('bb').value;
			
			var cc = Number(aa) + Number(bb);
			
			document.getElementById('cc').innerHTML = cc;
			
		}

	</script>

</body>
</html>