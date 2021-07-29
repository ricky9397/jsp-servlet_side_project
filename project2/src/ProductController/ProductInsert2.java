package ProductController;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bbsController.Action;
import product.ProductDao;
import product.ProductDto;

public class ProductInsert2 implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		System.out.println("파일업로드 시작");
		String iName = request.getParameter("iName");
		int iPrice = Integer.parseInt(request.getParameter("iPrice"));
		int count = Integer.parseInt(request.getParameter("count"));
		String iPhoto = request.getParameter("photo");
		String content1 = request.getParameter("content1");
		String content2 = request.getParameter("content2");
		String content3 = request.getParameter("content3");
		
		
		ProductDto product = new ProductDto();
		
		
		File newFile = null;
		// 1. multipart 여부 확인
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (isMultipart) {
			// 2. 파일을 저장할 Factory 객체 생성
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// 3. 요청 처리를 (form 안에 있는 input 들을 분리 ) 위해서 ServletFileUpload 생성
			ServletFileUpload upload = new ServletFileUpload(factory);

			// 4. 사용자 요청을 파싱(분리 : 원하는 형태로 분리 input => FileItem)
			// FileItem -> input 데이터를 저장하고 있는 객체
			try {
				List<FileItem> items = upload.parseRequest(request);

				Iterator<FileItem> itr = items.iterator();

				while (itr.hasNext()) {
					FileItem item = itr.next(); // text, checkbox, hidden, password, file

					// file과 file이외의 폼을 구분
					if (item.isFormField()) {
						// 회원 아이디, 회원 이름, 비밀번호
						String paramName = item.getFieldName();
						if(paramName.equals("iName")) {
							String paramValue = item.getString("utf-8");
							iName = paramValue;
						}

					} else {
						String paramName = item.getFieldName();
						if(paramName.equals("photo")) {
							String userFileName = item.getName();
							String contentType = item.getContentType();
							long fileSize = item.getSize();
						}
						String uploadUri = "/upload";
						String dir = request.getSession().getServletContext().getRealPath(uploadUri);

						File saveDir = new File(dir);

						if (!saveDir.exists()) {
							saveDir.mkdir();
						}

//						String paramName = item.getFieldName();
						if (paramName.equals("photo")) {
							// 파일 이름, 사이즈
							if (item.getName() != null && item.getSize() > 0) {
								// 저장
								newFile = new File(saveDir, item.getName());
								item.write(newFile);
								// DB 에 저장할 파일의 이름
								product.setiPhoto(item.getName());
								System.out.println("파일 저장!!!");
							}
						}
					}

				}

			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		ProductDao dao = ProductDao.getInstance();
		product.setiCode(dao.getNext() + 1);
		product.setiName(iName);
		product.setiPrice(iPrice);
		product.setCount(count);
		product.setiPhoto(iPhoto);
		product.setContent1(content1);
		product.setContent2(content2);
		product.setContent3(content3);
		dao.productInsert(product);
		
		System.out.println(iPhoto);
		
	}
}
