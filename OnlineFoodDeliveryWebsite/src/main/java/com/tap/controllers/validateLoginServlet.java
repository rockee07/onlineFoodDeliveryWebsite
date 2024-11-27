package com.tap.controllers;

import java.io.IOException;
import com.tap.dao.UserDAO;
import com.tap.daoimpl.UserDAOImpl;
import com.tap.model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/validateLogin")
public class validateLoginServlet extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.fetchUser(email);
        
        // Check if user exists and the password is correct
        if (user != null && user.getPassword().equals(password)) {
            // Store userId in session after successful login
            HttpSession session = req.getSession();
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("user", user); // Optionally store the full user object

            // Redirect to the home page after successful login
            resp.sendRedirect("home.jsp");
        } else {
            // Redirect to the login page if user does not exist or password is incorrect
            resp.sendRedirect("welcome.jsp");
        }
    }
    
}
