package ProductController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbsController.Action;
import product.ProductDao;
import product.ProductDto;

public class ProductContent implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		ProductDao dao = ProductDao.getInstance();
		
		int iCode = Integer.parseInt(request.getParameter("iCode"));
		
		ProductDto dto = dao.selectIcode(iCode);
		
		request.setAttribute("ProductContent", dto);
		
	}
	
}
