import java.util.ArrayList;

import java.util.Scanner;

public class Find {

	public static void main(String[] args) {
		
		
	int a;	
	ArrayList<Commondetails> emptype = new ArrayList<Commondetails>(3);
	emptype.add(new Salaried());
	emptype.add(new Hourly(20));
	emptype.add(new Commission(10,20));
	Scanner sc= new Scanner(System.in);
	System.out.println("enter ur choice");
	a=sc.nextInt();
	
	switch(a)
	{
	case 1:
		System.out.println("hai");
		break;
	default :
		System.out.println("sor");
	}
	
	
	
	
	
		
	

	}

}
