package practice;

public class Books {
	private String bookTitle;
	private String bookAuthor;
	private String ISBN;
	private int numOfCopies;
	
	public Books() {
	
	}
	
	public Books(String bookTitle, String bookAuthor, String ISBN, int numOfCopies) {
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.ISBN = ISBN;
		this.numOfCopies = numOfCopies;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}
	
	public String getISBN() {
		return ISBN;
	}

	public int getNumOfCopies() {
		return numOfCopies;
	}

	public void setNumOfCopies(int numOfCopies) {
		this.numOfCopies = numOfCopies;
	}

	public void display() {
		System.out.println(bookTitle + " " + bookAuthor + " " + ISBN + " " + numOfCopies);
	}
}