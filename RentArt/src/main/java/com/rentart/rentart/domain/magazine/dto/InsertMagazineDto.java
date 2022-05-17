package com.rentart.rentart.domain.magazine.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertMagazineDto {
	private String title;
	private String content;
	private Timestamp regDate;
	private String regDateInput;
	
	public InsertMagazineDto(String title, String content, Timestamp regDate) {
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		
		this.regDateInput = new SimpleDateFormat("yyyy-MM-dd").format(regDate);
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

	public String getRegDateInput() {
		return regDateInput;
	}

	public void setRegDateInput(String regDateInput) {
		this.regDateInput = regDateInput;
	}
}
