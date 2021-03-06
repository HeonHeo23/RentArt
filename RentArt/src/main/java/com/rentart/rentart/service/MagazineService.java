package com.rentart.rentart.service;

import java.util.List;

import com.rentart.rentart.domain.magazine.MagazineDao;
import com.rentart.rentart.domain.magazine.dto.InsertMagazineDto;
import com.rentart.rentart.domain.magazine.dto.MagazineDto;
import com.rentart.rentart.domain.magazine.dto.MagazineListDto;

public class MagazineService {
	private MagazineDao dao;
	
	public MagazineService() {
		dao = new MagazineDao();
	}
	
	public int getLastNumber() {
		return dao.getLast();
	}
	
	public MagazineDto getMagazine(int no) {
		dao.updateHits(no);
		return dao.get(no);
	}

	public List<MagazineListDto> getMagazineList(int page, String field, String query) {
		int start = 1+(page-1)*20;
		int end = page*20;
		return dao.find(start, end, field, query);
	}

	public int update(MagazineDto dto) {
		return dao.update(dto);
	}

	public int delete(int no) {
		return dao.delete(no);
	}

	public int insert(InsertMagazineDto dto) {
		return dao.insert(dto);
	}
}
