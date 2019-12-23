package com.kp.foodstore.dao;

public class ProductDao {
	private Integer id;
	private String name;
	private Double price;
	
	public ProductDao(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getProductName() {
		return name;
	}

	public void setProductName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
