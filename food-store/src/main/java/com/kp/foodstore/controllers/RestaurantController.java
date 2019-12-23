package com.kp.foodstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kp.foodstore.dao.RestaurantDao;
import com.kp.foodstore.entities.Restaurant;
import com.kp.foodstore.service.RestaurantService;

@RestController
@RequestMapping(path="/app/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantService handler;
    
	@PostMapping("/new")
	public void addRestaurant(@RequestBody RestaurantDao dao ) {
		handler.addRestaurant(dao);
	}
	
	@GetMapping(path = "/get/{id}")
	public Restaurant getRestaurant(@PathVariable Integer id) {
		Restaurant restaurant = handler.getRestaurant(id);
	    return restaurant;
	}
	
	@GetMapping(path = "/get/all")
	public List<Restaurant> getAll() {
		return handler.getAllRestaurants();
	}
	
	@DeleteMapping(path = "/del/{id}")
	public @ResponseBody String delRestaurant(@PathVariable Integer id) {
		handler.delRestaurantById(id);
		return "Deleted";
	}
}
