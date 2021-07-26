package commentController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.CommentDao;

@WebServlet("/CommentDelete")
public class CommentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블릿 댓글삭제 시작");
		request.setCharacterEncoding("UTF-8");
		
		CommentDao dao = CommentDao.getInstance();
		
		int cNum = Integer.parseInt(request.getParameter("cNum"));
		dao.deleteComment(cNum);
		
		System.out.println("댓글 삭제 끝");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}
	

}
