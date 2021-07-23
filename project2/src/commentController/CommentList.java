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

public class CommentList implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int cBbsNum = Integer.parseInt(request.getParameter("bbsNum"));
		
		CommentDao dao = CommentDao.getInstance();
		ArrayList<CommentDto> list = dao.getCommentList(cBbsNum);
		
		request.setAttribute("commentLsit", list);
		
		System.out.println("게시판 댓글 리스트 서블릿 완료");
		
	}
	
}
