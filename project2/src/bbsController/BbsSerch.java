package bbsController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.BbsDao;
import bbs.BbsDto;

public class BbsSerch implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//list?f=title&q=a
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		
		String field = "title";
		if(field_ != null) {
			field = field_;
		}
		
		String query = "";
		if(query_ != null) {
			query = query_;
		}
		
		
		
		BbsDao dao = BbsDao.getInstance();
		ArrayList<BbsDto> list = dao.getList(field, query);
		
//		BbsPage list = BbsPageDao.getInstance().getBbsPage(pageNumber);
		request.setAttribute("Bbslist", list); 

		
		
	}
	
}
