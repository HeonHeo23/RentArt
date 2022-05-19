package com.rentart.rentart.service;

import java.util.List;

import com.rentart.rentart.domain.artist.ArtistDao;
import com.rentart.rentart.domain.artist.dto.ArtistDetailDto;
import com.rentart.rentart.domain.artist.dto.ArtistDto;
import com.rentart.rentart.domain.artist.dto.ArtistListDto;
import com.rentart.rentart.domain.artist.dto.ArtistManageDto;
import com.rentart.rentart.domain.artist.dto.ArtistThumbnailDto;
import com.rentart.rentart.domain.artist.dto.InsertArtistDto;

public class ArtistService {
	private ArtistDao artistDao;
	
	public ArtistService() {
		this.artistDao = new ArtistDao();
	}
	
	public String getArtistInfo(int artistId) {
		return artistDao.getInfo(artistId);
	}
	
	public List<ArtistThumbnailDto> getArtistList(int page) {
		int start = 1+(page-1)*9;
		int end = page*9;
		return artistDao.find(start, end);
	}
	
	public ArtistDetailDto getArtistDetail(int no) {
		return artistDao.findDetail(no);
	}
	
	public int countArtist() {
		return artistDao.getCount();
	}

	//admin
	
	public ArtistDto login(int id, String password) {
		return artistDao.login(id, password);
	}
	
	public int updateInfo(int id, String text) {
		return artistDao.updateInfo(id, text);
	}
	
	public int updateArtist(int id, String name, String pwd) {
		return artistDao.updateArtist(id, name, pwd);
	}
	
	//manage

	public List<ArtistListDto> getManageArtistList(int page, String field, String query) {
		int start = 1+(page-1)*20;
		int end = page*20;
		return artistDao.findForManage(start, end, field, query);
	}

	public ArtistManageDto getArtist(int no) {
		return artistDao.getForManage(no);
	}

	public int delete(int no) {
		return artistDao.delete(no);
	}

	public int insert(InsertArtistDto dto) {
		return artistDao.insert(dto);
	}
	
	public int getLastId() {
		return artistDao.getLastId();
	}
}
