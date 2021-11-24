<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대분류 리스트</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/admin/adminmain.jsp"></jsp:include>
	<table border="1" width="1000" align="center">
    	<tr>
        	<td>카테고리 분류</td>
            <td>카테고리 이름</td>
        </tr>
        <c:forEach var="LcateVO" items="${lcatelist}">
        <tr>
    	<td><c:out value="${LcateVO.lcate_code}" /></td>
    	<td><c:out value="${LcateVO.lcate_name}" /></td>
    	</tr>
		</c:forEach>   
    </table>
</body>
</html>