<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>





<c:forEach var="scate" items="${scatelist}">	
	<a href=#>${scate.scate_name}<br></a>
</c:forEach>
	