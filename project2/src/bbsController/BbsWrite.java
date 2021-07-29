package bbsController;

import java.io.IOException;
import java.io.PrintWriter;

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
		// 게시글 제목등록이 안되있으면 안된다.
		if(bbsTitle != null && bbsContent != null) {
			BbsDto dto = new BbsDto();
			dto.setBbsNum(dao.getNext() + 1);
			dto.setBbsTitle(bbsTitle);
			dto.setBbsContent(bbsContent);
			dto.setId(id);
			dao.write(dto);
		}
	}
}
