package com.rentart.rentart.domain.magazine.dto;

import java.sql.Timestamp;

public class MagazineListDto {
	private int id;
	private String title;
	private int hits;
	private Timestamp regDate;
	private Timestamp upDate;
	
	public MagazineListDto(int id, String title, int hits, Timestamp regDate, Timestamp upDate) {
		this.id = id;
		this.title = title;
		this.hits = hits;
		this.regDate = regDate;
		this.upDate = upDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
}
