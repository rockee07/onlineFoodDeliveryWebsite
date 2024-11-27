package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tap.dao.RestaurantDAO;
import com.tap.model.Restaurant;
import com.tap.util.MyConnection;

public class RestaurantDAOImpl implements RestaurantDAO
{
	
	private MyConnection myCon;
	private Connection connection;
	private PreparedStatement pstmt;
	private int status;
	
	ArrayList<Restaurant> al=new ArrayList<Restaurant>();
	private PreparedStatement stmt;
	private ResultSet res;
	private Restaurant rest;
	
	private static final String ADD_REST="insert into user(restName,deliveryTime,quicineType,address,ratings,isActive,adminId,imgpath) values(?,?,?,?,?,?,?,?)";
	private static final String DELETE_REST="delete from restaurant where restId=?";
	private static final String FETCH_ALL_REST="select * from restaurant";
	private static final String FETCH_REST="select * from restaurant where restId=?";
	private static final String UPDATE_REST="update restaurant set restName=?,deliveryTime=?,quicineType=?,address=?,ratings=?,isActive=?,adminId=?,imgpath=? where restId=?";
	
	public RestaurantDAOImpl() {
		myCon = MyConnection.getMyConnection();
		connection = myCon.connect();
	}

	@Override
	public int insertRes(Restaurant r) {
		try {
		pstmt=connection.prepareStatement(ADD_REST);
		pstmt.setString(1, r.getRestName());
		pstmt.setString(3, r.getQuicineType());
		pstmt.setInt(2, r.getDeliveryTime());
		pstmt.setString(4, r.getAddress());
		pstmt.setInt(7, r.getAdminId());
		pstmt.setFloat(5, r.getRatings());
		pstmt.setBoolean(6,r.getIsActive());
		pstmt.setString(8, r.getImgpath());
		
		return pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int deleteRes(int restId) {
		try {
			pstmt=connection.prepareStatement(DELETE_REST);
			pstmt.setInt(1, restId);
			status=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public ArrayList<Restaurant> fetchAllRes() {
		try {
			stmt=connection.prepareStatement(FETCH_ALL_REST);
			res=stmt.executeQuery();
			al=extractRestaurantFromResultSet(res);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public Restaurant fetchRes(int restId) {
		try {
			pstmt=connection.prepareStatement(FETCH_REST);
			pstmt.setInt(1, restId);
			res=pstmt.executeQuery();
			al=extractRestaurantFromResultSet(res);
			rest=al.get(0);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return rest;
	}

	@Override
	public int updateRestOnId(Restaurant r) {
		try {
			pstmt=connection.prepareStatement(UPDATE_REST);
			pstmt.setString(1, r.getRestName());
			pstmt.setString(3, r.getQuicineType());
			pstmt.setInt(2, r.getDeliveryTime());
			pstmt.setString(4, r.getAddress());
			pstmt.setInt(7, r.getAdminId());
			pstmt.setFloat(5, r.getRatings());
			pstmt.setBoolean(6,r.getIsActive());
			pstmt.setString(8, r.getImgpath());
			pstmt.setInt(9, r.getRestId());
			
			status=pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return status;
	}
	
	ArrayList<Restaurant> extractRestaurantFromResultSet(ResultSet res){
		try {
			while(res.next()) {
				al.add(new Restaurant(res.getInt("restId"),
						res.getString("restName"),
						res.getString("quicineType"),
						res.getInt("deliveryTime"),
						res.getString("imgpath"),
						res.getFloat("ratings")));
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return al;
	}

}

