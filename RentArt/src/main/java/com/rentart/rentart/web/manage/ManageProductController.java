package com.rentart.rentart.web.manage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.rentart.rentart.domain.product.dto.InsertProductDto;
import com.rentart.rentart.domain.product.dto.ManageProductDto;
import com.rentart.rentart.service.ProductService;
import com.rentart.rentart.util.Script;

@MultipartConfig(
	fileSizeThreshold = 1024*1024,
	maxFileSize = 1024*1024*100,
	maxRequestSize = 1024*1024*100
)
@WebServlet("/manage/product")
public class ManageProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
       
    public ManageProductController() {
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
		
		String cmd = request.getParameter("cmd");
		if(cmd == null || cmd.equals("")) {
			String pg_ = request.getParameter("pg");
			int pg = (pg_ == null || pg_.equals("")) ? 1 : Integer.parseInt(pg_);
			String field = request.getParameter("field");
			field = (field == null || field.equals(""))? "p_name" : field;
			String query = request.getParameter("query");
			query = (query == null)? "%" : query;
			
			List<ManageProductDto> list = productService.getManageProductListAll(pg, field, query);
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("/manage/productList.jsp").forward(request, response);
			return;
		} else if(cmd.equals("update")) {
			try {
				String no_ = request.getParameter("no");
				int no = Integer.parseInt(no_);
				
				String id_ = request.getParameter("artistId");
				int id = Integer.parseInt(id_);
				
				String name = request.getParameter("name");
				
				String price_ = request.getParameter("price");
				int price = Integer.parseInt(price_);
				
				String year_ = request.getParameter("year");
				int year = Integer.parseInt(year_);
				
				String material = request.getParameter("material");
				
				String text = request.getParameter("text");
				
				String theme_ = request.getParameter("theme");
				int theme = Integer.parseInt(theme_);
				
				String size_ = request.getParameter("size");
				int size = Integer.parseInt(size_);
				
				InsertProductDto dto = new InsertProductDto(no, id, name, price, year, material, text, theme, size);
				
				int result = productService.updateProduct(dto);
				
				if(result != 1) {
					Script.back(response, "작품 정보 수정에 실패했습니다.");
					return;
				}
				
				Script.close(response, "작품 정보를 수정했습니다.");
			} catch(NumberFormatException e) {
				e.printStackTrace();
				Script.back(response, "내용을 다시 확인해 주시기 바랍니다.");
				return;
			} catch(Exception e) {
				e.printStackTrace();
				Script.back(response, "잘못된 접근입니다.");
				return;
			}
			
		} else if(cmd.equals("rent")) {
			try {
				String[] ids_ = request.getParameterValues("ids");
				int[] ids = Arrays.stream(ids_).mapToInt(Integer::parseInt).toArray();
				String[] rents_ = request.getParameterValues("rents");
				List<Integer> rents = Arrays.stream(rents_).map(t -> Integer.valueOf(t)).toList();
				List<Integer> nonRents = new ArrayList<Integer>();
				
				for(int i : ids) {
					if(rents.contains(i))
						continue;
					nonRents.add(i);
				}
				
				productService.setRentProduct(rents);
				productService.setNoRentProduct(nonRents);
				
				Script.back(response, "대여 여부를 업데이트 했습니다.");
			} catch (Exception e) {
				e.printStackTrace();
				Script.back(response, "잘못된 접근입니다.");
			}
		} else if(cmd.equals("new")) {
			try {
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
				
				String id_ = request.getParameter("artistId");
				int id = Integer.parseInt(id_);
				
				String price_ = request.getParameter("price");
				int price = Integer.parseInt(price_);
				
				String year_ = request.getParameter("year");
				int year = Integer.parseInt(year_);
				
				String material = request.getParameter("material");
				
				String text = request.getParameter("text");
				
				String theme_ = request.getParameter("theme");
				int theme = Integer.parseInt(theme_);
				
				String size_ = request.getParameter("size");
				int size = Integer.parseInt(size_);
				
				InsertProductDto dto = new InsertProductDto(id, name, fileName, price, year, material, text, theme, size);
				
				int result = productService.insertProduct(dto);
				
				if(result != 1) {
					Script.back(response, "작품 등록에 실패했습니다.");
					return;
				}
				
				Script.close(response, "작품을 등록했습니다.");
			} catch(NumberFormatException e) {
				e.printStackTrace();
				Script.back(response, "내용을 다시 확인해 주시기 바랍니다.");
				return;
			} catch (Exception e) {
				e.printStackTrace();
				Script.back(response, "잘못된 접근입니다.");
			}
			
		} else if(cmd.equals("delete")) {
			try {
				String no_ = request.getParameter("no");
				int no = Integer.parseInt(no_);
				int result = productService.deleteProduct(no);
				
				if(result != 1) {
					Script.back(response, "작품 삭제에 실패했습니다.");
					return;
				}
				
				Script.close(response, "작품을 삭제했습니다.");
			} catch (Exception e) {
				e.printStackTrace();
				Script.back(response, "잘못된 접근입니다.");
			}
			
		} else {
			Script.back(response, "잘못된 접근입니다.");
		}
		
	}
	
}
