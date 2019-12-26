package com.kp.foodstore;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;
import javax.websocket.ClientEndpoint;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.kp.foodstore.converter.Status;
import com.kp.foodstore.entities.Category;
import com.kp.foodstore.entities.Client;
import com.kp.foodstore.entities.Order;
import com.kp.foodstore.entities.OrderDetail;
import com.kp.foodstore.entities.Product;
import com.kp.foodstore.entities.Restaurant;
import com.kp.foodstore.repository.CategoryRepository;
import com.kp.foodstore.repository.ClientRepository;
import com.kp.foodstore.repository.OrderRepository;
import com.kp.foodstore.repository.RestaurantRepositories;

@SpringBootApplication
@ConfigurationPropertiesScan
public class FoodStoreApplication {
	private static final Logger LOG = LoggerFactory.getLogger(FoodStoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(FoodStoreApplication.class, args);
	}
	
	@Autowired
	ClientRepository clientRepo;
	
	@Autowired 
	RestaurantRepositories restaurantRepo;
	
	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	OrderRepository orderRepo;
	
	@Bean
    public CommandLineRunner appOutput() {
		return (args)-> {
			LOG.info("Starting initializing...");
			
			Client client = new Client("Dacian");
			client.setAddress("andrei muresanu nr 13");
			clientRepo.save(client);
			
			Set<Product> products = new HashSet<Product>();
			products.add(new Product("pizza margherita", 20.3));
			products.add(new Product("pizza romana", 22.3));
			products.add(new Product("pizza prosciuto", 24.3));
			
			Category category = new Category("Pizza");
			category.setProducts(products);
			categoryRepo.save(category);
			
			Restaurant restaurant = new Restaurant("Due Fratelli", "Pandurilor 51");
			List<Category> categories = new ArrayList<Category>();
			categories.add(category);
			restaurant.setCategories(categories);
			restaurantRepo.save(restaurant);
			
			OrderDetail details = new OrderDetail();
			details.setQty(2);
			details.setProduct(products.stream().findFirst().get());
			
			Order order = new Order();
			Set<OrderDetail> orderDetails = new HashSet<OrderDetail>();
			orderDetails.add(details);
			
			order.setClient(client);
			order.setRestaurant(restaurant);
			order.setStatus(Status.CONFIRMED);
			order.setOrderDetail(orderDetails);
			orderRepo.save(order);
			
		};
	}
}
