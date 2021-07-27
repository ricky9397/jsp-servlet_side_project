package cart;

import java.io.IOException;
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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		CartDao dao = CartDao.getInstance();

		int iCode = Integer.parseInt(request.getParameter("iCode"));
		
		response.setContentType("text/html;charset=utf-8");
		
		CartDto dto = dao.selectIcode(iCode);
		
		HttpSession session = request.getSession();
		session.setAttribute("cart", dto);
		
	}

}
