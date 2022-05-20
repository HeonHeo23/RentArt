package com.rentart.rentart.domain.review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.rentart.rentart.domain.review.dto.InsertReviewDto;
import com.rentart.rentart.domain.review.dto.ReviewDetailDto;
import com.rentart.rentart.domain.review.dto.ReviewForDetailDto;
import com.rentart.rentart.domain.review.dto.ReviewListDto;

public class ReviewDao {
	private String url = "jdbc:mysql://localhost:3306/RENTART";
	private String dbId = "root";
	private String dbPw = "@Oleout[3892]";
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	public List<ReviewForDetailDto> findForDetailByProdNo(int prodNo) {
		List<ReviewForDetailDto> list = new ArrayList<ReviewForDetailDto>();
		String SQL = "SELECT A.* FROM (SELECT @rownum:=@rownum+1 rownum, V.* FROM REVIEWFORDETAIL V, (SELECT @ROWNUM:=0) R "
				+ " WHERE V.P_ID = ? ORDER BY R_ID DESC) A ORDER BY A.ROWNUM ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, prodNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReviewForDetailDto dto;
				int rownum = rs.getInt("rownum");
				int rId = rs.getInt("r_id");
				int pId = rs.getInt("p_id");
				String rTitle = rs.getString("r_title");
				String rContent = rs.getString("r_content");
				Timestamp rRegDate = rs.getTimestamp("r_regdate");
				String userName = rs.getString("user_name");
				
				dto = new ReviewForDetailDto(rownum, rId, pId, rTitle, rContent, rRegDate, userName);
				
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
	
	public List<ReviewListDto> find(int start, int end) {
		List<ReviewListDto> list = new ArrayList<>();
		String SQL = "SELECT A.* FROM (SELECT @ROWNUM:=@ROWNUM+1 ROWNUM, V.* FROM REVIEWLIST V, (SELECT @ROWNUM:=0) R) A "
				+ " WHERE ROWNUM BETWEEN ? AND ?;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReviewListDto dto;
				int rownum = rs.getInt("rownum");
				int rId = rs.getInt("r_id");
				String rTitle = rs.getString("r_title");
				String rContent = rs.getString("r_content");
				Timestamp rRegDate = rs.getTimestamp("r_regdate");
				Timestamp rUpDate = rs.getTimestamp("r_update");
				int userKey = rs.getInt("user_key");
				String userName = rs.getString("user_name");
				int pId = rs.getInt("p_id");
				String pName = rs.getString("p_name");
				String pImg = rs.getString("p_img");
				
				dto = new ReviewListDto(rownum, rId, rTitle, rContent, rRegDate, rUpDate, userKey, userName, pId, pName, pImg);
				
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
	
	public List<ReviewListDto> find(int start, int end, String field, String query) {
		List<ReviewListDto> list = new ArrayList<>();
		String SQL = "SELECT A.* FROM (SELECT @ROWNUM:=@ROWNUM+1 ROWNUM, R.* FROM REVIEWLIST R, (SELECT @ROWNUM:=0) Rw"
				+ " WHERE " + field + " LIKE ? ) A WHERE ROWNUM BETWEEN ? AND ?;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, "%" + query + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReviewListDto dto;
				int rownum = rs.getInt("rownum");
				int rId = rs.getInt("r_id");
				String rTitle = rs.getString("r_title");
				String rContent = rs.getString("r_content");
				Timestamp rRegDate = rs.getTimestamp("r_regdate");
				Timestamp rUpDate = rs.getTimestamp("r_update");
				int userKey = rs.getInt("user_key");
				String userName = rs.getString("user_name");
				int pId = rs.getInt("p_id");
				String pName = rs.getString("p_name");
				String pImg = rs.getString("p_img");
				
				dto = new ReviewListDto(rownum, rId, rTitle, rContent, rRegDate, rUpDate, userKey, userName, pId, pName, pImg);
				
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

	public int insert(InsertReviewDto dto) {
		String SQL = "INSERT INTO REVIEW (USER_KEY, P_ID, R_TITLE, R_CONTENT) VALUES (?, ?, ?, ?);";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, dto.getUserKey());
			pstmt.setInt(2, dto.getpId());
			pstmt.setString(3, dto.getrTitle());
			pstmt.setString(4, dto.getrContent());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			return 1;
			
		} catch (NullPointerException e) {
			e.printStackTrace();
			return 0;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}

	public ReviewDetailDto get(int rId) {
		ReviewDetailDto dto;
		String SQL = "SELECT * FROM REVIEWLIST WHERE R_ID = ?;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, rId);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			int pId = rs.getInt("p_id");
			String rTitle = rs.getString("r_title");
			String rContent = rs.getString("r_content");
			Timestamp rRegDate = rs.getTimestamp("r_regdate");
			Timestamp rUpDate = rs.getTimestamp("r_update");
			int userKey = rs.getInt("user_key");
			String userName = rs.getString("user_name");
			String pName = rs.getString("p_name");
			String pImg = rs.getString("p_img");
			
			dto = new ReviewDetailDto(rId, pId, rTitle, rContent, rRegDate, rUpDate, userKey, userName, pName, pImg);
			
			return dto;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int update(int no, InsertReviewDto dto) {
		String SQL = "UPDATE REVIEW SET USER_KEY = ?, P_ID = ?, R_TITLE = ?, R_CONTENT = ?, R_UPDATE = NOW() "
				+ " WHERE R_ID = ?;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, dto.getUserKey());
			pstmt.setInt(2, dto.getpId());
			pstmt.setString(3, dto.getrTitle());
			pstmt.setString(4, dto.getrContent());
			pstmt.setInt(5, no);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			return 1;
			
		} catch (NullPointerException e) {
			e.printStackTrace();
			return 0;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	public int updateHits(int no) {
		String SQL = "UPDATE REVIEW SET R_HITS = R_HITS+1 WHERE R_ID = ?;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, no);
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}

	public int delete(int no) {
		String SQL = "DELETE FROM REVIEW WHERE R_ID = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			return 1;
			
		} catch (NullPointerException e) {
			e.printStackTrace();
			return 0;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}