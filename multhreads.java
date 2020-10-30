package practice;

import java.util.Random;
class Cal implements Runnable
{
  

private int i,sum=0;
   


public void run ()
  {
    i = new Random().nextInt(10)+1; 
	  sum=sum+i;
	  
}



public void getSum() {
	System.out.print(sum);
}







}


public class multhreads
{
  
 
 
public static void main (String[]args) throws InterruptedException
  {
    




Cal cal =new Cal();
    
Thread thread1 = new Thread (cal);
Thread thread2 = new Thread (cal);
Thread thread3 = new Thread (cal);
Thread thread4 = new Thread (cal);
Thread thread5 = new Thread (cal);
    
thread1.start ();
thread2.start ();
thread3.start ();
thread4.start ();
thread5.start ();
    
thread1.join ();
thread2.join ();
thread3.join ();
thread4.join ();
thread5.join ();
    
cal.getSum();

} 

} 
