<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OHMYGOT</title>
    <!-- css -->
    <link rel="stylesheet" href="./css/join_end.css">
    <!-- jquery -->
    <script src="https://code.jquery.com/jquery-1.12.4.js"
        integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous">
    </script>
    <!-- js -->
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
        <form action="indexOut.jsp" id="join_end_form">
            <h2 id="h2">회원 가입 완료</h2>
            <h3>OH MY SHOP</h3>
            <h4>회원가입이 완료 되었습니다.</h4>

            <div>
                <table id="end_table">
                    <tr class="table1">
                        <th colspan="2">저희 쇼핑몰을 이용해 주셔서 감사합니다.</th>
                    </tr>
                    <tr class="table2">
                        <th class="table_size"><img src="./img/사진첩.png"></th>
                        <td>아이디 <span class="s_s"><%= session.getAttribute("id") %></span></td>
                        <td>이름 <span class="s_s ss"><%= session.getAttribute("name") %></span></td>
                        <td>이메일 <span class="s_s"><%= session.getAttribute("email") %></span></td>
                    </tr>
                </table>
            </div>
            <div>
                <input type="submit" value="메인으로 이동" id="sub">
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