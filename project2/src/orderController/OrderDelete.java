package orderController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbsController.Action;
import order.OrderDao;

public class OrderDelete implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int oidx = Integer.parseInt(request.getParameter("oidx"));
		OrderDao dao = OrderDao.getInstance();
		dao.orderDelete(oidx);
	}

}
