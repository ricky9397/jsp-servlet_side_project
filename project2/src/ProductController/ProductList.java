package ProductController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbsController.Action;
import product.ProductDao;
import product.ProductDto;

public class ProductList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String category = request.getParameter("category");
		System.out.println(category);
		ProductDao dao = ProductDao.getInstance();
		
		
		ArrayList<ProductDto> productList = dao.getProductList();
		request.setAttribute("productList", productList);
	}
	
}
