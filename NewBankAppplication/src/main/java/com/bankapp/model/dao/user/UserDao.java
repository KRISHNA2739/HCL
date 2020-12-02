package com.bankapp.model.dao.user;

import java.util.List;

public interface UserDao {
	
	public void addUser(User user);
	public User getUser(String username, String password);
	public User updateUser(int accountId, User user);
	public User getUser(int accountId);
	public List<User> getallUser();
	public User deleteUser(int accountId);

}
