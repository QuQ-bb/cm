<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공 지 사 항</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/admin/adminmain.jsp"></jsp:include>
	<div class="seldetail" style ="width:1000px; margin-left:10px; margin-top: 10px;">
		<table class="table" border="1">
			<tr>
				<th>공지 번호</th>
				<td>${noticeVO.ntc_num}</td>
			</tr>
			<tr>
				<th>공지 분류</th>
				<td>${noticeVO.ntc_sort}</td>
			</tr>
			<tr>
				<th>공지 제목</th>
				<td>${noticeVO.ntc_title}</td>
			</tr>		
			<tr>
				<th>공지 등록일</th>
				<td>${noticeVO.ntc_date}</td>
			</tr>
			<tr>
				<th>공지 노출여부</th>
				<td>${noticeVO.ntc_delyn}</td>
			</tr>
			<tr>
				<th>등급</th>
				<td>${noticeVO.mem_grade}</td>
			</tr>
	</table>
	<div class="form-group">
				<label for = "seldetail">공지 내용</label>
				<textarea name="content" rows="5" cols="20" class="form-control" readonly>${noticeVO.ntc_content}</textarea>
			</div>
</div>		
</body>
</html>