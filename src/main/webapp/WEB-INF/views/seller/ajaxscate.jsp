<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<select id="scate_code" name="scate_code">
		<option value=-1>소분류 선택</option>
	<c:forEach var="scate" items="${scatelist}">
		<option value="${scate.scate_code}">${scate.scate_name}</option>
	</c:forEach>
		<option value=0>소분류 없음</option>
</select>