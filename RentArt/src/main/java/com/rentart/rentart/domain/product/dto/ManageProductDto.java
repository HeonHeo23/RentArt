package com.rentart.rentart.domain.product.dto;

import java.sql.Timestamp;

import com.rentart.rentart.util.Utility;

public class ManageProductDto {
	private int pId;
	private String pName;
	private String artistName;
	private int artistId;
	private int size;
	private int price;
	private int theme;
	private String themeString;
	private int year;
	private int favorite;
	private int hits;
	private Timestamp regDate;
	private Timestamp upDate;
	private boolean isRent;
	
	public ManageProductDto(int pId, String pName, String artistName, int artistId, int size, int price, int theme,
			int year, int favorite, int hits, Timestamp regDate, Timestamp upDate, boolean isRent) {
		this.pId = pId;
		this.pName = pName;
		this.artistName = artistName;
		this.artistId = artistId;
		this.size = size;
		this.price = price;
		this.theme = theme;
		
		this.themeString = Utility.themeMapper(theme);
		
		this.year = year;
		this.hits = hits;
		this.favorite = favorite;
		this.regDate = regDate;
		this.upDate = upDate;
		this.isRent = isRent;
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
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public int getArtistId() {
		return artistId;
	}
	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTheme() {
		return theme;
	}
	public void setTheme(int theme) {
		this.theme = theme;
	}
	public String getThemeString() {
		return themeString;
	}
	public void setThemeString(String themeString) {
		this.themeString = themeString;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getFavorite() {
		return favorite;
	}
	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
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
	public boolean isRent() {
		return isRent;
	}
	public void setRent(boolean isRent) {
		this.isRent = isRent;
	}
	
}
