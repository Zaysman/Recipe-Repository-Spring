package com.isaiah.main.restcontrollers;

import com.isaiah.main.objects.FavoritedRecipe;
import com.isaiah.main.services.FavoritedRecipeService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("favoritedrecipe")
public class FavoritedRecipeRestController {

	@Autowired
	private FavoritedRecipeService favoritedRecipeService;
	
	//Get favoritedRecipe by entryID
	@GetMapping(value = "/getfavoritedrecipe/{entryID}", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:3000")
	public FavoritedRecipe getFavoritedRecipe(@PathVariable int entryID) {
		return favoritedRecipeService.readFavoritedRecipeByEntryID(entryID);
	}
	
	//get favoritedRecipes by recipeID
	@GetMapping(value = "/getfavoritedrecipebyuserid/{userID}", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<FavoritedRecipe> getFavoritedRecipesByUserID(@PathVariable int userID) {
		return favoritedRecipeService.readRecipesByUserID(userID);
	}
	
	//Post create FavoritedRecipe
	@PostMapping(value = "/createfavoritedrecipe", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:3000")
	public FavoritedRecipe createFavoritedRecipe(@RequestBody FavoritedRecipe favoritedRecipe) {
		favoritedRecipeService.createFavoritedRecipe(favoritedRecipe);
		return favoritedRecipe;
	}
	
	//Put update favoritedRecipe
	@PutMapping(value = "/updatefavoritedrecipe/{entryID}", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:3000")
	public FavoritedRecipe updateFavoritedRecipe(@PathVariable int entryID, @RequestBody FavoritedRecipe favoritedRecipe) {
		FavoritedRecipe existingFavoriteRecipe = favoritedRecipeService.readFavoritedRecipeByEntryID(entryID);
		
		if(existingFavoriteRecipe != null) {
			existingFavoriteRecipe.setFavoritedRecipeID(favoritedRecipe.getFavoritedRecipeID());
			existingFavoriteRecipe.setUserID(favoritedRecipe.getUserID());
			
			return favoritedRecipeService.updateFavoritedRecipe(existingFavoriteRecipe);
		} else {
			return null;
		}
		
	}
	
	
	//Delete a favorited recipe by entryID
	@DeleteMapping(value = "/deletefavoritedrecipe/{entryID}")
	@CrossOrigin(origins = "http://localhost:3000")
	public void deleteFavoritedRecipe(@PathVariable int entryID) {
		favoritedRecipeService.deleteFavoritedRecipeByEntryID(entryID);
	}
	
	
}
