<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OHMYSHOP</title>
<link rel="stylesheet" href="./css/product_full.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"
        integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous">
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
		<form action="order.do" method="post">
		<input type="hidden" name="iCode" value="${ProductContent.iCode}">
		<input type="hidden" name="iName" value="${ProductContent.iName}">
		<input type="hidden" name="iPrice" value="${ProductContent.iPrice}">
		<input type="hidden" name="photo" value="${ProductContent.iPhoto}">
		<%-- <input type="hidden" name="count" value="${ProductContent.count}"> --%>
			<div id="center_wrap">
	            <div class="main_img">
	                <img src="<c:url value="/upload/${ProductContent.iPhoto}"/>">
	            </div>
	            <div class="main_content">
	                <div class="main_a">
	                    <h2><b>${ProductContent.iName}</b></h2>
	                </div>
	                <div class="main_a">
	                    <p><b>${ProductContent.iName}</b></p>
	                    <p>-${ProductContent.content1}</p>
	                    <p>-${ProductContent.content2}</p>
	                    <p>-${ProductContent.content3}</p>
	
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
	                    <p class="fonts">[필수]옵션을 선택해주세요.</p>
	                </div>
	                <div class="main_b">
	                    <select class="select_size">
	                        <option>size</option>
	                        <option>free</option>
	                    </select>
	                    <p class="fonts">[필수]옵션을 선택해주세요.</p>
	                </div>
	                <div class="in_number main_b">
                   		<input type="number" value="1" name="count"><p class="fonts">수량 선택</p>
               		</div>
	                <div class="button_size">
	                <a href="cart.do?iCode=${ProductContent.iCode}&iName=${ProductContent.iName}&iPrice=${ProductContent.iPrice}&photo=${ProductContent.iPhoto}&count=${ProductContent.count}">
	                    <input type="button" value="ADD TO CART" id="cartgo">
	                </a>
	                    <input type="submit" value="BUY NOW" onclick="<c:if test="${id == null}">alert('로그인 하셔야합니다.')</c:if>">
	                </div>
	            </div>
	        </div>
		</form>
		<!-- 센터끝 -->


		<!-- 하단 -->
		<footer>
			<%@ include file="../frame/footer.jsp" %>
		</footer>
		<!-- 하단끝 -->
	</div>

</body>

</html>