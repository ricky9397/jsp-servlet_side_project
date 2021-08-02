package bbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Database.DBClose;
import Database.DBconn;

public class BbsDao {

	private BbsDao() {
	}

	static private BbsDao dao = new BbsDao();

	public static BbsDao getInstance() {
		return dao;
	}

	// 게시글번호 늘어나게 하는 함수
	public int getNext() {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select max(bbsnum) from bbs";
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = rs.getInt("max(bbsnum)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
			DBClose.dbClose(rs);
		}
		return result;
	}

	// 글 작성
	public int write(BbsDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into bbs (BBSNUM, BBSTITLE, ID, BBSHIT, BBSCONTENT, PHOTO) values(?, ?, ?, 0, ?, ?)";
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getBbsNum());
			pstmt.setString(2, dto.getBbsTitle());
			pstmt.setString(3, dto.getId());
			pstmt.setString(4, dto.getBbsContent());
			pstmt.setString(5, dto.getPhoto());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
		}
		return 0; // 오류
	}

	// 전체 게시물의 개수
	public int selectAllCount(Connection conn) throws SQLException {
		int totalCount = 0;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from bbs";
		try {
			conn = DBconn.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				totalCount = rs.getInt(1);
			}
		} finally {
			DBClose.dbClose(rs);
			DBClose.dbClose(stmt);
		}
		return totalCount;
	}

	// 페이지 이용한 리스트
	public List<BbsDto> getBbsList(int firstRow, int messageCountPerPage) {

		List<BbsDto> list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from bbs order by bbsdate desc limit ?, ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, firstRow);
			pstmt.setInt(1, messageCountPerPage);

			rs = pstmt.executeQuery();

			list = new ArrayList<BbsDto>();
			while (rs.next()) {
				int bbsNum = rs.getInt("bbsNum");
				String bbsTitle = rs.getString("bbsTitle");
				String id = rs.getString("id");
				String bbsDate = rs.getString("bbsDate");
				int bbsHit = rs.getInt("bbsHit");
				String bbsContent = rs.getString("bbsContent");
				String photo = rs.getString("photo");

				BbsDto bDto = new BbsDto(bbsNum, bbsTitle, id, bbsDate, bbsHit, bbsContent, photo);
				list.add(bDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(pstmt);
			DBClose.dbClose(rs);
		}

		return list;
	}

	// 검색 한것만 전체 리스트
	public ArrayList<BbsDto> getList(String title, String bid) {
		ArrayList<BbsDto> list = new ArrayList<BbsDto>();
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from bbs";

		try {
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int bbsNum = rs.getInt("bbsNum");
				String bbsTitle = rs.getString("bbsTitle");
				String id = rs.getString("id");
				String bbsDate = rs.getString("bbsDate");
				int bbsHit = rs.getInt("bbsHit");
				String bbsContent = rs.getString("bbsContent");
				String photo = rs.getString("photo");

				BbsDto bDto = new BbsDto(bbsNum, bbsTitle, id, bbsDate, bbsHit, bbsContent, photo);
				list.add(bDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
			DBClose.dbClose(rs);
		}
		return list;
	}

	// 전체 리스트
	public ArrayList<BbsDto> getList() {
		ArrayList<BbsDto> list = new ArrayList<BbsDto>();
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from bbs order by bbsnum desc";

		try {
			conn = DBconn.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int bbsNum = rs.getInt("bbsNum");
				String bbsTitle = rs.getString("bbsTitle");
				String id = rs.getString("id");
				String bbsDate = rs.getString("bbsDate");
				int bbsHit = rs.getInt("bbsHit");
				String bbsContent = rs.getString("bbsContent");
				String photo = rs.getString("photo");

				BbsDto bDto = new BbsDto(bbsNum, bbsTitle, id, bbsDate, bbsHit, bbsContent, photo);
				list.add(bDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(stmt);
			DBClose.dbClose(rs);
		}
		return list;
	}

	// 조회수증가
	public int hitUp(String bbsNum) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update bbs set bbshit=bbshit+1 where bbsnum=?";
		try {
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(bbsNum));
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
		}
		return result;
	}

	// content
	public BbsDto selectByNum(String bbsNum) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from bbs where bbsnum=?";
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(bbsNum));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BbsDto bdto = new BbsDto();
				bdto.setBbsNum(rs.getInt("bbsNum"));
				bdto.setBbsTitle(rs.getString("bbsTitle"));
				bdto.setId(rs.getString("id"));
				bdto.setBbsDate(rs.getString("bbsDate"));
				bdto.setBbsHit(rs.getInt("bbsHit"));
				bdto.setBbsContent(rs.getString("bbsContent"));
				bdto.setPhoto(rs.getString("photo"));
				return bdto;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
			DBClose.dbClose(rs);
		}
		return null;
	}

	// 게시글 수정
	public int update(BbsDto dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "update bbs set bbstitle=?, bbscontent=?, photo=? where bbsnum=?";
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBbsTitle());
			pstmt.setString(2, dto.getBbsContent());
			pstmt.setString(3, dto.getPhoto());
			pstmt.setInt(4, dto.getBbsNum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
		}
		return result; // 오류
	}

	// 게시판글 삭제
	public int delete(String num) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from bbs where bbsnum=?";
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));

			return pstmt.executeUpdate(); // 삭제

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
		}
		return 0; // 오류
	}

	// 자기 게시글 검색
	public ArrayList<BbsDto> getList(String userId) {
		ArrayList<BbsDto> list = new ArrayList<BbsDto>();
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from bbs where id=? order by bbsnum";

		try {
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int bbsNum = rs.getInt("bbsNum");
				String bbsTitle = rs.getString("bbsTitle");
				String id = rs.getString("id");
				String bbsDate = rs.getString("bbsDate");
				int bbsHit = rs.getInt("bbsHit");
				String bbsContent = rs.getString("bbsContent");
				String photo = rs.getString("photo");

				BbsDto bDto = new BbsDto(bbsNum, bbsTitle, id, bbsDate, bbsHit, bbsContent, photo);
				list.add(bDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
			DBClose.dbClose(rs);
		}
		return list;
	}

}
