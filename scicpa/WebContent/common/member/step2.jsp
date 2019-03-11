<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ include file="/Sys_INCLUDE/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>会员自助服务平台</title>

<style >
.a_pic { color: transparent; text-decoration: none; }
.a_word {color: black; text-decoration: none; }
.a_word:HOVER{color: blue;}
.border {border: 2px solid red}
.noborder {border: 0px}
* {
	font-family: "宋体";
	font-size:16px;	
}
</style>

</head>
<body >
<form id="myform" name="myform" method="post" >
	<input type="hidden" id="typeId" name="typeId" >
	<input type="hidden" id="idNumber" name="idNumber" >
	<input type="hidden" id="departName" name="departName" >
	<input type="hidden" id="ctypeTabName" name="ctypeTabName" >
	<input type="hidden" id="loginId" name="loginId" >
	<input type="hidden" id="officeCode" name="officeCode" >
</form>

<%
String typeId = request.getParameter("typeId"); 
String idNumber = request.getParameter("idNumber"); 
String ctypeTabName = request.getParameter("ctypeTabName"); 
String detailTypeId = request.getParameter("detailTypeId"); 
String departName = request.getParameter("departName"); 
String loginId = request.getParameter("loginId"); 
String officeCode = request.getParameter("officeCode"); 
%>

