## FoodDelivery
> Add new User
>  http://localhost:8080/app/client/new
```json
{
    "id": 1,
    "client": "Dacian",
    "restaurant": "DueFratelli",
    "total": 142.2
}

```
> Add new Category  
>  http://localhost:8080/app/category/new
```json
{
	"name" : "pizza",
	"products" : [
			{
				"name" : "pizza margherita",
				"price" : 12.90
			},
			{
				"name" : "pizza romana",
				"price" : 11.10
			},
			{
				"name" : "pizza prosciuto",
				"price" : 12.0
			}
	]
}

```

> Add new Restaurant  
>  http://localhost:8080/app/restaurant/new
```json
{
	"name" : "DueFratelli",
	"address":"mihai viteazu",
	"categories": [1]
}
```

> Add new Order
> http://localhost:8080/app/order/new
```json
{
	"status" : "CONFIRMED",
	"client" : {
				"id": 1
		},
	"restaurant" : {
				"id" : 1	
		},
	"details" : [
		{
			"product" : { "id" : 1 },
			"qty" : 10
		},
		{
			"product" : { "id" : 2 },
			"qty" : 2
		}
	]		
}
}
```
