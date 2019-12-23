package com.kp.foodstore.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="operator")
public class AppOperator extends AppUser {
	
	public AppOperator() {
		
	}
	public AppOperator(String name) {
		super(name);
	}
	
}
