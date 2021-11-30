<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="layout/header.jsp" %>
	<div class="container" align="center">
		<h2 class="text-primary">검색결과</h2>
		
		
		<form action="list.do">
			<input type="hidden" name="pageNum" value="1"> 
			<select	name="search">
				<option value="subject"	<c:if test="${search=='subject'}">selected="selected" </c:if>>제목</option>
				<option value="content"	<c:if test="${search=='content'}">selected="selected" </c:if>>내용</option>
				<option value="writer"	<c:if test="${search=='writer'}">selected="selected" </c:if>>작성자</option>
				<option value="subcon"	<c:if test="${search=='subcon'}">selected="selected" </c:if>>제목+내용</option>
			</select> 
			<input type="text" name="keyword"> 
			<input type="submit" value="확인">
		</form>
		
		<ul class="pagination">
			<!-- 검색 했을 경우의 페이징 처리 -->
			<c:if test="${not empty keyword}">
				<c:if test="${pp.startPage > pp.pagePerBlk }">
					<li><a
						href="list.do?pageNum=${pp.startPage - 1}&search=${search}&keyword=${keyword}">이전</a></li>
				</c:if>
				<c:forEach var="i" begin="${pp.startPage}" end="${pp.endPage}">
					<li <c:if test="${pp.currentPage==i}">class="active"</c:if>><a
						href="list.do?pageNum=${i}&search=${search}&keyword=${keyword}">${i}</a></li>
				</c:forEach>
				<c:if test="${pp.endPage < pp.totalPage}">
					<li><a
						href="list.do?pageNum=${pp.endPage + 1}&search=${search}&keyword=${keyword}">다음</a></li>
				</c:if>
			</c:if>
			
			<!-- 전체 목록의 페이징 처리 -->
			<c:if test="${empty keyword}">
				<c:if test="${pp.startPage > pp.pagePerBlk }">
					<li><a href="list.do?pageNum=${pp.startPage - 1}">이전</a></li>
				</c:if>
				<c:forEach var="i" begin="${pp.startPage}" end="${pp.endPage}">
					<li <c:if test="${pp.currentPage==i}">class="active"</c:if>>
						<a href="list.do?pageNum=${i}">${i}</a></li>
				</c:forEach>
				<c:if test="${pp.endPage < pp.totalPage}">
					<li><a href="list.do?pageNum=${pp.endPage + 1}">다음</a></li>
				</c:if>
			</c:if>
		</ul>
		<div align="center">
			<a href="insertForm.do" class="btn btn-info">글 입력</a>
		</div>
	</div>
	<%@ include file="layout/footer.jsp" %>
</body>
</html> --%>