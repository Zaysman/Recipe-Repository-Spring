package com.isaiah.main.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.isaiah.main.objects.Ingredient;
import com.isaiah.main.objects.Recipe;
import com.isaiah.main.repositories.IngredientRepository;


@Service
public class IngredientService {

	@Autowired
	private IngredientRepository ingredientRepository;
	
	
	public void createIngredient(Ingredient ingredient) {
		ingredientRepository.save(ingredient);
	}
	
	public Ingredient readIngredientByIngredientID(int ingredientID) {
		return ingredientRepository.findByEntryID(ingredientID).orElse(null);
	}
	
	public List<Ingredient> readIngredientsByRecipeID(int recipeID) {
		return ingredientRepository.findIngredientsByRecipeID(recipeID);
	}
	
	public Ingredient updateIngredient(Ingredient ingredient) {
		return ingredientRepository.save(ingredient);
	}
	
	public void deleteIngredientByIngredientID(int ingredientID) {
		ingredientRepository.deleteByEntryID(ingredientID);
	}
	
	public void deleteIngredientsByRecipeID(int recipeID) {
		ingredientRepository.deleteByRecipeID(recipeID);
	}
	
	public void delete(Ingredient ingredient) {
		ingredientRepository.delete(ingredient);
	}
}
