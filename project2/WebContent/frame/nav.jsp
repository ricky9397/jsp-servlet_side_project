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
	<div>
		<ul class="nav1">
			<c:if test="${id != null}">
				<li><a href="LogOut">LOGOUT</a></li>
				<li><a href="mypage.jsp">MY PAGE</a></li>
			</c:if>
		</ul>
	</div>
	<div>
		<ul>
			<li class="serch_li"><a href="cart.jsp" class="serch2"> 
			<img src="<c:url value="/img/header_barket.png"/>">
			</a></li>
		</ul>
	</div>
	<ul class="nav2">
		<c:set var="adminID" value="admin" />
		<c:if test="${adminID ne id}">
			<li><a href="*.do">MAIN</a></li>
			<li><a href="productList.do">SHOP</a></li>
			<li><a href="bbsList.do">COMMUNITY</a></li>
		</c:if>
		<c:if test="${adminID eq id}">
			<li><a href="<c:url value="/admin/product.jsp"/>">PRODUCT</a></li>
			<li><a href="<c:url value="/productList.do"/>">PRODUCTLIST</a></li>
		</c:if>
	</ul>
</nav>