package com.krishna.anjanee_krishna;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class TesterTest {
	private Book bo;
	private BookDao bd;
	

	@Before
	public void setUp() throws Exception {
		bd=new Tester();
		bo=new Book(7, "python", 500, "taj");
	}
	@Test
	public void getAllBookstest() {
		int k=bd.getAllBooks().size();
		Assert.assertEquals(1, k);
	
		
	}
	@Test
	public void upBooktest() {
		Assert.assertNotNull(bd.upBook(1, 500));
		
	}

	@Test
	public void delBooktest() {
		Assert.assertNotNull(bd.delBook(1));
		
	}

	@Test
	public void addBooktest() {
		bd.addBook(bo);
		int k=bd.getAllBooks().size();
		Assert.assertEquals(2, k);
		
	}



	@After
	public void tearDown() throws Exception {
		bd=null;
		bo=null;
	}

	
}
