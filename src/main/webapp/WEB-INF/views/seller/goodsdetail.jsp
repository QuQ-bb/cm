<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세페이지</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>

	<div id="goodsdetail">
			<table border="1" width="1200">
				<tr>
					<th>카테고리</th>
					<td>
						${goods.lcate_code}
						${goods.mcate_code}
						${goods.scate_code}
					</td>
				</tr>
				<tr>
					<th>상품 판매자</th>
					<td>${goods.gds_seller}</td>
				</tr>
				<tr>
					<th>상품명</th>
					<td>${goods.gds_name}</td>
				</tr>
				<tr>
					<th>썸네일</th>
					<td><img src="<%=request.getContextPath() %>/resources/images/thumbnailimage/${goods.gds_thumbnail}" height="200" width="200" /></td>
				</tr>
				<tr>
					<th>단위 가격</th>
					<td>${goods.gds_price}</td>
				</tr>
				<tr>
					<th>상세설명</th>
					<td width=900 id="gds_detail" name="gds_detail">${goods.gds_detail}</td>
				</tr>
				<tr>
					<th>옵션</th>
					<td>${goods.gds_option}</td>
				</tr>
				<tr>
					<th>배송 정보</th>
					<td>${goods.deltem_num}</td>
				</tr>
				<tr>
					<th>재고</th>
					<td>${goods.gds_count}</td>
				</tr>
				<tr>
					<th>교환 환불 기준</th>
					<td>${goods.gds_ears}</td>
				</tr>
			</table>

	</div>


</body>
</html>