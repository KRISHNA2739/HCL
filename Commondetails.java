
abstract class Commondetails
{
	
	String name,dept,id,companyname;
	int salary;
	
	public abstract void salarycal();
	public abstract void salaryupd(int upd);
	public void display()
	{
		System.out.println(salary);
	}
	public void setdata(String name, String dept, String id, String companyname) {
		this.name=name;
		this.id=id;
		this.dept=dept;
		this.companyname=companyname;
		
		
	}
	
}
