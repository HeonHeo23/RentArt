package com.rentart.rentart.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentart.rentart.domain.artist.dto.ArtistDetailDto;
import com.rentart.rentart.domain.artist.dto.ArtistThumbnailDto;
import com.rentart.rentart.domain.notice.dto.NoticeListDto;
import com.rentart.rentart.domain.product.dto.DetailArtistProduct;
import com.rentart.rentart.service.ArtistService;
import com.rentart.rentart.service.NoticeService;
import com.rentart.rentart.service.ProductService;

@WebServlet("/artist")
public class ArtistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArtistService artistService;
       
    public ArtistController() {
    	artistService = new ArtistService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no_ = request.getParameter("no");
		if(no_ != null && !no_.equals("")) {
			int no = Integer.parseInt(no_);

			ArtistDetailDto dto = artistService.getArtistDetail(no);
			
			ProductService productService = new ProductService();
			NoticeService noticeService = new NoticeService();
			
			List<DetailArtistProduct> list = productService.getArtistProductList(no);
			List<NoticeListDto> notice = noticeService.getNoticeList(no);
			
			request.setAttribute("artist", dto);
			request.setAttribute("list", list);
			request.setAttribute("count", list.size());
			request.setAttribute("ls", (list.size()-1)/4+1);
			request.setAttribute("notice", notice);
			
			request.getRequestDispatcher("/artistDetail.jsp").forward(request, response);
		} else {
			String page_ = request.getParameter("pg");
			int page = (page_ != null && !page_.equals("")) ? Integer.parseInt(page_) : 1;
			
			List<ArtistThumbnailDto> list = artistService.getArtistList(page);
			int count = artistService.countArtist();
			
			request.setAttribute("list", list);
			request.setAttribute("ls", (list.size()-1)/3+1);
			request.setAttribute("count", count);
			
			request.getRequestDispatcher("/artistList.jsp").forward(request, response);
		}
		
	}

}