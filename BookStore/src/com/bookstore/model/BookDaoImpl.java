package com.bookstore.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.connection.ConnectionFactory;
import com.bookstore.exception.DataAccessException;


public class BookDaoImpl implements BookDao{

	private Connection connection;
	
	
	public BookDaoImpl() {
		connection = ConnectionFactory.getConnection();
		
	}
	@Override
	public List<Book> getAll() {
		
		String all_books_query = " select * from books";
		List<Book> books = new ArrayList<>();
		Book book = null;
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(all_books_query);
			
			while(rs.next()) {
				book = new Book(rs.getInt("id"), rs.getString("isbn"), rs.getString("title"),
						rs.getString("author"), rs.getDate("pubDate"), rs.getDouble("price"));
			
				books.add(book);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
		return books;
	}

	@Override
	public Book add(Book book) {
		String add_book_query =
				"insert into books(isbn, title, author, pubDate, price) values(?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(add_book_query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setDate(4, new Date(book.getPubDate().getTime()));
			pstmt.setDouble(5, book.getPrice());
			
			int numOfRowsEffected = pstmt.executeUpdate();
			
			if(numOfRowsEffected > 0) {
				ResultSet rs = pstmt.getGeneratedKeys();
				rs.next();
				book.setId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
		
		
		return book;
	}

	@Override
	public void delete(int bookId) {
		
		String delete_book_query = "delete from books where id = ?";
		
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(delete_book_query);
			pstmt.setInt(1, bookId);
			
			pstmt.execute();
			
			
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
		
	}

	@Override
	public Book update(int id, double price) {
		Book bookToBeUpdated = getById(id);
		String add_book_query =
				"update books set price = ? where id = ?";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(add_book_query);
			
			pstmt.setDouble(1, price);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		bookToBeUpdated.setPrice(price);
		return bookToBeUpdated;
	}

	@Override
	public Book getById(int bookId) {
		
		Book book = null;
		String get_book_by_id = "select * from books where id = ?";
		
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(get_book_by_id);
			pstmt.setInt(1, bookId);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				book = new Book(rs.getInt("id"), rs.getString("isbn"), rs.getString("title"),
						rs.getString("author"), rs.getDate("pubDate"), rs.getDouble("price"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
		
		return book;
	}
	@Override
	public Book getBookByIsbn(String isbn) {
	
		Book book = null;
	String get_book_by_id = "slect * from books where isbn = ?";
		
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(get_book_by_id);
			pstmt.setString(1, isbn);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				book = new Book(rs.getInt("id"), rs.getString("isbn"), rs.getString("title"),
						rs.getString("author"), rs.getDate("pubDate"), rs.getDouble("price"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
		return book;
	}

}
