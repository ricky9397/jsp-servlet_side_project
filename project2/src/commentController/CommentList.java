package commentController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import comment.CommentDao;
import comment.CommentDto;

@WebServlet("/CommentList")
public class CommentList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("게시판 댓글 리스트 서블릿 시작");
		request.setCharacterEncoding("UTF-8");

		int cBbsNum = Integer.parseInt(request.getParameter("bbsNum"));
		System.out.println(cBbsNum);
		CommentDao dao = CommentDao.getInstance();
		ArrayList<CommentDto> list = dao.getCommentList(cBbsNum);

		JSONArray jsonArr = new JSONArray();
		for (CommentDto cDto : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("cBbsNum", cDto.getcBbsNum());
			jsonObject.put("commentId", cDto.getCommentId());
			jsonObject.put("commentDate", cDto.getCommentDate());
			jsonObject.put("commentContent", cDto.getCommentContent());
			jsonArr.add(jsonObject);
			System.out.println(jsonObject.toString());
		};
		

		JSONObject json = new JSONObject();
		json.put("list", jsonArr);
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json.toString());
		System.out.println("서블릿 댓글 리스트 끝");
	}

}
