<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 업로드</title>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<!-- SmartEditor 텍스트 편집기 -->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/smarteditor2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script>
//우편번호, 주소 Daum API
function openDaumPostcode() {
	new daum.Postcode({
		oncomplete : function(data) {				
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
			// 우편번호와 주소 정보를 해당 필드에 넣고, 커서를 상세주소 필드로 이동한다.
			document.getElementById('deltem_repost').value = data.zonecode;
			document.getElementById('deltem_readd1').value = data.address;				
		}
	}).open();
}

// 옵션 Ajax
function add_item(){
	// 옵션을 입력하였을 경우
	 if($("#option1").val()!=""){
         var option1 = $("#option1").val();
         var option2 = $("#option2").val();
         
         $.ajax({
       	    url : '/optioncom', // 요청 할 주소
       	   // async: true, // false 일 경우 동기 요청으로 변경
       	    type : 'post', // GET, PUT
       	    dataType : 'text',
       	    data : {
       	    	"option1" : option1,
       	    	"option2" : option2,
       	    },
       	    success : function(data) {
       	    	$('#field').html(data);
       	    }, // 요청 완료 시
       	    error :function(xhr,status,error){
					console.log("code:"+xhr.status+"\n"+"message:"+xhr.responseText+"\n"+"error:"+error);
					alert(xhr.status);
				}
       	});
     // 옵션을 입력하지 않았을 경우
	 }else{
		 alert("옵션값을 입력해 주세요.");
		 return false;
	 }
}
// 배송템플릿 자동완성 
function deltemLoad() {
	if($("#deltem_num  option:selected").val() != null){
		var deltem_num = $("#deltem_num  option:selected").val();
		alert(deltem_num);
	//	$.post('/deltemload', deltem_num, function(data) {
	//		$('#deltemdiv').html(data);
	//		frm.replytext.value = '';
	//	});
		 $.ajax({
	    	    url : '/deltemload', // 요청 할 주소
	    	   // async: true, // false 일 경우 동기 요청으로 변경
	    	    type : 'post', // GET, PUT
	    	    dataType : 'text',
	    	    data : {
	    	    	"deltem_num" : deltem_num,
	    	    },
	    	    success : function(data) {
	    	    	$('#deltemdiv').html(data);
	    	    }, // 요청 완료 시
	    	    error :function(xhr,status,error){
						console.log("code:"+xhr.status+"\n"+"message:"+xhr.responseText+"\n"+"error:"+error);
						alert(xhr.status);
					}
	    	});
	}
}


</script>



<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">

</head>
<body>

	<div id="goodsuploadform">

		<form method="post" action="<%=request.getContextPath()%>/goodsupload" enctype="multipart/form-data">
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
					<td><input type="file" id="gds_thumbnail1" name="gds_thumbnail1"></td>
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
					<td>
						<div id="pre_set">
							옵션1 : <input type="text" name="size" id="option1" style="width:150px">
							옵션2 : <input type="text" name="color" id="option2" style="width:150px">
							<input type="button" value="추가 " onclick="add_item()">
						</div>
						
						
						<div id="field"></div>
					</td>
				</tr>
				<tr>
					<th>재고</th>
					<td><input type="text" id="gds_count" name="gds_count"></td>
				</tr>
				<tr>
					<th>배송 템플릿</th>
					<td>
						<select id="deltem_num" name="deltem_num" onchange="deltemLoad()">
								<option value="0">배송 템플릿</option>
							<c:forEach var="dtlist" items="${deltemlist}">
								<option value="${dtlist.deltem_num}">${dtlist.deltem_name}</option>
							</c:forEach>
								<option value="0">새로입력</option>
						</select>
						<div id="deltemdiv" name="deltemdiv">
						</div>
					
					
					</td>
				</tr>
				<tr>
					<th>교환 환불 기준</th>
					<td><textarea id="gds_ears" name="gds_ears" rows="20" cols="100"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" id="uploadbutton" name="uploadbutton" value="업로드 하기"></td>
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