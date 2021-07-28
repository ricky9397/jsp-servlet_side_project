<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav>
	<c:if test="${id == null}">
		<div>
			<ul class="nav1">
				<li><a href="Login">LOGIN</a></li>
				<li><a href="joincheck">JOIN</a></li>
				<li><a href="mypage.jsp">MY PAGE</a></li>
			</ul>
		</div>
	</c:if>
	<c:if test="${id != null}">
		<div>
			<ul class="nav1">
				<li><a href="LogOut">LOGOUT</a></li>
				<li><a href="mypage.jsp">MY PAGE</a></li>
			</ul>
		</div>
	</c:if>
	<div>
		<ul>
			<li class="serch_li"><a href="#" class="serch"> 
				<img src="<c:url value="/img/header_ico_search.png"/>">
			</a></li>
			<li class="serch_li"><a href="cart.jsp" class="serch2"> 
				<img src="<c:url value="/img/header_barket.png"/>">
			</a></li>
		</ul>
	</div>
	<ul class="nav2">
		<li><a href="index.jsp">MAIN</a></li>
		<li><a href="#">OUTWEAR</a></li>
		<li><a href="productList.do">TOP</a></li>
		<li><a href="#">BOTTOM</a></li>
		<li><a href="bbsList.do">COMMUNITY</a></li>
	</ul>
</nav>