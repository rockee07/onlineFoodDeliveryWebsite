package com.tap.model;

public class Menu {
	private int menuId;
	private int restId;
	private String menuName;
	private float price;
	private String description;
	private boolean isAvailable;
	private String imgPath;
	
	public Menu() {
		super();
	}

	public Menu(int menuId, int restId, String menuName, float price, String description, boolean isAvailable,
			String imgPath) {
		super();
		this.menuId = menuId;
		this.restId = restId;
		this.menuName = menuName;
		this.price = price;
		this.description = description;
		this.isAvailable = isAvailable;
		this.imgPath = imgPath;
	}

	public Menu(int restId, String menuName, float price, String description, boolean isAvailable, String imgPath) {
		super();
		this.restId = restId;
		this.menuName = menuName;
		this.price = price;
		this.description = description;
		this.isAvailable = isAvailable;
		this.imgPath = imgPath;
	}
	
	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getRestId() {
		return restId;
	}

	public void setRestId(int restId) {
		this.restId = restId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", restId=" + restId + ", menuName=" + menuName + ", price=" + price
				+ ", description=" + description + ", isAvailable=" + isAvailable + ", imgPath=" + imgPath + "]";
	}
	
}
