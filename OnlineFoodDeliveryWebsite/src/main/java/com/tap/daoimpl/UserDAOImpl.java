package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tap.dao.UserDAO;
import com.tap.model.User;
import com.tap.util.MyConnection;

public  class UserDAOImpl implements  UserDAO
{

	private MyConnection myCon;
	private Connection connection;
	private PreparedStatement pstmt;
	private int status;
	private Statement stmt;
	private ResultSet res;
	
	ArrayList<User> al=new ArrayList<User>();
	User user;
	
	private static final String ADD_USER="insert into user(username,email,phonenumber,password,address) values(?,?,?,?,?)";
	private static final String DELETE_USER="delete from user where email=?";
	private static final String FETCH_ALL_USERS="select * from user";
	private static final String FETCH_USER="select * from user where email=?";
	private static final String UPDATE_USER="update user set password=? where email=?";
	
	

	public UserDAOImpl() {
		myCon = MyConnection.getMyConnection();
		connection = myCon.connect();
	}

	@Override
	public int insertUser(User u) {
		try {
			pstmt=connection.prepareStatement(ADD_USER);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3, u.getPhonenumber());
			pstmt.setString(4, u.getPassword());
			pstmt.setString(5, u.getAddress());
			
			return pstmt.executeUpdate();
			
		} 
		catch (Exception e) {
			
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public int deleteUser(String email) {
		try {
			pstmt=connection.prepareStatement(DELETE_USER);
			pstmt.setString(1, email);
			
			status=pstmt.executeUpdate();
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public ArrayList<User> fetchAllUsers() {
		try {
			stmt=connection.createStatement();
			res=stmt.executeQuery(FETCH_ALL_USERS);
			al=extractUserFromResultSet(res);		
		}
		catch(Exception e) {
			
		}
		return al;
	}

	@Override
	public User fetchUser(String email) {
		try {
			pstmt=connection.prepareStatement(FETCH_USER);
			pstmt.setString(1, email);
			res=pstmt.executeQuery();
			al=extractUserFromResultSet(res);
			user=al.get(0);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int updateUser(String email,String password) {
		try {
		pstmt=connection.prepareStatement(UPDATE_USER);
		pstmt.setString(1, password);
		pstmt.setString(2, email);
		
		status=pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	 ArrayList<User> extractUserFromResultSet(ResultSet res){
		try {
			while(res.next()) 
			{
				al.add(new User(res.getInt("userId"),
				res.getString("username"),
				res.getString("email"),
				res.getString("phonenumber"),
				res.getString("password"),
				res.getString("address")));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}

}

