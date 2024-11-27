package com.tap.dao;

import java.util.ArrayList;

import com.tap.model.OrderTable;

public interface OrderTableDAO {
	int insertOrder(OrderTable  o);
	int deleteOrder(int orderId);
	ArrayList<OrderTable> fetchAllOrders();
	OrderTable fetchOrderById(OrderTable o);
}
