<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%= request.getContextPath()%>/productInsert.do">
	<h1>상품 등록</h1>
		<table>
			<tr>
				<td><input type="text" name="iName"></td>
				<td><input type="text" name="iPrice"></td>
				<td><input type="text" name="count"></td>
				<td><input type="submit" value="상품등록"></td>
			</tr>
		</table>
	</form>
</body>
</html>