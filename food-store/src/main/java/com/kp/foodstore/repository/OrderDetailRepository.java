package com.kp.foodstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.kp.foodstore.entities.OrderDetail;

public interface OrderDetailRepository extends CrudRepository<OrderDetail, Integer> {
	
	<T extends OrderDetail> T save(T entity);
}
