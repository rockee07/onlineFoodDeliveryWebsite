package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.tap.dao.OrderHistoryDAO;
import com.tap.model.OrderHistory;
import com.tap.util.MyConnection;

public class OrderHistoryDAOImpl implements OrderHistoryDAO {

    private MyConnection myCon;
    private Connection connection;
    private PreparedStatement pstmt;
    private int status;

    ArrayList<OrderHistory> orderHistoryList = new ArrayList<>();
    private PreparedStatement stmt;
    private ResultSet res;
    private OrderHistory orderHistory;

    private static final String ADD_ORDER_HISTORY = "insert into orderhistory(orderId,userId,orderDate,totalAmount,status) values(?,?,?,?,?)";
    private static final String FETCH_ALL_ORDER_HISTORY = "select * from orderhistory";
    private static final String FETCH_ORDER_HISTORY = "select * from orderhistory where userId=?";
    private static final String DELETE_ORDER_HISTORY = "delete from orderhistory where userId=?";

    public OrderHistoryDAOImpl() {
        myCon = MyConnection.getMyConnection();
        connection = myCon.connect();
    }

    @Override
    public int insertOrderHistory(OrderHistory oh) {
        try {
            pstmt = connection.prepareStatement(ADD_ORDER_HISTORY);
            pstmt.setInt(1, oh.getOrderId());
            pstmt.setInt(2, oh.getUserId());
            pstmt.setString(3, oh.getOrderDate());
            pstmt.setFloat(4, oh.getTotalAmount());
            pstmt.setString(5, oh.getStatus());

            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public ArrayList<OrderHistory> fetchAllOrderHistory() {
        try {
            stmt = connection.prepareStatement(FETCH_ALL_ORDER_HISTORY);
            res = stmt.executeQuery();
            orderHistoryList = extractOrderHistoryFromResultSet(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderHistoryList;
    }

    @Override
    public ArrayList<OrderHistory> fetchOrderHistory(int userId) {
        try {
            pstmt = connection.prepareStatement(FETCH_ORDER_HISTORY);
            pstmt.setInt(1, userId);
            res = pstmt.executeQuery();
            orderHistoryList = extractOrderHistoryFromResultSet(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderHistoryList;
    }

    @Override
    public int deleteOrderHistory(int orderHistoryId) {
        try {
            pstmt = connection.prepareStatement(DELETE_ORDER_HISTORY);
            pstmt.setInt(1, orderHistoryId);
            status = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    private ArrayList<OrderHistory> extractOrderHistoryFromResultSet(ResultSet res) {
        try {
            while (res.next()) {
                orderHistoryList.add(new OrderHistory(
                    res.getInt("orderHistoryId"),
                    res.getInt("orderId"),
                    res.getInt("userId"),
                    res.getString("orderDate"),
                    res.getFloat("totalAmount"),
                    res.getString("status")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderHistoryList;
    }
}


