<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/admin/adminmain.jsp"></jsp:include>
	<h2 align="center">회원 목록</h2>
	<table border="1" width="1000" align="center">
		<tr>
			<td>회원번호</td>
			<td>회원 아이디</td>
			<td>이름</td>
			<td>이메일</td>
			<td>연락처</td>
			<td>가입날짜</td>
			<td>등급</td>
			<td>탈퇴여부</td>
		</tr>
		<c:forEach var ="MemberVO" items="${memberlist}">
			<tr>
				<td><c:out value="${MemberVO.mem_num}"/></td>
				<td><c:out value="${MemberVO.mem_id}"/></td>
				<td><c:out value="${MemberVO.mem_name}"/></td>
				<td><c:out value="${MemberVO.mem_email}"/></td>
				<td><c:out value="${MemberVO.mem_phone}"/></td>
				<td><c:out value="${MemberVO.mem_date}"/></td>
				<td><c:out value="${MemberVO.mem_grade}"/></td>
				<td><c:out value="${MemberVO.mem_delyn}"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>