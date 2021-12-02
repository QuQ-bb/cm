<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	function mcate(mcate_code){
//		alert(lcate_code);
		
		$.post('scload', {'mcate_code':mcate_code}, function(data){
//			alert(data);
			console.log(data);
			$('#scate').html(data);
		});	
		
	}

</script>



<c:forEach var="mcate" items="${mcatelist}">	
	<a href="javascript:void(0)" onMouseOver="mcate(${mcate.mcate_code})">${mcate.mcate_name} <br></a>
</c:forEach>
	