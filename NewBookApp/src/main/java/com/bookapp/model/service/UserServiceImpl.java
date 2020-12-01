package com.bookapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.model.dao.user.User;
import com.bookapp.model.dao.user.UserDao;
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

}
