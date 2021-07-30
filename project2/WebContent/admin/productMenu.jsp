<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OHMYSHOP</title>
<link rel="stylesheet" href="<c:url value="/css/productMenu.css"/>">
<script src="https://code.jquery.com/jquery-1.12.4.js"
        integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous">
</script>
</head>
<body>
	<div id="wrap">
		<!-- 상단 -->
		<div>
            <!-- 로고 -->
            <header>
                <h1><a href="../index/index.html">OH MY SHOP</a></h1>
            </header>
            <!-- 로고 끝 -->
        </div>
		<!-- 상단 끝 -->
		
		<!-- 센터 -->
		<form action="">
            <div id="center_wrap">
                <div class="menu_a">
                    <h1>상품 등록</h1>
                </div>
                <div>
                    <table class="table_menu">
                        <tr>
                            <th><a href="">상품등록</a></th>
                            <th><a href="">상품목록</a></th>
                            <th><a href="#">상품 삭제</a></th>
                        </tr>
                        <tr>
                        </tr>
                    </table>
                </div>
                <div class="logout">
                    <input type="submit" value="관리자 로그아웃">
                </div>
            </div>
        </form>
		<!-- 센터끝 -->
	</div>

</body>

</html>