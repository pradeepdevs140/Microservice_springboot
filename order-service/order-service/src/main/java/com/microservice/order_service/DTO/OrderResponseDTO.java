package com.microservice.order_service.DTO;

public class OrderResponseDTO {

	private Long orderId;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	private Long productId;
	private int quantity;
	private double totalprice;
	
	private String ProductName;
	private double productPrice;
	public OrderResponseDTO(Long orderId, Long productId, int quantity, double totalprice, String productName,
			double productPrice) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.totalprice = totalprice;
		ProductName = productName;
		this.productPrice = productPrice;
	}
	public OrderResponseDTO() {
		
	}
}
