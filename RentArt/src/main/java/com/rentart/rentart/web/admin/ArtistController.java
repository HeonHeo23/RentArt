package com.rentart.rentart.web.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentart.rentart.domain.artist.dto.ArtistDto;
import com.rentart.rentart.util.Script;

@WebServlet("/admin/artist")
public class ArtistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ArtistController() {
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
			Script.redirect(response, "로그인 해주시기 바랍니다.", "/admin/login");
			return;
		}
		
		request.setAttribute("artist", artist);
		
		request.getRequestDispatcher("/admin/artist.jsp").forward(request, response);
	}
	
	

}
