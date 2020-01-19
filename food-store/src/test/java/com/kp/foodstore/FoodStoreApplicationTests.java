package com.kp.foodstore;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kp.foodstore.entities.Product;
import com.kp.foodstore.repository.ProductRepository;

@SpringBootTest
class FoodStoreApplicationTests {

	/*
	@Autowired 
	ProductRepository repo;
	*/
	
	@Test
	void contextLoads() {
		/*
		Product product  = new Product("pizza", 20.9);
		Product savedRepo = repo.save(product);
		assertEquals("pizza", savedRepo.getName());
		*/
	}

}
