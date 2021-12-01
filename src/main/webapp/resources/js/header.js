$(function(){
	
	$("#cate").mouseover(function(){
		
//		alert("호출 성공");
		
		// 대분류 요청
//		var lcate_code = $("#lcate_code  option:selected").val();
		 $.ajax({
	    	    url : '/lcateload', // 요청 할 주소
	    	    type : 'post', 		// GET, PUT
	    	    dataType : 'text',
//	    	    data : {
//	    	    	"lcate_code" : lcate_code,
//	    	    },
	    	    success : function(data) {
	    	    	$('#lcate').html(data);
//	    	    	alert(data);
	    	    }, // 요청 완료 시
	    	    error :function(xhr,status,error){
						console.log("code:"+xhr.status+"\n"+"message:"+xhr.responseText+"\n"+"error:"+error);
						alert(xhr.status);
					}
	    	});
		
		
		
		
	});
	
	
	
});


// 중분류 불러오기  ajax
function mcateload() {
	if($("#lcate_code  option:selected").val() > 0){
		var lcate_code = $("#lcate_code  option:selected").val();
		 $.ajax({
	    	    url : '/mcateload', // 요청 할 주소
	    	   // async: true, // false 일 경우 동기 요청으로 변경
	    	    type : 'post', // GET, PUT
	    	    dataType : 'text',
	    	    data : {
	    	    	"lcate_code" : lcate_code,
	    	    },
	    	    success : function(data) {
	    	    	$('#mcate').html(data);
	    	    }, // 요청 완료 시
	    	    error :function(xhr,status,error){
						console.log("code:"+xhr.status+"\n"+"message:"+xhr.responseText+"\n"+"error:"+error);
						alert(xhr.status);
					}
	    	});
		 $('#scate').empty();
	}else {
		$('#mcate').empty();
		$('#scate').empty();
	}
}

//소분류 불러오기  ajax
function scateload() {
	if($("#mcate_code  option:selected").val() > 0){
		var mcate_code = $("#mcate_code  option:selected").val();
		 $.ajax({
	    	    url : '/scateload', // 요청 할 주소
	    	   // async: true, // false 일 경우 동기 요청으로 변경
	    	    type : 'post', // GET, PUT
	    	    dataType : 'text',
	    	    data : {
	    	    	"mcate_code" : mcate_code,
	    	    },
	    	    success : function(data) {
	    	    	$('#scate').html(data);
	    	    }, // 요청 완료 시
	    	    error :function(xhr,status,error){
						console.log("code:"+xhr.status+"\n"+"message:"+xhr.responseText+"\n"+"error:"+error);
						alert(xhr.status);
					}
	    	});
	}else {
		$('#scate').empty();
	}
}