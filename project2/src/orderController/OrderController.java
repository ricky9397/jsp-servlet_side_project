package orderController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbsController.Action;
import order.OrderDao;
import order.OrderDto;

public class OrderController implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String[] icode = request.getParameterValues("iCode");
		String[] id = request.getParameterValues("id");
		String[] oname = request.getParameterValues("iName");
		String[] oprice = request.getParameterValues("iPrice");
		String[] ophoto = request.getParameterValues("photo");
		String[] count = request.getParameterValues("count");
		OrderDao dao = OrderDao.getInstance();
		List<OrderDto> list = new ArrayList<OrderDto>();
		OrderDto dto = null;
		for (int i = 0; i < icode.length; i++) {
			dto = new OrderDto();
			dto.setIcode(Integer.parseInt(icode[i]));
			dto.setId(id[i]);
			dto.setOname(oname[i]);
			dto.setOprice(Integer.parseInt(oprice[i]));
			dto.setOphoto(ophoto[i]);
			dto.setCount(Integer.parseInt(count[i]));
			list.add(dto);
		}
		dao.orderInsert(list);

		HttpSession session = request.getSession();
		session.removeAttribute("cartList");
	}
}
