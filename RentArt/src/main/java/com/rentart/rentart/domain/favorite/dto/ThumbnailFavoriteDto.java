package com.rentart.rentart.domain.favorite.dto;

public class ThumbnailFavoriteDto {
	private int fId;
	private int pId;
	private String pName;
	private String pImg;
	private int pSize;
	private boolean pIsRent;
	private int artistId;
	private String artist;
	
	public ThumbnailFavoriteDto(int fId, int pId, String pName, String pImg, int pSize, boolean pIsRent, int artistId,
			String artist) {
		this.fId = fId;
		this.pId = pId;
		this.pName = pName;
		this.pImg = pImg;
		this.pSize = pSize;
		this.pIsRent = pIsRent;
		this.artistId = artistId;
		this.artist = artist;
	}

	public int getfId() {
		return fId;
	}

	public void setfId(int fId) {
		this.fId = fId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpImg() {
		return pImg;
	}

	public void setpImg(String pImg) {
		this.pImg = pImg;
	}

	public int getpSize() {
		return pSize;
	}

	public void setpSize(int pSize) {
		this.pSize = pSize;
	}

	public boolean ispIsRent() {
		return pIsRent;
	}

	public void setpIsRent(boolean pIsRent) {
		this.pIsRent = pIsRent;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
}
