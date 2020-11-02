package com.krishna.anjanee_krishna;



	public class Book
	{
	    private int id;
	    private String title;
	    private int pages;
	    private String author;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public int getPages() {
			return pages;
		}
		public void setPages(int pages) {
			this.pages = pages;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public Book(int id, String title, int pages, String author) {
			
			this.id = id;
			this.title = title;
			this.pages = pages;
			this.author = author;
		}
		@Override
		public String toString() {
			return "Book [id=" + id + ", title=" + title + ", pages=" + pages + ", author=" + author + "]";
		}
		
		
	}




	



	