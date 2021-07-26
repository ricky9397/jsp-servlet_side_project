package commentController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import comment.CommentDao;
import comment.CommentDto;

@WebServlet("/CommentWrite")
public class CommentWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		CommentDao dao = CommentDao.getInstance();

		HttpSession session = request.getSession();
		String commentId = (String) session.getAttribute("id");

		int cBbsNum = Integer.parseInt(request.getParameter("num"));
		String commentContent = request.getParameter("comment");

		if (commentId == null || commentId.equals("") || commentContent == null || commentContent.equals("")) {
			response.getWriter().write("0");
		} else {
			CommentDto dto = new CommentDto();
			dto.setcBbsNum(cBbsNum);
			dto.setCommentId(commentId);
			dto.setCommentContent(commentContent);

			response.setContentType("text/html; charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.write(dao.insertComment(dto));
		}
	}

}
