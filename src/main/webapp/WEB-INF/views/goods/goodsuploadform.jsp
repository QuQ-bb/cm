<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 업로드</title>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<!-- SmartEditor 텍스트 편집기 -->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/smarteditor2/js/HuskyEZCreator.js"
	charset="utf-8"></script>
</head>
<body>

	<div id="goodsuploadform">

		<form method="post" action="<%=request.getContextPath() %>/goodsupload" enctype="multipart/form-data">
			<input type="hidden">
			<!-- 판매자명 가져가기 -->
			<table border="1" width="1200">

				<tr>
					<th>카테고리 선택</th>
					<td><input type="text" id="cate_code" name="cate_code"></td>
				</tr>
				<tr>
					<th>상품 판매자</th>
					<td><input type="text" id="gds_seller" name="gds_seller"></td>
				</tr>
				<tr>
					<th>상품명</th>
					<td><input type="text" id="gds_name" name="gds_name"></td>
				</tr>
				<tr>
					<th>썸네일</th>
					<td><input type="text" id="gds_thumbnail" name="gds_thumbnail"></td>
				</tr>
				<tr>
					<th>단위 가격</th>
					<td><input type="text" id="gds_price" name="gds_price"></td>
				</tr>
				<tr>
					<th>상세설명</th>
					<td width=900><textarea id="gds_detail" name="gds_detail"
							rows="20" cols="100"></textarea></td>
				</tr>
				<tr>
					<th>옵션</th>
					<td><input type="text" id="gds_option" name="gds_option"></td>
				</tr>
				<tr>
					<th>배송 정보</th>
					<td><input type="text" id="deltem_num" name="deltem_num"></td>
				</tr>
				<tr>
					<th>재고</th>
					<td><input type="text" id="gds_count" name="gds_count"></td>
				</tr>
				<tr>
					<th>교환 환불 기준</th>
					<td><textarea id="gds_ears" name="gds_ears"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						id="uploadbutton" name="uploadbutton" value="업로드 하기"></td>
				</tr>

			</table>
		</form>

	</div>
	<!-- 스마트에디터   -->
	<script>
	$(function(){
	    //전역변수선언
	    var editor_object = [];
	     
	    nhn.husky.EZCreator.createInIFrame({
	        oAppRef: editor_object,
	        elPlaceHolder: "gds_detail",
	        sSkinURI: "<%=request.getContextPath()%>/resources/smarteditor2/SmartEditor2Skin.html",
						htParams : {
							// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
							bUseToolbar : true,
							// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
							bUseVerticalResizer : false,
							// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
							bUseModeChanger : true,
							fCreator : "createSEditor2"
						}
					});

			//업로드버튼 클릭이벤트
			$("#uploadbutton").click(
					function() {
						//id가 gds_content인 textarea에 스마트 에디터의 내용을 전달
						editor_object.getById["gds_detail"].exec(
								"UPDATE_CONTENTS_FIELD", []);
						//폼 submit
						$("#form").submit();
					})
		})
	</script>


</body>
</html>