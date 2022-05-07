package com.rentart.rentart.service;

import com.rentart.rentart.domain.magazine.MagazineDao;
import com.rentart.rentart.domain.magazine.dto.MagazineDto;

public class MagazineService {
	private MagazineDao dao;
	
	public MagazineService() {
		dao = new MagazineDao();
	}
	
	public int getLastNumber() {
		return dao.findLast();
	}
	
	public MagazineDto getMagazine(int no) {
		return dao.findMagazine(no);
	}
}
