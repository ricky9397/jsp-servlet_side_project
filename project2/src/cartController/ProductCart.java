package cartController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import product.ProductDao;
import product.ProductDto;

@WebServlet("/cart")
public class ProductCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		cartGo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		cartGo(request, response);
	}
	
	public void cartGo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" 서블릿 시작");
		request.setCharacterEncoding("UTF-8");

		ProductDao dao = ProductDao.getInstance();

		int iCode = Integer.parseInt(request.getParameter("iCode"));
		
//		response.setContentType("text/html;charset=utf-8");
		
		ProductDto dto = dao.selectIcode(iCode);
		
		HttpSession session = request.getSession();
		session.setAttribute("cart", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("/cart.jsp");
		rd.forward(request, response);
	}
}