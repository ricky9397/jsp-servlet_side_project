package memberController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbsController.Action;
import member.MemberDao;
import member.MemberDto;

public class MemberUpdateForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		MemberDao dao = MemberDao.getInstance();
		
		String id = request.getParameter("id");
		
		MemberDto dto = dao.selectById(id);
		
		request.setAttribute("member", dto);
	}

}
