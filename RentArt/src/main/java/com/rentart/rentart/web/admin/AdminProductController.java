package com.rentart.rentart.web.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.rentart.rentart.domain.artist.dto.ArtistDto;
import com.rentart.rentart.domain.product.dto.DetailArtistProduct;
import com.rentart.rentart.domain.product.dto.InsertProductDto;
import com.rentart.rentart.service.ProductService;
import com.rentart.rentart.util.Script;

@MultipartConfig(
	fileSizeThreshold = 1024*1024,
	maxFileSize = 1024*1024*100,
	maxRequestSize = 1024*1024*100
)
@WebServlet("/admin/product")
public class AdminProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
       
    public AdminProductController() {
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
		
		int id = artist.getArtistId();
		
		String cmd = request.getParameter("cmd");
		if(cmd == null || cmd.equals("")) {
			List<DetailArtistProduct> dto = productService.getArtistProductList(id);
			request.setAttribute("list", dto);
			
			request.getRequestDispatcher("/admin/productList.jsp").forward(request, response);
			return;
		} else if(cmd.equals("update")) {
			String no_ = request.getParameter("no");
			int no = (no_ == null || no_.equals("")) ? Script.back(response, "잘못된 접근입니다.") : Integer.parseInt(no_);
			
			String name = request.getParameter("name");
			
			String price_ = request.getParameter("price");
			int price = (price_ == null || price_.equals("")) ? Script.back(response, "잘못된 접근입니다.") : Integer.parseInt(price_);
			
			String year_ = request.getParameter("year");
			int year = (year_ == null || year_.equals("")) ? Script.back(response, "잘못된 접근입니다.") : Integer.parseInt(year_);
			
			String material = request.getParameter("material");
			
			String text = request.getParameter("text");
			
			String theme_ = request.getParameter("theme");
			int theme = (theme_ == null || theme_.equals("")) ? Script.back(response, "잘못된 접근입니다.") : Integer.parseInt(theme_);
			
			String size_ = request.getParameter("size");
			int size = (size_ == null || size_.equals("")) ? Script.back(response, "잘못된 접근입니다.") : Integer.parseInt(size_);
			
			InsertProductDto dto = new InsertProductDto(no, id, name, price, year, material, text, theme, size);
			
			int result = productService.updateProduct(dto);
			
			if(result != 1) {
				Script.back(response, "작품 정보 수정에 실패했습니다.");
				return;
			}
			
			Script.close(response, "작품 정보를 수정했습니다.");
		} else if(cmd.equals("new")) {
			String name = request.getParameter("name");
			
			Part filePart = request.getPart("file");
			InputStream fis = filePart.getInputStream();
			
			String realPath = request.getServletContext().getRealPath("/img/product");
			String fileName = filePart.getSubmittedFileName();
			String filePath = realPath + File.separator + fileName;
			FileOutputStream fos = new FileOutputStream(filePath);
			
			int b;
			byte[] buf = new byte[1024];
			int bufSize = 0;
			while((bufSize = fis.read(buf)) != -1)
				fos.write(buf,0,bufSize);
			fos.close();
			fis.close();
			
			System.out.println("파일 업로드 성공");
			
			String price_ = request.getParameter("price");
			int price = (price_ == null || price_.equals("")) ? Script.back(response, "잘못된 접근입니다.") : Integer.parseInt(price_);
			
			String year_ = request.getParameter("year");
			int year = (year_ == null || year_.equals("")) ? Script.back(response, "잘못된 접근입니다.") : Integer.parseInt(year_);
			
			String material = request.getParameter("material");
			
			String text = request.getParameter("text");
			
			String theme_ = request.getParameter("theme");
			int theme = (theme_ == null || theme_.equals("")) ? Script.back(response, "잘못된 접근입니다.") : Integer.parseInt(theme_);
			
			String size_ = request.getParameter("size");
			int size = (size_ == null || size_.equals("")) ? Script.back(response, "잘못된 접근입니다.") : Integer.parseInt(size_);
			
			InsertProductDto dto = new InsertProductDto(id, name, fileName, price, year, material, text, theme, size);
			
			int result = productService.insertProduct(dto);
			
			if(result != 1) {
				Script.back(response, "작품 등록에 실패했습니다.");
				return;
			}
			
			Script.close(response, "작품을 등록했습니다.");
		} else if(cmd.equals("delete")) {
			String no_ = request.getParameter("no");
			int no = (no_ == null || no_.equals("")) ? Script.back(response, "잘못된 접근입니다.") : Integer.parseInt(no_);
			
			int result = productService.deleteProduct(no);
			
			if(result != 1) {
				Script.back(response, "작품 삭제에 실패했습니다.");
				return;
			}
			
			Script.close(response, "작품을 삭제했습니다.");
		}
		
	}
	

}
