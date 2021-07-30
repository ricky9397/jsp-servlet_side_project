<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OHMYSHOP</title>
<link rel="stylesheet" href="./css/member.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"
	integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
	crossorigin="anonymous">
	
</script>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script src="./js/member.js"></script>
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
		<form action="memberEdit.do" id="join_form" method="post">
			<div class="center_wrap">
				<div>
					<h2>J O I N</h2>
				</div>

				<table>
					<tr class="id_wrap">
						<th>아이디</th>
						<td>
							<div>
								<input type="text" id="userId" name="id" readonly value="${member.id}">
								<div class="msg"></div>
							</div> 
						</td>

					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" id="userPw" name="pw">
							<div class="msg"></div> <span>영문 대소문자/숫자 4자~16자</span></td>
					</tr>
					<tr>
						<th>비밀번호확인</th>
						<td><input type="password" id="userPw2" name="pw2">
							<div class="msg"></div></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" id="userName" name="name" value="${member.name}">
							<div class="msg"></div></td>
					</tr>
					<tr>
						<th>주소</th>
						<td>
							<div class="add_wrap">
								<input type="text" class="add userAdd" id="zip" name="post" readonly value="${member.post}">
								<input type="button" id="btnAdd" name="btnAdd">
							</div> <input type="text" class="add1 userAdd" id="addr1" name="address" readonly value="${member.address}"><span>기본주소</span> 
							<input type="text" class="add2 userAdd" id="addr2" name="addresss" value="${member.addresss}"><span>나머지주소</span>
							<div class="msg"></div>
						</td>
					</tr>
					<tr>
						<th>휴대전화</th>
						<td><select name="phoneNum">
								<option>010</option>
								<option>011</option>
								<option>016</option>
						</select> - <input type="text" class="p_size userPhone" name="phoneNum1">
							- <input type="text" class="p_size userPhone" name="phoneNum2">
							<div class="msg"></div></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" id="userEmail" name="email" value="${member.email}">
							<div class="msg"></div></td>
					</tr>
				</table>
				<div class="s_size">
					<input type="submit" id="goBtn" value="수정">
					<input type="button" value="취소" onclick="history.back(-1)">
				</div>
				<div class="s_size2">
					<a href="memberDelete.do?id=${member.id}">
                    <input type="button" value="회원탈퇴">
					</a>
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