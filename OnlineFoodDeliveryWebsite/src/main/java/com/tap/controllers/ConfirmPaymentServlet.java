package com.tap.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.model.Cart;
import com.tap.model.CartItem;

@WebServlet("/confirmPayment")
public class ConfirmPaymentServlet extends HttpServlet {
	    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        HttpSession session = request.getSession();
	        Cart cart = (Cart) session.getAttribute("cart");
	        String paymentMethod = request.getParameter("paymentMethod");
	        int userId = (int) session.getAttribute("userId");
	        int restId = (int) session.getAttribute("restId");
	   
	        if (cart == null || paymentMethod == null || userId == 0 || restId == 0) {
	            response.sendRedirect("checkout.jsp");
	            return;
	        }

	        double totalAmount = 0;
	        Map<Integer, CartItem> items = cart.getItems();

	        for (CartItem item : items.values()) {
	            totalAmount += item.getSubTotal();
	        }

	        Connection conn = null;
	        PreparedStatement psOrderTable = null, psOrderItems = null, psOrderHistory = null;

	        try {
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tapfoods", "root", "(Star@127)");
	            conn.setAutoCommit(false);

	            // Insert into Order Table
	            String orderTableQuery = "insert into ordertable (restId, userId, totalAmount, paymentMethod) values (?, ?, ?, ?)";
	            psOrderTable = conn.prepareStatement(orderTableQuery, Statement.RETURN_GENERATED_KEYS);
	            psOrderTable.setInt(1, restId);
	            psOrderTable.setInt(2, userId);
	            psOrderTable.setDouble(3, totalAmount);
	            psOrderTable.setString(4, paymentMethod);
	            psOrderTable.executeUpdate();

	            ResultSet rs = psOrderTable.getGeneratedKeys();
	            int orderId = 0;
	            if (rs.next()) {
	                orderId = rs.getInt(1);
	            }

	            // Insert into Order Items
	            String orderItemsQuery = "insert into orderitem (orderId, menuId, quantity, subTotal) values (?, ?, ?, ?)";
	            psOrderItems = conn.prepareStatement(orderItemsQuery);

	            for (CartItem item : items.values()) {
	                psOrderItems.setInt(1, orderId);
	                psOrderItems.setInt(2, item.getItemId());
	                psOrderItems.setInt(3, item.getQuantity());
	                psOrderItems.setDouble(4, item.getSubTotal());
	                psOrderItems.addBatch();
	            }
	            psOrderItems.executeBatch();

	            // Insert into Order History
	            String orderHistoryQuery = "insert into orderhistory (orderId, userId, totalAmount) values (?, ?, ?)";
	            psOrderHistory = conn.prepareStatement(orderHistoryQuery);
	            psOrderHistory.setInt(1, orderId);
	            psOrderHistory.setInt(2, userId);
	            psOrderHistory.setDouble(3, totalAmount);
	            psOrderHistory.executeUpdate();

	            conn.commit();
	            session.removeAttribute("cart");
	            response.sendRedirect("ordersuccess.jsp");
	        } catch (Exception e) {
	            if (conn != null) {
	                try {
	                    conn.rollback();
	                } catch (Exception rollbackEx) {
	                    rollbackEx.printStackTrace();
	                }
	            }
	            e.printStackTrace();
	        } finally {
	            try {
	                if (psOrderTable != null) psOrderTable.close();
	                if (psOrderItems != null) psOrderItems.close();
	                if (psOrderHistory != null) psOrderHistory.close();
	                if (conn != null) conn.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
