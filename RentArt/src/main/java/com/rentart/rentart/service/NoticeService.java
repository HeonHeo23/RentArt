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
		return noticeDao.findNoticeList(artistId);
	}
	
	public NoticeDetailDto getNoticeDeatil(int id) {
		return noticeDao.findReviewDetail(id);
	}
}
