<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>판매자 메인페이지</title>
<style>

.main {
	margin-left: 300px; /* Same width as the sidebar + left position in px */
	margin-right: 300px; 
	font-size: 18px; /* Increased text to enable scrolling */
	padding: 0px 10px;
	display: grid;
	grid-template-rows: repeat(2, 300px);
	grid-template-columns: repeat(2, 1fr);
	row-gap: 10px; /* row의 간격을 10px로 */
	column-gap: 20px; /* column의 간격을 20px로 */
}

.mainOrderTable th{
	text-align : center;
	background : #e9ecef;
}

.mainOrdername{
	text-overflow:ellipsis; 
	overflow:hidden; 
	white-space:nowrap;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


</head>


<body>
<%@ include file="../layout/sellerSidebar.jsp" %>

<div class="main">
	<div class="lefttop">
		<table border="1" style="table-layout:fixed" width="600" class="mainOrderTable">
			<thead><h2>최근 주문 현황</h2></thead>
			<tr>
				<th width="50%">상품명</th>
				<th width="10%">수량</th>
				<th width="20%">금액</th>
				<th width="20%">날짜</th>
			</tr>
			<c:forEach var="mainOrderList" items="${mainOrderList}">
			<tr>
				<td class="mainOrdername" title="${mainOrderList.gds_name }"><nobr>${mainOrderList.gds_name }</nobr></td>
				<td>${mainOrderList.ord_gdscount }</td>
				<td>${mainOrderList.ord_totalprice }</td>
				<td></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<div class="righttop">
		<table border="1" style="table-layout:fixed" width="600" class="mainOrderTable">
			<thead><h2>판매자 공지</h2></thead>
			<tr>
				<th width="50%">상품명</th>
				<th width="10%">수량</th>
				<th width="20%">금액</th>
				<th width="20%">날짜</th>
			</tr>
			<c:forEach var="mainOrderList" items="${mainOrderList}">
			<tr>
				<td class="mainOrdername" title="${mainOrderList.gds_name }"><nobr>${mainOrderList.gds_name }</nobr></td>
				<td>${mainOrderList.ord_gdscount }</td>
				<td>${mainOrderList.ord_totalprice }</td>
				<td></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	
	<div class="lefttop">
		<table border="1" style="table-layout:fixed" width="600" class="mainOrderTable">
		<thead><h2>최근 문의</h2></thead>
			<tr>
				<th width="50%">상품명</th>
				<th width="10%">수량</th>
				<th width="20%">금액</th>
				<th width="20%">날짜</th>
			</tr>
			<c:forEach var="mainOrderList" items="${mainOrderList}">
			<tr>
				<td class="mainOrdername" title="${mainOrderList.gds_name }"><nobr>${mainOrderList.gds_name }</nobr></td>
				<td>${mainOrderList.ord_gdscount }</td>
				<td>${mainOrderList.ord_totalprice }</td>
				<td></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	
	<div class="lefttop">
		<table border="1" style="table-layout:fixed" width="600" class="mainOrderTable">
		<thead><h2>최근 후기</h2></thead>
			<tr>
				<th width="50%">상품명</th>
				<th width="10%">수량</th>
				<th width="20%">금액</th>
				<th width="20%">날짜</th>
			</tr>
			<c:forEach var="mainOrderList" items="${mainOrderList}">
			<tr>
				<td class="mainOrdername" title="${mainOrderList.gds_name }"><nobr>${mainOrderList.gds_name }</nobr></td>
				<td>${mainOrderList.ord_gdscount }</td>
				<td>${mainOrderList.ord_totalprice }</td>
				<td></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</div>  

</body>
</html>
