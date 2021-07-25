package commentController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbsController.Action;
import comment.CommentDao;
import comment.CommentDto;

public class CommentList implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("게시판 댓글 리스트 서블릿 시작");
		request.setCharacterEncoding("UTF-8");
		
		int cBbsNum = Integer.parseInt(request.getParameter("num"));
		
		response.getWriter().write(getContentList(cBbsNum));
		
		System.out.println("게시판 댓글 리스트 서블릿 완료");
		
	}
	
	public String getContentList(int cBbsNum) {
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");
		CommentDao dao = CommentDao.getInstance();
		ArrayList<CommentDto> list = dao.getCommentList(cBbsNum);
		for(int i = 0; i < list.size(); i++) {
			result.append("[{\"value\": \"" + list.get(i).getCommentId() + "\"},");
			result.append("{\"value\": \"" + list.get(i).getCommentContent() + "\"},");
			result.append("{\"value\": \"" + list.get(i).getCommentDate() + "\"}]");
			if(i != list.size() -1) result.append(",");
		}
		result.append("]}");
		return result.toString();
	}
	
}
