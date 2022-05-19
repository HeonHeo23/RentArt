package com.rentart.rentart.domain.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.rentart.rentart.domain.product.dto.DetailArtistProduct;
import com.rentart.rentart.domain.product.dto.DetailDto;
import com.rentart.rentart.domain.product.dto.InsertProductDto;
import com.rentart.rentart.domain.product.dto.ManageProductDto;
import com.rentart.rentart.domain.product.dto.ThumbnailProduct;

public class ProductDao {
	private String url = "jdbc:mysql://localhost:3306/RENTART";
	private String dbId = "root";
	private String dbPw = "@Oleout[3892]";
	private String driver = "com.mysql.cj.jdbc.Driver";

	public List<ThumbnailProduct> find(int start, int end, String field, String query) {
		List<ThumbnailProduct> list = new ArrayList<>();
		String sql = "select a.* from (select @rownum:=@rownum+1 rownum, t.* from thumbnail t, (SELECT @ROWNUM:=0) R "
				+ " where "+ field +" like ? order by t.p_id desc) a "
				+ " where rownum between ? and ? order by a.rownum;";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+query+"%");
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

	public List<ThumbnailProduct> findByFilter(int[] theme, int[][] size, int[][] price, int start, int end, String field, String query) {
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
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+query+"%");
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

	public int count(String field, String query) {
		int result = 0;
		String sql = "Select count(p_id) c from thumbnail where "+field+ " like ?;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+query+"%");

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

	public int countByFilter(int[] theme, int[][] size, int[][] price, String field, String query) {
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
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+query+"%");
			
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
	
	public DetailDto get(int prodNo) {
		DetailDto detail = null;
		String sql = "SELECT * FROM DETAIL WHERE P_ID = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, prodNo);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			int pId = rs.getInt("p_id");
			String pName = rs.getString("p_name");
			String pImg = rs.getString("p_img");
			int artistId = rs.getInt("artist_id"); 
			String artist = rs.getString("artist_name");
			String pInfo = rs.getString("p_info");
			int pTheme = rs.getInt("p_theme");
			int pPrice = rs.getInt("p_price");
			int pSize = rs.getInt("p_size");
			String pMaterial = rs.getString("p_material");
			int pYear = rs.getInt("p_year");
			boolean pIsRent = rs.getBoolean("p_isrent");
			
			detail = new DetailDto(pId, pName, pImg, artistId, artist, pInfo, pTheme, pPrice, pSize, pMaterial, pYear, pIsRent);
			
			rs.close();
			pstmt.close();
			conn.close();
			
			return detail;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	public List<DetailArtistProduct> findByArtistId(int artistId, int start, int end){
		List<DetailArtistProduct> list = new ArrayList<>();
		String SQL = "SELECT A.* FROM (SELECT @ROWNUM:=@ROWNUM+1 ROWNUM, D.* FROM DETAILARTISTPRODUCT D, (SELECT @ROWNUM:=0) R"
				+ " WHERE ARTIST_ID = ? ORDER BY D.P_ID DESC) A WHERE ROWNUM BETWEEN ? AND ? ORDER BY A.ROWNUM;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, artistId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int pId = rs.getInt("p_id");
				String pName = rs.getString("p_name");
				String pImg = rs.getString("p_img");
				int pSize = rs.getInt("p_size");
				boolean pIsRent = rs.getBoolean("p_isrent");
				
				DetailArtistProduct dto = new DetailArtistProduct(pId, pName, pImg, pSize, pIsRent);
				
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
	
	public List<DetailArtistProduct> findByArtistId(int artistId){
		List<DetailArtistProduct> list = new ArrayList<>();
		String SQL = "SELECT A.* FROM (SELECT @ROWNUM:=@ROWNUM+1 ROWNUM, D.* FROM DETAILARTISTPRODUCT D, (SELECT @ROWNUM:=0) R"
				+ " WHERE ARTIST_ID = ? ORDER BY D.P_ID DESC) A;";
		
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
				int pId = rs.getInt("p_id");
				String pName = rs.getString("p_name");
				String pImg = rs.getString("p_img");
				int pSize = rs.getInt("p_size");
				boolean pIsRent = rs.getBoolean("p_isrent");
				
				DetailArtistProduct dto = new DetailArtistProduct(pId, pName, pImg, pSize, pIsRent);
				
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

	public int update(InsertProductDto dto) {
		String SQL = "UPDATE PRODUCT SET P_NAME = ?, ARTIST_ID = ?,P_THEME = ?, P_PRICE = ?, P_SIZE = ?, "
				+ " P_MATERIAL = ?, P_YEAR = ?, P_INFO = ?, P_UPDATE = now() WHERE P_ID = ?;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getaId());
			pstmt.setInt(3, dto.getTheme());
			pstmt.setInt(4, dto.getPrice());
			pstmt.setInt(5, dto.getSize());
			pstmt.setString(6, dto.getMaterial());
			pstmt.setInt(7, dto.getYear());
			pstmt.setString(8, dto.getText());
			pstmt.setInt(9, dto.getpId());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}

	public int insert(InsertProductDto dto) {
		String SQL = "INSERT INTO product (p_name, p_info, p_img, p_theme, p_price, p_size, p_material, p_year, ARTIST_ID) "
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getText());
			pstmt.setString(3, dto.getImg());
			pstmt.setInt(4, dto.getTheme());
			pstmt.setInt(5, dto.getPrice());
			pstmt.setInt(6, dto.getSize());
			pstmt.setString(7, dto.getMaterial());
			pstmt.setInt(8, dto.getYear());
			pstmt.setInt(9, dto.getaId());
			
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
		String SQL = "DELETE FROM PRODUCT WHERE P_ID = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
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

	public List<ManageProductDto> findForManage(int start, int end, String field, String query) {
		List<ManageProductDto> list = new ArrayList<>();
		
		String sql = "SELECT Q.* FROM (select @rownum:=@rownum+1 rownum, M.* FROM MANAGEPRODUCT M, "
				+ " (SELECT @ROWNUM:=0) R) Q WHERE "+ field +" LIKE ? AND ROWNUM BETWEEN ? AND ?;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+query+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int pId = rs.getInt("p_id");
				String pName = rs.getString("p_name");
				String artistName = rs.getString("artist_name");
				int artistId = rs.getInt("artist_id");
				int size = rs.getInt("p_size");
				int price = rs.getInt("p_price");
				int theme = rs.getInt("p_theme");
				int year = rs.getInt("p_year");
				int favorite = rs.getInt("c");
				Timestamp regDate = rs.getTimestamp("p_regdate");
				Timestamp upDate = rs.getTimestamp("p_upDate");
				boolean isRent = rs.getBoolean("p_isrent");
				
				ManageProductDto dto = new ManageProductDto(pId, pName, artistName, artistId,
						size, price, theme, year, favorite, regDate, upDate, isRent);
				
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

	public int updateRent(List<Integer> rents) {
		
		String sql = "UPDATE PRODUCT SET P_ISRENT = 1 WHERE P_ID = ?;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(sql);
			
			for(int i : rents) {
				pstmt.setInt(1, i);
				pstmt.executeUpdate();
			}
				
			pstmt.close();
			conn.close();
			
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public int updateNoRent(List<Integer> rents) {
		
		String sql = "UPDATE PRODUCT SET P_ISRENT = 0 WHERE P_ID = ?;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(sql);
			
			for(int i : rents) {
				pstmt.setInt(1, i);
				pstmt.executeUpdate();
			}
			
			pstmt.close();
			conn.close();
			
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
