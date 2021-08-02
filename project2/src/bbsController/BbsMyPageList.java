package bbsController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.BbsDao;
import bbs.BbsDto;

public class BbsMyPageList implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session =  request.getSession();
		session.getAttribute("id");
		
		BbsDao dao = BbsDao.getInstance();
		ArrayList<BbsDto> list = dao.getList("id");
		request.setAttribute("myBbs", list);
		// 아직 안뿌려줌
	}

}
