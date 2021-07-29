package cartController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbsController.Action;
import cart.CartDto;
import product.ProductDao;

public class CartSession implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ProductDao dao = ProductDao.getInstance();
		CartDto data = new CartDto();
		int iCode = Integer.parseInt(request.getParameter("iCode"));
		String iName = request.getParameter("iName");
		int iPrice = Integer.parseInt(request.getParameter("iPrice"));
		int count = Integer.parseInt(request.getParameter("count"));
		String photo = request.getParameter("photo");
		data.setiCode(iCode);
		data.setiName(iName);
		data.setiPrice(iPrice);
		data.setCount(count);
		data.setPhoto(photo);
		
		
		// 장바구니 카드 세션에 저장
		HttpSession session = request.getSession();
		ArrayList<CartDto> list = (ArrayList<CartDto>) session.getAttribute("cartList");
		if(list == null) {
			list = new ArrayList<CartDto>();
			session.setAttribute("cartList", list);
		}
		list.add(data);
		
		
		int total = 0;
		for (int i = 0; i < list.size(); i++) {
			total += list.get(i).getSumPrice();
			request.setAttribute("total", total);
		}
		
	}

}
