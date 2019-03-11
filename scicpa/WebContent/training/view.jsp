<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/Sys_INCLUDE/include.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>培训信息</title>
<style>
td {
	font-size: 12px;
	text-decoration: none;
}

#tb td {
	border: 1px solid lightblue;
}

.wb {
	border: 0px;
	border-bottom: 1px solid #aaa;
	margin: 0 10px;
}
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/JS/uploadFile.js?v=${modifyDate}"></script>
</head>

<body>
	<form name="thisForm" method="post" action=""
		enctype="multipart/form-data">
		<input type="hidden" id="companyToMicfoNo" name="companyToMicfoNo">
		<input type="hidden" id="leval2" name="leval2"> <input
			type="hidden" id="sdleval2" name="sdleval2"> <input
			type="hidden" id="loginid22" name="loginid22"> <input
			type="hidden" id="iszs" name="iszs"> <input type="hidden"
			id="iszz" name="iszz"> <input type="hidden" id="iszz2"
			name="iszz2"> <input type="hidden" id="sfzz" name="sfzz"
			value="${istransit}"> <input type="hidden" id="sfzz2"
			name="sfzz2" value="${istransit2}"> <input type="hidden"
			id="sdsfzs" name="sdsfzs"> <input type="hidden" id="sdsfzz"
			name="sdsfzz"> <input type="hidden" id="sdsfzz2"
			name="sdsfzz2"> <input type="hidden" id="syzs" name="syzs">
		<input type="hidden" id="syzz" name="syzz"> <input
			type="hidden" id="syzz2" name="syzz2"> <input type="hidden"
			id="hsysphone" name="hsysphone"> <input type="hidden"
			id="hsdphone" name="hsdphone"> <input type="hidden"
			id="phones" name="phones"> <input type="hidden" id="isstay"
			name="isstay" value="${trainingMap.isstay}"> <input
			type="hidden" id="source" name="source" value="${source}"> <input
			type="hidden" id="loginid_hyj" name="loginid_hyj" value="${loginid}">
		<input type="hidden" id="loginname_hyj" name="loginname_hyj"
			value="${loginname}"> <input type="hidden"
			id="officecode_hyj" name="officecode_hyj" value="${officecode}">
		<input type="hidden" id="ctypetabname_hyj" name="ctypetabname_hyj"
			value="${ctypetabname}">




		<div id="divBlock"
			style="position: absolute; width: 100%; height: 100%; top: expression(this.offsetParent.scrollTop); z-index: 1; padding: 10px; background: #ffffff; filter: alpha(opacity = 50); text-align: center; display: none;">
		</div>
		<div id="divProduce"
			style="position: absolute; width: 750px; height: 240px; z-index: 2; left: expression(( document.body.clientWidth-680)/2 ); top: expression(this.offsetParent.scrollTop +   130); border: 1px solid #6595d6; padding: 10px; background: #ffffff; text-align: center; display: none;">
			<fieldset>
				<legend>
					<font size="2"> <c:if
							test="${trainingMap.traintype  == '主任会计师班'}">
							<font color=red>本培训班必须所内股东或主任会计师参加！</font>
						</c:if> <c:if test="${trainingMap.traintype  != '主任会计师班'}">该所已有的会员</c:if>

					</font>
				</legend>
				<div style="height: 200px; overflow: auto">

					<input type="hidden" id="tname1" name="tname1" value=""> <input
						type="hidden" id="traintype" name="traintype"
						value=${trainingMap.traintype }>

					<table id="targetTable" cellSpacing="1" cellPadding="2"
						width="100%" bgColor="#6595d6" border="0" style="margin-top: 5px;">
						<tr>
							<td width="2px;" align="center" bgColor="#b9c4d5"><input
								type="checkbox" onclick="checkall(this);">
							</td>

							<td align="center" bgColor="#b9c4d5">姓名</td>
							<td noWrap align="center" bgColor="#b9c4d5">会员类型</td>

							<c:if test="${trainingMap.isstay=='是'}">
								<td noWrap align="center" bgColor="#b9c4d5">是否住宿</td>
							</c:if>

							<c:if test="${istransit=='是'}">
								<td noWrap align="center" bgColor="#b9c4d5">是否中转${trainingMap.szzremarks}</td>
							</c:if>

							<c:if test="${istransit2=='是'}">
								<td noWrap align="center" bgColor="#b9c4d5">是否中转${trainingMap.szzremarks1}</td>
							</c:if>

							<td noWrap align="center" bgColor="#b9c4d5">手机号码</td>
							<td noWrap align="center" bgColor="#b9c4d5">职务</td>
							<td noWrap align="center" bgColor="#b9c4d5">报名状态</td>
						</tr>

						<c:forEach items="${userList}" var="user">
							<tr>
								<td width="2px;" align="center" bgcolor="#f6f6f6"><input
									type=hidden id="loginid2" name="loginid2"
									value="${user.loginid}"> <input
									<c:if test="${user.ttype == '个人已报名'}">checked</c:if>
									<c:if test="${user.ttype == '团体代报名'}">checked</c:if>
									<c:if test="${user.ttype == '已缴费'}">checked disabled</c:if>
									<c:if test="${user.ttype == '已通过'}">checked disabled</c:if>
									name="t_name1" type="checkbox" onclick="checkone();"
									value='${user.loginname }' ttype='${user.ttype }'>
								</td>

								<input id="isshareholder" name="isshareholder"
									value="${user.isshareholder }" type="hidden">

								<td align="center" bgcolor="#f6f6f6">${user.loginname }</td>
								<td noWrap align="center" bgColor="#f6f6f6">${user.ctype }</td>

								<c:if test="${trainingMap.isstay=='是'}">
									<td noWrap align="center" bgColor="#f6f6f6"><select
										id="isdormitoryCompanyInfo" name="isdormitoryCompanyInfo"
										onchange="seeCompanyInfo(this)">
											<option value="是"
												<c:if test="${user.isdormitory == '是'}">selected</c:if>>是</option>
											<option value="否"
												<c:if test="${user.isdormitory != '是'}">selected</c:if>>否</option>
									</select></td>
								</c:if>

								<c:if test="${istransit=='是'}">
									<td noWrap align="center" bgColor="#f6f6f6"><select
										id="istransitCompanyInfo" name="istransitCompanyInfo"
										onchange="seeCompanyInfo2(this)">
											<option value="是"
												<c:if test="${user.istransit == '是'}">selected</c:if>>是</option>
											<option value="否"
												<c:if test="${user.istransit != '是'}">selected</c:if>>否</option>
									</select></td>
								</c:if>

								<c:if test="${istransit2=='是'}">
									<td noWrap align="center" bgColor="#f6f6f6"><select
										id="istransitCompanyInfo2" name="istransitCompanyInfo2"
										onchange="seeCompanyInfo2(this)">
											<option value="是"
												<c:if test="${user.istransit1 == '是'}">selected</c:if>>是</option>
											<option value="否"
												<c:if test="${user.istransit1 != '是'}">selected</c:if>>否</option>
									</select></td>
								</c:if>


								<td noWrap align="center" bgColor="#f6f6f6"><input
									type="text" class='wb' id="sysPhoneId" size="16"
									name="sysPhoneName" value="${user.phone}"
									onkeyup="value=value.replace(/[^\d\.\\-]/g,'');"></td>
								<td noWrap align="center" bgColor="#f6f6f6"><input
									type="text" class='wb' id="sysLeval" size="16" name="sysLeval"
									value="${user.leval }" onfocus="onPopDivClick(this);"
									onkeydown="onKeyDownEvent();" onkeyup="onKeyUpEvent();"
									onclick="onPopDivClick(this);" norestorehint=true autoid=33
									hideresult=true>
								</td>
								<td noWrap align="center" bgColor="#f6f6f6">${user.ttype }</td>
							</tr>
						</c:forEach>
					</table>

				</div>
			</fieldset>
			<br> <input type="hidden" id="temp" name="temp">
			
			<c:if test="${bedPresentation!=null && bedPresentation!=''}">
				<span id="companyInfo" style="display: none;"><font
					color="red"><strong>${bedPresentation }</strong>
				</font>
				</span>
			</c:if>
			<c:if test="${bedPresentation==null || bedPresentation==''}">
				<span id="companyInfo" style="display: none;"><font
					color="red"><strong>(住房预定后无法取消，请确认确实需要住宿)</strong>
				</font>
				</span>
			</c:if>
			
			<c:if test="${ZZPresentation!=null && ZZPresentation!=''}">
				<span id="companyInfo2" style="display: none;"><font
					color="red"><strong>${ZZPresentation }</strong>
				</font>
				</span>
			</c:if>
			<c:if test="${ZZPresentation==null || ZZPresentation==''}">
				<span id="companyInfo2" style="display: none;"><font
					color="red"><strong>(中转预定后无法取消，请确认确实需要中转)</strong>
				</font>
				</span>
			</c:if>
			<br>
			<br>


			<!-- 如果是主任会计师班则不能手动追加参与人 -->
			<c:if test="${trainingMap.traintype!='主任会计师班'}">	
			<div style="">
				<a href="###" onclick="addLine();">【手动追加参与人】</a>
			</div>


			<div style="overflow: auto">

				<table id="tb" cellSpacing="1" cellPadding="2" width="100%"
					border="0" style="margin-top: 5px;">
					<tr>
						<td align="center" bgColor="#b9c4d5">姓名</td>

						<c:if test="${trainingMap.isstay=='是'}">
							<td noWrap align="center" bgColor="#b9c4d5">是否住宿</td>
						</c:if>

						<c:if test="${istransit=='是'}">
							<td noWrap align="center" bgColor="#b9c4d5">
								是否中转${trainingMap.szzremarks}</td>
						</c:if>

						<c:if test="${istransit2=='是'}">
							<td noWrap align="center" bgColor="#b9c4d5">
								是否中转${trainingMap.szzremarks1}</td>
						</c:if>
						<td align="center" bgColor="#b9c4d5">手机号码</td>
						<td align="center" bgColor="#b9c4d5">职务</td>
						<td noWrap align="center" bgColor="#b9c4d5"><font
							color="#b9c4d5">操作</font>
						</td>
					</tr>
					<c:choose>
						<c:when test="${companyToMicfoNoListSize*1>0}">
							<c:forEach items="${companyToMicfoNoList}"
								var="companyToMicfoNoList">
								<tr>
									<td align="center"><input class='wb' id="xm" name="xm"
										onblur="f_blur(this)" value="${companyToMicfoNoList.tname }">
									</td>

									<c:if test="${trainingMap.isstay=='是'}">
										<td noWrap align="center"><select id='zs1' name='zs1' onchange="seeCompanyInfo(this)">
												<option value='是'
													<c:if test="${companyToMicfoNoList.isdormitory == '是'}">selected</c:if>>是</option>
												<option value='否'
													<c:if test="${companyToMicfoNoList.isdormitory != '是'}">selected</c:if>>否</option>
										</select></td>
									</c:if>

									<c:if test="${istransit=='是'}">
										<td noWrap align="center"><select id='zz1' name='zz1' onchange="seeCompanyInfo2(this)">
												<option value='是' 
													<c:if test="${companyToMicfoNoList.istransit == '是'}">selected</c:if>>是</option>
												<option value='否' 
													<c:if test="${companyToMicfoNoList.istransit != '是'}">selected</c:if>>否</option>
										</select></td>
									</c:if>

									<c:if test="${istransit2=='是'}">
										<td noWrap align="center"><select id='zz2' name='zz2' onchange="seeCompanyInfo2(this)">
												<option value='是' 
													<c:if test="${companyToMicfoNoList.istransit1 == '是'}">selected</c:if>>是</option>
												<option value='否' 
													<c:if test="${companyToMicfoNoList.istransit1 != '是'}">selected</c:if>>否</option>
										</select></td>
									</c:if>

									<td align="center"><input type="text" class='wb'
										id="sdPhoneId" name="sdPhoneName"
										value="${companyToMicfoNoList.phone}"
										onkeyup="value=value.replace(/[^\d\.\\-]/g,'');"></td>
									<td align="center"><input type="text" class='wb'
										id="sdLeval" name="sdLeval"
										value="${companyToMicfoNoList.leval}"
										onfocus="onPopDivClick(this);" onkeydown="onKeyDownEvent();"
										onkeyup="onKeyUpEvent();" onclick="onPopDivClick(this);"
										norestorehint=true autoid=33 hideresult=true></td>
									<td align="center"><a href='#' onclick='removeLine(this);'>【删除】</a>
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td align="center"><input class='wb' id="xm" name="xm"
									onblur="f_blur(this)">
								</td>

								<c:if test="${trainingMap.isstay=='是'}">
									<td noWrap align="center"><select id='zs1' name='zs1'
										 onchange='seeCompanyInfo(this);'>
											<option value='是'>是</option>
											<option value='否' selected>否</option>
									</select></td>
								</c:if>

								<c:if test="${istransit=='是'}">
									<td noWrap align="center"><select id='zz1' name='zz1' onchange="seeCompanyInfo2(this)">
											<option value='是'>是</option>
											<option value='否' selected>否</option>
									</select></td>
								</c:if>

								<c:if test="${istransit2=='是'}">
									<td noWrap align="center"><select id='zz2' name='zz2' onchange="seeCompanyInfo2(this)">
											<option value='是'>是</option>
											<option value='否' selected>否</option>
									</select></td>
								</c:if>

								<td align="center"><input type="text" class='wb'
									id="sdPhoneId" name="sdPhoneName" value="${user.phone}"
									onkeyup="value=value.replace(/[^\d\.\\-]/g,'');"></td>
								<td align="center"><input type="text" class='wb'
									id="sdLeval" name="sdLeval" value="${user.leval}"
									onfocus="onPopDivClick(this);" onkeydown="onKeyDownEvent();"
									onkeyup="onKeyUpEvent();" onclick="onPopDivClick(this);"
									norestorehint=true autoid=33 hideresult=true></td>
								<td align="center"><a href='###'
									onclick='removeLine(this);'>【删除】</a>
								</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</table>
			</div>
			</c:if>

			<!-- 
		<fieldset>
			<legend><font size="2">追加参与人</font><font size="2" color="red">(用,号分隔)</font></legend>
			<textarea rows="5" cols="50" name="tname2" id= "tname2" ></textarea>
		</fieldset>
		 -->
			<input type="hidden" name="tname2" id="tname2"> <br> <input
				type="button" onclick="saveProcedure();" class="flyBT" value="确定报名">
			<input type="button" onclick="hiddenProDiv();" class="flyBT"
				value="取消">
		</div>

		<div id="divBlock1"
			style="position: absolute; width: 100%; height: 100%; top: expression(this.offsetParent.scrollTop); z-index: 1; padding: 10px; background: #ffffff; filter: alpha(opacity = 50); text-align: center; display: none;">
		</div>
		<div id="divProduce1"
			style="position: absolute; width: 450px; height: 150px; z-index: 2; left: expression(( document.body.clientWidth-400)/2 ); top: expression(this.offsetParent.scrollTop +   130); border: 1px solid #6595d6; padding: 10px; background: #ffffff; text-align: center; display: none;">

			<div style="height: 140px; overflow: auto">

				<input type="hidden" id="tname1" name="tname1" value="">

				<table id="targetTable" cellSpacing="1" cellPadding="2" width="100%"
					bgColor="#6595d6" border="0" style="margin-top: 5px;">
					<tr>
						<td colspan=2 align="center"><font color="red"> <strong>
									请确认以下信息 </strong> </font></td>
					</tr>
					<c:if test="${trainingMap.isstay=='是'}">
						<tr>
							<td noWrap align="center" bgColor="#b9c4d5">是否住宿</td>
							<td noWrap align="left" bgColor="white"><c:if
									test="${trainingMap.isdormitory=='是'}">
									<input type="radio" id="isdormitory1" name="isdormitory1"
										value="是" checked onclick="setNotice1('y')">是
					 			<input type="radio" id="isdormitorys1" name="isdormitory1"
										value="否" onclick="setNotice1('n')">否
				 		 </c:if> <c:if
									test="${trainingMap.isdormitory=='否' || trainingMap.isdormitory=='' || trainingMap.isdormitory==null}">
									<input type="radio" id="isdormitory1" name="isdormitory1"
										value="是" onclick="setNotice1('y')">是
					 			<input type="radio" id="isdormitorys1" name="isdormitory1"
										value="否" checked onclick="setNotice1('n')">否
				 		 </c:if></td>
						</tr>
					</c:if>

					<c:if test="${istransit=='是'}">
						<tr>
							<td noWrap align="center" bgColor="#b9c4d5">是否中转${trainingMap.szzremarks}</td>
							<td noWrap align="left" bgColor="white"><input type="radio"
								id="istransit1" name="istransit1" onclick="setNoticeZZ('y')"
								value="是"
								<c:if test="${trainingMap.istransit=='是'}">checked</c:if>>是
								<input type="radio" id="istransits1" name="istransit1"
								onclick="setNoticeZZ('n')" value="否"
								<c:if test="${trainingMap.istransit=='否' || trainingMap.istransit=='' || trainingMap.istransit==null}">checked</c:if>>否
							</td>
						</tr>
					</c:if>

					<c:if test="${istransit2=='是'}">
						<tr>
							<td noWrap align="center" bgColor="#b9c4d5">是否中转${trainingMap.szzremarks1}</td>
							<td noWrap align="left" bgColor="white"><input type="radio"
								id="istransit2" name="istransit2" onclick="setNoticeZZ1('y')"
								value="是" <c:if test="${istransit2=='是'}">checked</c:if>>是
								<input type="radio" id="istransits2" name="istransit2"
								onclick="setNoticeZZ1('n')" value="否"
								<c:if test="${istransit2=='否' || istransit2=='' || istransit2==null}">checked</c:if>>否
							</td>
						</tr>
					</c:if>

					<tr>
						<td noWrap align="center" bgColor="#b9c4d5">手机号码</td>
						<td noWrap align="left" bgColor="white"><input type="text"
							id="phone" name="phone" value="${trainingMap.phone}"
							onkeyup="value=value.replace(/[^\d\.\\-]/g,'');"> <font
							color="red">(请确认手机号码，以便发培训短信)</font></td>
					</tr>
					<tr>
						<td noWrap align="center" bgColor="#b9c4d5">职务</td>
						<td noWrap align="left" bgColor="white"><input type="text"
							id="leval" name="leval" value="${trainingMap.leval}"
							onfocus="onPopDivClick(this);" onkeydown="onKeyDownEvent();"
							onkeyup="onKeyUpEvent();" onclick="onPopDivClick(this);"
							norestorehint=true autoid=33 hideresult=true></td>
					</tr>
				</table>
				<c:if test="${bedPresentation==null }">
					<span id="notice1" style="display: none;"><font color="red">(住房预定后无法取消，请确认确实需要住宿)</font>
					</span>
				</c:if>
				<c:if test="${bedPresentation!=null }">
					<span id="notice1" style="display: none;"><font color="red">${bedPresentation
							}</font>
					</span>
				</c:if>
				<c:if test="${ZZPresentation==null }">
					<span id="notice2" style="display: none;"><font color="red">(中转确定后无法取消，请确认确实需要中转)</font>
					</span>
				</c:if>
				<c:if test="${ZZPresentation!=null }">
					<span id="notice2" style="display: none;"><font color="red">${ZZPresentation
							}</font>
					</span>
				</c:if>

			</div>
			<input type="button" onclick="savePerson();" class="flyBT" value="确定">
			<input type="button" onclick="hiddenProDiv1();" class="flyBT"
				value="取消">
		</div>

		<input type="hidden" id="trainingid" name="trainingid"
			value="${trainingMap.id }"> <input type="hidden"
			id="trainingname" name="trainingname"
			value="${trainingMap.trainingname }"> <input type="hidden"
			id="status" name="status" value="${trainingMap.status }"> <input
			type="hidden" id="loginid" name="loginid"
			value="${trainingMap.loginid }"> <input type="hidden"
			id="lessonid" name="lessonid" value="${trainingMap.lessonid }">
		<input type="hidden" id="expense" name="expense"
			value="${trainingMap.expense }"> <input type="hidden"
			id="lessonname" name="lessonname" value="${trainingMap.lessonname }">
		<input type="hidden" id="orderid" name="orderid"
			value="${trainingMap.orderid }">

		<table width="100%" height="121" border="0" cellpadding="0"
			cellspacing="1" bgcolor="#6595d6">
			<tr>
				<c:if test="${source!='hyj_kqpxb'}">
					<input icon="icon-search" type="button" name="next"
						value="所属注册会计师学时查询" onclick="f_query();">
				</c:if>

				<td align="center" valign="top" bordercolor="#CCCCCC"
					bgcolor="#FFFFFF"><br>
					<h4>${trainingMap.trainingname }</h4>


					<table width="98%" border="0" align="center" cellpadding="2"
						cellspacing="1" bgcolor="#6595d6">
						<tr height=18>
							<td width="20%" height="20" align="right" bgColor="#EEEEEE"><strong>发布机构</strong>
							</td>
							<td width="80%" align="left" bgColor="#ffffff">${trainingMap.agency
								}</td>
						</tr>

						<!-- 
	<tr height=18>
	  	<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>发布人</strong></td>
	  	<td width="80%" align="left" bgColor="#ffffff" >${trainingMap.aname }</td>
	</tr>
	 -->

						<tr height=18>
							<td width="20%" height="20" align="right" bgColor="#EEEEEE"><strong>发布时间</strong>
							</td>
							<td width="80%" align="left" bgColor="#ffffff">${trainingMap.ntime
								}</td>
						</tr>
						<tr height=18>
							<td width="20%" height="20" align="right" bgColor="#EEEEEE"><strong>状态</strong>
							</td>
							<td width="80%" align="left" bgColor="#ffffff">${trainingMap.status
								}</td>
						</tr>
						<tr height=18>
							<td width="20%" height="20" align="right" bgColor="#EEEEEE"><strong>培训班名称</strong>
							</td>
							<td width="80%" align="left" bgColor="#ffffff">${trainingMap.trainingname
								}</td>
						</tr>
						<tr height=18>
							<td width="20%" height="20" align="right" bgColor="#EEEEEE"><strong>培训班类型</strong>
							</td>
							<td width="80%" align="left" bgColor="#ffffff">${trainingMap.traintype
								}</td>
						</tr>
						<!-- 
	<tr height=18>
	  	<td width="20%" height="20" align="right" bgColor="#EEEEEE" ><strong>期次</strong></td>
	  	<td width="80%" align="left" bgColor="#ffffff" >${trainingMap.term }</td>
	</tr>
	 -->
						<tr>
							<td height="22" align="right" bgColor="#EEEEEE"><strong>培训内容</strong>
							</td>
							<td align="left" bgColor="#FFFFFF"><textarea
									style="width: 90%" readonly="readonly" rows="3">${trainingMap.lessonname }</textarea>
							</td>
						</tr>
						<tr>
							<td height="22" align="right" bgColor="#EEEEEE"><strong>课程安排</strong>
							</td>
							<td align="left" bgColor="#FFFFFF"><textarea
									style="width: 90%" readonly="readonly" rows="3">${trainingMap.curriculum }</textarea>
							</td>
						</tr>
						<tr>
							<td height="22" align="right" bgColor="#EEEEEE"><strong>培训范围</strong>
							</td>
							<td align="left" bgColor="#FFFFFF"><textarea
									style="width: 90%" readonly="readonly" rows="3">${trainingMap.areas }</textarea>
							</td>
						</tr>
						<tr>
							<td height="22" align="right" bgColor="#EEEEEE"><strong>线下付款信息</strong>
							</td>
							<td align="left" bgColor="#FFFFFF"><textarea
									style="width: 90%" readonly="readonly" rows="3">${trainingMap.bank }</textarea>
							</td>
						</tr>
						<tr>
							<td height="22" align="right" bgColor="#EEEEEE"><strong>每人费用</strong>
							</td>
							<td align="left" bgColor="#FFFFFF">${trainingMap.expense }元</td>
						</tr>
						<tr height=18>
							<td height="22" align="right" bgColor="#EEEEEE"><strong>培训地点</strong>
							</td>
							<td align="left" bgColor="#ffffff">${trainingMap.place }</td>
						</tr>
						<tr height=18>
							<td height="20" align="right" bgColor="#EEEEEE"><strong>讲师教师</strong>
							</td>
							<td align="left" bgColor="#ffffff">${trainingMap.teacher }</td>
						</tr>
						<tr height=18>
							<td height="20" align="right" bgColor="#EEEEEE"><strong>培训日期</strong>
							</td>
							<td align="left" bgColor="#ffffff">${trainingMap.trainingbdate
								} - ${trainingMap.trainingedate }</td>
						</tr>
						<tr>
							<td height="22" align="right" bgColor="#EEEEEE"><strong>限定人数</strong>
							</td>
							<td align="left" bgColor="#FFFFFF">${trainingMap.quote }</td>
						</tr>
						<tr>
							<td height="22" align="right" bgColor="#EEEEEE"><strong>可报名人数</strong>
							</td>
							<td align="left" bgColor="#FFFFFF">${countEnroll}</td>
						</tr>
						<tr>
							<td height="22" align="right" bgColor="#EEEEEE"><strong>报名起止日期</strong>
							</td>
							<td align="left" bgColor="#FFFFFF">${trainingMap.enrollbdate
								} - ${trainingMap.enrolledate }</td>
						</tr>

						<!-- 
	<tr>
		<td height="22" align="right" bgColor="#EEEEEE"><strong>缴费起止日期</strong></td>
	 	<td align="left" bgColor="#FFFFFF">${trainingMap.expensebdate } - ${trainingMap.expenseedate } </td>
	</tr>
	 -->

						<tr>
							<td height="22" align="right" bgColor="#EEEEEE"><strong>附
									件</strong>
							</td>
							<td align="left" bgColor="#FFFFFF"><div
									id="${trainingMap.attachmentid }"></div>
							</td>
						</tr>


					</table>

					<div style="display: none">
						<table>
							<tr>
								<td height="22" align="right" bgColor="#EEEEEE"><strong>是否住宿</strong>
								</td>
								<td align="left" bgColor="#FFFFFF"><c:if
										test="${trainingMap.isdormitory=='是'}">
										<input type="radio" id="isdormitory" name="isdormitory"
											value="是" checked onclick="setzs('y')">是
			 			<input type="radio" id="isdormitorys" name="isdormitory"
											value="否" onclick="setzs('n')">否
			 		</c:if> <c:if
										test="${trainingMap.isdormitory=='否' || trainingMap.isdormitory=='' || trainingMap.isdormitory==null}">
										<input type="radio" id="isdormitory" name="isdormitory"
											value="是" onclick="setzs('y')">是
			 			<input type="radio" id="isdormitorys" name="isdormitory"
											value="否" checked onclick="setzs('n')">否
			 		</c:if></td>
							</tr>
							<c:if test="${trainingMap.istransit=='是'}">
								<tr>
									<td height="22" align="right" bgColor="#EEEEEE"><strong>是否中转${trainingMap.szzremarks}</strong>
									</td>
									<td align="left" bgColor="#FFFFFF"><input type="radio"
										id="istransit" name="istransit" value="是" onclick="setzz('y')"
										<c:if test="${trainingMap.istransit=='是'}">checked</c:if>>是
										<input type="radio" id="istransits" name="istransit" value="否"
										onclick="setzz('n')"
										<c:if test="${trainingMap.istransit=='否' || trainingMap.istransit=='' || trainingMap.istransit==null}">checked</c:if>>否
									</td>
								</tr>
							</c:if>
							<c:if test="${trainingMap.istransit1=='是'}">
								<tr>
									<td height="22" align="right" bgColor="#EEEEEE"><strong>是否中转${trainingMap.szzremarks1}</strong>
									</td>
									<td align="left" bgColor="#FFFFFF"><input type="radio"
										id="istransit2" name="istransit2" value="是"
										onclick="setzz1('y')"
										<c:if test="${istransit2=='是'}">checked</c:if>>是 <input
										type="radio" id="istransits2" name="istransit2" value="否"
										onclick="setzz1('n')"
										<c:if test="${istransit2=='否' || istransit2=='' || istransit2==null}">checked</c:if>>否
									</td>
								</tr>
							</c:if>
						</table>
					</div> <br> <br> <c:choose>
						<c:when test="${trainingMap.trainingway=='在线'}">
							<table width="90%" align="center">
								<tr height=18>
									<td width="20%" height="20" align="center"><font
										color="red">注意：该培训班为在线培训班,无需网上报名！</font>
									</td>
								</tr>
								<tr>
									<td width="" align="center"><c:if
											test="${source!='hyj_kqpxb'}">
											<input icon="icon-back" type="button" name="next"
												value="返  回" onclick="go();">
										</c:if></td>
								</tr>
							</table>
						</c:when>
						<c:otherwise>

							<c:choose>
								<c:when test="${trainingMap.enrolledate < today}">
									<table width="98%" border="0" align="center" cellpadding="2"
										cellspacing="1" bgcolor="#6595d6">
										<tr height=18>
											<td width="20%" height="20" align="right" bgColor="#EEEEEE"><strong>参加人</strong><font
												color="#FF0000">&nbsp;[*]</font>
											</td>
											<td width="80%" valign="bottom" align="left"
												bgColor="#ffffff"><textarea rows="5" cols="100"
													name="tname" id="tname" disabled="disabled">${trainingMap.tname }</textarea>
											</td>
										</tr>
									</table>

									<table width="90%" align="center">
										<tr height=18>
											<td width="20%" height="20" align="center"><font
												color="red">注意：报名时间已过，不能报名</font>
											</td>
										</tr>
										<tr>
											<td width="" align="center"><c:if
													test="${source!='hyj_kqpxb'}">
													<input icon="icon-back" type="button" name="next"
														value="返  回" onclick="go();">
												</c:if></td>
										</tr>
									</table>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${trainingMap.status != '报名中'}">
											<table width="98%" border="0" align="center" cellpadding="2"
												cellspacing="1" bgcolor="#6595d6">
												<tr height=18>
													<td width="20%" height="20" align="right" bgColor="#EEEEEE">
														<strong>参加人</strong><font color="#FF0000">&nbsp;[*]</font>
													</td>
													<td width="80%" valign="bottom" align="left"
														bgColor="#ffffff"><textarea rows="5" cols="100"
															name="tname" id="tname" disabled="disabled">${trainingMap.tname }</textarea>
													</td>
												</tr>
											</table>
											<table width="90%" align="center">
												<tr height=18>
													<td width="20%" height="20" align="center"><font
														color="red">注意：当前状态为${trainingMap.status }，不能报名</font>
													</td>
												</tr>
												<tr>
													<td width="" align="center"><c:if
															test="${source!='hyj_kqpxb'}">
															<input icon="icon-back" type="button" name="next"
																value="返  回" onclick="go();">
														</c:if></td>
												</tr>
											</table>
										</c:when>
										<c:otherwise>
											<c:choose>
												<c:when
													test="${trainingMap.quote*1 <= trainingMap.tcount*1 }">
													<table width="98%" border="0" align="center"
														cellpadding="2" cellspacing="1" bgcolor="#6595d6">
														<tr height=18>
															<td width="20%" height="20" align="right"
																bgColor="#EEEEEE"><strong>参加人</strong><font
																color="#FF0000">&nbsp;[*]</font>
															</td>
															<td width="80%" valign="bottom" align="left"
																bgColor="#ffffff"><c:choose>
																	<c:when
																		test="${trainingMap.ctypetabname == 'k_company'}">
																		<c:choose>
																			<c:when
																				test="${trainingMap.tname!='' && trainingMap.tname!=null }">
																				<textarea rows="5" cols="100" name="tname"
																					id="tname" onclick="setName();">${trainingMap.tname }</textarea>
																			</c:when>
																			<c:otherwise>
																				<textarea rows="5" cols="100" name="tname"
																					id="tname" disabled="disabled">${trainingMap.tname }</textarea>
																			</c:otherwise>
																		</c:choose>
																	</c:when>
																	<c:otherwise>
																		<c:choose>
																			<c:when
																				test="${trainingMap.tname!='' && trainingMap.tname!=null }">
																				<textarea rows="5" cols="100" name="tname"
																					id="tname" onclick="seeProDiv1()">${trainingMap.tname }</textarea>
																			</c:when>
																			<c:otherwise>
																				<textarea rows="5" cols="100" name="tname"
																					id="tname" disabled="disabled">${trainingMap.tname }</textarea>
																			</c:otherwise>
																		</c:choose>
																	</c:otherwise>
																</c:choose></td>
														</tr>
													</table>

													<table width="90%" align="center">
														<tr height=18>
															<td width="20%" height="20" align="center"><font
																color="red">注意：报名人数已满</font>
															</td>
														</tr>
														<tr>
															<td width="" align="center"><c:choose>
																	<c:when
																		test="${trainingMap.ctypetabname == 'k_company'}">
																		<c:choose>
																			<c:when
																				test="${trainingMap.tname!='' && trainingMap.tname!=null }">
																				<!-- 
													<input icon="icon-static" type="button" name="next" value="进行缴费"  onclick="pay()"  >
													 -->
																				<input icon="icon-delete" type="button" name="next"
																					value="取消全部报名"
																					onclick="del('${trainingMap.trainingid }','${trainingMap.orderstate }');">
																				<input icon="icon-edit" type="button" name="next"
																					value="修改报名" onclick="setName();">
																				<c:if test="${source!='hyj_kqpxb'}">
																					<input icon="icon-back" type="button" name="next"
																						value="返  回" onclick="go();">
																				</c:if>
																			</c:when>
																			<c:otherwise>
																				<c:if test="${source!='hyj_kqpxb'}">
																					<input icon="icon-back" type="button" name="next"
																						value="返  回" onclick="go();">
																				</c:if>
																			</c:otherwise>
																		</c:choose>
																	</c:when>
																	<c:otherwise>
																		<c:choose>
																			<c:when
																				test="${trainingMap.tname!='' && trainingMap.tname!=null }">
																				<!-- 
													<input icon="icon-static" type="button" name="next" value="进行缴费"  onclick="pay()"  >
													 -->
																				<input icon="icon-edit" type="button" name="next"
																					value="修改报名" onclick="seeProDiv1()">
																				<input icon="icon-delete" type="button" name="next"
																					value="取消报名"
																					onclick="del('${trainingMap.trainingid }','${trainingMap.orderstate }');">
																				<c:if test="${source!='hyj_kqpxb'}">
																					<input icon="icon-back" type="button" name="next"
																						value="返  回" onclick="go();">
																				</c:if>
																			</c:when>
																			<c:otherwise>
																				<c:if test="${source!='hyj_kqpxb'}">
																					<input icon="icon-back" type="button" name="next"
																						value="返  回" onclick="go();">
																				</c:if>
																			</c:otherwise>
																		</c:choose>
																	</c:otherwise>
																</c:choose></td>
														</tr>
													</table>
												</c:when>
												<c:otherwise>
													<c:choose>
														<c:when test="${trainingMap.ctypetabname == 'k_company'}">
															<c:choose>
																<c:when test="${trainingMap.expenseedate < today}">
																	<table width="98%" border="0" align="center"
																		cellpadding="2" cellspacing="1" bgcolor="#6595d6">
																		<tr height=18>
																			<td width="20%" height="20" align="right"
																				bgColor="#EEEEEE"><strong>参加人</strong><font
																				color="#FF0000">&nbsp;[*]</font>
																			</td>
																			<td width="80%" valign="bottom" align="left"
																				bgColor="#ffffff"><textarea rows="5"
																					cols="100" name="tname" id="tname"
																					disabled="disabled">${trainingMap.tname }</textarea>
																			</td>
																		</tr>
																	</table>

																	<table width="90%" align="center">
																		<tr>
																			<td width="" align="center">
																				<div>
																					<font color="red">注意：缴费日期已过，不能进行缴费</font>
																				</div> <br> <c:choose>
																					<c:when
																						test="${trainingMap.tname!='' && trainingMap.tname!=null }">
																						<input icon="icon-delete" type="button"
																							name="next" value="取消全部报名"
																							onclick="del('${trainingMap.trainingid }','${trainingMap.orderstate }');">
																						<c:if test="${source!='hyj_kqpxb'}">
																							<input icon="icon-back" type="button" name="next"
																								value="返  回" onclick="go();">
																						</c:if>
																					</c:when>
																					<c:otherwise>
																						<c:if test="${source!='hyj_kqpxb'}">
																							<input icon="icon-back" type="button" name="next"
																								value="返  回" onclick="go();">
																						</c:if>
																					</c:otherwise>
																				</c:choose></td>
																		</tr>
																	</table>
																</c:when>
																<c:otherwise>
																	<table width="98%" border="0" align="center"
																		cellpadding="2" cellspacing="1" bgcolor="#6595d6">
																		<tr height=18>
																			<td width="20%" height="20" align="right"
																				bgColor="#EEEEEE"><strong>参加人</strong><font
																				color="#FF0000">&nbsp;[*]</font>
																			</td>
																			<td width="80%" valign="bottom" align="left"
																				bgColor="#ffffff"><c:choose>
																					<c:when
																						test="${trainingMap.tname!='' && trainingMap.tname!=null }">
																						<c:choose>
																							<c:when test="${trainingMap.orderstate == 1}">
																								<textarea rows="5" cols="100" name="tname"
																									id="tname" readonly="readonly">${trainingMap.tname }</textarea>
																							</c:when>
																							<c:otherwise>
																								<textarea rows="5" cols="100" name="tname"
																									id="tname" onclick="setName()">${trainingMap.tname }</textarea>
																							</c:otherwise>
																						</c:choose>
																					</c:when>
																					<c:otherwise>
																						<textarea rows="5" cols="100" name="tname"
																							id="tname" onclick="setName()">${trainingMap.tname }</textarea>
																					</c:otherwise>
																				</c:choose></td>
																		</tr>
																	</table>

																	<table width="90%" align="center">
																		<tr>
																			<td width="" align="center"><c:choose>
																					<c:when
																						test="${trainingMap.tname!='' && trainingMap.tname!=null }">
																						<c:choose>
																							<c:when test="${trainingMap.orderstate == 1}">
																								<div>
																									<font color="red">注意：已缴费状态！</font>
																								</div>
																								<br>
																								<c:if test="${source!='hyj_kqpxb'}">
																									<input icon="icon-back" type="button"
																										name="next" value="返  回" onclick="go();">
																								</c:if>
																							</c:when>
																							<c:otherwise>
																								<!-- 
																	<input icon="icon-static" type="button" name="next" value="进行缴费"  onclick="pay()"  >
																	 -->
																								<input icon="icon-delete" type="button"
																									name="next" value="取消全部报名"
																									onclick="del('${trainingMap.trainingid }','${trainingMap.orderstate }');">
																								<input icon="icon-edit" type="button"
																									name="next" value="修改报名" onclick="setName();">
																								<c:if test="${source!='hyj_kqpxb'}">
																									<input icon="icon-back" type="button"
																										name="next" value="返  回" onclick="go();">
																								</c:if>
																							</c:otherwise>
																						</c:choose>
																					</c:when>
																					<c:otherwise>
																						<input icon="icon-save" type="button" name="next"
																							value="报  名" onclick="setName();">
																						<c:if test="${source!='hyj_kqpxb'}">
																							<input icon="icon-back" type="button" name="next"
																								value="返  回" onclick="go();">
																						</c:if>
																					</c:otherwise>
																				</c:choose></td>
																		</tr>
																	</table>
																</c:otherwise>
															</c:choose>
														</c:when>
														<c:otherwise>
															<c:choose>
																<c:when test="${trainingMap.expenseedate < today}">
																	<input type="hidden" name="tname" id="tname"
																		value="${trainingMap.loginname }">
																	<input type="hidden" name="tid" id="tid"
																		value="${trainingMap.loginid }">
																	<table width="90%" align="center">
																		<tr>
																			<td width="" align="center">
																				<div>
																					<font color="red">注意：缴费日期已过，不能进行缴费</font>
																				</div> <br> <c:if
																					test="${trainingMap.tname!='' && trainingMap.tname!=null }">
																					<input icon="icon-delete" type="button" name="next"
																						value="取消报名"
																						onclick="del('${trainingMap.trainingid }','${trainingMap.orderstate }');">
																				</c:if> <c:if test="${source!='hyj_kqpxb'}">
																					<input icon="icon-back" type="button" name="next"
																						value="返  回" onclick="go();">
																				</c:if></td>
																		</tr>
																	</table>
																</c:when>
																<c:otherwise>
																	<input type="hidden" name="tname" id="tname"
																		value="${trainingMap.loginname }">
																	<input type="hidden" name="tid" id="tid"
																		value="${trainingMap.loginid }">
																	<table width="90%" align="center">
																		<tr>
																			<td width="" align="center"><c:choose>
																					<c:when
																						test="${trainingMap.tname!='' && trainingMap.tname!=null }">
																						<c:choose>
																							<c:when test="${trainingMap.orderstate == 1}">
																								<div>
																									<font color="red">注意：已缴费状态！</font>
																								</div>
																								<br>
																								<c:if test="${source!='hyj_kqpxb'}">
																									<input icon="icon-back" type="button"
																										name="next" value="返  回" onclick="go();">
																								</c:if>
																							</c:when>
																							<c:otherwise>
																								<!-- 
																	<input icon="icon-static" type="button" name="next" value="进行缴费"  onclick="pay()"  >
																	 -->
																								<input icon="icon-edit" type="button"
																									name="next" value="修改报名" onclick="seeProDiv1()">
																								<input icon="icon-delete" type="button"
																									name="next" value="取消报名"
																									onclick="del('${trainingMap.trainingid }','${trainingMap.orderstate }');">
																								<c:if test="${source!='hyj_kqpxb'}">
																									<input icon="icon-back" type="button"
																										name="next" value="返  回" onclick="go();">
																								</c:if>
																							</c:otherwise>
																						</c:choose>
																					</c:when>
																					<c:otherwise>
																						<input icon="icon-save" type="button" name="next"
																							value="我要报名" onclick="seeProDiv1();">
																						<c:if test="${source!='hyj_kqpxb'}">
																							<input icon="icon-back" type="button" name="next"
																								value="返  回" onclick="go();">
																						</c:if>
																					</c:otherwise>
																				</c:choose></td>
																		</tr>
																	</table>
																</c:otherwise>
															</c:choose>
														</c:otherwise>
													</c:choose>
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose></td>
			</tr>
		</table>

	</form>
