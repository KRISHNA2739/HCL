import java.util.*;

public class repeat {
 
    public static void main(String[] args) {
 
       Set<String> set = new LinkedHashSet<>();
       Map<String,Integer> times =new HashMap<>();
       String s;
       Scanner sc= new Scanner(System.in);
		System.out.println("Enter the string:");
		s= sc.nextLine();
       String tokens[] =s.split(" ");
       int i;
         for(String t :tokens)
         {
        	 if(set.add(t.toLowerCase()))
        	 {
        		 set.add(t.toLowerCase());
        		 times.put(t.toLowerCase(), 1);
        	 }
        	 else
        	 {
        		 i=times.get(t.toLowerCase());
        		 times.put(t.toLowerCase(), ++i);
        		 
        	 }
        		 
        	 }
         System.out.println(times);
         sc.close();
         }
        	 
    
       
   
 
      
 
}