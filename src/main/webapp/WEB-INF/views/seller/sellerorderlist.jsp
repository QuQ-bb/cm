<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

판매자 주문 리스트 <br>
${listcount }
<div>
	<table border="1">
		<tr style="text-align: center;">
			<th>주문번호</th>
			<th colspan="2">상품이름</th>
			<th>옵션</th>
			<th>수량</th>
			<th>주문자(이름)</th>
			<th>배송비</th>
			<th>총 결제금액</th>
			<th>상태</th>
			<th>배송</th>
		</tr>
		<!-- 화면 출력 번호  변수 정의 -->		
		<c:set var="num" value="${listcount-(page-1)*10}"/> 	
		
		<c:forEach var="order" items="${orderlist}">
			<tr>
				<td>
					<!-- 번호 출력 부분 -->	
 					<c:out value="${num}"/>			
					<c:set var="num" value="${num-1}"/>	 
				</td>
				<td style="border-right: none;">
					<img src="<%=request.getContextPath() %>/resources/image/thumbnailimage/${order.gds_thumbnail}" height="100" width="100" />
				</td>
				<td style="border-left: none;">
					<a href="sellerorderdetail?ord_num=${order.ord_num}&page=${page}">${order.gds_name}<br><br></a>
					<div style="text-align: right"> <a href="goodsupdate?&gds_num=${order.ord_gdsnum}">상품 수정하기</a></div>
				</td>
				<td>
					<c:choose>
						<c:when test="${order.opt_2ndval != null}">
							${order.opt_1stname} : ${order.opt_1stval}	<br>
							${order.opt_2ndname} : ${order.opt_2ndval}
						</c:when>
						<c:when test="${order.opt_2ndval != null}">
							${order.opt_1stname} : ${order.opt_1stval}
						</c:when>
						<c:otherwise>
							-
						</c:otherwise>
					</c:choose>
				</td>
				<td>${order.ord_gdscount}</td>
				<td>${order.mem_id}</td>
				<td><fmt:formatNumber value="${order.ord_delfee}" pattern="#,###원" /></td>
				<td><fmt:formatNumber value="${order.ord_totalprice}" pattern="#,###원" /></td>
				<td>상태</td>
				<td>배송</td>
			</tr>
		</c:forEach>
		
	</table>

</div>
</body>
</html>