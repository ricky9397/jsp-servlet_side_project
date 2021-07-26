$(document).ready(function () {
    $('textarea').keyup(function () {

        var cnt = $(this).val().length;
        var remain = 150 - cnt;

        console.log(cnt, remain);

        if (remain < 0) {
            /* 150자 이상되면 뒤에 글자를 짤라줘서 더이상 들어가지 않게 해준다. */
            alert('소개서는 150자까지 작성이 가능합니다.');
            var str = $(this).val().substr(0, 300);
            $(this).val(str);
            $('#count').text('300');
            return false;
        }
        $('#count').text(cnt);
    });
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