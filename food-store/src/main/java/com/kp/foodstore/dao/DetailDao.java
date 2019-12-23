package com.kp.foodstore.dao;

public class DetailDao {
	
	private Integer id;
	private ProductDao product;
	private Double qty;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ProductDao getProduct() {
		return product;
	}
	public void setProduct(ProductDao product) {
		this.product = product;
	}
	public Double getQty() {
		return qty;
	}
	public void setQty(Double qty) {
		this.qty = qty;
	}
	
}
