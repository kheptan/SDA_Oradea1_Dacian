package com.kp.foodstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.kp.foodstore.entities.AppOperator;
import com.kp.foodstore.entities.Category;

public interface ProductCategoryRepository 
       extends CrudRepository<Category, Integer> {
	
	<S extends AppOperator> S save(S entity);
	
}
