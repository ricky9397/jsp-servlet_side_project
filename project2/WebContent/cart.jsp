<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OHMYSHOP</title>
<link rel="stylesheet" href="./css/basket.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"
        integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous">
        </script>
<script src="./js/basket.js"></script>
<script type="text/javascript">
function confirmDel(){
	var result = confirm('삭제 하시겠습니까?');
	if(result == true){
		alert('삭제되었습니다.');
	} else {
		return false;
	}
}
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
		<form action="order.do" method="post">
            <div id="center_wrap">
                <div class="menu_a">
                    <h3>일반상품</h3>
                </div>
                
                <div>
                    <table class="table_menu">
                        <tr>
                            <th>THUMB</th>
                            <th>PRODUCT</th>
                            <th>PRICE</th>
                            <th>QUANTITY</th>
                            <th>DELIVERY</th>
                            <th>CHARGE</th>
                            <th>TOTL</th>
                            <th>SELECT</th>
                        </tr>
                        
                        <c:if test="${cartList eq null || empty cartList}">
	                        <tr>
	                            <td colspan="9">
	                            	<h3>장바구니 상품이 없습니다.</h3>
	                            </td>
	                        </tr>
	                    </c:if>
	                    
	                    
                        <c:if test="${cartList ne null and not empty cartList}">
                        	<c:forEach items="${cartList}" var="cart">
                        	<input type="hidden" name="iCode" value="${cart.iCode}">
							<input type="hidden" name="iName" value="${cart.iName}">
							<input type="hidden" name="iPrice" value="${cart.iPrice}">
							<input type="hidden" name="photo" value="${cart.photo}">
							<input type="hidden" name="id" value="${id}">
							<input type="hidden" name="count" value="${cart.count}">
                        <tr>
                            <td>
                                <img src="<c:url value="/upload/${cart.photo}"/>" id="img_size">
                            </td>
                            <td>
                                <a href="productContent.do?iCode=${cart.iCode}"><strong>${cart.iName}</strong></a>
                            </td>
                            <td>${cart.iPrice}</td>
                            <td><div>
                                <p>${cart.count}</p>
                            </div>
                            </td>
                            <td>기본배송</td>
                            <td>
                                <p>3.000원</p>조건
                            </td>
                            <td>${cart.iPrice*cart.count}</td>
                            <td>
                                <a href="cartDelete.do?iCode=${cart.iCode}">
                                <input type="button" value="삭제하기" class="button_a" onclick="confirmDel()">
                                </a>
                            </td>
                        </tr>
                        
                        </c:forEach>
	                        <tr>
	                            <td>
	                                <span>[기본배송]</span>
	                            </td>
	                            <td colspan="9" class="order">
	                               	 상품구매금액
	                                <strong>${total}</strong>
	                                +배송비3.000= 합계:
	                                <strong>
	                                    <span>${total+3000}</span>원
	                                </strong>
	                            </td>
	                        </tr>
                        </c:if>
                    </table>
                </div>
                <div class="button_footer">
                    <input type="submit" value="ALL BUY">
                    <a href="index.jsp">
                        <input type="button" value="GO SHOPPING">
                    </a>
                </div>
                <div>
                    <img src="./img/이용안내.png">
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