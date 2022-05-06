package com.rentart.rentart.domain.artist.dto;

public class ArtistDetailDto {
	int artistId;
	String artistName;
	String artistInfo;
	
	public ArtistDetailDto(int artistId, String artistName, String artistInfo) {
		this.artistId = artistId;
		this.artistName = artistName;
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

	public String getArtistInfo() {
		return artistInfo;
	}

	public void setArtistInfo(String artistInfo) {
		this.artistInfo = artistInfo;
	}
}
