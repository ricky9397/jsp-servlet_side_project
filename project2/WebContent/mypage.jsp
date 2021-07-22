<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OHMYGOT</title>
<link rel="stylesheet" href="./css/mypage.css">
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
		<div id="center_wrap">
            <div id="center_a">
                <div class="center_b">
                    <a href="#"><strong>PROFILE</strong> 회원정보</a>
                    <p class="a_size"><a href="">회원이신 고객님의 개인정보를 관리하는 공간입니다.<br>
                    개인정보를 최신 정보로 유지하시면 보다 간편히 쇼핑을 즐기실 수 있습니다.</a></p>
                </div>
    
                <div class="center_b">
                    <a href="#"><strong>ORDER</strong> 주문내역 조회</a>
                    <p class="a_size"><a href="">고객님꼐서 주문하신 상품의 주문내역을 확인하실 수 있습니다.<br>
                        비회원의 경우, 주문하신 상품의 주문내역을 조회하실 수 없습니다.</a></p>
                </div>
                
                <div class="center_b">
                    <a href="#"><strong>MILEAGE</strong> 적립금</a>
                    <p class="a_size"><a href="">적립금은 상품 구매시 사용하실 수 있습니다.<br>
                        적립된 금액은 현금으로 환불되지 않습니다.</a></p>
                </div>
    
                <div class="center_b">
                    <a href="#"><strong>BOARD</strong> 게시물관리</a>
                    <p class="a_size"><a href="">고객님께서 작성하신 게시물을 관리하는 공간입니다.<br>
                    고객님께서 작성하신 글을 한눈에 관리하실 수 있습니다.</a></p>
                </div>
            </div>
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