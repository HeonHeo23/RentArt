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

public class ReviewDao {
	private String url = "jdbc:mysql://localhost:3306/RENTART";
	private String dbId = "root";
	private String dbPw = "@Oleout[3892]";
	
	public List<ReviewForDetailDto> findReviewsForDetail(int prodNo) {
		List<ReviewForDetailDto> list = new ArrayList<ReviewForDetailDto>();
		String SQL = "SELECT A.* FROM (SELECT @rownum:=@rownum+1 rownum, V.* FROM REVIEWFORDETAIL V, (SELECT @ROWNUM:=0) R "
				+ " WHERE V.P_ID = ? ORDER BY R_ID DESC) A ORDER BY A.ROWNUM ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
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
				
				dto.toString();
				
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

	public int insertReview(InsertReviewDto dto) {
		String SQL = "INSERT INTO REVIEW (USER_KEY, P_ID, R_TITLE, R_CONTENT) VALUES (?, ?, ?, ?);";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
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

	public ReviewDetailDto findReviewDetail(int rId) {
		ReviewDetailDto dto;
		String SQL = "SELECT R_TITLE, R_CONTENT, R_REGDATE, USER_NAME FROM REVIEW R LEFT JOIN USER U ON R.USER_KEY = U.USER_KEY WHERE R_ID = ?;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, rId);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			String rTitle = rs.getString("r_title");
			String rContent = rs.getString("r_content");
			Timestamp rRegDate = rs.getTimestamp("r_regdate");
			String userName = rs.getString("user_name");
			
			dto = new ReviewDetailDto(rTitle, rContent, rRegDate, userName);
			
			return dto;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}