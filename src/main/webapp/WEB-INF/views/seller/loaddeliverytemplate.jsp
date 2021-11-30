<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div id="deltemdiv" name="deltemdiv">
	<c:choose>
	<c:when test="${gettemplate != null}">
		<table>
			<tr>
				<th>배송 탬플릿 명</th>
				<td><input type="text" id="deltem_name" name="deltem_name" value="${gettemplate.deltem_name}" disabled="disabled"></td>
			</tr>
			<tr>
				<th>판매자 번호</th>
				<td><input type="text" id="sel_num" name="sel_num" value="${gettemplate.sel_num}" disabled="disabled"></td>
			</tr>

			<tr>
				<th>배송사 선택</th>
				<td>
					<input type="hidden" id="del_code" name="del_code" value="${gettemplate.del_code}" disabled="disabled">
					<input type="text" id="del_name" name="del_name" value="${gettemplate.del_name}" disabled="disabled">
				</td>
			</tr>
			<tr>
				<th>배송비</th>
				<td><input type="text" name="deltem_delfee" id="deltem_delfee" value="${gettemplate.deltem_delfee}" disabled="disabled"></td>
			</tr>
			<tr>
				<th>무료배송 기준금액</th>
				<td><input type="text" name="deltem_freedel" id="deltem_freedel" value="${gettemplate.deltem_freedel}" disabled="disabled"></td>
			</tr>
			<tr>
				<th>반품 배송비</th>
				<td><input type="text" name="deltem_redelfee" id="deltem_redelfee" value="${gettemplate.deltem_redelfee}" disabled="disabled"></td>
			</tr>
			<tr>
				<th>교환 배송비</th>
				<td><input type="text" name="deltem_exdelfee" id="deltem_exdelfee" value="${gettemplate.deltem_exdelfee}" disabled="disabled"></td>
			</tr>
			<tr>
				<th>반품/교환 배송지 <br>우편번호</th>
				<td><input name="deltem_repost" id="deltem_repost" size="5"
					class="input_box" readonly onclick="post_search()"  value="${gettemplate.deltem_repost}" disabled="disabled"/> 
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input name="deltem_readd1" id="deltem_readd1" size="50"
					class="input_box" readonly onclick="post_search()" value="${gettemplate.deltem_readd1}" disabled="disabled"/></td>
			</tr>

			<tr>
				<th>나머지 주소</th>
				<td><input name="deltem_readd2" id="deltem_readd2" size="37"
					class="input_box" value="${gettemplate.deltem_readd2}" disabled="disabled"/></td>
			</tr>
		</table>
		</c:when>
		<c:otherwise>
			<table>
			<tr>
				<th>배송 탬플릿 명</th>
				<td><input type="text" id="deltem_name" name="deltem_name" ></td>
			</tr>
			<tr>
				<th>판매자 번호</th>
				<td><input type="text" id="sel_num" name="sel_num"></td>
			</tr>

			<tr>
				<th>배송사 선택</th>
				<td><select id="del_info" name="del_info" onchange="delivery_list()">
						<option value="">배송사를 선택해 주세요.</option>
						<c:forEach var="gdcl" items="${getdeliverycatelist}">
							<option value="${gdcl.del_code},${gdcl.del_name}">${gdcl.del_name}</option>
						</c:forEach>
				</select>
			</tr>
			<tr>
				<th>배송비</th>
				<td><input type="text" name="deltem_delfee" id="deltem_delfee"></td>
			</tr>
			<tr>
				<th>무료배송 기준금액</th>
				<td><input type="text" name="deltem_freedel" id="deltem_freedel"></td>
			</tr>
			<tr>
				<th>반품 배송비</th>
				<td><input type="text" name="deltem_redelfee" id="deltem_redelfee"></td>
			</tr>
			<tr>
				<th>교환 배송비</th>
				<td><input type="text" name="deltem_exdelfee" id="deltem_exdelfee"></td>
			</tr>
			<tr>
				<th>반품/교환 배송지 <br>우편번호</th>
				<td><input name="deltem_repost" id="deltem_repost" size="5"
					class="input_box" readonly onclick="post_search()"/> 
					<input type="button" value="우편번호 찾기" class="input_button" onclick="openDaumPostcode()" />
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input name="deltem_readd1" id="deltem_readd1" size="50"
					class="input_box" readonly onclick="post_search()"/></td>
			</tr>

			<tr>
				<th>나머지 주소</th>
				<td><input name="deltem_readd2" id="deltem_readd2" size="37"
					class="input_box"/></td>
			</tr>
		</table>
		</c:otherwise>
		</c:choose>
	</div>
	
</body>