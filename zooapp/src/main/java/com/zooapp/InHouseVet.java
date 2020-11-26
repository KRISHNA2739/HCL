package com.zooapp;

import javax.persistence.Entity;

@Entity
public class InHouseVet extends Vet{
	
	private int salary;

	public InHouseVet(String name, String qualification, int salary) {
		super(name, qualification);
		this.salary = salary;
	}

	public InHouseVet() {
		
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("  ");
		builder.append("InHouseVet [salary=");
		builder.append(salary);
		builder.append("]");
		return builder.toString();
	}


	
	

}
