package com.rentart.rentart.web.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentart.rentart.domain.artist.dto.ArtistDto;
import com.rentart.rentart.util.Script;

@WebServlet("/admin/product/new")
public class NewProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public NewProductController() {
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
			Script.back(response, "로그인 해주시기 바랍니다.");
			return;
		}
		
		request.getRequestDispatcher("/admin/newProduct.jsp").forward(request, response);		
	}

}
