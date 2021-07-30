<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OHMYSHOP</title>
<!-- css -->
<link rel="stylesheet" href="./css/bbs.css">
<!-- jquery -->
<script src="https://code.jquery.com/jquery-1.12.4.js"
	integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
	crossorigin="anonymous">
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
		<form action="./write.do" method="post">
            <div class="center_wrap">
                <div class="center_font">
                    <h2>Q & A</h2>
                </div>
                
                <div class="qa">
                    <a href="#">공지사항</a>
                    <a href="bbsList.do">Q & A</a>
                </div>
        
                <div class="bbs">
                    <table class="bbs_table">
                        <tr>
                            <th class="bb_size">번호</th>
                            <th class="bb_size2">제목</th>
                            <th class="bb_size">작성자</th>
                            <th class="bb_size">작성일</th>
                            <th class="bb_size">조회수</th>
                        </tr>
                        
                        <!-- jstl for문을 이용하여 사용자가 작성한 게시글들이 db에 저장된 list를 불러와 출력한다. -->
                        <c:forEach items="${Bbslist}" var="list">
                        <tr class="bb_sizes">
                            <th class="bb_size">${list.bbsNum}</th>
                            <th class="bb_size2 bb_ss">
                            <a href="content.do?bbsNum=${list.bbsNum}">${list.bbsTitle}</a>
                            </th>
                            <th class="bb_size">${list.id}</th>
                            <th class="bb_size">${list.bbsDate}</th>
                            <th class="bb_size">${list.bbsHit}</th>
                        </tr>
                        </c:forEach>
                        
                    </table>
                    <div class="butto_write">
                        <input type="submit" value="WRITE" onclick="<c:if test="${id == null}">alert('로그인 하셔야합니다.')</c:if>">
                    </div>
                	</div>
                	<div>
                	
                	<!-- jstl을 사용해 page 숫자를 적용한다. -->
                	<!-- param.p == null인경우에는 1 아닌경우에는 param.p -->
                	<!-- page가 나눈값이 -1을 해줘야 1~10 11~20 나온다 -->
                	<c:set var="page" value="${(param.p == null)?1:param.p}" />
                	<c:set var="startNum" value="${page-(page-1)%10}" />
                	<!-- page 넘길때 쓰는 변수선언 -->
                	<c:set var="lastNum" value="23" />
                    <div class="bbs_page_num1">
                    
                    	<c:if test="${startNum > 1}">
                       		<a href="?p=${startNum-1}"><</a>
                    	</c:if>
                    	<c:if test="${startNum <= 1}">
                        	<a onclick="alert('이전 페이지가 없습니다.')"><</a>
                    	</c:if>
                        
                    	<c:forEach var="i" begin="0" end="9">
                        <a href="?p=${startNum+i}" class="bbs_page_num2">${startNum+i}</a>
                    	</c:forEach>
                    	
                    	<!-- 다음페이지 넘길때 -->
                    	<!-- 0~9니깐 다음페이지인 10을 넣어준다. -->
                    	<c:if test="${startNum+10 < lastNum}">
                        	<a href="?p=${startNum+10}">></a>
                    	</c:if>
                    	<c:if test="${startNum+10 >= lastNum}">
                        	<a onclick="alert('다음 페이지가 없습니다.')">></a>
                    	</c:if>
                    </div>
                    <div class="bbs_serch">
                        <select>
                            <option>제목</option>
                            <option>내용</option>
                            <option>아이디</option>
                        </select>
                        <input type="text"><a href="#">FIND</a>
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