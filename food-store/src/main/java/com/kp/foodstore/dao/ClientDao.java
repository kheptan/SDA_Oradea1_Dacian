package com.kp.foodstore.dao;

import java.util.Set;

import com.kp.foodstore.entities.Order;

public class ClientDao {
	//private Integer id;
	private String name;
	private Integer phone;
	private String address;
	//Set<Order> orders;
	
	public ClientDao() {
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
}