<div id="bs" style="display: none">

	<div style="width: 1234px;height: 995px;">
		<img src="step2_bg.jpg" style="width: 102%;height: 102%;background-repeat: no-repeat;" >
	</div> 
	 
	<div style="position: absolute;z-index: 1;width: 230px;height: 45px;left: 90px;top: 265px;" >
		<a href="###" onFocus="this.blur()" class="a_pic" onclick="f_clickModel('bs_zn')" >
			<div id="bs_zn_div" class="border">
				<img src="step2_02_1.jpg" style="width: 100%;height: 100%;border: 0px">
			</div>
		</a>
	</div>
	
	<div style="position: absolute;z-index: 1;width: 230px;height: 45px;left: 90px;top: 365px;">
		<a href="###" onFocus="this.blur()" class="a_pic" onclick="f_clickModel('bs_nj')">
			<div id="bs_nj_div" >
				<img src="step2_03.jpg" style="width: 100%;height: 100%;border: 0px">
			</div>
		</a>
	</div>
	
	<div style="position: absolute;z-index: 1;width: 230px;height: 45px;left: 90px;top: 465px;">
		<a href="###" onFocus="this.blur()" class="a_pic" onclick="f_clickModel('bs_dy')">
			<div id="bs_dy_div" >
				<img src="step2_04.jpg" style="width: 100%;height: 100%;border: 0px">
			</div>
		</a>
	</div>
	
	<div style="position: absolute;z-index: 1;width: 230px;height: 45px;left: 90px;top: 565px;">
		<a href="###" onFocus="this.blur()" class="a_pic" onclick="f_clickModel('zs_kq_kq')">
			<div id="zs_kq_kq_div" >
				<img src="step2_03_1.jpg" style="width: 100%;height: 100%;border: 0px">
			</div>
		</a>
	</div>
	
	<div style="position: absolute;z-index: 1;width: 200px;height: 65px;left: 105px;top: 675px;">
		<a href="###" onFocus="this.blur()" class="a_pic" onclick="f_exit()">
			<img src="step2_exit.jpg" style="width: 100%;height: 100%;border: 0px">
		</a>
	</div>
	
	<div style="position: absolute;z-index: 1;width: 160px;height: 60px;left: 1000px;top: 185px;" onclick="f_openKey()">
		<div style="position: absolute;z-index: 1;top: 60px;left:60px">
			<font color="red" style="font-size: 23;font-weight: bolder">激活键盘</font>
		</div>
		<a href="###" onFocus="this.blur()" class="a_pic" title="小键盘" >
			<img src="keyboard.jpg" style="width: 200px;height: 160px;border: 0px">
		</a>
	</div>
	
	<div id="bs_zn" style="position: absolute;z-index: 1;width: 730px;height: 40px;left: 390px;top: 255px;">
		<span style="margin-left: 30px;">
			<img src="step2_07.jpg" style="width: 28px;height: 25px;vertical-align: middle;">
			<font color="red">办事指南信息</font>
		</span> 
		<ul style="list-style-type: none;letter-spacing: 2px;line-height: 33px;margin-top: 2px;">
			<li><font color="red">1．</font><a href="###" class="a_word" onclick="this.blur();f_goBSZN('hyb')">会员部</a></li>
			<li><font color="red">2．</font><a href="###" class="a_word" onclick="this.blur();f_goBSZN('kpb')">考试培训部</a></li>
		</ul>
	</div>
	
	<div id="hyb_bs_zn" style="position: absolute;z-index: 1;width: 730px;height: 40px;left: 390px;top: 255px;display: none">
		<span style="margin-left: 30px;">
			<img src="step2_07.jpg" style="width: 28px;height: 25px;vertical-align: middle;">
			<font color="red">财政会计行业管理系统操作步骤</font>
		</span> 
		<ul style="list-style-type: none;letter-spacing: 2px;line-height: 33px;margin-top: 2px;">
			<!-- 
			<li><font color="red">1．</font><a href="###" class="a_word" onclick="this.blur();f_goPart('rzzgczbz')">任职资格检查申请网上操作步骤</a></li>
			 -->
			<li><font color="red">1．</font><a href="###" class="a_word" onclick="this.blur();f_goPart('kjszsczbz','hyb')">注册会计师转所网上操作步骤</a></li>
			<li><font color="red">2．</font><a href="###" class="a_word" onclick="this.blur();f_goPart('sqzcczbz','hyb')">申请注册会计师注册网上操作步骤</a></li>
		</ul>
		
		<span style="margin-left: 30px;">
			<img src="step2_07.jpg" style="width: 28px;height: 25px;vertical-align: middle;">
			<font color="red">会员办事指南</font>
		</span> 
		<ul style="list-style-type: none;letter-spacing: 2px;line-height: 33px;margin-top: 2px;">
			<li><font color="red">1．</font><a href="###" class="a_word" onclick="this.blur();f_goPart('zckjszc','hyb')">注册会计师注册</a></li>
			<li><font color="red">2．</font><a href="###" class="a_word" onclick="this.blur();f_goPart('zckjszs','hyb')">注册会计师转所</a></li>
			<li><font color="red">3．</font><a href="###" class="a_word" onclick="this.blur();f_goPart('grxxbd','hyb')">个人会员信息变更</a></li>
			<li><font color="red">4．</font><a href="###" class="a_word" onclick="this.blur();f_goPart('swsxxbg','hyb')">会计师事务所信息变更</a></li>
			<li><font color="red">5．</font><a href="###" class="a_word" onclick="this.blur();f_goPart('sjywzm','hyb')">拟担任会计师事务所股东或合伙人的注册会计师办理从事审计业务证明</a></li>
			<li><font color="red">6．</font><a href="###" class="a_word" onclick="this.blur();f_goPart('xzsgg','hyb')">省注协关于为非执业会员换发新证书的公告</a></li>
			<li><font color="red">7．</font><a href="###" class="a_word" onclick="this.blur();f_goPart('szxgyyf','hyb')">省注协关于印发《广东省注册会计师协会非执业会员管理办法》的通知</a></li>
		</ul>
		
		<span style="margin-left: 640px;margin-top: 50px">
			<a href="###" onclick="f_goBack('bszn_hyb');" onFocus="this.blur()" class="a_pic">
				<img src="back.jpg" style="width: 140px;height: 45px;border: 0px">
			</a>
		</span>
	</div>
	
	<div id="kpb_bs_zn" style="position: absolute;z-index: 1;width: 730px;height: 40px;left: 390px;top: 255px;display: none">
		<div id="kpb_detail_bs_zn">
			<span style="margin-left: 30px;">
				<img src="step2_07.jpg" style="width: 28px;height: 25px;vertical-align: middle;">
				<font color="red">考试培训部的办事指南</font>
			</span> 
			<ul style="list-style-type: none;letter-spacing: 2px;line-height: 33px;margin-top: 2px;">
				<li><font color="red">1．</font><a href="###" class="a_word" onclick="this.blur();f_kpb_bszn('pxglzn')">培训管理规定</a></li>
				<li><font color="red">2．</font><a href="###" class="a_word" onclick="this.blur();f_kpb_bszn('ksglzn')">考试管理规定</a></li>
			</ul>
			<div style="margin-left: 640px;margin-top: 350px">
				<a href="###" onclick="f_goBack('bszn_kpb');" onFocus="this.blur()" class="a_pic">
					<img src="back.jpg" style="width: 140px;height: 45px;border: 0px">
				</a>
			</div>
		</div>

		<div id="kpb_detail_bs_zn_px" style="position: absolute;z-index: 1;width: 730px;height: 350px;display: none;">
			<span style="margin-left: 30px;">
				<img src="step2_07.jpg" style="width: 28px;height: 25px;vertical-align: middle;">
				<font color="red">培训管理规定</font>
			</span> 
			<ul style="list-style-type: none;letter-spacing: 2px;line-height: 33px;margin-top: 2px;">
				<li><font color="red">1．</font><a href="###" class="a_word" onclick="this.blur();f_down_print('pxglzn_zgkjsjxjy','pxglzn')">中国注册会计师继续教育制度</a></li>
				<li><font color="red">2．</font><a href="###" class="a_word" onclick="this.blur();f_down_print('pxglzn_gdskjsjxjy','pxglzn')">广东省注册会计师继续教育管理制度</a></li>
				<li><font color="red">3．</font><a href="###" class="a_word" onclick="this.blur();f_down_print('pxglzn_fzyjxjy','pxglzn')">非执业会员继续教育暂行办法</a></li>
			</ul>
			<div style="margin-left: 640px;margin-top: 317px">
				<a href="###" onclick="f_goBack('bszn_kpb_pxglzn');" onFocus="this.blur()" class="a_pic">
					<img src="back.jpg" style="width: 140px;height: 45px;border: 0px">
				</a>
			</div>
		</div>
		
		<div id="kpb_detail_bs_zn_ks" style="position: absolute;z-index: 1;width: 730px;height: 350px;display: none">
			<span style="margin-left: 30px;">
				<img src="step2_07.jpg" style="width: 28px;height: 25px;vertical-align: middle;">
				<font color="red">考试管理规定</font>
			</span> 
			<ul style="list-style-type: none;letter-spacing: 2px;line-height: 33px;margin-top: 2px;">
				<li><font color="red">1．</font><a href="###" class="a_word" onclick="this.blur();f_down_print('ksglzn_jkrygzgz','ksglzn')">监考人员工作规则</a></li>
				<li><font color="red">2．</font><a href="###" class="a_word" onclick="this.blur();f_down_print('ksglzn_ksglgzzn','ksglzn')">考试管理工作指南</a></li>
				<li><font color="red">3．</font><a href="###" class="a_word" onclick="this.blur();f_down_print('ksglzn_kwgzgz','ksglzn')">考务工作规则</a></li>
				<li><font color="red">4．</font><a href="###" class="a_word" onclick="this.blur();f_down_print('ksglzn_wgxwclgz','ksglzn')">违规行为处理规程</a></li>
				<li><font color="red">5．</font><a href="###" class="a_word" onclick="this.blur();f_down_print('ksglzn_ykrykcsz','ksglzn')">应考人员考场守则</a></li>
				<li><font color="red">6．</font><a href="###" class="a_word" onclick="this.blur();f_down_print('ksglzn_ksggfa','ksglzn')">注册会计师考试改革方案</a></li>
				<li><font color="red">7．</font><a href="###" class="a_word" onclick="this.blur();f_down_print('ksglzn_tyksbf','ksglzn')">注册会计师全国统一考试办法</a></li>
				<li><font color="red">8．</font><a href="###" class="a_word" onclick="this.blur();f_down_print('ksglzn_kswgxwclbf','ksglzn')">注册会计师全国统一考试违规行为处理办法</a></li>
			</ul>
			<div style="margin-left: 640px;margin-top: 149px">
				<a href="###" onclick="f_goBack('bszn_kpb_ksglzn');" onFocus="this.blur()" class="a_pic">
					<img src="back.jpg" style="width: 140px;height: 45px;border: 0px">
				</a>
			</div>
		</div>
	
		
	</div>
	
	<div id="bs_nj" style="position: absolute;z-index: 1;width: 730px;height: 40px;left: 390px;top: 255px;display: none;">
		<iframe id="bs_nj_iframe" width="820px" height="385px" style= "border:1px solid lightblue;" frameborder=0></iframe>
	</div>
	
	<div id="bs_dy" style="position: absolute;z-index: 1;width: 730px;height: 40px;left: 390px;top: 255px;display: none;">
		<div id="bs_dy_detail" >
			<span style="margin-left: 30px;">
				<img src="step2_07.jpg" style="width: 28px;height: 25px;vertical-align: middle;">
				<font color="red">表格打印</font>
			</span> 
			<ul style="list-style-type: none;letter-spacing: 2px;line-height: 33px;margin-top: 2px;">
				<li><font color="red">1．</font><a href="###" class="a_word" onclick="this.blur();f_zs_bgdy('hyb')">会员部表格打印</a></li>
				<li><font color="red">2．</font><a href="###" class="a_word" onclick="this.blur();f_zs_bgdy('kpb')">考试培训部结业证书打印</a></li>
			</ul>
		</div>
		
		<div id="bs_dy_detail_hyb" style="width: 800px;display: none">			
			<ul style="list-style-type: none;letter-spacing: 2px;line-height: 35px;margin-top: 2px;">
				<li>
					注师注册：<a href="###" class="a_word" onclick="this.blur();f_down_print('zckjs_sqzczl','bgdy')">注册会计师申请注册材料  <IMG border=0 hspace=3 src="print.jpg" vspace=6 style="vertical-align: middle;"></a>
				</li>
				<li style="margin-top: 10px;">
					注师转所：<span><a href="###" class="a_word" onclick="this.blur();f_down_print('zckjs_zssqb','bgdy')">注册会计师转所申请表  <IMG border=0 hspace=3 src="print.jpg" vspace=6 style="vertical-align: middle;"></a></span><br>
							<span style="margin-left: 90px;"><a href="###" class="a_word" onclick="this.blur();f_down_print('zckjs_zsgrjlb','bgdy')">注册会计师转所个人简历表  <IMG border=0 hspace=3 src="print.jpg" vspace=6 style="vertical-align: middle;"></a></span><br>
							<span style="margin-left: 90px;"><a href="###" class="a_word" onclick="this.blur();f_down_print('zckjs_plzsb','bgdy')">注册会计师批量转所表  <IMG border=0 hspace=3 src="print.jpg" vspace=6 style="vertical-align: middle;"></a></span>
				</li>
				<li style="margin-top: 10px;">非执业会员入会：<a href="###" class="a_word" onclick="this.blur();f_down_print('fzyhy_djb','bgdy')">中国注册会计师协会非执业会员登记表  <IMG border=0 hspace=3 src="print.jpg" vspace=6 style="vertical-align: middle;"></a></li>
				<li style="margin-top: 10px;">非执业会员转会：<a href="###" class="a_word" onclick="this.blur();f_down_print('fzyhy_zhsqb','bgdy')">中国注册会计师协会非执业会员转会申请表  <IMG border=0 hspace=3 src="print.jpg" vspace=6 style="vertical-align: middle;"></a></li>
				<li style="margin-top: 10px;">
					会计师事务所信息变更：<span><a href="###" class="a_word" onclick="this.blur();f_down_print('kjsws_bgsxb','bgdy')">会计师事务所变更事项情况表  <IMG border=0 hspace=3 src="print.jpg" vspace=6 style="vertical-align: middle;"></a></span><br>
									  <span style="margin-left: 200px;"><a href="###" class="a_word" onclick="this.blur();f_down_print('kjsws_fsbgsxb','bgdy')">会计师事务所分所变更事项情况表  <IMG border=0 hspace=3 src="print.jpg" vspace=6 style="vertical-align: middle;"></a></span>  
				</li>
				<li style="margin-top: 10px;">办理从事审计业务证明：<a href="###" class="a_word" onclick="this.blur();f_down_print('blcs_sjywzmzl','bgdy')">办理从事审计业务证明资料  <IMG border=0 hspace=3 src="print.jpg" vspace=6 style="vertical-align: middle;"></a></li>
			</ul>
			<div style="margin-left: 640px;margin-top: 55px">
				<a href="###" onclick="f_goBack('bgdy_hyb');" onFocus="this.blur()" class="a_pic">
					<img src="back.jpg" style="width: 140px;height: 45px;border: 0px">
				</a>
			</div>
		</div>
		<div id="bs_dy_detail_kpb" style="width: 820px;display: none">			
			<iframe id="bm_print_iframe_jyzs" width="820px" height="385px" style= "border:1px solid lightblue;" frameborder=0></iframe>
			<div style="margin-left: 640px;margin-top: 55px">
				<a href="###" onclick="f_goBack('bgdy_kpb');" onFocus="this.blur()" class="a_pic">
					<img src="back.jpg" style="width: 140px;height: 45px;border: 0px">
				</a>
			</div>
		</div>
	</div>
	
	<div id="zs_kq_kq" style="position: absolute;z-index: 1;width: 730px;height: 40px;left: 390px;top: 255px;display: none;">
		<div id="zs_kq_seat_div">
			<span style="margin-left: 30px;">
				<img src="step2_07.jpg" style="width: 28px;height: 25px;vertical-align: middle;">
				<font color="red">培训查询信息</font>
			</span>
			<ul style="list-style-type: none;letter-spacing: 2px;line-height: 35px;margin-top: 2px;">
				<li><font color="red">1．</font><a href="###" class="a_word" onclick="this.blur();f_goXCKQ('bbm','zs_')">补报名</a></li>
				<!-- 
				<li><font color="red">2．</font><a href="###" class="a_word" onclick="this.blur();f_goXCKQ('kqqd','zs_')">考勤签到</a></li>
				 -->
				<li><font color="red">2．</font><a href="###" class="a_word" onclick="this.blur();f_goXCKQ('zwhcx','zs_')">座位号查询</a></li>
				<li><font color="red">3．</font><a href="###" class="a_word" onclick="this.blur();f_goXCKQ('kqjgcx','zs_')">考勤结果查询</a></li>
				<!--
				<li><font color="red">2．</font><a href="###" class="a_word" onclick="this.blur();f_goXCKQ('kqseatwh','zs_')">座位号维护</a></li>
				-->
			</ul>
		</div>
		<div id="zs_kq_seat_div_detail" style="display: none">
			<iframe id="zs_kq_seat_iframe" width="820px" height="385px" style= "border:1px solid lightblue;" frameborder=0></iframe>
			<div style="margin-left: 640px;margin-top: 55px">
				<a href="###" onclick="f_goBack('zs_kq_kq_cx');" onFocus="this.blur()" class="a_pic">
					<img src="back.jpg" style="width: 140px;height: 45px;border: 0px">
				</a>
			</div>
		</div>
	</div>