</body>
</html>
<script type="text/javascript">

String.prototype.replaceAll  = function(s1,s2){    
	return this.replace(new RegExp(s1,"gm"),s2);    
}

try{
	
	
	$('#${trainingMap.attachmentid }').uploadFile({
		indexId: '${trainingMap.attachmentid }',
		module:'${trainingMap.table }',
		forbitUpload:true,
		forbitDel:true
	});
}catch(e){}	 

function get(the){

	var str = ",";
	var oInput = document.getElementsByName("t_name1");
	for(var i = 0; i < oInput.length; i++){
		 str = str + oInput[i].value + ',';
	}
	

	var opt = 0;
	var the1 = ",";
	the = the.replaceAll(" ","");
	the = the.replaceAll("，",",");
	the = the.replaceAll("\n",",");
	the = the.replaceAll("\r","");
	
	if(the != ""){
		var len = the.split(",");	
		for(var i=0;i<len.length;i++){
			if(len[i] != "") {
				if(the1.indexOf("," + len[i] + ",") == -1){//去掉名字一样的
					if(str.indexOf("," + len[i] + ",") == -1){//去掉已有的会员
						opt ++;
						the1 += len[i] + ",";
					}
				}
			}
		}	
	}
	if(the1 == ",") return "";
	
	//document.getElementById("opt").innerText = opt;
	
	return the1.substring(1);
	//obj.value = the1.substring(1);
	
	//alert("共有【"+opt+"】人报名")
}

