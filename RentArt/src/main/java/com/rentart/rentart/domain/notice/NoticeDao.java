package com.rentart.rentart.domain.notice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.rentart.rentart.domain.notice.dto.NoticeDetailDto;
import com.rentart.rentart.domain.notice.dto.NoticeListDto;

public class NoticeDao {
	private String url = "jdbc:mysql://localhost:3306/RENTART";
	private String dbId = "root";
	private String dbPw = "@Oleout[3892]";
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	public List<NoticeListDto> findByArtistId(int artistId) {
		List<NoticeListDto> list = new ArrayList<NoticeListDto>();
		String SQL = "SELECT A.* FROM (SELECT @ROWNUM:=@ROWNUM+1 ROWNUM, N.* FROM NOTICELIST N, "
				+ " (SELECT @ROWNUM:=0) R WHERE ARTIST_ID = ?) A ORDER BY A.ROWNUM;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, artistId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				NoticeListDto dto;
				int rownum = rs.getInt("rownum");
				int id = rs.getInt("n_id");
				String title = rs.getString("n_title");
				String content = rs.getString("n_content");
				Timestamp regDate = rs.getTimestamp("n_regdate");
				String artistName = rs.getString("artist_name");
				
				dto = new NoticeListDto(rownum, id, title, content, regDate, artistName);
				
				list.add(dto);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public NoticeDetailDto get(int id) {
		NoticeDetailDto dto;
		String SQL = "SELECT N_TITLE, N_CONTENT, N_REGDATE, N_UPDATE, ARTIST_NAME FROM NOTICELIST WHERE N_ID = ?;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1,id);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			String title = rs.getString("n_title");
			String content = rs.getString("n_content");
			Timestamp regDate = rs.getTimestamp("n_regdate");
			Timestamp upDate = rs.getTimestamp("n_update");
			String userName = rs.getString("artist_name");
			
			dto = new NoticeDetailDto(title, content, regDate, upDate, userName);
			
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	//admin
	
	public int update(int id, String title, String text) {
		String SQL = "UPDATE NOTICE SET N_TITLE = ?, N_CONTENT = ?, N_UPDATE = NOW() WHERE N_ID = ?;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, title);
			pstmt.setString(2, text);
			pstmt.setInt(3, id);
			
			int result = pstmt.executeUpdate();		
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public int updateHits(int id) {
		String SQL = "UPDATE NOTICE SET N_HITS = N_HITS + 1 WHERE N_ID = ?;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, id);
			
			int result = pstmt.executeUpdate();		
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}

	public int insert(int id, String title, String text) {
		String SQL = "INSERT INTO NOTICE (ARTIST_ID, N_TITLE, N_CONTENT) VALUES(?,?,?);";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, id);
			pstmt.setString(2, title);
			pstmt.setString(3, text);
			
			int result = pstmt.executeUpdate();		
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}

	public int delete(int id) {
		String SQL = "DELETE FROM NOTICE WHERE N_ID = ?;";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, id);
			
			int result = pstmt.executeUpdate();		
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}

}
