<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<select id="mcate_code" name="mcate_code" onchange="scateload()">
		<option value=0>중분류 선택</option>
	<c:forEach var="mcate" items="${mcatelist}">
		<option value="${mcate.mcate_code}">${mcate.mcate_name}</option>
	</c:forEach>
</select>