function save(){

	var tname = document.getElementById("tname").value;
	if(tname == ""){
		alert("请输入培训参与人！");
		return ;
	}

	// 报名截止日期
	var endDate = "${trainingMap.enrolledate }";

	// 当前日期
	var date = new Date();
	var year = date.getYear();
	var month = date.getMonth()+1;
	var day = date.getDate();
	if(month*1<10){
		month = "0"+month;
	}	
	if(day*1<10){
		day = "0"+day;
	}
	var now = year+"-"+month+"-"+day;

	if(now>endDate){
		alert("报名截止日期:'"+endDate+"'已过,不能报名!");
		return;
	}
	
	var lessonid = document.getElementById("lessonid").value;
	
	var oBao = new ActiveXObject("Microsoft.XMLHTTP");
	var url="${pageContext.request.contextPath}/common/training.do?method=lesson&lessonid="+lessonid+"&random="+Math.random() ;
	oBao.open("POST",url,false);
	oBao.send();

	resText = oBao.responseText ;
	var bool = true;
	
	if(resText.indexOf("1")>-1){
		alert("您已经通过本次培训课程的培训，无需再报。");
		return ;
	} 
	/*
	else if(resText.indexOf("2")>-1){
		if(!confirm("您已经参加本次培训课程的报名，但没有通过本次培训；\n按照相关规定，您还要重新参加培训，并补缴二次报名费用。\n是否继续？","提示")){
			bool = false;
		}
	}
	*/
	if(viewCount()){
		document.thisForm.action = "${pageContext.request.contextPath}/common/training.do?method=save";
		document.thisForm.target = "";
		document.thisForm.submit();
	}
}


