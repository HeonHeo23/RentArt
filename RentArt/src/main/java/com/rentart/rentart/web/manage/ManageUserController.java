package com.rentart.rentart.web.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentart.rentart.domain.user.dto.UserListDto;
import com.rentart.rentart.service.UserService;
import com.rentart.rentart.util.Script;

@WebServlet("/manage/user")
public class ManageUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	
    public ManageUserController() {
    	userService = new UserService();
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
		
		String cmd = request.getParameter("cmd");
		if(cmd == null || cmd.equals("")) {
			String pg_ = request.getParameter("pg");
			int pg = (pg_ == null || pg_.equals("")) ? 1 : Integer.parseInt(pg_);
			String field = request.getParameter("field");
			field = (field == null || field.equals(""))? "user_name" : field;
			String query = request.getParameter("query");
			query = (query == null)? "%" : query;
			
			List<UserListDto> list = userService.getUserList(pg, field, query);
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("/manage/userList.jsp").forward(request, response);
			return;
		}
	}
}
