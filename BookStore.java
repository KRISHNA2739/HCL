package practice;



public class BookStore {

	private Books books[];
	private static int SIZE;

	public BookStore() {
		SIZE = 10;
		books = new Books[SIZE];
	}
	
	public BookStore(Books[] books) {
		this.books = books;
	}

	public void sellBook(String bookTitle, int numOfCopies) {
		int index = -1;
		for (int i = 0; i < books.length; i++) {
			if (bookTitle.equalsIgnoreCase(books[i].getBookTitle()) && books[i].getNumOfCopies()!=0 && numOfCopies <= books[i].getNumOfCopies()) {
				int copies = books[i].getNumOfCopies() - numOfCopies;
				books[i].setNumOfCopies(copies);
				index  = i;
			}
		}
		if( index != -1) {
			System.out.println("Remaining copies of java book");
			books[index].display();
		} else {
			System.out.println("Book not found or No sufficient books");
		}
	}
	
	public void orderBooks(String iSBN, int numOfCopies) {
		int index = -1;
		for(int i=0; i<books.length; i++) {
			if(iSBN.equals(books[i].getISBN()) ) {
				books[i].setNumOfCopies(books[i].getNumOfCopies() + numOfCopies);
				index = i;
			}
		}
		if(index != -1) {
			System.out.println("Added books to the system");
		} else {
			System.out.println("Book was not found Order new book");
		}
	}
	
	public void printBookDetails() {
		for (int i = 0; i < books.length; i++) {
			books[i].display();
		}
	}
}