// 个人报名
function savePerson(){

	var phone = document.getElementById("phone").value;
	if(phone == ""){
		alert("请确认手机号码，以便发培训短信！");
		return ;
	}
	
	// 报名截止日期
	var endDate = "${trainingMap.enrolledate }";

	// 当前日期
	var date = new Date();
	var year = date.getYear();
	var month = date.getMonth()+1;
	var day = date.getDate();
	if(month*1<10){
		month = "0"+month;
	}	
	if(day*1<10){
		day = "0"+day;
	}
	var now = year+"-"+month+"-"+day;

	if(now>endDate){
		alert("报名截止日期:'"+endDate+"'已过,不能报名!");
		return;
	}
	
	var lessonid = document.getElementById("lessonid").value;
	
	var oBao = new ActiveXObject("Microsoft.XMLHTTP");
	var url="${pageContext.request.contextPath}/common/training.do?method=lesson&lessonid="+lessonid+"&random="+Math.random() ;
	oBao.open("POST",url,false);
	oBao.send();

	resText = oBao.responseText ;
	var bool = true;
	
	if(resText.indexOf("1")>-1){
		alert("您已经通过本次培训课程的培训，无需再报。");
		return ;
	} 
	/*
	else if(resText.indexOf("2")>-1){
		if(!confirm("您已经参加本次培训课程的报名，但没有通过本次培训；\n按照相关规定，您还要重新参加培训，并补缴二次报名费用。\n是否继续？","提示")){
			bool = false;
		}
	}
	*/
	
	// 查看报名人数
	if(confirm("您确定要报名吗？")){
		document.thisForm.action = "${pageContext.request.contextPath}/common/training.do?method=savePerson";
		document.thisForm.target = "";
		document.thisForm.submit();
	}
}



