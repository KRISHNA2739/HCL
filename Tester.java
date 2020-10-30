package practice;

/*1. Find all transactions in the year 2011 and sort them by value (small to high)
. What are all the unique cities where the traders work?
. Find all traders from delhi and sort them by name.
. Return a string of all traders names sorted alphabetically.
. Are any traders based in Jaipur?
. Print all transactions values from the traders living in delhi
. Whats the highest value of all the transactions?
. Find the transaction with the smallest value
*/
import java.util.*;

public class Tester {

	public static void main(String[] args) {
		Trader ram = new Trader("ram", "delhi");
		Trader kapil = new Trader("kapil", "noida");
		Trader raj = new Trader("raj", "banglore");
		Trader ekta = new Trader("ekta", "banglore");
		
		List<Transaction> t = Arrays.asList(new Transaction(ram, 2011, 300),
				new Transaction(ram, 2012, 1000), new Transaction(kapil, 2011, 400), new Transaction(raj, 2012, 710),
				new Transaction(ekta, 2012, 700), new Transaction(ekta, 2012, 950));

		
		t.stream().filter(n->n.getYear()==2011).sorted((p1, p2)->Integer.compare(p1.getYear(),(p2.getYear()))) .forEach(n->System.out.println(n)); 
		t.stream().map(n->n.getTrader().getCity()).distinct().forEach(n->System.out.println(n));
		t.stream().filter(n->n.getTrader().getCity()=="delhi").forEach(n->System.out.println(n));
		t.stream().sorted((p1, p2)->Integer.compare(p2.getValue(),(p1.getValue()))).limit(1) .forEach(n->System.out.println(n));
		t.stream().sorted((p1, p2)->Integer.compare(p1.getValue(),(p2.getValue()))).limit(1) .forEach(n->System.out.println(n));
		t.stream().filter(n->n.getTrader().getCity()=="delhi").sorted((p1, p2)->(p1.getTrader().getName()).compareTo(p2.getTrader().getName())).forEach(n->System.out.println(n));
		t.stream().sorted((p1, p2)->(p1.getTrader().getName()).compareTo(p2.getTrader().getName())).forEach(n->System.out.println(n));
		boolean anyMatch = t.stream().anyMatch(n->n.getTrader().getCity()=="jaipur");
		System.out.println(anyMatch);
		
	}
}
