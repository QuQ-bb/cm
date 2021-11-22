// 옵션 Ajax
function add_item(){
	// 옵션을 입력하였을 경우
	 if($("#option1").val()!=""){
         var option1 = $("#option1").val();
         var option2 = $("#option2").val();
         
         $.ajax({
       	    url : '/optioncom', // 요청 할 주소
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
// 배송템플릿 자동완성  ajax
function deltemLoad() {
	if($("#deltem_num  option:selected").val() >= 0){
		var deltem_num = $("#deltem_num  option:selected").val();
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
	}else {
		$('#deltemdiv').empty();
	}
}



//배송템플릿 유효성검사
function goodsupload_check(){
	// 스마트 에디터 유효성검사
	var gds_detail = $("#gds_detail").val();
	
	if ($.trim($("#cate_code").val()) == "") {
		alert("카테고리를 선택해 주세요");
		$("#cate_code").val("").focus();
		return false;
	}
	if ($.trim($("#gds_name").val()) == "") {
		alert("상품명을 입력해 주세요");
		$("#gds_name").val("").focus();
		return false;
	}
	if ($.trim($("#gds_thumbnail1").val()) == "") {
		alert("대표이미지를 업로드 해주세요");
		$("#gds_thumbnail1").val("").focus();
		return false;
	}
	if ($.trim($("#gds_price").val()) == "") {
		alert("가격을 입력해 주세요");
		$("#gds_price").val("").focus();
		return false;
	}
	if (isNaN($("#gds_price").val())) {
		alert("가격은 숫자만 입력해 주세요");
		$("#gds_price").val("").focus();
		return false;
	}
	if (($("#gds_detail").val()) == "") {
		alert("상세정보를 입력해 주세요");
		$("#gds_detail").val("").focus();
		return false;
	}
	
	 if( gds_detail == ""  || gds_detail == null || gds_detail == '&nbsp;' || gds_detail == '<p>&nbsp;</p>')  {
         alert("내용을 입력하세요.");
         oEditors.getById["gds_detail"].exec("FOCUS"); //포커싱
         return;
    }
	if ($.trim($("#gds_count").val()) == "") {
		alert("수량을 입력해 주세요");
		$("#gds_count").val("").focus();
		return false;
	}
	if (isNaN($("#gds_count").val())) {
		alert("수량은 숫자만 입력해 주세요");
		$("#gds_count").val("").focus();
		return false;
	}
	if ($.trim($("#deltem_num").val()) < 0) {
		alert("배송정보를 입력해 주세요");
		return false;
	}
	if ($.trim($("#gds_ears").val()) == "") {
		alert("교환 환불 기준을 입력해 주세요");
		$("#gds_ears").val("").focus();
		return false;
	}
}