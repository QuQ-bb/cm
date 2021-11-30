<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 보기</title>
<script>
//상품 삭제 확인
function del(page, rev_num) {
   var chk = confirm("정말 삭제하시겠습니까?");
   if (chk) {
      location.href='review_delete?page='+page+'&rev_num='+rev_num;
   }
}   
</script>
</head>
<body>
	<div id="boardcont_wrap">
		<h2 class="boardcont_title">게시물 내용보기</h2>
		<table id="boardcont_t">
			<tr>
				<th>글내용</th>
				<td>
<%-- 					<c:if test="${empty rev_filename}">
       				${rcont.rev_content}
       				</c:if>
       				<c:if test="${!empty rev_filename}">
					<img src="<%=request.getContextPath() %>/resources/images/sellerimage/${rev_filename}" height="100" width="100" />
					${rcont.rev_content}
					</c:if> --%>
					${review.rev_content}
					 <%-- <pre>${bcont.board_content}</pre> --%></td>
				<td>
					<!-- 이미지 파일 들어가야할거같음 -->

				후기번호:${review.rev_num}
				결제번호:${review.pay_num}
				주문번호:${orderrev.ord_num}
				상품번호:${review.gds_num}
				상품이름:${review.gds_name}
				상품옵션:${review.ord_gdsoption}
				</td>
			</tr>
		</table>

		<div id="reviewcont_menu">
			<input type="button" value="수정" class="input_button"
				onclick="location='review_update?rev_num=${review.rev_num}&page=${page}'" />
			<input type="button" value="삭제" onclick="del(${page},${review.rev_num})"/>
			<input type="button" value="목록" class="input_button"
				onclick="location='review_list?page=${page}'" />
		</div>
	</div>
</body>
</html>