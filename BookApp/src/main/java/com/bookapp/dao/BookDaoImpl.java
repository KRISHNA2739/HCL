package com.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.bookapp.exception.BookNotFoundException;

@Primary
@Repository
public class BookDaoImpl implements BookDao{
	
	
	private DataSource dataSource;
	
	public BookDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	

	public List<Book> getAllBooks() {
		Connection conn;
		List<Book> books = new ArrayList<Book>();
		Book book = null;
		
		try {
			conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from book_table");
			
			while(rs.next()) {
				book = new Book(rs.getInt("id"), rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs.getDouble("price"));
				
				books.add(book);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return books;
	}

	public Book addBook(Book book) {
		
		return null;
		

	}

	public void deleteBook(int id) {
		
		
	}

	public void updateBook(int id, Book book) {
		
		Book bookToUpdate = getBookById(id);
		
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("update book_table set price = ? where id = ?");
			pstmt.setDouble(1, book.getPrice());
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Book getBookById(int id) {
		Connection conn;
		PreparedStatement pstmt;
		Book book = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("select * from book_table where id = ?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				book = new Book(rs.getInt("id"), rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs.getDouble("price"));	
			} else {
				throw new BookNotFoundException("book with id " + id + " not found");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return book;
	}
}
