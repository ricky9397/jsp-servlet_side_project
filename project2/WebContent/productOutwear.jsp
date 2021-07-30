<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OHMYSHOP</title>
<link rel="stylesheet" href="./css/top.css">
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
		<div class="top_main">
            <img src="./img/top_main.png">
        </div>
        <div class="center_a">
        <c:forEach items="${productList}" var="list">
            <div class="center_b">
                <ul>
                    <li>
                        <a href="productContent.do?iCode=${list.iCode}">
                            <img src="<c:url value="/upload/${list.iPhoto}"/>">
                        </a>
                    </li>
                    <li>
                        <a href="productContent.do?iCode=${list.iCode}">
                            <strong><span class="span_center">${list.iName}</span></strong>
                        </a>
                    </li>
                    <li><span class="text_in">${list.iPrice}</span></li>
                    <li><span>(3color)</span></li>
                </ul>
            </div>
        </c:forEach>
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