package com.zooapp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ANIMAL")
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int animalid;
	private String type;
	private int totalno;
	@OneToOne(mappedBy = "animal")
	private Cage cage;
	@ManyToOne
	private Category categoryid;
	@ManyToMany
	@JoinTable(name="animal_food_item",
	joinColumns= {@JoinColumn(name="animalid",referencedColumnName="animalid")},
	inverseJoinColumns= {@JoinColumn(name="food_item_id",referencedColumnName="food_item_id")})
	private List<FoodItem> foodItemList=new ArrayList<>();

	public Animal() {

		
	}

	public Animal(String type, int totalno) {

		this.type = type;
		this.totalno = totalno;
	}

	public int getAnimalid() {
		return animalid;
	}

	public void setAnimalid(int animalid) {
		this.animalid = animalid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTotalno() {
		return totalno;
	}

	public void setTotalno(int totalno) {
		this.totalno = totalno;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Animal [animalid=");
		builder.append(animalid);
		builder.append(", type=");
		builder.append(type);
		builder.append(", totalno=");
		builder.append(totalno);
		builder.append("]");
		return builder.toString();
	}

}
