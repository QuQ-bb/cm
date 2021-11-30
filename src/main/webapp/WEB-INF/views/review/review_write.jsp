<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기 쓰기</title>
</head>
<body>
		<h2 text-align="center">후기작성</h2>
	<form method="post" action="/review_ok" enctype="multipart/form-data">
	<input type="hidden" id="gds_name" name ="gds_name" value="${gds_name}">
	<input type="hidden" id="ord_gdsnum" name ="ord_gdsnum" value="${ord_gdsnum}">
	<input type="hidden" id="ord_num" name ="ord_num" value="${ord_num}">
		<table>
			<tr>
				<th>작성자</th>
				<td>
				${mem_id}
				</td>
			</tr>
			<tr>
				<th>후기</th>
				<td>				
				<textarea name="rev_content" id="rev_content" rows="8" cols="50" class="input_box"></textarea>
				</td>
			</tr>
			<tr>
				<th>후기사진</th>
				<td>	
				<input type="file" class="form-control" id="rev_filename1" name="rev_filename1">
				</td>
			</tr>
		</table>
		 <div id="reivewwrite_menu">
    <input type="submit" value="등록" class="input_button" />
    <input type="reset" value="취소" class="input_button"
    onclick="$('#rev_content').focus();" />
   </div>
	</form>
</body>
</html>