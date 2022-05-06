package com.rentart.rentart.domain.notice.dto;

import java.sql.Timestamp;

public class NoticeListDto {
	private int rownum;
	private int nId;
	private String nTitle;
	private String nContent;
	private Timestamp nRegDate; 
	private String artistName;
	
	public NoticeListDto(int rownum, int nId, String nTitle, String nContent, Timestamp nRegDate, String artistName) {
		super();
		this.rownum = rownum;
		this.nId = nId;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nRegDate = nRegDate;
		this.artistName = artistName;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public int getnId() {
		return nId;
	}

	public void setnId(int nId) {
		this.nId = nId;
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

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	
	
}