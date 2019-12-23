package com.kp.foodstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kp.foodstore.dao.ProductDao;
import com.kp.foodstore.entities.Product;
import com.kp.foodstore.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository repository;
	
	public void addProduct(ProductDao productDao) {
		Product product = new Product();
		product.setName(productDao.getProductName());
		product.setPrice(productDao.getPrice());
		repository.save(product);
	}
	
	public Product getProduct(Integer id) {
		return repository.findById(id).get();
	}
	
	public List<Product> getAllProducts() {
		return repository.findAll();
	}
	
	public void delProduct(Integer id) {
		repository.deleteById(id);
	}
	
}
