package joinController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDao;

@WebServlet("/JoinEnd")
public class JoinEndController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		joinEnd(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		joinEnd(request, response);
	}

	public void joinEnd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 사용자가 전달한 값 db에 한글이 깨지지 않게 하기위함
		request.setCharacterEncoding("UTF-8");
		// 사용자에게 전달할때 깨지지 않게하기위한 것
		response.setContentType("txet/html; charset=UTF-8");
		
		MemberDao dao = MemberDao.getInstance();
		
		PrintWriter out = response.getWriter();
		List list = dao.getMemberList();
		
		for(int i = 0; i<list.size(); i++) {
		}
		
		
		
		
	}

}
