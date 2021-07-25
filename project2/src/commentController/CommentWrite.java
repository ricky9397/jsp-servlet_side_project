package commentController;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		int cBbsNum = Integer.parseInt(request.getParameter("num"));
		String commentContent = request.getParameter("comment");

		request.setAttribute("num", cBbsNum);
		CommentDto dto = new CommentDto();
		dto.setcBbsNum(cBbsNum);
		dto.setCommentId(commentId);
		dto.setCommentContent(commentContent);
		
		PrintWriter pw = response.getWriter();
		pw.write(dao.insertComment(dto));
		
		System.out.println("댓글 : " + pw);
		
		
		
	}
}
