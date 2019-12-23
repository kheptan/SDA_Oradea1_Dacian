package com.kp.foodstore.converter;

public enum Status {
	CONFIRMED ("C"),
	PROCESSED ("P"),
	DELIVERED ("D");
	
	private String status;

	private Status(String status) {
		this.status = status;
	}

	public String getStats() {
		return status;
	}

	public void setStats(String status) {
		this.status = status;
	}
	
	
	
}
