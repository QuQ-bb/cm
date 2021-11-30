<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기목록</title>
</head>
<body>

<!-- 리뷰 리스트 -->
<div id="rev_list_wrap">
		<h2 class="rev_list_title">리뷰 목록</h2>
		<div id="rev_list_c">글 개수 : ${listcount}</div>

		<table id="rev_list_t">
			<tr align="center" valign="middle">
				<td>
					<div align="center">후기번호</div>
				</td>
				<td>
					<div align="center">내용</div>
				</td>
				<td>
					<div align="center">작성자</div>
				</td>
				<td>
					<div align="center">작성날짜</div>
				</td>
			</tr>

			<!-- 화면 출력 번호  변수 정의 -->		
			<c:set var="num" value="${listcount-(page-1)*5}"/> 	
			<!-- 반복문 시작 -->
			<c:forEach var="r"  items="${reviewlist}">
			
			<tr align="center" class="reviewlist">
				<td>					
						<input type="hidden" id="pay_num" name ="pay_num" value="${r.pay_num}">
						<input type="hidden" id="gds_num" name ="gds_num" value="${r.gds_num}">
						<input type="hidden" id="ord_num" name ="ord_num" value="${r.ord_num}">
 					<!-- 번호 출력 부분 -->	
 					<c:out value="${num}"/>			
				</td>
					<c:set var="num" value="${num-1}"/>	 
				
				<td>
					<div align="left">						
					<!--내용 출력 부분 -->	
					<a href="review_cont?rev_num=${r.rev_num}&page=${page}&state=cont">
							고객님의 소중한 후기
					</a>
					</div>
				</td>
				
				<td>
					<!-- 작성자 출력 부분 -->
					<div align="center">${r.mem_id}</div>
				</td>
				
				<td>
					<!-- 작성 날짜 출력 부분 -->
					<div align="center">
					<fmt:formatDate value="${r.rev_date}"
						 pattern="yyyy-MM-dd HH:mm:ss"/>					
					
					</div>
				</td>
			</tr>
			
			</c:forEach>
			<!-- 반복문 끝 -->			
		</table>
		

		<div id="revlist_paging">			
			<c:if test="${page <=1 }">
				[이전]&nbsp;
			</c:if>
			
			<c:if test="${page > 1 }">
				<a href="review_list?page=${page-1}">[이전]</a>&nbsp;
			</c:if>			

			<c:forEach var="a" begin="${startpage}" end="${endpage}">
				<c:if test="${a == page }">
					[${a}]
				</c:if>
				<c:if test="${a != page }">
					<a href="review_list?page=${a}">[${a}]</a>&nbsp;
				</c:if>
			</c:forEach>			
			
			<c:if test="${page >= maxpage }">
				[다음] 
			</c:if>
			<c:if test="${page < maxpage }">
				<a href="review_list?page=${page+1}">[다음]</a>
			</c:if>			
			
		</div>
		<div id="reviewlist_w">
			<input type="button" value="후기쓰기" class="input_button"
				onclick="location='review_write?page=${page}'">
		</div>
		
	</div>
</body>
</html>