package commentController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbsController.Action;
import comment.CommentDao;
import comment.CommentDto;

public class CommentWrite implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("UTF-8");
		
		CommentDao dao = CommentDao.getInstance();
		
		HttpSession session = request.getSession();
		String commentId = (String) session.getAttribute("id");
		
		// ajax에서 키값을 가져온다.
		int cBbsNum = Integer.parseInt(request.getParameter("num"));
		String commentContent = request.getParameter("comment");

		CommentDto dto = new CommentDto();
		dto.setcBbsNum(cBbsNum);
		dto.setCommentId(commentId);
		dto.setCommentContent(commentContent);
		
		dao.insertComment(dto);
//		if(result == 1) {
//			return;
//		}
		
		response.getWriter().write(dao.insertComment(dto) + "");
		
		System.out.println("게시판 댓글 작성 완료");

	}
}
