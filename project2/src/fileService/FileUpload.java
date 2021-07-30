package fileService;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bbsController.Action;
import product.ProductDao;
import product.ProductDto;


public class FileUpload implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		ServletContext context = request.getServletContext();
		String realpath = context.getRealPath("/upload");
		System.out.println("realpath: " + realpath);
		
		int maxSize = 10 * 1024 * 1024;
		
		// multipart 객체 생성
		MultipartRequest multi = new MultipartRequest(
				request, realpath, maxSize, "UTF-8", new DefaultFileRenamePolicy()
				);
		System.out.println("M : 파일업로드완료"+multi);
		ProductDao dao = ProductDao.getInstance();
		ProductDto product = new ProductDto();
		product.setiCode(dao.getNext()+1);
		product.setiName(multi.getParameter("iName"));
		product.setiPrice(Integer.parseInt(multi.getParameter("iPrice")));
		product.setCount(Integer.parseInt(multi.getParameter("count")));
		product.setContent1(multi.getParameter("content1"));
		product.setContent2(multi.getParameter("content2"));
		product.setContent3(multi.getParameter("content3"));
		String img = multi.getFilesystemName("photo");
		
		System.out.println("img : " + img);
		product.setiPhoto(img);
		dao.productInsert(product);
		
	}
}
