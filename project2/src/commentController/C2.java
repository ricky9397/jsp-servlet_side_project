package commentController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.CommentDao;
import comment.CommentDto;

@WebServlet("/C2")
public class C2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("게시판 댓글 리스트 서블릿 시작");
		request.setCharacterEncoding("UTF-8");
		
		int cBbsNum = Integer.parseInt(request.getParameter("num"));
		
		response.getWriter().write(getContentList(cBbsNum));
		
		System.out.println("게시판 댓글 리스트 서블릿 완료");
		
		request.setAttribute("num", cBbsNum);
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
		}
		result.append("]}");
		return result.toString();
	}

}