</div>


<div id="kq" style="display: none">
	<div style="width: 1234px;height: 995px;">
		<img src="step2_bg.jpg" style="width: 102%;height: 102%;background-repeat: no-repeat;" >
	</div> 
	 
	 <!-- 开启考勤 -->
	<div style="position: absolute;z-index: 1;width: 230px;height: 45px;left: 90px;top: 265px;">
		<a href="###" onFocus="this.blur()" class="a_pic" onclick="f_clickModel('kq_kqkq')">
			<div id="kq_kqkq_div" class="border">
				<img src="step2_02.jpg" style="width: 100%;height: 100%;border: 0px">
			</div>
		</a>
	</div>
	
	<div style="position: absolute;z-index: 1;width: 230px;height: 45px;left: 90px;top: 365px;">
		<a href="###" onFocus="this.blur()" class="a_pic" onclick="f_clickModel('kq_kq')">
			<div id="kq_kq_div" >
				<img src="step2_03_1.jpg" style="width: 100%;height: 100%;border: 0px">
			</div>
		</a>
	</div>
	
	<div style="position: absolute;z-index: 1;width: 230px;height: 45px;left: 90px;top: 465px;">
		<a href="###" onFocus="this.blur()" class="a_pic" onclick="f_clickModel('kq_dy')">	
			<div id="kq_dy_div" >
				<img src="step2_04.jpg" style="width: 100%;height: 100%;border: 0px">
			</div>
		</a>
	</div>
	
	<div style="position: absolute;z-index: 1;width: 200px;height: 65px;left: 105px;top: 580px;">
		<a href="###" onFocus="this.blur()" class="a_pic" onclick="f_exit()">
			<img src="step2_exit.jpg" style="width: 100%;height: 100%;border: 0px">
		</a>
	</div>
	
	<div style="position: absolute;z-index: 1;width: 130px;height: 40px;left: 1080px;top: 185px;" onclick="f_openKey()" >
		<div style="position: absolute;z-index: 1;top: 30px;left:16px;">
			<font color="red" style="font-size: 18;font-weight: bolder">激活键盘</font>
		</div>
		<a href="###" onFocus="this.blur()" class="a_pic" title="小键盘">
			<img src="keyboard.jpg" style="width: 120px;height: 80px;border: 0px">
		</a>
	</div>
	
	<div id="kq_kqkq" style="position: absolute;z-index: 1;width: 730px;height: 40px;left: 390px;top: 255px;">
		<div id="kq_kqkq_div_detail">
			<iframe id="kq_kqkq_iframe" width="820px" height="385px" style= "border:1px solid lightblue;" frameborder=0></iframe>
		</div>
	</div>
	
	<div id="kq_kq" style="position: absolute;z-index: 1;width: 730px;height: 40px;left: 390px;top: 255px;display: none;">
		<div id="kq_seat_div">
			<span style="margin-left: 30px;">
				<img src="step2_07.jpg" style="width: 28px;height: 25px;vertical-align: middle;">
				<font color="red">考勤查询信息</font>
			</span>
			<ul style="list-style-type: none;letter-spacing: 2px;line-height: 35px;margin-top: 2px;">
				<!-- 
				<li><font color="red">1．</font><a href="###" class="a_word" onclick="this.blur();f_goXCKQ('bbm','')">补报名</a></li>
				<li><font color="red">2．</font><a href="###" class="a_word" onclick="this.blur();f_goXCKQ('kqqd','')">考勤签到</a></li>
				 -->
				<li><font color="red">1．</font><a href="###" class="a_word" onclick="this.blur();f_goXCKQ('zwhcx','')">座位号查询</a></li>
				<li><font color="red">2．</font><a href="###" class="a_word" onclick="this.blur();f_goXCKQ('kqjgcx','')">考勤结果查询</a></li>
				<!--
				<li><font color="red">2．</font><a href="###" class="a_word" onclick="this.blur();f_goXCKQ('kqseatwh','')">座位号维护</a></li>
				-->
			</ul>
		</div>
		<div id="kq_seat_div_detail" style="display: none">
			<iframe id="kq_seat_iframe" width="820px" height="385px" style= "border:1px solid lightblue;" frameborder=0></iframe>
			<div style="margin-left: 640px;margin-top: 55px">
				<a href="###" onclick="f_goBack('zx_kq_kq_cx');" onFocus="this.blur()" class="a_pic">
					<img src="back.jpg" style="width: 140px;height: 45px;border: 0px">
				</a>
			</div>
		</div>
	</div>
	
	<div id="kq_dy" style="position: absolute;z-index: 1;width: 730px;height: 40px;left: 390px;top: 255px;display: none;">
		<div id="bm_print_div">
			<span style="margin-left: 30px;">
				<img src="step2_07.jpg" style="width: 28px;height: 25px;vertical-align: middle;">
				<font color="red">表格打印</font>
			</span>
			<ul style="list-style-type: none;letter-spacing: 2px;line-height: 35px;margin-top: 2px;">
				<!-- 
				<li><font color="red">1．</font><a href="###" class="a_word" onclick="this.blur();f_goprint('hz')">打印报名回执</a></li> 
				-->
				<li><font color="red">1．</font><a href="###" class="a_word" onclick="this.blur();f_goprint('jyzs')">打印结业证书</a></li>
			</ul>
		</div>
		<div id="bm_print_div_detail" style="display: none">
			<iframe id="bm_print_iframe" width="820px" height="385px" style= "border:1px solid lightblue;" frameborder=0></iframe>
			<div style="margin-left: 640px;margin-top: 55px">
				<a href="###" onclick="f_goBack('bm_print_zx');" onFocus="this.blur()" class="a_pic">
					<img src="back.jpg" style="width: 140px;height: 45px;border: 0px">
				</a>
			</div>
		</div>
	</div>
