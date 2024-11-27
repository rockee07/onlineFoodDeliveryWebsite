package com.tap.model;

public class Restaurant {
	private int restId;
	private String restName;
	private int deliveryTime;
	private String quicineType;
	private String address; 
	private float ratings;
	private boolean isActive;
	private int adminId;
	private String imgpath;
	
	public Restaurant() {
		super();
		
	}

	public Restaurant(int restId, String restName, int deliveryTime, String quicineType, String address, float ratings,
			boolean isActive, int adminId, String imgpath) {
		super();
		this.restId = restId;
		this.restName = restName;
		this.deliveryTime = deliveryTime;
		this.quicineType = quicineType;
		this.address = address;
		this.ratings = ratings;
		this.isActive = isActive;
		this.adminId = adminId;
		this.imgpath = imgpath;
	}

	public Restaurant(int restId,String restName,String quicineType, int deliveryTime, String imgpath, float ratings
			) {
		super();
		this.restId=restId;
		this.restName = restName;
		this.quicineType = quicineType;
		this.deliveryTime = deliveryTime;
		this.imgpath = imgpath;
		this.ratings = ratings;
	}

	public int getRestId() {
		return restId;
	}

	public void setRestId(int restId) {
		this.restId = restId;
	}

	public String getRestName() {
		return restName;
	}

	public void setRestName(String restName) {
		this.restName = restName;
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getQuicineType() {
		return quicineType;
	}

	public void setQuicineType(String quicineType) {
		this.quicineType = quicineType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getRatings() {
		return ratings;
	}

	public void setRatings(float ratings) {
		this.ratings = ratings;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	@Override
	public String toString() {
		return "Restaurant [restId=" + restId + ", restName=" + restName + ", deliveryTime=" + deliveryTime
				+ ", quicineType=" + quicineType + ", address=" + address + ", ratings=" + ratings + ", isActive="
				+ isActive + ", adminId=" + adminId + ", imgpath=" + imgpath + "]";
	}
}
