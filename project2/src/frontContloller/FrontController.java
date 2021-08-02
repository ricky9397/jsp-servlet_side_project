package frontContloller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ProductController.ProductContent;
import ProductController.ProductList;
import bbsController.Action;
import bbsController.BbsContent;
import bbsController.BbsDelete;
import bbsController.BbsMain;
import bbsController.BbsSerch;
import bbsController.BbsUpdate;
import bbsController.BbsUpdateForm;
import bbsController.BbsWrite;
import cartController.CartSession;
import cartController.CartSessionDelete;
import fileService.FileUpload;
import memberController.MemberDelet;
import memberController.MemberUpdateForm;
import memberController.MemeberUpdate;
import orderController.OrderController;
import orderController.OrderDelete;
import orderController.OrderList;

@WebServlet("/bbsFront")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		bbsAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		bbsAction(request, response);
	}

	public void bbsAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("프론트 컨트롤러 시작");

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

		String viewPage = null;
		Action action = null;

		if (com.equals("/memberShip.do")) {
			if (id != null) {
				action = new MemberUpdateForm();
				action.execute(request, response);
				viewPage = "memberEdit.jsp";
			} else {
				viewPage = "login.jsp";
			}
		} else if (com.equals("/memberEdit.do")) {
			action = new MemeberUpdate();
			action.execute(request, response);
			viewPage = "mypage.jsp";
		
		} else if (com.equals("/memberDelete.do")){
			action = new MemberDelet();
			action.execute(request, response);
			viewPage = "index.jsp";
		
		} else if (com.equals("/write.do")) {
			if (id == null) {
				viewPage = "login.jsp";
			} else {
				viewPage = "write.jsp";
			}

		} else if (com.equals("/bbswrite.do")) {
			action = new BbsWrite();
			action.execute(request, response);
			viewPage = "bbsList.do";

		} else if (com.equals("/bbsList.do")) {
			action = new BbsMain();
			action.execute(request, response);
			viewPage = "bbs.jsp";

		} else if (com.equals("/bbsSerch.do")) {
			action = new BbsSerch();
			action.execute(request, response);
			viewPage = "bbs.jsp";
		}
		
		else if (com.equals("/content.do")) {
			action = new BbsContent();
			action.execute(request, response);
			viewPage = "content.jsp";

		} else if (com.equals("/delete.do")) {
			action = new BbsDelete();
			action.execute(request, response);
			viewPage = "bbsList.do";

		} else if (com.equals("/update.do")) {
			action = new BbsUpdateForm();
			action.execute(request, response);
			viewPage = "bbs_update.jsp";

		} else if (com.equals("/bbsUpdate.do")) {
			action = new BbsUpdate();
			action.execute(request, response);
			viewPage = "bbsList.do";

		} else if (com.equals("/bbsSerch.do")) {
			action = new BbsSerch();
			action.execute(request, response);
			viewPage = "bbs.jsp";
		}
		
		else if (com.equals("/productInsert.do")) {
			action = new FileUpload();
			action.execute(request, response);
			viewPage = "productList.do";

		} else if (com.equals("/productList.do")) {
			action = new ProductList();
			action.execute(request, response);
			viewPage = "productTop.jsp";
			
		} else if (com.equals("/productContent.do")) {
			action = new ProductContent();
			action.execute(request, response);
			viewPage = "productMain.jsp";
			
		} else if (com.equals("/cart.do")) {
			action = new CartSession();
			action.execute(request, response);
			viewPage = "cart.jsp";
			
		} else if (com.equals("/cartBack.do")) {
			action = new CartSession();
			action.execute(request, response);
			viewPage = "productContent.do";
			
		} else if (com.equals("/cartDelete.do")) {
			action = new CartSessionDelete();
			action.execute(request, response);
			viewPage = "cart.jsp";
			
		} else if (com.equals("/order.do")) {
			if (id != null) {
				action = new OrderController();
				action.execute(request, response);
				viewPage = "order.jsp";
			} else {
				viewPage = "login.jsp";
			}
		
		// 주문 리스트
		} else if (com.equals("/orderList.do")) {
			if (id != null) {
				action = new OrderList();
				action.execute(request, response);
				viewPage = "orderList.jsp";
			} else {
				viewPage = "login.jsp";
			}
		} else if (com.equals("/orderDelete.do")) {
			action = new OrderDelete();
			action.execute(request, response);
			viewPage = "orderList.jsp";
		}


		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}
}
