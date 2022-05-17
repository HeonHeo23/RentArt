package com.rentart.rentart.domain.artist.dto;

public class InsertArtistDto {
	private int artistId;
	private String artistName;
	private String password;
	private String artistInfo;
	
	public InsertArtistDto(int artistId, String artistName, String password, String artistInfo) {
		this.artistId = artistId;
		this.artistName = artistName;
		this.password = password;
		this.artistInfo = artistInfo;
	}
	
	public int getArtistId() {
		return artistId;
	}
	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getArtistInfo() {
		return artistInfo;
	}
	public void setArtistInfo(String artistInfo) {
		this.artistInfo = artistInfo;
	}
}
