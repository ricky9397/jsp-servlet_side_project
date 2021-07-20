<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <header>
                <h1><a href="../index/index.html">OH MY SHOP</a></h1>
            </header>
            <!-- 로고 끝 -->

            <!-- 메뉴 -->
            <nav>
                <div>
                    <ul class="nav1">
                        <ul class="nav1">
						<li><a href="LogOut">LOGOUT</a></li>
						<li><a href="#">MY PAGE</a></li>
					</ul>
                    </ul>
                </div>
                <div>
                    <ul>
                        <li class="serch_li">
                            <a href="#" class="serch">
                                <img src="../img/header_ico_search.png">
                            </a>
                        </li>
                    </ul>
                </div>
                <ul class="nav2">
                    <li><a href="indexOut.jsp">MAIN</a></li>
					<li><a href="#">OUTWEAR</a></li>
					<li><a href="#">TOP</a></li>
					<li><a href="#">BOTTOM</a></li>
					<li><a href="bbsList.do">COMMUNITY</a></li>
                </ul>
            </nav>
            <!-- 메뉴 끝 -->
        </div>
        <!-- 상단 끝 -->

        
        <!-- 센터 -->
        <form action="./bbsList.do">
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
                        <a href="#" >
                            <input type="button" value="DELETE" class="con_dm">
                        </a>
                        <a href="#" >
                            <input type="button" value="MODIFY" class="con_dm">
                        </a>
                        <div class="button2">
                            <a href="bbsList.do">
                                <input type="button" value="LIST"  class="con_dm con_dm3">
                            </a>
                        </div>
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


    
</body>

</html>