<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<style>
body {
  font-family: "Lato", sans-serif;
}

.mypagesidenav {
  width: 250px;
  position: fixed;
  z-index: 1;
  top: 300px;
  left: 10px;
  background: #eee;
  overflow-x: hidden;
  padding: 10px 0;
  text-align: center;
}

.mypagesidenav a {
  padding: 6px 8px 6px 16px;
  text-decoration: none;
  font-size: 25px;
  color: #2196F3;
  display: block;
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
</style>
</head>
<body>
<%@ include file="layout/header.jsp" %>    
<div class="mypagesidenav">
  <h2>마이페이지</h2>
  <a href="order_history">주문관리</a>
  <a href="#services">배송지관리</a>
  <a href="#clients">취소 교환 반품 내역</a>
  <a href="passReCheck">정보수정</a>
  <a href="passReCheck">비밀번호 수정</a>
  <a href="#contact">후기문의QNA</a>
  <a href="sellerChanget">판매자 신청</a>
</div>

<div class="main">
  <h2>Auto Sidebar</h2>
  <p>This sidebar is as tall as its content (the links), and is always shown.</p>
  <p>Scroll down the page to see the result.</p>
  <p>Some text to enable scrolling.. Lorem ipsum dolor sit amet, illum definitiones no quo, maluisset concludaturque et eum, altera fabulas ut quo. Atqui causae gloriatur ius te, id agam omnis evertitur eum. Affert laboramus repudiandae nec et. Inciderint efficiantur his ad. Eum no molestiae voluptatibus.</p>
  <p>Some text to enable scrolling.. Lorem ipsum dolor sit amet, illum definitiones no quo, maluisset concludaturque et eum, altera fabulas ut quo. Atqui causae gloriatur ius te, id agam omnis evertitur eum. Affert laboramus repudiandae nec et. Inciderint efficiantur his ad. Eum no molestiae voluptatibus.</p>
  <p>Some text to enable scrolling.. Lorem ipsum dolor sit amet, illum definitiones no quo, maluisset concludaturque et eum, altera fabulas ut quo. Atqui causae gloriatur ius te, id agam omnis evertitur eum. Affert laboramus repudiandae nec et. Inciderint efficiantur his ad. Eum no molestiae voluptatibus.</p>
  <p>Some text to enable scrolling.. Lorem ipsum dolor sit amet, illum definitiones no quo, maluisset concludaturque et eum, altera fabulas ut quo. Atqui causae gloriatur ius te, id agam omnis evertitur eum. Affert laboramus repudiandae nec et. Inciderint efficiantur his ad. Eum no molestiae voluptatibus.</p>
</div>  

<%@ include file="layout/footer.jsp" %>    
</body>
</html>
