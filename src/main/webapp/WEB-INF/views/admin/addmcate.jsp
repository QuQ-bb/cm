<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중분류 등록</title>
</head>
<body>
	<form class="center" id="addmcate" method="post">
		<div>
			<h2>중분류 등록</h2>
				<table>
					<tr>
						<th>분류코드</th>
						<td><input type="text" id="mcatecode" name="mcatecode" value="${mcate_code}"></td>
					</tr>
					
					<tr>
						<th>분류명</th>
						<td><input type="text" id="mcatename" name="mcatename" value="${mcate_name}"></td>
					</tr>
					<tr>
						<th>상위분류</th>
						<td><input type="text" id="lcatecode" name="lacatecode" value="${lcate_code}"></td>
					</tr>
				</table>
				<input type="submit" value="등록" class="input_button">
				<input type="reset" value="취소" class="input_button" 
				 onclick="$('#mcate_code').focus();">
		</div>
	
	</form>
</body>
</html>