package com.rentart.rentart.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentart.rentart.domain.product.dto.DetailArtistProduct;
import com.rentart.rentart.domain.product.dto.DetailDto;
import com.rentart.rentart.service.ArtistService;
import com.rentart.rentart.service.ProductService;
import com.rentart.rentart.util.Script;
import com.rentart.rentart.util.Utility;

@WebServlet("/detail")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
	private ArtistService artistService;
       
    public DetailController() {
    	productService = new ProductService();
    	artistService = new ArtistService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int prodNo = 0;
		String prodNo_ = request.getParameter("no");
		if(prodNo_ == null || prodNo_.equals(""))
			Script.back(response, "잘못된 접근입니다.");
		prodNo = Integer.parseInt(prodNo_);
		
		DetailDto detail = productService.getProductDetail(prodNo);
		int artistId = detail.getArtistId();
		
		String artistInfo = artistService.getArtistInfo(artistId);
		
		List<DetailArtistProduct> list = productService.getArtistProductList(artistId);
		
		int rentFee = Utility.rentPriceMapper(detail.getpSize());
		
		request.setAttribute("detail", detail);
		request.setAttribute("artistInfo", artistInfo);
		request.setAttribute("list", list);
		request.setAttribute("fee", rentFee);
		
		request.getRequestDispatcher("/detail.jsp").forward(request, response);
	}

}
