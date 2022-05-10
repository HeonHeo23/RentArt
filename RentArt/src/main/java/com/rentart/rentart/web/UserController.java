package com.rentart.rentart.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rentart.rentart.domain.user.User;
import com.rentart.rentart.domain.user.dto.JoinUser;
import com.rentart.rentart.service.UserService;
import com.rentart.rentart.util.Script;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
       
    public UserController() {
        super();
        this.userService = new UserService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd = request.getParameter("cmd");
		if(cmd == null) {
			Script.back(response, "잘못된 접근입니다 [user]");
		}
		if(cmd.equals("loginAction")) {
			User user = userService.login(request.getParameter("email"), request.getParameter("password"));
			if(user == null)
				Script.back(response, "아이디 혹은 비밀번호를 다시 확인해주세요.");
			else {
				HttpSession session = request.getSession();
				session.setAttribute("principal", user);
				session.setMaxInactiveInterval(1800);
				response.sendRedirect("/main");
			}
		} else if(cmd.equals("joinAction")) {
			JoinUser joinUser = new JoinUser(request.getParameter("password"),
				request.getParameter("name"),
				request.getParameter("email"),
				request.getParameter("address"));
			int result = userService.join(joinUser);
			if(result == 1) {
				User user = userService.login(request.getParameter("email"), request.getParameter("password"));
				HttpSession session = request.getSession();
				session.setAttribute("principal", user);
				session.setMaxInactiveInterval(1800);
				response.sendRedirect("/main");
			} else {
				Script.back(response, "회원가입에 실패하였습니다.");
			}
		} else {
			Script.back(response, "잘못된 접근입니다 [user]");
		}
	}

}
