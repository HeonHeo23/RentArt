package com.rentart.rentart.service;

import com.rentart.rentart.domain.user.User;
import com.rentart.rentart.domain.user.UserDao;

public class UserService {
	
	private UserDao userDao;
	
	public UserService() {
		this.userDao = new UserDao();
	}

	public User login(String email, String password) {
		return userDao.login(email, password);
	}
}
