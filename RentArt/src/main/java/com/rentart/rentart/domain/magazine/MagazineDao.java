package com.rentart.rentart.domain.magazine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.rentart.rentart.domain.magazine.dto.InsertMagazineDto;
import com.rentart.rentart.domain.magazine.dto.MagazineDto;
import com.rentart.rentart.domain.magazine.dto.MagazineListDto;

public class MagazineDao {
	private String url = "jdbc:mysql://localhost:3306/RENTART";
	private String dbId = "root";
	private String dbPw = "@Oleout[3892]";
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	public int getLast() {
		int result = 0;
		
		String sql = "SELECT * FROM MAGAZINE ORDER BY M_ID DESC;";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
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
	
	public MagazineDto get(int id) {
		String sql = "SELECT * FROM MAGAZINE WHERE M_ID = ?;";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
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

	public List<MagazineListDto> find(int start, int end, String field, String query) {
		List<MagazineListDto> list = new ArrayList<>();
		
		String sql = "SELECT A.* FROM (SELECT @ROWNUM:=@ROWNUM+1 ROWNUM, M.* FROM MAGAZINE M, (SELECT @ROWNUM:=0) "
				+ " R ORDER BY M_ID DESC) A WHERE ROWNUM BETWEEN ? AND ? AND "+ field +" LIKE ?;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			pstmt.setString(3, "%"+query+"%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("m_id");
				String title = rs.getString("m_title");
				int hits = rs.getInt("m_hits");
				Timestamp regDate = rs.getTimestamp("m_regdate");
				Timestamp upDate = rs.getTimestamp("m_update");
				
				MagazineListDto dto = new MagazineListDto(id, title, hits, regDate, upDate);
				
				list.add(dto);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
			return list;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int update(MagazineDto dto) {
		String sql = "UPDATE MAGAZINE SET M_TITLE=?, M_CONTENT=?,M_REGDATE=? WHERE M_ID = ?;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setTimestamp(3, dto.getRegDate());
			pstmt.setInt(4, dto.getId());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}

	public int delete(int id) {
		String sql = "DELETE FROM MAGAZINE WHERE M_ID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int insert(InsertMagazineDto dto) {
		String sql = "INSERT INTO MAGAZINE(M_TITLE, M_CONTENT, M_REGDATE) VALUES(?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setTimestamp(3, dto.getRegDate());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}