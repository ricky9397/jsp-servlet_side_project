<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OHMYSHOP</title>
<!-- css -->
<link rel="stylesheet" href="./css/login.css">
<!-- jquery -->
<script src="https://code.jquery.com/jquery-1.12.4.js"
	integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
	crossorigin="anonymous">
	
</script>
<!-- js -->
<script src="./js/login.js"></script>
<script type="text/javascript">
	// 로그인 없는 아이디, 비밀번호 틀렷음 체크 ajax
$(document).ready(function(){
	$('#login_btn').on('click', function(){
		var userId = $('#userId').val();
		var userPw = $('#userPw').val();
		$.ajax({
			type : 'POST',
			url : 'LoginCheck',
			data : {
				userId : userId,
				userPw : userPw
			},
			success : function(data) {
				if($('#userId').val().trim() == '') {
					alert('아이디를 입력해주세요.');
			    } else if($('#userPw').val().trim() == ''){
			    	alert('비밀번호를 입력해주세요.')
			    } else if(data == -1){
			    	alert('아이디가 존재하지 않습니다.')
			    } else if(data == 0){
			    	alert('비밀번호 틀렸습니다.')
			    }
			},
			error:function(e){
				console.log('error'+e);
			}
		})
	});
});	

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
		<div>
			<h2>L O G I N</h2>
		</div>
		<form action="Login" id="login_form" method="post">
			<div>
				<input type="text" placeholder="아이디" id="userId" name="id">
				<div class="msg"></div>
			</div>
			<div>
				<input type="password" placeholder="비밀번호" id="userPw" name="pw">
				<div class="msg"></div>
			</div>
			<div>
				<input type="submit" value="로그인" id="login_btn">
			</div>
			<div class="login_footer">
				<ul>
					<li><a href="idFind.jsp">아이디찾기 </a></li>
					<li><a href="pwFind.jsp">비밀번호 찾기 </a></li>
					<li><a href="joinIndex.jsp">회원가입</a></li>
				</ul>
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