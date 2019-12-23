package com.kp.foodstore.dao;

import java.util.Set;
import com.kp.foodstore.converter.Status;
import com.kp.foodstore.entities.Client;
import com.kp.foodstore.entities.OrderDetail;
import com.kp.foodstore.entities.Restaurant;

public class OrderDao {
	
	private Integer id;
	private Status status;
	private Client client;
	private Restaurant restaurant;
	private Set<OrderDetail> details;
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}
	
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	public Set<OrderDetail> getDetails() {
		return details;
	}

	public void setDetails(Set<OrderDetail> details) {
		this.details = details;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
}
