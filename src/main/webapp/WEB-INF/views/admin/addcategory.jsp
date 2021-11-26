<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 등록</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/admin/adminmain.jsp"></jsp:include>
<%-- <select id="selectbox">
<c:forEach var="CategoryVO" items="${catelist}">
	<option value="${CategoryVO.cate_code}">${CategoryVO.cate_name}</option>
</c:forEach>
</select> --%>
<form>
	<input type="text" name="cate_code" placeholder="카테고리코드">
</form>
<script>
	
</script>
</body>
</html>