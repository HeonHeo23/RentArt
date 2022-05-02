package com.rentart.rentart.domain.product.dto;

public class DetailArtistProduct {
	private int pId;
	private String pName;
	private String pImg;
	private int pSize;
	private boolean pIsRent;
	
	public DetailArtistProduct(int pId, String pName, String pImg, int pSize, boolean pIsRent) {
		this.pId = pId;
		this.pName = pName;
		this.pImg = pImg;
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
	
}
