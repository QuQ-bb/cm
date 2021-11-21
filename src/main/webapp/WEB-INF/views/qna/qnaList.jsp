<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CM QnaList</title>
<c:import url="../template/boot.jsp" />
<c:import url="../layout/header.jsp" />
<link href="${pageContext.request.contextPath}/resources/css/reset.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/qna/qnaList.css" rel="stylesheet">
</head>
<body>
<div class="body_main">
	<div class="b"></div>
	<!-- 서브 타이틀 -->
	<div class="subTitle_wrap">
		<div class="subTitle_inner">
			<h2>1:1 문의</h2>
		</div>
	</div>

	<!-- container -->
	<div class="container">
		<div class="qna_filter"></div>
		<table class="qna_tb">
			<colgroup>
				<col style="width:85px;">
				<col style="width:auto;">
				<col style="width:96px;">
				<col style="width:115px;">
			</colgroup>
			<thead>
				<tr>
					<th scope="col">문의번호</th>
					<th scope="col">문의/답변</th>
					<th scope="col">작성자</th>
					<th scope="col">작성일</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${lists}" var="list">
						<c:if test="${list.step == 0}">
							<tr class="${list.ref}">
								<td class="td_num">${list.num}</td>
								<td class="td_view">
									<c:if test="${list.acheck eq 0}">
										<span class="state">미완료</span>
									</c:if>
									<c:if test="${list.acheck eq 1}">
										<span class="state stateF">답변완료</span>
									</c:if>
								<!-- 비밀글일때 -->
									<c:if test="${list.secret eq 1}">
										<c:if test="${member.nickname ne list.writer && member.grade ne 9999}">비밀글입니다. <img alt="비밀글" src="../images/board/lock-line.png" style="margin-bottom: 4px;"></c:if>
										<c:if test="${member.nickname eq list.writer || member.grade eq 9999}">
											<a href="javascript:void(0)" id="showCloseDetail" class="view_txt">${list.contents} <img alt="비밀글" src="../images/board/lock-line.png" style="margin-bottom: 4px;"></a>
										</c:if>
									</c:if>
								<!-- 비밀글 아닐때 -->
									<c:if test="${list.secret eq 0}">
										<a href="javascript:void(0)" id="showCloseDetail" class="view_txt">${list.contents}</a>
									</c:if>
								</td>
								<td class="td_writer">${list.writerS}</td>
								<td class="td_date"><fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd HH:mm" /></td>
							</tr>
						</c:if>
						
						<tr class="trQna trQna${list.ref}" style="display: table-row;">
							<td colspan="4" class="qna_wrap" style="display: table-cell;">
							<!-- 질문 -->
								<c:if test="${list.step == 0}">
									<div class="question">
										<span class="iconQ">질문</span>
											<div style="white-space: pre-line;"><c:out value="${list.contents}" /></div>
										<br>
										<div class="btns_wrap">
											<input type="hidden" class="num" value="${list.num}">
											<c:if test="${member.grade eq 9999}">
												<a href="javascript:void(0)" class="btn_reply">답변하기 ></a>
											</c:if>
											<c:if test="${member.nickname eq list.writer}">
												<a href="javascript:void(0)" class="btn_update">수정하기</a>
											</c:if>
											<c:if test="${member.nickname eq list.writer || member.grade eq 9999}">
												<a href="qnaDelete?ref=${list.ref}">삭제하기</a>
											</c:if>
										</div>
									</div>
								</c:if>
							<!-- 답변 -->
								<c:if test="${list.step > 0}">
									<div class="answer">
										<span class="iconA">답변</span>
										<div style="white-space: pre-line;"><c:out value="${list.contents}" /></div>
										<br>
										<div class="btns_wrap">	
											<input type="hidden" class="num" value="${list.ref}">
											<c:if test="${member.grade eq 9999 && member.nickname eq list.writer}">
												<a href="javascript:void(0)" class="btn_replyUpdate">수정하기</a>
												<a href="qnaAnswerDelete?num=${list.num}&&ref=${list.ref}">삭제하기</a>
											</c:if>
										</div>
									</div>
								</c:if>
							</td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<c:if test="${member.grade ne 9999}">
			<div class="btn_wrap">
				<input type="button" value="문의하기" class="btn_write" onclick="location.href='./qnaWrite'" style="cursor: pointer;">
			</div>
		</c:if>
		
		<ul class="pagination">
			<c:if test="${pager.curBlock gt 1}">
				<li class="previous"><a href="./qnaList?curPage=${pager.startNum-1}"><</a></li>
			</c:if>
			
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<c:if test="${pager.curPage == i}">
					<li class="list"><a href="./qnaList?curPage=${i}" style="color: #f23600;">${i}</a></li>
					
				</c:if>
				<c:if test="${pager.curPage != i}">
					<li class="list"><a href="./qnaList?curPage=${i}">${i}</a></li>
				</c:if>
			</c:forEach>
			
			<c:if test="${pager.curBlock lt pager.totalBlock}">
				<li class="next"><a href="./qnaList?curPage=${pager.lastNum+1}">></a></li>
			</c:if>
		</ul>
	</div>
		<c:import url="../layout/footer.jsp" />
</div>
<script type="text/javascript">

	var openWin;
	var nickname = "${member.nickname}";

	$('.trQna').hide();

	$('.view_txt').click(function(){
		var i = $(this).parents('tr').attr('class');
		$('.trQna'+i).slideToggle();
	});

	//날짜 변환 함수
	function changeDate(date){
		date = new Date(parseInt(date));
		year = date.getFullYear();
		month = date.getMonth();
		day = date.getDate();
		hour = date.getHours();
		minute = date.getMinutes();
		//second = date.getSeconds();
		strDate = year + "-" + month + "-" + day + " " + hour + ":" + minute;
		return strDate;
	}
</script>	
</body>
</html>				