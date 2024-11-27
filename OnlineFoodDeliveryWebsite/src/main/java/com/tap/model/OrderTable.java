package com.tap.model;

public class OrderTable {
	private int orderId;
	private int restId;
	private int userId;
	private String orderDate;
	private float totalAmount;
	private String status;
	private String paymentMethod;
	
	public OrderTable() {
		super();
		
	}

	public OrderTable(int orderId, int restId, int userId, String orderDate, float totalAmount, String status,
			String paymentMethod) {
		super();
		this.orderId = orderId;
		this.restId = restId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMethod = paymentMethod;
	}

	public OrderTable(int restId, int userId, String orderDate, float totalAmount, String status,
			String paymentMethod) {
		super();
		this.restId = restId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMethod = paymentMethod;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getRestId() {
		return restId;
	}

	public void setRestId(int restId) {
		this.restId = restId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "OrderTable [orderId=" + orderId + ", restId=" + restId + ", userId=" + userId + ", orderDate="
				+ orderDate + ", totalAmount=" + totalAmount + ", status=" + status + ", paymentMethod=" + paymentMethod
				+ "]";
	}
}
