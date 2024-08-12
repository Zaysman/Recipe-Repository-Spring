package com.isaiah.main.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaiah.main.objects.Recipe;
import com.isaiah.main.repositories.RecipeRepository;



@Service
public class RecipeService {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	
	public void createRecipe(Recipe recipe) {
		recipeRepository.save(recipe);
	}
	
	public Recipe readRecipeByRecipeID(int recipeID) {
		return recipeRepository.findByRecipeID(recipeID).orElse(null);
	}
	
	public Recipe updateRecipe(Recipe recipe) {
		return recipeRepository.save(recipe);
	}
	
	public void deleteByRecipeID(int recipeID) {
		recipeRepository.deleteByRecipeID(recipeID);		
	}
	
	public void delete(Recipe recipe) {
		recipeRepository.delete(recipe);
	}
	
	
	
}
