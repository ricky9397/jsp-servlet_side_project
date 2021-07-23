package memberController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbsController.Action;
import member.MemberDao;
import member.MemberDto;

public class MemeberUpdate implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		request.setCharacterEncoding("UTF-8");

		MemberDao dao = MemberDao.getInstance();

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String address = request.getParameter("address") 
						+ request.getParameter("address1")
						+ request.getParameter("address2");
		String phoneNum = request.getParameter("phoneNum") + request.getParameter("phoneNum1")
						+ request.getParameter("phoneNum2");
		String email = request.getParameter("email");
		
		dao.MemberEdit(new MemberDto(id, pw, name, address, phoneNum, email));
		
	}

}
