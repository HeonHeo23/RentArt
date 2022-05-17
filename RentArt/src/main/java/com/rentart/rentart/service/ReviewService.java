package com.rentart.rentart.service;

import java.util.List;

import com.rentart.rentart.domain.review.ReviewDao;
import com.rentart.rentart.domain.review.dto.InsertReviewDto;
import com.rentart.rentart.domain.review.dto.ReviewDetailDto;
import com.rentart.rentart.domain.review.dto.ReviewForDetailDto;
import com.rentart.rentart.domain.review.dto.ReviewListDto;

public class ReviewService {
	private ReviewDao reviewDao;

	public ReviewService() {
		this.reviewDao = new ReviewDao();
	}
	
	public List<ReviewForDetailDto> getReviewsForDetail(int prodNo) {
		return reviewDao.findReviewsForDetail(prodNo);
	}
	
	public List<ReviewListDto> getReviewList(int page) {
		int start = (page-1)*20 + 1; 
		int end = page*20;
		
		return reviewDao.findReviewList(start, end);
	}
	
	public List<ReviewListDto> getReviewList(int page, String field, String query) {
		int start = (page-1)*20 + 1; 
		int end = page*20;
		
		return reviewDao.findReviewList(start, end, field, query);
	}
	
	public int wrtie(InsertReviewDto dto) {
		return reviewDao.insertReview(dto);
	}
	
	public int update(int no, InsertReviewDto dto) {
		return reviewDao.update(no, dto);
	}
		
	public ReviewDetailDto getReviewDetail(int rId) {
		return reviewDao.findReviewDetail(rId);
	}

	public int delete(int no) {
		return reviewDao.delete(no);
	}
	
}