package com.kp.foodstore.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kp.foodstore.dao.CategoryDao;
import com.kp.foodstore.entities.Category;
import com.kp.foodstore.entities.Product;
import com.kp.foodstore.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository repository;
	
	public void addProduct(CategoryDao categoryDao) {
		Category category = new Category();
		Set<Product> products = new HashSet<Product>();
		
		categoryDao.getProducts().forEach(e->{
			products.add(new Product(e.getName(), e.getPrice()));
		});
		
		category.setName(categoryDao.getName());
		category.setProducts(categoryDao.getProducts());
		category.setProducts(products);
		repository.save(category);
	}
	
	public Category getCategory(Integer id) {
		return repository.findById(id).get();
	}
	
	public List<Category> getAllById(List<Integer> set) {
		return repository.findByIdIn(set); //STILL CONFUSE aBOUT THIS
	}
	
	public List<Category> getAll() {
		return repository.findAll();
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
