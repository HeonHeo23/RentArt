package com.rentart.rentart.domain.artist.dto;

import java.sql.Timestamp;

public class ArtistListDto {
	private int artistId;
	private String name;
	private int countProduct;
	private int countNotice;
	private Timestamp regDate;
	private Timestamp upDate;
	
	public ArtistListDto(int artistId, String name, int countProduct, int countNotice, Timestamp regDate, 
			Timestamp upDate) {
		this.artistId = artistId;
		this.name = name;
		this.countProduct = countProduct;
		this.countNotice = countNotice;
		this.regDate = regDate;
		this.upDate = upDate;
	}

	public int getArtistId() {
		return artistId;
	}
	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCountProduct() {
		return countProduct;
	}
	public void setCountProduct(int countProduct) {
		this.countProduct = countProduct;
	}
	public int getCountNotice() {
		return countNotice;
	}
	public void setCountNotice(int countNotice) {
		this.countNotice = countNotice;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public Timestamp getUpDate() {
		return upDate;
	}
	public void setUpDate(Timestamp upDate) {
		this.upDate = upDate;
	}
}
