package com.rentart.rentart.web.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rentart.rentart.util.Script;


@WebServlet("/manage")
public class ManageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManageController() {
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
		Boolean login = (Boolean) session.getAttribute("managePrincipal");
		
		if(cmd == null) {
			
			if(login == null) {
				response.sendRedirect("/manage/login");
			}
			else {
				response.sendRedirect("/manage/main");
			}
			
			return;
			
		} else if(cmd.equals("loginAction")) {
			
			String id = request.getParameter("id");
			if(id == null || !id.equals("sonheungmin")) {
				Script.back(response, "아이디를 다시 확인 해주시기 바랍니다.");
				return;
			}
			
			String password = request.getParameter("password");
			if(id == null || !password.equals("tottenham2021")) {
				Script.back(response, "비밀번호를 다시 확인 해주시기 바랍니다.");
				return;
			}
			
			session.setAttribute("managePrincipal", true);
			session.setMaxInactiveInterval(1800);
			response.sendRedirect("/manage/main");
				
		} else {
			Script.back(response, "잘못된 접근입니다.");
		}
	}
}