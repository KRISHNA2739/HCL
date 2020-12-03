package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.dao.user.User;
import com.bankapp.model.dao.user.UserDao;


@Service(value="us")
@Transactional
public class UserServiceImpl implements UserService{

	private UserDao userdao;
	@Autowired
	public UserServiceImpl(UserDao userdao) {
	
		this.userdao = userdao;
	}

	@Override
	public void addUser(User user) {
		
		userdao.addUser(user);
	}

	@Override
	public User getUser(String username, String password) {
		return userdao.getUser(username, password);
	}

	@Override
	public User updateUser(int accountId, User user) {
		
		return userdao.updateUser(accountId, user);
	}

	@Override
	public User getUser(int accountId) {
		
		return userdao.getUser(accountId);
	}

	@Override
	public List<User> getallUser() {
		// TODO Auto-generated method stub
		return userdao.getallUser();
	}

	@Override
	public User deleteUser(int accountId) {
		// TODO Auto-generated method stub
		return userdao.deleteUser(accountId);
	}

}
