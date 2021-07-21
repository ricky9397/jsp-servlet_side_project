package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBClose {
	
	public static void dbClose(Statement stmt){
        if (stmt != null){
            try {
            	stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
 
    public static void dbClose(ResultSet rs){
        if (rs != null){
            try {
            	rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void dbClose(Connection conn){
        if (conn != null){
            try {
            	conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
