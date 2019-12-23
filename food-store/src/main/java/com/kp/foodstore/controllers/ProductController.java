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

import com.kp.foodstore.dao.ProductDao;
import com.kp.foodstore.entities.Product;
import com.kp.foodstore.service.ProductService;

@RestController
@RequestMapping(path="/app/product")
public class ProductController {
	
	@Autowired
	ProductService productService;

	@PostMapping("/new")
	public void addProduct(@RequestBody ProductDao product) {
		productService.addProduct(product);
	}
	
	@GetMapping(path = "/get/{id}")
	public Product getProduct(@PathVariable Integer id) {
		Product product = productService.getProduct(id);
	    return product;
	}
	
	@GetMapping(path = "/get/all")
	public List<Product> getAll() {
		return productService.getAllProducts();
	}
	
	@DeleteMapping(path = "/del/{id}")
	public @ResponseBody String delProduct(@PathVariable Integer id) {
		productService.delProduct(id);
		return "Deleted";
	}
}
