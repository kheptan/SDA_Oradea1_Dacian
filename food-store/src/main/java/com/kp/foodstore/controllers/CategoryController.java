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

import com.kp.foodstore.dao.CategoryDao;
import com.kp.foodstore.entities.Category;
import com.kp.foodstore.service.CategoryService;

@RestController
@RequestMapping(path="/app/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@PostMapping(path="/new")
	public void addCategory(@RequestBody CategoryDao category) {
		categoryService.addProduct(category);
	}
	

	@GetMapping(path = "/get/{id}")
	public Category getCategory(@PathVariable Integer id) {
		Category category = categoryService.getCategory(id);
	    return category;
	}
	
	@GetMapping(path = "/get/all")
	public List<Category> getAll() {
		return categoryService.getAll();
	}
	
	@DeleteMapping(path = "/del/{id}")
	public @ResponseBody String delCategory(@PathVariable Integer id) {
		categoryService.delete(id);
		return "Deleted";
	}

}
