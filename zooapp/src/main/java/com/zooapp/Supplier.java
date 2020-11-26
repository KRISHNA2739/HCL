package com.zooapp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SUPPLIER")
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supplierid;
	private String suppliername;
	private String contactno;
	private String address;
	
	@OneToMany(mappedBy="supplier")
	private List<FoodItem> FoodItemList=new ArrayList<>();
	public Supplier(String suppliername, String contactno, String address) {
	
		this.suppliername = suppliername;
		this.contactno = contactno;
		this.address = address;
	}
	public Supplier() {
		
		// TODO Auto-generated constructor stub
	}
	public int getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Supplier [supplierid=");
		builder.append(supplierid);
		builder.append(", suppliername=");
		builder.append(suppliername);
		builder.append(", contactno=");
		builder.append(contactno);
		builder.append(", address=");
		builder.append(address);
		builder.append("]");
		return builder.toString();
	}
	

}
