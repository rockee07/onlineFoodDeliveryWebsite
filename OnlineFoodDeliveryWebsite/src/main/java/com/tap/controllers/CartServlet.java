package com.tap.controllers;

import java.io.IOException;
import java.util.ArrayList;

import com.tap.dao.MenuDAO;
import com.tap.model.Menu;
import com.tap.daoimpl.MenuDAOImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.model.Cart;
import com.tap.model.CartItem;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        String action = req.getParameter("action");
        if ("add".equals(action)) {
            addToCart(req, cart);
        } else if ("update".equals(action)) {
            updateCart(req, cart);
        } else if ("remove".equals(action)) {
            removeFromCart(req, cart);
        }

        session.setAttribute("cart", cart);
        resp.sendRedirect("cart.jsp"); // Redirect to cart.jsp after completing the action
    }

    private void addToCart(HttpServletRequest req, Cart cart) {
        try {
            int itemId = Integer.parseInt(req.getParameter("itemId"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));

            // Fetch the menu item based on the item ID
            MenuDAO menuDAO = new MenuDAOImpl();
            Menu menuItem = menuDAO.fetchMenuByItemId(itemId); // Fetch a single menu item by ID
            
            if (menuItem != null) {
                float price = menuItem.getPrice();
                String name = menuItem.getMenuName();
                int restId = menuItem.getRestId();
                float subTotal = price * quantity;

                // Create CartItem and add it to the cart
                CartItem item = new CartItem(itemId, restId, name, price, quantity, subTotal);
                cart.addItem(item);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void updateCart(HttpServletRequest req, Cart cart) {
        try {
            int itemId = Integer.parseInt(req.getParameter("itemId"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));

            // Update the item's quantity in the cart
            cart.updateItem(itemId, quantity);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void removeFromCart(HttpServletRequest req, Cart cart) {
        try {
            int itemId = Integer.parseInt(req.getParameter("itemId"));

            // Remove the item from the cart
            cart.removeItem(itemId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}

	 
	
	
	
	
	
	
	
	
	
	
	

