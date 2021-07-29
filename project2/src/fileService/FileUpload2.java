package fileService;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import product.ProductDao;
import product.ProductDto;

@WebServlet("/FileUpload2")
public class FileUpload2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			fileUpload(request, response);
	}

	public void fileUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ProductDto product = new ProductDto();
		File newFile = null;
		try {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> itr = items.iterator();
			while (itr.hasNext()) {
				FileItem item = itr.next();
				if (item.isFormField()) {
					String paramName = item.getFieldName();
					if(paramName.equals("iName")) {
						product.setiName("utf-8");
					} else if(paramName.equals("content1")) {
						product.setContent1("utf-8");
					} else if(paramName.equals("content2")) {
						product.setContent2("utf-8");
					} else if(paramName.equals("content3")) {
						product.setContent3("utf-8");
					} 
				} else {
					String uploadUri = "upload";
					String dir = request.getSession().getServletContext().getRealPath(uploadUri);
					
					File saveDir = new File(dir);
					if(!saveDir.exists()) {
						saveDir.mkdir();
					}
					
					String paramName = item.getFieldName();
					if(paramName.equals("photo")) {
						if(item.getName() != null && item.getSize() > 0) {
							item.write(new File(saveDir, item.getName()));
							product.setiPhoto(item.getName());
						}
					}
				}
			} // while 끝
		} else {
			throw new Exception("multipart 타입이 아닙니다.");
		}
		
		ProductDao dao = ProductDao.getInstance();
		String iName = request.getParameter("iName");
		System.out.println(iName);
		int iPrice = Integer.parseInt(request.getParameter("iPrice"));
		int count = Integer.parseInt(request.getParameter("count"));
		String iPhoto = request.getParameter("photo");
		String content1 = request.getParameter("content1");
		String content2 = request.getParameter("content2");
		String content3 = request.getParameter("content3");
		product.setiCode(dao.getNext() + 1);
		product.setiName(iName);
		product.setiPrice(iPrice);
		product.setCount(count);
		product.setiPhoto(iPhoto);
		product.setContent1(content1);
		product.setContent2(content2);
		product.setContent3(content3);
		dao.productInsert(product);
		
		RequestDispatcher rd = request.getRequestDispatcher("productTop.jsp");
		rd.forward(request, response);
		
		} catch(SQLException e) {
			e.printStackTrace();
			if(newFile != null && newFile.exists()) {
				newFile.delete();
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
