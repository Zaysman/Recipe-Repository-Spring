package com.isaiah.objects;

import java.util.LinkedList;
import java.time.Duration;

import jakarta.persistence.*;


@Entity
@Table(name = "recipes")
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recipeID")
	private int recipeID; 
	
	@Column(name = "servSize")
	private int servSize;
	
	@Column(name = "difflvl")
	private int difflvl;
	
	@Column(name = "authorID")
	private int authorId;
	
	@Column(name = "NutritionInfoId")
	private int nutritionInfoId;
	
	@Column(name = "rating")
	private float rating;
	
	@Column(name = "recipeTitle")
	private String recipeTitle;
	
	@Column(name = "recipeDesc")
	private String recipeDesc;
	
	@Column(name = "cuisineType")
	private String cuisineType;
	
	@Column(name = "prepTime")
	private Duration prepTime;
	
	@Column(name = "cookTime")
	private Duration cookTime;
	
	@Column(name = "totalTime")
	private Duration totalTime;
	
	@Transient
	private NutritionInfo nutritionInfo;
	
	@Transient
	private LinkedList<Ingredient> ingredients = new LinkedList<>();
	
	@Transient
	private LinkedList<Step> prepSteps = new LinkedList<>();
	
	@Transient
	private LinkedList<Comment> comments = new LinkedList<>();
	
	
	//Hibernate requires a no-argument constructor
	public Recipe() {
//		this(0, 0, 0, 0.0f, "Default Title", "", "", Duration.ZERO, Duration.ZERO, Duration.ZERO, new User(), new NutritionInfo(),
//				new LinkedList<Ingredient>(), new LinkedList<Step>(), new LinkedList<Comment>());
	
	}
	
	
	public Recipe(int recipeID, int servSize, int difflvl, float rating, String recipeTitle, String recipeDesc,
			String cuisineType, Duration prepTime, Duration cookTime, Duration totalTime, int authorId,
			NutritionInfo nutritionInfo, LinkedList<Ingredient> ingredients, LinkedList<Step> prepSteps,
			LinkedList<Comment> comments) {
		super();
		this.recipeID = recipeID;
		this.servSize = servSize;
		this.difflvl = difflvl;
		this.rating = rating;
		this.recipeTitle = recipeTitle;
		this.recipeDesc = recipeDesc;
		this.cuisineType = cuisineType;
		this.prepTime = prepTime;
		this.cookTime = cookTime;
		this.totalTime = totalTime;
		this.authorId = authorId;
		//this.nutritionInfo = nutritionInfo;
		this.ingredients = ingredients;
		this.prepSteps = prepSteps;
		this.comments = comments;
	}


	public int getRecipeID() {
		return recipeID;
	}


	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}


	public int getServSize() {
		return servSize;
	}


	public void setServSize(int servSize) {
		this.servSize = servSize;
	}


	public int getDifflvl() {
		return difflvl;
	}


	public void setDifflvl(int difflvl) {
		this.difflvl = difflvl;
	}


	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}


	public String getRecipeTitle() {
		return recipeTitle;
	}


	public void setRecipeTitle(String recipeTitle) {
		this.recipeTitle = recipeTitle;
	}


	public String getRecipeDesc() {
		return recipeDesc;
	}


	public void setRecipeDesc(String recipeDesc) {
		this.recipeDesc = recipeDesc;
	}


	public String getCuisineType() {
		return cuisineType;
	}


	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}


	public Duration getPrepTime() {
		return prepTime;
	}


	public void setPrepTime(Duration prepTime) {
		this.prepTime = prepTime;
	}


	public Duration getCookTime() {
		return cookTime;
	}


	public void setCookTime(Duration cookTime) {
		this.cookTime = cookTime;
	}


	public Duration getTotalTime() {
		return totalTime;
	}


	public void setTotalTime(Duration totalTime) {
		this.totalTime = totalTime;
	}


	public int getAuthorId() {
		return authorId;
	}


	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getNutritionInfoId() {
		return this.nutritionInfoId;
	}
	
	public void setNutritionInfoId(int nutritionInfoId) {
		this.nutritionInfoId = nutritionInfoId;
		
	}
	
	public NutritionInfo getNutritionInfo() {
		return nutritionInfo;
	}


	public void setNutritionInfo(NutritionInfo nutritionInfo) {
		this.nutritionInfo = nutritionInfo;
	}


	public LinkedList<Ingredient> getIngredients() {
		return ingredients;
	}


	public void setIngredients(LinkedList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	public void addIngredient(Ingredient i) {
		this.ingredients.add(i);
	}


	public LinkedList<Step> getPrepSteps() {
		return prepSteps;
	}


	public void setPrepSteps(LinkedList<Step> prepSteps) {
		this.prepSteps = prepSteps;
	}
	
	public void addPrepStep(Step s) {
		this.prepSteps.add(s);
	}


	public LinkedList<Comment> getComments() {
		return comments;
	}


	public void setComments(LinkedList<Comment> comments) {
		this.comments = comments;
	}
	
	public void addComment(Comment c) {
		this.comments.add(c);
	}
	
	public void removeComment(int index) {
		this.comments.remove(index);
	}


	@Override
	public String toString() {
		return "Recipe [recipeID=" + recipeID + ", servSize=" + servSize + ", difflvl=" + difflvl + ", rating=" + rating
				+ ", recipeTitle=" + recipeTitle + ", recipeDesc=" + recipeDesc + ", cuisineType=" + cuisineType
				+ ", prepTime=" + prepTime + ", cookTime=" + cookTime + ", totalTime=" + totalTime + ", authorId="
				+ authorId + ", nutritionInfo=" + nutritionInfo + ", ingredients=" + ingredients + ", prepSteps="
				+ prepSteps + ", comments=" + comments + "]";
	}
	
	

}
