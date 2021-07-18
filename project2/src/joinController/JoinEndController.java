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

		request.setCharacterEncoding("UTF-8");
		response.setContentType("txet/html; charset=UTF-8");
		
		MemberDao dao = MemberDao.getInstance();
		
		PrintWriter out = response.getWriter();
		List list = dao.getMemberList();
		
	}

}
