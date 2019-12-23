package com.kp.foodstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.kp.foodstore.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	<S extends Product> S save(S entity);
	
	Optional<Product> findById(Integer primaryKey);
	
	List<Product> findAll();
	
	void deleteById(Integer id);
}
