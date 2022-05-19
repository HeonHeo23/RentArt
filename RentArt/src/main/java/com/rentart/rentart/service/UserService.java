package com.rentart.rentart.service;

import java.util.List;

import com.rentart.rentart.domain.user.User;
import com.rentart.rentart.domain.user.UserDao;
import com.rentart.rentart.domain.user.dto.JoinUser;
import com.rentart.rentart.domain.user.dto.UserDto;
import com.rentart.rentart.domain.user.dto.UserListDto;

public class UserService {
	
	private UserDao userDao;
	
	public UserService() {
		this.userDao = new UserDao();
	}

	public User login(String email, String password) {
		return userDao.login(email, password);
	}
	
	public int join(JoinUser joinUser) {
		return userDao.join(joinUser);
	}

	//manage
	public List<UserListDto> getUserList(int page, String field, String query) {
		int start = 1+(page-1)*20;
		int end = page*20;
		
		return userDao.find(start, end, field, query);
	}
	public UserDto getUser(int no) {
		return userDao.get(no);
	}

	public int update(int no, JoinUser dto) {
		return userDao.update(no, dto);
	}

	public int delete(int no) {
		return userDao.delete(no);
	}
}
