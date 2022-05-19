package com.rentart.rentart.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentart.rentart.domain.magazine.dto.MagazineDto;
import com.rentart.rentart.service.MagazineService;

@WebServlet("/magazine")
public class MagazineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MagazineService magazineService;
       
    public MagazineController() {
    	magazineService = new MagazineService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no_ = request.getParameter("no");
		int lastNo = magazineService.getLastNumber(); 
		int no = (no_ != null && !no_.equals("")) ? Integer.parseInt(no_) : lastNo;
		
		MagazineDto dto = magazineService.getMagazine(no);
		
		request.setAttribute("dto", dto);
		request.setAttribute("lastNo", lastNo);
		request.setAttribute("no", no);
		
		request.getRequestDispatcher("/magazine.jsp").forward(request, response);
	}

}
