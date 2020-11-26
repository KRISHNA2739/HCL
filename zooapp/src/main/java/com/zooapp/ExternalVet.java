package com.zooapp;

import javax.persistence.Entity;

@Entity
public class ExternalVet extends Vet{
	private String country;
	private int visiting_fees;
	public ExternalVet(String name, String qualification, String country, int visiting_fees) {
		super(name, qualification);
		this.country = country;
		this.visiting_fees = visiting_fees;
	}
	
	public ExternalVet()
	{
		
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getVisiting_fees() {
		return visiting_fees;
	}

	public void setVisiting_fees(int visiting_fees) {
		this.visiting_fees = visiting_fees;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("  ");
		builder.append("ExternalVet [country=");
		builder.append(country);
		builder.append(", visiting_fees=");
		builder.append(visiting_fees);
		builder.append("]");
		return builder.toString();
	}
	
}