function save1(){
	var tname = document.getElementById("tname").value;
	if(tname == "" || tname == "," ){
		alert("请输入培训参与人！");
		return ;
	}


	if(confirm("确定是这些参与人进行报名了吗？")){
		// 报名截止日期
		var endDate = "${trainingMap.enrolledate }";
	
		// 当前日期
		var date = new Date();
		var year = date.getYear();
		var month = date.getMonth()+1;
		var day = date.getDate();
		if(month*1<10){
			month = "0"+month;
		}	
		if(day*1<10){
			day = "0"+day;
		}
		var now = year+"-"+month+"-"+day;
	
		if(now>endDate){
			alert("报名截止日期:'"+endDate+"'已过,不能报名!");
			return;
		}
		
		// 查看报名人数 
		if(viewCount()){
			document.thisForm.action = "${pageContext.request.contextPath}/common/training.do?method=save";
			document.thisForm.target = "";
			document.thisForm.submit();
		}
	} 
}

//取消报名
function del(eid,isexp){
	if(confirm("是否取消报名?")){
		//if(isexp == 1){
			//alert("该参与人已经缴费，不能取消2！");
			//return ;
		//}
	
		var loginid = "${loginid}";
		var ctypetabname = "${ctypetabname}";
		
		var url="${pageContext.request.contextPath}/common/training.do?method=del";
		var request = "&nid="+eid+"&loginid="+loginid+"&ctypetabname="+ctypetabname+"&random="+Math.random();
		var resText = ajaxLoadPageSynch(url,request);
		
		alert(resText);
		//window.location.reload();
		location.href = location.href;
	}
}
function go(){
	window.history.back();
	//window.location="${pageContext.request.contextPath}/common/training.do";
}


