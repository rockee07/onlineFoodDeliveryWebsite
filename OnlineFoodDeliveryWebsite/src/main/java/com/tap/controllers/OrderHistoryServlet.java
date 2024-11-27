package com.tap.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.dao.OrderHistoryDAO;
import com.tap.daoimpl.OrderHistoryDAOImpl;
import com.tap.daoimpl.RestaurantDAOImpl;
import com.tap.model.OrderHistory;


@WebServlet("/orderHistory")
public class OrderHistoryServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId != null) {
            OrderHistoryDAO orderHistoryDAO = new OrderHistoryDAOImpl();
            List<OrderHistory> orderHistory = orderHistoryDAO.fetchOrderHistory(userId);
            req.setAttribute("orderHistory", orderHistory);
            RequestDispatcher dispatcher = req.getRequestDispatcher("orderhistory.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("login.jsp");
        }
    }
	}
