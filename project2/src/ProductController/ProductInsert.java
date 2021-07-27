package ProductController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbsController.Action;
import product.ProductDao;
import product.ProductDto;

public class ProductInsert implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");


		ProductDao dao = ProductDao.getInstance();

		String iName = request.getParameter("iName");
		int iPrice = Integer.parseInt(request.getParameter("iPrice"));
		int count = Integer.parseInt(request.getParameter("count"));
		ProductDto dto = new ProductDto();
		dto.setiCode(dao.getNext() + 1);
		dto.setiName(iName);
		dto.setiPrice(iPrice);
		dto.setCount(count);
		dao.productInsert(dto);
		
	}
}
