package practice;

import java.util.*;

public class Tester {
	
	public static void main(String[] args) {
	
	List<Book> a = new ArrayList<>();
	
	a.add(new Book("java"));
	a.add(new Book("jcva"));
	a.add(new Book("jdva"));
	a.add(new Book("jbva"));
	System.out.print(a);
	System.out.print("\n");
	
Collections.sort(a, new lexical());

System.out.print(a);
}
}
