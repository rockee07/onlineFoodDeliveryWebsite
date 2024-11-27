package com.tap.dao;

import java.util.ArrayList;

import com.tap.model.User;

public interface UserDAO {
	int insertUser(User u);
	int deleteUser(String email);
	ArrayList<User> fetchAllUsers();
	User fetchUser(String email);
	int updateUser(String email,String password);
}
