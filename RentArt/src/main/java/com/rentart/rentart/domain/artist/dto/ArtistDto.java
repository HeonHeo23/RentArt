package com.rentart.rentart.domain.artist.dto;

public class ArtistDto {
	int artistId;
	String artistPassword;
	String artistName;
	
	public ArtistDto(int artistId, String artistPassword, String artistName) {
		this.artistId = artistId;
		this.artistPassword = artistPassword;
		this.artistName = artistName;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public String getArtistPassword() {
		return artistPassword;
	}

	public void setArtistPassword(String artistPassword) {
		this.artistPassword = artistPassword;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
}
