package com.rentart.rentart.web.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rentart.rentart.domain.artist.dto.ArtistDto;
import com.rentart.rentart.service.ArtistService;
import com.rentart.rentart.util.Script;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArtistService artistService; 
       
    public AdminController() {
    	artistService = new ArtistService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		HttpSession session = request.getSession();
		ArtistDto artist = (ArtistDto) session.getAttribute("adminPrincipal");
		
		if(cmd == null) {
			if(artist == null) {
				response.sendRedirect("/admin/login");
			}
			else {
				response.sendRedirect("/admin/main");
			}
			return;
		} else if(cmd.equals("loginAction")) {
			
			String id_ = request.getParameter("id");
			if(id_ == null || id_.equals("")) {
				Script.back(response, "아이디를 다시 확인 해주시기 바랍니다.");
				return;
			}
			int id = 0;
			if(id_.matches("\\d+")) {
			     id = Integer.parseInt(id_);
			}
			String password = request.getParameter("password");
			
			ArtistDto dto = artistService.login(id, password);
			
			if(dto == null) {
				Script.back(response, "아이디와 비밀번호를 다시 확인 해주시기 바랍니다.");
			} else {
				session.setAttribute("adminPrincipal", dto);
				session.setMaxInactiveInterval(1800);
				response.sendRedirect("/admin/main");
			}
		} else if(cmd.equals("updateInfo")) {
			String text = request.getParameter("text");
			
			if(artist == null) {
				Script.back(response, "다시 로그인 해주시기 바랍니다.");
				return;
			}
			
			int id = artist.getArtistId();
			
			int result = artistService.updateInfo(id, text);
			
			if(result != 1) {
				Script.back(response, "소개 글 업데이트에 실패 했습니다.");
				return;
			} Script.redirect(response, "소개 글을 성공적으로 업데이트 했습니다.", "/admin/main");
		} else if(cmd.equals("updateArtist")) {
			
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String newPassword = request.getParameter("newPassword");
			
			if(name == null || password == null || newPassword == null) {
				Script.back(response, "입력한 정보를 다시 확인 해주시기 바랍니다.");
				return;
			}
			
			int id = artist.getArtistId();
			
			Object loginResult = artistService.login(id, password);
			if(loginResult == null) {
				Script.back(response, "비밀번호를 다시 확인 해주시기 바랍니다.");
				return;
			}
			
			int result = artistService.updateArtist(id, name, newPassword);
			
			if(result != 1) {
				Script.back(response, "작가 정보 수정에 실패했습니다.");
			}
			Script.close(response, "작가 정보를 수정했습니다.");
			
		} else {
			Script.back(response, "잘못된 접근입니다.");
		}
	}
}