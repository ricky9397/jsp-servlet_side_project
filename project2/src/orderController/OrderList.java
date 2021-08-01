package orderController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbsController.Action;
import order.OrderDao;
import order.OrderDto;

public class OrderList implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		OrderDao dao = OrderDao.getInstance();
		HttpSession session  = request.getSession();
		String id = (String) session.getAttribute("id");
		ArrayList<OrderDto> list = dao.getOrderList(id);
		request.setAttribute("orders", list);
		
		int total = 0;
		for (int i = 0; i < list.size(); i++) {
			total += list.get(i).getSumPrice();
			request.setAttribute("total", total);
		}
		
		
	}
}
