package commentController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

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

		CommentDto dto = new CommentDto();
		dto.setcBbsNum(cBbsNum);
		dto.setCommentId(commentId);
		dto.setCommentContent(commentContent);
		
//		response.getWriter().write(dao.insertComment(dto));
		
		dao.insertComment(dto);
		
		JSONObject json = new JSONObject();
		PrintWriter pw = response.getWriter();
		pw.println(json);
		
	}
}
