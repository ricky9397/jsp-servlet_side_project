package bbsPage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Database.DBconn;
import bbs.BbsDao;
import bbs.BbsDto;

public class BbsPageDao {

	// 한 페이지에 표현할 메시지의 개수
	private final int messageCountPerPage = 3;

	private BbsPageDao() {
	}

	private static BbsPageDao service = new BbsPageDao();

	public static BbsPageDao getInstance() {
		return service;
	}

	public BbsPage getBbsPageList(int pageNumber) {

		BbsPage listView = null;

		Connection conn = null;
		BbsDao dao = null;

		try {
			conn = DBconn.getConnection();
			dao = BbsDao.getInstance();

			// 전체 게시물의 개수
			int totalMessageCount = dao.selectAllCount(conn);
			System.out.println("totalCount : " + totalMessageCount);

			// 페이지에 표현할 메시지 객체들 List<Message>
			List<BbsDto> messageList = null;

			// 시작행의 위치값 limit index
			int firstRow = (pageNumber-1)*messageCountPerPage;

			System.out.println(firstRow + messageCountPerPage);
			messageList = dao.getBbsList(conn, firstRow, messageCountPerPage);
			System.out.println("message List : " + messageList);

			listView = new BbsPage(
					messageList, 
					totalMessageCount, 
					pageNumber, 
					messageCountPerPage, 
					firstRow, 
					0);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listView;
	}

}