function go2(){
	//window.history.back();
	window.location="${pageContext.request.contextPath}/common/training.do?param=micfo";
}

function setName(){

	var divObj = document.getElementById("divProduce");
	var blockObj =  document.getElementById("divBlock");
	divObj.style.display = "";
	blockObj.style.display = "";
	
	var tname =  ","+document.getElementById("tname").value+",";
	var tname2 =  document.getElementById("tname2");
	//the = the.replaceAll(" ","");
	var oChooses = document.getElementsByName("t_name1");
    for(i = 0; i < oChooses.length; i++){
      if(oChooses[i].checked == true ){
		 tname = ","+tname.replaceAll(","+oChooses[i].value+",","")+",";
      }
	}
	tname = tname.replaceAll(",,","");
	tname2.value = tname;  // 手动增加的textarea中的人员
}

function hiddenProDiv() {
	divObj = document.getElementById("divProduce");
	blockObj =  document.getElementById("divBlock");
	divObj.style.display = "none";
	blockObj.style.display = "none";
	
	
	// 系统电话号码隐藏域对象
	var hsp = document.getElementById("hsysphone").value;

	// 手动电话号码隐藏域对象
	var sdp = document.getElementById("hsdphone").value;
	if(hsp=="" || hsp == null){
		document.getElementById("phones").value=sdp;
	}else{
		document.getElementById("phones").value=hsp+","+sdp;
	}
	
	// 操作 系统人员的 table
	checkone();
	
	// 得到 系统人员
	var tname1 = document.getElementById("tname1");

	//var tname2 = document.getElementById("tname2");
	//tname2.value = get(tname2.value);

	// 得到手动添加的人员
	var temp = "";
	var xm = document.getElementsByName("xm");
	for(var i=0;i<xm.length;i++){
		if(xm[i].value!=""){
			temp = temp + xm[i].value+",";
		}
	}
	var sdLevalTemp = "";
	var sdLeval = document.getElementsByName("sdLeval");
	for(var i=0;i<sdLeval.length;i++){
		if(sdLeval[i].value!=""){
			sdLevalTemp = sdLevalTemp + sdLeval[i].value+",";
		}else{
			sdLevalTemp = sdLevalTemp + "无,";
		}
	}
	var leval2 = document.getElementById("leval2").value;
	if(leval2!="" &&leval2 != null){
		sdLevalTemp = document.getElementById("leval2").value +","+sdLevalTemp;
	}
	
	var tname = "";
	if(tname1.value==""){
		tname = temp;
	}else{
		tname = tname1.value + "," + temp;
	} 
	
	document.getElementById("tname").value = tname.substring(0,tname.length-1);
	document.getElementById("leval2").value = sdLevalTemp.substring(0,sdLevalTemp.length-1);
	// 事务所用户添加非执业会员
	document.getElementById("companyToMicfoNo").value = temp.substring(0,temp.length-1);
			
			
}


// 处理系统电话号码
function f_sysphone(){
	// 得到复选框对象 
	var oChooses = document.getElementsByName("t_name1");
	// 系统电话号码对象 
	var spn = document.getElementsByName("sysPhoneName"); 
	// 系统所属级别 
	var sysLeval = document.getElementsByName("sysLeval"); 
	// 系统电话号码隐藏域对象
	var hsp = document.getElementById("hsysphone").value;
	// 系统所属级别隐藏域对象
	var leval2 = document.getElementById("leval2").value;
	// loginid2 
	var loginid2 = document.getElementsByName("loginid2");
	var loginidTemp = "";
	// 重新清空
	hsp = "";
	leval2 = "";
	var temp = "";
    for(i = 0; i < oChooses.length; i++){
    	if(oChooses[i].checked == true ){
	      if(spn[i].value == ""){
				alert("请确认手机号码，以便发培训短信!");
				spn[i].focus();
				return false;
	      }else if(spn[i].value.length != 11){		//shazi
		    	 alert("手机号码长度应为11位,请验证!");
				 spn[i].focus();
		 		 return false;
		  }else{
			 	temp = temp+","+spn[i].value;
	      }
	      if(sysLeval[i].value==""){
		      	 alert("职务不能为空!");
				 sysLeval[i].focus();
		 		 return false;
	      }else{
	      	 	leval2 = leval2+","+sysLeval[i].value;
	      }
	      loginidTemp = loginidTemp + ","+loginid2[i].value;
    	}
	}
    document.getElementById("hsysphone").value = temp.substring(1,temp.length);
    document.getElementById("leval2").value = leval2.substring(1,leval2.length);
    document.getElementById("loginid22").value = loginidTemp.substring(1,loginidTemp.length);
    return true;
}


// 处理手动电话号码 
function f_sdphone(){
	// 得到手动添加的人员对象 
	var oChooses = document.getElementsByName("xm");
	// 手动电话号码对象 
	var spn = document.getElementsByName("sdPhoneName"); 
	// 手动电话号码隐藏域对象
	var sdp = document.getElementById("hsdphone").value;
	// 手动所属级别 
	var sdLeval = document.getElementsByName("sdLeval"); 
	// 重新清空
	sdp = "";
	var temp = "";
	var leval2 = "";
    for(i = 0; i < oChooses.length; i++){
    	if(oChooses[i].value != "" ){
	      if(spn[i].value == ""){
			 alert("请确认手机号码，以便发培训短信!");
			 spn[i].focus();
	 		 return false;
	      }else if(spn[i].value.length != 11){		//shazi
	    	 alert("手机号码长度应为11位,请验证!");
			 spn[i].focus();
	 		 return false;
	      }else{
				temp = temp+","+spn[i].value;
	      }
	      
	      if(sdLeval[i].value==""){
		      	 alert("职务不能为空!");
				 sdLeval[i].focus();
		 		 return false;
	      }else{
	      	 	leval2 = leval2+","+sdLeval[i].value;
	      }
    	}
	}
    document.getElementById("sdleval2").value = leval2.substring(1,leval2.length);
    document.getElementById("hsdphone").value = temp.substring(1,temp.length);
    return true;
}

function saveProcedure(){

	//限制主任会计师最多报2人
	var trainName = "${trainingMap.traintype}";
  	if(trainName=='主任会计师班' && !checkCount()){
   		return;
   	}
	
	var lan = document.getElementById("traintype").value;
	var oChooses = document.getElementsByName("t_name1");
	var isshareholder = document.getElementsByName("isshareholder"); 
	
	
	if(lan == "主任会计师班") {
	    for(i = 0; i < oChooses.length; i++){
	    	if(oChooses[i].checked == true ){
			      if(isshareholder[i].value != "是"){
						alert("本培训班是主任会计师班，用户不是主任会计师,不能报名!!");
						return;
			      }
		    }	
	    }
	    saveresult();
	} else {
		saveresult();
	}
	
}



