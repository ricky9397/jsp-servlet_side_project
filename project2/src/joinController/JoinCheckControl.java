package joinController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/joincheck.do")
public class JoinCheckControl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] check = request.getParameterValues("check");
		
		RequestDispatcher rd = request.getRequestDispatcher("/joinIndex.jsp");
		rd.forward(request, response);
		
	}

}
