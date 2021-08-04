package ProductController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbsController.Action;
import product.ProductDao;

public class ProductDelete implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int iCode = Integer.parseInt(request.getParameter("iCode"));
		ProductDao dao = ProductDao.getInstance();
		dao.productDelete(iCode);
		
	}
	
	
}
