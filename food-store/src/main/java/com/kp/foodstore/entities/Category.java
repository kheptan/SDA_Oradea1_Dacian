package com.kp.foodstore.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="category")
public class Category {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER, 
			orphanRemoval = true)	
	@JoinColumn(name = "category_id")
	private Set<Product> products;
	
	@JsonManagedReference
	@ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
	private  Set<Restaurant> restaurants;
	
	public Category(){}
	
	public Category(String name){
		this.name = name;
		this.products = new HashSet<Product>();
	}
	
	public Category(String name, Set<Product> products){
		this.name = name;
		this.products = products;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(Set<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	
}
