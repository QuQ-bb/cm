<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 수정</title>
</head>
<body>
	<div id="bbswrite_wrap">
  <h2 class="bbswrite_title">리뷰 수정폼</h2>
  <form method="post" action="review_update_ok" onSubmit="return review_check()">
  <input type="hidden" name="rev_num" value="${review.rev_num}" />
  <input type="hidden" name="page" value="${page}" />
  
   <table id="bbswrite_t">
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
   
   <div id="bbswrite_menu">
    <input type="submit" value="수정" class="input_button" />
    <input type="reset" value="취소" class="input_button"
    onclick="$('#review.rev_content').focus();" />
   </div>
  </form>
 </div>
</body>
</html>