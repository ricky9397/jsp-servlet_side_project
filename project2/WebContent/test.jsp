<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${cart}" var="cart">
	<h1>
		${cart.iCode} <br>
		${cart.iName} <br>
		${cart.iPrice}
	</h1>
	</c:forEach>
		<h3>${cart}</h3>
		<a href="index.jsp">메인화면</a>
		
</body>
</html>