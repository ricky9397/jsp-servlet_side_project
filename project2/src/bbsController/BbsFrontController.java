package bbsController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/bbsFront")
public class BbsFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BbsFrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bbsAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bbsAction(request, response);
	}
	
	public void bbsAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("프론트 컨트롤러 시작");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		String viewPage = null;
		Action action = null;
		
		if(com.equals("/write.do")) {
			viewPage = "write.jsp";
		} else if(com.equals("/bbswrite.do")) {
			action = new BbsWrite();
			action.execute(request, response);
			viewPage = "bbsList.do";
		} else if(com.equals("/bbsList.do")) {
			action = new BbsMain();
			action.execute(request, response);
			viewPage = "bbs.jsp";
		} else if(com.equals("/content.do")) {
			action = new BbsContent();
			action.execute(request, response);
			viewPage = "content.jsp";
		} else if(com.equals("/delete.do")) {
			action = new BbsDelete();
			action.execute(request, response);
			viewPage = "bbsList.do";
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
}
