package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/joincheck")
public class JoinCheckControl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String check1 = null;
		String check2 = null;

		if (request.getParameter("check1") != null) {
			check1 = request.getParameter("check1");
		}

		if (request.getParameter("check2") != null) {
			check2 = request.getParameter("check2");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/joinIndex.jsp");
		rd.forward(request, response);
		
	}

}
