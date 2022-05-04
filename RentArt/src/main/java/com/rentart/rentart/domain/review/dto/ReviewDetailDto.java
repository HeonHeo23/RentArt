package com.rentart.rentart.domain.review.dto;

import java.sql.Timestamp;

public class ReviewDetailDto {
	private String rTitle;
	private String rContent;
	private Timestamp rRegDate; 
	private String userName;
	
	public ReviewDetailDto(String rTitle, String rContent, Timestamp rRegDate, String userName) {
		this.rTitle = rTitle;
		this.rContent = rContent;
		this.rRegDate = rRegDate;
		this.userName = userName;
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
	
}
