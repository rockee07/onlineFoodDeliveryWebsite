package com.tap.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.model.Restaurant;
import com.tap.dao.RestaurantDAO;
import com.tap.daoimpl.RestaurantDAOImpl;


@WebServlet("/SelectRestaurantServlet")
public class RestaurantServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int restId = Integer.parseInt(request.getParameter("restId"));

        // Assuming you have a method to get a Restaurant by restId
        RestaurantDAO restaurantDAO = new RestaurantDAOImpl();
        Restaurant restaurant = restaurantDAO.fetchRes(restId);

        if (restaurant != null) {
            // Store the restaurant details in the session
            HttpSession session = request.getSession();
            session.setAttribute("restId", restId);
            session.setAttribute("restaurant", restaurant); // Optionally store the full restaurant object

            // Redirect to the menu page
            response.sendRedirect("menu.jsp");
        } else {
            // Handle the case where the restaurant is not found
            response.sendRedirect("error.jsp");
        }
    }
}
