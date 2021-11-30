<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="<%=request.getContextPath() %>/js/notice.js"></script>
<title>공지 등록</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/admin/adminmain.jsp"></jsp:include>
	<h2 align="center">공지사항 등록</h2>
	<form action="/insertnotice" method="post">
	
	</form>
</body>
</html>