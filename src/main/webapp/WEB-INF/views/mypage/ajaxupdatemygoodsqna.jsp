<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action="<%=request.getContextPath()%>/mygoodsqnaupdate" method="post">
	<input type="hidden" id="gdsqna_num" name="gdsqna_num" value="${goodsquestion.gdsqna_num}">
	<table	border ="1" id="goodsquestion${goodsquestion.gdsqna_num}">
		<caption>문의 수정</caption>
		<tr>
			<th width="100">문의 제목</th>
			<td><input type="text" id="gdsqna_title" name="gdsqna_title" size="100" value="${goodsquestion.gdsqna_title}"></td>
		</tr>
		<tr>
			<th width="100">문의 내용</th>
			<td><textarea id="gdsqna_content" name="gdsqna_content" cols="102" rows="10">${goodsquestion.gdsqna_content }</textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<input type="submit" value="수정">			
			</td>
		</tr>
	
	</table>

</form>    