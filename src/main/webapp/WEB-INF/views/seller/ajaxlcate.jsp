<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	function lcate(lcate_code){
//		alert(lcate_code);
		
		$.post('mcload', {'lcate_code':lcate_code}, function(data){
//			alert(data);
			console.log(data);
			$('#mcate').html(data);
		});	
		
	}

</script>


<c:forEach var="lcate" items="${lcatelist}">
	<a href="javascript:void(0)" onMouseOver="lcate(${lcate.lcate_code})">${lcate.lcate_name}</a>
</c:forEach>
