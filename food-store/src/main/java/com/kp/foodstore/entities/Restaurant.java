package com.kp.foodstore.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String address;
	
	@OneToMany(mappedBy = "restaurant")
	private Set<Order> order;
	
	@ManyToMany
	private List<Category> categories;
	
	public Restaurant() {}
	
	public Restaurant(String name, String address) {
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

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories2) {
		this.categories = categories2;
	}
	
	
	
}
