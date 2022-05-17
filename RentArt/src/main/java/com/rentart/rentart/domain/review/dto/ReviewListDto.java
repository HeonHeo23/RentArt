package com.rentart.rentart.domain.review.dto;

import java.sql.Timestamp;

public class ReviewListDto {
	private int rownum;
	private int rId;
	private String rTitle;
	private String rContent;
	private Timestamp rRegDate;
	private Timestamp rUpDate;
	private int userKey;
	private String userName;
	private int pId;
	private String pName;
	private String pImg;
	
	public ReviewListDto(int rownum, int rId, String rTitle, String rContent, Timestamp rRegDate, Timestamp rUpDate,
			int userKey, String userName, int pId, String pName, String pImg) {
		this.rownum = rownum;
		this.rId = rId;
		this.rTitle = rTitle;
		this.rContent = rContent;
		this.rRegDate = rRegDate;
		this.rUpDate = rUpDate;
		this.userKey = userKey;
		this.userName = userName;
		this.pId = pId;
		this.pName = pName;
		this.pImg = pImg;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
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
}
