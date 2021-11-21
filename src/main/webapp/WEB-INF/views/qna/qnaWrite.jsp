<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CM QnaWrite</title>
<c:import url="../template/boot.jsp" />
<link href="${pageContext.request.contextPath}/resources/css/reset.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/qna/qnaWrite.css" rel="stylesheet">
</head>
<body>
	<div id="popWrap">
		<div id="popHead">
			<div class="popHeadEnd">
				<h2>문의내용 작성</h2>
			</div>
		</div>
		<div class="popBody_con">
			<form:form action="noticeWrite" modelAttribute="noticeVO" id="frm" enctype="multipart/form-data">
				<div class="pop_qna_wrap">
					<div class="tbl_wrap">
						<table class="tbl">
							<caption>문의내용 작성</caption>
							<colgroup>
								<col style="width:25%">
								<col style="width:75%">
							</colgroup>
							<tbody>
							<!-- 제목 -->
								<tr>
									<th scope="row" class="first alignL">
										<label for="popCont">제목</label>
									</th>
									<td class="alignL">
										<select style="display: block; border: 1px solid #b9b9b9;">
											<option>선택해주세요.</option>
											<option>배송지연/불만</option>
											<option>반품문의</option>
											<option>A/S문의</option>
											<option>환불문의</option>
											<option>주문결제문의</option>
											<option>회원정보문의</option>
											<option>취소문의</option>
											<option>교환문의</option>
											<option>상품정보문의</option>
											<option>기타문의</option>
										</select>
										<form:input path="qna_title" style="border: 1px solid #b9b9b9;width: 100%" />
									</td>
								</tr>
							<!-- 주문번호 -->
								<tr>
									<th scope="row" class="first alignL">
										<label for="popCont">주문번호</label>
									</th>
									<td class="alignL">
										<input type="text" style="border: 1px solid #b9b9b9;width: 10%">
										<input type="button" value="주문조회">
									</td>
								</tr>
							<!-- 내용 -->
								<tr>
									<th scope="row" class="first alignL">
										<label for="popCont">내용</label>
									</th>
									<td class="alignL">
										<ul>
											<li>1:1 문의 작성 전 확인해주세요!</li>
											<br>
											<li>반품/환불</li>
											<li> - 제품 하자 혹은 이상으로 반품(환불)이 필요한 경우 사진과 함께 구체적인 내용을 남겨주세요.</li>
											<br>
											<li>주문취소</li>
											<li> - 배송 단계별로 주문취소 방법이 상이합니다.</li>
											<li>   [입금확인] 단계 : [마이CM > 주문내역 상세페이지]에서 직접 취소 가능</li>
											<li>   [입금확인] 이후 단계 : 고객센터로 문의</li>
											<br>
											<li> - 생산이 시작된 [상품 중비중] 이후에는 취소가 제한되는 점 고객님의 양해 부탁드립니다.</li>
											<li> - 일부 예약상품은 배송 3~4일 전에만 취소 가능합니다.</li>
											<li> - 주문상품의 부분 취소는 불가능합니다. 전체 주문 취소 후 재구매 해주세요.</li>
											<br>
											<li>* 전화번호, 이메일, 주소, 계좌번호 등의 상세 개인정보가 문의 내용에 저장되지 않도록 주의해 주시기 바랍니다.</li>
										</ul>
										<textarea name="qna_content" id="popCont" rows="20" cols="150" placeholder="궁금하신 내용을 작성해 주세요"></textarea>
									</td>
								</tr>
								<!-- 이미지 첨부파일 -->
								<tr>
									<th scope="row" class="first alignL">
										<label for="popCont">이미지</label>
									</th>
									<td class="alignL">
										<input type="button" id="btn_add" class="btn_add" value="Add File">
	       								<div id="files"></div>
	       								
										<p>- 파일은 최대 5개까지 업로드가 지원됩니다.</p>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				<!-- 비밀글 -->
					<div class="chk_wrap">
						<label for="secret">
							<input type="checkbox" name="secret" id="secret" value="0" class="chk"> 비밀글로 문의하기
						</label>
					</div>
				</div>
			<!-- 버튼 -->
				<div class="btn_wrap">
					<input type="hidden" name="writer" value="${writer}">
					<button id="btnSave" class="popbtn popbtn1" title="등록"><span>등록</span></button>
					<button id="btnClose" class="popbtn popbtn2" title="취소"><span>취소</span></button>
				</div>
			</form:form>
		</div>
	</div>
<script type="text/javascript">
	
	//첨부파일 등록
	//var files = $('#files').html();
	var files = ' <div class="form-group tt"><label for="file"></label><br><div class="col-sm-11"><input type="file" class="form-control" id="file" name="files"></div><div class="col-sm-1"><input type="button" class="del" value="X"></div></div>';
	$('#files').empty(); //remove vs empty ; 나 포함 전체 지우기 vs 자식만 지우기
	var check = 0;
	var index = 0; //index 번호

	$('#files').on("click", ".del", function() {
		//event.preventDefault();
		//alert("del");
		//$("#files div:last").remove(); //선택된 게 지워지질 않아 ㅜㅠ
		//1. $(this).closest(".tt").remove(); //가장 가까운 거!!
		//2. $(this).parent().parent().remove();
		//3. $(this).parents(".form-group").remove();
		$(this).parentsUntil("#files").remove();
		check--;
	}); //add file은 버튼을 눌러야 추가되는데, 추가되기 전에 이벤트가 실행되므로 이벤트가 실행되지 않는다.

	$('#btn_add').click(function() {
		//alert(files);
		if (check < 5) {
			$('#files').append(files);
			check++;
		} else {
			alert("최대 5개까지 가능합니다.");
		}
	});

	//등록 버튼
	$('#btnSave').click(function() {
		if ($('input[name="secret"]').is(":checked")) {
			$('input[name="secret"]').val(1);
		} else {
			$('input[name="secret"]').val(0);
		}

		var writer = $('input[name="writer"]').val();
		var contents = $('#popCont').val();
		var secret = $('input[name="secret"]').val();

		//다른 input들 검증.
		
		if (writer == null || writer == "") {
			alert("로그인 후 이용하세요");
			self.close();
		} else {

			if (contents != "") {
					
				$.ajax({
					type : "POST",
					url : "./qnaWrite",
					data : {
						writer : writer,
						contents : contents,
						step : 0,
						secret : secret
					},
					success : function(data) {
						if (data > 0) {
							opener.location.reload();
							self.close();
						} else {
							alert("잠시 후에 다시 시도해주세요.");
						}
					},
					error : function() {
						alert("잠시 후에 다시 시도해주세요.");
					}
				});
							
			} else {
				alert("문의내용을 입력해주세요.");
			}
		}
	});

	//취소 버튼
	$('#btnClose').click(function() {
		history.go(-1);
	});
</script>
</body>
</html>