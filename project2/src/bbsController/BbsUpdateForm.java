package bbsController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.BbsDao;
import bbs.BbsDto;

public class BbsUpdateForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		BbsDao dao = BbsDao.getInstance();

		// 수정 번호를 누른후 수정정보를 가져온다. 
		String bbsNum = request.getParameter("bbsNum");
		
		BbsDto dto = dao.selectByNum(bbsNum);
		
		// update.jsp에 뿌려준다 
		// 수정하기 전 내용들이 글대로 볼수 있다.
		request.setAttribute("update", dto);
		
	}

}
