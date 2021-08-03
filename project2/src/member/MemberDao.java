package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.DBClose;
import Database.DBconn;

public class MemberDao {
	
	// 싱글톤
	private MemberDao() {}
	static private MemberDao dao = new MemberDao();
	public static MemberDao getInstance() { return dao; }
	
	// 로그인
	public int login(String id, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select pw from member where id=?";
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(pw)) {
					return 1; // 로그인 성공
				} else {
					return 0; // 비밀번호 틀림
				} 
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
			DBClose.dbClose(rs);
		}
		return -1; 
	}
	
	// 회원가입
	public int join(MemberDto dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member values(?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setInt(4, dto.getPost());
			pstmt.setString(5, dto.getAddress());
			pstmt.setString(6, dto.getAddresss());
			pstmt.setString(7, dto.getPhoneNum());
			pstmt.setString(8, dto.getEmail());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
		}
		return result; // 회원가입 실패
	}
	
	// 아이디 중복체크
	public int idCheck(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id=?";
		
		try {
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next() || id.equals("")){ //결과가 있다면
				return 0; // 존재하는 아이디
			} else {
				return 1; // 가입가능한 아이디
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
			DBClose.dbClose(rs);
		}
		
		return -1; // 오류
	}
	
	// 회원 정보 리스트
	public ArrayList<MemberDto> getMemberList(){
		ArrayList<MemberDto> list = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from member";
		
		try {
			conn = DBconn.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			list = new ArrayList<>();
			
			while(rs.next()) {
				list.add(new MemberDto(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
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
	
	// 회원정보수정 아이디 체크
	public MemberDto selectById(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id=?";
		try {
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDto dto = new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setPost(rs.getInt("post"));
				dto.setAddress(rs.getString("address"));
				dto.setAddresss(rs.getString("addresss"));
				dto.setPhoneNum(rs.getString("phoneNum"));
				dto.setEmail(rs.getString("email"));
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
	
	
	// 회원정보 수정
	public int MemberEdit(MemberDto dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update member set pw=?, name=?, post=?, address=?, addresss=?, phonenum=?, email=? where id=?";
		try {
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getPost());
			pstmt.setString(4, dto.getAddress());
			pstmt.setString(5, dto.getAddresss());
			pstmt.setString(6, dto.getPhoneNum());
			pstmt.setString(7, dto.getEmail());
			pstmt.setString(8, dto.getId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
		}
		return result;
	}
	
	// 회원 탈퇴
	public int memberDelete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from member where id=?";
		try {
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			return pstmt.executeUpdate(); //삭제
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
		}
		return 0;
	}
	
	
}