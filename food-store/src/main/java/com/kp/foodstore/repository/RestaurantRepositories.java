package com.kp.foodstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.kp.foodstore.entities.Restaurant;

public interface RestaurantRepositories extends CrudRepository<Restaurant, Integer> {
	
	<S extends Restaurant> S save(S entity);
	
	Optional<Restaurant> findById(Integer primaryKey);
	
	List<Restaurant> findAll();
	
	void deleteById(Integer id);
	
}
