package com.rentart.rentart.domain.product;

import java.sql.Timestamp;

public class Product {
	private int key;
	private String password;
	private String name;
	private String email;
	private String address;
	private Timestamp joinDate;
	
	public Product(int key, String password, String name, String email, String address, Timestamp joinDate) {
		this.key = key;
		this.password = password;
		this.name = name;
		this.email = email;
		this.address = address;
		this.joinDate = joinDate;
	}
	
	public Product() {
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
	public Timestamp getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}
	
}