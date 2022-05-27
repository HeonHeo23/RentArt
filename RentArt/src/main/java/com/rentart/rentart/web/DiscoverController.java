package com.rentart.rentart.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentart.rentart.domain.product.dto.ThumbnailProduct;
import com.rentart.rentart.domain.user.User;
import com.rentart.rentart.service.FavoriteService;
import com.rentart.rentart.service.ProductService;
import com.rentart.rentart.util.Script;

@WebServlet(urlPatterns = {"/discover"})
public class DiscoverController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
       
    public DiscoverController() {
    	productService = new ProductService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		if(cmd == null) {
			try {
				String page_ = request.getParameter("pg");
				String field = request.getParameter("f");
				String query = request.getParameter("q");
				String[] ft_ = request.getParameterValues("ft");
				String[] fs_ = request.getParameterValues("fs");
				String[] fp_ = request.getParameterValues("fp");
				
				int page = (page_ == null || page_.equals("")) ? 1 : Integer.parseInt(page_);
				
				field = (field == null || field.equals(""))? "p_name" : field;
				query = (query == null || query.equals(""))? "" : query;
				
				int[] ft = new int[]{1,2,3,4};
				int[] fs = new int[]{1,2,3,4,5,6,7};
				int[] fp = new int[]{1,2,3,4,5,6,7,8};
				
				if(ft_!=null)
					ft = Arrays.stream(ft_).mapToInt((Integer::parseInt)).toArray();
				if(fs_!=null)
					fs = Arrays.stream(fs_).mapToInt((Integer::parseInt)).toArray();
				if(fp_!=null)
					fp = Arrays.stream(fp_).mapToInt((Integer::parseInt)).toArray();
				
				List<ThumbnailProduct> list = productService.getProductList(field, query, page, ft, fs, fp);
				int count = productService.countProductList(field, query, ft, fs, fp);
				List<Integer> fList = null;
				
				User user = (User) request.getSession().getAttribute("principal");
				if(user != null) {
					FavoriteService favoriteService = new FavoriteService();
					fList = favoriteService.getFavoriteIds(user.getKey());
				}
				fList = (fList == null) ? Arrays.asList(0) : fList; 
				
				String tFt = ft_ == null ? null : String.join(",", ft_);
				String tFs = fs_ == null ? null : String.join(",", fs_);
				String tFp = fp_ == null ? null : String.join(",", fp_);
				
				request.setAttribute("list", list);
				request.setAttribute("ls", (list.size()-1)/4+1);
				request.setAttribute("count", count);
				request.setAttribute("fList", fList);
				request.setAttribute("ft", tFt);
				request.setAttribute("fs", tFs);
				request.setAttribute("fp", tFp);
				request.getRequestDispatcher("/discover.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			Script.back(response, "잘못되 접근입니다.");
		}
	}

}
