package commentController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import bbsController.Action;
import comment.CommentDao;
import comment.CommentDto;

public class CommentLists implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("게시판 댓글 리스트 서블릿 시작");
		request.setCharacterEncoding("UTF-8");
		int cBbsNum = Integer.parseInt(request.getParameter("num"));
		
		CommentDao dao = CommentDao.getInstance();
		
		ArrayList<CommentDto> list = dao.getCommentList(cBbsNum);

		JSONArray json = new JSONArray();
		json.add(list);
		PrintWriter pw = response.getWriter();
		pw.println(json);
		
		System.out.println("게시판 댓글 리스트 서블릿 완료");

	}

}
