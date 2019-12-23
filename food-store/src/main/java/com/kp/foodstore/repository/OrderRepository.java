package com.kp.foodstore.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.kp.foodstore.entities.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

	<T extends Order> T save(T entity);
	
	@Query(
			" select o.id as id, "
			+ 	"c.name as client, "
			+   "r.name as restaurant,"
			+ 	" sum(d.qty * p.price) as total "+
			" from Order o "+
			" join o.restaurant r "+		
			" join o.orderDetail d "+
			" join o.client c "+
			" join d.product p"+
			" where o.id = ?1 ")
	OrderTotal getTotalResult(Integer id);

}
