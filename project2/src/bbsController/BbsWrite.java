package bbsController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.BbsDao;
import bbs.BbsDto;

public class BbsWrite implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		BbsDao dao = BbsDao.getInstance();
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		String bbsTitle = request.getParameter("bbsTitle");
		String bbsContent = request.getParameter("bbsContent");
		
		// 사용자에게 전달받은 값들을 db에 저장하기위한 객체
		BbsDto dto = new BbsDto();
		dto.setBbsNum(dao.getNext() + 1);
		dto.setBbsTitle(bbsTitle);
		dto.setBbsContent(bbsContent);
		dto.setId(id);
		
		dao.write(dto);
		
		System.out.println("게시글 작성완료");
		
	}
}
