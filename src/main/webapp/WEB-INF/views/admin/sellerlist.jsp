<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자 목록</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/admin/adminmain.jsp"></jsp:include>
	<h2 align="center">판매자 목록</h2>
	<table border="1" width="1500" align="center">
		<tr>
			<td>상호명</td>
			<td>판매자 번호</td>
			<td>회원 번호</td>
			<td>대표명</td>
			<td>정지여부</td>
		</tr>
		<c:forEach var = "SellerVO" items="${sellist}">
			<tr>
			<td><a href="seldetail?sel_name=${SellerVO.sel_name}&state=seldetail">
				<c:out value="${SellerVO.sel_name}"/></a></td>
			<td><c:out value="${SellerVO.sel_num}"/></td>
			<td><c:out value="${SellerVO.mem_num}"/></td>
			<td><c:out value="${SellerVO.sel_ceo}"/></td>
			<td><c:out value="${SellerVO.sel_yn}"/></td>
			</tr>										
		</c:forEach>
	</table>
</body>
</html>