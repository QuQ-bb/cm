<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인 페이지</title>
<script>
	$(document).ready(function()){
		var mem_id = $("#mem_id").val();
		var mem_pass = ${"mem_pass"}.val();
		if(mem_id == ""){
			alert("아이디를 입력하세요");
			$("#mem_id").focus();
			return;
		}
		if(mem_pass == ""){
			alert("비밀번호를 입력하세요");
			$("#mem_pass").focus();
			return;
		}
		// 폼 내부 데이터 전송할 주소
		document.form1.action="${path}/admin/logincheck"
		// 제출
		document.form1.sumit();
	}
</script>
</head>
<body>

</body>
</html>