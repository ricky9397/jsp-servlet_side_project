package bbsController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.BbsDao;
import bbs.BbsDto;

public class BbsContent implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("글상세보기 시작2");
		request.setCharacterEncoding("UTF-8");

		
		BbsDao dao = BbsDao.getInstance();
		
		int bbsNum = Integer.parseInt(request.getParameter("bbsNum"));
		
		
		BbsDto bbs = dao.getContent(bbsNum);
		
		
		request.setAttribute("content", bbs);
		
	}
}
