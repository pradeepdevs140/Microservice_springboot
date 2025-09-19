package com.microservice.order_service.DTO;

public class ProductDTO {

	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public ProductDTO(Long id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public  ProductDTO() {
		
	}
	public void setPrice(double price) {
		this.price = price;
	}
	private String name;
	private double price;
}
