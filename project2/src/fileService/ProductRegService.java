package fileService;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import product.ProductDao;
import product.ProductDto;

public class ProductRegService {
	
	private ProductRegService() {}
	private static ProductRegService service = new ProductRegService();
	public static ProductRegService getInstance() {
		return service;
	}
	
	public int regProduct(HttpServletRequest request) throws UnsupportedEncodingException {
		int reuslt = 0;
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
		reuslt = dao.productInsert(product);
		
		ProductRegService.getInstance().regProduct(request);
		request.setCharacterEncoding("utf-8");
//		ProductDto product = new ProductDto();
//		ProductDao dao = ProductDao.getInstance();
//		String iName = request.getParameter("iName");
//		int iPrice = Integer.parseInt(request.getParameter("iPrice"));
//		int count = Integer.parseInt(request.getParameter("count"));
//		String iPhoto = request.getParameter("photo");
//		String content1 = request.getParameter("content1");
//		String content2 = request.getParameter("content2");
//		String content3 = request.getParameter("content3");
//		product.setiCode(dao.getNext() + 1);
//		product.setiName(iName);
//		product.setiPrice(iPrice);
//		product.setCount(count);
//		product.setiPhoto(iPhoto);
//		product.setContent1(content1);
//		product.setContent2(content2);
//		product.setContent3(content3);
//		dao.productInsert(product);
		
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
		return reuslt;
	}
}
