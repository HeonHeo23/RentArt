package com.rentart.rentart.domain.artist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rentart.rentart.domain.artist.dto.ArtistDetailDto;
import com.rentart.rentart.domain.artist.dto.ArtistThumbnailDto;

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

	public List<ArtistThumbnailDto> findArtistList(int start, int end) {
		List<ArtistThumbnailDto> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String SQL = "SELECT A.* FROM (SELECT @ROWNUM:=@ROWNUM+1 ROWNUM, T.*FROM artistThumbnail T, "
				+ " (SELECT @ROWNUM:=0) R) A WHERE ROWNUM BETWEEN ? AND ?;";
		
		try {
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			System.out.println("1");
			
			while(rs.next()) {
				System.out.println("2");
				ArtistThumbnailDto dto;
				int artistId = rs.getInt("artist_id");
				String artistName = rs.getString("artist_name");
				int count = rs.getInt("c");
				String pImg = rs.getString("p_img");
				
				dto = new ArtistThumbnailDto(artistId, artistName, count, pImg);
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
	
	public ArtistDetailDto findArtist(int id) {
		String sql = "SELECT artist_id, artist_name, artist_info FROM ARTIST WHERE ARTIST_ID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			String artist_name = rs.getString("ARTIST_NAME");
			String artist_info = rs.getString("ARTIST_INFO");
			
			ArtistDetailDto dto = new ArtistDetailDto(id, artist_name, artist_info);
			
			rs.close();
			pstmt.close();
			conn.close();
			
			return dto;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int count() {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String SQL = "SELECT COUNT(ARTIST_ID) C FROM ARTISTTHUMBNAIL;";
		
		try {
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
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
		
		return -1;
	}
}
