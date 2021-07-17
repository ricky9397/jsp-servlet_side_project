package loginController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDao;

@WebServlet("/Login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		login(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		login(request, response);
	}

	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login");
		request.setCharacterEncoding("UTF-8");
		
		MemberDao dao = MemberDao.getInstance();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id);
		System.out.println(pw);
		
		int result = dao.login(id, pw);
		
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			RequestDispatcher rd = request.getRequestDispatcher("/indexOut.jsp");
			rd.forward(request, response);
			System.out.println(id);
			System.out.println(pw);
			
		} else if(result == 0){
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
			System.out.println("비밀번호 땡");
			
		} else if(result == -1){
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
			System.out.println("아이디 없음");
			
		} 
	}

}