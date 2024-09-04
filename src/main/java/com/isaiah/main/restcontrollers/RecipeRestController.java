package com.isaiah.main.restcontrollers;

import com.isaiah.main.objects.Recipe;
import com.isaiah.main.services.RecipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("recipe")
public class RecipeRestController {

	
	@Autowired
	private RecipeService recipeService;
	
	//Get recipe by ID
	@GetMapping(value = "/getrecipe/{recipeID}", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:3000")
	public Recipe getRecipe(@PathVariable int recipeID) {
		return recipeService.readRecipeByRecipeID(recipeID);
	}
	
	//Get recipes by AuthorID
	@GetMapping(value = "/getrecipesbyauthorid/{authorID}")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Recipe> getRecipesByAuthorID(@PathVariable int authorID) {
		return recipeService.readRecipesByAuthorID(authorID);
	}
	
	//Get recipes by recipeIDs for the purpose of retrieving favorited recipes
	@GetMapping(value = "/getrecipesbyrecipeids", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Recipe> getRecipesByUserID(@RequestParam("favoritedRecipeIDs") List<Integer> recipeIDs) {
		return recipeService.readRecipesByRecipeIDs(recipeIDs);
	}
	
	
	//Post create recipe
	@PostMapping(value = "/createrecipe", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:3000")
	public Recipe createRecipe(@RequestBody Recipe recipe) {
		recipeService.createRecipe(recipe);
		return recipe;
	}
	
	//Put update recipe
	@PutMapping(value = "/updaterecipe/{recipeID}", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:3000")
	public Recipe updateRecipe(@PathVariable int recipeID, @RequestBody Recipe recipe) {
		Recipe existingRecipe = recipeService.readRecipeByRecipeID(recipeID);
		
		if(existingRecipe != null) {
			existingRecipe.setAuthorID(recipe.getAuthorID());
			existingRecipe.setComments(recipe.getComments());
			existingRecipe.setCookTime(recipe.getCookTime());
			existingRecipe.setCuisineType(recipe.getCuisineType());
			existingRecipe.setDifflvl(recipe.getDifflvl());
			existingRecipe.setIngredients(recipe.getIngredients());
			existingRecipe.setNutritionInfoID(recipe.getNutritionInfoID());
			existingRecipe.setPrepSteps(recipe.getPrepSteps());
			existingRecipe.setPrepTime(recipe.getPrepTime());
			existingRecipe.setRating(recipe.getRating());
			existingRecipe.setRecipeDesc(recipe.getRecipeDesc());
			existingRecipe.setRecipeTitle(recipe.getRecipeTitle());
			existingRecipe.setServSize(recipe.getServSize());
			existingRecipe.setTotalTime(recipe.getTotalTime());
			
			return recipeService.updateRecipe(existingRecipe);
		} else {
			
			return null;
		}
		
	}
	
	//Delete a recipe by recipeID
	@DeleteMapping(value = "/deleterecipe/{recipeID}")
	@CrossOrigin(origins = "http://localhost:3000")
	public void deleteRecipe(@PathVariable int recipeID) {
		recipeService.deleteByRecipeID(recipeID);
	}
	
	
	
}
