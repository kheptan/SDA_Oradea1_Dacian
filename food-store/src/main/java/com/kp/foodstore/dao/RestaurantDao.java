package com.kp.foodstore.dao;

import java.util.List;
public class RestaurantDao {

	private Integer id;
	private String name;
	private String address;
	private List<Integer> categories;
	
	public RestaurantDao() {
	}

	public RestaurantDao(String name, String address ) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public List<Integer> getCategories() {
		return categories;
	}

	public void setCategories(List<Integer> categories) {
		this.categories = categories;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
