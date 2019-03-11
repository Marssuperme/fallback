
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<input type="hidden" value="${apply.guid }" name="guid" id='guid'/>
<table border="0" cellSpacing="0" cellPadding="0" width="95%" align="center" height="100%">
	<tbody>
		<tr>
			<td height="280" vAlign="top" align="middle">
				<!--顶部图片结束--> <!--中部表格开始-->
				<table border="0" cellSpacing="0" cellPadding="0" width="100%" align="center" height="100%">
					<tbody >
						<tr>
							<td vAlign="top">
								<table style="WIDTH: 100%" class="data_tb applyBill" align="center" id='ftd'>
									<tr>
										<td class="data_tb_alignleft" colspan="2" style="height: 40px;">
											<font style="font-size:15px; font-weight: bolder;" >发票处理信息</font> 
										</td>
									</tr>
									<tr >
										<td class="data_tb_alignright " nowrap="nowrap" width='35%'>快递公司：</td>
										<td class="data_tb_content" width='60%'>
											<div style='width:80%' id="expresscom" >　${apply.expressCompany}</div>
										</td>
									</tr>
									<tr >
										<td class="data_tb_alignright " nowrap="nowrap" width='35%'>快递订单号：</td>
										<td class="data_tb_content" width='60%'>
											<div style='width:80%' id="expressNo" >　${apply.expressNo}</div>
										</td>
									</tr>
									<tr>
										<td class="data_tb_alignright " nowrap="nowrap" width='35%'>状态：</td>
										<td class="data_tb_content" width='60%'>
											<span id='statespan' name='statespan'>　</span>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</tbody>
				</table> <!--中部表格结束-->
			</td>
		</tr>
	</tbody>
</table>
<!-- </form> -->

