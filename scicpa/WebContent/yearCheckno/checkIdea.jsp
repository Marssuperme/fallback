<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<input type="hidden" value="${member.uuid }" name="uuid" />
<input type="hidden" name="norefress" id="norefress" value="${member.norefress }" />

<table width="100%;" border="0" cellpadding="0" cellspacing="0" class="data_tb" align="center">
	<tr>
		<td class="data_tb_alignright" class="data_tb_content"  >非执业会员意见：</td>
		<td colspan='3' class="data_tb_content"><c:choose>
				<c:when test="${usertype=='uncpa'&&member.edit=='edit' }">
					<select name="selfaudit" id="selfaudit">
						<option value="申请通过" ${member.selfaudit=='申请通过'?'selected':'' }>申请通过</option>
						<option value="申请暂缓" ${member.selfaudit=='申请暂缓'?'selected':'' }>申请暂缓</option>
						<option value="不通过" ${member.selfaudit=='不通过'?'selected':'' }>不通过</option>
						<option value="退会" ${member.selfaudit=='退会'?'selected':'' }>退会</option>
					</select>
				</c:when>
				<c:otherwise>
					<input name="selfaudit" id="selfaudit" value="${member.selfaudit}" type="text" class="checkIdea" readonly="readonly" />
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<td class="data_tb_alignright">非执业会员填写原因：</td>
		<td colspan='3' class="data_tb_content"><textarea rows="3" cols="80" name="selfidea"  id="selfidea">${member.selfidea}</textarea></td>
	</tr>
</table >

<!-- </form> -->
