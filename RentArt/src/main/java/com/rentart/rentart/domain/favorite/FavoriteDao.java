package com.rentart.rentart.domain.favorite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rentart.rentart.domain.favorite.dto.ThumbnailFavoriteDto;

public class FavoriteDao {
	private String url = "jdbc:mysql://localhost:3306/RENTART";
	private String dbId = "root";
	private String dbPw = "@Oleout[3892]";
	private String driver = "com.mysql.cj.jdbc.Driver";

	public List<ThumbnailFavoriteDto> findByUserKey(int key, int start, int end) {
		List<ThumbnailFavoriteDto> list = new ArrayList<>();
		String sql = "SELECT A.* FROM (SELECT @ROWNUM:=@ROWNUM+1 ROWNUM, T.* "
				+ " FROM FavoriteThumbnail T, (SELECT @ROWNUM:=0) R) A WHERE USER_KEY = ? AND ROWNUM BETWEEN ? AND ?;";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, key);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int fId = rs.getInt("f_id");
				int pId = rs.getInt("p_id");
				String pName = rs.getString("p_name");
				String pImg = rs.getString("p_img");
				int artistId = rs.getInt("artist_id"); 
				String artist = rs.getString("artist_name");
				int pSize = rs.getInt("p_size");
				boolean pIsRent = rs.getBoolean("p_isrent");
				
				ThumbnailFavoriteDto dto = new ThumbnailFavoriteDto(fId, pId, pName, pImg, pSize, pIsRent, artistId, artist);
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

	public List<Integer> findIdsByUserKey(int key) {
		List<Integer> list = new ArrayList<>();
		String sql = "SELECT P_ID FROM FAVORITE WHERE USER_KEY = ?;";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, key);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int pId = rs.getInt("p_id");
				list.add(pId);
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
	
	public int insert(int key, int pId) {
		String sql = "INSERT INTO FAVORITE (USER_KEY, P_ID) VALUES (?,?);";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, key);
			pstmt.setInt(2, pId);

			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
		
	}
	
	public int deleteByUserKeyAndPId(int userKey, int pId) {
		String sql = "DELETE FROM FAVORITE WHERE USER_KEY = ? AND P_ID = ?;";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userKey);
			pstmt.setInt(2, pId);

			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public int countByUserKey(int key) {
		int result = 0;
		String sql = "SELECT COUNT(F_ID) C FROM FavoriteThumbnail WHERE USER_KEY = ?;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, key);
			
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt("c");
			
			rs.close();
			pstmt.close();
			conn.close();
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
