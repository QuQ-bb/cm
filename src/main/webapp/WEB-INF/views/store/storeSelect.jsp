<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CM StoreSelect</title>
<c:import url="../template/boot.jsp" />
<link href="${pageContext.request.contextPath}/resources/css/reset.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/store/storeSelect.css" rel="stylesheet"></head>
<body>
	<div id="wrap">
		<div id="container">
			<div id="header"></div>
			<div id="main">
				<div id="content" style="opacity: 1;">
					<div class="section_view">
						<div id="shareLayer">
							<div class="layer_share">
								<div class="inner_layersns">
									<h3 class="screen_out">SNS 공유하기</h3>
									<ul class="list_share">
										<li>
											<a class="btn btn_fb">
												<img alt="페이스북" src="${pageContext.request.contextPath}/resources/images/storeSelect/ico_facebook.webp">
												<span class="txt">공유하기</span>
											</a>
										</li>
										<li>
											<a class="btn btn_tw">
												<img alt="트위터" src="${pageContext.request.contextPath}/resources/images/storeSelect/ico_twitter.webp">
												<span class="txt">트윗하기</span>
											</a>
										</li>
										<li class="btn_url">
											<input type="text" class="inp" value readonly="readonly">
											<a class="btn_copy off" href="#none">
												URL 복사
												<img alt="" src="">
											</a>
										</li>
									</ul>
								</div>
							</div>
						</div>
						<div id="sectionView">
							<div class="inner_view">
								<div class="thumb" style="background: url('${pageContext.request.contextPath}/resources/images/storeList/EfzUDn3VoAE3cj0.png') center center no-repeat;"></div>
								<p class="goods_name">
									<span class="btn_share">
										<button id="btnShare">공유하기</button>
									</span>
									<strong class="name">와인병으로 나팔 부는 모그리</strong>
									<span class="short_desc">솔솔 풍기는 와인의 향</span>
								</p>
								<p class="goods_price">
									<span class="position">
										<span class="dc">
											<span class="dc_price">
												5490
												<span class="won">원</span>
											</span>
										</span>
									</span>
								</p>
								<div class="goods_info">
									<dl class="list fst">
										<dt class="tit">판매단위</dt>
										<dd class="desc">1개</dd>
									</dl>
									<dl class="list">
										<dt class="tit">배송구분</dt>
										<dd class="desc">택배배송</dd>
									</dl>
									<dl class="list">
										<dt class="tit">판매자</dt>
										<dd class="desc">모그리</dd>
									</dl>
									<dl class="list">
										<dt class="tit">택배사</dt>
										<dd class="desc">CJ 대한통운</dd>
									</dl>
									<dl class="list">
										<dt class="tit">색상</dt>
										<dd class="desc">
											<div class="select select1">
												<div class="text text1">선택</div>
												<ul class="option-list">
													<li class="option option1">레드</li>
													<li class="option option1">블랙</li>
													<li class="option option1">아이보리</li>
												</ul>
											</div>
											<script type="text/javascript">
												// active가 추가되었을 경우에만 option-list가 보이도록
												// active 클래스 추가/제거 이벤트 함수
												$('.select1').click(function () {
													$(this).toggleClass("active");
												});
												
												// option 태그 클릭 시, 선택한 값으로 변경 이벤트 함수
												$('.option1').click(function () {
													$(".text1").html($(this).html());
												});
											</script>
										</dd>
									</dl>
									<dl class="list">
										<dt class="tit">사이즈</dt>
										<dd class="desc">
											<div class="select select2">
												<div class="text text2">선택</div>
												<ul class="option-list">
													<li class="option option2">L</li>
													<li class="option option2">M</li>
													<li class="option option2">S</li>
												</ul>
											</div>
											<script type="text/javascript">
												// active가 추가되었을 경우에만 option-list가 보이도록
												// active 클래스 추가/제거 이벤트 함수
												$('.select2').click(function () {
													$(this).toggleClass("active");
												});
												
												// option 태그 클릭 시, 선택한 값으로 변경 이벤트 함수
												$('.option2').click(function () {
													$(".text2").html($(this).html());
												});
											</script>
										</dd>
									</dl>
								</div>
							</div>
						</div>
					</div>
					<div class="layout-wrapper goods-view-area">
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>