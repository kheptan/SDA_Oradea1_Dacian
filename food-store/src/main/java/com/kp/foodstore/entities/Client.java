package com.kp.foodstore.entities;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client extends AppUser {

	private Integer id;
	
	public Integer getId() {
		return id;
	}

	private Integer phone;
	
	private String address;
	
	@OneToMany(mappedBy = "client")
	private Set<Order> orders;
	
	public Client() {}
	
	public Client(String name) {
		super(name);
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

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
}
