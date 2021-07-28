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
			url : 'CommentWrite',
			data : {
				id : "${id}",
				num : "${content.bbsNum}",
				comment : $('#cmWrite').val()
			},
			success : function(data){
				location.reload(true);
			},
			error:function(e){
				console.log('error'+e);
			}
		});
	});
	
	 // 댓글 리스트 json리스트 가져옴
	 $.ajax({
		type: "POST",
		url : "CommentList",
		dataType : "json",
		data : {
			bbsNum : "${content.bbsNum}"
		},
		success : function(data){
			var htmlStr = "<table>";
				$.each(data.list, function(key, val){
					htmlStr += "<tr>";
					htmlStr += "	<th style='padding:15px;'>" + val.commentId +"</th>";
					htmlStr += "		<td>"+ val.commentContent ;
					htmlStr += "			<p style='color:#aaa; font-size:5px'>" + val.commentDate ;
					if(val.commentId == '${sessionScope.id}'){
						htmlStr += "				<span>";
						htmlStr += "					<a href='#' style='color:royalblue; padding-left: 3px;'>수정</a>";
						htmlStr += "					<a href='javascript:commentDel("+val.cNum+")' style='color:royalblue; padding-left: 3px;'>삭제</a>";
						htmlStr += "				</span>";
					} else {
						htmlStr += "<td></td>"
					}
					htmlStr += "			</p>";
					htmlStr += "		</td>";
					htmlStr += "	</th>";
					htmlStr += "</tr>";
				})
					htmlStr += "</table>";
					$("#comentList").html(htmlStr);
		},
		error:function(e){
			console.log('error'+e);
		}
	});
	 
	 /* 	$.getJSON("CommentList",
     {bbsNum: $('#bbsNum').val()},
     function(data){
         var htmlStr = "<table>";
         $.each(data.list, function(key, val){
             htmlStr += "<tr>";
             htmlStr += "	<th style='padding:15px;'>" + val.commentId +"</th>";
             htmlStr += "		<td>"+ val.commentContent;
             htmlStr += "			<p style='color:#aaa; font-size:5px'>" + val.commentDate;
             if(val.commentId == '${sessionScope.id}'){
                 htmlStr += "				<span>";
                 htmlStr += "					<a href='#' style='color:royalblue; padding-left: 3px;'>수정</a>";
                 htmlStr += "					<a href='#' style='color:royalblue; padding-left: 3px;'>삭제</a>";
                 htmlStr += "				</span>";
             } else {
                 htmlStr += "<td></td>"
             }
             htmlStr += "			</p>";
             htmlStr += "		</td>";
             htmlStr += "	</th>";
             htmlStr += "</tr>";
         })
             htmlStr += "</table>";
             $("#comentList").html(htmlStr);
    	 }
	) */
	 
});
	
//댓글삭제 ajax 사용
function commentDel(num){
	 $.ajax({
		type: "GET",
		url : "CommentDelete",
		data : {
			cNum : num
			},
		success : function(data){
			console.log('성공');
			location.reload(true);
		}
	 });
 };
	
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
       	<input type="hidden" id="bbsNum" name="bbsNum" value="${content.bbsNum}">
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
						<!-- <table class="comment_size" class="dd">
								<tr class="dd">
									<th class="dd"></th>
									<td class="dd">
										<p class="p_size dd">
											<span> 
												<a href="#" class="p_size2 dd">수정</a> 
												<a href="#" class="p_size2 dd">삭제</a>
											</span>
										</p>
									</td>
								</tr>
						</table> -->
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