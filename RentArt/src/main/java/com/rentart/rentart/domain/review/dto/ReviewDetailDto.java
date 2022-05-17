package com.rentart.rentart.domain.review.dto;

import java.sql.Timestamp;

public class ReviewDetailDto {
	private int rId;
	private int pId;
	private String rTitle;
	private String rContent;
	private Timestamp rRegDate;
	private Timestamp rUpDate;
	private int userKey;
	private String userName;
	private String pName;
	private String pImg;

	public ReviewDetailDto(int rId, int pId, String rTitle, String rContent, Timestamp rRegDate, Timestamp rUpDate,
			int userKey, String userName, String pName, String pImg) {
		this.rId = rId;
		this.pId = pId;
		this.rTitle = rTitle;
		this.rContent = rContent;
		this.rRegDate = rRegDate;
		this.rUpDate = rUpDate;
		this.userKey = userKey;
		this.userName = userName;
		this.pName = pName;
		this.pImg = pImg;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getrTitle() {
		return rTitle;
	}

	public void setrTitle(String rTitle) {
		this.rTitle = rTitle;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public Timestamp getrRegDate() {
		return rRegDate;
	}

	public void setrRegDate(Timestamp rRegDate) {
		this.rRegDate = rRegDate;
	}

	public Timestamp getrUpDate() {
		return rUpDate;
	}

	public void setrUpDate(Timestamp rUpDate) {
		this.rUpDate = rUpDate;
	}
	
	public int getUserKey() {
		return userKey;
	}

	public void setUserKey(int userKey) {
		this.userKey = userKey;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
	
}
