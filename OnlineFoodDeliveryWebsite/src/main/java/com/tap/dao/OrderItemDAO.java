package com.tap.dao;

import java.util.ArrayList;

import com.tap.model.OrderItem;

public interface OrderItemDAO {
	int insertOrderItems(OrderItem  oi);
	int deleteOrderItems(int orderItemId);
	ArrayList<OrderItem> fetchAllOrderItems();
	OrderItem fetchOrderItems(OrderItem oi);
}
