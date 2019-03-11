<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<input type="hidden" value="${apply.guid}" name="guid"  id='guid'/>
<input type="hidden" value="${apply.loginId }" name="loginId" id="loginId" />
<input type="hidden" value="${apply.loginName }" name="loginName" id="loginName" />
<input type="hidden" value="${apply.state }" name="state" id="state" />
<input type="hidden" value="${apply.area }" name="area" id="area" />
<input type="hidden" value="${apply.auditId }" name="auditId" id="auditId" />
<input type="hidden" value="${type }" name="type" id="type" />

<style>
	.paddingLeft{padding-left:10px;}
</style>

<table border="0" cellSpacing="0" cellPadding="0" width="95%" align="center" height="100%">
	<tbody>
		<tr>
			<td height="280" vAlign="top" align="middle" >
				<!--顶部图片结束--> <!--中部表格开始-->
				<table border="0" cellSpacing="0" cellPadding="0" width="100%" align="center" height="100%">
					<tbody >
						<tr>
							<td vAlign="top">
								<table style="WIDTH: 100%" class="data_tb applyBill"  align="center" id='ftd'>
									<tr>
										<td class="data_tb_alignleft" colspan="2" style="height: 38px;">
											<font style="font-size: 15px; font-weight: bolder;" >会费发票申请信息</font> 
										</td>
									</tr>
									<tr >
										<td class="data_tb_alignright " nowrap="nowrap" width='35%'>
											申请年份：<font color="red">&nbsp;[*]</font>
										</td>
										<td class="data_tb_content" width='62%'>
											<div id="year_edit" class="paddingLeft">
												<input class="required data_tb_content" readonly="readonly" style='width:78%' 
													name="year" id="year" value="${apply.year}" type="text"/>
											</div>
											<div id="year_show" class="paddingLeft">${apply.year}</div>
										</td>
									</tr>
									<tr >
										<td class="data_tb_alignright " nowrap="nowrap" width='35%'>
											发票抬头：<font color="red">&nbsp;[*]</font>
										</td>
										<td class="data_tb_content" width='62%'>
											<div id="title_edit" class="paddingLeft">
												<input class="required data_tb_content"  maxlength='100' style='width:78%' 
													name="title" id="title" value="${apply.title}" type="text"/>
												<span class="remarkspan" >(限开本人或本人+单位)</span>
											</div>
											<div id="title_show" class="paddingLeft">${apply.title}</div>
										</td>
									</tr>
									<tr >
										<td class="data_tb_alignright " nowrap="nowrap" width='35%'>
											发票金额：<font color="red">&nbsp;[*]</font>
										</td>
										<td class="data_tb_content" width='62%'>
											<div id="money_edit" class="paddingLeft">
												<input class="required data_tb_content" style='width:5%' readonly="readonly"
													name="money" id="money" value="100.0" type="text"/> 元
											</div>
											<div id="money_show" class="paddingLeft">100.0　元</div>
										</td>
									</tr>
									<tr>
										<td class="data_tb_alignright " nowrap="nowrap"  width='35%'>
											收件人地址：<font color="red">&nbsp;[*]</font>
										</td>
										<td class="data_tb_content" width='62%'>
											<div id="address_edit" class="paddingLeft">
												<input class="required data_tb_content"  style='width:78%' maxlength='80'  
													name="address" id="address" value="${apply.address}" type="text"/>
											</div>
											<div id="address_show" class="paddingLeft">${apply.address}</div>
										</td>
									</tr>
									<tr >
										<td class="data_tb_alignright " nowrap="nowrap" width='35%'>
											收件人单位：<font color="red">&nbsp;[*]</font>
										</td>
										<td class="data_tb_content" width='62%'>
											<div id="workUnit_edit" class="paddingLeft">
												<input class="required data_tb_content" maxlength='80' style='width:78%' 
													name="workUnit" id="workUnit" value="${apply.workUnit}" type="text"/>
											</div>
											<div id="workUnit_show" class="paddingLeft">${apply.workUnit}</div>
										</td>
									</tr>
									<tr >
										<td class="data_tb_alignright " nowrap="nowrap" width='35%'>
											收件人：<font color="red">&nbsp;[*]</font>
										</td>
										<td class="data_tb_content" width='62%'>
											<div id="receiver_edit" class="paddingLeft">
												<input class="required data_tb_content" maxlength='20' style='width:78%' 
													name="receiver" id="receiver" value="${apply.receiver}" type="text"/>
											</div>
											<div id="receiver_show" class="paddingLeft">${apply.receiver}</div>
										</td>
									</tr>
									<tr >
										<td class="data_tb_alignright " nowrap="nowrap" width='35%'>
											收件人手机：<font color="red">&nbsp;[*]</font>
										</td>
										<td class="data_tb_content" width='62%'>
											<div id="mobile_edit" class="paddingLeft">
												<input class="required data_tb_contentinput" maxlength='16' style='width:78%' 
													name="mobile" id="mobile" value="${apply.mobile}" type="text"/>
											</div>
											<div id="mobile_show" class="paddingLeft">${apply.mobile}</div>
										</td>
									</tr>
									<tr >
										<td class="data_tb_alignright " nowrap="nowrap" width='35%'>
											邮编：<font color="red">&nbsp;[*]</font>
										</td>
										<td class="data_tb_content" width='62%'>
											<div id="postcode_edit" class="paddingLeft">
												<input class="required data_tb_contentinput" maxlength='16' style='width:78%' 
													name="postcode" id="postcode" value="${apply.postcode}" type="text"/>
											</div>
											<div id="postcode_show" class="paddingLeft">${apply.postcode}</div>
										</td>
									</tr>
									<tr >
										<td class="data_tb_alignright " nowrap="nowrap" width='35%'>备注：</td>
										<td class="data_tb_content" width='62%'>
											<div id="remark_edit" class="paddingLeft">
												<textarea rows="5" cols="67" id='remark' name='remark' maxlength='200' >
													${apply.remark }
												</textarea>
											</div>
											<div id="remark_show" class="paddingLeft">${apply.remark}</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</tbody >
				</table> <!--中部表格结束-->
			</td>
		</tr>
	</tbody>
</table>
<!-- </form> -->

<script>

	if("${type}" == "view"){
		
		// 隐藏
		$("#year_edit").hide();
		$("#title_edit").hide();
		$("#money_edit").hide();
		$("#address_edit").hide();
		$("#workUnit_edit").hide();
		$("#receiver_edit").hide();
		$("#mobile_edit").hide();
		$("#postcode_edit").hide();
		$("#remark_edit").hide();
		
		// 显示
		$("#year_show").show();
		$("#title_show").show();
		$("#money_show").show();
		$("#address_show").show();
		$("#workUnit_show").show();
		$("#receiver_show").show();
		$("#mobile_show").show();
		$("#postcode_show").show();
		$("#remark_show").show();
		
	}else{
		
		// 隐藏
		$("#year_show").hide();
		$("#title_show").hide();
		$("#money_show").hide();
		$("#address_show").hide();
		$("#workUnit_show").hide();
		$("#receiver_show").hide();
		$("#mobile_show").hide();
		$("#postcode_show").hide();
		$("#remark_show").hide();
	}

</script>

