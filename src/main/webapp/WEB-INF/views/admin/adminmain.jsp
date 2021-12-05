<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("YYYY년 MM월 dd일  HH:mm:ss EEE요일");
%>

<!DOCTYPE html>
<html lang="eg">
<head>
  <title>관리자 페이지</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div align="center">${mem_id}이 접속중 입니다.<%= sf.format(nowTime) %></div>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/adminmain">관리자페이지</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">주문<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">주문관리</a></li>
          <li><a href="#">주문상세</a></li>
        </ul>
      </li>
       <ul class="nav navbar-nav">
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">상품 카테고리<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/lcatelist">대분류 조회</a></li>
          <li><a href="/mcatelist">중분류 조회</a></li>
          <li><a href="/scatelist">소분류 조회</a></li>
          
        </ul>
      </li>
    </ul>
    <ul class="nav navbar-nav">
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">판매자 관리<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/chglist">판매자 신청 목록</a></li>
          <li><a href="/sellerlist">판매자 목록</a></li>
        </ul>
      </li>
    </ul>
      <ul class="nav navbar-nav">
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">공지사항<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/noticelist">공지 목록</a></li>
          <li><a href="/noticeform">공지 등록</a></li>
        </ul>
      </li>
    </ul>
    <li><a href="memberlist">회원 목록</a></li>
     <li><a href="home">Home</a></li>
  </div>
</nav>
</body>
</html>
