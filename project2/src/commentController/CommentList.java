package commentController;

import java.io.IOException;
import java.io.PrintWriter;
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
		
		int cBbsNum = Integer.parseInt(request.getParameter("BbsNum"));
		
//		response.getWriter().write(getJSON(cBbsNum));
		
		CommentDao dao = CommentDao.getInstance();
		
		ArrayList<CommentDto> list = dao.getCommentList(cBbsNum);
		
		request.setAttribute("list", list);
		
		System.out.println("게시판 댓글 리스트 서블릿 완료");
		
	}
	
	// 댓글리스트 json함수
//	public String getJSON(int cBbsNum) {		
//		StringBuffer sb = new StringBuffer();
//		sb.append("{\"cmList\":[");
//		CommentDao dao = CommentDao.getInstance();
//		ArrayList<CommentDto> list = dao.getCommentList(cBbsNum);
//		for(int i = 0; i < list.size(); i++) {
//			sb.append("[{\"id\": \""+ list.get(i).getCommentId() +"\"},");
//			sb.append("{\"content\": \""+ list.get(i).getCommentContent() +"\"},");
//			sb.append("{\"date\": \""+ list.get(i).getCommentDate() +"\"}],");
//		}
//		sb.append("]}");
//		return sb.toString();
//	}
	
	
}
