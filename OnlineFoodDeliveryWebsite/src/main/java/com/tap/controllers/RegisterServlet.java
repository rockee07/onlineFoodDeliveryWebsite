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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private int status;
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String phonenumber = req.getParameter("phonenumber");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        
        User user = new User(username, email, phonenumber, password, address);
        
        UserDAO userDAO = new UserDAOImpl();
        status = userDAO.insertUser(user);
        
        if (status != 0) { 
            resp.sendRedirect("success.jsp");  // Redirect to success page
        } else {
            resp.sendRedirect("registered.jsp");  // Registration failed
        }
    }
}

