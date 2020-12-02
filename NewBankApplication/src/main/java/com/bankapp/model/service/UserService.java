package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.dao.user.User;

public interface UserService {
	
	public void addUser(User user);
	public User getUser(String username, String password);
	public User updateUser(int accountId, User user);
	public User getUser(int accountId);
	public List<User> getallUser();
	public User deleteUser(int accountId);
}
