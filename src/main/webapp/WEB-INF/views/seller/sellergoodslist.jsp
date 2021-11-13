<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품목록</title>
</head>
<body>
	<div id="goodslist_div">
		<h2 class="goodslist_title">상품목록</h2>
		<div id="goodslist_c">총 상품 개수 : ${listcount}</div>

		<table id="goodslist_t" border="1">
			<tr align="center" valign="middle">
				<td height="26">
					<div align="center">번호</div>
				</td>
				<td>
					<div align="center">상품명</div>
				</td>
				<td >
					<div align="center">가격</div>
				</td>
				<td>
					<div align="center">재고</div>
				</td>
				<td>
					<div align="center">등록일</div>
				</td>
				<td>
					<div align="center">조회수 / 판매수</div>
				</td>
				<td>
					<div align="center">상태</div>
				</td>
				<td>
					<div align="center">액션</div>
				</td>
			</tr>
			
			<!-- 화면 출력 번호  변수 정의 -->		
			<c:set var="num" value="${listcount-(page-1)*10}"/> 	
			
			<!-- 반복문 시작 -->
			<c:forEach var="sgl" items="${sellergoodslist}">
			<tr>
				<td>
					<!-- 번호 출력 부분 -->	
 					<c:out value="${num}"/>			
					<c:set var="num" value="${num-1}"/>	 
				</td>
				<td>
					<div>
						<!-- 썸네일 출력 부분 -->
						<img src="">	
						<!-- 제목 출력 부분 -->	
						<a href="">
							${sgl.gds_name}
						</a>
					</div>
				</td>
				<td >
					<div>${sgl.gds_price}</div>
				</td>
				<td>
					<div>${sgl.gds_count}</div>
				</td>
				<td>
					<div><fmt:formatDate value="${sgl.gds_date}" pattern="yyyy-MM-dd"/></div>
				</td>
				<td>
					<div>${sgl.gds_readcount} / ${sgl.gds_sellcount}</div>
				</td>
				<td>
					<c:if test="${sgl.gds_viewyn eq 'y' || sgl.gds_viewyn eq 'Y'}">
						판매중
					</c:if>
					<c:if test="${sgl.gds_viewyn eq 'n' || sgl.gds_viewyn eq 'N'}">
						판매중지
					</c:if>
				</td>
				<td>
					<div align="center"><input type="button" value="수정"></div>
					<div align="center"><input type="button" value="삭제"></div>
				</td>
			</tr>
			</c:forEach>
		</table>
				<div id="bbslist_paging">			
			<c:if test="${page <=1 }">
				[이전]&nbsp;
			</c:if>
			
			<c:if test="${page > 1 }">
				<a href="board_list.nhn?page=${page-1}">[이전]</a>&nbsp;
			</c:if>			

			<c:forEach var="a" begin="${startpage}" end="${endpage}">
				<c:if test="${a == page }">
					[${a}]
				</c:if>
				<c:if test="${a != page }">
					<a href="board_list.nhn?page=${a}">[${a}]</a>&nbsp;
				</c:if>
			</c:forEach>			
			
			<c:if test="${page >= maxpage }">
				[다음] 
			</c:if>
			<c:if test="${page < maxpage }">
				<a href="board_list.nhn?page=${page+1}">[다음]</a>
			</c:if>			
		</div>

	</div>
</body>
</html>