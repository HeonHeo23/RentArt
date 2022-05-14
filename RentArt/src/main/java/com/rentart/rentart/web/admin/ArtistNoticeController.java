package com.rentart.rentart.web.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rentart.rentart.domain.artist.dto.ArtistDto;
import com.rentart.rentart.domain.notice.dto.NoticeListDto;
import com.rentart.rentart.service.ArtistService;
import com.rentart.rentart.service.NoticeService;
import com.rentart.rentart.util.Script;


@WebServlet("/admin/artistNotice")
public class ArtistNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeService noticeService;
       
    public ArtistNoticeController() {
    	noticeService = new NoticeService();
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
		
		int id = artist.getArtistId();
		
		List<NoticeListDto> list = noticeService.getNoticeList(id);
		
		request.setAttribute("notice", list);
		
		request.getRequestDispatcher("/admin/artistNotice.jsp").forward(request, response);
	}
}