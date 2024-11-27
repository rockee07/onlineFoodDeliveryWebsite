package com.tap.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	private static String url ="jdbc:mysql://localhost:3306/tapfoods";
	private static String username="root";
	private static String password="(Star@127)";

	private  MyConnection() {
		super();
		
	}
	static private MyConnection connection=new MyConnection();
	
	public static MyConnection getMyConnection() {
		return connection;
	}
	
	public static  Connection connect() {
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url,username,password);
		
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
}
