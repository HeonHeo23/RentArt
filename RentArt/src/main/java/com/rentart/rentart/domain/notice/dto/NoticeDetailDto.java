package com.rentart.rentart.domain.notice.dto;

import java.sql.Timestamp;

public class NoticeDetailDto {
	private String nTitle;
	private String nContent;
	private Timestamp nRegDate; 
	private Timestamp nUpDate; 
	private String artistName;
	
	public NoticeDetailDto(String nTitle, String nContent, Timestamp nRegDate, Timestamp nUpDate, String artistName) {
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nRegDate = nRegDate;
		this.nUpDate = nUpDate;
		this.artistName = artistName;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public Timestamp getnRegDate() {
		return nRegDate;
	}

	public void setnRegDate(Timestamp nRegDate) {
		this.nRegDate = nRegDate;
	}

	public Timestamp getnUpDate() {
		return nUpDate;
	}

	public void setnUpDate(Timestamp nUpDate) {
		this.nUpDate = nUpDate;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
}
