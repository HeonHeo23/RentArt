package com.rentart.rentart.domain.user.dto;

import java.sql.Timestamp;

public class UserListCountDto {
	private int key;
	private String name;
	private String email;
	private String address;
	private Timestamp regDate;
	private Timestamp upDate;
	private int countReview;
	private int countFavorite;
	
	public UserListCountDto(int key, String name, String email, String address, Timestamp regDate, Timestamp upDate,
			int countReview, int countFavorite) {
		this.key = key;
		this.name = name;
		this.email = email;
		this.address = address;
		this.regDate = regDate;
		this.upDate = upDate;
		this.countReview = countReview;
		this.countFavorite = countFavorite;
	}
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public int getCountReview() {
		return countReview;
	}
	public void setCountReview(int countReview) {
		this.countReview = countReview;
	}
	public int getCountFavorite() {
		return countFavorite;
	}
	public void setCountFavorite(int countFavorite) {
		this.countFavorite = countFavorite;
	}
}
