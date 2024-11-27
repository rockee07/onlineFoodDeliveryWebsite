package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.tap.dao.OrderTableDAO;
import com.tap.model.OrderTable;
import com.tap.util.MyConnection;

public class OrderTableDAOImpl implements OrderTableDAO {

    private MyConnection myCon;
    private Connection connection;
    private PreparedStatement pstmt;
    private int status;

    ArrayList<OrderTable> orderList = new ArrayList<>();
    private PreparedStatement stmt;
    private ResultSet res;
    private OrderTable order;

    private static final String ADD_ORDER = "insert into ordertable(restId,userId,totalAmount,status,paymentMethod) values(?,?,?,?,?)";
    private static final String FETCH_ALL_ORDERS = "select * from ordertable";
    private static final String FETCH_ORDER = "select * from ordertable where orderId=?";
    private static final String DELETE_ORDER = "delete from ordertable where orderId=?";

    public OrderTableDAOImpl() {
        myCon = MyConnection.getMyConnection();
        connection = myCon.connect();
    }

    @Override
    public int insertOrder(OrderTable o) {
        try {
            pstmt = connection.prepareStatement(ADD_ORDER);
            pstmt.setInt(1, o.getRestId());
            pstmt.setInt(2, o.getUserId());
            pstmt.setFloat(3, o.getTotalAmount());
            pstmt.setString(4, o.getStatus());
            pstmt.setString(5, o.getPaymentMethod());

            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public ArrayList<OrderTable> fetchAllOrders() {
        try {
            stmt = connection.prepareStatement(FETCH_ALL_ORDERS);
            res = stmt.executeQuery();
            orderList = extractOrderFromResultSet(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public OrderTable fetchOrderById(OrderTable o) {
        try {
            pstmt = connection.prepareStatement(FETCH_ORDER);
            pstmt.setInt(1, o.getOrderId());
            res = pstmt.executeQuery();
            orderList = extractOrderFromResultSet(res);
            if (!orderList.isEmpty()) {
                order = orderList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public int deleteOrder(int orderId) {
        try {
            pstmt = connection.prepareStatement(DELETE_ORDER);
            pstmt.setInt(1, orderId);
            status = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    private ArrayList<OrderTable> extractOrderFromResultSet(ResultSet res) {
        try {
            while (res.next()) {
                orderList.add(new OrderTable(
                    res.getInt("orderId"),
                    res.getInt("restId"),
                    res.getInt("userId"),
                    res.getString("orderDate"),
                    res.getFloat("totalAmount"),
                    res.getString("status"),
                    res.getString("paymentMethod")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }
}

