package com.bankapp.model.dao.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.model.dao.Account;



@Repository
public class UserDaoImpl implements UserDao {
	private SessionFactory factory;

	@Autowired
	public UserDaoImpl(SessionFactory factory) {

		this.factory = factory;
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public void addUser(User user) {
		Integer id = (Integer) getSession().save(user);
		user.setId(id);

	}

	@Override
	public User getUser(String username, String password) {

		String hql = "FROM User U WHERE U.username = :username AND U.password = :password";
		Query query = getSession().createQuery(hql);
		query.setParameter("username", username);
		query.setParameter("password", password);

		return (User) query.uniqueResult();
	}

	@Override
	public User updateUser(int accountId, User user) {
		User usertobeupdated=getUser(accountId);
		usertobeupdated.setUserType(user.getUserType());
		return usertobeupdated;
	}

	@Override
	public User getUser(int accountId) {
		User user=getSession().get(User.class, accountId);
		return user;
	}

	@Override
	public List<User> getallUser() {
		
		return getSession().createQuery("from User").getResultList();
	}

	@Override
	public User deleteUser(int accountId) {
		User userToBeDeleted =getSession().get(User.class, accountId);
		getSession().delete(userToBeDeleted);
		return userToBeDeleted;
	}

}
