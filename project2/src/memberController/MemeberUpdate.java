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
		int idx = 0;
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		int post = Integer.parseInt(request.getParameter("post"));
		String address = request.getParameter("address");
		String addresss = request.getParameter("addresss");
		String phoneNum = request.getParameter("phoneNum") 
						+ request.getParameter("phoneNum1")
						+ request.getParameter("phoneNum2");
		String email = request.getParameter("email");
		
		dao.MemberEdit(new MemberDto(idx, id, pw, name, post, address, addresss, phoneNum, email));
		
	}

}
