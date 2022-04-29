package com.rentart.rentart.domain.product;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.rentart.rentart.domain.product.dto.ThumbnailProduct;

public class ProductDao {
	private String url = "jdbc:mysql://localhost:3306/RENTART";
	private String dbId = "root";
	private String dbPw = "@Oleout[3892]";
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	public ProductDao() {
		
	}

	public List<ThumbnailProduct> getProductList(String field, String query, int start, int end) {
		List<ThumbnailProduct> list = new ArrayList<>();
		String sql = "select a.* from (select @rownum:=@rownum+1 rownum, t.* from thumbnail t, (SELECT @ROWNUM:=0) R "
				+ " where "+ field +" like ? order by t.p_id desc) a "
				+ " where rownum between ? and ? order by a.rownum;";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, query);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int pId = rs.getInt("p_id");
				String pName = rs.getString("p_name");
				String pImg = rs.getString("p_img");
				int artistId = rs.getInt("artist_id"); 
				String artist = rs.getString("artist_name");
				int pSize = rs.getInt("p_size");
				boolean pIsRent = rs.getBoolean("p_isrent");
				
				ThumbnailProduct product = new ThumbnailProduct(pId, pName, pImg, artistId, artist, pSize, pIsRent);
				
				list.add(product);
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

	public List<ThumbnailProduct> getProductList(String field, String query, int start, int end, int[] theme, int[][] size, int[][] price) {
		List<ThumbnailProduct> list = new ArrayList<>();
		String themeQuery = "";
		for(int i: theme) {
			themeQuery += String.format("%d,", i);
		}
		themeQuery = themeQuery.substring(0, themeQuery.length()-1);
		
		String sizeQuery = "";
		for(int[] i: size) {
			sizeQuery += String.format(" p_size between %d and %d or", i[0], i[1]);
		}
		sizeQuery = sizeQuery.substring(0, sizeQuery.length()-2);
		
		
		String priceQuery = "";
		for(int[] i: price) {
			priceQuery += String.format(" p_price between %d and %d or", i[0], i[1]);
		}
		priceQuery = priceQuery.substring(0, priceQuery.length()-2);
		
		
		String sql = "select a.* from (select @rownum:=@rownum+1 rownum, t.* from thumbnail t, (SELECT @ROWNUM:=0) R "
				+ " where "+ field +" like ? "
				+ " and p_theme in ("+ themeQuery +") and (" + sizeQuery +") and ("+ priceQuery
				+") order by t.p_id desc) a "
				+ " where rownum between ? and ? order by a.rownum;";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, dbId, dbPw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, query);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int pId = rs.getInt("p_id");
				String pName = rs.getString("p_name");
				String pImg = rs.getString("p_img");
				int artistId = rs.getInt("artist_id"); 
				String artist = rs.getString("artist_name");
				int pSize = rs.getInt("p_size");
				boolean pIsRent = rs.getBoolean("p_isrent");
				
				ThumbnailProduct product = new ThumbnailProduct(pId, pName, pImg, artistId, artist, pSize, pIsRent);
				
				list.add(product);
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

	public int countProduct(String field, String query) {
		int result = 0;
		String sql = "Select count(p_id) c from thumbnail where "+field+ " like ?;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, query);

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

	public int countProduct(String field, String query, int[] theme, int[][] size, int[][] price) {
		List<ThumbnailProduct> list = new ArrayList<>();
		String themeQuery = "";
		for(int i: theme) {
			themeQuery += String.format("%d,", i);
		}
		themeQuery = themeQuery.substring(0, themeQuery.length()-1);
		
		String sizeQuery = "";
		for(int[] i: size) {
			sizeQuery += String.format(" p_size between %d and %d or", i[0], i[1]);
		}
		sizeQuery = sizeQuery.substring(0, sizeQuery.length()-2);
		
		
		String priceQuery = "";
		for(int[] i: price) {
			priceQuery += String.format(" p_price between %d and %d or", i[0], i[1]);
		}
		priceQuery = priceQuery.substring(0, priceQuery.length()-2);
		
		
		int result = 0;
		String sql = "Select count(p_id) c from thumbnail where "+field+ " like ? "
				+ " and p_theme in ("+ themeQuery +") and (" + sizeQuery +") and ("+ priceQuery+");";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, query);

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
