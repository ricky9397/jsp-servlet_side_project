<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OHMYSHOP</title>
<link rel="stylesheet" href="./css/content_view.css">

<!-- jquery -->
<script src="https://code.jquery.com/jquery-1.12.4.js"
        integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous">
        </script>
<!-- js -->
<script src="./js/content_view.js"></script>

<!-- type 넣어주는게 브라우져 생각했을때 더안정적 -->
<script type="text/javascript">
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
		
	// 댓글 ajax
	$('#comment_btn').on('click', function(){
		$.ajax({
			type : 'POST',
			url : 'commentWirte.do?bbsNum=${content.bbsNum}',
			data : {
				id : "${id}",
				num : "${content.bbsNum}",
				comment : $('#cmWrite').val()
			},
			success : function(data){
				console.log('댓글 성공');
			}
		});
	});
		
	function showComent(type){
		$.ajax({
			type: "POST",
			url : "commentList.do",
			data : {
				num : "${content.bbsNum}"
			},
			beforeSend:function() {
                console.log("읽어오기 시작 전...");
            },
            complete:function() {
                console.log("읽어오기 완료 후...");
            },
            success : function(data){
				console.log('리스트 출력완료');
				if(data == "") return;
				var pased = JSON.parse(data);
				var result = parsed.result;
				for(var i = 0; i < result.length; i++){
					addList(result[i][0].value, result[i][1].value, result[i][2].value);
				}
				
			}
		});
	};
	
	function addList(commentId, commentContent, commentDate){
		$('#comentList').append('<table class="comment_size">'+ 
								'<tbody>' +
								'<tr>' +
								'<th>'+ commentId +'</th>' +
								'<td>' + commentContent +
								'<p class="p_size">'+ commentDate +
								'<span>' +
								'<a href="#" class="p_size2">수정</a>' +
								'<a href="#" class="p_size2">삭제</a>' +
								'</span>' +
								'</p>' +
								'</td>' +
								'</tr>' +
								'</tbody>' +
								'</table>');
	};
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
        <input type="hidden" name="id" value="${id}">
       	<input type="hidden" name="bbsNum" value="${content.bbsNum}">
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
                    <%-- <input type="text" name="cBbsNum" value="${num.cBbsNum}"> --%>
                    <!-- 댓글 리스트 -->
                    <div id="comentList">
						<%-- <table class="comment_size">
							<c:forEach items="${commentList}" var="clist">
							<tbody>
									<tr>
										<th>${clist.commentId}</th>
										<td>${clist.commentContent}
											<p class="p_size">${clist.commentDate}
												<span> 
													<a href="#" class="p_size2">수정</a> 
													<a href="#" class="p_size2">삭제</a>
												</span>
											</p>
										</td>
									</tr>
								
							</tbody>
							</c:forEach>
						</table> --%>
					</div>
					<!-- 댓글 리스트 끝 -->
					
					<!-- 댓글쓰기 -->
					<div class="content_footer">
						<table>
							<tr>
								<th><h3>Comment</h3></th>
							</tr>
							<tr>
								<th>
								<textarea name="commentContent" id="cmWrite"></textarea>
									<div class="count_size">
										문자 : <span id="count">0</span>
									</div> 
									<input type="button" value="댓글" id="comment_btn" onclick="<c:if test="${id == null}">alert('로그인 하셔야합니다.')</c:if>">
								</th>
							</tr>
						</table>
					</div>
                    <!-- 댓글 끝 -->
                    
                </div>
            </div>
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