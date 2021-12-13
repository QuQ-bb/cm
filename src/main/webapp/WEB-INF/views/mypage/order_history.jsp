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

<h2>구매내역</h2> <br>
${listcount }
<div>
	<table border="1">
		<tr style="text-align: center;">
			<th>주문번호</th>
			<th>썸네일, 상품이름</th>
			<th>옵션</th>
			<th>수량</th>
			<th>배송비</th>
			<th>요청사항</th>
			<th>총 결제금액</th>
			<th>배송상태</th>
			<th>확인</th>
		</tr>
		<!-- 화면 출력 번호  변수 정의 -->		
		<c:set var="num" value="${listcount-(page-1)*10}"/> 	
		
		<c:forEach var="his" items="${historylist}">
			<tr>
				<td>
					<!-- 번호출력부분 -->
					<c:out value="${num}"/>
					<c:set var="num" value="${num-1}"/>
				</td>
				<td>
					<img src="<%=request.getContextPath() %>/resources/images/thumbnailimage/${his.gds_thumbnail}" height="100" width="100" />
						<a href="history_detail?ol_num=${his.ol_num}&page=${page}">${his.gds_name}<br></a>
				</td>
				<td>
					<c:choose>
	                  <c:when test="${his.opt_2ndval != null}">
	                     ${his.opt_1stname} : ${his.opt_1stval}   <br>
	                     ${his.opt_2ndname} : ${his.opt_2ndval}
	                  </c:when>
	                  <c:when test="${his.opt_1stval != null}">
	                     ${his.opt_1stname} : ${his.opt_1stval}
	                  </c:when>
	                  <c:otherwise>
	                     -
	                  </c:otherwise>
	               </c:choose>
				</td>
				<td>${his.ol_count}</td>
				<td><fmt:formatNumber value="${his.deltem_delfee}" pattern="#,###원" /></td>
				<td>${his.ord_request}</td>
				<td><fmt:formatNumber value="${his.gds_price}" pattern="#,###원" /></td>
				<td>${his.ord_status}</td>
				<td>
				<input type="button" value="취소">
				<input type="button" value="환불">
				<input type="button" value="교환">
				<input type="button" value="후기쓰기" onClick="location.href='review_write?gds_num=${his.gds_num}&ord_num=${his.ord_num}'">
				</td>
			</tr>
		</c:forEach>
		
	</table>
	<div id="bbslist_paging">
			<c:if test="${page <=1 }">
				[이전]&nbsp;
			</c:if>

			<c:if test="${page > 1 }">
				<a href="order_history?page=${page-1}">[이전]</a>&nbsp;
			</c:if>

			<c:forEach var="a" begin="${startpage}" end="${endpage}">
				<c:if test="${a == page }">
					[${a}]
				</c:if>
				<c:if test="${a != page }">
					<a href="order_history?page=${a}">[${a}]</a>&nbsp;
				</c:if>
			</c:forEach>

			<c:if test="${page >= maxpage }">
				[다음] 
			</c:if>
			<c:if test="${page < maxpage }">
				<a href="order_history?page=${page+1}">[다음]</a>
			</c:if>
		</div>

	</div>

</div>
</body>
</html>