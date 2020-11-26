package com.zooapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Vet {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int vetid;
	private String name;
	private String qualification;
	public Vet(String name, String qualification) {
	
		this.name = name;
		this.qualification = qualification;
	}
	public Vet() {
	
	}
	public int getVetid() {
		return vetid;
	}
	public void setVetid(int vetid) {
		this.vetid = vetid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vet [vetid=");
		builder.append(vetid);
		builder.append(", name=");
		builder.append(name);
		builder.append(", qualification=");
		builder.append(qualification);
		builder.append("]");
		return builder.toString();
	}
	
	
}
