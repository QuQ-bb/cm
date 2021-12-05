<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/admin/adminmain.jsp"></jsp:include>
<div class="seldetail" style ="width:1000px; margin-left:10px; margin-top: 10px;">
	<table class="table" border="1">
		<tr>
				<th>판매자 번호</th>
				<td>${sellerVO.sel_num}</td>
		</tr>
		<tr>
				<th>회원 번호</th>
				<td>${sellerVO.mem_num}</td>
		</tr>
		<tr>
				<th>사업자번호</th>
				<td>${sellerVO.sel_bnum}</td>
		</tr>
		<tr>
				<th>상호명</th>
				<td>${sellerVO.sel_name}</td>
		</tr>
		<tr>
				<th>대표명</th>
				<td>${sellerVO.sel_ceo}</td>
		</tr>
		<tr>
				<th>통신판매업번호</th>
				<td>${sellerVO.sel_mobnum}</td>
		</tr>
		<tr>
				<th>사업장 우편번호</th>
				<td>${sellerVO.sel_post}</td>
		</tr>
		<tr>
				<th>사업장 소재지</th>
				<td>${sellerVO.sel_add}</td>
		</tr>
		<tr>
				<th>사업장 연락처</th>
				<td>${sellerVO.sel_tel}</td>
		</tr>
		<tr>
				<th>정산 은행</th>
				<td>${sellerVO.sel_bank}</td>
		</tr>
		<tr>
				<th>정산 예금주</th>
				<td>${sellerVO.sel_accholder}</td>
		</tr>
		<tr>
				<th>정산 계좌</th>
				<td>${sellerVO.sel_acc}</td>
		</tr>
		<tr>
				<th>정지여부</th>
				<td>${sellerVO.sel_yn}</td>
		</tr>
		<tr>
				<th>filename</th>
				
				<td><img src="<%=request.getContextPath()%>/resources/images/sellerimage${seling_filename1}" height="100" width="100"/></td>
		</tr>
		
	</table>
</div>
</body>
</html>