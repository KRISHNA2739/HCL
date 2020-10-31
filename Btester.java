package practice;

  


import java.util.Scanner;

public class Btester {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Here is the menu!!");
		
		System.out.println("Enter 1 to display books");
		System.out.println("Enter 2 to order new books");
		System.out.println("Enter 3 to sell books");
		System.out.println("Enter 0 to exit the system");
		int num = sc.nextInt();
		
		Books[] books = {new Books(" java", "raj", "34", 92), new Books("python", "gupta", "76", 94)};
		
		switch (num) {
		case 1:
			printBookInto(books);
			break;
		case 2:
			
			break;
		case 3: 
			
			break;
		case 0 :
			System.out.println("Exited!!");
			break;
		default:
			break;
		}
	}
	
	public static void printBookInto(Books[] books) {
		
		for(int i=0;i<books.length;i++) {
			books[i].display();
		}
	}
}