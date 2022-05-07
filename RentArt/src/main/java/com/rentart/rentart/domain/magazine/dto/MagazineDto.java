package com.rentart.rentart.domain.magazine.dto;

import java.sql.Timestamp;

public class MagazineDto {
	private int id;
	private String title;
	private String content;
	private Timestamp regDate;
	
	public MagazineDto(int id, String title, String content, Timestamp regDate) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	
}
