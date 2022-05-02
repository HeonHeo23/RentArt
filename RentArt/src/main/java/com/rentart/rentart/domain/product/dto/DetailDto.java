package com.rentart.rentart.domain.product.dto;

import com.rentart.rentart.util.Utility;

public class DetailDto {
	private int pId;
	private String pName;
	private String pImg;
	private int artistId;
	private String artist;
	private String pInfo;
	private int pTheme;
	private int pPrice;
	private int pSize;
	private String pMaterial;
	private int pYear;
	private boolean pIsRent;
	
	private String pThemeString;
	
	public DetailDto(int pId, String pName, String pImg, int artistId, String artist, String pInfo, int pTheme,
			int pPrice, int pSize, String pMaterial, int pYear, boolean pIsRent) {
		this.pId = pId;
		this.pName = pName;
		this.pImg = pImg;
		this.artistId = artistId;
		this.artist = artist;
		this.pInfo = pInfo;
		this.pTheme = pTheme;
		
		this.pThemeString = Utility.themeMapper(pTheme);
		
		this.pPrice = pPrice;
		this.pSize = pSize;
		this.pMaterial = pMaterial;
		this.pYear = pYear;
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

	public String getpInfo() {
		return pInfo;
	}

	public void setpInfo(String pInfo) {
		this.pInfo = pInfo;
	}

	public int getpTheme() {
		return pTheme;
	}

	public void setpTheme(int pTheme) {
		this.pTheme = pTheme;
	}

	public String getpThemeString() {
		return pThemeString;
	}

	public void setpThemeString(String pThemeString) {
		this.pThemeString = pThemeString;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public int getpSize() {
		return pSize;
	}

	public void setpSize(int pSize) {
		this.pSize = pSize;
	}

	public String getpMaterial() {
		return pMaterial;
	}

	public void setpMaterial(String pMaterial) {
		this.pMaterial = pMaterial;
	}

	public int getpYear() {
		return pYear;
	}

	public void setpYear(int pYear) {
		this.pYear = pYear;
	}

	public boolean ispIsRent() {
		return pIsRent;
	}

	public void setpIsRent(boolean pIsRent) {
		this.pIsRent = pIsRent;
	}
	
}
