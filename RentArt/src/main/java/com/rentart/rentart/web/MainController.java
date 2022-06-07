package com.rentart.rentart.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentart.rentart.domain.product.dto.ThumbnailProduct;
import com.rentart.rentart.service.ProductService;

@WebServlet(urlPatterns = {"/main"})
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService service;
       
    public MainController() {
    	service = new ProductService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ThumbnailProduct> list = service.getProductListForMain();
		System.out.println();
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/main.jsp").forward(request, response);
	}
	
	

}
