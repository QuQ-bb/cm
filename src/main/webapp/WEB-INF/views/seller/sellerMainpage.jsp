<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>판매자 메인페이지</title>
<style>
body {
  font-family: "Lato", sans-serif;
}

.mypagesidenav {
  width: 250px;
  z-index: 1;
  top: 300px;
  left: 10px;
  height : 800px;
  background: #808080;
  overflow-x: hidden;
  padding: 10px 0;
  text-align: center;
  
  
}

.mypagesidenav a {
  padding: 6px 8px 6px 16px;
  text-decoration: none;
  font-size: 15px;
  display: block;
  text-align : left;
  padding-left: 20px
}

.mypagesidenav a:hover {
  color: #064579;
}

.main {
  margin-left: 300px; /* Same width as the sidebar + left position in px */
  margin-right: 300px; 
  font-size: 28px; /* Increased text to enable scrolling */
  padding: 0px 10px;
}

@media screen and (max-height: 450px) {
  .mypagesidenav {padding-top: 15px;}
  .mypagesidenav a {font-size: 18px;}
}

*{
  box-sizing: border-box; 
}
  
.title:first-child{
    border-top: 1px solid black;
  }
  
.title{
  position: relative;
  padding: 17px 0;
  cursor: pointer;
  font-size: 14px;
  border-bottom: 1px solid #dddddd;
  
}
  
.title::before{
  display: inline-block;
  font-size: 14px;
  color: #006633;
  margin-right: 5px;
}

.title.on>a{
  font-weight: bold;
  color: #006633; 
}
  
.menu {
  display: none;
  overflow: hidden;
  font-size: 14px;
  background-color: #f4f4f2;
  padding: 27px 0;
}
  
.menu::before {
  display: inline-block;
  font-size: 14px;
  font-weight: bold;
  color: #666;
  margin-right: 5px;
}	
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


</head>


<body>
<div class="mypagesidenav">
  	<h2>판매자 페이지</h2>
  	<div class="title">주문관리</div>
  	<div class="menu">
  		<a href="sellerorderlist">판매자 주문내역</a>
  	</div>
  	
  	<div class="title">상품관리</div>
 	<div class="menu">
	 	<a href="goodsuploadform">판매자 상품 업로드 폼</a>			
		<a href="sellergoodslist">판매자 상품 리스트</a>
	</div>	
	
	<div class="title">문의 / 후기관리</div>
	<div class="menu">
		<a href="sellergoodsqnalist">판매자 문의내역</a>
	</div>	
		
	<div class="title">배송관리</div>
  	<div class="menu">
  		<a href="sellerdeliverytemplate">판매자 배송 템플릿 작성</a>		
		<a href="sellerdeliverytemplatelist">판매자 배송템플릿 리스트</a>
  	</div>
  	
	<div class="title">정산관리</div>
	<div class="menu">
		<a href="sellercalculatelist">판매자 정산내역</a>
	</div>					
				
						
</div>

<div class="main">
</div>  
<script type="text/javascript">
$(".title").click(function() {
	   $(this).next(".menu").stop().slideToggle(300);
	  $(this).toggleClass('on').siblings().removeClass('on');
	  $(this).next(".menu").siblings(".menu").slideUp(300); // 1개씩 펼치기
	});
</script>

</body>
</html>
