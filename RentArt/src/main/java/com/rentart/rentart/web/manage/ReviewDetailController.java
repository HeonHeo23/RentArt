package com.rentart.rentart.web.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentart.rentart.domain.review.dto.ReviewDetailDto;
import com.rentart.rentart.service.ReviewService;
import com.rentart.rentart.util.Script;

@WebServlet("/manage/review/detail")
public class ReviewDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewService reviewService;
	
    public ReviewDetailController() {
    	reviewService = new ReviewService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean login = (Boolean) request.getSession().getAttribute("managePrincipal");
		if(login == null) {
			Script.back(response, "로그인 해주시기 바랍니다.");
			return;
		}
		
		try {
			String no_ = request.getParameter("no");
			int no = Integer.parseInt(no_);
			
			ReviewDetailDto dto = reviewService.getReviewDetail(no);
			
			request.setAttribute("dto", dto);
			
			request.getRequestDispatcher("/manage/reviewDetail.jsp").forward(request, response);
		} catch(NumberFormatException e) {
			e.printStackTrace();
			Script.back(response, "잘못된 접근입니다.");
			return;
		}
	}
}
