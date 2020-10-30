package practice;
import java.util.*;

class lexical implements Comparator<Book>
{
	public int compare(Book b1,Book b2)
	{
		return b1.getName().compareToIgnoreCase(b2.getName());
	}
}

public class Book {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

	public Book(String name) {
		this.name = name;
	}
	

}
