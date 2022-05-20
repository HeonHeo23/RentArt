package com.rentart.rentart.service;

import java.util.List;

import com.rentart.rentart.domain.notice.NoticeDao;
import com.rentart.rentart.domain.notice.dto.NoticeDetailDto;
import com.rentart.rentart.domain.notice.dto.NoticeListDto;

public class NoticeService {
	private NoticeDao noticeDao;
	
	public NoticeService() {
		noticeDao = new NoticeDao();
	}
	
	public List<NoticeListDto> getNoticeList(int artistId){
		return noticeDao.findByArtistId(artistId);
	}
	
	public NoticeDetailDto getNoticeDeatil(int id) {
		noticeDao.updateHits(id);
		return noticeDao.get(id);
	}
	
	//admin

	public int updateNotice(int no, String title, String text) {
		return noticeDao.update(no, title, text);
	}
	
	public int insertNotice(int id, String title, String text) {
		return noticeDao.insert(id, title, text);
	}
	
	public int deleteNotice(int id) {
		return noticeDao.delete(id);
	}
}
