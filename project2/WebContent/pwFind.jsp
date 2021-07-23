<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OHMYSHOP</title>
<link rel="stylesheet" href="./css/pw_find.css">
<!-- jquery -->
<script src="https://code.jquery.com/jquery-1.12.4.js"
	integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
	crossorigin="anonymous">
	
</script>
<!-- js -->
<script src="./js/pw_find.js"></script>
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
		<div>
			<h2>비밀번호 찾기</h2>
		</div>
		<form action="" id="pwFind">
			<div>
				<table class="id_find">
					<tr>
						<th>아이디</th>
						<td class="id-find_check"><input type="text" id="userid"
							name="pw"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td class="id-find_check"><input type="text" id="userName"
							name="name"></td>
					</tr>
					<tr>
						<th>이메일로 찾기</th>
						<td class="id-find_check"><input type="text" id="userEmail"
							name="email"></td>
					</tr>
				</table>
				<div class="submit_check">
					<input type="submit" value="확인">
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