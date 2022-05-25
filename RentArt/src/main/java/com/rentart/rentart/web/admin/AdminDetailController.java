package com.rentart.rentart.web.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentart.rentart.domain.artist.dto.ArtistDto;
import com.rentart.rentart.domain.product.dto.DetailDto;
import com.rentart.rentart.service.ProductService;
import com.rentart.rentart.util.Script;

@WebServlet("/admin/detail")
public class AdminDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
       
    public AdminDetailController() {
    	productService = new ProductService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArtistDto artist = (ArtistDto) request.getSession().getAttribute("adminPrincipal");
		
		if(artist == null) {
			Script.back(response, "다시 로그인 해주시기 바랍니다.");
			return;
		}
		
		try {
			String no_ = request.getParameter("no");
			int no = Integer.parseInt(no_);
			
			DetailDto dto = productService.getProductDetail(no);
			
			request.setAttribute("dto", dto);
			
			request.getRequestDispatcher("/admin/productDetail.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			Script.back(response, "잘못된 접근입니다.");
			return;
		}
	}
}
