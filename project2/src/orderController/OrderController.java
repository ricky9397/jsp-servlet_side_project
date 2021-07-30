package orderController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbsController.Action;
import order.OrderDao;
import order.OrderDto;

public class OrderController implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int icode = Integer.parseInt(request.getParameter("iCode"));
		System.out.println(icode);
		String id = request.getParameter("id");
		System.out.println(id);
		String oname = request.getParameter("iName");
		System.out.println(oname);
		int oprice = Integer.parseInt(request.getParameter("iPrice"));
		System.out.println(oprice);
		String ophoto = request.getParameter("photo");
		System.out.println(ophoto);
		int count = Integer.parseInt(request.getParameter("count"));
		System.out.println(count);
		OrderDao dao = OrderDao.getInstance();
		OrderDto dto = new OrderDto();
		dto.setIcode(icode);
		dto.setId(id);
		dto.setOname(oname);
		dto.setOprice(oprice);
		dto.setOphoto(ophoto);
		dto.setCount(count);
		dao.orderInsert(dto);
	}
}
