package bbsController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.BbsDao;
import bbs.BbsDto;

public class BbsList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title_ = request.getParameter("f");
		String bid_ = request.getParameter("q");
		String page_ = request.getParameter("p");
		
		String title = "bbstitle";
		if(title_ != null && !title_.equals("")) {
			title = title_;
		}
		
		String bid = "";
		if(bid_ != null && !bid_.equals("")) {
			bid = bid_;
		}
		
		int page = 1;
		if(page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		
		BbsDao dao = BbsDao.getInstance();

		ArrayList<BbsDto> list = dao.getList(title, bid, page);
		int count = dao.selectAllCount(title, bid);
		request.setAttribute("BbsList", list);
		request.setAttribute("count", count);
	
	}
}
