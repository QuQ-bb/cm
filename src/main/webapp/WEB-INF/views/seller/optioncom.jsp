<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function insertOpion(){
		 $("#gds_count").attr("disabled", false); //입력 가능 설정
		
		var size = $("input[id='optioncom']").length;
		var count = 0;
		
		for(i=0;i<size;i++){
			count += parseInt($("input[name='optioncount']").eq(i).val());
		}
		
		if(isNaN(count)){
			alert("수량을 제대로 입력해 주세요.");
		}else{
			 $('#gds_count').val(count);
			 $("#gds_count").attr("disabled", true); //입력 불가 설정
		}
	}
</script>
</head>
<body>

	<div>
		<table border="1">
			<tr>
				<td>옵션</td>
				<td>수량</td>
			</tr>
			<c:forEach var="optioncom" items="${optioncom}">
				<tr>
					<td><input type="text" id="optioncom" name="optioncom" value="${optioncom}" readonly></td>
					<td><input type="text" id="optioncount" name="optioncount"></td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="button" onclick="insertOpion()" value="확인"></td>
			</tr>
		</table>

	</div>

</body>
</html>