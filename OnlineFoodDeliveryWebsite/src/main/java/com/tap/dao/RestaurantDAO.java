package com.tap.dao;

import java.util.ArrayList;

import com.tap.model.Restaurant;

public interface RestaurantDAO {
	int insertRes(Restaurant r);
	int deleteRes(int restId);
	ArrayList<Restaurant> fetchAllRes();
	Restaurant fetchRes(int restId);
	int updateRestOnId(Restaurant r);
}
