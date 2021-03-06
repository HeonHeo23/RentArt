package com.rentart.rentart.web.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentart.rentart.domain.artist.dto.ArtistDto;
import com.rentart.rentart.domain.notice.dto.NoticeDetailDto;
import com.rentart.rentart.service.NoticeService;
import com.rentart.rentart.util.Script;

@WebServlet("/admin/notice")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeService noticeService;
       
    public NoticeController() {
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
		String cmd = request.getParameter("cmd");
		
		if(artist == null) {
			Script.back(response, "다시 로그인 해주시기 바랍니다.");
			return;
		}
		
		if(cmd == null) {
			String no_ = request.getParameter("no");
			if(no_ == null || no_.equals("")) {
				Script.back(response, "잘못된 접근입니다.");
				return;
			}
			
			int no = Integer.parseInt(no_);
			
			NoticeDetailDto dto = noticeService.getNoticeDeatil(no);
			
			request.setAttribute("dto", dto);
			
			request.getRequestDispatcher("/admin/noticeDetail.jsp").forward(request, response);
		} else if(cmd.equals("updateNotice")) {
			try {
				String title = request.getParameter("title");
				String text = request.getParameter("text");
				String no_ = request.getParameter("no");
				
				int no = 0;
				no = Integer.parseInt(no_);
				
				int result = noticeService.updateNotice(no, title, text);
				
				if(result != 1) {
					Script.back(response, "작가의 말 수정에 실패했습니다.");
					return;
				}
				Script.close(response, "작가의 말을 수정했습니다.");
			} catch (NumberFormatException e) {
				e.printStackTrace();
				Script.back(response, "잘못된 접근입니다.");
				return;
			}
		} else if(cmd.equals("newNotice")) {
			String title = request.getParameter("title");
			String text = request.getParameter("text");
			int id = artist.getArtistId();
			
			int result = noticeService.insertNotice(id, title, text);
			if(result != 1) {
				Script.back(response, "작가의 말 수정에 실패했습니다.");
				return;
			}
			Script.close(response, "작가의 말을 등록했습니다.");
		} else if(cmd.equals("deleteNotice")) {
			try {
				String no_ = request.getParameter("no");
				int no = Integer.parseInt(no_);
				
				int result = noticeService.deleteNotice(no);
				
				if(result != 1) {
					Script.back(response, "작가의 말 삭제에 실패했습니다.");
					return;
				}
				Script.close(response, "작가의 말을 삭제했습니다.");
			} catch (NumberFormatException e) {
				Script.back(response, "잘못된 접근입니다.");
				return;
			}
			
		} else {
			Script.back(response, "잘못된 접근입니다.");
		}
	}
}
