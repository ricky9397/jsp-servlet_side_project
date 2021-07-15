package control;

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

@WebServlet("/join")
public class JoinControl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/joinMain.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MemberDao dao = MemberDao.getInstance();

		String id = null;
		String pw = null;
		String name = null;
		String address = null;
		String phoneNum = null;
		String email = null;

		if (request.getParameter("id") != null) {
			id = request.getParameter("id");
		}
		if (request.getParameter("pw") != null) {
			pw = request.getParameter("pw");
		}
		if (request.getParameter("name") != null) {
			name = request.getParameter("name");
		}
		if (request.getParameter("address") != null) {
			address = request.getParameter("address") + request.getParameter("address1")
					+ request.getParameter("address2");
		}
		if (request.getParameter("phoneNum1") != null) {
			phoneNum = request.getParameter("phoneNum") + request.getParameter("phoneNum1")
					+ request.getParameter("phoneNum2");
		}
		if (request.getParameter("email") != null) {
			email = request.getParameter("email");
		}

		int result = dao.join(new MemberDto(id, pw, name, address, phoneNum, email));

		

		if (result == 1) {
			PrintWriter script = response.getWriter();
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			script.println("<script>");
			script.println("alert('회원가입에 성공했습니다.');");
			script.println("location.href = 'indexOut.jsp';");
			script.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("/joinMain.jsp");
			rd.forward(request, response);
			script.close();
		}

		if (result == -1) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 존재하는 아이디입니다.');");
			script.println("history.back();");
			script.println("</script>");
			script.close();
		}
		
		

	}

}
