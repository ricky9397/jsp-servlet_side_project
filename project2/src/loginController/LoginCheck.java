package loginController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDao;

@WebServlet("/LoginCheck.do")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		MemberDao dao = MemberDao.getInstance();

		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		response.getWriter().write(dao.login(userId, userPw) + "");

	}

}
