<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib  prefix="spring" uri="http://www.springframework.org/tags" %> 	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>CSS</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="<c:url value='/resources/css/header.css'/>">
</head>
<body>

	<header>
		  <div class="links">
         <c:if test="${member == null}"><a href="login" class="link_text">로그인</a></c:if>
         <c:if test="${member != null}">${member.mem_id}님 안녕하세요.</c:if>
         <c:if test="${member != null}"><a href="/" class="link_text">로그아웃</a></c:if>
         <c:if test="${member != null}"><a href="mypage" class="link_text">마이페이지</a></c:if>
         <c:if test="${member == null}"><a href="/" class="link_text">회원가입</a></c:if>
        <a href="/" class="link_text">공지</a>
      </div>
      <a href="home"><img src="resources/image/logo3.png" class="img_logo"/></a>
      <form>
        <fieldset>
          <legend class="visually-hidden">검색</legend>
          <div class="search_box">
            <input type="text" id= "tags" />
            <button type="button" class="searchBtn" tabindex="2" onClick="location.href='searchlist'">
              <i class="fa fa-search"></i>
            </button>
          </div>
        </fieldset>
      </form>
      <nav>
        <div class="nav_items">
          <ul class="main1">
          <li><a href="home"><span class="glyphicon glyphicon-home"></span>홈</a></li>
            <li><a href="#"> <span class="glyphicon glyphicon-align-justify"></span> 카테고리</a>
            	<ul class="main2">
            		<li><a href="#">대메뉴1</a></li>
            		<li><a href="#">대메뉴2</a>
            			<ul class="main3">
            				<li><a href="#">2단 중메뉴1</a></li>
            				<li><a href="#">2단 중메뉴2</a></li>
            				<li><a href="#">2단 중메뉴3</a>
            					<ul class="main4">
            					<li><a href="#">3단 소메뉴</a></li>
            					<li><a href="#">3단 소메뉴</a></li>
            					<li><a href="#">3단 소메뉴</a></li>
            					<li><a href="#">3단 소메뉴</a></li>
            					</ul>	
            				</li>
            			</ul>
            		</li>
            		<li><a href="#">대메뉴3</a></li>
            	</ul>
            </li>
          </ul>
          <a href="#" class="shopping-cart">
          <span class="glyphicon glyphicon-shopping-cart"></span>
        </a>
        </div>
      </nav>
	</header>


</body>
</html>
