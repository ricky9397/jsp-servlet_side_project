package bbsController;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bbs.BbsDao;
import bbs.BbsDto;

public class BbsUpdate implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		ServletContext context = request.getServletContext();
		String realpath = context.getRealPath("/upload");
		System.out.println("realpath: " + realpath);

		int maxSize = 10 * 1024 * 1024;

		// multipart 객체 생성
		MultipartRequest multi = new MultipartRequest(request, realpath, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());
		System.out.println("M : 파일업로드완료" + multi);
		BbsDao dao = BbsDao.getInstance();

		BbsDto dto = new BbsDto();
		dto.setBbsNum(Integer.parseInt(multi.getParameter("bbsNum")));
		dto.setBbsTitle(multi.getParameter("bbsTitle"));
		dto.setBbsContent(multi.getParameter("bbsContent"));
		String img = multi.getFilesystemName("photo");
		System.out.println("img : " + img);
		dto.setPhoto(img);
		dao.update(dto);
	}

}
