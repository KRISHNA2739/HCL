package practice;

class Cal implements Runnable
{
  


   

 
public synchronized void run ()
  {
	
    for(int i=0;i<=100;i++)
	  System.out.println(Thread.currentThread().getName()+" "+i);
	
  
} 
 


}


public class threads
{
  
 
 
public static void main (String[]args) throws InterruptedException
  {
    




Cal cal =new Cal();
    
Thread thread1 = new Thread (cal);
Thread thread2 = new Thread (cal);
Thread thread3 = new Thread (cal);
    
thread1.start ();
thread2.start ();
thread3.start ();
    
thread1.join ();
thread2.join ();
thread3.join ();
    


} 

} 