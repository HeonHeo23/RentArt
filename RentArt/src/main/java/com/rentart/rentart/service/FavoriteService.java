package com.rentart.rentart.service;

import java.util.List;

import com.rentart.rentart.domain.favorite.FavoriteDao;
import com.rentart.rentart.domain.favorite.dto.ThumbnailFavoriteDto;

public class FavoriteService {
	private FavoriteDao favoriteDao;
	
	public FavoriteService() {
		favoriteDao = new FavoriteDao();
	}
	
	public List<ThumbnailFavoriteDto> getFavoriteList(int userKey, int page) {
		int start = 1+(page-1)*12;
		int end = page*12;
		return favoriteDao.findByUserKey(userKey, start, end);
	}
	
	public List<Integer> getFavoriteIds(int userKey) {
		return favoriteDao.findIdsByUserKey(userKey);
	}
	
	public int addFavorite(int userKey, int prodNo) {
		return favoriteDao.insert(userKey, prodNo);
	}
	
	public int removeFavorite(int userKey, int prodNo) {
		return favoriteDao.deleteByUserKeyAndPId(userKey, prodNo);
	}
	
	public int countFavorite(int userKey) {
		return favoriteDao.countByUserKey(userKey);
	}

}