</div>


</body>

<script type="text/javascript">
	
	// 加载显示
	function f_controlDisplay(typeId){
		var bs_obj = document.getElementById("bs");
		var kq_obj = document.getElementById("kq");
		var ctypeTabName = "<%=ctypeTabName%>";
	 	var loginId = "<%=loginId%>";
	 	var officeCode = "<%=officeCode%>";
		if(typeId=="kq"){
			if(bs_obj){
				document.getElementById("bs").style.display = "none";
			}
			if(kq_obj){
				document.getElementById("kq").style.display = "";
				document.getElementById("kq_kqkq_div_detail").style.display = "";
				document.getElementById("kq_kqkq_iframe").src = "${pageContext.request.contextPath}/common/training.do?method=indexFromeHYJ&param=company&source=hyj_kqpxb&loginId="+loginId+"&officeCode="+officeCode+"&ctypeTabName="+ctypeTabName+"&optType=kqpxb&paremTemp="+Math.random();
			}
		}else{
			if(bs_obj){
				document.getElementById("bs").style.display = "";
				var detailTypeId = "<%=detailTypeId%>";
				if(detailTypeId!="" && detailTypeId!="null"){
					document.getElementById("bs_zn").style.display = "none";
					f_goBSZN(detailTypeId);
				}
			}
			if(kq_obj){
				document.getElementById("kq").style.display = "none";
			}
		}
	}
	
	// 身份证号
	var idNumber = "<%=idNumber%>";
	// 功能模块类型
	var typeId = "<%=typeId%>";
	// 加载
	f_controlDisplay(typeId);
	
	
	// 切换对应模块
	function f_clickModel(type){
		var modelArray = ["bs_zn","hyb_bs_zn","kpb_bs_zn","bs_nj","bs_dy","zs_kq_kq","kq_kqkq","kq_kq","kq_dy"];
		for(var i=0;i<modelArray.length;i++){
			if(modelArray[i]==type){
				if(document.getElementById(type+"_div")){
					document.getElementById(type+"_div").className = "border";
				}
				if(document.getElementById(type)){
					document.getElementById(type).style.display = "";
				}
				// 链接到 办事表格打印
				if(type=="bs_dy"){
					document.getElementById("bs_dy_detail").style.display = "";
					document.getElementById("bs_dy_detail_hyb").style.display = "none";
					document.getElementById("bs_dy_detail_kpb").style.display = "none";
					document.getElementById("bm_print_iframe_jyzs").src = "";
				}
				
				// 链接到 办事指南
				if(type=="bs_zn"){
					document.getElementById("hyb_bs_zn").style.display = "none";
					document.getElementById("kpb_bs_zn").style.display = "none";
					document.getElementById("kq_seat_iframe").src = "";
				}
				// 链接到 任职资格预查
				if(type=="bs_nj"){
					var ctypeTabName = "<%=ctypeTabName%>";
				 	var loginId = "<%=loginId%>";
				 	var officeCode = "<%=officeCode%>";
					document.getElementById("bs_nj_iframe").src = "${pageContext.request.contextPath}/common/inspection.do?method=company&type=hyj&loginid="+loginId+"&ctypetabname="+ctypeTabName+"&officecode="+officeCode+"&paremTemp="+Math.random();
				}
				// 注师登陆 考勤查询
				if(type=="zs_kq_kq"){
					document.getElementById("zs_kq_seat_div").style.display = "";
					document.getElementById("zs_kq_seat_div_detail").style.display = "none";
					document.getElementById("zs_kq_seat_iframe").src = "";
				}
				
				// 现场考勤
				if(type=="kq_kq"){
					document.getElementById("kq_seat_div").style.display = "";
					document.getElementById("kq_seat_div_detail").style.display = "none";
					document.getElementById("kq_seat_iframe").src = "";
				}
				// 考勤打印
				if(type=="kq_dy"){
					document.getElementById("bm_print_div").style.display = "";
					document.getElementById("bm_print_div_detail").style.display = "none";
					document.getElementById("bm_print_iframe").src = "";
				}
				
				// 开启考勤
				if(type=="kq_kqkq"){
					var ctypeTabName = "<%=ctypeTabName%>";
				 	var loginId = "<%=loginId%>";
				 	var officeCode = "<%=officeCode%>";
					document.getElementById("kq_kqkq").style.display = "";
					document.getElementById("kq_kqkq_div_detail").style.display = "";
					document.getElementById("kq_kqkq_iframe").src = "${pageContext.request.contextPath}/common/training.do?method=indexFromeHYJ&param=company&source=hyj_kqpxb&loginId="+loginId+"&officeCode="+officeCode+"&ctypeTabName="+ctypeTabName+"&optType=kqpxb&paremTemp="+Math.random();
				}
				
				
			}else{
				if(document.getElementById(modelArray[i]+"_div")){
					document.getElementById(modelArray[i]+"_div").className = "noborder";
				}
				if(document.getElementById(modelArray[i])){
					document.getElementById(modelArray[i]).style.display = "none";
				}
				document.getElementById("bm_print_iframe").src = "";
			}
		}
	}
	
	
	var AuditReport =  new ActiveXObject("AuditReportPoject.AuditReport");
	//---------------
	//获取主机地址
	//---------------
	function getlocationhost(){
		return "http:\/\/"+window.location.host;
	}

	
	
	// 详细信息
	function f_goPart(partId,detailTypeId){
		var ctypeTabName = "<%=ctypeTabName%>";
	 	var idNumber = "<%=idNumber%>";
	 	var departName = "<%=departName%>";
	 	var loginId = "<%=loginId%>";
	 	var officeCode = "<%=officeCode%>";
	 	
		document.getElementById("ctypeTabName").value = ctypeTabName;
	 	document.getElementById("idNumber").value = idNumber;
	 	document.getElementById("departName").value = departName;
	 	document.getElementById("loginId").value = loginId;
	 	document.getElementById("officeCode").value = officeCode;
	 	var param = "?ctypeTabName="+ctypeTabName+"&idNumber="+idNumber+"&departName="+departName+"&loginId="+loginId+"&officeCode="+officeCode+"&typeId="+typeId+"&partId="+partId+"&detailTypeId="+detailTypeId;
	 	var url = "${pageContext.request.contextPath}/common/member/step3.jsp" + param;
		
		//document.getElementById("myform").action = "${pageContext.request.contextPath}/common/member/step3.jsp?typeId="+typeId+"&partId="+partId+"&detailTypeId="+detailTypeId;
	 	//document.getElementById("myform").submit();
	 	
	 	//window.showModalDialog(url,"","dialogWidth=1300px;dialogHeight=1000px;location=no");
	 	//window.close();
	 	
	 	window.location = url; 
	} 
	
	// 返回
	function f_back(){
		document.getElementById("ctypeTabName").value = "<%=ctypeTabName%>";
	 	document.getElementById("idNumber").value = "<%=idNumber%>";
	 	document.getElementById("departName").value = "<%=departName%>";
	 	document.getElementById("loginId").value = "<%=loginId%>";
	 	document.getElementById("officeCode").value = "<%=officeCode%>";
		document.getElementById("myform").action = "${pageContext.request.contextPath}/common/member/step1.jsp";
	 	document.getElementById("myform").submit();
	}
	
	
	
	
	// 表格打印
	function f_down_print_bak(id,folderId){
		//window.open("${pageContext.request.contextPath}/common/member/openFile.jsp?&attachmentId="+id+"&folderId="+folderId);
		//window.showModalDialog("${pageContext.request.contextPath}/common/member/openFile.jsp?&attachmentId="+id+"&folderId="+folderId,"","dialogWidth=1000px;dialogHeight=900px;location=no;scrollbars=no");
		//window.location = "${pageContext.request.contextPath}/common/member/openFile.jsp?&attachmentId="+id+"&folderId="+folderId;
		 
		var filename=id+".doc";
		AuditReport.pFileName = filename;
    	AuditReport.pOpenUrl = getlocationhost()+"/gdicpa/common/member/attachFiles/"+folderId+"/"+id;
		AuditReport.funOpenUrlFile(2);
						
	}
	
	
	
	function f_down_print(_id,_folderId){
		var attachmentId = _id;
		var attachmentIds = ["micfoNo_glff","micfoNo_djb","zckjs_sqzczl","zckjs_zssqb","zckjs_zsgrjlb",
							"zckjs_plzsb","fzyhy_djb","fzyhy_zhsqb","kjsws_bgsxb","kjsws_fsbgsxb",
							"blcs_sjywzmzl", "ksglzn_jkrygzgz","ksglzn_ksglgzzn","ksglzn_kwgzgz","ksglzn_wgxwclgz",
							"ksglzn_ykrykcsz","ksglzn_ksggfa","ksglzn_tyksbf","ksglzn_kswgxwclbf","pxglzn_fzyjxjy",
							"pxglzn_gdskjsjxjy","pxglzn_zgkjsjxjy"];
							
		var attachmentNames = ["广东省注册会计师协会非执业会员管理办法.doc","非执业会员登记表.xls","注册会计师申请注册材料.doc","注册会计师转所申请表.doc","注册会计师转所个人简历表.doc",
								"注册会计师批量转所表.doc","中国注册会计师协会非执业会员登记表.xls","中国注册会计师协会非执业会员转会申请表.xls","会计师事务所变更事项情况表.doc","会计师事务所分所变更事项情况表.doc",
								"办理从事审计业务证明资料.doc","监考人员工作规则.doc","考试管理工作指南.doc","考务工作规则.doc","违规行为处理规程.doc",
								"应考人员考场守则.doc","注册会计师考试改革方案.doc","注册会计师全国统一考试办法.doc","注册会计师全国统一考试违规行为处理办法.doc","非执业会员继续教育暂行办法.doc",
								"广东省注册会计师继续教育管理制度.doc","中国注册会计师继续教育制度.doc"];
		var filename = "";										
		for (var i = 0; i < attachmentNames.length; i++) {
			if(attachmentIds[i]==attachmentId){
				filename = attachmentNames[i];
				break;
			}
		}	
		
		// 办事指南不用打印按钮
		if(attachmentId.indexOf("zn")>-1 && document.getElementById("print_span")){
			document.getElementById("print_span").style.display = "none";
		}
		
		var folderId = _folderId;
		var folderIds = ["bgdy","ksglzn","pxglzn"];
		var folderNames = ["表格打印","培训管理指南","考试管理指南"];
										
		var folder = "";		
		for (var i = 0; i < folderIds.length; i++) {
			if(folderIds[i]==folderId){
				folder = folderNames[i];
				break;
			}
		}	
		if(filename!=""){
			AuditReport.pFileName = filename;
	    	AuditReport.pOpenUrl = getlocationhost()+"/gdicpa/common/member/attachFiles/"+folder+"/"+filename;
			AuditReport.funOpenUrlFile(2);
			//openfile("/gdicpa/common/member/attachFiles/"+folder+"/"+filename,filename);
		}else{
			alert("找不到文件！");
		}
	}
	
	
	
	// 打印
	function f_goprint(type){
		var ctypeTabName = "<%=ctypeTabName%>";
		var loginId = "<%=loginId%>";
		if(ctypeTabName=="" || ctypeTabName=="null"){
			ctypeTabName = "k_cicpa";
		}
		document.getElementById("bm_print_div").style.display = "none";
		document.getElementById("bm_print_div_detail").style.display = "";
		// 打印回执
		if(type=="hz"){
			document.getElementById("bm_print_iframe").src = "${pageContext.request.contextPath}/common/certificateReceipt.do?method=receiptListFromHYJ&ctypeTabName="+ctypeTabName+"&loginId="+loginId+"&paremTemp="+Math.random();
		}
		// 打印结业证书
		if(type=="jyzs"){
			document.getElementById("bm_print_iframe").src = "${pageContext.request.contextPath}/common/certificateReceipt.do?method=certificateListFromHYJ&ctypeTabName="+ctypeTabName+"&loginId="+loginId+"&paremTemp="+Math.random();
		}
	}
	
	// 座位号信息
	function f_goXCKQ(type,userTypeId){
		
		// 补报名
		if(type=="bbm"){
			var loginId = "<%=loginId%>";
			var officeCode = "<%=officeCode%>";
			var ctypeTabName = "<%=ctypeTabName%>";
			if(ctypeTabName=="k_cicpa"){
				alert("当前身份证属于省注协用户登陆，请注师自己刷身份证登陆进行补报名！");
				return;
			}else{
				document.getElementById(userTypeId+"kq_seat_div").style.display = "none";
				document.getElementById(userTypeId+"kq_seat_div_detail").style.display = "";
				document.getElementById(userTypeId+"kq_seat_iframe").src = "${pageContext.request.contextPath}/common/training.do?method=indexFromeHYJ&param=company&source=hyj_kqpxb&loginId="+loginId+"&officeCode="+officeCode+"&ctypeTabName="+ctypeTabName+"&optType=bbm&paremTemp="+Math.random();
			}
		}
		// 考勤签到
		if(type=="kqqd"){
			document.getElementById(userTypeId+"kq_seat_iframe").src = "";
			alert("考勤签到");
		}
		// 座位号查询
		if(type=="zwhcx"){
			var loginId = "<%=loginId%>";
			document.getElementById(userTypeId+"kq_seat_div").style.display = "none";
			document.getElementById(userTypeId+"kq_seat_div_detail").style.display = "";
			document.getElementById(userTypeId+"kq_seat_iframe").src = "${pageContext.request.contextPath}/common/training.do?method=indexSeatNoSearch&loginId="+loginId+"&userType="+userTypeId+"&paremTemp="+Math.random();
		}
		// 考勤结果查询
		if(type=="kqjgcx"){
			document.getElementById(userTypeId+"kq_seat_div").style.display = "none";
			document.getElementById(userTypeId+"kq_seat_div_detail").style.display = "";
			var ctypeTabName = "<%=ctypeTabName%>";
			var loginId = "<%=loginId%>";
			var officeCode = "<%=officeCode%>";
			if(ctypeTabName=="k_cicpa"){
				document.getElementById(userTypeId+"kq_seat_iframe").src = "${pageContext.request.contextPath}/common/training.do?method=indexFromeHYJ&param=company&source=hyj_kqpxb&loginId="+loginId+"&officeCode="+officeCode+"&ctypeTabName="+ctypeTabName+"&optType=kq_cx_szx&paremTemp="+Math.random();
			}else{
				document.getElementById(userTypeId+"kq_seat_iframe").src = "${pageContext.request.contextPath}/common/training.do?method=kqSearch&loginId="+loginId+"&officeCode="+officeCode+"&ctypeTabName="+ctypeTabName+"&optType=kq_cx_zx&paremTemp="+Math.random();
			}
		}
		// 座位号维护
		if(type=="kqseatwh"){
			document.getElementById(userTypeId+"kq_seat_div").style.display = "none";
			document.getElementById(userTypeId+"kq_seat_div_detail").style.display = "";
			document.getElementById(userTypeId+"kq_seat_iframe").src = "${pageContext.request.contextPath}/common/seat.do?method=index&paremTemp="+Math.random();
		}
	}
	
	// 办事指南
	function f_goBSZN(type){
		document.getElementById("bs_zn").style.display = "none";
		// 会员部
		if(type=="hyb"){
			document.getElementById("hyb_bs_zn").style.display = "";
			document.getElementById("kpb_bs_zn").style.display = "none";
		}
		// 考培部
		if(type=="kpb"){
			document.getElementById("hyb_bs_zn").style.display = "none";
			document.getElementById("kpb_bs_zn").style.display = "";
			document.getElementById("kpb_detail_bs_zn").style.display = "";
			document.getElementById("kpb_detail_bs_zn_ks").style.display = "none";
			document.getElementById("kpb_detail_bs_zn_px").style.display = "none";
		}
	}
	
	
	// 考勤
	function f_goPXB(type){
		var ctypeTabName = "<%=ctypeTabName%>";
		if(ctypeTabName=="" || ctypeTabName=="null"){
			ctypeTabName = "k_cicpa";
		}
		if(type=="pxb"){
			var loginId = "<%=loginId%>";
			var officeCode = "<%=officeCode%>";
			document.getElementById("kq_kqkq_iframe").src = "${pageContext.request.contextPath}/common/training.do?method=indexFromeHYJ&param=company&source=hyj_kqpxb&loginId="+loginId+"&officeCode="+officeCode+"&ctypeTabName="+ctypeTabName+"&optType=kqpxb&paremTemp="+Math.random();
			document.getElementById("kq_kqkq_div_detail").style.display = "";
			//document.getElementById("kq_kqkq_div").style.display = "none";
		}		
	}
	
	
