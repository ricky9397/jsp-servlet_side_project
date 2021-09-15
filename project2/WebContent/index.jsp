<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OHMYSHOP</title>
<link rel="stylesheet" href="./css/index.css">
	<!-- jquery -->
	<script src="https://code.jquery.com/jquery-1.12.4.js"
		integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
		crossorigin="anonymous">
	</script>
	<!-- js -->
	<script src="./js/index.js"></script>
	
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>+
    <script>
    $(document).ready(function(){
      $('.slider').bxSlider();
    });
  </script>
</head>

<body>

	<div id="wrap">	
		<!-- 상단 -->
		<div>
			<!-- 로고 -->
			<%@ include file="../frame/header.jsp" %>
			<!-- 로고 끝 -->

			<!-- 메뉴 -->
			<%@ include file="../frame/nav.jsp" %>
			<!-- 메뉴 끝 -->
			
		</div>
		<!-- 상단 끝 -->

		<!-- 센터 -->
		<div class="swiper-container mySwiper1">
			<div class="slider">
				<div class="swiper-slide">
					<img src="./img/main7.png" alt="">
				</div>
				<div class="swiper-slide">
					<img src="./img/main2.png" alt="">
				</div>
				<div class="swiper-slide">
					<img src="./img/메인사진.png" alt="">
				</div>
				<div class="swiper-slide">
					<img src="./img/main6.png" alt="">
				</div>
			</div>
			<div class="swiper-button-next"></div>
			<div class="swiper-button-prev"></div>
		</div>
		<div class="swiper-container mySwiper2">
			<div class="slider">
				<div class="swiper-slide">
					<a href=""> <img src="./img/item1.jpg" alt="">
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
			<%@ include file="../frame/footer.jsp" %>
		</footer>
		<!-- 하단끝 -->
	</div>

</body>

</html>