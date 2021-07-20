package bbsController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.BbsDao;
import bbs.BbsDto;

public class BbsUpdate implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		BbsDao dao = BbsDao.getInstance();
		
		String bbsNum = request.getParameter("bbsNum");
		String bbsTitle = request.getParameter("bbsTitle");
		String bbsContent = request.getParameter("bbsContent");

		System.out.println("에러3");
		
		dao.update(bbsNum, bbsContent, bbsTitle);
		
		request.setAttribute("content", bbsNum);
		System.out.println("에러4");

		
		System.out.println("게시글 수정 완료");
		
	}
	
}
