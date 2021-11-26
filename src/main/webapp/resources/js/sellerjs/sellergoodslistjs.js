// 상품 삭제 확인
function del(page, gds_num) {
	var chk = confirm("정말 삭제하시겠습니까?");
	if (chk) {
		location.href='goodsdelete?page='+page+'&gds_num='+gds_num;
	}
}	