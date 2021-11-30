function insertOpion(){
		 $("#opt_count").attr("readonly", false); //입력 가능 설정
		
		var size = $("input[id='optioncom']").length;
		var count = 0;
		
		for(i=0;i<size;i++){
			count += parseInt($("input[name='optioncount']").eq(i).val());
		}
		
		if(isNaN(count)){
			alert("수량을 제대로 입력해 주세요.");
		}else{
			 $('#opt_count').val(count);
			 $("#opt_count").attr("readonly", true); //입력 불가 설정
		}
}

function updateOption(){
	 $("#opt_count").attr("readonly", false); //입력 가능 설정
	
	var size = $("input[id='edit_opt_count']").length;
	var count = 0;
	
	for(i=0;i<size;i++){
		count += parseInt($("input[name='edit_opt_count']").eq(i).val());
	}
	
	if(isNaN(count)){
		alert("수량을 제대로 입력해 주세요.");
	}else{
		 $('#opt_count').val(count);
		 $("#opt_count").attr("readonly", true); //입력 불가 설정
	}
}
