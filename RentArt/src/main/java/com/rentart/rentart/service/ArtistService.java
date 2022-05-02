package com.rentart.rentart.service;

import com.rentart.rentart.domain.artist.ArtistDao;

public class ArtistService {
	private ArtistDao artistDao;
	
	public ArtistService() {
		this.artistDao = new ArtistDao();
	}
	
	public String getArtistInfo(int artistId) {
		return artistDao.findArtistInfo(artistId);
	}
}
