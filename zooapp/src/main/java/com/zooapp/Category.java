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
@Table(name = "CATEGORY")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Category_id;

	private String Category_type;
	@OneToMany(mappedBy="categoryid")
	private List<Animal> animalList=new ArrayList<>();

	public Category() {

	}

	public String getCategory_type() {
		return Category_type;
	}

	public void setCategory_type(String category_type) {
		Category_type = category_type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Category [Category_id=");
		builder.append(Category_id);
		builder.append(", Category_type=");
		builder.append(Category_type);
		builder.append("]");
		return builder.toString();
	}

}
