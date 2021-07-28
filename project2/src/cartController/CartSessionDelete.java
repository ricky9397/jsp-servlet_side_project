package cartController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbsController.Action;
import cart.CartDto;

public class CartSessionDelete implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int iCode = Integer.parseInt(request.getParameter("iCode"));
		System.out.println(iCode);
		
		HttpSession session = request.getSession();
		ArrayList<CartDto> list = (ArrayList<CartDto>) session.getAttribute("cartList");
		if(list != null) {
			for (int i = 0; i < list.size(); i++) {
				if(iCode == list.get(i).getiCode()) {
					list.remove(i);
				} 
			} 
		}
		session.setAttribute("cartDel", list);
		
	}
}
