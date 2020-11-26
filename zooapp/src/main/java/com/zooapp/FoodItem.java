package com.zooapp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "FOOD_ITEM")
public class FoodItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int food_item_id;
	private String name;
	private String quantity;
	@ManyToMany(mappedBy = "foodItemList")
	private List<Animal> Animal = new ArrayList<>();
	@ManyToOne
	private Supplier supplier;

	public FoodItem(String name, String quantity) {

		this.name = name;
		this.quantity = quantity;
	}

	public FoodItem() {

	}

	public int getFood_item_id() {
		return food_item_id;
	}

	public void setFood_item_id(int food_iteam_id) {
		this.food_item_id = food_iteam_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FoodItem [food_iteam_id=");
		builder.append(food_item_id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append("]");
		return builder.toString();
	}

}
