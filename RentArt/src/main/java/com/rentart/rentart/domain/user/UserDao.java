package com.rentart.rentart.domain.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class UserDao {
	private String url = "jdbc:mysql://localhost:3306/RENTART";
	private String dbId = "root";
	private String dbPw = "@Oleout[3892]";
	private String driver = "com.mysql.cj.jdbc.Driver";

	public User login(String email, String password) {
		String sql = "SELECT * FROM USER WHERE USER_EMAIL = ? AND USER_PASSWORD = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int key = rs.getInt("user_key");
				String pwd = rs.getString("user_password");
				String name = rs.getString("user_name");
				String email2 = rs.getString("user_email");
				String address = rs.getString("user_address");
				Timestamp joinDate = rs.getTimestamp("user_joindate");
				
				User user = new User(key, pwd, name, email2, address, joinDate);
				
				rs.close();
				pstmt.close();
				conn.close();
				
				return user;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
