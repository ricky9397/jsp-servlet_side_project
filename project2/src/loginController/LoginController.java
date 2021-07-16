package loginController;

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

@WebServlet("/Login")
public class LoginController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		login(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		login(request, response);
	}

	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 사용자가 전달한 값 db에 한글이 깨지지 않게 하기위함
		request.setCharacterEncoding("UTF-8");
		// 사용자에게 전달할때 깨지지 않게하기위한 것
		response.setContentType("txet/html; charset=UTF-8");

		MemberDao dao = MemberDao.getInstance();

		String id = null;
		String pw = null;
		if (request.getParameter("id") != null) {
			id = request.getParameter("id");
		}
		if (request.getParameter("pw") != null) {
			pw = request.getParameter("pw");
		}

		int result = dao.login(id, pw);

		if (result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			RequestDispatcher rd = request.getRequestDispatcher("/indexOut.jsp");
			rd.forward(request, response);
		}
//		} else if (result == 0) {
//			PrintWriter script = response.getWriter();
//			script.println("<script>");
//			script.println("alert('비밀번호가 틀렸습니다.')");
//			script.println("history.back();");
//			script.println("</script>");
//			script.close();
//			return;
//		} else if (result == -1) {
//			PrintWriter script = response.getWriter();
//			script.println("<script>");
//			script.println("alert('존재하지 않는 아이디입니다.')");
//			script.println("history.back();");
//			script.println("</script>");
//			script.close();
//			return;
//		} else if (result == -2) {
//			PrintWriter script = response.getWriter();
//			script.println("<script>");
//			script.println("alert('데이터베이스 오류가 발생했습니다.')");
//			script.println("history.back();");
//			script.println("</script>");
//			script.close();
//			return;
//		}
	}

}
