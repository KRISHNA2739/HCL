package practice;

public class Circle {
	private double radius;
	private  String color;
	  Circle(){
		  this.radius=2.98;
		  this.color="bule";
	  }
	  Circle(double r){
		  this.radius=r;
		  
	  }
	  public double getRadius() {
		  return this.radius;
		  
	  }
	  public double getArea() {
		return  radius*radius*Math.PI;
	  
	  }
	  public static void main(String[] args) {
		  Circle c = new Circle();
		  Circle c1=new Circle(2.5);
		  System.out.println("Radius of a circle is:"+c.getRadius());
		  System.out.println("Area of the circle is:"+c.getArea());
		  System.out.println("Radius of a circle is:"+c1.getRadius());
		  System.out.println("Area of the circle is:"+c1.getArea());
		  
		

		}
}
