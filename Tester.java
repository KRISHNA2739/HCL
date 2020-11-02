package com.krishna.anjanee_krishna;


import java.util.*;

public class Tester implements BookDao
{
	private Map<Integer,Book> Bookmap;
	
	private int id=0;
	
	public Tester() {
		Bookmap=new HashMap<>();
		Bookmap.put(++id, new Book(id, "java", 100, "raj"));
	}


	@Override
	public List<Book> getAllBooks() {
		
		return new ArrayList<Book>(Bookmap.values());
	}

	

	@Override
	public Book upBook(int id, int page) {
		if(Bookmap.get(id) != null)
		{
			Bookmap.get(id).setPages(page);
			return Bookmap.get(id);
		}
		
		return null;
	}

	@Override
	public Book delBook(int id) {
		
		return Bookmap.remove(id);
	}

	@Override
	public void addBook(Book book) {
		Bookmap.put(book.getId(), book);
		
		
	}
	

	
    
}



