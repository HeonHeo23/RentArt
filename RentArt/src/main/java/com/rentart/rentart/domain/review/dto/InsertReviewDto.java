package com.rentart.rentart.domain.review.dto;

public class InsertReviewDto {
	private int userKey;
	private int pId;
	private String rTitle;
	private String rContent;
	
	public InsertReviewDto(int userKey, int pId, String rTitle, String rContent) {
		this.userKey = userKey;
		this.pId = pId;
		this.rTitle = rTitle;
		this.rContent = rContent;
	}

	public int getUserKey() {
		return userKey;
	}

	public void setUserKey(int userKey) {
		this.userKey = userKey;
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
}
