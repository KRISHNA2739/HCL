package com.bookstore.user.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookstore.connection.ConnectionFactory;
import com.bookstore.exception.DataAccessException;

public class UserDaoImpl implements UserDao{

	private Connection conn;
	
	public UserDaoImpl() {
		conn = ConnectionFactory.getConnection();
	}
	
	@Override
	public void addUser(User user) {
		String add_customer = "insert into user(username, password, profile) values(?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(add_customer);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getProfile());
		
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
	}

	@Override
	public User getUser(String username, String password) {
		User user = null;
		PreparedStatement pstmt;
		try {
			
			pstmt = conn.prepareStatement("select * from  user where username = ? and password=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new User(rs.getInt("id"), username, password, rs.getString("profile"));
			} else {
				throw new UserNotFoundException("user not found");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return user;
	}

}
