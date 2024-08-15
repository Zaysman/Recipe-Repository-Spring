package com.isaiah.main.restcontrollers;

import com.isaiah.main.objects.Ingredient;
import com.isaiah.main.services.IngredientService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ingredient")
public class IngredientRestController {

	@Autowired
	private IngredientService ingredientService;


	//Get ingredient by entryID
	@GetMapping(value = "/getingredientbyentryid/{entryID}", produces = "application/json")
	public Ingredient getIngredient(@PathVariable int entryID) {
		return ingredientService.readIngredientByEntryID(entryID);
	}

	//Get ingredients by recipeID
	@GetMapping(value = "/getingredientbyrecipeid/{recipeID}", produces = "application/json")
	public List<Ingredient> getIngredients(@PathVariable int recipeID) {
		return ingredientService.readIngredientsByRecipeID(recipeID);
	}


	//Post create a new ingredient
	@PostMapping(value = "/createingredient")
	public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
		ingredientService.createIngredient(ingredient);
		return ingredient;
	}

	//Put update ingredient
	@PutMapping(value = "/updateingredient/{entryID}", consumes = "application/json", produces = "application/json")
	public Ingredient updateIngredient(@PathVariable int entryID, @RequestBody Ingredient ingredient) {
		Ingredient existingIngredient = ingredientService.readIngredientByEntryID(entryID);

		if(existingIngredient != null) {
			existingIngredient.setName(ingredient.getName());
			existingIngredient.setQuantity(ingredient.getQuantity());
			existingIngredient.setRecipeID(ingredient.getRecipeID());
			existingIngredient.setUnit(ingredient.getUnit());
			ingredientService.updateIngredient(existingIngredient);
			return existingIngredient;
		} else {
			//Handle ingredient not found
			return null;
		}	

	}

	//Delete an ingredient by entryID
	@DeleteMapping(value = "/deleteingredient/{entryID}")
	public void deleteIngredient(@PathVariable int entryID) {
		ingredientService.deleteIngredientByEntryID(entryID);
	}


}
