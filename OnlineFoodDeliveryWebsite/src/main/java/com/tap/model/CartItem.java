package com.tap.model;

public class CartItem {
	private int itemId;
	private int restId;
	private String name;
	private float price;
	private int quantity;
	private float subTotal;
	
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartItem(int itemId, int restId, String name, float price, int quantity, float subTotal) {
		super();
		this.itemId = itemId;
		this.restId = restId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.subTotal = subTotal;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getRestId() {
		return restId;
	}

	public void setRestId(int restId) {
		this.restId = restId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	@Override
	public String toString() {
		return "CartItem [itemId=" + itemId + ", restId=" + restId + ", name=" + name + ", price=" + price
				+ ", quantity=" + quantity + ", subTotal=" + subTotal + "]";
	}

	
	
}
