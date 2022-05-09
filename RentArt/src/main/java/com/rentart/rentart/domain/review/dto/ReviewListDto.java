package com.rentart.rentart.domain.review.dto;

import java.sql.Timestamp;

public class ReviewListDto {
	private int rownum;
	private int rId;
	private int pId;
	private String rTitle;
	private String rContent;
	private Timestamp rRegDate;
	private String userName;
	private String pName;
	private String pImg;
	
	public ReviewListDto(int rownum, int rId, int pId, String rTitle, String rContent, Timestamp rRegDate,
			String userName, String pName, String pImg) {
		this.rownum = rownum;
		this.rId = rId;
		this.pId = pId;
		this.rTitle = rTitle;
		this.rContent = rContent;
		this.rRegDate = rRegDate;
		this.userName = userName;
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
