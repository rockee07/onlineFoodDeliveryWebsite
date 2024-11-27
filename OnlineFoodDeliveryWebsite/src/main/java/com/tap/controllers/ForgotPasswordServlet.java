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

@WebServlet("/forgotPassword")
public class ForgotPasswordServlet extends HttpServlet {
	private User user;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		
		UserDAO userDAO = new UserDAOImpl();
		user=userDAO.fetchUser(email);
		if(user!=null) {
			HttpSession session=req.getSession();
			session.setAttribute("email", email);
			resp.sendRedirect("updatePassword.jsp");
		}
		else {
			resp.sendRedirect("failure.jsp");
		}
		
	}

}
