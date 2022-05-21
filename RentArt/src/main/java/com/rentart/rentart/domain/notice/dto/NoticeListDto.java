package com.rentart.rentart.domain.notice.dto;

import java.sql.Timestamp;

public class NoticeListDto {
	private int rownum;
	private int nId;
	private String nTitle;
	private String nContent;
	private int nHits;
	private Timestamp nRegDate; 
	private Timestamp nUpDate; 
	private String artistName;
	
	public NoticeListDto(int rownum, int nId, String nTitle, String nContent, int nHits, Timestamp nRegDate,
			Timestamp nUpDate, String artistName) {
		this.rownum = rownum;
		this.nId = nId;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nHits = nHits;
		this.nRegDate = nRegDate;
		this.nUpDate = nUpDate;
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
	public int getnHits() {
		return nHits;
	}
	public void setnHits(int nHits) {
		this.nHits = nHits;
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