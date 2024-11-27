package com.tap.dao;

import java.util.ArrayList;

import com.tap.model.OrderHistory;

public interface OrderHistoryDAO {
	int insertOrderHistory(OrderHistory oh);
	int deleteOrderHistory(int orderHistoryId);
	ArrayList<OrderHistory> fetchAllOrderHistory();
	ArrayList<OrderHistory> fetchOrderHistory(int userId);
}