function saveresult(){	

	if(f_sysphone()){                        // 处理系统电话号码

		if(f_sdphone()){        // 处理手动电话号码 

			// 系统电话号码隐藏域对象
			var hsp = document.getElementById("hsysphone").value;

			// 手动电话号码隐藏域对象
			var sdp = document.getElementById("hsdphone").value;
			if(hsp=="" || hsp == null){
				document.getElementById("phones").value=sdp;
			}else{
				document.getElementById("phones").value=hsp+","+sdp;
			}
			
			// 操作 系统人员的 table
			checkone();
			
			// 得到 系统人员
			var tname1 = document.getElementById("tname1");
		
			//var tname2 = document.getElementById("tname2");
			//tname2.value = get(tname2.value);
		
			// 得到手动添加的人员
			var temp = "";
			var xm = document.getElementsByName("xm");
			for(var i=0;i<xm.length;i++){
				if(xm[i].value!=""){
					temp = temp + xm[i].value+",";
				}
			}
			var sdLevalTemp = "";
			var sdLeval = document.getElementsByName("sdLeval");
			for(var i=0;i<sdLeval.length;i++){
				if(sdLeval[i].value!=""){
					sdLevalTemp = sdLevalTemp + sdLeval[i].value+",";
				}else{
					sdLevalTemp = sdLevalTemp + "无,";
				}
			}
			var leval2 = document.getElementById("leval2").value;
			if(leval2!="" &&leval2 != null){
				sdLevalTemp = document.getElementById("leval2").value +","+sdLevalTemp;
			}
			
			var tname = "";
			if(tname1.value==""){
				tname = temp;
			}else{
				tname = tname1.value + "," + temp;
			} 
			
			document.getElementById("tname").value = tname.substring(0,tname.length-1);
			document.getElementById("leval2").value = sdLevalTemp.substring(0,sdLevalTemp.length-1);
			// 事务所用户添加非执业会员
			document.getElementById("companyToMicfoNo").value = temp.substring(0,temp.length-1);

			
			
			
			// 报名
			save1(); 
			// hiddenProDiv();
		}
	}
	
}
	
	
	
	

	
/*	
function saveProcedure(){	

	if(f_sysphone()){                        // 处理系统电话号码

		if(f_sdphone()){        // 处理手动电话号码 

			// 系统电话号码隐藏域对象
			var hsp = document.getElementById("hsysphone").value;

			// 手动电话号码隐藏域对象
			var sdp = document.getElementById("hsdphone").value;
			if(hsp=="" || hsp == null){
				document.getElementById("phones").value=sdp;
			}else{
				document.getElementById("phones").value=hsp+","+sdp;
			}
			
			// 操作 系统人员的 table
			checkone();
			
			// 得到 系统人员
			var tname1 = document.getElementById("tname1");
		
			//var tname2 = document.getElementById("tname2");
			//tname2.value = get(tname2.value);
		
			// 得到手动添加的人员
			var temp = "";
			var xm = document.getElementsByName("xm");
			for(var i=0;i<xm.length;i++){
				if(xm[i].value!=""){
					temp = temp + xm[i].value+",";
				}
			}
			var sdLevalTemp = "";
			var sdLeval = document.getElementsByName("sdLeval");
			for(var i=0;i<sdLeval.length;i++){
				if(sdLeval[i].value!=""){
					sdLevalTemp = sdLevalTemp + sdLeval[i].value+",";
				}else{
					sdLevalTemp = sdLevalTemp + "无,";
				}
			}
			var leval2 = document.getElementById("leval2").value;
			if(leval2!="" &&leval2 != null){
				sdLevalTemp = document.getElementById("leval2").value +","+sdLevalTemp;
			}
			
			var tname = "";
			if(tname1.value==""){
				tname = temp;
			}else{
				tname = tname1.value + "," + temp;
			} 
			
			document.getElementById("tname").value = tname.substring(0,tname.length-1);
			document.getElementById("leval2").value = sdLevalTemp.substring(0,sdLevalTemp.length-1);
			// 事务所用户添加非执业会员
			document.getElementById("companyToMicfoNo").value = temp.substring(0,temp.length-1);

			
			
			
			// 报名
			save1(); 
			// hiddenProDiv();
		}
	}
	
}
/*


/*		shazi
function checkuser(){
	var lan = document.getElementById("traintype").value;
    //alert(lan);
	
	var oChooses = document.getElementsByName("t_name1");
	var isshareholder = document.getElementsByName("isshareholder"); 
	
	
    for(i = 0; i < oChooses.length; i++){
    	if(oChooses[i].checked == true ){
	      if(lan == "主任会计师班" && isshareholder[i].value != "是"){
				alert("本培训班是主任会计师班，用户不是主任会计师,不能报名!!");
				return;
	      } 
	      }
    	}
}
*/



function checkall(oCbx){
	var cbxValue = oCbx.checked; 
	var oInput = document.getElementsByName("t_name1");
	for(var i = 0; i < oInput.length; i++){
		if(!oInput[i].disabled){
			oInput[i].checked = cbxValue;  
		}
	}
	//checkone();
}


function checkone(){
   var i = 0;
   var str = "";
   var iszs = "";
   var iszz = "";
   var iszz2 = "";
   var sfzz = document.getElementById("sfzz").value;   //该通知是否中转
   var sfzz2 = document.getElementById("sfzz2").value;
   
   // 系统人的 是否住宿 是否中转
   var isdormitoryCompanyInfo = document.getElementsByName("isdormitoryCompanyInfo");
   var istransitCompanyInfo = document.getElementsByName("istransitCompanyInfo");
   var istransitCompanyInfo2 = document.getElementsByName("istransitCompanyInfo2");
   // 手动添加人的  是否住宿  是否中转
   var zs1 = document.getElementsByName("zs1");
   var zz1 = document.getElementsByName("zz1");
   var zz2 = document.getElementsByName("zz2");
   // 名称
   var xm = document.getElementsByName("xm"); 
   var tzs = "";
   var tzz = ""; 
   var tzz2="";
   
   if(xm){
	   for(var j=0;j<xm.length;j++){
	   	   if(xm[j].value!=""){
	   	   		if(zs1[j]){
			   		if(zs1[j].value == "是"){
			   			tzs = tzs + "是,";
			   		}else{
			   			tzs = tzs + "否,";
			   		}
			   	}else{
	   				tzs = tzs + "无,";
			   	}
		   		
		   		if(sfzz=="是"){
		   			if(zz1[j]){
				         if(zz1[j].value == "是" ){
				         	 tzz = tzz + '是,';
				         }else{
				         	 tzz = tzz + '否,';
				         }
				     }else{
			         	 tzz = tzz + '无,';
				     }
		        }else{
		        	tzz = tzz + '否,';
		        }
		   		
		   		if(sfzz2=="是"){
		   			if(zz2[j]){
				         if(zz2[j].value == "是" ){
				         	 tzz2 = tzz2 + '是,';
				         }else{
				         	 tzz2 = tzz2 + '否,';
				         }
				     }else{
			         	 tzz2 = tzz2 + '无,';
				     }
		        }else{
		        	tzz2 = tzz2 + '否,';
		        }
			}
		} 
	}
	
	if(tzs.length>0){
		tzs = tzs.substring(0,(tzs.length - 1));
	}
	if(tzz.length>0){
		tzz = tzz.substring(0,(tzz.length - 1));
	}
	if(tzz2.length>0){
		tzz2 = tzz2.substring(0,(tzz2.length - 1));
	}
	
	// 记录手动是否住宿中转
    document.getElementById("sdsfzs").value=tzs; 
    document.getElementById("sdsfzz").value=tzz;
    document.getElementById("sdsfzz2").value=tzz2;
    
   var oChooses = document.getElementsByName("t_name1");
   var j = oChooses.length;
   for(i = 0; i < j; i++){
      if(oChooses[i].checked == true ){
         str = str + oChooses[i].value + ',';
         
         if(isdormitoryCompanyInfo[i]){
	         if(isdormitoryCompanyInfo[i].value == "是" ){
	         	iszs = iszs + '是,';
	         }else{
	         	iszs = iszs + '否,';
	         }
		 }else{
	     	iszs = iszs + '无,';
		 }
		 
         if(sfzz=="是"){
         	 if(istransitCompanyInfo[i]){
		         if(istransitCompanyInfo[i].value == "是" ){
		         	iszz = iszz + '是,';
		         }else{
		         	iszz = iszz + '否,';
		         }
		      }else{
	         	iszz = iszz + '无,';
		      }
	     }else{
	     	iszz = iszz + '否,';
	     }
         
         if(sfzz2=="是"){
         	 if(istransitCompanyInfo2[i]){
		         if(istransitCompanyInfo2[i].value == "是" ){
		         	iszz2 = iszz2 + '是,';
		         }else{
		         	iszz2 = iszz2 + '否,';
		         }
		      }else{
	         	iszz2 = iszz2 + '无,';
		      }
	     }else{
	     	iszz2 = iszz2 + '否,';
	     }
      }
	}
	if(str.length>0){
		str = str.substring(0,(str.length - 1));
	}
	if(iszs.length>0){
		iszs = iszs.substring(0,(iszs.length - 1));
	}
	if(iszz.length>0){
		iszz = iszz.substring(0,(iszz.length - 1));
	}
	if(iszz2.length>0){
		iszz2 = iszz2.substring(0,(iszz2.length - 1));
	}
	
	document.getElementById("tname1").value = str;
	// 记录系统是否住宿中转
	document.getElementById("iszs").value = iszs;
	document.getElementById("iszz").value = iszz;
	document.getElementById("iszz2").value = iszz2;
	
	if(iszz == "" || iszz == null){
		document.getElementById("syzz").value = tzz;
	}else{
		document.getElementById("syzz").value = iszz+","+tzz;
	}
	
	if(iszz2 == "" || iszz2 == null){
		document.getElementById("syzz2").value = tzz2;
	}else{
		document.getElementById("syzz2").value = iszz2+","+tzz2;
	}
	
	if(iszs == "" || iszs == null){
		document.getElementById("syzs").value = tzs;
	}else{
		document.getElementById("syzs").value = iszs+","+tzs;
	}
} 

