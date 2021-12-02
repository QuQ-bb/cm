<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자신청 목록</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/admin/adminmain.jsp"></jsp:include>
	<h2 align="center">판매자 신청 목록</h2>
	<table border="1" width="1500" align="center">
		<tr>
			<td>판매자 번호</td>
			<td>회원 번호</td>
			<td>사업자번호</td>
			<td>상호명</td>
			<td>대표명</td>
			<td>통신판매업번호</td>
			<td>사업장 우편번호</td>
			<td>사업장 소재지</td>
			<td>사업장 연락처</td>
			<td>정산 은행</td>
			<td>정산 예금주</td>
			<td>정산 계좌</td>
			<td>정지여부</td>
			<td>filename?</td>
		</tr>
		<c:forEach var = "SellerVO" items="${chglist}">
			<tr>
			<td><c:out value="${SellerVO.sel_num}"/></td>
			<td><c:out value="${SellerVO.mem_num}"/></td>
			<td><c:out value="${SellerVO.sel_bnum}"/></td>
			<td><a href="chgdetail sel_name=${SellerVO.sel_name}&page=${page}&state=chgdetail">
				<c:out value="${SellerVO.sel_name}"/></a></td>
			<td><c:out value="${SellerVO.sel_ceo}"/></td>
			<td><c:out value="${SellerVO.sel_mobnum}"/></td>
			<td><c:out value="${SellerVO.sel_post}"/></td>
			<td><c:out value="${SellerVO.sel_add}"/></td>
			<td><c:out value="${SellerVO.sel_tel}"/></td>
			<td><c:out value="${SellerVO.sel_bank}"/></td>
			<td><c:out value="${SellerVO.sel_accholder}"/></td>
			<td><c:out value="${SellerVO.sel_acc}"/></td>
			<td><c:out value="${SellerVO.sel_yn}"/></td>
			<td><c:out value="${SellerVO.seling_filename}"/></td>
			</tr>										
		</c:forEach>
	</table>
</body>
</html>