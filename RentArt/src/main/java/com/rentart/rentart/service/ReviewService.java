package com.rentart.rentart.service;

import java.util.List;

import com.rentart.rentart.domain.review.ReviewDao;
import com.rentart.rentart.domain.review.dto.InsertReviewDto;
import com.rentart.rentart.domain.review.dto.ReviewForDetailDto;

public class ReviewService {
	private ReviewDao reviewDao;

	public ReviewService() {
		this.reviewDao = new ReviewDao();
	}
	
	public List<ReviewForDetailDto> getReviewsForDetail(int prodNo) {
		return reviewDao.findReviewsForDetail(prodNo);
	}
	
	public int wrtie(InsertReviewDto dto) {
		return reviewDao.insertReview(dto);
	}
	
}