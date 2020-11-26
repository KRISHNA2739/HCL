package com.zooapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CAGE")
public class Cage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cageId;
	private int cageNo;
	private String location;
	@OneToOne
    @JoinColumn(name="animal_id")
	private Animal animal;

	public Cage() {

		// TODO Auto-generated constructor stub
	}

	public Cage(int cageNo, String location) {

		this.cageNo = cageNo;
		this.location = location;
	}

	public int getCageId() {
		return cageId;
	}

	public void setCageId(int cageId) {
		this.cageId = cageId;
	}

	public int getCageNo() {
		return cageNo;
	}

	public void setCageNo(int cageNo) {
		this.cageNo = cageNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cage [cageId=");
		builder.append(cageId);
		builder.append(", cageNo=");
		builder.append(cageNo);
		builder.append(", location=");
		builder.append(location);
		builder.append("]");
		return builder.toString();
	}

}
