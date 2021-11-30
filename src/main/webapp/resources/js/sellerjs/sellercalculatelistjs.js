function showcalculdetail(clcln_num) {
	if($("#calculdetail"+clcln_num).hasClass('hide')) {
		 $.ajax({
	 	    url : '/showcalculdetail', // 요청 할 주소
	 	   // async: true, // false 일 경우 동기 요청으로 변경
	 	    type : 'post', // GET, PUT
	 	    dataType : 'text',
	 	    data : {
	 	    	"clcln_num" : clcln_num,
	 	    },
	 	    success : function(data) {
	 	    	 /*var tr = $(this).parent().parent();
	 	    	 tr.html(data);*/
	 	    	$("#calculdetail"+clcln_num).html(data);
	 	    	$("#calculdetail"+clcln_num).removeClass('hide').addClass('show');  
	 	    }, // 요청 완료 시
	 	    error :function(xhr,status,error){
						console.log("code:"+xhr.status+"\n"+"message:"+xhr.responseText+"\n"+"error:"+error);
						alert(xhr.status);
			}
	 	});
	}else if($("#calculdetail"+clcln_num).hasClass('show')) {
		$("#calculdetail"+clcln_num).empty();
		$("#calculdetail"+clcln_num).removeClass('show').addClass('hide');  
		
	}
}