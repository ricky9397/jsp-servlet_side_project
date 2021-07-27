package cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.DBClose;
import Database.DBconn;

public class CartDao {
	
	private CartDao() {}
	static private CartDao dao = new CartDao();
	public static CartDao getInstance() {
		return dao;
	}
	
	public CartDto selectIcode(int iCode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from product where icode=?";
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, iCode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CartDto dto = new CartDto();
				dto.setCartNum(rs.getInt("cartNum"));
				dto.setCartCode(rs.getInt("cartCode"));
				dto.setId(rs.getString("id"));
				dto.setCount(rs.getInt("count"));
				return dto;
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
