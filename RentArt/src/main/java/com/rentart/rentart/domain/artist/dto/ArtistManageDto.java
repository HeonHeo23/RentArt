package com.rentart.rentart.domain.artist.dto;

import java.sql.Timestamp;

public class ArtistManageDto {
	int artistId;
	String password;
	String artistName;
	String artistInfo;
	int countProduct;
	int countNotice;
	Timestamp regDate;
	Timestamp upDate;

	public ArtistManageDto(int artistId, String password, String artistName, String artistInfo, int countProduct,
			int countNotice, Timestamp regDate, Timestamp upDate) {
		this.artistId = artistId;
		this.password = password;
		this.artistName = artistName;
		this.artistInfo = artistInfo;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
