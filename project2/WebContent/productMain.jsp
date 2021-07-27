<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OHMYSHOP</title>
<link rel="stylesheet" href="./css/product_full.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"
        integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous">
        </script>
<script type="text/javascript">

$(document).ready(function(){
	$('#cartgo').on('click', function(){
		$.ajax({
			type : 'POST',
			url : 'cart',
			data : {
				iCode : '${ProductContent.iCode}'
			},
			success : function(data){
				alert('성공');				
			},
		});
	});
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
		<form action="#">
		<input type="hidden" name="iCode" value="${ProductContent.iCode}">
			<div id="center_wrap">
	            <div class="main_img">
	                <img src="./img/옷1.png">
	            </div>
	            <div class="main_content">
	                <div class="main_a">
	                    <h2><b>${ProductContent.iName}</b></h2>
	                </div>
	                <div class="main_a">
	                    <p><b>${ProductContent.iName}</b></p>
	                    <p>-피그먼트 워싱 티셔츠</p>
	                    <p>-오버핏 디자인</p>
	                    <p>-데님 슬랙스등 다양한 하의와 매치 좋음</p>
	
	                    <p><span>FITTING</span></p>
	                    <p>OHMYSHOP[185/76] - charcoal fitting</p>
	                    <p><span>SIZE</span></p>
	                    <p><span>FREE</span></p>
	                </div>
	                <div class="main_a font_sizes">
	                    <h3>${ProductContent.iPrice}원</h3>
	                </div>
	                <div class="main_b">
	                    <select class="select_size">
	                        <option>color</option>
	                        <option>white</option>
	                        <option>black</option>
	                    </select>
	                    <p>[필수]옵션을 선택해주세요.</p>
	                </div>
	                <div class="main_b">
	                    <select class="select_size">
	                        <option>size</option>
	                        <option>free</option>
	                    </select>
	                    <p>[필수]옵션을 선택해주세요.</p>
	                </div>
	                <div class="button_size">
	                <a href="#">
	                    <input type="button" value="BUY NOW">
	                </a>
	                    <input type="button" value="ADD TO CART" id="cartgo">
	                </div>
	            </div>
	        </div>
		</form>
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