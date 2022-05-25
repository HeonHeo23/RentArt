package com.rentart.rentart.web.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentart.rentart.domain.review.dto.InsertReviewDto;
import com.rentart.rentart.domain.review.dto.ReviewListDto;
import com.rentart.rentart.service.ReviewService;
import com.rentart.rentart.util.Script;

@WebServlet("/manage/review")
public class ManageReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewService reviewService;
       
    public ManageReviewController() {
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
		
		String cmd = request.getParameter("cmd");
		if(cmd == null || cmd.equals("")) {
			String pg_ = request.getParameter("pg");
			int pg = (pg_ == null || pg_.equals("")) ? 1 : Integer.parseInt(pg_);
			String field = request.getParameter("field");
			field = (field == null || field.equals(""))? "r_title" : field;
			String query = request.getParameter("query");
			query = (query == null)? "%" : query;
			
			List<ReviewListDto> list = reviewService.getReviewList(pg, field, query);
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("/manage/reviewList.jsp").forward(request, response);
			return;
		} else if(cmd.equals("update")) {
			try {
				String title = request.getParameter("title");
				String userKey_ = request.getParameter("userKey");
				int userKey = Integer.parseInt(userKey_);
				String pId_ = request.getParameter("pId");
				int pId = Integer.parseInt(pId_);
				String no_ = request.getParameter("no");
				int no = Integer.parseInt(no_);
				String text = request.getParameter("text");
				
				InsertReviewDto dto = new InsertReviewDto(userKey, pId, title, text);
				
				int result = reviewService.update(no, dto);
				if(result != 1) {
					Script.back(response, "리뷰 수정에 실패했습니다.");
					return;
				}
				
				Script.close(response, "리뷰 정보를 수정했습니다.");
			} catch(NumberFormatException e) {
				e.printStackTrace();
				Script.back(response, "내용을 다시 확인해 주시기 바랍니다.");
				return;
			} catch(Exception e) {
				e.printStackTrace();
				Script.back(response, "잘못된 접근입니다.");
				return;
			}
			
		} else if(cmd.equals("delete")) {
			try {
				String no_ = request.getParameter("no");
				int no = Integer.parseInt(no_);
				int result = reviewService.delete(no);
				
				if(result != 1) {
					Script.back(response, "리뷰 삭제에 실패했습니다.");
					return;
				}
				
				Script.close(response, "리뷰를 삭제했습니다.");
			} catch (Exception e) {
				e.printStackTrace();
				Script.back(response, "잘못된 접근입니다.");
				return;
			}
			
		} else {
			Script.back(response, "잘못된 접근입니다.");
		}
		
	}
	
}
