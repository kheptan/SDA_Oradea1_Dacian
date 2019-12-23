package com.kp.foodstore.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kp.foodstore.dao.RestaurantDao;
import com.kp.foodstore.entities.Category;
import com.kp.foodstore.entities.Restaurant;
import com.kp.foodstore.repository.RestaurantRepositories;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepositories repository;

	@Autowired
	CategoryService categoryService;
	
	public void addRestaurant(RestaurantDao restaurantDao) {
		List<Category> categories = new ArrayList<Category>();
		Restaurant restaurant = new Restaurant();
		
		categories = categoryService.getAllById(restaurantDao.getCategories());
		restaurant.setName(restaurantDao.getName());
		restaurant.setAddress(restaurantDao.getAddress());
		restaurant.setCategories(categories);
		
		repository.save(restaurant);
	}
	
	public Restaurant getRestaurant(Integer id) {
		return repository.findById(id).get();
	}
	
	public List<Restaurant> getAllRestaurants() {
		return repository.findAll();
	}
	
	public void delRestaurantById(Integer id) {
		repository.deleteById(id);
	}
}
