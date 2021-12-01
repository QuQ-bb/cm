<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function del(seq) {
		var chk = confirm("정말 삭제하시겠습니까?");
		if (chk) {
			location.href='deltemdelete?deltem_num='+seq;
		}
	}	
</script>
</head>
<body>
<table border="1">
	<tr align="center">
		<th>번호</th>
		<th>배송 탬플릿 명</th>
		<th>배송사 </th>
		<th>배송비</th>	
		<th>무료배송 기준금액	</th>
		<th>반품 배송비</th>
		<th>교환 배송비</th>
		<th>반품/교환 배송지 우편번호</th>
		<th>주소</th>
		<th>나머지 주소</th>
		<th>액션</th>
	</tr>
	
		<c:set var="num" value="${listcount}"/> 	 	
		<c:forEach var="deltemlist" items="${deltemlist}">
			<tr>
				<!-- 번호 출력 부분 -->	
				<td><c:out value="${num}"/>	</td>
				<c:set var="num" value="${num-1}"/>	 
				<td>${deltemlist.deltem_name }</td>
				<td>${deltemlist.del_name }</td>
				<td><fmt:formatNumber value="${deltemlist.deltem_delfee }" pattern="#,###원" /></td>
				<td><fmt:formatNumber value="${deltemlist.deltem_redelfee }" pattern="#,###원" /></td>
				<td><fmt:formatNumber value="${deltemlist.deltem_exdelfee }" pattern="#,###원" /></td>
				<td><fmt:formatNumber value="${deltemlist.deltem_freedel }" pattern="#,###원" /></td>
				<td>${deltemlist.deltem_repost }</td>
				<td>${deltemlist.deltem_readd1 }</td>
				<td>${deltemlist.deltem_readd2 }</td>
				<td><input type="button" value="수정" onclick="location='deltemeditform?deltem_num=${deltemlist.deltem_num}'">
				    <input type="button" value="삭제" onclick="del(${deltemlist.deltem_num})"></td>
			</tr>
		</c:forEach>
	
</table>
</body>
</html>