package com.rentart.rentart.domain.artist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ArtistDao {
	private String url = "jdbc:mysql://localhost:3306/RENTART";
	private String dbId = "root";
	private String dbPw = "@Oleout[3892]";
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	public String findArtistInfo(int artistId) {
		String sql = "SELECT artist_info FROM ARTIST WHERE ARTIST_ID = ?";
		String result = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, artistId);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			result = rs.getString("artist_info");
			
			rs.close();
			pstmt.close();
			conn.close();
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
}