// 考培部办事指南	
function f_kpb_bszn(_typeKP){
	document.getElementById("kpb_bs_zn").style.display = "";
	document.getElementById("kpb_detail_bs_zn").style.display = "none";
	if(_typeKP=="ksglzn"){// 考试办事指南
		document.getElementById("kpb_detail_bs_zn_ks").style.display = "";
		document.getElementById("kpb_detail_bs_zn_px").style.display = "none";
	}else{ // 培训办事指南
		document.getElementById("kpb_detail_bs_zn_ks").style.display = "none";
		document.getElementById("kpb_detail_bs_zn_px").style.display = "";
	}
}


/*	
// 控件打开
var AuditReport =  new ActiveXObject("AuditReportPoject.AuditReport");
var oframe=document.getElementById('oframe');
AuditReport.pDSOFramer=oframe;

//---------------
//获取主机地址
//---------------
function getlocationhost(){
	return "http:\/\/"+window.location.host;
}

function print(){
	AuditReport.funPrint();
}
*/

function openfile(url,filename){
	
	AuditReport.pFileName = filename;
    AuditReport.pOpenUrl = getlocationhost()+url;
	AuditReport.funOpenUrlFile();
}


function myclose(){
	AuditReport.funCloseFile();
}

	
function f_goBack(id){
	if(id=="bszn_hyb"){// 会员部办事指南
		document.getElementById("bs_zn").style.display = "";
		document.getElementById("hyb_bs_zn").style.display = "none";
	}else if(id=="bszn_kpb"){// 考培部办事指南
		document.getElementById("bs_zn").style.display = "";
		document.getElementById("kpb_bs_zn").style.display = "none";
	}else if(id=="bszn_kpb_ksglzn" || id=="bszn_kpb_pxglzn"){// 考培部办事指南：考试管理      // 考培部办事指南：培训管理
		document.getElementById("kpb_detail_bs_zn").style.display = "";
		document.getElementById("kpb_detail_bs_zn_ks").style.display = "none";
		document.getElementById("kpb_detail_bs_zn_px").style.display = "none";
	}else if(id=="bgdy_hyb" || id=="bgdy_kpb"){
		document.getElementById("bs_dy_detail").style.display = "";
		document.getElementById("bs_dy_detail_hyb").style.display = "none";
		document.getElementById("bs_dy_detail_kpb").style.display = "none";
		document.getElementById("bm_print_iframe_jyzs").src = "";
	}else if(id=="zs_kq_kq_cx"){
		document.getElementById("zs_kq_seat_div").style.display = "";
		document.getElementById("zs_kq_seat_div_detail").style.display = "none";
		document.getElementById("zs_kq_seat_iframe").src = "";
	}else if(id=="zx_kq_kq_cx"){
		document.getElementById("kq_seat_div").style.display = "";
		document.getElementById("kq_seat_div_detail").style.display = "none";
		document.getElementById("kq_seat_iframe").src = "";
	}else if(id=="bm_print_zx"){
		document.getElementById("bm_print_div").style.display = "";
		document.getElementById("bm_print_div_detail").style.display = "none";
		document.getElementById("bm_print_iframe").src = "";
	}else if(id=="kq_kqkq_pxb"){
		document.getElementById("kq_kqkq_div").style.display = "";
		document.getElementById("kq_kqkq_div_detail").style.display = "none";
		document.getElementById("kq_kqkq_iframe").src = "";
	}
	
	
}	

