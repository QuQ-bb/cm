<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자 전환 상세 정보</title>
</head>
<body>
<div class="chgdetail" style ="width:500px; margin-left:10px; margin-top: 10px;">
	<table class="table">
		<tr>
				<td>판매자 번호</td>
				<td>${SellerVO.sel_num}</td>
		</tr>
		<tr>
				<td>회원 번호</td>
				<td>${SellerVO.mem_num}</td>
		</tr>
		<tr>
				<td>사업자번호</td>
				<td>${SellerVO.sel_bnum}</td>
		</tr>
		<tr>
				<td>상호명</td>
				<td>${SellerVO.sel_name}</td>
		</tr>
		<tr>
				<td>대표명</td>
				<td>${SellerVO.sel_ceo}</td>
		</tr>
		<tr>
				<td>통신판매업번호</td>
				<td>${SellerVO.sel_mobnum}</td>
		</tr>
		<tr>
				<td>사업장 우편번호</td>
				<td>${SellerVO.sel_post}</td>
		</tr>
		<tr>
				<td>사업장 소재지</td>
				<td>${SellerVO.sel_add}</td>
		</tr>
		<tr>
				<td>사업장 연락처</td>
				<td>${SellerVO.sel_tel}</td>
		</tr>
		<tr>
				<td>정산 은행</td>
				<td>${SellerVO.sel_bank}</td>
		</tr>
		<tr>
				<td>정산 예금주</td>
				<td>${SellerVO.sel_accholder}</td>
		</tr>
		<tr>
				<td>정산 계좌</td>
				<td>${SellerVO.sel_acc}</td>
		</tr>
		<tr>
				<td>정지여부</td>
				<td>${SellerVO.sel_yn}</td>
		</tr>
		<tr>
				<td>filename?</td>
				<td>${SellerVO.seling_filename}</td>
		</tr>
		
	</table>
</div>
</body>
</html>