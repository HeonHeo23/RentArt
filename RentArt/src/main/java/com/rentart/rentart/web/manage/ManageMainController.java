package com.rentart.rentart.web.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentart.rentart.domain.artist.ArtistDao;
import com.rentart.rentart.domain.artist.dto.ArtistDto;
import com.rentart.rentart.util.Script;

@WebServlet("/manage/main")
public class ManageMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArtistDao artistDao;
       
    public ManageMainController() {
    	artistDao = new ArtistDao();
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
		
		request.getRequestDispatcher("/manage/main.jsp").forward(request, response);
	}
	
	

}
