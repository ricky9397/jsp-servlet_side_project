package bbsController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.BbsDao;

public class BbsViewWrite implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("게시글 보여주기용");

//		request.setCharacterEncoding("UTF-8");
//		
//		BbsDao dao = BbsDao.getInstance();
//		
//		HttpSession session = request.getSession();
//		String id = (String) session.getAttribute("id");
//		
//		String bbsTitle = request.getParameter("bbsTitle");
//		String bbsContent = request.getParameter("bbsContent");
//		
//		dao.write(bbsTitle, id, bbsContent);
	}

}
