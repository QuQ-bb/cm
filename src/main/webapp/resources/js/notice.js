function notice_check() {
	if ($.trim($("#ntc_sort").val()) == "") {
		alert("공지 분류를 선택하세요");
		$("#ntc_sort").val("").focus();
		return false;
	}
	if ($.trim($("#ntc_title").val()) == "") {
		alert("공지 제목을 입력하세요");
		$("#ntc_title").val("").focus();
		return false;
	}
	if ($.trim($("#ntc_content").val()) == "") {
		alert("공지 내용을 입력하세요");
		$("#ntc_content").val("").focus();
		return false;
	}
}