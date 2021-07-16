package joinController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDao;
import member.MemberDto;

@WebServlet("/Join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		join(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		join(request, response);
	}

	public void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 사용자가 전달한 값 db에 한글이 깨지지 않게 하기위함
		request.setCharacterEncoding("UTF-8");
		// 사용자에게 전달할때 깨지지 않게하기위한 것
		response.setContentType("txet/html; charset=UTF-8");
		
		
		MemberDao dao = MemberDao.getInstance();

		String id = request.getParameter("id");
		String pw = null;
		String name = null;
		String address = null;
		String phoneNum = null;
		String email = null;
		
//		if (request.getParameter("id") != null) {
//			id = request.getParameter("id");
//		}
		
		if (request.getParameter("pw") != null) {
			pw = request.getParameter("pw");
		}
		if (request.getParameter("name") != null) {
			name = request.getParameter("name");
		}
		if (request.getParameter("address") != null) {
			address = request.getParameter("address") 
					+ request.getParameter("address1")
					+ request.getParameter("address2");
		}
		if (request.getParameter("phoneNum1") != null && request.getParameter("phoneNum2") != null) {
			phoneNum = request.getParameter("phoneNum")
						+request.getParameter("phoneNum1")
						+ request.getParameter("phoneNum2");
			
		}
		if (request.getParameter("email") != null) {
			email = request.getParameter("email");
		}

		int result = dao.join(new MemberDto(id, pw, name, address, phoneNum, email));
		
		if (result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			
			RequestDispatcher rd = request.getRequestDispatcher("/indexOut.jsp");
			rd.forward(request, response);
		}

		if (result == 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/joinMain.jsp");
			rd.forward(request, response);
		}
		
	}

}
