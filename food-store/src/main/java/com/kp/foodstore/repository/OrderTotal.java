package com.kp.foodstore.repository;

import org.springframework.beans.factory.annotation.Value;

public interface OrderTotal {
	@Value("#{target.id}")
	Integer getId();
	
	@Value("#{target.client}")
	String getClient();
	
	@Value("#{target.restaurant}")
	String getRestaurant();
	
	@Value("#{target.total}")
	Double getTotal();
}
