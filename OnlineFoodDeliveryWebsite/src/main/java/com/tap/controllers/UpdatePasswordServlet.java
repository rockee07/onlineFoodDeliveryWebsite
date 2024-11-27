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


@WebServlet("/updatePassword")
public class UpdatePasswordServlet extends HttpServlet {
	
	private Object user;
	private int status;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		
		UserDAO userDAO = new UserDAOImpl();
		status=userDAO.updateUser(email,password);
		if(status!=0) {
			resp.sendRedirect("passwordSuccess.jsp");
		}
		else {
			resp.sendRedirect("failure.jsp");
		}
	}
}
