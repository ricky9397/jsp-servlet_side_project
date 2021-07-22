<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OHMYGOT</title>
    <link rel="stylesheet" href="./css/content_view.css">

    <!-- jquery -->
    <script src="https://code.jquery.com/jquery-1.12.4.js"
        integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous">
        </script>
    <!-- js -->
    <script src="./js/content_view.js"></script>
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
        <form action="./bbsList.do">
        	<input type="hidden" name="bbsNum" value="${pram.bbsNum}">
            <div class="center_wrap">
                <div class="center_font">
                    <h2>Q & A</h2>
                </div>
                <div class="qa">
                    <a href="#">공지사항</a>
                    <a href="bbsList.do">Q & A</a>
                </div>
                <div class="content_view_wrap">
                    <table>
                        <tr>
                            <th>제목</th>
                            <td>${content.bbsTitle}</td>
                        </tr>
                        <tr>
                            <th>작성자</th>
                            <td>${content.id} <p class="con_p">${content.bbsDate}</p><span>${content.bbsHit}</span></td>
                        </tr>
                    </table> 
                    <div class="content_m">
                        <p>${content.bbsContent}</p>
                    </div>
                    
                    
                    
                    <div class="button1">
                    <!-- 접속자가 작성한글이면 삭제,수정가능 -->
                    <c:if test="${id != null && id == content.id}">
                        <a href="delete.do?bbsNum=${content.bbsNum}" id="delete">
                            <input type="button" value="DELETE" class="con_dm">
                       </a>
                        <a href="update.do?bbsNum=${content.bbsNum}">
                            <input type="button" value="MODIFY" class="con_dm">
                        </a>
                    </c:if>
                        <a href="bbsList.do">
                                <input type="button" value="LIST"  class="con_dm con_dm3">
                        </a>
                    </div> 
                    
                    <div class="content_footer">
                        <table>
                            <tr>
                                <th><h3>Comment</h3></th>
                            </tr>
                            <tr>
                                <th >
                                    <textarea ></textarea>
                                    <div class="count_size">
                                     	   문자 : <span id="count">0</span>
                                    </div>
                                    <input type="submit" value="댓글">
                                </th>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </form>
        <!-- 센터끝 -->


        <!-- 하단 -->
        <footer>
            <div>
                <h2>카카오톡@OHMYSHOP & Q/A % 070-1234-5678</h2>
                <p>MON-FRI ~ PM 06:00 LUNCH TIME PM 12:00 ~ PM 01:00 SAT.HOLIDAY CLOSED</p>
                <P>하나은행 123-123123-1231 예금주:김명호(오마이샵)</P>
            </div>
        </footer>
        <!-- 하단끝 -->
    </div>
    
<script>

/* 삭제 여부 물어보기~ */
$(document).ready(function(){
	
	$("#delete").click(function(){
		var result = confirm('삭제 하시겠습니까?');
		if(result == true){
			alert('삭제되었습니다.');
		} else {
			return false;
		}
	});
});
</script>

</body>

</html>