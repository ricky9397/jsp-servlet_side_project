<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OHMYGOT</title>
<link rel="stylesheet" href="./css/index.css">
<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />
	<!-- jquery -->
	<script src="https://code.jquery.com/jquery-1.12.4.js"
		integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
		crossorigin="anonymous">
	</script>
	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
	<!-- js -->
	<script src="./js/index.js"></script>
</head>

<body>

	<div id="wrap">
		<!-- 상단 -->
		<div>
			<!-- 로고 -->
			<header>
				<h1>
					<a href="index.jsp">OH MY SHOP</a>
				</h1>
			</header>
			<!-- 로고 끝 -->

			<!-- 메뉴 -->
			<nav>
			<c:if test="${id == null}">
				<div>
					<ul class="nav1">
						<li><a href="Login">LOGIN</a></li>
						<li><a href="joincheck">JOIN</a></li>
						<li><a href="#">MY PAGE</a></li>
					</ul>
				</div>
			</c:if>
			<c:if test="${id != null}">
			<div>
				<ul class="nav1">
					<li><a href="LogOut">LOGOUT</a></li>
					<li><a href="#">MY PAGE</a></li>
				</ul>
			</div>
			</c:if>
				<div>
					<ul>
						<li class="serch_li"><a href="#" class="serch"> <img
								src="./img/header_ico_search.png">
						</a></li>
					</ul>
				</div>
				<ul class="nav2">
					<li><a href="index.jsp">MAIN</a></li>
					<li><a href="#">OUTWEAR</a></li>
					<li><a href="#">TOP</a></li>
					<li><a href="#">BOTTOM</a></li>
					<li><a href="Login">COMMUNITY</a></li>
				</ul>
			</nav>
			<!-- 메뉴 끝 -->
		</div>
		<!-- 상단 끝 -->

		<!-- 센터 -->
		<div class="swiper-container mySwiper1">
			<div class="swiper-wrapper">
				<div class="swiper-slide">
					<img src="./img/main1.jpg" alt="">
				</div>
				<div class="swiper-slide">
					<img src="./img/main2.jpg" alt="">
				</div>
				<div class="swiper-slide">
					<img src="./img/main3.jpg" alt="">
				</div>
				<div class="swiper-slide">
					<img src="./img/main4.jpg" alt="">
				</div>
			</div>
			<div class="swiper-button-next"></div>
			<div class="swiper-button-prev"></div>
		</div>
		<div class="swiper-container mySwiper2">
			<div class="swiper-wrapper">
				<div class="swiper-slide">
					<a href=""> <img src="./img/item1.jpg" alt=""> s
					</a>
				</div>
				<div class="swiper-slide">
					<a href=""> <img src="./img/item2.jpg" alt="">
					</a>
				</div>
				<div class="swiper-slide">
					<a href=""> <img src="./img/item3.jpg" alt="">
					</a>
				</div>
				<div class="swiper-slide">
					<a href=""> <img src="./img/item4.jpg" alt="">
					</a>
				</div>
				<div class="swiper-slide">
					<a href="#"> <img src="./img/item5.jpg" alt="">
					</a>
				</div>
			</div>
			<div class="swiper-pagination"></div>
		</div>
		<!-- 센터끝 -->

		<!-- 하단 -->
		<footer>
			<div>
				<h2>카카오톡@OHMYSHOP & Q/A % 070-1234-5678</h2>
				<p>MON-FRI ~ PM 06:00 LUNCH TIME PM 12:00 ~ PM 01:00 SAT.HOLIDAY
					CLOSED</p>
				<P>하나은행 123-123123-1231 예금주:김명호(오마이샵)</P>
			</div>
		</footer>
		<!-- 하단끝 -->
	</div>

</body>

</html>