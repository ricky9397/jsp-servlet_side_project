package comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.DBconn;

public class CommentDao {
	
	private CommentDao() {}
	static private CommentDao dao = new CommentDao(); 
	public static CommentDao getInstance() { return dao; }
	
	
	
	// 댓글 등록
	public int insertComment(CommentDto dto) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into comments values(?, ?, ?, sysdate, ?, ?)";
		try {
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getcNum());
			pstmt.setInt(2, dto.getcBbsNum());
			pstmt.setString(3, dto.getCommentId());
			pstmt.setInt(4, dto.getCommentParent());
			pstmt.setString(5, dto.getCommentContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	// 미완성 댓글 대댓글 쿼리 공부 필요... 모르겟음...ㅠ
	public ArrayList<CommentDto> getCommentList(int cBbsNum){
		ArrayList<CommentDto> list = new ArrayList<CommentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from comments where cbbsnum=?";
		return list;
	}
	
}
