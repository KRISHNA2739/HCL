package com.zooapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STAFF")
public class Emergency {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emergencyid;
	private String type;
	private String cases;
	private String progress_so_far;

	public Emergency() {

	}

	public Emergency(String type, String cases, String progress_so_far) {

		this.type = type;
		this.cases = cases;
		this.progress_so_far = progress_so_far;
	}

	public int getEmergencyid() {
		return emergencyid;
	}

	public void setEmergencyid(int emergencyid) {
		this.emergencyid = emergencyid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCases() {
		return cases;
	}

	public void setCases(String cases) {
		this.cases = cases;
	}

	public String getProgress_so_far() {
		return progress_so_far;
	}

	public void setProgress_so_far(String progress_so_far) {
		this.progress_so_far = progress_so_far;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Emergency [emergencyid=");
		builder.append(emergencyid);
		builder.append(", type=");
		builder.append(type);
		builder.append(", cases=");
		builder.append(cases);
		builder.append(", progress_so_far=");
		builder.append(progress_so_far);
		builder.append("]");
		return builder.toString();
	}

}
