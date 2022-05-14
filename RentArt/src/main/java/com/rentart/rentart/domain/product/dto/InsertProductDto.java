package com.rentart.rentart.domain.product.dto;

public class InsertProductDto {
	private int pId;
	private int aId;
	private String name;
	private String img;
	private int price;
	private int year;
	private String material;
	private String text;
	private int theme;
	private int size;
	
	public InsertProductDto(int pId, int aId, String name, int price, int year, String material, String text, int theme,
			int size) {
		this.pId = pId;
		this.aId = aId;
		this.name = name;
		this.price = price;
		this.year = year;
		this.material = material;
		this.text = text;
		this.theme = theme;
		this.size = size;
	}
	
	public InsertProductDto(int aId, String name, String img, int price, int year, String material, String text, 
			int theme, int size) {
		this.aId = aId;
		this.name = name;
		this.img = img;
		this.price = price;
		this.year = year;
		this.material = material;
		this.text = text;
		this.theme = theme;
		this.size = size;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}
	
	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getTheme() {
		return theme;
	}

	public void setTheme(int theme) {
		this.theme = theme;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
