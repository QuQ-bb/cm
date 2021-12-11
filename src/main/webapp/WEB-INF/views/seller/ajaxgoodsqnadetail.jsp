<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="goodsqnamodal" role="dialog">
<!-- 문의글 -->
	<table id="questionTable">
		<tr>
			<td style="border-right: none;">
				<img src="<%=request.getContextPath() %>/resources/images/thumbnailimage/${goodsquestion.gds_thumbnail}" height="100" width="100" />
			</td>
			<td style="border-left: none;">
				${goodsquestion.gds_name}
				<br><br>
				<div style="text-align: right"> <a href="goodsupdate?&gds_num=${goodsquestion.gds_num}">상품 수정하기</a></div>
			</td>
			<td>${goodsquestion.gdsqna_title}</td>
			<td>
				<fmt:formatDate value="${goodsquestion.gdsqna_date}" pattern="yyyy-MM-dd HH:mm:ss"/> 
			</td>
			<td style="text-align: center;">
				<c:choose>
					<c:when test="${goodsquestion.gdsqna_answer == 0}">
						미답변
					</c:when>
					<c:when test="${goodsquestion.gdsqna_answer == 1}">
						답변완료
					</c:when>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td>
				${goodsquestion.gdsqna_content}
			</td>
		</tr>
	
	</table>

<!-- 답변이 있을 경우 -->
<!-- 답변이 없을 경우 -->


</div>