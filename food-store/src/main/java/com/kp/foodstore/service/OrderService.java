package com.kp.foodstore.service;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kp.foodstore.dao.OrderDao;
import com.kp.foodstore.entities.Client;
import com.kp.foodstore.entities.Order;
import com.kp.foodstore.entities.OrderDetail;
import com.kp.foodstore.entities.Restaurant;
import com.kp.foodstore.repository.OrderRepository;
import com.kp.foodstore.repository.OrderTotal;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository repository;
	
	@Autowired
	ClientService clientService;
	
	@Autowired 
	RestaurantService restaurantService;
	
	public void add(OrderDao dao) {
		Order order = new Order();
		Client client;
		Restaurant restaurant;
		
		Integer idClient = dao.getClient().getId();
		Integer idRestaurant = dao.getRestaurant().getId();
		
		//dummy check
		if (idClient == null ) {
			client = dao.getClient();
		} else {
			client = clientService.getClient(idClient); //should be a valid id :)		
		}

		restaurant = restaurantService.getRestaurant(idRestaurant); // ...same here

		Set<OrderDetail> details = new HashSet<OrderDetail>(); 
		details = dao.getDetails();
		
		order.setOrderDetail(details);
		order.setRestaurant(restaurant);
		order.setStatus(dao.getStatus());
		order.setClient(client);
		
		repository.save(order);
	}

	public OrderTotal getOrder(Integer id) {
		
		return repository.getTotalResult(id);
	}
}
