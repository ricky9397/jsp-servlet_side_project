package order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Database.DBClose;
import Database.DBconn;

public class OrderDao {
	
	private OrderDao() {}
	private static OrderDao dao = new OrderDao();
	public static OrderDao getInstance() { return dao; }
	
	
	// 주문
	public int orderInsert(List<OrderDto> dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into iorder values(iorder_oidx_seq.nextval, ?, ?, ?, ?, ?, sysdate, ?)";

		try {
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (OrderDto o : dto) {
				pstmt.setInt(1, o.getIcode());
				pstmt.setString(2, o.getId());
				pstmt.setString(3, o.getOname());
				pstmt.setInt(4, o.getOprice());
				pstmt.setString(5, o.getOphoto());
				pstmt.setInt(6, o.getCount());
//				pstmt.setInt(1, dto.getIcode());
//				pstmt.setString(2, dto.getId());
//				pstmt.setString(3, dto.getOname());
//				pstmt.setInt(4, dto.getOprice());
//				pstmt.setString(5, dto.getOphoto());
//				pstmt.setInt(6, dto.getCount());
				result = pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
		}
		return result; // 회원가입 실패
	}
	
	// 주문 리스트
	
	public ArrayList<OrderDto> getOrderList(String id){
		ArrayList<OrderDto> list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from iorder where id=?";
		try {
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			list = new ArrayList<>();
			while(rs.next()) {
				list.add(new OrderDto(
						rs.getInt(1),
						rs.getInt(2), 
						rs.getString(3), 
						rs.getString(4),
						rs.getInt(5), 
						rs.getString(6), 
						rs.getString(7), 
						rs.getInt(8)));
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
