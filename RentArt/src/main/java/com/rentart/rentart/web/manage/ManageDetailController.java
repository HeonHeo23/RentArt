package com.rentart.rentart.web.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentart.rentart.domain.product.dto.DetailDto;
import com.rentart.rentart.service.ProductService;
import com.rentart.rentart.util.Script;

@WebServlet("/manage/detail")
public class ManageDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
       
    public ManageDetailController() {
    	productService = new ProductService();
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
		
		String no_ = request.getParameter("no");
		if(no_ == null || no_.equals("")) {
			Script.back(response, "잘못된 접근입니다.");
			return;
		}
		
		int no = Integer.parseInt(no_);
		
		DetailDto dto = productService.getProductDetail(no);
		
		request.setAttribute("dto", dto);
		
		request.getRequestDispatcher("/manage/productDetail.jsp").forward(request, response);
	}
}