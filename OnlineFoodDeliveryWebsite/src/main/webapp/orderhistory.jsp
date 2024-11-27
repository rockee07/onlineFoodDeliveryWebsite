<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, com.tap.model.OrderHistory, com.tap.dao.OrderHistoryDAO, com.tap.daoimpl.OrderHistoryDAOImpl" %>
<%
    // Retrieve userId from session
    Integer userId = (Integer) session.getAttribute("userId");
    
    if (userId != null) {
        // Fetch the order history using the DAO
        OrderHistoryDAO orderHistoryDAO = new OrderHistoryDAOImpl();
        List<OrderHistory> orderHistoryList = orderHistoryDAO.fetchOrderHistory(userId); // Assuming this method fetches order history by userId
        
        // Set the order history list as a request attribute
        request.setAttribute("orderHistory", orderHistoryList);
    } else {
        // If userId is not found in session, redirect to login page
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Order History</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(120deg, #6A11CB, #2575FC);
            color: #fff;
            margin: 0;
            padding: 20px;
        }

        .order-history {
            max-width: 900px;
            margin: auto;
            background: rgba(255, 255, 255, 0.1);
            padding: 20px;
            border-radius: 10px;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            animation: fadeIn 1s ease-in-out;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #2575FC;
            color: #fff;
        }

        tr:hover {
            background-color: #6A11CB;
            color: #fff;
            transform: scale(1.05);
            transition: transform 0.3s ease;
        }

        .no-orders {
            text-align: center;
            font-size: 1.2em;
            margin-top: 20px;
        }

        /* Keyframe Animations */
        @keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }
    </style>
</head>
<body>
    <div class="order-history">
        <h2>Order History</h2>
        <% 
            // Get the orderHistory attribute from the request
            List<OrderHistory> orderHistory = (List<OrderHistory>) request.getAttribute("orderHistory");
            
            if (orderHistory != null && !orderHistory.isEmpty()) {
        %>
        <table>
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Total Amount</th>
                    <th>Order Date</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    // Iterate over the orderHistory list and display each order in a table row
                    for (OrderHistory order : orderHistory) {
                %>
                <tr>
                    <td><%= order.getOrderId() %></td>
                    <td>₹<%= order.getTotalAmount() %></td>
                    <td><%= order.getOrderDate() %></td>
                </tr>
                <% 
                    }
                %>
            </tbody>
        </table>
        <% 
            } else {
        %>
            <div class="no-orders">No orders found.</div>
        <% 
            }
        %>
    </div>
</body>
</html>
