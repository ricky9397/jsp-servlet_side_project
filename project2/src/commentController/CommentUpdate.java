package commentController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.CommentDao;
import comment.CommentDto;

@WebServlet("/CommentUpdate")
public class CommentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		CommentDao dao = CommentDao.getInstance();
		int cNum = Integer.parseInt(request.getParameter("cNum"));
		String commentContent = request.getParameter("cContent");
		CommentDto dto = new CommentDto();
		dto.setcNum(cNum);
		dto.setCommentContent(commentContent);
		dao.updateComment(dto);
	}
}