// 注师登陆表格打印
function f_zs_bgdy(type){
	var ctypeTabName = "<%=ctypeTabName%>";
	var loginId = "<%=loginId%>";
	if(ctypeTabName=="" || ctypeTabName=="null"){
		ctypeTabName = "k_micfo";
	}
	document.getElementById("bs_dy_detail").style.display = "none";
	if(type=="hyb"){
		document.getElementById("bs_dy_detail_hyb").style.display = "";
		document.getElementById("bs_dy_detail_kpb").style.display = "none";
		document.getElementById("bm_print_iframe_jyzs").src = "";
	}else{
		document.getElementById("bs_dy_detail_hyb").style.display = "none";
		document.getElementById("bs_dy_detail_kpb").style.display = "";
		document.getElementById("bm_print_iframe_jyzs").src = "${pageContext.request.contextPath}/common/certificateReceipt.do?method=certificateListFromHYJ&ctypeTabName="+ctypeTabName+"&loginId="+loginId+"&paremTemp="+Math.random();
	}
}

function f_openKey(){
	
	var shell = new ActiveXObject("wscript.shell");
    shell.run("osk.exe");
    
    //AuditReport.execute("osk.exe");
}


function f_exit(){
	var url = "${pageContext.request.contextPath}/common/member/entry.jsp";
	//window.showModalDialog(url,"","dialogWidth=1300px;dialogHeight=1000px;location=no");
 	//window.close();
 	window.location = url;
}

var timeId = "";
function f_checkExitSelf(){
	var url="${pageContext.request.contextPath}/common/training.do?method=checkExitSelf";
	var request = "";
	var resText = ajaxLoadPageSynch(url,request);
	if(resText=="exit"){
		if(timeId!=""){
	 		window.clearInterval(timeId); //清楚定时器
	 	}
	 	
	 	// 删除退出登录标识数据
	 	url="${pageContext.request.contextPath}/common/training.do?method=deleteFromExit";
		request = "";
		resText = ajaxLoadPageSynch(url,request);
	 	
	 	//退出
		f_exit();
	}
	
}
var timeId = window.setInterval("f_checkExitSelf()",3000);


</script>

</html>