package com.rentart.rentart.domain.artist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.rentart.rentart.domain.artist.dto.ArtistDetailDto;
import com.rentart.rentart.domain.artist.dto.ArtistDto;
import com.rentart.rentart.domain.artist.dto.ArtistListDto;
import com.rentart.rentart.domain.artist.dto.ArtistManageDto;
import com.rentart.rentart.domain.artist.dto.ArtistThumbnailDto;
import com.rentart.rentart.domain.artist.dto.InsertArtistDto;

public class ArtistDao {
	private String url = "jdbc:mysql://localhost:3306/RENTART";
	private String dbId = "root";
	private String dbPw = "@Oleout[3892]";
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	public String getInfo(int id) {
		String sql = "SELECT artist_info FROM ARTIST WHERE ARTIST_ID = ?";
		String result = "";
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

	public List<ArtistThumbnailDto> find(int start, int end) {
		List<ArtistThumbnailDto> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String SQL = "SELECT A.* FROM (SELECT @ROWNUM:=@ROWNUM+1 ROWNUM, T.*FROM artistThumbnail T, "
				+ " (SELECT @ROWNUM:=0) R) A WHERE ROWNUM BETWEEN ? AND ?;";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
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
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArtistDetailDto findDetail(int id) {
		String sql = "SELECT artist_id, artist_name, artist_info FROM ARTIST WHERE ARTIST_ID = ?";
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
	
	public int getCount() {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String SQL = "SELECT COUNT(ARTIST_ID) C FROM ARTISTTHUMBNAIL;";
		
		try {
			Class.forName(driver);
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

	public ArtistDto login(int id, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String SQL = "SELECT * FROM ARTIST WHERE artist_ID = ? AND artist_password = ?;";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, id);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			String name = rs.getString("ARTIST_NAME");
			
			ArtistDto dto = new ArtistDto(id, password, name);
			
			
			rs.close();
			pstmt.close();
			conn.close();
			
			return dto;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int updateInfo(int id, String text) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String SQL = "UPDATE ARTIST SET ARTIST_INFO = ?, ARTIST_UPDATE = NOW() WHERE ARTIST_ID = ?";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, text);
			pstmt.setInt(2, id);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}

	public int updateArtist(int id, String name, String pwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String SQL = "UPDATE ARTIST SET ARTIST_NAME = ?, ARTIST_PASSWORD = ?, ARTIST_UPDATE = NOW() WHERE ARTIST_ID = ?";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			pstmt.setInt(3, id);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public int updateHits(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String SQL = "UPDATE ARTIST SET ARTIST_HITS = ARTIST_HITS+1 WHERE ARTIST_ID = ?";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, id);
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}

	public List<ArtistListDto> findForManage(int start, int end, String field, String query) {
		List<ArtistListDto> list = new ArrayList<>();
		
		String SQL = "select q.* from(select @ROWNUM:=@ROWNUM+1 ROWNUM, B.* from (SELECT @ROWNUM:=0) R, "
			+ " (SELECT a.*, count(p_id) cp, count(n_id) cn FROM artist a left join product p on p.artist_id = a.artist_id "
			+ "	left join notice n on n.artist_id = a.artist_id where "+ field +" like ?"
			+ "	group by p.artist_id order by a.artist_id desc)B )q where rownum between ? and ?;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, "%"+query+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int artistId = rs.getInt("artist_id");
				String artistName = rs.getString("artist_name");
				int countProduct = rs.getInt("cp");
				int countNotice = rs.getInt("cn");
				Timestamp regDate = rs.getTimestamp("artist_regdate");
				Timestamp upDate = rs.getTimestamp("artist_update");
				
				ArtistListDto dto = new ArtistListDto(artistId, artistName, countProduct, countNotice, regDate, upDate);
				
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

	public ArtistManageDto getForManage(int id) {
		String SQL = "SELECT A.*, count(p_id) cp, count(n_id) cn FROM ARTIST a left join product p on p.artist_id = a.artist_id "
				+ "left join notice n on n.artist_id = a.artist_id where a.artist_id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			int artistId = rs.getInt("artist_id");
			String password = rs.getString("artist_password");
			String artistName = rs.getString("artist_name");
			String artistInfo = rs.getString("artist_info");
			int countProduct = rs.getInt("cp");
			int countNotice = rs.getInt("cn");
			Timestamp regDate = rs.getTimestamp("artist_regdate");
			Timestamp upDate = rs.getTimestamp("artist_update");
			
			ArtistManageDto dto = new ArtistManageDto(artistId, password, artistName, artistInfo, countProduct, countNotice, regDate, upDate);
			
			rs.close();
			pstmt.close();
			conn.close();
			
			return dto;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int delete(int id) {
		String SQL = "DELETE FROM ARTIST WHERE ARTIST_ID = ?";
		
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
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}

	public int insert(InsertArtistDto dto) {
		String SQL = "INSERT INTO ARTIST(ARTIST_NAME, ARTIST_PASSWORD, ARTIST_INFO, ARTIST_ID) VALUES(?, ?, ?, ?);";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, dto.getArtistName());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getArtistInfo());
			pstmt.setInt(4, dto.getArtistId());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}

	public int getLastId() {
		String SQL = "SELECT ARTIST_ID FROM ARTIST ORDER BY ARTIST_ID DESC LIMIT 1";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbId, dbPw);
			pstmt = conn.prepareStatement(SQL);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			int result = rs.getInt("ARTIST_ID");
			
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
