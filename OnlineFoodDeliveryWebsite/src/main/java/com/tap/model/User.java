package com.tap.model;

public class User {
	private int userId;
	private String username;
	private String email;
	private String phonenumber;
	private String password;
	private String address;
	private String createDate;
	private String lastLogin;
	
	public User() {
		
	}

	public User(int userId, String username, String email, String phonenumber, String password, String address,
			String createDate, String lastLogin) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.phonenumber = phonenumber;
		this.password = password;
		this.address = address;
		this.createDate = createDate;
		this.lastLogin = lastLogin;
	}
	
	public User(int userId, String username, String email, String phonenumber, String password, String address
			) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.phonenumber = phonenumber;
		this.password = password;
		this.address = address;
		
	}

	public User(String username, String email, String phonenumber, String password, String address) {
		super();
		this.username = username;
		this.email = email;
		this.phonenumber = phonenumber;
		this.password = password;
		this.address = address;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", email=" + email + ", phonenumber=" + phonenumber
				+ ", password=" + password + ", address=" + address + ", createDate=" + createDate + ", lastLogin="
				+ lastLogin + "]";
	}

}
