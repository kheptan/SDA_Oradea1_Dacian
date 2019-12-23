package com.kp.foodstore.dao;

import java.util.HashSet;
import java.util.Set;

import com.kp.foodstore.entities.Product;
import com.kp.foodstore.entities.Restaurant;

public class CategoryDao {
	private Integer id;
	private String name;
	private Set<Product> products = new HashSet<Product>();
	private Set<Restaurant> restaurants = new HashSet<Restaurant>();
	
	public CategoryDao(String name, Set<Product> products) {
		this.name = name;
		this.products = products;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Set<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(Set<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
