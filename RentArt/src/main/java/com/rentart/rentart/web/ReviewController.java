package com.rentart.rentart.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentart.rentart.domain.review.dto.InsertReviewDto;
import com.rentart.rentart.domain.review.dto.ReviewDetailDto;
import com.rentart.rentart.domain.user.User;
import com.rentart.rentart.service.ArtistService;
import com.rentart.rentart.service.ProductService;
import com.rentart.rentart.service.ReviewService;
import com.rentart.rentart.util.Script;

@WebServlet("/review")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
	private ArtistService artistService;
	private ReviewService reviewService;
       
    public ReviewController() {
    	reviewService = new ReviewService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int prodNo = 0;
		
		String cmd = request.getParameter("cmd");
		User user = (User) request.getSession().getAttribute("principal");
		
		String prodNo_ = request.getParameter("prodNo");
		if(prodNo_ != null && !prodNo_.equals(""))
			prodNo = Integer.parseInt(prodNo_);
		
		
		if(cmd == null) {
			if(user == null) {
				Script.close(response, "로그인을 해주시기를 바랍니다.");
			} 
			request.getRequestDispatcher("/writeReview.jsp").forward(request, response);
		}
		else if(cmd.equals("write")) {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			InsertReviewDto dto = new InsertReviewDto(user.getKey(), prodNo, title, content);
			
			int result = reviewService.wrtie(dto);
			
			if(result == 1) {
				Script.close(response, "리뷰를 성공적으로 등록했습니다.");
			} /*
				 * else if(result == 0) { Script.close(response, ""); }
				 */
			else {
				Script.back(response, "리뷰 작성에 실패했습니다.");
			}
		}
		else if(cmd.equals("view")) {
			int number = -1;
			String number_ = request.getParameter("no");
			
			if(number_ != null && !number_.equals("")) {
				number = Integer.parseInt(number_);				
			}
			if(number != -1) {
				ReviewDetailDto dto = reviewService.getReviewDetail(number);
				request.setAttribute("dto", dto);
				
				request.getRequestDispatcher("/reviewDetail.jsp").forward(request, response);
			}
		}

	}

}
