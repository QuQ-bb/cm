function insertOpion(){
		 $("#gds_count").attr("readonly", false); //입력 가능 설정
		
		var size = $("input[id='optioncom']").length;
		var count = 0;
		
		for(i=0;i<size;i++){
			count += parseInt($("input[name='optioncount']").eq(i).val());
		}
		
		if(isNaN(count)){
			alert("수량을 제대로 입력해 주세요.");
		}else{
			 $('#gds_count').val(count);
			 $("#gds_count").attr("readonly", true); //입력 불가 설정
		}
	}