<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
//우편번호, 주소 Daum API
function openDaumPostcode() {
	new daum.Postcode({
		oncomplete : function(data) {				
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
			// 우편번호와 주소 정보를 해당 필드에 넣고, 커서를 상세주소 필드로 이동한다.
			document.getElementById('deltem_repost').value = data.zonecode;
			document.getElementById('deltem_readd1').value = data.address;				
		}
	}).open();
}
</script>
</head>
<body>
	<br>
	<form method="post" action="<%=request.getContextPath()%>/deliverytemplateupload">
		<table>
			<tr>
				<th>배송 탬플릿 명</th>
				<td><input type="text" id="deltem_name" name="deltem_name"></td>
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
							<%-- <option value="${gdcl.del_code}">${gdcl.del_name}</option> --%>
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
				<th>우편번호</th>
				<td><input name="deltem_repost" id="deltem_repost" size="5"
					class="input_box" readonly onclick="post_search()" /> 
					<input type="button" value="우편번호 찾기" class="input_button" onclick="openDaumPostcode()" />
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input name="deltem_readd1" id="deltem_readd1" size="50"
					class="input_box" readonly onclick="post_search()" /></td>
			</tr>

			<tr>
				<th>나머지 주소</th>
				<td><input name="deltem_readd2" id="deltem_readd2" size="37"
					class="input_box" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" id="savebutton" name="savebutton" value="템플릿 저장"></td>
			</tr>
		</table>
	</form>
</body>
</html>