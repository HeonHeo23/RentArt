package com.rentart.rentart.service;

import java.util.List;

import com.rentart.rentart.domain.artist.ArtistDao;
import com.rentart.rentart.domain.artist.dto.ArtistDetailDto;
import com.rentart.rentart.domain.artist.dto.ArtistDto;
import com.rentart.rentart.domain.artist.dto.ArtistThumbnailDto;

public class ArtistService {
	private ArtistDao artistDao;
	
	public ArtistService() {
		this.artistDao = new ArtistDao();
	}
	
	public String getArtistInfo(int artistId) {
		return artistDao.findArtistInfo(artistId);
	}
	
	public List<ArtistThumbnailDto> getArtistList(int page) {
		int start = 1+(page-1)*9;
		int end = page*9;
		return artistDao.findArtistList(start, end);
	}
	
	public ArtistDetailDto getArtistDetail(int no) {
		return artistDao.findArtistDetail(no);
	}
	
	public int countArtist() {
		return artistDao.count();
	}

	//admin
	
	public ArtistDto login(int id, String password) {
		return artistDao.login(id, password);
	}
	
}
