package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.tap.dao.MenuDAO;
import com.tap.model.Menu;
import com.tap.util.MyConnection;

public class MenuDAOImpl implements MenuDAO {

    private MyConnection myCon;
    private Connection connection;
    private PreparedStatement pstmt;
    private ResultSet res;
    private int status;

    ArrayList<Menu> menuList = new ArrayList<>();
    private Menu menu;

    private static final String ADD_MENU = "insert into menu(restId,menuName,price,description,isAvailable,imgPath) values(?,?,?,?,?,?)";
    private static final String FETCH_ALL_MENU = "select * from menu";
    private static final String FETCH_MENU_BY_ID = "select * from menu where restId=?";
    private static final String DELETE_MENU = "delete from menu where menuId=?";
    private static final String FETCH_MENU_BY_MenuID = "select * from menu where menuId=?";

    public MenuDAOImpl() {
        myCon = MyConnection.getMyConnection();
        connection = myCon.connect();
    }

    @Override
    public int insertMenu(Menu m) {
        try {
            pstmt = connection.prepareStatement(ADD_MENU);
            pstmt.setInt(1, m.getRestId());
            pstmt.setString(2, m.getMenuName());
            pstmt.setFloat(3, m.getPrice());
            pstmt.setString(4, m.getDescription());
            pstmt.setBoolean(5, m.getIsAvailable());
            pstmt.setString(6, m.getImgPath());

            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            closeStatement(pstmt);
        }
    }

    @Override
    public ArrayList<Menu> fetchAllMenu() {
        try {
            pstmt = connection.prepareStatement(FETCH_ALL_MENU);
            res = pstmt.executeQuery();
            menuList = extractMenuFromResultSet(res);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResultSet(res);
            closeStatement(pstmt);
        }
        return menuList;
    }

    @Override
    public ArrayList<Menu> fetchMenuById(int restId) {
        try {
            pstmt = connection.prepareStatement(FETCH_MENU_BY_ID);
            pstmt.setInt(1,restId);
            res = pstmt.executeQuery();
            menuList = extractMenuFromResultSet(res);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResultSet(res);
            closeStatement(pstmt);
        }
        return menuList;
    }

    @Override
    public int deleteMenu(int menuId) {
        try {
            pstmt = connection.prepareStatement(DELETE_MENU);
            pstmt.setInt(1, menuId);
            status = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStatement(pstmt);
        }
        return status;
    }

    private ArrayList<Menu> extractMenuFromResultSet(ResultSet res) {
        ArrayList<Menu> menuList = new ArrayList<>();
        try {
            while (res.next()) {
                menuList.add(new Menu(
                        res.getInt("menuId"),
                        res.getInt("restId"),
                        res.getString("menuName"),
                        res.getFloat("price"),
                        res.getString("description"),
                        res.getBoolean("isAvailable"),
                        res.getString("imgPath")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuList;
    }

    private void closeStatement(PreparedStatement stmt) {
        try {
            if (stmt != null) stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void closeResultSet(ResultSet res) {
        try {
            if (res != null) res.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Override
	public Menu fetchMenuByItemId(int menuId) {
		try {
            pstmt = connection.prepareStatement(FETCH_MENU_BY_MenuID);
            pstmt.setInt(1,menuId);
            res = pstmt.executeQuery();
            menuList = extractMenuFromResultSet(res);
            if(menuList!=null) {
            	menu=menuList.get(0);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResultSet(res);
            closeStatement(pstmt);
        }
        return menu;
		
	}
}

