package practice;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class bigfile {

	  public static void main(String[] args) throws IOException {
		  List<Double> a = new ArrayList<>();
	    try (BufferedReader reader = new BufferedReader(new FileReader("double.txt"))) {
			String line = null;
			while((line = reader.readLine()) != null) {
			    a.add(Double.valueOf(line));
			}
		}
	    Collections.sort(a);
	    System.out.print(a.get(a.size()-1));
	  }
	
}
