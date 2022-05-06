package com.rentart.rentart.domain.artist.dto;

public class ArtistThumbnailDto {
	private int artistId;
	private String artistName;
	private int countProduct;
	private String pImg;
	
	public ArtistThumbnailDto(int artistId, String artistName, int countProduct, String pImg) {
		this.artistId = artistId;
		this.artistName = artistName;
		this.countProduct = countProduct;
		this.pImg = pImg;
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

	public int getCountProduct() {
		return countProduct;
	}

	public void setCountProduct(int countProduct) {
		this.countProduct = countProduct;
	}

	public String getpImg() {
		return pImg;
	}

	public void setpImg(String pImg) {
		this.pImg = pImg;
	}
	
}
