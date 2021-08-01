package bbsController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbsPage.BbsPage;
import bbsPage.BbsPageDao;

public class BbsMain implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String pageNumStr = request.getParameter("page");
		int pageNum = 1;
		if(pageNumStr != null) {
			pageNum = Integer.parseInt(pageNumStr);
		}
		
//		ArrayList<BbsDto> list = dao.getList();
		System.out.println(pageNum);
		BbsPage list = BbsPageDao.getInstance().getBbsPageList(pageNum);
		request.setAttribute("BbsList", list);
		
	}
}