// 隐藏执业会员的是否中转和是否住宿 的 div
function hiddenProDiv1() {
	divObj = document.getElementById("divProduce1");
	blockObj =  document.getElementById("divBlock1");
	divObj.style.display = "none";
	blockObj.style.display = "none";
}

// 执业会员的是否中转和是否住宿 的 div
function seeProDiv1() {
	divObj = document.getElementById("divProduce1");
	blockObj =  document.getElementById("divBlock1");
	divObj.style.display = "";
	blockObj.style.display = "";
}

// 设置执业会员 是否住宿的提示信息所在的 div
function setNotice1(p){
	if(p == "y"){
		document.getElementById("notice1").style.display = "";
		var dor = document.getElementById("isdormitory");
		dor.checked = true;
	}else{
		document.getElementById("notice1").style.display = "none";
		var dors = document.getElementById("isdormitorys");
		dors.checked = true;
	}
	
}

//设置执业会员 是否中转所在的 div
function setNoticeZZ(p){
	var t1=GetRadioValue("istransit1");
	var t2=GetRadioValue("istransit2");
	if(p == "y"){
		document.getElementById("notice2").style.display = "";
		var dor = document.getElementById("istransit");
		dor.checked = true;
	}else{
		if(t1=="否"&&t2=="否"){
			document.getElementById("notice2").style.display = "none";
		}
		var dors = document.getElementById("istransits");
		dors.checked = true;
	}
	
}
//通用获取Radio值
function GetRadioValue(RadioName){
    var obj;    
    obj=document.getElementsByName(RadioName);
    if(obj!=null){
        var i;
        for(i=0;i<obj.length;i++){
            if(obj[i].checked){
                return obj[i].value;            
            }
        }
    }
    return null;
}

function setNoticeZZ1(p){
	var t1=GetRadioValue("istransit1");
	var t2=GetRadioValue("istransit2");
	if(p == "y"){
		document.getElementById("notice2").style.display = "";
		var dor = document.getElementById("istransit2");
		dor.checked = true;
	}else{
		if(t1=="否"&&t2=="否"){
			document.getElementById("notice2").style.display = "none";
		}
		var dors = document.getElementById("istransits2");
		dors.checked = true;
	}
	
}

// 控制 是否住宿 radio
function setzs(p){
	if(p == "y"){
		var dor = document.getElementById("isdormitory1");
		document.getElementById("notice1").style.display = "";
		dor.checked = true;
	}else{
		var dors = document.getElementById("isdormitorys1");
		document.getElementById("notice1").style.display = "none";
		dors.checked = true;
	}
}

// 控制 是否中转 radio
function setzz(p){
	if(p == "y"){
		var dor = document.getElementById("istransit1");
		dor.checked = true;
	}else{
		var dors = document.getElementById("istransits1");
		dors.checked = true;
	}
	
}
function setzz1(p){
	if(p == "y"){
		var dor = document.getElementById("istransit2");
		dor.checked = true;
	}else{
		var dors = document.getElementById("istransits2");
		dors.checked = true;
	}
	
}

// 团体会员是否住宿的  div
function seeCompanyInfo(p){
	var ch = document.getElementsByName("isdormitoryCompanyInfo");
	var zss1 = document.getElementsByName("zs1");
	var c = document.getElementById("companyInfo");
	var j = 0;
	for(var i=0;i<ch.length;i++){
		if(ch[i].value=='是'){
			j=1;
			break;
		} 
	}
	
	for(var i=0;i<zss1.length;i++){
		if(zss1[i].value=='是'){
			j=1;
			break;
		} 
	}

	if(j==1){
		c.style.display="";
	}else{
		c.style.display="none";
	}
	 
}

function seeCompanyInfo2(p){
	var ch = document.getElementsByName("istransitCompanyInfo");
	var zss1 = document.getElementsByName("istransitCompanyInfo2");
	var zz2 = document.getElementsByName("zz2");
	var zz1 = document.getElementsByName("zz1");
	var c = document.getElementById("companyInfo2");
	var j = 0;
	for(var i=0;i<ch.length;i++){
		if(ch[i].value=='是'){
			j=1;
			break;
		} 
	}
	
	for(var i=0;i<zss1.length;i++){
		if(zss1[i].value=='是'){
			j=1;
			break;
		} 
	}
	for(var i=0;i<zz1.length;i++){
		if(zz1[i].value=='是'){
			j=1;
			break;
		} 
	}
	
	for(var i=0;i<zz2.length;i++){
		if(zz2[i].value=='是'){
			j=1;
			break;
		} 
	}

	if(j==1){
		c.style.display="";
	}else{
		c.style.display="none";
	}
	 
}


// 添加行  有中转
function addLine(){
	  $('#tb').append("<tr> <td align='center'><input class='wb' type='text' name='xm' id='xm' onblur='f_blur(this)'></td>"
			  
			  <c:if test="${trainingMap.isstay=='是'}">
			  +"<td align='center'><select id='zs1' name='zs1' onchange='seeCompanyInfo(this)'><option value='是'>是</option><option value='否' selected>否</option></select></td>"
			  </c:if>
			  <c:if test="${istransit=='是'}">
			  		+"<td align='center'><select id='zz1' name='zz1' onchange='seeCompanyInfo2(this)'><option value='是'>是</option><option value='否' selected>否</option></select></td>"
			  </c:if>

			  <c:if test="${istransit2=='是'}">
			  		+"<td align='center'><select id='zz2' name='zz2' onchange='seeCompanyInfo2(this)'><option value='是'>是</option><option value='否' selected>否</option></select></td>"
			  </c:if>
			  
				+"<td noWrap align='center'><input noWrap type='text' class='wb' id='sdPhoneId' name='sdPhoneName' onkeyup='f_keyup(this)' ></td>"
				+"<td noWrap align='center'><input noWrap type='text' class='wb' id='sdLeval' name='sdLeval' onfocus='onPopDivClick(this);'	onkeyup='onKeyUpEvent();'onclick='onPopDivClick(this);' norestorehint='true' autoid='33' hideresult='true'></td>"
				+"<td align='center'><a href='###' onclick='removeLine(this);'>【删除】</a></td></tr>");
	  
}



// 控制只能输入数字 
function f_keyup(t){
	t.value=t.value.replace(/[^\d\.\\-]/g,'');
}

// 删除行
function removeLine(obj){
	var $delLine = $(obj).parent("td").parent("tr"); 
	$delLine.remove(); 
}
	
// 手动添加  表格的第一列
function checkall1(oCbx){
	var cbxValue = oCbx.checked; 
	var oInput = document.getElementsByName("nm");
	for(var i = 0; i < oInput.length; i++){
		oInput[i].checked = cbxValue;  
	}
	//checkone();
}



 
// 判断手动添加的人员是否重复
function f_blur(p){
	if(p.value==""){
		return;
	}
	var temp = ","+ document.getElementById("temp").value + ",";
	if(temp.indexOf(","+p.value+",")==-1){
		temp += p.value + ","
		document.getElementById("temp").value = "";
	}else{
		alert("请不要添加重复人员!");
		p.value="";
	}
}


// 限定人数 
var count = "${trainingMap.quote}";
var trainingid = "${trainingMap.id}";

// 查看已报名人数 
function viewCount(){
	var oBao = new ActiveXObject("Microsoft.XMLHTTP");
	var url="${pageContext.request.contextPath}/common/training.do?method=viewCount&trainingid="+trainingid;
	oBao.open("POST",url,false);    // 注意第三个参数  为true 时要加多下面三句话  false 就不用
	oBao.send();
	var resText = oBao.responseText;    // 除本事务所外的已报名人数 
	if(resText*1>=count*1){
		alert("报名人数已满!");
		return false;
	}else{
		var tname = document.getElementById("tname").value;
		var tnames = tname.split(',');
		
		var valid = count*1-resText*1;    // 剩余 报名数
		if(tnames.length>valid){
			if(resText==0){
				alert("报名人数不能高于限定人数!");
			}else{
				alert("已报名"+resText*1+"个人,只能报"+valid+"个人了!");
			}
			return false;
		}else{
			return true;
		}

		//if(tnames.length>count*1){
			//alert("您当前选择的报名人数为："+tnames.length+"人,不能高于限定人数 "+count+"人!");
			//return false;
		//}else{
			//return true;
		//}

	}
}


//alert("${trainingMap.orderid}");

/*缴费*/
function pay() {
	// 缴费截止日期
	var endDate = "${trainingMap.expenseedate }";

	// 当前日期
	var date = new Date();
	var year = date.getYear();
	var month = date.getMonth()+1;
	var day = date.getDate();
	if(month*1<10){
		month = "0"+month;
	}	
	if(day*1<10){
		day = "0"+day;
	}
	var now = year+"-"+month+"-"+day;

	if(now>endDate){
		alert("缴费截止日期:'"+endDate+"'已过,不能缴费!");
		return;
	}
	
	window.location = "${pageContext.request.contextPath}/common/pay.do?method=payInfo&orderId=${trainingMap.orderid}";
}

//取消报名 
function f_cancle(){
	
}

 //查询方法
function f_query(){
	document.thisForm.action = "${pageContext.request.contextPath}/common/inspection.do?method=company1";
	document.thisForm.submit();
}
             
//检查主任会计师班报名数量，限制最多2人
function checkCount(){
	var obj = document.getElementsByName("t_name1");
	var sum = 0;
	for(i=0;i<obj.length;i++){
		if(obj[i].checked){
			sum+=1;
		}
		if(sum>2){		
			alert("主任会计师班报名人数最多2人！");
			return false;
		}
	}
	return true;
} 
</script>