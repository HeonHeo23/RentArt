package com.rentart.rentart.domain.product.dto;

public class ThumbnailProduct {
	private int pId;
	private String pName;
	private String pImg;
	private int artistId;
	private String artist;
	private int pSize;
	private boolean pIsRent;
	
	public ThumbnailProduct() {
	}

	public ThumbnailProduct(int pId, String pName, String pImg, int artistId, String artist, int pSize,
			boolean pIsRent) {
		this.pId = pId;
		this.pName = pName;
		this.pImg = pImg;
		this.artistId = artistId;
		this.artist = artist;
		this.pSize = pSize;
		this.pIsRent = pIsRent;
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

	@Override
	public String toString() {
		return "ThumbnailProduct [pId=" + pId + ", pName=" + pName + ", pImg=" + pImg + ", artistId=" + artistId
				+ ", artist=" + artist + ", pSize=" + pSize + ", pIsRent=" + pIsRent + "]";
	}
	
}
