<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>基准价计算器</title>
</head>

<style>
.tab{
border-collapse:collapse;border:none;text-align: center;
}
.tab td{border:solid #8db2e3 1px;}

.input{
border: 0px ;width: 60%;text-align: right;
}

.display{
	display: none; 
}
</style>

<body>
<br>
<center>
	请录入金额：&nbsp;
	<input id="bbmoney" name="bbmoney" size="30">&nbsp;&nbsp;元<input type="button" value="计算" style="margin-left: 20px;" onclick="f_calc()">
	<br><br>
	<font color="red">( 请在输入框内输入资产或收入或验资的金额，计算器将根据此金额计算各项业务的基准价。)</font>
</center>
<br> 
<table cellSpacing="0" cellPadding="5" width="60%" class="tab" align="center">
	<tr class="display">
		<td style="background-color: #e8f7fc ! important" rowspan="2">&nbsp;&nbsp;&nbsp;项目</td>
		<td style="background-color: #e8f7fc ! important" colspan="2">基准价</td>
	</tr>
	<tr class="display">
		<td style="background-color: #e8f7fc ! important" colspan="">珠三角</td>
		<td style="background-color: #e8f7fc ! important" colspan="">非珠三角</td>
	</tr>
	
	<tr >
		<td style="background-color: #e8f7fc ! important" >&nbsp;&nbsp;&nbsp;项目</td>
		<td style="background-color: #e8f7fc ! important">基准价</td>
	</tr>
	<tr>
		<td width="40%" >审计（盈利组织）</td>
		<td width="30%" style="text-align: left;">
			<input id="sjyl_zsj" name="sjyl_zsj" class="input" readonly="readonly" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元
		</td>
		<td width="30%" style="text-align: left;" class="display">
			<input id="sjyl_fzsj" name="sjyl_fzsj" class="input" readonly="readonly" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元
		</td>
	</tr>
	<tr>
		<td >审计（非盈利组织）</td>
		<td style="text-align: left;">
			<input id="fsjyl_zsj" name="fsjyl_zsj" class="input" readonly="readonly" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元
		</td>
		<td style="text-align: left;" class="display">
			<input id="fsjyl_fzsj" name="fsjyl_fzsj" class="input" readonly="readonly" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元
		</td>
	</tr>
	<tr>
		<td >外汇年检</td>
		<td style="text-align: left;">
			<input id="whnj_zsj" name="whnj_zsj" class="input" readonly="readonly" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元
		</td>
		<td style="text-align: left;" class="display">
			<input id="whnj_fzsj" name="whnj_fzsj" class="input" readonly="readonly" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元
		</td>
	</tr>
	<tr>
		<td >合并审计</td>
		<td style="text-align: left;">
			<input id="hbsj_zsj" name="hbsj_zsj" class="input" readonly="readonly" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元
		</td>
		<td style="text-align: left;" class="display">
			<input id="hbsj_fzsj" name="hbsj_fzsj" class="input" readonly="readonly" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元
		</td>
	</tr>
	<tr>
		<td >分立审计</td>
		<td style="text-align: left;">
			<input id="flsj_zsj" name="flsj_zsj" class="input" readonly="readonly" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元
		</td>
		<td style="text-align: left;" class="display">
			<input id="flsj_fzsj" name="flsj_fzsj" class="input" readonly="readonly" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元
		</td>
	</tr>
	<tr>
		<td >清算审计</td>
		<td style="text-align: left;">
			<input id="qssj_zsj" name="qssj_zsj" class="input" readonly="readonly" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元
		</td>
		<td style="text-align: left;" class="display">
			<input id="qssj_fzsj" name="qssj_fzsj" class="input" readonly="readonly" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元
		</td>
	</tr>
	<tr>
		<td >清产核资</td>
		<td style="text-align: left;">
			<input id="qchz_zsj" name="qchz_zsj" class="input" readonly="readonly" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元
		</td>
		<td style="text-align: left;" class="display">
			<input id="qchz_fzsj" name="qchz_fzsj" class="input" readonly="readonly" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元
		</td>
	</tr>
	<tr>
		<td >司法会计鉴定</td>
		<td style="text-align: left;">
			<input id="sfkjjd_zsj" name="sfkjjd_zsj" class="input" readonly="readonly" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元
		</td>
		<td style="text-align: left;" class="display">
			<input id="sfkjjd_fzsj" name="sfkjjd_fzsj" class="input" readonly="readonly" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元
		</td>
	</tr>
	<tr>
		<td >报备其他(经济责任审计)</td>
		<td style="text-align: left;">
			<input id="bbqt_zsj" name="bbqt_zsj" class="input" readonly="readonly" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元
		</td>
		<td style="text-align: left;" class="display">
			<input id="bbqt_fzsj" name="bbqt_fzsj" class="input" readonly="readonly" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元
		</td>
	</tr>
	<tr>
		<td >验资（货币）</td>
		<td style="text-align: left;">
			<input id="yzhb_zsj" name="yzhb_zsj" class="input" readonly="readonly" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元
		</td>
		<td style="text-align: left;" class="display">
			<input id="yzhb_fzsj" name="yzhb_fzsj" class="input" readonly="readonly" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元
		</td>
	</tr>
	<tr>
		<td >验资（非货币或货币+非货币）</td>
		<td style="text-align: left;">
			<input id="yzfhb_zsj" name="yzfhb_zsj" class="input" readonly="readonly" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元
		</td>
		<td style="text-align: left;" class="display">
			<input id="yzfhb_fzsj" name="yzfhb_fzsj" class="input" readonly="readonly" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元
		</td>
	</tr>
</table>

</body>

<script type="text/javascript">

	// 验证金额
	function check(v){
		var a=/^[0-9]*(\.[0-9]{1,8})?$/;
		if(!a.test(v)){
			return false;
		}else{
			return true;
		}
	}

	// 计算 最低标准金额
	function f_calc(){
		var bbmoney = document.getElementById("bbmoney").value;
		if(bbmoney==""){
			alert("请录入金额！");
			return;
		}
		if(check(bbmoney)){
			//	------------------- 验资 ------------------- //
			// 珠三角纯货币
			document.getElementById("yzhb_zsj").value = f_check_yz(bbmoney,"Y","Y");
			// 非珠三角纯货币
			document.getElementById("yzhb_fzsj").value = f_check_yz(bbmoney,"N","Y");
			// 珠三角非纯货币
			document.getElementById("yzfhb_zsj").value = f_check_yz(bbmoney,"Y","N");
			// 非珠三角非纯货币
			document.getElementById("yzfhb_fzsj").value = f_check_yz(bbmoney,"N","N");
			
			
			//	------------------- 审计（一般） ------------------- //
			// 珠三角盈利
			document.getElementById("sjyl_zsj").value = f_check_sj(bbmoney,"Y","Y");
			// 非珠三角盈利
			document.getElementById("sjyl_fzsj").value = f_check_sj(bbmoney,"N","Y");
			// 珠三角非盈利
			document.getElementById("fsjyl_zsj").value = f_check_sj(bbmoney,"Y","N");
			// 非珠三角非盈利
			document.getElementById("fsjyl_fzsj").value = f_check_sj(bbmoney,"N","N");
			
			
			//	------------------- 外汇年检 ------------------- //
			// 珠三角
			document.getElementById("whnj_zsj").value = f_check_whnj();
			// 非珠三角
			document.getElementById("whnj_fzsj").value = f_check_whnj();
			
			
			//	------------------- 合并审计 ------------------- //
			// 珠三角
			document.getElementById("hbsj_zsj").value = f_check_hbsj(bbmoney,"Y");
			// 非珠三角
			document.getElementById("hbsj_fzsj").value = f_check_hbsj(bbmoney,"N");
			
			
			//	------------------- 分立审计 ------------------- //
			// 珠三角
			document.getElementById("flsj_zsj").value = f_check_flsj(bbmoney,"Y");
			// 非珠三角
			document.getElementById("flsj_fzsj").value = f_check_flsj(bbmoney,"N");
			
			
			//	------------------- 清算审计 ------------------- //
			// 珠三角
			document.getElementById("qssj_zsj").value = f_check_qssj(bbmoney,"Y");
			// 非珠三角
			document.getElementById("qssj_fzsj").value = f_check_qssj(bbmoney,"N");
			
			
			//	------------------- 清产核资 ------------------- //
			// 珠三角
			document.getElementById("qchz_zsj").value = f_check_qchz(bbmoney,"Y");
			// 非珠三角
			document.getElementById("qchz_fzsj").value = f_check_qchz(bbmoney,"N");
			
			
			//	------------------- 司法会计鉴定 ------------------- //
			// 珠三角
			document.getElementById("sfkjjd_zsj").value = f_check_sfkjjd(bbmoney,"Y");
			// 非珠三角
			document.getElementById("sfkjjd_fzsj").value = f_check_sfkjjd(bbmoney,"N");
			
			//	------------------- 报备其他 ------------------- //
			// 珠三角
			document.getElementById("bbqt_zsj").value = f_check_bbqt(bbmoney,"Y");
			// 非珠三角
			document.getElementById("bbqt_fzsj").value = f_check_bbqt(bbmoney,"N");
			
			
		}else{
			alert("请录入正确的金额格式！");
			document.getElementById("bbmoney").select();
			
			var form_obj = document.all; 
			//form的值
			for (i=0;i<form_obj.length ;i++ ) {
				var e = form_obj[i];
				if (e.tagName=="INPUT" && e.id!="bbmoney" && e.type=="text") {
					e.value = "";
				}
			}
		}
	}
	
	
	// 验资：最低收费标准
	function f_check_yz(money,isZSJ,isOnlyHb){
		money = money / 10000;
		if(money>50){
			// 然后(A--货币     B--实物   C--无形资产总额       D--其他)
			// 省物价局规定的收费标准={（A×费率+速算增加数×A/(A+B+C+D)）×10000+[(B+C+D)×费率+速算增加数×(B+C+D)/(A+B+C+D)]×1.2×10000}×0.7
			
			// 纯货币：非珠三角  省物价局规定的收费标准={A×汇率×费率+速算增加数）×10000}×0.7
			// 纯货币：珠三角  省物价局规定的收费标准={A×汇率×费率+速算增加数）×10000}
			// 非纯货币：非珠三角 省物价局规定的收费标准={[(A+B+C+D)×汇率×费率+速算增加数]×1.2×10000}×0.7
			// 非纯货币：珠三角 省物价局规定的收费标准={[(A+B+C+D)×汇率×费率+速算增加数]×1.2×10000}
			
			var ysywfCount = (money*f_getRateByMoney_yz(money)+f_getIncreaseByMoney_yz(money)*1)*10000;
			
			// 珠三角：广州、珠海、佛山、东莞、中山、江门、深圳
			if(isZSJ=="N"){
				ysywfCount = ysywfCount*0.7;
			}
			
			// 非纯货币：验资总金额>币种
			if(isOnlyHb=="N"){
				ysywfCount = ysywfCount*1.2;
			}
			
			/*
			// 验资总额在1千万到5亿之间
			if(1000<=money && money<=50000){
				// 珠三角：广州、珠海、佛山、东莞、中山、江门、深圳
				if(isZSJ=="Y"){
					// 非纯货币：验资总金额>币种
					if(isOnlyHb=="N"){
						ysywfCount = (ysywfCount*1 - 6060*1)*0.7 + 6060*1;
					}else{
						ysywfCount = (ysywfCount*1 - 5050*1)*0.7 + 5050*1;
					}
				}
			}
			
			
			// 珠三角：广州、珠海、佛山、东莞、中山、江门、深圳
			if(isZSJ=="Y"){
				// 非纯货币：验资总金额>币种
				if(isOnlyHb=="N"){
					ysywfCount = ysywfCount>52680 ? 52680:ysywfCount;
				}else{
					ysywfCount = ysywfCount>43900 ? 43900:ysywfCount;
				}
			}else{
				// 非纯货币：验资总金额>币种
				if(isOnlyHb=="N"){
					ysywfCount = ysywfCount>50862 ? 50862:ysywfCount;
				}else{
					ysywfCount = ysywfCount>42385 ? 42385:ysywfCount;
				}
			}
			*/
			
		}else{
			var ysywfCount = 1200*1;
			// 广州、珠海、佛山、东莞、中山、江门、深圳
			if(isZSJ=="N"){	   
				ysywfCount = ysywfCount*0.7;
			} 
			
			// 非纯货币：验资总金额>币种
			if(isOnlyHb=="N"){
				ysywfCount = ysywfCount*1.2;
			}
		}
		
		return ysywfCount.toFixed(2)*1;
	}
	
	
	// 根据金额得到：费率 (验资)
	function f_getRateByMoney_yz(money){
		if(money==""){
			money = 0;
		}else{
			money = money*1;
		}
		
		if(money<=50){
			return "0";
		}else if(50<money && money<=100){
			return "0.0015";
		}else if(100<money && money<=500){
			return "0.0004";
		}else if(500<money && money<=1000){
			return "0.0003";
		}else if(1000<money && money<=5000){
			return "0.0002";
		}else if(5000<money && money<=10000){
			return "0.00015";
		}else if(10000<money && money<=50000){
			return "0.0001";
		}else if(50000<money && money<=100000){
			return "0.00008";
		}else{
			return "0.00006";
		}
		
	}
	
	
	// 根据金额得到：速算增加数 (验资)
	function f_getIncreaseByMoney_yz(money){
		if(money==""){
			money = 0;
		}else{
			money = money*1;
		}
		
		if(money<=50){
			return "0.12";
		}else if(50<money && money<=100){
			return "0.045";
		}else if(100<money && money<=500){
			return "0.155";
		}else if(500<money && money<=1000){
			return "0.205";
		}else if(1000<money && money<=5000){
			return "0.305";
		}else if(5000<money && money<=10000){
			return "0.555";
		}else if(10000<money && money<=50000){
			return "1.055";
		}else if(50000<money && money<=100000){
			return "2.055";
		}else{
			return "4.055";
		}
	}
	

		
	// 审计：最低收费标准
	function f_check_sj(money,isZSJ,sfly){
		money = money / 10000;
		var ysywfCount = (money*f_getRateByMoney_sj(money)*1+f_getIncreaseByMoney_sj(money)*1)*10000;
		
		// 是否盈利：非盈利组织
		if(sfly=="N"){
			// 收费标准R = R×(1-下浮率)
			ysywfCount = ysywfCount*(1-f_getFloatRateByMoney_sj(money)*1)+f_getIncreaseByMoney2_sj(money)*1;
		}
		
		ysywfCount = ysywfCount>2000?ysywfCount:2000;
		
		// 非珠三角地区
		if(isZSJ=="N"){
			ysywfCount = ysywfCount*0.7;
		}
		
		/*
			（按现在算出来的标准金额=A
			 扣除数=B： 由资产/收入 以高的为基准 区间设置得来
			 修改后标准金额=C）
	 
			是珠三角且资产/收入所在区间，且，如果在1000W～5000W、5000W～1E、1E～5亿区间，那么C=(A-B)*0.7+B，扣除数见下表  
			如果是非珠三角，C=A
			 
			项目				1QW～5E			 
			审计（一般）		10,100.00 	      
			审计（非盈利）		9,090.00 	       
			
						珠三角        非珠三角
			审计（一般）	76,600.00 	73,570.00 
			审计（非盈利）	64,740.00 	62,013.00 
			
		*/
		
		/*
		// 金额在1千万到5亿之间
		if(1000<=money && money<=50000){
			var betValue = "10100";
			
			// 是否盈利：非盈利组织
			if(sfly=="N"){
				betValue = "9090";
			}
			// 属于珠三角地区
			if(isZSJ=="Y"){
				ysywfCount = (ysywfCount*1 - betValue*1)*0.7 + betValue*1;
			}
		} 
		
		
		// 属于珠三角地区
		if(isZSJ=="Y"){
			// 是否盈利：非盈利组织
			if(sfly=="N"){
				ysywfCount = ysywfCount>64740 ? 64740:ysywfCount;
			}else{
				ysywfCount = ysywfCount>76600 ? 76600:ysywfCount;
			}
			
		}else{
			// 是否盈利：非盈利组织
			if(sfly=="N"){
				ysywfCount = ysywfCount>62013 ? 62013:ysywfCount;
			}else{
				ysywfCount = ysywfCount>73570 ? 73570:ysywfCount;
			}
		}
		*/
		
		// 标准金额
		return ysywfCount.toFixed(2)*1;
			
	}
	
		
	// 根据金额得到：费率 (审计)
	function f_getRateByMoney_sj(money){
		if(money==""){
			money = 0;
		}else{
			money = money*1;
		}
		
		if(money<=50){
			return "0";
		}else if(50<money && money<=100){
			return "0.002";
		}else if(100<money && money<=500){
			return "0.0009";
		}else if(500<money && money<=1000){
			return "0.0007";
		}else if(1000<money && money<=5000){
			return "0.0005";
		}else if(5000<money && money<=10000){
			return "0.0003";
		}else if(10000<money && money<=50000){
			return "0.00015";
		}else if(50000<money && money<=100000){
			return "0.0001";
		}else{
			return "0.00008";
		}
		
	}
	
	
	// 根据金额得到：速算增加数 (审计)
	function f_getIncreaseByMoney_sj(money){
		if(money==""){
			money = 0;
		}else{
			money = money*1;
		}
		
		if(money<=50){
			return "0.2";
		}else if(50<money && money<=100){
			return "0.1";
		}else if(100<money && money<=500){
			return "0.21";
		}else if(500<money && money<=1000){
			return "0.31";
		}else if(1000<money && money<=5000){
			return "0.51";
		}else if(5000<money && money<=10000){
			return "1.51";
		}else if(10000<money && money<=50000){
			return "3.01";
		}else if(50000<money && money<=100000){
			return "5.51";
		}else{
			return "7.51";
		}
	}
	
	
	// 根据金额得到：下浮率 (审计)
	function f_getFloatRateByMoney_sj(money){
		if(money==""){
			money = 0;
		}else{
			money = money*1;
		}
		
		if(money<=10000){
			return "0.1";
		}else if(10000<money && money<=50000){
			return "0.2";
		}else{
			return "0.3";
		}
	}
	
	
	// 根据金额得到：速算数 (审计)
	function f_getIncreaseByMoney2_sj(money){
		if(money==""){
			money = 0;
		}else{
			money = money*1;
		}
		
		if(money<=10000){
			return "0";
		}else if(10000<money && money<=50000){
			return "4510";
		}else{
			return "15020";
		}
	}
	
	
	// 外汇年检：最低收费标准
	function f_check_whnj(){
		return "1000";
	}
	
	
	// 合并审计：最低收费标准
	function f_check_hbsj(money,isZSJ){
		
		// 转万元
		money = money/10000; 
		
		var ysywfCount = (money*f_getRateByMoney_hbsj(money)*1 + f_getIncreaseByMoney_hbsj(money)*1)*1.2*10000;
		
		// 属于非珠三角地区
		if(isZSJ=="N"){
			ysywfCount = ysywfCount*0.7;
		}
		
		/*
		// 金额在1千万到5亿之间
		if(1000<=money && money<=50000){
			// 属于珠三角地区
			if(isZSJ=="Y"){
				ysywfCount = (ysywfCount*1 - 12120*1)*0.7 + 12120*1;
			}
		} 
		
		// 属于珠三角地区
		if(isZSJ=="Y"){
			ysywfCount = ysywfCount>91920 ? 91920:ysywfCount;
		}else{
			ysywfCount = ysywfCount>88284 ? 88284:ysywfCount;
		}
		*/
		
		return ysywfCount.toFixed(2)*1;
	}
	
	
	// 根据金额得到：费率 (合并审计)
	function f_getRateByMoney_hbsj(money){
		if(money==""){
			money = 0;
		}else{
			money = money*1;
		}
		
		if(money<=50){
			return "0";
		}else if(50<money && money<=100){
			return "0.002";
		}else if(100<money && money<=500){
			return "0.0009";
		}else if(500<money && money<=1000){
			return "0.0007";
		}else if(1000<money && money<=5000){
			return "0.0005";
		}else if(5000<money && money<=10000){
			return "0.0003";
		}else if(10000<money && money<=50000){
			return "0.00015";
		}else if(50000<money && money<=100000){
			return "0.0001";
		}else{
			return "0.00008";
		}
		
	}


	// 根据金额得到：速算增加数 (合并审计)
	function f_getIncreaseByMoney_hbsj(money){
		if(money==""){
			money = 0;
		}else{
			money = money*1;
		}
		
		if(money<=50){
			return "0.2";
		}else if(50<money && money<=100){
			return "0.1";
		}else if(100<money && money<=500){
			return "0.21";
		}else if(500<money && money<=1000){
			return "0.31";
		}else if(1000<money && money<=5000){
			return "0.51";
		}else if(5000<money && money<=10000){
			return "1.51";
		}else if(10000<money && money<=50000){
			return "3.01";
		}else if(50000<money && money<=100000){
			return "5.51";
		}else{
			return "7.51";
		}
	}
	
	
	// 分立审计：最低收费标准
	function f_check_flsj(money,isZSJ){
		
		// 转万元
		money = money/10000;
		
		var ysywfCount = (money*f_getRateByMoney_flsj(money)*1 + f_getIncreaseByMoney_flsj(money)*1)*1.2*10000;
		
		if(isZSJ=="N"){
			ysywfCount = ysywfCount*0.7;
		}
		
		/*
		// 金额在1千万到5亿之间
		if(1000<=money && money<=50000){
			// 属于珠三角地区
			if(isZSJ=="Y"){
				ysywfCount = (ysywfCount*1 - 12120*1)*0.7 + 12120*1;
			}
		} 
		
		
		// 属于珠三角地区
		if(isZSJ=="Y"){
			ysywfCount = ysywfCount>91920 ? 91920:ysywfCount;
		}else{
			ysywfCount = ysywfCount>88284 ? 88284:ysywfCount;
		}
		*/
		
		return ysywfCount.toFixed(2)*1;
	}
			
	
	
	// 根据金额得到：费率 (分立审计)
	function f_getRateByMoney_flsj(money){
		if(money==""){
			money = 0;
		}else{
			money = money*1;
		}
		
		if(money<=50){
			return "0";
		}else if(50<money && money<=100){
			return "0.002";
		}else if(100<money && money<=500){
			return "0.0009";
		}else if(500<money && money<=1000){
			return "0.0007";
		}else if(1000<money && money<=5000){
			return "0.0005";
		}else if(5000<money && money<=10000){
			return "0.0003";
		}else if(10000<money && money<=50000){
			return "0.00015";
		}else if(50000<money && money<=100000){
			return "0.0001";
		}else{
			return "0.00008";
		}
		
	}
	
	
	// 根据金额得到：速算增加数 (分立审计)
	function f_getIncreaseByMoney_flsj(money){
		if(money==""){
			money = 0;
		}else{
			money = money*1;
		}
		
		if(money<=50){
			return "0.2";
		}else if(50<money && money<=100){
			return "0.1";
		}else if(100<money && money<=500){
			return "0.21";
		}else if(500<money && money<=1000){
			return "0.31";
		}else if(1000<money && money<=5000){
			return "0.51";
		}else if(5000<money && money<=10000){
			return "1.51";
		}else if(10000<money && money<=50000){
			return "3.01";
		}else if(50000<money && money<=100000){
			return "5.51";
		}else{
			return "7.51";
		}
	}
	
	
	// 清算审计：最低收费标准 
	function f_check_qssj(money,isZSJ){
		
		// 转万元
		money = money/10000;
		
		var ysywfCount = (money*f_getRateByMoney_qssj(money)*1 + f_getIncreaseByMoney_qssj(money)*1)*1.2*10000;
		
		// 属于非珠三角地区
		if(isZSJ=="N"){
			ysywfCount = ysywfCount*0.7;
		}
		
		/*
		// 金额在1千万到5亿之间
		if(1000<=money && money<=50000){
			// 属于珠三角地区
			if(isZSJ=="Y"){
				ysywfCount = (ysywfCount*1 - 12120*1)*0.7 + 12120*1;
			}
		} 
		
		 
		// 属于珠三角地区
		if(isZSJ=="Y"){
			ysywfCount = ysywfCount>91920 ? 91920:ysywfCount;
		}else{
			ysywfCount = ysywfCount>88284 ? 88284:ysywfCount;
		}
		*/
		
		return ysywfCount.toFixed(2)*1;
	}
	
	
	
	// 根据金额得到：费率 (清算审计)
	function f_getRateByMoney_qssj(money){
		if(money==""){
			money = 0;
		}else{
			money = money*1;
		}
		
		if(money<=50){
			return "0";
		}else if(50<money && money<=100){
			return "0.002";
		}else if(100<money && money<=500){
			return "0.0009";
		}else if(500<money && money<=1000){
			return "0.0007";
		}else if(1000<money && money<=5000){
			return "0.0005";
		}else if(5000<money && money<=10000){
			return "0.0003";
		}else if(10000<money && money<=50000){
			return "0.00015";
		}else if(50000<money && money<=100000){
			return "0.0001";
		}else{
			return "0.00008";
		}
		
	}
	
	
	// 根据金额得到：速算增加数 (清算审计)
	function f_getIncreaseByMoney_qssj(money){
		if(money==""){
			money = 0;
		}else{
			money = money*1;
		}
		
		if(money<=50){
			return "0.2";
		}else if(50<money && money<=100){
			return "0.1";
		}else if(100<money && money<=500){
			return "0.21";
		}else if(500<money && money<=1000){
			return "0.31";
		}else if(1000<money && money<=5000){
			return "0.51";
		}else if(5000<money && money<=10000){
			return "1.51";
		}else if(10000<money && money<=50000){
			return "3.01";
		}else if(50000<money && money<=100000){
			return "5.51";
		}else{
			return "7.51";
		}
	}
	

	// 清产核资：最低收费标准 
	function f_check_qchz(money,isZSJ){
	
		money = money / 10000;
		
		var ysywfCount = (money*f_getRateByMoney_qchz(money)*1 + f_getIncreaseByMoney_qchz(money)*1)*10000*2;
		
		// 非珠三角
		if(isZSJ=="N"){
			ysywfCount = ysywfCount*0.7;
		}
		
		/*
		// 金额在1千万到5亿之间
		if(1000<=money && money<=50000){
			// 属于珠三角地区
			if(isZSJ=="Y"){
				ysywfCount = (ysywfCount*1 - 20200*1)*0.7 + 20200*1;
			}
		} 
		
		// 属于珠三角地区
		if(isZSJ=="Y"){
			ysywfCount = ysywfCount>153200 ? 153200:ysywfCount;
		}else{
			ysywfCount = ysywfCount>147140 ? 147140:ysywfCount;
		}
		*/
		
		return ysywfCount.toFixed(2)*1;
	}
	
	
	
	// 根据金额得到：费率 (清产核资)
	function f_getRateByMoney_qchz(money){
		if(money==""){
			money = 0;
		}else{
			money = money*1;
		}
		
		if(money<=50){
			return "0";
		}else if(50<money && money<=100){
			return "0.002";
		}else if(100<money && money<=500){
			return "0.0009";
		}else if(500<money && money<=1000){
			return "0.0007";
		}else if(1000<money && money<=5000){
			return "0.0005";
		}else if(5000<money && money<=10000){
			return "0.0003";
		}else if(10000<money && money<=50000){
			return "0.00015";
		}else if(50000<money && money<=100000){
			return "0.0001";
		}else{
			return "0.00008";
		}
		
	}
	
	
	// 根据金额得到：速算增加数 (清产核资)
	function f_getIncreaseByMoney_qchz(money){
		if(money==""){
			money = 0;
		}else{
			money = money*1;
		}
		
		if(money<=50){
			return "0.2";
		}else if(50<money && money<=100){
			return "0.1";
		}else if(100<money && money<=500){
			return "0.21";
		}else if(500<money && money<=1000){
			return "0.31";
		}else if(1000<money && money<=5000){
			return "0.51";
		}else if(5000<money && money<=10000){
			return "1.51";
		}else if(10000<money && money<=50000){
			return "3.01";
		}else if(50000<money && money<=100000){
			return "5.51";
		}else{
			return "7.51";
		}
	}
	
	
	
	// 司法会计鉴定：最低收费标准 
	function f_check_sfkjjd(money,isZSJ){
		
		// 转万元
		money = money/10000;
		
		var ysywfCount = (money*f_getRateByMoney_sfkjjd(money)*1 + f_getIncreaseByMoney_sfkjjd(money)*1)*1.2*10000;
		
		// 非珠三角
		if(isZSJ=="N"){
			ysywfCount = ysywfCount*0.7;
		}
		
		/*
		// 金额在1千万到5亿之间
		if(1000<=money && money<=50000){
			// 属于珠三角地区
			if(isZSJ=="Y"){
				ysywfCount = (ysywfCount*1 - 12120*1)*0.7 + 12120*1;
			}
		} 
		
		// 属于珠三角地区
		if(isZSJ=="Y"){
			ysywfCount = ysywfCount>91920 ? 91920:ysywfCount;
		}else{
			ysywfCount = ysywfCount>88284 ? 88284:ysywfCount;
		}
		*/
		
		return ysywfCount.toFixed(2)*1;
	}


	// 根据金额得到：费率 (司法会计鉴定)
	function f_getRateByMoney_sfkjjd(money){
		if(money==""){
			money = 0;
		}else{
			money = money*1;
		}
		
		if(money<=50){
			return "0";
		}else if(50<money && money<=100){
			return "0.002";
		}else if(100<money && money<=500){
			return "0.0009";
		}else if(500<money && money<=1000){
			return "0.0007";
		}else if(1000<money && money<=5000){
			return "0.0005";
		}else if(5000<money && money<=10000){
			return "0.0003";
		}else if(10000<money && money<=50000){
			return "0.00015";
		}else if(50000<money && money<=100000){
			return "0.0001";
		}else{
			return "0.00008";
		}
		
	}
	
	
	// 根据金额得到：速算增加数 (司法会计鉴定)
	function f_getIncreaseByMoney_sfkjjd(money){
		if(money==""){
			money = 0;
		}else{
			money = money*1;
		}
		
		if(money<=50){
			return "0.2";
		}else if(50<money && money<=100){
			return "0.1";
		}else if(100<money && money<=500){
			return "0.21";
		}else if(500<money && money<=1000){
			return "0.31";
		}else if(1000<money && money<=5000){
			return "0.51";
		}else if(5000<money && money<=10000){
			return "1.51";
		}else if(10000<money && money<=50000){
			return "3.01";
		}else if(50000<money && money<=100000){
			return "5.51";
		}else{
			return "7.51";
		}
	}
	
	
	// 报备其他：最低收费标准 
	function f_check_bbqt(money,isZSJ){
		
		// 转万元
		money = money/10000;
	
		var ysywfCount = (money*f_getRateByMoney_bbqt(money)*1 + f_getIncreaseByMoney_bbqt(money)*1)*1.2*10000;
		
		// 非珠三角
		if(isZSJ=="N"){
			ysywfCount = ysywfCount*0.7;
		}
		
		/*
			// 金额在1千万到5亿之间
			if(1000<=money && money<=50000){
				// 属于珠三角地区
				if(isZSJ=="Y"){
					ysywfCount = (ysywfCount*1 - 12120*1)*0.7 + 12120*1;
				}
			} 
			
			// 属于珠三角地区
			if(isZSJ=="Y"){
				ysywfCount = ysywfCount>91920 ? 91920:ysywfCount;
			}else{
				ysywfCount = ysywfCount>88284 ? 88284:ysywfCount;
			}
		*/
		
		return ysywfCount.toFixed(2)*1;
	}
	
	// 根据金额得到：费率
	function f_getRateByMoney_bbqt(money){
		if(money==""){
			money = 0;
		}else{
			money = money*1;
		}
		
		if(money<=50){
			return "0";
		}else if(50<money && money<=100){
			return "0.002";
		}else if(100<money && money<=500){
			return "0.0009";
		}else if(500<money && money<=1000){
			return "0.0007";
		}else if(1000<money && money<=5000){
			return "0.0005";
		}else if(5000<money && money<=10000){
			return "0.0003";
		}else if(10000<money && money<=50000){
			return "0.00015";
		}else if(50000<money && money<=100000){
			return "0.0001";
		}else{
			return "0.00008";
		}
		
	}
	
	
	// 根据金额得到：速算增加数
	function f_getIncreaseByMoney_bbqt(money){
		if(money==""){
			money = 0;
		}else{
			money = money*1;
		}
		
		if(money<=50){
			return "0.2";
		}else if(50<money && money<=100){
			return "0.1";
		}else if(100<money && money<=500){
			return "0.21";
		}else if(500<money && money<=1000){
			return "0.31";
		}else if(1000<money && money<=5000){
			return "0.51";
		}else if(5000<money && money<=10000){
			return "1.51";
		}else if(10000<money && money<=50000){
			return "3.01";
		}else if(50000<money && money<=100000){
			return "5.51";
		}else{
			return "7.51";
		}
	}
	
	
	
		
	

</script>
</html>