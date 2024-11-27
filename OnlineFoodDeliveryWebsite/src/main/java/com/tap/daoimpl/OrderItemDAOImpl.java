package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.tap.dao.OrderItemDAO;
import com.tap.model.OrderItem;
import com.tap.util.MyConnection;

public class OrderItemDAOImpl implements OrderItemDAO {

    private MyConnection myCon;
    private Connection connection;
    private PreparedStatement pstmt;
    private int status;

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    private PreparedStatement stmt;
    private ResultSet res;
    private OrderItem orderItem;

    private static final String ADD_ORDER_ITEM = "insert into orderitem(orderId,menuId,quantity,subTotal) values(?,?,?,?)";
    private static final String FETCH_ALL_ORDER_ITEMS = "select * from orderitem";
    private static final String FETCH_ORDER_ITEM = "select * from orderitem where orderItemId=?";
    private static final String DELETE_ORDER_ITEM = "delete from orderitem where orderItemId=?";

    public OrderItemDAOImpl() {
        myCon = MyConnection.getMyConnection();
        connection = myCon.connect();
    }

    @Override
    public int insertOrderItems(OrderItem oi) {
        try {
            pstmt = connection.prepareStatement(ADD_ORDER_ITEM);
            pstmt.setInt(1, oi.getOrderId());
            pstmt.setInt(2, oi.getMenuId());
            pstmt.setInt(3, oi.getQuantity());
            pstmt.setFloat(4, oi.getSubTotal());

            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public ArrayList<OrderItem> fetchAllOrderItems() {
        try {
            stmt = connection.prepareStatement(FETCH_ALL_ORDER_ITEMS);
            res = stmt.executeQuery();
            orderItemList = extractOrderItemFromResultSet(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderItemList;
    }

    @Override
    public OrderItem fetchOrderItems(OrderItem oi) {
        try {
            pstmt = connection.prepareStatement(FETCH_ORDER_ITEM);
            pstmt.setInt(1, oi.getOrderItemId());
            res = pstmt.executeQuery();
            orderItemList = extractOrderItemFromResultSet(res);
            if (!orderItemList.isEmpty()) {
                orderItem = orderItemList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderItem;
    }

    @Override
    public int deleteOrderItems(int orderItemId) {
        try {
            pstmt = connection.prepareStatement(DELETE_ORDER_ITEM);
            pstmt.setInt(1, orderItemId);
            status = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    private ArrayList<OrderItem> extractOrderItemFromResultSet(ResultSet res) {
        try {
            while (res.next()) {
                orderItemList.add(new OrderItem(
                    res.getInt("orderItemId"),
                    res.getInt("orderId"),
                    res.getInt("menuId"),
                    res.getInt("quantity"),
                    res.getFloat("subTotal")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderItemList;
    }
}

