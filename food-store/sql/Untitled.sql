select p.id, p.price as price, o.qty as quantity, sum(price * qa) suma
	from client_order as c
		inner join restaurant as r on c.restaurant_id = r.id
		inner join client as cl on c.client_id = cl.id 
        inner join order_detail as o
				on c.id = o.order_detail_id
        inner join product as p   on o.product_id = p.id
		where c.id = 1        
		group by p.id, o.qty
        
        
       
		
      