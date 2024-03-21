<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약내역 - 여기 어떤데</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/reservePage.css">
</head>

<body>
	<%@include file="../common/menubar.jsp" %>
	<main>
	<%@include file="../common/sidebar.jsp" %>
	<section id="mainSection">
		<div class="item">
			<img src="" alt="reserveImg">
			<div class="item_name">
				<span class="reserveDate">2024-03-07 ~ 2024-03-08</span>
				<span class="reserveName">노보텍 앰배서더 동대문호텔</span>
				<span class="reserveAddress">중구 동대문 역사문화공원</span>
			</div>
			<div class="item_price"><button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#reserveCancel">예약취소</button></div>
		</div>
		<div class="item">
			<img src="" alt="reserveImg">
			<div class="item_name">
				<span class="reserveDate">2024-03-07 ~ 2024-03-08</span>
				<span class="reserveName">노보텍 앰배서더 동대문호텔</span>
				<span class="reserveAddress">중구 동대문 역사문화공원</span>
			</div>
			<div class="item_price"><button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#review">리뷰</button></div>
		</div>
	</section>
	</main>
</body>
</html>