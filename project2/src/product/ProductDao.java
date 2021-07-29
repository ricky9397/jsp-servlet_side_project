package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.DBClose;
import Database.DBconn;
import bbs.BbsDto;
import comment.CommentDto;
import member.MemberDto;

public class ProductDao {
	
	private ProductDao() {}
	static private ProductDao dao = new ProductDao();
	public static ProductDao getInstance() {
		return dao;
	}
	
	// 상품번호 증가
	public int getNext() {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select max(icode) from product";
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt("max(icode)");
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
	
	// 상품 등록
	public int productInsert(ProductDto dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into product values (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getiCode());
			pstmt.setString(2, dto.getiName());
			pstmt.setInt(3, dto.getiPrice());
			pstmt.setInt(4, dto.getCount());
			pstmt.setString(5, dto.getiPhoto());
			pstmt.setString(6, dto.getContent1());
			pstmt.setString(7, dto.getContent2());
			pstmt.setString(8, dto.getContent3());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
		}
		return result;
	}
	
	
	// 상품 리스트
	public ArrayList<ProductDto> getProductList(){
		ArrayList<ProductDto> list = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from product";
		
		try {
			conn = DBconn.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			list = new ArrayList<>();
			
			while(rs.next()) {
				list.add(new ProductDto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getInt(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8)
						));
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
	
	
	// 상품클릭 후 상세보기 
	public ProductDto selectIcode(int iCode) {
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
				ProductDto dto = new ProductDto();
				dto.setiCode(rs.getInt("iCode"));
				dto.setiName(rs.getString("iName"));
				dto.setiPrice(rs.getInt("iPrice"));
				dto.setCount(rs.getInt("count"));
				dto.setiPhoto(rs.getString("iPhoto"));
				dto.setContent1(rs.getString("content1"));
				dto.setContent2(rs.getString("content2"));
				dto.setContent3(rs.getString("content3"));
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
