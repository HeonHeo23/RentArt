package com.rentart.rentart.domain.user.dto;

import java.sql.Timestamp;

public class UserDto {
	int key;
	String password;
	String name;
	String email;
	String address;
	Timestamp regDate;
	
	public UserDto(int key, String password, String name, String email, String address, Timestamp regDate) {
		this.key = key;
		this.password = password;
		this.name = name;
		this.email = email;
		this.address = address;
		this.regDate = regDate;
	}
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
}
