<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<title>소분류 등록</title>
</head>
<body>
		<div>
			<h2>소분류 등록</h2>
	<form class="center" id="addscate" method="post" action="/insertscate">
				<table>
					<tr>
						<th>분류코드</th>
						<td><input type="text" id="scatecode" name="scatecode" value=""></td>
					</tr>
					
					<tr>
						<th>분류명</th>
						<td><input type="text" id="scatename" name="scatename" value=""></td>
					</tr>
					<tr>
						<th>상위대분류</th>
						<td><input type="text" id="lcatecode" name="lcatecode" value=""></td>
					</tr>
					<tr>
						<th>상위중분류</th>
						<td><input type="text" id="mcatecode" name="mcatecode" value=""></td>
					</tr>
				</table>
	</form>
				<input type="button" value="등록" class="input_button" onclick="regist();"/>
				<input type="reset" value="리셋" class="input_button" onclick="focusing();"/>
		</div>
<script>
	function focusing(){
		$("#scatecode").focus();
	}
	
	function regist(){
		$("#addscate").submit();
	}
</script>
</body>
</html>