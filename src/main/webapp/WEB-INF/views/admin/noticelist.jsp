<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 목록</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/admin/adminmain.jsp"></jsp:include>
		<h1>공지 목록</h1>
	<table border ="1" width="1000" align="center">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>구분</th>
		</tr>

		<%-- 반복문 사용하여 데이터 출력 --%>
		<c:forEach var="NoticeVO" items="${noticelist}">
			<tr>
				<td><c:out value="${NoticeVO.ntc_num}"/></td>
				<td><a href="ntcdetail?ntc_title=${NoticeVO.ntc_title}&state=ntcdetail">
				<c:out value="${NoticeVO.ntc_title}"/></a></td>
				<td><c:out value="${NoticeVO.ntc_sort}"/></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
				<button type="button" onClick="location.href='/noticeform'">글쓰기</button>
			</td>
		</tr>
	</table>
</body>
</html>