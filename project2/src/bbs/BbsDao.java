package bbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.DBClose;
import Database.DBconn;

public class BbsDao {
	
	private BbsDao() {}
	static private BbsDao dao = new BbsDao();
	public static BbsDao getInstance() { return dao; }
	
	// 시간 함수
//	public String getDate() {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			String sql = "SELECT SYSDATE FROM DUAL";
//			conn = DBconn.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				return rs.getString(1);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBClose.dbClose(conn);
//			DBClose.dbClose(pstmt);
//			DBClose.dbClose(rs);
//		}
//		return ""; // 데이터베이스 오류
//	}
	
	// 게시글번호 늘어나게 하는 함수
	public int getNext() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT bbsnum from bbs order by bbsnum desc";
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1) + 1; // 게시글 1씩증가
			}
			return 1; // 첫번째 게시물인 경우
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
			DBClose.dbClose(rs);
		}
		return -1; // 데이터베이스 오류
	}
	
	// 글 작성 
	public int write(String bbsTitle, String id, String bbsContent) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into bbs values(?, ?, ?, sysdate, 0, ?)";
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, bbsTitle);
			pstmt.setString(3, id);
			pstmt.setString(4, bbsContent);
			return pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
		}
		return 0; // 데이터베이스 오류
	}
	
	// 전체리스트
	public ArrayList<BbsDto> getList(){
		ArrayList<BbsDto> list = new ArrayList<BbsDto>();
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from bbs order by bbsnum desc";
		
		try {
			conn = DBconn.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int bbsNum = rs.getInt("bbsNum");
				String bbsTitle = rs.getString("bbsTitle");
				String id = rs.getString("id");
				String bbsDate = rs.getString("bbsDate");
				int bbsHit = rs.getInt("bbsHit");
				String bbsContent = rs.getString("bbsContent");
//				int bbsGroup = rs.getInt("bbsGroup");
//				int bbsStep = rs.getInt("bbsStep");
//				int bbsIndent = rs.getInt("bbsIndent");
				
				BbsDto bDto = new BbsDto(bbsNum, bbsTitle, id, bbsDate, bbsHit, bbsContent);
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
	
	// content
	public BbsDto getContent(int num) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from bbs where bbsnum=?";
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BbsDto bdto = new BbsDto();
				bdto.setBbsNum(rs.getInt("bbsNum"));
				bdto.setBbsTitle(rs.getString("bbsTitle"));
				bdto.setId(rs.getString("id"));
				bdto.setBbsDate(rs.getString("bbsDate"));
				bdto.setBbsHit(rs.getInt("bbsHit"));
				bdto.setBbsContent(rs.getString("bbsContent"));
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
	
	
}
