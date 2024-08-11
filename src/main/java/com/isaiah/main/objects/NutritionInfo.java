package com.isaiah.main.objects;

import jakarta.persistence.*;


@Entity
@Table(name = "nutritionInfo")
public class NutritionInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //This means we'll use the database to determine the ID for the object
	@Column(name = "nutritionID")
	private int nutritionID;
	
	@Column(name = "recipeID")
	private int recipeID;
	
	@Column(name = "calories")
	private int calories;
	
	@Column(name = "satFat")
	private int satFat;
	
	@Column(name = "transFat")
	private int transFat; 
	
	@Column(name = "cholesterol")
	private int cholesterol; 
	
	@Column(name = "sodium")
	private int sodium;
	
	@Column(name = "carbs")
	private int carbs;
	
	@Column(name = "protein")
	private int protein;
	
	@Column(name = "vitaminA")
	private int vitaminA;
	
	@Column(name = "vitaminC")
	private int vitaminC;
	
	@Column(name = "vitaminD")
	private int vitaminD;
	
	@Column(name = "calcium")
	private int calcium;
	
	@Column(name = "iron")
	private int iron; 
	
	@Column(name = "potassium")
	private int potassium;

	public NutritionInfo() {
		this(-1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}
	
	public NutritionInfo(int nutritionID, int recipeID, int calories, int satFat, int transFat, int cholesterol,
			int sodium, int carbs, int protein, int vitaminA, int vitaminC, int vitaminD, int calcium, int iron,
			int potassium) {
		super();
		this.nutritionID = nutritionID;
		this.recipeID = recipeID;
		this.calories = calories;
		this.satFat = satFat;
		this.transFat = transFat;
		this.cholesterol = cholesterol;
		this.sodium = sodium;
		this.carbs = carbs;
		this.protein = protein;
		this.vitaminA = vitaminA;
		this.vitaminC = vitaminC;
		this.vitaminD = vitaminD;
		this.calcium = calcium;
		this.iron = iron;
		this.potassium = potassium;
	}

	public int getNutritionID() {
		return nutritionID;
	}

	public void setNutritionID(int nutritionID) {
		this.nutritionID = nutritionID;
	}

	public int getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getSatFat() {
		return satFat;
	}

	public void setSatFat(int satFat) {
		this.satFat = satFat;
	}

	public int getTransFat() {
		return transFat;
	}

	public void setTransFat(int transFat) {
		this.transFat = transFat;
	}

	public int getCholesterol() {
		return cholesterol;
	}

	public void setCholesterol(int cholesterol) {
		this.cholesterol = cholesterol;
	}

	public int getSodium() {
		return sodium;
	}

	public void setSodium(int sodium) {
		this.sodium = sodium;
	}

	public int getCarbs() {
		return carbs;
	}

	public void setCarbs(int carbs) {
		this.carbs = carbs;
	}

	public int getProtein() {
		return protein;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public int getVitaminA() {
		return vitaminA;
	}

	public void setVitaminA(int vitaminA) {
		this.vitaminA = vitaminA;
	}

	public int getVitaminC() {
		return vitaminC;
	}

	public void setVitaminC(int vitaminC) {
		this.vitaminC = vitaminC;
	}

	public int getVitaminD() {
		return vitaminD;
	}

	public void setVitaminD(int vitaminD) {
		this.vitaminD = vitaminD;
	}

	public int getCalcium() {
		return calcium;
	}

	public void setCalcium(int calcium) {
		this.calcium = calcium;
	}

	public int getIron() {
		return iron;
	}

	public void setIron(int iron) {
		this.iron = iron;
	}

	public int getPotassium() {
		return potassium;
	}

	public void setPotassium(int potassium) {
		this.potassium = potassium;
	}

	@Override
	public String toString() {
		return "NutritionInfo [nutritionID=" + nutritionID + ", recipeID=" + recipeID + ", calories=" + calories
				+ ", satFat=" + satFat + ", transFat=" + transFat + ", cholesterol=" + cholesterol + ", sodium="
				+ sodium + ", carbs=" + carbs + ", protein=" + protein + ", vitaminA=" + vitaminA + ", vitaminC="
				+ vitaminC + ", vitaminD=" + vitaminD + ", calcium=" + calcium + ", iron=" + iron + ", potassium="
				+ potassium + "]";
	}
	

}
