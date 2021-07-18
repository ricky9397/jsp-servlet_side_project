package bbsController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.BbsDao;
import bbs.BbsDto;

public class BbsMain implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		BbsDao dao = BbsDao.getInstance();
		ArrayList<BbsDto> list = dao.getList();
		
		request.setAttribute("list", list); // 세션에 저장
		
		System.out.println("게시판 글작성이후 리스트 출력 완료");
	}
}
