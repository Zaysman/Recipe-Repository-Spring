package com.isaiah.objects;

import jakarta.persistence.*;

@Entity
@Table(name = "ingredients")
public class Ingredient {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "recipeID")
	private int recipeID;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //This means we'll use the database to determine the ID for the object
	@Column(name = "entryID")
	private int entryID;
	
	public Ingredient() {
		this("default ingredient name", "miligram", 0, -1, -1);
	}
	
	public Ingredient(String name, String unit, int quantity, int recipeID, int entryID) {
		super();
		this.name = name;
		this.unit = unit;
		this.quantity = quantity;
		this.recipeID = recipeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}

	public int getEntryID() {
		return entryID;
	}

	public void setEntryID(int entryID) {
		this.entryID = entryID;
	}

	@Override
	public String toString() {
		return "Ingredient [name=" + name + ", unit=" + unit + ", quantity=" + quantity + ", recipeID=" + recipeID
				+ ", entryID=" + entryID + "]";
	}

	
	
	
	
	

}
