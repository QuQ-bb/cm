<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<table border="1">
			<tr>
				<td>옵션</td>
				<td>수량</td>
			</tr>
			<c:forEach var="optioncom" items="${optioncom}">
				<tr>
					<td>${optioncom}</td>
					<td><input type="text"></td>
				</tr>
			</c:forEach>
		</table>

	</div>

</body>
</html>