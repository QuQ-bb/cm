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

// 배송템플릿 유효성검사
function template_check(){
	if ($.trim($("#deltem_name").val()) == "") {
		alert("배송 템플릿 명을 입력해 주세요");
		$("#deltem_name").val("").focus();
		return false;
	}
	if ($.trim($("#del_info").val()) == "") {
		alert("배송사를 선택해 주세요");
		$("#del_info").val("").focus();
		return false;
	}
	if ($.trim($("#deltem_delfee").val()) == "") {
		alert("배송비를 입력해 주세요");
		$("#deltem_delfee").val("").focus();
		return false;
	}
	if (isNaN($("#deltem_delfee").val())) {
		alert("배송비는 숫자만 입력해 주세요");
		$("#deltem_delfee").val("").focus();
		return false;
	}
	if ($.trim($("#deltem_redelfee").val()) == "") {
		alert("반품 배송비를 입력해 주세요");
		$("#deltem_redelfee").val("").focus();
		return false;
	}
	if (isNaN($("#deltem_redelfee").val())) {
		alert("반품 배송비는 숫자만 입력해 주세요");
		$("#deltem_redelfee").val("").focus();
		return false;
	}
	if ($.trim($("#deltem_exdelfee").val()) == "") {
		alert("교환 배송비를 입력해 주세요");
		$("#deltem_exdelfee").val("").focus();
		return false;
	}
	if (isNaN($("#deltem_exdelfee").val())) {
		alert("교환 배송비는 숫자만 입력해 주세요");
		$("#deltem_exdelfee").val("").focus();
		return false;
	}
	if ($.trim($("#deltem_repost").val()) == "") {
		alert("우편번호 찾기를 통해 주소를 입력해주세요");
		return false;
	}
	if ($.trim($("#deltem_readd1").val()) == "") {
		alert("우편번호 찾기를 통해 주소를 입력해주세요");
		return false;
	}
	if ($.trim($("#deltem_readd2").val()) == "") {
		alert("나머지 주소를 입력해주세요");
		return false;
	}
	
}


