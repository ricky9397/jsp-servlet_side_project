package joinController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDao;
import member.MemberDto;

@WebServlet("/join")
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
		
		System.out.println("회원가입 시작");
		
		// 사용자가 전달한 값 db에 한글이 깨지지 않게 하기위함
		request.setCharacterEncoding("UTF-8");
		
		MemberDao dao = MemberDao.getInstance();
		
		int idx = 0;
		String id = null;
		String pw = null;
		String name = null;
		int post = 0;
		String address = null;
		String addresss = null;
		String phoneNum = null;
		String email = null;
		
		if(request.getParameter("idx") != null) {
			idx = Integer.parseInt(request.getParameter("idx"));
		}
		if (request.getParameter("id") != null) {
			id = request.getParameter("id");
		}
		if (request.getParameter("pw") != null) {
			pw = request.getParameter("pw");
		}
		if (request.getParameter("name") != null) {
			name = request.getParameter("name");
		}
		if (request.getParameter("post") != null){
			post = Integer.parseInt(request.getParameter("post"));
		}
		if (request.getParameter("address") != null) {
			address = request.getParameter("address");
		}
		if (request.getParameter("addresss") != null) {
			addresss = request.getParameter("addresss");
		}
		if (request.getParameter("phoneNum1") != null && request.getParameter("phoneNum2") != null) {
			phoneNum = request.getParameter("phoneNum")
						+request.getParameter("phoneNum1")
						+ request.getParameter("phoneNum2");
			
		}
		if (request.getParameter("email") != null) {
			email = request.getParameter("email");
		}

		int result = dao.join(new MemberDto(idx, id, pw, name, post, address , addresss, phoneNum, email));
		
		if (result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("email", email);
			RequestDispatcher rd = request.getRequestDispatcher("/joinEnd.jsp");
			rd.forward(request, response);
		}

		if (result == 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/joinMain.jsp");
			rd.forward(request, response);
		}
		
	}

}
