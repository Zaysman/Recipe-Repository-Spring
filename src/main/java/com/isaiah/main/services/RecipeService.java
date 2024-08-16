package com.isaiah.main.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaiah.main.objects.Recipe;
import com.isaiah.main.repositories.RecipeRepository;

import jakarta.transaction.Transactional;



@Service
public class RecipeService {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	
	public Recipe createRecipe(Recipe recipe) {
		return recipeRepository.save(recipe);
	}
	
	public Recipe readRecipeByRecipeID(int recipeID) {
		return recipeRepository.findByRecipeID(recipeID).orElse(null);
	}
	
	public Recipe updateRecipe(Recipe recipe) {
		return recipeRepository.save(recipe);
	}
	
	@Transactional
	public void deleteByRecipeID(int recipeID) {
		recipeRepository.deleteByRecipeID(recipeID);		
	}
	
	@Transactional
	public void delete(Recipe recipe) {
		recipeRepository.delete(recipe);
	}
	
	
	
}
