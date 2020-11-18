package com.bookstore.user.model;

public class User {
	
	private int id;
	private String username;
	private String password;
	private String profile;
	
	
	public User() {
		
	}
	
	public User(String username, String password, String profile) {
		this.username = username;
		this.password = password;
		this.profile = profile;
	}
	
	
	public User(int id, String username, String password, String profile) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.profile = profile;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", profile=");
		builder.append(profile);
		builder.append("]");
		return builder.toString();
	}
}
