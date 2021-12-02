<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>관리자 로그인 페이지</title>
<script type="text/javascript">
function check(){
	if($.trim($("#mem_id").val()) == ""){
		alert("아이디를 입력해주세요.");
		$("#mem_id").val("").focus();
		return false;
	}
	if($.trim($("#mem_pass").val()) == ""){
		alert("비밀번호를 입력해주세요.");
		$("#mem_pass").val("").focus();
		return false;
	}
	if($.trim($("#mem_grade").val()) != "99"){
		alert("관리자계정이 아닙니다");
		$("#mem_id").val("").focus();
		return false;
	}
}
	
</script>
</head>
<body>
	<form action="/adminlogin" method="post" onsubmit="retrun check">
		<div class="border">
			<h1>로그인</h1>
				<input type="text" name="mem_id" id="mem_id"><br>
				<input type="password" name="mem_pass" id="mem_pass"><br>
				<input type="submit" value="관리자 로그인">
		</div>
	</form>
</body>
</html>