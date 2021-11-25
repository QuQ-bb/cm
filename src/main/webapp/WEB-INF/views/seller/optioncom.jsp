<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/resources/js/sellerjs/insertOption.js"></script>
</head>
<body>

	<div>
		<table border="1">
			<tr>
				<td>${option1name}
					<c:if test="${option2name != null}"> - ${option2name}
					</c:if>
				</td>
				<td>수량</td>
			</tr>
			<c:forEach var="optioncom" items="${optioncom}">
				<tr>
					<td><input type="text" id="optioncom" name="optioncom" value="${optioncom}" readonly></td>
					<td><input type="text" id="optioncount" name="optioncount"></td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="button" onclick="insertOpion()" value="확인"></td>
			</tr>
		</table>

	</div>

</body>
</html>