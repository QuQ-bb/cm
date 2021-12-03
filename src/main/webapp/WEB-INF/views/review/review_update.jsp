<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 수정</title>
<link rel="stylesheet" href="<c:url value='/resources/css/review/review_update.css'/>">
</head>
<body>
<%@ include file="../layout/header.jsp" %>
<%@ include file="../layout/mypage.jsp" %>
	
	<div id="bbswrite_wrap">
  <h2 class="bbswrite_title">리뷰 수정폼</h2>
  <form method="post" action="review_update_ok" onSubmit="return review_check()">
  <input type="hidden" name="rev_num" value="${review.rev_num}" />
  <input type="hidden" name="page" value="${page}" />
  
   <table id="customers">
    <tr>
	<th>작성자</th>
	<td>
	${review.mem_id}
	</td>
	</tr>
    <tr>
     <th>후기내용</th>
     <td>
      <textarea name="rev_content" id="rev_content" rows="8" cols="50"
      class="input_box">${review.rev_content}</textarea>
     </td>
    </tr> 
   </table>
   <br>
   <button type="submit">수정</button>
   <button type="reset"  onclick="history.go(-1)">취소</button>
  </form>
 </div>
 <%@ include file="../layout/footer.jsp" %>
</body>
</html>