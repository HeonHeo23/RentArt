package com.rentart.rentart.domain.magazine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import com.rentart.rentart.domain.magazine.dto.MagazineDto;

public class MagazineDao {
	private String url = "jdbc:mysql://localhost:3306/RENTART";
	private String dbId = "root";
	private String dbPw = "@Oleout[3892]";
	
	public int findLast() {
		int result = 0;
		
		String sql = "SELECT * FROM MAGAZINE ORDER BY M_ID DESC;";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			result = rs.getInt("m_id");
			
			rs.close();
			pstmt.close();
			conn.close();
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public MagazineDto findMagazine(int no) {
		String sql = "SELECT * FROM MAGAZINE WHERE M_ID = ?;";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			int id = rs.getInt("m_id");
			String title = rs.getString("m_title");
			String content = rs.getString("m_content");
			Timestamp regDate = rs.getTimestamp("m_regdate");
			
			rs.close();
			pstmt.close();
			conn.close();
			
			MagazineDto dto = new MagazineDto(id, title, content, regDate);
			
			return dto;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
