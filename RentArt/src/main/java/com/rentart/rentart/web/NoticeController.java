package com.rentart.rentart.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentart.rentart.domain.notice.dto.NoticeDetailDto;
import com.rentart.rentart.service.NoticeService;
import com.rentart.rentart.util.Script;

@WebServlet("/notice")
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
		String cmd = request.getParameter("cmd");
		if(cmd == null || cmd.equals("")) {
			Script.close(response, "잘못된 접근입니다.");
			return;
		} else if(cmd.equals("view")) {
			String no_ = request.getParameter("no");
			if(no_ == null && no_.equals(""))
				Script.close(response, "잘못된 접근입니다.");
			else {
				int no = Integer.parseInt(no_);
				NoticeDetailDto dto = noticeService.getNoticeDeatil(no);
				
				request.setAttribute("dto", dto);
				
				request.getRequestDispatcher("/noticeDetail.jsp").forward(request, response);
			}
		} else {
			Script.back(response, "잘못된 접근입니다.");
		}
	}
}