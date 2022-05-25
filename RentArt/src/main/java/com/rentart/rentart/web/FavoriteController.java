package com.rentart.rentart.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentart.rentart.domain.favorite.dto.ThumbnailFavoriteDto;
import com.rentart.rentart.domain.user.User;
import com.rentart.rentart.service.FavoriteService;
import com.rentart.rentart.util.Script;

@WebServlet(urlPatterns = {"/favorite"})
public class FavoriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FavoriteService favoriteService;
       
    public FavoriteController() {
    	favoriteService = new FavoriteService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		
		User user = (User) request.getSession().getAttribute("principal");
		if(user == null)
			Script.redirect(response, "로그인이 필요한 기능입니다.", "/login");
		else {
			int userKey = user.getKey();
			if(cmd == null) {
				String page_ = request.getParameter("pg");
				
				int page = (page_ == null || page_.equals("")) ? 1 : Integer.parseInt(page_);
				
				List<ThumbnailFavoriteDto> list = favoriteService.getFavoriteList(userKey, page);
				int count = favoriteService.countFavorite(userKey);
				List<Integer> fList = favoriteService.getFavoriteIds(user.getKey());
				
				request.setAttribute("userName", user.getName());
				request.setAttribute("list", list);
				request.setAttribute("ls", (list.size()-1)/4+1);
				request.setAttribute("count", count);
				request.setAttribute("fList", fList);
				request.getRequestDispatcher("/favoriteList.jsp").forward(request, response);
				
			} else if(cmd.equals("add")) {
				String prodNo_ = request.getParameter("prodNo");
				if(prodNo_ == null || prodNo_.equals("")) {
					Script.back(response, "잘못된 접근입니다.");
				} else {
					int prodNo = Integer.parseInt(prodNo_);
					
					int result = favoriteService.addFavorite(userKey, prodNo);
					
					if(result != 1) {
						Script.back(response, "찜 등록에 실패했습니다.");
					} else {
						String referer = request.getHeader("Referer");
						response.sendRedirect(referer);
					}
				} 
			} else if(cmd.equals("remove")) {
				String prodNo_ = request.getParameter("prodNo");
				if(prodNo_ == null || prodNo_.equals("")) {
					Script.back(response, "잘못된 접근입니다.");
				} else {
					int prodNo = Integer.parseInt(prodNo_);
					
					int result = favoriteService.removeFavorite(userKey, prodNo);
					
					if(result != 1) {
						Script.back(response, "찜 등록 해제에 실패했습니다.");
					} else {
						String referer = request.getHeader("Referer");
						response.sendRedirect(referer);
					}
				} 
			} else {
				Script.back(response, "잘못되 접근입니다.");
			}
	
		}
	}
}
