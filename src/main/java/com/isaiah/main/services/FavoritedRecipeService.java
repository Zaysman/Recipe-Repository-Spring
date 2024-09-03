package com.isaiah.main.services;

import com.isaiah.main.objects.FavoritedRecipe;
import com.isaiah.main.repositories.FavoritedRecipeRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.transaction.Transactional;


public class FavoritedRecipeService {

	@Autowired
	private FavoritedRecipeRepository favoritedRecipeRepository;
	
	public FavoritedRecipe createFavoritedRecipe(FavoritedRecipe favoritedRecipe) {
		return favoritedRecipeRepository.save(favoritedRecipe);
	} 
	
	public FavoritedRecipe readFavoritedRecipeByEntryID(int entryID) {
		return favoritedRecipeRepository.findByEntryID(entryID).orElse(null);
	}
	
	public List<FavoritedRecipe> readRecipesByUserID(int userID) {
		return favoritedRecipeRepository.findByUserID(userID);
	}
	
	public FavoritedRecipe updateFavoritedRecipe(FavoritedRecipe favoritedRecipe) {
		return favoritedRecipeRepository.save(favoritedRecipe);
		
	}
	
	@Transactional
	public void deleteFavoritedRecipeByEntryID(int entryID) {
		favoritedRecipeRepository.deleteByEntryID(entryID);		
	}
	
	@Transactional
	public void deleteFavoritedRecipe(FavoritedRecipe favoritedRecipe) {
		favoritedRecipeRepository.delete(favoritedRecipe);
	}
	
	
	
}
