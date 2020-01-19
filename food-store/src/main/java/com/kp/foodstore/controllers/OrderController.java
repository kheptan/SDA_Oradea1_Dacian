package com.kp.foodstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kp.foodstore.dao.OrderDao;
import com.kp.foodstore.repository.OrderTotal;
import com.kp.foodstore.service.OrderService;

@RestController
@RequestMapping(path="/app/order")
public class OrderController {
	
	@Autowired
	OrderService service;
	
	@PostMapping(path="/new")
	public void addOrder(@RequestBody OrderDao order) {
		service.add(order);
	}
	
	@GetMapping(path = "/get/{id}")
	public OrderTotal getOrder(@PathVariable Integer id) {
		return service.getOrder(id);
	}
	
	@GetMapping(path="/get/all")
	public List<OrderTotal> getAll(){
		return service.getAllOrders();
	}
	
	
}
