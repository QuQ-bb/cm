<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 정보</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/admin/adminmain.jsp"></jsp:include>
<div class="memdetail" style ="width:1000px;">
	<table class="table" border="1">
		<tr>
				<th>회원 번호</th>
				<td>${memberVO.mem_num}</td>
		</tr>
		<tr>
				<th>회원 아이디</th>
				<td>${memberVO.mem_id}</td>
		</tr>
		<tr>
				<th>회원 이름</th>
				<td>${memberVO.mem_name}</td>
		</tr>
		<tr>
				<th>회원 이메일</th>
				<td>${memberVO.mem_email}</td>
		</tr>
		<tr>
				<th>회원 연락처</th>
				<td>${memberVO.mem_phone}</td>
		</tr>
		<tr>
				<th>회원 가입날짜</th>
				<td>${memberVO.mem_date}</td>
		</tr>
		<tr>
				<th>회원 등급</th>
				<td>${memberVO.mem_grade}</td>
		</tr>
		<tr>
				<th>회원 탈퇴여부</th>
				<td>${memberVO.mem_delyn}</td>
		</tr>
		
	</table>
	
</div>
</body>
</html>