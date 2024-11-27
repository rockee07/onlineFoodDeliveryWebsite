package com.tap.dao;

import java.util.ArrayList;

import com.tap.model.Menu;

public interface MenuDAO {
	int insertMenu(Menu  m);
	int deleteMenu(int menuId);
	ArrayList<Menu> fetchAllMenu();
	ArrayList<Menu> fetchMenuById(int restId);
	Menu fetchMenuByItemId(int menuId);
}
