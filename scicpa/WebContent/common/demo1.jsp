<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp" %>

<html>
<head>


<style type="text/css">
* { font-family: Verdana; font-size: 96%; }
label { width: 10em; float: left; }
label.error { float: none; color: red; padding-left: .5em; vertical-align: top; }
p { clear: both; }
.submit { margin-left: 12em; }
em { font-weight: bold; padding-right: 1em; vertical-align: top; }
</style>
  <script>
  //加验证
  $(document).ready(function(){
    $("#commentForm").validate();
  });
  
  //加输入限制
  $(document).ready(function(){
    $("input.zipcode").mask("999999");
  });  
  
  </script>
  
</head>
<body>
  

 <form class="cmxform" id="commentForm" method="get" action="">
 <fieldset>
   <legend>A simple comment form with submit validation and default messages</legend>
   <p>
     <label for="cname">Name</label>
     <em>*</em><input id="cname" name="name" size="25" class="required" minlength="2" />
   </p>
   <p>
     <label for="cemail">E-Mail</label>
     <em>*</em><input id="cemail" name="email" size="25"  class="email" />
   </p>
   <p>
     <label for="curl">URL</label>
     <em>  </em><input id="curl" name="url" size="25"  class="required url" value="" />
   </p>
   
   <p>
     <label for="curl">日期：</label>
     <em>  </em><input id="cdate" name="date" size="25"  class="date" value="" />有值才校验有效性，必填加required
   </p>

   <p>
     <label for="curl">货币</label>
     <em>  </em><input id="cnum" name="num" size="25"  class="number" value="" />有值才校验有效性，必填加required
   </p>   
   
   <p>
     <label for="curl">整数</label>
     <em>  </em><input id="hb1" name="hb1" size="25"  class="digits" value="" />有值才校验有效性，必填加required
   </p>
   
   <p>
     <label for="curl">重复输入整数</label>
     <em>  </em><input id="hb2" name="hb2" equalTo="#hb1"  size="25"  class="digits" value="" />两次录入的验证
   </p>
   
   <p>
     <label for="curl">电话号码</label>
     <em>  </em><input id="phone" name="phone" size="25"  class="phone" value="" />
   </p>
   
   <p>
     <label for="curl">身份证号码</label>
     <em>  </em><input id="aa" name="aa" size="25"  class="personcard" value="" />
   </p>
   
   <p>
     <label for="ccomment">Your comment</label>
     <em>*</em><textarea id="ccomment" name="comment" cols="22"  class="required"></textarea>
   </p>
   <p>
     <label for="ccomment">Zipcode</label>
     <em>*</em><input id="czipcode" name="zipcode" cols="22"  class="required zipcode"></input>
   </p>
   <p>
     <input class="submit" type="submit" value="Submit"/>
   </p>
 </fieldset>
 </form>
</body>
</html>