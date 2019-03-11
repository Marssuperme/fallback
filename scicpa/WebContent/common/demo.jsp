<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>

<form method="POST" id="test" name="test" action="http://www.163.com/test.jsp">
  <p>校验数字:
  			<input type="text" name="T1" id="T1" size="20" class="required validate-digits"  title="请输入数字！" 
  
						onfocus="onPopDivClick(this);"
						onkeydown="onKeyDownEvent();"
						onkeyup="onKeyUpEvent();"
						onclick="onPopDivClick(this);"
						norestorehint=true
						autoid=2
						hideresult=true
  
  			></p>
  			
  <p>校验金额:<input type="text" name="T2" id="T2" size="20" class="required"  title="请输入金额！" ></p>
  
    <p>校验金额11:<input type="text" name="kk" id="kk" size="20" myClass="required"  title="请输入金额！" ></p>
  
  <p>校验日期:<input type="text" name="T3" id="T3" size="20" class="required"  title="请输入日期！" showcalendar="true"></p>
  <p>校验邮箱:<input type="text" name="T4" id="T4" size="20" class="required"  title="请输入email！" ></p>
  <p>校验电话:<input type="text" name="T4" id="T4" size="20" class="required"  ></p>

  <p>请输入密码:<input type="password" name="password" id="password" size="20" class="required"  title="请输入密码" ></p>
  <p>校验密码:<input type="password" name="repassword" id="repassword" size="20" class="required validate-passwd-identical"  title="两次输入密码不一致！" ></p>
  
  <p><textarea rows="2" name="S1" id="S1" cols="20" class="required"  title="请输入，不得为空" ></textarea></p>
  <p><input type="checkbox" name="C1" id="C1" value="ON" class="required"  title="请输入，不得为空"></p>
  <p><input type="radio" value="V1" id="R1" name="R1" class="required"  title="请输入，不得为空"></p>
  
  <p><input type="submit" id=opSave value="使用submit按钮提交" name="B1" >
  <input type="button" value="使用form.submit()提交"  onclick="t1()" name="B3">
  <input type="button" value="只校验，不提交"  onclick="t2()" name="B3">
  <input type="button" value="动态改变一个输入的样式" name="B4"  onclick="t3()">
</form>

<script type="text/javascript">

  $(document).ready(function(){
    $("#test").validate();
    
    $("input.zipcode").mask("99999");
    
  });


function t1(){
	if (test.fireEvent('onsubmit'))
		test.submit();
}

function t2(){
	test.fireEvent('onsubmit');
}


function t3(){

	$("input").each(function(index,obj){
			if (obj.myClass){
				alert(obj.myClass);
				obj.className = obj.myClass;
			}
		});

}
</script>